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
                leastSignificantBit = stream.g1();
                mostSignificantBit = stream.g1();
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
    public int leastSignificantBit;
    public int mostSignificantBit;
    private boolean aBoolean651;
}
