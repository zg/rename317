package rs2;


public class SoundTrack
{

    public static void initialise()
    {
        noise = new int[32768];
        for(int i = 0; i < 32768; i++)
            if(Math.random() > 0.5D)
                noise[i] = 1;
            else
                noise[i] = -1;

        sineTable = new int[32768];
        for(int j = 0; j < 32768; j++)
            sineTable[j] = (int)(Math.sin((double)j / 5215.1903000000002D) * 16384D);

        sampleBuffer = new int[0x35d54];
    }

    public int[] buildSoundData(int sampleLength, int j)
    {
        for(int k = 0; k < sampleLength; k++)
            sampleBuffer[k] = 0;

        if(j < 10)
            return sampleBuffer;
        double d = (double)sampleLength / ((double)j + 0.0D);
        samp1.resetValues();
        samp2.resetValues();
        int l = 0;
        int i1 = 0;
        int phase = 0;
        if(samp3 != null)
        {
            samp3.resetValues();
            samp4.resetValues();
            l = (int)(((double)(samp3.anInt539 - samp3.anInt538) * 32.768000000000001D) / d);
            i1 = (int)(((double) samp3.anInt538 * 32.768000000000001D) / d);
        }
        int k1 = 0;
        int l1 = 0;
        int phase2 = 0;
        if(samp5 != null)
        {
            samp5.resetValues();
            samp6.resetValues();
            k1 = (int)(((double)(samp5.anInt539 - samp5.anInt538) * 32.768000000000001D) / d);
            l1 = (int)(((double) samp5.anInt538 * 32.768000000000001D) / d);
        }
        for(int j2 = 0; j2 < 5; j2++)
            if(anIntArray106[j2] != 0)
            {
                SoundTrack.phase[j2] = 0;
                anIntArray119[j2] = (int)((double)anIntArray108[j2] * d);
                anIntArray120[j2] = (anIntArray106[j2] << 14) / 100;
                anIntArray121[j2] = (int)(((double)(samp1.anInt539 - samp1.anInt538) * 32.768000000000001D * Math.pow(1.0057929410678534D, anIntArray107[j2])) / d);
                anIntArray122[j2] = (int)(((double) samp1.anInt538 * 32.768000000000001D) / d);
            }

        for(int k2 = 0; k2 < sampleLength; k2++)
        {
            int l2 = samp1.readEnvelope(sampleLength);
            int j4 = samp2.readEnvelope(sampleLength);
            if(samp3 != null)
            {
                int j5 = samp3.readEnvelope(sampleLength);
                int vol = samp4.readEnvelope(sampleLength);
                l2 += getValue(vol, phase, samp3.anInt540) >> 1;
                phase += (j5 * l >> 16) + i1;
            }
            if(samp5 != null)
            {
                int k5 = samp5.readEnvelope(sampleLength);
                int vol = samp6.readEnvelope(sampleLength);
                j4 = j4 * ((getValue(vol, phase2, samp5.anInt540) >> 1) + 32768) >> 15;
                phase2 += (k5 * k1 >> 16) + l1;
            }
            for(int l5 = 0; l5 < 5; l5++)
                if(anIntArray106[l5] != 0)
                {
                    int l6 = k2 + anIntArray119[l5];
                    if(l6 < sampleLength)
                    {
                        sampleBuffer[l6] += getValue(j4 * anIntArray120[l5] >> 15, SoundTrack.phase[l5], samp1.anInt540);
                        SoundTrack.phase[l5] += (l2 * anIntArray121[l5] >> 16) + anIntArray122[l5];
                    }
                }

        }

        if(aClass29_104 != null)
        {
            aClass29_104.resetValues();
            aClass29_105.resetValues();
            int i3 = 0;
            //boolean flag = false;//never used
            boolean flag1 = true;
            for(int i7 = 0; i7 < sampleLength; i7++)
            {
                int k7 = aClass29_104.readEnvelope(sampleLength);
                int i8 = aClass29_105.readEnvelope(sampleLength);
                int k4;
                if(flag1)
                    k4 = aClass29_104.anInt538 + ((aClass29_104.anInt539 - aClass29_104.anInt538) * k7 >> 8);
                else
                    k4 = aClass29_104.anInt538 + ((aClass29_104.anInt539 - aClass29_104.anInt538) * i8 >> 8);
                if((i3 += 256) >= k4)
                {
                    i3 = 0;
                    flag1 = !flag1;
                }
                if(flag1)
                    sampleBuffer[i7] = 0;
            }

        }
        if(anInt109 > 0 && gain > 0)
        {
            int j3 = (int)((double)anInt109 * d);
            for(int l4 = j3; l4 < sampleLength; l4++)
                sampleBuffer[l4] += (sampleBuffer[l4 - j3] * gain) / 100;

        }
        if(aClass39_111.anIntArray665[0] > 0 || aClass39_111.anIntArray665[1] > 0)
        {
            aClass29_112.resetValues();
            int k3 = aClass29_112.readEnvelope(sampleLength + 1);
            int i5 = aClass39_111.method544(0, (float)k3 / 65536F);
            int i6 = aClass39_111.method544(1, (float)k3 / 65536F);
            if(sampleLength >= i5 + i6)
            {
                int j7 = 0;
                int l7 = i6;
                if(l7 > sampleLength - i5)
                    l7 = sampleLength - i5;
                for(; j7 < l7; j7++)
                {
                    int j8 = (int)((long) sampleBuffer[j7 + i5] * (long)Class39.anInt672 >> 16);
                    for(int k8 = 0; k8 < i5; k8++)
                        j8 += (int)((long) sampleBuffer[(j7 + i5) - 1 - k8] * (long)Class39.anIntArrayArray670[0][k8] >> 16);

                    for(int j9 = 0; j9 < j7; j9++)
                        j8 -= (int)((long) sampleBuffer[j7 - 1 - j9] * (long)Class39.anIntArrayArray670[1][j9] >> 16);

                    sampleBuffer[j7] = j8;
                    k3 = aClass29_112.readEnvelope(sampleLength + 1);
                }

                char c = '\200';
                l7 = c;
                do
                {
                    if(l7 > sampleLength - i5)
                        l7 = sampleLength - i5;
                    for(; j7 < l7; j7++)
                    {
                        int l8 = (int)((long) sampleBuffer[j7 + i5] * (long)Class39.anInt672 >> 16);
                        for(int k9 = 0; k9 < i5; k9++)
                            l8 += (int)((long) sampleBuffer[(j7 + i5) - 1 - k9] * (long)Class39.anIntArrayArray670[0][k9] >> 16);

                        for(int i10 = 0; i10 < i6; i10++)
                            l8 -= (int)((long) sampleBuffer[j7 - 1 - i10] * (long)Class39.anIntArrayArray670[1][i10] >> 16);

                        sampleBuffer[j7] = l8;
                        k3 = aClass29_112.readEnvelope(sampleLength + 1);
                    }

                    if(j7 >= sampleLength - i5)
                        break;
                    i5 = aClass39_111.method544(0, (float)k3 / 65536F);
                    i6 = aClass39_111.method544(1, (float)k3 / 65536F);
                    l7 += c;
                } while(true);
                for(; j7 < sampleLength; j7++)
                {
                    int i9 = 0;
                    for(int l9 = (j7 + i5) - sampleLength; l9 < i5; l9++)
                        i9 += (int)((long) sampleBuffer[(j7 + i5) - 1 - l9] * (long)Class39.anIntArrayArray670[0][l9] >> 16);

                    for(int j10 = 0; j10 < i6; j10++)
                        i9 -= (int)((long) sampleBuffer[j7 - 1 - j10] * (long)Class39.anIntArrayArray670[1][j10] >> 16);

                    sampleBuffer[j7] = i9;
                    //int l3 = aClass29_112.readEnvelope(sampleLength + 1);//never used
                }

            }
        }
        for(int i4 = 0; i4 < sampleLength; i4++)
        {
            if(sampleBuffer[i4] < -32768)
                sampleBuffer[i4] = -32768;
            if(sampleBuffer[i4] > 32767)
                sampleBuffer[i4] = 32767;
        }

        return sampleBuffer;
    }

