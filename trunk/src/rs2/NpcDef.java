package rs2;


public class NpcDef
{

    public static NpcDef forID(int itemId)
    {
        for(int j = 0; j < 20; j++)
            if(cache[j].type == (long)itemId)
                return cache[j];

        cacheIndex = (cacheIndex + 1) % 20;
        NpcDef npcDef = cache[cacheIndex] = new NpcDef();
        npcData.pos = streamIndices[itemId];
        npcDef.type = itemId;
        npcDef.readValues(npcData);
        return npcDef;
    }

    public Model getHeadModel()
    {
        if(childrenIDs != null)
        {
            NpcDef npcDef = method161();
            if(npcDef == null)
                return null;
            else
                return npcDef.getHeadModel();
        }
        if(aditionalModels == null)
            return null;
        boolean modelMissing = false;
        for(int i = 0; i < aditionalModels.length; i++)
            if(!Model.isCached(aditionalModels[i]))
                modelMissing = true;

        if(modelMissing)
            return null;
        Model additionalModels[] = new Model[aditionalModels.length];
        for(int additionalModelPtr = 0; additionalModelPtr < aditionalModels.length; additionalModelPtr++)
            additionalModels[additionalModelPtr] = Model.getModel(aditionalModels[additionalModelPtr]);

        Model model;
        if(additionalModels.length == 1)
            model = additionalModels[0];
        else
            model = new Model(additionalModels.length, additionalModels);
        if(recolourOriginal != null)
        {
            for(int k = 0; k < recolourOriginal.length; k++)
                model.recolour(recolourOriginal[k], recolourTarget[k]);

        }
        return model;
    }

    public NpcDef method161()
    {
        int j = -1;
        if(varBitID != -1)
        {
            VarBit varBit = VarBit.cache[varBitID];
            int k = varBit.configId;
            int l = varBit.leastSignificantBit;
            int i1 = varBit.mostSignificantBit;
            int j1 = StaticLogic.BITFIELD_MAX_VALUE[i1 - l];
            if (clientInstance == null)
                j = 0;
            else
                j = clientInstance.sessionSettings[k] >> l & j1;
        } else
        if(sessionSettingID != -1)
            if (clientInstance == null)
                j = 0;
            else
                j = clientInstance.sessionSettings[sessionSettingID];
        if(j < 0 || j >= childrenIDs.length || childrenIDs[j] == -1)
            return null;
        else
            return forID(childrenIDs[j]);
    }

    public static void unpackConfig(JagexArchive jagexArchive)
    {
        npcData = new Packet(jagexArchive.getDataForName("npc.dat"));
        Packet indexData = new Packet(jagexArchive.getDataForName("npc.idx"));
        int totalNPCs = indexData.g2();
        streamIndices = new int[totalNPCs];
        int i = 2;
        for(int npcPtr = 0; npcPtr < totalNPCs; npcPtr++)
        {
            streamIndices[npcPtr] = i;
            i += indexData.g2();
        }

        cache = new NpcDef[20];
        for(int k = 0; k < 20; k++)
            cache[k] = new NpcDef();

    }

    public static void clearCache()
    {
        modelCache = null;
        streamIndices = null;
        cache = null;
        npcData = null;
    }

    public Model method164(int frameId2, int frameId, int framesFrom2[])
    {
        if(childrenIDs != null)
        {
            NpcDef npcDef = method161();
            if(npcDef == null)
                return null;
            else
                return npcDef.method164(frameId2, frameId, framesFrom2);
        }
        Model model = (Model) modelCache.get(type);
        if(model == null)
        {
            boolean flag = false;
            for(int i1 = 0; i1 < npcModels.length; i1++)
                if(!Model.isCached(npcModels[i1]))
                    flag = true;

            if(flag)
                return null;
            Model models[] = new Model[npcModels.length];
            for(int j1 = 0; j1 < npcModels.length; j1++)
                models[j1] = Model.getModel(npcModels[j1]);

            if(models.length == 1)
                model = models[0];
            else
                model = new Model(models.length, models);
            if(recolourOriginal != null)
            {
                for(int k1 = 0; k1 < recolourOriginal.length; k1++)
                    model.recolour(recolourOriginal[k1], recolourTarget[k1]);

            }
            model.createBones();
            model.light(64 + lightModifier, 850 + shadowModifier, -30, -50, -30, true);
            modelCache.put(model, type);
        }
        Model model_1 = Model.aModel_1621;
        model_1.method464(model, Animation.isNullFrame(frameId) & Animation.isNullFrame(frameId2));
        if(frameId != -1 && frameId2 != -1)
            model_1.mixAnimationFrames(framesFrom2, frameId2, frameId);
        else
        if(frameId != -1)
            model_1.applyTransform(frameId);
        if(scaleXZ != 128 || scaleY != 128)
            model_1.scaleT(scaleXZ, scaleXZ, scaleY);
        model_1.calculateDiagonals();
        model_1.triangleSkin = null;
        model_1.vertexSkin = null;
        if(boundDim == 1)
            model_1.oneSquareModel = true;
        return model_1;
    }

