
final class Class33_Sub7_Sub1 extends Class33_Sub7
{
    private int anInt1120;
    private Class12 aClass12_1121;
    public int anInt1122;
    public int anInt1123;
    public int anInt1124;
    public int anInt1125;
    public int anInt1126;
    private int anInt1127;
    private int anInt1128;
    public boolean aBoolean1129 = false;
    
    public Class33_Sub7_Sub1(int arg0, int arg1, int arg2, int arg3, int arg4,
			     int arg5, int arg6, int arg7) {
	aClass12_1121 = Class12.aClass12Array208[arg3];
	anInt1123 = arg4;
	anInt1124 = arg5;
	anInt1125 = arg6;
	anInt1126 = arg0;
	anInt1122 = arg7 + arg2;
	if (arg1 != 0)
	    anInt1120 = 47;
	aBoolean1129 = false;
    }
    
    public final void method359(int arg0, int arg1) {
	if (arg1 != 30001) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	anInt1128 += arg0;
	while (anInt1128
	       > aClass12_1121.aClass10_211.anIntArray187[anInt1127]) {
	    anInt1128
		-= aClass12_1121.aClass10_211.anIntArray187[anInt1127] + 1;
	    anInt1127++;
	    if (anInt1127 >= aClass12_1121.aClass10_211.anInt184) {
		anInt1127 = 0;
		aBoolean1129 = true;
	    }
	}
    }
    
    public final Class33_Sub2_Sub1 method358(int arg0) {
	if (arg0 != 0)
	    throw new NullPointerException();
	Class33_Sub2_Sub1 class33_sub2_sub1 = aClass12_1121.method140();
	Class33_Sub2_Sub1 class33_sub2_sub1_1
	    = new Class33_Sub2_Sub1(true, !aClass12_1121.aBoolean212,
				    class33_sub2_sub1, 440, true, false);
	if (!aBoolean1129) {
	    class33_sub2_sub1_1.method265(0);
	    class33_sub2_sub1_1.method266(false, (aClass12_1121.aClass10_211
						  .anIntArray185[anInt1127]));
	    class33_sub2_sub1_1.anIntArrayArray1038 = null;
	    class33_sub2_sub1_1.anIntArrayArray1037 = null;
	}
	class33_sub2_sub1_1.method275(64, 850, -30, -50, -30, true);
	return class33_sub2_sub1_1;
    }
}
