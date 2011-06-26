
public class Class12
{
    private static boolean aBoolean204;
    private static boolean aBoolean205;
    private static byte aByte206 = 2;
    public static int anInt207;
    public static Class12[] aClass12Array208;
    public int anInt209;
    public int anInt210;
    public Class10 aClass10_211;
    public boolean aBoolean212 = false;
    public int[] anIntArray213 = new int[6];
    public int[] anIntArray214 = new int[6];
    public static Class29 aClass29_215 = new Class29(-947, 30);
    
    public static void method138(Class34 arg0, int arg1) {
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "spotanim.dat"),
				    (byte) 63);
	anInt207 = class33_sub2_sub3.method344();
	if (aClass12Array208 == null)
	    aClass12Array208 = new Class12[anInt207];
	for (int i = 0; i < anInt207; i++) {
	    if (aClass12Array208[i] == null)
		aClass12Array208[i] = new Class12();
	    aClass12Array208[i].anInt209 = i;
	    aClass12Array208[i].method139((byte) 4, class33_sub2_sub3);
	}
	if (arg1 != -47511)
	    aBoolean204 = !aBoolean204;
    }
    
    public void method139(byte arg0, Class33_Sub2_Sub3 arg1) {
	if (arg0 == 4) {
	    boolean flag = false;
	} else
	    throw new NullPointerException();
	for (;;) {
	    int i = arg1.method342();
	    if (i == 0)
		break;
	    if (i == 1)
		anInt210 = arg1.method344();
	    else if (i == 2)
		aClass10_211 = Class10.aClass10Array183[arg1.method344()];
	    else if (i == 3)
		aBoolean212 = true;
	    else if (i >= 40 && i < 50)
		anIntArray213[i - 40] = arg1.method344();
	    else if (i >= 50 && i < 60)
		anIntArray214[i - 50] = arg1.method344();
	    else
		System.out
		    .println("Error unrecognised spotanim config code: " + i);
	}
    }
    
    public Class33_Sub2_Sub1 method140() {
	Class33_Sub2_Sub1 class33_sub2_sub1
	    = (Class33_Sub2_Sub1) aClass29_215.method250((long) anInt209);
	if (class33_sub2_sub1 != null)
	    return class33_sub2_sub1;
	class33_sub2_sub1 = new Class33_Sub2_Sub1(anInt210, aBoolean205);
	for (int i = 0; i < 6; i++) {
	    if (anIntArray213[0] != 0)
		class33_sub2_sub1.method272(anIntArray213[i],
					    anIntArray214[i]);
	}
	aClass29_215.method251(class33_sub2_sub1, (long) anInt209, aByte206);
	return class33_sub2_sub1;
    }
}
