
final class Class3
{
    private int anInt55 = 8;
    private int anInt56 = -836;
    private boolean aBoolean57 = false;
    private byte aByte58 = 2;
    static boolean aBoolean59 = true;
    static int anInt60;
    private int anInt61;
    private int anInt62;
    private int[][][] anIntArrayArrayArray63;
    private byte[][][] aByteArrayArrayArray64;
    private byte[][][] aByteArrayArrayArray65;
    private byte[][][] aByteArrayArrayArray66;
    private byte[][][] aByteArrayArrayArray67;
    private byte[][][] aByteArrayArrayArray68;
    private byte[][][] aByteArrayArrayArray69;
    private int[][] anIntArrayArray70;
    private int[] anIntArray71;
    private int[] anIntArray72;
    private int[] anIntArray73;
    private int[] anIntArray74;
    private int[] anIntArray75;
    private int[][][] anIntArrayArrayArray76;
    private static final int[] anIntArray77 = { 1, 2, 4, 8 };
    private static final int[] anIntArray78 = { 16, 32, 64, 128 };
    private static final int[] anIntArray79 = { 1, 0, -1, 0 };
    private static final int[] anIntArray80 = { 0, -1, 0, 1 };
    
    public Class3(byte[][][] arg0, int[][][] arg1, int arg2, int arg3,
		  int arg4) {
	anInt61 = arg2;
	anInt62 = arg3;
	anIntArrayArrayArray63 = arg1;
	aByteArrayArrayArray64 = arg0;
	aByteArrayArrayArray65 = new byte[4][anInt61][anInt62];
	aByteArrayArrayArray66 = new byte[4][anInt61][anInt62];
	aByteArrayArrayArray67 = new byte[4][anInt61][anInt62];
	aByteArrayArrayArray68 = new byte[4][anInt61][anInt62];
	if (arg4 != anInt55)
	    anInt56 = 395;
	anIntArrayArrayArray76 = new int[4][anInt61 + 1][anInt62 + 1];
	aByteArrayArrayArray69 = new byte[4][anInt61 + 1][anInt62 + 1];
	anIntArrayArray70 = new int[anInt61 + 1][anInt62 + 1];
	anIntArray71 = new int[anInt62];
	anIntArray72 = new int[anInt62];
	anIntArray73 = new int[anInt62];
	anIntArray74 = new int[anInt62];
	anIntArray75 = new int[anInt62];
    }
    
    public final void method107(int arg0, int arg1, int arg2, int arg3,
				byte arg4) {
	byte i = 0;
	if (arg4 != -98)
	    aBoolean57 = !aBoolean57;
	for (int i1 = 0; i1 < Class2.anInt43; i1++) {
	    if (Class2.aClass2Array44[i1].aString49
		    .equalsIgnoreCase("water")) {
		i = (byte) (i1 + 1);
		break;
	    }
	}
	for (int i2 = arg0; i2 < arg0 + arg2; i2++) {
	    for (int i3 = arg3; i3 < arg3 + arg1; i3++) {
		if (i3 >= 0 && i3 < anInt61 && i2 >= 0 && i2 < anInt62) {
		    aByteArrayArrayArray66[0][i3][i2] = i;
		    for (int i4 = 0; i4 < 4; i4++) {
			anIntArrayArrayArray63[i4][i3][i2] = 0;
			aByteArrayArrayArray64[i4][i3][i2] = (byte) 0;
		    }
		}
	    }
	}
    }
    
    public final void method108(int arg0, byte[] arg1, int arg2, int arg3,
				int arg4, int arg5) {
	if (arg0 == -16770) {
	    Class33_Sub2_Sub3 class33_sub2_sub3
		= new Class33_Sub2_Sub3(arg1, (byte) 63);
	    for (int i = 0; i < 4; i++) {
		for (int i1 = 0; i1 < 64; i1++) {
		    for (int i2 = 0; i2 < 64; i2++) {
			int i3 = i1 + arg4;
			int i4 = i2 + arg3;
			if (i3 >= 0 && i3 < 104 && i4 >= 0 && i4 < 104) {
			    aByteArrayArrayArray64[i][i3][i4] = (byte) 0;
			    for (;;) {
				int i5 = class33_sub2_sub3.method342();
				if (i5 == 0) {
				    if (i == 0)
					anIntArrayArrayArray63[0][i3][i4]
					    = (-method112(i3 + 932731 + arg2,
							  i4 + 556238 + arg5)
					       * 8);
				    else
					anIntArrayArrayArray63[i][i3][i4]
					    = (anIntArrayArrayArray63[i - 1]
					       [i3][i4]) - 240;
				    break;
				}
				if (i5 == 1) {
				    int i6 = class33_sub2_sub3.method342();
				    if (i6 == 1)
					i6 = 0;
				    if (i == 0)
					anIntArrayArrayArray63[0][i3][i4]
					    = -i6 * 8;
				    else
					anIntArrayArrayArray63[i][i3][i4]
					    = (anIntArrayArrayArray63[i - 1]
					       [i3][i4]) - i6 * 8;
				    break;
				}
				if (i5 <= 49) {
				    aByteArrayArrayArray66[i][i3][i4]
					= class33_sub2_sub3.method343();
				    aByteArrayArrayArray67[i][i3][i4]
					= (byte) ((i5 - 2) / 4);
				    aByteArrayArrayArray68[i][i3][i4]
					= (byte) (i5 - 2 & 0x3);
				} else if (i5 <= 81)
				    aByteArrayArrayArray64[i][i3][i4]
					= (byte) (i5 - 49);
				else
				    aByteArrayArrayArray65[i][i3][i4]
					= (byte) (i5 - 81);
			    }
			} else {
			    for (;;) {
				int i7 = class33_sub2_sub3.method342();
				if (i7 == 0)
				    break;
				if (i7 == 1) {
				    class33_sub2_sub3.method342();
				    break;
				}
				if (i7 <= 49)
				    class33_sub2_sub3.method342();
			    }
			}
		    }
		}
	    }
	}
    }
    
