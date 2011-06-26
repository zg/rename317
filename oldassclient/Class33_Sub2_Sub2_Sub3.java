
public final class Class33_Sub2_Sub2_Sub3 extends Class33_Sub2_Sub2
{
    private int anInt1243;
    private boolean aBoolean1244 = false;
    private boolean aBoolean1245 = false;
    public byte[] aByteArray1246;
    public int[] anIntArray1247;
    public int anInt1248;
    public int anInt1249;
    public int anInt1250;
    public int anInt1251;
    public int anInt1252;
    public int anInt1253;
    
    public Class33_Sub2_Sub2_Sub3(int arg0, Class34 arg1, String arg2,
				  int arg3) {
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg1.method371(0, null, arg2 + ".dat"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3_1
	    = new Class33_Sub2_Sub3(arg1.method371(0, null, "index.dat"),
				    (byte) 63);
	class33_sub2_sub3_1.anInt1108 = class33_sub2_sub3.method344();
	anInt1252 = class33_sub2_sub3_1.method344();
	anInt1253 = class33_sub2_sub3_1.method344();
	if (arg0 != 0)
	    throw new NullPointerException();
	int i = class33_sub2_sub3_1.method342();
	anIntArray1247 = new int[i];
	for (int i2 = 0; i2 < i - 1; i2++)
	    anIntArray1247[i2 + 1] = class33_sub2_sub3_1.method346();
	for (int i3 = 0; i3 < arg3; i3++) {
	    class33_sub2_sub3_1.anInt1108 += 2;
	    class33_sub2_sub3.anInt1108 += (class33_sub2_sub3_1.method344()
					    * class33_sub2_sub3_1.method344());
	    class33_sub2_sub3_1.anInt1108++;
	}
	anInt1250 = class33_sub2_sub3_1.method342();
	anInt1251 = class33_sub2_sub3_1.method342();
	anInt1248 = class33_sub2_sub3_1.method344();
	anInt1249 = class33_sub2_sub3_1.method344();
	int i4 = class33_sub2_sub3_1.method342();
	int i5 = anInt1248 * anInt1249;
	aByteArray1246 = new byte[i5];
	if (i4 == 0) {
	    for (int i6 = 0; i6 < i5; i6++)
		aByteArray1246[i6] = class33_sub2_sub3.method343();
	} else if (i4 == 1) {
	    for (int i7 = 0; i7 < anInt1248; i7++) {
		for (int i8 = 0; i8 < anInt1249; i8++)
		    aByteArray1246[i7 + i8 * anInt1248]
			= class33_sub2_sub3.method343();
	    }
	}
    }
    
    public void method319(int arg0) {
	anInt1252 /= 2;
	anInt1253 /= 2;
	byte[] bytes = new byte[anInt1252 * anInt1253];
	int i = 0;
	for (int i1 = 0; i1 < anInt1249; i1++) {
	    for (int i2 = 0; i2 < anInt1248; i2++)
		bytes[((i2 + anInt1250 >> 1)
		       + (i1 + anInt1251 >> 1) * anInt1252)]
		    = aByteArray1246[i++];
	}
	aByteArray1246 = bytes;
	anInt1248 = anInt1252;
	if (arg0 == 45133) {
	    anInt1249 = anInt1253;
	    anInt1250 = 0;
	    anInt1251 = 0;
	}
    }
    
    public void method320(int arg0) {
	if (arg0 != -42137)
	    anInt1243 = 182;
	if (anInt1248 != anInt1252 || anInt1249 != anInt1253) {
	    byte[] bytes = new byte[anInt1252 * anInt1253];
	    int i = 0;
	    for (int i1 = 0; i1 < anInt1249; i1++) {
		for (int i2 = 0; i2 < anInt1248; i2++)
		    bytes[i2 + anInt1250 + (i1 + anInt1251) * anInt1252]
			= aByteArray1246[i++];
	    }
	    aByteArray1246 = bytes;
	    anInt1248 = anInt1252;
	    anInt1249 = anInt1253;
	    anInt1250 = 0;
	    anInt1251 = 0;
	}
    }
    
    public void method321(int arg0) {
	byte[] bytes = new byte[anInt1248 * anInt1249];
	int i = 0;
	for (int i1 = 0; i1 < anInt1249; i1++) {
	    for (int i2 = anInt1248 - 1; i2 >= 0; i2--)
		bytes[i++] = aByteArray1246[i2 + i1 * anInt1248];
	}
	aByteArray1246 = bytes;
	if (arg0 < 5 || arg0 > 5)
	    anInt1243 = -96;
	anInt1250 = anInt1252 - anInt1248 - anInt1250;
    }
    
    public void method322(int arg0) {
	byte[] bytes = new byte[anInt1248 * anInt1249];
	int i = 0;
	for (int i1 = anInt1249 - 1; i1 >= 0; i1--) {
	    for (int i2 = 0; i2 < anInt1248; i2++)
		bytes[i++] = aByteArray1246[i2 + i1 * anInt1248];
	}
	if (arg0 <= 0)
	    aBoolean1245 = !aBoolean1245;
	aByteArray1246 = bytes;
	anInt1251 = anInt1253 - anInt1249 - anInt1251;
    }
    
    public void method323(int arg0, boolean arg1, int arg2) {
	arg0 += anInt1250;
	if (!arg1)
	    anInt1243 = -150;
	arg2 += anInt1251;
	int i = arg0 + arg2 * Class33_Sub2_Sub2.anInt1090;
	int i1 = 0;
	int i2 = anInt1249;
	int i3 = anInt1248;
	int i4 = Class33_Sub2_Sub2.anInt1090 - i3;
	int i5 = 0;
	if (arg2 < Class33_Sub2_Sub2.anInt1092) {
	    int i6 = Class33_Sub2_Sub2.anInt1092 - arg2;
	    i2 -= i6;
	    arg2 = Class33_Sub2_Sub2.anInt1092;
	    i1 += i6 * i3;
	    i += i6 * Class33_Sub2_Sub2.anInt1090;
	}
	if (arg2 + i2 > Class33_Sub2_Sub2.anInt1093)
	    i2 -= arg2 + i2 - Class33_Sub2_Sub2.anInt1093;
	if (arg0 < Class33_Sub2_Sub2.anInt1094) {
	    int i7 = Class33_Sub2_Sub2.anInt1094 - arg0;
	    i3 -= i7;
	    arg0 = Class33_Sub2_Sub2.anInt1094;
	    i1 += i7;
	    i += i7;
	    i5 += i7;
	    i4 += i7;
	}
	if (arg0 + i3 > Class33_Sub2_Sub2.anInt1095) {
	    int i8 = arg0 + i3 - Class33_Sub2_Sub2.anInt1095;
	    i3 -= i8;
	    i5 += i8;
	    i4 += i8;
	}
	if (i3 > 0 && i2 > 0)
	    method324(i2, aByteArray1246, anIntArray1247, i3, i, i1,
		      Class33_Sub2_Sub2.anIntArray1089, 92, i4, i5);
    }
    
    private void method324(int arg0, byte[] arg1, int[] arg2, int arg3,
			   int arg4, int arg5, int[] arg6, int arg7, int arg8,
			   int arg9) {
	int i = -(arg3 >> 2);
	arg3 = -(arg3 & 0x3);
	for (int i1 = -arg0; i1 < 0; i1++) {
	    for (int i2 = i; i2 < 0; i2++) {
		int i3 = arg1[arg5++];
		if (i3 != 0)
		    arg6[arg4++] = arg2[i3 & 0xff];
		else
		    arg4++;
		i3 = arg1[arg5++];
		if (i3 != 0)
		    arg6[arg4++] = arg2[i3 & 0xff];
		else
		    arg4++;
		i3 = arg1[arg5++];
		if (i3 != 0)
		    arg6[arg4++] = arg2[i3 & 0xff];
		else
		    arg4++;
		i3 = arg1[arg5++];
		if (i3 != 0)
		    arg6[arg4++] = arg2[i3 & 0xff];
		else
		    arg4++;
	    }
	    for (int i4 = arg3; i4 < 0; i4++) {
		int i5 = arg1[arg5++];
		if (i5 != 0)
		    arg6[arg4++] = arg2[i5 & 0xff];
		else
		    arg4++;
	    }
	    arg4 += arg8;
	    arg5 += arg9;
	}
	arg7 = 70 / arg7;
    }
}
