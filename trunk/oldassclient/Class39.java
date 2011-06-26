
final class Class39
{
    private static boolean aBoolean587;
    private static boolean aBoolean588 = true;
    private static boolean aBoolean589;
    private int anInt590 = 8;
    private static byte aByte591 = 2;
    private static int anInt592;
    private static int[] anIntArray593;
    private static Class33_Sub2_Sub3 aClass33_Sub2_Sub3_594;
    private static Class39[] aClass39Array595;
    private static int anInt596;
    public int anInt597 = -1;
    private int anInt598;
    public String aString599;
    public byte[] aByteArray600;
    private int[] anIntArray601;
    private int[] anIntArray602;
    public int anInt603;
    public int anInt604;
    public int anInt605;
    private int anInt606;
    private int anInt607;
    private int anInt608;
    private boolean aBoolean609;
    public int anInt610;
    public boolean aBoolean611;
    public int anInt612;
    public boolean aBoolean613;
    public String[] aStringArray614;
    public String[] aStringArray615;
    private int anInt616;
    private int anInt617;
    private byte aByte618;
    private int anInt619;
    private int anInt620;
    private byte aByte621;
    private int anInt622;
    public int anInt623;
    public int anInt624;
    public int anInt625;
    public static Class29 aClass29_626 = new Class29(-947, 50);
    static Class29 aClass29_627 = new Class29(-947, 200);
    
