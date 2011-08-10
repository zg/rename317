package rt4;/* Class26_Sub2_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import rt4.Class26_Sub2;

public class Class26_Sub2_Sub1 extends Class26_Sub2
{
    public byte[] data;
    
    public byte[] method1033(int w, int h, int d) {
        data = new byte[w * h * d * 2];
        method1020(h, d, w, 0);
        return data;
    }
    
    public Class26_Sub2_Sub1() {
	    super(8, 5, 8, 8, 2, 0.1F, 0.55F, 3.0F);
    }
    
    public void writeData(int ptr, byte valA) {
        int i = ptr * 2;
        int val = valA & 0xff;
        data[i++] = (byte)( 3* (val >> 5));
        data[i] = (byte) ((val >> 2));
    }
}
