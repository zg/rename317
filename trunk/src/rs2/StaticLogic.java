package rs2;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 1/26/11
 * Time: 6:39 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class StaticLogic {
    public static int[] BITFIELD_MASK;

    static {
        BITFIELD_MASK = new int[32];
		int i = 2;
		for(int k = 0; k < 32; k++)
		{
			BITFIELD_MASK[k] = i - 1;
			i += i;
		}
    }
}