    public final void method109(byte[] arg0, Class22 arg1, Class1[] arg2,
				Class27 arg3, int arg4, int arg5, int arg6) {
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg0, (byte) 63);
	while (arg6 >= 0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	int i = -1;
	for (;;) {
	    int i1 = class33_sub2_sub3.method356();
	    if (i1 == 0)
		break;
	    i += i1;
	    int i2 = 0;
	    for (;;) {
		int i3 = class33_sub2_sub3.method356();
		if (i3 == 0)
		    break;
		i2 += i3 - 1;
		int i4 = i2 & 0x3f;
		int i5 = i2 >> 6 & 0x3f;
		int i6 = i2 >> 12;
		int i7 = class33_sub2_sub3.method342();
		int i8 = i7 >> 2;
		int i9 = i7 & 0x3;
		int i10 = i5 + arg5;
		int i11 = i4 + arg4;
		if (i10 > 0 && i11 > 0 && i10 < 103 && i11 < 103)
		    method110(arg3, arg1, i, i6, i8, i9, -420, i11, arg2[i6],
			      i10);
	    }
	}
    }
    
    private final void method110(Class27 arg0, Class22 arg1, int arg2,
				 int arg3, int arg4, int arg5, int arg6,
				 int arg7, Class1 arg8, int arg9) {
	if (aBoolean59) {
	    int i = arg3;
	    if (i > 0 && (aByteArrayArrayArray64[1][arg9][arg7] & 0x2) != 0)
		i--;
	    if ((aByteArrayArrayArray64[arg3][arg9][arg7] & 0x8) != 0)
		i = 0;
	    if (i != anInt60
		|| (aByteArrayArrayArray64[arg3][arg9][arg7] & 0x10) != 0)
		return;
	}
	int i = anIntArrayArrayArray63[arg3][arg9][arg7];
	int i1 = anIntArrayArrayArray63[arg3][arg9 + 1][arg7];
	int i2 = anIntArrayArrayArray63[arg3][arg9 + 1][arg7 + 1];
	int i3 = anIntArrayArrayArray63[arg3][arg9][arg7 + 1];
	if (arg6 < 0) {
	    int i4 = i + i1 + i2 + i3 >> 2;
	    Class37 class37 = Class37.method383(arg2);
	    int i5 = arg9 + (arg7 << 7) + (arg2 << 14) + 1073741824;
	    if (!class37.aBoolean536)
		i5 -= -2147483648;
	    byte i6 = (byte) ((arg5 << 6) + arg4);
	    if (arg4 == 22) {
		if (!aBoolean59 || class37.aBoolean536) {
		    Class33_Sub2_Sub1 class33_sub2_sub1
			= class37.method386(22, arg5, i, i1, i2, i3, -1);
		    arg0.method200(class33_sub2_sub1, arg9, i6, 0, i4, arg3,
				   arg7, i5);
		    if (class37.aBoolean534 && class37.aBoolean536)
			arg8.method95((byte) 0, arg7, arg9);
		}
	    } else if (arg4 == 10 || arg4 == 11) {
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(10, arg5, i, i1, i2, i3, -1);
		if (class33_sub2_sub1 != null) {
		    int i7 = 0;
		    if (arg4 == 11)
			i7 += 256;
		    int i8;
		    int i9;
		    if (arg5 == 1 || arg5 == 3) {
			i8 = class37.anInt533;
			i9 = class37.anInt532;
		    } else {
			i8 = class37.anInt532;
			i9 = class37.anInt533;
		    }
		    if (arg0.method204(i5, arg7, class33_sub2_sub1, i9,
				       (byte) -14, i7, arg3, arg9, i4, i6,
				       null, i8)
			&& class37.aBoolean549) {
			for (int i10 = 0; i10 <= i8; i10++) {
			    for (int i11 = 0; i11 <= i9; i11++) {
				int i12 = class33_sub2_sub1.anInt1029 / 4;
				if (i12 > 30)
				    i12 = 30;
				if (i12 > (aByteArrayArrayArray69[arg3]
					   [arg9 + i10][arg7 + i11]))
				    aByteArrayArrayArray69[arg3]
					[arg9 + i10][arg7 + i11]
					= (byte) i12;
			    }
			}
		    }
		}
		if (class37.aBoolean534)
		    arg8.method94(true, class37.anInt532, arg9, arg7,
				  class37.aBoolean535, arg5, class37.anInt533);
		if (class37.anInt540 != -1)
		    arg1.method181(new Class33_Sub5(2, arg3, arg2, 5858,
						    (Class10.aClass10Array183
						     [class37.anInt540]),
						    arg9, arg7));
	    } else if (arg4 >= 12) {
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(arg4, arg5, i, i1, i2, i3, -1);
		arg0.method204(i5, arg7, class33_sub2_sub1, 1, (byte) -14, 0,
			       arg3, arg9, i4, i6, null, 1);
		if (arg4 >= 12 && arg4 <= 17 && arg4 != 13 && arg3 > 0)
		    anIntArrayArrayArray76[arg3][arg9][arg7] |= 0x924;
		if (class37.aBoolean534)
		    arg8.method94(true, class37.anInt532, arg9, arg7,
				  class37.aBoolean535, arg5, class37.anInt533);
		if (class37.anInt540 != -1)
		    arg1.method181(new Class33_Sub5(2, arg3, arg2, 5858,
						    (Class10.aClass10Array183
						     [class37.anInt540]),
						    arg9, arg7));
	    } else if (arg4 == 0) {
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(0, arg5, i, i1, i2, i3, -1);
		arg0.method202(i4, anIntArray77[arg5], i6, 0, i5, (byte) -120,
			       arg7, arg9, null, arg3, class33_sub2_sub1);
		if (arg5 == 0) {
		    if (class37.aBoolean549) {
			aByteArrayArrayArray69[arg3][arg9][arg7] = (byte) 50;
			aByteArrayArrayArray69[arg3][arg9][arg7 + 1]
			    = (byte) 50;
		    }
		    if (class37.aBoolean539)
			anIntArrayArrayArray76[arg3][arg9][arg7] |= 0x249;
		} else if (arg5 == 1) {
		    if (class37.aBoolean549) {
			aByteArrayArrayArray69[arg3][arg9][arg7 + 1]
			    = (byte) 50;
			aByteArrayArrayArray69[arg3][arg9 + 1][arg7 + 1]
			    = (byte) 50;
		    }
		    if (class37.aBoolean539)
			anIntArrayArrayArray76[arg3][arg9][arg7 + 1] |= 0x492;
		} else if (arg5 == 2) {
		    if (class37.aBoolean549) {
			aByteArrayArrayArray69[arg3][arg9 + 1][arg7]
			    = (byte) 50;
			aByteArrayArrayArray69[arg3][arg9 + 1][arg7 + 1]
			    = (byte) 50;
		    }
		    if (class37.aBoolean539)
			anIntArrayArrayArray76[arg3][arg9 + 1][arg7] |= 0x249;
		} else if (arg5 == 3) {
		    if (class37.aBoolean549) {
			aByteArrayArrayArray69[arg3][arg9][arg7] = (byte) 50;
			aByteArrayArrayArray69[arg3][arg9 + 1][arg7]
			    = (byte) 50;
		    }
		    if (class37.aBoolean539)
			anIntArrayArrayArray76[arg3][arg9][arg7] |= 0x492;
		}
		if (class37.aBoolean534)
		    arg8.method93(arg9, class37.aBoolean535, arg4, arg7,
				  -34301, arg5);
	    } else if (arg4 == 1) {
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(1, arg5, i, i1, i2, i3, -1);
		arg0.method202(i4, anIntArray78[arg5], i6, 0, i5, (byte) -120,
			       arg7, arg9, null, arg3, class33_sub2_sub1);
		if (class37.aBoolean549) {
		    if (arg5 == 0)
			aByteArrayArrayArray69[arg3][arg9][arg7 + 1]
			    = (byte) 50;
		    else if (arg5 == 1)
			aByteArrayArrayArray69[arg3][arg9 + 1][arg7 + 1]
			    = (byte) 50;
		    else if (arg5 == 2)
			aByteArrayArrayArray69[arg3][arg9 + 1][arg7]
			    = (byte) 50;
		    else if (arg5 == 3)
			aByteArrayArrayArray69[arg3][arg9][arg7] = (byte) 50;
		}
		if (class37.aBoolean534)
		    arg8.method93(arg9, class37.aBoolean535, arg4, arg7,
				  -34301, arg5);
	    } else if (arg4 == 2) {
		int i13 = arg5 + 1 & 0x3;
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(2, arg5 + 4, i, i1, i2, i3, -1);
		Class33_Sub2_Sub1 class33_sub2_sub1_14
		    = class37.method386(2, i13, i, i1, i2, i3, -1);
		arg0.method202(i4, anIntArray77[arg5], i6, anIntArray77[i13],
			       i5, (byte) -120, arg7, arg9,
			       class33_sub2_sub1_14, arg3, class33_sub2_sub1);
		if (class37.aBoolean539) {
		    if (arg5 == 0) {
			anIntArrayArrayArray76[arg3][arg9][arg7] |= 0x249;
			anIntArrayArrayArray76[arg3][arg9][arg7 + 1] |= 0x492;
		    } else if (arg5 == 1) {
			anIntArrayArrayArray76[arg3][arg9][arg7 + 1] |= 0x492;
			anIntArrayArrayArray76[arg3][arg9 + 1][arg7] |= 0x249;
		    } else if (arg5 == 2) {
			anIntArrayArrayArray76[arg3][arg9 + 1][arg7] |= 0x249;
			anIntArrayArrayArray76[arg3][arg9][arg7] |= 0x492;
		    } else if (arg5 == 3) {
			anIntArrayArrayArray76[arg3][arg9][arg7] |= 0x492;
			anIntArrayArrayArray76[arg3][arg9][arg7] |= 0x249;
		    }
		}
		if (class37.aBoolean534)
		    arg8.method93(arg9, class37.aBoolean535, arg4, arg7,
				  -34301, arg5);
	    } else if (arg4 == 3) {
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(3, arg5, i, i1, i2, i3, -1);
		arg0.method202(i4, anIntArray78[arg5], i6, 0, i5, (byte) -120,
			       arg7, arg9, null, arg3, class33_sub2_sub1);
		if (class37.aBoolean549) {
		    if (arg5 == 0)
			aByteArrayArrayArray69[arg3][arg9][arg7 + 1]
			    = (byte) 50;
		    else if (arg5 == 1)
			aByteArrayArrayArray69[arg3][arg9 + 1][arg7 + 1]
			    = (byte) 50;
		    else if (arg5 == 2)
			aByteArrayArrayArray69[arg3][arg9 + 1][arg7]
			    = (byte) 50;
		    else if (arg5 == 3)
			aByteArrayArrayArray69[arg3][arg9][arg7] = (byte) 50;
		}
		if (class37.aBoolean534)
		    arg8.method93(arg9, class37.aBoolean535, arg4, arg7,
				  -34301, arg5);
	    } else if (arg4 == 9) {
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(arg4, arg5, i, i1, i2, i3, -1);
		arg0.method204(i5, arg7, class33_sub2_sub1, 1, (byte) -14, 0,
			       arg3, arg9, i4, i6, null, 1);
		if (class37.aBoolean534)
		    arg8.method94(true, class37.anInt532, arg9, arg7,
				  class37.aBoolean535, arg5, class37.anInt533);
	    } else if (arg4 == 4) {
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(4, 0, i, i1, i2, i3, -1);
		arg0.method203(i6, i5, class33_sub2_sub1, 0, arg9, false,
			       anIntArray77[arg5], arg3, i4, arg7, arg5 * 512,
			       0);
		if (class37.anInt540 != -1)
		    arg1.method181(new Class33_Sub5(1, arg3, arg2, 5858,
						    (Class10.aClass10Array183
						     [class37.anInt540]),
						    arg9, arg7));
	    } else if (arg4 == 5) {
		int i15 = 16;
		int i16 = arg0.method217(arg3, arg9, arg7);
		if (i16 > 0)
		    i15 = Class37.method383(i16 >> 14 & 0x7fff).anInt541;
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(4, 0, i, i1, i2, i3, -1);
		arg0.method203(i6, i5, class33_sub2_sub1,
			       anIntArray80[arg5] * i15, arg9, false,
			       anIntArray77[arg5], arg3, i4, arg7, arg5 * 512,
			       anIntArray79[arg5] * i15);
		if (class37.anInt540 != -1)
		    arg1.method181(new Class33_Sub5(1, arg3, arg2, 5858,
						    (Class10.aClass10Array183
						     [class37.anInt540]),
						    arg9, arg7));
	    } else if (arg4 == 6) {
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(4, 0, i, i1, i2, i3, -1);
		arg0.method203(i6, i5, class33_sub2_sub1, 0, arg9, false, 256,
			       arg3, i4, arg7, arg5, 0);
		if (class37.anInt540 != -1)
		    arg1.method181(new Class33_Sub5(1, arg3, arg2, 5858,
						    (Class10.aClass10Array183
						     [class37.anInt540]),
						    arg9, arg7));
	    } else if (arg4 == 7) {
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(4, 0, i, i1, i2, i3, -1);
		arg0.method203(i6, i5, class33_sub2_sub1, 0, arg9, false, 512,
			       arg3, i4, arg7, arg5, 0);
		if (class37.anInt540 != -1)
		    arg1.method181(new Class33_Sub5(1, arg3, arg2, 5858,
						    (Class10.aClass10Array183
						     [class37.anInt540]),
						    arg9, arg7));
	    } else if (arg4 == 8) {
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = class37.method386(4, 0, i, i1, i2, i3, -1);
		arg0.method203(i6, i5, class33_sub2_sub1, 0, arg9, false, 768,
			       arg3, i4, arg7, arg5, 0);
		if (class37.anInt540 != -1)
		    arg1.method181(new Class33_Sub5(1, arg3, arg2, 5858,
						    (Class10.aClass10Array183
						     [class37.anInt540]),
						    arg9, arg7));
	    }
	}
    }
    
