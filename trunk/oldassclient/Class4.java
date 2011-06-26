
public class Class4
{
    private static boolean aBoolean81;
    private static boolean aBoolean82;
    public static int anInt83;
    public static Class4[] aClass4Array84;
    public int anInt85 = -1;
    public int[] anIntArray86;
    public int[] anIntArray87 = new int[6];
    public int[] anIntArray88 = new int[6];
    public int[] anIntArray89 = { -1, -1, -1, -1, -1 };
    
    public static void method121(Class34 arg0, int arg1) {
	if (arg1 != -47511)
	    aBoolean81 = !aBoolean81;
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "idk.dat"),
				    (byte) 63);
	anInt83 = class33_sub2_sub3.method344();
	if (aClass4Array84 == null)
	    aClass4Array84 = new Class4[anInt83];
	for (int i = 0; i < anInt83; i++) {
	    if (aClass4Array84[i] == null)
		aClass4Array84[i] = new Class4();
	    aClass4Array84[i].method122((byte) 4, class33_sub2_sub3);
	}
    }
    
    public void method122(byte arg0, Class33_Sub2_Sub3 arg1) {
	if (arg0 != 4) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	for (;;) {
	    int i = arg1.method342();
	    if (i == 0)
		break;
	    if (i == 1)
		anInt85 = arg1.method342();
	    else if (i == 2) {
		int i1 = arg1.method342();
		anIntArray86 = new int[i1];
		for (int i2 = 0; i2 < i1; i2++)
		    anIntArray86[i2] = arg1.method344();
	    } else if (i >= 40 && i < 50)
		anIntArray87[i - 40] = arg1.method344();
	    else if (i >= 50 && i < 60)
		anIntArray88[i - 50] = arg1.method344();
	    else if (i >= 60 && i < 70)
		anIntArray89[i - 60] = arg1.method344();
	    else
		System.out.println("Error unrecognised config code: " + i);
	}
    }
    
    public Class33_Sub2_Sub1 method123() {
	if (anIntArray86 == null)
	    return null;
	Class33_Sub2_Sub1[] class33_sub2_sub1s
	    = new Class33_Sub2_Sub1[anIntArray86.length];
	for (int i = 0; i < anIntArray86.length; i++)
	    class33_sub2_sub1s[i]
		= new Class33_Sub2_Sub1(anIntArray86[i], aBoolean82);
	Class33_Sub2_Sub1 class33_sub2_sub1;
	if (class33_sub2_sub1s.length == 1)
	    class33_sub2_sub1 = class33_sub2_sub1s[0];
	else
	    class33_sub2_sub1
		= new Class33_Sub2_Sub1(class33_sub2_sub1s.length, false,
					class33_sub2_sub1s);
	for (int i = 0; i < 6; i++) {
	    if (anIntArray87[i] == 0)
		break;
	    class33_sub2_sub1.method272(anIntArray87[i], anIntArray88[i]);
	}
	return class33_sub2_sub1;
    }
    
    public Class33_Sub2_Sub1 method124(int arg0) {
	if (arg0 >= 0)
	    throw new NullPointerException();
	Class33_Sub2_Sub1[] class33_sub2_sub1s = new Class33_Sub2_Sub1[5];
	int i = 0;
	for (int i1 = 0; i1 < 5; i1++) {
	    if (anIntArray89[i1] != -1)
		class33_sub2_sub1s[i++]
		    = new Class33_Sub2_Sub1(anIntArray89[i1], aBoolean82);
	}
	Class33_Sub2_Sub1 class33_sub2_sub1
	    = new Class33_Sub2_Sub1(i, false, class33_sub2_sub1s);
	for (int i2 = 0; i2 < 6; i2++) {
	    if (anIntArray87[i2] == 0)
		break;
	    class33_sub2_sub1.method272(anIntArray87[i2], anIntArray88[i2]);
	}
	return class33_sub2_sub1;
    }
}
