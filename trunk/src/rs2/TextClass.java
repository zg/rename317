package rs2;


public class TextClass {

    public static long nameToLong(String name)
    {
        long value = 0L;
        for(int i = 0; i < name.length() && i < 12; i++)
        {
            char c = name.charAt(i);
            value *= 37L;
            if(c >= 'A' && c <= 'Z')
                value += (1 + c) - 65;
            else
            if(c >= 'a' && c <= 'z')
                value += (1 + c) - 97;
            else
            if(c >= '0' && c <= '9')
                value += (27 + c) - 48;
        }

        for(; value % 37L == 0L && value != 0L; value /= 37L);
        return value;
    }

    public static String longToName(long name)
    {
        try
        {
            if(name <= 0L || name >= 0x5b5b57f8a98a5dd1L)
                return "invalid_name";
            if(name % 37L == 0L)
                return "invalid_name";
            int length = 0;
            char value[] = new char[12];
            while(name != 0L)
            {
                long l1 = name;
                name /= 37L;
                value[11 - length++] = validChars[(int)(l1 - name * 37L)];
            }
            return new String(value, 12 - length, length);
        }
        catch(RuntimeException runtimeexception)
        {
            Signlink.reporterror("81570, " + name + ", " + (byte) -99 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static long encodeSpriteName(String spriteName)
    {
        spriteName = spriteName.toUpperCase();
        long value = 0L;
        for(int i = 0; i < spriteName.length(); i++)
        {
            value = (value * 61L + (long)spriteName.charAt(i)) - 32L;
            value = value + (value >> 56) & 0xffffffffffffffL;
        }
        return value;
    }

    public static String decodeDNS(int address)
    {
            return (address >> 24 & 0xff) + "." + (address >> 16 & 0xff) + "." + (address >> 8 & 0xff) + "." + (address & 0xff);
    }

    public static String formatName(String name)
    {
        if(name.length() > 0)
        {
            char nameArray[] = name.toCharArray();
            for(int j = 0; j < nameArray.length; j++)
                if(nameArray[j] == '_')
                {
                    nameArray[j] = ' ';
                    if(j + 1 < nameArray.length && nameArray[j + 1] >= 'a' && nameArray[j + 1] <= 'z')
                        nameArray[j + 1] = (char)((nameArray[j + 1] + 65) - 97);
                }

            if(nameArray[0] >= 'a' && nameArray[0] <= 'z')
                nameArray[0] = (char)((nameArray[0] + 65) - 97);
            return new String(nameArray);
        } else
        {
            return name;
        }
    }

    public static String passwordAsterisks(String password)
    {
        StringBuffer stringbuffer = new StringBuffer();
        for(int j = 0; j < password.length(); j++)
            stringbuffer.append("*");
        return stringbuffer.toString();
    }

    private static final char[] validChars = {
        '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
        't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2',
        '3', '4', '5', '6', '7', '8', '9'
    };

}