    public static final void method393(Class34 arg0) {
	aClass33_Sub2_Sub3_594
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "obj.dat"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "obj.idx"),
				    (byte) 63);
	anInt592 = class33_sub2_sub3.method344();
	anIntArray593 = new int[anInt592];
	int i = 2;
	for (int i1 = 0; i1 < anInt592; i1++) {
	    anIntArray593[i1] = i;
	    i += class33_sub2_sub3.method344();
	}
	aClass39Array595 = new Class39[10];
	for (int i2 = 0; i2 < 10; i2++)
	    aClass39Array595[i2] = new Class39();
    }
    
    public static final void method394(int arg0) {
	aClass29_626 = null;
	aClass29_627 = null;
	anIntArray593 = null;
	arg0 = 23 / arg0;
	aClass39Array595 = null;
	aClass33_Sub2_Sub3_594 = null;
    }
    
    public static final Class39 method395(int arg0) {
	for (int i = 0; i < 10; i++) {
	    if (aClass39Array595[i].anInt597 == arg0)
		return aClass39Array595[i];
	}
	anInt596 = (anInt596 + 1) % 10;
	Class39 class39 = aClass39Array595[anInt596];
	aClass33_Sub2_Sub3_594.anInt1108 = anIntArray593[arg0];
	class39.anInt597 = arg0;
	class39.method396();
	class39.method397((byte) 4, aClass33_Sub2_Sub3_594);
	return class39;
    }
    
    public final void method396() {
	anInt598 = 0;
	aString599 = null;
	aByteArray600 = null;
	anIntArray601 = null;
	anIntArray602 = null;
	anInt603 = 2000;
	anInt604 = 0;
	anInt605 = 0;
	anInt606 = 0;
	anInt607 = 0;
	anInt608 = 0;
	aBoolean609 = false;
	anInt610 = -1;
	aBoolean611 = false;
	anInt612 = 1;
	aBoolean613 = false;
	aStringArray614 = null;
	aStringArray615 = null;
	anInt616 = -1;
	anInt617 = -1;
	aByte618 = (byte) 0;
	anInt619 = -1;
	anInt620 = -1;
	aByte621 = (byte) 0;
	anInt622 = -1;
	anInt623 = -1;
	anInt624 = -1;
	anInt625 = -1;
    }
    
    public final void method397(byte arg0, Class33_Sub2_Sub3 arg1) {
	if (arg0 != 4)
	    aBoolean587 = !aBoolean587;
	for (;;) {
	    int i = arg1.method342();
	    if (i == 0)
		break;
	    if (i == 1)
		anInt598 = arg1.method344();
	    else if (i == 2)
		aString599 = arg1.method349();
	    else if (i == 3)
		aByteArray600 = arg1.method350((byte) 2);
	    else if (i == 4)
		anInt603 = arg1.method344();
	    else if (i == 5)
		anInt604 = arg1.method344();
	    else if (i == 6)
		anInt605 = arg1.method344();
	    else if (i == 7) {
		anInt607 = arg1.method344();
		if (anInt607 > 32767)
		    anInt607 -= 65536;
	    } else if (i == 8) {
		anInt608 = arg1.method344();
		if (anInt608 > 32767)
		    anInt608 -= 65536;
	    } else if (i == 9)
		aBoolean609 = true;
	    else if (i == 10)
		anInt610 = arg1.method344();
	    else if (i == 11)
		aBoolean611 = true;
	    else if (i == 12)
		anInt612 = arg1.method347();
	    else if (i == 16)
		aBoolean613 = true;
	    else if (i == 23) {
		anInt616 = arg1.method344();
		aByte618 = arg1.method343();
	    } else if (i == 24)
		anInt617 = arg1.method344();
	    else if (i == 25) {
		anInt619 = arg1.method344();
		aByte621 = arg1.method343();
	    } else if (i == 26)
		anInt620 = arg1.method344();
	    else if (i >= 30 && i < 35) {
		if (aStringArray614 == null)
		    aStringArray614 = new String[5];
		aStringArray614[i - 30] = arg1.method349();
	    } else if (i >= 35 && i < 40) {
		if (aStringArray615 == null)
		    aStringArray615 = new String[5];
		aStringArray615[i - 35] = arg1.method349();
	    } else if (i == 40) {
		int i1 = arg1.method342();
		anIntArray601 = new int[i1];
		anIntArray602 = new int[i1];
		for (int i2 = 0; i2 < i1; i2++) {
		    anIntArray601[i2] = arg1.method344();
		    anIntArray602[i2] = arg1.method344();
		}
	    } else if (i == 90)
		anInt622 = arg1.method344();
	    else if (i == 91)
		anInt624 = arg1.method344();
	    else if (i == 92)
		anInt623 = arg1.method344();
	    else if (i == 93)
		anInt625 = arg1.method344();
	    else if (i == 95)
		anInt606 = arg1.method344();
	}
    }
    
    public final Class33_Sub2_Sub1 method398() {
	Class33_Sub2_Sub1 class33_sub2_sub1
	    = (Class33_Sub2_Sub1) aClass29_626.method250((long) anInt597);
	if (class33_sub2_sub1 != null)
	    return class33_sub2_sub1;
	class33_sub2_sub1 = new Class33_Sub2_Sub1(anInt598, aBoolean589);
	if (anIntArray601 != null) {
	    for (int i = 0; i < anIntArray601.length; i++)
		class33_sub2_sub1.method272(anIntArray601[i],
					    anIntArray602[i]);
	}
	class33_sub2_sub1.method275(64, 768, -50, -10, -50, true);
	aClass29_626.method251(class33_sub2_sub1, (long) anInt597, aByte591);
	return class33_sub2_sub1;
    }
    
    public static final Class33_Sub2_Sub2_Sub2 method399(int arg0, int arg1) {
	Class33_Sub2_Sub2_Sub2 class33_sub2_sub2_sub2
	    = (Class33_Sub2_Sub2_Sub2) aClass29_627.method250((long) arg0);
	if (class33_sub2_sub2_sub2 != null)
	    return class33_sub2_sub2_sub2;
	Class39 class39 = method395(arg0);
	class33_sub2_sub2_sub2 = new Class33_Sub2_Sub2_Sub2(32, 32, 0);
	int i = Class33_Sub2_Sub2_Sub1.anInt1214;
	int i1 = Class33_Sub2_Sub2_Sub1.anInt1215;
	int[] ints = Class33_Sub2_Sub2_Sub1.anIntArray1220;
	int[] ints2 = Class33_Sub2_Sub2.anIntArray1089;
	int i3 = Class33_Sub2_Sub2.anInt1090;
	int i4 = Class33_Sub2_Sub2.anInt1091;
	Class33_Sub2_Sub2_Sub1.aBoolean1212 = false;
	Class33_Sub2_Sub2.method284(aBoolean588, 32,
				    class33_sub2_sub2_sub2.anIntArray1236, 32);
	Class33_Sub2_Sub2.method288(0, 32, 0, false, 32, 0);
	Class33_Sub2_Sub2_Sub1.method293((byte) -111);
	Class33_Sub2_Sub1 class33_sub2_sub1 = class39.method398();
	int i5 = ((Class33_Sub2_Sub2_Sub1.anIntArray1218[class39.anInt604]
		   * class39.anInt603)
		  >> 16);
	int i6 = ((Class33_Sub2_Sub2_Sub1.anIntArray1219[class39.anInt604]
		   * class39.anInt603)
		  >> 16);
	class33_sub2_sub1.method278((i5 + class33_sub2_sub1.anInt1030 / 2
				     + class39.anInt608),
				    i6 + class39.anInt608, class39.anInt607, 0,
				    0, class39.anInt606, class39.anInt604,
				    class39.anInt605);
	for (int i7 = 31; i7 >= 0; i7--) {
	    for (i6 = 31; i6 >= 0; i6--) {
		if (class33_sub2_sub2_sub2.anIntArray1236[i7 + i6 * 32] == 0) {
		    if (i7 > 0 && (class33_sub2_sub2_sub2.anIntArray1236
				   [i7 - 1 + i6 * 32]) > 1)
			class33_sub2_sub2_sub2.anIntArray1236[i7 + i6 * 32]
			    = 1;
		    else if (i6 > 0 && (class33_sub2_sub2_sub2.anIntArray1236
					[i7 + (i6 - 1) * 32]) > 1)
			class33_sub2_sub2_sub2.anIntArray1236[i7 + i6 * 32]
			    = 1;
		    else if (i7 < 31 && (class33_sub2_sub2_sub2.anIntArray1236
					 [i7 + 1 + i6 * 32]) > 1)
			class33_sub2_sub2_sub2.anIntArray1236[i7 + i6 * 32]
			    = 1;
		    else if (i6 < 31 && (class33_sub2_sub2_sub2.anIntArray1236
					 [i7 + (i6 + 1) * 32]) > 1)
			class33_sub2_sub2_sub2.anIntArray1236[i7 + i6 * 32]
			    = 1;
		}
	    }
	}
	for (int i8 = 31; i8 >= 0; i8--) {
	    for (i6 = 31; i6 >= 0; i6--) {
		if (class33_sub2_sub2_sub2.anIntArray1236[i8 + i6 * 32] == 0
		    && i8 > 0 && i6 > 0
		    && (class33_sub2_sub2_sub2.anIntArray1236
			[i8 - 1 + (i6 - 1) * 32]) > 0)
		    class33_sub2_sub2_sub2.anIntArray1236[i8 + i6 * 32]
			= 3153952;
	    }
	}
	aClass29_627.method251(class33_sub2_sub2_sub2, (long) arg0, aByte591);
	Class33_Sub2_Sub2.method284(aBoolean588, i3, ints2, i4);
	Class33_Sub2_Sub2_Sub1.anInt1214 = i;
	Class33_Sub2_Sub2_Sub1.anInt1215 = i1;
	Class33_Sub2_Sub2_Sub1.anIntArray1220 = ints;
	Class33_Sub2_Sub2_Sub1.aBoolean1212 = true;
	if (arg1 != -25063) {
	    for (int i9 = 1; i9 > 0; i9++) {
	    }
	}
	if (class39.aBoolean611)
	    class33_sub2_sub2_sub2.anInt1241 = 33;
	else
	    class33_sub2_sub2_sub2.anInt1241 = 32;
	return class33_sub2_sub2_sub2;
    }
    
    public final Class33_Sub2_Sub1 method400(int arg0, byte arg1) {
	int i = anInt616;
	if (arg0 == 1)
	    i = anInt619;
	if (i == -1)
	    return null;
	int i1 = anInt617;
	if (arg1 == 1) {
	    boolean flag = false;
	} else
	    throw new NullPointerException();
	if (arg0 == 1)
	    i1 = anInt620;
	Class33_Sub2_Sub1 class33_sub2_sub1
	    = new Class33_Sub2_Sub1(i, aBoolean589);
	if (i1 != -1) {
	    Class33_Sub2_Sub1 class33_sub2_sub1_2
		= new Class33_Sub2_Sub1(i1, aBoolean589);
	    Class33_Sub2_Sub1[] class33_sub2_sub1s
		= { class33_sub2_sub1, class33_sub2_sub1_2 };
	    class33_sub2_sub1
		= new Class33_Sub2_Sub1(2, false, class33_sub2_sub1s);
	}
	if (arg0 == 0 && aByte618 != 0)
	    class33_sub2_sub1.method271(anInt590, 0, 0, aByte618);
	if (arg0 == 1 && aByte621 != 0)
	    class33_sub2_sub1.method271(anInt590, 0, 0, aByte621);
	if (anIntArray601 != null) {
	    for (int i3 = 0; i3 < anIntArray601.length; i3++)
		class33_sub2_sub1.method272(anIntArray601[i3],
					    anIntArray602[i3]);
	}
	return class33_sub2_sub1;
    }
    
    public final Class33_Sub2_Sub1 method401(int arg0, int arg1) {
	int i = anInt622;
	if (arg1 != -39571)
	    throw new NullPointerException();
	if (arg0 == 1)
	    i = anInt624;
	if (i == -1)
	    return null;
	int i1 = anInt623;
	if (arg0 == 1)
	    i1 = anInt625;
	Class33_Sub2_Sub1 class33_sub2_sub1
	    = new Class33_Sub2_Sub1(i, aBoolean589);
	if (i1 != -1) {
	    Class33_Sub2_Sub1 class33_sub2_sub1_2
		= new Class33_Sub2_Sub1(i1, aBoolean589);
	    Class33_Sub2_Sub1[] class33_sub2_sub1s
		= { class33_sub2_sub1, class33_sub2_sub1_2 };
	    class33_sub2_sub1
		= new Class33_Sub2_Sub1(2, false, class33_sub2_sub1s);
	}
	if (anIntArray601 != null) {
	    for (int i3 = 0; i3 < anIntArray601.length; i3++)
		class33_sub2_sub1.method272(anIntArray601[i3],
					    anIntArray602[i3]);
	}
	return class33_sub2_sub1;
    }
}
