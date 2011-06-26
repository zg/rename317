
public class Class1
{
    private boolean aBoolean31 = false;
    private int anInt32;
    private boolean aBoolean33 = false;
    private boolean aBoolean34 = false;
    private int anInt35 = 90;
    private int anInt36 = -497;
    public int anInt37 = 0;
    public int anInt38 = 0;
    public int anInt39;
    public int anInt40;
    public int[][] anIntArrayArray41;
    
    public Class1(int arg0, int arg1, int arg2) {
	anInt39 = arg2;
	anInt40 = arg0;
	anIntArrayArray41 = new int[anInt39][anInt40];
	method92(573);
	while (arg1 >= 0)
	    anInt32 = -264;
    }
    
    public void method92(int arg0) {
	for (int i = 0; i < anInt39; i++) {
	    for (int i1 = 0; i1 < anInt40; i1++) {
		if (i == 0 || i1 == 0 || i == anInt39 - 1 || i1 == anInt40 - 1)
		    anIntArrayArray41[i][i1] = 16777215;
		else
		    anIntArrayArray41[i][i1] = 0;
	    }
	}
	arg0 = 61 / arg0;
    }
    
    public void method93(int arg0, boolean arg1, int arg2, int arg3, int arg4,
			 int arg5) {
	arg0 -= anInt37;
	if (arg4 == -34301) {
	    arg3 -= anInt38;
	    if (arg2 == 0) {
		if (arg5 == 0) {
		    method96(arg0, arg3, 128);
		    method96(arg0 - 1, arg3, 8);
		}
		if (arg5 == 1) {
		    method96(arg0, arg3, 2);
		    method96(arg0, arg3 + 1, 32);
		}
		if (arg5 == 2) {
		    method96(arg0, arg3, 8);
		    method96(arg0 + 1, arg3, 128);
		}
		if (arg5 == 3) {
		    method96(arg0, arg3, 32);
		    method96(arg0, arg3 - 1, 2);
		}
	    }
	    if (arg2 == 1 || arg2 == 3) {
		if (arg5 == 0) {
		    method96(arg0, arg3, 1);
		    method96(arg0 - 1, arg3 + 1, 16);
		}
		if (arg5 == 1) {
		    method96(arg0, arg3, 4);
		    method96(arg0 + 1, arg3 + 1, 64);
		}
		if (arg5 == 2) {
		    method96(arg0, arg3, 16);
		    method96(arg0 + 1, arg3 - 1, 1);
		}
		if (arg5 == 3) {
		    method96(arg0, arg3, 64);
		    method96(arg0 - 1, arg3 - 1, 4);
		}
	    }
	    if (arg2 == 2) {
		if (arg5 == 0) {
		    method96(arg0, arg3, 130);
		    method96(arg0 - 1, arg3, 8);
		    method96(arg0, arg3 + 1, 32);
		}
		if (arg5 == 1) {
		    method96(arg0, arg3, 10);
		    method96(arg0, arg3 + 1, 32);
		    method96(arg0 + 1, arg3, 128);
		}
		if (arg5 == 2) {
		    method96(arg0, arg3, 40);
		    method96(arg0 + 1, arg3, 128);
		    method96(arg0, arg3 - 1, 2);
		}
		if (arg5 == 3) {
		    method96(arg0, arg3, 160);
		    method96(arg0, arg3 - 1, 2);
		    method96(arg0 - 1, arg3, 8);
		}
	    }
	    if (arg1) {
		if (arg2 == 0) {
		    if (arg5 == 0) {
			method96(arg0, arg3, 65536);
			method96(arg0 - 1, arg3, 4096);
		    }
		    if (arg5 == 1) {
			method96(arg0, arg3, 1024);
			method96(arg0, arg3 + 1, 16384);
		    }
		    if (arg5 == 2) {
			method96(arg0, arg3, 4096);
			method96(arg0 + 1, arg3, 65536);
		    }
		    if (arg5 == 3) {
			method96(arg0, arg3, 16384);
			method96(arg0, arg3 - 1, 1024);
		    }
		}
		if (arg2 == 1 || arg2 == 3) {
		    if (arg5 == 0) {
			method96(arg0, arg3, 512);
			method96(arg0 - 1, arg3 + 1, 8192);
		    }
		    if (arg5 == 1) {
			method96(arg0, arg3, 2048);
			method96(arg0 + 1, arg3 + 1, 32768);
		    }
		    if (arg5 == 2) {
			method96(arg0, arg3, 8192);
			method96(arg0 + 1, arg3 - 1, 512);
		    }
		    if (arg5 == 3) {
			method96(arg0, arg3, 32768);
			method96(arg0 - 1, arg3 - 1, 2048);
		    }
		}
		if (arg2 == 2) {
		    if (arg5 == 0) {
			method96(arg0, arg3, 66560);
			method96(arg0 - 1, arg3, 4096);
			method96(arg0, arg3 + 1, 16384);
		    }
		    if (arg5 == 1) {
			method96(arg0, arg3, 5120);
			method96(arg0, arg3 + 1, 16384);
			method96(arg0 + 1, arg3, 65536);
		    }
		    if (arg5 == 2) {
			method96(arg0, arg3, 20480);
			method96(arg0 + 1, arg3, 65536);
			method96(arg0, arg3 - 1, 1024);
		    }
		    if (arg5 == 3) {
			method96(arg0, arg3, 81920);
			method96(arg0, arg3 - 1, 1024);
			method96(arg0 - 1, arg3, 4096);
		    }
		}
	    }
	}
    }
    
