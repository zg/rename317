// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class VarBit {

    public static void unpackConfig(JagexArchive jagexArchive)
    {
        Packet stream = new Packet(jagexArchive.getDataForName("varbit.dat"));
        int cacheSize = stream.g2();
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

        if(stream.pos != stream.data.length)
            System.out.println("varbit load mismatch");
    }

    private void readValues(Packet stream)
    {
        do
        {
            int j = stream.g1();
            if(j == 0)
                return;
            if(j == 1)
            {
                configId = stream.g2();
                least_significant_bit = stream.g1();
                most_significant_bit = stream.g1();
            } else
            if(j == 10)
                stream.gstr();
            else
            if(j == 2)
                aBoolean651 = true;
            else
            if(j == 3)
                stream.g4();
            else
            if(j == 4)
                stream.g4();
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
