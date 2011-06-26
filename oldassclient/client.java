import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.zip.CRC32;

public final class client extends RSApplet
{
    private String[] aStringArray631 = new String[500];
    private Class33_Sub2_Sub2_Sub2[] aClass33_Sub2_Sub2_Sub2Array632
	= new Class33_Sub2_Sub2_Sub2[20];
    private boolean aBoolean633 = false;
    private int[] anIntArray634;
    private int[] anIntArray635;
    private int[] anIntArray636 = new int[151];
    private int[] anIntArray637 = new int[50];
    private Class1[] aClass1Array638 = new Class1[4];
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_639;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_640;
    static final int[] anIntArray641
	= { 9104, 10275, 7595, 3610, 7975, 8526, 918, 38802, 24466, 10145,
	    58654, 5027, 1457, 16565, 34991, 25486 };
    private static String aString642
	= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00a3$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_643;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_644;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_645;
    private boolean aBoolean646 = false;
    static int anInt647;
    private int anInt648;
    private int anInt649 = 90;
    private int anInt650;
    private Class33_Sub2_Sub2_Sub2[] aClass33_Sub2_Sub2_Sub2Array651
	= new Class33_Sub2_Sub2_Sub2[20];
    private Class33_Sub2_Sub2_Sub4 aClass33_Sub2_Sub2_Sub4_652;
    private Class33_Sub2_Sub2_Sub4 aClass33_Sub2_Sub2_Sub4_653;
    private Class33_Sub2_Sub2_Sub4 aClass33_Sub2_Sub2_Sub4_654;
    private Class33_Sub2_Sub2_Sub4 aClass33_Sub2_Sub2_Sub4_655;
    private static boolean aBoolean656;
    private int anInt657;
    private int[] anIntArray658 = new int[8];
    private int anInt659 = -1;
    private int anInt660 = -1;
    private int anInt661 = 383;
    private int anInt662;
    private int[] anIntArray663 = new int[1000];
    private int[] anIntArray664 = new int[1000];
    private static boolean aBoolean665 = true;
    private boolean aBoolean666 = false;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_667;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_668;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_669;
    private int[] anIntArray670;
    private boolean aBoolean671 = false;
    private boolean aBoolean672 = false;
    private int[][] anIntArrayArray673 = new int[104][104];
    private Class32 aClass32_674;
    private Class22 aClass22_675 = new Class22(845);
    private boolean aBoolean676 = false;
    private Class6 aClass6_677 = new Class6();
    private boolean aBoolean678 = false;
    private Class33_Sub2_Sub2_Sub2 aClass33_Sub2_Sub2_Sub2_679;
    private Class33_Sub2_Sub2_Sub2 aClass33_Sub2_Sub2_Sub2_680;
    private int anInt681;
    private int anInt682;
    private static BigInteger aBigInteger683
	= (new BigInteger
	   ("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789"));
    private static int anInt684;
    private int anInt685;
    private Class33_Sub2_Sub2_Sub3[] aClass33_Sub2_Sub2_Sub3Array686;
    private Class26 aClass26_687;
    private Class26 aClass26_688;
    private Class26 aClass26_689;
    private Class26 aClass26_690;
    private Class26 aClass26_691;
    private Class26 aClass26_692;
    private Class26 aClass26_693;
    private Class26 aClass26_694;
    private Class26 aClass26_695;
    private Class33_Sub2_Sub3 aClass33_Sub2_Sub3_696
	= Class33_Sub2_Sub3.method333(-836, 1);
    private Class22 aClass22_697 = new Class22(845);
    private int anInt698 = -1;
    private int[] anIntArray699;
    private int[] anIntArray700;
    private int[] anIntArray701;
    private int anInt702;
    private byte aByte703 = 103;
    private int anInt704 = -1;
    private byte aByte705 = 5;
    private boolean aBoolean706 = false;
    private boolean aBoolean707 = false;
    private Class33_Sub2_Sub3 aClass33_Sub2_Sub3_708
	= Class33_Sub2_Sub3.method333(-836, 1);
    private int anInt709 = -1;
    private int anInt710 = 2301979;
    private int anInt711;
    private int anInt712 = 3;
    private int anInt713;
    private int anInt714;
    private int anInt715;
    private int anInt716;
    private static boolean aBoolean717 = true;
    private int anInt718;
    private int anInt719;
    private int anInt720;
    private int anInt721;
    private int anInt722;
    String aString723;
    private boolean aBoolean724 = false;
    private boolean aBoolean725 = true;
    private int anInt726;
    private int anInt727;
    private int anInt728;
    private boolean aBoolean729 = false;
    private Class5 aClass5_730;
    private int anInt731;
    private int anInt732;
    private CRC32 aCRC32_733 = new CRC32();
    private int anInt734 = 2048;
    private int anInt735 = 2047;
    private Class33_Sub7_Sub2_Sub2[] aClass33_Sub7_Sub2_Sub2Array736
	= new Class33_Sub7_Sub2_Sub2[anInt734];
    private int anInt737;
    int[] anIntArray738 = new int[anInt734];
    private int[] anIntArray739 = new int[anInt734];
    private Class33_Sub2_Sub3[] aClass33_Sub2_Sub3Array740
	= new Class33_Sub2_Sub3[anInt734];
    private static BigInteger aBigInteger741
	= (new BigInteger
	   ("58778699976184461502525193738213253649000149147835990136706041084440742975821"));
    private int anInt742;
    private String[] aStringArray743 = new String[100];
    private int anInt744;
    private int[] anIntArray745 = new int[7];
    private int anInt746;
    private int anInt747 = 4;
    private int anInt748 = 128;
    private int anInt749;
    private int anInt750;
    private int anInt751;
    private int anInt752;
    private int anInt753;
    private int anInt754;
    private int anInt755;
    private int[][][] anIntArrayArrayArray756;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_757;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_758;
    private boolean aBoolean759 = true;
    private boolean aBoolean760 = false;
    private int anInt761;
    private int[] anIntArray762;
    private int[] anIntArray763;
    private byte[][] aByteArrayArray764;
    private int anInt765;
    private final int anInt766 = 100;
    private int[] anIntArray767 = new int[100];
    private final int[] anIntArray768 = { 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2,
					  2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };
    private int[] anIntArray769 = new int[500];
    private int[] anIntArray770 = new int[500];
    private int[] anIntArray771 = new int[500];
    private int[] anIntArray772 = new int[500];
    private byte aByte773 = 5;
    private int anInt774;
    private int[] anIntArray775 = new int[33];
    private int[][] anIntArrayArray776 = new int[104][104];
    private Class33_Sub2_Sub2_Sub2[] aClass33_Sub2_Sub2_Sub2Array777
	= new Class33_Sub2_Sub2_Sub2[50];
    private String aString778 = "";
    private String aString779 = "";
    private String aString780 = "";
    private int anInt781;
    private int anInt782 = 2;
    private int[] anIntArray783 = new int[33];
    private boolean aBoolean784 = false;
    private int[] anIntArray785 = new int[50];
    private byte[] aByteArray786 = new byte[16384];
    private Class26 aClass26_787;
    private Class26 aClass26_788;
    private Class26 aClass26_789;
    private Class26 aClass26_790;
    private int anInt791 = 3353893;
    private Class33_Sub7_Sub2_Sub2 aClass33_Sub7_Sub2_Sub2_792;
    private boolean aBoolean793 = false;
    private boolean aBoolean794 = true;
    private byte[][] aByteArrayArray795;
    private int[] anIntArray796
	= { 16776960, 16711680, 65280, 65535, 16711935, 16777215 };
    private int anInt797;
    private Class33_Sub2_Sub2_Sub2[] aClass33_Sub2_Sub2_Sub2Array798
	= new Class33_Sub2_Sub2_Sub2[1000];
    private int[] anIntArray799 = new int[256];
    private int[] anIntArray800 = new int[50];
    private int anInt801 = -958;
    private int anInt802;
    private int anInt803;
    private int anInt804 = 2;
    private Class22[][][] aClass22ArrayArrayArray805
	= new Class22[4][104][104];
    private Class27 aClass27_806;
    private int anInt807;
    private int anInt808 = 1;
    private Class33_Sub2_Sub2_Sub2 aClass33_Sub2_Sub2_Sub2_809;
    private Class33_Sub2_Sub2_Sub2 aClass33_Sub2_Sub2_Sub2_810;
    private Class33_Sub2_Sub2_Sub2 aClass33_Sub2_Sub2_Sub2_811;
    private int anInt812;
    private int anInt813;
    private int anInt814;
    private int anInt815;
    private int anInt816;
    private String aString817 = "";
    private String aString818 = "";
    private static int[] anIntArray819 = new int[99];
    private boolean aBoolean820 = true;
    private int anInt821;
    private int[] anIntArray822 = new int[5];
    private int anInt823;
    private int anInt824;
    private boolean aBoolean825 = false;
    private int anInt826;
    private int anInt827;
    private int anInt828;
    private int[] anIntArray829 = new int[100];
    private Class33_Sub2_Sub3 aClass33_Sub2_Sub3_830
	= Class33_Sub2_Sub3.method333(-836, 1);
    private long[] aLongArray831 = new long[100];
    private int anInt832;
    int[] anIntArray833 = new int[1000];
    private int anInt834;
    private int anInt835;
    private int anInt836;
    private int anInt837;
    private int anInt838;
    private int anInt839;
    private int anInt840;
    private int anInt841;
    private boolean aBoolean842 = false;
    private int anInt843 = 268;
    private boolean aBoolean844 = false;
    private int[] anIntArray845 = new int[4000];
    private int[] anIntArray846 = new int[4000];
    private int anInt847;
    private int anInt848;
    private int anInt849;
    String aString850;
    private int anInt851 = 10;
    private String[] aStringArray852 = new String[100];
    private int[] anIntArray853
	= { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    static final int[][] anIntArrayArray854;
    private Class33_Sub2_Sub2_Sub2 aClass33_Sub2_Sub2_Sub2_855;
    private Class33_Sub2_Sub2_Sub2 aClass33_Sub2_Sub2_Sub2_856;
    private int[] anIntArray857 = new int[151];
    private int anInt858;
    private byte aByte859 = -21;
    private int anInt860;
    private int anInt861 = -449;
    private Class22 aClass22_862 = new Class22(845);
    private String aString863;
    private int anInt864;
    private int anInt865;
    private int anInt866;
    private Class33_Sub2_Sub2_Sub2 aClass33_Sub2_Sub2_Sub2_867;
    private Class22 aClass22_868 = new Class22(845);
    private Class33_Sub2_Sub2_Sub2[] aClass33_Sub2_Sub2_Sub2Array869
	= new Class33_Sub2_Sub2_Sub2[8];
    private int anInt870 = -1;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_871;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_872;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_873;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_874;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_875;
    private boolean aBoolean876 = false;
    private Class26 aClass26_877;
    private Class26 aClass26_878;
    private Class26 aClass26_879;
    private String aString880 = "127.0.0.1";
    private boolean aBoolean881 = false;
    private int anInt882 = -36905;
    private int[][] anIntArrayArray883 = new int[104][104];
    private Class26 aClass26_884;
    private Class26 aClass26_885;
    private Class26 aClass26_886;
    private Class26 aClass26_887;
    private Class26 aClass26_888;
    private Class26 aClass26_889;
    private Class26 aClass26_890;
    private Class26 aClass26_891;
    private Class26 aClass26_892;
    private Class26 aClass26_893;
    private boolean aBoolean894 = false;
    private int anInt895 = 7759444;
    private Class33_Sub2_Sub2_Sub3[] aClass33_Sub2_Sub2_Sub3Array896
	= new Class33_Sub2_Sub2_Sub3[50];
    private Class22 aClass22_897 = new Class22(845);
    private String aString898 = "";
    private String aString899 = "";
    private String aString900 = "";
    private boolean aBoolean901 = false;
    static int anInt902;
    private byte[][][] aByteArrayArrayArray903;
    private int anInt904;
    private int anInt905;
    private int anInt906;
    private int anInt907;
    private int anInt908;
    private int anInt909 = 5063219;
    private int[] anIntArray910;
    private int[] anIntArray911;
    private int[] anIntArray912;
    private int[] anIntArray913;
    private int anInt914 = 78;
    private String aString915 = "";
    private boolean aBoolean916 = false;
    private int anInt917 = -1;
    private int anInt918;
    private int anInt919;
    private Class34 aClass34_920;
    private int anInt921;
    private int anInt922;
    private int anInt923;
    private int anInt924;
    private int anInt925;
    private int anInt926;
    private int anInt927;
    private int anInt928;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_929;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_930;
    private String[] aStringArray931 = new String[100];
    private Class33_Sub2_Sub2_Sub2 aClass33_Sub2_Sub2_Sub2_932;
    private boolean aBoolean933 = false;
    private Class33_Sub7_Sub2_Sub1[] aClass33_Sub7_Sub2_Sub1Array934
	= new Class33_Sub7_Sub2_Sub1[8192];
    private int anInt935;
    int[] anIntArray936 = new int[8192];
    private int[] anIntArray937 = new int[2000];
    private int[] anIntArray938 = new int[100];
    private long aLong939;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_940;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_941;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_942;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_943;
    private Class33_Sub2_Sub2_Sub3 aClass33_Sub2_Sub2_Sub3_944;
    private int anInt945;
    private int anInt946 = -12807;
    
    public static final void main(String[] arg0) {
	try {
	    signlink.startpriv(InetAddress.getLocalHost());
	    client var_client = new client();
	    if (arg0.length > 0)
		var_client.anInt851 = Integer.parseInt(arg0[0]);
	    if (arg0.length > 1)
		var_client.anInt840 = Integer.parseInt(arg0[1]);
	    if (arg0.length > 2 && arg0[2].equalsIgnoreCase("lowmem"))
		method14(0);
	    else
		method15(216);
	    var_client.method1(532, (byte) 4, 789);
	} catch (Exception exception) {
	}
    }
    
    public final void init() {
	anInt840 = Integer.parseInt(getParameter("portoff"));
	anInt851 = Integer.parseInt(getParameter("nodeid"));
	String string = getParameter("lowmem");
	if (string != null && string.equals("1"))
	    method14(0);
	else
	    method15(216);
	this.method2(532, (byte) 104, 789);
    }
    
    public static final void method14(int arg0) {
	Class27.aBoolean371 = true;
	Class33_Sub2_Sub2_Sub1.aBoolean1209 = true;
	if (arg0 != 0)
	    anInt684 = -45;
	aBoolean665 = true;
	Class3.aBoolean59 = true;
    }
    
    public static final void method15(int arg0) {
	arg0 = 50 / arg0;
	Class27.aBoolean371 = false;
	Class33_Sub2_Sub2_Sub1.aBoolean1209 = false;
	aBoolean665 = false;
	Class3.aBoolean59 = false;
    }
    
    public final void startUp() {
	if (signlink.sunjava)
	    minDelay = 5;
	signlink.midi = "scape_main";
	if (aBoolean656)
	    aBoolean706 = true;
	else {
	    aBoolean656 = true;
	    boolean flag = false;
	    String string = method86(0);
	    if (string.endsWith("jagex.com"))
		flag = true;
	    if (string.endsWith("runescape.com"))
		flag = true;
	    if (string.endsWith("192.168.1.252"))
		flag = true;
	    if (string.endsWith("192.168.1.2"))
		flag = true;
	    if (string.endsWith("69.1.68.43"))
		flag = true;
	    if (string.endsWith("127.0.0.1"))
		flag = true;
	    if (!flag)
		aBoolean933 = true;
	    else {
		try {
		    int i = 5;
		    anIntArray658[7] = 0;
		    while (anIntArray658[7] == 0) {
			drawLoadingText("Connecting to fileserver", 10, false);
			try {
			    DataInputStream datainputstream
				= method87("crc" + (int) (Math.random()
							  * 9.9999999E7));
			    Class33_Sub2_Sub3 class33_sub2_sub3
				= new Class33_Sub2_Sub3(new byte[32],
							(byte) 63);
			    datainputstream.readFully((class33_sub2_sub3
						       .aByteArray1107),
						      0, 32);
			    for (int i1 = 0; i1 < 8; i1++)
				anIntArray658[i1]
				    = class33_sub2_sub3.method347();
			    datainputstream.close();
			} catch (IOException ioexception) {
			    for (int i2 = i; i2 > 0; i2--) {
				drawLoadingText(("Error loading - Will retry in " + i2
					  + " secs."),
					 10, false);
				try {
				    Thread.sleep(1000L);
				} catch (Exception exception) {
				}
			    }
			    i *= 2;
			    if (i > 60)
				i = 60;
			}
		    }
		    aClass34_920 = method16("title", 5, "title screen", 10,
					    anIntArray658[1]);
		    aClass33_Sub2_Sub2_Sub4_652
			= new Class33_Sub2_Sub2_Sub4("p11", aClass34_920,
						     false);
		    aClass33_Sub2_Sub2_Sub4_653
			= new Class33_Sub2_Sub2_Sub4("p12", aClass34_920,
						     false);
		    aClass33_Sub2_Sub2_Sub4_654
			= new Class33_Sub2_Sub2_Sub4("b12", aClass34_920,
						     false);
		    aClass33_Sub2_Sub2_Sub4_655
			= new Class33_Sub2_Sub2_Sub4("q8", aClass34_920,
						     false);
		    method17(5);
		    method22(aBoolean717);
		    Class34 class34 = method16("config", 5, "config", 20,
					       anIntArray658[2]);
		    Class34 class34_3 = method16("interface", 5, "interface",
						 30, anIntArray658[3]);
		    Class34 class34_4 = method16("media", 5, "2d graphics", 40,
						 anIntArray658[4]);
		    Class34 class34_5 = method16("models", 5, "3d graphics",
						 50, anIntArray658[5]);
		    Class34 class34_6 = method16("textures", 5, "textures", 60,
						 anIntArray658[6]);
		    Class34 class34_7 = method16("wordenc", 5, "chat system",
						 70, anIntArray658[7]);
		    aByteArrayArrayArray903 = new byte[4][104][104];
		    anIntArrayArrayArray756 = new int[4][105][105];
		    aClass27_806 = new Class27(4, anIntArrayArrayArray756, 104,
					       (byte) 4, 104);
		    for (int i8 = 0; i8 < 4; i8++)
			aClass1Array638[i8] = new Class1(104, -242, 104);
		    aClass33_Sub2_Sub2_Sub2_932
			= new Class33_Sub2_Sub2_Sub2(512, 512, 0);
		    drawLoadingText("Unpacking media", 80, false);
		    aClass33_Sub2_Sub2_Sub3_643
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "invback",
						     0);
		    aClass33_Sub2_Sub2_Sub3_645
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "chatback",
						     0);
		    aClass33_Sub2_Sub2_Sub3_644
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "mapback",
						     0);
		    aClass33_Sub2_Sub2_Sub3_667
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "backbase1",
						     0);
		    aClass33_Sub2_Sub2_Sub3_668
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "backbase2",
						     0);
		    aClass33_Sub2_Sub2_Sub3_669
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "backhmid1",
						     0);
		    aClass33_Sub2_Sub2_Sub3_929
			= new Class33_Sub2_Sub2_Sub3(0, class34_4,
						     "sideicons1", 0);
		    aClass33_Sub2_Sub2_Sub3_930
			= new Class33_Sub2_Sub2_Sub3(0, class34_4,
						     "sideicons2", 0);
		    aClass33_Sub2_Sub2_Sub2_867
			= new Class33_Sub2_Sub2_Sub2("compass", 154, 0,
						     class34_4);
		    try {
			for (int i9 = 0; i9 < 50; i9++)
			    aClass33_Sub2_Sub2_Sub3Array896[i9]
				= new Class33_Sub2_Sub2_Sub3(0, class34_4,
							     "mapscene", i9);
		    } catch (Exception exception) {
		    }
		    try {
			for (int i10 = 0; i10 < 50; i10++)
			    aClass33_Sub2_Sub2_Sub2Array777[i10]
				= new Class33_Sub2_Sub2_Sub2("mapfunction",
							     154, i10,
							     class34_4);
		    } catch (Exception exception) {
		    }
		    try {
			for (int i11 = 0; i11 < 20; i11++)
			    aClass33_Sub2_Sub2_Sub2Array651[i11]
				= new Class33_Sub2_Sub2_Sub2("hitmarks", 154,
							     i11, class34_4);
		    } catch (Exception exception) {
		    }
		    try {
			for (int i12 = 0; i12 < 20; i12++)
			    aClass33_Sub2_Sub2_Sub2Array632[i12]
				= new Class33_Sub2_Sub2_Sub2("headicons", 154,
							     i12, class34_4);
		    } catch (Exception exception) {
		    }
		    for (int i13 = 0; i13 < 8; i13++)
			aClass33_Sub2_Sub2_Sub2Array869[i13]
			    = new Class33_Sub2_Sub2_Sub2("cross", 154, i13,
							 class34_4);
		    aClass33_Sub2_Sub2_Sub2_809
			= new Class33_Sub2_Sub2_Sub2("mapdots", 154, 0,
						     class34_4);
		    aClass33_Sub2_Sub2_Sub2_810
			= new Class33_Sub2_Sub2_Sub2("mapdots", 154, 1,
						     class34_4);
		    aClass33_Sub2_Sub2_Sub2_811
			= new Class33_Sub2_Sub2_Sub2("mapdots", 154, 2,
						     class34_4);
		    aClass33_Sub2_Sub2_Sub3_639
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "scrollbar",
						     0);
		    aClass33_Sub2_Sub2_Sub3_640
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "scrollbar",
						     1);
		    aClass33_Sub2_Sub2_Sub3_940
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "redstone1",
						     0);
		    aClass33_Sub2_Sub2_Sub3_941
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "redstone2",
						     0);
		    aClass33_Sub2_Sub2_Sub3_942
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "redstone3",
						     0);
		    aClass33_Sub2_Sub2_Sub3_943
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "redstone1",
						     0);
		    aClass33_Sub2_Sub2_Sub3_943.method321(5);
		    aClass33_Sub2_Sub2_Sub3_944
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "redstone2",
						     0);
		    aClass33_Sub2_Sub2_Sub3_944.method321(5);
		    aClass33_Sub2_Sub2_Sub3_871
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "redstone1",
						     0);
		    aClass33_Sub2_Sub2_Sub3_871.method322(409);
		    aClass33_Sub2_Sub2_Sub3_872
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "redstone2",
						     0);
		    aClass33_Sub2_Sub2_Sub3_872.method322(409);
		    aClass33_Sub2_Sub2_Sub3_873
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "redstone3",
						     0);
		    aClass33_Sub2_Sub2_Sub3_873.method322(409);
		    aClass33_Sub2_Sub2_Sub3_874
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "redstone1",
						     0);
		    aClass33_Sub2_Sub2_Sub3_874.method321(5);
		    aClass33_Sub2_Sub2_Sub3_874.method322(409);
		    aClass33_Sub2_Sub2_Sub3_875
			= new Class33_Sub2_Sub2_Sub3(0, class34_4, "redstone2",
						     0);
		    aClass33_Sub2_Sub2_Sub3_875.method321(5);
		    aClass33_Sub2_Sub2_Sub3_875.method322(409);
		    Class33_Sub2_Sub2_Sub2 class33_sub2_sub2_sub2
			= new Class33_Sub2_Sub2_Sub2("backleft1", 154, 0,
						     class34_4);
		    aClass26_884
			= new Class26(class33_sub2_sub2_sub2.anInt1238, 604,
				      class33_sub2_sub2_sub2.anInt1237,
				      getGameComponent((byte) 8));
		    class33_sub2_sub2_sub2.method310(false, 0, 0);
		    class33_sub2_sub2_sub2
			= new Class33_Sub2_Sub2_Sub2("backleft2", 154, 0,
						     class34_4);
		    aClass26_885
			= new Class26(class33_sub2_sub2_sub2.anInt1238, 604,
				      class33_sub2_sub2_sub2.anInt1237,
				      getGameComponent((byte) 8));
		    class33_sub2_sub2_sub2.method310(false, 0, 0);
		    class33_sub2_sub2_sub2
			= new Class33_Sub2_Sub2_Sub2("backright1", 154, 0,
						     class34_4);
		    aClass26_886
			= new Class26(class33_sub2_sub2_sub2.anInt1238, 604,
				      class33_sub2_sub2_sub2.anInt1237,
				      getGameComponent((byte) 8));
		    class33_sub2_sub2_sub2.method310(false, 0, 0);
		    class33_sub2_sub2_sub2
			= new Class33_Sub2_Sub2_Sub2("backright2", 154, 0,
						     class34_4);
		    aClass26_887
			= new Class26(class33_sub2_sub2_sub2.anInt1238, 604,
				      class33_sub2_sub2_sub2.anInt1237,
				      getGameComponent((byte) 8));
		    class33_sub2_sub2_sub2.method310(false, 0, 0);
		    class33_sub2_sub2_sub2
			= new Class33_Sub2_Sub2_Sub2("backtop1", 154, 0,
						     class34_4);
		    aClass26_888
			= new Class26(class33_sub2_sub2_sub2.anInt1238, 604,
				      class33_sub2_sub2_sub2.anInt1237,
				      getGameComponent((byte) 8));
		    class33_sub2_sub2_sub2.method310(false, 0, 0);
		    class33_sub2_sub2_sub2
			= new Class33_Sub2_Sub2_Sub2("backtop2", 154, 0,
						     class34_4);
		    aClass26_889
			= new Class26(class33_sub2_sub2_sub2.anInt1238, 604,
				      class33_sub2_sub2_sub2.anInt1237,
				      getGameComponent((byte) 8));
		    class33_sub2_sub2_sub2.method310(false, 0, 0);
		    class33_sub2_sub2_sub2
			= new Class33_Sub2_Sub2_Sub2("backvmid1", 154, 0,
						     class34_4);
		    aClass26_890
			= new Class26(class33_sub2_sub2_sub2.anInt1238, 604,
				      class33_sub2_sub2_sub2.anInt1237,
				      getGameComponent((byte) 8));
		    class33_sub2_sub2_sub2.method310(false, 0, 0);
		    class33_sub2_sub2_sub2
			= new Class33_Sub2_Sub2_Sub2("backvmid2", 154, 0,
						     class34_4);
		    aClass26_891
			= new Class26(class33_sub2_sub2_sub2.anInt1238, 604,
				      class33_sub2_sub2_sub2.anInt1237,
				      getGameComponent((byte) 8));
		    class33_sub2_sub2_sub2.method310(false, 0, 0);
		    class33_sub2_sub2_sub2
			= new Class33_Sub2_Sub2_Sub2("backvmid3", 154, 0,
						     class34_4);
		    aClass26_892
			= new Class26(class33_sub2_sub2_sub2.anInt1238, 604,
				      class33_sub2_sub2_sub2.anInt1237,
				      getGameComponent((byte) 8));
		    class33_sub2_sub2_sub2.method310(false, 0, 0);
		    class33_sub2_sub2_sub2
			= new Class33_Sub2_Sub2_Sub2("backhmid2", 154, 0,
						     class34_4);
		    aClass26_893
			= new Class26(class33_sub2_sub2_sub2.anInt1238, 604,
				      class33_sub2_sub2_sub2.anInt1237,
				      getGameComponent((byte) 8));
		    class33_sub2_sub2_sub2.method310(false, 0, 0);
		    drawLoadingText("Unpacking textures", 85, false);
		    Class33_Sub2_Sub2_Sub1.method297(-377, class34_6);
		    Class33_Sub2_Sub2_Sub1.method301(-217, 0.8);
		    Class33_Sub2_Sub2_Sub1.method296(20, (byte) 2);
		    drawLoadingText("Unpacking models", 85, false);
		    Class33_Sub2_Sub1.method261(class34_5, 0);
		    Class7.method134((byte) 4, class34_5);
		    Class9.method135((byte) 4, class34_5);
		    drawLoadingText("Unpacking config", 85, false);
		    Class10.method136(class34, -47511);
		    Class37.method381(class34);
		    Class2.method104(class34, -47511);
		    Class39.method393(class34);
		    Class38.method387(class34);
		    Class4.method121(class34, -47511);
		    Class12.method138(class34, -47511);
		    Class14.method141(class34, -47511);
		    drawLoadingText("Unpacking interfaces", 90, false);
		    Class33_Sub2_Sub2_Sub4[] class33_sub2_sub2_sub4s
			= { aClass33_Sub2_Sub2_Sub4_652,
			    aClass33_Sub2_Sub2_Sub4_653,
			    aClass33_Sub2_Sub2_Sub4_654,
			    aClass33_Sub2_Sub2_Sub4_655 };
		    Class6.method130(class33_sub2_sub2_sub4s, class34_4,
				     (byte) -60, class34_3);
		    drawLoadingText("Preparing game engine", 95, false);
		    for (int i14 = 0; i14 < 33; i14++) {
			int i15 = 999;
			int i16 = 0;
			for (int i17 = 0; i17 < 35; i17++) {
			    if ((aClass33_Sub2_Sub2_Sub3_644.aByteArray1246
				 [i17 + i14 * (aClass33_Sub2_Sub2_Sub3_644
					       .anInt1248)])
				== 0) {
				if (i15 == 999)
				    i15 = i17;
			    } else if (i15 != 999) {
				i16 = i17;
				break;
			    }
			}
			anIntArray775[i14] = i15;
			anIntArray783[i14] = i16 - i15;
		    }
		    for (int i18 = 9; i18 < 160; i18++) {
			int i19 = 999;
			int i20 = 0;
			for (int i21 = 10; i21 < 168; i21++) {
			    if ((aClass33_Sub2_Sub2_Sub3_644.aByteArray1246
				 [i21 + i18 * (aClass33_Sub2_Sub2_Sub3_644
					       .anInt1248)]) == 0
				&& (i21 > 34 || i18 > 34)) {
				if (i19 == 999)
				    i19 = i21;
			    } else if (i19 != 999) {
				i20 = i21;
				break;
			    }
			}
			anIntArray857[i18 - 9] = i19 - 21;
			anIntArray636[i18 - 9] = i20 - i19;
		    }
		    Class33_Sub2_Sub2_Sub1.method294(479, 96, (byte) -44);
		    anIntArray699 = Class33_Sub2_Sub2_Sub1.anIntArray1220;
		    Class33_Sub2_Sub2_Sub1.method294(190, 261, (byte) -44);
		    anIntArray700 = Class33_Sub2_Sub2_Sub1.anIntArray1220;
		    Class33_Sub2_Sub2_Sub1.method294(512, 334, (byte) -44);
		    anIntArray701 = Class33_Sub2_Sub2_Sub1.anIntArray1220;
		    int[] ints = new int[9];
		    for (int i22 = 0; i22 < 9; i22++) {
			int i23 = i22 * 32 + 128 + 15;
			int i24 = i23 * 3 + 600;
			int i25 = Class33_Sub2_Sub2_Sub1.anIntArray1218[i23];
			ints[i22] = i24 * i25 >> 16;
		    }
		    Class27.method227(0, 334, 512, 800, ints, 500);
		    Class16.method143(class34_7);
		} catch (Exception exception) {
		    aBoolean901 = true;
		}
	    }
	}
    }
    
    public final Class34 method16(String arg0, int arg1, String arg2, int arg3,
				  int arg4) {
	int i = 5;
	byte[] bytes = signlink.cacheload(arg0);
	if (arg1 < 5 || arg1 > 5) {
	    for (int i1 = 1; i1 > 0; i1++) {
	    }
	}
	if (bytes != null) {
	    aCRC32_733.reset();
	    aCRC32_733.update(bytes);
	    int i2 = (int) aCRC32_733.getValue();
	    if (i2 != arg4)
		bytes = null;
	}
	if (bytes != null) {
	    Class34 class34 = new Class34(bytes, 969);
	    return class34;
	}
	while (bytes == null) {
	    drawLoadingText("Requesting " + arg2, arg3, false);
	    try {
		int i3 = 0;
		DataInputStream datainputstream = method87(arg0 + arg4);
		byte[] bytes4 = new byte[6];
		datainputstream.readFully(bytes4, 0, 6);
		Class33_Sub2_Sub3 class33_sub2_sub3
		    = new Class33_Sub2_Sub3(bytes4, (byte) 63);
		class33_sub2_sub3.anInt1108 = 3;
		int i5 = class33_sub2_sub3.method346() + 6;
		int i6 = 6;
		bytes = new byte[i5];
		for (int i7 = 0; i7 < 6; i7++)
		    bytes[i7] = bytes4[i7];
		while (i6 < i5) {
		    int i8 = i5 - i6;
		    if (i8 > 1000)
			i8 = 1000;
		    i6 += datainputstream.read(bytes, i6, i8);
		    int i9 = i6 * 100 / i5;
		    if (i9 != i3)
			drawLoadingText("Loading " + arg2 + " - " + i9 + "%", arg3,
				 false);
		    i3 = i9;
		}
		datainputstream.close();
	    } catch (IOException ioexception) {
		bytes = null;
		for (int i10 = i; i10 > 0; i10--) {
		    drawLoadingText("Error loading - Will retry in " + i10 + " secs.",
			     arg3, false);
		    try {
			Thread.sleep(1000L);
		    } catch (Exception exception) {
		    }
		}
		i *= 2;
		if (i > 60)
		    i = 60;
	    }
	}
	signlink.cachesave(arg0, bytes);
	Class34 class34 = new Class34(bytes, 969);
	return class34;
    }
    
    public final void method17(int arg0) {
	byte[] bytes = aClass34_920.method371(0, null, "title.dat");
	Class33_Sub2_Sub2_Sub2 class33_sub2_sub2_sub2
	    = new Class33_Sub2_Sub2_Sub2(bytes, this, 0);
	aClass26_690.method190(0);
	class33_sub2_sub2_sub2.method310(false, 0, 0);
	aClass26_691.method190(0);
	class33_sub2_sub2_sub2.method310(false, 0, -661);
	aClass26_687.method190(0);
	class33_sub2_sub2_sub2.method310(false, 0, -128);
	if (arg0 != 5)
	    startUp();
	aClass26_688.method190(0);
	class33_sub2_sub2_sub2.method310(false, -386, -214);
	aClass26_689.method190(0);
	class33_sub2_sub2_sub2.method310(false, -186, -214);
	aClass26_692.method190(0);
	class33_sub2_sub2_sub2.method310(false, -265, 0);
	aClass26_693.method190(0);
	class33_sub2_sub2_sub2.method310(false, -265, -574);
	aClass26_694.method190(0);
	class33_sub2_sub2_sub2.method310(false, -186, -128);
	aClass26_695.method190(0);
	class33_sub2_sub2_sub2.method310(false, -186, -574);
	int[] ints = new int[class33_sub2_sub2_sub2.anInt1237];
	for (int i = 0; i < class33_sub2_sub2_sub2.anInt1238; i++) {
	    for (int i1 = 0; i1 < class33_sub2_sub2_sub2.anInt1237; i1++)
		ints[i1] = (class33_sub2_sub2_sub2.anIntArray1236
			    [(class33_sub2_sub2_sub2.anInt1237 - i1 - 1
			      + class33_sub2_sub2_sub2.anInt1237 * i)]);
	    for (int i2 = 0; i2 < class33_sub2_sub2_sub2.anInt1237; i2++)
		class33_sub2_sub2_sub2.anIntArray1236
		    [i2 + class33_sub2_sub2_sub2.anInt1237 * i]
		    = ints[i2];
	}
	aClass26_690.method190(0);
	class33_sub2_sub2_sub2.method310(false, 0, 394);
	aClass26_691.method190(0);
	class33_sub2_sub2_sub2.method310(false, 0, -267);
	aClass26_687.method190(0);
	class33_sub2_sub2_sub2.method310(false, 0, 266);
	aClass26_688.method190(0);
	class33_sub2_sub2_sub2.method310(false, -386, 180);
	aClass26_689.method190(0);
	class33_sub2_sub2_sub2.method310(false, -186, 180);
	aClass26_692.method190(0);
	class33_sub2_sub2_sub2.method310(false, -265, 394);
	aClass26_693.method190(0);
	class33_sub2_sub2_sub2.method310(false, -265, -180);
	aClass26_694.method190(0);
	class33_sub2_sub2_sub2.method310(false, -186, 212);
	aClass26_695.method190(0);
	class33_sub2_sub2_sub2.method310(false, -186, -180);
	class33_sub2_sub2_sub2
	    = new Class33_Sub2_Sub2_Sub2("logo", 154, 0, aClass34_920);
	aClass26_687.method190(0);
	class33_sub2_sub2_sub2.method312(anInt11 / 2 - (class33_sub2_sub2_sub2
							.anInt1237) / 2 - 128,
					 true, 18);
	Object object = null;
	Object object3 = null;
	Object object4 = null;
	System.gc();
    }
    
    public final void drawLoadingText(String arg0, int arg1, boolean arg2) {
	method20(-905);
	if (aClass34_920 == null)
	    super.drawLoadingText(arg0, arg1, false);
	else {
	    aClass26_689.method190(0);
	    if (arg2)
		anInt684 = aClass32_674.method255();
	    int i = 360;
	    int i1 = 200;
	    int i2 = 20;
	    aClass33_Sub2_Sub2_Sub4_654.method325
		(i1 / 2 - 26 - i2, aBoolean876, i / 2, 16777215,
		 "RuneScape is loading - please wait...");
	    int i3 = i1 / 2 - 18 - i2;
	    Class33_Sub2_Sub2.method289(304, 34, i / 2 - 152, i3, true,
					9179409);
	    Class33_Sub2_Sub2.method289(302, 32, i / 2 - 151, i3 + 1, true, 0);
	    Class33_Sub2_Sub2.method288(9179409, arg1 * 3, i3 + 2, false, 30,
					i / 2 - 150);
	    Class33_Sub2_Sub2.method288(0, 300 - arg1 * 3, i3 + 2, false, 30,
					i / 2 - 150 + arg1 * 3);
	    aClass33_Sub2_Sub2_Sub4_654.method325(i1 / 2 + 5 - i2, aBoolean876,
						  i / 2, 16777215, arg0);
	    aClass26_689.method191(aGraphics13, 214, 186);
	    if (aBoolean844) {
		aBoolean844 = false;
		if (!aBoolean724) {
		    aClass26_690.method191(aGraphics13, 0, 0);
		    aClass26_691.method191(aGraphics13, 661, 0);
		}
		aClass26_687.method191(aGraphics13, 128, 0);
		aClass26_688.method191(aGraphics13, 214, 386);
		aClass26_692.method191(aGraphics13, 0, 265);
		aClass26_693.method191(aGraphics13, 574, 265);
		aClass26_694.method191(aGraphics13, 128, 186);
		aClass26_695.method191(aGraphics13, 574, 186);
	    }
	}
    }
    
    public final void method7(int arg0) {
	if (!aBoolean706 && !aBoolean901 && !aBoolean933) {
	    anInt647++;
	    if (arg0 != 0)
		aClass22ArrayArrayArray805 = null;
	    if (!aBoolean825)
		method21(0);
	    else
		method34(4);
	}
    }
    
    public final void method9(int arg0) {
	if (arg0 < 4 || arg0 > 4)
	    anInt684 = -280;
	if (aBoolean706 || aBoolean901 || aBoolean933)
	    method18(aByte703);
	else {
	    if (!aBoolean825)
		method28(true);
	    else
		method36(anInt797);
	    anInt904 = 0;
	}
    }
    
    public final void method18(byte arg0) {
	Graphics graphics = getGameComponent((byte) 8).getGraphics();
	graphics.setColor(Color.black);
	if (arg0 != 103) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	graphics.fillRect(0, 0, 789, 532);
	this.method4(1, 0);
	if (aBoolean901) {
	    aBoolean724 = false;
	    graphics.setFont(new Font("Helvetica", 1, 16));
	    graphics.setColor(Color.yellow);
	    int i = 35;
	    graphics.drawString
		("Sorry, an error has occured whilst loading RuneScape", 30,
		 i);
	    i += 50;
	    graphics.setColor(Color.white);
	    graphics.drawString("To fix this try the following (in order):",
				30, i);
	    i += 50;
	    graphics.setColor(Color.white);
	    graphics.setFont(new Font("Helvetica", 1, 12));
	    graphics.drawString
		("1: Try closing ALL open web-browser windows, and reloading",
		 30, i);
	    i += 30;
	    graphics.drawString
		("2: Try clearing your web-browsers cache from tools->internet options",
		 30, i);
	    i += 30;
	    graphics.drawString("3: Try using a different game-world", 30, i);
	    i += 30;
	    graphics.drawString("4: Try rebooting your computer", 30, i);
	    i += 30;
	    graphics.drawString
		("5: Try selecting a different version of Java from the play-game menu",
		 30, i);
	}
	if (aBoolean933) {
	    aBoolean724 = false;
	    graphics.setFont(new Font("Helvetica", 1, 20));
	    graphics.setColor(Color.white);
	    graphics.drawString("Error - unable to load game!", 50, 50);
	    graphics.drawString("To play RuneScape make sure you play from",
				50, 100);
	    graphics.drawString("http://www.runescape.com", 50, 150);
	}
	if (aBoolean706) {
	    aBoolean724 = false;
	    graphics.setColor(Color.yellow);
	    int i = 35;
	    graphics.drawString
		("Error a copy of RuneScape already appears to be loaded", 30,
		 i);
	    i += 50;
	    graphics.setColor(Color.white);
	    graphics.drawString("To fix this try the following (in order):",
				30, i);
	    i += 50;
	    graphics.setColor(Color.white);
	    graphics.setFont(new Font("Helvetica", 1, 12));
	    graphics.drawString
		("1: Try closing ALL open web-browser windows, and reloading",
		 30, i);
	    i += 30;
	    graphics.drawString
		("2: Try rebooting your computer, and reloading", 30, i);
	    i += 30;
	}
    }
    
    public final void raiseWelcomeSceen(int arg0) {
	aBoolean844 = true;
	if (arg0 >= 0)
	    aBoolean876 = !aBoolean876;
    }
    
    public final void method19(byte arg0) {
	if (aClass26_790 == null) {
	    method23(0);
	    aClass26_14 = null;
	    aClass26_687 = null;
	    aClass26_688 = null;
	    aClass26_689 = null;
	    aClass26_690 = null;
	    aClass26_691 = null;
	    aClass26_692 = null;
	    aClass26_693 = null;
	    if (arg0 != 109)
		anInt797 = aClass32_674.method255();
	    aClass26_694 = null;
	    aClass26_695 = null;
	    aClass26_790 = new Class26(96, 604, 479, getGameComponent((byte) 8));
	    aClass26_788 = new Class26(160, 604, 168, getGameComponent((byte) 8));
	    Class33_Sub2_Sub2.method287(2);
	    aClass33_Sub2_Sub2_Sub3_644.method323(0, true, 0);
	    aClass26_787 = new Class26(261, 604, 190, getGameComponent((byte) 8));
	    aClass26_789 = new Class26(334, 604, 512, getGameComponent((byte) 8));
	    Class33_Sub2_Sub2.method287(2);
	    aClass26_877 = new Class26(61, 604, 501, getGameComponent((byte) 8));
	    aClass26_878 = new Class26(40, 604, 288, getGameComponent((byte) 8));
	    aClass26_879 = new Class26(66, 604, 269, getGameComponent((byte) 8));
	    aBoolean844 = true;
	}
    }
    
    public final void method20(int arg0) {
	if (aClass26_687 == null) {
	    aClass26_14 = null;
	    aClass26_790 = null;
	    aClass26_788 = null;
	    aClass26_787 = null;
	    aClass26_789 = null;
	    aClass26_877 = null;
	    aClass26_878 = null;
	    aClass26_879 = null;
	    aClass26_690 = new Class26(265, 604, 128, getGameComponent((byte) 8));
	    Class33_Sub2_Sub2.method287(2);
	    aClass26_691 = new Class26(265, 604, 128, getGameComponent((byte) 8));
	    Class33_Sub2_Sub2.method287(2);
	    aClass26_687 = new Class26(186, 604, 533, getGameComponent((byte) 8));
	    Class33_Sub2_Sub2.method287(2);
	    aClass26_688 = new Class26(146, 604, 360, getGameComponent((byte) 8));
	    if (arg0 < 0) {
		Class33_Sub2_Sub2.method287(2);
		aClass26_689 = new Class26(200, 604, 360, getGameComponent((byte) 8));
		Class33_Sub2_Sub2.method287(2);
		aClass26_692 = new Class26(267, 604, 214, getGameComponent((byte) 8));
		Class33_Sub2_Sub2.method287(2);
		aClass26_693 = new Class26(267, 604, 215, getGameComponent((byte) 8));
		Class33_Sub2_Sub2.method287(2);
		aClass26_694 = new Class26(79, 604, 86, getGameComponent((byte) 8));
		Class33_Sub2_Sub2.method287(2);
		aClass26_695 = new Class26(79, 604, 87, getGameComponent((byte) 8));
		Class33_Sub2_Sub2.method287(2);
		if (aClass34_920 != null) {
		    method17(5);
		    method22(aBoolean717);
		}
		aBoolean844 = true;
	    }
	}
    }
    
    public final void method21(int arg0) {
	anInt713 += arg0;
	if (anInt685 == 0) {
	    int i = anInt11 / 2;
	    int i1 = anInt12 / 2 + 90;
	    if (clickMode1 == 1 && clickX >= i - 75 && clickX <= i + 75
		&& clickY >= i1 - 20 && clickY <= i1 + 20) {
		aString898 = "";
		aString899 = "Enter your username & password.";
		anInt685 = 2;
		anInt860 = 0;
	    }
	} else if (anInt685 == 1 || anInt685 == 2) {
	    int i = anInt12 / 2 - 30;
	    i += 30;
	    if (clickMode1 == 1 && clickY >= i - 15 && clickY < i)
		anInt860 = 0;
	    i += 15;
	    if (clickMode1 == 1 && clickY >= i - 15 && clickY < i)
		anInt860 = 1;
	    i += 15;
	    if (clickMode1 == 1 && clickY >= i - 15 && clickY < i
		&& anInt685 == 1)
		anInt860 = 2;
	    int i2 = anInt11 / 2 - 80;
	    int i3 = anInt12 / 2 + 60;
	    if (clickMode1 == 1 && clickX >= i2 - 75 && clickX <= i2 + 75
		&& clickY >= i3 - 20 && clickY <= i3 + 20) {
		if (anInt685 == 1)
		    method30(method85(314), aString778, aString779, 0);
		else
		    method29(aString778, aString779, (byte) 12, method85(314),
			     false);
	    }
	    i2 = anInt11 / 2 + 80;
	    if (clickMode1 == 1 && clickX >= i2 - 75 && clickX <= i2 + 75
		&& clickY >= i3 - 20 && clickY <= i3 + 20)
		anInt685 = 0;
	    for (;;) {
		int i4 = this.readChar(false);
		if (i4 == -1)
		    break;
		boolean flag = false;
		for (int i5 = 0; i5 < aString642.length(); i5++) {
		    if (i4 == aString642.charAt(i5)) {
			flag = true;
			break;
		    }
		}
		if (anInt860 == 0) {
		    if (i4 == 8 && aString778.length() > 0)
			aString778
			    = aString778.substring(0, aString778.length() - 1);
		    if (i4 == 9 || i4 == 10 || i4 == 13)
			anInt860 = 1;
		    if (flag)
			aString778 += (char) i4;
		    if (aString778.length() > 12)
			aString778 = aString778.substring(0, 12);
		} else if (anInt860 == 1) {
		    if (i4 == 8 && aString779.length() > 0)
			aString779
			    = aString779.substring(0, aString779.length() - 1);
		    if (i4 == 9 || i4 == 10 || i4 == 13) {
			if (anInt685 == 1)
			    anInt860 = 2;
			else
			    anInt860 = 0;
		    }
		    if (flag)
			aString779 += (char) i4;
		    if (aString779.length() > 20)
			aString779 = aString779.substring(0, 20);
		} else if (anInt860 == 2) {
		    if (i4 == 8 && aString780.length() > 0)
			aString780
			    = aString780.substring(0, aString780.length() - 1);
		    if (i4 == 9 || i4 == 10 || i4 == 13)
			anInt860 = 0;
		    if (flag)
			aString780 += (char) i4;
		    if (aString780.length() > 20)
			aString780 = aString780.substring(0, 20);
		}
	    }
	}
    }
    
    public final void method22(boolean arg0) {
	aClass33_Sub2_Sub2_Sub3_757
	    = new Class33_Sub2_Sub2_Sub3(0, aClass34_920, "titlebox", 0);
	aClass33_Sub2_Sub2_Sub3_758
	    = new Class33_Sub2_Sub2_Sub3(0, aClass34_920, "titlebutton", 0);
	aClass33_Sub2_Sub2_Sub3Array686 = new Class33_Sub2_Sub2_Sub3[12];
	aBoolean825 &= arg0;
	for (int i = 0; i < 12; i++)
	    aClass33_Sub2_Sub2_Sub3Array686[i]
		= new Class33_Sub2_Sub2_Sub3(0, aClass34_920, "runes", i);
	aClass33_Sub2_Sub2_Sub2_679 = new Class33_Sub2_Sub2_Sub2(128, 265, 0);
	aClass33_Sub2_Sub2_Sub2_680 = new Class33_Sub2_Sub2_Sub2(128, 265, 0);
	for (int i = 0; i < 33920; i++)
	    aClass33_Sub2_Sub2_Sub2_679.anIntArray1236[i]
		= aClass26_690.anIntArray359[i];
	for (int i = 0; i < 33920; i++)
	    aClass33_Sub2_Sub2_Sub2_680.anIntArray1236[i]
		= aClass26_691.anIntArray359[i];
	anIntArray911 = new int[256];
	for (int i = 0; i < 64; i++)
	    anIntArray911[i] = i * 262144;
	for (int i = 0; i < 64; i++)
	    anIntArray911[i + 64] = 16711680 + i * 1024;
	for (int i = 0; i < 64; i++)
	    anIntArray911[i + 128] = 16776960 + i * 4;
	for (int i = 0; i < 64; i++)
	    anIntArray911[i + 192] = 16777215;
	anIntArray912 = new int[256];
	for (int i = 0; i < 64; i++)
	    anIntArray912[i] = i * 1024;
	for (int i = 0; i < 64; i++)
	    anIntArray912[i + 64] = 65280 + i * 4;
	for (int i = 0; i < 64; i++)
	    anIntArray912[i + 128] = 65535 + i * 262144;
	for (int i = 0; i < 64; i++)
	    anIntArray912[i + 192] = 16777215;
	anIntArray913 = new int[256];
	for (int i = 0; i < 64; i++)
	    anIntArray913[i] = i * 4;
	for (int i = 0; i < 64; i++)
	    anIntArray913[i + 64] = 255 + i * 262144;
	for (int i = 0; i < 64; i++)
	    anIntArray913[i + 128] = 16711935 + i * 1024;
	for (int i = 0; i < 64; i++)
	    anIntArray913[i + 192] = 16777215;
	anIntArray910 = new int[256];
	anIntArray762 = new int[32768];
	anIntArray763 = new int[32768];
	method24(0, null);
	anIntArray634 = new int[32768];
	anIntArray635 = new int[32768];
	drawLoadingText("Connecting to fileserver", 10, false);
	if (!aBoolean724) {
	    aBoolean916 = true;
	    aBoolean724 = true;
	    method12(this, 2);
	}
    }
    
    public final void run() {
	if (!aBoolean916)
	    super.run();
	else {
	    aBoolean784 = true;
	    try {
		long l = System.currentTimeMillis();
		int i = 0;
		int i1 = 20;
		while (aBoolean724) {
		    method25((byte) 9);
		    method25((byte) 9);
		    method27(-404);
		    if (++i > 10) {
			long l2 = System.currentTimeMillis();
			int i3 = (int) (l2 - l) / 10 - i1;
			i1 = 40 - i3;
			if (i1 < 5)
			    i1 = 5;
			i = 0;
			l = l2;
		    }
		    try {
			Thread.sleep((long) i1);
		    } catch (Exception exception) {
		    }
		}
	    } catch (Exception exception) {
	    }
	    aBoolean784 = false;
	}
    }
    
    public final void method23(int arg0) {
	aBoolean724 = false;
	while (aBoolean784) {
	    aBoolean724 = false;
	    try {
		Thread.sleep(50L);
	    } catch (Exception exception) {
	    }
	}
	aClass33_Sub2_Sub2_Sub3_757 = null;
	aClass33_Sub2_Sub2_Sub3_758 = null;
	aClass33_Sub2_Sub2_Sub3Array686 = null;
	anIntArray910 = null;
	anIntArray911 = null;
	anIntArray912 = null;
	anIntArray913 = null;
	anIntArray762 = null;
	anIntArray763 = null;
	anInt713 += arg0;
	anIntArray634 = null;
	anIntArray635 = null;
	aClass33_Sub2_Sub2_Sub2_679 = null;
	aClass33_Sub2_Sub2_Sub2_680 = null;
    }
    
    public final void method24(int arg0, Class33_Sub2_Sub2_Sub3 arg1) {
	int i = 256;
	for (int i1 = 0; i1 < anIntArray762.length; i1++)
	    anIntArray762[i1] = 0;
	for (int i2 = 0; i2 < 5000; i2++) {
	    int i3 = (int) (Math.random() * 128.0 * (double) i);
	    anIntArray762[i3] = (int) (Math.random() * 256.0);
	}
	for (int i4 = 0; i4 < 20; i4++) {
	    for (int i5 = 1; i5 < i - 1; i5++) {
		for (int i6 = 1; i6 < 127; i6++) {
		    int i7 = i6 + (i5 << 7);
		    anIntArray763[i7]
			= (anIntArray762[i7 - 1] + anIntArray762[i7 + 1]
			   + anIntArray762[i7 - 128]
			   + anIntArray762[i7 + 128]) / 4;
		}
	    }
	    int[] ints = anIntArray762;
	    anIntArray762 = anIntArray763;
	    anIntArray763 = ints;
	}
	anInt713 += arg0;
	if (arg1 != null) {
	    int i8 = 0;
	    for (int i9 = 0; i9 < arg1.anInt1249; i9++) {
		for (int i10 = 0; i10 < arg1.anInt1248; i10++) {
		    if (arg1.aByteArray1246[i8++] != 0) {
			int i11 = i10 + 16 + arg1.anInt1250;
			int i12 = i9 + 16 + arg1.anInt1251;
			int i13 = i11 + (i12 << 7);
			anIntArray762[i13] = 0;
		    }
		}
	    }
	}
    }
    
    public final void method25(byte arg0) {
	int i = 256;
	for (int i1 = 10; i1 < 117; i1++) {
	    int i2 = (int) (Math.random() * 100.0);
	    if (i2 < 50)
		anIntArray634[i1 + (i - 2 << 7)] = 255;
	}
	for (int i3 = 0; i3 < 100; i3++) {
	    int i4 = (int) (Math.random() * 124.0) + 2;
	    int i5 = (int) (Math.random() * 128.0) + 128;
	    int i6 = i4 + (i5 << 7);
	    anIntArray634[i6] = 192;
	}
	if (arg0 != 9)
	    anInt684 = -438;
	for (int i7 = 1; i7 < i - 1; i7++) {
	    for (int i8 = 1; i8 < 127; i8++) {
		int i9 = i8 + (i7 << 7);
		anIntArray635[i9]
		    = ((anIntArray634[i9 - 1] + anIntArray634[i9 + 1]
			+ anIntArray634[i9 - 128] + anIntArray634[i9 + 128])
		       / 4);
	    }
	}
	anInt864 += 128;
	if (anInt864 > anIntArray762.length) {
	    anInt864 -= anIntArray762.length;
	    int i10 = (int) (Math.random() * 12.0);
	    method24(0, aClass33_Sub2_Sub2_Sub3Array686[i10]);
	}
	for (int i11 = 1; i11 < i - 1; i11++) {
	    for (int i12 = 1; i12 < 127; i12++) {
		int i13 = i12 + (i11 << 7);
		int i14 = (anIntArray635[i13 + 128]
			   - anIntArray762[(i13 + anInt864
					    & anIntArray762.length - 1)] / 5);
		if (i14 < 0)
		    i14 = 0;
		anIntArray634[i13] = i14;
	    }
	}
	for (int i15 = 0; i15 < i - 1; i15++)
	    anIntArray799[i15] = anIntArray799[i15 + 1];
	anIntArray799[i - 1]
	    = (int) (Math.sin((double) anInt647 / 14.0) * 16.0
		     + Math.sin((double) anInt647 / 15.0) * 14.0
		     + Math.sin((double) anInt647 / 16.0) * 12.0);
	if (anInt834 > 0)
	    anInt834 -= 4;
	if (anInt835 > 0)
	    anInt835 -= 4;
	if (anInt834 == 0 && anInt835 == 0) {
	    int i16 = (int) (Math.random() * 2000.0);
	    if (i16 == 0)
		anInt834 = 1024;
	    if (i16 == 1)
		anInt835 = 1024;
	}
    }
    
    public final int method26(int arg0, int arg1, int arg2, int arg3) {
	int i = 256 - arg3;
	anInt713 += arg1;
	return ((((arg2 & 0xff00ff) * i + (arg0 & 0xff00ff) * arg3 & ~0xff00ff)
		 + ((arg2 & 0xff00) * i + (arg0 & 0xff00) * arg3 & 0xff0000))
		>> 8);
    }
    
    public final void method27(int arg0) {
	int i = 256;
	if (anInt834 > 0) {
	    for (int i1 = 0; i1 < 256; i1++) {
		if (anInt834 > 768)
		    anIntArray910[i1]
			= method26(anIntArray912[i1], 0, anIntArray911[i1],
				   1024 - anInt834);
		else if (anInt834 > 256)
		    anIntArray910[i1] = anIntArray912[i1];
		else
		    anIntArray910[i1]
			= method26(anIntArray911[i1], 0, anIntArray912[i1],
				   256 - anInt834);
	    }
	} else if (anInt835 > 0) {
	    for (int i2 = 0; i2 < 256; i2++) {
		if (anInt835 > 768)
		    anIntArray910[i2]
			= method26(anIntArray913[i2], 0, anIntArray911[i2],
				   1024 - anInt835);
		else if (anInt835 > 256)
		    anIntArray910[i2] = anIntArray913[i2];
		else
		    anIntArray910[i2]
			= method26(anIntArray911[i2], 0, anIntArray913[i2],
				   256 - anInt835);
	    }
	} else {
	    for (int i3 = 0; i3 < 256; i3++)
		anIntArray910[i3] = anIntArray911[i3];
	}
	for (int i4 = 0; i4 < 33920; i4++)
	    aClass26_690.anIntArray359[i4]
		= aClass33_Sub2_Sub2_Sub2_679.anIntArray1236[i4];
	int i5 = 0;
	int i6 = 1152;
	for (int i7 = 1; i7 < i - 1; i7++) {
	    int i8 = anIntArray799[i7] * (i - i7) / i;
	    int i9 = i8 + 22;
	    if (i9 < 0)
		i9 = 0;
	    i5 += i9;
	    for (int i10 = i9; i10 < 128; i10++) {
		int i11 = anIntArray634[i5++];
		if (i11 != 0) {
		    int i12 = i11;
		    int i13 = 256 - i11;
		    i11 = anIntArray910[i11];
		    int i14 = aClass26_690.anIntArray359[i6];
		    aClass26_690.anIntArray359[i6++]
			= (((i11 & 0xff00ff) * i12 + (i14 & 0xff00ff) * i13
			    & ~0xff00ff)
			   + ((i11 & 0xff00) * i12 + (i14 & 0xff00) * i13
			      & 0xff0000)) >> 8;
		} else
		    i6++;
	    }
	    i6 += i9;
	}
	if (arg0 < 0) {
	    aClass26_690.method191(aGraphics13, 0, 0);
	    for (int i15 = 0; i15 < 33920; i15++)
		aClass26_691.anIntArray359[i15]
		    = aClass33_Sub2_Sub2_Sub2_680.anIntArray1236[i15];
	    i5 = 0;
	    i6 = 1176;
	    for (int i16 = 1; i16 < i - 1; i16++) {
		int i17 = anIntArray799[i16] * (i - i16) / i;
		int i18 = 103 - i17;
		i6 += i17;
		for (int i19 = 0; i19 < i18; i19++) {
		    int i20 = anIntArray634[i5++];
		    if (i20 != 0) {
			int i21 = i20;
			int i22 = 256 - i20;
			i20 = anIntArray910[i20];
			int i23 = aClass26_691.anIntArray359[i6];
			aClass26_691.anIntArray359[i6++]
			    = (((i20 & 0xff00ff) * i21 + (i23 & 0xff00ff) * i22
				& ~0xff00ff)
			       + ((i20 & 0xff00) * i21 + (i23 & 0xff00) * i22
				  & 0xff0000)) >> 8;
		    } else
			i6++;
		}
		i5 += 128 - i18;
		i6 += 128 - i18 - i17;
	    }
	    aClass26_691.method191(aGraphics13, 661, 0);
	}
    }
    
    public final void method28(boolean arg0) {
	method20(-905);
	aClass26_689.method190(0);
	aBoolean825 &= arg0;
	aClass33_Sub2_Sub2_Sub3_757.method323(0, true, 0);
	int i = 360;
	int i1 = 200;
	if (anInt685 == 0) {
	    int i2 = i1 / 2 - 80;
	    aClass33_Sub2_Sub2_Sub4_654.method326
		(i / 2, "Welcome to the RuneScape-2 BETA test.", i2, anInt861,
		 16776960, true);
	    i2 += 15;
	    i2 += 15;
	    aClass33_Sub2_Sub2_Sub4_652.method326
		(i / 2,
		 "Please note this test version of the game is provided for ",
		 i2, anInt861, 16777215, true);
	    i2 += 15;
	    aClass33_Sub2_Sub2_Sub4_652.method326
		(i / 2,
		 "testing/preview purposes only. As such please bear in mind that:",
		 i2, anInt861, 16777215, true);
	    i2 += 15;
	    i2 += 10;
	    aClass33_Sub2_Sub2_Sub4_652.method326
		(i / 2,
		 "a) Everything you do/gain here will be forgotten when the beta ends.",
		 i2, anInt861, 16777215, true);
	    i2 += 15;
	    aClass33_Sub2_Sub2_Sub4_652.method326
		(i / 2, "b) No customer support is available for the beta.",
		 i2, anInt861, 16777215, true);
	    i2 += 15;
	    aClass33_Sub2_Sub2_Sub4_652.method326
		(i / 2,
		 "c) The beta may be incomplete/buggy, we're still working on it.",
		 i2, anInt861, 16777215, true);
	    i2 += 15;
	    aClass33_Sub2_Sub2_Sub4_652.method326
		(i / 2, "d) The beta may be totally unavailable at times.", i2,
		 anInt861, 16777215, true);
	    i2 += 15;
	    int i3 = i / 2;
	    int i4 = i1 / 2 + 65;
	    aClass33_Sub2_Sub2_Sub3_758.method323(i3 - 73, true, i4 - 20);
	    aClass33_Sub2_Sub2_Sub4_654.method326(i / 2,
						  "Click here to login.",
						  i4 + 5, anInt861, 16777215,
						  true);
	}
	if (anInt685 == 1 || anInt685 == 2) {
	    int i5 = i1 / 2 - 50;
	    if (aString898.length() > 0) {
		aClass33_Sub2_Sub2_Sub4_654.method326(i / 2, aString898,
						      i5 - 15, anInt861,
						      16776960, true);
		aClass33_Sub2_Sub2_Sub4_654.method326(i / 2, aString899, i5,
						      anInt861, 16776960,
						      true);
		i5 += 30;
	    } else {
		aClass33_Sub2_Sub2_Sub4_654.method326(i / 2, aString899,
						      i5 - 7, anInt861,
						      16776960, true);
		i5 += 30;
	    }
	    aClass33_Sub2_Sub2_Sub4_654.method330(true, i / 2 - 90, i5,
						  16777215, true,
						  ("Username: " + aString778
						   + ((anInt860 == 0
						       & anInt647 % 40 < 20)
						      ? "@yel@|" : "")));
	    i5 += 15;
	    aClass33_Sub2_Sub2_Sub4_654.method330
		(true, i / 2 - 88, i5, 16777215, true,
		 ("Password: " + Class35.method378(aString779, (byte) -37)
		  + (anInt860 == 1 & anInt647 % 40 < 20 ? "@yel@|" : "")));
	    i5 += 15;
	    if (anInt685 == 1)
		aClass33_Sub2_Sub2_Sub4_654.method330
		    (true, i / 2 - 143, i5, 16777215, true,
		     ("Confirm Password: "
		      + Class35.method378(aString780, (byte) -37)
		      + (anInt860 == 2 & anInt647 % 40 < 20 ? "@yel@|" : "")));
	    int i6 = i / 2 - 80;
	    int i7 = i1 / 2 + 40;
	    aClass33_Sub2_Sub2_Sub3_758.method323(i6 - 73, true, i7 - 20);
	    if (anInt685 == 1)
		aClass33_Sub2_Sub2_Sub4_654
		    .method326(i6, "Create", i7 + 5, anInt861, 16777215, true);
	    else
		aClass33_Sub2_Sub2_Sub4_654
		    .method326(i6, "Login", i7 + 5, anInt861, 16777215, true);
	    i6 = i / 2 + 80;
	    aClass33_Sub2_Sub2_Sub3_758.method323(i6 - 73, true, i7 - 20);
	    aClass33_Sub2_Sub2_Sub4_654.method326(i6, "Cancel", i7 + 5,
						  anInt861, 16777215, true);
	}
	aClass26_689.method191(aGraphics13, 214, 186);
	if (aBoolean844) {
	    aBoolean844 = false;
	    aClass26_687.method191(aGraphics13, 128, 0);
	    aClass26_688.method191(aGraphics13, 214, 386);
	    aClass26_692.method191(aGraphics13, 0, 265);
	    aClass26_693.method191(aGraphics13, 574, 265);
	    aClass26_694.method191(aGraphics13, 128, 186);
	    aClass26_695.method191(aGraphics13, 574, 186);
	}
    }
    
    public final void method29(String arg0, String arg1, byte arg2, int arg3,
			       boolean arg4) {
	if (arg2 == 12) {
	    try {
		if (!arg4) {
		    aString898 = "";
		    aString899 = "Connecting to server...";
		    method28(true);
		}
		aClass5_730
		    = new Class5(-407, method88(anInt840 + 43594), this);
		aClass5_730.method128(aClass33_Sub2_Sub3_708.aByteArray1107, 0,
				      8);
		aClass33_Sub2_Sub3_708.anInt1108 = 0;
		aLong939 = aClass33_Sub2_Sub3_708.method348(1);
		int[] ints = new int[4];
		ints[0] = (int) (Math.random() * 9.9999999E7);
		ints[1] = (int) (Math.random() * 9.9999999E7);
		ints[2] = (int) (aLong939 >> 32);
		ints[3] = (int) aLong939;
		aClass33_Sub2_Sub3_696.anInt1108 = 0;
		aClass33_Sub2_Sub3_696.method335(10);
		aClass33_Sub2_Sub3_696.method337(ints[0]);
		aClass33_Sub2_Sub3_696.method337(ints[1]);
		aClass33_Sub2_Sub3_696.method337(ints[2]);
		aClass33_Sub2_Sub3_696.method337(ints[3]);
		aClass33_Sub2_Sub3_696.method337(arg3);
		aClass33_Sub2_Sub3_696.method339(arg0);
		aClass33_Sub2_Sub3_696.method339(arg1);
		aClass33_Sub2_Sub3_696.method357(aBigInteger683, true,
						 aBigInteger741);
		aClass33_Sub2_Sub3_830.anInt1108 = 0;
		if (arg4)
		    aClass33_Sub2_Sub3_830.method335(18);
		else
		    aClass33_Sub2_Sub3_830.method335(16);
		aClass33_Sub2_Sub3_830
		    .method335(aClass33_Sub2_Sub3_696.anInt1108 + 32);
		for (int i = 0; i < 8; i++)
		    aClass33_Sub2_Sub3_830.method337(anIntArray658[i]);
		aClass33_Sub2_Sub3_830.method340((aClass33_Sub2_Sub3_696
						  .anInt1108),
						 false, 0,
						 (aClass33_Sub2_Sub3_696
						  .aByteArray1107));
		aClass33_Sub2_Sub3_696.aClass32_1112
		    = new Class32((byte) -73, ints);
		for (int i = 0; i < 4; i++)
		    ints[i] += 50;
		aClass32_674 = new Class32((byte) -73, ints);
		aClass5_730.method129(0, 0,
				      aClass33_Sub2_Sub3_830.aByteArray1107,
				      aClass33_Sub2_Sub3_830.anInt1108);
		int i = aClass5_730.method126();
		if (i == 1) {
		    try {
			Thread.sleep(2000L);
		    } catch (Exception exception) {
		    }
		    method29(arg0, arg1, (byte) 12, arg3, arg4);
		} else if (i == 2) {
		    aBoolean825 = true;
		    aClass33_Sub2_Sub3_696.anInt1108 = 0;
		    aClass33_Sub2_Sub3_708.anInt1108 = 0;
		    anInt714 = -1;
		    anInt713 = 0;
		    anInt715 = 0;
		    anInt732 = 0;
		    if (!arg4) {
			idleTime = 0;
			for (int i1 = 0; i1 < 100; i1++)
			    aStringArray931[i1] = null;
			anInt719 = 0;
			anInt847 = 0;
			anInt648 = 0;
			anInt870 = -1;
			anInt737 = 0;
			anInt935 = 0;
			for (int i2 = 0; i2 < anInt734; i2++) {
			    aClass33_Sub7_Sub2_Sub2Array736[i2] = null;
			    aClass33_Sub2_Sub3Array740[i2] = null;
			}
			for (int i3 = 0; i3 < 8192; i3++)
			    aClass33_Sub7_Sub2_Sub1Array934[i3] = null;
			aClass33_Sub7_Sub2_Sub2_792
			    = aClass33_Sub7_Sub2_Sub2Array736[anInt735]
			    = new Class33_Sub7_Sub2_Sub2();
			aClass22_897.method187();
			aClass22_675.method187();
			aClass22_868.method187();
			for (int i4 = 0; i4 < 4; i4++) {
			    for (int i5 = 0; i5 < 104; i5++) {
				for (int i6 = 0; i6 < 104; i6++)
				    aClass22ArrayArrayArray805[i4][i5][i6]
					= null;
			    }
			}
			aClass22_697 = new Class22(845);
			anInt841 = 0;
			anInt917 = -1;
			anInt709 = -1;
			anInt704 = -1;
			aBoolean678 = false;
			anInt712 = 3;
			aBoolean707 = false;
			aBoolean881 = false;
			aBoolean633 = false;
			anInt744 = 0;
			aBoolean725 = true;
			method78((byte) 86);
			for (int i7 = 0; i7 < 5; i7++)
			    anIntArray822[i7] = 0;
			method19((byte) 109);
		    }
		} else if (i == 3) {
		    aString898 = "";
		    aString899 = "Invalid username or password.";
		} else if (i == 4) {
		    aString898 = "Your account has been disabled.";
		    aString899
			= "Please check your message-centre for details.";
		} else if (i == 5) {
		    aString898 = "Your account is already logged in.";
		    aString899 = "Try again in 60 secs...";
		} else if (i == 6) {
		    aString898 = "RuneScape has been updated!";
		    aString899 = "Please reload this page.";
		} else if (i == 7) {
		    aString898 = "This world is full.";
		    aString899 = "Please use a different world.";
		} else if (i == 8) {
		    aString898 = "Unable to connect.";
		    aString899 = "Login server offline.";
		} else if (i == 9) {
		    aString898 = "Login limit exceeded.";
		    aString899 = "Too many connections from your address.";
		} else if (i == 10) {
		    aString898 = "Unable to connect.";
		    aString899 = "Bad session id.";
		} else if (i == 11) {
		    aString898 = "Unable to connect.";
		    aString899 = "Login server rejected session.";
		} else if (i == 12) {
		    aString898 = "You need a members account to beta-test";
		    aString899 = "Please subscribe, or play RS1 instead";
		} else if (i == 13) {
		    aString898 = "Could not complete login";
		    aString899 = "Please try using a different world";
		} else if (i == 14) {
		    aString898 = "The server is being updated";
		    aString899 = "Please wait 1 minute and try again";
		}
	    } catch (IOException ioexception) {
		aString898 = "";
		aString899 = "Error connecting to server.";
	    }
	}
    }
    
    public final void method30(int arg0, String arg1, String arg2, int arg3) {
	if (arg3 != 0)
	    anInt714 = aClass33_Sub2_Sub3_708.method342();
	try {
	    aString898 = "";
	    aString899 = "Connecting to server...";
	    method28(true);
	    aClass5_730 = new Class5(-407, method88(anInt840 + 43594), this);
	    aClass5_730.method128(aClass33_Sub2_Sub3_708.aByteArray1107, 0, 8);
	    aClass33_Sub2_Sub3_708.anInt1108 = 0;
	    aLong939 = aClass33_Sub2_Sub3_708.method348(1);
	    aClass33_Sub2_Sub3_696.anInt1108 = 0;
	    aClass33_Sub2_Sub3_696.method335(10);
	    aClass33_Sub2_Sub3_696.method337((int) Math.random() * 99999999);
	    aClass33_Sub2_Sub3_696.method337((int) Math.random() * 99999999);
	    aClass33_Sub2_Sub3_696.method338(aLong939, -771);
	    aClass33_Sub2_Sub3_696.method337(arg0);
	    aClass33_Sub2_Sub3_696.method339(arg1);
	    aClass33_Sub2_Sub3_696.method339(arg2);
	    aClass33_Sub2_Sub3_696.method357(aBigInteger683, true,
					     aBigInteger741);
	    aClass33_Sub2_Sub3_830.anInt1108 = 0;
	    aClass33_Sub2_Sub3_830.method335(17);
	    aClass33_Sub2_Sub3_830.method335(aClass33_Sub2_Sub3_696.anInt1108);
	    aClass33_Sub2_Sub3_830.method340(aClass33_Sub2_Sub3_696.anInt1108,
					     false, 0,
					     (aClass33_Sub2_Sub3_696
					      .aByteArray1107));
	    aClass5_730.method129(0, 0, aClass33_Sub2_Sub3_830.aByteArray1107,
				  aClass33_Sub2_Sub3_830.anInt1108);
	    int i = aClass5_730.method126();
	    if (i == 1) {
		try {
		    Thread.sleep(2000L);
		} catch (Exception exception) {
		}
		method30(arg0, arg1, arg2, 0);
	    } else if (i == 2) {
		aString898 = "Username already taken.";
		aString899 = "Please choose a different name.";
	    } else if (i == 3) {
		anInt685 = 2;
		method29(aString778, aString779, (byte) 12, arg0, false);
	    }
	} catch (IOException ioexception) {
	    aString898 = "";
	    aString899 = "Error connecting to server.";
	}
    }
    
    public final void cleanUpForQuit(byte arg0) {
	try {
	    if (aClass5_730 != null)
		aClass5_730.method125();
	} catch (Exception exception) {
	}
	aClass5_730 = null;
	signlink.midi = "null";
	aClass33_Sub2_Sub3_696 = null;
	aClass33_Sub2_Sub3_830 = null;
	aClass33_Sub2_Sub3_708 = null;
	anIntArray670 = null;
	aByteArrayArray764 = null;
	aByteArrayArray795 = null;
	anIntArrayArrayArray756 = null;
	aByteArrayArrayArray903 = null;
	aClass27_806 = null;
	aClass1Array638 = null;
	anIntArrayArray673 = null;
	anIntArrayArray776 = null;
	anIntArray845 = null;
	anIntArray846 = null;
	aByteArray786 = null;
	aClass26_787 = null;
	aClass26_788 = null;
	aClass26_789 = null;
	aClass26_790 = null;
	aClass26_877 = null;
	aClass26_878 = null;
	aClass26_879 = null;
	aClass26_884 = null;
	aClass26_885 = null;
	aClass26_886 = null;
	aClass26_887 = null;
	aClass26_888 = null;
	aClass26_889 = null;
	aClass26_890 = null;
	aClass26_891 = null;
	aClass26_892 = null;
	aClass26_893 = null;
	aClass33_Sub2_Sub2_Sub3_643 = null;
	aClass33_Sub2_Sub2_Sub3_644 = null;
	aClass33_Sub2_Sub2_Sub3_645 = null;
	aClass33_Sub2_Sub2_Sub3_667 = null;
	aClass33_Sub2_Sub2_Sub3_668 = null;
	aClass33_Sub2_Sub2_Sub3_669 = null;
	aClass33_Sub2_Sub2_Sub3_929 = null;
	aClass33_Sub2_Sub2_Sub3_930 = null;
	aClass33_Sub2_Sub2_Sub3_940 = null;
	aClass33_Sub2_Sub2_Sub3_941 = null;
	aClass33_Sub2_Sub2_Sub3_942 = null;
	aClass33_Sub2_Sub2_Sub3_943 = null;
	aClass33_Sub2_Sub2_Sub3_944 = null;
	aClass33_Sub2_Sub2_Sub3_871 = null;
	aClass33_Sub2_Sub2_Sub3_872 = null;
	aClass33_Sub2_Sub2_Sub3_873 = null;
	aClass33_Sub2_Sub2_Sub3_874 = null;
	aClass33_Sub2_Sub2_Sub3_875 = null;
	aClass33_Sub2_Sub2_Sub2_867 = null;
	aClass33_Sub2_Sub2_Sub2Array651 = null;
	aClass33_Sub2_Sub2_Sub2Array632 = null;
	aClass33_Sub2_Sub2_Sub2Array869 = null;
	aClass33_Sub2_Sub2_Sub2_809 = null;
	aClass33_Sub2_Sub2_Sub2_810 = null;
	aClass33_Sub2_Sub2_Sub2_811 = null;
	aClass33_Sub2_Sub2_Sub3Array896 = null;
	aClass33_Sub2_Sub2_Sub2Array777 = null;
	anIntArrayArray883 = null;
	aClass33_Sub7_Sub2_Sub2Array736 = null;
	((client) this).anIntArray738 = null;
	anIntArray739 = null;
	aClass33_Sub2_Sub3Array740 = null;
	((client) this).anIntArray833 = null;
	aClass33_Sub7_Sub2_Sub1Array934 = null;
	((client) this).anIntArray936 = null;
	aClass22ArrayArrayArray805 = null;
	aClass22_697 = null;
	aClass22_868 = null;
	aClass22_897 = null;
	aClass22_675 = null;
	aClass22_862 = null;
	anIntArray769 = null;
	anIntArray770 = null;
	anIntArray771 = null;
	anIntArray772 = null;
	aStringArray631 = null;
	anIntArray937 = null;
	anIntArray663 = null;
	anIntArray664 = null;
	aClass33_Sub2_Sub2_Sub2Array798 = null;
	aClass33_Sub2_Sub2_Sub2_932 = null;
	aStringArray852 = null;
	if (arg0 != -64)
	    anInt684 = 60;
	anIntArray938 = null;
	aClass26_690 = null;
	aClass26_691 = null;
	aClass26_687 = null;
	aClass26_688 = null;
	aClass26_689 = null;
	aClass26_692 = null;
	aClass26_693 = null;
	aClass26_694 = null;
	aClass26_695 = null;
	method23(0);
	Class37.method382(415);
	Class38.method388(415);
	Class39.method394(415);
	Class2.aClass2Array44 = null;
	Class4.aClass4Array84 = null;
	Class6.aClass6Array105 = null;
	Class8.aClass8Array167 = null;
	Class10.aClass10Array183 = null;
	Class12.aClass12Array208 = null;
	Class12.aClass29_215 = null;
	Class14.aClass14Array243 = null;
	aClass26_14 = null;
	Class33_Sub7_Sub2_Sub2.aClass29_1293 = null;
	Class33_Sub2_Sub2_Sub1.method292(415);
	Class27.method193(415);
	Class33_Sub2_Sub1.method260(415);
	Class7.aClass7Array162 = null;
	Class9.aClass9Array173 = null;
	System.gc();
    }
    
    public final void method31(boolean arg0) {
	Class37.aClass29_554.method252();
	Class37.aClass29_555.method252();
	Class38.aClass29_586.method252();
	Class39.aClass29_626.method252();
	Class39.aClass29_627.method252();
	Class33_Sub7_Sub2_Sub2.aClass29_1293.method252();
	Class12.aClass29_215.method252();
	if (arg0)
	    anInt861 = 27;
    }
    
    public final void method32(int arg0) {
	if (arg0 != anInt882)
	    anInt861 = aClass32_674.method255();
	try {
	    if (aClass5_730 != null)
		aClass5_730.method125();
	} catch (Exception exception) {
	}
	aClass5_730 = null;
	aBoolean825 = false;
	anInt685 = 0;
	aString778 = "";
	aString779 = "";
	aString780 = "";
	method31(false);
	aClass27_806.method194(false);
	for (int i = 0; i < 4; i++)
	    aClass1Array638[i].method92(573);
	System.gc();
	if (aBoolean759)
	    signlink.midi = "null";
	aString863 = null;
    }
    
    public final void method33(byte arg0) {
	aClass26_789.method190(0);
	aClass33_Sub2_Sub2_Sub4_653.method325(144, aBoolean876, 257, 0,
					      "Connection lost");
	aClass33_Sub2_Sub2_Sub4_653.method325(143, aBoolean876, 256, 16777215,
					      "Connection lost");
	aClass33_Sub2_Sub2_Sub4_653.method325
	    (159, aBoolean876, 257, 0,
	     "Please wait - attempting to reestablish");
	aClass33_Sub2_Sub2_Sub4_653.method325
	    (158, aBoolean876, 256, 16777215,
	     "Please wait - attempting to reestablish");
	aClass26_789.method191(aGraphics13, 8, 11);
	aBoolean825 = false;
	method29(aString778, aString779, (byte) 12, method85(314), true);
	if (arg0 == 4) {
	    boolean flag = false;
	} else
	    aClass22ArrayArrayArray805 = null;
	if (!aBoolean825)
	    method32(-36905);
    }
    
    public final void method34(int arg0) {
	if (anInt732 > 1)
	    anInt732--;
	for (int i = 0; i < 5; i++) {
	    if (!method51(-359))
		break;
	}
	anInt715++;
	if (anInt715 > 750)
	    method33((byte) 4);
	method45(-31949);
	method47(0);
	for (int i = -1; i < anInt737; i++) {
	    int i1;
	    if (i == -1)
		i1 = anInt735;
	    else
		i1 = ((client) this).anIntArray738[i];
	    Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
		= aClass33_Sub7_Sub2_Sub2Array736[i1];
	    if (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1143 > 0) {
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1143--;
		if (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1143
		    == 0)
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).aString1142
			= null;
	    }
	}
	for (int i = 0; i < anInt935; i++) {
	    int i2 = ((client) this).anIntArray936[i];
	    Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
		= aClass33_Sub7_Sub2_Sub1Array934[i2];
	    if (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1143 > 0) {
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1143--;
		if (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1143
		    == 0)
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).aString1142
			= null;
	    }
	}
	if (anInt648 == 2) {
	    for (Class33_Sub4 class33_sub4
		     = (Class33_Sub4) aClass22_868.method183();
		 class33_sub4 != null;
		 class33_sub4
		     = (Class33_Sub4) aClass22_868.method185(-14092)) {
		if (anInt647 >= class33_sub4.anInt990) {
		    method52(class33_sub4.anInt983, class33_sub4.anInt989,
			     class33_sub4.anInt986, (byte) 120,
			     class33_sub4.anInt985, class33_sub4.anInt984,
			     class33_sub4.anInt988, class33_sub4.anInt987);
		    class33_sub4.method258();
		}
	    }
	}
	anInt761++;
	if (arg0 < anInt747 || arg0 > anInt747)
	    aClass22ArrayArrayArray805 = null;
	if (anInt839 != 0) {
	    anInt838 += 20;
	    if (anInt838 >= 400)
		anInt839 = 0;
	}
	if (anInt908 != 0) {
	    anInt905++;
	    if (anInt905 >= 15) {
		if (anInt908 == 2)
		    aBoolean646 = true;
		if (anInt908 == 3)
		    aBoolean760 = true;
		anInt908 = 0;
	    }
	}
	if (Class27.anInt405 != -1) {
	    int i = Class27.anInt405;
	    int i3 = Class27.anInt406;
	    boolean flag
		= method50(i3, true, 0, true, 0, i,
			   (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			    .anIntArray1178[0]),
			   0, 0, 0,
			   (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			    .anIntArray1179[0]));
	    Class27.anInt405 = -1;
	    if (flag) {
		anInt836 = clickX;
		anInt837 = clickY;
		anInt839 = 1;
		anInt838 = 0;
	    }
	}
	method59(811);
	if (clickMode1 == 1) {
	    int i = clickX - 21 - 561;
	    int i4 = clickY - 9 - 5;
	    if (i >= 0 && i4 >= 0 && i < 146 && i4 < 151) {
		i -= 73;
		i4 -= 75;
		int i5 = Class33_Sub2_Sub2_Sub1.anIntArray1218[anInt749];
		int i6 = Class33_Sub2_Sub2_Sub1.anIntArray1219[anInt749];
		int i7 = i4 * i5 + i * i6 >> 11;
		int i8 = i4 * i6 - i * i5 >> 11;
		int i9 = ((((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			   .anInt1131) + i7
			  >> 7);
		int i10 = ((((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			    .anInt1132) - i8
			   >> 7);
		method50(i10, true, 0, true, 0, i9,
			 (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			  .anIntArray1178[0]),
			 0, 0, 0,
			 (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			  .anIntArray1179[0]));
	    }
	}
	if (clickMode1 == 1) {
	    if (clickX >= 549 && clickX <= 583 && clickY >= 195
		&& clickY < 231) {
		aBoolean646 = true;
		anInt712 = 0;
		aBoolean729 = true;
	    }
	    if (clickX >= 579 && clickX <= 609 && clickY >= 194
		&& clickY < 231) {
		aBoolean646 = true;
		anInt712 = 1;
		aBoolean729 = true;
	    }
	    if (clickX >= 607 && clickX <= 637 && clickY >= 194
		&& clickY < 231) {
		aBoolean646 = true;
		anInt712 = 2;
		aBoolean729 = true;
	    }
	    if (clickX >= 635 && clickX <= 679 && clickY >= 194
		&& clickY < 229) {
		aBoolean646 = true;
		anInt712 = 3;
		aBoolean729 = true;
	    }
	    if (clickX >= 676 && clickX <= 706 && clickY >= 194
		&& clickY < 231) {
		aBoolean646 = true;
		anInt712 = 4;
		aBoolean729 = true;
	    }
	    if (clickX >= 704 && clickX <= 734 && clickY >= 194
		&& clickY < 231) {
		aBoolean646 = true;
		anInt712 = 5;
		aBoolean729 = true;
	    }
	    if (clickX >= 732 && clickX <= 766 && clickY >= 195
		&& clickY < 231) {
		aBoolean646 = true;
		anInt712 = 6;
		aBoolean729 = true;
	    }
	    if (clickX >= 582 && clickX <= 612 && clickY >= 492
		&& clickY < 529) {
		aBoolean646 = true;
		anInt712 = 8;
		aBoolean729 = true;
	    }
	    if (clickX >= 609 && clickX <= 639 && clickY >= 492
		&& clickY < 529) {
		aBoolean646 = true;
		anInt712 = 9;
		aBoolean729 = true;
	    }
	    if (clickX >= 637 && clickX <= 681 && clickY >= 493
		&& clickY < 528) {
		aBoolean646 = true;
		anInt712 = 10;
		aBoolean729 = true;
	    }
	    if (clickX >= 679 && clickX <= 709 && clickY >= 492
		&& clickY < 529) {
		aBoolean646 = true;
		anInt712 = 11;
		aBoolean729 = true;
	    }
	}
	if (clickMode1 == 1) {
	    if (clickX >= 8 && clickX <= 108 && clickY >= 490
		&& clickY <= 522) {
		anInt802 = (anInt802 + 1) % 3;
		aBoolean894 = true;
		aBoolean760 = true;
		aClass33_Sub2_Sub3_696.method334(false, 173);
		aClass33_Sub2_Sub3_696.method335(anInt802);
		aClass33_Sub2_Sub3_696.method335(anInt765);
		aClass33_Sub2_Sub3_696.method335(anInt742);
	    }
	    if (clickX >= 137 && clickX <= 237 && clickY >= 490
		&& clickY <= 522) {
		anInt765 = (anInt765 + 1) % 3;
		aBoolean894 = true;
		aBoolean760 = true;
		aClass33_Sub2_Sub3_696.method334(false, 173);
		aClass33_Sub2_Sub3_696.method335(anInt802);
		aClass33_Sub2_Sub3_696.method335(anInt765);
		aClass33_Sub2_Sub3_696.method335(anInt742);
	    }
	    if (clickX >= 275 && clickX <= 375 && clickY >= 490
		&& clickY <= 522) {
		anInt742 = (anInt742 + 1) % 3;
		aBoolean894 = true;
		aBoolean760 = true;
		aClass33_Sub2_Sub3_696.method334(false, 173);
		aClass33_Sub2_Sub3_696.method335(anInt802);
		aClass33_Sub2_Sub3_696.method335(anInt765);
		aClass33_Sub2_Sub3_696.method335(anInt742);
	    }
	    if (clickX >= 416 && clickX <= 516 && clickY >= 490
		&& clickY <= 522) {
	    }
	}
	if (clickMode2 == 1 || clickMode1 == 1)
	    anInt904++;
	if (anInt648 == 2)
	    method35(aBoolean672);
	for (;;) {
	    int i = this.readChar(false);
	    if (i == -1)
		break;
	    if (aBoolean633) {
		if (i >= 32 && i <= 122 && aString915.length() < 80) {
		    aString915 += (char) i;
		    aBoolean760 = true;
		}
		if (i == 8 && aString915.length() > 0) {
		    aString915
			= aString915.substring(0, aString915.length() - 1);
		    aBoolean760 = true;
		}
		if (i == 13 || i == 10) {
		    aBoolean633 = false;
		    aBoolean760 = true;
		    if (anInt711 == 1 && anInt841 < 100) {
			aString915
			    = Class35.method376(Class35.method375(aString915,
								  535),
						-591);
			if (aString915.length() > 0) {
			    boolean flag = false;
			    for (int i11 = 0; i11 < anInt841; i11++) {
				if (aStringArray852[i11].equals(aString915)) {
				    flag = true;
				    break;
				}
			    }
			    if (aString915.equals(((Class33_Sub7_Sub2_Sub2)
						   aClass33_Sub7_Sub2_Sub2_792)
						  .aString1273))
				flag = true;
			    if (!flag) {
				aStringArray852[anInt841] = aString915;
				anIntArray938[anInt841] = 0;
				anInt841++;
				aBoolean646 = true;
				aClass33_Sub2_Sub3_696.method334(false, 150);
				aClass33_Sub2_Sub3_696.method338
				    (Class35.method372(aString915), -771);
			    }
			}
		    }
		    if (anInt711 == 2 && anInt841 > 0) {
			aString915
			    = Class35.method376(Class35.method375(aString915,
								  535),
						-591);
			if (aString915.length() > 0) {
			    for (int i12 = 0; i12 < anInt841; i12++) {
				if (aStringArray852[i12].equals(aString915)) {
				    anInt841--;
				    aBoolean646 = true;
				    for (int i13 = i12; i13 < anInt841;
					 i13++) {
					aStringArray852[i13]
					    = aStringArray852[i13 + 1];
					anIntArray938[i13]
					    = anIntArray938[i13 + 1];
				    }
				    aClass33_Sub2_Sub3_696.method334(false,
								     234);
				    aClass33_Sub2_Sub3_696.method338
					(Class35.method372(aString915), -771);
				    break;
				}
			    }
			}
		    }
		    if (anInt711 == 3 && aString915.length() > 0
			&& anInt731 >= 0 && anInt731 < anInt841) {
			aClass33_Sub2_Sub3_696.method334(false, 12);
			aClass33_Sub2_Sub3_696.method335(0);
			int i14 = aClass33_Sub2_Sub3_696.anInt1108;
			aClass33_Sub2_Sub3_696.method338
			    (Class35.method372(aStringArray852[anInt731]),
			     -771);
			Class36.method380(aClass33_Sub2_Sub3_696, aString915,
					  0);
			aClass33_Sub2_Sub3_696.method341
			    (-529, aClass33_Sub2_Sub3_696.anInt1108 - i14);
			aString915 = Class35.method377(aString915, 86);
			aString915 = Class16.method153(anInt946, aString915);
			method81(6, aStringArray852[anInt731], aString915,
				 36887);
			if (anInt765 == 2) {
			    anInt765 = 1;
			    aBoolean894 = true;
			    aClass33_Sub2_Sub3_696.method334(false, 173);
			    aClass33_Sub2_Sub3_696.method335(anInt802);
			    aClass33_Sub2_Sub3_696.method335(anInt765);
			    aClass33_Sub2_Sub3_696.method335(anInt742);
			}
		    }
		    if (anInt711 == 4 && anInt821 < 100
			&& aString915.length() > 0) {
			long l = Class35.method372(aString915);
			boolean flag = false;
			for (int i15 = 0; i15 < anInt821; i15++) {
			    if (aLongArray831[i15] == l) {
				flag = true;
				break;
			    }
			}
			if (!flag) {
			    aLongArray831[anInt821++] = l;
			    aBoolean646 = true;
			    aClass33_Sub2_Sub3_696.method334(false, 105);
			    aClass33_Sub2_Sub3_696.method338(l, -771);
			}
		    }
		    if (anInt711 == 5 && anInt821 > 0
			&& aString915.length() > 0) {
			long l = Class35.method372(aString915);
			for (int i16 = 0; i16 < anInt821; i16++) {
			    if (aLongArray831[i16] == l) {
				anInt821--;
				aBoolean646 = true;
				for (int i17 = i16; i17 < anInt821; i17++)
				    aLongArray831[i17]
					= aLongArray831[i17 + 1];
				aClass33_Sub2_Sub3_696.method334(false, 92);
				aClass33_Sub2_Sub3_696.method338(l, -771);
				break;
			    }
			}
		    }
		}
	    } else if (aBoolean707) {
		if (i >= 48 && i <= 57 && aString818.length() < 10) {
		    aString818 += (char) i;
		    aBoolean760 = true;
		}
		if (i == 8 && aString818.length() > 0) {
		    aString818
			= aString818.substring(0, aString818.length() - 1);
		    aBoolean760 = true;
		}
		if (i == 13 || i == 10) {
		    if (aString818.length() > 0) {
			int i18 = 0;
			try {
			    i18 = Integer.parseInt(aString818);
			} catch (Exception exception) {
			}
			aClass33_Sub2_Sub3_696.method334(false, 217);
			aClass33_Sub2_Sub3_696.method337(i18);
		    }
		    aBoolean707 = false;
		    aBoolean760 = true;
		}
	    } else if (anInt917 == -1) {
		if (i >= 32 && i <= 122 && aString817.length() < 80) {
		    aString817 += (char) i;
		    aBoolean760 = true;
		}
		if (i == 8 && aString817.length() > 0) {
		    aString817
			= aString817.substring(0, aString817.length() - 1);
		    aBoolean760 = true;
		}
		if ((i == 13 || i == 10) && aString817.length() > 0) {
		    if (aString817.equals("::clientdrop")
			&& gameFrame != null)
			method33((byte) 4);
		    else if (aString817.startsWith("::")) {
			aClass33_Sub2_Sub3_696.method334(false, 37);
			aClass33_Sub2_Sub3_696
			    .method335(aString817.length() - 1);
			aClass33_Sub2_Sub3_696
			    .method339(aString817.substring(2));
		    } else {
			int i19 = 0;
			if (aString817.startsWith("yellow:")) {
			    i19 = 0;
			    aString817 = aString817.substring(7);
			}
			if (aString817.startsWith("red:")) {
			    i19 = 1;
			    aString817 = aString817.substring(4);
			}
			if (aString817.startsWith("green:")) {
			    i19 = 2;
			    aString817 = aString817.substring(6);
			}
			if (aString817.startsWith("cyan:")) {
			    i19 = 3;
			    aString817 = aString817.substring(5);
			}
			if (aString817.startsWith("purple:")) {
			    i19 = 4;
			    aString817 = aString817.substring(7);
			}
			if (aString817.startsWith("white:")) {
			    i19 = 5;
			    aString817 = aString817.substring(6);
			}
			if (aString817.startsWith("flash1:")) {
			    i19 = 6;
			    aString817 = aString817.substring(7);
			}
			if (aString817.startsWith("flash2:")) {
			    i19 = 7;
			    aString817 = aString817.substring(7);
			}
			if (aString817.startsWith("flash3:")) {
			    i19 = 8;
			    aString817 = aString817.substring(7);
			}
			if (aString817.startsWith("glow1:")) {
			    i19 = 9;
			    aString817 = aString817.substring(6);
			}
			if (aString817.startsWith("glow2:")) {
			    i19 = 10;
			    aString817 = aString817.substring(6);
			}
			if (aString817.startsWith("glow3:")) {
			    i19 = 11;
			    aString817 = aString817.substring(6);
			}
			int i20 = 0;
			if (aString817.startsWith("wave:")) {
			    i20 = 1;
			    aString817 = aString817.substring(5);
			}
			if (aString817.startsWith("scroll:")) {
			    i20 = 2;
			    aString817 = aString817.substring(7);
			}
			aClass33_Sub2_Sub3_696.method334(false, 18);
			aClass33_Sub2_Sub3_696.method335(0);
			int i21 = aClass33_Sub2_Sub3_696.anInt1108;
			aClass33_Sub2_Sub3_696.method335(i19);
			aClass33_Sub2_Sub3_696.method335(i20);
			Class36.method380(aClass33_Sub2_Sub3_696, aString817,
					  0);
			aClass33_Sub2_Sub3_696.method341
			    (-529, aClass33_Sub2_Sub3_696.anInt1108 - i21);
			aString817 = Class35.method377(aString817, 86);
			aString817 = Class16.method153(anInt946, aString817);
			((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			    .aString1142
			    = aString817;
			((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			    .anInt1144
			    = i19;
			((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			    .anInt1145
			    = i20;
			((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			    .anInt1143
			    = 150;
			method81(2,
				 ((Class33_Sub7_Sub2_Sub2)
				  aClass33_Sub7_Sub2_Sub2_792).aString1273,
				 ((Class33_Sub7_Sub2)
				  aClass33_Sub7_Sub2_Sub2_792).aString1142,
				 36887);
			if (anInt802 == 2) {
			    anInt802 = 1;
			    aBoolean894 = true;
			    aClass33_Sub2_Sub3_696.method334(false, 173);
			    aClass33_Sub2_Sub3_696.method335(anInt802);
			    aClass33_Sub2_Sub3_696.method335(anInt765);
			    aClass33_Sub2_Sub3_696.method335(anInt742);
			}
		    }
		    aString817 = "";
		    aBoolean760 = true;
		}
	    }
	}
	idleTime++;
	if (idleTime > 4500) {
	    idleTime -= 500;
	    aClass33_Sub2_Sub3_696.method334(false, 135);
	}
	anInt866++;
	if (anInt866 > 500) {
	    anInt866 = 0;
	    int i = (int) (Math.random() * 8.0);
	    if ((i & 0x1) == 1)
		anInt781 += anInt782;
	    if ((i & 0x2) == 2)
		anInt803 += anInt804;
	    if ((i & 0x4) == 4)
		anInt807 += anInt808;
	}
	if (anInt781 < -50)
	    anInt782 = 2;
	if (anInt781 > 50)
	    anInt782 = -2;
	if (anInt803 < -55)
	    anInt804 = 2;
	if (anInt803 > 55)
	    anInt804 = -2;
	if (anInt807 < -40)
	    anInt808 = 1;
	if (anInt807 > 40)
	    anInt808 = -1;
	anInt716++;
	if (anInt716 > 50)
	    aClass33_Sub2_Sub3_696.method334(false, 223);
	do {
	    try {
		if (aClass5_730 == null
		    || aClass33_Sub2_Sub3_696.anInt1108 <= 0)
		    break;
		aClass5_730.method129(0, 0,
				      aClass33_Sub2_Sub3_696.aByteArray1107,
				      aClass33_Sub2_Sub3_696.anInt1108);
		aClass33_Sub2_Sub3_696.anInt1108 = 0;
		anInt716 = 0;
	    } catch (IOException ioexception) {
		method33((byte) 4);
	    } catch (Exception exception) {
		method32(-36905);
		break;
	    }
	    break;
	} while (false);
    }
    
    public final void method35(boolean arg0) {
	int i = (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792).anInt1131
		 + anInt781);
	int i1 = (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792).anInt1132
		  + anInt803);
	if (anInt921 - i < -500 || anInt921 - i > 500 || anInt922 - i1 < -500
	    || anInt922 - i1 > 500) {
	    anInt921 = i;
	    anInt922 = i1;
	}
	if (anInt921 != i)
	    anInt921 += (i - anInt921) / 16;
	if (anInt922 != i1)
	    anInt922 += (i1 - anInt922) / 16;
	if (keyArray[1] == 1) {
	    client var_client = this;
	    int i2 = var_client.anInt923;
	    int i3 = (-24 - anInt923) / 2;
	    var_client.anInt923 = i3 + i2;
	} else if (keyArray[2] == 1) {
	    client var_client = this;
	    int i4 = var_client.anInt923;
	    int i5 = (24 - anInt923) / 2;
	    var_client.anInt923 = i5 + i4;
	} else
	    anInt923 /= 2;
	if (keyArray[3] == 1) {
	    client var_client = this;
	    int i6 = var_client.anInt924;
	    int i7 = (12 - anInt924) / 2;
	    var_client.anInt924 = i7 + i6;
	} else if (keyArray[4] == 1) {
	    client var_client = this;
	    int i8 = var_client.anInt924;
	    int i9 = (-12 - anInt924) / 2;
	    var_client.anInt924 = i9 + i8;
	} else
	    anInt924 /= 2;
	anInt750 = anInt750 + anInt923 / 2 & 0x7ff;
	if (arg0)
	    anInt714 = -1;
	anInt748 += anInt924 / 2;
	anInt749 = anInt750 + anInt807 & 0x7ff;
	if (anInt748 < 128)
	    anInt748 = 128;
	if (anInt748 > 383)
	    anInt748 = 383;
	int i10 = anInt921 >> 7;
	int i11 = anInt922 >> 7;
	int i12 = method39(anInt921, (byte) 42, anInt922, anInt858);
	int i13 = 0;
	if (i10 > 3 && i11 > 3 && i10 < 100 && i11 < 100) {
	    for (int i14 = i10 - 4; i14 <= i10 + 4; i14++) {
		for (int i15 = i11 - 4; i15 <= i11 + 4; i15++) {
		    int i16 = anInt858;
		    if (i16 < 3
			&& (aByteArrayArrayArray903[1][i14][i15] & 0x2) == 2)
			i16++;
		    int i17 = i12 - anIntArrayArrayArray756[i16][i14][i15];
		    if (i17 > i13)
			i13 = i17;
		}
	    }
	}
	int i18 = i13 * 192;
	if (i18 > 98048)
	    i18 = 98048;
	if (i18 < 32768)
	    i18 = 32768;
	if (i18 > anInt755)
	    anInt755 += (i18 - anInt755) / 24;
	else if (i18 < anInt755)
	    anInt755 += (i18 - anInt755) / 80;
    }
    
    public final void method36(int arg0) {
	anInt713 += arg0;
	if (aBoolean844) {
	    aBoolean844 = false;
	    aClass26_884.method191(aGraphics13, 0, 11);
	    aClass26_885.method191(aGraphics13, 0, 375);
	    aClass26_886.method191(aGraphics13, 729, 5);
	    aClass26_887.method191(aGraphics13, 752, 231);
	    aClass26_888.method191(aGraphics13, 0, 0);
	    aClass26_889.method191(aGraphics13, 561, 0);
	    aClass26_890.method191(aGraphics13, 520, 11);
	    aClass26_891.method191(aGraphics13, 520, 231);
	    aClass26_892.method191(aGraphics13, 501, 375);
	    aClass26_893.method191(aGraphics13, 0, 345);
	    aBoolean646 = true;
	    aBoolean760 = true;
	    aBoolean729 = true;
	    aBoolean894 = true;
	    if (anInt648 != 2) {
		aClass26_789.method191(aGraphics13, 8, 11);
		aClass26_788.method191(aGraphics13, 561, 5);
	    }
	}
	if (anInt648 == 2)
	    method37(44638);
	if (aBoolean881 && anInt812 == 1)
	    aBoolean646 = true;
	if (anInt704 != -1) {
	    boolean flag = method74((byte) -91, anInt761, anInt704);
	    if (flag)
		aBoolean646 = true;
	}
	if (anInt908 == 2)
	    aBoolean646 = true;
	if (aBoolean646) {
	    method84(746);
	    aBoolean646 = false;
	}
	if (anInt917 == -1) {
	    aClass6_677.anInt122 = anInt914 - anInt865 - 77;
	    if (mouseX > 453 && mouseX < 565 && mouseY > 350)
		method67(0, 463, mouseX - 22, 77, mouseY - 375, aClass6_677,
			 0, false, anInt914);
	    int i = anInt914 - 77 - aClass6_677.anInt122;
	    if (i < 0)
		i = 0;
	    if (i > anInt914 - 77)
		i = anInt914 - 77;
	    if (anInt865 != i) {
		anInt865 = i;
		aBoolean760 = true;
	    }
	}
	if (anInt917 != -1) {
	    boolean flag = method74((byte) -91, anInt761, anInt917);
	    if (flag)
		aBoolean760 = true;
	}
	if (anInt908 == 3)
	    aBoolean760 = true;
	if (aBoolean760) {
	    method82(anInt746);
	    aBoolean760 = false;
	}
	if (anInt648 == 2) {
	    if (aBoolean665 && anInt923 == 0 && anInt647 - anInt919 > 25) {
		anInt919 = anInt647;
		anInt918 = 1 - anInt918;
		if (anInt918 == 0)
		    method79(421);
		else
		    aClass26_788.method191(aGraphics13, 561, 5);
	    }
	    if (!aBoolean665) {
		method79(421);
		aClass26_788.method191(aGraphics13, 561, 5);
	    }
	}
	if (aBoolean729) {
	    aBoolean729 = false;
	    aClass26_879.method190(0);
	    aClass33_Sub2_Sub2_Sub3_669.method323(0, true, 0);
	    if (anInt704 == -1) {
		if (anInt712 == 0)
		    aClass33_Sub2_Sub2_Sub3_940.method323(29, true, 30);
		if (anInt712 == 1)
		    aClass33_Sub2_Sub2_Sub3_941.method323(59, true, 29);
		if (anInt712 == 2)
		    aClass33_Sub2_Sub2_Sub3_941.method323(87, true, 29);
		if (anInt712 == 3)
		    aClass33_Sub2_Sub2_Sub3_942.method323(115, true, 29);
		if (anInt712 == 4)
		    aClass33_Sub2_Sub2_Sub3_944.method323(156, true, 29);
		if (anInt712 == 5)
		    aClass33_Sub2_Sub2_Sub3_944.method323(184, true, 29);
		if (anInt712 == 6)
		    aClass33_Sub2_Sub2_Sub3_943.method323(212, true, 30);
		aClass33_Sub2_Sub2_Sub3_929.method323(39, true, 33);
	    }
	    aClass26_879.method191(aGraphics13, 520, 165);
	    aClass26_878.method190(0);
	    aClass33_Sub2_Sub2_Sub3_668.method323(0, true, 0);
	    if (anInt704 == -1) {
		if (anInt712 == 7)
		    aClass33_Sub2_Sub2_Sub3_871.method323(49, true, 0);
		if (anInt712 == 8)
		    aClass33_Sub2_Sub2_Sub3_872.method323(81, true, 0);
		if (anInt712 == 9)
		    aClass33_Sub2_Sub2_Sub3_872.method323(108, true, 0);
		if (anInt712 == 10)
		    aClass33_Sub2_Sub2_Sub3_873.method323(136, true, 1);
		if (anInt712 == 11)
		    aClass33_Sub2_Sub2_Sub3_875.method323(178, true, 0);
		if (anInt712 == 12)
		    aClass33_Sub2_Sub2_Sub3_875.method323(205, true, 0);
		if (anInt712 == 13)
		    aClass33_Sub2_Sub2_Sub3_874.method323(233, true, 0);
		aClass33_Sub2_Sub2_Sub3_930.method323(83, true, 4);
	    }
	    aClass26_878.method191(aGraphics13, 501, 492);
	    aClass26_789.method190(0);
	}
	if (aBoolean894) {
	    aBoolean894 = false;
	    aClass26_877.method190(0);
	    aClass33_Sub2_Sub2_Sub3_667.method323(0, true, 0);
	    aClass33_Sub2_Sub2_Sub4_653.method326(57, "Public chat", 33,
						  anInt861, 16777215, true);
	    if (anInt802 == 0)
		aClass33_Sub2_Sub2_Sub4_653.method326(57, "On", 46, anInt861,
						      65280, true);
	    if (anInt802 == 1)
		aClass33_Sub2_Sub2_Sub4_653
		    .method326(57, "Friends", 46, anInt861, 16776960, true);
	    if (anInt802 == 2)
		aClass33_Sub2_Sub2_Sub4_653.method326(57, "Off", 46, anInt861,
						      16711680, true);
	    aClass33_Sub2_Sub2_Sub4_653.method326(186, "Private chat", 33,
						  anInt861, 16777215, true);
	    if (anInt765 == 0)
		aClass33_Sub2_Sub2_Sub4_653.method326(186, "On", 46, anInt861,
						      65280, true);
	    if (anInt765 == 1)
		aClass33_Sub2_Sub2_Sub4_653
		    .method326(186, "Friends", 46, anInt861, 16776960, true);
	    if (anInt765 == 2)
		aClass33_Sub2_Sub2_Sub4_653.method326(186, "Off", 46, anInt861,
						      16711680, true);
	    aClass33_Sub2_Sub2_Sub4_653.method326(326, "Trade/duel", 33,
						  anInt861, 16777215, true);
	    if (anInt742 == 0)
		aClass33_Sub2_Sub2_Sub4_653.method326(326, "On", 46, anInt861,
						      65280, true);
	    if (anInt742 == 1)
		aClass33_Sub2_Sub2_Sub4_653
		    .method326(326, "Friends", 46, anInt861, 16776960, true);
	    if (anInt742 == 2)
		aClass33_Sub2_Sub2_Sub4_653.method326(326, "Off", 46, anInt861,
						      16711680, true);
	    aClass26_877.method191(aGraphics13, 0, 471);
	    aClass26_789.method190(0);
	}
	anInt761 = 0;
    }
    
    public final void method37(int arg0) {
	anInt945++;
	for (int i = -1; i < anInt737; i++) {
	    Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2;
	    int i1;
	    if (i == -1) {
		class33_sub7_sub2_sub2 = aClass33_Sub7_Sub2_Sub2_792;
		i1 = anInt735 << 14;
	    } else {
		class33_sub7_sub2_sub2 = (aClass33_Sub7_Sub2_Sub2Array736
					  [((client) this).anIntArray738[i]]);
		i1 = ((client) this).anIntArray738[i] << 14;
	    }
	    ((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2).aBoolean1292
		= false;
	    if ((aBoolean665 && anInt737 > 50 || anInt737 > 200) && i != -1
		&& (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1154
		    == ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1140))
		((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2).aBoolean1292
		    = true;
	    if (class33_sub7_sub2_sub2.method367(-29424)) {
		int i2
		    = (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1131
		       >> 7);
		int i3
		    = (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1132
		       >> 7);
		if (i2 >= 0 && i2 < 104 && i3 >= 0 && i3 < 104) {
		    if ((((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			 .aClass33_Sub2_Sub1_1287) != null
			&& anInt647 >= ((Class33_Sub7_Sub2_Sub2)
					class33_sub7_sub2_sub2).anInt1282
			&& anInt647 < ((Class33_Sub7_Sub2_Sub2)
				       class33_sub7_sub2_sub2).anInt1283) {
			((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			    .aBoolean1292
			    = false;
			((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			    .anInt1281
			    = method39(((Class33_Sub7_Sub2)
					class33_sub7_sub2_sub2).anInt1131,
				       (byte) 42,
				       ((Class33_Sub7_Sub2)
					class33_sub7_sub2_sub2).anInt1132,
				       anInt858);
			aClass27_806.method206
			    ((((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			      .anInt1288),
			     823,
			     (((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			      .anInt1289),
			     (((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			      .anInt1281),
			     (((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			      .anInt1291),
			     anInt858,
			     (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anInt1131),
			     null,
			     (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anInt1132),
			     (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anInt1133),
			     (((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			      .anInt1290),
			     i1, 60, class33_sub7_sub2_sub2);
		    } else {
			if (((((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anInt1131)
			     & 0x7f) == 64
			    && ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
				 .anInt1132)
				& 0x7f) == 64) {
			    if (anIntArrayArray883[i2][i3] == anInt945)
				continue;
			    anIntArrayArray883[i2][i3] = anInt945;
			}
			((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			    .anInt1281
			    = method39(((Class33_Sub7_Sub2)
					class33_sub7_sub2_sub2).anInt1131,
				       (byte) 42,
				       ((Class33_Sub7_Sub2)
					class33_sub7_sub2_sub2).anInt1132,
				       anInt858);
			aClass27_806.method205
			    ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anInt1133),
			     class33_sub7_sub2_sub2, i1,
			     (((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			      .anInt1281),
			     (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anInt1131),
			     anInt858,
			     (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anInt1134),
			     60,
			     (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anInt1132),
			     true, null);
		    }
		}
	    }
	}
	for (int i = 0; i < anInt935; i++) {
	    Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
		= (aClass33_Sub7_Sub2_Sub1Array934
		   [((client) this).anIntArray936[i]]);
	    int i4 = (((client) this).anIntArray936[i] << 14) + 536870912;
	    if (class33_sub7_sub2_sub1.method363(-29424)) {
		int i5
		    = (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1131
		       >> 7);
		int i6
		    = (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1132
		       >> 7);
		if (i5 >= 0 && i5 < 104 && i6 >= 0 && i6 < 104) {
		    if ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1135
			 == 1)
			&& ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			     .anInt1131)
			    & 0x7f) == 64
			&& ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			     .anInt1132)
			    & 0x7f) == 64) {
			if (anIntArrayArray883[i5][i6] == anInt945)
			    continue;
			anIntArrayArray883[i5][i6] = anInt945;
		    }
		    aClass27_806.method205
			((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			  .anInt1133),
			 class33_sub7_sub2_sub1, i4,
			 method39((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
				   .anInt1131),
				  (byte) 42,
				  (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
				   .anInt1132),
				  anInt858),
			 (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			  .anInt1131),
			 anInt858,
			 (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			  .anInt1134),
			 ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			   .anInt1135)
			  - 1) * 64 + 60,
			 (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			  .anInt1132),
			 true, null);
		}
	    }
	}
	for (Class33_Sub7_Sub3 class33_sub7_sub3
		 = (Class33_Sub7_Sub3) aClass22_897.method183();
	     class33_sub7_sub3 != null;
	     class33_sub7_sub3
		 = (Class33_Sub7_Sub3) aClass22_897.method185(-14092)) {
	    if (class33_sub7_sub3.anInt1183 != anInt858
		|| anInt647 > class33_sub7_sub3.anInt1189)
		class33_sub7_sub3.method258();
	    else if (anInt647 >= class33_sub7_sub3.anInt1188) {
		if (class33_sub7_sub3.anInt1192 > 0) {
		    Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
			= (aClass33_Sub7_Sub2_Sub1Array934
			   [class33_sub7_sub3.anInt1192 - 1]);
		    if (class33_sub7_sub2_sub1 != null)
			class33_sub7_sub3.method368
			    ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			      .anInt1132),
			     (method39(((Class33_Sub7_Sub2)
					class33_sub7_sub2_sub1).anInt1131,
				       (byte) 42,
				       ((Class33_Sub7_Sub2)
					class33_sub7_sub2_sub1).anInt1132,
				       class33_sub7_sub3.anInt1183)
			      - class33_sub7_sub3.anInt1187),
			     (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			      .anInt1131),
			     anInt661, anInt647);
		}
		if (class33_sub7_sub3.anInt1192 < 0) {
		    int i = -class33_sub7_sub3.anInt1192 - 1;
		    Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2;
		    if (i == anInt698)
			class33_sub7_sub2_sub2 = aClass33_Sub7_Sub2_Sub2_792;
		    else
			class33_sub7_sub2_sub2
			    = aClass33_Sub7_Sub2_Sub2Array736[i];
		    if (class33_sub7_sub2_sub2 != null)
			class33_sub7_sub3.method368
			    ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anInt1132),
			     (method39(((Class33_Sub7_Sub2)
					class33_sub7_sub2_sub2).anInt1131,
				       (byte) 42,
				       ((Class33_Sub7_Sub2)
					class33_sub7_sub2_sub2).anInt1132,
				       class33_sub7_sub3.anInt1183)
			      - class33_sub7_sub3.anInt1187),
			     (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anInt1131),
			     anInt661, anInt647);
		}
		class33_sub7_sub3.method369(0, anInt761);
		aClass27_806.method205(class33_sub7_sub3.anInt1202,
				       class33_sub7_sub3, -1,
				       (int) class33_sub7_sub3.aDouble1196,
				       (int) class33_sub7_sub3.aDouble1194,
				       anInt858, 0, 60,
				       (int) class33_sub7_sub3.aDouble1195,
				       true, null);
	    }
	}
	for (Class33_Sub7_Sub1 class33_sub7_sub1
		 = (Class33_Sub7_Sub1) aClass22_675.method183();
	     class33_sub7_sub1 != null;
	     class33_sub7_sub1
		 = (Class33_Sub7_Sub1) aClass22_675.method185(-14092)) {
	    if (class33_sub7_sub1.anInt1123 != anInt858
		|| class33_sub7_sub1.aBoolean1129)
		class33_sub7_sub1.method258();
	    else if (anInt647 >= class33_sub7_sub1.anInt1122) {
		class33_sub7_sub1.method359(anInt761, 30001);
		if (class33_sub7_sub1.aBoolean1129)
		    class33_sub7_sub1.method258();
		else
		    aClass27_806.method205(0, class33_sub7_sub1, -1,
					   class33_sub7_sub1.anInt1126,
					   class33_sub7_sub1.anInt1124,
					   class33_sub7_sub1.anInt1123, 0, 60,
					   class33_sub7_sub1.anInt1125, true,
					   null);
	    }
	}
	for (Class33_Sub5 class33_sub5
		 = (Class33_Sub5) aClass22_862.method183();
	     class33_sub5 != null;
	     class33_sub5 = (Class33_Sub5) aClass22_862.method185(-14092)) {
	    boolean flag = false;
	    class33_sub5.anInt998 += anInt761;
	    if (class33_sub5.anInt997 == -1) {
		class33_sub5.anInt997 = 0;
		flag = true;
	    }
	    while (class33_sub5.anInt998
		   > (class33_sub5.aClass10_996.anIntArray187
		      [class33_sub5.anInt997])) {
		class33_sub5.anInt998
		    -= (class33_sub5.aClass10_996.anIntArray187
			[class33_sub5.anInt997]) + 1;
		class33_sub5.anInt997++;
		flag = true;
		if (class33_sub5.anInt997
		    >= class33_sub5.aClass10_996.anInt184) {
		    class33_sub5.anInt997
			-= class33_sub5.aClass10_996.anInt188;
		    if (class33_sub5.anInt997 < 0
			|| (class33_sub5.anInt997
			    >= class33_sub5.aClass10_996.anInt184)) {
			class33_sub5.method258();
			flag = false;
			break;
		    }
		}
	    }
	    if (flag) {
		int i = 0;
		if (class33_sub5.anInt992 == 1)
		    i = aClass27_806.method218(class33_sub5.anInt991,
					       class33_sub5.anInt994,
					       (byte) -73,
					       class33_sub5.anInt993);
		if (class33_sub5.anInt992 == 2)
		    i = aClass27_806.method219(class33_sub5.anInt991,
					       class33_sub5.anInt993,
					       class33_sub5.anInt994);
		if (i == 0 || (i >> 14 & 0x7fff) != class33_sub5.anInt995)
		    class33_sub5.method258();
		else {
		    Class37 class37 = Class37.method383(class33_sub5.anInt995);
		    int i7 = -1;
		    if (class33_sub5.anInt997 != -1)
			i7 = (class33_sub5.aClass10_996.anIntArray185
			      [class33_sub5.anInt997]);
		    if (class33_sub5.anInt992 == 2) {
			int i8
			    = (aClass27_806.method221(class33_sub5.anInt991,
						      class33_sub5.anInt993,
						      class33_sub5.anInt994, i)
			       >> 6);
			Class33_Sub2_Sub1 class33_sub2_sub1
			    = class37.method386(10, i8, 0, 0, 0, 0, i7);
			aClass27_806.method210(class33_sub5.anInt991,
					       class33_sub5.anInt993,
					       class33_sub5.anInt994,
					       class33_sub2_sub1, true);
		    } else if (class33_sub5.anInt992 == 1) {
			Class33_Sub2_Sub1 class33_sub2_sub1
			    = class37.method386(4, 0, 0, 0, 0, 0, i7);
			aClass27_806.method211(class33_sub2_sub1,
					       class33_sub5.anInt993,
					       class33_sub5.anInt991, true,
					       class33_sub5.anInt994);
		    }
		}
	    }
	}
	int i = method39(anInt921, (byte) 42, anInt922, anInt858);
	anInt754 = anInt748;
	if (anInt755 / 256 > anInt754)
	    anInt754 = anInt755 / 256;
	method40(anInt922, anInt921, anInt749, i - 50, 0, anInt754,
		 anInt754 * 3 + 600);
	int i9 = 3;
	if (anInt754 < 310) {
	    int i10 = anInt751 >> 7;
	    int i11 = anInt753 >> 7;
	    int i12
		= (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792).anInt1131
		   >> 7);
	    int i13
		= (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792).anInt1132
		   >> 7);
	    if ((aByteArrayArrayArray903[anInt858][i10][i11] & 0x4) != 0)
		i9 = anInt858;
	    int i14;
	    if (i12 > i10)
		i14 = i12 - i10;
	    else
		i14 = i10 - i12;
	    int i15;
	    if (i13 > i11)
		i15 = i13 - i11;
	    else
		i15 = i11 - i13;
	    if (i14 > i15) {
		int i16 = i15 * 65536 / i14;
		int i17 = 32768;
		while (i10 != i12) {
		    if (i10 < i12)
			i10++;
		    else if (i10 > i12)
			i10--;
		    if ((aByteArrayArrayArray903[anInt858][i10][i11] & 0x4)
			!= 0)
			i9 = anInt858;
		    i17 += i16;
		    if (i17 >= 65536) {
			i17 -= 65536;
			if (i11 < i13)
			    i11++;
			else if (i11 > i13)
			    i11--;
			if ((aByteArrayArrayArray903[anInt858][i10][i11] & 0x4)
			    != 0)
			    i9 = anInt858;
		    }
		}
	    } else {
		int i18 = i14 * 65536 / i15;
		int i19 = 32768;
		while (i11 != i13) {
		    if (i11 < i13)
			i11++;
		    else if (i11 > i13)
			i11--;
		    if ((aByteArrayArrayArray903[anInt858][i10][i11] & 0x4)
			!= 0)
			i9 = anInt858;
		    i19 += i18;
		    if (i19 >= 65536) {
			i19 -= 65536;
			if (i10 < i12)
			    i10++;
			else if (i10 > i12)
			    i10--;
			if ((aByteArrayArrayArray903[anInt858][i10][i11] & 0x4)
			    != 0)
			    i9 = anInt858;
		    }
		}
	    }
	}
	if (((aByteArrayArrayArray903[anInt858]
	      [(((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792).anInt1131
		>> 7)]
	      [(((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792).anInt1132
		>> 7)])
	     & 0x4)
	    != 0)
	    i9 = anInt858;
	int i20 = Class33_Sub2_Sub2_Sub1.anInt1229;
	Class33_Sub2_Sub1.aBoolean1077 = true;
	Class33_Sub2_Sub1.anInt1080 = 0;
	Class33_Sub2_Sub1.anInt1078 = mouseX - 8;
	Class33_Sub2_Sub1.anInt1079 = mouseY - 11;
	if (arg0 == 44638) {
	    Class33_Sub2_Sub2.method287(2);
	    aClass27_806.method230(anInt751, anInt752, anInt753, anInt754,
				   anInt749, i9);
	    aClass27_806.method208(false);
	    for (int i21 = -1; i21 < anInt737 + anInt935; i21++) {
		Class33_Sub7_Sub2 class33_sub7_sub2;
		if (i21 == -1)
		    class33_sub7_sub2 = aClass33_Sub7_Sub2_Sub2_792;
		else if (i21 < anInt737)
		    class33_sub7_sub2 = (aClass33_Sub7_Sub2_Sub2Array736
					 [((client) this).anIntArray738[i21]]);
		else
		    class33_sub7_sub2
			= (aClass33_Sub7_Sub2_Sub1Array934
			   [((client) this).anIntArray936[i21 - anInt737]]);
		if (i21 < anInt737) {
		    Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
			= (Class33_Sub7_Sub2_Sub2) class33_sub7_sub2;
		    if ((((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			 .anInt1276)
			!= 0) {
			method38((((Class33_Sub7_Sub2) class33_sub7_sub2)
				  .anInt1175) + 15,
				 0, class33_sub7_sub2);
			if (anInt659 > -1) {
			    int i22 = 28;
			    for (int i23 = 0; i23 < 8; i23++) {
				if ((((Class33_Sub7_Sub2_Sub2)
				      class33_sub7_sub2_sub2).anInt1276
				     & 1 << i23)
				    != 0) {
				    aClass33_Sub2_Sub2_Sub2Array632[i23]
					.method312
					(anInt659 - 12, true, anInt660 - i22);
				    i22 -= 25;
				}
			    }
			}
		    }
		}
		if (((Class33_Sub7_Sub2) class33_sub7_sub2).aString1142 != null
		    && (i21 >= anInt737 || anInt802 == 0
			|| anInt802 == 1 && method83((((Class33_Sub7_Sub2_Sub2)
						       (Class33_Sub7_Sub2_Sub2)
						       class33_sub7_sub2)
						      .aString1273),
						     (byte) -21))) {
		    method38(((Class33_Sub7_Sub2) class33_sub7_sub2).anInt1175,
			     0, class33_sub7_sub2);
		    if (anInt659 > -1) {
			if (anInt718 == 0) {
			    int i24 = 16776960;
			    if ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				 .anInt1144)
				< 6)
				i24 = anIntArray796[(((Class33_Sub7_Sub2)
						      class33_sub7_sub2)
						     .anInt1144)];
			    if ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				 .anInt1144)
				== 6)
				i24 = anInt945 % 20 < 10 ? 16711680 : 16776960;
			    if ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				 .anInt1144)
				== 7)
				i24 = anInt945 % 20 < 10 ? 255 : 65535;
			    if ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				 .anInt1144)
				== 8)
				i24 = anInt945 % 20 < 10 ? 45056 : 8454016;
			    if ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				 .anInt1144)
				== 9) {
				int i25 = 150 - ((Class33_Sub7_Sub2)
						 class33_sub7_sub2).anInt1143;
				if (i25 < 50)
				    i24 = 16711680 + i25 * 1280;
				else if (i25 < 100)
				    i24 = 16776960 - (i25 - 50) * 327680;
				else if (i25 < 150)
				    i24 = 65280 + (i25 - 100) * 5;
			    }
			    if ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				 .anInt1144)
				== 10) {
				int i26 = 150 - ((Class33_Sub7_Sub2)
						 class33_sub7_sub2).anInt1143;
				if (i26 < 50)
				    i24 = 16711680 + i26 * 5;
				else if (i26 < 100)
				    i24 = 16711935 - (i26 - 50) * 327680;
				else if (i26 < 150)
				    i24 = (255 + (i26 - 100) * 327680
					   - (i26 - 100) * 5);
			    }
			    if ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				 .anInt1144)
				== 11) {
				int i27 = 150 - ((Class33_Sub7_Sub2)
						 class33_sub7_sub2).anInt1143;
				if (i27 < 50)
				    i24 = 16777215 - i27 * 327685;
				else if (i27 < 100)
				    i24 = 65280 + (i27 - 50) * 327685;
				else if (i27 < 150)
				    i24 = 16777215 - (i27 - 100) * 327680;
			    }
			    if ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				 .anInt1145)
				== 0) {
				aClass33_Sub2_Sub2_Sub4_654.method325
				    (anInt660 + 1, aBoolean876, anInt659, 0,
				     (((Class33_Sub7_Sub2) class33_sub7_sub2)
				      .aString1142));
				aClass33_Sub2_Sub2_Sub4_654.method325
				    (anInt660, aBoolean876, anInt659, i24,
				     (((Class33_Sub7_Sub2) class33_sub7_sub2)
				      .aString1142));
			    }
			    if ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				 .anInt1145)
				== 1) {
				aClass33_Sub2_Sub2_Sub4_654.method329
				    (anInt659, 0, (byte) 71, anInt945,
				     anInt660 + 1,
				     (((Class33_Sub7_Sub2) class33_sub7_sub2)
				      .aString1142));
				aClass33_Sub2_Sub2_Sub4_654.method329
				    (anInt659, i24, (byte) 71, anInt945,
				     anInt660,
				     (((Class33_Sub7_Sub2) class33_sub7_sub2)
				      .aString1142));
			    }
			    if ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				 .anInt1145)
				== 2) {
				int i28
				    = (aClass33_Sub2_Sub2_Sub4_654.method327
				       (331, ((Class33_Sub7_Sub2)
					      class33_sub7_sub2).aString1142));
				int i29
				    = ((150 - ((Class33_Sub7_Sub2)
					       class33_sub7_sub2).anInt1143)
				       * (i28 + 100) / 150);
				Class33_Sub2_Sub2.method286(anInt659 + 50,
							    aByte773,
							    anInt659 - 50, 0,
							    334);
				aClass33_Sub2_Sub2_Sub4_654.method328
				    ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				      .aString1142),
				     anInt659 + 50 - i29, anInt660 + 1, 0,
				     -200);
				aClass33_Sub2_Sub2_Sub4_654.method328
				    ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				      .aString1142),
				     anInt659 + 50 - i29, anInt660, i24, -200);
				Class33_Sub2_Sub2.method285((byte) 9);
			    }
			} else {
			    aClass33_Sub2_Sub2_Sub4_654.method325
				(anInt660 + 1, aBoolean876, anInt659, 0,
				 (((Class33_Sub7_Sub2) class33_sub7_sub2)
				  .aString1142));
			    aClass33_Sub2_Sub2_Sub4_654.method325
				(anInt660, aBoolean876, anInt659, 16776960,
				 (((Class33_Sub7_Sub2) class33_sub7_sub2)
				  .aString1142));
			}
		    }
		}
		if (((Class33_Sub7_Sub2) class33_sub7_sub2).anInt1148
		    > anInt647 + 100) {
		    method38((((Class33_Sub7_Sub2) class33_sub7_sub2).anInt1175
			      + 15),
			     0, class33_sub7_sub2);
		    if (anInt659 > -1) {
			int i30 = ((((Class33_Sub7_Sub2) class33_sub7_sub2)
				    .anInt1149)
				   * 30
				   / (((Class33_Sub7_Sub2) class33_sub7_sub2)
				      .anInt1150));
			if (i30 > 30)
			    i30 = 30;
			Class33_Sub2_Sub2.method288(65280, i30, anInt660 - 3,
						    false, 5, anInt659 - 15);
			Class33_Sub2_Sub2.method288(16711680, 30 - i30,
						    anInt660 - 3, false, 5,
						    anInt659 - 15 + i30);
		    }
		}
		if (((Class33_Sub7_Sub2) class33_sub7_sub2).anInt1148
		    > anInt647 + 330) {
		    method38((((Class33_Sub7_Sub2) class33_sub7_sub2).anInt1175
			      / 2),
			     0, class33_sub7_sub2);
		    if (anInt659 > -1) {
			aClass33_Sub2_Sub2_Sub2Array651
			    [((Class33_Sub7_Sub2) class33_sub7_sub2).anInt1147]
			    .method312(anInt659 - 12, true, anInt660 - 12);
			aClass33_Sub2_Sub2_Sub4_652.method325
			    (anInt660 + 4, aBoolean876, anInt659, 0,
			     String.valueOf(((Class33_Sub7_Sub2)
					     class33_sub7_sub2).anInt1146));
			aClass33_Sub2_Sub2_Sub4_652.method325
			    (anInt660 + 3, aBoolean876, anInt659 - 1, 16777215,
			     String.valueOf(((Class33_Sub7_Sub2)
					     class33_sub7_sub2).anInt1146));
		    }
		}
	    }
	    if (anInt839 == 1)
		aClass33_Sub2_Sub2_Sub2Array869[anInt838 / 100]
		    .method312(anInt836 - 8 - 8, true, anInt837 - 8 - 11);
	    if (anInt839 == 2)
		aClass33_Sub2_Sub2_Sub2Array869[anInt838 / 100 + 4]
		    .method312(anInt836 - 8 - 8, true, anInt837 - 8 - 11);
	    if (anInt709 != -1)
		method66(0, Class6.aClass6Array105[anInt709], 0, 0, -204);
	    int i31
		= ((((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792).anInt1131
		    >> 7)
		   + anInt925);
	    int i32
		= ((((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792).anInt1132
		    >> 7)
		   + anInt926);
	    if (i31 >= 2944 && i31 < 3392 && i32 >= 3520 && i32 < 6400)
		anInt728 = (i32 - 3520) / 8 + 1;
	    else
		anInt728 = 0;
	    if (!aBoolean881) {
		method61((byte) 0);
		method57(true);
	    } else if (anInt812 == 0)
		method58(false);
	    if (!aBoolean665
		&& Class33_Sub2_Sub2_Sub1.anIntArray1228[17] >= i20) {
		Class33_Sub2_Sub2_Sub3 class33_sub2_sub2_sub3
		    = (Class33_Sub2_Sub2_Sub1.aClass33_Sub2_Sub2_Sub3Array1222
		       [17]);
		int i33 = ((class33_sub2_sub2_sub3.anInt1248
			    * class33_sub2_sub2_sub3.anInt1249)
			   - 1);
		int i34 = class33_sub2_sub2_sub3.anInt1248 * anInt761 * 2;
		byte[] bytes = class33_sub2_sub2_sub3.aByteArray1246;
		byte[] bytes35 = aByteArray786;
		for (int i36 = 0; i36 <= i33; i36++)
		    bytes35[i36] = bytes[i36 - i34 & i33];
		class33_sub2_sub2_sub3.aByteArray1246 = bytes35;
		aByteArray786 = bytes;
		Class33_Sub2_Sub2_Sub1.method299(17, 423);
	    }
	    if (anInt744 == 1)
		aClass33_Sub2_Sub2_Sub2Array632[1].method312(5, true, 296);
	    if (anInt728 > 0) {
		aClass33_Sub2_Sub2_Sub2Array632[0].method312(472, true, 296);
		aClass33_Sub2_Sub2_Sub4_653.method325(329, aBoolean876, 484,
						      16776960,
						      "Level: " + anInt728);
	    } else if (aBoolean665) {
		int i37 = 16776960;
		Runtime runtime = Runtime.getRuntime();
		long l = runtime.totalMemory();
		long l38 = runtime.freeMemory();
		if (!signlink.sunjava && l - l38 > 33554432L
		    && anInt647 > anInt902 + 500) {
		    method31(false);
		    runtime.gc();
		    i37 = 16711680;
		    anInt902 = anInt647;
		}
	    }
	    if (anInt732 != 0) {
		int i39 = anInt732 / 50;
		int i40 = i39 / 60;
		i39 %= 60;
		if (i39 < 10)
		    aClass33_Sub2_Sub2_Sub4_653.method325(329, aBoolean876,
							  256, 16776960,
							  ("System update in: "
							   + i40 + ":0"
							   + i39));
		else
		    aClass33_Sub2_Sub2_Sub4_653.method325(329, aBoolean876,
							  256, 16776960,
							  ("System update in: "
							   + i40 + ":" + i39));
	    }
	    aClass26_789.method191(aGraphics13, 8, 11);
	}
    }
    
    public final void method38(int arg0, int arg1, Class33_Sub7_Sub2 arg2) {
	int i = ((Class33_Sub7_Sub2) arg2).anInt1131;
	int i1 = ((Class33_Sub7_Sub2) arg2).anInt1132;
	int i2 = (method39(((Class33_Sub7_Sub2) arg2).anInt1131, (byte) 42,
			   ((Class33_Sub7_Sub2) arg2).anInt1132, anInt858)
		  - arg0);
	anInt754 = anInt748;
	if (anInt755 / 256 > anInt754)
	    anInt754 = anInt755 / 256;
	i -= anInt751;
	i2 -= anInt752;
	anInt713 += arg1;
	i1 -= anInt753;
	int i3 = Class33_Sub2_Sub1.anIntArray1082[anInt754];
	int i4 = Class33_Sub2_Sub1.anIntArray1083[anInt754];
	int i5 = Class33_Sub2_Sub1.anIntArray1082[anInt749];
	int i6 = Class33_Sub2_Sub1.anIntArray1083[anInt749];
	int i7 = i1 * i5 + i * i6 >> 16;
	i1 = i1 * i6 - i * i5 >> 16;
	i = i7;
	i7 = i2 * i4 - i1 * i3 >> 16;
	i1 = i2 * i3 + i1 * i4 >> 16;
	i2 = i7;
	if (i1 >= 50) {
	    anInt659 = Class33_Sub2_Sub2_Sub1.anInt1214 + (i << 9) / i1;
	    anInt660 = Class33_Sub2_Sub2_Sub1.anInt1215 + (i2 << 9) / i1;
	} else {
	    anInt659 = -1;
	    anInt660 = -1;
	}
    }
    
    public final int method39(int arg0, byte arg1, int arg2, int arg3) {
	int i = arg0 >> 7;
	int i1 = arg2 >> 7;
	int i2 = arg3;
	if (i2 < 3 && (aByteArrayArrayArray903[1][i][i1] & 0x2) == 2)
	    i2++;
	int i3 = arg0 & 0x7f;
	int i4 = arg2 & 0x7f;
	int i5 = ((anIntArrayArrayArray756[i2][i][i1] * (128 - i3)
		   + anIntArrayArrayArray756[i2][i + 1][i1] * i3)
		  >> 7);
	int i6 = ((anIntArrayArrayArray756[i2][i][i1 + 1] * (128 - i3)
		   + anIntArrayArrayArray756[i2][i + 1][i1 + 1] * i3)
		  >> 7);
	if (arg1 != 42)
	    anInt746 = -181;
	return i5 * (128 - i4) + i6 * i4 >> 7;
    }
    
    public final void method40(int arg0, int arg1, int arg2, int arg3,
			       int arg4, int arg5, int arg6) {
	int i = 2048 - arg5 & 0x7ff;
	int i1 = 2048 - arg2 & 0x7ff;
	int i2 = 0;
	int i3 = 0;
	int i4 = arg6;
	if (i != 0) {
	    int i5 = Class33_Sub2_Sub1.anIntArray1082[i];
	    int i6 = Class33_Sub2_Sub1.anIntArray1083[i];
	    int i7 = i3 * i6 - i4 * i5 >> 16;
	    i4 = i3 * i5 + i4 * i6 >> 16;
	    i3 = i7;
	}
	if (i1 != 0) {
	    int i8 = Class33_Sub2_Sub1.anIntArray1082[i1];
	    int i9 = Class33_Sub2_Sub1.anIntArray1083[i1];
	    int i10 = i4 * i8 + i2 * i9 >> 16;
	    i4 = i4 * i9 - i2 * i8 >> 16;
	    i2 = i10;
	}
	anInt751 = arg1 - i2;
	if (arg4 != 0)
	    anInt714 = -1;
	anInt752 = arg3 - i3;
	anInt753 = arg0 - i4;
    }
    
    public final void method41(byte arg0) {
	try {
	    anInt870 = -1;
	    aClass22_868.method187();
	    aClass22_862.method187();
	    aClass22_675.method187();
	    aClass22_897.method187();
	    Class33_Sub2_Sub2_Sub1.method295(false);
	    method31(false);
	    aClass27_806.method194(false);
	    for (int i = 0; i < 4; i++)
		aClass1Array638[i].method92(573);
	    System.gc();
	    Class3 class3 = new Class3(aByteArrayArrayArray903,
				       anIntArrayArrayArray756, 104, 104, 8);
	    byte[] bytes = new byte[100000];
	    int i = aByteArrayArray764.length;
	    if (aBoolean665)
		aClass27_806.method195(anInt858, -841);
	    else
		aClass27_806.method195(0, -841);
	    for (int i1 = 0; i1 < i; i1++) {
		int i2 = (anIntArray670[i1] >> 8) * 64 - anInt925;
		int i3 = (anIntArray670[i1] & 0xff) * 64 - anInt926;
		byte[] bytes4 = aByteArrayArray764[i1];
		if (bytes4 != null) {
		    int i5
			= new Class33_Sub2_Sub3(bytes4, (byte) 63).method347();
		    Class28.method242(bytes, i5, bytes4, bytes4.length - 4, 4);
		    class3.method108(-16770, bytes, (anInt681 - 6) * 8, i3, i2,
				     (anInt682 - 6) * 8);
		} else if (anInt682 < 800)
		    class3.method107(i3, 64, 64, i2, (byte) -98);
	    }
	    for (int i6 = 0; i6 < i; i6++) {
		byte[] bytes7 = aByteArrayArray795[i6];
		if (bytes7 != null) {
		    int i8
			= new Class33_Sub2_Sub3(bytes7, (byte) 63).method347();
		    Class28.method242(bytes, i8, bytes7, bytes7.length - 4, 4);
		    int i9 = (anIntArray670[i6] >> 8) * 64 - anInt925;
		    int i10 = (anIntArray670[i6] & 0xff) * 64 - anInt926;
		    class3.method109(bytes, aClass22_862, aClass1Array638,
				     aClass27_806, i10, i9, -576);
		}
	    }
	    class3.method111(aClass1Array638, aClass27_806, -910);
	    aClass26_789.method190(0);
	    for (int i11 = 0; i11 < 104; i11++) {
		for (int i12 = 0; i12 < 104; i12++)
		    method54(i11, i12);
	    }
	    for (Class33_Sub3 class33_sub3
		     = (Class33_Sub3) aClass22_697.method183();
		 class33_sub3 != null;
		 class33_sub3 = (Class33_Sub3) aClass22_697.method185(-14092))
		method52(class33_sub3.anInt973, class33_sub3.anInt979,
			 class33_sub3.anInt976, (byte) 120,
			 class33_sub3.anInt975, class33_sub3.anInt974,
			 class33_sub3.anInt978, class33_sub3.anInt977);
	} catch (Exception exception) {
	}
	Class37.aClass29_554.method252();
	System.gc();
	Class33_Sub2_Sub2_Sub1.method296(20, (byte) 2);
	if (arg0 == 5) {
	    boolean flag = false;
	} else
	    anInt714 = -1;
    }
    
    public final void method42(int arg0, int arg1) {
	int[] ints = aClass33_Sub2_Sub2_Sub2_932.anIntArray1236;
	int i = ints.length;
	for (int i1 = 0; i1 < i; i1++)
	    ints[i1] = 0;
	for (int i2 = 1; i2 < 103; i2++) {
	    int i3 = (103 - i2) * 512 * 4 + 24628;
	    for (int i4 = 1; i4 < 103; i4++) {
		if ((aByteArrayArrayArray903[arg0][i4][i2] & 0x18) == 0)
		    aClass27_806.method226(ints, i3, 512, arg0, i4, i2);
		if (arg0 < 3
		    && (aByteArrayArrayArray903[arg0 + 1][i4][i2] & 0x8) != 0)
		    aClass27_806.method226(ints, i3, 512, arg0 + 1, i4, i2);
		i3 += 4;
	    }
	}
	aClass33_Sub2_Sub2_Sub2_932.method309(0);
	for (int i5 = 1; i5 < 103; i5++) {
	    for (int i6 = 1; i6 < 103; i6++) {
		if ((aByteArrayArrayArray903[arg0][i6][i5] & 0x18) == 0)
		    method43(false, i6, i5, arg0);
		if (arg0 < 3
		    && (aByteArrayArrayArray903[arg0 + 1][i6][i5] & 0x8) != 0)
		    method43(false, i6, i5, arg0 + 1);
	    }
	}
	aClass26_789.method190(0);
	if (arg1 >= 0)
	    aBoolean672 = !aBoolean672;
	anInt662 = 0;
	for (int i7 = 0; i7 < 104; i7++) {
	    for (int i8 = 0; i8 < 104; i8++) {
		int i9 = aClass27_806.method220(anInt858, i7, i8);
		if (i9 != 0) {
		    i9 = i9 >> 14 & 0x7fff;
		    int i10 = Class37.method383(i9).anInt546;
		    if (i10 >= 0) {
			aClass33_Sub2_Sub2_Sub2Array798[anInt662]
			    = aClass33_Sub2_Sub2_Sub2Array777[i10];
			anIntArray663[anInt662] = i7;
			anIntArray664[anInt662] = i8;
			anInt662++;
		    }
		}
	    }
	}
    }
    
    public final void method43(boolean arg0, int arg1, int arg2, int arg3) {
	int i = aClass27_806.method217(arg3, arg1, arg2);
	if (i != 0) {
	    int i1 = aClass27_806.method221(arg3, arg1, arg2, i);
	    int i2 = i1 >> 6 & 0x3;
	    int i3 = i1 & 0x1f;
	    int i4 = 15658734;
	    if (i > 0)
		i4 = 15597568;
	    int[] ints = aClass33_Sub2_Sub2_Sub2_932.anIntArray1236;
	    int i5 = arg1 * 4 + 24624 + (103 - arg2) * 512 * 4;
	    if (i3 == 0 || i3 == 2) {
		if (i2 == 0) {
		    ints[i5] = i4;
		    ints[i5 + 512] = i4;
		    ints[i5 + 1024] = i4;
		    ints[i5 + 1536] = i4;
		} else if (i2 == 1) {
		    ints[i5] = i4;
		    ints[i5 + 1] = i4;
		    ints[i5 + 2] = i4;
		    ints[i5 + 3] = i4;
		} else if (i2 == 2) {
		    ints[i5 + 3] = i4;
		    ints[i5 + 3 + 512] = i4;
		    ints[i5 + 3 + 1024] = i4;
		    ints[i5 + 3 + 1536] = i4;
		} else if (i2 == 3) {
		    ints[i5 + 1536] = i4;
		    ints[i5 + 1536 + 1] = i4;
		    ints[i5 + 1536 + 2] = i4;
		    ints[i5 + 1536 + 3] = i4;
		}
	    }
	    if (i3 == 3) {
		if (i2 == 0)
		    ints[i5] = i4;
		else if (i2 == 1)
		    ints[i5 + 3] = i4;
		else if (i2 == 2)
		    ints[i5 + 3 + 1536] = i4;
		else if (i2 == 3)
		    ints[i5 + 1536] = i4;
	    }
	    if (i3 == 2) {
		if (i2 == 3) {
		    ints[i5] = i4;
		    ints[i5 + 512] = i4;
		    ints[i5 + 1024] = i4;
		    ints[i5 + 1536] = i4;
		} else if (i2 == 0) {
		    ints[i5] = i4;
		    ints[i5 + 1] = i4;
		    ints[i5 + 2] = i4;
		    ints[i5 + 3] = i4;
		} else if (i2 == 1) {
		    ints[i5 + 3] = i4;
		    ints[i5 + 3 + 512] = i4;
		    ints[i5 + 3 + 1024] = i4;
		    ints[i5 + 3 + 1536] = i4;
		} else if (i2 == 2) {
		    ints[i5 + 1536] = i4;
		    ints[i5 + 1536 + 1] = i4;
		    ints[i5 + 1536 + 2] = i4;
		    ints[i5 + 1536 + 3] = i4;
		}
	    }
	}
	i = aClass27_806.method219(arg3, arg1, arg2);
	if (!arg0) {
	    if (i != 0) {
		int i6 = aClass27_806.method221(arg3, arg1, arg2, i);
		int i7 = i6 >> 6 & 0x3;
		int i8 = i6 & 0x1f;
		if (i8 == 9) {
		    int i9 = 15658734;
		    if (i > 0)
			i9 = 15597568;
		    int[] ints = aClass33_Sub2_Sub2_Sub2_932.anIntArray1236;
		    int i10 = arg1 * 4 + 24624 + (103 - arg2) * 512 * 4;
		    if (i7 == 0 || i7 == 2) {
			ints[i10 + 1536] = i9;
			ints[i10 + 1024 + 1] = i9;
			ints[i10 + 512 + 2] = i9;
			ints[i10 + 3] = i9;
		    } else {
			ints[i10] = i9;
			ints[i10 + 512 + 1] = i9;
			ints[i10 + 1024 + 2] = i9;
			ints[i10 + 1536 + 3] = i9;
		    }
		}
		if (i8 == 10 || i8 == 11) {
		    int i11 = i >> 14 & 0x7fff;
		    Class37 class37 = Class37.method383(i11);
		    if (class37.anInt547 != -1) {
			Class33_Sub2_Sub2_Sub3 class33_sub2_sub2_sub3
			    = (aClass33_Sub2_Sub2_Sub3Array896
			       [class37.anInt547]);
			int i12 = ((class37.anInt532 * 4
				    - class33_sub2_sub2_sub3.anInt1248)
				   / 2);
			int i13 = ((class37.anInt533 * 4
				    - class33_sub2_sub2_sub3.anInt1249)
				   / 2);
			class33_sub2_sub2_sub3.method323
			    (arg1 * 4 + 48 + i12, true,
			     48 + (104 - arg2 - class37.anInt533) * 4 + i13);
		    }
		}
	    }
	}
    }
    
    public final void method44(byte arg0, int arg1, Class33_Sub7_Sub2 arg2,
			       int arg3) {
	if (arg0 != 0)
	    anInt714 = -1;
	if (arg2 == null)
	    System.out.println("null entity");
	else {
	    if (((Class33_Sub7_Sub2) arg2).anInt1131 < 0
		|| ((Class33_Sub7_Sub2) arg2).anInt1132 < 0
		|| ((Class33_Sub7_Sub2) arg2).anInt1131 >= 13312
		|| ((Class33_Sub7_Sub2) arg2).anInt1132 >= 13312) {
		((Class33_Sub7_Sub2) arg2).anInt1157 = -1;
		((Class33_Sub7_Sub2) arg2).anInt1162 = -1;
		((Class33_Sub7_Sub2) arg2).anInt1171 = 0;
		((Class33_Sub7_Sub2) arg2).anInt1172 = 0;
		((Class33_Sub7_Sub2) arg2).anInt1131
		    = (((Class33_Sub7_Sub2) arg2).anIntArray1178[0] * 128
		       + ((Class33_Sub7_Sub2) arg2).anInt1135 * 64);
		((Class33_Sub7_Sub2) arg2).anInt1132
		    = (((Class33_Sub7_Sub2) arg2).anIntArray1179[0] * 128
		       + ((Class33_Sub7_Sub2) arg2).anInt1135 * 64);
		((Class33_Sub7_Sub2) arg2).anInt1177 = 0;
	    }
	    boolean flag = false;
	    if (((Class33_Sub7_Sub2) arg2).anInt1157 != -1
		&& ((Class33_Sub7_Sub2) arg2).anInt1160 == 0) {
		try {
		    Class10 class10 = (Class10.aClass10Array183
				       [((Class33_Sub7_Sub2) arg2).anInt1157]);
		    if (class10.anIntArray189 == null) {
			flag = true;
			((Class33_Sub7_Sub2) arg2).anInt1180++;
		    }
		} catch (Exception exception) {
		    System.out.println("e2: "
				       + ((Class33_Sub7_Sub2) arg2).anInt1157);
		}
	    }
	    if (((Class33_Sub7_Sub2) arg2).anInt1171 > anInt647) {
		int i = ((Class33_Sub7_Sub2) arg2).anInt1171 - anInt647;
		int i1 = (((Class33_Sub7_Sub2) arg2).anInt1167 * 128
			  + ((Class33_Sub7_Sub2) arg2).anInt1135 * 64);
		int i2 = (((Class33_Sub7_Sub2) arg2).anInt1169 * 128
			  + ((Class33_Sub7_Sub2) arg2).anInt1135 * 64);
		((Class33_Sub7_Sub2) arg2).anInt1131
		    += (i1 - ((Class33_Sub7_Sub2) arg2).anInt1131) / i;
		((Class33_Sub7_Sub2) arg2).anInt1132
		    += (i2 - ((Class33_Sub7_Sub2) arg2).anInt1132) / i;
		((Class33_Sub7_Sub2) arg2).anInt1180 = 0;
		if (((Class33_Sub7_Sub2) arg2).anInt1173 == 0)
		    ((Class33_Sub7_Sub2) arg2).anInt1176 = 1024;
		if (((Class33_Sub7_Sub2) arg2).anInt1173 == 1)
		    ((Class33_Sub7_Sub2) arg2).anInt1176 = 1536;
		if (((Class33_Sub7_Sub2) arg2).anInt1173 == 2)
		    ((Class33_Sub7_Sub2) arg2).anInt1176 = 0;
		if (((Class33_Sub7_Sub2) arg2).anInt1173 == 3)
		    ((Class33_Sub7_Sub2) arg2).anInt1176 = 512;
	    } else if (((Class33_Sub7_Sub2) arg2).anInt1172 >= anInt647) {
		try {
		    if (((Class33_Sub7_Sub2) arg2).anInt1172 == anInt647
			|| !flag
			|| (((Class33_Sub7_Sub2) arg2).anInt1159 + 1
			    > (Class10.aClass10Array183
			       [((Class33_Sub7_Sub2) arg2).anInt1157]
			       .anIntArray187
			       [((Class33_Sub7_Sub2) arg2).anInt1158]))) {
			int i = (((Class33_Sub7_Sub2) arg2).anInt1172
				 - ((Class33_Sub7_Sub2) arg2).anInt1171);
			int i3
			    = anInt647 - ((Class33_Sub7_Sub2) arg2).anInt1171;
			int i4 = (((Class33_Sub7_Sub2) arg2).anInt1167 * 128
				  + ((Class33_Sub7_Sub2) arg2).anInt1135 * 64);
			int i5 = (((Class33_Sub7_Sub2) arg2).anInt1169 * 128
				  + ((Class33_Sub7_Sub2) arg2).anInt1135 * 64);
			int i6 = (((Class33_Sub7_Sub2) arg2).anInt1168 * 128
				  + ((Class33_Sub7_Sub2) arg2).anInt1135 * 64);
			int i7 = (((Class33_Sub7_Sub2) arg2).anInt1170 * 128
				  + ((Class33_Sub7_Sub2) arg2).anInt1135 * 64);
			((Class33_Sub7_Sub2) arg2).anInt1131
			    = (i4 * (i - i3) + i6 * i3) / i;
			((Class33_Sub7_Sub2) arg2).anInt1132
			    = (i5 * (i - i3) + i7 * i3) / i;
		    }
		    ((Class33_Sub7_Sub2) arg2).anInt1180 = 0;
		    if (((Class33_Sub7_Sub2) arg2).anInt1173 == 0)
			((Class33_Sub7_Sub2) arg2).anInt1176 = 1024;
		    if (((Class33_Sub7_Sub2) arg2).anInt1173 == 1)
			((Class33_Sub7_Sub2) arg2).anInt1176 = 1536;
		    if (((Class33_Sub7_Sub2) arg2).anInt1173 == 2)
			((Class33_Sub7_Sub2) arg2).anInt1176 = 0;
		    if (((Class33_Sub7_Sub2) arg2).anInt1173 == 3)
			((Class33_Sub7_Sub2) arg2).anInt1176 = 512;
		    ((Class33_Sub7_Sub2) arg2).anInt1133
			= ((Class33_Sub7_Sub2) arg2).anInt1176;
		} catch (Exception exception) {
		    System.out.println("e4: "
				       + ((Class33_Sub7_Sub2) arg2).anInt1157);
		}
	    } else {
		try {
		    if (((Class33_Sub7_Sub2) arg2).anInt1177 == 0)
			((Class33_Sub7_Sub2) arg2).anInt1180 = 0;
		    if (((Class33_Sub7_Sub2) arg2).anInt1177 > 0 && !flag) {
			int i = ((Class33_Sub7_Sub2) arg2).anInt1131;
			int i8 = ((Class33_Sub7_Sub2) arg2).anInt1132;
			int i9 = (((((Class33_Sub7_Sub2) arg2).anIntArray1178
				    [((Class33_Sub7_Sub2) arg2).anInt1177 - 1])
				   * 128)
				  + ((Class33_Sub7_Sub2) arg2).anInt1135 * 64);
			int i10
			    = (((((Class33_Sub7_Sub2) arg2).anIntArray1179
				 [((Class33_Sub7_Sub2) arg2).anInt1177 - 1])
				* 128)
			       + ((Class33_Sub7_Sub2) arg2).anInt1135 * 64);
			if (i9 - i > 256 || i9 - i < -256 || i10 - i8 > 256
			    || i10 - i8 < -256) {
			    ((Class33_Sub7_Sub2) arg2).anInt1131 = i9;
			    ((Class33_Sub7_Sub2) arg2).anInt1132 = i10;
			} else {
			    if (i < i9) {
				if (i8 < i10)
				    ((Class33_Sub7_Sub2) arg2).anInt1176
					= 1280;
				else if (i8 > i10)
				    ((Class33_Sub7_Sub2) arg2).anInt1176
					= 1792;
				else
				    ((Class33_Sub7_Sub2) arg2).anInt1176
					= 1536;
			    } else if (i > i9) {
				if (i8 < i10)
				    ((Class33_Sub7_Sub2) arg2).anInt1176 = 768;
				else if (i8 > i10)
				    ((Class33_Sub7_Sub2) arg2).anInt1176 = 256;
				else
				    ((Class33_Sub7_Sub2) arg2).anInt1176 = 512;
			    } else if (i8 < i10)
				((Class33_Sub7_Sub2) arg2).anInt1176 = 1024;
			    else
				((Class33_Sub7_Sub2) arg2).anInt1176 = 0;
			    int i11 = ((((Class33_Sub7_Sub2) arg2).anInt1176
					- ((Class33_Sub7_Sub2) arg2).anInt1133)
				       & 0x7ff);
			    if (i11 > 1024)
				i11 -= 2048;
			    int i12 = ((Class33_Sub7_Sub2) arg2).anInt1137;
			    if (i11 >= -256 && i11 <= 256)
				i12 = ((Class33_Sub7_Sub2) arg2).anInt1136;
			    else if (i11 >= 256 && i11 < 768)
				i12 = ((Class33_Sub7_Sub2) arg2).anInt1139;
			    else if (i11 >= -768 && i11 <= -256)
				i12 = ((Class33_Sub7_Sub2) arg2).anInt1138;
			    if (i12 == -1)
				i12 = ((Class33_Sub7_Sub2) arg2).anInt1136;
			    if (i12 != ((Class33_Sub7_Sub2) arg2).anInt1154) {
				((Class33_Sub7_Sub2) arg2).anInt1154 = i12;
				((Class33_Sub7_Sub2) arg2).anInt1155 = 0;
				((Class33_Sub7_Sub2) arg2).anInt1156 = 0;
			    }
			    int i13 = 4;
			    if ((((Class33_Sub7_Sub2) arg2).anInt1133
				 != ((Class33_Sub7_Sub2) arg2).anInt1176)
				&& ((Class33_Sub7_Sub2) arg2).anInt1151 == -1)
				i13 = 2;
			    if (((Class33_Sub7_Sub2) arg2).anInt1177 > 2)
				i13 = 6;
			    if (((Class33_Sub7_Sub2) arg2).anInt1177 > 3)
				i13 = 8;
			    if (((Class33_Sub7_Sub2) arg2).anInt1180 > 0
				&& ((Class33_Sub7_Sub2) arg2).anInt1177 > 1) {
				i13 = 8;
				((Class33_Sub7_Sub2) arg2).anInt1180--;
			    }
			    if (i < i9) {
				((Class33_Sub7_Sub2) arg2).anInt1131 += i13;
				if (((Class33_Sub7_Sub2) arg2).anInt1131 > i9)
				    ((Class33_Sub7_Sub2) arg2).anInt1131 = i9;
			    } else if (i > i9) {
				((Class33_Sub7_Sub2) arg2).anInt1131 -= i13;
				if (((Class33_Sub7_Sub2) arg2).anInt1131 < i9)
				    ((Class33_Sub7_Sub2) arg2).anInt1131 = i9;
			    }
			    if (i8 < i10) {
				((Class33_Sub7_Sub2) arg2).anInt1132 += i13;
				if (((Class33_Sub7_Sub2) arg2).anInt1132 > i10)
				    ((Class33_Sub7_Sub2) arg2).anInt1132 = i10;
			    } else if (i8 > i10) {
				((Class33_Sub7_Sub2) arg2).anInt1132 -= i13;
				if (((Class33_Sub7_Sub2) arg2).anInt1132 < i10)
				    ((Class33_Sub7_Sub2) arg2).anInt1132 = i10;
			    }
			    if (((Class33_Sub7_Sub2) arg2).anInt1131 == i9
				&& ((Class33_Sub7_Sub2) arg2).anInt1132 == i10)
				((Class33_Sub7_Sub2) arg2).anInt1177--;
			}
		    } else
			((Class33_Sub7_Sub2) arg2).anInt1154
			    = ((Class33_Sub7_Sub2) arg2).anInt1140;
		} catch (Exception exception) {
		    System.out.println("e5: "
				       + ((Class33_Sub7_Sub2) arg2).anInt1177);
		}
	    }
	    if (((Class33_Sub7_Sub2) arg2).anInt1151 != -1
		&& ((Class33_Sub7_Sub2) arg2).anInt1151 < 32768) {
		try {
		    Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
			= (aClass33_Sub7_Sub2_Sub1Array934
			   [((Class33_Sub7_Sub2) arg2).anInt1151]);
		    if (class33_sub7_sub2_sub1 != null) {
			int i
			    = (((Class33_Sub7_Sub2) arg2).anInt1131
			       - (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
				  .anInt1131));
			int i14
			    = (((Class33_Sub7_Sub2) arg2).anInt1132
			       - (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
				  .anInt1132));
			if (i != 0 || i14 != 0)
			    ((Class33_Sub7_Sub2) arg2).anInt1176
				= (int) (Math.atan2((double) i, (double) i14)
					 * 325.949) & 0x7ff;
		    }
		} catch (Exception exception) {
		    System.out.println("e6: "
				       + ((Class33_Sub7_Sub2) arg2).anInt1151);
		}
	    }
	    if (((Class33_Sub7_Sub2) arg2).anInt1151 >= 32768) {
		try {
		    int i = ((Class33_Sub7_Sub2) arg2).anInt1151 - 32768;
		    if (i == anInt698)
			i = anInt735;
		    Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
			= aClass33_Sub7_Sub2_Sub2Array736[i];
		    if (class33_sub7_sub2_sub2 != null) {
			int i15
			    = (((Class33_Sub7_Sub2) arg2).anInt1131
			       - (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
				  .anInt1131));
			int i16
			    = (((Class33_Sub7_Sub2) arg2).anInt1132
			       - (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
				  .anInt1132));
			if (i15 != 0 || i16 != 0)
			    ((Class33_Sub7_Sub2) arg2).anInt1176
				= (int) (Math.atan2((double) i15, (double) i16)
					 * 325.949) & 0x7ff;
		    }
		} catch (Exception exception) {
		    System.out.println("e7: "
				       + ((Class33_Sub7_Sub2) arg2).anInt1151);
		}
	    }
	    if ((((Class33_Sub7_Sub2) arg2).anInt1152 != 0
		 || ((Class33_Sub7_Sub2) arg2).anInt1153 != 0)
		&& (((Class33_Sub7_Sub2) arg2).anInt1177 == 0
		    || ((Class33_Sub7_Sub2) arg2).anInt1180 > 0)) {
		int i = (((Class33_Sub7_Sub2) arg2).anInt1131
			 - (((Class33_Sub7_Sub2) arg2).anInt1152 - anInt925
			    - anInt925) * 64);
		int i17 = (((Class33_Sub7_Sub2) arg2).anInt1132
			   - (((Class33_Sub7_Sub2) arg2).anInt1153 - anInt926
			      - anInt926) * 64);
		if (i != 0 || i17 != 0)
		    ((Class33_Sub7_Sub2) arg2).anInt1176
			= (int) (Math.atan2((double) i, (double) i17)
				 * 325.949) & 0x7ff;
		((Class33_Sub7_Sub2) arg2).anInt1152 = 0;
		((Class33_Sub7_Sub2) arg2).anInt1153 = 0;
	    }
	    int i = ((((Class33_Sub7_Sub2) arg2).anInt1176
		      - ((Class33_Sub7_Sub2) arg2).anInt1133)
		     & 0x7ff);
	    if (i != 0) {
		if (i < 32 || i > 2016)
		    ((Class33_Sub7_Sub2) arg2).anInt1133
			= ((Class33_Sub7_Sub2) arg2).anInt1176;
		else if (i > 1024)
		    ((Class33_Sub7_Sub2) arg2).anInt1133 -= 32;
		else
		    ((Class33_Sub7_Sub2) arg2).anInt1133 += 32;
		((Class33_Sub7_Sub2) arg2).anInt1133 &= 0x7ff;
		if (((Class33_Sub7_Sub2) arg2).anInt1154
		    == ((Class33_Sub7_Sub2) arg2).anInt1140) {
		    if (((Class33_Sub7_Sub2) arg2).anInt1141 != -1)
			((Class33_Sub7_Sub2) arg2).anInt1154
			    = ((Class33_Sub7_Sub2) arg2).anInt1141;
		    else
			((Class33_Sub7_Sub2) arg2).anInt1154
			    = ((Class33_Sub7_Sub2) arg2).anInt1136;
		}
	    }
	    ((Class33_Sub7_Sub2) arg2).anInt1134 = 0;
	    if (((Class33_Sub7_Sub2) arg2).anInt1154 != -1) {
		try {
		    Class10 class10 = (Class10.aClass10Array183
				       [((Class33_Sub7_Sub2) arg2).anInt1154]);
		    ((Class33_Sub7_Sub2) arg2).anInt1156++;
		    if (((Class33_Sub7_Sub2) arg2).anInt1155 < class10.anInt184
			&& (((Class33_Sub7_Sub2) arg2).anInt1156
			    > (class10.anIntArray187
			       [((Class33_Sub7_Sub2) arg2).anInt1155]))) {
			((Class33_Sub7_Sub2) arg2).anInt1156 = 0;
			((Class33_Sub7_Sub2) arg2).anInt1155++;
		    }
		    if (((Class33_Sub7_Sub2) arg2).anInt1155
			>= class10.anInt184) {
			((Class33_Sub7_Sub2) arg2).anInt1156 = 0;
			((Class33_Sub7_Sub2) arg2).anInt1155 = 0;
		    }
		} catch (Exception exception) {
		    System.out.println("e8: "
				       + ((Class33_Sub7_Sub2) arg2).anInt1154);
		}
	    }
	    if (((Class33_Sub7_Sub2) arg2).anInt1157 != -1
		&& ((Class33_Sub7_Sub2) arg2).anInt1160 == 0) {
		try {
		    Class10 class10 = (Class10.aClass10Array183
				       [((Class33_Sub7_Sub2) arg2).anInt1157]);
		    for (((Class33_Sub7_Sub2) arg2).anInt1159++;
			 ((((Class33_Sub7_Sub2) arg2).anInt1158
			   < class10.anInt184)
			  && (((Class33_Sub7_Sub2) arg2).anInt1159
			      > (class10.anIntArray187
				 [((Class33_Sub7_Sub2) arg2).anInt1158])));
			 ((Class33_Sub7_Sub2) arg2).anInt1158++)
			((Class33_Sub7_Sub2) arg2).anInt1159
			    -= (class10.anIntArray187
				[((Class33_Sub7_Sub2) arg2).anInt1158]);
		    if (((Class33_Sub7_Sub2) arg2).anInt1158
			>= class10.anInt184) {
			((Class33_Sub7_Sub2) arg2).anInt1158
			    -= class10.anInt188;
			((Class33_Sub7_Sub2) arg2).anInt1161++;
			if (((Class33_Sub7_Sub2) arg2).anInt1161
			    >= class10.anInt194)
			    ((Class33_Sub7_Sub2) arg2).anInt1157 = -1;
			if (((Class33_Sub7_Sub2) arg2).anInt1158 < 0
			    || (((Class33_Sub7_Sub2) arg2).anInt1158
				>= class10.anInt184))
			    ((Class33_Sub7_Sub2) arg2).anInt1157 = -1;
		    }
		    ((Class33_Sub7_Sub2) arg2).anInt1134 = class10.anInt190;
		} catch (Exception exception) {
		    System.out.println("e9: "
				       + ((Class33_Sub7_Sub2) arg2).anInt1157);
		}
	    }
	    if (((Class33_Sub7_Sub2) arg2).anInt1160 > 0)
		((Class33_Sub7_Sub2) arg2).anInt1160--;
	    do {
		if (((Class33_Sub7_Sub2) arg2).anInt1162 != -1
		    && anInt647 >= ((Class33_Sub7_Sub2) arg2).anInt1165) {
		    try {
			if (((Class33_Sub7_Sub2) arg2).anInt1163 < 0)
			    ((Class33_Sub7_Sub2) arg2).anInt1163 = 0;
			Class10 class10
			    = (Class12.aClass12Array208
			       [((Class33_Sub7_Sub2) arg2).anInt1162]
			       .aClass10_211);
			for (((Class33_Sub7_Sub2) arg2).anInt1164++;
			     ((((Class33_Sub7_Sub2) arg2).anInt1163
			       < class10.anInt184)
			      && (((Class33_Sub7_Sub2) arg2).anInt1164
				  > (class10.anIntArray187
				     [((Class33_Sub7_Sub2) arg2).anInt1163])));
			     ((Class33_Sub7_Sub2) arg2).anInt1163++)
			    ((Class33_Sub7_Sub2) arg2).anInt1164
				-= (class10.anIntArray187
				    [((Class33_Sub7_Sub2) arg2).anInt1163]);
			if (((Class33_Sub7_Sub2) arg2).anInt1163
			    < class10.anInt184)
			    break;
			((Class33_Sub7_Sub2) arg2).anInt1162 = -1;
		    } catch (Exception exception) {
			System.out.println("e10: " + ((Class33_Sub7_Sub2)
						      arg2).anInt1162);
		    }
		    break;
		}
	    } while (false);
	}
    }
    
    public final void method45(int arg0) {
	for (int i = -1; i < anInt737; i++) {
	    int i1;
	    if (i == -1)
		i1 = anInt735;
	    else
		i1 = ((client) this).anIntArray738[i];
	    Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
		= aClass33_Sub7_Sub2_Sub2Array736[i1];
	    method44((byte) 0, 1, class33_sub7_sub2_sub2, i1 + 32768);
	}
	if (arg0 != -31949)
	    anInt746 = -434;
    }
    
    public final void method46(boolean arg0, int arg1) {
	if (!arg0)
	    aClass33_Sub7_Sub2_Sub2Array736[arg1] = null;
    }
    
    public final void method47(int arg0) {
	anInt713 += arg0;
	for (int i = 0; i < anInt935; i++) {
	    int i1 = ((client) this).anIntArray936[i];
	    Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
		= aClass33_Sub7_Sub2_Sub1Array934[i1];
	    method44((byte) 0,
		     (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		      .aClass38_1268.aByte567),
		     class33_sub7_sub2_sub1, i1);
	}
    }
    
    public final void method48(int arg0, boolean arg1) {
	aBoolean825 &= arg1;
	if (aClass33_Sub7_Sub2_Sub1Array934[arg0] != null)
	    ((Class33_Sub7_Sub2_Sub1) aClass33_Sub7_Sub2_Sub1Array934[arg0])
		.aClass38_1268
		= null;
	aClass33_Sub7_Sub2_Sub1Array934[arg0] = null;
    }
    
    public final void method49(int arg0, int arg1, int arg2, int arg3,
			       int arg4) {
	if (arg3 <= 0)
	    arg4 = aClass33_Sub2_Sub3_708.method342();
	int i = arg0 >> 14 & 0x7fff;
	int i1 = aClass27_806.method221(anInt858, arg1, arg2, arg0);
	if (i1 != -1) {
	    int i2 = i1 & 0x1f;
	    int i3 = i1 >> 6 & 0x3;
	    if (i2 == 10 || i2 == 11 || i2 == 22) {
		Class37 class37 = Class37.method383(i);
		int i4;
		int i5;
		if (i3 == 0 || i3 == 2) {
		    i4 = class37.anInt532;
		    i5 = class37.anInt533;
		} else {
		    i4 = class37.anInt533;
		    i5 = class37.anInt532;
		}
		int i6 = class37.anInt553;
		if (i3 != 0)
		    i6 = (i6 << i3 & 0xf) + (i6 >> 4 - i3);
		method50(arg2, true, 0, false, i4, arg1,
			 (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			  .anIntArray1178[0]),
			 i6, i5, 0,
			 (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			  .anIntArray1179[0]));
	    } else
		method50(arg2, true, i2 + 1, false, 0, arg1,
			 (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			  .anIntArray1178[0]),
			 0, 0, i3,
			 (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			  .anIntArray1179[0]));
	    anInt836 = clickX;
	    anInt837 = clickY;
	    anInt839 = 2;
	    anInt838 = 0;
	    aClass33_Sub2_Sub3_696.method334(false, arg4);
	    aClass33_Sub2_Sub3_696.method336(arg1 + anInt925);
	    aClass33_Sub2_Sub3_696.method336(arg2 + anInt926);
	    aClass33_Sub2_Sub3_696.method336(i);
	}
    }
    
    public final boolean method50(int arg0, boolean arg1, int arg2,
				  boolean arg3, int arg4, int arg5, int arg6,
				  int arg7, int arg8, int arg9, int arg10) {
	int i = 104;
	int i1 = 104;
	for (int i2 = 0; i2 < i; i2++) {
	    for (int i3 = 0; i3 < i1; i3++) {
		anIntArrayArray673[i2][i3] = 0;
		anIntArrayArray776[i2][i3] = 99999999;
	    }
	}
	int i4 = arg6;
	int i5 = arg10;
	anIntArrayArray673[arg6][arg10] = 99;
	aBoolean825 &= arg1;
	anIntArrayArray776[arg6][arg10] = 0;
	int i6 = 0;
	int i7 = 0;
	anIntArray845[i6] = arg6;
	anIntArray846[i6++] = arg10;
	boolean flag = false;
	int i8 = anIntArray845.length;
	int[][] is = aClass1Array638[anInt858].anIntArrayArray41;
	while (i7 != i6) {
	    i4 = anIntArray845[i7];
	    i5 = anIntArray846[i7];
	    i7 = (i7 + 1) % i8;
	    if (i4 == arg5 && i5 == arg0) {
		flag = true;
		break;
	    }
	    if (arg2 != 0) {
		if ((arg2 < 5 || arg2 == 10)
		    && aClass1Array638[anInt858].method101(i4, arg9,
							   aBoolean793, i5,
							   arg0, arg2 - 1,
							   arg5)) {
		    flag = true;
		    break;
		}
		if (arg2 < 10
		    && aClass1Array638[anInt858]
			   .method102(arg0, i5, 0, arg2 - 1, arg5, i4, arg9)) {
		    flag = true;
		    break;
		}
	    }
	    if (arg4 != 0 && arg8 != 0
		&& aClass1Array638[anInt858].method103(arg8, i5, arg7,
						       anInt649, i4, arg5,
						       arg4, arg0)) {
		flag = true;
		break;
	    }
	    int i9 = anIntArrayArray776[i4][i5] + 1;
	    if (i4 > 0 && anIntArrayArray673[i4 - 1][i5] == 0
		&& (is[i4 - 1][i5] & 0x280108) == 0) {
		anIntArray845[i6] = i4 - 1;
		anIntArray846[i6] = i5;
		i6 = (i6 + 1) % i8;
		anIntArrayArray673[i4 - 1][i5] = 2;
		anIntArrayArray776[i4 - 1][i5] = i9;
	    }
	    if (i4 < i - 1 && anIntArrayArray673[i4 + 1][i5] == 0
		&& (is[i4 + 1][i5] & 0x280180) == 0) {
		anIntArray845[i6] = i4 + 1;
		anIntArray846[i6] = i5;
		i6 = (i6 + 1) % i8;
		anIntArrayArray673[i4 + 1][i5] = 8;
		anIntArrayArray776[i4 + 1][i5] = i9;
	    }
	    if (i5 > 0 && anIntArrayArray673[i4][i5 - 1] == 0
		&& (is[i4][i5 - 1] & 0x280102) == 0) {
		anIntArray845[i6] = i4;
		anIntArray846[i6] = i5 - 1;
		i6 = (i6 + 1) % i8;
		anIntArrayArray673[i4][i5 - 1] = 1;
		anIntArrayArray776[i4][i5 - 1] = i9;
	    }
	    if (i5 < i1 - 1 && anIntArrayArray673[i4][i5 + 1] == 0
		&& (is[i4][i5 + 1] & 0x280120) == 0) {
		anIntArray845[i6] = i4;
		anIntArray846[i6] = i5 + 1;
		i6 = (i6 + 1) % i8;
		anIntArrayArray673[i4][i5 + 1] = 4;
		anIntArrayArray776[i4][i5 + 1] = i9;
	    }
	    if (i4 > 0 && i5 > 0 && anIntArrayArray673[i4 - 1][i5 - 1] == 0
		&& (is[i4 - 1][i5 - 1] & 0x28010e) == 0
		&& (is[i4 - 1][i5] & 0x280108) == 0
		&& (is[i4][i5 - 1] & 0x280102) == 0) {
		anIntArray845[i6] = i4 - 1;
		anIntArray846[i6] = i5 - 1;
		i6 = (i6 + 1) % i8;
		anIntArrayArray673[i4 - 1][i5 - 1] = 3;
		anIntArrayArray776[i4 - 1][i5 - 1] = i9;
	    }
	    if (i4 < i - 1 && i5 > 0 && anIntArrayArray673[i4 + 1][i5 - 1] == 0
		&& (is[i4 + 1][i5 - 1] & 0x280183) == 0
		&& (is[i4 + 1][i5] & 0x280180) == 0
		&& (is[i4][i5 - 1] & 0x280102) == 0) {
		anIntArray845[i6] = i4 + 1;
		anIntArray846[i6] = i5 - 1;
		i6 = (i6 + 1) % i8;
		anIntArrayArray673[i4 + 1][i5 - 1] = 9;
		anIntArrayArray776[i4 + 1][i5 - 1] = i9;
	    }
	    if (i4 > 0 && i5 < i1 - 1
		&& anIntArrayArray673[i4 - 1][i5 + 1] == 0
		&& (is[i4 - 1][i5 + 1] & 0x280138) == 0
		&& (is[i4 - 1][i5] & 0x280108) == 0
		&& (is[i4][i5 + 1] & 0x280120) == 0) {
		anIntArray845[i6] = i4 - 1;
		anIntArray846[i6] = i5 + 1;
		i6 = (i6 + 1) % i8;
		anIntArrayArray673[i4 - 1][i5 + 1] = 6;
		anIntArrayArray776[i4 - 1][i5 + 1] = i9;
	    }
	    if (i4 < i - 1 && i5 < i1 - 1
		&& anIntArrayArray673[i4 + 1][i5 + 1] == 0
		&& (is[i4 + 1][i5 + 1] & 0x2801e0) == 0
		&& (is[i4 + 1][i5] & 0x280180) == 0
		&& (is[i4][i5 + 1] & 0x280120) == 0) {
		anIntArray845[i6] = i4 + 1;
		anIntArray846[i6] = i5 + 1;
		i6 = (i6 + 1) % i8;
		anIntArrayArray673[i4 + 1][i5 + 1] = 12;
		anIntArrayArray776[i4 + 1][i5 + 1] = i9;
	    }
	}
	if (!flag) {
	    if (arg3) {
		int i10 = 100;
		for (int i11 = 1; i11 < 2; i11++) {
		    for (int i12 = arg5 - i11; i12 <= arg5 + i11; i12++) {
			for (int i13 = arg0 - i11; i13 <= arg0 + i11; i13++) {
			    if (i12 >= 0 && i13 >= 0 && i12 < 104 && i13 < 104
				&& anIntArrayArray776[i12][i13] < i10) {
				i10 = anIntArrayArray776[i12][i13];
				i4 = i12;
				i5 = i13;
				flag = true;
			    }
			}
		    }
		    if (flag)
			break;
		}
	    }
	    if (!flag)
		return false;
	}
	i7 = 0;
	anIntArray845[i7] = i4;
	anIntArray846[i7++] = i5;
	int i15;
	int i14 = i15 = anIntArrayArray673[i4][i5];
	while (i4 != arg6 || i5 != arg10) {
	    if (i14 != i15) {
		i15 = i14;
		anIntArray845[i7] = i4;
		anIntArray846[i7++] = i5;
	    }
	    if ((i14 & 0x2) != 0)
		i4++;
	    else if ((i14 & 0x8) != 0)
		i4--;
	    if ((i14 & 0x1) != 0)
		i5++;
	    else if ((i14 & 0x4) != 0)
		i5--;
	    i14 = anIntArrayArray673[i4][i5];
	}
	if (i7 > 0) {
	    i8 = i7;
	    if (i8 > 25)
		i8 = 25;
	    i7--;
	    int i16 = anIntArray845[i7];
	    int i17 = anIntArray846[i7];
	    aClass33_Sub2_Sub3_696.method334(false, 147);
	    aClass33_Sub2_Sub3_696.method335(i8 + i8 + 2);
	    aClass33_Sub2_Sub3_696.method336(i16 + anInt925);
	    aClass33_Sub2_Sub3_696.method336(i17 + anInt926);
	    for (int i18 = 1; i18 < i8; i18++) {
		i7--;
		aClass33_Sub2_Sub3_696.method335(anIntArray845[i7] - i16);
		aClass33_Sub2_Sub3_696.method335(anIntArray846[i7] - i17);
	    }
	}
	return true;
    }
    
    public final boolean method51(int arg0) {
	while (arg0 >= 0)
	    anInt861 = aClass32_674.method255();
	if (aClass5_730 == null)
	    return false;
	try {
	    int i = aClass5_730.method127();
	    if (i == 0)
		return false;
	    if (anInt714 == -1) {
		aClass5_730.method128(aClass33_Sub2_Sub3_708.aByteArray1107, 0,
				      1);
		anInt714 = aClass33_Sub2_Sub3_708.aByteArray1107[0] & 0xff;
		if (aClass32_674 != null)
		    anInt714 = anInt714 - aClass32_674.method255() & 0xff;
		anInt713 = Class40.anIntArray629[anInt714];
		i--;
	    }
	    if (anInt713 == -1) {
		if (i > 0) {
		    aClass5_730.method128((aClass33_Sub2_Sub3_708
					   .aByteArray1107),
					  0, 1);
		    anInt713 = aClass33_Sub2_Sub3_708.aByteArray1107[0] & 0xff;
		    i--;
		} else
		    return false;
	    }
	    if (anInt713 == -2) {
		if (i > 1) {
		    aClass5_730.method128((aClass33_Sub2_Sub3_708
					   .aByteArray1107),
					  0, 2);
		    aClass33_Sub2_Sub3_708.anInt1108 = 0;
		    anInt713 = aClass33_Sub2_Sub3_708.method344();
		    i -= 2;
		} else
		    return false;
	    }
	    if (i < anInt713)
		return false;
	    aClass33_Sub2_Sub3_708.anInt1108 = 0;
	    aClass5_730.method128(aClass33_Sub2_Sub3_708.aByteArray1107, 0,
				  anInt713);
	    anInt715 = 0;
	    if (anInt714 == 232) {
		aClass26_789.method190(0);
		aClass33_Sub2_Sub2_Sub4_653.method325
		    (151, aBoolean876, 257, 0, "Loading - please wait.");
		aClass33_Sub2_Sub2_Sub4_653.method325
		    (150, aBoolean876, 256, 16777215,
		     "Loading - please wait.");
		aClass26_789.method191(aGraphics13, 8, 11);
		anInt648 = 1;
		anInt681 = aClass33_Sub2_Sub3_708.method344();
		anInt682 = aClass33_Sub2_Sub3_708.method344();
		anInt925 = (anInt681 - 6) * 8;
		anInt926 = (anInt682 - 6) * 8;
		signlink.looprate(5);
		int i1 = (anInt713 - 2) / 10;
		aByteArrayArray764 = new byte[i1][];
		aByteArrayArray795 = new byte[i1][];
		anIntArray670 = new int[i1];
		aClass33_Sub2_Sub3_696.method334(false, 117);
		aClass33_Sub2_Sub3_696.method335(0);
		int i2 = 0;
		for (int i3 = 0; i3 < i1; i3++) {
		    int i4 = aClass33_Sub2_Sub3_708.method342();
		    int i5 = aClass33_Sub2_Sub3_708.method342();
		    int i6 = aClass33_Sub2_Sub3_708.method347();
		    int i7 = aClass33_Sub2_Sub3_708.method347();
		    anIntArray670[i3] = (i4 << 8) + i5;
		    if (i6 != 0) {
			byte[] bytes = signlink.cacheload("m" + i4 + "_" + i5);
			if (bytes != null) {
			    aCRC32_733.reset();
			    aCRC32_733.update(bytes);
			    if ((int) aCRC32_733.getValue() != i6)
				bytes = null;
			}
			if (bytes != null)
			    aByteArrayArray764[i3] = bytes;
			else {
			    anInt648 = 0;
			    aClass33_Sub2_Sub3_696.method335(0);
			    aClass33_Sub2_Sub3_696.method335(i4);
			    aClass33_Sub2_Sub3_696.method335(i5);
			    i2 += 3;
			}
		    }
		    if (i7 != 0) {
			byte[] bytes = signlink.cacheload("l" + i4 + "_" + i5);
			if (bytes != null) {
			    aCRC32_733.reset();
			    aCRC32_733.update(bytes);
			    if ((int) aCRC32_733.getValue() != i7)
				bytes = null;
			}
			if (bytes != null)
			    aByteArrayArray795[i3] = bytes;
			else {
			    anInt648 = 0;
			    aClass33_Sub2_Sub3_696.method335(1);
			    aClass33_Sub2_Sub3_696.method335(i4);
			    aClass33_Sub2_Sub3_696.method335(i5);
			    i2 += 3;
			}
		    }
		}
		aClass33_Sub2_Sub3_696.method341(-529, i2);
		signlink.looprate(100);
		int i8 = anInt925 - anInt927;
		int i9 = anInt926 - anInt928;
		anInt927 = anInt925;
		anInt928 = anInt926;
		for (int i10 = 0; i10 < 8192; i10++) {
		    Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
			= aClass33_Sub7_Sub2_Sub1Array934[i10];
		    if (class33_sub7_sub2_sub1 != null) {
			for (int i11 = 0; i11 < 10; i11++) {
			    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
				.anIntArray1178[i11]
				-= i8;
			    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
				.anIntArray1179[i11]
				-= i9;
			}
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1131
			    -= i8 * 128;
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1132
			    -= i9 * 128;
		    }
		}
		for (int i12 = 0; i12 < anInt734; i12++) {
		    Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
			= aClass33_Sub7_Sub2_Sub2Array736[i12];
		    if (class33_sub7_sub2_sub2 != null) {
			for (int i13 = 0; i13 < 10; i13++) {
			    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
				.anIntArray1178[i13]
				-= i8;
			    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
				.anIntArray1179[i13]
				-= i9;
			}
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1131
			    -= i8 * 128;
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1132
			    -= i9 * 128;
		    }
		}
		int i14 = 0;
		int i15 = 104;
		int i16 = 1;
		if (i8 < 0) {
		    i14 = 103;
		    i15 = -1;
		    i16 = -1;
		}
		int i17 = 0;
		int i18 = 104;
		int i19 = 1;
		if (i9 < 0) {
		    i17 = 103;
		    i18 = -1;
		    i19 = -1;
		}
		for (int i20 = i14; i20 != i15; i20 += i16) {
		    for (int i21 = i17; i21 != i18; i21 += i19) {
			int i22 = i20 + i8;
			int i23 = i21 + i9;
			for (int i24 = 0; i24 < 4; i24++) {
			    if (i22 >= 0 && i23 >= 0 && i22 < 104 && i23 < 104)
				aClass22ArrayArrayArray805[i24][i20][i21]
				    = (aClass22ArrayArrayArray805[i24][i22]
				       [i23]);
			    else
				aClass22ArrayArrayArray805[i24][i20][i21]
				    = null;
			}
		    }
		}
		for (Class33_Sub3 class33_sub3
			 = (Class33_Sub3) aClass22_697.method183();
		     class33_sub3 != null;
		     class33_sub3
			 = (Class33_Sub3) aClass22_697.method185(-14092)) {
		    class33_sub3.anInt975 -= i8;
		    class33_sub3.anInt976 -= i9;
		    if (class33_sub3.anInt975 < 0 || class33_sub3.anInt976 < 0
			|| class33_sub3.anInt975 >= 104
			|| class33_sub3.anInt976 >= 104)
			class33_sub3.method258();
		}
	    } else if (anInt714 == 217)
		anInt744 = aClass33_Sub2_Sub3_708.method342();
	    else if (anInt714 == 248) {
		int i25 = aClass33_Sub2_Sub3_708.method344();
		int i26 = aClass33_Sub2_Sub3_708.method344();
		int i27 = i26 >> 10 & 0x1f;
		int i28 = i26 >> 5 & 0x1f;
		int i29 = i26 & 0x1f;
		Class6.aClass6Array105[i25].anInt144
		    = (i27 << 19) + (i28 << 11) + (i29 << 3);
	    } else if (anInt714 == 98) {
		aBoolean646 = true;
		int i30 = aClass33_Sub2_Sub3_708.method342();
		int i31 = aClass33_Sub2_Sub3_708.method347();
		int i32 = aClass33_Sub2_Sub3_708.method342();
		anIntArray637[i30] = i31;
		anIntArray800[i30] = i32;
		anIntArray785[i30] = 1;
		for (int i33 = 0; i33 < 98; i33++) {
		    if (i31 >= anIntArray819[i33])
			anIntArray785[i30] = i33 + 2;
		}
	    } else if (anInt714 == 5) {
		for (int i34 = 0; i34 < aClass33_Sub7_Sub2_Sub2Array736.length;
		     i34++) {
		    if (aClass33_Sub7_Sub2_Sub2Array736[i34] != null)
			((Class33_Sub7_Sub2)
			 aClass33_Sub7_Sub2_Sub2Array736[i34]).anInt1157
			    = -1;
		}
		for (int i35 = 0; i35 < aClass33_Sub7_Sub2_Sub1Array934.length;
		     i35++) {
		    if (aClass33_Sub7_Sub2_Sub1Array934[i35] != null)
			((Class33_Sub7_Sub2)
			 aClass33_Sub7_Sub2_Sub1Array934[i35]).anInt1157
			    = -1;
		}
	    } else if (anInt714 == 47) {
		method55(anInt713, (byte) -47, aClass33_Sub2_Sub3_708);
		if (anInt648 == 1) {
		    anInt648 = 2;
		    Class3.anInt60 = anInt858;
		    method41(aByte705);
		}
		if (aBoolean665 && anInt648 == 2
		    && Class3.anInt60 != anInt858) {
		    aClass26_789.method190(0);
		    aClass33_Sub2_Sub2_Sub4_653.method325
			(151, aBoolean876, 257, 0, "Loading - please wait.");
		    aClass33_Sub2_Sub2_Sub4_653.method325
			(150, aBoolean876, 256, 16777215,
			 "Loading - please wait.");
		    aClass26_789.method191(aGraphics13, 8, 11);
		    Class3.anInt60 = anInt858;
		    method41(aByte705);
		}
		if (anInt858 != anInt870 && anInt648 == 2) {
		    anInt870 = anInt858;
		    method42(anInt858, anInt801);
		}
	    } else if (anInt714 == 234) {
		int i36 = aClass33_Sub2_Sub3_708.method344();
		int i37 = aClass33_Sub2_Sub3_708.method342();
		anIntArray853[i37] = i36;
		aBoolean646 = true;
	    } else if (anInt714 == 156) {
		String string = aClass33_Sub2_Sub3_708.method349();
		if (string.endsWith(":tradereq:")) {
		    String string38 = string.substring(0, string.indexOf(":"));
		    long l = Class35.method372(string38);
		    boolean flag = false;
		    for (int i39 = 0; i39 < anInt821; i39++) {
			if (aLongArray831[i39] == l) {
			    flag = true;
			    break;
			}
		    }
		    if (!flag)
			method81(4, string38, "wishes to trade with you.",
				 36887);
		} else
		    method81(0, "", string, 36887);
	    } else if (anInt714 == 220) {
		anInt802 = aClass33_Sub2_Sub3_708.method342();
		anInt765 = aClass33_Sub2_Sub3_708.method342();
		anInt742 = aClass33_Sub2_Sub3_708.method342();
		aBoolean894 = true;
		aBoolean760 = true;
	    } else if (anInt714 == 149) {
		int i40 = aClass33_Sub2_Sub3_708.method344();
		int i41 = aClass33_Sub2_Sub3_708.method344();
		Class6.aClass6Array105[i40].anInt151 = i41;
	    } else if (anInt714 == 95) {
		anInt726 = aClass33_Sub2_Sub3_708.method342();
		anInt727 = aClass33_Sub2_Sub3_708.method342();
	    } else if (anInt714 == 235) {
		aBoolean646 = true;
		int i42 = aClass33_Sub2_Sub3_708.method344();
		int i43 = aClass33_Sub2_Sub3_708.method343();
		if (anIntArray937[i42] != i43) {
		    anIntArray937[i42] = i43;
		    method75(6, i42);
		}
	    } else if (anInt714 == 123) {
		int i44 = aClass33_Sub2_Sub3_708.method344();
		Class6.aClass6Array105[i44].aClass33_Sub2_Sub1_149
		    = aClass33_Sub7_Sub2_Sub2_792.method366(1);
	    } else if (anInt714 == 44) {
		int i45 = aClass33_Sub2_Sub3_708.method342();
		int i46 = aClass33_Sub2_Sub3_708.method342();
		int i47 = -1;
		for (int i48 = 0; i48 < anIntArray670.length; i48++) {
		    if (anIntArray670[i48] == (i45 << 8) + i46)
			i47 = i48;
		}
		if (i47 != -1) {
		    signlink.cachesave("l" + i45 + "_" + i46,
				       aByteArrayArray795[i47]);
		    anInt648 = 1;
		}
	    } else if (anInt714 == 171) {
		int i49 = aClass33_Sub2_Sub3_708.method344();
		method73(1, i49);
		if (anInt704 != -1) {
		    anInt704 = -1;
		    aBoolean646 = true;
		    aBoolean729 = true;
		}
		if (anInt917 != -1) {
		    anInt917 = -1;
		    aBoolean760 = true;
		}
		if (aBoolean707) {
		    aBoolean707 = false;
		    aBoolean760 = true;
		}
		anInt709 = i49;
		aBoolean678 = false;
	    } else if (anInt714 == 197) {
		int i50 = aClass33_Sub2_Sub3_708.method342();
		int i51 = aClass33_Sub2_Sub3_708.method342();
		int i52 = aClass33_Sub2_Sub3_708.method344();
		int i53 = aClass33_Sub2_Sub3_708.method344();
		int i54 = -1;
		for (int i55 = 0; i55 < anIntArray670.length; i55++) {
		    if (anIntArray670[i55] == (i50 << 8) + i51)
			i54 = i55;
		}
		if (i54 != -1) {
		    if (aByteArrayArray764[i54] == null
			|| aByteArrayArray764[i54].length != i53)
			aByteArrayArray764[i54] = new byte[i53];
		    aClass33_Sub2_Sub3_708.method351(i52, anInt713 - 6,
						     aByteArrayArray764[i54],
						     false);
		}
	    } else if (anInt714 == 181) {
		int i56 = aClass33_Sub2_Sub3_708.method344();
		int i57 = aClass33_Sub2_Sub3_708.method344();
		Class38 class38 = Class38.method389(i57);
		Class6.aClass6Array105[i56].aClass33_Sub2_Sub1_149
		    = class38.method392(-502);
	    } else if (anInt714 == 68) {
		aBoolean646 = true;
		int i58 = aClass33_Sub2_Sub3_708.method344();
		Class6 class6 = Class6.aClass6Array105[i58];
		while (aClass33_Sub2_Sub3_708.anInt1108 < anInt713) {
		    int i59 = aClass33_Sub2_Sub3_708.method342();
		    int i60 = aClass33_Sub2_Sub3_708.method344();
		    int i61 = aClass33_Sub2_Sub3_708.method342();
		    if (i61 == 255)
			i61 = aClass33_Sub2_Sub3_708.method347();
		    if (i59 >= 0 && i59 < class6.anIntArray106.length) {
			class6.anIntArray106[i59] = i60;
			class6.anIntArray107[i59] = i61;
		    }
		}
	    } else if (anInt714 == 153 || anInt714 == 90 || anInt714 == 59
		       || anInt714 == 60 || anInt714 == 250 || anInt714 == 127
		       || anInt714 == 175 || anInt714 == 35 || anInt714 == 22)
		method53(true, aClass33_Sub2_Sub3_708, anInt714);
	    else if (anInt714 == 61) {
		int i62 = aClass33_Sub2_Sub3_708.method344();
		boolean flag = aClass33_Sub2_Sub3_708.method342() == 1;
		Class6.aClass6Array105[i62].aBoolean123 = flag;
	    } else if (anInt714 == 80) {
		if (anInt704 != -1) {
		    anInt704 = -1;
		    aBoolean646 = true;
		    aBoolean729 = true;
		}
		if (anInt917 != -1) {
		    anInt917 = -1;
		    aBoolean760 = true;
		}
		if (aBoolean707) {
		    aBoolean707 = false;
		    aBoolean760 = true;
		}
		anInt709 = -1;
		aBoolean678 = false;
	    } else if (anInt714 == 225) {
		int i63 = aClass33_Sub2_Sub3_708.method342();
		int i64 = aClass33_Sub2_Sub3_708.method342();
		int i65 = aClass33_Sub2_Sub3_708.method344();
		int i66 = aClass33_Sub2_Sub3_708.method344();
		int i67 = -1;
		for (int i68 = 0; i68 < anIntArray670.length; i68++) {
		    if (anIntArray670[i68] == (i63 << 8) + i64)
			i67 = i68;
		}
		if (i67 != -1) {
		    if (aByteArrayArray795[i67] == null
			|| aByteArrayArray795[i67].length != i66)
			aByteArrayArray795[i67] = new byte[i66];
		    aClass33_Sub2_Sub3_708.method351(i65, anInt713 - 6,
						     aByteArrayArray795[i67],
						     false);
		}
	    } else if (anInt714 == 51) {
		int i69 = aClass33_Sub2_Sub3_708.method342();
		int i70 = aClass33_Sub2_Sub3_708.method342();
		int i71 = -1;
		for (int i72 = 0; i72 < anIntArray670.length; i72++) {
		    if (anIntArray670[i72] == (i69 << 8) + i70)
			i71 = i72;
		}
		if (i71 != -1) {
		    signlink.cachesave("m" + i69 + "_" + i70,
				       aByteArrayArray764[i71]);
		    anInt648 = 1;
		}
	    } else if (anInt714 == 100)
		method56(aClass33_Sub2_Sub3_708, true, anInt713);
	    else if (anInt714 == 210) {
		int i73 = aClass33_Sub2_Sub3_708.method344();
		Class6 class6 = Class6.aClass6Array105[i73];
		for (int i74 = 0; i74 < class6.anIntArray106.length; i74++) {
		    class6.anIntArray106[i74] = -1;
		    class6.anIntArray106[i74] = 0;
		}
	    } else if (anInt714 == 42) {
		int i75 = aClass33_Sub2_Sub3_708.method344();
		int i76 = aClass33_Sub2_Sub3_708.method344();
		Class6.aClass6Array105[i75].aClass33_Sub2_Sub1_149
		    = new Class33_Sub2_Sub1(i76, aBoolean666);
	    } else if (anInt714 == 254) {
		anInt712 = aClass33_Sub2_Sub3_708.method342();
		aBoolean646 = true;
		aBoolean729 = true;
	    } else if (anInt714 == 114) {
		long l = aClass33_Sub2_Sub3_708.method348(1);
		int i77 = aClass33_Sub2_Sub3_708.method342();
		String string
		    = Class35.method376(Class35.method373((byte) -89, l),
					-591);
		for (int i78 = 0; i78 < anInt841; i78++) {
		    if (string.equals(aStringArray852[i78])) {
			if (anIntArray938[i78] != i77) {
			    anIntArray938[i78] = i77;
			    aBoolean646 = true;
			    if (i77 > 0)
				method81(5, "", string + " has logged in.",
					 36887);
			    if (i77 == 0)
				method81(5, "", string + " has logged out.",
					 36887);
			}
			string = null;
			break;
		    }
		}
		if (string != null && anInt841 < 100) {
		    aStringArray852[anInt841] = string;
		    anIntArray938[anInt841] = i77;
		    anInt841++;
		    aBoolean646 = true;
		}
		boolean flag = false;
		while (!flag) {
		    flag = true;
		    for (int i79 = 0; i79 < anInt841 - 1; i79++) {
			if ((anIntArray938[i79] != anInt851
			     && anIntArray938[i79 + 1] == anInt851)
			    || (anIntArray938[i79] == 0
				&& anIntArray938[i79 + 1] != 0)) {
			    int i80 = anIntArray938[i79];
			    anIntArray938[i79] = anIntArray938[i79 + 1];
			    anIntArray938[i79 + 1] = i80;
			    String string81 = aStringArray852[i79];
			    aStringArray852[i79] = aStringArray852[i79 + 1];
			    aStringArray852[i79 + 1] = string81;
			    aBoolean646 = true;
			    flag = false;
			}
		    }
		}
	    } else if (anInt714 == 159) {
		String string = aClass33_Sub2_Sub3_708.method349();
		if (!string.equals(aString863)) {
		    aString863 = string;
		    if (aBoolean759)
			signlink.midi = string;
		}
	    } else if (anInt714 == 119) {
		aBoolean646 = true;
		int i82 = aClass33_Sub2_Sub3_708.method344();
		int i83 = aClass33_Sub2_Sub3_708.method347();
		if (anIntArray937[i82] != i83) {
		    anIntArray937[i82] = i83;
		    method75(6, i82);
		}
	    } else if (anInt714 == 138) {
		int i84 = aClass33_Sub2_Sub3_708.method344();
		int i85 = aClass33_Sub2_Sub3_708.method344();
		if (anInt917 != -1) {
		    anInt917 = -1;
		    aBoolean760 = true;
		}
		if (aBoolean707) {
		    aBoolean707 = false;
		    aBoolean760 = true;
		}
		anInt709 = i84;
		anInt704 = i85;
		aBoolean646 = true;
		aBoolean729 = true;
		aBoolean678 = false;
	    } else if (anInt714 == 48) {
		anInt726 = aClass33_Sub2_Sub3_708.method342();
		anInt727 = aClass33_Sub2_Sub3_708.method342();
		while (aClass33_Sub2_Sub3_708.anInt1108 < anInt713) {
		    int i86 = aClass33_Sub2_Sub3_708.method342();
		    method53(true, aClass33_Sub2_Sub3_708, i86);
		}
	    } else if (anInt714 == 27)
		anInt698 = aClass33_Sub2_Sub3_708.method344();
	    else if (anInt714 == 85) {
		if (aBoolean759) {
		    signlink.jingle = aClass33_Sub2_Sub3_708.method349();
		    signlink.jinglelen = aClass33_Sub2_Sub3_708.method344();
		}
	    } else if (anInt714 == 227) {
		aBoolean646 = true;
		int i87 = aClass33_Sub2_Sub3_708.method344();
		Class6 class6 = Class6.aClass6Array105[i87];
		int i88 = aClass33_Sub2_Sub3_708.method342();
		for (int i89 = 0; i89 < i88; i89++) {
		    class6.anIntArray106[i89]
			= aClass33_Sub2_Sub3_708.method344();
		    int i90 = aClass33_Sub2_Sub3_708.method342();
		    if (i90 == 255)
			i90 = aClass33_Sub2_Sub3_708.method347();
		    class6.anIntArray107[i89] = i90;
		}
		for (int i91 = i88; i91 < class6.anIntArray106.length; i91++) {
		    class6.anIntArray106[i91] = 0;
		    class6.anIntArray107[i91] = 0;
		}
	    } else if (anInt714 == 188) {
		anInt726 = aClass33_Sub2_Sub3_708.method342();
		anInt727 = aClass33_Sub2_Sub3_708.method342();
		for (int i92 = anInt726; i92 < anInt726 + 8; i92++) {
		    for (int i93 = anInt727; i93 < anInt727 + 8; i93++) {
			if (aClass22ArrayArrayArray805[anInt858][i92][i93]
			    != null) {
			    aClass22ArrayArrayArray805[anInt858][i92][i93]
				= null;
			    method54(i92, i93);
			}
		    }
		}
		for (Class33_Sub3 class33_sub3
			 = (Class33_Sub3) aClass22_697.method183();
		     class33_sub3 != null;
		     class33_sub3
			 = (Class33_Sub3) aClass22_697.method185(-14092)) {
		    if (class33_sub3.anInt975 >= anInt726
			&& class33_sub3.anInt975 < anInt726 + 8
			&& class33_sub3.anInt976 >= anInt727
			&& class33_sub3.anInt976 < anInt727 + 8
			&& class33_sub3.anInt973 == anInt858) {
			method52(class33_sub3.anInt973, class33_sub3.anInt982,
				 class33_sub3.anInt976, (byte) 120,
				 class33_sub3.anInt975, class33_sub3.anInt974,
				 class33_sub3.anInt981, class33_sub3.anInt980);
			class33_sub3.method258();
		    }
		}
	    } else if (anInt714 == 9) {
		int i94 = aClass33_Sub2_Sub3_708.method344();
		String string = aClass33_Sub2_Sub3_708.method349();
		Class6.aClass6Array105[i94].aString142 = string;
	    } else {
		if (anInt714 == 126) {
		    method32(-36905);
		    return false;
		}
		if (anInt714 == 229) {
		    long l = aClass33_Sub2_Sub3_708.method348(1);
		    int i95 = aClass33_Sub2_Sub3_708.method347();
		    boolean flag = false;
		    for (int i96 = 0; i96 < 100; i96++) {
			if (anIntArray767[i96] == i95) {
			    flag = true;
			    break;
			}
		    }
		    for (int i97 = 0; i97 < anInt821; i97++) {
			if (aLongArray831[i97] == l) {
			    flag = true;
			    break;
			}
		    }
		    if (!flag) {
			anIntArray767[anInt657] = i95;
			anInt657 = (anInt657 + 1) % 100;
			String string
			    = Class36.method379(false, aClass33_Sub2_Sub3_708,
						anInt713 - 12);
			string = Class16.method153(anInt946, string);
			method81
			    (3, Class35.method376(Class35.method373((byte) -89,
								    l),
						  -591), string, 36887);
		    }
		} else if (anInt714 == 6) {
		    anInt821 = anInt713 / 8;
		    for (int i98 = 0; i98 < anInt821; i98++)
			aLongArray831[i98]
			    = aClass33_Sub2_Sub3_708.method348(1);
		} else if (anInt714 == 53)
		    anInt732 = aClass33_Sub2_Sub3_708.method344() * 30;
		else if (anInt714 == 116) {
		    int i99 = aClass33_Sub2_Sub3_708.method344();
		    method73(1, i99);
		    if (anInt704 != -1) {
			anInt704 = -1;
			aBoolean646 = true;
			aBoolean729 = true;
		    }
		    anInt917 = i99;
		    aBoolean760 = true;
		    anInt709 = -1;
		    aBoolean678 = false;
		} else if (anInt714 == 107) {
		    int i100 = aClass33_Sub2_Sub3_708.method344();
		    int i101 = aClass33_Sub2_Sub3_708.method344();
		    int i102 = aClass33_Sub2_Sub3_708.method344();
		    Class39 class39 = Class39.method395(i101);
		    Class6.aClass6Array105[i100].aClass33_Sub2_Sub1_149
			= class39.method398();
		    Class6.aClass6Array105[i100].anInt154 = class39.anInt604;
		    Class6.aClass6Array105[i100].anInt155 = class39.anInt605;
		    Class6.aClass6Array105[i100].anInt153
			= class39.anInt603 * 100 / i102;
		} else if (anInt714 == 75) {
		    aBoolean633 = false;
		    aBoolean707 = true;
		    aString818 = "";
		    aBoolean760 = true;
		} else if (anInt714 == 124) {
		    int i103 = aClass33_Sub2_Sub3_708.method344();
		    method73(1, i103);
		    if (anInt917 != -1) {
			anInt917 = -1;
			aBoolean760 = true;
		    }
		    if (aBoolean707) {
			aBoolean707 = false;
			aBoolean760 = true;
		    }
		    anInt704 = i103;
		    aBoolean646 = true;
		    aBoolean729 = true;
		    anInt709 = -1;
		    aBoolean678 = false;
		}
	    }
	    anInt714 = -1;
	} catch (IOException ioexception) {
	    method33((byte) 4);
	} catch (Exception exception) {
	    method32(-36905);
	}
	return true;
    }
    
    public final void method52(int arg0, int arg1, int arg2, byte arg3,
			       int arg4, int arg5, int arg6, int arg7) {
	if (arg3 != 120)
	    anInt714 = -1;
	if (!aBoolean665 || arg0 == anInt858) {
	    int i = 0;
	    int i1 = -1;
	    boolean flag = false;
	    boolean flag2 = false;
	    if (arg5 == 0)
		i = aClass27_806.method217(arg0, arg4, arg2);
	    if (arg5 == 1)
		i = aClass27_806.method218(arg0, arg2, (byte) -73, arg4);
	    if (arg5 == 2)
		i = aClass27_806.method219(arg0, arg4, arg2);
	    if (arg5 == 3)
		i = aClass27_806.method220(arg0, arg4, arg2);
	    if (i != 0) {
		int i3 = aClass27_806.method221(arg0, arg4, arg2, i);
		i1 = i >> 14 & 0x7fff;
		int i4 = i3 & 0x1f;
		int i5 = i3 >> 6;
		if (arg5 == 0) {
		    aClass27_806.method212(arg0, arg4, arg2, -415);
		    Class37 class37 = Class37.method383(i1);
		    if (class37.aBoolean534)
			aClass1Array638[arg0].method97(class37.aBoolean535, i5,
						       arg4, 2, i4, arg2);
		}
		if (arg5 == 1)
		    aClass27_806.method213(arg0, -101, arg4, arg2);
		if (arg5 == 2) {
		    aClass27_806.method214(arg0, 685, arg2, arg4);
		    Class37 class37 = Class37.method383(i1);
		    if (class37.aBoolean534)
			aClass1Array638[arg0].method98(arg4,
						       class37.aBoolean535,
						       false, class37.anInt532,
						       class37.anInt533, i5,
						       arg2);
		}
		if (arg5 == 3) {
		    aClass27_806.method215(arg0, arg2, arg4, (byte) 7);
		    Class37 class37 = Class37.method383(i1);
		    if (class37.aBoolean534 && class37.aBoolean536)
			aClass1Array638[arg0].method100(aBoolean820, arg2,
							arg4);
		}
	    }
	    if (arg7 >= 0) {
		int i6 = arg0;
		if (i6 < 3
		    && (aByteArrayArrayArray903[1][arg4][arg2] & 0x2) == 2)
		    i6++;
		Class3.method120(i6, aClass22_862, arg2, arg0, arg6,
				 aClass1Array638[arg0],
				 anIntArrayArrayArray756, arg7, aClass27_806,
				 arg4, arg1, 210);
	    }
	}
    }
    
    public final void method53(boolean arg0, Class33_Sub2_Sub3 arg1,
			       int arg2) {
	if (!arg0)
	    aClass33_Sub2_Sub3_696.method335(252);
	if (arg2 == 22 || arg2 == 35) {
	    int i = arg1.method342();
	    int i1 = anInt726 + (i >> 4 & 0x7);
	    int i2 = anInt727 + (i & 0x7);
	    int i3 = arg1.method342();
	    int i4 = i3 >> 2;
	    int i5 = i3 & 0x3;
	    int i6 = anIntArray768[i4];
	    int i7;
	    if (arg2 == 35)
		i7 = -1;
	    else
		i7 = arg1.method344();
	    if (i1 >= 0 && i2 >= 0 && i1 < 104 && i2 < 104) {
		Class33_Sub3 class33_sub3 = null;
		for (Class33_Sub3 class33_sub3_8
			 = (Class33_Sub3) aClass22_697.method183();
		     class33_sub3_8 != null;
		     class33_sub3_8
			 = (Class33_Sub3) aClass22_697.method185(-14092)) {
		    if (class33_sub3_8.anInt973 == anInt858
			&& class33_sub3_8.anInt975 == i1
			&& class33_sub3_8.anInt976 == i2
			&& class33_sub3_8.anInt974 == i6) {
			class33_sub3 = class33_sub3_8;
			break;
		    }
		}
		if (class33_sub3 == null) {
		    int i9 = 0;
		    int i10 = -1;
		    int i11 = 0;
		    int i12 = 0;
		    if (i6 == 0)
			i9 = aClass27_806.method217(anInt858, i1, i2);
		    if (i6 == 1)
			i9 = aClass27_806.method218(anInt858, i2, (byte) -73,
						    i1);
		    if (i6 == 2)
			i9 = aClass27_806.method219(anInt858, i1, i2);
		    if (i6 == 3)
			i9 = aClass27_806.method220(anInt858, i1, i2);
		    if (i9 != 0) {
			int i13 = aClass27_806.method221(anInt858, i1, i2, i9);
			i10 = i9 >> 14 & 0x7fff;
			i11 = i13 & 0x1f;
			i12 = i13 >> 6;
		    }
		    class33_sub3 = new Class33_Sub3();
		    class33_sub3.anInt973 = anInt858;
		    class33_sub3.anInt974 = i6;
		    class33_sub3.anInt975 = i1;
		    class33_sub3.anInt976 = i2;
		    class33_sub3.anInt980 = i10;
		    class33_sub3.anInt982 = i11;
		    class33_sub3.anInt981 = i12;
		    aClass22_697.method181(class33_sub3);
		}
		class33_sub3.anInt977 = i7;
		class33_sub3.anInt979 = i4;
		class33_sub3.anInt978 = i5;
		method52(anInt858, i4, i2, (byte) 120, i1, i6, i5, i7);
	    }
	} else if (arg2 == 175) {
	    int i = arg1.method342();
	    int i14 = anInt726 + (i >> 4 & 0x7);
	    int i15 = anInt727 + (i & 0x7);
	    int i16 = arg1.method342();
	    int i17 = i16 >> 2;
	    int i18 = anIntArray768[i17];
	    int i19 = arg1.method344();
	    if (i14 >= 0 && i15 >= 0 && i14 < 104 && i15 < 104) {
		int i20 = 0;
		if (i18 == 1)
		    i20 = aClass27_806.method218(anInt858, i15, (byte) -73,
						 i14);
		if (i18 == 2)
		    i20 = aClass27_806.method219(anInt858, i14, i15);
		if (i20 != 0) {
		    Class33_Sub5 class33_sub5
			= new Class33_Sub5(i18, anInt858, i20 >> 14 & 0x7fff,
					   5858, Class10.aClass10Array183[i19],
					   i14, i15);
		    aClass22_862.method181(class33_sub5);
		}
	    }
	} else if (arg2 == 127) {
	    int i = arg1.method342();
	    int i21 = anInt726 + (i >> 4 & 0x7);
	    int i22 = anInt727 + (i & 0x7);
	    int i23 = arg1.method344();
	    if (i21 >= 0 && i22 >= 0 && i21 < 104 && i22 < 104) {
		Class33_Sub6 class33_sub6 = new Class33_Sub6();
		class33_sub6.anInt999 = i23;
		if (aClass22ArrayArrayArray805[anInt858][i21][i22] == null)
		    aClass22ArrayArrayArray805[anInt858][i21][i22]
			= new Class22(845);
		aClass22ArrayArrayArray805[anInt858][i21][i22]
		    .method181(class33_sub6);
		method54(i21, i22);
	    }
	} else if (arg2 == 250) {
	    int i = arg1.method342();
	    int i24 = anInt726 + (i >> 4 & 0x7);
	    int i25 = anInt727 + (i & 0x7);
	    int i26 = arg1.method344();
	    if (i24 >= 0 && i25 >= 0 && i24 < 104 && i25 < 104) {
		Class22 class22
		    = aClass22ArrayArrayArray805[anInt858][i24][i25];
		if (class22 != null) {
		    for (Class33_Sub6 class33_sub6
			     = (Class33_Sub6) class22.method183();
			 class33_sub6 != null;
			 class33_sub6
			     = (Class33_Sub6) class22.method185(-14092)) {
			if (class33_sub6.anInt999 == (i26 & 0x7fff)) {
			    class33_sub6.method258();
			    break;
			}
		    }
		    if (class22.method183() == null)
			aClass22ArrayArrayArray805[anInt858][i24][i25] = null;
		    method54(i24, i25);
		}
	    }
	} else if (arg2 == 60) {
	    int i = arg1.method342();
	    int i27 = anInt726 + (i >> 4 & 0x7);
	    int i28 = anInt727 + (i & 0x7);
	    int i29 = i27 + arg1.method343();
	    int i30 = i28 + arg1.method343();
	    int i31 = arg1.method345();
	    int i32 = arg1.method344();
	    int i33 = arg1.method342();
	    int i34 = arg1.method342();
	    int i35 = arg1.method344();
	    int i36 = arg1.method344();
	    int i37 = arg1.method342();
	    int i38 = arg1.method342();
	    if (i27 >= 0 && i28 >= 0 && i27 < 104 && i28 < 104 && i29 >= 0
		&& i30 >= 0 && i29 < 104 && i30 < 104) {
		i27 = i27 * 128 + 64;
		i28 = i28 * 128 + 64;
		i29 = i29 * 128 + 64;
		i30 = i30 * 128 + 64;
		Class33_Sub7_Sub3 class33_sub7_sub3
		    = new Class33_Sub7_Sub3(anInt858, i38, i27, aBoolean794,
					    i37,
					    method39(i27, (byte) 42, i28,
						     anInt858) - i33,
					    i32, i35 + anInt647, i34, i28,
					    i36 + anInt647, i31);
		class33_sub7_sub3.method368(i30,
					    method39(i29, (byte) 42, i30,
						     anInt858) - i34,
					    i29, anInt661, i35 + anInt647);
		aClass22_897.method181(class33_sub7_sub3);
	    }
	} else if (arg2 == 59) {
	    int i = arg1.method342();
	    int i39 = anInt726 + (i >> 4 & 0x7);
	    int i40 = anInt727 + (i & 0x7);
	    int i41 = arg1.method344();
	    int i42 = arg1.method342();
	    int i43 = arg1.method344();
	    if (i39 >= 0 && i40 >= 0 && i39 < 104 && i40 < 104) {
		i39 = i39 * 128 + 64;
		i40 = i40 * 128 + 64;
		Class33_Sub7_Sub1 class33_sub7_sub1
		    = new Class33_Sub7_Sub1(method39(i39, (byte) 42, i40,
						     anInt858) - i42,
					    0, i43, i41, anInt858, i39, i40,
					    anInt647);
		aClass22_675.method181(class33_sub7_sub1);
	    }
	} else if (arg2 == 90) {
	    int i = arg1.method342();
	    int i44 = anInt726 + (i >> 4 & 0x7);
	    int i45 = anInt727 + (i & 0x7);
	    int i46 = arg1.method344();
	    int i47 = arg1.method344();
	    if (i44 >= 0 && i45 >= 0 && i44 < 104 && i45 < 104
		&& i47 != anInt698) {
		Class33_Sub6 class33_sub6 = new Class33_Sub6();
		class33_sub6.anInt999 = i46;
		if (aClass22ArrayArrayArray805[anInt858][i44][i45] == null)
		    aClass22ArrayArrayArray805[anInt858][i44][i45]
			= new Class22(845);
		aClass22ArrayArrayArray805[anInt858][i44][i45]
		    .method181(class33_sub6);
		method54(i44, i45);
	    }
	} else if (arg2 == 153) {
	    int i = arg1.method342();
	    int i48 = anInt726 + (i >> 4 & 0x7);
	    int i49 = anInt727 + (i & 0x7);
	    int i50 = arg1.method342();
	    int i51 = i50 >> 2;
	    int i52 = i50 & 0x3;
	    int i53 = anIntArray768[i51];
	    int i54 = arg1.method344();
	    int i55 = arg1.method344();
	    int i56 = arg1.method344();
	    int i57 = arg1.method344();
	    int i58 = arg1.method343();
	    int i59 = arg1.method343();
	    int i60 = arg1.method343();
	    int i61 = arg1.method343();
	    Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2;
	    if (i57 == anInt698)
		class33_sub7_sub2_sub2 = aClass33_Sub7_Sub2_Sub2_792;
	    else
		class33_sub7_sub2_sub2 = aClass33_Sub7_Sub2_Sub2Array736[i57];
	    if (class33_sub7_sub2_sub2 != null) {
		Class33_Sub4 class33_sub4
		    = new Class33_Sub4(i51, (byte) 4, i55 + anInt647, anInt858,
				       i49, i52, -1, i53, i48);
		aClass22_868.method181(class33_sub4);
		Class33_Sub4 class33_sub4_62
		    = new Class33_Sub4(i51, (byte) 4, i56 + anInt647, anInt858,
				       i49, i52, i54, i53, i48);
		aClass22_868.method181(class33_sub4_62);
		int i63 = anIntArrayArrayArray756[anInt858][i48][i49];
		int i64 = anIntArrayArrayArray756[anInt858][i48 + 1][i49];
		int i65 = anIntArrayArrayArray756[anInt858][i48 + 1][i49 + 1];
		int i66 = anIntArrayArrayArray756[anInt858][i48][i49 + 1];
		Class37 class37 = Class37.method383(i54);
		((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2).anInt1282
		    = i55 + anInt647;
		((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2).anInt1283
		    = i56 + anInt647;
		((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
		    .aClass33_Sub2_Sub1_1287
		    = class37.method386(i51, i52, i63, i64, i65, i66, -1);
		int i67 = class37.anInt532;
		int i68 = class37.anInt533;
		if (i52 == 1 || i52 == 3) {
		    i67 = class37.anInt533;
		    i68 = class37.anInt532;
		}
		((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2).anInt1284
		    = i48 * 128 + i67 * 64;
		((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2).anInt1286
		    = i49 * 128 + i68 * 64;
		((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2).anInt1285
		    = method39(((Class33_Sub7_Sub2_Sub2)
				class33_sub7_sub2_sub2).anInt1284,
			       (byte) 42,
			       ((Class33_Sub7_Sub2_Sub2)
				class33_sub7_sub2_sub2).anInt1286,
			       anInt858);
		if (i58 > i60) {
		    int i69 = i58;
		    i58 = i60;
		    i60 = i69;
		}
		if (i59 > i61) {
		    int i70 = i59;
		    i59 = i61;
		    i61 = i70;
		}
		((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2).anInt1288
		    = i48 + i58;
		((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2).anInt1290
		    = i48 + i60;
		((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2).anInt1289
		    = i49 + i59;
		((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2).anInt1291
		    = i49 + i61;
	    }
	}
    }
    
    public final void method54(int arg0, int arg1) {
	Class22 class22 = aClass22ArrayArrayArray805[anInt858][arg0][arg1];
	if (class22 == null)
	    aClass27_806.method216(anInt858, arg0, arg1);
	else {
	    int i = -99999999;
	    Class39 class39 = null;
	    for (Class33_Sub6 class33_sub6
		     = (Class33_Sub6) class22.method183();
		 class33_sub6 != null;
		 class33_sub6 = (Class33_Sub6) class22.method185(-14092)) {
		Class39 class39_1 = Class39.method395(class33_sub6.anInt999);
		if (class39_1.anInt612 > i) {
		    i = class39_1.anInt612;
		    class39 = class39_1;
		}
	    }
	    int i2 = arg0 + (arg1 << 7) + 1610612736;
	    aClass27_806.method201(method39(arg0 * 128 + 64, (byte) 42,
					    arg1 * 128 + 64, anInt858),
				   anInt858, i2, class39.method398(), arg0,
				   (byte) 0, arg1);
	}
    }
    
    public final void method55(int arg0, byte arg1, Class33_Sub2_Sub3 arg2) {
	if (arg1 == -47) {
	    int i = 0;
	    arg2.method352(0);
	    anInt858 = arg2.method353(737, 2);
	    int i1 = arg2.method353(737, 7);
	    int i2 = arg2.method353(737, 7);
	    int i3 = arg2.method353(737, 1);
	    if (i3 == 1)
		anIntArray739[i++] = anInt735;
	    aClass33_Sub7_Sub2_Sub2_792.method360(anInt843, i1, i2);
	    anInt832 = 0;
	    int i4 = arg2.method353(737, 8);
	    if (i4 < anInt935) {
		for (int i5 = i4; i5 < anInt737; i5++) {
		    ((client) this).anIntArray833[anInt832++]
			= ((client) this).anIntArray738[i5];
		    ((Class33_Sub7_Sub2) (aClass33_Sub7_Sub2_Sub2Array736
					  [((client) this).anIntArray738[i5]]))
			.aBoolean1174
			= true;
		}
	    }
	    anInt737 = 0;
	    for (int i6 = 0; i6 < i4; i6++) {
		int i7 = ((client) this).anIntArray738[i6];
		Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
		    = aClass33_Sub7_Sub2_Sub2Array736[i7];
		int i8 = arg2.method353(737, 1);
		if (i8 == 0)
		    ((client) this).anIntArray738[anInt737++] = i7;
		else {
		    int i9 = arg2.method353(737, 2);
		    if (i9 == 3) {
			((client) this).anIntArray833[anInt832++] = i7;
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			    .aBoolean1174
			    = true;
		    } else {
			((client) this).anIntArray738[anInt737++] = i7;
			if (i9 == 0)
			    anIntArray739[i++] = i7;
			else {
			    if (i9 == 2)
				anIntArray739[i++] = i7;
			    int i10 = arg2.method353(737, 3);
			    if (i10 == 0)
				class33_sub7_sub2_sub2.method361(false, 1, -1);
			    if (i10 == 1)
				class33_sub7_sub2_sub2.method361(false, 1, 0);
			    if (i10 == 2)
				class33_sub7_sub2_sub2.method361(false, 1, 1);
			    if (i10 == 3)
				class33_sub7_sub2_sub2.method361(false, 0, -1);
			    if (i10 == 4)
				class33_sub7_sub2_sub2.method361(false, 0, 1);
			    if (i10 == 5)
				class33_sub7_sub2_sub2.method361(false, -1,
								 -1);
			    if (i10 == 6)
				class33_sub7_sub2_sub2.method361(false, -1, 0);
			    if (i10 == 7)
				class33_sub7_sub2_sub2.method361(false, -1, 1);
			}
		    }
		}
	    }
	    for (;;) {
		int i11 = arg2.method353(737, 11);
		if (i11 == 2047 || arg2.anInt1109 + 10 >= arg0 * 8)
		    break;
		if (aClass33_Sub7_Sub2_Sub2Array736[i11] == null) {
		    aClass33_Sub7_Sub2_Sub2Array736[i11]
			= new Class33_Sub7_Sub2_Sub2();
		    if (aClass33_Sub2_Sub3Array740[i11] != null)
			aClass33_Sub7_Sub2_Sub2Array736[i11]
			    .method364(aClass33_Sub2_Sub3Array740[i11], -384);
		}
		((client) this).anIntArray738[anInt737++] = i11;
		Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
		    = aClass33_Sub7_Sub2_Sub2Array736[i11];
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).aBoolean1174
		    = false;
		int i12 = arg2.method353(737, 5);
		if (i12 > 15)
		    i12 -= 32;
		int i13 = arg2.method353(737, 5);
		if (i13 > 15)
		    i13 -= 32;
		class33_sub7_sub2_sub2.method360(anInt843,
						 (((Class33_Sub7_Sub2)
						   aClass33_Sub7_Sub2_Sub2_792)
						  .anIntArray1178[0]) + i12,
						 (((Class33_Sub7_Sub2)
						   aClass33_Sub7_Sub2_Sub2_792)
						  .anIntArray1179[0]) + i13);
		anIntArray739[i++] = i11;
	    }
	    arg2.method354(0);
	    for (int i14 = 0; i14 < i; i14++) {
		int i15 = anIntArray739[i14];
		Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
		    = aClass33_Sub7_Sub2_Sub2Array736[i15];
		int i16 = arg2.method342();
		if ((i16 & 0x80) == 128)
		    i16 += arg2.method342() << 8;
		if ((i16 & 0x1) == 1) {
		    int i17 = arg2.method342();
		    byte[] bytes = new byte[i17];
		    Class33_Sub2_Sub3 class33_sub2_sub3
			= new Class33_Sub2_Sub3(bytes, (byte) 63);
		    arg2.method351(0, i17, bytes, false);
		    aClass33_Sub2_Sub3Array740[i15] = class33_sub2_sub3;
		    class33_sub7_sub2_sub2.method364(class33_sub2_sub3, -384);
		}
		if ((i16 & 0x2) == 2) {
		    int i18 = arg2.method344();
		    if (i18 == 65535)
			i18 = -1;
		    if (i18 == (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
				.anInt1157))
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1161
			    = 0;
		    int i19 = arg2.method342();
		    if (i18 == -1
			|| (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			    .anInt1157) == -1
			|| (Class10.aClass10Array183[i18].anInt191
			    > (Class10.aClass10Array183
			       [(((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
				 .anInt1157)]
			       .anInt191))) {
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1157
			    = i18;
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1158
			    = 0;
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1159
			    = 0;
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1160
			    = i19;
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1161
			    = 0;
		    }
		}
		if ((i16 & 0x4) == 4) {
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1151
			= arg2.method344();
		    if (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1151
			== 65535)
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1151
			    = -1;
		}
		if ((i16 & 0x8) == 8) {
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).aString1142
			= arg2.method349();
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1144 = 0;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1145 = 0;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1143
			= 150;
		    method81(2,
			     (((Class33_Sub7_Sub2_Sub2) class33_sub7_sub2_sub2)
			      .aString1273),
			     (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .aString1142),
			     36887);
		}
		if ((i16 & 0x10) == 16) {
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1146
			= arg2.method342();
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1147
			= arg2.method342();
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1148
			= anInt647 + 400;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1149
			= arg2.method342();
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1150
			= arg2.method342();
		}
		if ((i16 & 0x20) == 32) {
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1152
			= arg2.method344();
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1153
			= arg2.method344();
		}
		if ((i16 & 0x40) == 64) {
		    int i20 = arg2.method344();
		    int i21 = arg2.method342();
		    long l = Class35.method372(((Class33_Sub7_Sub2_Sub2)
						class33_sub7_sub2_sub2)
					       .aString1273);
		    boolean flag = false;
		    for (int i22 = 0; i22 < anInt821; i22++) {
			if (aLongArray831[i22] == l) {
			    flag = true;
			    break;
			}
		    }
		    if (!flag) {
			String string = Class36.method379(false, arg2, i21);
			string = Class16.method153(anInt946, string);
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			    .aString1142
			    = string;
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1144
			    = i20 >> 8;
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1145
			    = i20 & 0xff;
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1143
			    = 150;
			method81(2,
				 ((Class33_Sub7_Sub2_Sub2)
				  class33_sub7_sub2_sub2).aString1273,
				 string, 36887);
		    }
		}
		if ((i16 & 0x100) == 256) {
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1162
			= arg2.method344();
		    int i23 = arg2.method347();
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1166
			= i23 >> 16;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1165
			= anInt647 + (i23 & 0xffff);
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1163 = 0;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1164 = 0;
		    if (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1165
			> anInt647)
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1163
			    = -1;
		    if (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1162
			== 65535)
			((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1162
			    = -1;
		}
		if ((i16 & 0x200) == 512) {
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1167
			= arg2.method342();
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1169
			= arg2.method342();
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1168
			= arg2.method342();
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1170
			= arg2.method342();
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1171
			= arg2.method344() + anInt647;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1172
			= arg2.method344() + anInt647;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1173
			= arg2.method342();
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1177 = 0;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			.anIntArray1178[0]
			= (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			   .anInt1168);
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			.anIntArray1179[0]
			= (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			   .anInt1170);
		}
	    }
	    for (int i24 = 0; i24 < anInt832; i24++) {
		int i25 = ((client) this).anIntArray833[i24];
		if (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2Array736[i25])
		    .aBoolean1174)
		    method46(false, i25);
	    }
	}
    }
    
    public final void method56(Class33_Sub2_Sub3 arg0, boolean arg1,
			       int arg2) {
	anInt832 = 0;
	aBoolean825 &= arg1;
	arg0.method352(0);
	int i = arg0.method353(737, 8);
	if (i < anInt935) {
	    for (int i1 = i; i1 < anInt935; i1++) {
		((client) this).anIntArray833[anInt832++]
		    = ((client) this).anIntArray936[i1];
		((Class33_Sub7_Sub2) (aClass33_Sub7_Sub2_Sub1Array934
				      [((client) this).anIntArray936[i1]]))
		    .aBoolean1174
		    = true;
	    }
	}
	int i2 = 0;
	anInt935 = 0;
	for (int i3 = 0; i3 < i; i3++) {
	    int i4 = ((client) this).anIntArray936[i3];
	    Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
		= aClass33_Sub7_Sub2_Sub1Array934[i4];
	    int i5 = arg0.method353(737, 1);
	    if (i5 == 0)
		((client) this).anIntArray936[anInt935++] = i4;
	    else {
		int i6 = arg0.method353(737, 2);
		if (i6 == 3) {
		    ((client) this).anIntArray833[anInt832++] = i4;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).aBoolean1174
			= true;
		} else {
		    ((client) this).anIntArray936[anInt935++] = i4;
		    if (i6 == 0)
			anIntArray739[i2++] = i4;
		    else {
			if (i6 == 2)
			    anIntArray739[i2++] = i4;
			int i7 = arg0.method353(737, 3);
			if (i7 == 0)
			    class33_sub7_sub2_sub1.method361(false, 1, -1);
			if (i7 == 1)
			    class33_sub7_sub2_sub1.method361(false, 1, 0);
			if (i7 == 2)
			    class33_sub7_sub2_sub1.method361(false, 1, 1);
			if (i7 == 3)
			    class33_sub7_sub2_sub1.method361(false, 0, -1);
			if (i7 == 4)
			    class33_sub7_sub2_sub1.method361(false, 0, 1);
			if (i7 == 5)
			    class33_sub7_sub2_sub1.method361(false, -1, -1);
			if (i7 == 6)
			    class33_sub7_sub2_sub1.method361(false, -1, 0);
			if (i7 == 7)
			    class33_sub7_sub2_sub1.method361(false, -1, 1);
		    }
		}
	    }
	}
	for (;;) {
	    int i8 = arg0.method353(737, 13);
	    if (i8 == 8191 || arg0.anInt1109 + 21 >= arg2 * 8)
		break;
	    ((client) this).anIntArray936[anInt935++] = i8;
	    if (aClass33_Sub7_Sub2_Sub1Array934[i8] == null)
		aClass33_Sub7_Sub2_Sub1Array934[i8]
		    = new Class33_Sub7_Sub2_Sub1();
	    Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
		= aClass33_Sub7_Sub2_Sub1Array934[i8];
	    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).aBoolean1174 = false;
	    ((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1).aClass38_1268
		= Class38.method389(arg0.method353(737, 11));
	    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1135
		= (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		   .aClass38_1268.aByte567);
	    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1136
		= (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		   .aClass38_1268.anInt571);
	    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1137
		= (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		   .aClass38_1268.anInt572);
	    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1138
		= (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		   .aClass38_1268.anInt573);
	    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1139
		= (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		   .aClass38_1268.anInt574);
	    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1140
		= (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		   .aClass38_1268.anInt570);
	    int i9 = arg0.method353(737, 5);
	    if (i9 > 15)
		i9 -= 32;
	    int i10 = arg0.method353(737, 5);
	    if (i10 > 15)
		i10 -= 32;
	    class33_sub7_sub2_sub1.method360(anInt843,
					     (((Class33_Sub7_Sub2)
					       aClass33_Sub7_Sub2_Sub2_792)
					      .anIntArray1178[0]) + i9,
					     (((Class33_Sub7_Sub2)
					       aClass33_Sub7_Sub2_Sub2_792)
					      .anIntArray1179[0]) + i10);
	    int i11 = arg0.method353(737, 1);
	    if (i11 == 1)
		anIntArray739[i2++] = i8;
	}
	arg0.method354(0);
	for (int i12 = 0; i12 < i2; i12++) {
	    int i13 = anIntArray739[i12];
	    Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
		= aClass33_Sub7_Sub2_Sub1Array934[i13];
	    int i14 = arg0.method342();
	    if ((i14 & 0x2) == 2) {
		int i15 = arg0.method344();
		if (i15 == 65535)
		    i15 = -1;
		if (i15
		    == ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1157)
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1161 = 0;
		int i16 = arg0.method342();
		if (i15 == -1
		    || (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1157
			== -1)
		    || (Class10.aClass10Array183[i15].anInt191
			> (Class10.aClass10Array183
			   [(((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			     .anInt1157)]
			   .anInt191))) {
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1157
			= i15;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1158 = 0;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1159 = 0;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1160
			= i16;
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1161 = 0;
		}
	    }
	    if ((i14 & 0x4) == 4) {
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1151
		    = arg0.method344();
		if (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1151
		    == 65535)
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1151
			= -1;
	    }
	    if ((i14 & 0x8) == 8) {
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).aString1142
		    = arg0.method349();
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1143 = 100;
	    }
	    if ((i14 & 0x10) == 16) {
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1146
		    = arg0.method342();
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1147
		    = arg0.method342();
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1148
		    = anInt647 + 400;
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1149
		    = arg0.method342();
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1150
		    = arg0.method342();
	    }
	    if ((i14 & 0x20) == 32) {
		((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1).aClass38_1268
		    = Class38.method389(arg0.method344());
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1136
		    = (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		       .aClass38_1268.anInt571);
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1137
		    = (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		       .aClass38_1268.anInt572);
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1138
		    = (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		       .aClass38_1268.anInt573);
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1139
		    = (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		       .aClass38_1268.anInt574);
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1140
		    = (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		       .aClass38_1268.anInt570);
	    }
	    if ((i14 & 0x40) == 64) {
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1162
		    = arg0.method344();
		int i17 = arg0.method347();
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1166
		    = i17 >> 16;
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1165
		    = anInt647 + (i17 & 0xffff);
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1163 = 0;
		((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1164 = 0;
		if (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1165
		    > anInt647)
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1163
			= -1;
		if (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1162
		    == 65535)
		    ((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1162
			= -1;
	    }
	}
	for (int i18 = 0; i18 < anInt832; i18++) {
	    int i19 = ((client) this).anIntArray833[i18];
	    if (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub1Array934[i19])
		.aBoolean1174)
		method48(i19, true);
	}
    }
    
    public final void method57(boolean arg0) {
	aBoolean825 &= arg0;
	if (anInt828 >= 2 || anInt719 != 0 || anInt847 != 0) {
	    String string;
	    if (anInt719 == 1 && anInt828 < 2)
		string = "Use " + ((client) this).aString723 + " with...";
	    else if (anInt847 == 1 && anInt828 < 2)
		string = ((client) this).aString850 + "...";
	    else
		string = aStringArray631[anInt828 - 1];
	    if (anInt828 > 2)
		string += "@whi@ / " + (anInt828 - 2) + " more options";
	    aClass33_Sub2_Sub2_Sub4_654.method330(true, 4, 15, 16777215, true,
						  string);
	}
    }
    
    public final void method58(boolean arg0) {
	int i = anInt813;
	int i1 = anInt814;
	int i2 = anInt815;
	int i3 = anInt816;
	int i4 = 6116423;
	Class33_Sub2_Sub2.method288(i4, i2, i1, false, i3, i);
	Class33_Sub2_Sub2.method288(0, i2 - 2, i1 + 1, false, 16, i + 1);
	Class33_Sub2_Sub2.method289(i2 - 2, i3 - 19, i + 1, i1 + 18, true, 0);
	aClass33_Sub2_Sub2_Sub4_654.method328("Choose Option", i + 3, i1 + 14,
					      i4, -200);
	if (arg0)
	    startUp();
	int i5 = mouseX;
	int i6 = mouseY;
	if (anInt812 == 0) {
	    i5 -= 8;
	    i6 -= 11;
	}
	if (anInt812 == 1) {
	    i5 -= 562;
	    i6 -= 231;
	}
	for (int i7 = 0; i7 < anInt828; i7++) {
	    int i8 = i1 + 31 + (anInt828 - 1 - i7) * 15;
	    int i9 = 16777215;
	    if (i5 > i && i5 < i + i2 && i6 > i8 - 13 && i6 < i8 + 3)
		i9 = 16776960;
	    aClass33_Sub2_Sub2_Sub4_654.method330(true, i + 3, i8, i9, true,
						  aStringArray631[i7]);
	}
    }
    
    public final void method59(int arg0) {
	if (arg0 <= 0)
	    anInt861 = 371;
	int i = clickMode1;
	if (anInt847 == 1 && clickX >= 520 && clickY >= 165 && clickX <= 788
	    && clickY <= 230)
	    i = 0;
	if (aBoolean881) {
	    if (i != 1) {
		int i1 = mouseX;
		int i2 = mouseY;
		if (anInt812 == 0) {
		    i1 -= 8;
		    i2 -= 11;
		}
		if (anInt812 == 1) {
		    i1 -= 562;
		    i2 -= 231;
		}
		if (i1 < anInt813 - 10 || i1 > anInt813 + anInt815 + 10
		    || i2 < anInt814 - 10 || i2 > anInt814 + anInt816 + 10) {
		    aBoolean881 = false;
		    if (anInt812 == 1)
			aBoolean646 = true;
		}
	    }
	    if (i == 1) {
		int i3 = anInt813;
		int i4 = anInt814;
		int i5 = anInt815;
		int i6 = clickX;
		int i7 = clickY;
		if (anInt812 == 0) {
		    i6 -= 8;
		    i7 -= 11;
		}
		if (anInt812 == 1) {
		    i6 -= 562;
		    i7 -= 231;
		}
		int i8 = -1;
		for (int i9 = 0; i9 < anInt828; i9++) {
		    int i10 = i4 + 31 + (anInt828 - 1 - i9) * 15;
		    if (i6 > i3 && i6 < i3 + i5 && i7 > i10 - 13
			&& i7 < i10 + 3)
			i8 = i9;
		}
		if (i8 != -1)
		    method60(i8, -753);
		aBoolean881 = false;
		if (anInt812 == 1)
		    aBoolean646 = true;
	    }
	} else {
	    if (i == 1 && anInt824 == 1 && anInt828 > 2)
		i = 2;
	    if (i == 1 && anInt828 > 0)
		method60(anInt828 - 1, -753);
	    if (i == 2 && anInt828 > 0) {
		int i11
		    = aClass33_Sub2_Sub2_Sub4_654.method327(331,
							    "Choose Option");
		for (int i12 = 0; i12 < anInt828; i12++) {
		    int i13 = aClass33_Sub2_Sub2_Sub4_654
				  .method327(331, aStringArray631[i12]);
		    if (i13 > i11)
			i11 = i13;
		}
		i11 += 8;
		int i14 = anInt828 * 15 + 21;
		if (clickX > 8 && clickY > 11 && clickX < 520
		    && clickY < 345) {
		    int i15 = clickX - 8 - i11 / 2;
		    if (i15 + i11 > 512)
			i15 = 512 - i11;
		    if (i15 < 0)
			i15 = 0;
		    int i16 = clickY - 11;
		    if (i16 + i14 > 334)
			i16 = 334 - i14;
		    if (i16 < 0)
			i16 = 0;
		    aBoolean881 = true;
		    anInt812 = 0;
		    anInt813 = i15;
		    anInt814 = i16;
		    anInt815 = i11;
		    anInt816 = anInt828 * 15 + 22;
		}
		if (clickX > 562 && clickY > 231 && clickX < 752
		    && clickY < 492) {
		    int i17 = clickX - 562 - i11 / 2;
		    if (i17 < 0)
			i17 = 0;
		    else if (i17 + i11 > 190)
			i17 = 190 - i11;
		    int i18 = clickY - 231;
		    if (i18 < 0)
			i18 = 0;
		    else if (i18 + i14 > 261)
			i18 = 261 - i14;
		    aBoolean881 = true;
		    anInt812 = 1;
		    anInt813 = i17;
		    anInt814 = i18;
		    anInt815 = i11;
		    anInt816 = anInt828 * 15 + 22;
		}
	    }
	}
    }
    
    public final void method60(int arg0, int arg1) {
	if (arg0 >= 0) {
	    if (aBoolean707) {
		aBoolean707 = false;
		aBoolean760 = true;
	    }
	    int i = anIntArray769[arg0];
	    int i1 = anIntArray770[arg0];
	    int i2 = anIntArray771[arg0];
	    int i3 = anIntArray772[arg0];
	    while (arg1 >= 0)
		anInt661 = aClass32_674.method255();
	    if (i2 == 636) {
		Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
		    = aClass33_Sub7_Sub2_Sub2Array736[i3];
		if (class33_sub7_sub2_sub2 != null) {
		    method50((((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anIntArray1179[0]),
			     true, 0, false, 1,
			     (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2)
			      .anIntArray1178[0]),
			     (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			      .anIntArray1178[0]),
			     0, 1, 0,
			     (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			      .anIntArray1179[0]));
		    anInt836 = clickX;
		    anInt837 = clickY;
		    anInt839 = 2;
		    anInt838 = 0;
		    aClass33_Sub2_Sub3_696.method334(false, 185);
		    aClass33_Sub2_Sub3_696.method336(i3);
		    aClass33_Sub2_Sub3_696.method336(anInt722);
		    aClass33_Sub2_Sub3_696.method336(anInt720);
		    aClass33_Sub2_Sub3_696.method336(anInt721);
		}
	    }
	    if (i2 == 1294) {
		int i4 = i3 >> 14 & 0x7fff;
		Class37 class37 = Class37.method383(i4);
		String string;
		if (class37.aByteArray529 != null)
		    string = new String(class37.aByteArray529);
		else
		    string = "It's a " + class37.aString528 + ".";
		method81(0, "", string, 36887);
	    }
	    if (i2 == 700) {
		aClass33_Sub2_Sub3_696.method334(false, 101);
		aClass33_Sub2_Sub3_696.method336(i1);
		Class6 class6 = Class6.aClass6Array105[i1];
		if (class6.anIntArrayArray117 != null
		    && class6.anIntArrayArray117[0][0] == 5) {
		    int i5 = class6.anIntArrayArray117[0][1];
		    if (anIntArray937[i5] != class6.anIntArray119[0]) {
			anIntArray937[i5] = class6.anIntArray119[0];
			method75(6, i5);
			aBoolean646 = true;
		    }
		}
	    }
	    if (i2 == 54)
		method49(i3, i, i1, 356, 249);
	    if (i2 == 806) {
		Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
		    = aClass33_Sub7_Sub2_Sub1Array934[i3];
		if (class33_sub7_sub2_sub1 != null) {
		    method50((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			      .anIntArray1179[0]),
			     true, 0, false, 1,
			     (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
			      .anIntArray1178[0]),
			     (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			      .anIntArray1178[0]),
			     0, 1, 0,
			     (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			      .anIntArray1179[0]));
		    anInt836 = clickX;
		    anInt837 = clickY;
		    anInt839 = 2;
		    anInt838 = 0;
		    aClass33_Sub2_Sub3_696.method334(false, 28);
		    aClass33_Sub2_Sub3_696.method336(i3);
		    aClass33_Sub2_Sub3_696.method336(anInt722);
		    aClass33_Sub2_Sub3_696.method336(anInt720);
		    aClass33_Sub2_Sub3_696.method336(anInt721);
		}
	    }
	    if (i2 == 243) {
		method49(i3, i, i1, 356, 10);
		aClass33_Sub2_Sub3_696.method336(anInt848);
	    }
	    if (i2 == 17) {
		Class6 class6 = Class6.aClass6Array105[i1];
		anInt847 = 1;
		anInt848 = i1;
		anInt849 = class6.anInt158;
		anInt719 = 0;
		String string = class6.aString156;
		if (string.indexOf(" ") != -1)
		    string = string.substring(0, string.indexOf(" "));
		String string6 = class6.aString156;
		if (string6.indexOf(" ") != -1)
		    string6 = string6.substring(string6.indexOf(" ") + 1);
		((client) this).aString850
		    = string + " " + class6.aString157 + " " + string6;
		if (anInt849 == 16) {
		    aBoolean646 = true;
		    anInt712 = 3;
		    aBoolean729 = true;
		}
	    } else {
		if (i2 == 284) {
		    if (!aBoolean881)
			aClass27_806.method229(clickY - 11, clickX - 8,
					       (byte) 6);
		    else
			aClass27_806.method229(i1 - 11, i - 8, (byte) 6);
		}
		if (i2 == 669) {
		    anInt719 = 1;
		    anInt720 = i;
		    anInt721 = i1;
		    anInt722 = i3;
		    ((client) this).aString723
			= Class39.method395(i3).aString599;
		    anInt847 = 0;
		} else {
		    if (i2 == 146)
			method49(i3, i, i1, 356, 65);
		    if (i2 == 237) {
			method49(i3, i, i1, 356, 205);
			aClass33_Sub2_Sub3_696.method336(anInt722);
			aClass33_Sub2_Sub3_696.method336(anInt720);
			aClass33_Sub2_Sub3_696.method336(anInt721);
		    }
		    if (i2 == 739) {
			aClass33_Sub2_Sub3_696.method334(false, 101);
			aClass33_Sub2_Sub3_696.method336(i1);
			Class6 class6 = Class6.aClass6Array105[i1];
			if (class6.anIntArrayArray117 != null
			    && class6.anIntArrayArray117[0][0] == 5) {
			    int i7 = class6.anIntArrayArray117[0][1];
			    anIntArray937[i7] = 1 - anIntArray937[i7];
			    method75(6, i7);
			    aBoolean646 = true;
			}
		    }
		    if (i2 == 710 || i2 == 301 || i2 == 328 || i2 == 498
			|| i2 == 74) {
			Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
			    = aClass33_Sub7_Sub2_Sub1Array934[i3];
			if (class33_sub7_sub2_sub1 != null) {
			    method50((((Class33_Sub7_Sub2)
				       class33_sub7_sub2_sub1)
				      .anIntArray1179[0]),
				     true, 0, false, 1,
				     (((Class33_Sub7_Sub2)
				       class33_sub7_sub2_sub1)
				      .anIntArray1178[0]),
				     (((Class33_Sub7_Sub2)
				       aClass33_Sub7_Sub2_Sub2_792)
				      .anIntArray1178[0]),
				     0, 1, 0,
				     (((Class33_Sub7_Sub2)
				       aClass33_Sub7_Sub2_Sub2_792)
				      .anIntArray1179[0]));
			    anInt836 = clickX;
			    anInt837 = clickY;
			    anInt839 = 2;
			    anInt838 = 0;
			    if (i2 == 328)
				aClass33_Sub2_Sub3_696.method334(false, 107);
			    if (i2 == 301)
				aClass33_Sub2_Sub3_696.method334(false, 152);
			    if (i2 == 498)
				aClass33_Sub2_Sub3_696.method334(false, 119);
			    if (i2 == 74)
				aClass33_Sub2_Sub3_696.method334(false, 8);
			    if (i2 == 710)
				aClass33_Sub2_Sub3_696.method334(false, 41);
			    aClass33_Sub2_Sub3_696.method336(i3);
			}
		    }
		    if (i2 == 1682 || i2 == 1930 || i2 == 1754 || i2 == 1484) {
			Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
			    = aClass33_Sub7_Sub2_Sub2Array736[i3];
			if (class33_sub7_sub2_sub2 != null) {
			    method50((((Class33_Sub7_Sub2)
				       class33_sub7_sub2_sub2)
				      .anIntArray1179[0]),
				     true, 0, false, 1,
				     (((Class33_Sub7_Sub2)
				       class33_sub7_sub2_sub2)
				      .anIntArray1178[0]),
				     (((Class33_Sub7_Sub2)
				       aClass33_Sub7_Sub2_Sub2_792)
				      .anIntArray1178[0]),
				     0, 1, 0,
				     (((Class33_Sub7_Sub2)
				       aClass33_Sub7_Sub2_Sub2_792)
				      .anIntArray1179[0]));
			    anInt836 = clickX;
			    anInt837 = clickY;
			    anInt839 = 2;
			    anInt838 = 0;
			    if (i2 == 1930)
				aClass33_Sub2_Sub3_696.method334(false, 212);
			    if (i2 == 1682)
				aClass33_Sub2_Sub3_696.method334(false, 192);
			    if (i2 == 1484)
				aClass33_Sub2_Sub3_696.method334(false, 172);
			    if (i2 == 1754)
				aClass33_Sub2_Sub3_696.method334(false, 251);
			    aClass33_Sub2_Sub3_696.method336(i3);
			}
		    }
		    if (i2 == 462)
			method49(i3, i, i1, 356, 233);
		    if (i2 == 1971 || i2 == 1258) {
			Class39 class39 = Class39.method395(i3);
			String string;
			if (class39.aByteArray600 != null)
			    string = new String(class39.aByteArray600);
			else
			    string = "It's a " + class39.aString599 + ".";
			method81(0, "", string, 36887);
		    }
		    if (i2 == 730) {
			Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
			    = aClass33_Sub7_Sub2_Sub2Array736[i3];
			if (class33_sub7_sub2_sub2 != null) {
			    method50((((Class33_Sub7_Sub2)
				       class33_sub7_sub2_sub2)
				      .anIntArray1179[0]),
				     true, 0, false, 1,
				     (((Class33_Sub7_Sub2)
				       class33_sub7_sub2_sub2)
				      .anIntArray1178[0]),
				     (((Class33_Sub7_Sub2)
				       aClass33_Sub7_Sub2_Sub2_792)
				      .anIntArray1178[0]),
				     0, 1, 0,
				     (((Class33_Sub7_Sub2)
				       aClass33_Sub7_Sub2_Sub2_792)
				      .anIntArray1179[0]));
			    anInt836 = clickX;
			    anInt837 = clickY;
			    anInt839 = 2;
			    anInt838 = 0;
			    aClass33_Sub2_Sub3_696.method334(false, 252);
			    aClass33_Sub2_Sub3_696.method336(i3);
			    aClass33_Sub2_Sub3_696.method336(anInt848);
			}
		    }
		    if (i2 == 917 || i2 == 14 || i2 == 401 || i2 == 514
			|| i2 == 164) {
			boolean flag = method50(i1, true, 0, false, 0, i,
						(((Class33_Sub7_Sub2)
						  aClass33_Sub7_Sub2_Sub2_792)
						 .anIntArray1178[0]),
						0, 0, 0,
						(((Class33_Sub7_Sub2)
						  aClass33_Sub7_Sub2_Sub2_792)
						 .anIntArray1179[0]));
			if (!flag)
			    flag = method50(i1, true, 0, false, 1, i,
					    (((Class33_Sub7_Sub2)
					      aClass33_Sub7_Sub2_Sub2_792)
					     .anIntArray1178[0]),
					    0, 1, 0,
					    (((Class33_Sub7_Sub2)
					      aClass33_Sub7_Sub2_Sub2_792)
					     .anIntArray1179[0]));
			anInt836 = clickX;
			anInt837 = clickY;
			anInt839 = 2;
			anInt838 = 0;
			if (i2 == 164)
			    aClass33_Sub2_Sub3_696.method334(false, 140);
			if (i2 == 514)
			    aClass33_Sub2_Sub3_696.method334(false, 235);
			if (i2 == 401)
			    aClass33_Sub2_Sub3_696.method334(false, 113);
			if (i2 == 14)
			    aClass33_Sub2_Sub3_696.method334(false, 61);
			if (i2 == 917)
			    aClass33_Sub2_Sub3_696.method334(false, 186);
			aClass33_Sub2_Sub3_696.method336(i + anInt925);
			aClass33_Sub2_Sub3_696.method336(i1 + anInt926);
			aClass33_Sub2_Sub3_696.method336(i3);
		    }
		    if (i2 == 677 || i2 == 522 || i2 == 249 || i2 == 247
			|| i2 == 296) {
			if (i2 == 296)
			    aClass33_Sub2_Sub3_696.method334(false, 38);
			if (i2 == 247)
			    aClass33_Sub2_Sub3_696.method334(false, 155);
			if (i2 == 249)
			    aClass33_Sub2_Sub3_696.method334(false, 146);
			if (i2 == 522)
			    aClass33_Sub2_Sub3_696.method334(false, 240);
			if (i2 == 677)
			    aClass33_Sub2_Sub3_696.method334(false, 121);
			aClass33_Sub2_Sub3_696.method336(i3);
			aClass33_Sub2_Sub3_696.method336(i);
			aClass33_Sub2_Sub3_696.method336(i1);
			anInt905 = 0;
			anInt906 = i1;
			anInt907 = i;
			anInt908 = 2;
			if (Class6.aClass6Array105[i1].anInt111 == anInt709)
			    anInt908 = 1;
			if (Class6.aClass6Array105[i1].anInt111 == anInt917)
			    anInt908 = 3;
		    }
		    if (i2 == 883 && !aBoolean678) {
			aClass33_Sub2_Sub3_696.method334(false, 167);
			aClass33_Sub2_Sub3_696.method336(i1);
			aBoolean678 = true;
		    }
		    if (i2 == 754)
			method49(i3, i, i1, 356, 216);
		    if (i2 == 39) {
			aClass33_Sub2_Sub3_696.method334(false, 168);
			aClass33_Sub2_Sub3_696.method336(i3);
			aClass33_Sub2_Sub3_696.method336(i);
			aClass33_Sub2_Sub3_696.method336(i1);
			aClass33_Sub2_Sub3_696.method336(anInt722);
			aClass33_Sub2_Sub3_696.method336(anInt720);
			aClass33_Sub2_Sub3_696.method336(anInt721);
			anInt905 = 0;
			anInt906 = i1;
			anInt907 = i;
			anInt908 = 2;
			if (Class6.aClass6Array105[i1].anInt111 == anInt709)
			    anInt908 = 1;
			if (Class6.aClass6Array105[i1].anInt111 == anInt917)
			    anInt908 = 3;
		    }
		    if (i2 == 981)
			method49(i3, i, i1, 356, 221);
		    if (i2 == 454) {
			aClass33_Sub2_Sub3_696.method334(false, 213);
			if (anInt704 != -1) {
			    anInt704 = -1;
			    aBoolean646 = true;
			    aBoolean678 = false;
			    aBoolean729 = true;
			}
			if (anInt917 != -1) {
			    anInt917 = -1;
			    aBoolean760 = true;
			    aBoolean678 = false;
			}
			anInt709 = -1;
		    }
		    if (i2 == 759) {
			Class6 class6 = Class6.aClass6Array105[i1];
			boolean flag = true;
			if (class6.anInt114 > 0)
			    flag = method77(class6, 2);
			if (flag) {
			    aClass33_Sub2_Sub3_696.method334(false, 101);
			    aClass33_Sub2_Sub3_696.method336(i1);
			}
		    }
		    if (i2 == 160) {
			boolean flag = method50(i1, true, 0, false, 0, i,
						(((Class33_Sub7_Sub2)
						  aClass33_Sub7_Sub2_Sub2_792)
						 .anIntArray1178[0]),
						0, 0, 0,
						(((Class33_Sub7_Sub2)
						  aClass33_Sub7_Sub2_Sub2_792)
						 .anIntArray1179[0]));
			if (!flag)
			    flag = method50(i1, true, 0, false, 1, i,
					    (((Class33_Sub7_Sub2)
					      aClass33_Sub7_Sub2_Sub2_792)
					     .anIntArray1178[0]),
					    0, 1, 0,
					    (((Class33_Sub7_Sub2)
					      aClass33_Sub7_Sub2_Sub2_792)
					     .anIntArray1179[0]));
			anInt836 = clickX;
			anInt837 = clickY;
			anInt839 = 2;
			anInt838 = 0;
			aClass33_Sub2_Sub3_696.method334(false, 42);
			aClass33_Sub2_Sub3_696.method336(i + anInt925);
			aClass33_Sub2_Sub3_696.method336(i1 + anInt926);
			aClass33_Sub2_Sub3_696.method336(i3);
			aClass33_Sub2_Sub3_696.method336(anInt722);
			aClass33_Sub2_Sub3_696.method336(anInt720);
			aClass33_Sub2_Sub3_696.method336(anInt721);
		    }
		    if (i2 == 678 || i2 == 523 || i2 == 836 || i2 == 548
			|| i2 == 62) {
			if (i2 == 548)
			    aClass33_Sub2_Sub3_696.method334(false, 21);
			if (i2 == 523)
			    aClass33_Sub2_Sub3_696.method334(false, 181);
			if (i2 == 836)
			    aClass33_Sub2_Sub3_696.method334(false, 145);
			if (i2 == 678)
			    aClass33_Sub2_Sub3_696.method334(false, 175);
			if (i2 == 62)
			    aClass33_Sub2_Sub3_696.method334(false, 47);
			aClass33_Sub2_Sub3_696.method336(i3);
			aClass33_Sub2_Sub3_696.method336(i);
			aClass33_Sub2_Sub3_696.method336(i1);
			anInt905 = 0;
			anInt906 = i1;
			anInt907 = i;
			anInt908 = 2;
			if (Class6.aClass6Array105[i1].anInt111 == anInt709)
			    anInt908 = 1;
			if (Class6.aClass6Array105[i1].anInt111 == anInt917)
			    anInt908 = 3;
		    }
		    if (i2 == 130) {
			Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
			    = aClass33_Sub7_Sub2_Sub1Array934[i3];
			if (class33_sub7_sub2_sub1 != null) {
			    method50((((Class33_Sub7_Sub2)
				       class33_sub7_sub2_sub1)
				      .anIntArray1179[0]),
				     true, 0, false, 1,
				     (((Class33_Sub7_Sub2)
				       class33_sub7_sub2_sub1)
				      .anIntArray1178[0]),
				     (((Class33_Sub7_Sub2)
				       aClass33_Sub7_Sub2_Sub2_792)
				      .anIntArray1178[0]),
				     0, 1, 0,
				     (((Class33_Sub7_Sub2)
				       aClass33_Sub7_Sub2_Sub2_792)
				      .anIntArray1179[0]));
			    anInt836 = clickX;
			    anInt837 = clickY;
			    anInt839 = 2;
			    anInt838 = 0;
			    aClass33_Sub2_Sub3_696.method334(false, 189);
			    aClass33_Sub2_Sub3_696.method336(i3);
			    aClass33_Sub2_Sub3_696.method336(anInt848);
			}
		    }
		    if (i2 == 1725) {
			Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
			    = aClass33_Sub7_Sub2_Sub1Array934[i3];
			if (class33_sub7_sub2_sub1 != null) {
			    String string;
			    if ((((Class33_Sub7_Sub2_Sub1)
				  class33_sub7_sub2_sub1)
				 .aClass38_1268.aByteArray566)
				!= null)
				string
				    = new String(((Class33_Sub7_Sub2_Sub1)
						  class33_sub7_sub2_sub1)
						 .aClass38_1268.aByteArray566);
			    else
				string = "It's a " + (((Class33_Sub7_Sub2_Sub1)
						       class33_sub7_sub2_sub1)
						      .aClass38_1268
						      .aString565) + ".";
			    method81(0, "", string, 36887);
			}
		    }
		    if (i2 == 449) {
			aClass33_Sub2_Sub3_696.method334(false, 247);
			aClass33_Sub2_Sub3_696.method336(i3);
			aClass33_Sub2_Sub3_696.method336(i);
			aClass33_Sub2_Sub3_696.method336(i1);
			aClass33_Sub2_Sub3_696.method336(anInt848);
			anInt905 = 0;
			anInt906 = i1;
			anInt907 = i;
			anInt908 = 2;
			if (Class6.aClass6Array105[i1].anInt111 == anInt709)
			    anInt908 = 1;
			if (Class6.aClass6Array105[i1].anInt111 == anInt917)
			    anInt908 = 3;
		    }
		    if (i2 == 504) {
			boolean flag = method50(i1, true, 0, false, 0, i,
						(((Class33_Sub7_Sub2)
						  aClass33_Sub7_Sub2_Sub2_792)
						 .anIntArray1178[0]),
						0, 0, 0,
						(((Class33_Sub7_Sub2)
						  aClass33_Sub7_Sub2_Sub2_792)
						 .anIntArray1179[0]));
			if (!flag)
			    flag = method50(i1, true, 0, false, 1, i,
					    (((Class33_Sub7_Sub2)
					      aClass33_Sub7_Sub2_Sub2_792)
					     .anIntArray1178[0]),
					    0, 1, 0,
					    (((Class33_Sub7_Sub2)
					      aClass33_Sub7_Sub2_Sub2_792)
					     .anIntArray1179[0]));
			anInt836 = clickX;
			anInt837 = clickY;
			anInt839 = 2;
			anInt838 = 0;
			aClass33_Sub2_Sub3_696.method334(false, 244);
			aClass33_Sub2_Sub3_696.method336(i + anInt925);
			aClass33_Sub2_Sub3_696.method336(i1 + anInt926);
			aClass33_Sub2_Sub3_696.method336(i3);
			aClass33_Sub2_Sub3_696.method336(anInt848);
		    }
		    anInt719 = 0;
		    anInt847 = 0;
		}
	    }
	}
    }
    
    public final void method61(byte arg0) {
	aStringArray631[0] = "Cancel";
	anIntArray771[0] = 1264;
	anInt828 = 1;
	if (mouseX > 8 && mouseY > 11 && mouseX < 520 && mouseY < 345) {
	    if (anInt709 != -1)
		method72(Class6.aClass6Array105[anInt709], true, 8, mouseX, 0,
			 mouseY, 11);
	    else
		method62((byte) 123);
	}
	if (anInt823 != anInt702)
	    anInt702 = anInt823;
	anInt823 = 0;
	if (arg0 == 0) {
	    boolean flag = false;
	} else
	    anInt684 = aClass32_674.method255();
	if (mouseX > 562 && mouseY > 231 && mouseX < 752 && mouseY < 492) {
	    if (anInt704 != -1)
		method72(Class6.aClass6Array105[anInt704], true, 562, mouseX,
			 0, mouseY, 231);
	    else if (anIntArray853[anInt712] != -1)
		method72(Class6.aClass6Array105[anIntArray853[anInt712]], true,
			 562, mouseX, 0, mouseY, 231);
	}
	if (anInt823 != anInt826) {
	    aBoolean646 = true;
	    anInt826 = anInt823;
	}
	anInt823 = 0;
	if (mouseX > 22 && mouseY > 375 && mouseX < 501 && mouseY < 471
	    && anInt917 != -1)
	    method72(Class6.aClass6Array105[anInt917], true, 22, mouseX, 0,
		     mouseY, 375);
	if (anInt917 != -1 && anInt823 != anInt650) {
	    aBoolean760 = true;
	    anInt650 = anInt823;
	}
	boolean flag = false;
	while (!flag) {
	    flag = true;
	    for (int i = 0; i < anInt828 - 1; i++) {
		if (anIntArray771[i] < 1000 && anIntArray771[i + 1] > 1000) {
		    String string = aStringArray631[i];
		    aStringArray631[i] = aStringArray631[i + 1];
		    aStringArray631[i + 1] = string;
		    int i1 = anIntArray771[i];
		    anIntArray771[i] = anIntArray771[i + 1];
		    anIntArray771[i + 1] = i1;
		    i1 = anIntArray769[i];
		    anIntArray769[i] = anIntArray769[i + 1];
		    anIntArray769[i + 1] = i1;
		    i1 = anIntArray770[i];
		    anIntArray770[i] = anIntArray770[i + 1];
		    anIntArray770[i + 1] = i1;
		    i1 = anIntArray772[i];
		    anIntArray772[i] = anIntArray772[i + 1];
		    anIntArray772[i + 1] = i1;
		    flag = false;
		}
	    }
	}
    }
    
    public final void method62(byte arg0) {
	if (anInt719 == 0 && anInt847 == 0) {
	    aStringArray631[anInt828] = "Walk here";
	    anIntArray771[anInt828] = 284;
	    anIntArray769[anInt828] = mouseX;
	    anIntArray770[anInt828] = mouseY;
	    anInt828++;
	}
	for (int i = 0; i < Class33_Sub2_Sub1.anInt1080; i++) {
	    int i1 = Class33_Sub2_Sub1.anIntArray1081[i];
	    int i2 = i1 & 0x7f;
	    int i3 = i1 >> 7 & 0x7f;
	    int i4 = i1 >> 29 & 0x3;
	    int i5 = i1 >> 14 & 0x7fff;
	    if (i4 == 2 && aClass27_806.method221(anInt858, i2, i3, i1) >= 0) {
		Class37 class37 = Class37.method383(i5);
		if (anInt719 == 1) {
		    aStringArray631[anInt828]
			= ("Use " + ((client) this).aString723 + " with @cya@"
			   + class37.aString528);
		    anIntArray771[anInt828] = 237;
		    anIntArray772[anInt828] = i1;
		    anIntArray769[anInt828] = i2;
		    anIntArray770[anInt828] = i3;
		    anInt828++;
		} else if (anInt847 == 1) {
		    if ((anInt849 & 0x4) == 4) {
			aStringArray631[anInt828]
			    = (((client) this).aString850 + " @cya@"
			       + class37.aString528);
			anIntArray771[anInt828] = 243;
			anIntArray772[anInt828] = i1;
			anIntArray769[anInt828] = i2;
			anIntArray770[anInt828] = i3;
			anInt828++;
		    }
		} else {
		    if (class37.aStringArray544 != null) {
			for (int i6 = 4; i6 >= 0; i6--) {
			    if (class37.aStringArray544[i6] != null) {
				aStringArray631[anInt828]
				    = (class37.aStringArray544[i6] + " @cya@"
				       + class37.aString528);
				if (i6 == 0)
				    anIntArray771[anInt828] = 981;
				if (i6 == 1)
				    anIntArray771[anInt828] = 462;
				if (i6 == 2)
				    anIntArray771[anInt828] = 54;
				if (i6 == 3)
				    anIntArray771[anInt828] = 146;
				if (i6 == 4)
				    anIntArray771[anInt828] = 754;
				anIntArray772[anInt828] = i1;
				anIntArray769[anInt828] = i2;
				anIntArray770[anInt828] = i3;
				anInt828++;
			    }
			}
		    }
		    aStringArray631[anInt828]
			= "Examine @cya@" + class37.aString528;
		    anIntArray771[anInt828] = 1294;
		    anIntArray772[anInt828] = i1;
		    anIntArray769[anInt828] = i2;
		    anIntArray770[anInt828] = i3;
		    anInt828++;
		}
	    }
	    if (i4 == 1) {
		Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
		    = aClass33_Sub7_Sub2_Sub1Array934[i5];
		if ((((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		     .aClass38_1268.aByte567) == 1
		    && (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1131
			& 0x7f) == 64
		    && (((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1132
			& 0x7f) == 64) {
		    for (int i7 = 0; i7 < anInt935; i7++) {
			Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1_8
			    = (aClass33_Sub7_Sub2_Sub1Array934
			       [((client) this).anIntArray936[i7]]);
			if (class33_sub7_sub2_sub1_8 != null
			    && (class33_sub7_sub2_sub1_8
				!= class33_sub7_sub2_sub1)
			    && (((Class33_Sub7_Sub2_Sub1)
				 class33_sub7_sub2_sub1_8)
				.aClass38_1268.aByte567) == 1
			    && ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1_8)
				 .anInt1131)
				== ((Class33_Sub7_Sub2)
				    class33_sub7_sub2_sub1).anInt1131)
			    && ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1_8)
				 .anInt1132)
				== ((Class33_Sub7_Sub2)
				    class33_sub7_sub2_sub1).anInt1132))
			    method63(i2, anInt827,
				     ((Class33_Sub7_Sub2_Sub1)
				      class33_sub7_sub2_sub1_8).aClass38_1268,
				     i3, ((client) this).anIntArray936[i7]);
		    }
		}
		method63(i2, anInt827,
			 (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
			  .aClass38_1268),
			 i3, i5);
	    }
	    if (i4 == 0) {
		Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
		    = aClass33_Sub7_Sub2_Sub2Array736[i5];
		if ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1131
		     & 0x7f) == 64
		    && (((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1132
			& 0x7f) == 64) {
		    for (int i9 = 0; i9 < anInt935; i9++) {
			Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
			    = (aClass33_Sub7_Sub2_Sub1Array934
			       [((client) this).anIntArray936[i9]]);
			if (class33_sub7_sub2_sub1 != null
			    && (((Class33_Sub7_Sub2_Sub1)
				 class33_sub7_sub2_sub1).aClass38_1268.aByte567
				== 1)
			    && ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
				 .anInt1131)
				== ((Class33_Sub7_Sub2)
				    class33_sub7_sub2_sub2).anInt1131)
			    && ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1)
				 .anInt1132)
				== ((Class33_Sub7_Sub2)
				    class33_sub7_sub2_sub2).anInt1132))
			    method63(i2, anInt827,
				     ((Class33_Sub7_Sub2_Sub1)
				      class33_sub7_sub2_sub1).aClass38_1268,
				     i3, ((client) this).anIntArray936[i9]);
		    }
		    for (int i10 = 0; i10 < anInt737; i10++) {
			Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2_11
			    = (aClass33_Sub7_Sub2_Sub2Array736
			       [((client) this).anIntArray738[i10]]);
			if (class33_sub7_sub2_sub2_11 != null
			    && (class33_sub7_sub2_sub2_11
				!= class33_sub7_sub2_sub2)
			    && (((Class33_Sub7_Sub2)
				 class33_sub7_sub2_sub2_11).anInt1131
				== ((Class33_Sub7_Sub2)
				    class33_sub7_sub2_sub2).anInt1131)
			    && (((Class33_Sub7_Sub2)
				 class33_sub7_sub2_sub2_11).anInt1132
				== ((Class33_Sub7_Sub2)
				    class33_sub7_sub2_sub2).anInt1132))
			    method64(i3, i2, class33_sub7_sub2_sub2_11, 576,
				     ((client) this).anIntArray738[i10]);
		    }
		}
		method64(i3, i2, class33_sub7_sub2_sub2, 576, i5);
	    }
	    if (i4 == 3) {
		Class22 class22 = aClass22ArrayArrayArray805[anInt858][i2][i3];
		if (class22 != null) {
		    for (Class33_Sub6 class33_sub6
			     = (Class33_Sub6) class22.method184((byte) 69);
			 class33_sub6 != null;
			 class33_sub6
			     = (Class33_Sub6) class22.method186((byte) 3)) {
			Class39 class39
			    = Class39.method395(class33_sub6.anInt999);
			if (anInt719 == 1) {
			    aStringArray631[anInt828]
				= ("Use " + ((client) this).aString723
				   + " with @lre@" + class39.aString599);
			    anIntArray771[anInt828] = 160;
			    anIntArray772[anInt828] = class33_sub6.anInt999;
			    anIntArray769[anInt828] = i2;
			    anIntArray770[anInt828] = i3;
			    anInt828++;
			} else if (anInt847 == 1) {
			    if ((anInt849 & 0x1) == 1) {
				aStringArray631[anInt828]
				    = (((client) this).aString850 + " @lre@"
				       + class39.aString599);
				anIntArray771[anInt828] = 504;
				anIntArray772[anInt828]
				    = class33_sub6.anInt999;
				anIntArray769[anInt828] = i2;
				anIntArray770[anInt828] = i3;
				anInt828++;
			    }
			} else {
			    for (int i12 = 4; i12 >= 0; i12--) {
				if (class39.aStringArray614 != null
				    && class39.aStringArray614[i12] != null) {
				    aStringArray631[anInt828]
					= (class39.aStringArray614[i12]
					   + " @lre@" + class39.aString599);
				    if (i12 == 0)
					anIntArray771[anInt828] = 917;
				    if (i12 == 1)
					anIntArray771[anInt828] = 14;
				    if (i12 == 2)
					anIntArray771[anInt828] = 401;
				    if (i12 == 3)
					anIntArray771[anInt828] = 514;
				    if (i12 == 4)
					anIntArray771[anInt828] = 164;
				    anIntArray772[anInt828]
					= class33_sub6.anInt999;
				    anIntArray769[anInt828] = i2;
				    anIntArray770[anInt828] = i3;
				    anInt828++;
				} else if (i12 == 2) {
				    aStringArray631[anInt828]
					= "Take @lre@" + class39.aString599;
				    anIntArray771[anInt828] = 401;
				    anIntArray772[anInt828]
					= class33_sub6.anInt999;
				    anIntArray769[anInt828] = i2;
				    anIntArray770[anInt828] = i3;
				    anInt828++;
				}
			    }
			    aStringArray631[anInt828]
				= "Examine @lre@" + class39.aString599;
			    anIntArray771[anInt828] = 1971;
			    anIntArray772[anInt828] = class33_sub6.anInt999;
			    anIntArray769[anInt828] = i2;
			    anIntArray770[anInt828] = i3;
			    anInt828++;
			}
		    }
		}
	    }
	}
	if (arg0 != 123)
	    startUp();
    }
    
    public final void method63(int arg0, int arg1, Class38 arg2, int arg3,
			       int arg4) {
	if (anInt828 < 400) {
	    String string = arg2.aString565;
	    anInt713 += arg1;
	    if (arg2.anInt583 != 0)
		string
		    += method65(arg2.anInt583,
				((Class33_Sub7_Sub2_Sub2)
				 aClass33_Sub7_Sub2_Sub2_792).anInt1279,
				(byte) 7) + " (level-" + arg2.anInt583 + ")";
	    if (anInt719 == 1) {
		aStringArray631[anInt828]
		    = ("Use " + ((client) this).aString723 + " with @yel@"
		       + string);
		anIntArray771[anInt828] = 806;
		anIntArray772[anInt828] = arg4;
		anIntArray769[anInt828] = arg0;
		anIntArray770[anInt828] = arg3;
		anInt828++;
	    } else if (anInt847 == 1) {
		if ((anInt849 & 0x2) == 2) {
		    aStringArray631[anInt828]
			= ((client) this).aString850 + " @yel@" + string;
		    anIntArray771[anInt828] = 130;
		    anIntArray772[anInt828] = arg4;
		    anIntArray769[anInt828] = arg0;
		    anIntArray770[anInt828] = arg3;
		    anInt828++;
		}
	    } else {
		if (arg2.aStringArray578 != null) {
		    for (int i = 4; i >= 0; i--) {
			if (arg2.aStringArray578[i] != null) {
			    aStringArray631[anInt828]
				= arg2.aStringArray578[i] + " @yel@" + string;
			    if (i == 0)
				anIntArray771[anInt828] = 710;
			    if (i == 1)
				anIntArray771[anInt828] = 301;
			    if (i == 2)
				anIntArray771[anInt828] = 328;
			    if (i == 3)
				anIntArray771[anInt828] = 498;
			    if (i == 4)
				anIntArray771[anInt828] = 74;
			    anIntArray772[anInt828] = arg4;
			    anIntArray769[anInt828] = arg0;
			    anIntArray770[anInt828] = arg3;
			    anInt828++;
			}
		    }
		}
		aStringArray631[anInt828] = "Examine @yel@" + string;
		anIntArray771[anInt828] = 1725;
		anIntArray772[anInt828] = arg4;
		anIntArray769[anInt828] = arg0;
		anIntArray770[anInt828] = arg3;
		anInt828++;
	    }
	}
    }
    
    public final void method64(int arg0, int arg1, Class33_Sub7_Sub2_Sub2 arg2,
			       int arg3, int arg4) {
	if (arg3 > 0 && arg2 != aClass33_Sub7_Sub2_Sub2_792
	    && anInt828 < 400) {
	    String string
		= (((Class33_Sub7_Sub2_Sub2) arg2).aString1273
		   + method65(((Class33_Sub7_Sub2_Sub2) arg2).anInt1279,
			      ((Class33_Sub7_Sub2_Sub2)
			       aClass33_Sub7_Sub2_Sub2_792).anInt1279,
			      (byte) 7)
		   + " (level-" + ((Class33_Sub7_Sub2_Sub2) arg2).anInt1279
		   + ")");
	    if (anInt719 == 1) {
		aStringArray631[anInt828]
		    = ("Use " + ((client) this).aString723 + " with @whi@"
		       + string);
		anIntArray771[anInt828] = 636;
		anIntArray772[anInt828] = arg4;
		anIntArray769[anInt828] = arg1;
		anIntArray770[anInt828] = arg0;
		anInt828++;
	    } else if (anInt847 == 1) {
		if ((anInt849 & 0x8) == 8) {
		    aStringArray631[anInt828]
			= ((client) this).aString850 + " @whi@" + string;
		    anIntArray771[anInt828] = 730;
		    anIntArray772[anInt828] = arg4;
		    anIntArray769[anInt828] = arg1;
		    anIntArray770[anInt828] = arg0;
		    anInt828++;
		}
	    } else {
		aStringArray631[anInt828] = "Trade with @whi@" + string;
		anIntArray771[anInt828] = 1682;
		anIntArray772[anInt828] = arg4;
		anIntArray769[anInt828] = arg1;
		anIntArray770[anInt828] = arg0;
		anInt828++;
		aStringArray631[anInt828] = "Follow @whi@" + string;
		anIntArray771[anInt828] = 1930;
		anIntArray772[anInt828] = arg4;
		anIntArray769[anInt828] = arg1;
		anIntArray770[anInt828] = arg0;
		anInt828++;
		if (anInt728 > 0) {
		    aStringArray631[anInt828] = "Attack @whi@" + string;
		    anIntArray771[anInt828] = 1754;
		    anIntArray772[anInt828] = arg4;
		    anIntArray769[anInt828] = arg1;
		    anIntArray770[anInt828] = arg0;
		    anInt828++;
		}
	    }
	}
    }
    
    public static final String method65(int arg0, int arg1, byte arg2) {
	if (arg2 != 7)
	    throw new NullPointerException();
	int i = arg1 - arg0;
	if (i < -9)
	    return "@red@";
	if (i < -6)
	    return "@or3@";
	if (i < -3)
	    return "@or2@";
	if (i < 0)
	    return "@or1@";
	if (i > 9)
	    return "@gre@";
	if (i > 6)
	    return "@gr3@";
	if (i > 3)
	    return "@gr2@";
	if (i > 0)
	    return "@gr1@";
	return "@yel@";
    }
    
    public final void method66(int arg0, Class6 arg1, int arg2, int arg3,
			       int arg4) {
	if (arg4 >= 0)
	    aBoolean717 = !aBoolean717;
	if (arg1.anInt112 == 0 && arg1.anIntArray124 != null
	    && (!arg1.aBoolean123 || anInt702 == arg1.anInt110
		|| anInt826 == arg1.anInt110 || anInt650 == arg1.anInt110)) {
	    int i = Class33_Sub2_Sub2.anInt1094;
	    int i1 = Class33_Sub2_Sub2.anInt1092;
	    int i2 = Class33_Sub2_Sub2.anInt1095;
	    int i3 = Class33_Sub2_Sub2.anInt1093;
	    Class33_Sub2_Sub2.method286(arg3 + arg1.anInt115, aByte773, arg3,
					arg2, arg2 + arg1.anInt116);
	    int i4 = arg1.anIntArray124.length;
	    for (int i5 = 0; i5 < i4; i5++) {
		int i6 = arg1.anIntArray125[i5] + arg3;
		int i7 = arg1.anIntArray126[i5] + arg2 - arg0;
		Class6 class6 = Class6.aClass6Array105[arg1.anIntArray124[i5]];
		if (class6.anInt114 > 0)
		    method76(class6, 6);
		if (class6.anInt112 == 0) {
		    if (class6.anInt122 > class6.anInt121 - class6.anInt116)
			class6.anInt122 = class6.anInt121 - class6.anInt116;
		    if (class6.anInt122 < 0)
			class6.anInt122 = 0;
		    method66(class6.anInt122, class6, i7, i6, -204);
		    if (class6.anInt121 > class6.anInt116)
			method68(i7, i6 + class6.anInt115, class6.anInt122,
				 class6.anInt116, class6.anInt121, 5);
		} else if (class6.anInt112 != 1) {
		    if (class6.anInt112 == 2) {
			int i8 = 0;
			for (int i9 = 0; i9 < class6.anInt116; i9++) {
			    for (int i10 = 0; i10 < class6.anInt115; i10++) {
				int i11 = i6 + i10 * (class6.anInt132 + 32);
				int i12 = i7 + i9 * (class6.anInt133 + 32);
				if (i8 < 20) {
				    i11 += class6.anIntArray135[i8];
				    i12 += class6.anIntArray136[i8];
				}
				if (class6.anIntArray106[i8] > 0) {
				    int i13 = class6.anIntArray106[i8] - 1;
				    Class33_Sub2_Sub2_Sub2 class33_sub2_sub2_sub2
					= Class39.method399(i13, -25063);
				    if (anInt908 != 0 && anInt907 == i8
					&& anInt906 == class6.anInt110)
					class33_sub2_sub2_sub2
					    .method314(4, i11, i12, 128);
				    else
					class33_sub2_sub2_sub2
					    .method312(i11, true, i12);
				    if (class33_sub2_sub2_sub2.anInt1241 == 33
					|| class6.anIntArray107[i8] != 1) {
					int i14 = class6.anIntArray107[i8];
					aClass33_Sub2_Sub2_Sub4_652.method328
					    (String.valueOf(i14), i11 + 1,
					     i12 + 10, 0, -200);
					aClass33_Sub2_Sub2_Sub4_652.method328
					    (String.valueOf(i14), i11, i12 + 9,
					     16776960, -200);
				    }
				} else if (((class6
					     .aClass33_Sub2_Sub2_Sub2Array134)
					    != null)
					   && i8 < 20) {
				    Class33_Sub2_Sub2_Sub2 class33_sub2_sub2_sub2
					= (class6
					   .aClass33_Sub2_Sub2_Sub2Array134
					   [i8]);
				    if (class33_sub2_sub2_sub2 != null)
					class33_sub2_sub2_sub2
					    .method312(i11, true, i12);
				}
				i8++;
			    }
			}
		    } else if (class6.anInt112 == 3) {
			if (class6.aBoolean138)
			    Class33_Sub2_Sub2.method288(class6.anInt144,
							class6.anInt115, i7,
							false, class6.anInt116,
							i6);
			else
			    Class33_Sub2_Sub2.method289(class6.anInt115,
							class6.anInt116, i6,
							i7, true,
							class6.anInt144);
		    } else if (class6.anInt112 == 4) {
			Class33_Sub2_Sub2_Sub4 class33_sub2_sub2_sub4
			    = class6.aClass33_Sub2_Sub2_Sub4_141;
			int i15 = class6.anInt144;
			String string = class6.aString142;
			if ((anInt650 == class6.anInt110
			     || anInt826 == class6.anInt110
			     || anInt702 == class6.anInt110)
			    && class6.anInt146 != 0)
			    i15 = class6.anInt146;
			if (method70(class6, -27654)) {
			    i15 = class6.anInt145;
			    if (class6.aString143.length() > 0)
				string = class6.aString143;
			}
			if (class6.anInt113 == 6 && aBoolean678) {
			    string = "Please wait...";
			    i15 = class6.anInt144;
			}
			int i16 = i7 + class33_sub2_sub2_sub4.anInt1265;
			while (string.length() > 0) {
			    if (string.indexOf("%") != -1) {
				for (;;) {
				    int i17 = string.indexOf("%1");
				    if (i17 == -1)
					break;
				    string
					= (string.substring(0, i17)
					   + method69((byte) 3,
						      method71(5, 0, class6))
					   + string.substring(i17 + 2));
				}
				for (;;) {
				    int i18 = string.indexOf("%2");
				    if (i18 == -1)
					break;
				    string
					= (string.substring(0, i18)
					   + method69((byte) 3,
						      method71(5, 1, class6))
					   + string.substring(i18 + 2));
				}
				for (;;) {
				    int i19 = string.indexOf("%3");
				    if (i19 == -1)
					break;
				    string
					= (string.substring(0, i19)
					   + method69((byte) 3,
						      method71(5, 2, class6))
					   + string.substring(i19 + 2));
				}
				for (;;) {
				    int i20 = string.indexOf("%4");
				    if (i20 == -1)
					break;
				    string
					= (string.substring(0, i20)
					   + method69((byte) 3,
						      method71(5, 3, class6))
					   + string.substring(i20 + 2));
				}
				for (;;) {
				    int i21 = string.indexOf("%5");
				    if (i21 == -1)
					break;
				    string
					= (string.substring(0, i21)
					   + method69((byte) 3,
						      method71(5, 4, class6))
					   + string.substring(i21 + 2));
				}
			    }
			    int i22 = string.indexOf("\\n");
			    String string23;
			    if (i22 != -1) {
				string23 = string.substring(0, i22);
				string = string.substring(i22 + 2);
			    } else {
				string23 = string;
				string = "";
			    }
			    if (class6.aBoolean139)
				class33_sub2_sub2_sub4.method326
				    (i6 + class6.anInt115 / 2, string23, i16,
				     anInt861, i15, class6.aBoolean140);
			    else
				class33_sub2_sub2_sub4.method330
				    (class6.aBoolean140, i6, i16, i15, true,
				     string23);
			    i16 += class33_sub2_sub2_sub4.anInt1265;
			}
		    } else if (class6.anInt112 == 5) {
			Class33_Sub2_Sub2_Sub2 class33_sub2_sub2_sub2;
			if (method70(class6, -27654))
			    class33_sub2_sub2_sub2
				= class6.aClass33_Sub2_Sub2_Sub2_148;
			else
			    class33_sub2_sub2_sub2
				= class6.aClass33_Sub2_Sub2_Sub2_147;
			if (class33_sub2_sub2_sub2 != null)
			    class33_sub2_sub2_sub2.method312(i6, true, i7);
		    } else if (class6.anInt112 == 6) {
			int i24 = Class33_Sub2_Sub2_Sub1.anInt1214;
			int i25 = Class33_Sub2_Sub2_Sub1.anInt1215;
			Class33_Sub2_Sub2_Sub1.anInt1214
			    = i6 + class6.anInt115 / 2;
			Class33_Sub2_Sub2_Sub1.anInt1215
			    = i7 + class6.anInt116 / 2;
			int i26 = ((Class33_Sub2_Sub2_Sub1.anIntArray1218
				    [class6.anInt154]) * class6.anInt153
				   >> 16);
			int i27 = ((Class33_Sub2_Sub2_Sub1.anIntArray1219
				    [class6.anInt154]) * class6.anInt153
				   >> 16);
			Class33_Sub2_Sub1 class33_sub2_sub1;
			if (class6.anInt151 == -1)
			    class33_sub2_sub1
				= class6.method131(-1, -1,
						   method70(class6, -27654));
			else {
			    Class10 class10
				= Class10.aClass10Array183[class6.anInt151];
			    class33_sub2_sub1
				= class6.method131((class10.anIntArray185
						    [class6.anInt108]),
						   (class10.anIntArray186
						    [class6.anInt108]),
						   method70(class6, -27654));
			}
			if (class33_sub2_sub1 != null)
			    class33_sub2_sub1.method278(i26, i27, 0, 0, 0, 0,
							class6.anInt154,
							class6.anInt155);
			Class33_Sub2_Sub2_Sub1.anInt1214 = i24;
			Class33_Sub2_Sub2_Sub1.anInt1215 = i25;
		    } else if (class6.anInt112 == 7) {
			Class33_Sub2_Sub2_Sub4 class33_sub2_sub2_sub4
			    = class6.aClass33_Sub2_Sub2_Sub4_141;
			int i28 = 0;
			for (int i29 = 0; i29 < class6.anInt116; i29++) {
			    for (int i30 = 0; i30 < class6.anInt115; i30++) {
				if (class6.anIntArray106[i28] > 0) {
				    Class39 class39
					= Class39.method395((class6
							     .anIntArray106
							     [i28]) - 1);
				    String string = class39.aString599;
				    if (class39.aBoolean611
					|| class6.anIntArray107[i28] != 1)
					string = (String.valueOf(class6
								 .anIntArray107
								 [i28])
						  + "x " + string);
				    int i31
					= i6 + i30 * (class6.anInt132 + 115);
				    int i32
					= i7 + i29 * (class6.anInt133 + 12);
				    if (class6.aBoolean139) {
					if (class6.aBoolean140)
					    class33_sub2_sub2_sub4.method325
						(i32 + 1, aBoolean876,
						 i31 + 1 + class6.anInt115 / 2,
						 0, string);
					class33_sub2_sub2_sub4.method325
					    (i32, aBoolean876,
					     i31 + class6.anInt115 / 2,
					     class6.anInt144, string);
				    } else {
					if (class6.aBoolean140)
					    class33_sub2_sub2_sub4.method328
						(string, i31 + 1, i32 + 1, 0,
						 -200);
					class33_sub2_sub2_sub4.method328
					    (string, i31, i32, class6.anInt144,
					     -200);
				    }
				}
				i28++;
			    }
			}
		    }
		}
	    }
	    Class33_Sub2_Sub2.method286(i2, aByte773, i, i1, i3);
	}
    }
    
    public final void method67(int arg0, int arg1, int arg2, int arg3,
			       int arg4, Class6 arg5, int arg6, boolean arg7,
			       int arg8) {
	if (arg6 != 0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	if (aBoolean842)
	    anInt774 = 32;
	else
	    anInt774 = 0;
	aBoolean842 = false;
	if (arg2 >= arg1 && arg2 < arg1 + 16 && arg4 >= arg0
	    && arg4 < arg0 + 16) {
	    arg5.anInt122 -= anInt904 * 4;
	    if (arg7)
		aBoolean646 = true;
	} else if (arg2 >= arg1 && arg2 < arg1 + 16 && arg4 >= arg0 + arg3 - 16
		   && arg4 < arg0 + arg3) {
	    arg5.anInt122 += anInt904 * 4;
	    if (arg7)
		aBoolean646 = true;
	} else if (arg2 >= arg1 - anInt774 && arg2 < arg1 + 16 + anInt774
		   && arg4 >= arg0 + 16 && arg4 < arg0 + arg3 - 16
		   && anInt904 > 0) {
	    int i = (arg3 - 32) * arg3 / arg8;
	    if (i < 8)
		i = 8;
	    int i1 = arg4 - arg0 - 16 - i / 2;
	    int i2 = arg3 - 32 - i;
	    arg5.anInt122 = (arg8 - arg3) * i1 / i2;
	    if (arg7)
		aBoolean646 = true;
	    aBoolean842 = true;
	}
    }
    
    public final void method68(int arg0, int arg1, int arg2, int arg3,
			       int arg4, int arg5) {
	aClass33_Sub2_Sub2_Sub3_639.method323(arg1, true, arg0);
	aClass33_Sub2_Sub2_Sub3_640.method323(arg1, true, arg0 + arg3 - 16);
	if (arg5 >= 5 && arg5 <= 5) {
	    Class33_Sub2_Sub2.method288(anInt710, 16, arg0 + 16, false,
					arg3 - 32, arg1);
	    int i = (arg3 - 32) * arg3 / arg4;
	    if (i < 8)
		i = 8;
	    int i1 = (arg3 - 32 - i) * arg2 / (arg4 - arg3);
	    Class33_Sub2_Sub2.method288(anInt909, 16, arg0 + 16 + i1, false, i,
					arg1);
	    Class33_Sub2_Sub2.method291(arg0 + 16 + i1, arg1, i, false,
					anInt895);
	    Class33_Sub2_Sub2.method291(arg0 + 16 + i1, arg1 + 1, i, false,
					anInt895);
	    Class33_Sub2_Sub2.method290(true, anInt895, arg0 + 16 + i1, 16,
					arg1);
	    Class33_Sub2_Sub2.method290(true, anInt895, arg0 + 17 + i1, 16,
					arg1);
	    Class33_Sub2_Sub2.method291(arg0 + 16 + i1, arg1 + 15, i, false,
					anInt791);
	    Class33_Sub2_Sub2.method291(arg0 + 17 + i1, arg1 + 14, i - 1,
					false, anInt791);
	    Class33_Sub2_Sub2.method290(true, anInt791, arg0 + 15 + i1 + i, 16,
					arg1);
	    Class33_Sub2_Sub2.method290(true, anInt791, arg0 + 14 + i1 + i, 15,
					arg1 + 1);
	}
    }
    
    public final String method69(byte arg0, int arg1) {
	if (arg0 == 3) {
	    boolean flag = false;
	} else
	    anInt684 = aClass32_674.method255();
	if (arg1 < 999999999)
	    return String.valueOf(arg1);
	return "*";
    }
    
    public final boolean method70(Class6 arg0, int arg1) {
	if (arg0.anIntArray118 == null)
	    return false;
	for (int i = 0; i < arg0.anIntArray118.length; i++) {
	    int i1 = method71(5, i, arg0);
	    int i2 = arg0.anIntArray119[i];
	    if (arg0.anIntArray118[i] == 2) {
		if (i1 >= i2)
		    return false;
	    } else if (arg0.anIntArray118[i] == 3) {
		if (i1 <= i2)
		    return false;
	    } else if (arg0.anIntArray118[i] == 4) {
		if (i1 == i2)
		    return false;
	    } else if (i1 != i2)
		return false;
	}
	if (arg1 != -27654)
	    aBoolean793 = !aBoolean793;
	return true;
    }
    
    public final int method71(int arg0, int arg1, Class6 arg2) {
	if (arg0 != 5)
	    aBoolean876 = !aBoolean876;
	if (arg2.anIntArrayArray117 == null
	    || arg1 >= arg2.anIntArrayArray117.length)
	    return -2;
	try {
	    int[] ints = arg2.anIntArrayArray117[arg1];
	    int i = 0;
	    int i1 = 0;
	    for (;;) {
		int i2 = ints[i1++];
		if (i2 == 0)
		    return i;
		if (i2 == 1)
		    i += anIntArray800[ints[i1++]];
		if (i2 == 2)
		    i += anIntArray785[ints[i1++]];
		if (i2 == 3)
		    i += anIntArray637[ints[i1++]];
		if (i2 == 4) {
		    Class6 class6 = Class6.aClass6Array105[ints[i1++]];
		    int i3 = ints[i1++] + 1;
		    for (int i4 = 0; i4 < class6.anIntArray106.length; i4++) {
			if (class6.anIntArray106[i4] == i3)
			    i += class6.anIntArray107[i4];
		    }
		}
		if (i2 == 5)
		    i += anIntArray937[ints[i1++]];
		if (i2 == 6)
		    i += anIntArray819[anIntArray785[ints[i1++]] - 1];
		if (i2 == 7)
		    i += anIntArray937[ints[i1++]] * 100 / 46875;
		if (i2 == 8)
		    i += ((Class33_Sub7_Sub2_Sub2)
			  aClass33_Sub7_Sub2_Sub2_792).anInt1279;
		if (i2 == 9) {
		    for (int i5 = 0; i5 < 19; i5++)
			i += anIntArray785[i5];
		}
		if (i2 == 10) {
		    Class6 class6 = Class6.aClass6Array105[ints[i1++]];
		    int i6 = ints[i1++] + 1;
		    for (int i7 = 0; i7 < class6.anIntArray106.length; i7++) {
			if (class6.anIntArray106[i7] == i6) {
			    i += 999999999;
			    break;
			}
		    }
		}
	    }
	} catch (Exception exception) {
	    return -1;
	}
    }
    
    public final void method72(Class6 arg0, boolean arg1, int arg2, int arg3,
			       int arg4, int arg5, int arg6) {
	if (arg0.anInt112 == 0 && arg0.anIntArray124 != null
	    && !arg0.aBoolean123
	    && (arg3 >= arg2 && arg5 >= arg6 && arg3 <= arg2 + arg0.anInt115
		&& arg5 <= arg6 + arg0.anInt116)) {
	    int i = arg0.anIntArray124.length;
	    for (int i1 = 0; i1 < i; i1++) {
		int i2 = arg0.anIntArray125[i1] + arg2;
		int i3 = arg0.anIntArray126[i1] + arg6 - arg4;
		Class6 class6 = Class6.aClass6Array105[arg0.anIntArray124[i1]];
		if ((class6.anInt120 >= 0 || class6.anInt146 != 0)
		    && arg3 >= i2 && arg5 >= i3 && arg3 < i2 + class6.anInt115
		    && arg5 < i3 + class6.anInt116) {
		    if (class6.anInt120 >= 0)
			anInt823 = class6.anInt120;
		    else
			anInt823 = class6.anInt110;
		}
		if (class6.anInt112 == 0) {
		    method72(class6, true, i2, arg3, class6.anInt122, arg5,
			     i3);
		    if (class6.anInt121 > class6.anInt116)
			method67(i3, i2 + class6.anInt115, arg3,
				 class6.anInt116, arg5, class6, 0, true,
				 class6.anInt121);
		} else {
		    if (class6.anInt113 == 1 && arg3 >= i2 && arg5 >= i3
			&& arg3 < i2 + class6.anInt115
			&& arg5 < i3 + class6.anInt116) {
			aStringArray631[anInt828] = class6.aString159;
			anIntArray771[anInt828] = 759;
			anIntArray770[anInt828] = class6.anInt110;
			anInt828++;
		    }
		    if (class6.anInt113 == 2 && anInt847 == 0 && arg3 >= i2
			&& arg5 >= i3 && arg3 < i2 + class6.anInt115
			&& arg5 < i3 + class6.anInt116) {
			String string = class6.aString156;
			if (string.indexOf(" ") != -1)
			    string = string.substring(0, string.indexOf(" "));
			aStringArray631[anInt828]
			    = string + " @gre@" + class6.aString157;
			anIntArray771[anInt828] = 17;
			anIntArray770[anInt828] = class6.anInt110;
			anInt828++;
		    }
		    if (class6.anInt113 == 3 && arg3 >= i2 && arg5 >= i3
			&& arg3 < i2 + class6.anInt115
			&& arg5 < i3 + class6.anInt116) {
			aStringArray631[anInt828] = "Close";
			anIntArray771[anInt828] = 454;
			anIntArray770[anInt828] = class6.anInt110;
			anInt828++;
		    }
		    if (class6.anInt113 == 4 && arg3 >= i2 && arg5 >= i3
			&& arg3 < i2 + class6.anInt115
			&& arg5 < i3 + class6.anInt116) {
			aStringArray631[anInt828] = class6.aString159;
			anIntArray771[anInt828] = 739;
			anIntArray770[anInt828] = class6.anInt110;
			anInt828++;
		    }
		    if (class6.anInt113 == 5 && arg3 >= i2 && arg5 >= i3
			&& arg3 < i2 + class6.anInt115
			&& arg5 < i3 + class6.anInt116) {
			aStringArray631[anInt828] = class6.aString159;
			anIntArray771[anInt828] = 700;
			anIntArray770[anInt828] = class6.anInt110;
			anInt828++;
		    }
		    if (class6.anInt113 == 6 && aBoolean678 == false
			&& arg3 >= i2 && arg5 >= i3
			&& arg3 < i2 + class6.anInt115
			&& arg5 < i3 + class6.anInt116) {
			aStringArray631[anInt828] = class6.aString159;
			anIntArray771[anInt828] = 883;
			anIntArray770[anInt828] = class6.anInt110;
			anInt828++;
		    }
		    if (class6.anInt112 == 2) {
			int i4 = 0;
			for (int i5 = 0; i5 < class6.anInt116; i5++) {
			    for (int i6 = 0; i6 < class6.anInt115; i6++) {
				if (class6.anIntArray106[i4] > 0) {
				    int i7 = i2 + i6 * (class6.anInt132 + 32);
				    int i8 = i3 + i5 * (class6.anInt133 + 32);
				    if (i4 < 20) {
					i7 += class6.anIntArray135[i4];
					i8 += class6.anIntArray136[i4];
				    }
				    if (arg3 >= i7 && arg5 >= i8
					&& arg3 < i7 + 32 && arg5 < i8 + 32) {
					Class39 class39
					    = Class39.method395((class6
								 .anIntArray106
								 [i4]) - 1);
					if (anInt719 == 1
					    && class6.aBoolean130) {
					    if (class6.anInt110 != anInt721
						|| i4 != anInt720) {
						aStringArray631[anInt828]
						    = ("Use "
						       + (((client) this)
							  .aString723)
						       + " with @lre@"
						       + class39.aString599);
						anIntArray771[anInt828] = 39;
						anIntArray772[anInt828]
						    = class39.anInt597;
						anIntArray769[anInt828] = i4;
						anIntArray770[anInt828]
						    = class6.anInt110;
						anInt828++;
					    }
					} else if (anInt847 == 1
						   && class6.aBoolean130) {
					    if ((anInt849 & 0x10) == 16) {
						aStringArray631[anInt828]
						    = ((((client) this)
							.aString850)
						       + " @lre@"
						       + class39.aString599);
						anIntArray771[anInt828] = 449;
						anIntArray772[anInt828]
						    = class39.anInt597;
						anIntArray769[anInt828] = i4;
						anIntArray770[anInt828]
						    = class6.anInt110;
						anInt828++;
					    }
					} else {
					    if (class6.aBoolean130) {
						for (int i9 = 4; i9 >= 3;
						     i9--) {
						    if (((class39
							  .aStringArray615)
							 != null)
							&& (class39
							    .aStringArray615
							    [i9]) != null) {
							aStringArray631
							    [anInt828]
							    = ((class39
								.aStringArray615
								[i9])
							       + " @lre@"
							       + (class39
								  .aString599));
							if (i9 == 3)
							    anIntArray771
								[anInt828]
								= 247;
							if (i9 == 4)
							    anIntArray771
								[anInt828]
								= 296;
							anIntArray772[anInt828]
							    = class39.anInt597;
							anIntArray769[anInt828]
							    = i4;
							anIntArray770[anInt828]
							    = class6.anInt110;
							anInt828++;
						    } else if (i9 == 4) {
							aStringArray631
							    [anInt828]
							    = ("Drop @lre@"
							       + (class39
								  .aString599));
							anIntArray771[anInt828]
							    = 296;
							anIntArray772[anInt828]
							    = class39.anInt597;
							anIntArray769[anInt828]
							    = i4;
							anIntArray770[anInt828]
							    = class6.anInt110;
							anInt828++;
						    }
						}
					    }
					    if (class6.aBoolean131) {
						aStringArray631[anInt828]
						    = ("Use @lre@"
						       + class39.aString599);
						anIntArray771[anInt828] = 669;
						anIntArray772[anInt828]
						    = class39.anInt597;
						anIntArray769[anInt828] = i4;
						anIntArray770[anInt828]
						    = class6.anInt110;
						anInt828++;
					    }
					    if (class6.aBoolean130
						&& (class39.aStringArray615
						    != null)) {
						for (int i10 = 2; i10 >= 0;
						     i10--) {
						    if ((class39
							 .aStringArray615[i10])
							!= null) {
							aStringArray631
							    [anInt828]
							    = ((class39
								.aStringArray615
								[i10])
							       + " @lre@"
							       + (class39
								  .aString599));
							if (i10 == 0)
							    anIntArray771
								[anInt828]
								= 677;
							if (i10 == 1)
							    anIntArray771
								[anInt828]
								= 522;
							if (i10 == 2)
							    anIntArray771
								[anInt828]
								= 249;
							anIntArray772[anInt828]
							    = class39.anInt597;
							anIntArray769[anInt828]
							    = i4;
							anIntArray770[anInt828]
							    = class6.anInt110;
							anInt828++;
						    }
						}
					    }
					    if (class6.aStringArray137
						!= null) {
						for (int i11 = 4; i11 >= 0;
						     i11--) {
						    if ((class6.aStringArray137
							 [i11])
							!= null) {
							aStringArray631
							    [anInt828]
							    = ((class6
								.aStringArray137
								[i11])
							       + " @lre@"
							       + (class39
								  .aString599));
							if (i11 == 0)
							    anIntArray771
								[anInt828]
								= 678;
							if (i11 == 1)
							    anIntArray771
								[anInt828]
								= 523;
							if (i11 == 2)
							    anIntArray771
								[anInt828]
								= 836;
							if (i11 == 3)
							    anIntArray771
								[anInt828]
								= 548;
							if (i11 == 4)
							    anIntArray771
								[anInt828]
								= 62;
							anIntArray772[anInt828]
							    = class39.anInt597;
							anIntArray769[anInt828]
							    = i4;
							anIntArray770[anInt828]
							    = class6.anInt110;
							anInt828++;
						    }
						}
					    }
					    aStringArray631[anInt828]
						= ("Examine @lre@"
						   + class39.aString599);
					    anIntArray771[anInt828] = 1258;
					    anIntArray772[anInt828]
						= class39.anInt597;
					    anInt828++;
					}
				    }
				}
				i4++;
			    }
			}
		    }
		}
	    }
	    aBoolean825 &= arg1;
	}
    }
    
    public final void method73(int arg0, int arg1) {
	Class6 class6 = Class6.aClass6Array105[arg1];
	for (int i = 0; i < class6.anIntArray124.length; i++) {
	    if (class6.anIntArray124[i] == -1)
		break;
	    Class6 class6_1 = Class6.aClass6Array105[class6.anIntArray124[i]];
	    if (class6_1.anInt112 == 1)
		method73(1, class6_1.anInt110);
	    class6_1.anInt108 = 0;
	    class6_1.anInt109 = 0;
	}
	if (arg0 < 1 || arg0 > 1)
	    anInt861 = -6;
    }
    
    public final boolean method74(byte arg0, int arg1, int arg2) {
	boolean flag = false;
	Class6 class6 = Class6.aClass6Array105[arg2];
	for (int i = 0; i < class6.anIntArray124.length; i++) {
	    if (class6.anIntArray124[i] == -1)
		break;
	    Class6 class6_1 = Class6.aClass6Array105[class6.anIntArray124[i]];
	    if (class6_1.anInt112 == 1)
		flag |= method74((byte) -91, arg1, class6_1.anInt110);
	    if (class6_1.anInt151 != -1) {
		Class10 class10 = Class10.aClass10Array183[class6_1.anInt151];
		class6_1.anInt109 += arg1;
		while (class6_1.anInt109
		       > class10.anIntArray187[class6_1.anInt108]) {
		    class6_1.anInt109
			-= class10.anIntArray187[class6_1.anInt108] + 1;
		    class6_1.anInt108++;
		    if (class6_1.anInt108 >= class10.anInt184) {
			class6_1.anInt108 -= class10.anInt188;
			if (class6_1.anInt108 < 0
			    || class6_1.anInt108 >= class10.anInt184)
			    class6_1.anInt108 = 0;
		    }
		    flag = true;
		}
	    }
	}
	if (arg0 != -91)
	    aClass22ArrayArrayArray805 = null;
	return flag;
    }
    
    public final void method75(int arg0, int arg1) {
	int i = Class14.aClass14Array243[arg1].anInt251;
	if (arg0 != 6)
	    anInt946 = aClass32_674.method255();
	if (i != 0) {
	    int i1 = anIntArray937[arg1];
	    if (i == 1) {
		if (i1 == 1)
		    Class33_Sub2_Sub2_Sub1.method301(-217, 0.9);
		if (i1 == 2)
		    Class33_Sub2_Sub2_Sub1.method301(-217, 0.8);
		if (i1 == 3)
		    Class33_Sub2_Sub2_Sub1.method301(-217, 0.7);
		if (i1 == 4)
		    Class33_Sub2_Sub2_Sub1.method301(-217, 0.6);
		Class39.aClass29_627.method252();
		aBoolean844 = true;
	    }
	    if (i == 3) {
		if (i1 == 1 && aBoolean759) {
		    aBoolean759 = false;
		    signlink.midi = "null";
		}
		if (i1 == 0 && !aBoolean759) {
		    aBoolean759 = true;
		    signlink.midi = aString863;
		}
	    }
	    if (i == 5)
		anInt824 = i1;
	    if (i == 6)
		anInt718 = i1;
	}
    }
    
    public final void method76(Class6 arg0, int arg1) {
	int i = arg0.anInt114;
	if (arg1 != 6)
	    anInt714 = -1;
	if (i >= 1 && i <= 100) {
	    if (--i >= anInt841) {
		arg0.aString142 = "";
		arg0.anInt113 = 0;
	    } else {
		arg0.aString142 = aStringArray852[i];
		arg0.anInt113 = 1;
		if (arg0.aString159 == null)
		    arg0.anInt113 = 0;
	    }
	} else if (i >= 101 && i <= 200) {
	    i -= 101;
	    if (i >= anInt841) {
		arg0.aString142 = "";
		arg0.anInt113 = 0;
	    } else {
		if (anIntArray938[i] == 0)
		    arg0.aString142 = "@red@Offline";
		else if (anIntArray938[i] == anInt851)
		    arg0.aString142 = "@gre@World-" + (anIntArray938[i] - 9);
		else
		    arg0.aString142 = "@yel@World-" + (anIntArray938[i] - 9);
		arg0.anInt113 = 1;
		if (arg0.aString159 == null)
		    arg0.anInt113 = 0;
	    }
	} else if (i == 203) {
	    arg0.anInt121 = anInt841 * 15 + 20;
	    if (arg0.anInt121 <= arg0.anInt116)
		arg0.anInt121 = arg0.anInt116 + 1;
	} else if (i >= 401 && i <= 500) {
	    i -= 401;
	    if (i >= anInt821) {
		arg0.aString142 = "";
		arg0.anInt113 = 0;
	    } else
		arg0.aString142
		    = Class35.method376(Class35.method373((byte) -89,
							  aLongArray831[i]),
					-591);
	} else if (i == 503) {
	    arg0.anInt121 = anInt821 * 15 + 20;
	    if (arg0.anInt121 <= arg0.anInt116)
		arg0.anInt121 = arg0.anInt116 + 1;
	} else if (i == 327) {
	    arg0.anInt154 = 150;
	    arg0.anInt155
		= (int) (Math.sin((double) anInt647 / 40.0) * 256.0) & 0x7ff;
	    if (aBoolean676) {
		aBoolean676 = false;
		Class33_Sub2_Sub1[] class33_sub2_sub1s
		    = new Class33_Sub2_Sub1[7];
		int i1 = 0;
		for (int i2 = 0; i2 < 7; i2++) {
		    int i3 = anIntArray745[i2];
		    if (i3 >= 0)
			class33_sub2_sub1s[i1++]
			    = Class4.aClass4Array84[i3].method123();
		}
		Class33_Sub2_Sub1 class33_sub2_sub1
		    = new Class33_Sub2_Sub1(i1, false, class33_sub2_sub1s);
		for (int i4 = 0; i4 < 5; i4++) {
		    if (anIntArray822[i4] != 0) {
			class33_sub2_sub1.method272(anIntArrayArray854[i4][0],
						    (anIntArrayArray854[i4]
						     [anIntArray822[i4]]));
			if (i4 == 1)
			    class33_sub2_sub1.method272(anIntArray641[0],
							(anIntArray641
							 [anIntArray822[i4]]));
		    }
		}
		class33_sub2_sub1.method265(0);
		class33_sub2_sub1.method266(false,
					    (Class10.aClass10Array183
					     [(((Class33_Sub7_Sub2)
						aClass33_Sub7_Sub2_Sub2_792)
					       .anInt1140)]
					     .anIntArray185[0]));
		class33_sub2_sub1.method275(64, 850, -30, -50, -30, true);
		arg0.aClass33_Sub2_Sub1_149 = class33_sub2_sub1;
	    }
	} else if (i == 324) {
	    if (aClass33_Sub2_Sub2_Sub2_855 == null) {
		aClass33_Sub2_Sub2_Sub2_855 = arg0.aClass33_Sub2_Sub2_Sub2_147;
		aClass33_Sub2_Sub2_Sub2_856 = arg0.aClass33_Sub2_Sub2_Sub2_148;
	    }
	    if (aBoolean725)
		arg0.aClass33_Sub2_Sub2_Sub2_147 = aClass33_Sub2_Sub2_Sub2_856;
	    else
		arg0.aClass33_Sub2_Sub2_Sub2_147 = aClass33_Sub2_Sub2_Sub2_855;
	} else if (i == 325) {
	    if (aClass33_Sub2_Sub2_Sub2_855 == null) {
		aClass33_Sub2_Sub2_Sub2_855 = arg0.aClass33_Sub2_Sub2_Sub2_147;
		aClass33_Sub2_Sub2_Sub2_856 = arg0.aClass33_Sub2_Sub2_Sub2_148;
	    }
	    if (aBoolean725)
		arg0.aClass33_Sub2_Sub2_Sub2_147 = aClass33_Sub2_Sub2_Sub2_855;
	    else
		arg0.aClass33_Sub2_Sub2_Sub2_147 = aClass33_Sub2_Sub2_Sub2_856;
	}
    }
    
    public final boolean method77(Class6 arg0, int arg1) {
	int i = arg0.anInt114;
	if (arg1 != 2)
	    aClass22ArrayArrayArray805 = null;
	if (i == 201) {
	    aBoolean760 = true;
	    aBoolean707 = false;
	    aBoolean633 = true;
	    aString915 = "";
	    anInt711 = 1;
	    aString900 = "Enter name of friend to add to list";
	}
	if (i == 202) {
	    aBoolean760 = true;
	    aBoolean707 = false;
	    aBoolean633 = true;
	    aString915 = "";
	    anInt711 = 2;
	    aString900 = "Enter name of friend to delete from list";
	}
	if (i >= 1 && i <= 200) {
	    if (i >= 101)
		i -= 101;
	    else
		i--;
	    if (anIntArray938[i] > 0) {
		aBoolean760 = true;
		aBoolean707 = false;
		aBoolean633 = true;
		aString915 = "";
		anInt711 = 3;
		anInt731 = i;
		aString900 = "Enter message to send to " + aStringArray852[i];
	    }
	}
	if (i == 501) {
	    aBoolean760 = true;
	    aBoolean707 = false;
	    aBoolean633 = true;
	    aString915 = "";
	    anInt711 = 4;
	    aString900 = "Enter name of player to add to list";
	}
	if (i == 502) {
	    aBoolean760 = true;
	    aBoolean707 = false;
	    aBoolean633 = true;
	    aString915 = "";
	    anInt711 = 5;
	    aString900 = "Enter name of player to delete from list";
	}
	if (i >= 300 && i <= 313) {
	    int i1 = (i - 300) / 2;
	    int i2 = i & 0x1;
	    int i3 = anIntArray745[i1];
	    if (i3 != -1) {
		do {
		    if (i2 == 0 && --i3 < 0)
			i3 = Class4.anInt83 - 1;
		    if (i2 == 1 && ++i3 >= Class4.anInt83)
			i3 = 0;
		} while (Class4.aClass4Array84[i3].anInt85
			 != i1 + (aBoolean725 ? 0 : 7));
		anIntArray745[i1] = i3;
		aBoolean676 = true;
	    }
	}
	if (i >= 314 && i <= 323) {
	    int i4 = (i - 314) / 2;
	    int i5 = i & 0x1;
	    int i6 = anIntArray822[i4];
	    if (i5 == 0 && --i6 < 0)
		i6 = anIntArrayArray854[i4].length - 1;
	    if (i5 == 1 && ++i6 >= anIntArrayArray854[i4].length)
		i6 = 0;
	    anIntArray822[i4] = i6;
	    aBoolean676 = true;
	}
	if (i == 324 && !aBoolean725) {
	    aBoolean725 = true;
	    method78((byte) 86);
	}
	if (i == 325 && aBoolean725) {
	    aBoolean725 = false;
	    method78((byte) 86);
	}
	if (i == 326) {
	    aClass33_Sub2_Sub3_696.method334(false, 128);
	    aClass33_Sub2_Sub3_696.method335(aBoolean725 ? 0 : 1);
	    for (int i7 = 0; i7 < 7; i7++)
		aClass33_Sub2_Sub3_696.method335(anIntArray745[i7]);
	    for (int i8 = 0; i8 < 5; i8++)
		aClass33_Sub2_Sub3_696.method335(anIntArray822[i8]);
	    return true;
	}
	return false;
    }
    
    public final void method78(byte arg0) {
	aBoolean676 = true;
	for (int i = 0; i < 7; i++) {
	    anIntArray745[i] = -1;
	    for (int i1 = 0; i1 < Class4.anInt83; i1++) {
		if (Class4.aClass4Array84[i1].anInt85
		    == i + (aBoolean725 ? 0 : 7)) {
		    anIntArray745[i] = i1;
		    break;
		}
	    }
	}
	if (arg0 != 86)
	    aBoolean794 = !aBoolean794;
    }
    
    public final void method79(int arg0) {
	arg0 = 51 / arg0;
	aClass26_788.method190(0);
	int i
	    = (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792).anInt1131 / 32
	       + 48);
	int i1 = 464 - (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			.anInt1132) / 32;
	aClass33_Sub2_Sub2_Sub2_932.method316(21, i, i1, anInt749, 151, -22915,
					      anIntArray636, 146,
					      anIntArray857, 9);
	aClass33_Sub2_Sub2_Sub2_867.method316(0, 25, 25, anInt749, 33, -22915,
					      anIntArray783, 33, anIntArray775,
					      0);
	for (int i2 = 0; i2 < anInt662; i2++) {
	    i = (anIntArray663[i2] * 4 + 2
		 - (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792).anInt1131
		    / 32));
	    i1 = (anIntArray664[i2] * 4 + 2
		  - (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
		     .anInt1132) / 32);
	    method80(i, i1, 945, aClass33_Sub2_Sub2_Sub2Array798[i2]);
	}
	for (int i3 = 0; i3 < 104; i3++) {
	    for (int i4 = 0; i4 < 104; i4++) {
		Class22 class22 = aClass22ArrayArrayArray805[anInt858][i3][i4];
		if (class22 != null) {
		    i = (i3 * 4 + 2
			 - (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			    .anInt1131) / 32);
		    i1 = (i4 * 4 + 2
			  - (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			     .anInt1132) / 32);
		    method80(i, i1, 945, aClass33_Sub2_Sub2_Sub2_809);
		}
	    }
	}
	for (int i5 = 0; i5 < anInt935; i5++) {
	    Class33_Sub7_Sub2_Sub1 class33_sub7_sub2_sub1
		= (aClass33_Sub7_Sub2_Sub1Array934
		   [((client) this).anIntArray936[i5]]);
	    if (class33_sub7_sub2_sub1 != null
		&& class33_sub7_sub2_sub1.method363(-29424)
		&& (((Class33_Sub7_Sub2_Sub1) class33_sub7_sub2_sub1)
		    .aClass38_1268.aBoolean582)) {
		i = ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1131
		      / 32)
		     - (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			.anInt1131) / 32);
		i1 = ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub1).anInt1132
		       / 32)
		      - (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			 .anInt1132) / 32);
		method80(i, i1, 945, aClass33_Sub2_Sub2_Sub2_810);
	    }
	}
	for (int i6 = 0; i6 < anInt737; i6++) {
	    Class33_Sub7_Sub2_Sub2 class33_sub7_sub2_sub2
		= (aClass33_Sub7_Sub2_Sub2Array736
		   [((client) this).anIntArray738[i6]]);
	    if (class33_sub7_sub2_sub2 != null
		&& class33_sub7_sub2_sub2.method367(-29424)) {
		i = ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1131
		      / 32)
		     - (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			.anInt1131) / 32);
		i1 = ((((Class33_Sub7_Sub2) class33_sub7_sub2_sub2).anInt1132
		       / 32)
		      - (((Class33_Sub7_Sub2) aClass33_Sub7_Sub2_Sub2_792)
			 .anInt1132) / 32);
		method80(i, i1, 945, aClass33_Sub2_Sub2_Sub2_811);
	    }
	}
	Class33_Sub2_Sub2.method288(16777215, 3, 82, false, 3, 93);
	aClass26_789.method190(0);
    }
    
    public final void method80(int arg0, int arg1, int arg2,
			       Class33_Sub2_Sub2_Sub2 arg3) {
	int i = arg0 * arg0 + arg1 * arg1;
	arg2 = 4 / arg2;
	if (i <= 6400) {
	    int i1 = Class33_Sub2_Sub1.anIntArray1082[anInt749];
	    int i2 = Class33_Sub2_Sub1.anIntArray1083[anInt749];
	    int i3 = arg1 * i1 + arg0 * i2 >> 16;
	    int i4 = arg1 * i2 - arg0 * i1 >> 16;
	    if (i > 2500)
		arg3.method317(aClass33_Sub2_Sub2_Sub3_644,
			       i3 + 94 - arg3.anInt1237 / 2, 0,
			       83 - i4 - arg3.anInt1238 / 2);
	    else
		arg3.method312(i3 + 94 - arg3.anInt1237 / 2, true,
			       83 - i4 - arg3.anInt1238 / 2);
	}
    }
    
    public final void method81(int arg0, String arg1, String arg2, int arg3) {
	if (anInt917 == -1)
	    aBoolean760 = true;
	for (int i = 99; i > 0; i--) {
	    anIntArray829[i] = anIntArray829[i - 1];
	    aStringArray743[i] = aStringArray743[i - 1];
	    aStringArray931[i] = aStringArray931[i - 1];
	}
	anIntArray829[0] = arg0;
	aStringArray743[0] = arg1;
	aStringArray931[0] = arg2;
	if (arg3 != 36887)
	    aBoolean876 = !aBoolean876;
    }
    
    public final void method82(int arg0) {
	aClass26_790.method190(0);
	if (arg0 != 0)
	    aBoolean666 = !aBoolean666;
	Class33_Sub2_Sub2_Sub1.anIntArray1220 = anIntArray699;
	aClass33_Sub2_Sub2_Sub3_645.method323(0, true, 0);
	if (aBoolean633) {
	    aClass33_Sub2_Sub2_Sub4_654.method325(40, aBoolean876, 239, 0,
						  aString900);
	    aClass33_Sub2_Sub2_Sub4_654.method325(60, aBoolean876, 239, 128,
						  aString915 + "*");
	} else if (aBoolean707) {
	    aClass33_Sub2_Sub2_Sub4_654.method325(40, aBoolean876, 239, 0,
						  "Enter amount to transfer:");
	    aClass33_Sub2_Sub2_Sub4_654.method325(60, aBoolean876, 239, 128,
						  aString818 + "*");
	} else if (anInt917 != -1)
	    method66(0, Class6.aClass6Array105[anInt917], 0, 0, -204);
	else {
	    int i = 0;
	    Class33_Sub2_Sub2.method286(463, aByte773, 0, 0, 77);
	    for (int i1 = 0; i1 < 50; i1++) {
		if (aStringArray931[i1] != null) {
		    int i2 = anIntArray829[i1];
		    int i3 = 70 - i * 14 + anInt865;
		    if (i2 == 0) {
			if (i3 > 0 && i3 < 110)
			    aClass33_Sub2_Sub2_Sub4_655.method328
				(aStringArray931[i1], 4, i3, 0, -200);
			i++;
		    }
		    if (i2 == 1) {
			if (i3 > 0 && i3 < 110) {
			    aClass33_Sub2_Sub2_Sub4_655.method328
				(aStringArray743[i1] + ":", 4, i3, 16777215,
				 -200);
			    Class33_Sub2_Sub2_Sub4 class33_sub2_sub2_sub4
				= aClass33_Sub2_Sub2_Sub4_655;
			    String string = aStringArray931[i1];
			    int i4 = 12;
			    int i5 = aClass33_Sub2_Sub2_Sub4_655
					 .method327(331, aStringArray743[i1]);
			    class33_sub2_sub2_sub4.method328(string, i5 + i4,
							     i3, 255, -200);
			}
			i++;
		    }
		    if (i2 == 2
			&& (anInt802 == 0
			    || anInt802 == 1 && method83(aStringArray743[i1],
							 (byte) -21))) {
			if (i3 > 0 && i3 < 110) {
			    aClass33_Sub2_Sub2_Sub4_655.method328
				(aStringArray743[i1] + ":", 4, i3, 0, -200);
			    Class33_Sub2_Sub2_Sub4 class33_sub2_sub2_sub4
				= aClass33_Sub2_Sub2_Sub4_655;
			    String string = aStringArray931[i1];
			    int i6 = 12;
			    int i7 = aClass33_Sub2_Sub2_Sub4_655
					 .method327(331, aStringArray743[i1]);
			    class33_sub2_sub2_sub4.method328(string, i7 + i6,
							     i3, 255, -200);
			}
			i++;
		    }
		    if (i2 == 3
			&& (anInt765 == 0
			    || anInt765 == 1 && method83(aStringArray743[i1],
							 (byte) -21))) {
			if (i3 > 0 && i3 < 110) {
			    aClass33_Sub2_Sub2_Sub4_655.method328
				("From " + aStringArray743[i1] + ":", 4, i3, 0,
				 -200);
			    aClass33_Sub2_Sub2_Sub4_655.method328
				(aStringArray931[i1],
				 12 + (aClass33_Sub2_Sub2_Sub4_655.method327
				       (331, "From " + aStringArray743[i1])),
				 i3, 8388608, -200);
			}
			i++;
		    }
		    if (i2 == 4
			&& (anInt742 == 0
			    || anInt742 == 1 && method83(aStringArray743[i1],
							 (byte) -21))) {
			if (i3 > 0 && i3 < 110)
			    aClass33_Sub2_Sub2_Sub4_655.method328
				((aStringArray743[i1] + " "
				  + aStringArray931[i1]),
				 4, i3, 8388736, -200);
			i++;
		    }
		    if (i2 == 5 && anInt765 < 2) {
			if (i3 > 0 && i3 < 110)
			    aClass33_Sub2_Sub2_Sub4_655.method328
				(aStringArray931[i1], 4, i3, 8388608, -200);
			i++;
		    }
		    if (i2 == 6 && anInt765 < 2) {
			if (i3 > 0 && i3 < 110) {
			    aClass33_Sub2_Sub2_Sub4_655.method328
				("To " + aStringArray743[i1] + ":", 4, i3, 0,
				 -200);
			    aClass33_Sub2_Sub2_Sub4_655.method328
				(aStringArray931[i1],
				 12 + (aClass33_Sub2_Sub2_Sub4_655.method327
				       (331, "To " + aStringArray743[i1])),
				 i3, 8388608, -200);
			}
			i++;
		    }
		}
	    }
	    Class33_Sub2_Sub2.method285((byte) 9);
	    anInt914 = i * 14 + 7;
	    if (anInt914 < 78)
		anInt914 = 78;
	    method68(0, 463, anInt914 - anInt865 - 77, 77, anInt914, 5);
	    aClass33_Sub2_Sub2_Sub4_655.method328(aString817 + "*", 3, 90, 0,
						  -200);
	    Class33_Sub2_Sub2.method290(true, 0, 77, 479, 0);
	}
	aClass26_790.method191(aGraphics13, 22, 375);
	aClass26_789.method190(0);
	Class33_Sub2_Sub2_Sub1.anIntArray1220 = anIntArray701;
    }
    
    public final boolean method83(String arg0, byte arg1) {
	if (arg0 == null)
	    return false;
	for (int i = 0; i < anInt841; i++) {
	    if (arg0.equalsIgnoreCase(aStringArray852[i]))
		return true;
	}
	if (arg1 != aByte859)
	    throw new NullPointerException();
	if (arg0.equalsIgnoreCase(((Class33_Sub7_Sub2_Sub2)
				   aClass33_Sub7_Sub2_Sub2_792).aString1273))
	    return true;
	return false;
    }
    
    public final void method84(int arg0) {
	aClass26_787.method190(0);
	Class33_Sub2_Sub2_Sub1.anIntArray1220 = anIntArray700;
	aClass33_Sub2_Sub2_Sub3_643.method323(0, true, 0);
	if (anInt704 != -1)
	    method66(0, Class6.aClass6Array105[anInt704], 0, 0, -204);
	else if (anIntArray853[anInt712] != -1)
	    method66(0, Class6.aClass6Array105[anIntArray853[anInt712]], 0, 0,
		     -204);
	if (aBoolean881 && anInt812 == 1)
	    method58(false);
	aClass26_787.method191(aGraphics13, 562, 231);
	aClass26_789.method190(0);
	Class33_Sub2_Sub2_Sub1.anIntArray1220 = anIntArray701;
	if (arg0 <= 0)
	    anInt797 = -361;
    }
    
    public final int method85(int arg0) {
	arg0 = 45 / arg0;
	return 0;
    }
    
    public final Component getGameComponent(byte arg0) {
	if (arg0 != 8)
	    anInt714 = -1;
	if (signlink.mainapp != null)
	    return signlink.mainapp;
	if (gameFrame != null)
	    return gameFrame;
	return this;
    }
    
    public final URL getCodeBase() {
	if (signlink.mainapp != null)
	    return signlink.mainapp.getCodeBase();
	try {
	    if (gameFrame != null)
		return new URL("http://" + aString880 + ":" + (anInt840 + 80));
	} catch (Exception exception) {
	}
	return super.getCodeBase();
    }
    
    public final String method86(int arg0) {
	anInt713 += arg0;
	if (signlink.mainapp != null)
	    return signlink.mainapp.getDocumentBase().getHost().toLowerCase();
	if (gameFrame != null)
	    return "runescape.com";
	return super.getDocumentBase().getHost().toLowerCase();
    }
    
    public final String getParameter(String arg0) {
	if (signlink.mainapp != null)
	    return signlink.mainapp.getParameter(arg0);
	return super.getParameter(arg0);
    }
    
    public final void method12(Runnable arg0, int arg1) {
	if (signlink.mainapp != null)
	    signlink.startthread(arg0, arg1);
	else
	    super.method12(arg0, arg1);
    }
    
    public final DataInputStream method87(String arg0) throws IOException {
	if (signlink.mainapp != null)
	    return signlink.openurl(arg0);
	return new DataInputStream(new URL(getCodeBase(), arg0).openStream());
    }
    
    public final Socket method88(int arg0) throws IOException {
	if (signlink.mainapp != null)
	    return signlink.opensocket(arg0);
	return new Socket(InetAddress.getByName(getCodeBase().getHost()),
			  arg0);
    }
    
    public final String method89() {
	if (signlink.midi == null)
	    return "none";
	String string = signlink.midi + ".mid.gz";
	signlink.midi = null;
	return string;
    }
    
    public final String method90() {
	if (signlink.jingle == null)
	    return "none";
	String string = signlink.jingle + ".mid.gz";
	signlink.jingle = null;
	return string;
    }
    
    public final int method91() {
	return signlink.jinglelen;
    }
    
    static {
	int i = 0;
	for (int i1 = 0; i1 < 99; i1++) {
	    int i2 = i1 + 1;
	    int i3 = (int) ((double) i2
			    + 300.0 * Math.pow(2.0, (double) i2 / 7.0));
	    i += i3;
	    anIntArray819[i1] = i / 4;
	}
	anIntArrayArray854
	    = (new int[][]
	       { { 6798, 107, 10283, 16, 4797, 7744, 5799 },
		 { 8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094,
		   10153, 56621, 4783, 1341, 16578, 35003, 25239 },
		 { 25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430,
		   24094, 10153, 56621, 4783, 1341, 16578, 35003 },
		 { 4626, 11146, 6439, 12, 4758, 10270 },
		 { 4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574 } });
    }
}
