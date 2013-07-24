package rs2;


import rs2.util.collection.MemCache;

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
        object_model_ids = null;
        object_model_type = null;
        name = null;
        description = null;
        modifiedModelColors = null;
        originalModelColors = null;
        width = 1;
        height = 1;
        isUnwalkable = true;
        aBoolean757 = true;
        hasActions = false;
        adjustToTerrain = false;
        nonFlatShading = false;
        aBoolean764 = false;
        animation_id = -1;
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
        isSolidObject = false;
        anInt760 = -1;
        variable_id_bitfield = -1;
        variable_id = -1;
        alternative_ids = null;
    }

    public void request_models(OnDemandFetcher class42_sub1)
    {
        if(object_model_ids == null)
            return;
        for(int j = 0; j < object_model_ids.length; j++)
            class42_sub1.method560(object_model_ids[j] & 0xffff, 0);
    }

    public static void clearCache()
    {
        modelCache = null;
        modelCache2 = null;
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

    public boolean is_type_cached(int i)
    {
        if(object_model_type == null)
        {
            if(object_model_ids == null)
                return true;
            if(i != 10)
                return true;
            boolean flag1 = true;
            for(int k = 0; k < object_model_ids.length; k++)
                flag1 &= Model.isCached(object_model_ids[k] & 0xffff);

            return flag1;
        }
        for(int j = 0; j < object_model_type.length; j++)
            if(object_model_type[j] == i)
                return Model.isCached(object_model_ids[j] & 0xffff);

        return true;
    }

    public Model generate_model(int object_type, int orientation, int a_y, int b_y, int d_y, int c_y, int currentAnimID)
    {
        Model model = getAnimatedModel(object_type, currentAnimID, orientation);
        if(model == null)
            return null;
        if(adjustToTerrain || nonFlatShading)
            model = new Model(adjustToTerrain, nonFlatShading, model);
        adjustToTerrain = true;
        if(adjustToTerrain)
        {
            int avg_y = (a_y + b_y + d_y + c_y) / 4;
            for(int vertex_ptr = 0; vertex_ptr < model.vertex_count; vertex_ptr++)
            {
                int vertex_x = model.vertex_x[vertex_ptr];
                int vertex_z = model.vertex_z[vertex_ptr];
                int l2 = a_y + ((b_y - a_y) * (vertex_x + 64)) / 128;
                int i3 = c_y + ((d_y - c_y) * (vertex_x + 64)) / 128;
                int j3 = l2 + ((i3 - l2) * (vertex_z + 64)) / 128;
                model.vertex_y[vertex_ptr] += j3 - avg_y;
            }
            model.normalise();
        }
        return model;
    }

    public boolean is_cached()
    {
        if(object_model_ids == null)
            return true;
        boolean complete = true;
        for(int i = 0; i < object_model_ids.length; i++)
            complete &= Model.isCached(object_model_ids[i] & 0xffff);
            return complete;
    }

    public ObjectDef method580()
    {
        int i = -1;
        if(variable_id_bitfield != -1)
        {
            VarBit varBit = VarBit.cache[variable_id_bitfield];
            int j = varBit.variable;
            int k = varBit.leastSignificantBit;
            int l = varBit.mostSignificantBit;
            int i1 = StaticLogic.BITFIELD_MASK[l - k];
            if (clientInstance == null)
                i = 0;
            else
                i = clientInstance.session_variables[j] >> k & i1;

        } else
        if(variable_id != -1)
            if (clientInstance == null)
                i = 0;
            else
                i = clientInstance.session_variables[variable_id];
        if(i < 0 || i >= alternative_ids.length || alternative_ids[i] == -1)
            return null;
        else
            return forID(alternative_ids[i]);
    }

    private Model getAnimatedModel(int objectType, int currentAnimID, int face)
    {
        Model model = null;
        long hash;
        if(object_model_type == null)
        {
            if(objectType != 10)
                return null;
            hash = (long)((type << 6) + face) + ((long)(currentAnimID + 1) << 32);
            Model model_1 = (Model) modelCache2.get(hash);
            if(model_1 != null)
                return model_1;
            if(object_model_ids == null)
                return null;
            boolean mirror = aBoolean751 ^ (face > 3);
            int numberOfModels = object_model_ids.length;
            for(int i2 = 0; i2 < numberOfModels; i2++)
            {
                int subModelID = object_model_ids[i2];
                if(mirror)
                    subModelID += 0x10000;
                model = (Model) modelCache.get(subModelID);
                if(model == null)
                {
                    model = Model.getModel(subModelID & 0xffff);
                    if(model == null)
                        return null;
                    if(mirror)
                        model.mirrorModel();
                    modelCache.put(model, subModelID);
                }
                if(numberOfModels > 1)
                    modelParts[i2] = model;
            }

            if(numberOfModels > 1)
                model = new Model(numberOfModels, modelParts);
        } else
        {
            int i1 = -1;
            for(int j1 = 0; j1 < object_model_type.length; j1++)
            {
                if(object_model_type[j1] != objectType)
                    continue;
                i1 = j1;
                break;
            }

            if(i1 == -1)
                return null;
            hash = (long)((type << 6) + (i1 << 3) + face) + ((long)(currentAnimID + 1) << 32);
            Model model_2 = (Model) modelCache2.get(hash);
            if(model_2 != null)
                return model_2;
            int j2 = object_model_ids[i1];
            boolean mirrorModel = aBoolean751 ^ (face > 3);
            if(mirrorModel)
                j2 += 0x10000;
            model = (Model) modelCache.get(j2);
            if(model == null)
            {
                model = Model.getModel(j2 & 0xffff);
                if(model == null)
                    return null;
                if(mirrorModel)
                    model.mirrorModel();
                modelCache.put(model, j2);
            }
        }
        boolean needsScaling;
        needsScaling = modelSizeX != 128 || modelSizeH != 128 || modelSizeY != 128;
        boolean modelIsOffset;
        modelIsOffset = offsetX != 0 || offsetH != 0 || offsetY != 0;
        Model model_3 = new Model(modifiedModelColors == null, Animation.isNullFrame(currentAnimID), face == 0 && currentAnimID == -1 && !needsScaling && !modelIsOffset, model);
        if(currentAnimID != -1)
        {
            model_3.createBones();
            model_3.applyTransform(currentAnimID);
            model_3.triangleSkin = null;
            model_3.vertexSkin = null;
        }
        while(face-- > 0)
            model_3.rotateBy90();
        if(modifiedModelColors != null)
        {
            for(int k2 = 0; k2 < modifiedModelColors.length; k2++)
                model_3.recolour(modifiedModelColors[k2], originalModelColors[k2]);

        }
        if(needsScaling)
            model_3.scale(modelSizeX, modelSizeH, modelSizeY);
        if(modelIsOffset)
            model_3.translate(offsetX, offsetH, offsetY);
        model_3.light(64 + brightness, 768 + contrast * 5, -50, -10, -50, !nonFlatShading);
        if(anInt760 == 1)
            model_3.anInt1654 = model_3.modelHeight;
        modelCache2.put(model_3, hash);
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
                        if(object_model_ids == null || lowMem)
                        {
                            object_model_type = new int[k];
                            object_model_ids = new int[k];
                            for(int k1 = 0; k1 < k; k1++)
                            {
                                object_model_ids[k1] = stream.g2();
                                
                                object_model_type[k1] = stream.g1();
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
                        if(object_model_ids == null || lowMem)
                        {
                            object_model_type = null;
                            object_model_ids = new int[l];
                            for(int l1 = 0; l1 < l; l1++)
                                object_model_ids[l1] = stream.g2();

                        } else
                        {
                            stream.pos += l * 2;
                        }
                } else
                if(j == 14)
                    width = stream.g1();
                else
                if(j == 15)
                    height = stream.g1();
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
                    adjustToTerrain = true;
                else
                if(j == 22)
                    nonFlatShading = true;
                else
                if(j == 23)
                    aBoolean764 = true;
                else
                if(j == 24)
                {
                    animation_id = stream.g2();
                    if(animation_id == 65535)
                        animation_id = -1;
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
                    mapFunctionID = stream.g2();//minimapIconIndex
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
                    isSolidObject = true;
                } else
                {
                    if(j != 75)
                        continue;
                    anInt760 = stream.g1();
                }
                continue label0;
            } while(j != 77);
            variable_id_bitfield = stream.g2();
            if(variable_id_bitfield == 65535)
                variable_id_bitfield = -1;
            variable_id = stream.g2();
            if(variable_id == 65535)
                variable_id = -1;
            int j1 = stream.g1();
            alternative_ids = new int[j1 + 1];
            for(int j2 = 0; j2 <= j1; j2++)
            {
                alternative_ids[j2] = stream.g2();
                if(alternative_ids[j2] == 65535)
                    alternative_ids[j2] = -1;
            }

        } while(true);
        if(i == -1)
        {
            hasActions = object_model_ids != null && (object_model_type == null || object_model_type[0] == 10);
            if(actions != null)
                hasActions = true;
        }
        if(isSolidObject)
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
    private static final Model[] modelParts = new Model[4];
    private byte contrast;
    public int width;
    private int offsetH;
    public int mapFunctionID;
    private int[] originalModelColors;
    private int modelSizeX;
    public int variable_id;
    private boolean aBoolean751;
    public static boolean lowMem;
    private static Packet stream;
    public int type;
    private static int[] streamIndices;
    public boolean aBoolean757;
    public int mapSceneID;
    public int alternative_ids[];
    private int anInt760;
    public int height;
    public boolean adjustToTerrain;
    public boolean aBoolean764;
    public static Client clientInstance;
    private boolean isSolidObject;
    public boolean isUnwalkable;
    public int anInt768;
    private boolean nonFlatShading;
    private static int cacheIndex;
    private int modelSizeH;
    private int[] object_model_ids;
    public int variable_id_bitfield;
    public int anInt775;
    private int[] object_model_type;
    public byte description[];
    public boolean hasActions;
    public boolean aBoolean779;
    public static MemCache modelCache2 = new MemCache(30);
    public int animation_id;
    private static ObjectDef[] cache;
    private int offsetY;
    private int[] modifiedModelColors;
    public static MemCache modelCache = new MemCache(500);
    public String actions[];

}
