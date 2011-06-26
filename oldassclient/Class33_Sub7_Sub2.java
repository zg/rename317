
class Class33_Sub7_Sub2 extends Class33_Sub7
{
    private int anInt1130 = -449;
    int anInt1131;
    int anInt1132;
    int anInt1133;
    int anInt1134;
    int anInt1135 = 1;
    int anInt1136 = -1;
    int anInt1137 = -1;
    int anInt1138 = -1;
    int anInt1139 = -1;
    int anInt1140 = -1;
    int anInt1141 = -1;
    String aString1142;
    int anInt1143 = 100;
    int anInt1144;
    int anInt1145;
    int anInt1146;
    int anInt1147;
    int anInt1148 = -1000;
    int anInt1149;
    int anInt1150;
    int anInt1151 = -1;
    int anInt1152;
    int anInt1153;
    int anInt1154 = -1;
    int anInt1155;
    int anInt1156;
    int anInt1157 = -1;
    int anInt1158;
    int anInt1159;
    int anInt1160;
    int anInt1161;
    int anInt1162 = -1;
    int anInt1163;
    int anInt1164;
    int anInt1165;
    int anInt1166;
    int anInt1167;
    int anInt1168;
    int anInt1169;
    int anInt1170;
    int anInt1171;
    int anInt1172;
    int anInt1173;
    boolean aBoolean1174 = false;
    int anInt1175;
    int anInt1176;
    int anInt1177;
    int[] anIntArray1178 = new int[10];
    int[] anIntArray1179 = new int[10];
    int anInt1180;
    
    public final void method360(int arg0, int arg1, int arg2) {
	if (arg1 != ((Class33_Sub7_Sub2) this).anIntArray1178[0]
	    || arg2 != ((Class33_Sub7_Sub2) this).anIntArray1179[0]) {
	    if (((Class33_Sub7_Sub2) this).anInt1157 != -1
		&& (Class10.aClass10Array183
		    [((Class33_Sub7_Sub2) this).anInt1157].anInt191) <= 1)
		((Class33_Sub7_Sub2) this).anInt1157 = -1;
	    if (((Class33_Sub7_Sub2) this).anInt1177 < 9) {
		((Class33_Sub7_Sub2) this).anInt1177++;
		for (int i = ((Class33_Sub7_Sub2) this).anInt1177; i > 0;
		     i--) {
		    ((Class33_Sub7_Sub2) this).anIntArray1178[i]
			= ((Class33_Sub7_Sub2) this).anIntArray1178[i - 1];
		    ((Class33_Sub7_Sub2) this).anIntArray1179[i]
			= ((Class33_Sub7_Sub2) this).anIntArray1179[i - 1];
		}
	    } else {
		for (int i = 8; i > 0; i--) {
		    ((Class33_Sub7_Sub2) this).anIntArray1178[i]
			= ((Class33_Sub7_Sub2) this).anIntArray1178[i - 1];
		    ((Class33_Sub7_Sub2) this).anIntArray1179[i]
			= ((Class33_Sub7_Sub2) this).anIntArray1179[i - 1];
		}
	    }
	    ((Class33_Sub7_Sub2) this).anIntArray1178[0] = arg1;
	    arg0 = 87 / arg0;
	    ((Class33_Sub7_Sub2) this).anIntArray1179[0] = arg2;
	}
    }
    
    public final void method361(boolean arg0, int arg1, int arg2) {
	if (arg2 != 0 || arg1 != 0) {
	    int i = ((Class33_Sub7_Sub2) this).anIntArray1178[0] + arg2;
	    int i1 = ((Class33_Sub7_Sub2) this).anIntArray1179[0] + arg1;
	    if (((Class33_Sub7_Sub2) this).anInt1157 != -1
		&& (Class10.aClass10Array183
		    [((Class33_Sub7_Sub2) this).anInt1157].anInt191) <= 1)
		((Class33_Sub7_Sub2) this).anInt1157 = -1;
	    if (((Class33_Sub7_Sub2) this).anInt1177 < 9) {
		((Class33_Sub7_Sub2) this).anInt1177++;
		for (int i2 = ((Class33_Sub7_Sub2) this).anInt1177; i2 > 0;
		     i2--) {
		    ((Class33_Sub7_Sub2) this).anIntArray1178[i2]
			= ((Class33_Sub7_Sub2) this).anIntArray1178[i2 - 1];
		    ((Class33_Sub7_Sub2) this).anIntArray1179[i2]
			= ((Class33_Sub7_Sub2) this).anIntArray1179[i2 - 1];
		}
	    } else {
		for (int i3 = 8; i3 > 0; i3--) {
		    ((Class33_Sub7_Sub2) this).anIntArray1178[i3]
			= ((Class33_Sub7_Sub2) this).anIntArray1178[i3 - 1];
		    ((Class33_Sub7_Sub2) this).anIntArray1179[i3]
			= ((Class33_Sub7_Sub2) this).anIntArray1179[i3 - 1];
		}
	    }
	    ((Class33_Sub7_Sub2) this).anIntArray1178[0] = i;
	    ((Class33_Sub7_Sub2) this).anIntArray1179[0] = i1;
	    if (arg0)
		anInt1130 = -19;
	}
    }
}
