package rt4;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 8/1/11
 * Time: 11:47 AM
 * To change this template use File | Ssettings | File Templates.
 */
public class LightingShit {
    public static float[] aFloatArray3171 = new float[] { 0.073F, 0.169F, 0.24F, 1.0F };
    public static float[] aFloatArray3964 = new float[4];

    public static float[] method1590(boolean arg0) {
    while_1065_:
	do {
	    float f;
	    float f_1_;
	    float f_2_;
	    do {
		float[] fs;
		try {
		    f = AthmosphericEffects.getAmbientModelModifier() + AthmosphericEffects.getLight1Modifier();
		    int i = AthmosphericEffects.getLightModelColour();
		    aFloatArray3964[3] = 1.0F;
		    float f_3_ = (float) (0xff & i >> -67461104) / 255.0F;
		    f_1_ = 0.58823526F;
		    float f_4_ = (float) (i & 0xff) / 255.0F;
		    aFloatArray3964[0] = f * (f_3_ * aFloatArray3171[0] * f_1_);
		    aFloatArray3964[2] = f * (f_1_ * (aFloatArray3171[2] * f_4_));
		    f_2_ = (float) ((0xffc6 & i) >> -1645030520) / 255.0F;
		    if (!arg0)
			break;
		    fs = null;
		} catch (RuntimeException runtimeexception) {
		    break while_1065_;
		}
		return fs;
	    } while (false);
	    float[] fs;
	    try {
		aFloatArray3964[1]
		    = aFloatArray3171[1] * f_2_ * f_1_ * f;
		fs = aFloatArray3964;
	    } catch (RuntimeException runtimeexception) {
		break;
	    }
	    return fs;
	} while (false);
	Throwable throwable = new Throwable();
	throw ErrorHandling.method554(throwable, "z.A(" + arg0 + ')');
    }
}
