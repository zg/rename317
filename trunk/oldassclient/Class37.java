
final class Class37
{
    private static boolean aBoolean518;
    private static byte aByte519 = 2;
    private static int anInt520;
    private static int[] anIntArray521;
    private static Class33_Sub2_Sub3 aClass33_Sub2_Sub3_522;
    private static Class37[] aClass37Array523;
    private static int anInt524;
    private int anInt525 = -1;
    private int[] anIntArray526;
    private int[] anIntArray527;
    public String aString528;
    public byte[] aByteArray529;
    private int[] anIntArray530;
    private int[] anIntArray531;
    public int anInt532;
    public int anInt533;
    public boolean aBoolean534;
    public boolean aBoolean535;
    public boolean aBoolean536;
    private boolean aBoolean537;
    private boolean aBoolean538;
    public boolean aBoolean539;
    public int anInt540;
    public int anInt541;
    private byte aByte542;
    private byte aByte543;
    public String[] aStringArray544;
    private boolean aBoolean545;
    public int anInt546;
    public int anInt547;
    private boolean aBoolean548;
    public boolean aBoolean549;
    private int anInt550;
    private int anInt551;
    private int anInt552;
    public int anInt553;
    public static Class29 aClass29_554 = new Class29(-947, 500);
    public static Class29 aClass29_555 = new Class29(-947, 30);
    
