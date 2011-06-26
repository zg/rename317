
final class Class33_Sub7_Sub2_Sub2 extends Class33_Sub7_Sub2
{
    private int anInt1269 = 1;
    private int anInt1270 = -612;
    private int anInt1271 = 8;
    private byte aByte1272 = 2;
    String aString1273;
    boolean aBoolean1274 = false;
    int anInt1275;
    int anInt1276;
    int[] anIntArray1277 = new int[13];
    int[] anIntArray1278 = new int[5];
    int anInt1279;
    long aLong1280;
    int anInt1281;
    int anInt1282;
    int anInt1283;
    int anInt1284;
    int anInt1285;
    int anInt1286;
    Class33_Sub2_Sub1 aClass33_Sub2_Sub1_1287;
    int anInt1288;
    int anInt1289;
    int anInt1290;
    int anInt1291;
    boolean aBoolean1292 = false;
    static Class29 aClass29_1293 = new Class29(-947, 200);
    
    public final void method364(Class33_Sub2_Sub3 arg0, int arg1) {
	arg0.anInt1108 = 0;
	((Class33_Sub7_Sub2_Sub2) this).anInt1275 = arg0.method342();
	((Class33_Sub7_Sub2_Sub2) this).anInt1276 = arg0.method342();
	if (arg1 < 0) {
	    for (int i = 0; i < 13; i++) {
		int i1 = arg0.method342();
		if (i1 == 0)
		    ((Class33_Sub7_Sub2_Sub2) this).anIntArray1277[i] = 0;
		else {
		    int i2 = arg0.method342();
		    ((Class33_Sub7_Sub2_Sub2) this).anIntArray1277[i]
			= (i1 << 8) + i2;
		}
	    }
	    for (int i = 0; i < 5; i++) {
		int i3 = arg0.method342();
		if (i3 < 0 || i3 >= client.anIntArrayArray854[i].length)
		    i3 = 0;
		((Class33_Sub7_Sub2_Sub2) this).anIntArray1278[i] = i3;
	    }
	    ((Class33_Sub7_Sub2) this).anInt1140 = arg0.method344();
	    ((Class33_Sub7_Sub2) this).anInt1141 = arg0.method344();
	    ((Class33_Sub7_Sub2) this).anInt1136 = arg0.method344();
	    ((Class33_Sub7_Sub2) this).anInt1137 = arg0.method344();
	    ((Class33_Sub7_Sub2) this).anInt1138 = arg0.method344();
	    ((Class33_Sub7_Sub2) this).anInt1139 = arg0.method344();
	    ((Class33_Sub7_Sub2_Sub2) this).aString1273
		= Class35.method376(Class35.method373((byte) -89,
						      arg0.method348(1)),
				    -591);
	    ((Class33_Sub7_Sub2_Sub2) this).anInt1279 = arg0.method342();
	    ((Class33_Sub7_Sub2_Sub2) this).aBoolean1274 = true;
	    ((Class33_Sub7_Sub2_Sub2) this).aLong1280 = 0L;
	    for (int i = 0; i < 12; i++) {
		((Class33_Sub7_Sub2_Sub2) this).aLong1280 <<= 4;
		if (((Class33_Sub7_Sub2_Sub2) this).anIntArray1277[i] >= 256)
		    ((Class33_Sub7_Sub2_Sub2) this).aLong1280
			+= (long) ((((Class33_Sub7_Sub2_Sub2) this)
				    .anIntArray1277[i])
				   - 256);
	    }
	    for (int i = 0; i < 5; i++) {
		((Class33_Sub7_Sub2_Sub2) this).aLong1280 <<= 3;
		((Class33_Sub7_Sub2_Sub2) this).aLong1280
		    += (long) (((Class33_Sub7_Sub2_Sub2) this).anIntArray1278
			       [i]);
	    }
	    ((Class33_Sub7_Sub2_Sub2) this).aLong1280 <<= 1;
	    ((Class33_Sub7_Sub2_Sub2) this).aLong1280
		+= (long) ((Class33_Sub7_Sub2_Sub2) this).anInt1275;
	}
    }
    
