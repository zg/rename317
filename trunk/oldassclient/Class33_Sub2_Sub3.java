import java.math.BigInteger;

public final class Class33_Sub2_Sub3 extends Class33_Sub2
{
    private boolean aBoolean1100 = false;
    private int anInt1101 = -95;
    private static int anInt1102 = -836;
    private boolean aBoolean1103 = false;
    private byte aByte1104 = 61;
    private byte aByte1105 = 61;
    private boolean aBoolean1106 = true;
    public byte[] aByteArray1107;
    public int anInt1108;
    public int anInt1109;
    private static int[] anIntArray1110 = new int[256];
    private static final int[] anIntArray1111;
    public Class32 aClass32_1112;
    private static int anInt1113;
    private static int anInt1114;
    private static int anInt1115;
    private static Class22 aClass22_1116;
    private static Class22 aClass22_1117;
    private static Class22 aClass22_1118;
    public static boolean aBoolean1119;
    
    public static Class33_Sub2_Sub3 method333(int arg0, int arg1) {
	if (arg0 >= 0)
	    throw new NullPointerException();
	synchronized (aClass22_1117) {
	    Class33_Sub2_Sub3 class33_sub2_sub3 = null;
	    if (arg1 == 0 && anInt1113 > 0) {
		anInt1113--;
		class33_sub2_sub3
		    = (Class33_Sub2_Sub3) aClass22_1116.method182();
	    } else if (arg1 == 1 && anInt1114 > 0) {
		anInt1114--;
		class33_sub2_sub3
		    = (Class33_Sub2_Sub3) aClass22_1117.method182();
	    } else if (arg1 == 2 && anInt1115 > 0) {
		anInt1115--;
		class33_sub2_sub3
		    = (Class33_Sub2_Sub3) aClass22_1118.method182();
	    }
	    if (class33_sub2_sub3 != null) {
		class33_sub2_sub3.anInt1108 = 0;
		return class33_sub2_sub3;
	    }
	}
	Class33_Sub2_Sub3 class33_sub2_sub3 = new Class33_Sub2_Sub3(false);
	class33_sub2_sub3.anInt1108 = 0;
	if (arg1 == 0)
	    class33_sub2_sub3.aByteArray1107 = new byte[100];
	else if (arg1 == 1)
	    class33_sub2_sub3.aByteArray1107 = new byte[5000];
	else
	    class33_sub2_sub3.aByteArray1107 = new byte[30000];
	return class33_sub2_sub3;
    }
    