    public static final void method381(Class34 arg0) {
	aClass33_Sub2_Sub3_522
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "loc.dat"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "loc.idx"),
				    (byte) 63);
	anInt520 = class33_sub2_sub3.method344();
	anIntArray521 = new int[anInt520];
	int i = 2;
	for (int i1 = 0; i1 < anInt520; i1++) {
	    anIntArray521[i1] = i;
	    i += class33_sub2_sub3.method344();
	}
	aClass37Array523 = new Class37[10];
	for (int i2 = 0; i2 < 10; i2++)
	    aClass37Array523[i2] = new Class37();
    }
    
    public static final void method382(int arg0) {
	aClass29_554 = null;
	aClass29_555 = null;
	anIntArray521 = null;
	aClass37Array523 = null;
	arg0 = 5 / arg0;
	aClass33_Sub2_Sub3_522 = null;
    }
    
    public static final Class37 method383(int arg0) {
	for (int i = 0; i < 10; i++) {
	    if (aClass37Array523[i].anInt525 == arg0)
		return aClass37Array523[i];
	}
	anInt524 = (anInt524 + 1) % 10;
	Class37 class37 = aClass37Array523[anInt524];
	aClass33_Sub2_Sub3_522.anInt1108 = anIntArray521[arg0];
	class37.anInt525 = arg0;
	class37.method384();
	class37.method385((byte) 4, aClass33_Sub2_Sub3_522);
	return class37;
    }
    
    private final void method384() {
	anIntArray526 = null;
	anIntArray527 = null;
	aString528 = null;
	aByteArray529 = null;
	anIntArray530 = null;
	anIntArray531 = null;
	anInt532 = 1;
	anInt533 = 1;
	aBoolean534 = true;
	aBoolean535 = true;
	aBoolean536 = false;
	aBoolean537 = false;
	aBoolean538 = false;
	aBoolean539 = false;
	anInt540 = -1;
	anInt541 = 16;
	aByte542 = (byte) 0;
	aByte543 = (byte) 0;
	aStringArray544 = null;
	aBoolean545 = false;
	anInt546 = -1;
	anInt547 = -1;
	aBoolean548 = false;
	aBoolean549 = true;
	anInt550 = 128;
	anInt551 = 128;
	anInt552 = 128;
	anInt553 = 0;
    }
    
    private final void method385(byte arg0, Class33_Sub2_Sub3 arg1) {
	if (arg0 != 4)
	    throw new NullPointerException();
	int i = -1;
	for (;;) {
	    int i1 = arg1.method342();
	    if (i1 == 0)
		break;
	    if (i1 == 1) {
		int i2 = arg1.method342();
		anIntArray527 = new int[i2];
		anIntArray526 = new int[i2];
		for (int i3 = 0; i3 < i2; i3++) {
		    anIntArray526[i3] = arg1.method344();
		    anIntArray527[i3] = arg1.method342();
		}
	    } else if (i1 == 2)
		aString528 = arg1.method349();
	    else if (i1 == 3)
		aByteArray529 = arg1.method350((byte) 2);
	    else if (i1 == 14)
		anInt532 = arg1.method342();
	    else if (i1 == 15)
		anInt533 = arg1.method342();
	    else if (i1 == 17)
		aBoolean534 = false;
	    else if (i1 == 18)
		aBoolean535 = false;
	    else if (i1 == 19) {
		i = arg1.method342();
		if (i == 1)
		    aBoolean536 = true;
	    } else if (i1 == 21)
		aBoolean537 = true;
	    else if (i1 == 22)
		aBoolean538 = true;
	    else if (i1 == 23)
		aBoolean539 = true;
	    else if (i1 == 24) {
		anInt540 = arg1.method344();
		if (anInt540 == 65535)
		    anInt540 = -1;
	    } else if (i1 == 25)
		aBoolean545 = true;
	    else if (i1 == 28)
		anInt541 = arg1.method342();
	    else if (i1 == 29)
		aByte542 = arg1.method343();
	    else if (i1 == 39)
		aByte543 = arg1.method343();
	    else if (i1 >= 30 && i1 < 39) {
		if (aStringArray544 == null)
		    aStringArray544 = new String[5];
		aStringArray544[i1 - 30] = arg1.method349();
	    } else if (i1 == 40) {
		int i4 = arg1.method342();
		anIntArray530 = new int[i4];
		anIntArray531 = new int[i4];
		for (int i5 = 0; i5 < i4; i5++) {
		    anIntArray530[i5] = arg1.method344();
		    anIntArray531[i5] = arg1.method344();
		}
	    } else if (i1 == 60)
		anInt546 = arg1.method344();
	    else if (i1 == 62)
		aBoolean548 = true;
	    else if (i1 == 64)
		aBoolean549 = false;
	    else if (i1 == 65)
		anInt550 = arg1.method344();
	    else if (i1 == 66)
		anInt551 = arg1.method344();
	    else if (i1 == 67)
		anInt552 = arg1.method344();
	    else if (i1 == 68)
		anInt547 = arg1.method344();
	    else if (i1 == 69)
		anInt553 = arg1.method342();
	}
	if (anIntArray527 == null)
	    anIntArray527 = new int[0];
	if (i == -1) {
	    aBoolean536 = false;
	    if (anIntArray527.length > 0 && anIntArray527[0] == 10)
		aBoolean536 = true;
	    if (aStringArray544 != null)
		aBoolean536 = true;
	}
    }
    
    public final Class33_Sub2_Sub1 method386(int arg0, int arg1, int arg2,
					     int arg3, int arg4, int arg5,
					     int arg6) {
	int i = -1;
	for (int i1 = 0; i1 < anIntArray527.length; i1++) {
	    if (anIntArray527[i1] == arg0) {
		i = i1;
		break;
	    }
	}
	if (i == -1)
	    return null;
	long l = ((long) ((anInt525 << 6) + (i << 3) + arg1)
		  + ((long) (arg6 + 1) << 32));
	if (!aBoolean537 && !aBoolean538) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= (Class33_Sub2_Sub1) aClass29_555.method250(l);
	    if (class33_sub2_sub1 != null)
		return class33_sub2_sub1;
	}
	if (i >= anIntArray526.length)
	    return null;
	int i2 = anIntArray526[i];
	if (i2 == -1)
	    return null;
	boolean flag = aBoolean548 ^ arg1 > 3;
	if (flag)
	    i2 += 65536;
	Class33_Sub2_Sub1 class33_sub2_sub1
	    = (Class33_Sub2_Sub1) aClass29_554.method250((long) i2);
	if (class33_sub2_sub1 == null) {
	    class33_sub2_sub1
		= new Class33_Sub2_Sub1(i2 & 0xffff, aBoolean518);
	    if (flag)
		class33_sub2_sub1.method273(5);
	    aClass29_554.method251(class33_sub2_sub1, (long) i2, aByte519);
	}
	boolean flag3;
	if (anInt550 != 128 || anInt551 != 128 || anInt552 != 128)
	    flag3 = true;
	else
	    flag3 = false;
	Class33_Sub2_Sub1 class33_sub2_sub1_4
	    = new Class33_Sub2_Sub1(anIntArray530 == null, !aBoolean545,
				    class33_sub2_sub1, 440, !aBoolean538,
				    (arg1 == 0 && !aBoolean537 && arg6 == -1
				     && !flag3));
	if (arg6 != -1) {
	    class33_sub2_sub1_4.method265(0);
	    class33_sub2_sub1_4.method266(false, arg6);
	    class33_sub2_sub1_4.anIntArrayArray1038 = null;
	    class33_sub2_sub1_4.anIntArrayArray1037 = null;
	}
	while (arg1-- > 0)
	    class33_sub2_sub1_4.method269(0);
	if (anIntArray530 != null) {
	    for (int i5 = 0; i5 < anIntArray530.length; i5++)
		class33_sub2_sub1_4.method272(anIntArray530[i5],
					      anIntArray531[i5]);
	}
	if (flag3)
	    class33_sub2_sub1_4.method274(anInt551, anInt550, false, anInt552);
	if (aBoolean537) {
	    int i6 = (arg2 + arg3 + arg4 + arg5) / 4;
	    for (int i7 = 0; i7 < class33_sub2_sub1_4.anInt1005; i7++) {
		int i8 = class33_sub2_sub1_4.anIntArray1006[i7];
		int i9 = class33_sub2_sub1_4.anIntArray1008[i7];
		int i10 = arg2 + (arg3 - arg2) * (i8 + 64) / 128;
		int i11 = arg5 + (arg4 - arg5) * (i8 + 64) / 128;
		int i12 = i10 + (i11 - i10) * (i9 + 64) / 128;
		class33_sub2_sub1_4.anIntArray1007[i7] += i12 - i6;
	    }
	}
	class33_sub2_sub1_4.method275(aByte542 + 64, aByte543 * 5 + 768, -50,
				      -10, -50, !aBoolean538);
	if (aBoolean534)
	    class33_sub2_sub1_4.anInt1034 = class33_sub2_sub1_4.anInt1030;
	if (!aBoolean537 && !aBoolean538)
	    aClass29_555.method251(class33_sub2_sub1_4, l, aByte519);
	return class33_sub2_sub1_4;
    }
}
