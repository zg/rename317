package rt4;/* Class26 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.util.Random;

public abstract class Class26
{
    public static int anInt480;
    public int anInt483;
    public int anInt484;
    public int anInt485;
    public short[] aShortArray487 = new short[512];
    public static int[] anIntArray468;
    public static int anInt490;
    public int anInt492;
    public static int anInt494;
    public short[] aShortArray496;
    public static int anInt497;
    public int anInt498;

    public abstract void method1011(int i, int i_15_, byte i_16_);
    
    public abstract void write(int i);
    
    public abstract void method1013(int i);

    public void method1015(byte arg0) {
	try {
	    Random random = new Random((long) anInt485);
	    anInt490++;
	    for (int i = 0; 255 > i; i++)
		aShortArray487[i] = (short) i;
	    for (int i = 0; -256 < (i ^ 0xffffffff); i++) {
		int i_17_ = -i + 255;
		int i_18_ = method1949(random, i_17_, -32640);
		short i_19_ = aShortArray487[i_18_];
		aShortArray487[i_18_] = aShortArray487[i_17_];
		aShortArray487[i_17_] = aShortArray487[i_17_ - -256] = i_19_;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }

    public static int method545(byte arg0, int arg1, int arg2) {
        int i;
        try {
            int i_0_ = arg2 >> 695524447 & -1 + arg1;
            int i_1_ = 126 / ((-49 - arg0) / 43);
            i = (arg2 - -(arg2 >>> 2128508639)) % arg1 + i_0_;
        } catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
        }
        return i;
        }
    public static int method1949(Random arg0, int arg1, int arg2) {
    while_1241_:
	do {
	    do {
		int i;
		try {
		    if ((arg1 ^ 0xffffffff) >= -1)
			throw new IllegalArgumentException();
		    if (!method1594(arg1, 474))
			break;
		    i = (int) ((((long) arg0.nextInt() & 0xffffffffL)
				* (long) arg1)
			       >> -1424455328);
		} catch (RuntimeException runtimeexception) {
		    break while_1241_;
		}
		return i;
	    } while (false);
	    int i;
	    try {
		int i_21_ = -2147483648 + -(int) (4294967296L % (long) arg1);
		int i_22_;
		do
		    i_22_ = arg0.nextInt();
		while ((i_21_ ^ 0xffffffff) >= (i_22_ ^ 0xffffffff));
		i = method545((byte) -107, arg1, i_22_);
	    } catch (RuntimeException runtimeexception) {
		break;
	    }
	    return i;
	} while (false);
        throw new RuntimeException();
    }
    public static boolean method1594(int arg0, int arg1) {
	boolean bool;
	try {
	    bool = arg0 == (arg0 & -arg0);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return bool;
    }
    public void method1019(int arg0) {
	try {
	    anInt494++;
	    aShortArray496 = new short[anInt484];
	    for (int i = 0; (anInt484 ^ 0xffffffff) < (i ^ 0xffffffff); i++)
		aShortArray496[i] = (short) (int) Math.pow(2.0, (double) i);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public void method1020(int arg0, int arg1, int arg2, int arg3) {
	try {
	    anInt497++;
	    int[] is = new int[arg2];
	    int[] is_27_ = new int[arg0];
	    for (int i = 0; (i ^ 0xffffffff) > (arg2 ^ 0xffffffff); i++)
		is[i] = (i << 1243547980) / arg2;
	    for (int i = 0; (arg0 ^ 0xffffffff) < (i ^ 0xffffffff); i++)
		is_27_[i] = (i << 16179468) / arg0;
	    int[] is_28_ = new int[arg1];
	    for (int i = arg3; arg1 > i; i++)
		is_28_[i] = (i << -558406356) / arg1;
	    method1013(-23880);
	    for (int i = 0; (i ^ 0xffffffff) > (arg1 ^ 0xffffffff); i++) {
		for (int i_29_ = 0; i_29_ < arg0; i_29_++) {
		    for (int i_30_ = 0; i_30_ < arg2; i_30_++) {
			for (int i_31_ = 0; i_31_ < anInt484; i_31_++) {
			    int i_32_ = aShortArray496[i_31_] << -41511540;
			    int i_33_ = is_28_[i] * i_32_ >> 336781132;
			    i_33_ *= anInt498;
			    int i_34_ = is[i_30_] * i_32_ >> 887172492;
			    int i_35_ = anInt498 * i_32_ >> 1625714636;
			    int i_36_ = i_32_ * anInt483 >> 2144840204;
			    int i_37_ = i_32_ * is_27_[i_29_] >> -345379060;
			    int i_38_ = i_33_ >> -1318185236;
			    int i_39_ = i_38_ - -1;
			    i_37_ *= anInt483;
			    i_34_ *= anInt492;
			    int i_40_ = i_34_ >> 497144748;
			    i_34_ &= 0xfff;
			    if (i_35_ <= i_39_)
				i_39_ = 0;
			    else
				i_39_ &= 0xff;
			    int i_41_ = anIntArray468[i_34_];
			    i_33_ &= 0xfff;
			    i_38_ &= 0xff;
			    int i_42_ = i_37_ >> -1509602260;
			    i_37_ &= 0xfff;
			    int i_43_ = aShortArray487[i_39_];
			    int i_44_ = -4096 + i_33_;
			    int i_45_ = i_40_ + 1;
			    int i_46_ = anIntArray468[i_33_];
			    int i_47_ = aShortArray487[i_38_];
			    int i_48_ = i_37_ + -4096;
			    int i_49_ = anIntArray468[i_37_];
			    i_40_ &= 0xff;
			    int i_50_ = i_34_ - 4096;
			    int i_51_ = i_42_ + 1;
			    if ((i_51_ ^ 0xffffffff) <= (i_36_ ^ 0xffffffff))
				i_51_ = 0;
			    else
				i_51_ &= 0xff;
			    int i_52_ = anInt492 * i_32_ >> 1546678668;
			    i_42_ &= 0xff;
			    int i_53_ = aShortArray487[i_51_ - -i_47_];
			    int i_54_ = aShortArray487[i_47_ + i_42_];
			    if ((i_52_ ^ 0xffffffff) >= (i_45_ ^ 0xffffffff))
				i_45_ = 0;
			    else
				i_45_ &= 0xff;
			    int i_55_ = aShortArray487[i_51_ + i_43_];
			    int i_56_ = aShortArray487[i_42_ + i_43_];
			    int i_57_
				= method1786(i_34_,
						      (aShortArray487
						       [i_40_ - -i_54_]),
						      13828, i_37_, i_33_);
			    int i_58_
				= method1786(i_50_,
						      (aShortArray487
						       [i_45_ - -i_54_]),
						      13828, i_37_, i_33_);
			    int i_59_
				= (((i_58_ + -i_57_) * i_41_ >> 393606316)
				   + i_57_);
			    i_57_ = method1786(i_34_,
							(aShortArray487
							 [i_40_ - -i_53_]),
							13828, i_48_, i_33_);
			    i_58_ = method1786(i_50_,
							(aShortArray487
							 [i_53_ + i_45_]),
							arg3 ^ 0x3604, i_48_,
							i_33_);
			    int i_60_ = i_57_ + ((-i_57_ + i_58_) * i_41_
						 >> 93719564);
			    int i_61_ = (((i_60_ - i_59_) * i_49_ >> 460247180)
					 + i_59_);
			    i_57_ = method1786(i_34_,
							(aShortArray487
							 [i_56_ + i_40_]),
							arg3 ^ 0x3604, i_37_,
							i_44_);
			    i_58_ = method1786(i_50_,
							(aShortArray487
							 [i_56_ + i_45_]),
							13828, i_37_, i_44_);
			    i_59_ = i_57_ - -((i_58_ - i_57_) * i_41_
					      >> -1201375924);
			    i_57_ = method1786(i_34_,
							(aShortArray487
							 [i_40_ - -i_55_]),
							13828, i_48_, i_44_);
			    i_58_ = method1786(i_50_,
							(aShortArray487
							 [i_55_ + i_45_]),
							arg3 + 13828, i_48_,
							i_44_);
			    i_60_ = i_57_ - -(i_41_ * (i_58_ + -i_57_)
					      >> -872615348);
			    int i_62_ = i_59_ + (i_49_ * (i_60_ - i_59_)
						 >> -199734388);
			    method1011(i_31_,
				       ((-i_61_ + i_62_) * i_46_
					>> -140152532) + i_61_,
				       (byte) -113);
			}
			write(0);
		    }
		}
	    }
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }

    public Class26(int arg0, int arg1, int arg2, int arg3, int arg4) {
	anInt485 = 0;
	anInt483 = 4;
	anInt492 = 4;
	anInt484 = 4;
	anInt498 = 4;
	try {
	    anInt484 = arg1;
	    anInt492 = arg2;
	    anInt498 = arg4;
	    anInt485 = arg0;
	    anInt483 = arg3;
	    method1019(2);
	    method1015((byte) -125);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    public static int method1786(int arg0, int arg1, int arg2, int arg3,
				 int arg4) {
    while_1170_:
	do {
	    int i;
	    int i_5_;
	    do {
		int i_6_;
		try {
		    i = arg1 & 0xf;
		    i_5_ = (i ^ 0xffffffff) > -9 ? arg0 : arg3;
		    if (arg2 == 13828)
			break;
		    i_6_ = 4;
		} catch (RuntimeException runtimeexception) {
		    break while_1170_;
		}
		return i_6_;
	    } while (false);
	    int i_7_;
	    try {
		int i_8_ = (i < 4 ? arg3 : 12 == i || -15 == (i ^ 0xffffffff)
			    ? arg0 : arg4);
		i_7_ = (((i & 0x1 ^ 0xffffffff) == -1 ? i_5_ : -i_5_)
			- -(0 != (i & 0x2) ? -i_8_ : i_8_));
	    } catch (RuntimeException runtimeexception) {
		break;
	    }
	    return i_7_;
	} while (false);
    RuntimeException throwable = new RuntimeException();
	throw throwable;
    }

    public static int method1207(byte arg0, int arg1) {
	int i;
	try {
	    int i_0_ = arg1 * (arg1 * arg1 >> 75060012) >> -896491924;
	    int i_1_ = 6 * arg1 + -61440;
	    int i_2_ = (i_1_ * arg1 >> -641795124) + 40960;
	    i = i_2_ * i_0_ >> 1931685196;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return i;
    }
    static {
        anIntArray468 = new int[4096];
        for (int i = 0; i < 4096; i++)
            anIntArray468[i] = method1207((byte) -124, i);
    }
}