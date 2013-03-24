package rs2;


import rs2.util.collection.MemCache;

public class SpotAnim {

    public static void unpackConfig(JagexArchive jagexArchive)
    {//spotanim restored to 317
        rs2.Packet stream = new rs2.Packet(jagexArchive.getDataForName("spotanim.dat"));
        int length = stream.g2();
        if(cache == null)
            cache = new SpotAnim[length];
        for(int j = 0; j < length; j++)
        {
            if(cache[j] == null)
                cache[j] = new SpotAnim();
            cache[j].id = j;
            cache[j].readValues(stream);
        }

    }

    private void readValues(rs2.Packet stream)
    {
        do
        {
            int opCode = stream.g1();
            if(opCode == 0)
                return;
            if(opCode == 1)
                modelID = stream.g2();
            else
            if(opCode == 2)
            {
                animationID = stream.g2();
                if(rs2.Sequence.anims != null)
                    animationSequence = rs2.Sequence.anims[animationID];
            } else
            if(opCode == 4)
                resizeXY = stream.g2();
            else
            if(opCode == 5)
                resizeZ = stream.g2();
            else
            if(opCode == 6)
                rotation = stream.g2();
            else
            if(opCode == 7)
                modelBrightness = stream.g1();
            else
            if(opCode == 8)
                modelShadow = stream.g1();
            else
            if(opCode >= 40 && opCode < 50)
                originalModelColours[opCode - 40] = stream.g2();
            else
            if(opCode >= 50 && opCode < 60)
                modifiedModelColours[opCode - 50] = stream.g2();
            else
                System.out.println("Error unrecognised spotanim config code: " + opCode);
        } while(true);
    }

/*
	private void readValues(Packet stream) {//new format type
	do {
		modelID = stream.g2();
		animationID = stream.g2();
        if(Sequence.anims != null && animationID != 65535 && animationID != -1)
			aSequence_407 = Sequence.anims[animationID];
        	resizeXY = stream.g1();
        	resizeZ = stream.g1();
			int j = stream.g1();
			if(j != 0){
			for (int k = 0; k < j; k++)
				originalModelColours[k] = stream.g2();
			for (int k = 0; k < j; k++)
				modifiedModelColours[k] = stream.g2();
			}
			break;
		}while(true);
	}
*/
    public Model getModel()
    {
        Model model = (Model) modelCache.get(id);
        if(model != null)
            return model;
        model = Model.getModel(modelID);
        if(model == null)
            return null;
        for(int i = 0; i < 6; i++)
            if(originalModelColours[0] != 0)
                model.recolour(originalModelColours[i], modifiedModelColours[i]);

        modelCache.put(model, id);
        return model;
    }

    private SpotAnim()
    {
        animationID = -1;
        originalModelColours = new int[6];
        modifiedModelColours = new int[6];
        resizeXY = 128;
        resizeZ = 128;
    }

    public static SpotAnim cache[];
    private int id;
    private int modelID;
    private int animationID;
    public Sequence animationSequence;
    private final int[] originalModelColours;
    private final int[] modifiedModelColours;
    public int resizeXY;
    public int resizeZ;
    public int rotation;
    public int modelBrightness;
    public int modelShadow;
    public static MemCache modelCache = new MemCache(30);

}