    public void method94(boolean arg0, int arg1, int arg2, int arg3,
			 boolean arg4, int arg5, int arg6) {
	if (!arg0)
	    anInt32 = 65;
	int i = 256;
	if (arg4)
	    i += 131072;
	arg2 -= anInt37;
	arg3 -= anInt38;
	if (arg5 == 1 || arg5 == 3) {
	    int i1 = arg1;
	    arg1 = arg6;
	    arg6 = i1;
	}
	for (int i2 = arg2; i2 < arg2 + arg1; i2++) {
	    if (i2 >= 0 && i2 < anInt39) {
		for (int i3 = arg3; i3 < arg3 + arg6; i3++) {
		    if (i3 >= 0 && i3 < anInt40)
			method96(i2, i3, i);
		}
	    }
	}
    }
    
    public void method95(byte arg0, int arg1, int arg2) {
	arg2 -= anInt37;
	arg1 -= anInt38;
	anIntArrayArray41[arg2][arg1] |= 0x200000;
	if (arg0 != 0)
	    aBoolean31 = !aBoolean31;
    }
    
    private void method96(int arg0, int arg1, int arg2) {
	anIntArrayArray41[arg0][arg1] |= arg2;
    }
    
    public void method97(boolean arg0, int arg1, int arg2, int arg3, int arg4,
			 int arg5) {
	arg2 -= anInt37;
	if (arg3 != 2)
	    anInt32 = -18;
	arg5 -= anInt38;
	if (arg4 == 0) {
	    if (arg1 == 0) {
		method99(aBoolean34, arg5, arg2, 128);
		method99(aBoolean34, arg5, arg2 - 1, 8);
	    }
	    if (arg1 == 1) {
		method99(aBoolean34, arg5, arg2, 2);
		method99(aBoolean34, arg5 + 1, arg2, 32);
	    }
	    if (arg1 == 2) {
		method99(aBoolean34, arg5, arg2, 8);
		method99(aBoolean34, arg5, arg2 + 1, 128);
	    }
	    if (arg1 == 3) {
		method99(aBoolean34, arg5, arg2, 32);
		method99(aBoolean34, arg5 - 1, arg2, 2);
	    }
	}
	if (arg4 == 1 || arg4 == 3) {
	    if (arg1 == 0) {
		method99(aBoolean34, arg5, arg2, 1);
		method99(aBoolean34, arg5 + 1, arg2 - 1, 16);
	    }
	    if (arg1 == 1) {
		method99(aBoolean34, arg5, arg2, 4);
		method99(aBoolean34, arg5 + 1, arg2 + 1, 64);
	    }
	    if (arg1 == 2) {
		method99(aBoolean34, arg5, arg2, 16);
		method99(aBoolean34, arg5 - 1, arg2 + 1, 1);
	    }
	    if (arg1 == 3) {
		method99(aBoolean34, arg5, arg2, 64);
		method99(aBoolean34, arg5 - 1, arg2 - 1, 4);
	    }
	}
	if (arg4 == 2) {
	    if (arg1 == 0) {
		method99(aBoolean34, arg5, arg2, 130);
		method99(aBoolean34, arg5, arg2 - 1, 8);
		method99(aBoolean34, arg5 + 1, arg2, 32);
	    }
	    if (arg1 == 1) {
		method99(aBoolean34, arg5, arg2, 10);
		method99(aBoolean34, arg5 + 1, arg2, 32);
		method99(aBoolean34, arg5, arg2 + 1, 128);
	    }
	    if (arg1 == 2) {
		method99(aBoolean34, arg5, arg2, 40);
		method99(aBoolean34, arg5, arg2 + 1, 128);
		method99(aBoolean34, arg5 - 1, arg2, 2);
	    }
	    if (arg1 == 3) {
		method99(aBoolean34, arg5, arg2, 160);
		method99(aBoolean34, arg5 - 1, arg2, 2);
		method99(aBoolean34, arg5, arg2 - 1, 8);
	    }
	}
	if (arg0) {
	    if (arg4 == 0) {
		if (arg1 == 0) {
		    method99(aBoolean34, arg5, arg2, 65536);
		    method99(aBoolean34, arg5, arg2 - 1, 4096);
		}
		if (arg1 == 1) {
		    method99(aBoolean34, arg5, arg2, 1024);
		    method99(aBoolean34, arg5 + 1, arg2, 16384);
		}
		if (arg1 == 2) {
		    method99(aBoolean34, arg5, arg2, 4096);
		    method99(aBoolean34, arg5, arg2 + 1, 65536);
		}
		if (arg1 == 3) {
		    method99(aBoolean34, arg5, arg2, 16384);
		    method99(aBoolean34, arg5 - 1, arg2, 1024);
		}
	    }
	    if (arg4 == 1 || arg4 == 3) {
		if (arg1 == 0) {
		    method99(aBoolean34, arg5, arg2, 512);
		    method99(aBoolean34, arg5 + 1, arg2 - 1, 8192);
		}
		if (arg1 == 1) {
		    method99(aBoolean34, arg5, arg2, 2048);
		    method99(aBoolean34, arg5 + 1, arg2 + 1, 32768);
		}
		if (arg1 == 2) {
		    method99(aBoolean34, arg5, arg2, 8192);
		    method99(aBoolean34, arg5 - 1, arg2 + 1, 512);
		}
		if (arg1 == 3) {
		    method99(aBoolean34, arg5, arg2, 32768);
		    method99(aBoolean34, arg5 - 1, arg2 - 1, 2048);
		}
	    }
	    if (arg4 == 2) {
		if (arg1 == 0) {
		    method99(aBoolean34, arg5, arg2, 66560);
		    method99(aBoolean34, arg5, arg2 - 1, 4096);
		    method99(aBoolean34, arg5 + 1, arg2, 16384);
		}
		if (arg1 == 1) {
		    method99(aBoolean34, arg5, arg2, 5120);
		    method99(aBoolean34, arg5 + 1, arg2, 16384);
		    method99(aBoolean34, arg5, arg2 + 1, 65536);
		}
		if (arg1 == 2) {
		    method99(aBoolean34, arg5, arg2, 20480);
		    method99(aBoolean34, arg5, arg2 + 1, 65536);
		    method99(aBoolean34, arg5 - 1, arg2, 1024);
		}
		if (arg1 == 3) {
		    method99(aBoolean34, arg5, arg2, 81920);
		    method99(aBoolean34, arg5 - 1, arg2, 1024);
		    method99(aBoolean34, arg5, arg2 - 1, 4096);
		}
	    }
	}
    }
    
