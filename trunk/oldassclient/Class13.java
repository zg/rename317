
final class Class13
{
    private int anInt216 = 8;
    int[] anIntArray217;
    int[] anIntArray218;
    int[] anIntArray219;
    int[] anIntArray220;
    int[] anIntArray221;
    int[] anIntArray222;
    int[] anIntArray223;
    int[] anIntArray224;
    int[] anIntArray225;
    int[] anIntArray226;
    boolean aBoolean227 = true;
    int anInt228;
    int anInt229;
    int anInt230;
    int anInt231;
    static int[] anIntArray232 = new int[6];
    static int[] anIntArray233 = new int[6];
    static int[] anIntArray234 = new int[6];
    static int[] anIntArray235 = new int[6];
    static int[] anIntArray236 = new int[6];
    static int[] anIntArray237 = { 1, 0 };
    static int[] anIntArray238 = { 2, 1 };
    static int[] anIntArray239 = { 3, 3 };
    static final int[][] anIntArrayArray240
	= { { 1, 3, 5, 7 }, { 1, 3, 5, 7 }, { 1, 3, 5, 7 }, { 1, 3, 5, 7, 6 },
	    { 1, 3, 5, 7, 6 }, { 1, 3, 5, 7, 6 }, { 1, 3, 5, 7, 6 },
	    { 1, 3, 5, 7, 2, 6 }, { 1, 3, 5, 7, 2, 8 }, { 1, 3, 5, 7, 2, 8 },
	    { 1, 3, 5, 7, 11, 12 }, { 1, 3, 5, 7, 11, 12 },
	    { 1, 3, 5, 7, 13, 14 } };
    static final int[][] anIntArrayArray241
	= { { 0, 1, 2, 3, 0, 0, 1, 3 }, { 1, 1, 2, 3, 1, 0, 1, 3 },
	    { 0, 1, 2, 3, 1, 0, 1, 3 }, { 0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3 },
	    { 0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4 },
	    { 0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4 },
	    { 0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3 },
	    { 0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3 },
	    { 0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5 },
	    { 0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5 },
	    { 0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4,
	      2, 3 },
	    { 1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4,
	      2, 3 },
	    { 1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1,
	      2, 5 } };
    