    public final void method111(Class1[] arg0, Class27 arg1, int arg2) {
	Class1 class1 = null;
	for (int i = 0; i < 4; i++) {
	    Class1 class1_1 = arg0[i];
	    for (int i2 = 0; i2 < 104; i2++) {
		for (int i3 = 0; i3 < 104; i3++) {
		    if ((aByteArrayArrayArray64[i][i2][i3] & 0x1) == 1)
			class1_1.method95((byte) 0, i3, i2);
		    if (i > 0
			&& (aByteArrayArrayArray64[1][i2][i3] & 0x2) == 2)
			class1.anIntArrayArray41[i2][i3]
			    = class1_1.anIntArrayArray41[i2][i3];
		}
	    }
	    class1 = class1_1;
	}
	for (int i = 0; i < 4; i++) {
	    byte[][] is = aByteArrayArrayArray69[i];
	    int i4 = 96;
	    int i5 = 768;
	    int i6 = -50;
	    int i7 = -10;
	    int i8 = -50;
	    int i9 = (int) Math.sqrt((double) (i6 * i6 + i7 * i7 + i8 * i8));
	    int i10 = i5 * i9 >> 8;
	    for (int i11 = 1; i11 < anInt62 - 1; i11++) {
		for (int i12 = 1; i12 < anInt61 - 1; i12++) {
		    int i13 = (anIntArrayArrayArray63[i][i12 + 1][i11]
			       - anIntArrayArrayArray63[i][i12 - 1][i11]);
		    int i14 = (anIntArrayArrayArray63[i][i12][i11 + 1]
			       - anIntArrayArrayArray63[i][i12][i11 - 1]);
		    int i15 = (int) Math.sqrt((double) (i13 * i13 + 65536
							+ i14 * i14));
		    int i16 = (i13 << 8) / i15;
		    int i17 = 65536 / i15;
		    int i18 = (i14 << 8) / i15;
		    int i19 = i4 + (i6 * i16 + i7 * i17 + i8 * i18) / i10;
		    int i20
			= ((is[i12 - 1][i11] >> 2) + (is[i12 + 1][i11] >> 3)
			   + (is[i12][i11 - 1] >> 2) + (is[i12][i11 + 1] >> 3)
			   + (is[i12][i11] >> 1));
		    anIntArrayArray70[i12][i11] = i19 - i20;
		}
	    }
	    for (int i21 = 0; i21 < anInt62; i21++) {
		anIntArray71[i21] = 0;
		anIntArray72[i21] = 0;
		anIntArray73[i21] = 0;
		anIntArray74[i21] = 0;
		anIntArray75[i21] = 0;
	    }
	    for (int i22 = -5; i22 < anInt61 + 5; i22++) {
		for (int i23 = 0; i23 < anInt62; i23++) {
		    int i24 = i22 + 5;
		    if (i24 >= 0 && i24 < anInt61) {
			int i25 = aByteArrayArrayArray65[i][i24][i23] & 0xff;
			if (i25 > 0) {
			    Class2 class2 = Class2.aClass2Array44[i25 - 1];
			    anIntArray71[i23] += class2.anInt53;
			    anIntArray72[i23] += class2.anInt51;
			    anIntArray73[i23] += class2.anInt52;
			    anIntArray74[i23] += class2.anInt54;
			    anIntArray75[i23]++;
			}
		    }
		    int i26 = i22 - 5;
		    if (i26 >= 0 && i26 < anInt61) {
			int i27 = aByteArrayArrayArray65[i][i26][i23] & 0xff;
			if (i27 > 0) {
			    Class2 class2 = Class2.aClass2Array44[i27 - 1];
			    anIntArray71[i23] -= class2.anInt53;
			    anIntArray72[i23] -= class2.anInt51;
			    anIntArray73[i23] -= class2.anInt52;
			    anIntArray74[i23] -= class2.anInt54;
			    anIntArray75[i23]--;
			}
		    }
		}
		if (i22 >= 1 && i22 < anInt61 - 1) {
		    int i28 = 0;
		    int i29 = 0;
		    int i30 = 0;
		    int i31 = 0;
		    int i32 = 0;
		    int i33 = -5;
		    for (; i33 < anInt62 + 5; i33++) {
			int i34 = i33 + 5;
			if (i34 >= 0 && i34 < anInt62) {
			    i28 += anIntArray71[i34];
			    i29 += anIntArray72[i34];
			    i30 += anIntArray73[i34];
			    i31 += anIntArray74[i34];
			    i32 += anIntArray75[i34];
			}
			int i35 = i33 - 5;
			if (i35 >= 0 && i35 < anInt62) {
			    i28 -= anIntArray71[i35];
			    i29 -= anIntArray72[i35];
			    i30 -= anIntArray73[i35];
			    i31 -= anIntArray74[i35];
			    i32 -= anIntArray75[i35];
			}
			if (i33 >= 1 && i33 < anInt62 - 1) {
			    if (aBoolean59) {
				int i36 = i;
				if (i > 0
				    && (aByteArrayArrayArray64[1][i22][i33]
					& 0x2) != 0)
				    i36--;
				if ((aByteArrayArrayArray64[i][i22][i33] & 0x8)
				    != 0)
				    i36 = 0;
				if (i36 != anInt60
				    || (aByteArrayArrayArray64[i][i22][i33]
					& 0x10) != 0)
				    continue;
			    }
			    int i37
				= aByteArrayArrayArray65[i][i22][i33] & 0xff;
			    int i38
				= aByteArrayArrayArray66[i][i22][i33] & 0xff;
			    if (i37 > 0 || i38 > 0) {
				int i39 = anIntArrayArrayArray63[i][i22][i33];
				int i40
				    = anIntArrayArrayArray63[i][i22 + 1][i33];
				int i41 = (anIntArrayArrayArray63[i][i22 + 1]
					   [i33 + 1]);
				int i42
				    = anIntArrayArrayArray63[i][i22][i33 + 1];
				int i43 = anIntArrayArray70[i22][i33];
				int i44 = anIntArrayArray70[i22 + 1][i33];
				int i45 = anIntArrayArray70[i22 + 1][i33 + 1];
				int i46 = anIntArrayArray70[i22][i33 + 1];
				int i47 = -1;
				if (i37 > 0)
				    i47 = method119(i28 * 256 / i31, i29 / i32,
						    i30 / i32);
				if (i > 0 && !aBoolean59) {
				    boolean flag = true;
				    if (i37 == 0
					&& (aByteArrayArrayArray67[i][i22][i33]
					    != 0))
					flag = false;
				    if (i38 > 0 && !(Class2.aClass2Array44
						     [i38 - 1].aBoolean48))
					flag = false;
				    if (flag && i39 == i40 && i39 == i41
					&& i39 == i42)
					anIntArrayArrayArray76[i][i22][i33]
					    |= 0x924;
				}
				int i48 = 0;
				if (i47 != -1)
				    i48 = (Class33_Sub2_Sub2_Sub1
					   .anIntArray1230
					   [method117(i47, 96)]);
				if (i38 == 0)
				    arg1.method199(i, i22, i33, 0, 0, -1, i39,
						   i40, i41, i42,
						   method117(i47, i43),
						   method117(i47, i44),
						   method117(i47, i45),
						   method117(i47, i46), 0, 0,
						   0, 0, i48, 0);
				else {
				    int i49
					= (aByteArrayArrayArray67[i][i22][i33]
					   + 1);
				    byte i50
					= aByteArrayArrayArray68[i][i22][i33];
				    Class2 class2
					= Class2.aClass2Array44[i38 - 1];
				    int i51 = class2.anInt46;
				    int i52;
				    int i53;
				    if (i51 >= 0) {
					i52 = Class33_Sub2_Sub2_Sub1
						  .method298(i51, 47117);
					i53 = -1;
				    } else if (class2.anInt45 == 16711935) {
					i52 = 0;
					i53 = -2;
					i51 = -1;
				    } else {
					i53 = method119(class2.anInt50,
							class2.anInt51,
							class2.anInt52);
					i52 = (Class33_Sub2_Sub2_Sub1
					       .anIntArray1230
					       [method118(i53, 96)]);
				    }
				    arg1.method199(i, i22, i33, i49, i50, i51,
						   i39, i40, i41, i42,
						   method117(i47, i43),
						   method117(i47, i44),
						   method117(i47, i45),
						   method117(i47, i46),
						   method118(i53, i43),
						   method118(i53, i44),
						   method118(i53, i45),
						   method118(i53, i46), i48,
						   i52);
				}
			    }
			}
		    }
		}
	    }
	    for (int i54 = 1; i54 < anInt62 - 1; i54++) {
		for (int i55 = 1; i55 < anInt61 - 1; i55++) {
		    int i56 = i;
		    if (i56 > 0
			&& (aByteArrayArrayArray64[1][i55][i54] & 0x2) != 0)
			i56--;
		    if ((aByteArrayArrayArray64[i][i55][i54] & 0x8) != 0)
			i56 = 0;
		    arg1.method198(i, i55, i54, i56);
		}
	    }
	}
	arg1.method222(-50, 64, aByte58, 768, -10, -50);
	for (int i = 0; i < anInt61; i++) {
	    for (int i57 = 0; i57 < anInt62; i57++) {
		if ((aByteArrayArrayArray64[1][i][i57] & 0x2) == 2)
		    arg1.method196(i, 53, i57);
	    }
	}
	int i = 1;
	int i58 = 2;
	int i59 = 4;
	for (int i60 = 0; i60 < 4; i60++) {
	    if (i60 > 0) {
		i <<= 3;
		i58 <<= 3;
		i59 <<= 3;
	    }
	    for (int i61 = 0; i61 <= i60; i61++) {
		for (int i62 = 0; i62 <= anInt62; i62++) {
		    for (int i63 = 0; i63 <= anInt61; i63++) {
			if ((anIntArrayArrayArray76[i61][i63][i62] & i) != 0) {
			    int i64 = i62;
			    int i65 = i62;
			    int i66 = i61;
			    int i67 = i61;
			    for (; i64 > 0; i64--) {
				if ((anIntArrayArrayArray76[i61][i63][i64 - 1]
				     & i)
				    == 0)
				    break;
			    }
			    for (; i65 < anInt62; i65++) {
				if ((anIntArrayArrayArray76[i61][i63][i65 + 1]
				     & i)
				    == 0)
				    break;
			    }
			while0:
			    for (; i66 > 0; i66--) {
				for (int i68 = i64; i68 <= i65; i68++) {
				    if (((anIntArrayArrayArray76[i66 - 1][i63]
					  [i68])
					 & i)
					== 0)
					break while0;
				}
			    }
			while1:
			    for (; i67 < i60; i67++) {
				for (int i69 = i64; i69 <= i65; i69++) {
				    if (((anIntArrayArrayArray76[i67 + 1][i63]
					  [i69])
					 & i)
					== 0)
					break while1;
				}
			    }
			    int i70 = (i67 + 1 - i66) * (i65 - i64 + 1);
			    if (i70 >= 8) {
				int i71 = 240;
				int i72
				    = (anIntArrayArrayArray63[i67][i63][i64]
				       - i71);
				int i73
				    = anIntArrayArrayArray63[i66][i63][i64];
				Class27.method197(i63 * 128, i65 * 128 + 128,
						  i72, i64 * 128, 508, 1,
						  i63 * 128, i73, i60);
				for (int i74 = i66; i74 <= i67; i74++) {
				    for (int i75 = i64; i75 <= i65; i75++)
					anIntArrayArrayArray76[i74][i63][i75]
					    &= i ^ 0xffffffff;
				}
			    }
			}
			if ((anIntArrayArrayArray76[i61][i63][i62] & i58)
			    != 0) {
			    int i76 = i63;
			    int i77 = i63;
			    int i78 = i61;
			    int i79 = i61;
			    for (; i76 > 0; i76--) {
				if ((anIntArrayArrayArray76[i61][i76 - 1][i62]
				     & i58)
				    == 0)
				    break;
			    }
			    for (; i77 < anInt61; i77++) {
				if ((anIntArrayArrayArray76[i61][i77 + 1][i62]
				     & i58)
				    == 0)
				    break;
			    }
			while2:
			    for (; i78 > 0; i78--) {
				for (int i80 = i76; i80 <= i77; i80++) {
				    if (((anIntArrayArrayArray76[i78 - 1][i80]
					  [i62])
					 & i58)
					== 0)
					break while2;
				}
			    }
			while3:
			    for (; i79 < i60; i79++) {
				for (int i81 = i76; i81 <= i77; i81++) {
				    if (((anIntArrayArrayArray76[i79 + 1][i81]
					  [i62])
					 & i58)
					== 0)
					break while3;
				}
			    }
			    int i82 = (i79 + 1 - i78) * (i77 - i76 + 1);
			    if (i82 >= 8) {
				int i83 = 240;
				int i84
				    = (anIntArrayArrayArray63[i79][i76][i62]
				       - i83);
				int i85
				    = anIntArrayArrayArray63[i78][i76][i62];
				Class27.method197(i76 * 128, i62 * 128, i84,
						  i62 * 128, 508, 2,
						  i77 * 128 + 128, i85, i60);
				for (int i86 = i78; i86 <= i79; i86++) {
				    for (int i87 = i76; i87 <= i77; i87++)
					anIntArrayArrayArray76[i86][i87][i62]
					    &= i58 ^ 0xffffffff;
				}
			    }
			}
			if (!aBoolean59
			    && ((anIntArrayArrayArray76[i61][i63][i62] & i59)
				!= 0)) {
			    int i88 = i63;
			    int i89 = i63;
			    int i90 = i62;
			    int i91 = i62;
			    for (; i90 > 0; i90--) {
				if ((anIntArrayArrayArray76[i61][i63][i90 - 1]
				     & i59)
				    == 0)
				    break;
			    }
			    for (; i91 < anInt62; i91++) {
				if ((anIntArrayArrayArray76[i61][i63][i91 + 1]
				     & i59)
				    == 0)
				    break;
			    }
			while4:
			    for (; i88 > 0; i88--) {
				for (int i92 = i90; i92 <= i91; i92++) {
				    if (((anIntArrayArrayArray76[i61][i88 - 1]
					  [i92])
					 & i59)
					== 0)
					break while4;
				}
			    }
			while5:
			    for (; i89 < anInt61; i89++) {
				for (int i93 = i90; i93 <= i91; i93++) {
				    if (((anIntArrayArrayArray76[i61][i89 + 1]
					  [i93])
					 & i59)
					== 0)
					break while5;
				}
			    }
			    if ((i89 - i88 + 1) * (i91 - i90 + 1) >= 4) {
				int i94
				    = anIntArrayArrayArray63[i61][i88][i90];
				Class27.method197(i88 * 128, i91 * 128 + 128,
						  i94, i90 * 128, 508, 4,
						  i89 * 128 + 128, i94, i60);
				for (int i95 = i88; i95 <= i89; i95++) {
				    for (int i96 = i90; i96 <= i91; i96++)
					anIntArrayArrayArray76[i61][i95][i96]
					    &= i59 ^ 0xffffffff;
				}
			    }
			}
		    }
		}
	    }
	}
	if (arg2 >= 0) {
	    for (int i97 = 1; i97 > 0; i97++) {
	    }
	}
    }
    