    public void method98(int arg0, boolean arg1, boolean arg2, int arg3,
			 int arg4, int arg5, int arg6) {
	int i = 256;
	if (!arg2) {
	    if (arg1)
		i += 131072;
	    arg0 -= anInt37;
	    arg6 -= anInt38;
	    if (arg5 == 1 || arg5 == 3) {
		int i1 = arg3;
		arg3 = arg4;
		arg4 = i1;
	    }
	    for (int i2 = arg0; i2 < arg0 + arg3; i2++) {
		if (i2 >= 0 && i2 < anInt39) {
		    for (int i3 = arg6; i3 < arg6 + arg4; i3++) {
			if (i3 >= 0 && i3 < anInt40)
			    method99(aBoolean34, i3, i2, i);
		    }
		}
	    }
	}
    }
    
    private void method99(boolean arg0, int arg1, int arg2, int arg3) {
	if (!arg0)
	    anIntArrayArray41[arg2][arg1] &= 16777215 - arg3;
    }
    
    public void method100(boolean arg0, int arg1, int arg2) {
	arg2 -= anInt37;
	arg1 -= anInt38;
	if (!arg0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	anIntArrayArray41[arg2][arg1] &= 0xdfffff;
    }
    
    public boolean method101(int arg0, int arg1, boolean arg2, int arg3,
			     int arg4, int arg5, int arg6) {
	if (arg0 == arg6 && arg3 == arg4)
	    return true;
	arg0 -= anInt37;
	arg3 -= anInt38;
	if (arg2) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	arg6 -= anInt37;
	arg4 -= anInt38;
	if (arg5 == 0) {
	    if (arg1 == 0) {
		if (arg0 == arg6 - 1 && arg3 == arg4)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 + 1
		    && (anIntArrayArray41[arg0][arg3] & 0x280120) == 0)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 - 1
		    && (anIntArrayArray41[arg0][arg3] & 0x280102) == 0)
		    return true;
	    } else if (arg1 == 1) {
		if (arg0 == arg6 && arg3 == arg4 + 1)
		    return true;
		if (arg0 == arg6 - 1 && arg3 == arg4
		    && (anIntArrayArray41[arg0][arg3] & 0x280108) == 0)
		    return true;
		if (arg0 == arg6 + 1 && arg3 == arg4
		    && (anIntArrayArray41[arg0][arg3] & 0x280180) == 0)
		    return true;
	    } else if (arg1 == 2) {
		if (arg0 == arg6 + 1 && arg3 == arg4)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 + 1
		    && (anIntArrayArray41[arg0][arg3] & 0x280120) == 0)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 - 1
		    && (anIntArrayArray41[arg0][arg3] & 0x280102) == 0)
		    return true;
	    } else if (arg1 == 3) {
		if (arg0 == arg6 && arg3 == arg4 - 1)
		    return true;
		if (arg0 == arg6 - 1 && arg3 == arg4
		    && (anIntArrayArray41[arg0][arg3] & 0x280108) == 0)
		    return true;
		if (arg0 == arg6 + 1 && arg3 == arg4
		    && (anIntArrayArray41[arg0][arg3] & 0x280180) == 0)
		    return true;
	    }
	}
	if (arg5 == 2) {
	    if (arg1 == 0) {
		if (arg0 == arg6 - 1 && arg3 == arg4)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 + 1)
		    return true;
		if (arg0 == arg6 + 1 && arg3 == arg4
		    && (anIntArrayArray41[arg0][arg3] & 0x280180) == 0)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 - 1
		    && (anIntArrayArray41[arg0][arg3] & 0x280102) == 0)
		    return true;
	    } else if (arg1 == 1) {
		if (arg0 == arg6 - 1 && arg3 == arg4
		    && (anIntArrayArray41[arg0][arg3] & 0x280108) == 0)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 + 1)
		    return true;
		if (arg0 == arg6 + 1 && arg3 == arg4)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 - 1
		    && (anIntArrayArray41[arg0][arg3] & 0x280102) == 0)
		    return true;
	    } else if (arg1 == 2) {
		if (arg0 == arg6 - 1 && arg3 == arg4
		    && (anIntArrayArray41[arg0][arg3] & 0x280108) == 0)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 + 1
		    && (anIntArrayArray41[arg0][arg3] & 0x280120) == 0)
		    return true;
		if (arg0 == arg6 + 1 && arg3 == arg4)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 - 1)
		    return true;
	    } else if (arg1 == 3) {
		if (arg0 == arg6 - 1 && arg3 == arg4)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 + 1
		    && (anIntArrayArray41[arg0][arg3] & 0x280120) == 0)
		    return true;
		if (arg0 == arg6 + 1 && arg3 == arg4
		    && (anIntArrayArray41[arg0][arg3] & 0x280180) == 0)
		    return true;
		if (arg0 == arg6 && arg3 == arg4 - 1)
		    return true;
	    }
	}
	if (arg5 == 9) {
	    if (arg0 == arg6 && arg3 == arg4 + 1
		&& (anIntArrayArray41[arg0][arg3] & 0x20) == 0)
		return true;
	    if (arg0 == arg6 && arg3 == arg4 - 1
		&& (anIntArrayArray41[arg0][arg3] & 0x2) == 0)
		return true;
	    if (arg0 == arg6 - 1 && arg3 == arg4
		&& (anIntArrayArray41[arg0][arg3] & 0x8) == 0)
		return true;
	    if (arg0 == arg6 + 1 && arg3 == arg4
		&& (anIntArrayArray41[arg0][arg3] & 0x80) == 0)
		return true;
	}
	return false;
    }
    
    public boolean method102(int arg0, int arg1, int arg2, int arg3, int arg4,
			     int arg5, int arg6) {
	if (arg2 != 0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	if (arg5 == arg4 && arg1 == arg0)
	    return true;
	arg5 -= anInt37;
	arg1 -= anInt38;
	arg4 -= anInt37;
	arg0 -= anInt38;
	if (arg3 == 6 || arg3 == 7) {
	    if (arg3 == 7)
		arg6 = arg6 + 2 & 0x3;
	    if (arg6 == 0) {
		if (arg5 == arg4 + 1 && arg1 == arg0
		    && (anIntArrayArray41[arg5][arg1] & 0x80) == 0)
		    return true;
		if (arg5 == arg4 && arg1 == arg0 - 1
		    && (anIntArrayArray41[arg5][arg1] & 0x2) == 0)
		    return true;
	    } else if (arg6 == 1) {
		if (arg5 == arg4 - 1 && arg1 == arg0
		    && (anIntArrayArray41[arg5][arg1] & 0x8) == 0)
		    return true;
		if (arg5 == arg4 && arg1 == arg0 - 1
		    && (anIntArrayArray41[arg5][arg1] & 0x2) == 0)
		    return true;
	    } else if (arg6 == 2) {
		if (arg5 == arg4 - 1 && arg1 == arg0
		    && (anIntArrayArray41[arg5][arg1] & 0x8) == 0)
		    return true;
		if (arg5 == arg4 && arg1 == arg0 + 1
		    && (anIntArrayArray41[arg5][arg1] & 0x20) == 0)
		    return true;
	    } else if (arg6 == 3) {
		if (arg5 == arg4 + 1 && arg1 == arg0
		    && (anIntArrayArray41[arg5][arg1] & 0x80) == 0)
		    return true;
		if (arg5 == arg4 && arg1 == arg0 + 1
		    && (anIntArrayArray41[arg5][arg1] & 0x20) == 0)
		    return true;
	    }
	}
	if (arg3 == 8) {
	    if (arg5 == arg4 && arg1 == arg0 + 1
		&& (anIntArrayArray41[arg5][arg1] & 0x20) == 0)
		return true;
	    if (arg5 == arg4 && arg1 == arg0 - 1
		&& (anIntArrayArray41[arg5][arg1] & 0x2) == 0)
		return true;
	    if (arg5 == arg4 - 1 && arg1 == arg0
		&& (anIntArrayArray41[arg5][arg1] & 0x8) == 0)
		return true;
	    if (arg5 == arg4 + 1 && arg1 == arg0
		&& (anIntArrayArray41[arg5][arg1] & 0x80) == 0)
		return true;
	}
	return false;
    }
    
    public boolean method103(int arg0, int arg1, int arg2, int arg3, int arg4,
			     int arg5, int arg6, int arg7) {
	if (arg3 <= 0)
	    throw new NullPointerException();
	int i = arg5 + arg6 - 1;
	int i1 = arg7 + arg0 - 1;
	if (arg4 >= arg5 && arg4 <= i && arg1 >= arg7 && arg1 <= i1)
	    return true;
	if (arg4 == arg5 - 1 && arg1 >= arg7 && arg1 <= i1
	    && (anIntArrayArray41[arg4 - anInt37][arg1 - anInt38] & 0x8) == 0
	    && (arg2 & 0x8) == 0)
	    return true;
	if (arg4 == i + 1 && arg1 >= arg7 && arg1 <= i1
	    && (anIntArrayArray41[arg4 - anInt37][arg1 - anInt38] & 0x80) == 0
	    && (arg2 & 0x2) == 0)
	    return true;
	if (arg1 == arg7 - 1 && arg4 >= arg5 && arg4 <= i
	    && (anIntArrayArray41[arg4 - anInt37][arg1 - anInt38] & 0x2) == 0
	    && (arg2 & 0x4) == 0)
	    return true;
	if (arg1 == i1 + 1 && arg4 >= arg5 && arg4 <= i
	    && (anIntArrayArray41[arg4 - anInt37][arg1 - anInt38] & 0x20) == 0
	    && (arg2 & 0x1) == 0)
	    return true;
	return false;
    }
}
