package rs2;


public class Npc extends Mobile
{

    private Model method450()
    {
        if(super.animation >= 0 && super.anInt1529 == 0)
        {
            int k = Sequence.anims[super.animation].frame2IDS[super.anInt1527];
            int i1 = -1;
            if(super.anInt1517 >= 0 && super.anInt1517 != super.standAnimIndex)
                i1 = Sequence.anims[super.anInt1517].frame2IDS[super.anInt1518];
            return desc.method164(i1, k, Sequence.anims[super.animation].animationFlowControl);
        }
        int l = -1;
        if(super.anInt1517 >= 0)
            l = Sequence.anims[super.anInt1517].frame2IDS[super.anInt1518];
        return desc.method164(-1, l, null);
    }

    public Model getRotatedModel()
    {
        if(desc == null)
            return null;
        Model model = method450();
        if(model == null)
            return null;
        super.height = model.modelHeight;
        if(super.anInt1520 != -1 && super.anInt1521 != -1)
        {
            SpotAnim spotAnim = SpotAnim.cache[super.anInt1520];
            Model model_1 = spotAnim.getModel();
            if(model_1 != null)
            {
                int j = spotAnim.animationSequence.frame2IDS[super.anInt1521];
                Model model_2 = new Model(true, Animation.isNullFrame(j), false, model_1);
                model_2.translate(0, -super.anInt1524, 0);
                model_2.createBones();
                model_2.applyTransform(j);
                model_2.triangleSkin = null;
                model_2.vertexSkin = null;
                if(spotAnim.resizeXY != 128 || spotAnim.resizeZ != 128)
                    model_2.scaleT(spotAnim.resizeXY, spotAnim.resizeXY, spotAnim.resizeZ);
                model_2.light(64 + spotAnim.modelBrightness, 850 + spotAnim.modelShadow, -30, -50, -30, true);
                Model aModel[] = {
                        model, model_2
                };
                model = new Model(aModel);
            }
        }
        if(desc.aByte68 == 1)
            model.aBoolean1659 = true;
        return model;
    }

    public boolean isVisible()
    {
        return desc != null;
    }

    Npc()
    {
    }

    public NpcDef desc;
}
