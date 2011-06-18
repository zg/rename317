package rs2;


public class ObjectDef
{
    //thanks for the variables Xaves

    public static ObjectDef forID(int i)
    {
        for(int j = 0; j < 20; j++)
            if(cache[j].type == i)
                return cache[j];

        cacheIndex = (cacheIndex + 1) % 20;
        ObjectDef class46 = cache[cacheIndex];
        stream.pos = streamIndices[i];
        class46.type = i;
        class46.setDefaults();
        class46.readValues(stream);
        return class46;
    }

    private void setDefaults()
    {
        objectModelIDs = null;
        types = null;
        name = null;
        description = null;
        modifiedModelColors = null;
        originalModelColors = null;
        sizeX = 1;
        sizeY = 1;
        isUnwalkable = true;
        aBoolean757 = true;
        hasActions = false;
        isSolid = false;
        aBoolean769 = false;
        aBoolean764 = false;
        animationID = -1;
        anInt775 = 16;
        brightness = 0;
        contrast = 0;
        actions = null;
        mapFunctionID = -1;
        mapSceneID = -1;
        aBoolean751 = false;
        aBoolean779 = true;
        modelSizeX = 128;
        modelSizeH = 128;
        modelSizeY = 128;
        anInt768 = 0;
        offsetX = 0;
        offsetH = 0;
        offsetY = 0;
        aBoolean736 = false;
        aBoolean766 = false;
        anInt760 = -1;
        configId_1 = -1;
        configID = -1;
        configObjectIDs = null;
    }

    public void method574(OnDemandFetcher class42_sub1)
    {
        if(objectModelIDs == null)
            return;
        for(int j = 0; j < objectModelIDs.length; j++)
            class42_sub1.method560(objectModelIDs[j] & 0xffff, 0);
    }

    public static void nullLoader()
    {
        memCache1 = null;
        memCache2 = null;
        streamIndices = null;
        cache = null;
        stream = null;
    }

    public static void unpackConfig(JagexArchive jagexArchive)
    {
        stream = new Packet(jagexArchive.getDataForName("loc.dat"));
        Packet stream = new Packet(jagexArchive.getDataForName("loc.idx"));
        int totalObjects = stream.g2();
        streamIndices = new int[totalObjects];
        int i = 2;
        for(int j = 0; j < totalObjects; j++)
        {
            streamIndices[j] = i;
            i += stream.g2();
        }

        cache = new ObjectDef[20];
        for(int k = 0; k < 20; k++)
            cache[k] = new ObjectDef();

    }

    public boolean method577(int i)
    {
        if(types == null)
        {
            if(objectModelIDs == null)
                return true;
            if(i != 10)
                return true;
            boolean flag1 = true;
            for(int k = 0; k < objectModelIDs.length; k++)
                flag1 &= Model.isCached(objectModelIDs[k] & 0xffff);

            return flag1;
        }
        for(int j = 0; j < types.length; j++)
            if(types[j] == i)
                return Model.isCached(objectModelIDs[j] & 0xffff);

        return true;
    }

    public Model method578(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        Model model = method581(i, k1, j);
        if(model == null)
            return null;
        if(isSolid || aBoolean769)
            model = new Model(isSolid, aBoolean769, model);
        if(isSolid)
        {
            int l1 = (k + l + i1 + j1) / 4;
            for(int i2 = 0; i2 < model.verticeCount; i2++)
            {
                int j2 = model.vertexX[i2];
                int k2 = model.vertexZ[i2];
                int l2 = k + ((l - k) * (j2 + 64)) / 128;
                int i3 = j1 + ((i1 - j1) * (j2 + 64)) / 128;
                int j3 = l2 + ((i3 - l2) * (k2 + 64)) / 128;
                model.vertexY[i2] += j3 - l1;
            }

            model.method467();
        }
        return model;
    }

    public boolean method579()
    {
        if(objectModelIDs == null)
            return true;
        boolean flag1 = true;
        for(int i = 0; i < objectModelIDs.length; i++)
            flag1 &= Model.isCached(objectModelIDs[i] & 0xffff);
            return flag1;
    }

    public ObjectDef method580()
    {
        int i = -1;
        if(configId_1 != -1)
        {
            VarBit varBit = VarBit.cache[configId_1];
            int j = varBit.configId;
            int k = varBit.leastSignificantBit;
            int l = varBit.mostSignificantBit;
            int i1 = client.BITFIELD_MAX_VALUE[l - k];
            i = clientInstance.sessionSettings[j] >> k & i1;
        } else
        if(configID != -1)
            i = clientInstance.sessionSettings[configID];
        if(i < 0 || i >= configObjectIDs.length || configObjectIDs[i] == -1)
            return null;
        else
            return forID(configObjectIDs[i]);
    }

