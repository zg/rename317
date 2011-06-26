import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class RSApplet extends Applet
    implements Runnable, MouseListener, MouseMotionListener, KeyListener,
	       FocusListener, WindowListener
{
    private byte aByte1 = -64;
    private int anInt2;
    private int anInt3 = 2;
    private byte aByte4 = 4;
    private boolean aBoolean5 = false;
    private int anInt6;
    private int delayTime = 20;
    public int minDelay = 1;
    private long[] otim = new long[10];
    public int anInt10;
    public int anInt11;
    public int anInt12;
    public Graphics aGraphics13;
    public Class26 aClass26_14;
    public Class33_Sub2_Sub2_Sub2[] aClass33_Sub2_Sub2_Sub2Array15
	= new Class33_Sub2_Sub2_Sub2[6];
    public RSFrame gameFrame;
    public boolean shouldClearSceen = true;
    public int idleTime;
    public int clickMode2;
    public int mouseX;
    public int mouseY;
    public int clickMode1;
    public int clickX;
    public int clickY;
    public int[] keyArray = new int[128];
    private int[] charQueue = new int[128];
    private int readIndex;
    private int writeIndex;
    public static boolean aBoolean29;
    
    public final void method1(int arg0, byte arg1, int arg2) {
	anInt11 = arg2;
	anInt12 = arg0;
	gameFrame = new RSFrame(anInt11, this, 22967, anInt12);
	aGraphics13 = getGameComponent((byte) 8).getGraphics();
	aClass26_14 = new Class26(anInt12, 604, anInt11, getGameComponent((byte) 8));
	if (arg1 == aByte4)
	    method12(this, 1);
    }
    
    public final void method2(int arg0, byte arg1, int arg2) {
	if (arg1 == 104) {
	    anInt11 = arg2;
	    anInt12 = arg0;
	    aGraphics13 = getGameComponent((byte) 8).getGraphics();
	    aClass26_14
		= new Class26(anInt12, 604, anInt11, getGameComponent((byte) 8));
	    method12(this, 1);
	}
    }
    
    public void run() {
	System.out.println("Registering event listeners");
	getGameComponent((byte) 8).addMouseListener(this);
	getGameComponent((byte) 8).addMouseMotionListener(this);
	getGameComponent((byte) 8).addKeyListener(this);
	getGameComponent((byte) 8).addFocusListener(this);
	if (gameFrame != null)
	    gameFrame.addWindowListener(this);
	drawLoadingText("Loading...", 0, false);
	startUp();
	int opos = 0;
	int ratio = 256;
	int del = 1;
	int i3 = 0;
	for (int i4 = 0; i4 < 10; i4++)
	    otim[i4] = System.currentTimeMillis();
	long l = System.currentTimeMillis();
	while (anInt6 >= 0) {
	    if (anInt6 > 0) {
		anInt6--;
		if (anInt6 == 0) {
		    exit((byte) 8);
		    return;
		}
	    }
	    int i5 = ratio;
	    int i6 = del;
	    ratio = 300;
	    del = 1;
	    l = System.currentTimeMillis();
	    if (otim[opos] == 0L) {
		ratio = i5;
		del = i6;
	    } else if (l > otim[opos])
		ratio = (int) ((long) (delayTime * 2560) / (l - otim[opos]));
	    if (ratio < 25)
		ratio = 25;
	    if (ratio > 256) {
		ratio = 256;
		del = (int) ((long) delayTime - (l - otim[opos]) / 10L);
	    }
	    otim[opos] = l;
	    opos = (opos + 1) % 10;
	    if (del > 1) {
		for (int i7 = 0; i7 < 10; i7++) {
		    if (otim[i7] != 0L)
			otim[i7] += (long) del;
		}
	    }
	    if (del < minDelay)
		del = minDelay;
	    try {
		Thread.sleep((long) del);
	    } catch (InterruptedException interruptedexception) {
	    }
	    for (; i3 < 256; i3 += ratio) {
		method7(0);
		clickMode1 = 0;
		readIndex = writeIndex;
	    }
	    i3 &= 0xff;
	    if (delayTime > 0)
		anInt10 = ratio * 1000 / (delayTime * 256);
	    method9(4);
	}
	if (anInt6 == -1)
	    exit((byte) 8);
    }
    
    public final void exit(byte arg0) {
	anInt6 = -2;
	System.out.println("Closing program");
	cleanUpForQuit(aByte1);
	if (arg0 == 8) {
	    boolean flag = false;
	} else {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	try {
	    Thread.sleep(1000L);
	} catch (Exception exception) {
	}
	try {
	    System.exit(0);
	} catch (Throwable throwable) {
	}
    }
    
    public final void method4(int arg0, int arg1) {
	if (arg1 != 0) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
	delayTime = 1000 / arg0;
    }
    
    public final void start() {
	if (anInt6 >= 0)
	    anInt6 = 0;
    }
    
    public final void stop() {
	if (anInt6 >= 0)
	    anInt6 = 4000 / delayTime;
    }
    
    public final void destroy() {
	anInt6 = -1;
	try {
	    Thread.sleep(5000L);
	} catch (Exception exception) {
	}
	if (anInt6 == -1) {
	    System.out.println("5 seconds expired, forcing kill");
	    exit((byte) 8);
	}
    }
    
    public final void update(Graphics arg0) {
	shouldClearSceen = true;
	raiseWelcomeSceen(-467);
    }
    
    public final void paint(Graphics arg0) {
	shouldClearSceen = true;
	raiseWelcomeSceen(-467);
    }
    
    public final void mousePressed(MouseEvent mouseEvent) {
	int i = mouseEvent.getX();
	int i1 = mouseEvent.getY();
	if (gameFrame != null) {
	    i -= 4;
	    i1 -= 22;
	}
	idleTime = 0;
	clickX = i;
	clickY = i1;
	if (mouseEvent.isMetaDown()) {
	    clickMode1 = 2;
	    clickMode2 = 2;
	} else {
	    clickMode1 = 1;
	    clickMode2 = 1;
	}
    }
    
    public final void mouseReleased(MouseEvent arg0) {
	idleTime = 0;
	clickMode2 = 0;
    }
    
    public final void mouseClicked(MouseEvent arg0) {
    }
    
    public final void mouseEntered(MouseEvent arg0) {
    }
    
    public final void mouseExited(MouseEvent arg0) {
    }
    
    public final void mouseDragged(MouseEvent arg0) {
	int i = arg0.getX();
	int i1 = arg0.getY();
	if (gameFrame != null) {
	    i -= 4;
	    i1 -= 22;
	}
	idleTime = 0;
	mouseX = i;
	mouseY = i1;
    }
    
    public final void mouseMoved(MouseEvent arg0) {
	int i = arg0.getX();
	int i1 = arg0.getY();
	if (gameFrame != null) {
	    i -= 4;
	    i1 -= 22;
	}
	idleTime = 0;
	mouseX = i;
	mouseY = i1;
    }
    
    public final void keyPressed(KeyEvent arg0) {
	idleTime = 0;
	int i = arg0.getKeyCode();
	int i1 = arg0.getKeyChar();
	if (i1 < 30)
	    i1 = 0;
	if (i == 37)
	    i1 = 1;
	if (i == 39)
	    i1 = 2;
	if (i == 38)
	    i1 = 3;
	if (i == 40)
	    i1 = 4;
	if (i == 8)
	    i1 = 8;
	if (i == 127)
	    i1 = 8;
	if (i == 9)
	    i1 = 9;
	if (i == 10)
	    i1 = 10;
	if (i >= 112 && i <= 123)
	    i1 = i + 1008 - 112;
	if (i == 36)
	    i1 = 1000;
	if (i == 35)
	    i1 = 1001;
	if (i == 33)
	    i1 = 1002;
	if (i == 34)
	    i1 = 1003;
	if (i1 > 0 && i1 < 128)
	    keyArray[i1] = 1;
	if (i1 > 4) {
	    charQueue[writeIndex] = i1;
	    writeIndex = writeIndex + 1 & 0x7f;
	}
    }
    
    public final void keyReleased(KeyEvent arg0) {
	idleTime = 0;
	int i = arg0.getKeyCode();
	char c = arg0.getKeyChar();
	if (c < '\036')
	    c = '\0';
	if (i == 37)
	    c = '\001';
	if (i == 39)
	    c = '\002';
	if (i == 38)
	    c = '\003';
	if (i == 40)
	    c = '\004';
	if (i == 8)
	    c = '\010';
	if (i == 127)
	    c = '\010';
	if (i == 9)
	    c = '\t';
	if (i == 10)
	    c = '\n';
	if (c > 0 && c < '\u0080')
	    keyArray[c] = 0;
    }
    
    public final void keyTyped(KeyEvent arg0) {
    }
    
    public final void focusGained(FocusEvent arg0) {
	shouldClearSceen = true;
	raiseWelcomeSceen(-467);
    }
    
    public final void focusLost(FocusEvent arg0) {
    }
    
    public final int readChar(boolean arg0) {
	if (arg0)
	    return anInt3;
	int i = -1;
	if (writeIndex != readIndex) {
	    i = charQueue[readIndex];
	    readIndex = readIndex + 1 & 0x7f;
	}
	return i;
    }
    
    public final void windowActivated(WindowEvent arg0) {
    }
    
    public final void windowClosed(WindowEvent arg0) {
    }
    
    public final void windowClosing(WindowEvent arg0) {
	destroy();
    }
    
    public final void windowDeactivated(WindowEvent arg0) {
    }
    
    public final void windowDeiconified(WindowEvent arg0) {
    }
    
    public final void windowIconified(WindowEvent arg0) {
    }
    
    public final void windowOpened(WindowEvent arg0) {
    }
    
    public void startUp() {
    }
    
    public void method7(int arg0) {
	if (arg0 != 0) {
	}
    }
    
    public void cleanUpForQuit(byte arg0) {
	if (arg0 != -64) {
	    for (int i = 1; i > 0; i++) {
	    }
	}
    }
    
    public void method9(int arg0) {
	if (arg0 < 4 || arg0 > 4) {
	}
    }
    
    public void raiseWelcomeSceen(int arg0) {
	while (arg0 >= 0)
	    aBoolean5 = !aBoolean5;
    }
    
    public Component getGameComponent(byte arg0) {
	if (arg0 == 8) {
	    boolean flag = false;
	} else
	    anInt2 = -278;
	if (gameFrame != null)
	    return gameFrame;
	return this;
    }
    
    public void method12(Runnable arg0, int arg1) {
	Thread thread = new Thread(arg0);
	thread.start();
	thread.setPriority(arg1);
    }
    
    public void drawLoadingText(String arg0, int arg1, boolean arg2) {
	Font font = new Font("Helvetica", 1, 13);
	FontMetrics fontmetrics = getGameComponent((byte) 8).getFontMetrics(font);
	Font font1 = new Font("Helvetica", 0, 13);
	getGameComponent((byte) 8).getFontMetrics(font1);
	if (shouldClearSceen) {
	    aGraphics13.setColor(Color.black);
	    aGraphics13.fillRect(0, 0, anInt11, anInt12);
	    shouldClearSceen = false;
	}
	Color color = new Color(140, 17, 17);
	int i = anInt12 / 2 - 18;
	aGraphics13.setColor(color);
	aGraphics13.drawRect(anInt11 / 2 - 152, i, 304, 34);
	aGraphics13.fillRect(anInt11 / 2 - 150, i + 2, arg1 * 3, 30);
	aGraphics13.setColor(Color.black);
	if (!arg2) {
	    aGraphics13.fillRect(anInt11 / 2 - 150 + arg1 * 3, i + 2,
				 300 - arg1 * 3, 30);
	    aGraphics13.setFont(font);
	    aGraphics13.setColor(Color.white);
	    aGraphics13.drawString(arg0,
				   ((anInt11 - fontmetrics.stringWidth(arg0))
				    / 2),
				   i + 22);
	}
    }
}