    public final Class33_Sub2_Sub1 method358(int arg0) {
	if (arg0 != 0)
	    throw new NullPointerException();
	if (!((Class33_Sub7_Sub2_Sub2) this).aBoolean1274)
	    return null;
	Class33_Sub2_Sub1 class33_sub2_sub1 = method365(39767);
	((Class33_Sub7_Sub2) this).anInt1175 = class33_sub2_sub1.anInt1030;
	if (((Class33_Sub7_Sub2_Sub2) this).aBoolean1292)
	    return class33_sub2_sub1;
	if (((Class33_Sub7_Sub2) this).anInt1162 != -1
	    && ((Class33_Sub7_Sub2) this).anInt1163 != -1) {
	    Class12 class12 = (Class12.aClass12Array208
			       [((Class33_Sub7_Sub2) this).anInt1162]);
	    Class33_Sub2_Sub1 class33_sub2_sub1_1
		= new Class33_Sub2_Sub1(true, !class12.aBoolean212,
					class12.method140(), 440, true, false);
	    class33_sub2_sub1_1.method271(anInt1271, 0, 0,
					  -(((Class33_Sub7_Sub2) this)
					    .anInt1166));
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
	    class33_sub2_sub1
		= new Class33_Sub2_Sub1(true, class33_sub2_sub1s, 20525, 2);
	}
	if (((Class33_Sub7_Sub2_Sub2) this).aClass33_Sub2_Sub1_1287 != null) {
	    if (client.anInt647 >= ((Class33_Sub7_Sub2_Sub2) this).anInt1283)
		((Class33_Sub7_Sub2_Sub2) this).aClass33_Sub2_Sub1_1287 = null;
	    if (client.anInt647 >= ((Class33_Sub7_Sub2_Sub2) this).anInt1282
		&& (client.anInt647
		    < ((Class33_Sub7_Sub2_Sub2) this).anInt1283)) {
		Class33_Sub2_Sub1 class33_sub2_sub1_2
		    = ((Class33_Sub7_Sub2_Sub2) this).aClass33_Sub2_Sub1_1287;
		class33_sub2_sub1_2.method271
		    (anInt1271,
		     (((Class33_Sub7_Sub2_Sub2) this).anInt1286
		      - ((Class33_Sub7_Sub2) this).anInt1132),
		     (((Class33_Sub7_Sub2_Sub2) this).anInt1284
		      - ((Class33_Sub7_Sub2) this).anInt1131),
		     (((Class33_Sub7_Sub2_Sub2) this).anInt1285
		      - ((Class33_Sub7_Sub2_Sub2) this).anInt1281));
		if (((Class33_Sub7_Sub2) this).anInt1176 == 512) {
		    class33_sub2_sub1_2.method269(0);
		    class33_sub2_sub1_2.method269(0);
		    class33_sub2_sub1_2.method269(0);
		} else if (((Class33_Sub7_Sub2) this).anInt1176 == 1024) {
		    class33_sub2_sub1_2.method269(0);
		    class33_sub2_sub1_2.method269(0);
		} else if (((Class33_Sub7_Sub2) this).anInt1176 == 1536)
		    class33_sub2_sub1_2.method269(0);
		Class33_Sub2_Sub1[] class33_sub2_sub1s
		    = { class33_sub2_sub1, class33_sub2_sub1_2 };
		class33_sub2_sub1
		    = new Class33_Sub2_Sub1(true, class33_sub2_sub1s, 20525,
					    2);
		if (((Class33_Sub7_Sub2) this).anInt1176 == 512)
		    class33_sub2_sub1_2.method269(0);
		else if (((Class33_Sub7_Sub2) this).anInt1176 == 1024) {
		    class33_sub2_sub1_2.method269(0);
		    class33_sub2_sub1_2.method269(0);
		} else if (((Class33_Sub7_Sub2) this).anInt1176 == 1536) {
		    class33_sub2_sub1_2.method269(0);
		    class33_sub2_sub1_2.method269(0);
		    class33_sub2_sub1_2.method269(0);
		}
		class33_sub2_sub1_2.method271
		    (anInt1271,
		     (((Class33_Sub7_Sub2) this).anInt1132
		      - ((Class33_Sub7_Sub2_Sub2) this).anInt1286),
		     (((Class33_Sub7_Sub2) this).anInt1131
		      - ((Class33_Sub7_Sub2_Sub2) this).anInt1284),
		     (((Class33_Sub7_Sub2_Sub2) this).anInt1281
		      - ((Class33_Sub7_Sub2_Sub2) this).anInt1285));
	    }
	}
	return class33_sub2_sub1;
    }
    