    private static final int method112(int arg0, int arg1) {
	int i = (method113(arg0 + 45365, arg1 + 91923, 4) - 128
		 + (method113(arg0 + 10294, arg1 + 37821, 2) - 128 >> 1)
		 + (method113(arg0, arg1, 1) - 128 >> 2));
	i = (int) ((double) i * 0.3) + 35;
	if (i < 10)
	    i = 10;
	else if (i > 60)
	    i = 60;
	return i;
    }
    
    private static final int method113(int arg0, int arg1, int arg2) {
	int i = arg0 / arg2;
	int i1 = arg0 & arg2 - 1;
	int i2 = arg1 / arg2;
	int i3 = arg1 & arg2 - 1;
	int i4 = method115(i, i2);
	int i5 = method115(i + 1, i2);
	int i6 = method115(i, i2 + 1);
	int i7 = method115(i + 1, i2 + 1);
	int i8 = method114(i4, i5, i1, arg2);
	int i9 = method114(i6, i7, i1, arg2);
	return method114(i8, i9, i3, arg2);
    }
    
    private static final int method114(int arg0, int arg1, int arg2,
				       int arg3) {
	int i = ((65536
		  - Class33_Sub2_Sub2_Sub1.anIntArray1219[arg2 * 1024 / arg3])
		 >> 1);
	return (arg0 * (65536 - i) >> 16) + (arg1 * i >> 16);
    }
    
