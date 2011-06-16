



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
            if(client.currentTime >= anInt1708)
                aModel_1714 = null;
            if(client.currentTime >= anInt1707 && client.currentTime < anInt1708)
            {
                Model model_1 = aModel_1714;
                model_1.translate(anInt1711 - super.boundExtentX, anInt1712 - anInt1709, anInt1713 - super.boundExtentY);
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
                model_1.translate(super.boundExtentX - anInt1711, anInt1709 - anInt1712, super.boundExtentY - anInt1713);
            }
        }
        model.aBoolean1659 = true;
        return model;
    }

    public void updatePlayer(Packet stream)
    {
        stream.pos = 0;
        playerGender = stream.g1();
        headIcon = stream.g1();
        desc = null;
        team = 0;
        for(int j = 0; j < 12; j++)
        {
            int k = stream.g1();
            if(k == 0)
            {
                appearanceModels[j] = 0;
                continue;
            }
            int i1 = stream.g1();
            appearanceModels[j] = (k << 8) + i1;
            if(j == 0 && appearanceModels[0] == 65535)
            {
                desc = EntityDef.forID(stream.g2());
                break;
            }
            if(appearanceModels[j] >= 512 && appearanceModels[j] - 512 < ItemDef.totalItems)
            {
                int l1 = ItemDef.forID(appearanceModels[j] - 512).team;
                if(l1 != 0)
                    team = l1;
            }
        }

        for(int l = 0; l < 5; l++)
        {
            int j1 = stream.g1();
            if(j1 < 0 || j1 >= client.playerBodyRecolours[l].length)
                j1 = 0;
            appearanceColours[l] = j1;
        }

        super.anInt1511 = stream.g2();
        if(super.anInt1511 == 65535)
            super.anInt1511 = -1;
        super.anInt1512 = stream.g2();
        if(super.anInt1512 == 65535)
            super.anInt1512 = -1;
        super.anInt1554 = stream.g2();
        if(super.anInt1554 == 65535)
            super.anInt1554 = -1;
        super.anInt1555 = stream.g2();
        if(super.anInt1555 == 65535)
            super.anInt1555 = -1;
        super.anInt1556 = stream.g2();
        if(super.anInt1556 == 65535)
            super.anInt1556 = -1;
        super.anInt1557 = stream.g2();
        if(super.anInt1557 == 65535)
            super.anInt1557 = -1;
        super.anInt1505 = stream.g2();
        if(super.anInt1505 == 65535)
            super.anInt1505 = -1;
        name = TextClass.fixName(TextClass.nameForLong(stream.g8()));
        combatLevel = stream.g1();
        skill = stream.g2();
        visible = true;
        aLong1718 = 0L;
        for(int k1 = 0; k1 < 12; k1++)
        {
            aLong1718 <<= 4;
            if(appearanceModels[k1] >= 256)
                aLong1718 += appearanceModels[k1] - 256;
        }

        if(appearanceModels[0] >= 256)
            aLong1718 += appearanceModels[0] - 256 >> 4;
        if(appearanceModels[1] >= 256)
            aLong1718 += appearanceModels[1] - 256 >> 8;
        for(int i2 = 0; i2 < 5; i2++)
        {
            aLong1718 <<= 3;
            aLong1718 += appearanceColours[i2];
        }

        aLong1718 <<= 1;
        aLong1718 += playerGender;
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
                l += j1 - appearanceModels[5] << 40;
            }
            if(animation.anInt361 >= 0)
            {
                k1 = animation.anInt361;
                l += k1 - appearanceModels[3] << 48;
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
                int k2 = appearanceModels[i2];
                if(k1 >= 0 && i2 == 3)
                    k2 = k1;
                if(j1 >= 0 && i2 == 5)
                    k2 = j1;
                if(k2 >= 256 && k2 < 512 && !IdentityKit.cache[k2 - 256].isBodyDownloaded())
                    flag = true;
                if(k2 >= 512 && !ItemDef.forID(k2 - 512).areEquipModelsDownloaded(playerGender))
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
                int i3 = appearanceModels[l2];
                if(k1 >= 0 && l2 == 3)
                    i3 = k1;
                if(j1 >= 0 && l2 == 5)
                    i3 = j1;
                if(i3 >= 256 && i3 < 512)
                {
                    Model model_3 = IdentityKit.cache[i3 - 256].getBodyModel();
                    if(model_3 != null)
                        aclass30_sub2_sub4_sub6s[j2++] = model_3;
                }
                if(i3 >= 512)
                {
                    Model model_4 = ItemDef.forID(i3 - 512).method196(playerGender);
                    if(model_4 != null)
                        aclass30_sub2_sub4_sub6s[j2++] = model_4;
                }
            }

            model_1 = new Model(j2, aclass30_sub2_sub4_sub6s);
            for(int j3 = 0; j3 < 5; j3++)
                if(appearanceColours[j3] != 0)
                {
                    model_1.recolour(client.playerBodyRecolours[j3][0], client.playerBodyRecolours[j3][appearanceColours[j3]]);
                    if(j3 == 1)
                        model_1.recolour(client.skinColours[0], client.skinColours[appearanceColours[j3]]);
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
            model_2.mixAnimationFrames(Animation.anims[super.animation].animationFlowControl, i1, k);
        else
        if(k != -1)
            model_2.applyTransform(k);
        model_2.calculateDiagonals();
        model_2.triangleSkin = null;
        model_2.vertexSkin = null;
        return model_2;
    }

    public boolean isVisible()
    {
        return visible;
    }

    public int privelage;
	public Model getHeadModel()
    {
        if(!visible)
            return null;
        if(desc != null)
            return desc.getHeadModel();
        boolean isDownloaded = false;
        for(int i = 0; i < 12; i++)
        {
            int j = appearanceModels[i];
            if(j >= 256 && j < 512 && !IdentityKit.cache[j - 256].isHeadDownloaded())
                isDownloaded = true;
            if(j >= 512 && !ItemDef.forID(j - 512).areHeadModelsDownloaded(playerGender))
                isDownloaded = true;
        }

        if(isDownloaded)
            return null;
        Model subModels[] = new Model[12];
        int modelPointer = 0;
        for(int ptr = 0; ptr < 12; ptr++)
        {
            int modelID = appearanceModels[ptr];
            if(modelID >= 256 && modelID < 512)
            {
                Model idkitModel = IdentityKit.cache[modelID - 256].getHeadModel();
                if(idkitModel != null)
                    subModels[modelPointer++] = idkitModel;
            }
            if(modelID >= 512)
            {
                Model itemModel = ItemDef.forID(modelID - 512).getHeadModel(playerGender);
                if(itemModel != null)
                    subModels[modelPointer++] = itemModel;
            }
        }

        Model model = new Model(modelPointer, subModels);
        for(int colourPointer = 0; colourPointer < 5; colourPointer++)
            if(appearanceColours[colourPointer] != 0)
            {
                model.recolour(client.playerBodyRecolours[colourPointer][0], client.playerBodyRecolours[colourPointer][appearanceColours[colourPointer]]);
                if(colourPointer == 1)
                    model.recolour(client.skinColours[0], client.skinColours[appearanceColours[colourPointer]]);
            }

        return model;
    }

    Player()
    {
        aLong1697 = -1L;
        aBoolean1699 = false;
        appearanceColours = new int[5];
        visible = false;
        //anInt1715 = 9;//never used
        appearanceModels = new int[12];
    }

    private long aLong1697;
    public EntityDef desc;
    boolean aBoolean1699;
    final int[] appearanceColours;
    public int team;
    private int playerGender;//gender in 0 or 1 
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
    //private int anInt1715;//never used
    public final int[] appearanceModels;
    private long aLong1718;
    int anInt1719;
    int anInt1720;
    int anInt1721;
    int anInt1722;
    int skill;

}
