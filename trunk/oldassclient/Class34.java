
public final class Class34
{
    private int anInt500 = -958;
    private boolean aBoolean501 = true;
    public byte[] aByteArray502;
    public int anInt503;
    public int[] anIntArray504;
    public int[] anIntArray505;
    public int[] anIntArray506;
    public int[] anIntArray507;
    
    public Class34(byte[] arg0, int arg1) {
	arg1 = 59 / arg1;
	method370((byte) -75, arg0);
    }
    
    private void method370(byte arg0, byte[] arg1) {
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg1, (byte) 63);
	int i = class33_sub2_sub3.method346();
	int i1 = class33_sub2_sub3.method346();
	if (i1 != i) {
	    byte[] bytes = new byte[i];
	    Class28.method242(bytes, i, arg1, i1, 6);
	    aByteArray502 = bytes;
	    class33_sub2_sub3
		= new Class33_Sub2_Sub3(aByteArray502, (byte) 63);
	} else
	    aByteArray502 = arg1;
	anInt503 = class33_sub2_sub3.method344();
	if (arg0 != -75)
	    aBoolean501 = !aBoolean501;
	anIntArray504 = new int[anInt503];
	anIntArray505 = new int[anInt503];
	anIntArray506 = new int[anInt503];
	anIntArray507 = new int[anInt503];
	int i2 = class33_sub2_sub3.anInt1108 + anInt503 * 10;
	for (int i3 = 0; i3 < anInt503; i3++) {
	    anIntArray504[i3] = class33_sub2_sub3.method347();
	    anIntArray505[i3] = class33_sub2_sub3.method346();
	    anIntArray506[i3] = class33_sub2_sub3.method346();
	    anIntArray507[i3] = i2;
	    i2 += anIntArray506[i3];
	}
    }
    
    public byte[] method371(int arg0, byte[] arg1, String arg2) {//get meh file
	int i = 0;
	arg2 = arg2.toUpperCase();
	for (int i1 = 0; i1 < arg2.length(); i1++)
	    i = i * 61 + arg2.charAt(i1) - 32;
	for (int i2 = 0; i2 < anInt503; i2++) {
	    if (anIntArray504[i2] == i) {
		if (arg1 == null)
		    arg1 = new byte[anIntArray505[i2]];
		if (anIntArray505[i2] != anIntArray506[i2])
		    Class28.method242(arg1, anIntArray505[i2], aByteArray502, anIntArray506[i2], anIntArray507[i2]);
		else {
		    for (int i3 = 0; i3 < anIntArray505[i2]; i3++)
			arg1[i3] = aByteArray502[anIntArray507[i2] + i3];
		}
		return arg1;
	    }
	}
	if (arg0 != 0) {
	    for (int i4 = 1; i4 > 0; i4++) {
	    }
	}
	return null;
    }
}
