// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class EntityDef
{

    public static EntityDef forID(int i)
    {
        for(int j = 0; j < 20; j++)
            if(cache[j].type == (long)i)
                return cache[j];

        anInt56 = (anInt56 + 1) % 20;
        EntityDef entityDef = cache[anInt56] = new EntityDef();
        stream.pos = streamIndices[i];
        entityDef.type = i;
        entityDef.readValues(stream);
        return entityDef;
    }

    public Model getHeadModel()
    {
        if(childrenIDs != null)
        {
            EntityDef entityDef = method161();
            if(entityDef == null)
                return null;
            else
                return entityDef.getHeadModel();
        }
        if(anIntArray73 == null)
            return null;
        boolean flag1 = false;
        for(int i = 0; i < anIntArray73.length; i++)
            if(!Model.isDownloaded(anIntArray73[i]))
                flag1 = true;

        if(flag1)
            return null;
        Model aclass30_sub2_sub4_sub6s[] = new Model[anIntArray73.length];
        for(int j = 0; j < anIntArray73.length; j++)
            aclass30_sub2_sub4_sub6s[j] = Model.getModel(anIntArray73[j]);

        Model model;
        if(aclass30_sub2_sub4_sub6s.length == 1)
            model = aclass30_sub2_sub4_sub6s[0];
        else
            model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
        if(anIntArray76 != null)
        {
            for(int k = 0; k < anIntArray76.length; k++)
                model.recolour(anIntArray76[k], anIntArray70[k]);

        }
        return model;
    }

    public EntityDef method161()
    {
        int j = -1;
        if(anInt57 != -1)
        {
            VarBit varBit = VarBit.cache[anInt57];
            int k = varBit.configId;
            int l = varBit.least_significant_bit;
            int i1 = varBit.most_significant_bit;
            int j1 = client.BITFIELD_MAX_VALUE[i1 - l];
            j = clientInstance.session_settings[k] >> l & j1;
        } else
        if(anInt59 != -1)
            j = clientInstance.session_settings[anInt59];
        if(j < 0 || j >= childrenIDs.length || childrenIDs[j] == -1)
            return null;
        else
            return forID(childrenIDs[j]);
    }

    public static void unpackConfig(JagexArchive jagexArchive)
    {
        stream = new Packet(jagexArchive.getDataForName("npc.dat"));
        Packet stream2 = new Packet(jagexArchive.getDataForName("npc.idx"));
        int totalNPCs = stream2.g2();
        streamIndices = new int[totalNPCs];
        int i = 2;
        for(int j = 0; j < totalNPCs; j++)
        {
            streamIndices[j] = i;
            i += stream2.g2();
        }

        cache = new EntityDef[20];
        for(int k = 0; k < 20; k++)
            cache[k] = new EntityDef();

    }

    public static void nullLoader()
    {
        mruNodes = null;
        streamIndices = null;
        cache = null;
        stream = null;
    }

    public Model method164(int j, int frameId, int ai[])
    {
        if(childrenIDs != null)
        {
            EntityDef entityDef = method161();
            if(entityDef == null)
                return null;
            else
                return entityDef.method164(j, frameId, ai);
        }
        Model model = (Model) mruNodes.get(type);
        if(model == null)
        {
            boolean flag = false;
            for(int i1 = 0; i1 < anIntArray94.length; i1++)
                if(!Model.isDownloaded(anIntArray94[i1]))
                    flag = true;

            if(flag)
                return null;
            Model aclass30_sub2_sub4_sub6s[] = new Model[anIntArray94.length];
            for(int j1 = 0; j1 < anIntArray94.length; j1++)
                aclass30_sub2_sub4_sub6s[j1] = Model.getModel(anIntArray94[j1]);

            if(aclass30_sub2_sub4_sub6s.length == 1)
                model = aclass30_sub2_sub4_sub6s[0];
            else
                model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
            if(anIntArray76 != null)
            {
                for(int k1 = 0; k1 < anIntArray76.length; k1++)
                    model.recolour(anIntArray76[k1], anIntArray70[k1]);

            }
            model.calcSkinning();
            model.preprocess(64 + anInt85, 850 + anInt92, -30, -50, -30, true);
            mruNodes.put(model, type);
        }
        Model model_1 = Model.aModel_1621;
        model_1.method464(model, AnimationFrame.method532(frameId) & AnimationFrame.method532(j));
        if(frameId != -1 && j != -1)
            model_1.mixAnimationFrames(ai, j, frameId);
        else
        if(frameId != -1)
            model_1.applyTransform(frameId);
        if(anInt91 != 128 || anInt86 != 128)
            model_1.scaleT(anInt91, anInt91, anInt86);
        model_1.calculateDiagonals();
        model_1.triangleSkin = null;
        model_1.vertexSkin = null;
        if(aByte68 == 1)
            model_1.aBoolean1659 = true;
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
                anIntArray94 = new int[j];
                for(int j1 = 0; j1 < j; j1++)
                    anIntArray94[j1] = stream.g2();

            } else
            if(i == 2)
                name = stream.gstr();
            else
            if(i == 3)
                description = stream.gstrbyte();
            else
            if(i == 12)
                aByte68 = stream.g1b();
            else
            if(i == 13)
                idleAnimation = stream.g2();
            else
            if(i == 14)
                anInt67 = stream.g2();
            else
            if(i == 17)
            {
                anInt67 = stream.g2();
                anInt58 = stream.g2();
                anInt83 = stream.g2();
                anInt55 = stream.g2();
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
                int k = stream.g1();
                anIntArray76 = new int[k];
                anIntArray70 = new int[k];
                for(int k1 = 0; k1 < k; k1++)
                {
                    anIntArray76[k1] = stream.g2();
                    anIntArray70[k1] = stream.g2();
                }

            } else
            if(i == 60)
            {
                int l = stream.g1();
                anIntArray73 = new int[l];
                for(int l1 = 0; l1 < l; l1++)
                    anIntArray73[l1] = stream.g2();

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
                aBoolean87 = false;
            else
            if(i == 95)
                combatLevel = stream.g2();
            else
            if(i == 97)
                anInt91 = stream.g2();
            else
            if(i == 98)
                anInt86 = stream.g2();
            else
            if(i == 99)
                aBoolean93 = true;
            else
            if(i == 100)
                anInt85 = stream.g1b();
            else
            if(i == 101)
                anInt92 = stream.g1b() * 5;
            else
            if(i == 102)
                anInt75 = stream.g2();
            else
            if(i == 103)
                anInt79 = stream.g2();
            else
            if(i == 106)
            {
                anInt57 = stream.g2();
                if(anInt57 == 65535)
                    anInt57 = -1;
                anInt59 = stream.g2();
                if(anInt59 == 65535)
                    anInt59 = -1;
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
                aBoolean84 = false;
        } while(true);
    }

    private EntityDef()
    {
        anInt55 = -1;
        anInt57 = -1;
        anInt58 = -1;
        anInt59 = -1;
        combatLevel = -1;
        anInt64 = 1834;
        anInt67 = -1;
        aByte68 = 1;
        anInt75 = -1;
        idleAnimation = -1;
        type = -1L;
        anInt79 = 32;
        anInt83 = -1;
        aBoolean84 = true;
        anInt86 = 128;
        aBoolean87 = true;
        anInt91 = 128;
        aBoolean93 = false;
    }

    public int anInt55;
    private static int anInt56;
    private int anInt57;
    public int anInt58;
    private int anInt59;
    private static Packet stream;
    public int combatLevel;
    private final int anInt64;
    public String name;
    public String actions[];
    public int anInt67;
    public byte aByte68;
    private int[] anIntArray70;
    private static int[] streamIndices;
    private int[] anIntArray73;
    public int anInt75;
    private int[] anIntArray76;
    public int idleAnimation;
    public long type;
    public int anInt79;
    private static EntityDef[] cache;
    public static client clientInstance;
    public int anInt83;
    public boolean aBoolean84;
    private int anInt85;
    private int anInt86;
    public boolean aBoolean87;
    public int childrenIDs[];
    public byte description[];
    private int anInt91;
    private int anInt92;
    public boolean aBoolean93;
    private int[] anIntArray94;
    public static MRUNodes mruNodes = new MRUNodes(30);

}
