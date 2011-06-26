
public final class Class29
{
    private boolean aBoolean434 = true;
    private int anInt435;
    private int anInt436;
    private Class31 aClass31_437 = new Class31(false, 1024);
    private Class24 aClass24_438 = new Class24((byte) 3);
    
    public Class29(int arg0, int arg1) {
	if (arg0 >= 0)
	    throw new NullPointerException();
	anInt435 = arg1;
	anInt436 = arg1;
    }
    
    public Class33_Sub2 method250(long arg0) {
	Class33_Sub2 class33_sub2
	    = (Class33_Sub2) aClass31_437.method253(arg0);
	if (class33_sub2 != null)
	    aClass24_438.method188(class33_sub2);
	return class33_sub2;
    }
    
    public void method251(Class33_Sub2 arg0, long arg1, byte arg2) {
	if (anInt436 == 0) {
	    Class33_Sub2 class33_sub2 = aClass24_438.method189();
	    class33_sub2.method258();
	    class33_sub2.method259();
	} else
	    anInt436--;
	aClass31_437.method254(arg1, arg0, 276);
	if (arg2 == 2) {
	    boolean flag = false;
	} else
	    aBoolean434 = !aBoolean434;
	aClass24_438.method188(arg0);
    }
    
    public void method252() {
	for (;;) {
	    Class33_Sub2 class33_sub2 = aClass24_438.method189();
	    if (class33_sub2 == null)
		break;
	    class33_sub2.method258();
	    class33_sub2.method259();
	}
	anInt436 = anInt435;
    }
}
