package rt4;/* Class26_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import rt4.Class26;
import rt4.StaticFields;

public class Class26_Sub2 extends Class26
{
    public int anInt3300;
    public int anInt3302;
    public int anInt3303;
    public int anInt3304;
    public byte[] aByteArray3305;
    public int ptr;
    public int anInt3307;
    public int colour;
    public int anInt3312;

    public Class26_Sub2(int arg0, int arg1, int arg2, int arg3, int arg4,
			float arg5, float arg6, float arg7) {
	super(arg0, arg1, arg2, arg3, arg4);
	try {
	    anInt3302 = (int) (arg7 * 4096.0F);
	    anInt3304 = (int) (arg6 * 4096.0F);
	    anInt3307 = anInt3300
		= (int) (Math.pow(0.5, (double) -arg5) * 4096.0);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public void writeData(int arg0, byte arg1) {
	try {
	    aByteArray3305[arg0] = arg1;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }

    public void method1011(int arg0, int arg1, byte arg2) {
	try {
	    if (arg0 == 0) {
		anInt3312 = anInt3304 - (arg1 >= 0 ? arg1 : -arg1);
		anInt3312 = anInt3312 * anInt3312 >> 2093089196;
		colour = anInt3312;
		anInt3303 = 4096;
	    } else {
		anInt3303 = anInt3312 * anInt3302 >> -1291652884;
		anInt3312
		    = anInt3304 - (-1 < (arg1 ^ 0xffffffff) ? -arg1 : arg1);
		if (0 <= anInt3303) {
		    if ((anInt3303 ^ 0xffffffff) < -4097)
			anInt3303 = 4096;
		} else
		    anInt3303 = 0;
		anInt3312 = anInt3312 * anInt3312 >> 572242892;
		anInt3312 = anInt3303 * anInt3312 >> 721084396;
		colour += anInt3312 * anInt3307 >> 289211436;
		anInt3307 = anInt3307 * anInt3300 >> 898455372;
	    }
	    if (arg2 >= -112)
		anInt3312 = 42;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public void write(int arg0) {
	try {
	    colour >>= 4;
	    if ((~colour) <= -1) {
            if ((~colour) < -256)
                colour = 255;
	    } else
		    colour = 0;
	    anInt3307 = anInt3300;
	    writeData(ptr++, (byte) colour);
	    colour = arg0;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public void method1013(int arg0) {
    while_658_:
	do {
	while_657_:
	    do {
		do {
		    try {
			if (arg0 == -23880)
			    break;
		    } catch (RuntimeException runtimeexception) {
			break while_657_;
		    }
		    return;
		} while (false);
		try {
		    ptr = 0;
		    colour = 0;
		} catch (RuntimeException runtimeexception) {
		    break;
		}
		break while_658_;
	    } while (false);
	} while (false);
    }
    
    static {
    }
}
