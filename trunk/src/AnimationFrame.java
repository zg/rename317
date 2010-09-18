// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class AnimationFrame
{

    public static void method528(int i)
    {
        aAnimationFrameArray635 = new AnimationFrame[i + 1];
        aBooleanArray643 = new boolean[i + 1];
        for(int j = 0; j < i + 1; j++)
            aBooleanArray643[j] = true;

    }

    public static void method529(byte abyte0[])
    {
        Packet stream = new Packet(abyte0);
        stream.pos = abyte0.length - 8;
        int i = stream.g2();
        int j = stream.g2();
        int k = stream.g2();
        int l = stream.g2();
        int i1 = 0;
        Packet stream_1 = new Packet(abyte0);
        stream_1.pos = i1;
        i1 += i + 2;
        Packet stream_2 = new Packet(abyte0);
        stream_2.pos = i1;
        i1 += j;
        Packet stream_3 = new Packet(abyte0);
        stream_3.pos = i1;
        i1 += k;
        Packet stream_4 = new Packet(abyte0);
        stream_4.pos = i1;
        i1 += l;
        Packet stream_5 = new Packet(abyte0);
        stream_5.pos = i1;
        ModelTransform modelTransform = new ModelTransform(stream_5);
        int k1 = stream_1.g2();
        int ai[] = new int[500];
        int ai1[] = new int[500];
        int ai2[] = new int[500];
        int ai3[] = new int[500];
        for(int l1 = 0; l1 < k1; l1++)
        {
            int i2 = stream_1.g2();
            AnimationFrame animationFrame = aAnimationFrameArray635[i2] = new AnimationFrame();
            animationFrame.displayLength = stream_4.g1();
            animationFrame.myModelTransform = modelTransform;
            int j2 = stream_1.g1();
            int k2 = -1;
            int l2 = 0;
            for(int i3 = 0; i3 < j2; i3++)
            {
                int j3 = stream_2.g1();
                if(j3 > 0)
                {
                    if(modelTransform.opcodes[i3] != 0)
                    {
                        for(int l3 = i3 - 1; l3 > k2; l3--)
                        {
                            if(modelTransform.opcodes[l3] != 0)
                                continue;
                            ai[l2] = l3;
                            ai1[l2] = 0;
                            ai2[l2] = 0;
                            ai3[l2] = 0;
                            l2++;
                            break;
                        }

                    }
                    ai[l2] = i3;
                    char c = '\0';
                    if(modelTransform.opcodes[i3] == 3)
                        c = '\200';
                    if((j3 & 1) != 0)
                        ai1[l2] = stream_3.gsmart();
                    else
                        ai1[l2] = c;
                    if((j3 & 2) != 0)
                        ai2[l2] = stream_3.gsmart();
                    else
                        ai2[l2] = c;
                    if((j3 & 4) != 0)
                        ai3[l2] = stream_3.gsmart();
                    else
                        ai3[l2] = c;
                    k2 = i3;
                    l2++;
                    if(modelTransform.opcodes[i3] == 5)
                        aBooleanArray643[i2] = false;
                }
            }

            animationFrame.anInt638 = l2;
            animationFrame.opcodeLinkTable = new int[l2];
            animationFrame.modifier1 = new int[l2];
            animationFrame.modifier2 = new int[l2];
            animationFrame.modifier3 = new int[l2];
            for(int k3 = 0; k3 < l2; k3++)
            {
                animationFrame.opcodeLinkTable[k3] = ai[k3];
                animationFrame.modifier1[k3] = ai1[k3];
                animationFrame.modifier2[k3] = ai2[k3];
                animationFrame.modifier3[k3] = ai3[k3];
            }

        }

    }

    public static void nullLoader()
    {
        aAnimationFrameArray635 = null;
    }

    public static AnimationFrame forID(int j)
    {
        if(aAnimationFrameArray635 == null)
            return null;
        else
            return aAnimationFrameArray635[j];
    }

    public static boolean method532(int i)
    {
        return i == -1;
    }

    private AnimationFrame()
    {
    }

    private static AnimationFrame[] aAnimationFrameArray635;
    public int displayLength;
    public ModelTransform myModelTransform;
    public int anInt638;
    public int opcodeLinkTable[];
    public int modifier1[];
    public int modifier2[];
    public int modifier3[];
    private static boolean[] aBooleanArray643;

}