    private void readValues(Packet stream)
    {
        do
        {
            int i = stream.g1();
            if(i == 0)
                return;
            if(i == 1)
            {
                int j = stream.g1();
                npcModels = new int[j];
                for(int j1 = 0; j1 < j; j1++)
                    npcModels[j1] = stream.g2();

            } else
            if(i == 2)
                name = stream.gstr();
            else
            if(i == 3)
                description = stream.gstrbyte();
            else
            if(i == 12)
                boundDim = stream.g1b();
            else
            if(i == 13)
                idleAnimation = stream.g2();
            else
            if(i == 14)
                walkAnimIndex = stream.g2();
            else
            if(i == 17)
            {
                walkAnimIndex = stream.g2();
                turn180AnimIndex = stream.g2();
                turn90CWAnimIndex = stream.g2();
                turn90CCWAnimIndex = stream.g2();
            } else
            if(i >= 30 && i < 40)
            {
                if(actions == null)
                    actions = new String[5];
                actions[i - 30] = stream.gstr();
                if(actions[i - 30].equalsIgnoreCase("hidden"))
                    actions[i - 30] = null;
            } else
            if(i == 40)
            {
                int colours = stream.g1();
                recolourOriginal = new int[colours];
                recolourTarget = new int[colours];
                for(int k1 = 0; k1 < colours; k1++)
                {
                    recolourOriginal[k1] = stream.g2();
                    recolourTarget[k1] = stream.g2();
                }

            } else
            if(i == 60)
            {
                int additionalModelLen = stream.g1();
                aditionalModels = new int[additionalModelLen];
                for(int l1 = 0; l1 < additionalModelLen; l1++)
                    aditionalModels[l1] = stream.g2();

            } else
            if(i == 90)
                stream.g2();
            else
            if(i == 91)
                stream.g2();
            else
            if(i == 92)
                stream.g2();
            else
            if(i == 93)
                drawMinimapDot = false;//dont show on minimap
            else
            if(i == 95)
                combatLevel = stream.g2();
            else
            if(i == 97)
                scaleXZ = stream.g2();
            else
            if(i == 98)
                scaleY = stream.g2();
            else
            if(i == 99)//should be isVisible but method146 is wrong?
                aBoolean93 = true;
            else
            if(i == 100)
                lightModifier = stream.g1b();
            else
            if(i == 101)
                shadowModifier = stream.g1b() * 5;
            else
            if(i == 102)
                headIcon = stream.g2();
            else
            if(i == 103)
                degreesToTurn = stream.g2();
            else
            if(i == 106)
            {
                varBitID = stream.g2();
                if(varBitID == 65535)
                    varBitID = -1;
                sessionSettingID = stream.g2();
                if(sessionSettingID == 65535)
                    sessionSettingID = -1;
                int i1 = stream.g1();
                childrenIDs = new int[i1 + 1];
                for(int i2 = 0; i2 <= i1; i2++)
                {
                    childrenIDs[i2] = stream.g2();
                    if(childrenIDs[i2] == 65535)
                        childrenIDs[i2] = -1;
                }

            } else
            if(i == 107)
                clickable = false;
        } while(true);
    }

    private NpcDef()
    {
        turn90CCWAnimIndex = -1;
        varBitID = -1;
        turn180AnimIndex = -1;
        sessionSettingID = -1;
        combatLevel = -1;
        //anInt64 = 1834;//never used
        walkAnimIndex = -1;
        boundDim = 1;
        headIcon = -1;
        idleAnimation = -1;
        type = -1L;
        degreesToTurn = 32;
        turn90CWAnimIndex = -1;
        clickable = true;
        scaleY = 128;
        drawMinimapDot = true;
        scaleXZ = 128;
        aBoolean93 = false;
    }

    public int turn90CCWAnimIndex;
    private static int cacheIndex;
    private int varBitID;
    public int turn180AnimIndex;
    private int sessionSettingID;
    private static Packet npcData;
    public int combatLevel;
    //private final int anInt64;//never used
    public String name;
    public String actions[];
    public int walkAnimIndex;
    public byte boundDim;
    private int[] recolourTarget;
    private static int[] streamIndices;
    private int[] aditionalModels;
    public int headIcon;
    private int[] recolourOriginal;
    public int idleAnimation;
    public long type;
    public int degreesToTurn;
    private static NpcDef[] cache;
    public static Client clientInstance;
    public int turn90CWAnimIndex;
    public boolean clickable;
    private int lightModifier;
    private int scaleY;
    public boolean drawMinimapDot;
    public int childrenIDs[];
    public byte description[];
    private int scaleXZ;
    private int shadowModifier;
    public boolean aBoolean93;
    private int[] npcModels;
    public static MemCache modelCache = new MemCache(30);

}
