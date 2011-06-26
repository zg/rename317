
public class Class6
{
    private static boolean aBoolean101;
    private static byte aByte102 = 2;
    private static byte aByte103 = -60;
    private static boolean aBoolean104 = true;
    public static Class6[] aClass6Array105;
    public int[] anIntArray106;
    public int[] anIntArray107;
    public int anInt108;
    public int anInt109;
    public int anInt110;
    public int anInt111;
    public int anInt112;
    public int anInt113;
    public int anInt114;
    public int anInt115;
    public int anInt116;
    public int[][] anIntArrayArray117;
    public int[] anIntArray118;
    public int[] anIntArray119;
    public int anInt120;
    public int anInt121;
    public int anInt122;
    public boolean aBoolean123;
    public int[] anIntArray124;
    public int[] anIntArray125;
    public int[] anIntArray126;
    public int anInt127;
    public boolean aBoolean128;
    public boolean aBoolean129;
    public boolean aBoolean130;
    public boolean aBoolean131;
    public int anInt132;
    public int anInt133;
    public Class33_Sub2_Sub2_Sub2[] aClass33_Sub2_Sub2_Sub2Array134;
    public int[] anIntArray135;
    public int[] anIntArray136;
    public String[] aStringArray137;
    public boolean aBoolean138;
    public boolean aBoolean139;
    public boolean aBoolean140;
    public Class33_Sub2_Sub2_Sub4 aClass33_Sub2_Sub2_Sub4_141;
    public String aString142;
    public String aString143;
    public int anInt144;
    public int anInt145;
    public int anInt146;
    public Class33_Sub2_Sub2_Sub2 aClass33_Sub2_Sub2_Sub2_147;
    public Class33_Sub2_Sub2_Sub2 aClass33_Sub2_Sub2_Sub2_148;
    public Class33_Sub2_Sub1 aClass33_Sub2_Sub1_149;
    public Class33_Sub2_Sub1 aClass33_Sub2_Sub1_150;
    public int anInt151;
    public int anInt152;
    public int anInt153;
    public int anInt154;
    public int anInt155;
    public String aString156;
    public String aString157;
    public int anInt158;
    public String aString159;
    private static Class29 aClass29_160;
    private static Class29 aClass29_161;
    
