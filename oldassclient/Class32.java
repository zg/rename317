
public final class Class32
{
    private int anInt490;
    private int[] anIntArray491;
    private int[] anIntArray492 = new int[256];
    private int anInt493;
    private int anInt494;
    private int anInt495;
    
    public Class32(byte arg0, int[] arg1) {
	anIntArray491 = new int[256];
	for (int i = 0; i < arg1.length; i++)
	    anIntArray491[i] = arg1[i];
	if (arg0 != -73)
	    throw new NullPointerException();
	method257();
    }
    
    public final int method255() {
	if (anInt490-- == 0) {
	    method256(4);
	    anInt490 = 255;
	}
	return anIntArray491[anInt490];
    }
    
    private final void method256(int arg0) {
	if (arg0 != 4) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	anInt494 += ++anInt495;
	for (int i = 0; i < 256; i++) {
	    int i1 = anIntArray492[i];
	    switch (i & 0x3) {
	    case 0:
		anInt493 ^= anInt493 << 13;
		break;
	    case 1:
		anInt493 ^= anInt493 >>> 6;
		break;
	    case 2:
		anInt493 ^= anInt493 << 2;
		break;
	    case 3:
		anInt493 ^= anInt493 >>> 16;
		break;
	    }
	    anInt493 += anIntArray492[i + 128 & 0xff];
	    int i2;
	    anIntArray492[i] = i2
		= anIntArray492[(i1 & 0x3fc) >> 2] + anInt493 + anInt494;
	    anIntArray491[i] = anInt494
		= anIntArray492[(i2 >> 8 & 0x3fc) >> 2] + i1;
	}
    }
    
    private final void method257() {
	int i1;
	int i2;
	int i3;
	int i4;
	int i5;
	int i6;
	int i7;
	int i = i1 = i2 = i3 = i4 = i5 = i6 = i7 = -1640531527;
	for (int i8 = 0; i8 < 4; i8++) {
	    i ^= i1 << 11;
	    i3 += i;
	    i1 += i2;
	    i1 ^= i2 >>> 2;
	    i4 += i1;
	    i2 += i3;
	    i2 ^= i3 << 8;
	    i5 += i2;
	    i3 += i4;
	    i3 ^= i4 >>> 16;
	    i6 += i3;
	    i4 += i5;
	    i4 ^= i5 << 10;
	    i7 += i4;
	    i5 += i6;
	    i5 ^= i6 >>> 4;
	    i += i5;
	    i6 += i7;
	    i6 ^= i7 << 8;
	    i1 += i6;
	    i7 += i;
	    i7 ^= i >>> 9;
	    i2 += i7;
	    i += i1;
	}
	for (int i9 = 0; i9 < 256; i9 += 8) {
	    i += anIntArray491[i9];
	    i1 += anIntArray491[i9 + 1];
	    i2 += anIntArray491[i9 + 2];
	    i3 += anIntArray491[i9 + 3];
	    i4 += anIntArray491[i9 + 4];
	    i5 += anIntArray491[i9 + 5];
	    i6 += anIntArray491[i9 + 6];
	    i7 += anIntArray491[i9 + 7];
	    i ^= i1 << 11;
	    i3 += i;
	    i1 += i2;
	    i1 ^= i2 >>> 2;
	    i4 += i1;
	    i2 += i3;
	    i2 ^= i3 << 8;
	    i5 += i2;
	    i3 += i4;
	    i3 ^= i4 >>> 16;
	    i6 += i3;
	    i4 += i5;
	    i4 ^= i5 << 10;
	    i7 += i4;
	    i5 += i6;
	    i5 ^= i6 >>> 4;
	    i += i5;
	    i6 += i7;
	    i6 ^= i7 << 8;
	    i1 += i6;
	    i7 += i;
	    i7 ^= i >>> 9;
	    i2 += i7;
	    i += i1;
	    anIntArray492[i9] = i;
	    anIntArray492[i9 + 1] = i1;
	    anIntArray492[i9 + 2] = i2;
	    anIntArray492[i9 + 3] = i3;
	    anIntArray492[i9 + 4] = i4;
	    anIntArray492[i9 + 5] = i5;
	    anIntArray492[i9 + 6] = i6;
	    anIntArray492[i9 + 7] = i7;
	}
	for (int i10 = 0; i10 < 256; i10 += 8) {
	    i += anIntArray492[i10];
	    i1 += anIntArray492[i10 + 1];
	    i2 += anIntArray492[i10 + 2];
	    i3 += anIntArray492[i10 + 3];
	    i4 += anIntArray492[i10 + 4];
	    i5 += anIntArray492[i10 + 5];
	    i6 += anIntArray492[i10 + 6];
	    i7 += anIntArray492[i10 + 7];
	    i ^= i1 << 11;
	    i3 += i;
	    i1 += i2;
	    i1 ^= i2 >>> 2;
	    i4 += i1;
	    i2 += i3;
	    i2 ^= i3 << 8;
	    i5 += i2;
	    i3 += i4;
	    i3 ^= i4 >>> 16;
	    i6 += i3;
	    i4 += i5;
	    i4 ^= i5 << 10;
	    i7 += i4;
	    i5 += i6;
	    i5 ^= i6 >>> 4;
	    i += i5;
	    i6 += i7;
	    i6 ^= i7 << 8;
	    i1 += i6;
	    i7 += i;
	    i7 ^= i >>> 9;
	    i2 += i7;
	    i += i1;
	    anIntArray492[i10] = i;
	    anIntArray492[i10 + 1] = i1;
	    anIntArray492[i10 + 2] = i2;
	    anIntArray492[i10 + 3] = i3;
	    anIntArray492[i10 + 4] = i4;
	    anIntArray492[i10 + 5] = i5;
	    anIntArray492[i10 + 6] = i6;
	    anIntArray492[i10 + 7] = i7;
	}
	method256(4);
	anInt490 = 256;
    }
}
