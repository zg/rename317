
public class Class10
{
    private static int anInt181 = 268;
    public static int anInt182;
    public static Class10[] aClass10Array183;
    public int anInt184;
    public int[] anIntArray185;
    public int[] anIntArray186;
    public int[] anIntArray187;
    public int anInt188 = -1;
    public int[] anIntArray189;
    public int anInt190;
    public int anInt191 = 5;
    public int anInt192 = -1;
    public int anInt193 = -1;
    public int anInt194 = 99;
    public static int anInt195;
    
    public static void method136(Class34 arg0, int arg1) {
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "seq.dat"),
				    (byte) 63);
	if (arg1 == -47511) {
	    anInt182 = class33_sub2_sub3.method344();
	    if (aClass10Array183 == null)
		aClass10Array183 = new Class10[anInt182];
	    for (int i = 0; i < anInt182; i++) {
		if (aClass10Array183[i] == null)
		    aClass10Array183[i] = new Class10();
		aClass10Array183[i].method137((byte) 4, class33_sub2_sub3);
	    }
	}
    }
    
    public void method137(byte arg0, Class33_Sub2_Sub3 arg1) {
	if (arg0 == 4) {
	    boolean flag = false;
	} else
	    anInt181 = -49;
	for (;;) {
	    int i = arg1.method342();
	    if (i == 0)
		break;
	    if (i == 1) {
		anInt184 = arg1.method342();
		anIntArray185 = new int[anInt184];
		anIntArray186 = new int[anInt184];
		anIntArray187 = new int[anInt184];
		for (int i1 = 0; i1 < anInt184; i1++) {
		    anIntArray185[i1] = arg1.method344();
		    anIntArray186[i1] = arg1.method344();
		    if (anIntArray186[i1] == 65535)
			anIntArray186[i1] = -1;
		    anIntArray187[i1] = arg1.method344();
		    if (anIntArray187[i1] == 0)
			anIntArray187[i1] = (Class9.aClass9Array173
					     [anIntArray185[i1]].anInt174);
		    if (anIntArray187[i1] == 0)
			anIntArray187[i1] = 1;
		}
	    } else if (i == 2)
		anInt188 = arg1.method344();
	    else if (i == 3) {
		int i2 = arg1.method342();
		anIntArray189 = new int[i2 + 1];
		for (int i3 = 0; i3 < i2; i3++)
		    anIntArray189[i3] = arg1.method342();
		anIntArray189[i2] = 9999999;
	    } else if (i == 4)
		anInt190 = arg1.method344();
	    else if (i == 5)
		anInt191 = arg1.method342();
	    else if (i == 6)
		anInt192 = arg1.method344();
	    else if (i == 7)
		anInt193 = arg1.method344();
	    else if (i == 8)
		anInt194 = arg1.method342();
	    else
		System.out.println("Error unrecognised seq config code: " + i);
	}
	if (anInt184 == 0) {
	    anInt184 = 1;
	    anIntArray185 = new int[1];
	    anIntArray185[0] = -1;
	    anIntArray186 = new int[1];
	    anIntArray186[0] = -1;
	    anIntArray187 = new int[1];
	    anIntArray187[0] = -1;
	}
    }
}
