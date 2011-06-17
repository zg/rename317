package rs2;
final class Sounds {

	private Sounds() {
		aSoundTrackArray329 = new SoundTrack[10];
	}

	public static void unpack(Packet stream) {
		waveGenerationBuffer = new byte[0x6baa8];
		waveGenerationStream = new Packet(waveGenerationBuffer);
		SoundTrack.initialise();
		do {
			int j = stream.g2();
			if (j == 65535)
				return;
			sound_gererator_list[j] = new Sounds();
			sound_gererator_list[j].load(stream);
			anIntArray326[j] = sound_gererator_list[j].method243();
		} while (true);
	}

	public static Packet generateWaveData(int i, int j) {
		if (sound_gererator_list[j] != null) {
			Sounds sounds = sound_gererator_list[j];
			return sounds.writeWaveHeader(i);
		} else {
			return null;
		}
	}

	private void load(Packet stream) {
		for (int i = 0; i < 10; i++) {
			int j = stream.g1();
			if (j != 0) {
				stream.pos--;
				aSoundTrackArray329[i] = new SoundTrack();
				aSoundTrackArray329[i].unpack(stream);
			}
		}
		anInt330 = stream.g2();
		anInt331 = stream.g2();
	}

	private int method243() {
		int j = 0x98967f;
		for (int k = 0; k < 10; k++)
			if (aSoundTrackArray329[k] != null && aSoundTrackArray329[k].anInt114 / 20 < j)
				j = aSoundTrackArray329[k].anInt114 / 20;
		if (anInt330 < anInt331 && anInt330 / 20 < j)
			j = anInt330 / 20;
		if (j == 0x98967f || j == 0)
			return 0;
		for (int l = 0; l < 10; l++)
			if (aSoundTrackArray329[l] != null)
				aSoundTrackArray329[l].anInt114 -= j * 20;
		if (anInt330 < anInt331) {
			anInt330 -= j * 20;
			anInt331 -= j * 20;
		}
		return j;
	}

	private Packet writeWaveHeader(int i) {// http://soundfile.sapp.org/doc/WaveFormat/
		int SubChunk2Size = method245(i);
		waveGenerationStream.pos = 0;
		waveGenerationStream.p4(0x52494646);// RIFF
		waveGenerationStream.ip4(36 + SubChunk2Size);// 36 + SubChunk2Size, or more precisely: 4+(8+SubChunk1Size)+(8+SubChunk2Size)
		waveGenerationStream.p4(0x57415645);// Wave in big-endian
		waveGenerationStream.p4(0x666d7420);// FMT - SubChunk1ID
		waveGenerationStream.ip4(16);// PCM Header size
		waveGenerationStream.ip2(1);// PCM Linear quantization
		waveGenerationStream.ip2(1);// MONO
		waveGenerationStream.ip4(22050);// SampleRate
		waveGenerationStream.ip4(22050);// ByteRate
		waveGenerationStream.ip2(1);// BlockAlign
		waveGenerationStream.ip2(8);// bitsPerSample
		waveGenerationStream.p4(0x64617461);// data
		waveGenerationStream.ip4(SubChunk2Size);
		waveGenerationStream.pos += SubChunk2Size;
		return waveGenerationStream;
	}

	private int method245(int i)// getSubChunk2Size
	{
		int j = 0;
		for (int k = 0; k < 10; k++)
			if (aSoundTrackArray329[k] != null && aSoundTrackArray329[k].msLength + aSoundTrackArray329[k].anInt114 > j)
				j = aSoundTrackArray329[k].msLength + aSoundTrackArray329[k].anInt114;
		if (j == 0)
			return 0;
		int l = (22050 * j) / 1000;
		int i1 = (22050 * anInt330) / 1000;
		int j1 = (22050 * anInt331) / 1000;
		if (i1 < 0 || i1 > l || j1 < 0 || j1 > l || i1 >= j1)
			i = 0;
		int k1 = l + (j1 - i1) * (i - 1);
		for (int l1 = 44; l1 < k1 + 44; l1++)
			waveGenerationBuffer[l1] = -128;
		for (int i2 = 0; i2 < 10; i2++)
			if (aSoundTrackArray329[i2] != null) {
				int j2 = (aSoundTrackArray329[i2].msLength * 22050) / 1000;
				int i3 = (aSoundTrackArray329[i2].anInt114 * 22050) / 1000;
				int ai[] = aSoundTrackArray329[i2].buildSoundData(j2, aSoundTrackArray329[i2].msLength);
				for (int l3 = 0; l3 < j2; l3++)
					waveGenerationBuffer[l3 + i3 + 44] += (byte) (ai[l3] >> 8);
				// 44 is the data byte offset Type_WAV_PCM
				// http://soundfile.sapp.org/src/SoundHeader.cpp
			}
		if (i > 1) {
			i1 += 44;
			j1 += 44;
			l += 44;
			int k2 = (k1 += 44) - l;
			for (int j3 = l - 1; j3 >= j1; j3--)
				waveGenerationBuffer[j3 + k2] = waveGenerationBuffer[j3];
			for (int k3 = 1; k3 < i; k3++) {
				int l2 = (j1 - i1) * k3;
				System.arraycopy(waveGenerationBuffer, i1, waveGenerationBuffer, i1 + l2, j1 - i1);
			}
			k1 -= 44;
		}
		return k1;
	}
	private static final Sounds[] sound_gererator_list = new Sounds[5000];
	public static final int[] anIntArray326 = new int[5000];
	private static byte[] waveGenerationBuffer;
	private static Packet waveGenerationStream;
	private final SoundTrack[] aSoundTrackArray329;
	private int anInt330;
	private int anInt331;
}
