import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;

public final class Class33_Sub2_Sub2_Sub2 extends Class33_Sub2_Sub2
{
    private int anInt1232;
    private boolean aBoolean1233 = true;
    private boolean aBoolean1234 = false;
    private int anInt1235 = 6;
    public int[] anIntArray1236;
    public int anInt1237;
    public int anInt1238;
    public int anInt1239;
    public int anInt1240;
    public int anInt1241;
    public int anInt1242;
    
    public Class33_Sub2_Sub2_Sub2(int arg0, int arg1, int arg2) {
	anIntArray1236 = new int[arg0 * arg1];
	if (arg2 != 0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	anInt1237 = anInt1241 = arg0;
	anInt1238 = anInt1242 = arg1;
	anInt1239 = anInt1240 = 0;
    }
    
    public Class33_Sub2_Sub2_Sub2(byte[] arg0, Component arg1, int arg2) {
	if (arg2 != 0)
	    throw new NullPointerException();
	try {
	    Image image = Toolkit.getDefaultToolkit().createImage(arg0);
	    MediaTracker mediatracker = new MediaTracker(arg1);
	    mediatracker.addImage(image, 0);
	    mediatracker.waitForAll();
	    anInt1237 = image.getWidth(arg1);
	    anInt1238 = image.getHeight(arg1);
	    anInt1241 = anInt1237;
	    anInt1242 = anInt1238;
	    anInt1239 = 0;
	    anInt1240 = 0;
	    anIntArray1236 = new int[anInt1237 * anInt1238];
	    PixelGrabber pixelgrabber
		= new PixelGrabber(image, 0, 0, anInt1237, anInt1238,
				   anIntArray1236, 0, anInt1237);
	    pixelgrabber.grabPixels();
	} catch (Exception exception) {
	    System.out.println("Error converting jpg");
	}
    }
    
    public Class33_Sub2_Sub2_Sub2(String arg0, int arg1, int arg2,
				  Class34 arg3) {
	Class33_Sub2_Sub3 class33_sub2_sub3
	    = new Class33_Sub2_Sub3(arg3.method371(0, null, arg0 + ".dat"),
				    (byte) 63);
	Class33_Sub2_Sub3 class33_sub2_sub3_1
	    = new Class33_Sub2_Sub3(arg3.method371(0, null, "index.dat"),
				    (byte) 63);
	class33_sub2_sub3_1.anInt1108 = class33_sub2_sub3.method344();
	anInt1241 = class33_sub2_sub3_1.method344();
	anInt1242 = class33_sub2_sub3_1.method344();
	int i = class33_sub2_sub3_1.method342();
	int[] ints = new int[i];
	arg1 = 60 / arg1;
	for (int i2 = 0; i2 < i - 1; i2++) {
	    ints[i2 + 1] = class33_sub2_sub3_1.method346();
	    if (ints[i2 + 1] == 0)
		ints[i2 + 1] = 1;
	}
	for (int i3 = 0; i3 < arg2; i3++) {
	    class33_sub2_sub3_1.anInt1108 += 2;
	    class33_sub2_sub3.anInt1108 += (class33_sub2_sub3_1.method344()
					    * class33_sub2_sub3_1.method344());
	    class33_sub2_sub3_1.anInt1108++;
	}
	anInt1239 = class33_sub2_sub3_1.method342();
	anInt1240 = class33_sub2_sub3_1.method342();
	anInt1237 = class33_sub2_sub3_1.method344();
	anInt1238 = class33_sub2_sub3_1.method344();
	int i4 = class33_sub2_sub3_1.method342();
	int i5 = anInt1237 * anInt1238;
	anIntArray1236 = new int[i5];
	if (i4 == 0) {
	    for (int i6 = 0; i6 < i5; i6++)
		anIntArray1236[i6] = ints[class33_sub2_sub3.method342()];
	} else if (i4 == 1) {
	    for (int i7 = 0; i7 < anInt1237; i7++) {
		for (int i8 = 0; i8 < anInt1238; i8++)
		    anIntArray1236[i7 + i8 * anInt1237]
			= ints[class33_sub2_sub3.method342()];
	    }
	}
    }
    
    public void method309(int arg0) {
	Class33_Sub2_Sub2.method284(aBoolean1233, anInt1237, anIntArray1236,
				    anInt1238);
	if (arg0 != 0) {
	}
    }
    
    public void method310(boolean arg0, int arg1, int arg2) {
	arg2 += anInt1239;
	arg1 += anInt1240;
	int i = arg2 + arg1 * Class33_Sub2_Sub2.anInt1090;
	int i1 = 0;
	if (arg0)
	    anInt1235 = -451;
	int i2 = anInt1238;
	int i3 = anInt1237;
	int i4 = Class33_Sub2_Sub2.anInt1090 - i3;
	int i5 = 0;
	if (arg1 < Class33_Sub2_Sub2.anInt1092) {
	    int i6 = Class33_Sub2_Sub2.anInt1092 - arg1;
	    i2 -= i6;
	    arg1 = Class33_Sub2_Sub2.anInt1092;
	    i1 += i6 * i3;
	    i += i6 * Class33_Sub2_Sub2.anInt1090;
	}
	if (arg1 + i2 > Class33_Sub2_Sub2.anInt1093)
	    i2 -= arg1 + i2 - Class33_Sub2_Sub2.anInt1093;
	if (arg2 < Class33_Sub2_Sub2.anInt1094) {
	    int i7 = Class33_Sub2_Sub2.anInt1094 - arg2;
	    i3 -= i7;
	    arg2 = Class33_Sub2_Sub2.anInt1094;
	    i1 += i7;
	    i += i7;
	    i5 += i7;
	    i4 += i7;
	}
	if (arg2 + i3 > Class33_Sub2_Sub2.anInt1095) {
	    int i8 = arg2 + i3 - Class33_Sub2_Sub2.anInt1095;
	    i3 -= i8;
	    i5 += i8;
	    i4 += i8;
	}
	if (i3 > 0 && i2 > 0)
	    method311(i3, i5, anInt1232, Class33_Sub2_Sub2.anIntArray1089, i,
		      i4, anIntArray1236, i1, i2);
    }
    
    private void method311(int arg0, int arg1, int arg2, int[] arg3, int arg4,
			   int arg5, int[] arg6, int arg7, int arg8) {
	int i = -(arg0 >> 2);
	if (arg2 != 0)
	    anInt1232 = -483;
	arg0 = -(arg0 & 0x3);
	for (int i1 = -arg8; i1 < 0; i1++) {
	    for (int i2 = i; i2 < 0; i2++) {
		arg3[arg4++] = arg6[arg7++];
		arg3[arg4++] = arg6[arg7++];
		arg3[arg4++] = arg6[arg7++];
		arg3[arg4++] = arg6[arg7++];
	    }
	    for (int i3 = arg0; i3 < 0; i3++)
		arg3[arg4++] = arg6[arg7++];
	    arg4 += arg5;
	    arg7 += arg1;
	}
    }
    
    public void method312(int arg0, boolean arg1, int arg2) {
	arg0 += anInt1239;
	if (arg1) {
	    arg2 += anInt1240;
	    int i = arg0 + arg2 * Class33_Sub2_Sub2.anInt1090;
	    int i1 = 0;
	    int i2 = anInt1238;
	    int i3 = anInt1237;
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
		method313(Class33_Sub2_Sub2.anIntArray1089, anIntArray1236, 0,
			  i1, i, i3, i2, i4, i5);
	}
    }
    
    private void method313(int[] arg0, int[] arg1, int arg2, int arg3,
			   int arg4, int arg5, int arg6, int arg7, int arg8) {
	int i = -(arg5 >> 2);
	arg5 = -(arg5 & 0x3);
	for (int i1 = -arg6; i1 < 0; i1++) {
	    for (int i2 = i; i2 < 0; i2++) {
		arg2 = arg1[arg3++];
		if (arg2 != 0)
		    arg0[arg4++] = arg2;
		else
		    arg4++;
		arg2 = arg1[arg3++];
		if (arg2 != 0)
		    arg0[arg4++] = arg2;
		else
		    arg4++;
		arg2 = arg1[arg3++];
		if (arg2 != 0)
		    arg0[arg4++] = arg2;
		else
		    arg4++;
		arg2 = arg1[arg3++];
		if (arg2 != 0)
		    arg0[arg4++] = arg2;
		else
		    arg4++;
	    }
	    for (int i3 = arg5; i3 < 0; i3++) {
		arg2 = arg1[arg3++];
		if (arg2 != 0)
		    arg0[arg4++] = arg2;
		else
		    arg4++;
	    }
	    arg4 += arg7;
	    arg3 += arg8;
	}
    }
    
    public void method314(int arg0, int arg1, int arg2, int arg3) {
	if (arg0 < 4 || arg0 > 4)
	    anInt1232 = -126;
	arg1 += anInt1239;
	arg2 += anInt1240;
	int i = arg1 + arg2 * Class33_Sub2_Sub2.anInt1090;
	int i1 = 0;
	int i2 = anInt1238;
	int i3 = anInt1237;
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
	if (arg1 < Class33_Sub2_Sub2.anInt1094) {
	    int i7 = Class33_Sub2_Sub2.anInt1094 - arg1;
	    i3 -= i7;
	    arg1 = Class33_Sub2_Sub2.anInt1094;
	    i1 += i7;
	    i += i7;
	    i5 += i7;
	    i4 += i7;
	}
	if (arg1 + i3 > Class33_Sub2_Sub2.anInt1095) {
	    int i8 = arg1 + i3 - Class33_Sub2_Sub2.anInt1095;
	    i3 -= i8;
	    i5 += i8;
	    i4 += i8;
	}
	if (i3 > 0 && i2 > 0)
	    method315(anIntArray1236, i, i5, 0, arg3, i1, i4,
		      Class33_Sub2_Sub2.anIntArray1089, i2, i3, (byte) 94);
    }
    
    private void method315(int[] arg0, int arg1, int arg2, int arg3, int arg4,
			   int arg5, int arg6, int[] arg7, int arg8, int arg9,
			   byte arg10) {
	if (arg10 != 94)
	    anInt1235 = 381;
	int i = 256 - arg4;
	for (int i1 = -arg8; i1 < 0; i1++) {
	    for (int i2 = -arg9; i2 < 0; i2++) {
		arg3 = arg0[arg5++];
		if (arg3 != 0) {
		    int i3 = arg7[arg1];
		    arg7[arg1++]
			= (((arg3 & 0xff00ff) * arg4 + (i3 & 0xff00ff) * i
			    & ~0xff00ff)
			   + ((arg3 & 0xff00) * arg4 + (i3 & 0xff00) * i
			      & 0xff0000)) >> 8;
		} else
		    arg1++;
	    }
	    arg1 += arg6;
	    arg5 += arg2;
	}
    }
    
    public void method316(int arg0, int arg1, int arg2, int arg3, int arg4,
			  int arg5, int[] arg6, int arg7, int[] arg8,
			  int arg9) {
	if (arg5 != -22915) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	try {
	    int i = -arg7 / 2;
	    int i1 = -arg4 / 2;
	    int i2 = (int) (Math.sin((double) arg3 / 326.11) * 65536.0);
	    int i3 = (int) (Math.cos((double) arg3 / 326.11) * 65536.0);
	    int i4 = (arg1 << 16) + (i1 * i2 + i * i3);
	    int i5 = (arg2 << 16) + (i1 * i3 - i * i2);
	    int i6 = arg0 + arg9 * Class33_Sub2_Sub2.anInt1090;
	    for (arg9 = 0; arg9 < arg4; arg9++) {
		int i7 = arg8[arg9];
		int i8 = i6 + i7;
		int i9 = i4 + i3 * i7;
		int i10 = i5 - i2 * i7;
		for (arg0 = -arg6[arg9]; arg0 < 0; arg0++) {
		    Class33_Sub2_Sub2.anIntArray1089[i8++]
			= anIntArray1236[(i9 >> 16) + (i10 >> 16) * anInt1237];
		    i9 += i3;
		    i10 -= i2;
		}
		i4 += i2;
		i5 += i3;
		i6 += Class33_Sub2_Sub2.anInt1090;
	    }
	} catch (Exception exception) {
	}
    }
    
    public void method317(Class33_Sub2_Sub2_Sub3 arg0, int arg1, int arg2,
			  int arg3) {
	arg1 += anInt1239;
	if (arg2 == 0) {
	    arg3 += anInt1240;
	    int i = arg1 + arg3 * Class33_Sub2_Sub2.anInt1090;
	    int i1 = 0;
	    int i2 = anInt1238;
	    int i3 = anInt1237;
	    int i4 = Class33_Sub2_Sub2.anInt1090 - i3;
	    int i5 = 0;
	    if (arg3 < Class33_Sub2_Sub2.anInt1092) {
		int i6 = Class33_Sub2_Sub2.anInt1092 - arg3;
		i2 -= i6;
		arg3 = Class33_Sub2_Sub2.anInt1092;
		i1 += i6 * i3;
		i += i6 * Class33_Sub2_Sub2.anInt1090;
	    }
	    if (arg3 + i2 > Class33_Sub2_Sub2.anInt1093)
		i2 -= arg3 + i2 - Class33_Sub2_Sub2.anInt1093;
	    if (arg1 < Class33_Sub2_Sub2.anInt1094) {
		int i7 = Class33_Sub2_Sub2.anInt1094 - arg1;
		i3 -= i7;
		arg1 = Class33_Sub2_Sub2.anInt1094;
		i1 += i7;
		i += i7;
		i5 += i7;
		i4 += i7;
	    }
	    if (arg1 + i3 > Class33_Sub2_Sub2.anInt1095) {
		int i8 = arg1 + i3 - Class33_Sub2_Sub2.anInt1095;
		i3 -= i8;
		i5 += i8;
		i4 += i8;
	    }
	    if (i3 > 0 && i2 > 0)
		method318(Class33_Sub2_Sub2.anIntArray1089, i1, 0, i2, false,
			  i5, i, i4, anIntArray1236, arg0.aByteArray1246, i3);
	}
    }
    
    private void method318(int[] arg0, int arg1, int arg2, int arg3,
			   boolean arg4, int arg5, int arg6, int arg7,
			   int[] arg8, byte[] arg9, int arg10) {
	int i = -(arg10 >> 2);
	arg10 = -(arg10 & 0x3);
	for (int i1 = -arg3; i1 < 0; i1++) {
	    for (int i2 = i; i2 < 0; i2++) {
		arg2 = arg8[arg1++];
		if (arg2 != 0 && arg9[arg6] == 0)
		    arg0[arg6++] = arg2;
		else
		    arg6++;
		arg2 = arg8[arg1++];
		if (arg2 != 0 && arg9[arg6] == 0)
		    arg0[arg6++] = arg2;
		else
		    arg6++;
		arg2 = arg8[arg1++];
		if (arg2 != 0 && arg9[arg6] == 0)
		    arg0[arg6++] = arg2;
		else
		    arg6++;
		arg2 = arg8[arg1++];
		if (arg2 != 0 && arg9[arg6] == 0)
		    arg0[arg6++] = arg2;
		else
		    arg6++;
	    }
	    for (int i3 = arg10; i3 < 0; i3++) {
		arg2 = arg8[arg1++];
		if (arg2 != 0 && arg9[arg6] == 0)
		    arg0[arg6++] = arg2;
		else
		    arg6++;
	    }
	    arg6 += arg7;
	    arg1 += arg5;
	}
	if (arg4)
	    anInt1235 = 174;
    }
}