    private static final int method115(int arg0, int arg1) {
	int i = (method116(arg0 - 1, arg1 - 1) + method116(arg0 + 1, arg1 - 1)
		 + method116(arg0 - 1, arg1 + 1)
		 + method116(arg0 + 1, arg1 + 1));
	int i1 = (method116(arg0 - 1, arg1) + method116(arg0 + 1, arg1)
		  + method116(arg0, arg1 - 1) + method116(arg0, arg1 + 1));
	int i2 = method116(arg0, arg1);
	return i / 16 + i1 / 8 + i2 / 4;
    }
    
    private static final int method116(int arg0, int arg1) {
	int i = arg0 + arg1 * 57;
	i = i << 13 ^ i;
	int i1 = i * (i * i * 15731 + 789221) + 1376312589 & 0x7fffffff;
	return i1 >> 19 & 0xff;
    }
    
    private static final int method117(int arg0, int arg1) {
	if (arg0 == -1)
	    return 12345678;
	arg1 = arg1 * (arg0 & 0x7f) / 128;
	if (arg1 < 2)
	    arg1 = 2;
	else if (arg1 > 126)
	    arg1 = 126;
	return (arg0 & 0xff80) + arg1;
    }
    
    private final int method118(int arg0, int arg1) {
	if (arg0 == -2)
	    return 12345678;
	if (arg0 == -1) {
	    if (arg1 < 0)
		arg1 = 0;
	    else if (arg1 > 127)
		arg1 = 127;
	    arg1 = 127 - arg1;
	    return arg1;
	}
	arg1 = arg1 * (arg0 & 0x7f) / 128;
	if (arg1 < 2)
	    arg1 = 2;
	else if (arg1 > 126)
	    arg1 = 126;
	return (arg0 & 0xff80) + arg1;
    }
    
