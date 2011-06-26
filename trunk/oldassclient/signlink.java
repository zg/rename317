import java.applet.Applet;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public final class signlink implements Runnable
{
    public static Applet mainapp;
    public static boolean sunjava;
    private static boolean active;
    private static InetAddress socketip;
    private static int socketreq;
    private static Socket socket = null;
    private static int threadreqpri = 1;
    private static Runnable threadreq = null;
    private static String dnsreq = null;
    private static String dns = null;
    private static String loadreq = null;
    private static byte[] loadbuf = null;
    private static String savereq = null;
    private static byte[] savebuf = null;
    private static String urlreq = null;
    private static DataInputStream urlstream = null;
    public static String midi = null;
    public static String jingle = null;
    public static int jinglelen = 3500;
    public static int looprate = 100;
    
    public static final void startpriv(InetAddress arg0) {
	if (!active) {
	    socketip = arg0;
	    Thread thread = new Thread(new signlink());
	    thread.setDaemon(true);
	    thread.start();
	}
    }
    
    public final void run() {
	if (!active) {
	    active = true;
	    String string = findcachedir();
	    for (;;) {
		if (socketreq != 0) {
		    try {
			socket = new Socket(socketip, socketreq);
		    } catch (Exception exception) {
			socket = null;
		    }
		    socketreq = 0;
		}
		if (threadreq != null) {
		    Thread thread = new Thread(threadreq);
		    thread.setDaemon(true);
		    thread.start();
		    thread.setPriority(threadreqpri);
		    threadreq = null;
		}
		if (dnsreq != null) {
		    try {
			dns = InetAddress.getByName(dnsreq).getHostName();
		    } catch (Exception exception) {
			dns = "unknown";
		    }
		    dnsreq = null;
		}
		if (loadreq != null) {
		    loadbuf = null;
		    try {
			File file = new File(string + loadreq);
			if (file.exists()) {
			    int i = (int) file.length();
			    loadbuf = new byte[i];
			    DataInputStream datainputstream
				= (new DataInputStream
				   (new FileInputStream(string + loadreq)));
			    datainputstream.readFully(loadbuf, 0, i);
			    datainputstream.close();
			}
		    } catch (Exception exception) {
		    }
		    loadreq = null;
		}
		if (savereq != null) {
		    try {
			FileOutputStream fileoutputstream
			    = new FileOutputStream(string + savereq);
			fileoutputstream.write(savebuf, 0, savebuf.length);
			fileoutputstream.close();
		    } catch (Exception exception) {
		    }
		    savereq = null;
		}
		if (urlreq != null) {
		    try {
			urlstream
			    = new DataInputStream(new URL
						      (mainapp.getCodeBase(),
						       urlreq)
						      .openStream());
		    } catch (Exception exception) {
			urlstream = null;
		    }
		    urlreq = null;
		}
		try {
		    Thread.sleep((long) looprate);
		} catch (Exception exception) {
		}
	    }
	}
    }
    
    public static final String findcachedir() {
	String[] strings
	    = { "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/",
		"e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/",
		"~/", "/tmp/", "" };
	String string = ".file_store_32";
	for (int i = 0; i < strings.length; i++) {
	    try {
		String string1 = strings[i];
		if (string1.length() > 0) {
		    File file = new File(string1);
		    if (!file.exists())
			continue;
		}
		File file = new File(string1 + string);
		if (file.exists() || file.mkdir())
		    return string1 + string + "/";
	    } catch (Exception exception) {
	    }
	}
	return null;
    }
    
    public static final long gethash(String arg0) {
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
    
    public static final void looprate(int arg0) {
	looprate = arg0;
    }
    
    public static final byte[] cacheload(String arg0) {
	if (!active)
	    return null;
	if (loadreq != null)
	    return null;
	loadreq = String.valueOf(gethash(arg0));
	while (loadreq != null) {
	    try {
		Thread.sleep(1L);
	    } catch (Exception exception) {
	    }
	}
	return loadbuf;
    }
    
    public static final void cachesave(String arg0, byte[] arg1) {
	if (active && savereq == null && arg1.length <= 2000000) {
	    savebuf = arg1;
	    savereq = String.valueOf(gethash(arg0));
	    while (savereq != null) {
		try {
		    Thread.sleep(1L);
		} catch (Exception exception) {
		}
	    }
	}
    }
    
    public static final Socket opensocket(int arg0) throws IOException {
	socketreq = arg0;
	while (socketreq != 0) {
	    try {
		Thread.sleep(50L);
	    } catch (Exception exception) {
	    }
	}
	if (socket == null)
	    throw new IOException("could not open socket");
	return socket;
    }
    
    public static final String dnslookup(String arg0) {
	return "unknown";
    }
    
    public static final void startthread(Runnable arg0, int arg1) {
	threadreqpri = arg1;
	threadreq = arg0;
    }
    
    public static final DataInputStream openurl(String arg0)
	throws IOException {
	urlreq = arg0;
	while (urlreq != null) {
	    try {
		Thread.sleep(50L);
	    } catch (Exception exception) {
	    }
	}
	if (urlstream == null)
	    throw new IOException("could not open: " + arg0);
	return urlstream;
    }
}
