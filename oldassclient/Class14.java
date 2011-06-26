
public class Class14
{
    public static int anInt242;
    public static Class14[] aClass14Array243;
    public static int anInt244;
    public static int[] anIntArray245;
    public String aString246;
    public int anInt247;
    public int anInt248;
    public boolean aBoolean249 = false;
    public boolean aBoolean250 = true;
    public int anInt251;
    
    public static void method141(Class34 arg0, int arg1) {
	if (arg1 == -47511) {
	    Class33_Sub2_Sub3 class33_sub2_sub3
		= new Class33_Sub2_Sub3(arg0.method371(0, null, "varp.dat"),
					(byte) 63);
	    anInt244 = 0;
	    anInt242 = class33_sub2_sub3.method344();
	    if (aClass14Array243 == null)
		aClass14Array243 = new Class14[anInt242];
	    if (anIntArray245 == null)
		anIntArray245 = new int[anInt242];
	    for (int i = 0; i < anInt242; i++) {
		if (aClass14Array243[i] == null)
		    aClass14Array243[i] = new Class14();
		aClass14Array243[i].method142(class33_sub2_sub3, i, 0);
	    }
	}
    }
    
    public void method142(Class33_Sub2_Sub3 arg0, int arg1, int arg2) {
	if (arg2 == 0) {
	    for (;;) {
		int i = arg0.method342();
		if (i == 0)
		    break;
		if (i == 1)
		    anInt247 = arg0.method342();
		else if (i == 2)
		    anInt248 = arg0.method342();
		else if (i == 3) {
		    aBoolean249 = true;
		    anIntArray245[anInt244++] = arg1;
		} else if (i == 4)
		    aBoolean250 = false;
		else if (i == 5)
		    anInt251 = arg0.method344();
		else if (i == 10)
		    aString246 = arg0.method349();
		else
		    System.out.println("Error unrecognised config code: " + i);
	    }
	}
    }
}
