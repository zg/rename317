import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class Class5 implements Runnable
{
    private int anInt90 = 268;
    private InputStream anInputStream91;
    private OutputStream anOutputStream92;
    private Socket aSocket93;
    private boolean aBoolean94 = false;
    RSApplet anApplet_Sub1_95;
    private byte[] aByteArray96;
    private int anInt97;
    private int anInt98;
    private boolean aBoolean99 = false;
    private boolean aBoolean100 = false;
    
    public Class5(int arg0, Socket arg1, RSApplet arg2) throws IOException {
	((Class5) this).anApplet_Sub1_95 = arg2;
	aSocket93 = arg1;
	aSocket93.setSoTimeout(30000);
	aSocket93.setTcpNoDelay(true);
	anInputStream91 = aSocket93.getInputStream();
	while (arg0 >= 0)
	    anInt90 = -113;
	anOutputStream92 = aSocket93.getOutputStream();
    }
    
    public void method125() {
	aBoolean94 = true;
	try {
	    if (anInputStream91 != null)
		anInputStream91.close();
	    if (anOutputStream92 != null)
		anOutputStream92.close();
	    if (aSocket93 != null)
		aSocket93.close();
	} catch (IOException ioexception) {
	    System.out.println("Error closing stream");
	}
	aBoolean99 = false;
	synchronized (this) {
	    this.notify();
	}
	aByteArray96 = null;
    }
    
    public int method126() throws IOException {
	if (aBoolean94 == true)
	    return 0;
	return anInputStream91.read();
    }
    
    public int method127() throws IOException {
	if (aBoolean94 == true)
	    return 0;
	return anInputStream91.available();
    }
    
    public void method128(byte[] arg0, int arg1, int arg2) throws IOException {
	if (aBoolean94 != true) {
	    int i;
	    for (; arg2 > 0; arg2 -= i) {
		i = anInputStream91.read(arg0, arg1, arg2);
		if (i <= 0)
		    throw new IOException("EOF");
		arg1 += i;
	    }
	}
    }
    
    public void method129(int arg0, int arg1, byte[] arg2, int arg3)
	throws IOException {
	if (aBoolean94 != true) {
	    if (aBoolean100) {
		aBoolean100 = false;
		throw new IOException("Error in writer thread");
	    }
	    if (aByteArray96 == null)
		aByteArray96 = new byte[5000];
	    synchronized (this) {
		for (int i = 0; i < arg3; i++) {
		    aByteArray96[anInt98] = arg2[i + arg0];
		    anInt98 = (anInt98 + 1) % 5000;
		    if (anInt98 == (anInt97 + 4900) % 5000)
			throw new IOException("buffer overflow");
		}
		if (aBoolean99 == false) {
		    aBoolean99 = true;
		    ((Class5) this).anApplet_Sub1_95.method12(this, 2);
		}
		this.notify();
	    }
	    if (arg1 != 0) {
		for (int i = 1; i > 0; i++) {
		}
	    }
	}
    }
    
    public void run() {
	System.out.println("clientstream writer starting");
	while (aBoolean99 == true) {
	    int i;
	    int i1;
	    synchronized (this) {
		if (anInt98 == anInt97) {
		    try {
			this.wait();
		    } catch (InterruptedException interruptedexception) {
		    }
		}
		if (aBoolean99 == false)
		    break;
		i = anInt97;
		if (anInt98 >= anInt97)
		    i1 = anInt98 - anInt97;
		else
		    i1 = 5000 - anInt97;
	    }
	    if (i1 > 0) {
		try {
		    anOutputStream92.write(aByteArray96, i, i1);
		} catch (IOException ioexception) {
		    aBoolean100 = true;
		}
		anInt97 = (anInt97 + i1) % 5000;
		try {
		    if (anInt98 == anInt97)
			anOutputStream92.flush();
		} catch (IOException ioexception) {
		    aBoolean100 = true;
		}
	    }
	}
	System.out.println("clientstream writer stopping");
    }
}
