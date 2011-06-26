
final class Class33_Sub7_Sub3 extends Class33_Sub7
{
    private boolean aBoolean1181 = true;
    private Class12 aClass12_1182;
    public int anInt1183;
    public int anInt1184;
    public int anInt1185;
    public int anInt1186;
    public int anInt1187;
    public int anInt1188;
    public int anInt1189;
    public int anInt1190;
    public int anInt1191;
    public int anInt1192;
    public boolean aBoolean1193 = false;
    public double aDouble1194;
    public double aDouble1195;
    public double aDouble1196;
    private double aDouble1197;
    private double aDouble1198;
    private double aDouble1199;
    private double aDouble1200;
    private double aDouble1201;
    public int anInt1202;
    public int anInt1203;
    private int anInt1204;
    private int anInt1205;
    
    public Class33_Sub7_Sub3(int arg0, int arg1, int arg2, boolean arg3,
			     int arg4, int arg5, int arg6, int arg7, int arg8,
			     int arg9, int arg10, int arg11) {
	aClass12_1182 = Class12.aClass12Array208[arg6];
	anInt1183 = arg0;
	anInt1184 = arg2;
	if (!arg3) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	anInt1185 = arg9;
	anInt1186 = arg5;
	anInt1188 = arg7;
	anInt1189 = arg10;
	anInt1190 = arg4;
	anInt1191 = arg1;
	anInt1192 = arg11;
	anInt1187 = arg8;
	aBoolean1193 = false;
    }
    
    public final void method368(int arg0, int arg1, int arg2, int arg3,
				int arg4) {
	if (arg3 > 0) {
	    if (!aBoolean1193) {
		double d = (double) (arg2 - anInt1184);
		double d1 = (double) (arg0 - anInt1185);
		double d2 = Math.sqrt(d * d + d1 * d1);
		aDouble1194 = (double) anInt1184 + d * (double) anInt1191 / d2;
		aDouble1195
		    = (double) anInt1185 + d1 * (double) anInt1191 / d2;
		aDouble1196 = (double) anInt1186;
	    }
	    double d = (double) (anInt1189 + 1 - arg4);
	    aDouble1197 = ((double) arg2 - aDouble1194) / d;
	    aDouble1198 = ((double) arg0 - aDouble1195) / d;
	    aDouble1199 = Math.sqrt(aDouble1197 * aDouble1197
				    + aDouble1198 * aDouble1198);
	    if (!aBoolean1193)
		aDouble1200
		    = -aDouble1199 * Math.tan((double) anInt1190 * 0.02454369);
	    aDouble1201 = 2.0 * ((double) arg1 - aDouble1196
				 - aDouble1200 * d) / (d * d);
	}
    }
    
    public final void method369(int arg0, int arg1) {
	aBoolean1193 = true;
	aDouble1194 += aDouble1197 * (double) arg1;
	aDouble1195 += aDouble1198 * (double) arg1;
	aDouble1196 += (aDouble1200 * (double) arg1
			+ 0.5 * aDouble1201 * (double) arg1 * (double) arg1);
	aDouble1200 += aDouble1201 * (double) arg1;
	if (arg0 == 0) {
	    anInt1202 = ((int) (Math.atan2(aDouble1197, aDouble1198) * 325.949)
			 + 1024) & 0x7ff;
	    anInt1203 = ((int) (Math.atan2(aDouble1200, aDouble1199) * 325.949)
			 & 0x7ff);
	    if (aClass12_1182.aClass10_211 != null) {
		anInt1205 += arg1;
		while (anInt1205
		       > aClass12_1182.aClass10_211.anIntArray187[anInt1204]) {
		    anInt1205
			-= (aClass12_1182.aClass10_211.anIntArray187[anInt1204]
			    + 1);
		    anInt1204++;
		    if (anInt1204 >= aClass12_1182.aClass10_211.anInt184)
			anInt1204 = 0;
		}
	    }
	}
    }
    
    public final Class33_Sub2_Sub1 method358(int arg0) {
	Class33_Sub2_Sub1 class33_sub2_sub1 = aClass12_1182.method140();
	Class33_Sub2_Sub1 class33_sub2_sub1_1
	    = new Class33_Sub2_Sub1(true, !aClass12_1182.aBoolean212,
				    class33_sub2_sub1, 440, true, false);
	if (aClass12_1182.aClass10_211 != null) {
	    class33_sub2_sub1_1.method265(0);
	    class33_sub2_sub1_1.method266(false, (aClass12_1182.aClass10_211
						  .anIntArray185[anInt1204]));
	    class33_sub2_sub1_1.anIntArrayArray1038 = null;
	    class33_sub2_sub1_1.anIntArrayArray1037 = null;
	}
	class33_sub2_sub1_1.method270(anInt1203, -937);
	class33_sub2_sub1_1.method275(64, 850, -30, -50, -30, true);
	if (arg0 != 0)
	    throw new NullPointerException();
	return class33_sub2_sub1_1;
    }
}
