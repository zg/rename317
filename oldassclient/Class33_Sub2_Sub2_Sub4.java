
public final class Class33_Sub2_Sub2_Sub4 extends Class33_Sub2_Sub2
{
    private boolean aBoolean1254 = false;
    private int anInt1255 = -449;
    private int anInt1256 = 331;
    private int anInt1257;
    byte[][] aByteArrayArray1258 = new byte[94][];
    int[] anIntArray1259 = new int[94];
    int[] anIntArray1260 = new int[94];
    int[] anIntArray1261 = new int[94];
    int[] anIntArray1262 = new int[94];
    int[] anIntArray1263 = new int[95];
    int[] anIntArray1264 = new int[256];
    public int anInt1265;
    static int[] anIntArray1266 = new int[256];
    
    public Class33_Sub2_Sub2_Sub4(String arg0, Class34 arg1, boolean arg2) {
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg1.method371(0, null, arg0 + ".dat"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3_1
	    = new Class33_Sub2_Sub3(arg1.method371(0, null, "index.dat"),
				    (byte) 63);
	class33_sub2_sub3_1.anInt1108 = class33_sub2_sub3.method344() + 4;
	int i = class33_sub2_sub3_1.method342();
	if (i > 0)
	    class33_sub2_sub3_1.anInt1108 += (i - 1) * 3;
	for (int i2 = 0; i2 < 94; i2++) {
	    ((Class33_Sub2_Sub2_Sub4) this).anIntArray1261[i2]
		= class33_sub2_sub3_1.method342();
	    ((Class33_Sub2_Sub2_Sub4) this).anIntArray1262[i2]
		= class33_sub2_sub3_1.method342();
	    int i3 = (((Class33_Sub2_Sub2_Sub4) this).anIntArray1259[i2]
		      = class33_sub2_sub3_1.method344());
	    int i4 = (((Class33_Sub2_Sub2_Sub4) this).anIntArray1260[i2]
		      = class33_sub2_sub3_1.method344());
	    int i5 = class33_sub2_sub3_1.method342();
	    int i6 = i3 * i4;
	    ((Class33_Sub2_Sub2_Sub4) this).aByteArrayArray1258[i2]
		= new byte[i6];
	    if (i5 == 0) {
		for (int i7 = 0; i7 < i6; i7++)
		    ((Class33_Sub2_Sub2_Sub4) this).aByteArrayArray1258[i2][i7]
			= class33_sub2_sub3.method343();
	    } else if (i5 == 1) {
		for (int i8 = 0; i8 < i3; i8++) {
		    for (int i9 = 0; i9 < i4; i9++)
			((Class33_Sub2_Sub2_Sub4) this).aByteArrayArray1258
			    [i2][i8 + i9 * i3]
			    = class33_sub2_sub3.method343();
		}
	    }
	    if (i4 > anInt1265)
		anInt1265 = i4;
	    ((Class33_Sub2_Sub2_Sub4) this).anIntArray1261[i2] = 1;
	    ((Class33_Sub2_Sub2_Sub4) this).anIntArray1263[i2] = i3 + 2;
	    int i10 = 0;
	    for (int i11 = i4 / 7; i11 < i4; i11++)
		i10 += (((Class33_Sub2_Sub2_Sub4) this).aByteArrayArray1258[i2]
			[i11 * i3]);
	    if (i10 <= i4 / 7) {
		((Class33_Sub2_Sub2_Sub4) this).anIntArray1263[i2]--;
		((Class33_Sub2_Sub2_Sub4) this).anIntArray1261[i2] = 0;
	    }
	    i10 = 0;
	    for (int i12 = i4 / 7; i12 < i4; i12++)
		i10 += (((Class33_Sub2_Sub2_Sub4) this).aByteArrayArray1258[i2]
			[i3 - 1 + i12 * i3]);
	    if (i10 <= i4 / 7)
		((Class33_Sub2_Sub2_Sub4) this).anIntArray1263[i2]--;
	}
	if (arg2)
	    anInt1257 = 314;
	((Class33_Sub2_Sub2_Sub4) this).anIntArray1263[94]
	    = ((Class33_Sub2_Sub2_Sub4) this).anIntArray1263[8];
	for (int i13 = 0; i13 < 256; i13++)
	    ((Class33_Sub2_Sub2_Sub4) this).anIntArray1264[i13]
		= (((Class33_Sub2_Sub2_Sub4) this).anIntArray1263
		   [anIntArray1266[i13]]);
    }
    
    public void method325(int arg0, boolean arg1, int arg2, int arg3,
			  String arg4) {
	if (arg1) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	method328(arg4, arg2 - method327(331, arg4) / 2, arg0, arg3, -200);
    }
    
    public void method326(int arg0, String arg1, int arg2, int arg3, int arg4,
			  boolean arg5) {
	method330(arg5, arg0 - method327(331, arg1) / 2, arg2, arg4, true,
		  arg1);
	if (arg3 >= 0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
    }
    
    public int method327(int arg0, String arg1) {
	if (arg0 <= 0)
	    return 4;
	int i = 0;
	for (int i1 = 0; i1 < arg1.length(); i1++) {
	    if (arg1.charAt(i1) == '@' && i1 + 4 < arg1.length()
		&& arg1.charAt(i1 + 4) == '@')
		i1 += 4;
	    else
		i += (((Class33_Sub2_Sub2_Sub4) this).anIntArray1264
		      [arg1.charAt(i1)]);
	}
	return i;
    }
    
    public void method328(String arg0, int arg1, int arg2, int arg3,
			  int arg4) {
	while (arg4 >= 0)
	    anInt1257 = 407;
	arg2 -= anInt1265;
	for (int i = 0; i < arg0.length(); i++) {
	    int i1 = anIntArray1266[arg0.charAt(i)];
	    if (i1 != 94)
		method331
		    (((Class33_Sub2_Sub2_Sub4) this).aByteArrayArray1258[i1],
		     arg1 + ((Class33_Sub2_Sub2_Sub4) this).anIntArray1261[i1],
		     arg2 + ((Class33_Sub2_Sub2_Sub4) this).anIntArray1262[i1],
		     ((Class33_Sub2_Sub2_Sub4) this).anIntArray1259[i1],
		     ((Class33_Sub2_Sub2_Sub4) this).anIntArray1260[i1], arg3);
	    arg1 += ((Class33_Sub2_Sub2_Sub4) this).anIntArray1263[i1];
	}
    }
    
    public void method329(int arg0, int arg1, byte arg2, int arg3, int arg4,
			  String arg5) {
	arg0 -= method327(331, arg5) / 2;
	if (arg2 != 71)
	    anInt1257 = 157;
	arg4 -= anInt1265;
	for (int i = 0; i < arg5.length(); i++) {
	    int i1 = anIntArray1266[arg5.charAt(i)];
	    if (i1 != 94)
		method331
		    (((Class33_Sub2_Sub2_Sub4) this).aByteArrayArray1258[i1],
		     arg0 + ((Class33_Sub2_Sub2_Sub4) this).anIntArray1261[i1],
		     (arg4 + ((Class33_Sub2_Sub2_Sub4) this).anIntArray1262[i1]
		      + (int) (Math.sin((double) i / 2.0 + (double) arg3 / 5.0)
			       * 5.0)),
		     ((Class33_Sub2_Sub2_Sub4) this).anIntArray1259[i1],
		     ((Class33_Sub2_Sub2_Sub4) this).anIntArray1260[i1], arg1);
	    arg0 += ((Class33_Sub2_Sub2_Sub4) this).anIntArray1263[i1];
	}
    }
    
    public void method330(boolean arg0, int arg1, int arg2, int arg3,
			  boolean arg4, String arg5) {
	arg2 -= anInt1265;
	for (int i = 0; i < arg5.length(); i++) {
	    if (arg5.charAt(i) == '@' && i + 4 < arg5.length()
		&& arg5.charAt(i + 4) == '@') {
		String string = arg5.substring(i + 1, i + 4);
		if (string.equals("red"))
		    arg3 = 16711680;
		if (string.equals("gre"))
		    arg3 = 65280;
		if (string.equals("blu"))
		    arg3 = 255;
		if (string.equals("yel"))
		    arg3 = 16776960;
		if (string.equals("cya"))
		    arg3 = 65535;
		if (string.equals("mag"))
		    arg3 = 16711935;
		if (string.equals("whi"))
		    arg3 = 16777215;
		if (string.equals("bla"))
		    arg3 = 0;
		if (string.equals("lre"))
		    arg3 = 16748608;
		if (string.equals("dre"))
		    arg3 = 8388608;
		if (string.equals("dbl"))
		    arg3 = 128;
		if (string.equals("or1"))
		    arg3 = 16756736;
		if (string.equals("or2"))
		    arg3 = 16740352;
		if (string.equals("or3"))
		    arg3 = 16723968;
		if (string.equals("gr1"))
		    arg3 = 12648192;
		if (string.equals("gr2"))
		    arg3 = 8453888;
		if (string.equals("gr3"))
		    arg3 = 4259584;
		i += 4;
	    } else {
		int i1 = anIntArray1266[arg5.charAt(i)];
		if (i1 != 94) {
		    if (arg0)
			method331((((Class33_Sub2_Sub2_Sub4) this)
				   .aByteArrayArray1258[i1]),
				  arg1 + (((Class33_Sub2_Sub2_Sub4) this)
					  .anIntArray1261[i1]) + 1,
				  arg2 + (((Class33_Sub2_Sub2_Sub4) this)
					  .anIntArray1262[i1]) + 1,
				  (((Class33_Sub2_Sub2_Sub4) this)
				   .anIntArray1259[i1]),
				  (((Class33_Sub2_Sub2_Sub4) this)
				   .anIntArray1260[i1]),
				  0);
		    method331((((Class33_Sub2_Sub2_Sub4) this)
			       .aByteArrayArray1258[i1]),
			      arg1 + (((Class33_Sub2_Sub2_Sub4) this)
				      .anIntArray1261[i1]),
			      arg2 + (((Class33_Sub2_Sub2_Sub4) this)
				      .anIntArray1262[i1]),
			      (((Class33_Sub2_Sub2_Sub4) this).anIntArray1259
			       [i1]),
			      (((Class33_Sub2_Sub2_Sub4) this).anIntArray1260
			       [i1]),
			      arg3);
		}
		arg1 += ((Class33_Sub2_Sub2_Sub4) this).anIntArray1263[i1];
	    }
	}
	if (!arg4) {
	}
    }
    
    private void method331(byte[] arg0, int arg1, int arg2, int arg3, int arg4,
			   int arg5) {
	int i = arg1 + arg2 * Class33_Sub2_Sub2.anInt1090;
	int i1 = Class33_Sub2_Sub2.anInt1090 - arg3;
	int i2 = 0;
	int i3 = 0;
	if (arg2 < Class33_Sub2_Sub2.anInt1092) {
	    int i4 = Class33_Sub2_Sub2.anInt1092 - arg2;
	    arg4 -= i4;
	    arg2 = Class33_Sub2_Sub2.anInt1092;
	    i3 += i4 * arg3;
	    i += i4 * Class33_Sub2_Sub2.anInt1090;
	}
	if (arg2 + arg4 >= Class33_Sub2_Sub2.anInt1093)
	    arg4 -= arg2 + arg4 - Class33_Sub2_Sub2.anInt1093 + 1;
	if (arg1 < Class33_Sub2_Sub2.anInt1094) {
	    int i5 = Class33_Sub2_Sub2.anInt1094 - arg1;
	    arg3 -= i5;
	    arg1 = Class33_Sub2_Sub2.anInt1094;
	    i3 += i5;
	    i += i5;
	    i2 += i5;
	    i1 += i5;
	}
	if (arg1 + arg3 >= Class33_Sub2_Sub2.anInt1095) {
	    int i6 = arg1 + arg3 - Class33_Sub2_Sub2.anInt1095 + 1;
	    arg3 -= i6;
	    i2 += i6;
	    i1 += i6;
	}
	if (arg3 > 0 && arg4 > 0)
	    method332(Class33_Sub2_Sub2.anIntArray1089, arg0, arg5, i3, i,
		      arg3, arg4, i1, i2);
    }
    
    private void method332(int[] arg0, byte[] arg1, int arg2, int arg3,
			   int arg4, int arg5, int arg6, int arg7, int arg8) {
	int i = -(arg5 >> 2);
	arg5 = -(arg5 & 0x3);
	for (int i1 = -arg6; i1 < 0; i1++) {
	    for (int i2 = i; i2 < 0; i2++) {
		if (arg1[arg3++] != 0)
		    arg0[arg4++] = arg2;
		else
		    arg4++;
		if (arg1[arg3++] != 0)
		    arg0[arg4++] = arg2;
		else
		    arg4++;
		if (arg1[arg3++] != 0)
		    arg0[arg4++] = arg2;
		else
		    arg4++;
		if (arg1[arg3++] != 0)
		    arg0[arg4++] = arg2;
		else
		    arg4++;
	    }
	    for (int i3 = arg5; i3 < 0; i3++) {
		if (arg1[arg3++] != 0)
		    arg0[arg4++] = arg2;
		else
		    arg4++;
	    }
	    arg4 += arg7;
	    arg3 += arg8;
	}
    }
    
    static {
	String string
	    = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00a3$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
	for (int i = 0; i < 256; i++) {
	    int i1 = string.indexOf(i);
	    if (i1 == -1)
		i1 = 74;
	    anIntArray1266[i] = i1;
	}
    }
}
