
public class Class7
{
    public static Class7[] aClass7Array162;
    public int anInt163;
    public int[] anIntArray164;
    public int[][] anIntArrayArray165;
    
    public static void method134(byte arg0, Class34 arg1) {
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg1.method371(0, null, "base_head.dat"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3_1
	    = new Class33_Sub2_Sub3(arg1.method371(0, null, "base_type.dat"),
				    (byte) 63);
	if (arg0 != 4) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	Class33_Sub2_Sub3 class33_sub2_sub3_2
	    = new Class33_Sub2_Sub3(arg1.method371(0, null, "base_label.dat"),
				    (byte) 63);
	int i = class33_sub2_sub3.method344();
	int i3 = class33_sub2_sub3.method344();
	aClass7Array162 = new Class7[i3 + 1];
	for (int i4 = 0; i4 < i; i4++) {
	    int i5 = class33_sub2_sub3.method344();
	    int i6 = class33_sub2_sub3.method342();
	    int[] ints = new int[i6];
	    int[][] is = new int[i6][];
	    for (int i7 = 0; i7 < i6; i7++) {
		ints[i7] = class33_sub2_sub3_1.method342();
		int i8 = class33_sub2_sub3_2.method342();
		is[i7] = new int[i8];
		for (int i9 = 0; i9 < i8; i9++)
		    is[i7][i9] = class33_sub2_sub3_2.method342();
	    }
	    aClass7Array162[i5] = new Class7();
	    aClass7Array162[i5].anInt163 = i6;
	    aClass7Array162[i5].anIntArray164 = ints;
	    aClass7Array162[i5].anIntArrayArray165 = is;
	}
    }
}
