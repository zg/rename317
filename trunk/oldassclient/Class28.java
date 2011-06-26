
public final class Class28
{
    public static int method242(byte[] arg0, int arg1, byte[] arg2, int arg3,
				int arg4) {
	Class30 class30 = new Class30();
	((Class30) class30).aByteArray448 = arg2;
	((Class30) class30).anInt449 = arg4;
	((Class30) class30).aByteArray453 = arg0;
	((Class30) class30).anInt454 = 0;
	((Class30) class30).anInt450 = arg3;
	((Class30) class30).anInt455 = arg1;
	((Class30) class30).anInt462 = 0;
	((Class30) class30).anInt461 = 0;
	((Class30) class30).anInt451 = 0;
	((Class30) class30).anInt452 = 0;
	((Class30) class30).anInt456 = 0;
	((Class30) class30).anInt457 = 0;
	((Class30) class30).anInt464 = 0;
	method244(class30);
	arg1 -= ((Class30) class30).anInt455;
	return arg1;
    }
    
    private static void method243(Class30 arg0) {
	byte i = ((Class30) arg0).aByte458;
	int i1 = ((Class30) arg0).anInt459;
	int i2 = ((Class30) arg0).anInt469;
	int i3 = ((Class30) arg0).anInt467;
	int[] ints = Class30.anIntArray472;
	int i4 = ((Class30) arg0).anInt466;
	byte[] bytes = ((Class30) arg0).aByteArray453;
	int i5 = ((Class30) arg0).anInt454;
	int i6 = ((Class30) arg0).anInt455;
	int i7 = i6;
	int i8 = ((Class30) arg0).anInt486 + 1;
    while10:
	for (;;) {
	    if (i1 > 0) {
		for (;;) {
		    if (i6 == 0)
			break while10;
		    if (i1 == 1)
			break;
		    bytes[i5] = i;
		    i1--;
		    i5++;
		    i6--;
		}
		if (i6 == 0) {
		    i1 = 1;
		    break;
		}
		bytes[i5] = i;
		i5++;
		i6--;
	    }
	    boolean flag = true;
	    while (flag) {
		flag = false;
		if (i2 == i8) {
		    i1 = 0;
		    break while10;
		}
		i = (byte) i3;
		i4 = ints[i4];
		int i9 = (byte) (i4 & 0xff);
		i4 >>= 8;
		i2++;
		if (i9 != i3) {
		    i3 = i9;
		    if (i6 == 0) {
			i1 = 1;
			break while10;
		    }
		    bytes[i5] = i;
		    i5++;
		    i6--;
		    flag = true;
		} else if (i2 == i8) {
		    if (i6 == 0) {
			i1 = 1;
			break while10;
		    }
		    bytes[i5] = i;
		    i5++;
		    i6--;
		    flag = true;
		}
	    }
	    i1 = 2;
	    i4 = ints[i4];
	    int i10 = (byte) (i4 & 0xff);
	    i4 >>= 8;
	    if (++i2 != i8) {
		if (i10 != i3)
		    i3 = i10;
		else {
		    i1 = 3;
		    i4 = ints[i4];
		    i10 = (byte) (i4 & 0xff);
		    i4 >>= 8;
		    if (++i2 != i8) {
			if (i10 != i3)
			    i3 = i10;
			else {
			    i4 = ints[i4];
			    i10 = (byte) (i4 & 0xff);
			    i4 >>= 8;
			    i2++;
			    i1 = (i10 & 0xff) + 4;
			    i4 = ints[i4];
			    i3 = (byte) (i4 & 0xff);
			    i4 >>= 8;
			    i2++;
			}
		    }
		}
	    }
	}
	int i11 = ((Class30) arg0).anInt456;
	((Class30) arg0).anInt456 += i7 - i6;
	if (((Class30) arg0).anInt456 < i11)
	    ((Class30) arg0).anInt457++;
	((Class30) arg0).aByte458 = i;
	((Class30) arg0).anInt459 = i1;
	((Class30) arg0).anInt469 = i2;
	((Class30) arg0).anInt467 = i3;
	Class30.anIntArray472 = ints;
	((Class30) arg0).anInt466 = i4;
	((Class30) arg0).aByteArray453 = bytes;
	((Class30) arg0).anInt454 = i5;
	((Class30) arg0).anInt455 = i6;
    }
    
