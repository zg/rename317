
public class Class33_Sub2_Sub2_Sub1 extends Class33_Sub2_Sub2
{
    private static boolean aBoolean1206 = true;
    private static int anInt1207 = -377;
    private static int anInt1208 = 8;
    public static boolean aBoolean1209 = true;
    static boolean aBoolean1210;
    static boolean aBoolean1211;
    public static boolean aBoolean1212 = true;
    public static int anInt1213;
    public static int anInt1214;
    public static int anInt1215;
    public static int[] anIntArray1216 = new int[512];
    public static int[] anIntArray1217 = new int[2048];
    public static int[] anIntArray1218 = new int[2048];
    public static int[] anIntArray1219 = new int[2048];
    public static int[] anIntArray1220;
    static int anInt1221;
    public static Class33_Sub2_Sub2_Sub3[] aClass33_Sub2_Sub2_Sub3Array1222;
    static boolean[] aBooleanArray1223;
    static int[] anIntArray1224;
    static int anInt1225;
    static int[][] anIntArrayArray1226;
    static int[][] anIntArrayArray1227;
    public static int[] anIntArray1228;
    public static int anInt1229;
    public static int[] anIntArray1230;
    static int[][] anIntArrayArray1231;
    
    public static final void method292(int arg0) {
	anIntArray1216 = null;
	anIntArray1216 = null;
	anIntArray1218 = null;
	anIntArray1219 = null;
	anIntArray1220 = null;
	aClass33_Sub2_Sub2_Sub3Array1222 = null;
	aBooleanArray1223 = null;
	anIntArray1224 = null;
	if (arg0 > 0) {
	    anIntArrayArray1226 = null;
	    anIntArrayArray1227 = null;
	    anIntArray1228 = null;
	    anIntArray1230 = null;
	    anIntArrayArray1231 = null;
	}
    }
    
    public static final void method293(byte arg0) {
	anIntArray1220 = new int[Class33_Sub2_Sub2.anInt1091];
	if (arg0 == -111) {
	    for (int i = 0; i < Class33_Sub2_Sub2.anInt1091; i++)
		anIntArray1220[i] = Class33_Sub2_Sub2.anInt1090 * i;
	    anInt1214 = Class33_Sub2_Sub2.anInt1090 / 2;
	    anInt1215 = Class33_Sub2_Sub2.anInt1091 / 2;
	}
    }
    
    public static final void method294(int arg0, int arg1, byte arg2) {
	if (arg2 != -44)
	    anInt1208 = 348;
	anIntArray1220 = new int[arg1];
	for (int i = 0; i < arg1; i++)
	    anIntArray1220[i] = arg0 * i;
	anInt1214 = arg0 / 2;
	anInt1215 = arg1 / 2;
    }
    
    public static final void method295(boolean arg0) {
	if (arg0)
	    aBoolean1206 = !aBoolean1206;
	anIntArrayArray1226 = null;
	for (int i = 0; i < 50; i++)
	    anIntArrayArray1227[i] = null;
    }
    
