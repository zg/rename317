package rs2;


public class StillGraphic extends Entity {

    public StillGraphic(int z, int j, int l, int i1, int j1, int k1,
                        int l1)
    {
        transformCompleted = false;
        spotAnim = SpotAnim.cache[i1];
        plane = z;
        anInt1561 = l1;
        anInt1562 = k1;
        anInt1563 = j1;
        anInt1564 = j + l;
    }

    public Model getRotatedModel()
    {
        Model model = spotAnim.getModel();
        if(model == null)
            return null;
        int j = spotAnim.animationSequence.frame2IDS[eclapsedFrames];
        Model model_1 = new Model(true, Animation.method532(j), false, model);
        if(!transformCompleted)
        {
            model_1.createBones();
            model_1.applyTransform(j);
            model_1.triangleSkin = null;
            model_1.vertexSkin = null;
        }
        if(spotAnim.resizeXY != 128 || spotAnim.resizeZ != 128)
            model_1.scaleT(spotAnim.resizeXY, spotAnim.resizeXY, spotAnim.resizeZ);
        if(spotAnim.rotation != 0)
        {
            if(spotAnim.rotation == 90)
                model_1.rotateBy90();
            if(spotAnim.rotation == 180)
            {
                model_1.rotateBy90();
                model_1.rotateBy90();
            }
            if(spotAnim.rotation == 270)
            {
                model_1.rotateBy90();
                model_1.rotateBy90();
                model_1.rotateBy90();
            }
        }
        model_1.light(64 + spotAnim.modelBrightness, 850 + spotAnim.modelShadow, -30, -50, -30, true);
        return model_1;
    }

    public void animationStep(int timePassed)
    {
        for(duration += timePassed; duration > spotAnim.animationSequence.getFrameLength(eclapsedFrames);)
        {
            duration -= spotAnim.animationSequence.getFrameLength(eclapsedFrames) + 1;
            eclapsedFrames++;
            if(eclapsedFrames >= spotAnim.animationSequence.frameCount && (eclapsedFrames < 0 || eclapsedFrames >= spotAnim.animationSequence.frameCount))
            {
                eclapsedFrames = 0;
                transformCompleted = true;
            }
        }

    }

    public final int plane;
    public final int anInt1561;
    public final int anInt1562;
    public final int anInt1563;
    public final int anInt1564;
    public boolean transformCompleted;
    private final SpotAnim spotAnim;
    private int eclapsedFrames;
    private int duration;
}
