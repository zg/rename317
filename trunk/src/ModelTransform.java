// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class ModelTransform
{

    public ModelTransform(Stream stream)
    {
        int length = stream.readUnsignedByte();
        opcodes = new int[length];
        skinList = new int[length][];
        for(int stepId = 0; stepId < length; stepId++)
            opcodes[stepId] = stream.readUnsignedByte();

        for(int stepId = 0; stepId < length; stepId++)
        {
            int stepSkinIdLength = stream.readUnsignedByte();
            skinList[stepId] = new int[stepSkinIdLength];
            for(int skinIDX = 0; skinIDX < stepSkinIdLength; skinIDX++)
                skinList[stepId][skinIDX] = stream.readUnsignedByte();

        }

    }

    public final int[] opcodes;
    public final int[][] skinList;
}