    public Class13(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5,
		   int arg6, int arg7, int arg8, int arg9, int arg10,
		   int arg11, int arg12, int arg13, int arg14, int arg15,
		   int arg16, byte arg17, int arg18, int arg19) {
	if (arg3 != arg13 || arg3 != arg2 || arg3 != arg0)
	    ((Class13) this).aBoolean227 = false;
	((Class13) this).anInt228 = arg15;
	((Class13) this).anInt229 = arg8;
	((Class13) this).anInt230 = arg18;
	((Class13) this).anInt231 = arg19;
	int i = 128;
	int i1 = i / 2;
	int i2 = i / 4;
	int i3 = i * 3 / 4;
	int[] ints = anIntArrayArray240[arg15];
	int i4 = ints.length;
	((Class13) this).anIntArray217 = new int[i4];
	((Class13) this).anIntArray218 = new int[i4];
	((Class13) this).anIntArray219 = new int[i4];
	int[] ints5 = new int[i4];
	int[] ints6 = new int[i4];
	int i7 = arg4 * i;
	int i8 = arg1 * i;
	for (int i9 = 0; i9 < i4; i9++) {
	    int i10 = ints[i9];
	    if ((i10 & 0x1) == 0 && i10 <= 8)
		i10 = (i10 - arg8 - arg8 - 1 & 0x7) + 1;
	    if (i10 > 8 && i10 <= 12)
		i10 = (i10 - 9 - arg8 & 0x3) + 9;
	    if (i10 > 12 && i10 <= 16)
		i10 = (i10 - 13 - arg8 & 0x3) + 13;
	    int i11;
	    int i12;
	    int i13;
	    int i14;
	    int i15;
	    if (i10 == 1) {
		i11 = i7;
		i12 = i8;
		i13 = arg3;
		i14 = arg6;
		i15 = arg11;
	    } else if (i10 == 2) {
		i11 = i7 + i1;
		i12 = i8;
		i13 = arg3 + arg13 >> 1;
		i14 = arg6 + arg14 >> 1;
		i15 = arg11 + arg7 >> 1;
	    } else if (i10 == 3) {
		i11 = i7 + i;
		i12 = i8;
		i13 = arg13;
		i14 = arg14;
		i15 = arg7;
	    } else if (i10 == 4) {
		i11 = i7 + i;
		i12 = i8 + i1;
		i13 = arg13 + arg2 >> 1;
		i14 = arg14 + arg9 >> 1;
		i15 = arg7 + arg10 >> 1;
	    } else if (i10 == 5) {
		i11 = i7 + i;
		i12 = i8 + i;
		i13 = arg2;
		i14 = arg9;
		i15 = arg10;
	    } else if (i10 == 6) {
		i11 = i7 + i1;
		i12 = i8 + i;
		i13 = arg2 + arg0 >> 1;
		i14 = arg9 + arg12 >> 1;
		i15 = arg10 + arg16 >> 1;
	    } else if (i10 == 7) {
		i11 = i7;
		i12 = i8 + i;
		i13 = arg0;
		i14 = arg12;
		i15 = arg16;
	    } else if (i10 == 8) {
		i11 = i7;
		i12 = i8 + i1;
		i13 = arg0 + arg3 >> 1;
		i14 = arg12 + arg6 >> 1;
		i15 = arg16 + arg11 >> 1;
	    } else if (i10 == 9) {
		i11 = i7 + i1;
		i12 = i8 + i2;
		i13 = arg3 + arg13 >> 1;
		i14 = arg6 + arg14 >> 1;
		i15 = arg11 + arg7 >> 1;
	    } else if (i10 == 10) {
		i11 = i7 + i3;
		i12 = i8 + i1;
		i13 = arg13 + arg2 >> 1;
		i14 = arg14 + arg9 >> 1;
		i15 = arg7 + arg10 >> 1;
	    } else if (i10 == 11) {
		i11 = i7 + i1;
		i12 = i8 + i3;
		i13 = arg2 + arg0 >> 1;
		i14 = arg9 + arg12 >> 1;
		i15 = arg10 + arg16 >> 1;
	    } else if (i10 == 12) {
		i11 = i7 + i2;
		i12 = i8 + i1;
		i13 = arg0 + arg3 >> 1;
		i14 = arg12 + arg6 >> 1;
		i15 = arg16 + arg11 >> 1;
	    } else if (i10 == 13) {
		i11 = i7 + i2;
		i12 = i8 + i2;
		i13 = arg3;
		i14 = arg6;
		i15 = arg11;
	    } else if (i10 == 14) {
		i11 = i7 + i3;
		i12 = i8 + i2;
		i13 = arg13;
		i14 = arg14;
		i15 = arg7;
	    } else if (i10 == 15) {
		i11 = i7 + i3;
		i12 = i8 + i3;
		i13 = arg2;
		i14 = arg9;
		i15 = arg10;
	    } else {
		i11 = i7 + i2;
		i12 = i8 + i3;
		i13 = arg0;
		i14 = arg12;
		i15 = arg16;
	    }
	    ((Class13) this).anIntArray217[i9] = i11;
	    ((Class13) this).anIntArray218[i9] = i13;
	    ((Class13) this).anIntArray219[i9] = i12;
	    ints5[i9] = i14;
	    ints6[i9] = i15;
	}
	int[] ints16 = anIntArrayArray241[arg15];
	int i17 = ints16.length / 4;
	if (arg17 != -119)
	    anInt216 = 136;
	((Class13) this).anIntArray223 = new int[i17];
	((Class13) this).anIntArray224 = new int[i17];
	((Class13) this).anIntArray225 = new int[i17];
	((Class13) this).anIntArray220 = new int[i17];
	((Class13) this).anIntArray221 = new int[i17];
	((Class13) this).anIntArray222 = new int[i17];
	if (arg5 != -1)
	    ((Class13) this).anIntArray226 = new int[i17];
	int i18 = 0;
	for (int i19 = 0; i19 < i17; i19++) {
	    int i20 = ints16[i18];
	    int i21 = ints16[i18 + 1];
	    int i22 = ints16[i18 + 2];
	    int i23 = ints16[i18 + 3];
	    i18 += 4;
	    if (i21 < 4)
		i21 = i21 - arg8 & 0x3;
	    if (i22 < 4)
		i22 = i22 - arg8 & 0x3;
	    if (i23 < 4)
		i23 = i23 - arg8 & 0x3;
	    ((Class13) this).anIntArray223[i19] = i21;
	    ((Class13) this).anIntArray224[i19] = i22;
	    ((Class13) this).anIntArray225[i19] = i23;
	    if (i20 == 0) {
		((Class13) this).anIntArray220[i19] = ints5[i21];
		((Class13) this).anIntArray221[i19] = ints5[i22];
		((Class13) this).anIntArray222[i19] = ints5[i23];
		if (((Class13) this).anIntArray226 != null)
		    ((Class13) this).anIntArray226[i19] = -1;
	    } else {
		((Class13) this).anIntArray220[i19] = ints6[i21];
		((Class13) this).anIntArray221[i19] = ints6[i22];
		((Class13) this).anIntArray222[i19] = ints6[i23];
		if (((Class13) this).anIntArray226 != null)
		    ((Class13) this).anIntArray226[i19] = arg5;
	    }
	}
	int i24 = arg3;
	int i25 = arg13;
	if (arg13 < i24)
	    i24 = arg13;
	if (arg13 > i25)
	    i25 = arg13;
	if (arg2 < i24)
	    i24 = arg2;
	if (arg2 > i25)
	    i25 = arg2;
	if (arg0 < i24)
	    i24 = arg0;
	if (arg0 > i25)
	    i25 = arg0;
	i24 /= 14;
	i25 /= 14;
    }
}
