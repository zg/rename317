// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class ModelTransform
{

    public ModelTransform(Packet stream)
    {
/*
        int length = stream.g1();
        opcodes = new int[length];
        skinList = new int[length][];
        for(int stepId = 0; stepId < length; stepId++)
            opcodes[stepId] = stream.g1();

        for(int stepId = 0; stepId < length; stepId++)
        {
            int stepSkinIdLength = stream.g1();
            skinList[stepId] = new int[stepSkinIdLength];
            for(int skinIDX = 0; skinIDX < stepSkinIdLength; skinIDX++)
                skinList[stepId][skinIDX] = stream.g1();

        }

*/

int length = stream.g2();
opcodes = new int[length];
skinList = new int[length][];
for(int j = 0; j < length; j++)
opcodes[j] = stream.g2();

for(int j = 0; j < length; j++)
skinList[j] = new int[stream.g2()];

for(int j = 0; j < length; j++)
for(int l = 0; l < skinList[j].length; l++)
skinList[j][l] = stream.g2();

    }

    public final int[] opcodes;
    public final int[][] skinList;
}