    private Model method581(int j, int k, int l)
    {
        Model model = null;
        long l1;
        if(types == null)
        {
            if(j != 10)
                return null;
            l1 = (long)((type << 6) + l) + ((long)(k + 1) << 32);
            Model model_1 = (Model) memCache2.get(l1);
            if(model_1 != null)
                return model_1;
            if(objectModelIDs == null)
                return null;
            boolean flag1 = aBoolean751 ^ (l > 3);
            int k1 = objectModelIDs.length;
            for(int i2 = 0; i2 < k1; i2++)
            {
                int l2 = objectModelIDs[i2];
                if(flag1)
                    l2 += 0x10000;
                model = (Model) memCache1.get(l2);
                if(model == null)
                {
                    model = Model.getModel(l2 & 0xffff);
                    if(model == null)
                        return null;
                    if(flag1)
                        model.method477();
                    memCache1.put(model, l2);
                }
                if(k1 > 1)
                    aModelArray741s[i2] = model;
            }

            if(k1 > 1)
                model = new Model(k1, aModelArray741s);
        } else
        {
            int i1 = -1;
            for(int j1 = 0; j1 < types.length; j1++)
            {
                if(types[j1] != j)
                    continue;
                i1 = j1;
                break;
            }

            if(i1 == -1)
                return null;
            l1 = (long)((type << 6) + (i1 << 3) + l) + ((long)(k + 1) << 32);
            Model model_2 = (Model) memCache2.get(l1);
            if(model_2 != null)
                return model_2;
            int j2 = objectModelIDs[i1];
            boolean flag3 = aBoolean751 ^ (l > 3);
            if(flag3)
                j2 += 0x10000;
            model = (Model) memCache1.get(j2);
            if(model == null)
            {
                model = Model.getModel(j2 & 0xffff);
                if(model == null)
                    return null;
                if(flag3)
                    model.method477();
                memCache1.put(model, j2);
            }
        }
        boolean flag;
        flag = modelSizeX != 128 || modelSizeH != 128 || modelSizeY != 128;
        boolean flag2;
        flag2 = offsetX != 0 || offsetH != 0 || offsetY != 0;
        Model model_3 = new Model(modifiedModelColors == null, Animation.method532(k), l == 0 && k == -1 && !flag && !flag2, model);
        if(k != -1)
        {
            model_3.calcSkinning();
            model_3.applyTransform(k);
            model_3.triangleSkin = null;
            model_3.vertexSkin = null;
        }
        while(l-- > 0)
            model_3.method473();
        if(modifiedModelColors != null)
        {
            for(int k2 = 0; k2 < modifiedModelColors.length; k2++)
                model_3.recolour(modifiedModelColors[k2], originalModelColors[k2]);

        }
        if(flag)
            model_3.scaleT(modelSizeX, modelSizeY, modelSizeH);
        if(flag2)
            model_3.translate(offsetX, offsetH, offsetY);
        model_3.light(64 + brightness, 768 + contrast * 5, -50, -10, -50, !aBoolean769);
        if(anInt760 == 1)
            model_3.anInt1654 = model_3.modelHeight;
        memCache2.put(model_3, l1);
        return model_3;
    }

