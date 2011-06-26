
public class Class33_Sub2_Sub2 extends Class33_Sub2
{
    private static int anInt1087 = 837;
    private static byte aByte1088 = 5;
    public static int[] anIntArray1089;
    public static int anInt1090;
    public static int anInt1091;
    public static int anInt1092;
    public static int anInt1093;
    public static int anInt1094;
    public static int anInt1095;
    public static int anInt1096;
    public static int anInt1097;
    public static int anInt1098;
    public static boolean aBoolean1099;
    
    public static void method284(boolean arg0, int arg1, int[] arg2,
				 int arg3) {
	anIntArray1089 = arg2;
	if (!arg0)
	    anInt1087 = 256;
	anInt1090 = arg1;
	anInt1091 = arg3;
	method286(arg1, aByte1088, 0, 0, arg3);
    }
    
    public static void method285(byte arg0) {
	anInt1094 = 0;
	if (arg0 == 9) {
	    boolean flag = false;
	} else {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	anInt1092 = 0;
	anInt1095 = anInt1090;
	anInt1093 = anInt1091;
	anInt1096 = anInt1095 - 1;
	anInt1097 = anInt1095 / 2;
    }
    
    public static void method286(int arg0, byte arg1, int arg2, int arg3,
				 int arg4) {
	if (arg2 < 0)
	    arg2 = 0;
	if (arg3 < 0)
	    arg3 = 0;
	if (arg0 > anInt1090)
	    arg0 = anInt1090;
	if (arg4 > anInt1091)
	    arg4 = anInt1091;
	anInt1094 = arg2;
	anInt1092 = arg3;
	anInt1095 = arg0;
	if (arg1 != 5) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	anInt1093 = arg4;
	anInt1096 = anInt1095 - 1;
	anInt1097 = anInt1095 / 2;
	anInt1098 = anInt1093 / 2;
    }
    
    public static void method287(int arg0) {
	int i = anInt1090 * anInt1091;
	if (arg0 != 2)
	    anInt1087 = -185;
	for (int i1 = 0; i1 < i; i1++)
	    anIntArray1089[i1] = 0;
    }
    
    public static void method288(int arg0, int arg1, int arg2, boolean arg3,
				 int arg4, int arg5) {
	if (arg5 < anInt1094) {
	    arg1 -= anInt1094 - arg5;
	    arg5 = anInt1094;
	}
	if (arg2 < anInt1092) {
	    arg4 -= anInt1092 - arg2;
	    arg2 = anInt1092;
	}
	if (arg5 + arg1 > anInt1095)
	    arg1 = anInt1095 - arg5;
	if (arg2 + arg4 > anInt1093)
	    arg4 = anInt1093 - arg2;
	int i = anInt1090 - arg1;
	int i1 = arg5 + arg2 * anInt1090;
	for (int i2 = -arg4; i2 < 0; i2++) {
	    for (int i3 = -arg1; i3 < 0; i3++)
		anIntArray1089[i1++] = arg0;
	    i1 += i;
	}
	if (arg3) {
	    for (int i4 = 1; i4 > 0; i4++) {
	    }
	}
    }
    
    public static void method289(int arg0, int arg1, int arg2, int arg3,
				 boolean arg4, int arg5) {
	method290(true, arg5, arg3, arg0, arg2);
	if (!arg4) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	method290(true, arg5, arg3 + arg1 - 1, arg0, arg2);
	method291(arg3, arg2, arg1, false, arg5);
	method291(arg3, arg2 + arg0 - 1, arg1, false, arg5);
    }
    
    public static void method290(boolean arg0, int arg1, int arg2, int arg3,
				 int arg4) {
	if (arg0 && (arg2 >= anInt1092 && arg2 < anInt1093)) {
	    if (arg4 < anInt1094) {
		arg3 -= anInt1094 - arg4;
		arg4 = anInt1094;
	    }
	    if (arg4 + arg3 > anInt1095)
		arg3 = anInt1095 - arg4;
	    int i = arg4 + arg2 * anInt1090;
	    for (int i1 = 0; i1 < arg3; i1++)
		anIntArray1089[i + i1] = arg1;
	}
    }
    
    public static void method291(int arg0, int arg1, int arg2, boolean arg3,
				 int arg4) {
	if (arg1 >= anInt1094 && arg1 < anInt1095) {
	    if (arg0 < anInt1092) {
		arg2 -= anInt1092 - arg0;
		arg0 = anInt1092;
	    }
	    if (arg0 + arg2 > anInt1093)
		arg2 = anInt1093 - arg0;
	    int i = arg1 + arg0 * anInt1090;
	    if (!arg3) {
		for (int i1 = 0; i1 < arg2; i1++)
		    anIntArray1089[i + i1 * anInt1090] = arg4;
	    }
	}
    }
}
