package rs2;


import rs2.model.entity.Entity;

public class Projectile extends Entity {

    public void method455(int currentTime, int offsetX, int drawHeight, int offsetY)
    {
        if(!aBoolean1579)
        {
            double d = offsetY - anInt1580;
            double d2 = offsetX - anInt1581;
            double d3 = Math.sqrt(d * d + d2 * d2);
            aDouble1585 = (double)anInt1580 + (d * (double)radius) / d3;
            aDouble1586 = (double)anInt1581 + (d2 * (double)radius) / d3;
            aDouble1587 = _drawHeight;
        }
        double d1 = (speedTime + 1) - currentTime;
        aDouble1574 = ((double)offsetY - aDouble1585) / d1;
        aDouble1575 = ((double)offsetX - aDouble1586) / d1;
        aDouble1576 = Math.sqrt(aDouble1574 * aDouble1574 + aDouble1575 * aDouble1575);
        if(!aBoolean1579)
            aDouble1577 = -aDouble1576 * Math.tan((double)slope * 0.02454369D);
        aDouble1578 = (2D * ((double)drawHeight - aDouble1587 - aDouble1577 * d1)) / (d1 * d1);
    }

    public Model getRotatedModel()
    {
        Model model = spotAnim.getModel();
        if(model == null)
            return null;
        int frameId = -1;
        if(spotAnim.animationSequence != null)
            frameId = spotAnim.animationSequence.frame2IDS[eclapsedFrames];
        Model model_1 = new Model(true, Animation.isNullFrame(frameId), false, model);
        if(frameId != -1)
        {
            model_1.createBones();
            model_1.applyTransform(frameId);
            model_1.triangleSkin = null;
            model_1.vertexSkin = null;
        }
        if(spotAnim.resizeXY != 128 || spotAnim.resizeZ != 128)
            model_1.scale(spotAnim.resizeXY, spotAnim.resizeZ, spotAnim.resizeXY);
        model_1.method474(anInt1596);
        model_1.light(64 + spotAnim.modelBrightness, 850 + spotAnim.modelShadow, -30, -50, -30, true);
            return model_1;
    }

    public Projectile(int slope_, int endHeight_, int delayTime_, int speedTime_, int radius_, int z,
                         int drawHeight_, int i2, int j2, int lockOn_, int id)
    {
        aBoolean1579 = false;
        spotAnim = SpotAnim.cache[id];
        plane = z;
        anInt1580 = j2;
        anInt1581 = i2;
        _drawHeight = drawHeight_;
        delayTime = delayTime_;
        speedTime = speedTime_;
        slope = slope_;
        radius = radius_;
        lockOn = lockOn_;
        endHeight = endHeight_;
        aBoolean1579 = false;
    }

    public void method456(int timePassed)
    {
        aBoolean1579 = true;
        aDouble1585 += aDouble1574 * (double)timePassed;
        aDouble1586 += aDouble1575 * (double)timePassed;
        aDouble1587 += aDouble1577 * (double)timePassed + 0.5D * aDouble1578 * (double)timePassed * (double)timePassed;
        aDouble1577 += aDouble1578 * (double)timePassed;
        anInt1595 = (int)(Math.atan2(aDouble1574, aDouble1575) * 325.94900000000001D) + 1024 & 0x7ff;
        anInt1596 = (int)(Math.atan2(aDouble1577, aDouble1576) * 325.94900000000001D) & 0x7ff;
        if(spotAnim.animationSequence != null)
            for(duration += timePassed; duration > spotAnim.animationSequence.getFrameLength(eclapsedFrames);)
            {
                duration -= spotAnim.animationSequence.getFrameLength(eclapsedFrames) + 1;
                eclapsedFrames++;
                if(eclapsedFrames >= spotAnim.animationSequence.frameCount)
                    eclapsedFrames = 0;
            }

    }

    public final int delayTime;
    public final int speedTime;
    private double aDouble1574;
    private double aDouble1575;
    private double aDouble1576;
    private double aDouble1577;
    private double aDouble1578;
    private boolean aBoolean1579;
    private final int anInt1580;
    private final int anInt1581;
    private final int _drawHeight;
    public final int endHeight;
    public double aDouble1585;
    public double aDouble1586;
    public double aDouble1587;
    private final int slope;
    private final int radius;
    public final int lockOn;
    private final SpotAnim spotAnim;
    private int eclapsedFrames;
    private int duration;
    public int anInt1595;
    private int anInt1596;
    public final int plane;
}