    private static void method244(Class30 arg0) {
	boolean flag = false;
	boolean flag1 = false;
	boolean flag2 = false;
	boolean flag3 = false;
	boolean flag4 = false;
	boolean flag5 = false;
	boolean flag6 = false;
	boolean flag7 = false;
	boolean flag8 = false;
	boolean flag9 = false;
	boolean flag10 = false;
	boolean flag11 = false;
	boolean flag12 = false;
	boolean flag13 = false;
	boolean flag14 = false;
	boolean flag15 = false;
	boolean flag16 = false;
	boolean flag17 = false;
	boolean flag18 = false;
	int i = 0;
	int[] is = null;
	int[] is19 = null;
	int[] ints = null;
	((Class30) arg0).anInt463 = 1;
	if (Class30.anIntArray472 == null)
	    Class30.anIntArray472
		= new int[((Class30) arg0).anInt463 * 100000];
	boolean flag20 = true;
	while (flag20) {
	    byte i21 = method245(arg0);
	    if (i21 == 23)
		break;
	    i21 = method245(arg0);
	    i21 = method245(arg0);
	    i21 = method245(arg0);
	    i21 = method245(arg0);
	    i21 = method245(arg0);
	    ((Class30) arg0).anInt464++;
	    i21 = method245(arg0);
	    i21 = method245(arg0);
	    i21 = method245(arg0);
	    i21 = method245(arg0);
	    i21 = method246(arg0);
	    if (i21 != 0)
		((Class30) arg0).aBoolean460 = true;
	    else
		((Class30) arg0).aBoolean460 = false;
	    if (((Class30) arg0).aBoolean460)
		System.out.println("PANIC! RANDOMISED BLOCK!");
	    ((Class30) arg0).anInt465 = 0;
	    int i22 = method245(arg0);
	    ((Class30) arg0).anInt465
		= ((Class30) arg0).anInt465 << 8 | i22 & 0xff;
	    i22 = method245(arg0);
	    ((Class30) arg0).anInt465
		= ((Class30) arg0).anInt465 << 8 | i22 & 0xff;
	    i22 = method245(arg0);
	    ((Class30) arg0).anInt465
		= ((Class30) arg0).anInt465 << 8 | i22 & 0xff;
	    for (int i23 = 0; i23 < 16; i23++) {
		i21 = method246(arg0);
		if (i21 == 1)
		    ((Class30) arg0).aBooleanArray475[i23] = true;
		else
		    ((Class30) arg0).aBooleanArray475[i23] = false;
	    }
	    for (int i24 = 0; i24 < 256; i24++)
		((Class30) arg0).aBooleanArray474[i24] = false;
	    for (int i25 = 0; i25 < 16; i25++) {
		if (((Class30) arg0).aBooleanArray475[i25]) {
		    for (int i26 = 0; i26 < 16; i26++) {
			i21 = method246(arg0);
			if (i21 == 1)
			    ((Class30) arg0).aBooleanArray474[i25 * 16 + i26]
				= true;
		    }
		}
	    }
	    method248(arg0);
	    int i27 = ((Class30) arg0).anInt473 + 2;
	    int i28 = method247(3, arg0);
	    int i29 = method247(15, arg0);
	    for (int i30 = 0; i30 < i29; i30++) {
		int i31 = 0;
		for (;;) {
		    i21 = method246(arg0);
		    if (i21 == 0)
			break;
		    i31++;
		}
		((Class30) arg0).aByteArray480[i30] = (byte) i31;
	    }
	    byte[] is32 = new byte[6];
	    for (byte i33 = 0; i33 < i28; i33++)
		is32[i33] = i33;
	    for (int i34 = 0; i34 < i29; i34++) {
		byte b = ((Class30) arg0).aByteArray480[i34];
		byte i35 = is32[b];
		for (; b > 0; b--)
		    is32[b] = is32[b - 1];
		is32[0] = i35;
		((Class30) arg0).aByteArray479[i34] = i35;
	    }
	    for (int i36 = 0; i36 < i28; i36++) {
		int i37 = method247(5, arg0);
		for (int i38 = 0; i38 < i27; i38++) {
		    for (;;) {
			i21 = method246(arg0);
			if (i21 == 0)
			    break;
			i21 = method246(arg0);
			if (i21 == 0)
			    i37++;
			else
			    i37--;
		    }
		    ((Class30) arg0).aByteArrayArray481[i36][i38] = (byte) i37;
		}
	    }
	    for (int i39 = 0; i39 < i28; i39++) {
		int i40 = 32;
		byte i41 = 0;
		for (int i42 = 0; i42 < i27; i42++) {
		    if (((Class30) arg0).aByteArrayArray481[i39][i42] > i41)
			i41 = ((Class30) arg0).aByteArrayArray481[i39][i42];
		    if (((Class30) arg0).aByteArrayArray481[i39][i42] < i40)
			i40 = ((Class30) arg0).aByteArrayArray481[i39][i42];
		}
		method249(((Class30) arg0).anIntArrayArray482[i39],
			  ((Class30) arg0).anIntArrayArray483[i39],
			  ((Class30) arg0).anIntArrayArray484[i39],
			  ((Class30) arg0).aByteArrayArray481[i39], i40, i41,
			  i27);
		((Class30) arg0).anIntArray485[i39] = i40;
	    }
	    int i43 = ((Class30) arg0).anInt473 + 1;
	    int i44 = ((Class30) arg0).anInt463 * 100000;
	    int i45 = -1;
	    int i46 = 0;
	    for (int i47 = 0; i47 <= 255; i47++)
		((Class30) arg0).anIntArray468[i47] = 0;
	    int i48 = 4095;
	    for (int i49 = 15; i49 >= 0; i49--) {
		for (int i50 = 15; i50 >= 0; i50--) {
		    ((Class30) arg0).aByteArray477[i48]
			= (byte) (i49 * 16 + i50);
		    i48--;
		}
		((Class30) arg0).anIntArray478[i49] = i48 + 1;
	    }
	    int i51 = 0;
	    if (i46 == 0) {
		i45++;
		i46 = 50;
		byte i52 = ((Class30) arg0).aByteArray479[i45];
		i = ((Class30) arg0).anIntArray485[i52];
		is = ((Class30) arg0).anIntArrayArray482[i52];
		ints = ((Class30) arg0).anIntArrayArray484[i52];
		is19 = ((Class30) arg0).anIntArrayArray483[i52];
	    }
	    i46--;
	    int i53 = i;
	    int i54;
	    int i55;
	    for (i55 = method247(i53, arg0); i55 > is[i53];
		 i55 = i55 << 1 | i54) {
		i53++;
		i54 = method246(arg0);
	    }
	    int i56 = ints[i55 - is19[i53]];
	    while (i56 != i43) {
		if (i56 == 0 || i56 == 1) {
		    int i57 = -1;
		    int i58 = 1;
		    do {
			if (i56 == 0)
			    i57 += i58;
			else if (i56 == 1)
			    i57 += i58 * 2;
			i58 *= 2;
			if (i46 == 0) {
			    i45++;
			    i46 = 50;
			    byte i59 = ((Class30) arg0).aByteArray479[i45];
			    i = ((Class30) arg0).anIntArray485[i59];
			    is = ((Class30) arg0).anIntArrayArray482[i59];
			    ints = ((Class30) arg0).anIntArrayArray484[i59];
			    is19 = ((Class30) arg0).anIntArrayArray483[i59];
			}
			i46--;
			i53 = i;
			for (i55 = method247(i53, arg0); i55 > is[i53];
			     i55 = i55 << 1 | i54) {
			    i53++;
			    i54 = method246(arg0);
			}
			i56 = ints[i55 - is19[i53]];
		    } while (i56 == 0 || i56 == 1);
		    i57++;
		    i22 = (((Class30) arg0).aByteArray476
			   [(((Class30) arg0).aByteArray477
			     [((Class30) arg0).anIntArray478[0]]) & 0xff]);
		    ((Class30) arg0).anIntArray468[i22 & 0xff] += i57;
		    for (; i57 > 0; i57--) {
			Class30.anIntArray472[i51] = i22 & 0xff;
			i51++;
		    }
		} else {
		    int i60 = i56 - 1;
		    if (i60 < 16) {
			int i61 = ((Class30) arg0).anIntArray478[0];
			i21 = ((Class30) arg0).aByteArray477[i61 + i60];
			for (; i60 > 3; i60 -= 4) {
			    int i62 = i61 + i60;
			    ((Class30) arg0).aByteArray477[i62]
				= ((Class30) arg0).aByteArray477[i62 - 1];
			    ((Class30) arg0).aByteArray477[i62 - 1]
				= ((Class30) arg0).aByteArray477[i62 - 2];
			    ((Class30) arg0).aByteArray477[i62 - 2]
				= ((Class30) arg0).aByteArray477[i62 - 3];
			    ((Class30) arg0).aByteArray477[i62 - 3]
				= ((Class30) arg0).aByteArray477[i62 - 4];
			}
			for (; i60 > 0; i60--)
			    ((Class30) arg0).aByteArray477[i61 + i60]
				= (((Class30) arg0).aByteArray477
				   [i61 + i60 - 1]);
			((Class30) arg0).aByteArray477[i61] = i21;
		    } else {
			int i63 = i60 / 16;
			int i64 = i60 % 16;
			int i65 = ((Class30) arg0).anIntArray478[i63] + i64;
			i21 = ((Class30) arg0).aByteArray477[i65];
			for (; i65 > ((Class30) arg0).anIntArray478[i63];
			     i65--)
			    ((Class30) arg0).aByteArray477[i65]
				= ((Class30) arg0).aByteArray477[i65 - 1];
			((Class30) arg0).anIntArray478[i63]++;
			for (; i63 > 0; i63--) {
			    ((Class30) arg0).anIntArray478[i63]--;
			    ((Class30) arg0).aByteArray477
				[((Class30) arg0).anIntArray478[i63]]
				= (((Class30) arg0).aByteArray477
				   [(((Class30) arg0).anIntArray478[i63 - 1]
				     + 16 - 1)]);
			}
			((Class30) arg0).anIntArray478[0]--;
			((Class30) arg0).aByteArray477[(((Class30) arg0)
							.anIntArray478[0])]
			    = i21;
			if (((Class30) arg0).anIntArray478[0] == 0) {
			    int i66 = 4095;
			    for (int i67 = 15; i67 >= 0; i67--) {
				for (int i68 = 15; i68 >= 0; i68--) {
				    ((Class30) arg0).aByteArray477[i66]
					= (((Class30) arg0).aByteArray477
					   [(((Class30) arg0).anIntArray478
					     [i67]) + i68]);
				    i66--;
				}
				((Class30) arg0).anIntArray478[i67] = i66 + 1;
			    }
			}
		    }
		    ((Class30) arg0).anIntArray468
			[((Class30) arg0).aByteArray476[i21 & 0xff] & 0xff]++;
		    Class30.anIntArray472[i51]
			= ((Class30) arg0).aByteArray476[i21 & 0xff] & 0xff;
		    i51++;
		    if (i46 == 0) {
			i45++;
			i46 = 50;
			byte i69 = ((Class30) arg0).aByteArray479[i45];
			i = ((Class30) arg0).anIntArray485[i69];
			is = ((Class30) arg0).anIntArrayArray482[i69];
			ints = ((Class30) arg0).anIntArrayArray484[i69];
			is19 = ((Class30) arg0).anIntArrayArray483[i69];
		    }
		    i46--;
		    i53 = i;
		    for (i55 = method247(i53, arg0); i55 > is[i53];
			 i55 = i55 << 1 | i54) {
			i53++;
			i54 = method246(arg0);
		    }
		    i56 = ints[i55 - is19[i53]];
		}
	    }
	    ((Class30) arg0).anInt459 = 0;
	    ((Class30) arg0).aByte458 = (byte) 0;
	    ((Class30) arg0).anIntArray470[0] = 0;
	    for (int i70 = 1; i70 <= 256; i70++)
		((Class30) arg0).anIntArray470[i70]
		    = ((Class30) arg0).anIntArray468[i70 - 1];
	    for (int i71 = 1; i71 <= 256; i71++)
		((Class30) arg0).anIntArray470[i71]
		    += ((Class30) arg0).anIntArray470[i71 - 1];
	    for (int i72 = 0; i72 < i51; i72++) {
		i22 = (byte) (Class30.anIntArray472[i72] & 0xff);
		Class30.anIntArray472[(((Class30) arg0).anIntArray470
				       [i22 & 0xff])]
		    |= i72 << 8;
		((Class30) arg0).anIntArray470[i22 & 0xff]++;
	    }
	    ((Class30) arg0).anInt466
		= Class30.anIntArray472[((Class30) arg0).anInt465] >> 8;
	    ((Class30) arg0).anInt469 = 0;
	    ((Class30) arg0).anInt466
		= Class30.anIntArray472[((Class30) arg0).anInt466];
	    ((Class30) arg0).anInt467
		= (byte) (((Class30) arg0).anInt466 & 0xff);
	    ((Class30) arg0).anInt466 >>= 8;
	    ((Class30) arg0).anInt469++;
	    ((Class30) arg0).anInt486 = i51;
	    method243(arg0);
	    if (((Class30) arg0).anInt469 == ((Class30) arg0).anInt486 + 1
		&& ((Class30) arg0).anInt459 == 0)
		flag20 = true;
	    else
		flag20 = false;
	}
    }
    
