
public final class Class22
{
    private boolean aBoolean325 = true;
    private byte aByte326 = 69;
    private int anInt327 = 845;
    Class33 aClass33_328 = new Class33();
    Class33 aClass33_329;
    
    public Class22(int arg0) {
	((Class33) ((Class22) this).aClass33_328).aClass33_497
	    = ((Class22) this).aClass33_328;
	((Class33) ((Class22) this).aClass33_328).aClass33_498
	    = ((Class22) this).aClass33_328;
	arg0 = 11 / arg0;
    }
    
    public void method181(Class33 arg0) {
	if (((Class33) arg0).aClass33_498 != null)
	    arg0.method258();
	((Class33) arg0).aClass33_498
	    = ((Class33) ((Class22) this).aClass33_328).aClass33_498;
	((Class33) arg0).aClass33_497 = ((Class22) this).aClass33_328;
	((Class33) ((Class33) arg0).aClass33_498).aClass33_497 = arg0;
	((Class33) ((Class33) arg0).aClass33_497).aClass33_498 = arg0;
    }
    
    public Class33 method182() {
	Class33 class33
	    = ((Class33) ((Class22) this).aClass33_328).aClass33_497;
	if (class33 == ((Class22) this).aClass33_328)
	    return null;
	class33.method258();
	return class33;
    }
    
    public Class33 method183() {
	Class33 class33
	    = ((Class33) ((Class22) this).aClass33_328).aClass33_497;
	if (class33 == ((Class22) this).aClass33_328) {
	    ((Class22) this).aClass33_329 = null;
	    return null;
	}
	((Class22) this).aClass33_329 = ((Class33) class33).aClass33_497;
	return class33;
    }
    
    public Class33 method184(byte arg0) {
	if (arg0 != aByte326)
	    throw new NullPointerException();
	Class33 class33
	    = ((Class33) ((Class22) this).aClass33_328).aClass33_498;
	if (class33 == ((Class22) this).aClass33_328) {
	    ((Class22) this).aClass33_329 = null;
	    return null;
	}
	((Class22) this).aClass33_329 = ((Class33) class33).aClass33_498;
	return class33;
    }
    
    public Class33 method185(int arg0) {
	Class33 class33 = ((Class22) this).aClass33_329;
	if (class33 == ((Class22) this).aClass33_328) {
	    ((Class22) this).aClass33_329 = null;
	    return null;
	}
	((Class22) this).aClass33_329 = ((Class33) class33).aClass33_497;
	if (arg0 != -14092) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	return class33;
    }
    
    public Class33 method186(byte arg0) {
	Class33 class33 = ((Class22) this).aClass33_329;
	if (arg0 == 3) {
	    boolean flag = false;
	} else
	    throw new NullPointerException();
	if (class33 == ((Class22) this).aClass33_328) {
	    ((Class22) this).aClass33_329 = null;
	    return null;
	}
	((Class22) this).aClass33_329 = ((Class33) class33).aClass33_498;
	return class33;
    }
    
    public void method187() {
	for (;;) {
	    Class33 class33
		= ((Class33) ((Class22) this).aClass33_328).aClass33_497;
	    if (class33 == ((Class22) this).aClass33_328)
		break;
	    class33.method258();
	}
    }
}
