package rs2;


public class Npc extends Mobile
{

    private Model method450()
    {
        if(super.animation >= 0 && super.animationDelay == 0)
        {
            int frameId = Sequence.anims[super.animation].frame2IDS[super.anInt1527];
            int frameId2 = -1;
            if(super.anInt1517 >= 0 && super.anInt1517 != super.standAnimIndex)
                frameId2 = Sequence.anims[super.anInt1517].frame2IDS[super.anInt1518];
            return desc.method164(frameId2, frameId, Sequence.anims[super.animation].animationFlowControl);
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
        if(super.gfxId != -1 && super.currentAnim != -1)
        {
            SpotAnim spotAnim = SpotAnim.cache[super.gfxId];
            Model gfxModel = spotAnim.getModel();
            if(gfxModel != null)
            {
                int frameId = spotAnim.animationSequence.frame2IDS[super.currentAnim];
                Model npcModel = new Model(true, Animation.isNullFrame(frameId), false, gfxModel);
                npcModel.translate(0, -super.graphicHeight, 0);
                npcModel.createBones();
                npcModel.applyTransform(frameId);
                npcModel.triangleSkin = null;
                npcModel.vertexSkin = null;
                if(spotAnim.resizeXY != 128 || spotAnim.resizeZ != 128)
                    npcModel.scaleT(spotAnim.resizeXY, spotAnim.resizeXY, spotAnim.resizeZ);
                npcModel.light(64 + spotAnim.modelBrightness, 850 + spotAnim.modelShadow, -30, -50, -30, true);
                Model fullModel[] = {
                        model, npcModel
                };
                model = new Model(fullModel);
            }
        }
        if(desc.boundDim == 1)
            model.oneSquareModel = true;
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
