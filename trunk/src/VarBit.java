// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class VarBit {

    public static void unpackConfig(JagexArchive jagexArchive)
    {
        Stream stream = new Stream(jagexArchive.getDataForName("varbit.dat"));
        int cacheSize = stream.readUnsignedWord();
        if(cache == null)
            cache = new VarBit[cacheSize];
        for(int j = 0; j < cacheSize; j++)
        {
            if(cache[j] == null)
                cache[j] = new VarBit();
            cache[j].readValues(stream);
            if(cache[j].aBoolean651)
                SettingUsagePointers.cache[cache[j].configId].aBoolean713 = true;
        }

        if(stream.currentOffset != stream.buffer.length)
            System.out.println("varbit load mismatch");
    }

    private void readValues(Stream stream)
    {
        do
        {
            int j = stream.readUnsignedByte();
            if(j == 0)
                return;
            if(j == 1)
            {
                configId = stream.readUnsignedWord();
                least_significant_bit = stream.readUnsignedByte();
                most_significant_bit = stream.readUnsignedByte();
            } else
            if(j == 10)
                stream.readString();
            else
            if(j == 2)
                aBoolean651 = true;
            else
            if(j == 3)
                stream.readDWord();
            else
            if(j == 4)
                stream.readDWord();
            else
                System.out.println("Error unrecognised config code: " + j);
        } while(true);
    }

    private VarBit()
    {
        aBoolean651 = false;
    }

    public static VarBit cache[];
    public int configId;
    public int least_significant_bit;
    public int most_significant_bit;
    private boolean aBoolean651;
}
