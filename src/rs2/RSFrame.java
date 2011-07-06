package rs2;

import java.awt.*;

@SuppressWarnings("serial")
public class RSFrame extends Frame
{

    public RSFrame(GameShell gameShell, int width, int height)
    {
        this.gameShell = gameShell;
        setTitle("Jagex");
        setResizable(false);
        setVisible(true);
        toFront();
        setSize(width + 8, height + 28);
    }

    public Graphics getGraphics()
    {
        Graphics g = super.getGraphics();
        g.translate(4, 24);
        return g;
    }

    public void update(Graphics g)
    {
        gameShell.update(g);
    }

    public void paint(Graphics g)
    {
        gameShell.paint(g);
    }

    private final GameShell gameShell;
}
