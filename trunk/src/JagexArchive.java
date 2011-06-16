// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

final class JagexArchive {

    public JagexArchive(byte in[])
    {
               Packet stream = new Packet(in);
        int resultLength = stream.g3();
        int rawLength = stream.g3();
        if(rawLength != resultLength)
        {
            byte out[] = new byte[resultLength];
            BZIP2Decompressor.decompressBuffer(out, resultLength, in, rawLength, 6);
            outputData = out;
            stream = new Packet(outputData);
            isCompressed = true;
        } else
        {
            outputData = in;
            isCompressed = false;
        }
        dataSize = stream.g2();
        myNameIndexes = new int[dataSize];
        myFileSizes = new int[dataSize];
        myOnDiskFileSizes = new int[dataSize];
        myFileOffsets = new int[dataSize];
        int k = stream.pos + dataSize * 10;
        for(int l = 0; l < dataSize; l++)
        {
            myNameIndexes[l] = stream.g4();
            myFileSizes[l] = stream.g3();
            myOnDiskFileSizes[l] = stream.g3();
            myFileOffsets[l] = k;
            k += myOnDiskFileSizes[l];
        }
    }

    public byte[] getDataForName(String s)//TODO abyte0 is always null =.= fix it up
    {
        byte abyte0[] = null; //was a parameter
        int i = 0;
        s = s.toUpperCase();
        for(int j = 0; j < s.length(); j++)
            i = (i * 61 + s.charAt(j)) - 32;

        for(int k = 0; k < dataSize; k++)
            if(myNameIndexes[k] == i)
            {
                if(abyte0 == null)
                    abyte0 = new byte[myFileSizes[k]];
                if(!isCompressed)
                {
                    BZIP2Decompressor.decompressBuffer(abyte0, myFileSizes[k], outputData, myOnDiskFileSizes[k], myFileOffsets[k]);
                } else
                {
                    System.arraycopy(outputData, myFileOffsets[k], abyte0, 0, myFileSizes[k]);

                }
                return abyte0;
            }

        return null;
    }

    private final byte[] outputData;
    private final int dataSize;
    private final int[] myNameIndexes;
    private final int[] myFileSizes;
    private final int[] myOnDiskFileSizes;
    private final int[] myFileOffsets;
    private final boolean isCompressed;
}
