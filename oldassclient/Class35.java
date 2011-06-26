
public final class Class35
{
    private static boolean aBoolean508 = true;
    private static int anInt509 = 86;
    private static int anInt510 = 604;
    private static boolean aBoolean511;
    static char[] aCharArray512 = new char[12];
    static char[] aCharArray513
	= { '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
	    'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
	    'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    
    public static long method372(String arg0) {
	arg0 = arg0.trim();
	long l = 0L;
	for (int i = 0; i < arg0.length() && i < 12; i++) {
	    char c = arg0.charAt(i);
	    l *= 37L;
	    if (c >= 'A' && c <= 'Z')
		l += (long) (c + '\001' - 'A');
	    else if (c >= 'a' && c <= 'z')
		l += (long) (c + '\001' - 'a');
	    else if (c >= '0' && c <= '9')
		l += (long) (c + '\033' - '0');
	}
	return l;
    }
    
    public static String method373(byte arg0, long arg1) {
	if (arg1 < 0L || arg1 >= 6582952005840035281L)
	    return "invalid_name";
	int i = 0;
	if (arg0 != -89)
	    throw new NullPointerException();
	while (arg1 != 0L) {
	    long l = arg1;
	    arg1 /= 37L;
	    aCharArray512[11 - i++] = aCharArray513[(int) (l - arg1 * 37L)];
	}
	return new String(aCharArray512, 12 - i, i);
    }
    
    public static long method374(String arg0, int arg1) {
	arg0 = arg0.toLowerCase();
	arg1 = 27 / arg1;
	long l = 0L;
	for (int i = 0; i < arg0.length(); i++)
	    l = l * 61L + (long) arg0.charAt(i) - 32L;
	return l;
    }
    
    public static String method375(String arg0, int arg1) {
	if (arg1 <= 0)
	    aBoolean511 = !aBoolean511;
	arg0 = arg0.toLowerCase().trim();
	String string = "";
	for (int i = 0; i < arg0.length(); i++) {
	    if (i >= 12)
		break;
	    char c = arg0.charAt(i);
	    if (c >= 'a' && c <= 'z')
		string += c;
	    else if (c >= '0' && c <= '9')
		string += c;
	    else
		string += '_';
	}
	for (; string.endsWith("_");
	     string = string.substring(0, string.length() - 1)) {
	}
	for (; string.startsWith("_"); string = string.substring(1)) {
	}
	return string;
    }
    
    public static String method376(String arg0, int arg1) {
	if (arg1 >= 0)
	    throw new NullPointerException();
	if (arg0.length() > 0) {
	    char[] chars = arg0.toCharArray();
	    for (int i = 0; i < chars.length; i++) {
		if (chars[i] == '_') {
		    chars[i] = ' ';
		    if (i + 1 < chars.length && chars[i + 1] >= 'a'
			&& chars[i + 1] <= 'z')
			chars[i + 1] = (char) (chars[i + 1] + 'A' - 'a');
		}
	    }
	    if (chars[0] >= 'a' && chars[0] <= 'z')
		chars[0] = (char) (chars[0] + 'A' - 'a');
	    return new String(chars);
	}
	return arg0;
    }
    
    public static String method377(String arg0, int arg1) {
	if (arg1 <= 0)
	    aBoolean508 = !aBoolean508;
	arg0 = arg0.toLowerCase();
	char[] chars = arg0.toCharArray();
	int i = chars.length;
	boolean flag = true;
	for (int i1 = 0; i1 < i; i1++) {
	    char c = chars[i1];
	    if (flag && c >= 'a' && c <= 'z') {
		chars[i1] += -32;
		flag = false;
	    }
	    if (c == '.' || c == '!')
		flag = true;
	}
	return new String(chars);
    }
    
    public static String method378(String arg0, byte arg1) {
	if (arg1 != -37)
	    anInt509 = -142;
	String string = "";
	for (int i = 0; i < arg0.length(); i++)
	    string += "*";
	return string;
    }
}