    public static void method130(Class33_Sub2_Sub2_Sub4[] arg0, Class34 arg1,
				 byte arg2, Class34 arg3) {
	aClass29_160 = new Class29(-947, 50000);
	aClass29_161 = new Class29(-947, 50000);
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg3.method371(0, null, "data"),
				    (byte) 63);
	int i = -1;
	int i1 = class33_sub2_sub3.method344();
	aClass6Array105 = new Class6[i1];
	while (class33_sub2_sub3.anInt1108
	       < class33_sub2_sub3.aByteArray1107.length) {
	    int i2 = class33_sub2_sub3.method344();
	    if (i2 == 65535) {
		i = class33_sub2_sub3.method344();
		i2 = class33_sub2_sub3.method344();
	    }
	    Class6 class6 = aClass6Array105[i2] = new Class6();
	    class6.anInt110 = i2;
	    class6.anInt111 = i;
	    class6.anInt112 = class33_sub2_sub3.method342();
	    class6.anInt113 = class33_sub2_sub3.method342();
	    class6.anInt114 = class33_sub2_sub3.method344();
	    class6.anInt115 = class33_sub2_sub3.method344();
	    class6.anInt116 = class33_sub2_sub3.method344();
	    class6.anInt120 = class33_sub2_sub3.method342();
	    if (class6.anInt120 != 0)
		class6.anInt120 = ((class6.anInt120 - 1 << 8)
				   + class33_sub2_sub3.method342());
	    else
		class6.anInt120 = -1;
	    int i3 = class33_sub2_sub3.method342();
	    if (i3 > 0) {
		class6.anIntArray118 = new int[i3];
		class6.anIntArray119 = new int[i3];
		for (int i4 = 0; i4 < i3; i4++) {
		    class6.anIntArray118[i4] = class33_sub2_sub3.method342();
		    class6.anIntArray119[i4] = class33_sub2_sub3.method344();
		}
	    }
	    int i5 = class33_sub2_sub3.method342();
	    if (i5 > 0) {
		class6.anIntArrayArray117 = new int[i5][];
		for (int i6 = 0; i6 < i5; i6++) {
		    int i7 = class33_sub2_sub3.method344();
		    class6.anIntArrayArray117[i6] = new int[i7];
		    for (int i8 = 0; i8 < i7; i8++)
			class6.anIntArrayArray117[i6][i8]
			    = class33_sub2_sub3.method344();
		}
	    }
	    if (class6.anInt112 == 0) {
		class6.anInt121 = class33_sub2_sub3.method344();
		class6.aBoolean123 = class33_sub2_sub3.method342() == 1;
		int i9 = class33_sub2_sub3.method342();
		class6.anIntArray124 = new int[i9];
		class6.anIntArray125 = new int[i9];
		class6.anIntArray126 = new int[i9];
		for (int i10 = 0; i10 < i9; i10++) {
		    class6.anIntArray124[i10] = class33_sub2_sub3.method344();
		    class6.anIntArray125[i10] = class33_sub2_sub3.method345();
		    class6.anIntArray126[i10] = class33_sub2_sub3.method345();
		}
	    }
	    if (class6.anInt112 == 1) {
		class6.anInt127 = class33_sub2_sub3.method344();
		class6.aBoolean128 = class33_sub2_sub3.method342() == 1;
	    }
	    if (class6.anInt112 == 2) {
		class6.anIntArray106
		    = new int[class6.anInt115 * class6.anInt116];
		class6.anIntArray107
		    = new int[class6.anInt115 * class6.anInt116];
		class6.aBoolean129 = class33_sub2_sub3.method342() == 1;
		class6.aBoolean130 = class33_sub2_sub3.method342() == 1;
		class6.aBoolean131 = class33_sub2_sub3.method342() == 1;
		class6.anInt132 = class33_sub2_sub3.method342();
		class6.anInt133 = class33_sub2_sub3.method342();
		class6.anIntArray135 = new int[20];
		class6.anIntArray136 = new int[20];
		class6.aClass33_Sub2_Sub2_Sub2Array134
		    = new Class33_Sub2_Sub2_Sub2[20];
		for (int i11 = 0; i11 < 20; i11++) {
		    int i12 = class33_sub2_sub3.method342();
		    if (i12 == 1) {
			class6.anIntArray135[i11]
			    = class33_sub2_sub3.method345();
			class6.anIntArray136[i11]
			    = class33_sub2_sub3.method345();
			String string = class33_sub2_sub3.method349();
			if (arg1 != null && string.length() > 0) {
			    int i13 = string.lastIndexOf(",");
			    class6.aClass33_Sub2_Sub2_Sub2Array134[i11]
				= method132((byte) 4, string.substring(0, i13),
					    arg1,
					    (Integer.parseInt
					     (string.substring(i13 + 1))));
			}
		    }
		}
		class6.aStringArray137 = new String[5];
		for (int i14 = 0; i14 < 5; i14++) {
		    class6.aStringArray137[i14]
			= class33_sub2_sub3.method349();
		    if (class6.aStringArray137[i14].length() == 0)
			class6.aStringArray137[i14] = null;
		}
	    }
	    if (class6.anInt112 == 3)
		class6.aBoolean138 = class33_sub2_sub3.method342() == 1;
	    if (class6.anInt112 == 4 || class6.anInt112 == 1) {
		class6.aBoolean139 = class33_sub2_sub3.method342() == 1;
		int i15 = class33_sub2_sub3.method342();
		if (arg0 != null)
		    class6.aClass33_Sub2_Sub2_Sub4_141 = arg0[i15];
		class6.aBoolean140 = class33_sub2_sub3.method342() == 1;
	    }
	    if (class6.anInt112 == 4) {
		class6.aString142 = class33_sub2_sub3.method349();
		class6.aString143 = class33_sub2_sub3.method349();
	    }
	    if (class6.anInt112 == 1 || class6.anInt112 == 3
		|| class6.anInt112 == 4)
		class6.anInt144 = class33_sub2_sub3.method347();
	    if (class6.anInt112 == 3 || class6.anInt112 == 4) {
		class6.anInt145 = class33_sub2_sub3.method347();
		class6.anInt146 = class33_sub2_sub3.method347();
	    }
	    if (class6.anInt112 == 5) {
		String string = class33_sub2_sub3.method349();
		if (arg1 != null && string.length() > 0) {
		    int i16 = string.lastIndexOf(",");
		    class6.aClass33_Sub2_Sub2_Sub2_147
			= method132((byte) 4, string.substring(0, i16), arg1,
				    Integer
					.parseInt(string.substring(i16 + 1)));
		}
		string = class33_sub2_sub3.method349();
		if (arg1 != null && string.length() > 0) {
		    int i17 = string.lastIndexOf(",");
		    class6.aClass33_Sub2_Sub2_Sub2_148
			= method132((byte) 4, string.substring(0, i17), arg1,
				    Integer
					.parseInt(string.substring(i17 + 1)));
		}
	    }
	    if (class6.anInt112 == 6) {
		i2 = class33_sub2_sub3.method342();
		if (i2 != 0)
		    class6.aClass33_Sub2_Sub1_149
			= method133(((i2 - 1 << 8)
				     + class33_sub2_sub3.method342()),
				    false);
		i2 = class33_sub2_sub3.method342();
		if (i2 != 0)
		    class6.aClass33_Sub2_Sub1_150
			= method133(((i2 - 1 << 8)
				     + class33_sub2_sub3.method342()),
				    false);
		i2 = class33_sub2_sub3.method342();
		if (i2 != 0)
		    class6.anInt151
			= (i2 - 1 << 8) + class33_sub2_sub3.method342();
		else
		    class6.anInt151 = -1;
		i2 = class33_sub2_sub3.method342();
		if (i2 != 0)
		    class6.anInt152
			= (i2 - 1 << 8) + class33_sub2_sub3.method342();
		else
		    class6.anInt152 = -1;
		class6.anInt153 = class33_sub2_sub3.method344();
		class6.anInt154 = class33_sub2_sub3.method344();
		class6.anInt155 = class33_sub2_sub3.method344();
	    }
	    if (class6.anInt112 == 7) {
		class6.anIntArray106
		    = new int[class6.anInt115 * class6.anInt116];
		class6.anIntArray107
		    = new int[class6.anInt115 * class6.anInt116];
		class6.aBoolean139 = class33_sub2_sub3.method342() == 1;
		int i18 = class33_sub2_sub3.method342();
		if (arg0 != null)
		    class6.aClass33_Sub2_Sub2_Sub4_141 = arg0[i18];
		class6.aBoolean140 = class33_sub2_sub3.method342() == 1;
		class6.anInt144 = class33_sub2_sub3.method347();
		class6.anInt132 = class33_sub2_sub3.method345();
		class6.anInt133 = class33_sub2_sub3.method345();
		class6.aBoolean130 = class33_sub2_sub3.method342() == 1;
		class6.aStringArray137 = new String[5];
		for (int i19 = 0; i19 < 5; i19++) {
		    class6.aStringArray137[i19]
			= class33_sub2_sub3.method349();
		    if (class6.aStringArray137[i19].length() == 0)
			class6.aStringArray137[i19] = null;
		}
	    }
	    if (class6.anInt113 == 2 || class6.anInt112 == 2) {
		class6.aString156 = class33_sub2_sub3.method349();
		class6.aString157 = class33_sub2_sub3.method349();
		class6.anInt158 = class33_sub2_sub3.method344();
	    }
	    if (class6.anInt113 == 1 || class6.anInt113 == 4
		|| class6.anInt113 == 5 || class6.anInt113 == 6) {
		class6.aString159 = class33_sub2_sub3.method349();
		if (class6.aString159.length() == 0) {
		    if (class6.anInt113 == 1)
			class6.aString159 = "Ok";
		    if (class6.anInt113 == 4)
			class6.aString159 = "Select";
		    if (class6.anInt113 == 5)
			class6.aString159 = "Select";
		    if (class6.anInt113 == 6)
			class6.aString159 = "Continue";
		}
	    }
	}
	aClass29_160 = null;
	if (arg2 == aByte103)
	    aClass29_161 = null;
    }
    
    public Class33_Sub2_Sub1 method131(int arg0, int arg1, boolean arg2) {
	Class33_Sub2_Sub1 class33_sub2_sub1 = aClass33_Sub2_Sub1_149;
	if (arg2)
	    class33_sub2_sub1 = aClass33_Sub2_Sub1_150;
	if (class33_sub2_sub1 == null)
	    return null;
	if (arg0 == -1 && arg1 == -1
	    && class33_sub2_sub1.anIntArray1019 == null)
	    return class33_sub2_sub1;
	Class33_Sub2_Sub1 class33_sub2_sub1_1
	    = new Class33_Sub2_Sub1(true, true, class33_sub2_sub1, 440, true,
				    false);
	if (arg0 != -1 || arg1 != -1)
	    class33_sub2_sub1_1.method265(0);
	if (arg0 != -1)
	    class33_sub2_sub1_1.method266(false, arg0);
	if (arg1 != -1)
	    class33_sub2_sub1_1.method266(false, arg1);
	class33_sub2_sub1_1.method275(64, 768, -50, -10, -50, true);
	return class33_sub2_sub1_1;
    }
    
    private static Class33_Sub2_Sub2_Sub2 method132(byte arg0, String arg1,
						    Class34 arg2, int arg3) {
	if (arg0 == 4) {
	    boolean flag = false;
	} else
	    aBoolean104 = !aBoolean104;
	long l = (Class35.method374(arg1, 729) << 4) + (long) arg3;
	Class33_Sub2_Sub2_Sub2 class33_sub2_sub2_sub2
	    = (Class33_Sub2_Sub2_Sub2) aClass29_160.method250(l);
	if (class33_sub2_sub2_sub2 != null)
	    return class33_sub2_sub2_sub2;
	class33_sub2_sub2_sub2
	    = new Class33_Sub2_Sub2_Sub2(arg1, 154, arg3, arg2);
	aClass29_160.method251(class33_sub2_sub2_sub2, l, aByte102);
	return class33_sub2_sub2_sub2;
    }
    
    private static Class33_Sub2_Sub1 method133(int arg0, boolean arg1) {
	Class33_Sub2_Sub1 class33_sub2_sub1
	    = (Class33_Sub2_Sub1) aClass29_161.method250((long) arg0);
	if (arg1)
	    throw new NullPointerException();
	if (class33_sub2_sub1 != null)
	    return class33_sub2_sub1;
	class33_sub2_sub1 = new Class33_Sub2_Sub1(arg0, aBoolean101);
	aClass29_161.method251(class33_sub2_sub1, (long) arg0, aByte102);
	return class33_sub2_sub1;
    }
}