    public final Class33_Sub2_Sub1 method365(int arg0) {
	long l = ((Class33_Sub7_Sub2_Sub2) this).aLong1280;
	int i = -1;
	int i1 = -1;
	int i2 = -1;
	int i3 = -1;
	if (((Class33_Sub7_Sub2) this).anInt1157 >= 0
	    && ((Class33_Sub7_Sub2) this).anInt1160 == 0) {
	    Class10 class10 = (Class10.aClass10Array183
			       [((Class33_Sub7_Sub2) this).anInt1157]);
	    i = class10.anIntArray185[((Class33_Sub7_Sub2) this).anInt1158];
	    if (((Class33_Sub7_Sub2) this).anInt1154 >= 0
		&& (((Class33_Sub7_Sub2) this).anInt1154
		    != ((Class33_Sub7_Sub2) this).anInt1140))
		i1 = (Class10.aClass10Array183
		      [((Class33_Sub7_Sub2) this).anInt1154].anIntArray185
		      [((Class33_Sub7_Sub2) this).anInt1155]);
	    if (class10.anInt192 >= 0) {
		i2 = class10.anInt192;
		l += (long) (i2 - (((Class33_Sub7_Sub2_Sub2) this)
				   .anIntArray1277[5])
			     << 8);
	    }
	    if (class10.anInt193 >= 0) {
		i3 = class10.anInt193;
		l += (long) (i2 - (((Class33_Sub7_Sub2_Sub2) this)
				   .anIntArray1277[3])
			     << 16);
	    }
	} else if (((Class33_Sub7_Sub2) this).anInt1154 >= 0)
	    i = (Class10.aClass10Array183[((Class33_Sub7_Sub2) this).anInt1154]
		 .anIntArray185[((Class33_Sub7_Sub2) this).anInt1155]);
	Class33_Sub2_Sub1 class33_sub2_sub1
	    = (Class33_Sub2_Sub1) aClass29_1293.method250(l);
	if (class33_sub2_sub1 == null) {
	    Class33_Sub2_Sub1[] class33_sub2_sub1s = new Class33_Sub2_Sub1[13];
	    int i4 = 0;
	    for (int i5 = 0; i5 < 13; i5++) {
		int i6 = ((Class33_Sub7_Sub2_Sub2) this).anIntArray1277[i5];
		if (i3 >= 0 && i5 == 3)
		    i6 = i3;
		if (i2 >= 0 && i5 == 5)
		    i6 = i2;
		if (i6 >= 256 && i6 < 512)
		    class33_sub2_sub1s[i4++]
			= Class4.aClass4Array84[i6 - 256].method123();
		if (i6 >= 512) {
		    Class39 class39 = Class39.method395(i6 - 512);
		    Class33_Sub2_Sub1 class33_sub2_sub1_7
			= class39.method400((((Class33_Sub7_Sub2_Sub2) this)
					     .anInt1275),
					    (byte) 1);
		    if (class33_sub2_sub1_7 != null)
			class33_sub2_sub1s[i4++] = class33_sub2_sub1_7;
		}
	    }
	    class33_sub2_sub1
		= new Class33_Sub2_Sub1(i4, false, class33_sub2_sub1s);
	    for (int i8 = 0; i8 < 5; i8++) {
		if (((Class33_Sub7_Sub2_Sub2) this).anIntArray1278[i8] != 0) {
		    class33_sub2_sub1.method272((client.anIntArrayArray854[i8]
						 [0]),
						(client.anIntArrayArray854[i8]
						 [((Class33_Sub7_Sub2_Sub2)
						   this).anIntArray1278[i8]]));
		    if (i8 == 1)
			class33_sub2_sub1.method272
			    (client.anIntArray641[0],
			     client.anIntArray641[((Class33_Sub7_Sub2_Sub2)
						   this).anIntArray1278[i8]]);
		}
	    }
	    class33_sub2_sub1.method265(0);
	    class33_sub2_sub1.method275(64, 850, -30, -50, -30, true);
	    aClass29_1293.method251(class33_sub2_sub1, l, aByte1272);
	}
	if (((Class33_Sub7_Sub2_Sub2) this).aBoolean1292)
	    return class33_sub2_sub1;
	Class33_Sub2_Sub1 class33_sub2_sub1_9
	    = new Class33_Sub2_Sub1(true, false, class33_sub2_sub1);
	if (i != -1 && i1 != -1)
	    class33_sub2_sub1_9.method267(i, i1, (Class10.aClass10Array183
						  [(((Class33_Sub7_Sub2) this)
						    .anInt1157)]
						  .anIntArray189), anInt1270);
	else if (i != -1)
	    class33_sub2_sub1_9.method266(false, i);
	class33_sub2_sub1_9.method263(false);
	class33_sub2_sub1_9.anIntArrayArray1038 = null;
	if (arg0 != 39767) {
	    for (int i10 = 1; i10 > 0; i10++) {
	    }
	}
	class33_sub2_sub1_9.anIntArrayArray1037 = null;
	return class33_sub2_sub1_9;
    }
    
