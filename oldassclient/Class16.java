
public final class Class16
{
    private static int anInt258;
    private static boolean aBoolean259;
    private static int anInt260 = -497;
    private static boolean aBoolean261 = true;
    private static int anInt262 = -12807;
    private static int anInt263 = 6;
    private static byte aByte264 = 8;
    private static int anInt265;
    private static int[] anIntArray266;
    private static char[][] aCharArrayArray267;
    private static byte[][][] aByteArrayArrayArray268;
    private static char[][] aCharArrayArray269;
    private static char[][] aCharArrayArray270;
    private static int[] anIntArray271;
    private static final String[] aStringArray272
	= { "cook", "cook's", "cooks", "seeks", "sheet" };
    public static boolean aBoolean273;
    
    public static final void method143(Class34 arg0) {
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg0.method371(0, null,
						   "fragmentsenc.txt"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3_1
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "badenc.txt"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3_2
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "domainenc.txt"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3_3
	    = new Class33_Sub2_Sub3(arg0.method371(0, null, "tldlist.txt"),
				    (byte) 63);
	method144(class33_sub2_sub3, class33_sub2_sub3_1, class33_sub2_sub3_2,
		  class33_sub2_sub3_3);
    }
    
    private static final void method144
	(Class33_Sub2_Sub3 arg0, Class33_Sub2_Sub3 arg1,
	 Class33_Sub2_Sub3 arg2, Class33_Sub2_Sub3 arg3) {
	method146((byte) 4, arg1);
	method147(102, arg2);
	method148(115, arg0);
	method145(aBoolean261, arg3);
    }
    
    private static final void method145(boolean arg0, Class33_Sub2_Sub3 arg1) {
	if (!arg0)
	    anInt260 = -270;
	int i = arg1.method347();
	aCharArrayArray270 = new char[i][];
	anIntArray271 = new int[i];
	for (int i1 = 0; i1 < i; i1++) {
	    anIntArray271[i1] = arg1.method342();
	    char[] chars = new char[arg1.method342()];
	    for (int i2 = 0; i2 < chars.length; i2++)
		chars[i2] = (char) arg1.method342();
	    aCharArrayArray270[i1] = chars;
	}
    }
    
    private static final void method146(byte arg0, Class33_Sub2_Sub3 arg1) {
	int i = arg1.method347();
	aCharArrayArray267 = new char[i][];
	aByteArrayArrayArray268 = new byte[i][][];
	method149(0, arg1, aByteArrayArrayArray268, aCharArrayArray267);
	if (arg0 != 4) {
	}
    }
    
    private static final void method147(int arg0, Class33_Sub2_Sub3 arg1) {
	int i = arg1.method347();
	aCharArrayArray269 = new char[i][];
	method150(arg1, -687, aCharArrayArray269);
	arg0 = 82 / arg0;
    }
    
    private static final void method148(int arg0, Class33_Sub2_Sub3 arg1) {
	anIntArray266 = new int[arg1.method347()];
	arg0 = 76 / arg0;
	for (int i = 0; i < anIntArray266.length; i++)
	    anIntArray266[i] = arg1.method344();
    }
    
    private static final void method149(int arg0, Class33_Sub2_Sub3 arg1,
					byte[][][] arg2, char[][] arg3) {
	if (arg0 == 0) {
	    for (int i = 0; i < arg3.length; i++) {
		char[] chars = new char[arg1.method342()];
		for (int i1 = 0; i1 < chars.length; i1++)
		    chars[i1] = (char) arg1.method342();
		arg3[i] = chars;
		byte[][] is = new byte[arg1.method342()][2];
		for (int i2 = 0; i2 < is.length; i2++) {
		    is[i2][0] = (byte) arg1.method342();
		    is[i2][1] = (byte) arg1.method342();
		}
		if (is.length > 0)
		    arg2[i] = is;
	    }
	}
    }
    
    private static final void method150(Class33_Sub2_Sub3 arg0, int arg1,
					char[][] arg2) {
	for (int i = 0; i < arg2.length; i++) {
	    char[] chars = new char[arg0.method342()];
	    for (int i1 = 0; i1 < chars.length; i1++)
		chars[i1] = (char) arg0.method342();
	    arg2[i] = chars;
	}
	while (arg1 >= 0)
	    anInt260 = -364;
    }
    
    private static final void method151(byte arg0, char[] arg1) {
	if (arg0 == 3) {
	    boolean flag = false;
	} else {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	for (int i = 0; i < arg1.length; i++) {
	    if (!method152(arg1[i], 966))
		arg1[i] = ' ';
	}
    }
    
    private static final boolean method152(char arg0, int arg1) {
	arg1 = 11 / arg1;
	if ((arg0 < ' ' || arg0 > '\u007f') && arg0 != ' ' && arg0 != '\n'
	    && arg0 != '\t' && arg0 != '\u00a3' && arg0 != '\u20ac')
	    return false;
	return true;
    }
    
    public static final String method153(int arg0, String arg1) {
	if (arg0 != -12807)
	    throw new NullPointerException();
	long l = System.currentTimeMillis();
	char[] chars = arg1.toLowerCase().toCharArray();
	method151((byte) 3, chars);
	method161(4, chars);
	method156(chars, 552);
	method157(chars, 901);
	method170(chars, 10513);
	for (int i = 0; i < aStringArray272.length; i++) {
	    int i1 = -1;
	    while ((i1 = arg1.indexOf(aStringArray272[i], i1 + 1)) != -1) {
		char[] chars2 = aStringArray272[i].toCharArray();
		for (int i3 = 0; i3 < chars2.length; i3++)
		    chars[i3 + i1] = chars2[i3];
	    }
	}
	method154(arg1.toCharArray(), (byte) 7, chars);
	method155(false, chars);
	long l4 = System.currentTimeMillis();
	return new String(chars).trim();
    }
    
    private static final void method154(char[] arg0, byte arg1, char[] arg2) {
	if (arg1 != 7) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	for (int i = 0; i < arg0.length; i++) {
	    if (arg2[i] != '*' && method178(arg0[i], (byte) 85))
		arg2[i] = arg0[i];
	}
    }
    
    private static final void method155(boolean arg0, char[] arg1) {
	boolean flag = true;
	if (!arg0) {
	    for (int i = 0; i < arg1.length; i++) {
		char c = arg1[i];
		if (method175(c, 0)) {
		    if (flag) {
			if (method177((byte) 7, c))
			    flag = false;
		    } else if (method178(c, (byte) 85))
			arg1[i] = (char) (c + 'a' - 'A');
		} else
		    flag = true;
	    }
	}
    }
    
    private static final void method156(char[] arg0, int arg1) {
	arg1 = 23 / arg1;
	for (int i = 0; i < 2; i++) {
	    for (int i1 = aCharArrayArray267.length - 1; i1 >= 0; i1--)
		method165(arg0, aCharArrayArray267[i1], 0,
			  aByteArrayArrayArray268[i1]);
	}
    }
    
    private static final void method157(char[] arg0, int arg1) {
	char[] chars = (char[]) arg0.clone();
	char[] chars1 = { '(', 'a', ')' };
	method165(chars, chars1, 0, null);
	char[] chars2 = (char[]) arg0.clone();
	char[] chars3 = { 'd', 'o', 't' };
	method165(chars2, chars3, 0, null);
	arg1 = 63 / arg1;
	for (int i = aCharArrayArray269.length - 1; i >= 0; i--)
	    method158(chars2, true, chars, arg0, aCharArrayArray269[i]);
    }
    
    private static final void method158(char[] arg0, boolean arg1, char[] arg2,
					char[] arg3, char[] arg4) {
	if (!arg1)
	    anInt258 = -204;
	if (arg4.length <= arg3.length) {
	    boolean flag = true;
	    int i1;
	    for (int i = 0; i <= arg3.length - arg4.length; i += i1) {
		int i2 = i;
		int i3 = 0;
		i1 = 1;
		while (i2 < arg3.length) {
		    boolean flag4 = false;
		    char c = arg3[i2];
		    char c5 = '\0';
		    if (i2 + 1 < arg3.length)
			c5 = arg3[i2 + 1];
		    int i6;
		    if (i3 < arg4.length
			&& (i6 = method167(true, arg4[i3], c5, c)) > 0) {
			i2 += i6;
			i3++;
		    } else {
			if (i3 == 0)
			    break;
			if ((i6 = method167(true, arg4[i3 - 1], c5, c)) > 0) {
			    i2 += i6;
			    if (i3 == 1)
				i1++;
			} else {
			    if (i3 >= arg4.length || !method173(false, c))
				break;
			    i2++;
			}
		    }
		}
		if (i3 >= arg4.length) {
		    boolean flag7 = false;
		    int i8 = method159(i, anInt263, arg2, arg3);
		    int i9 = method160(arg3, i2 - 1, true, arg0);
		    if (i8 > 2 || i9 > 2)
			flag7 = true;
		    if (flag7) {
			for (int i10 = i; i10 < i2; i10++)
			    arg3[i10] = '*';
		    }
		}
	    }
	}
    }
    
    private static final int method159(int arg0, int arg1, char[] arg2,
				       char[] arg3) {
	if (arg0 == 0)
	    return 2;
	for (int i = arg0 - 1; i >= 0; i--) {
	    if (!method173(false, arg3[i]))
		break;
	    if (arg3[i] == '@')
		return 3;
	}
	if (arg1 != 6)
	    return 3;
	int i = 0;
	for (int i1 = arg0 - 1; i1 >= 0; i1--) {
	    if (!method173(false, arg2[i1]))
		break;
	    if (arg2[i1] == '*')
		i++;
	}
	if (i >= 3)
	    return 4;
	if (method173(false, arg3[arg0 - 1]))
	    return 1;
	return 0;
    }
    
    private static final int method160(char[] arg0, int arg1, boolean arg2,
				       char[] arg3) {
	if (arg1 + 1 == arg0.length)
	    return 2;
	for (int i = arg1 + 1; i < arg0.length; i++) {
	    if (!method173(false, arg0[i]))
		break;
	    if (arg0[i] == '.' || arg0[i] == ',')
		return 3;
	}
	int i = 0;
	for (int i1 = arg1 + 1; i1 < arg0.length; i1++) {
	    if (!method173(false, arg3[i1]))
		break;
	    if (arg3[i1] == '*')
		i++;
	}
	if (!arg2)
	    return 3;
	if (i >= 3)
	    return 4;
	if (method173(false, arg0[arg1 + 1]))
	    return 1;
	return 0;
    }
    
    private static final void method161(int arg0, char[] arg1) {
	char[] chars = (char[]) arg1.clone();
	char[] chars1 = { 'd', 'o', 't' };
	method165(chars, chars1, 0, null);
	char[] chars2 = (char[]) arg1.clone();
	char[] chars3 = { 's', 'l', 'a', 's', 'h' };
	method165(chars2, chars3, 0, null);
	if (arg0 == 4) {
	    for (int i = 0; i < aCharArrayArray270.length; i++)
		method162(chars2, chars, aCharArrayArray270[i], 175,
			  anIntArray271[i], arg1);
	}
    }
    
    private static final void method162(char[] arg0, char[] arg1, char[] arg2,
					int arg3, int arg4, char[] arg5) {
	if (arg2.length <= arg5.length) {
	    boolean flag = true;
	    arg3 = 20 / arg3;
	    int i1;
	    for (int i = 0; i <= arg5.length - arg2.length; i += i1) {
		int i2 = i;
		int i3 = 0;
		i1 = 1;
		while (i2 < arg5.length) {
		    boolean flag4 = false;
		    char c = arg5[i2];
		    char c5 = '\0';
		    if (i2 + 1 < arg5.length)
			c5 = arg5[i2 + 1];
		    int i6;
		    if (i3 < arg2.length
			&& (i6 = method167(true, arg2[i3], c5, c)) > 0) {
			i2 += i6;
			i3++;
		    } else {
			if (i3 == 0)
			    break;
			if ((i6 = method167(true, arg2[i3 - 1], c5, c)) > 0) {
			    i2 += i6;
			    if (i3 == 1)
				i1++;
			} else {
			    if (i3 >= arg2.length || !method173(false, c))
				break;
			    i2++;
			}
		    }
		}
		if (i3 >= arg2.length) {
		    boolean flag7 = false;
		    int i8 = method163(aByte264, i, arg5, arg1);
		    int i9 = method164(arg5, i2 - 1, 261, arg0);
		    if (arg4 == 1 && i8 > 0 && i9 > 0)
			flag7 = true;
		    if (arg4 == 2 && (i8 > 2 && i9 > 0 || i8 > 0 && i9 > 2))
			flag7 = true;
		    if (arg4 == 3 && i8 > 0 && i9 > 2)
			flag7 = true;
		    if (arg4 == 3 && i8 > 2 && i9 > 0) {
		    }
		    if (flag7) {
			int i10 = i;
			int i11 = i2 - 1;
			if (i8 > 2) {
			    if (i8 == 4) {
				boolean flag12 = false;
				for (int i13 = i10 - 1; i13 >= 0; i13--) {
				    if (flag12) {
					if (arg1[i13] != '*')
					    break;
					i10 = i13;
				    } else if (arg1[i13] == '*') {
					i10 = i13;
					flag12 = true;
				    }
				}
			    }
			    boolean flag14 = false;
			    for (int i15 = i10 - 1; i15 >= 0; i15--) {
				if (flag14) {
				    if (method173(false, arg5[i15]))
					break;
				    i10 = i15;
				} else if (!method173(false, arg5[i15])) {
				    flag14 = true;
				    i10 = i15;
				}
			    }
			}
			if (i9 > 2) {
			    if (i9 == 4) {
				boolean flag16 = false;
				for (int i17 = i11 + 1; i17 < arg5.length;
				     i17++) {
				    if (flag16) {
					if (arg0[i17] != '*')
					    break;
					i11 = i17;
				    } else if (arg0[i17] == '*') {
					i11 = i17;
					flag16 = true;
				    }
				}
			    }
			    boolean flag18 = false;
			    for (int i19 = i11 + 1; i19 < arg5.length; i19++) {
				if (flag18) {
				    if (method173(false, arg5[i19]))
					break;
				    i11 = i19;
				} else if (!method173(false, arg5[i19])) {
				    flag18 = true;
				    i11 = i19;
				}
			    }
			}
			for (int i20 = i10; i20 <= i11; i20++)
			    arg5[i20] = '*';
		    }
		}
	    }
	}
    }
    
    private static final int method163(byte arg0, int arg1, char[] arg2,
				       char[] arg3) {
	if (arg0 != aByte264)
	    anInt263 = 122;
	if (arg1 == 0)
	    return 2;
	for (int i = arg1 - 1; i >= 0; i--) {
	    if (!method173(false, arg2[i]))
		break;
	    if (arg2[i] == ',' || arg2[i] == '.')
		return 3;
	}
	int i = 0;
	for (int i1 = arg1 - 1; i1 >= 0; i1--) {
	    if (!method173(false, arg3[i1]))
		break;
	    if (arg3[i1] == '*')
		i++;
	}
	if (i >= 3)
	    return 4;
	if (method173(false, arg2[arg1 - 1]))
	    return 1;
	return 0;
    }
    
    private static final int method164(char[] arg0, int arg1, int arg2,
				       char[] arg3) {
	if (arg2 <= 0)
	    anInt260 = -274;
	if (arg1 + 1 == arg0.length)
	    return 2;
	for (int i = arg1 + 1; i < arg0.length; i++) {
	    if (!method173(false, arg0[i]))
		break;
	    if (arg0[i] == '\\' || arg0[i] == '/')
		return 3;
	}
	int i = 0;
	for (int i1 = arg1 + 1; i1 < arg0.length; i1++) {
	    if (!method173(false, arg3[i1]))
		break;
	    if (arg3[i1] == '*')
		i++;
	}
	if (i >= 5)
	    return 4;
	if (method173(false, arg0[arg1 + 1]))
	    return 1;
	return 0;
    }
    
    private static final void method165(char[] arg0, char[] arg1, int arg2,
					byte[][] arg3) {
	if (arg2 == 0 && arg1.length <= arg0.length) {
	    boolean flag = true;
	    int i1;
	    for (int i = 0; i <= arg0.length - arg1.length; i += i1) {
		int i2 = i;
		int i3 = 0;
		int i4 = 0;
		i1 = 1;
		boolean flag5 = false;
		while (i2 < arg0.length) {
		    boolean flag6 = false;
		    char c = arg0[i2];
		    char c7 = '\0';
		    if (i2 + 1 < arg0.length)
			c7 = arg0[i2 + 1];
		    int i8;
		    if (i3 < arg1.length
			&& (i8 = method168(c, arg1[i3], 0, c7)) > 0) {
			i2 += i8;
			i3++;
		    } else {
			if (i3 == 0)
			    break;
			if ((i8 = method168(c, arg1[i3 - 1], 0, c7)) > 0) {
			    i2 += i8;
			    if (i3 == 1)
				i1++;
			} else {
			    if (i3 >= arg1.length || !method174(anInt265, c))
				break;
			    if (method173(false, c) && c != '\'')
				flag5 = true;
			    i2++;
			    if (++i4 * 100 / (i2 - i) > 90)
				break;
			}
		    }
		}
		if (i3 >= arg1.length) {
		    boolean flag9 = true;
		    if (!flag5) {
			char c = ' ';
			if (i - 1 >= 0)
			    c = arg0[i - 1];
			char c10 = ' ';
			if (i2 < arg0.length)
			    c10 = arg0[i2];
			byte i11 = method169((byte) 9, c);
			byte i12 = method169((byte) 9, c10);
			if (arg3 != null
			    && method166(arg3, (byte) -114, i12, i11))
			    flag9 = false;
		    } else {
			boolean flag13 = false;
			boolean flag14 = false;
			if (i - 1 < 0 || (method173(false, arg0[i - 1])
					  && arg0[i - 1] != '\''))
			    flag13 = true;
			if (i2 >= arg0.length
			    || method173(false, arg0[i2]) && arg0[i2] != '\'')
			    flag14 = true;
			if (!flag13 || !flag14) {
			    boolean flag15 = false;
			    int i16 = i - 2;
			    if (flag13)
				i16 = i;
			    for (; !flag15 && i16 < i2; i16++) {
				if (i16 >= 0 && (!method173(false, arg0[i16])
						 || arg0[i16] == '\'')) {
				    char[] chars = new char[3];
				    int i17;
				    for (i17 = 0; i17 < 3; i17++) {
					if (i16 + i17 >= arg0.length
					    || (method173(false,
							  arg0[i16 + i17])
						&& arg0[i16 + i17] != '\''))
					    break;
					chars[i17] = arg0[i16 + i17];
				    }
				    boolean flag18 = true;
				    if (i17 == 0)
					flag18 = false;
				    if (i17 < 3 && i16 - 1 >= 0
					&& (!method173(false, arg0[i16 - 1])
					    || arg0[i16 - 1] == '\''))
					flag18 = false;
				    if (flag18 && !method179(chars, -136))
					flag15 = true;
				}
			    }
			    if (!flag15)
				flag9 = false;
			}
		    }
		    if (flag9) {
			int i19 = 0;
			for (int i20 = i; i20 < i2; i20++) {
			    if (method176(arg0[i20], 0))
				i19++;
			}
			if (i19 * 100 / (i2 - i) <= 50) {
			    for (int i21 = i; i21 < i2; i21++)
				arg0[i21] = '*';
			}
		    }
		}
	    }
	}
    }
    
    private static final boolean method166(byte[][] arg0, byte arg1, byte arg2,
					   byte arg3) {
	int i = 0;
	if (arg1 != -114)
	    throw new NullPointerException();
	if (arg0[i][0] == arg3 && arg0[i][1] == arg2)
	    return true;
	int i1 = arg0.length - 1;
	if (arg0[i1][0] == arg3 && arg0[i1][1] == arg2)
	    return true;
	do {
	    int i2 = (i + i1) / 2;
	    if (arg0[i2][0] == arg3 && arg0[i2][1] == arg2)
		return true;
	    if (arg3 < arg0[i2][0]
		|| arg3 == arg0[i2][0] && arg2 < arg0[i2][1])
		i1 = i2;
	    else
		i = i2;
	} while (i != i1 && i + 1 != i1);
	return false;
    }
    
    private static final int method167(boolean arg0, char arg1, char arg2,
				       char arg3) {
	if (!arg0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	if (arg1 == arg3)
	    return 1;
	if (arg1 == 'o' && arg3 == '0')
	    return 1;
	if (arg1 == 'o' && arg3 == '(' && arg2 == ')')
	    return 2;
	if (arg1 == 'c' && (arg3 == '(' || arg3 == '<' || arg3 == '['))
	    return 1;
	if (arg1 == 'e' && arg3 == '\u20ac')
	    return 1;
	if (arg1 == 's' && arg3 == '$')
	    return 1;
	if (arg1 == 'l' && arg3 == 'i')
	    return 1;
	return 0;
    }
    
    private static final int method168(char arg0, char arg1, int arg2,
				       char arg3) {
	if (arg2 < 0 || arg2 > 0)
	    return 2;
	if (arg1 == arg0)
	    return 1;
	if (arg1 >= 'a' && arg1 <= 'm') {
	    if (arg1 == 'a') {
		if (arg0 == '4' || arg0 == '@' || arg0 == '^')
		    return 1;
		if (arg0 == '/' && arg3 == '\\')
		    return 2;
		return 0;
	    }
	    if (arg1 == 'b') {
		if (arg0 == '1' && arg3 == '3')
		    return 2;
		return 0;
	    }
	    if (arg1 == 'c') {
		if (arg0 == '(' || arg0 == '<' || arg0 == '{' || arg0 == '[')
		    return 1;
		return 0;
	    }
	    if (arg1 == 'd')
		return 0;
	    if (arg1 == 'e') {
		if (arg0 == '3' || arg0 == '\u20ac')
		    return 1;
		return 0;
	    }
	    if (arg1 == 'f') {
		if (arg0 == 'p' && arg3 == 'h')
		    return 2;
		if (arg0 == '\u00a3')
		    return 1;
		return 0;
	    }
	    if (arg1 == 'g') {
		if (arg0 == '9' || arg0 == '6')
		    return 1;
		return 0;
	    }
	    if (arg1 == 'h') {
		if (arg0 == '#')
		    return 1;
		return 0;
	    }
	    if (arg1 == 'i') {
		if (arg0 == 'y' || arg0 == 'l' || arg0 == 'j' || arg0 == '1'
		    || arg0 == '!' || arg0 == ':' || arg0 == ';'
		    || arg0 == '|')
		    return 1;
		return 0;
	    }
	    if (arg1 == 'j')
		return 0;
	    if (arg1 == 'k')
		return 0;
	    if (arg1 == 'l') {
		if (arg0 == '1' || arg0 == '|' || arg0 == 'i')
		    return 1;
		return 0;
	    }
	    if (arg1 == 'm')
		return 0;
	}
	if (arg1 >= 'n' && arg1 <= 'z') {
	    if (arg1 == 'n')
		return 0;
	    if (arg1 == 'o') {
		if (arg0 == '0' || arg0 == '*')
		    return 1;
		if (arg0 == '(' && arg3 == ')' || arg0 == '[' && arg3 == ']'
		    || arg0 == '{' && arg3 == '}'
		    || arg0 == '<' && arg3 == '>')
		    return 2;
		return 0;
	    }
	    if (arg1 == 'p')
		return 0;
	    if (arg1 == 'q')
		return 0;
	    if (arg1 == 'r')
		return 0;
	    if (arg1 == 's') {
		if (arg0 == '5' || arg0 == 'z' || arg0 == '$' || arg0 == '2')
		    return 1;
		return 0;
	    }
	    if (arg1 == 't') {
		if (arg0 == '7')
		    return 1;
		return 0;
	    }
	    if (arg1 == 'u') {
		if (arg0 == 'v')
		    return 1;
		if (arg0 == '\\' && arg3 == '/' || arg0 == '\\' && arg3 == '|'
		    || arg0 == '|' && arg3 == '/')
		    return 2;
		return 0;
	    }
	    if (arg1 == 'v') {
		if (arg0 == '\\' && arg3 == '/' || arg0 == '\\' && arg3 == '|'
		    || arg0 == '|' && arg3 == '/')
		    return 2;
		return 0;
	    }
	    if (arg1 == 'w') {
		if (arg0 == 'v' && arg3 == 'v')
		    return 2;
		return 0;
	    }
	    if (arg1 == 'x') {
		if (arg0 == ')' && arg3 == '(' || arg0 == '}' && arg3 == '{'
		    || arg0 == ']' && arg3 == '['
		    || arg0 == '>' && arg3 == '<')
		    return 2;
		return 0;
	    }
	    if (arg1 == 'y')
		return 0;
	    if (arg1 == 'z')
		return 0;
	}
	if (arg1 >= '0' && arg1 <= '9') {
	    if (arg1 == '0') {
		if (arg0 == 'o' || arg0 == 'O')
		    return 1;
		if (arg0 == '(' && arg3 == ')' || arg0 == '{' && arg3 == '}'
		    || arg0 == '[' && arg3 == ']')
		    return 2;
		return 0;
	    }
	    if (arg1 == '1') {
		if (arg0 == 'l')
		    return 1;
		return 0;
	    }
	    return 0;
	}
	if (arg1 == ',') {
	    if (arg0 == '.')
		return 1;
	    return 0;
	}
	if (arg1 == '.') {
	    if (arg0 == ',')
		return 1;
	    return 0;
	}
	if (arg1 == '!') {
	    if (arg0 == 'i')
		return 1;
	    return 0;
	}
	return 0;
    }
    
    private static final byte method169(byte arg0, char arg1) {
	if (arg0 == 9) {
	    boolean flag = false;
	} else
	    throw new NullPointerException();
	if (arg1 >= 'a' && arg1 <= 'z')
	    return (byte) (arg1 - 'a' + '\001');
	if (arg1 == '\'')
	    return (byte) 28;
	if (arg1 >= '0' && arg1 <= '9')
	    return (byte) (arg1 - '0' + '\035');
	return (byte) 27;
    }
    
    private static final void method170(char[] arg0, int arg1) {
	boolean flag = false;
	if (arg1 != 10513)
	    anInt263 = 58;
	int i = 0;
	int i1 = 0;
	int i2 = 0;
	int i3;
	while ((i3 = method171(arg0, i, 0)) != -1) {
	    boolean flag4 = false;
	    for (int i5 = i; i5 >= 0 && i5 < i3 && !flag4; i5++) {
		if (!method173(false, arg0[i5])
		    && !method174(anInt265, arg0[i5]))
		    flag4 = true;
	    }
	    if (flag4)
		i1 = 0;
	    if (i1 == 0)
		i2 = i3;
	    i = method172(-34716, arg0, i3);
	    int i6 = 0;
	    for (int i7 = i3; i7 < i; i7++)
		i6 = i6 * 10 + arg0[i7] - 48;
	    if (i6 > 255 || i - i3 > 8)
		i1 = 0;
	    else
		i1++;
	    if (i1 == 4) {
		for (int i8 = i2; i8 < i; i8++)
		    arg0[i8] = '*';
		i1 = 0;
	    }
	}
    }
    
    private static final int method171(char[] arg0, int arg1, int arg2) {
	if (arg2 != 0)
	    return anInt265;
	for (int i = arg1; i < arg0.length && i >= 0; i++) {
	    if (arg0[i] >= '0' && arg0[i] <= '9')
		return i;
	}
	return -1;
    }
    
    private static final int method172(int arg0, char[] arg1, int arg2) {
	for (int i = arg2; i < arg1.length && i >= 0; i++) {
	    if (arg1[i] < '0' || arg1[i] > '9')
		return i;
	}
	if (arg0 != -34716)
	    return anInt265;
	return arg1.length;
    }
    
    private static final boolean method173(boolean arg0, char arg1) {
	if (arg0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	if (method175(arg1, 0) || method176(arg1, 0))
	    return false;
	return true;
    }
    
    private static final boolean method174(int arg0, char arg1) {
	if (arg0 != 0)
	    throw new NullPointerException();
	if (arg1 < 'a' || arg1 > 'z')
	    return true;
	if (arg1 == 'v' || arg1 == 'x' || arg1 == 'j' || arg1 == 'q'
	    || arg1 == 'z')
	    return true;
	return false;
    }
    
    private static final boolean method175(char arg0, int arg1) {
	if (arg1 != 0)
	    anInt263 = 10;
	if ((arg0 < 'a' || arg0 > 'z') && (arg0 < 'A' || arg0 > 'Z'))
	    return false;
	return true;
    }
    
    private static final boolean method176(char arg0, int arg1) {
	if (arg1 != 0)
	    throw new NullPointerException();
	if (arg0 < '0' || arg0 > '9')
	    return false;
	return true;
    }
    
    private static final boolean method177(byte arg0, char arg1) {
	if (arg0 != 7)
	    throw new NullPointerException();
	if (arg1 < 'a' || arg1 > 'z')
	    return false;
	return true;
    }
    
    private static final boolean method178(char arg0, byte arg1) {
	if (arg1 != 85)
	    anInt265 = -437;
	if (arg0 < 'A' || arg0 > 'Z')
	    return false;
	return true;
    }
    
    private static final boolean method179(char[] arg0, int arg1) {
	boolean flag = true;
	if (arg1 >= 0)
	    aBoolean259 = !aBoolean259;
	for (int i = 0; i < arg0.length; i++) {
	    if (!method176(arg0[i], 0) && arg0[i] != 0)
		flag = false;
	}
	if (flag)
	    return true;
	int i = method180((byte) 123, arg0);
	int i1 = 0;
	int i2 = anIntArray266.length - 1;
	if (i == anIntArray266[i1] || i == anIntArray266[i2])
	    return true;
	do {
	    int i3 = (i1 + i2) / 2;
	    if (i == anIntArray266[i3])
		return true;
	    if (i < anIntArray266[i3])
		i2 = i3;
	    else
		i1 = i3;
	} while (i1 != i2 && i1 + 1 != i2);
	return false;
    }
    
    private static final int method180(byte arg0, char[] arg1) {
	if (arg0 != 123)
	    return anInt263;
	if (arg1.length > 6)
	    return 0;
	int i = 0;
	for (int i1 = 0; i1 < arg1.length; i1++) {
	    int i2 = arg1[arg1.length - i1 - 1];
	    if (i2 >= 97 && i2 <= 122)
		i = i * 38 + (i2 - 97 + 1);
	    else if (i2 == 39)
		i = i * 38 + 27;
	    else if (i2 >= 48 && i2 <= 57)
		i = i * 38 + (i2 - 48 + 28);
	    else if (i2 != 0)
		return 0;
	}
	return i;
    }
}
