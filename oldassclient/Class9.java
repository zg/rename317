
public class Class9
{
    private static int anInt172 = -377;
    public static Class9[] aClass9Array173;
    public int anInt174;
    public Class7 aClass7_175;
    public int anInt176;
    public int[] anIntArray177;
    public int[] anIntArray178;
    public int[] anIntArray179;
    public int[] anIntArray180;
    
    public static void method135(byte arg0, Class34 arg1) {
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg1.method371(0, null, "frame_head.dat"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3_1
	    = new Class33_Sub2_Sub3(arg1.method371(0, null, "frame_tran1.dat"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3_2
	    = new Class33_Sub2_Sub3(arg1.method371(0, null, "frame_tran2.dat"),
				    (byte) 63);
	if (arg0 != 4)
	    anInt172 = 85;
	Class33_Sub2_Sub3 class33_sub2_sub3_3
	    = new Class33_Sub2_Sub3(arg1.method371(0, null, "frame_del.dat"),
				    (byte) 63);
	int i = class33_sub2_sub3.method344();
	int i4 = class33_sub2_sub3.method344();
	aClass9Array173 = new Class9[i4 + 1];
	int[] ints = new int[500];
	int[] ints5 = new int[500];
	int[] ints6 = new int[500];
	int[] ints7 = new int[500];
	for (int i8 = 0; i8 < i; i8++) {
	    int i9 = class33_sub2_sub3.method344();
	    Class9 class9 = aClass9Array173[i9] = new Class9();
	    class9.anInt174 = class33_sub2_sub3_3.method342();
	    int i10 = class33_sub2_sub3.method344();
	    Class7 class7 = Class7.aClass7Array162[i10];
	    class9.aClass7_175 = class7;
	    int i11 = class33_sub2_sub3.method342();
	    int i12 = -1;
	    int i13 = 0;
	    for (int i14 = 0; i14 < i11; i14++) {
		int i15 = class33_sub2_sub3_1.method342();
		if (i15 > 0) {
		    if (class7.anIntArray164[i14] != 0) {
			for (int i16 = i14 - 1; i16 > i12; i16--) {
			    if (class7.anIntArray164[i16] == 0) {
				ints[i13] = i16;
				ints5[i13] = 0;
				ints6[i13] = 0;
				ints7[i13] = 0;
				i13++;
				break;
			    }
			}
		    }
		    ints[i13] = i14;
		    int i17 = 0;
		    if (class7.anIntArray164[ints[i13]] == 3)
			i17 = 128;
		    if ((i15 & 0x1) != 0)
			ints5[i13] = class33_sub2_sub3_2.method355();
		    else
			ints5[i13] = i17;
		    if ((i15 & 0x2) != 0)
			ints6[i13] = class33_sub2_sub3_2.method355();
		    else
			ints6[i13] = i17;
		    if ((i15 & 0x4) != 0)
			ints7[i13] = class33_sub2_sub3_2.method355();
		    else
			ints7[i13] = i17;
		    i12 = i14;
		    i13++;
		}
	    }
	    class9.anInt176 = i13;
	    class9.anIntArray177 = new int[i13];
	    class9.anIntArray178 = new int[i13];
	    class9.anIntArray179 = new int[i13];
	    class9.anIntArray180 = new int[i13];
	    for (int i18 = 0; i18 < i13; i18++) {
		class9.anIntArray177[i18] = ints[i18];
		class9.anIntArray178[i18] = ints5[i18];
		class9.anIntArray179[i18] = ints6[i18];
		class9.anIntArray180[i18] = ints7[i18];
	    }
	}
    }
}
