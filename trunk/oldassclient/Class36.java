
public final class Class36
{
    private static boolean aBoolean514 = true;
    private static boolean aBoolean515;
    public static char[] aCharArray516 = new char[100];
    private static char[] aCharArray517
	= { ' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u',
	    'm', 'w', 'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q',
	    'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '!',
	    '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@',
	    '#', '+', '=', '\u00a3', '$', '%', '\"', '[', ']' };
    
    public static String method379(boolean arg0, Class33_Sub2_Sub3 arg1,
				   int arg2) {
	int i = 0;
	int i1 = -1;
	if (arg0)
	    aBoolean514 = !aBoolean514;
	for (int i2 = 0; i2 < arg2; i2++) {
	    int i3 = arg1.method342();
	    int i4 = i3 >> 4 & 0xf;
	    if (i1 == -1) {
		if (i4 < 13)
		    aCharArray516[i++] = aCharArray517[i4];
		else
		    i1 = i4;
	    } else {
		aCharArray516[i++] = aCharArray517[(i1 << 4) + i4 - 195];
		i1 = -1;
	    }
	    i4 = i3 & 0xf;
	    if (i1 == -1) {
		if (i4 < 13)
		    aCharArray516[i++] = aCharArray517[i4];
		else
		    i1 = i4;
	    } else {
		aCharArray516[i++] = aCharArray517[(i1 << 4) + i4 - 195];
		i1 = -1;
	    }
	}
	boolean flag = true;
	for (int i5 = 0; i5 < i; i5++) {
	    char c = aCharArray516[i5];
	    if (flag && c >= 'a' && c <= 'z') {
		aCharArray516[i5] += -32;
		flag = false;
	    }
	    if (c == '.' || c == '!')
		flag = true;
	}
	return new String(aCharArray516, 0, i);
    }
    
    public static void method380(Class33_Sub2_Sub3 arg0, String arg1,
				 int arg2) {
	if (arg1.length() > 80)
	    arg1 = arg1.substring(0, 80);
	arg1 = arg1.toLowerCase();
	if (arg2 != 0)
	    aBoolean515 = !aBoolean515;
	int i = -1;
	for (int i1 = 0; i1 < arg1.length(); i1++) {
	    char c = arg1.charAt(i1);
	    int i2 = 0;
	    for (int i3 = 0; i3 < aCharArray517.length; i3++) {
		if (c == aCharArray517[i3]) {
		    i2 = i3;
		    break;
		}
	    }
	    if (i2 > 12)
		i2 += 195;
	    if (i == -1) {
		if (i2 < 13)
		    i = i2;
		else
		    arg0.method335(i2);
	    } else if (i2 < 13) {
		arg0.method335((i << 4) + i2);
		i = -1;
	    } else {
		arg0.method335((i << 4) + (i2 >> 4));
		i = i2 & 0xf;
	    }
	}
	if (i != -1)
	    arg0.method335(i << 4);
    }
}