    private Class33_Sub2_Sub3(boolean arg0) {
	if (arg0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
    }
    
    public Class33_Sub2_Sub3(byte[] arg0, byte arg1) {
	aByteArray1107 = arg0;
	anInt1108 = 0;
	if (arg1 != 63)
	    throw new NullPointerException();
    }
    
    public void method334(boolean arg0, int arg1) {
	if (!arg0)
	    aByteArray1107[anInt1108++]
		= (byte) (arg1 + aClass32_1112.method255());
    }
    
    public void method335(int arg0) {
	aByteArray1107[anInt1108++] = (byte) arg0;
    }
    
    public void method336(int arg0) {
	aByteArray1107[anInt1108++] = (byte) (arg0 >> 8);
	aByteArray1107[anInt1108++] = (byte) arg0;
    }
    
    public void method337(int arg0) {
	aByteArray1107[anInt1108++] = (byte) (arg0 >> 24);
	aByteArray1107[anInt1108++] = (byte) (arg0 >> 16);
	aByteArray1107[anInt1108++] = (byte) (arg0 >> 8);
	aByteArray1107[anInt1108++] = (byte) arg0;
    }
    
    public void method338(long arg0, int arg1) {
	aByteArray1107[anInt1108++] = (byte) (int) (arg0 >> 56);
	aByteArray1107[anInt1108++] = (byte) (int) (arg0 >> 48);
	aByteArray1107[anInt1108++] = (byte) (int) (arg0 >> 40);
	aByteArray1107[anInt1108++] = (byte) (int) (arg0 >> 32);
	while (arg1 >= 0)
	    anInt1102 = -185;
	aByteArray1107[anInt1108++] = (byte) (int) (arg0 >> 24);
	aByteArray1107[anInt1108++] = (byte) (int) (arg0 >> 16);
	aByteArray1107[anInt1108++] = (byte) (int) (arg0 >> 8);
	aByteArray1107[anInt1108++] = (byte) (int) arg0;
    }
    
    public void method339(String arg0) {
	arg0.getBytes(0, arg0.length(), aByteArray1107, anInt1108);
	anInt1108 += arg0.length();
	aByteArray1107[anInt1108++] = (byte) 10;
    }
    
    public void method340(int arg0, boolean arg1, int arg2, byte[] arg3) {
	if (arg1)
	    anInt1102 = -195;
	for (int i = arg2; i < arg2 + arg0; i++)
	    aByteArray1107[anInt1108++] = arg3[i];
    }
    
    public void method341(int arg0, int arg1) {
	aByteArray1107[anInt1108 - arg1 - 1] = (byte) arg1;
	if (arg0 >= 0) {
	}
    }
    
    public int method342() {
	return aByteArray1107[anInt1108++] & 0xff;
    }
    
    public byte method343() {
	return aByteArray1107[anInt1108++];
    }
    
    public int method344() {
	anInt1108 += 2;
	return (((aByteArray1107[anInt1108 - 2] & 0xff) << 8)
		+ (aByteArray1107[anInt1108 - 1] & 0xff));
    }
    
    public int method345() {
	anInt1108 += 2;
	int i = (((aByteArray1107[anInt1108 - 2] & 0xff) << 8)
		 + (aByteArray1107[anInt1108 - 1] & 0xff));
	if (i > 32767)
	    i -= 65536;
	return i;
    }
    
    public int method346() {
	anInt1108 += 3;
	return (((aByteArray1107[anInt1108 - 3] & 0xff) << 16)
		+ ((aByteArray1107[anInt1108 - 2] & 0xff) << 8)
		+ (aByteArray1107[anInt1108 - 1] & 0xff));
    }
    
    public int method347() {
	anInt1108 += 4;
	return (((aByteArray1107[anInt1108 - 4] & 0xff) << 24)
		+ ((aByteArray1107[anInt1108 - 3] & 0xff) << 16)
		+ ((aByteArray1107[anInt1108 - 2] & 0xff) << 8)
		+ (aByteArray1107[anInt1108 - 1] & 0xff));
    }
    
    public long method348(int arg0) {
	if (arg0 != 1)
	    throw new NullPointerException();
	long l = (long) method347() & 0xffffffffL;
	long l1 = (long) method347() & 0xffffffffL;
	return (l << 32) + l1;
    }
    
    public String method349() {
	int i = anInt1108;
	while (aByteArray1107[anInt1108++] != 10) {
	}
	return new String(aByteArray1107, i, anInt1108 - i - 1);
    }
    
    public byte[] method350(byte arg0) {
	if (arg0 == 2) {
	    boolean flag = false;
	} else
	    aBoolean1100 = !aBoolean1100;
	int i = anInt1108;
	while (aByteArray1107[anInt1108++] != 10) {
	}
	byte[] bytes = new byte[anInt1108 - i - 1];
	for (int i1 = i; i1 < anInt1108 - 1; i1++)
	    bytes[i1 - i] = aByteArray1107[i1];
	return bytes;
    }
    
    public void method351(int arg0, int arg1, byte[] arg2, boolean arg3) {
	if (arg3)
	    anInt1101 = 301;
	for (int i = arg0; i < arg0 + arg1; i++)
	    arg2[i] = aByteArray1107[anInt1108++];
    }
    
    public void method352(int arg0) {
	anInt1109 = anInt1108 * 8;
	if (arg0 != 0)
	    anInt1101 = -441;
    }
    
    public int method353(int arg0, int arg1) {
	int i = anInt1109 >> 3;
	int i1 = 8 - (anInt1109 & 0x7);
	int i2 = 0;
	arg0 = 94 / arg0;
	anInt1109 += arg1;
	for (; arg1 > i1; i1 = 8) {
	    i2 += (aByteArray1107[i++] & anIntArray1111[i1]) << arg1 - i1;
	    arg1 -= i1;
	}
	if (arg1 == i1)
	    i2 += aByteArray1107[i] & anIntArray1111[i1];
	else
	    i2 += aByteArray1107[i] >> i1 - arg1 & anIntArray1111[arg1];
	return i2;
    }
    
    public void method354(int arg0) {
	anInt1108 = (anInt1109 + 7) / 8;
	if (arg0 != 0)
	    anInt1102 = 406;
    }
    
    public int method355() {
	int i = aByteArray1107[anInt1108] & 0xff;
	if (i < 128)
	    return method342() - 64;
	return method344() - 49152;
    }
    
    public int method356() {
	int i = aByteArray1107[anInt1108] & 0xff;
	if (i < 128)
	    return method342();
	return method344() - 32768;
    }
    
    public void method357(BigInteger arg0, boolean arg1, BigInteger arg2) {
	int i = anInt1108;
	anInt1108 = 0;
	byte[] bytes = new byte[i];
	method351(0, i, bytes, false);
	BigInteger biginteger = new BigInteger(bytes);
	BigInteger biginteger1 = biginteger.modPow(arg2, arg0);
	byte[] bytes2 = biginteger1.toByteArray();
	anInt1108 = 0;
	method335(bytes2.length);
	if (!arg1)
	    anInt1101 = 440;
	method340(bytes2.length, false, 0, bytes2);
    }
    
    static {
	for (int i = 0; i < 256; i++) {
	    int i1 = i;
	    for (int i2 = 0; i2 < 8; i2++) {
		if ((i1 & 0x1) == 1)
		    i1 = i1 >>> 1 ^ ~0x12477cdf;
		else
		    i1 >>>= 1;
	    }
	    anIntArray1110[i] = i1;
	}
	anIntArray1111
	    = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047,
			  4095, 8191, 16383, 32767, 65535, 131071, 262143,
			  524287, 1048575, 2097151, 4194303, 8388607, 16777215,
			  33554431, 67108863, 134217727, 268435455, 536870911,
			  1073741823, 2147483647, -1 };
	aClass22_1116 = new Class22(845);
	aClass22_1117 = new Class22(845);
	aClass22_1118 = new Class22(845);
    }
}
