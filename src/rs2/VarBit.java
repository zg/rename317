package rs2;

public class VarBit {

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

        }

        if(stream.pos != stream.data.length)
            System.out.println("varbit load mismatch");
    }

    private void readValues(Packet stream)
    {
        do
        {
            int opCode = stream.g1();
            if(opCode == 0)
                return;
            if(opCode == 1)
            {
                variable = stream.g2();
                leastSignificantBit = stream.g1();
                mostSignificantBit = stream.g1();
            } else
            if(opCode == 10)
                stream.gstr();
            else
            if(opCode == 2)
                {}
            else
            if(opCode == 3)
                stream.g4();
            else
            if(opCode == 4)
                stream.g4();
            else
                System.out.println("Error unrecognised config code: " + opCode);
        } while(true);
    }

    private VarBit()
    {
    }

    public static VarBit cache[];
    public int variable;
    public int leastSignificantBit;
    public int mostSignificantBit;
}