    public static final void method296(int arg0, byte arg1) {
	if (arg1 == 2) {
	    boolean flag = false;
	} else {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	if (anIntArrayArray1226 == null) {
	    anInt1225 = arg0;
	    if (aBoolean1209)
		anIntArrayArray1226 = new int[anInt1225][16384];
	    else
		anIntArrayArray1226 = new int[anInt1225][65536];
	    for (int i = 0; i < 50; i++)
		anIntArrayArray1227[i] = null;
	}
    }
    
    public static final void method297(int arg0, Class34 arg1) {
	anInt1221 = 0;
	for (int i = 0; i < 50; i++) {
	    try {
		aClass33_Sub2_Sub2_Sub3Array1222[i]
		    = new Class33_Sub2_Sub2_Sub3(0, arg1, String.valueOf(i),
						 0);
		if (aBoolean1209
		    && aClass33_Sub2_Sub2_Sub3Array1222[i].anInt1252 == 128)
		    aClass33_Sub2_Sub2_Sub3Array1222[i].method319(45133);
		else
		    aClass33_Sub2_Sub2_Sub3Array1222[i].method320(-42137);
		anInt1221++;
	    } catch (Exception exception) {
	    }
	}
	if (arg0 >= 0)
	    aBoolean1206 = !aBoolean1206;
    }
    
    public static final int method298(int arg0, int arg1) {
	if (anIntArray1224[arg0] != 0)
	    return anIntArray1224[arg0];
	int i = 0;
	int i1 = 0;
	int i2 = 0;
	int i3 = anIntArrayArray1231[arg0].length;
	for (int i4 = 0; i4 < i3; i4++) {
	    i += anIntArrayArray1231[arg0][i4] >> 16 & 0xff;
	    i1 += anIntArrayArray1231[arg0][i4] >> 8 & 0xff;
	    i2 += anIntArrayArray1231[arg0][i4] & 0xff;
	}
	if (arg1 != 47117)
	    aBoolean1206 = !aBoolean1206;
	int i5 = (i / i3 << 16) + (i1 / i3 << 8) + i2 / i3;
	i5 = method302(i5, 1.4);
	if (i5 == 0)
	    i5 = 1;
	anIntArray1224[arg0] = i5;
	return i5;
    }
    
    public static final void method299(int arg0, int arg1) {
	if (anIntArrayArray1227[arg0] != null) {
	    anIntArrayArray1226[anInt1225++] = anIntArrayArray1227[arg0];
	    anIntArrayArray1227[arg0] = null;
	    arg1 = 44 / arg1;
	}
    }
    
    public static final int[] method300(int arg0) {
	anIntArray1228[arg0] = anInt1229++;
	if (anIntArrayArray1227[arg0] != null)
	    return anIntArrayArray1227[arg0];
	int[] ints;
	if (anInt1225 > 0) {
	    ints = anIntArrayArray1226[--anInt1225];
	    anIntArrayArray1226[anInt1225] = null;
	} else {
	    int i = 0;
	    int i1 = -1;
	    for (int i2 = 0; i2 < anInt1221; i2++) {
		if (anIntArrayArray1227[i2] != null
		    && (anIntArray1228[i2] < i || i1 == -1)) {
		    i = anIntArray1228[i2];
		    i1 = i2;
		}
	    }
	    ints = anIntArrayArray1227[i1];
	    anIntArrayArray1227[i1] = null;
	}
	anIntArrayArray1227[arg0] = ints;
	Class33_Sub2_Sub2_Sub3 class33_sub2_sub2_sub3
	    = aClass33_Sub2_Sub2_Sub3Array1222[arg0];
	int[] ints3 = anIntArrayArray1231[arg0];
	if (aBoolean1209) {
	    aBooleanArray1223[arg0] = false;
	    for (int i = 0; i < 4096; i++) {
		int i4 = (ints[i]
			  = (ints3[class33_sub2_sub2_sub3.aByteArray1246[i]]
			     & 0xf8f8ff));
		if (i4 == 0)
		    aBooleanArray1223[arg0] = true;
		ints[i + 4096] = i4 - (i4 >>> 3) & 0xf8f8ff;
		ints[i + 8192] = i4 - (i4 >>> 2) & 0xf8f8ff;
		ints[i + 12288] = i4 - (i4 >>> 2) - (i4 >>> 3) & 0xf8f8ff;
	    }
	} else {
	    if (class33_sub2_sub2_sub3.anInt1248 == 64) {
		for (int i = 0; i < 128; i++) {
		    for (int i5 = 0; i5 < 128; i5++)
			ints[i5 + (i << 7)]
			    = ints3[(class33_sub2_sub2_sub3.aByteArray1246
				     [(i5 >> 1) + (i >> 1 << 6)])];
		}
	    } else {
		for (int i = 0; i < 16384; i++)
		    ints[i] = ints3[class33_sub2_sub2_sub3.aByteArray1246[i]];
	    }
	    aBooleanArray1223[arg0] = false;
	    for (int i = 0; i < 16384; i++) {
		ints[i] &= 0xf8f8ff;
		int i6 = ints[i];
		if (i6 == 0)
		    aBooleanArray1223[arg0] = true;
		ints[i + 16384] = i6 - (i6 >>> 3) & 0xf8f8ff;
		ints[i + 32768] = i6 - (i6 >>> 2) & 0xf8f8ff;
		ints[i + 49152] = i6 - (i6 >>> 2) - (i6 >>> 3) & 0xf8f8ff;
	    }
	}
	return ints;
    }
    
    public static final void method301(int arg0, double arg1) {
	int i = 0;
	if (arg0 < 0) {
	    for (int i1 = 0; i1 < 512; i1++) {
		double d = (double) (i1 / 8) / 64.0 + 0.0078125;
		double d2 = (double) (i1 & 0x7) / 8.0 + 0.0625;
		for (int i3 = 0; i3 < 128; i3++) {
		    double d4 = (double) i3 / 128.0;
		    double d5 = d4;
		    double d6 = d4;
		    double d7 = d4;
		    if (d2 != 0.0) {
			double d8;
			if (d4 < 0.5)
			    d8 = d4 * (1.0 + d2);
			else
			    d8 = d4 + d2 - d4 * d2;
			double d9 = 2.0 * d4 - d8;
			double d10 = d + 0.3333333333333333;
			if (d10 > 1.0)
			    d10--;
			double d11 = d;
			double d12 = d - 0.3333333333333333;
			if (d12 < 0.0)
			    d12++;
			if (6.0 * d10 < 1.0)
			    d5 = d9 + (d8 - d9) * 6.0 * d10;
			else if (2.0 * d10 < 1.0)
			    d5 = d8;
			else if (3.0 * d10 < 2.0)
			    d5 = d9 + ((d8 - d9) * (0.6666666666666666 - d10)
				       * 6.0);
			else
			    d5 = d9;
			if (6.0 * d11 < 1.0)
			    d6 = d9 + (d8 - d9) * 6.0 * d11;
			else if (2.0 * d11 < 1.0)
			    d6 = d8;
			else if (3.0 * d11 < 2.0)
			    d6 = d9 + ((d8 - d9) * (0.6666666666666666 - d11)
				       * 6.0);
			else
			    d6 = d9;
			if (6.0 * d12 < 1.0)
			    d7 = d9 + (d8 - d9) * 6.0 * d12;
			else if (2.0 * d12 < 1.0)
			    d7 = d8;
			else if (3.0 * d12 < 2.0)
			    d7 = d9 + ((d8 - d9) * (0.6666666666666666 - d12)
				       * 6.0);
			else
			    d7 = d9;
		    }
		    int i13 = (int) (d5 * 256.0);
		    int i14 = (int) (d6 * 256.0);
		    int i15 = (int) (d7 * 256.0);
		    int i16 = (i13 << 16) + (i14 << 8) + i15;
		    i16 = method302(i16, arg1);
		    anIntArray1230[i++] = i16;
		}
	    }
	    for (int i17 = 0; i17 < 50; i17++) {
		if (aClass33_Sub2_Sub2_Sub3Array1222[i17] != null) {
		    int[] ints
			= aClass33_Sub2_Sub2_Sub3Array1222[i17].anIntArray1247;
		    anIntArrayArray1231[i17] = new int[ints.length];
		    for (int i18 = 0; i18 < ints.length; i18++)
			anIntArrayArray1231[i17][i18]
			    = method302(ints[i18], arg1);
		}
	    }
	    for (int i19 = 0; i19 < 50; i19++)
		method299(i19, 423);
	}
    }
    
    public static int method302(int arg0, double arg1) {
	double d = (double) (arg0 >> 16) / 256.0;
	double d1 = (double) (arg0 >> 8 & 0xff) / 256.0;
	double d2 = (double) (arg0 & 0xff) / 256.0;
	d = Math.pow(d, arg1);
	d1 = Math.pow(d1, arg1);
	d2 = Math.pow(d2, arg1);
	int i = (int) (d * 256.0);
	int i3 = (int) (d1 * 256.0);
	int i4 = (int) (d2 * 256.0);
	return (i << 16) + (i3 << 8) + i4;
    }
    
    public static final void method303(int arg0, int arg1, int arg2, int arg3,
				       int arg4, int arg5, int arg6, int arg7,
				       int arg8) {
	int i = 0;
	int i1 = 0;
	if (arg1 != arg0) {
	    i = (arg4 - arg3 << 16) / (arg1 - arg0);
	    i1 = (arg7 - arg6 << 15) / (arg1 - arg0);
	}
	int i2 = 0;
	int i3 = 0;
	if (arg2 != arg1) {
	    i2 = (arg5 - arg4 << 16) / (arg2 - arg1);
	    i3 = (arg8 - arg7 << 15) / (arg2 - arg1);
	}
	int i4 = 0;
	int i5 = 0;
	if (arg2 != arg0) {
	    i4 = (arg3 - arg5 << 16) / (arg0 - arg2);
	    i5 = (arg6 - arg8 << 15) / (arg0 - arg2);
	}
	if (arg0 <= arg1 && arg0 <= arg2) {
	    if (arg0 < Class33_Sub2_Sub2.anInt1093) {
		if (arg1 > Class33_Sub2_Sub2.anInt1093)
		    arg1 = Class33_Sub2_Sub2.anInt1093;
		if (arg2 > Class33_Sub2_Sub2.anInt1093)
		    arg2 = Class33_Sub2_Sub2.anInt1093;
		if (arg1 < arg2) {
		    arg5 = arg3 <<= 16;
		    arg8 = arg6 <<= 15;
		    if (arg0 < 0) {
			arg5 -= i4 * arg0;
			arg3 -= i * arg0;
			arg8 -= i5 * arg0;
			arg6 -= i1 * arg0;
			arg0 = 0;
		    }
		    arg4 <<= 16;
		    arg7 <<= 15;
		    if (arg1 < 0) {
			arg4 -= i2 * arg1;
			arg7 -= i3 * arg1;
			arg1 = 0;
		    }
		    if (arg0 != arg1 && i4 < i || arg0 == arg1 && i4 > i2) {
			arg2 -= arg1;
			arg1 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg1 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      0, 0, arg5 >> 16, arg3 >> 16, arg8 >> 7,
				      arg6 >> 7);
			    arg5 += i4;
			    arg3 += i;
			    arg8 += i5;
			    arg6 += i1;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg2 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      0, 0, arg5 >> 16, arg4 >> 16, arg8 >> 7,
				      arg7 >> 7);
			    arg5 += i4;
			    arg4 += i2;
			    arg8 += i5;
			    arg7 += i3;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
		    } else {
			arg2 -= arg1;
			arg1 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg1 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      0, 0, arg3 >> 16, arg5 >> 16, arg6 >> 7,
				      arg8 >> 7);
			    arg5 += i4;
			    arg3 += i;
			    arg8 += i5;
			    arg6 += i1;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg2 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      0, 0, arg4 >> 16, arg5 >> 16, arg7 >> 7,
				      arg8 >> 7);
			    arg5 += i4;
			    arg4 += i2;
			    arg8 += i5;
			    arg7 += i3;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
		    }
		} else {
		    arg4 = arg3 <<= 16;
		    arg7 = arg6 <<= 15;
		    if (arg0 < 0) {
			arg4 -= i4 * arg0;
			arg3 -= i * arg0;
			arg7 -= i5 * arg0;
			arg6 -= i1 * arg0;
			arg0 = 0;
		    }
		    arg5 <<= 16;
		    arg8 <<= 15;
		    if (arg2 < 0) {
			arg5 -= i2 * arg2;
			arg8 -= i3 * arg2;
			arg2 = 0;
		    }
		    if (arg0 != arg2 && i4 < i || arg0 == arg2 && i2 > i) {
			arg1 -= arg2;
			arg2 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg2 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      0, 0, arg4 >> 16, arg3 >> 16, arg7 >> 7,
				      arg6 >> 7);
			    arg4 += i4;
			    arg3 += i;
			    arg7 += i5;
			    arg6 += i1;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg1 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      0, 0, arg5 >> 16, arg3 >> 16, arg8 >> 7,
				      arg6 >> 7);
			    arg5 += i2;
			    arg3 += i;
			    arg8 += i3;
			    arg6 += i1;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
		    } else {
			arg1 -= arg2;
			arg2 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg2 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      0, 0, arg3 >> 16, arg4 >> 16, arg6 >> 7,
				      arg7 >> 7);
			    arg4 += i4;
			    arg3 += i;
			    arg7 += i5;
			    arg6 += i1;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg1 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      0, 0, arg3 >> 16, arg5 >> 16, arg6 >> 7,
				      arg8 >> 7);
			    arg5 += i2;
			    arg3 += i;
			    arg8 += i3;
			    arg6 += i1;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
		    }
		}
	    }
	} else if (arg1 <= arg2) {
	    if (arg1 < Class33_Sub2_Sub2.anInt1093) {
		if (arg2 > Class33_Sub2_Sub2.anInt1093)
		    arg2 = Class33_Sub2_Sub2.anInt1093;
		if (arg0 > Class33_Sub2_Sub2.anInt1093)
		    arg0 = Class33_Sub2_Sub2.anInt1093;
		if (arg2 < arg0) {
		    arg3 = arg4 <<= 16;
		    arg6 = arg7 <<= 15;
		    if (arg1 < 0) {
			arg3 -= i * arg1;
			arg4 -= i2 * arg1;
			arg6 -= i1 * arg1;
			arg7 -= i3 * arg1;
			arg1 = 0;
		    }
		    arg5 <<= 16;
		    arg8 <<= 15;
		    if (arg2 < 0) {
			arg5 -= i4 * arg2;
			arg8 -= i5 * arg2;
			arg2 = 0;
		    }
		    if (arg1 != arg2 && i < i2 || arg1 == arg2 && i > i4) {
			arg0 -= arg2;
			arg2 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg2 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      0, 0, arg3 >> 16, arg4 >> 16, arg6 >> 7,
				      arg7 >> 7);
			    arg3 += i;
			    arg4 += i2;
			    arg6 += i1;
			    arg7 += i3;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg0 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      0, 0, arg3 >> 16, arg5 >> 16, arg6 >> 7,
				      arg8 >> 7);
			    arg3 += i;
			    arg5 += i4;
			    arg6 += i1;
			    arg8 += i5;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
		    } else {
			arg0 -= arg2;
			arg2 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg2 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      0, 0, arg4 >> 16, arg3 >> 16, arg7 >> 7,
				      arg6 >> 7);
			    arg3 += i;
			    arg4 += i2;
			    arg6 += i1;
			    arg7 += i3;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg0 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      0, 0, arg5 >> 16, arg3 >> 16, arg8 >> 7,
				      arg6 >> 7);
			    arg3 += i;
			    arg5 += i4;
			    arg6 += i1;
			    arg8 += i5;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
		    }
		} else {
		    arg5 = arg4 <<= 16;
		    arg8 = arg7 <<= 15;
		    if (arg1 < 0) {
			arg5 -= i * arg1;
			arg4 -= i2 * arg1;
			arg8 -= i1 * arg1;
			arg7 -= i3 * arg1;
			arg1 = 0;
		    }
		    arg3 <<= 16;
		    arg6 <<= 15;
		    if (arg0 < 0) {
			arg3 -= i4 * arg0;
			arg6 -= i5 * arg0;
			arg0 = 0;
		    }
		    if (i < i2) {
			arg2 -= arg0;
			arg0 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg0 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      0, 0, arg5 >> 16, arg4 >> 16, arg8 >> 7,
				      arg7 >> 7);
			    arg5 += i;
			    arg4 += i2;
			    arg8 += i1;
			    arg7 += i3;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg2 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      0, 0, arg3 >> 16, arg4 >> 16, arg6 >> 7,
				      arg7 >> 7);
			    arg3 += i4;
			    arg4 += i2;
			    arg6 += i5;
			    arg7 += i3;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
		    } else {
			arg2 -= arg0;
			arg0 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg0 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      0, 0, arg4 >> 16, arg5 >> 16, arg7 >> 7,
				      arg8 >> 7);
			    arg5 += i;
			    arg4 += i2;
			    arg8 += i1;
			    arg7 += i3;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg2 >= 0) {
			    method304(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      0, 0, arg4 >> 16, arg3 >> 16, arg7 >> 7,
				      arg6 >> 7);
			    arg3 += i4;
			    arg4 += i2;
			    arg6 += i5;
			    arg7 += i3;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
		    }
		}
	    }
	} else if (arg2 < Class33_Sub2_Sub2.anInt1093) {
	    if (arg0 > Class33_Sub2_Sub2.anInt1093)
		arg0 = Class33_Sub2_Sub2.anInt1093;
	    if (arg1 > Class33_Sub2_Sub2.anInt1093)
		arg1 = Class33_Sub2_Sub2.anInt1093;
	    if (arg0 < arg1) {
		arg4 = arg5 <<= 16;
		arg7 = arg8 <<= 15;
		if (arg2 < 0) {
		    arg4 -= i2 * arg2;
		    arg5 -= i4 * arg2;
		    arg7 -= i3 * arg2;
		    arg8 -= i5 * arg2;
		    arg2 = 0;
		}
		arg3 <<= 16;
		arg6 <<= 15;
		if (arg0 < 0) {
		    arg3 -= i * arg0;
		    arg6 -= i1 * arg0;
		    arg0 = 0;
		}
		if (i2 < i4) {
		    arg1 -= arg0;
		    arg0 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg0 >= 0) {
			method304(Class33_Sub2_Sub2.anIntArray1089, arg2, 0, 0,
				  arg4 >> 16, arg5 >> 16, arg7 >> 7,
				  arg8 >> 7);
			arg4 += i2;
			arg5 += i4;
			arg7 += i3;
			arg8 += i5;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		    while (--arg1 >= 0) {
			method304(Class33_Sub2_Sub2.anIntArray1089, arg2, 0, 0,
				  arg4 >> 16, arg3 >> 16, arg7 >> 7,
				  arg6 >> 7);
			arg4 += i2;
			arg3 += i;
			arg7 += i3;
			arg6 += i1;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		} else {
		    arg1 -= arg0;
		    arg0 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg0 >= 0) {
			method304(Class33_Sub2_Sub2.anIntArray1089, arg2, 0, 0,
				  arg5 >> 16, arg4 >> 16, arg8 >> 7,
				  arg7 >> 7);
			arg4 += i2;
			arg5 += i4;
			arg7 += i3;
			arg8 += i5;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		    while (--arg1 >= 0) {
			method304(Class33_Sub2_Sub2.anIntArray1089, arg2, 0, 0,
				  arg3 >> 16, arg4 >> 16, arg6 >> 7,
				  arg7 >> 7);
			arg4 += i2;
			arg3 += i;
			arg7 += i3;
			arg6 += i1;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		}
	    } else {
		arg3 = arg5 <<= 16;
		arg6 = arg8 <<= 15;
		if (arg2 < 0) {
		    arg3 -= i2 * arg2;
		    arg5 -= i4 * arg2;
		    arg6 -= i3 * arg2;
		    arg8 -= i5 * arg2;
		    arg2 = 0;
		}
		arg4 <<= 16;
		arg7 <<= 15;
		if (arg1 < 0) {
		    arg4 -= i * arg1;
		    arg7 -= i1 * arg1;
		    arg1 = 0;
		}
		if (i2 < i4) {
		    arg0 -= arg1;
		    arg1 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg1 >= 0) {
			method304(Class33_Sub2_Sub2.anIntArray1089, arg2, 0, 0,
				  arg3 >> 16, arg5 >> 16, arg6 >> 7,
				  arg8 >> 7);
			arg3 += i2;
			arg5 += i4;
			arg6 += i3;
			arg8 += i5;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		    while (--arg0 >= 0) {
			method304(Class33_Sub2_Sub2.anIntArray1089, arg2, 0, 0,
				  arg4 >> 16, arg5 >> 16, arg7 >> 7,
				  arg8 >> 7);
			arg4 += i;
			arg5 += i4;
			arg7 += i1;
			arg8 += i5;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		} else {
		    arg0 -= arg1;
		    arg1 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg1 >= 0) {
			method304(Class33_Sub2_Sub2.anIntArray1089, arg2, 0, 0,
				  arg5 >> 16, arg3 >> 16, arg8 >> 7,
				  arg6 >> 7);
			arg3 += i2;
			arg5 += i4;
			arg6 += i3;
			arg8 += i5;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		    while (--arg0 >= 0) {
			method304(Class33_Sub2_Sub2.anIntArray1089, arg2, 0, 0,
				  arg5 >> 16, arg4 >> 16, arg8 >> 7,
				  arg7 >> 7);
			arg4 += i;
			arg5 += i4;
			arg7 += i1;
			arg8 += i5;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		}
	    }
	}
    }
    
    public static final void method304(int[] arg0, int arg1, int arg2,
				       int arg3, int arg4, int arg5, int arg6,
				       int arg7) {
	if (aBoolean1212) {
	    int i;
	    if (aBoolean1210) {
		if (arg5 - arg4 > 3)
		    i = (arg7 - arg6) / (arg5 - arg4);
		else
		    i = 0;
		if (arg5 > Class33_Sub2_Sub2.anInt1096)
		    arg5 = Class33_Sub2_Sub2.anInt1096;
		if (arg4 < 0) {
		    arg6 -= arg4 * i;
		    arg4 = 0;
		}
		if (arg4 >= arg5)
		    return;
		arg1 += arg4;
		arg3 = arg5 - arg4 >> 2;
		i <<= 2;
	    } else {
		if (arg4 >= arg5)
		    return;
		arg1 += arg4;
		arg3 = arg5 - arg4 >> 2;
		if (arg3 > 0)
		    i = (arg7 - arg6) * anIntArray1216[arg3] >> 15;
		else
		    i = 0;
	    }
	    if (anInt1213 == 0) {
		while (--arg3 >= 0) {
		    arg2 = anIntArray1230[arg6 >> 8];
		    arg6 += i;
		    arg0[arg1++] = arg2;
		    arg0[arg1++] = arg2;
		    arg0[arg1++] = arg2;
		    arg0[arg1++] = arg2;
		}
		arg3 = arg5 - arg4 & 0x3;
		if (arg3 > 0) {
		    arg2 = anIntArray1230[arg6 >> 8];
		    do
			arg0[arg1++] = arg2;
		    while (--arg3 > 0);
		}
	    } else {
		int i1 = anInt1213;
		int i2 = 256 - anInt1213;
		while (--arg3 >= 0) {
		    arg2 = anIntArray1230[arg6 >> 8];
		    arg6 += i;
		    arg2 = (((arg2 & 0xff00ff) * i2 >> 8 & 0xff00ff)
			    + ((arg2 & 0xff00) * i2 >> 8 & 0xff00));
		    arg0[arg1++]
			= (arg2
			   + ((arg0[arg1] & 0xff00ff) * i1 >> 8 & 0xff00ff)
			   + ((arg0[arg1] & 0xff00) * i1 >> 8 & 0xff00));
		    arg0[arg1++]
			= (arg2
			   + ((arg0[arg1] & 0xff00ff) * i1 >> 8 & 0xff00ff)
			   + ((arg0[arg1] & 0xff00) * i1 >> 8 & 0xff00));
		    arg0[arg1++]
			= (arg2
			   + ((arg0[arg1] & 0xff00ff) * i1 >> 8 & 0xff00ff)
			   + ((arg0[arg1] & 0xff00) * i1 >> 8 & 0xff00));
		    arg0[arg1++]
			= (arg2
			   + ((arg0[arg1] & 0xff00ff) * i1 >> 8 & 0xff00ff)
			   + ((arg0[arg1] & 0xff00) * i1 >> 8 & 0xff00));
		}
		arg3 = arg5 - arg4 & 0x3;
		if (arg3 > 0) {
		    arg2 = anIntArray1230[arg6 >> 8];
		    arg2 = (((arg2 & 0xff00ff) * i2 >> 8 & 0xff00ff)
			    + ((arg2 & 0xff00) * i2 >> 8 & 0xff00));
		    do
			arg0[arg1++]
			    = (arg2
			       + ((arg0[arg1] & 0xff00ff) * i1 >> 8 & 0xff00ff)
			       + ((arg0[arg1] & 0xff00) * i1 >> 8 & 0xff00));
		    while (--arg3 > 0);
		}
	    }
	} else if (arg4 < arg5) {
	    int i = (arg7 - arg6) / (arg5 - arg4);
	    if (aBoolean1210) {
		if (arg5 > Class33_Sub2_Sub2.anInt1096)
		    arg5 = Class33_Sub2_Sub2.anInt1096;
		if (arg4 < 0) {
		    arg6 -= arg4 * i;
		    arg4 = 0;
		}
		if (arg4 >= arg5)
		    return;
	    }
	    arg1 += arg4;
	    arg3 = arg5 - arg4;
	    if (anInt1213 == 0) {
		do {
		    arg0[arg1++] = anIntArray1230[arg6 >> 8];
		    arg6 += i;
		} while (--arg3 > 0);
	    } else {
		int i3 = anInt1213;
		int i4 = 256 - anInt1213;
		do {
		    arg2 = anIntArray1230[arg6 >> 8];
		    arg6 += i;
		    arg2 = (((arg2 & 0xff00ff) * i4 >> 8 & 0xff00ff)
			    + ((arg2 & 0xff00) * i4 >> 8 & 0xff00));
		    arg0[arg1++]
			= (arg2
			   + ((arg0[arg1] & 0xff00ff) * i3 >> 8 & 0xff00ff)
			   + ((arg0[arg1] & 0xff00) * i3 >> 8 & 0xff00));
		} while (--arg3 > 0);
	    }
	}
    }
    
    public static final void method305(int arg0, int arg1, int arg2, int arg3,
				       int arg4, int arg5, int arg6) {
	int i = 0;
	if (arg1 != arg0)
	    i = (arg4 - arg3 << 16) / (arg1 - arg0);
	int i1 = 0;
	if (arg2 != arg1)
	    i1 = (arg5 - arg4 << 16) / (arg2 - arg1);
	int i2 = 0;
	if (arg2 != arg0)
	    i2 = (arg3 - arg5 << 16) / (arg0 - arg2);
	if (arg0 <= arg1 && arg0 <= arg2) {
	    if (arg0 < Class33_Sub2_Sub2.anInt1093) {
		if (arg1 > Class33_Sub2_Sub2.anInt1093)
		    arg1 = Class33_Sub2_Sub2.anInt1093;
		if (arg2 > Class33_Sub2_Sub2.anInt1093)
		    arg2 = Class33_Sub2_Sub2.anInt1093;
		if (arg1 < arg2) {
		    arg5 = arg3 <<= 16;
		    if (arg0 < 0) {
			arg5 -= i2 * arg0;
			arg3 -= i * arg0;
			arg0 = 0;
		    }
		    arg4 <<= 16;
		    if (arg1 < 0) {
			arg4 -= i1 * arg1;
			arg1 = 0;
		    }
		    if (arg0 != arg1 && i2 < i || arg0 == arg1 && i2 > i1) {
			arg2 -= arg1;
			arg1 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg1 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      arg6, 0, arg5 >> 16, arg3 >> 16);
			    arg5 += i2;
			    arg3 += i;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg2 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      arg6, 0, arg5 >> 16, arg4 >> 16);
			    arg5 += i2;
			    arg4 += i1;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
		    } else {
			arg2 -= arg1;
			arg1 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg1 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      arg6, 0, arg3 >> 16, arg5 >> 16);
			    arg5 += i2;
			    arg3 += i;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg2 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      arg6, 0, arg4 >> 16, arg5 >> 16);
			    arg5 += i2;
			    arg4 += i1;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
		    }
		} else {
		    arg4 = arg3 <<= 16;
		    if (arg0 < 0) {
			arg4 -= i2 * arg0;
			arg3 -= i * arg0;
			arg0 = 0;
		    }
		    arg5 <<= 16;
		    if (arg2 < 0) {
			arg5 -= i1 * arg2;
			arg2 = 0;
		    }
		    if (arg0 != arg2 && i2 < i || arg0 == arg2 && i1 > i) {
			arg1 -= arg2;
			arg2 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg2 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      arg6, 0, arg4 >> 16, arg3 >> 16);
			    arg4 += i2;
			    arg3 += i;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg1 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      arg6, 0, arg5 >> 16, arg3 >> 16);
			    arg5 += i1;
			    arg3 += i;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
		    } else {
			arg1 -= arg2;
			arg2 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg2 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      arg6, 0, arg3 >> 16, arg4 >> 16);
			    arg4 += i2;
			    arg3 += i;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg1 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg0,
				      arg6, 0, arg3 >> 16, arg5 >> 16);
			    arg5 += i1;
			    arg3 += i;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			}
		    }
		}
	    }
	} else if (arg1 <= arg2) {
	    if (arg1 < Class33_Sub2_Sub2.anInt1093) {
		if (arg2 > Class33_Sub2_Sub2.anInt1093)
		    arg2 = Class33_Sub2_Sub2.anInt1093;
		if (arg0 > Class33_Sub2_Sub2.anInt1093)
		    arg0 = Class33_Sub2_Sub2.anInt1093;
		if (arg2 < arg0) {
		    arg3 = arg4 <<= 16;
		    if (arg1 < 0) {
			arg3 -= i * arg1;
			arg4 -= i1 * arg1;
			arg1 = 0;
		    }
		    arg5 <<= 16;
		    if (arg2 < 0) {
			arg5 -= i2 * arg2;
			arg2 = 0;
		    }
		    if (arg1 != arg2 && i < i1 || arg1 == arg2 && i > i2) {
			arg0 -= arg2;
			arg2 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg2 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      arg6, 0, arg3 >> 16, arg4 >> 16);
			    arg3 += i;
			    arg4 += i1;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg0 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      arg6, 0, arg3 >> 16, arg5 >> 16);
			    arg3 += i;
			    arg5 += i2;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
		    } else {
			arg0 -= arg2;
			arg2 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg2 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      arg6, 0, arg4 >> 16, arg3 >> 16);
			    arg3 += i;
			    arg4 += i1;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg0 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      arg6, 0, arg5 >> 16, arg3 >> 16);
			    arg3 += i;
			    arg5 += i2;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
		    }
		} else {
		    arg5 = arg4 <<= 16;
		    if (arg1 < 0) {
			arg5 -= i * arg1;
			arg4 -= i1 * arg1;
			arg1 = 0;
		    }
		    arg3 <<= 16;
		    if (arg0 < 0) {
			arg3 -= i2 * arg0;
			arg0 = 0;
		    }
		    if (i < i1) {
			arg2 -= arg0;
			arg0 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg0 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      arg6, 0, arg5 >> 16, arg4 >> 16);
			    arg5 += i;
			    arg4 += i1;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg2 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      arg6, 0, arg3 >> 16, arg4 >> 16);
			    arg3 += i2;
			    arg4 += i1;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
		    } else {
			arg2 -= arg0;
			arg0 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg0 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      arg6, 0, arg4 >> 16, arg5 >> 16);
			    arg5 += i;
			    arg4 += i1;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
			while (--arg2 >= 0) {
			    method306(Class33_Sub2_Sub2.anIntArray1089, arg1,
				      arg6, 0, arg4 >> 16, arg3 >> 16);
			    arg3 += i2;
			    arg4 += i1;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			}
		    }
		}
	    }
	} else if (arg2 < Class33_Sub2_Sub2.anInt1093) {
	    if (arg0 > Class33_Sub2_Sub2.anInt1093)
		arg0 = Class33_Sub2_Sub2.anInt1093;
	    if (arg1 > Class33_Sub2_Sub2.anInt1093)
		arg1 = Class33_Sub2_Sub2.anInt1093;
	    if (arg0 < arg1) {
		arg4 = arg5 <<= 16;
		if (arg2 < 0) {
		    arg4 -= i1 * arg2;
		    arg5 -= i2 * arg2;
		    arg2 = 0;
		}
		arg3 <<= 16;
		if (arg0 < 0) {
		    arg3 -= i * arg0;
		    arg0 = 0;
		}
		if (i1 < i2) {
		    arg1 -= arg0;
		    arg0 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg0 >= 0) {
			method306(Class33_Sub2_Sub2.anIntArray1089, arg2, arg6,
				  0, arg4 >> 16, arg5 >> 16);
			arg4 += i1;
			arg5 += i2;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		    while (--arg1 >= 0) {
			method306(Class33_Sub2_Sub2.anIntArray1089, arg2, arg6,
				  0, arg4 >> 16, arg3 >> 16);
			arg4 += i1;
			arg3 += i;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		} else {
		    arg1 -= arg0;
		    arg0 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg0 >= 0) {
			method306(Class33_Sub2_Sub2.anIntArray1089, arg2, arg6,
				  0, arg5 >> 16, arg4 >> 16);
			arg4 += i1;
			arg5 += i2;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		    while (--arg1 >= 0) {
			method306(Class33_Sub2_Sub2.anIntArray1089, arg2, arg6,
				  0, arg3 >> 16, arg4 >> 16);
			arg4 += i1;
			arg3 += i;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		}
	    } else {
		arg3 = arg5 <<= 16;
		if (arg2 < 0) {
		    arg3 -= i1 * arg2;
		    arg5 -= i2 * arg2;
		    arg2 = 0;
		}
		arg4 <<= 16;
		if (arg1 < 0) {
		    arg4 -= i * arg1;
		    arg1 = 0;
		}
		if (i1 < i2) {
		    arg0 -= arg1;
		    arg1 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg1 >= 0) {
			method306(Class33_Sub2_Sub2.anIntArray1089, arg2, arg6,
				  0, arg3 >> 16, arg5 >> 16);
			arg3 += i1;
			arg5 += i2;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		    while (--arg0 >= 0) {
			method306(Class33_Sub2_Sub2.anIntArray1089, arg2, arg6,
				  0, arg4 >> 16, arg5 >> 16);
			arg4 += i;
			arg5 += i2;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		} else {
		    arg0 -= arg1;
		    arg1 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg1 >= 0) {
			method306(Class33_Sub2_Sub2.anIntArray1089, arg2, arg6,
				  0, arg5 >> 16, arg3 >> 16);
			arg3 += i1;
			arg5 += i2;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		    while (--arg0 >= 0) {
			method306(Class33_Sub2_Sub2.anIntArray1089, arg2, arg6,
				  0, arg5 >> 16, arg4 >> 16);
			arg4 += i;
			arg5 += i2;
			arg2 += Class33_Sub2_Sub2.anInt1090;
		    }
		}
	    }
	}
    }
    
    public static final void method306(int[] arg0, int arg1, int arg2,
				       int arg3, int arg4, int arg5) {
	if (aBoolean1210) {
	    if (arg5 > Class33_Sub2_Sub2.anInt1096)
		arg5 = Class33_Sub2_Sub2.anInt1096;
	    if (arg4 < 0)
		arg4 = 0;
	}
	if (arg4 < arg5) {
	    arg1 += arg4;
	    arg3 = arg5 - arg4 >> 2;
	    if (anInt1213 == 0) {
		while (--arg3 >= 0) {
		    arg0[arg1++] = arg2;
		    arg0[arg1++] = arg2;
		    arg0[arg1++] = arg2;
		    arg0[arg1++] = arg2;
		}
		arg3 = arg5 - arg4 & 0x3;
		while (--arg3 >= 0)
		    arg0[arg1++] = arg2;
	    } else {
		int i = anInt1213;
		int i1 = 256 - anInt1213;
		arg2 = (((arg2 & 0xff00ff) * i1 >> 8 & 0xff00ff)
			+ ((arg2 & 0xff00) * i1 >> 8 & 0xff00));
		while (--arg3 >= 0) {
		    arg0[arg1++]
			= (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff)
			   + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
		    arg0[arg1++]
			= (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff)
			   + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
		    arg0[arg1++]
			= (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff)
			   + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
		    arg0[arg1++]
			= (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff)
			   + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
		}
		arg3 = arg5 - arg4 & 0x3;
		while (--arg3 >= 0)
		    arg0[arg1++]
			= (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff)
			   + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
	    }
	}
    }
    
    public static final void method307
	(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6,
	 int arg7, int arg8, int arg9, int arg10, int arg11, int arg12,
	 int arg13, int arg14, int arg15, int arg16, int arg17, int arg18) {
	int[] ints = method300(arg18);
	aBoolean1211 = !aBooleanArray1223[arg18];
	arg10 = arg9 - arg10;
	arg13 = arg12 - arg13;
	arg16 = arg15 - arg16;
	arg11 -= arg9;
	arg14 -= arg12;
	arg17 -= arg15;
	int i = arg11 * arg12 - arg14 * arg9 << 14;
	int i1 = arg14 * arg15 - arg17 * arg12 << 8;
	int i2 = arg17 * arg9 - arg11 * arg15 << 5;
	int i3 = arg10 * arg12 - arg13 * arg9 << 14;
	int i4 = arg13 * arg15 - arg16 * arg12 << 8;
	int i5 = arg16 * arg9 - arg10 * arg15 << 5;
	int i6 = arg13 * arg11 - arg10 * arg14 << 14;
	int i7 = arg16 * arg14 - arg13 * arg17 << 8;
	int i8 = arg10 * arg17 - arg16 * arg11 << 5;
	int i9 = 0;
	int i10 = 0;
	if (arg1 != arg0) {
	    i9 = (arg4 - arg3 << 16) / (arg1 - arg0);
	    i10 = (arg7 - arg6 << 16) / (arg1 - arg0);
	}
	int i11 = 0;
	int i12 = 0;
	if (arg2 != arg1) {
	    i11 = (arg5 - arg4 << 16) / (arg2 - arg1);
	    i12 = (arg8 - arg7 << 16) / (arg2 - arg1);
	}
	int i13 = 0;
	int i14 = 0;
	if (arg2 != arg0) {
	    i13 = (arg3 - arg5 << 16) / (arg0 - arg2);
	    i14 = (arg6 - arg8 << 16) / (arg0 - arg2);
	}
	if (arg0 <= arg1 && arg0 <= arg2) {
	    if (arg0 < Class33_Sub2_Sub2.anInt1093) {
		if (arg1 > Class33_Sub2_Sub2.anInt1093)
		    arg1 = Class33_Sub2_Sub2.anInt1093;
		if (arg2 > Class33_Sub2_Sub2.anInt1093)
		    arg2 = Class33_Sub2_Sub2.anInt1093;
		if (arg1 < arg2) {
		    arg5 = arg3 <<= 16;
		    arg8 = arg6 <<= 16;
		    if (arg0 < 0) {
			arg5 -= i13 * arg0;
			arg3 -= i9 * arg0;
			arg8 -= i14 * arg0;
			arg6 -= i10 * arg0;
			arg0 = 0;
		    }
		    arg4 <<= 16;
		    arg7 <<= 16;
		    if (arg1 < 0) {
			arg4 -= i11 * arg1;
			arg7 -= i12 * arg1;
			arg1 = 0;
		    }
		    int i15 = arg0 - anInt1215;
		    i += i2 * i15;
		    i3 += i5 * i15;
		    i6 += i8 * i15;
		    if (arg0 != arg1 && i13 < i9
			|| arg0 == arg1 && i13 > i11) {
			arg2 -= arg1;
			arg1 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg1 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg0, arg5 >> 16, arg3 >> 16,
				      arg8 >> 8, arg6 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg5 += i13;
			    arg3 += i9;
			    arg8 += i14;
			    arg6 += i10;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
			while (--arg2 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg0, arg5 >> 16, arg4 >> 16,
				      arg8 >> 8, arg7 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg5 += i13;
			    arg4 += i11;
			    arg8 += i14;
			    arg7 += i12;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
		    } else {
			arg2 -= arg1;
			arg1 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg1 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg0, arg3 >> 16, arg5 >> 16,
				      arg6 >> 8, arg8 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg5 += i13;
			    arg3 += i9;
			    arg8 += i14;
			    arg6 += i10;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
			while (--arg2 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg0, arg4 >> 16, arg5 >> 16,
				      arg7 >> 8, arg8 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg5 += i13;
			    arg4 += i11;
			    arg8 += i14;
			    arg7 += i12;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
		    }
		} else {
		    arg4 = arg3 <<= 16;
		    arg7 = arg6 <<= 16;
		    if (arg0 < 0) {
			arg4 -= i13 * arg0;
			arg3 -= i9 * arg0;
			arg7 -= i14 * arg0;
			arg6 -= i10 * arg0;
			arg0 = 0;
		    }
		    arg5 <<= 16;
		    arg8 <<= 16;
		    if (arg2 < 0) {
			arg5 -= i11 * arg2;
			arg8 -= i12 * arg2;
			arg2 = 0;
		    }
		    int i16 = arg0 - anInt1215;
		    i += i2 * i16;
		    i3 += i5 * i16;
		    i6 += i8 * i16;
		    if (arg0 != arg2 && i13 < i9 || arg0 == arg2 && i11 > i9) {
			arg1 -= arg2;
			arg2 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg2 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg0, arg4 >> 16, arg3 >> 16,
				      arg7 >> 8, arg6 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg4 += i13;
			    arg3 += i9;
			    arg7 += i14;
			    arg6 += i10;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
			while (--arg1 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg0, arg5 >> 16, arg3 >> 16,
				      arg8 >> 8, arg6 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg5 += i11;
			    arg3 += i9;
			    arg8 += i12;
			    arg6 += i10;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
		    } else {
			arg1 -= arg2;
			arg2 -= arg0;
			arg0 = anIntArray1220[arg0];
			while (--arg2 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg0, arg3 >> 16, arg4 >> 16,
				      arg6 >> 8, arg7 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg4 += i13;
			    arg3 += i9;
			    arg7 += i14;
			    arg6 += i10;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
			while (--arg1 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg0, arg3 >> 16, arg5 >> 16,
				      arg6 >> 8, arg8 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg5 += i11;
			    arg3 += i9;
			    arg8 += i12;
			    arg6 += i10;
			    arg0 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
		    }
		}
	    }
	} else if (arg1 <= arg2) {
	    if (arg1 < Class33_Sub2_Sub2.anInt1093) {
		if (arg2 > Class33_Sub2_Sub2.anInt1093)
		    arg2 = Class33_Sub2_Sub2.anInt1093;
		if (arg0 > Class33_Sub2_Sub2.anInt1093)
		    arg0 = Class33_Sub2_Sub2.anInt1093;
		if (arg2 < arg0) {
		    arg3 = arg4 <<= 16;
		    arg6 = arg7 <<= 16;
		    if (arg1 < 0) {
			arg3 -= i9 * arg1;
			arg4 -= i11 * arg1;
			arg6 -= i10 * arg1;
			arg7 -= i12 * arg1;
			arg1 = 0;
		    }
		    arg5 <<= 16;
		    arg8 <<= 16;
		    if (arg2 < 0) {
			arg5 -= i13 * arg2;
			arg8 -= i14 * arg2;
			arg2 = 0;
		    }
		    int i17 = arg1 - anInt1215;
		    i += i2 * i17;
		    i3 += i5 * i17;
		    i6 += i8 * i17;
		    if (arg1 != arg2 && i9 < i11 || arg1 == arg2 && i9 > i13) {
			arg0 -= arg2;
			arg2 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg2 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg1, arg3 >> 16, arg4 >> 16,
				      arg6 >> 8, arg7 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg3 += i9;
			    arg4 += i11;
			    arg6 += i10;
			    arg7 += i12;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
			while (--arg0 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg1, arg3 >> 16, arg5 >> 16,
				      arg6 >> 8, arg8 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg3 += i9;
			    arg5 += i13;
			    arg6 += i10;
			    arg8 += i14;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
		    } else {
			arg0 -= arg2;
			arg2 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg2 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg1, arg4 >> 16, arg3 >> 16,
				      arg7 >> 8, arg6 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg3 += i9;
			    arg4 += i11;
			    arg6 += i10;
			    arg7 += i12;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
			while (--arg0 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg1, arg5 >> 16, arg3 >> 16,
				      arg8 >> 8, arg6 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg3 += i9;
			    arg5 += i13;
			    arg6 += i10;
			    arg8 += i14;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
		    }
		} else {
		    arg5 = arg4 <<= 16;
		    arg8 = arg7 <<= 16;
		    if (arg1 < 0) {
			arg5 -= i9 * arg1;
			arg4 -= i11 * arg1;
			arg8 -= i10 * arg1;
			arg7 -= i12 * arg1;
			arg1 = 0;
		    }
		    arg3 <<= 16;
		    arg6 <<= 16;
		    if (arg0 < 0) {
			arg3 -= i13 * arg0;
			arg6 -= i14 * arg0;
			arg0 = 0;
		    }
		    int i18 = arg1 - anInt1215;
		    i += i2 * i18;
		    i3 += i5 * i18;
		    i6 += i8 * i18;
		    if (i9 < i11) {
			arg2 -= arg0;
			arg0 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg0 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg1, arg5 >> 16, arg4 >> 16,
				      arg8 >> 8, arg7 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg5 += i9;
			    arg4 += i11;
			    arg8 += i10;
			    arg7 += i12;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
			while (--arg2 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg1, arg3 >> 16, arg4 >> 16,
				      arg6 >> 8, arg7 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg3 += i13;
			    arg4 += i11;
			    arg6 += i14;
			    arg7 += i12;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
		    } else {
			arg2 -= arg0;
			arg0 -= arg1;
			arg1 = anIntArray1220[arg1];
			while (--arg0 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg1, arg4 >> 16, arg5 >> 16,
				      arg7 >> 8, arg8 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg5 += i9;
			    arg4 += i11;
			    arg8 += i10;
			    arg7 += i12;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
			while (--arg2 >= 0) {
			    method308(Class33_Sub2_Sub2.anIntArray1089, ints,
				      0, 0, arg1, arg4 >> 16, arg3 >> 16,
				      arg7 >> 8, arg6 >> 8, i, i3, i6, i1, i4,
				      i7);
			    arg3 += i13;
			    arg4 += i11;
			    arg6 += i14;
			    arg7 += i12;
			    arg1 += Class33_Sub2_Sub2.anInt1090;
			    i += i2;
			    i3 += i5;
			    i6 += i8;
			}
		    }
		}
	    }
	} else if (arg2 < Class33_Sub2_Sub2.anInt1093) {
	    if (arg0 > Class33_Sub2_Sub2.anInt1093)
		arg0 = Class33_Sub2_Sub2.anInt1093;
	    if (arg1 > Class33_Sub2_Sub2.anInt1093)
		arg1 = Class33_Sub2_Sub2.anInt1093;
	    if (arg0 < arg1) {
		arg4 = arg5 <<= 16;
		arg7 = arg8 <<= 16;
		if (arg2 < 0) {
		    arg4 -= i11 * arg2;
		    arg5 -= i13 * arg2;
		    arg7 -= i12 * arg2;
		    arg8 -= i14 * arg2;
		    arg2 = 0;
		}
		arg3 <<= 16;
		arg6 <<= 16;
		if (arg0 < 0) {
		    arg3 -= i9 * arg0;
		    arg6 -= i10 * arg0;
		    arg0 = 0;
		}
		int i19 = arg2 - anInt1215;
		i += i2 * i19;
		i3 += i5 * i19;
		i6 += i8 * i19;
		if (i11 < i13) {
		    arg1 -= arg0;
		    arg0 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg0 >= 0) {
			method308(Class33_Sub2_Sub2.anIntArray1089, ints, 0, 0,
				  arg2, arg4 >> 16, arg5 >> 16, arg7 >> 8,
				  arg8 >> 8, i, i3, i6, i1, i4, i7);
			arg4 += i11;
			arg5 += i13;
			arg7 += i12;
			arg8 += i14;
			arg2 += Class33_Sub2_Sub2.anInt1090;
			i += i2;
			i3 += i5;
			i6 += i8;
		    }
		    while (--arg1 >= 0) {
			method308(Class33_Sub2_Sub2.anIntArray1089, ints, 0, 0,
				  arg2, arg4 >> 16, arg3 >> 16, arg7 >> 8,
				  arg6 >> 8, i, i3, i6, i1, i4, i7);
			arg4 += i11;
			arg3 += i9;
			arg7 += i12;
			arg6 += i10;
			arg2 += Class33_Sub2_Sub2.anInt1090;
			i += i2;
			i3 += i5;
			i6 += i8;
		    }
		} else {
		    arg1 -= arg0;
		    arg0 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg0 >= 0) {
			method308(Class33_Sub2_Sub2.anIntArray1089, ints, 0, 0,
				  arg2, arg5 >> 16, arg4 >> 16, arg8 >> 8,
				  arg7 >> 8, i, i3, i6, i1, i4, i7);
			arg4 += i11;
			arg5 += i13;
			arg7 += i12;
			arg8 += i14;
			arg2 += Class33_Sub2_Sub2.anInt1090;
			i += i2;
			i3 += i5;
			i6 += i8;
		    }
		    while (--arg1 >= 0) {
			method308(Class33_Sub2_Sub2.anIntArray1089, ints, 0, 0,
				  arg2, arg3 >> 16, arg4 >> 16, arg6 >> 8,
				  arg7 >> 8, i, i3, i6, i1, i4, i7);
			arg4 += i11;
			arg3 += i9;
			arg7 += i12;
			arg6 += i10;
			arg2 += Class33_Sub2_Sub2.anInt1090;
			i += i2;
			i3 += i5;
			i6 += i8;
		    }
		}
	    } else {
		arg3 = arg5 <<= 16;
		arg6 = arg8 <<= 16;
		if (arg2 < 0) {
		    arg3 -= i11 * arg2;
		    arg5 -= i13 * arg2;
		    arg6 -= i12 * arg2;
		    arg8 -= i14 * arg2;
		    arg2 = 0;
		}
		arg4 <<= 16;
		arg7 <<= 16;
		if (arg1 < 0) {
		    arg4 -= i9 * arg1;
		    arg7 -= i10 * arg1;
		    arg1 = 0;
		}
		int i20 = arg2 - anInt1215;
		i += i2 * i20;
		i3 += i5 * i20;
		i6 += i8 * i20;
		if (i11 < i13) {
		    arg0 -= arg1;
		    arg1 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg1 >= 0) {
			method308(Class33_Sub2_Sub2.anIntArray1089, ints, 0, 0,
				  arg2, arg3 >> 16, arg5 >> 16, arg6 >> 8,
				  arg8 >> 8, i, i3, i6, i1, i4, i7);
			arg3 += i11;
			arg5 += i13;
			arg6 += i12;
			arg8 += i14;
			arg2 += Class33_Sub2_Sub2.anInt1090;
			i += i2;
			i3 += i5;
			i6 += i8;
		    }
		    while (--arg0 >= 0) {
			method308(Class33_Sub2_Sub2.anIntArray1089, ints, 0, 0,
				  arg2, arg4 >> 16, arg5 >> 16, arg7 >> 8,
				  arg8 >> 8, i, i3, i6, i1, i4, i7);
			arg4 += i9;
			arg5 += i13;
			arg7 += i10;
			arg8 += i14;
			arg2 += Class33_Sub2_Sub2.anInt1090;
			i += i2;
			i3 += i5;
			i6 += i8;
		    }
		} else {
		    arg0 -= arg1;
		    arg1 -= arg2;
		    arg2 = anIntArray1220[arg2];
		    while (--arg1 >= 0) {
			method308(Class33_Sub2_Sub2.anIntArray1089, ints, 0, 0,
				  arg2, arg5 >> 16, arg3 >> 16, arg8 >> 8,
				  arg6 >> 8, i, i3, i6, i1, i4, i7);
			arg3 += i11;
			arg5 += i13;
			arg6 += i12;
			arg8 += i14;
			arg2 += Class33_Sub2_Sub2.anInt1090;
			i += i2;
			i3 += i5;
			i6 += i8;
		    }
		    while (--arg0 >= 0) {
			method308(Class33_Sub2_Sub2.anIntArray1089, ints, 0, 0,
				  arg2, arg5 >> 16, arg4 >> 16, arg8 >> 8,
				  arg7 >> 8, i, i3, i6, i1, i4, i7);
			arg4 += i9;
			arg5 += i13;
			arg7 += i10;
			arg8 += i14;
			arg2 += Class33_Sub2_Sub2.anInt1090;
			i += i2;
			i3 += i5;
			i6 += i8;
		    }
		}
	    }
	}
    }
    
    public static final void method308
	(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5,
	 int arg6, int arg7, int arg8, int arg9, int arg10, int arg11,
	 int arg12, int arg13, int arg14) {
	if (arg5 < arg6) {
	    int i;
	    int i1;
	    if (aBoolean1210) {
		i1 = (arg8 - arg7) / (arg6 - arg5);
		if (arg6 > Class33_Sub2_Sub2.anInt1096)
		    arg6 = Class33_Sub2_Sub2.anInt1096;
		if (arg5 < 0) {
		    arg7 -= arg5 * i1;
		    arg5 = 0;
		}
		if (arg5 >= arg6)
		    return;
		i = arg6 - arg5 >> 3;
		i1 <<= 12;
		arg7 <<= 9;
	    } else {
		if (arg6 - arg5 > 7) {
		    i = arg6 - arg5 >> 3;
		    i1 = (arg8 - arg7) * anIntArray1216[i] >> 6;
		} else {
		    i = 0;
		    i1 = 0;
		}
		arg7 <<= 9;
	    }
	    arg4 += arg5;
	    if (aBoolean1209) {
		int i2 = 0;
		int i3 = 0;
		int i4 = arg5 - anInt1214;
		arg9 += (arg12 >> 3) * i4;
		arg10 += (arg13 >> 3) * i4;
		arg11 += (arg14 >> 3) * i4;
		int i5 = arg11 >> 12;
		if (i5 != 0) {
		    arg2 = arg9 / i5;
		    arg3 = arg10 / i5;
		    if (arg2 < 0)
			arg2 = 0;
		    else if (arg2 > 4032)
			arg2 = 4032;
		}
		arg9 += arg12;
		arg10 += arg13;
		arg11 += arg14;
		i5 = arg11 >> 12;
		if (i5 != 0) {
		    i2 = arg9 / i5;
		    i3 = arg10 / i5;
		    if (i2 < 7)
			i2 = 7;
		    else if (i2 > 4032)
			i2 = 4032;
		}
		int i6 = i2 - arg2 >> 3;
		int i7 = i3 - arg3 >> 3;
		arg2 += (arg7 & 0x600000) >> 3;
		int i8 = arg7 >> 23;
		if (aBoolean1211) {
		    while (i-- > 0) {
			arg0[arg4++]
			    = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8;
			arg2 += i6;
			arg3 += i7;
			arg0[arg4++]
			    = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8;
			arg2 += i6;
			arg3 += i7;
			arg0[arg4++]
			    = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8;
			arg2 += i6;
			arg3 += i7;
			arg0[arg4++]
			    = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8;
			arg2 += i6;
			arg3 += i7;
			arg0[arg4++]
			    = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8;
			arg2 += i6;
			arg3 += i7;
			arg0[arg4++]
			    = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8;
			arg2 += i6;
			arg3 += i7;
			arg0[arg4++]
			    = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8;
			arg2 += i6;
			arg3 += i7;
			arg0[arg4++]
			    = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8;
			arg2 = i2;
			arg3 = i3;
			arg9 += arg12;
			arg10 += arg13;
			arg11 += arg14;
			i5 = arg11 >> 12;
			if (i5 != 0) {
			    i2 = arg9 / i5;
			    i3 = arg10 / i5;
			    if (i2 < 7)
				i2 = 7;
			    else if (i2 > 4032)
				i2 = 4032;
			}
			i6 = i2 - arg2 >> 3;
			i7 = i3 - arg3 >> 3;
			arg7 += i1;
			arg2 += (arg7 & 0x600000) >> 3;
			i8 = arg7 >> 23;
		    }
		    i = arg6 - arg5 & 0x7;
		    while (i-- > 0) {
			arg0[arg4++]
			    = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8;
			arg2 += i6;
			arg3 += i7;
		    }
		} else {
		    while (i-- > 0) {
			int i9;
			if ((i9 = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8)
			    != 0)
			    arg0[arg4] = i9;
			arg4++;
			arg2 += i6;
			arg3 += i7;
			if ((i9 = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8)
			    != 0)
			    arg0[arg4] = i9;
			arg4++;
			arg2 += i6;
			arg3 += i7;
			if ((i9 = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8)
			    != 0)
			    arg0[arg4] = i9;
			arg4++;
			arg2 += i6;
			arg3 += i7;
			if ((i9 = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8)
			    != 0)
			    arg0[arg4] = i9;
			arg4++;
			arg2 += i6;
			arg3 += i7;
			if ((i9 = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8)
			    != 0)
			    arg0[arg4] = i9;
			arg4++;
			arg2 += i6;
			arg3 += i7;
			if ((i9 = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8)
			    != 0)
			    arg0[arg4] = i9;
			arg4++;
			arg2 += i6;
			arg3 += i7;
			if ((i9 = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8)
			    != 0)
			    arg0[arg4] = i9;
			arg4++;
			arg2 += i6;
			arg3 += i7;
			if ((i9 = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8)
			    != 0)
			    arg0[arg4] = i9;
			arg4++;
			arg2 = i2;
			arg3 = i3;
			arg9 += arg12;
			arg10 += arg13;
			arg11 += arg14;
			i5 = arg11 >> 12;
			if (i5 != 0) {
			    i2 = arg9 / i5;
			    i3 = arg10 / i5;
			    if (i2 < 7)
				i2 = 7;
			    else if (i2 > 4032)
				i2 = 4032;
			}
			i6 = i2 - arg2 >> 3;
			i7 = i3 - arg3 >> 3;
			arg7 += i1;
			arg2 += (arg7 & 0x600000) >> 3;
			i8 = arg7 >> 23;
		    }
		    i = arg6 - arg5 & 0x7;
		    while (i-- > 0) {
			int i10;
			if ((i10 = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i8)
			    != 0)
			    arg0[arg4] = i10;
			arg4++;
			arg2 += i6;
			arg3 += i7;
		    }
		}
	    } else {
		int i11 = 0;
		int i12 = 0;
		int i13 = arg5 - anInt1214;
		arg9 += (arg12 >> 3) * i13;
		arg10 += (arg13 >> 3) * i13;
		arg11 += (arg14 >> 3) * i13;
		int i14 = arg11 >> 14;
		if (i14 != 0) {
		    arg2 = arg9 / i14;
		    arg3 = arg10 / i14;
		    if (arg2 < 0)
			arg2 = 0;
		    else if (arg2 > 16256)
			arg2 = 16256;
		}
		arg9 += arg12;
		arg10 += arg13;
		arg11 += arg14;
		i14 = arg11 >> 14;
		if (i14 != 0) {
		    i11 = arg9 / i14;
		    i12 = arg10 / i14;
		    if (i11 < 7)
			i11 = 7;
		    else if (i11 > 16256)
			i11 = 16256;
		}
		int i15 = i11 - arg2 >> 3;
		int i16 = i12 - arg3 >> 3;
		arg2 += arg7 & 0x600000;
		int i17 = arg7 >> 23;
		if (aBoolean1211) {
		    while (i-- > 0) {
			arg0[arg4++]
			    = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17;
			arg2 += i15;
			arg3 += i16;
			arg0[arg4++]
			    = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17;
			arg2 += i15;
			arg3 += i16;
			arg0[arg4++]
			    = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17;
			arg2 += i15;
			arg3 += i16;
			arg0[arg4++]
			    = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17;
			arg2 += i15;
			arg3 += i16;
			arg0[arg4++]
			    = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17;
			arg2 += i15;
			arg3 += i16;
			arg0[arg4++]
			    = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17;
			arg2 += i15;
			arg3 += i16;
			arg0[arg4++]
			    = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17;
			arg2 += i15;
			arg3 += i16;
			arg0[arg4++]
			    = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17;
			arg2 = i11;
			arg3 = i12;
			arg9 += arg12;
			arg10 += arg13;
			arg11 += arg14;
			i14 = arg11 >> 14;
			if (i14 != 0) {
			    i11 = arg9 / i14;
			    i12 = arg10 / i14;
			    if (i11 < 7)
				i11 = 7;
			    else if (i11 > 16256)
				i11 = 16256;
			}
			i15 = i11 - arg2 >> 3;
			i16 = i12 - arg3 >> 3;
			arg7 += i1;
			arg2 += arg7 & 0x600000;
			i17 = arg7 >> 23;
		    }
		    i = arg6 - arg5 & 0x7;
		    while (i-- > 0) {
			arg0[arg4++]
			    = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17;
			arg2 += i15;
			arg3 += i16;
		    }
		} else {
		    while (i-- > 0) {
			int i18;
			if ((i18 = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17)
			    != 0)
			    arg0[arg4] = i18;
			arg4++;
			arg2 += i15;
			arg3 += i16;
			if ((i18 = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17)
			    != 0)
			    arg0[arg4] = i18;
			arg4++;
			arg2 += i15;
			arg3 += i16;
			if ((i18 = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17)
			    != 0)
			    arg0[arg4] = i18;
			arg4++;
			arg2 += i15;
			arg3 += i16;
			if ((i18 = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17)
			    != 0)
			    arg0[arg4] = i18;
			arg4++;
			arg2 += i15;
			arg3 += i16;
			if ((i18 = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17)
			    != 0)
			    arg0[arg4] = i18;
			arg4++;
			arg2 += i15;
			arg3 += i16;
			if ((i18 = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17)
			    != 0)
			    arg0[arg4] = i18;
			arg4++;
			arg2 += i15;
			arg3 += i16;
			if ((i18 = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17)
			    != 0)
			    arg0[arg4] = i18;
			arg4++;
			arg2 += i15;
			arg3 += i16;
			if ((i18 = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17)
			    != 0)
			    arg0[arg4] = i18;
			arg4++;
			arg2 = i11;
			arg3 = i12;
			arg9 += arg12;
			arg10 += arg13;
			arg11 += arg14;
			i14 = arg11 >> 14;
			if (i14 != 0) {
			    i11 = arg9 / i14;
			    i12 = arg10 / i14;
			    if (i11 < 7)
				i11 = 7;
			    else if (i11 > 16256)
				i11 = 16256;
			}
			i15 = i11 - arg2 >> 3;
			i16 = i12 - arg3 >> 3;
			arg7 += i1;
			arg2 += arg7 & 0x600000;
			i17 = arg7 >> 23;
		    }
		    i = arg6 - arg5 & 0x7;
		    while (i-- > 0) {
			int i19;
			if ((i19 = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i17)
			    != 0)
			    arg0[arg4] = i19;
			arg4++;
			arg2 += i15;
			arg3 += i16;
		    }
		}
	    }
	}
    }
    
    static {
	for (int i = 1; i < 512; i++)
	    anIntArray1216[i] = 32768 / i;
	for (int i = 1; i < 2048; i++)
	    anIntArray1217[i] = 65536 / i;
	for (int i = 0; i < 2048; i++) {
	    anIntArray1218[i]
		= (int) (65536.0 * Math.sin((double) i * 0.0030679615));
	    anIntArray1219[i]
		= (int) (65536.0 * Math.cos((double) i * 0.0030679615));
	}
	aClass33_Sub2_Sub2_Sub3Array1222 = new Class33_Sub2_Sub2_Sub3[50];
	aBooleanArray1223 = new boolean[50];
	anIntArray1224 = new int[50];
	anIntArrayArray1227 = new int[50][];
	anIntArray1228 = new int[50];
	anIntArray1230 = new int[65536];
	anIntArrayArray1231 = new int[50][];
    }
}