    private final int method119(int arg0, int arg1, int arg2) {
	if (arg2 > 179)
	    arg1 /= 2;
	if (arg2 > 192)
	    arg1 /= 2;
	if (arg2 > 217)
	    arg1 /= 2;
	if (arg2 > 243)
	    arg1 /= 2;
	int i = (arg0 / 4 << 10) + (arg1 / 32 << 7) + arg2 / 2;
	return i;
    }
    
    public static final void method120(int arg0, Class22 arg1, int arg2,
				       int arg3, int arg4, Class1 arg5,
				       int[][][] arg6, int arg7, Class27 arg8,
				       int arg9, int arg10, int arg11) {
	int i = arg6[arg0][arg9][arg2];
	int i1 = arg6[arg0][arg9 + 1][arg2];
	int i2 = arg6[arg0][arg9 + 1][arg2 + 1];
	int i3 = arg6[arg0][arg9][arg2 + 1];
	int i4 = i + i1 + i2 + i3 >> 2;
	Class37 class37 = Class37.method383(arg7);
	int i5 = arg9 + (arg2 << 7) + (arg7 << 14) + 1073741824;
	arg11 = 62 / arg11;
	if (!class37.aBoolean536)
	    i5 -= -2147483648;
	byte i6 = (byte) ((arg4 << 6) + arg10);
	if (arg10 == 22) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(22, arg4, i, i1, i2, i3, -1);
	    arg8.method200(class33_sub2_sub1, arg9, i6, 0, i4, arg3, arg2, i5);
	    if (class37.aBoolean534 && class37.aBoolean536)
		arg5.method95((byte) 0, arg2, arg9);
	} else if (arg10 == 10 || arg10 == 11) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(10, arg4, i, i1, i2, i3, -1);
	    if (class33_sub2_sub1 != null) {
		int i7 = 0;
		if (arg10 == 11)
		    i7 += 256;
		int i8;
		int i9;
		if (arg4 == 1 || arg4 == 3) {
		    i8 = class37.anInt533;
		    i9 = class37.anInt532;
		} else {
		    i8 = class37.anInt532;
		    i9 = class37.anInt533;
		}
		arg8.method204(i5, arg2, class33_sub2_sub1, i9, (byte) -14, i7,
			       arg3, arg9, i4, i6, null, i8);
	    }
	    if (class37.aBoolean534)
		arg5.method94(true, class37.anInt532, arg9, arg2,
			      class37.aBoolean535, arg4, class37.anInt533);
	    if (class37.anInt540 != -1)
		arg1.method181(new Class33_Sub5(2, arg3, arg7, 5858,
						(Class10.aClass10Array183
						 [class37.anInt540]),
						arg9, arg2));
	} else if (arg10 >= 12) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(arg10, arg4, i, i1, i2, i3, -1);
	    arg8.method204(i5, arg2, class33_sub2_sub1, 1, (byte) -14, 0, arg3,
			   arg9, i4, i6, null, 1);
	    if (class37.aBoolean534)
		arg5.method94(true, class37.anInt532, arg9, arg2,
			      class37.aBoolean535, arg4, class37.anInt533);
	    if (class37.anInt540 != -1)
		arg1.method181(new Class33_Sub5(2, arg3, arg7, 5858,
						(Class10.aClass10Array183
						 [class37.anInt540]),
						arg9, arg2));
	} else if (arg10 == 0) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(0, arg4, i, i1, i2, i3, -1);
	    arg8.method202(i4, anIntArray77[arg4], i6, 0, i5, (byte) -120,
			   arg2, arg9, null, arg3, class33_sub2_sub1);
	    if (class37.aBoolean534)
		arg5.method93(arg9, class37.aBoolean535, arg10, arg2, -34301,
			      arg4);
	} else if (arg10 == 1) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(1, arg4, i, i1, i2, i3, -1);
	    arg8.method202(i4, anIntArray78[arg4], i6, 0, i5, (byte) -120,
			   arg2, arg9, null, arg3, class33_sub2_sub1);
	    if (class37.aBoolean534)
		arg5.method93(arg9, class37.aBoolean535, arg10, arg2, -34301,
			      arg4);
	} else if (arg10 == 2) {
	    int i10 = arg4 + 1 & 0x3;
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(2, arg4 + 4, i, i1, i2, i3, -1);
	    Class33_Sub2_Sub1 class33_sub2_sub1_11
		= class37.method386(2, i10, i, i1, i2, i3, -1);
	    arg8.method202(i4, anIntArray77[arg4], i6, anIntArray77[i10], i5,
			   (byte) -120, arg2, arg9, class33_sub2_sub1_11, arg3,
			   class33_sub2_sub1);
	    if (class37.aBoolean534)
		arg5.method93(arg9, class37.aBoolean535, arg10, arg2, -34301,
			      arg4);
	} else if (arg10 == 3) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(3, arg4, i, i1, i2, i3, -1);
	    arg8.method202(i4, anIntArray78[arg4], i6, 0, i5, (byte) -120,
			   arg2, arg9, null, arg3, class33_sub2_sub1);
	    if (class37.aBoolean534)
		arg5.method93(arg9, class37.aBoolean535, arg10, arg2, -34301,
			      arg4);
	} else if (arg10 == 9) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(arg10, arg4, i, i1, i2, i3, -1);
	    arg8.method204(i5, arg2, class33_sub2_sub1, 1, (byte) -14, 0, arg3,
			   arg9, i4, i6, null, 1);
	    if (class37.aBoolean534)
		arg5.method94(true, class37.anInt532, arg9, arg2,
			      class37.aBoolean535, arg4, class37.anInt533);
	} else if (arg10 == 4) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(4, 0, i, i1, i2, i3, -1);
	    arg8.method203(i6, i5, class33_sub2_sub1, 0, arg9, false,
			   anIntArray77[arg4], arg3, i4, arg2, arg4 * 512, 0);
	    if (class37.anInt540 != -1)
		arg1.method181(new Class33_Sub5(1, arg3, arg7, 5858,
						(Class10.aClass10Array183
						 [class37.anInt540]),
						arg9, arg2));
	} else if (arg10 == 5) {
	    int i12 = 16;
	    int i13 = arg8.method217(arg3, arg9, arg2);
	    if (i13 > 0)
		i12 = Class37.method383(i13 >> 14 & 0x7fff).anInt541;
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(4, 0, i, i1, i2, i3, -1);
	    arg8.method203(i6, i5, class33_sub2_sub1, anIntArray80[arg4] * i12,
			   arg9, false, anIntArray77[arg4], arg3, i4, arg2,
			   arg4 * 512, anIntArray79[arg4] * i12);
	    if (class37.anInt540 != -1)
		arg1.method181(new Class33_Sub5(1, arg3, arg7, 5858,
						(Class10.aClass10Array183
						 [class37.anInt540]),
						arg9, arg2));
	} else if (arg10 == 6) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(4, 0, i, i1, i2, i3, -1);
	    arg8.method203(i6, i5, class33_sub2_sub1, 0, arg9, false, 256,
			   arg3, i4, arg2, arg4, 0);
	    if (class37.anInt540 != -1)
		arg1.method181(new Class33_Sub5(1, arg3, arg7, 5858,
						(Class10.aClass10Array183
						 [class37.anInt540]),
						arg9, arg2));
	} else if (arg10 == 7) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(4, 0, i, i1, i2, i3, -1);
	    arg8.method203(i6, i5, class33_sub2_sub1, 0, arg9, false, 512,
			   arg3, i4, arg2, arg4, 0);
	    if (class37.anInt540 != -1)
		arg1.method181(new Class33_Sub5(1, arg3, arg7, 5858,
						(Class10.aClass10Array183
						 [class37.anInt540]),
						arg9, arg2));
	} else if (arg10 == 8) {
	    Class33_Sub2_Sub1 class33_sub2_sub1
		= class37.method386(4, 0, i, i1, i2, i3, -1);
	    arg8.method203(i6, i5, class33_sub2_sub1, 0, arg9, false, 768,
			   arg3, i4, arg2, arg4, 0);
	    if (class37.anInt540 != -1)
		arg1.method181(new Class33_Sub5(1, arg3, arg7, 5858,
						(Class10.aClass10Array183
						 [class37.anInt540]),
						arg9, arg2));
	}
    }
}