    private static byte method245(Class30 arg0) {
	return (byte) method247(8, arg0);
    }
    
    private static byte method246(Class30 arg0) {
	return (byte) method247(1, arg0);
    }
    
    private static int method247(int arg0, Class30 arg1) {
	int i;
	for (;;) {
	    if (((Class30) arg1).anInt462 >= arg0) {
		int i1 = ((((Class30) arg1).anInt461
			   >> ((Class30) arg1).anInt462 - arg0)
			  & (1 << arg0) - 1);
		((Class30) arg1).anInt462 -= arg0;
		i = i1;
		break;
	    }
	    ((Class30) arg1).anInt461
		= (((Class30) arg1).anInt461 << 8
		   | (((Class30) arg1).aByteArray448[((Class30) arg1).anInt449]
		      & 0xff));
	    ((Class30) arg1).anInt462 += 8;
	    ((Class30) arg1).anInt449++;
	    ((Class30) arg1).anInt450--;
	    ((Class30) arg1).anInt451++;
	    if (((Class30) arg1).anInt451 == 0)
		((Class30) arg1).anInt452++;
	}
	return i;
    }
    
    private static void method248(Class30 arg0) {
	((Class30) arg0).anInt473 = 0;
	for (int i = 0; i < 256; i++) {
	    if (((Class30) arg0).aBooleanArray474[i]) {
		((Class30) arg0).aByteArray476[((Class30) arg0).anInt473]
		    = (byte) i;
		((Class30) arg0).anInt473++;
	    }
	}
    }
    
    private static void method249(int[] arg0, int[] arg1, int[] arg2,
				  byte[] arg3, int arg4, int arg5, int arg6) {
	int i = 0;
	for (int i1 = arg4; i1 <= arg5; i1++) {
	    for (int i2 = 0; i2 < arg6; i2++) {
		if (arg3[i2] == i1) {
		    arg2[i] = i2;
		    i++;
		}
	    }
	}
	for (int i3 = 0; i3 < 23; i3++)
	    arg1[i3] = 0;
	for (int i4 = 0; i4 < arg6; i4++)
	    arg1[arg3[i4] + 1]++;
	for (int i5 = 1; i5 < 23; i5++)
	    arg1[i5] += arg1[i5 - 1];
	for (int i6 = 0; i6 < 23; i6++)
	    arg0[i6] = 0;
	int i7 = 0;
	for (int i8 = arg4; i8 <= arg5; i8++) {
	    i7 += arg1[i8 + 1] - arg1[i8];
	    arg0[i8] = i7 - 1;
	    i7 <<= 1;
	}
	for (int i9 = arg4 + 1; i9 <= arg5; i9++)
	    arg1[i9] = (arg0[i9 - 1] + 1 << 1) - arg1[i9];
    }
}
