
public class Class2
{
    private static int anInt42;
    public static int anInt43;
    public static Class2[] aClass2Array44;
    public int anInt45;
    public int anInt46 = -1;
    public boolean aBoolean47 = false;
    public boolean aBoolean48 = true;
    public String aString49;
    public int anInt50;
    public int anInt51;
    public int anInt52;
    public int anInt53;
    public int anInt54;
    
    public static void method104(Class34 arg0, int arg1) {
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "flo.dat"),
				    (byte) 63);
	anInt43 = class33_sub2_sub3.method344();
	if (aClass2Array44 == null)
	    aClass2Array44 = new Class2[anInt43];
	for (int i = 0; i < anInt43; i++) {
	    if (aClass2Array44[i] == null)
		aClass2Array44[i] = new Class2();
	    aClass2Array44[i].method105((byte) 4, class33_sub2_sub3);
	}
	if (arg1 != -47511) {
	}
    }
    
    public void method105(byte arg0, Class33_Sub2_Sub3 arg1) {
	if (arg0 != 4)
	    anInt42 = -239;
	for (;;) {
	    int i = arg1.method342();
	    if (i == 0)
		break;
	    if (i == 1) {
		anInt45 = arg1.method346();
		method106(anInt45, 40841);
	    } else if (i == 2)
		anInt46 = arg1.method342();
	    else if (i == 3)
		aBoolean47 = true;
	    else if (i == 5)
		aBoolean48 = false;
	    else if (i == 6)
		aString49 = arg1.method349();
	    else
		System.out.println("Error unrecognised config code: " + i);
	}
    }
    
    private void method106(int arg0, int arg1) {
	double d = (double) (arg0 >> 16 & 0xff) / 256.0;
	double d1 = (double) (arg0 >> 8 & 0xff) / 256.0;
	double d2 = (double) (arg0 & 0xff) / 256.0;
	double d3 = d;
	if (d1 < d3)
	    d3 = d1;
	if (d2 < d3)
	    d3 = d2;
	double d4 = d;
	if (d1 > d4)
	    d4 = d1;
	if (d2 > d4)
	    d4 = d2;
	double d5 = 0.0;
	double d6 = 0.0;
	double d7 = (d3 + d4) / 2.0;
	if (d3 != d4) {
	    if (d7 < 0.5)
		d6 = (d4 - d3) / (d4 + d3);
	    if (d7 >= 0.5)
		d6 = (d4 - d3) / (2.0 - d4 - d3);
	    if (d == d4)
		d5 = (d1 - d2) / (d4 - d3);
	    else if (d1 == d4)
		d5 = 2.0 + (d2 - d) / (d4 - d3);
	    else if (d2 == d4)
		d5 = 4.0 + (d - d1) / (d4 - d3);
	}
	d5 /= 6.0;
	anInt50 = (int) (d5 * 256.0);
	anInt51 = (int) (d6 * 256.0);
	if (arg1 != 40841)
	    anInt42 = 443;
	anInt52 = (int) (d7 * 256.0);
	if (anInt51 < 0)
	    anInt51 = 0;
	else if (anInt51 > 255)
	    anInt51 = 255;
	if (anInt52 < 0)
	    anInt52 = 0;
	else if (anInt52 > 255)
	    anInt52 = 255;
	if (d7 > 0.5)
	    anInt54 = (int) ((1.0 - d7) * d6 * 512.0);
	else
	    anInt54 = (int) (d7 * d6 * 512.0);
	if (anInt54 < 1)
	    anInt54 = 1;
	anInt53 = (int) (d5 * (double) anInt54);
    }
}
