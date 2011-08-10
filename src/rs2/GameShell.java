package rs2;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GameShell extends Applet implements Runnable, MouseListener, MouseMotionListener, KeyListener, FocusListener, WindowListener {

    private static final Object graphicsMutex = new Object();
    private static boolean inGraphicsBlock = false;

    protected final void initializeApp(int width, int height) {
        myWidth = width;
        myHeight = height;
        gameFrame = new RSFrame(this, myWidth, myHeight);
        graphics = getGameComponent().getGraphics();
        fullGameScreen = new GraphicsBuffer(myWidth, myHeight, getGameComponent());
        startRunnable(this, 1);
    }

    protected final void initialize(int width, int height) {
        myWidth = width;
        myHeight = height;
        graphics = getGameComponent().getGraphics();
        fullGameScreen = new GraphicsBuffer(myWidth, myHeight, getGameComponent());
        startRunnable(this, 1);
    }

    public void run() {
        getGameComponent().addMouseListener(this);
        getGameComponent().addMouseMotionListener(this);
        getGameComponent().addKeyListener(this);
        getGameComponent().addFocusListener(this);
        if (gameFrame != null)
            gameFrame.addWindowListener(this);
        drawLoadingText(0, "Loading...");
        startUp();
        int opos = 0;
        int ratio = 256;
        int del = 1;
        int count = 0;
        int intex = 0;
        for (int otimPtr = 0; otimPtr < 10; otimPtr++)
            otim[otimPtr] = System.currentTimeMillis();

        //long l = System.currentTimeMillis();//never used
        while (gameState >= 0) {// 0 == Running, >0 - Stop timer, -2 - Exit, -1 Destroyed
            if (gameState > 0) {
                gameState--;
                if (gameState == 0) {
                    exit();
                    return;
                }
            }
            int i2 = ratio;
            int j2 = del;
            ratio = 300;
            del = 1;
            long ntime = System.currentTimeMillis();
            if (otim[opos] == 0L) {
                ratio = i2;
                del = j2;
            } else if (ntime > otim[opos])
                ratio = (int) ((long) (2560 * delayTime) / (ntime - otim[opos]));
            if (ratio < 25)
                ratio = 25;
            if (ratio > 256) {
                ratio = 256;
                del = (int) ((long) delayTime - (ntime - otim[opos]) / 10L);
            }
            if (del > delayTime)
                del = delayTime;
            otim[opos] = ntime;
            opos = (opos + 1) % 10;
            if (del > 1) {
                for (int k2 = 0; k2 < 10; k2++)
                    if (otim[k2] != 0L)
                        otim[k2] += del;

            }
            if (del < minDelay)
                del = minDelay;
            try {
                Thread.sleep(del);
            } catch (InterruptedException _ex) {
                intex++;
            }
            for (; count < 256; count += ratio) {
                mouseButtonPressed = eventMouseButtonPressed;
                clickX = eventClickX;
                clickY = eventClickY;
                clickTime = eventTime;
                eventMouseButtonPressed = 0;
                doLogic();
                readIndex = writeIndex;
            }

            count &= 0xff;
            if (delayTime > 0)
                fps = (1000 * ratio) / (delayTime * 256);
            startGraphicsBlock();
            drawGame();
            endGraphicsBlock();
            if (gameShellDumpRequested) {
                System.out.println("ntime:" + ntime);
                for (int l2 = 0; l2 < 10; l2++) {
                    int otimPtr = ((opos - l2 - 1) + 20) % 10;
                    System.out.println("otim" + otimPtr + ":" + otim[otimPtr]);
                }

                System.out.println("fps:" + fps + " ratio:" + ratio + " count:" + count);
                System.out.println("del:" + del + " deltime:" + delayTime + " mindel:" + minDelay);
                System.out.println("intex:" + intex + " opos:" + opos);
                gameShellDumpRequested = false;
                intex = 0;
            }
        }
        if (gameState == -1)
            exit();
    }

    public static void startGraphicsBlock(){  //Synchronized to prevent race conditions
        synchronized (graphicsMutex){
            while(inGraphicsBlock)
                try {
                    graphicsMutex.wait();
                } catch (InterruptedException ignored) {}
            inGraphicsBlock = true;
        }
    }

    public static void endGraphicsBlock(){
        synchronized (graphicsMutex){
            inGraphicsBlock = false;
            graphicsMutex.notify();
        }
    }

    private void exit() {
        gameState = -2;
        shutdown();
        if (gameFrame != null) {
            try {
                Thread.sleep(1000L);
            } catch (Exception ignored) {
            }
            try {
                System.exit(0);
            } catch (Throwable ignored) {
            }
        }
    }

    final void setTargetFramerate(int i) {
        delayTime = 1000 / i;
    }

    public final void start() {
        if (gameState >= 0)
            gameState = 0;
    }

    public final void stop() {
        if (gameState >= 0)
            gameState = 4000 / delayTime;
    }

    public final void destroy() {
        gameState = -1;
        try {
            Thread.sleep(5000L);
        } catch (Exception ignored) {
        }
        if (gameState == -1)
            exit();
    }

    public final void update(Graphics g) {
        if (graphics == null)
            graphics = g;
        shouldClearScreen = true;
        repaintGame();
    }

    public final void paint(Graphics g) {
        if (graphics == null)
            graphics = g;
        shouldClearScreen = true;
        repaintGame();
    }

    public final void mousePressed(MouseEvent mouseevent) {
        int x = mouseevent.getX();
        int y = mouseevent.getY();
        if (gameFrame != null) {
            x -= 4;
            y -= 22;
        }
        idleTime = 0;
        eventClickX = x;
        eventClickY = y;
        eventTime = System.currentTimeMillis();
        if (mouseevent.isMetaDown()) {
            eventMouseButtonPressed = 2;
            mouseButtonDown = 2;
        } else {
            eventMouseButtonPressed = 1;
            mouseButtonDown = 1;
        }
    }

    public final void mouseReleased(MouseEvent mouseevent) {
        idleTime = 0;
        mouseButtonDown = 0;
    }

    public final void mouseClicked(MouseEvent mouseevent) {
    }

    public final void mouseEntered(MouseEvent mouseevent) {
    }

    public final void mouseExited(MouseEvent mouseevent) {
        idleTime = 0;
        mouseEventX = -1;
        mouseEventY = -1;
    }

    public final void mouseDragged(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if (gameFrame != null) {
            i -= 4;
            j -= 22;
        }
        idleTime = 0;
        mouseEventX = i;
        mouseEventY = j;
    }

    public final void mouseMoved(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if (gameFrame != null) {
            i -= 4;
            j -= 22;
        }
        idleTime = 0;
        mouseEventX = i;
        mouseEventY = j;
    }

    public final void keyPressed(KeyEvent keyevent) {
        idleTime = 0;
        int keyCode = keyevent.getKeyCode();
        int keyChar = keyevent.getKeyChar();
        if (keyChar < 30)
            keyChar = 0;
        if (keyCode == 37)
            keyChar = 1;
        if (keyCode == 39)
            keyChar = 2;
        if (keyCode == 38)
            keyChar = 3;
        if (keyCode == 40)
            keyChar = 4;
        if (keyCode == 17)
            keyChar = 5;
        if (keyCode == 8)
            keyChar = 8;
        if (keyCode == 127)
            keyChar = 8;
        if (keyCode == 9)
            keyChar = 9;
        if (keyCode == 10)
            keyChar = 10;
        if (keyCode >= 112 && keyCode <= 123)
            keyChar = (1008 + keyCode) - 112;
        if (keyCode == 36)
            keyChar = 1000;
        if (keyCode == 35)
            keyChar = 1001;
        if (keyCode == 33)
            keyChar = 1002;
        if (keyCode == 34)
            keyChar = 1003;
        if (keyChar > 0 && keyChar < 128)
            keyStatus[keyChar] = 1;
        if (keyChar > 4) {
            inputBuffer[writeIndex] = keyChar;
            writeIndex = writeIndex + 1 & 0x7f;
        }
    }

    public final void keyReleased(KeyEvent keyevent) {
        idleTime = 0;
        int i = keyevent.getKeyCode();
        char c = keyevent.getKeyChar();
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
        if (i == 17)
            c = '\005';
        if (i == 8)
            c = '\b';
        if (i == 127)
            c = '\b';
        if (i == 9)
            c = '\t';
        if (i == 10)
            c = '\n';
        if (c > 0 && c < '\200')
            keyStatus[c] = 0;
    }

    public final void keyTyped(KeyEvent keyevent) {
    }

    final int readChar() {
        int k = -1;
        if (writeIndex != readIndex) {
            k = inputBuffer[readIndex];
            readIndex = readIndex + 1 & 0x7f;
        }
        return k;
    }

    public final void focusGained(FocusEvent focusevent) {
        awtFocus = true;
        shouldClearScreen = true;
        repaintGame();
    }

    public final void focusLost(FocusEvent focusevent) {
        awtFocus = false;
        for (int i = 0; i < 128; i++)
            keyStatus[i] = 0;

    }

    public final void windowActivated(WindowEvent windowevent) {
    }

    public final void windowClosed(WindowEvent windowevent) {
    }

    public void windowClosing(WindowEvent windowevent) {
        destroy();
    }

    public void windowDeactivated(WindowEvent windowevent) {
    }

    public final void windowDeiconified(WindowEvent windowevent) {
    }

    public final void windowIconified(WindowEvent windowevent) {
    }

    public void windowOpened(WindowEvent windowevent) {
    }

    protected void startUp() {
    }

    protected void doLogic() {
    }

    protected void shutdown() {
    }

    protected void drawGame() {
    }

    protected void repaintGame() {
    }

    protected Component getGameComponent() {
        if (gameFrame != null)
            return gameFrame;
        else
            return this;
    }

    public void startRunnable(Runnable runnable, int priority) {
        Thread thread = new Thread(runnable);
        thread.start();
        thread.setPriority(priority);
    }

    protected void drawLoadingText(int i, String s) {
        while (graphics == null) {
            graphics = getGameComponent().getGraphics();
            try {
                getGameComponent().repaint();
            } catch (Exception ignored) {
            }
            try {
                Thread.sleep(1000L);
            } catch (Exception ignored) {
            }
        }
        Font font = new Font("Helvetica", 1, 13);
        FontMetrics fontmetrics = getGameComponent().getFontMetrics(font);
        Font font1 = new Font("Helvetica", 0, 13);
        getGameComponent().getFontMetrics(font1);
        if (shouldClearScreen) {
            graphics.setColor(Color.black);
            graphics.fillRect(0, 0, myWidth, myHeight);
            shouldClearScreen = false;
        }
        Color color = new Color(140, 17, 17);
        int j = myHeight / 2 - 18;
        graphics.setColor(color);
        graphics.drawRect(myWidth / 2 - 152, j, 304, 34);
        graphics.fillRect(myWidth / 2 - 150, j + 2, i * 3, 30);
        graphics.setColor(Color.black);
        graphics.fillRect((myWidth / 2 - 150) + i * 3, j + 2, 300 - i * 3, 30);
        graphics.setFont(font);
        graphics.setColor(Color.white);
        graphics.drawString(s, (myWidth - fontmetrics.stringWidth(s)) / 2, j + 22);
    }

    public GameShell() {
        delayTime = 20;//20;
        minDelay = 1;//1
        otim = new long[10];
        gameShellDumpRequested = false;
        shouldClearScreen = true;
        awtFocus = true;
        keyStatus = new int[128];
        inputBuffer = new int[128];
    }

    private int gameState;
    private int delayTime;
    protected int minDelay;
    private final long[] otim;
    protected int fps;
    protected boolean gameShellDumpRequested;
    protected int myWidth;
    protected int myHeight;
    protected Graphics graphics;
    protected GraphicsBuffer fullGameScreen;
    public RSFrame gameFrame;
    private boolean shouldClearScreen;
    protected boolean awtFocus;
    protected int idleTime;
    protected int mouseButtonDown;
    public int mouseEventX;
    public int mouseEventY;
    private int eventMouseButtonPressed;
    private int eventClickX;
    private int eventClickY;
    private long eventTime;
    protected int mouseButtonPressed;
    protected int clickX;
    protected int clickY;
    protected long clickTime;
    protected final int[] keyStatus;
    private final int[] inputBuffer;
    private int readIndex;
    private int writeIndex;
}
