package rs2;

// Decompiler options: packimporsts(3) 

import java.math.BigInteger;
import sign.signlink;

public class Packet extends NodeSub {

    public static Packet create()
    {
        synchronized(stream_pool)
        {
            Packet stream = null;
            if(stream_pool_ptr > 0)
            {
                stream_pool_ptr--;
                stream = (Packet) stream_pool.popHead();
            }
            if(stream != null)
            {
                stream.pos = 0;
                return stream;
            }
        }
        Packet stream_1 = new Packet();
        stream_1.pos = 0;
        stream_1.data = new byte[5000];
        return stream_1;
    }

	public int readShort2() {
		pos += 2;
		int i = ((data[pos - 2] & 0xff) << 8) + (data[pos - 1] & 0xff);
		if(i  > 60000)
		i = -65535+i;
		return i;
	}

    private Packet()
    {
    }

    public Packet(byte abyte0[])
    {
        data = abyte0;
            pos = 0;
    }

    public void p1isaac(int i)
    {
        data[pos++] = (byte)(i + encryption.next());
    }

    public void p1(int i)
    {
        data[pos++] = (byte)i;
    }

    public void p2(int i)
    {
        data[pos++] = (byte)(i >> 8);
        data[pos++] = (byte)i;
    }

    public void ip2(int i)
    {
        data[pos++] = (byte)i;
        data[pos++] = (byte)(i >> 8);
    }

    public void p3(int i)
    {
        data[pos++] = (byte)(i >> 16);
        data[pos++] = (byte)(i >> 8);
        data[pos++] = (byte)i;
    }

    public void p4(int i)
    {
        data[pos++] = (byte)(i >> 24);
        data[pos++] = (byte)(i >> 16);
        data[pos++] = (byte)(i >> 8);
        data[pos++] = (byte)i;
    }

    public void ip4(int j)
    {
        data[pos++] = (byte)j;
        data[pos++] = (byte)(j >> 8);
            data[pos++] = (byte)(j >> 16);
            data[pos++] = (byte)(j >> 24);
    }

