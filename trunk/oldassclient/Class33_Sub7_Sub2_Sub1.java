
final class Class33_Sub7_Sub2_Sub1 extends Class33_Sub7_Sub2
{
    private int anInt1267 = 8;
    Class38 aClass38_1268;
    
    public final Class33_Sub2_Sub1 method358(int arg0) {
	if (((Class33_Sub7_Sub2_Sub1) this).aClass38_1268 == null)
	    return null;
	if (((Class33_Sub7_Sub2) this).anInt1162 == -1
	    || ((Class33_Sub7_Sub2) this).anInt1163 == -1)
	    return method362(39767);
	Class33_Sub2_Sub1 class33_sub2_sub1 = method362(39767);
	Class12 class12
	    = Class12.aClass12Array208[((Class33_Sub7_Sub2) this).anInt1162];
	Class33_Sub2_Sub1 class33_sub2_sub1_1
	    = new Class33_Sub2_Sub1(true, !class12.aBoolean212,
				    class12.method140(), 440, true, false);
	if (arg0 != 0)
	    throw new NullPointerException();
	class33_sub2_sub1_1.method271(anInt1267, 0, 0,
				      -((Class33_Sub7_Sub2) this).anInt1166);
	class33_sub2_sub1_1.method265(0);
	class33_sub2_sub1_1.method266(false,
				      (class12.aClass10_211.anIntArray185
				       [(((Class33_Sub7_Sub2) this)
					 .anInt1163)]));
	class33_sub2_sub1_1.anIntArrayArray1038 = null;
	class33_sub2_sub1_1.anIntArrayArray1037 = null;
	class33_sub2_sub1_1.method275(64, 850, -30, -50, -30, true);
	Class33_Sub2_Sub1[] class33_sub2_sub1s
	    = { class33_sub2_sub1, class33_sub2_sub1_1 };
	return new Class33_Sub2_Sub1(true, class33_sub2_sub1s, 20525, 2);
    }
    
    public final Class33_Sub2_Sub1 method362(int arg0) {
	if (arg0 != 39767)
	    throw new NullPointerException();
	if (((Class33_Sub7_Sub2) this).anInt1157 >= 0
	    && ((Class33_Sub7_Sub2) this).anInt1160 == 0) {
	    int i = (Class10.aClass10Array183
		     [((Class33_Sub7_Sub2) this).anInt1157].anIntArray185
		     [((Class33_Sub7_Sub2) this).anInt1158]);
	    int i1 = -1;
	    if (((Class33_Sub7_Sub2) this).anInt1154 >= 0
		&& (((Class33_Sub7_Sub2) this).anInt1154
		    != ((Class33_Sub7_Sub2) this).anInt1140))
		i1 = (Class10.aClass10Array183
		      [((Class33_Sub7_Sub2) this).anInt1154].anIntArray185
		      [((Class33_Sub7_Sub2) this).anInt1155]);
	    return (((Class33_Sub7_Sub2_Sub1) this).aClass38_1268.method391
		    (i, i1,
		     (Class10.aClass10Array183
		      [((Class33_Sub7_Sub2) this).anInt1157].anIntArray189)));
	}
	int i = -1;
	if (((Class33_Sub7_Sub2) this).anInt1154 >= 0)
	    i = (Class10.aClass10Array183[((Class33_Sub7_Sub2) this).anInt1154]
		 .anIntArray185[((Class33_Sub7_Sub2) this).anInt1155]);
	Class33_Sub2_Sub1 class33_sub2_sub1
	    = ((Class33_Sub7_Sub2_Sub1) this).aClass38_1268.method391(i, -1,
								      null);
	((Class33_Sub7_Sub2) this).anInt1175 = class33_sub2_sub1.anInt1030;
	return class33_sub2_sub1;
    }
    
    public final boolean method363(int arg0) {
	if (arg0 != -29424)
	    throw new NullPointerException();
	if (((Class33_Sub7_Sub2_Sub1) this).aClass38_1268 == null)
	    return false;
	return true;
    }
}
