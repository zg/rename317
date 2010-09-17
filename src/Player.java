// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class Player extends Entity
{

    public Model getRotatedModel()
    {
        if(!visible)
            return null;
        Model model = method452();
        if(model == null)
            return null;
        super.height = model.modelHeight;
        model.aBoolean1659 = true;
        if(aBoolean1699)
            return model;
        if(super.anInt1520 != -1 && super.anInt1521 != -1)
        {
            SpotAnim spotAnim = SpotAnim.cache[super.anInt1520];
            Model model_2 = spotAnim.getModel();
            if(model_2 != null)
            {
                Model model_3 = new Model(true, AnimationFrame.method532(super.anInt1521), false, model_2);
                model_3.translate(0, -super.anInt1524, 0);
                model_3.calcSkinning();
                model_3.applyTransform(spotAnim.aAnimation_407.frame2IDS[super.anInt1521]);
                model_3.triangleSkin = null;
                model_3.vertexSkin = null;
                if(spotAnim.resizeXY != 128 || spotAnim.resizeZ != 128)
                    model_3.scaleT(spotAnim.resizeXY, spotAnim.resizeXY, spotAnim.resizeZ);
                model_3.preprocess(64 + spotAnim.modelBrightness, 850 + spotAnim.modelShadow, -30, -50, -30, true);
                Model aclass30_sub2_sub4_sub6_1s[] = {
                        model, model_3
                };
                model = new Model(aclass30_sub2_sub4_sub6_1s);
            }
        }
        if(aModel_1714 != null)
        {
            if(client.loopCycle >= anInt1708)
                aModel_1714 = null;
            if(client.loopCycle >= anInt1707 && client.loopCycle < anInt1708)
            {
                Model model_1 = aModel_1714;
                model_1.translate(anInt1711 - super.bound_extent_x, anInt1712 - anInt1709, anInt1713 - super.bound_extent_y);
                if(super.turnDirection == 512)
                {
                    model_1.method473();
                    model_1.method473();
                    model_1.method473();
                } else
                if(super.turnDirection == 1024)
                {
                    model_1.method473();
                    model_1.method473();
                } else
                if(super.turnDirection == 1536)
                    model_1.method473();
                Model aclass30_sub2_sub4_sub6s[] = {
                        model, model_1
                };
                model = new Model(aclass30_sub2_sub4_sub6s);
                if(super.turnDirection == 512)
                    model_1.method473();
                else
                if(super.turnDirection == 1024)
                {
                    model_1.method473();
                    model_1.method473();
                } else
                if(super.turnDirection == 1536)
                {
                    model_1.method473();
                    model_1.method473();
                    model_1.method473();
                }
                model_1.translate(super.bound_extent_x - anInt1711, anInt1709 - anInt1712, super.bound_extent_y - anInt1713);
            }
        }
        model.aBoolean1659 = true;
        return model;
    }

    public void updatePlayer(Stream stream)
    {
        stream.currentOffset = 0;
        anInt1702 = stream.readUnsignedByte();
        headIcon = stream.readUnsignedByte();
        desc = null;
        team = 0;
        for(int j = 0; j < 12; j++)
        {
            int k = stream.readUnsignedByte();
            if(k == 0)
            {
                appearance_models[j] = 0;
                continue;
            }
            int i1 = stream.readUnsignedByte();
            appearance_models[j] = (k << 8) + i1;
            if(j == 0 && appearance_models[0] == 65535)
            {
                desc = EntityDef.forID(stream.readUnsignedWord());
                break;
            }
            if(appearance_models[j] >= 512 && appearance_models[j] - 512 < ItemDef.totalItems)
            {
                int l1 = ItemDef.forID(appearance_models[j] - 512).team;
                if(l1 != 0)
                    team = l1;
            }
        }

        for(int l = 0; l < 5; l++)
        {
            int j1 = stream.readUnsignedByte();
            if(j1 < 0 || j1 >= client.PLAYER_BODY_RECOLOURS[l].length)
                j1 = 0;
            appearance_colours[l] = j1;
        }

        super.anInt1511 = stream.readUnsignedWord();
        if(super.anInt1511 == 65535)
            super.anInt1511 = -1;
        super.anInt1512 = stream.readUnsignedWord();
        if(super.anInt1512 == 65535)
            super.anInt1512 = -1;
        super.anInt1554 = stream.readUnsignedWord();
        if(super.anInt1554 == 65535)
            super.anInt1554 = -1;
        super.anInt1555 = stream.readUnsignedWord();
        if(super.anInt1555 == 65535)
            super.anInt1555 = -1;
        super.anInt1556 = stream.readUnsignedWord();
        if(super.anInt1556 == 65535)
            super.anInt1556 = -1;
        super.anInt1557 = stream.readUnsignedWord();
        if(super.anInt1557 == 65535)
            super.anInt1557 = -1;
        super.anInt1505 = stream.readUnsignedWord();
        if(super.anInt1505 == 65535)
            super.anInt1505 = -1;
        name = TextClass.fixName(TextClass.nameForLong(stream.readQWord()));
        combatLevel = stream.readUnsignedByte();
        skill = stream.readUnsignedWord();
        visible = true;
        aLong1718 = 0L;
        for(int k1 = 0; k1 < 12; k1++)
        {
            aLong1718 <<= 4;
            if(appearance_models[k1] >= 256)
                aLong1718 += appearance_models[k1] - 256;
        }

        if(appearance_models[0] >= 256)
            aLong1718 += appearance_models[0] - 256 >> 4;
        if(appearance_models[1] >= 256)
            aLong1718 += appearance_models[1] - 256 >> 8;
        for(int i2 = 0; i2 < 5; i2++)
        {
            aLong1718 <<= 3;
            aLong1718 += appearance_colours[i2];
        }

        aLong1718 <<= 1;
        aLong1718 += anInt1702;
    }

    private Model method452()
    {
        if(desc != null)
        {
            int j = -1;
            if(super.animation >= 0 && super.anInt1529 == 0)
                j = Animation.anims[super.animation].frame2IDS[super.anInt1527];
            else
            if(super.anInt1517 >= 0)
                j = Animation.anims[super.anInt1517].frame2IDS[super.anInt1518];
            Model model = desc.method164(-1, j, null);
            return model;
        }
        long l = aLong1718;
        int k = -1;
        int i1 = -1;
        int j1 = -1;
        int k1 = -1;
        if(super.animation >= 0 && super.anInt1529 == 0)
        {
            Animation animation = Animation.anims[super.animation];
            k = animation.frame2IDS[super.anInt1527];
            if(super.anInt1517 >= 0 && super.anInt1517 != super.anInt1511)
                i1 = Animation.anims[super.anInt1517].frame2IDS[super.anInt1518];
            if(animation.anInt360 >= 0)
            {
                j1 = animation.anInt360;
                l += j1 - appearance_models[5] << 40;
            }
            if(animation.anInt361 >= 0)
            {
                k1 = animation.anInt361;
                l += k1 - appearance_models[3] << 48;
            }
        } else
        if(super.anInt1517 >= 0)
            k = Animation.anims[super.anInt1517].frame2IDS[super.anInt1518];
        Model model_1 = (Model) mruNodes.get(l);
        if(model_1 == null)
        {
            boolean flag = false;
            for(int i2 = 0; i2 < 12; i2++)
            {
                int k2 = appearance_models[i2];
                if(k1 >= 0 && i2 == 3)
                    k2 = k1;
                if(j1 >= 0 && i2 == 5)
                    k2 = j1;
                if(k2 >= 256 && k2 < 512 && !IdentityKit.cache[k2 - 256].is_body_downloaded())
                    flag = true;
                if(k2 >= 512 && !ItemDef.forID(k2 - 512).method195(anInt1702))
                    flag = true;
            }

            if(flag)
            {
                if(aLong1697 != -1L)
                    model_1 = (Model) mruNodes.get(aLong1697);
                if(model_1 == null)
                    return null;
            }
        }
        if(model_1 == null)
        {
            Model aclass30_sub2_sub4_sub6s[] = new Model[12];
            int j2 = 0;
            for(int l2 = 0; l2 < 12; l2++)
            {
                int i3 = appearance_models[l2];
                if(k1 >= 0 && l2 == 3)
                    i3 = k1;
                if(j1 >= 0 && l2 == 5)
                    i3 = j1;
                if(i3 >= 256 && i3 < 512)
                {
                    Model model_3 = IdentityKit.cache[i3 - 256].get_body_model();
                    if(model_3 != null)
                        aclass30_sub2_sub4_sub6s[j2++] = model_3;
                }
                if(i3 >= 512)
                {
                    Model model_4 = ItemDef.forID(i3 - 512).method196(anInt1702);
                    if(model_4 != null)
                        aclass30_sub2_sub4_sub6s[j2++] = model_4;
                }
            }

            model_1 = new Model(j2, aclass30_sub2_sub4_sub6s);
            for(int j3 = 0; j3 < 5; j3++)
                if(appearance_colours[j3] != 0)
                {
                    model_1.recolour(client.PLAYER_BODY_RECOLOURS[j3][0], client.PLAYER_BODY_RECOLOURS[j3][appearance_colours[j3]]);
                    if(j3 == 1)
                        model_1.recolour(client.SKIN_COLOURS[0], client.SKIN_COLOURS[appearance_colours[j3]]);
                }

            model_1.calcSkinning();
            model_1.preprocess(64, 850, -30, -50, -30, true);
            mruNodes.put(model_1, l);
            aLong1697 = l;
        }
        if(aBoolean1699)
            return model_1;
        Model model_2 = Model.aModel_1621;
        model_2.method464(model_1, AnimationFrame.method532(k) & AnimationFrame.method532(i1));
        if(k != -1 && i1 != -1)
            model_2.method471(Animation.anims[super.animation].animationFlowControl, i1, k);
        else
        if(k != -1)
            model_2.applyTransform(k);
        model_2.method466();
        model_2.triangleSkin = null;
        model_2.vertexSkin = null;
        return model_2;
    }

    public boolean isVisible()
    {
        return visible;
    }

    public int privelage;
	public Model get_head_model()
    {
        if(!visible)
            return null;
        if(desc != null)
            return desc.get_head_model();
        boolean is_downloaded = false;
        for(int i = 0; i < 12; i++)
        {
            int j = appearance_models[i];
            if(j >= 256 && j < 512 && !IdentityKit.cache[j - 256].is_head_downloaded())
                is_downloaded = true;
            if(j >= 512 && !ItemDef.forID(j - 512).is_downloaded(anInt1702))
                is_downloaded = true;
        }

        if(is_downloaded)
            return null;
        Model sub_models[] = new Model[12];
        int model_ptr = 0;
        for(int ptr = 0; ptr < 12; ptr++)
        {
            int model_id = appearance_models[ptr];
            if(model_id >= 256 && model_id < 512)
            {
                Model idkit_model = IdentityKit.cache[model_id - 256].get_head_model();
                if(idkit_model != null)
                    sub_models[model_ptr++] = idkit_model;
            }
            if(model_id >= 512)
            {
                Model item_model = ItemDef.forID(model_id - 512).get_head_model(anInt1702);
                if(item_model != null)
                    sub_models[model_ptr++] = item_model;
            }
        }

        Model model = new Model(model_ptr, sub_models);
        for(int colour_ptr = 0; colour_ptr < 5; colour_ptr++)
            if(appearance_colours[colour_ptr] != 0)
            {
                model.recolour(client.PLAYER_BODY_RECOLOURS[colour_ptr][0], client.PLAYER_BODY_RECOLOURS[colour_ptr][appearance_colours[colour_ptr]]);
                if(colour_ptr == 1)
                    model.recolour(client.SKIN_COLOURS[0], client.SKIN_COLOURS[appearance_colours[colour_ptr]]);
            }

        return model;
    }

    Player()
    {
        aLong1697 = -1L;
        aBoolean1699 = false;
        appearance_colours = new int[5];
        visible = false;
        anInt1715 = 9;
        appearance_models = new int[12];
    }

    private long aLong1697;
    public EntityDef desc;
    boolean aBoolean1699;
    final int[] appearance_colours;
    public int team;
    private int anInt1702;
    public String name;
    static MRUNodes mruNodes = new MRUNodes(260);
    public int combatLevel;
    public int headIcon;
    public int anInt1707;
    int anInt1708;
    int anInt1709;
    boolean visible;
    int anInt1711;
    int anInt1712;
    int anInt1713;
    Model aModel_1714;
    private int anInt1715;
    public final int[] appearance_models;
    private long aLong1718;
    int anInt1719;
    int anInt1720;
    int anInt1721;
    int anInt1722;
    int skill;

}
