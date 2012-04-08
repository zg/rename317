package rs2;


public class Track {

    private Track()
    {
        samples = new Sample[10];
    }

    public static void unpack(Packet data)
    {
        output = new byte[0x6baa8];
        riff_data = new Packet(output);
        Sample.initialise();
        do
        {
            int j = data.g2();
            if(j == 65535)
                return;
            TRACKS[j] = new Track();
            TRACKS[j].decode(data);
            anIntArray326[j] = TRACKS[j].method243();
        } while(true);
    }

    public static Packet data(int volume, int id)
    {
        if(TRACKS[id] != null)
        {
            Track sound = TRACKS[id];
            return sound.pack(volume);
        } else
        {
            return null;
        }
    }

    private void decode(Packet stream)
    {
        for(int i = 0; i < 10; i++)
        {
            int j = stream.g1();
            if(j != 0)
            {
                stream.pos--;
                samples[i] = new Sample();
                samples[i].decode(stream);
            }
        }
        anInt330 = stream.g2();
        anInt331 = stream.g2();
    }

    private int method243()
    {
        int j = 0x98967f;
        for(int k = 0; k < 10; k++)
            if(samples[k] != null && samples[k].remaining / 20 < j)
                j = samples[k].remaining / 20;

        if(anInt330 < anInt331 && anInt330 / 20 < j)
            j = anInt330 / 20;
        if(j == 0x98967f || j == 0)
            return 0;
        for(int l = 0; l < 10; l++)
            if(samples[l] != null)
                samples[l].remaining -= j * 20;

        if(anInt330 < anInt331)
        {
            anInt330 -= j * 20;
            anInt331 -= j * 20;
        }
        return j;
    }

    private Packet pack(int volume)
    {//http://soundfile.sapp.org/doc/WaveFormat/
        int SubChunk2Size = encode(volume);
        riff_data.pos = 0;
        riff_data.p4(0x52494646);//RIFF
        riff_data.ip4(36 + SubChunk2Size);//36 + SubChunk2Size, or more precisely: 4+(8+SubChunk1Size)+(8+SubChunk2Size)
        riff_data.p4(0x57415645);//Wave in big-endian

        riff_data.p4(0x666d7420);//FMT - SubChunk1ID
        riff_data.ip4(16);//PCM Header size
        riff_data.ip2(1);//PCM Linear quantization
        riff_data.ip2(1);//MONO
        riff_data.ip4(22050);//SampleRate
        riff_data.ip4(22050);//ByteRate
        riff_data.ip2(1);//BlockAlign
        riff_data.ip2(8);//bitsPerSample

        riff_data.p4(0x64617461);//data
        riff_data.ip4(SubChunk2Size);
        riff_data.pos += SubChunk2Size;
        return riff_data;
    }

    private int encode(int volume)//getSubChunk2Size - packs the pcm
    {
        int j = 0;
        for(int k = 0; k < 10; k++)
            if(samples[k] != null && samples[k].offset + samples[k].remaining > j)
                j = samples[k].offset + samples[k].remaining;

        if(j == 0)
            return 0;
        int l = (22050 * j) / 1000;
        int i1 = (22050 * anInt330) / 1000;
        int j1 = (22050 * anInt331) / 1000;
        if(i1 < 0 || i1 > l || j1 < 0 || j1 > l || i1 >= j1)
            volume = 0;
        int k1 = l + (j1 - i1) * (volume - 1);
        for(int l1 = 44; l1 < k1 + 44; l1++)
            output[l1] = -128;

        for(int i2 = 0; i2 < 10; i2++)
            if(samples[i2] != null)
            {
                int j2 = (samples[i2].offset * 22050) / 1000;
                int i3 = (samples[i2].remaining * 22050) / 1000;
                int sampleData[] = samples[i2].synthesize(j2, samples[i2].offset);
                for(int l3 = 0; l3 < j2; l3++)
                    output[l3 + i3 + 44] += (byte)(sampleData[l3] >> 8);
//44 is the data byte offset Type_WAV_PCM
//http://soundfile.sapp.org/src/SoundHeader.cpp
            }

        if(volume > 1)
        {
            i1 += 44;
            j1 += 44;
            l += 44;
            int k2 = (k1 += 44) - l;
            for(int j3 = l - 1; j3 >= j1; j3--)
                output[j3 + k2] = output[j3];

            for(int k3 = 1; k3 < volume; k3++)
            {
                int l2 = (j1 - i1) * k3;
                System.arraycopy(output, i1, output, i1 + l2, j1 - i1);

            }

            k1 -= 44;
        }
        return k1;
    }

    private static final Track[] TRACKS = new Track[5000];
    public static final int[] anIntArray326 = new int[5000];
    private static byte[] output;
    private static Packet riff_data;
    private final Sample[] samples;
    private int anInt330;
    private int anInt331;

}