    private void readValues(Packet stream)
    {
        int i = -1;
label0:
        do
        {
            int j;
            do
            {
                j = stream.g1();
                if(j == 0)
                    break label0;
                if(j == 1)
                {
                    int k = stream.g1();
                    if(k > 0)
                        if(objectModelIDs == null || lowMem)
                        {
                            types = new int[k];
                            objectModelIDs = new int[k];
                            for(int k1 = 0; k1 < k; k1++)
                            {
                                objectModelIDs[k1] = stream.g2();
                                types[k1] = stream.g1();
                            }

                        } else
                        {
                            stream.pos += k * 3;
                        }
                } else
                if(j == 2)
                    name = stream.gstr();
                else
                if(j == 3)
                    description = stream.gstrbyte();
                else
                if(j == 5)
                {
                    int l = stream.g1();
                    if(l > 0)
                        if(objectModelIDs == null || lowMem)
                        {
                            types = null;
                            objectModelIDs = new int[l];
                            for(int l1 = 0; l1 < l; l1++)
                                objectModelIDs[l1] = stream.g2();

                        } else
                        {
                            stream.pos += l * 2;
                        }
                } else
                if(j == 14)
                    sizeX = stream.g1();
                else
                if(j == 15)
                    sizeY = stream.g1();
                else
                if(j == 17)
                    isUnwalkable = false;
                else
                if(j == 18)
                    aBoolean757 = false;
                else
                if(j == 19)
                {
                    i = stream.g1();
                    if(i == 1)
                        hasActions = true;
                } else
                if(j == 21)
                    isSolid = true;
                else
                if(j == 22)
                    aBoolean769 = true;
                else
                if(j == 23)
                    aBoolean764 = true;
                else
                if(j == 24)
                {
                    animationID = stream.g2();
                    if(animationID == 65535)
                        animationID = -1;
                } else
                if(j == 28)
                    anInt775 = stream.g1();
                else
                if(j == 29)
                    brightness = stream.g1b();
                else
                if(j == 39)
                    contrast = stream.g1b();
                else
                if(j >= 30 && j < 39)
                {
                    if(actions == null)
                        actions = new String[5];
                    actions[j - 30] = stream.gstr();
                    if(actions[j - 30].equalsIgnoreCase("hidden"))
                        actions[j - 30] = null;
                } else
                if(j == 40)
                {
                    int i1 = stream.g1();
                    modifiedModelColors = new int[i1];
                    originalModelColors = new int[i1];
                    for(int i2 = 0; i2 < i1; i2++)
                    {
                        modifiedModelColors[i2] = stream.g2();
                        originalModelColors[i2] = stream.g2();
                    }

                } else
                if(j == 60)
                    mapFunctionID = stream.g2();
                else
                if(j == 62)
                    aBoolean751 = true;
                else
                if(j == 64)
                    aBoolean779 = false;
                else
                if(j == 65)
                    modelSizeX = stream.g2();
                else
                if(j == 66)
                    modelSizeH = stream.g2();
                else
                if(j == 67)
                    modelSizeY = stream.g2();
                else
                if(j == 68)
                    mapSceneID = stream.g2();
                else
                if(j == 69)
                    anInt768 = stream.g1();
                else
                if(j == 70)
                    offsetX = stream.g2b();
                else
                if(j == 71)
                    offsetH = stream.g2b();
                else
                if(j == 72)
                    offsetY = stream.g2b();
                else
                if(j == 73)
                    aBoolean736 = true;
                else
                if(j == 74)
                {
                    aBoolean766 = true;
                } else
                {
                    if(j != 75)
                        continue;
                    anInt760 = stream.g1();
                }
                continue label0;
            } while(j != 77);
            configId_1 = stream.g2();
            if(configId_1 == 65535)
                configId_1 = -1;
            configID = stream.g2();
            if(configID == 65535)
                configID = -1;
            int j1 = stream.g1();
            configObjectIDs = new int[j1 + 1];
            for(int j2 = 0; j2 <= j1; j2++)
            {
                configObjectIDs[j2] = stream.g2();
                if(configObjectIDs[j2] == 65535)
                    configObjectIDs[j2] = -1;
            }

        } while(true);
        if(i == -1)
        {
            hasActions = objectModelIDs != null && (types == null || types[0] == 10);
            if(actions != null)
                hasActions = true;
        }
        if(aBoolean766)
        {
            isUnwalkable = false;
            aBoolean757 = false;
        }
        if(anInt760 == -1)
            anInt760 = isUnwalkable ? 1 : 0;
    }

    private ObjectDef()
    {
        type = -1;
    }

    public boolean aBoolean736;
    private byte brightness;
    private int offsetX;
    public String name;
    private int modelSizeY;
    private static final Model[] aModelArray741s = new Model[4];
    private byte contrast;
    public int sizeX;
    private int offsetH;
    public int mapFunctionID;
    private int[] originalModelColors;
    private int modelSizeX;
    public int configID;
    private boolean aBoolean751;
    public static boolean lowMem;
    private static Packet stream;
    public int type;
    private static int[] streamIndices;
    public boolean aBoolean757;
    public int mapSceneID;
    public int configObjectIDs[];
    private int anInt760;
    public int sizeY;
    public boolean isSolid;
    public boolean aBoolean764;
    public static client clientInstance;
    private boolean aBoolean766;
    public boolean isUnwalkable;
    public int anInt768;
    private boolean aBoolean769;
    private static int cacheIndex;
    private int modelSizeH;
    private int[] objectModelIDs;
    public int configId_1;
    public int anInt775;
    private int[] types;
    public byte description[];
    public boolean hasActions;
    public boolean aBoolean779;
    public static MemCache memCache2 = new MemCache(30);
    public int animationID;
    private static ObjectDef[] cache;
    private int offsetY;
    private int[] modifiedModelColors;
    public static MemCache memCache1 = new MemCache(500);
    public String actions[];

}
