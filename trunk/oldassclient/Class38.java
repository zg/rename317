
final class Class38
{
    private static boolean aBoolean556;
    private static int anInt557 = -612;
    private static byte aByte558 = 2;
    public static int anInt559;
    private static int[] anIntArray560;
    private static Class33_Sub2_Sub3 aClass33_Sub2_Sub3_561;
    private static Class38[] aClass38Array562;
    private static int anInt563;
    private long aLong564 = -1L;
    public String aString565;
    public byte[] aByteArray566;
    public byte aByte567 = 1;
    private int[] anIntArray568;
    private int[] anIntArray569;
    public int anInt570 = -1;
    public int anInt571 = -1;
    public int anInt572 = -1;
    public int anInt573 = -1;
    public int anInt574 = -1;
    private boolean aBoolean575 = false;
    private int[] anIntArray576;
    private int[] anIntArray577;
    public String[] aStringArray578;
    public int anInt579 = -1;
    public int anInt580 = -1;
    public int anInt581 = -1;
    public boolean aBoolean582 = true;
    public int anInt583 = -1;
    private int anInt584 = 128;
    private int anInt585 = 128;
    public static Class29 aClass29_586 = new Class29(-947, 30);
    
    public static final void method387(Class34 arg0) {
	aClass33_Sub2_Sub3_561
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "npc.dat"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "npc.idx"),
				    (byte) 63);
	anInt559 = class33_sub2_sub3.method344();
	anIntArray560 = new int[anInt559];
	int i = 2;
	for (int i1 = 0; i1 < anInt559; i1++) {
	    anIntArray560[i1] = i;
	    i += class33_sub2_sub3.method344();
	}
	aClass38Array562 = new Class38[20];
	for (int i2 = 0; i2 < 20; i2++)
	    aClass38Array562[i2] = new Class38();
    }
    
    public static final void method388(int arg0) {
	aClass29_586 = null;
	anIntArray560 = null;
	aClass38Array562 = null;
	if (arg0 <= 0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	aClass33_Sub2_Sub3_561 = null;
    }
    
    public static final Class38 method389(int arg0) {
	for (int i = 0; i < 20; i++) {
	    if (aClass38Array562[i].aLong564 == (long) arg0)
		return aClass38Array562[i];
	}
	anInt563 = (anInt563 + 1) % 20;
	Class38 class38 = aClass38Array562[anInt563] = new Class38();
	aClass33_Sub2_Sub3_561.anInt1108 = anIntArray560[arg0];
	class38.aLong564 = (long) arg0;
	class38.method390((byte) 4, aClass33_Sub2_Sub3_561);
	return class38;
    }
    
    private final void method390(byte arg0, Class33_Sub2_Sub3 arg1) {
	if (arg0 == 4) {
	    boolean flag = false;
	} else
	    throw new NullPointerException();
	for (;;) {
	    int i = arg1.method342();
	    if (i == 0)
		break;
	    if (i == 1) {
		int i1 = arg1.method342();
		anIntArray568 = new int[i1];
		for (int i2 = 0; i2 < i1; i2++)
		    anIntArray568[i2] = arg1.method344();
	    } else if (i == 2)
		aString565 = arg1.method349();
	    else if (i == 3)
		aByteArray566 = arg1.method350((byte) 2);
	    else if (i == 12)
		aByte567 = arg1.method343();
	    else if (i == 13)
		anInt570 = arg1.method344();
	    else if (i == 14)
		anInt571 = arg1.method344();
	    else if (i == 16)
		aBoolean575 = true;
	    else if (i == 17) {
		anInt571 = arg1.method344();
		anInt572 = arg1.method344();
		anInt573 = arg1.method344();
		anInt574 = arg1.method344();
	    } else if (i >= 30 && i < 40) {
		if (aStringArray578 == null)
		    aStringArray578 = new String[5];
		aStringArray578[i - 30] = arg1.method349();
	    } else if (i == 40) {
		int i3 = arg1.method342();
		anIntArray576 = new int[i3];
		anIntArray577 = new int[i3];
		for (int i4 = 0; i4 < i3; i4++) {
		    anIntArray576[i4] = arg1.method344();
		    anIntArray577[i4] = arg1.method344();
		}
	    } else if (i == 60) {
		int i5 = arg1.method342();
		anIntArray569 = new int[i5];
		for (int i6 = 0; i6 < i5; i6++)
		    anIntArray569[i6] = arg1.method344();
	    } else if (i == 90)
		anInt579 = arg1.method344();
	    else if (i == 91)
		anInt580 = arg1.method344();
	    else if (i == 92)
		anInt581 = arg1.method344();
	    else if (i == 93)
		aBoolean582 = false;
	    else if (i == 95)
		anInt583 = arg1.method344();
	    else if (i == 97)
		anInt584 = arg1.method344();
	    else if (i == 98)
		anInt585 = arg1.method344();
	}
    }
    
    public final Class33_Sub2_Sub1 method391(int arg0, int arg1, int[] arg2) {
	Object object = null;
	Class33_Sub2_Sub1 class33_sub2_sub1
	    = (Class33_Sub2_Sub1) aClass29_586.method250(aLong564);
	if (class33_sub2_sub1 == null) {
	    Class33_Sub2_Sub1[] class33_sub2_sub1s
		= new Class33_Sub2_Sub1[anIntArray568.length];
	    for (int i = 0; i < anIntArray568.length; i++)
		class33_sub2_sub1s[i]
		    = new Class33_Sub2_Sub1(anIntArray568[i], aBoolean556);
	    if (class33_sub2_sub1s.length == 1)
		class33_sub2_sub1 = class33_sub2_sub1s[0];
	    else
		class33_sub2_sub1
		    = new Class33_Sub2_Sub1(class33_sub2_sub1s.length, false,
					    class33_sub2_sub1s);
	    if (anIntArray576 != null) {
		for (int i = 0; i < anIntArray576.length; i++)
		    class33_sub2_sub1.method272(anIntArray576[i],
						anIntArray577[i]);
	    }
	    class33_sub2_sub1.method265(0);
	    class33_sub2_sub1.method275(64, 850, -30, -50, -30, true);
	    aClass29_586.method251(class33_sub2_sub1, aLong564, aByte558);
	}
	Class33_Sub2_Sub1 class33_sub2_sub1_1
	    = new Class33_Sub2_Sub1(!aBoolean575, false, class33_sub2_sub1);
	if (arg0 != -1 && arg1 != -1)
	    class33_sub2_sub1_1.method267(arg0, arg1, arg2, anInt557);
	else if (arg0 != -1)
	    class33_sub2_sub1_1.method266(false, arg0);
	if (anInt584 != 128 || anInt585 != 128)
	    class33_sub2_sub1_1.method274(anInt585, anInt584, false, anInt584);
	class33_sub2_sub1_1.method263(false);
	class33_sub2_sub1_1.anIntArrayArray1038 = null;
	class33_sub2_sub1_1.anIntArrayArray1037 = null;
	return class33_sub2_sub1_1;
    }
    
    public final Class33_Sub2_Sub1 method392(int arg0) {
	while (arg0 >= 0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	if (anIntArray569 == null)
	    return null;
	Class33_Sub2_Sub1[] class33_sub2_sub1s
	    = new Class33_Sub2_Sub1[anIntArray569.length];
	for (int i = 0; i < anIntArray569.length; i++)
	    class33_sub2_sub1s[i]
		= new Class33_Sub2_Sub1(anIntArray569[i], aBoolean556);
	Class33_Sub2_Sub1 class33_sub2_sub1;
	if (class33_sub2_sub1s.length == 1)
	    class33_sub2_sub1 = class33_sub2_sub1s[0];
	else
	    class33_sub2_sub1
		= new Class33_Sub2_Sub1(class33_sub2_sub1s.length, false,
					class33_sub2_sub1s);
	if (anIntArray576 != null) {
	    for (int i = 0; i < anIntArray576.length; i++)
		class33_sub2_sub1.method272(anIntArray576[i],
					    anIntArray577[i]);
	}
	return class33_sub2_sub1;
    }
}
