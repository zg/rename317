// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

final class JagexArchive {

    public JagexArchive(byte in[])
    {
               Stream stream = new Stream(in);
        int resultLength = stream.read3Bytes();
        int rawLength = stream.read3Bytes();
        if(rawLength != resultLength)
        {
            byte out[] = new byte[resultLength];
            BZIP2Decompressor.decompress(out, resultLength, in, rawLength, 6);
            outputData = out;
            stream = new Stream(outputData);
            isCompressed = true;
        } else
        {
            outputData = in;
            isCompressed = false;
        }
        dataSize = stream.readUnsignedWord();
        myNameIndexes = new int[dataSize];
        myFileSizes = new int[dataSize];
        myOnDiskFileSizes = new int[dataSize];
        myFileOffsets = new int[dataSize];
        int k = stream.currentOffset + dataSize * 10;
        for(int l = 0; l < dataSize; l++)
        {
            myNameIndexes[l] = stream.readDWord();
            myFileSizes[l] = stream.read3Bytes();
            myOnDiskFileSizes[l] = stream.read3Bytes();
            myFileOffsets[l] = k;
            k += myOnDiskFileSizes[l];
        }
    }

    public byte[] getDataForName(String s)
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
                    BZIP2Decompressor.decompress(abyte0, myFileSizes[k], outputData, myOnDiskFileSizes[k], myFileOffsets[k]);
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
