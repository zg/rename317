
public final class Class31
{
    private int anInt487 = -36905;
    private int anInt488;
    private Class33[] aClass33Array489;
    
    public Class31(boolean arg0, int arg1) {
	anInt488 = arg1;
	aClass33Array489 = new Class33[arg1];
	if (arg0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	for (int i = 0; i < arg1; i++) {
	    Class33 class33 = aClass33Array489[i] = new Class33();
	    ((Class33) class33).aClass33_497 = class33;
	    ((Class33) class33).aClass33_498 = class33;
	}
    }
    
    public Class33 method253(long arg0) {
	Class33 class33
	    = aClass33Array489[(int) (arg0 & (long) (anInt488 - 1))];
	for (Class33 class33_1 = ((Class33) class33).aClass33_497;
	     class33_1 != class33;
	     class33_1 = ((Class33) class33_1).aClass33_497) {
	    if (((Class33) class33_1).aLong496 == arg0)
		return class33_1;
	}
	return null;
    }
    
    public void method254(long arg0, Class33 arg1, int arg2) {
	if (((Class33) arg1).aClass33_498 != null)
	    arg1.method258();
	Class33 class33
	    = aClass33Array489[(int) (arg0 & (long) (anInt488 - 1))];
	((Class33) arg1).aClass33_498 = ((Class33) class33).aClass33_498;
	((Class33) arg1).aClass33_497 = class33;
	arg2 = 95 / arg2;
	((Class33) ((Class33) arg1).aClass33_498).aClass33_497 = arg1;
	((Class33) ((Class33) arg1).aClass33_497).aClass33_498 = arg1;
	((Class33) arg1).aLong496 = arg0;
    }
}