    private int getValue(int vol, int phase, int envelopeType)
    {
        if(envelopeType == 1) //square
            if((phase & 0x7fff) < 16384)
                return vol;
            else
                return -vol;
        if(envelopeType == 2)   //sine
            return sineTable[phase & 0x7fff] * vol >> 14;
        if(envelopeType == 3)            //saw
            return ((phase & 0x7fff) * vol >> 14) - vol;
        if(envelopeType == 4) //Random
            return noise[phase / 2607 & 0x7fff] * vol;
        else
            return 0;
    }

    public void unpack(Packet stream)
    {
        samp1 = new Class29();
        samp1.method325(stream);
        samp2 = new Class29();
        samp2.method325(stream);
        int i = stream.g1();
        if(i != 0)
        {
            stream.pos--;
            samp3 = new Class29();
            samp3.method325(stream);
            samp4 = new Class29();
            samp4.method325(stream);
        }
        i = stream.g1();
        if(i != 0)
        {
            stream.pos--;
            samp5 = new Class29();
            samp5.method325(stream);
            samp6 = new Class29();
            samp6.method325(stream);
        }
        i = stream.g1();
        if(i != 0)
        {
            stream.pos--;
            aClass29_104 = new Class29();
            aClass29_104.method325(stream);
            aClass29_105 = new Class29();
            aClass29_105.method325(stream);
        }
        for(int j = 0; j < 10; j++)
        {
            int k = stream.gsmarts();
            if(k == 0)
                break;
            anIntArray106[j] = k;
            anIntArray107[j] = stream.gsmart();
            anIntArray108[j] = stream.gsmarts();
        }

        anInt109 = stream.gsmarts();
        gain = stream.gsmarts();
        msLength = stream.g2();
        anInt114 = stream.g2();
        aClass39_111 = new Class39();
        aClass29_112 = new Class29();
        aClass39_111.method545(stream, aClass29_112);
    }

    public SoundTrack()
    {
        anIntArray106 = new int[5];
        anIntArray107 = new int[5];
        anIntArray108 = new int[5];
        gain = 100;
        msLength = 500;
    }

    private Class29 samp1;
    private Class29 samp2;
    private Class29 samp3;
    private Class29 samp4;
    private Class29 samp5;
    private Class29 samp6;
    private Class29 aClass29_104;
    private Class29 aClass29_105;
    private final int[] anIntArray106;
    private final int[] anIntArray107;
    private final int[] anIntArray108;
    private int anInt109;
    private int gain;
    private Class39 aClass39_111;
    private Class29 aClass29_112;
    int msLength;
    int anInt114;
    private static int[] sampleBuffer;
    private static int[] noise;
    private static int[] sineTable;
    private static final int[] phase = new int[5];
    private static final int[] anIntArray119 = new int[5];
    private static final int[] anIntArray120 = new int[5];
    private static final int[] anIntArray121 = new int[5];
    private static final int[] anIntArray122 = new int[5];

}