    public final Class33_Sub2_Sub1 method366(int arg0) {
	if (!((Class33_Sub7_Sub2_Sub2) this).aBoolean1274)
	    return null;
	Class33_Sub2_Sub1[] class33_sub2_sub1s = new Class33_Sub2_Sub1[13];
	int i = 0;
	for (int i1 = 0; i1 < 13; i1++) {
	    int i2 = ((Class33_Sub7_Sub2_Sub2) this).anIntArray1277[i1];
	    if (i2 >= 256 && i2 < 512)
		class33_sub2_sub1s[i++]
		    = Class4.aClass4Array84[i2 - 256].method124(-502);
	    if (i2 >= 512) {
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = (Class39.method395(i2 - 512).method401
		       (((Class33_Sub7_Sub2_Sub2) this).anInt1275, -39571));
		if (class33_sub2_sub1 != null)
		    class33_sub2_sub1s[i++] = class33_sub2_sub1;
	    }
	}
	if (arg0 != anInt1269)
	    throw new NullPointerException();
	Class33_Sub2_Sub1 class33_sub2_sub1
	    = new Class33_Sub2_Sub1(i, false, class33_sub2_sub1s);
	for (int i3 = 0; i3 < 5; i3++) {
	    if (((Class33_Sub7_Sub2_Sub2) this).anIntArray1278[i3] != 0) {
		class33_sub2_sub1.method272(client.anIntArrayArray854[i3][0],
					    (client.anIntArrayArray854[i3]
					     [(((Class33_Sub7_Sub2_Sub2) this)
					       .anIntArray1278[i3])]));
		if (i3 == 1)
		    class33_sub2_sub1.method272(client.anIntArray641[0],
						(client.anIntArray641
						 [((Class33_Sub7_Sub2_Sub2)
						   this).anIntArray1278[i3]]));
	    }
	}
	return class33_sub2_sub1;
    }
    
    public final boolean method367(int arg0) {
	if (arg0 != -29424)
	    throw new NullPointerException();
	if (!((Class33_Sub7_Sub2_Sub2) this).aBoolean1274)
	    return false;
	return true;
    }
}