    public void p8(long l)
    {
        try
        {
            data[pos++] = (byte)(int)(l >> 56);
            data[pos++] = (byte)(int)(l >> 48);
            data[pos++] = (byte)(int)(l >> 40);
            data[pos++] = (byte)(int)(l >> 32);
            data[pos++] = (byte)(int)(l >> 24);
            data[pos++] = (byte)(int)(l >> 16);
            data[pos++] = (byte)(int)(l >> 8);
            data[pos++] = (byte)(int)l;
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("14395, " + 5 + ", " + l + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void pjstr(String s)
    {
        //s.getBytes(0, s.length(), buffer, currentOffset);    //deprecated
        System.arraycopy(s.getBytes(), 0, data, pos, s.length());
        pos += s.length();
        data[pos++] = 10;
    }

    public void pdata(byte data[], int offset, int length)
    {
        for(int k = offset; k < offset + length; k++)
            this.data[pos++] = data[k];

    }

    public void psize1(int i)
    {
        data[pos - i - 1] = (byte)i;
    }

    public int g1()
    {
        return data[pos++] & 0xff;
    }

    public byte g1b()
    {
        return data[pos++];
    }

    public int g2()
    {
        pos += 2;
        return ((data[pos - 2] & 0xff) << 8) + (data[pos - 1] & 0xff);
    }

    public int g2b()
    {
        pos += 2;
        int i = ((data[pos - 2] & 0xff) << 8) + (data[pos - 1] & 0xff);
        if(i > 32767)
            i -= 0x10000;
        return i;
    }

    public int g3()
    {
        pos += 3;
        return ((data[pos - 3] & 0xff) << 16) + ((data[pos - 2] & 0xff) << 8) + (data[pos - 1] & 0xff);
    }

    public int g4()
    {
        pos += 4;
        return ((data[pos - 4] & 0xff) << 24) + ((data[pos - 3] & 0xff) << 16) + ((data[pos - 2] & 0xff) << 8) + (data[pos - 1] & 0xff);
    }

    public long g8()
    {
        long l = (long) g4() & 0xffffffffL;
        long l1 = (long) g4() & 0xffffffffL;
        return (l << 32) + l1;
    }

    public String gstr()
    {
        int i = pos;
        while(data[pos++] != 10) ;
        return new String(data, i, pos - i - 1);
    }

    public byte[] gstrbyte()
    {
        int i = pos;
        while(data[pos++] != 10) ;
        byte abyte0[] = new byte[pos - i - 1];
        System.arraycopy(data, i, abyte0, i - i, pos - 1 - i);
        return abyte0;
    }

    public void gdata(byte buffer[], int offset, int length)
    {
        for(int l = offset; l < offset + length; l++)
            buffer[l] = data[pos++];
    }

    public byte[] getData(byte[] buffer)
    {
	for(int i = 0; i < buffer.length; i++)
		buffer[i] = data[pos++];

return buffer;
    }

    public void begin_bit_block()
    {
        bit_pos = pos * 8;
    }

    public int gbits(int size)
    {
        int byte_offset = bit_pos >> 3;
        int bit_offset = 8 - (bit_pos & 7);
        int result = 0;
        bit_pos += size;
        for(; size > bit_offset; bit_offset = 8)
        {
            result += (data[byte_offset++] & bitmasks[bit_offset]) << size - bit_offset;
            size -= bit_offset;
        }
        if(size == bit_offset)
            result += data[byte_offset] & bitmasks[bit_offset];
        else
            result += data[byte_offset] >> bit_offset - size & bitmasks[size];
        return result;
    }

    public void end_bit_block()
    {
        pos = (bit_pos + 7) / 8;
    }

    public int gsmart()
    {
        int i = data[pos] & 0xff;
        if(i < 128)
            return g1() - 64;
        else
            return g2() - 49152;
    }

    public int gsmarts()
    {
        int i = data[pos] & 0xff;
        if(i < 128)
            return g1();
        else
            return g2() - 32768;
    }

    public void rsaenc()
    {
        int i = pos;
        pos = 0;
        byte abyte0[] = new byte[i];
        gdata(abyte0, 0, i);
        BigInteger biginteger2 = new BigInteger(abyte0);
        BigInteger biginteger3 = biginteger2/*.modPow(biginteger, biginteger1)*/;
        byte abyte1[] = biginteger3.toByteArray();
        pos = 0;
        p1(abyte1.length);
        pdata(abyte1, 0, abyte1.length);
    }

    public void np1(int i)
    {
        data[pos++] = (byte)(-i);
    }

    public void sp1(int j)
    {
        data[pos++] = (byte)(128 - j);
    }

    public int nsp1()
    {
            return data[pos++] - 128 & 0xff;
    }

    public int ng1b()
    {
        return -data[pos++] & 0xff;
    }

    public int sg1()
    {
        return 128 - data[pos++] & 0xff;
    }

    public byte ng1()
    {
            return (byte)(-data[pos++]);
    }

    public byte sg1b()
    {
        return (byte)(128 - data[pos++]);
    }

    public void sp2(int j)
    {
        data[pos++] = (byte)(j >> 8);
        data[pos++] = (byte)(j + 128);
    }

    public void isp2(int j)
    {
        data[pos++] = (byte)(j + 128);
        data[pos++] = (byte)(j >> 8);
    }

    public int ig2()
    {
        pos += 2;
        return ((data[pos - 1] & 0xff) << 8) + (data[pos - 2] & 0xff);
    }

    public int sg2()
    {
        pos += 2;
        return ((data[pos - 2] & 0xff) << 8) + (data[pos - 1] - 128 & 0xff);
    }

    public int isg2()
    {
        pos += 2;
        return ((data[pos - 1] & 0xff) << 8) + (data[pos - 2] - 128 & 0xff);
    }

    public int ig2b()
    {
        pos += 2;
        int j = ((data[pos - 1] & 0xff) << 8) + (data[pos - 2] & 0xff);
        if(j > 32767)
            j -= 0x10000;
        return j;
    }

    public int isg2b()
    {
        pos += 2;
        int j = ((data[pos - 1] & 0xff) << 8) + (data[pos - 2] - 128 & 0xff);
        if(j > 32767)
            j -= 0x10000;
        return j;
    }

    public int big4()
    {
            pos += 4;
            return ((data[pos - 2] & 0xff) << 24)
            + ((data[pos - 1] & 0xff) << 16)
            + ((data[pos - 4] & 0xff) << 8)
            + (data[pos - 3] & 0xff);
    }

    public int biig4()
    {
        pos += 4;
        return ((data[pos - 3] & 0xff) << 24)
        + ((data[pos - 4] & 0xff) << 16)
        + ((data[pos - 1] & 0xff) << 8)
        + (data[pos - 2] & 0xff);
    }

    public void ispdata(byte buffer[], int offset, int length)
    {
        for(int k = (offset + length) - 1; k >= offset; k--)
            data[pos++] = (byte)(buffer[k] + 128);

    }

    public void igdata(byte buffer[], int offset, int length)
    {
        for(int p = (offset + length) - 1; p >= offset; p--)
            buffer[p] = data[pos++];

    }

    public byte data[];
    public int pos;
    public int bit_pos;
    private static final int[] bitmasks = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };
    public ISAACRandomGen encryption;
    private static int stream_pool_ptr;
    private static final NodeList stream_pool = new NodeList();

    //removed useless static initializer
}
