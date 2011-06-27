package editor.renderer;

import editor.EditorMain;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/24/11
 * Time: 7:15 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 * Our swing component version of RSFrame
 */
public class MapViewPanel extends Canvas {

    public MapViewPanel() {
    }

    public void setGameShell(EditorMain shell){
        gameShell = shell;
        repaint();
    }

    /**
     * Invoked by Swing to draw components.
     * Applications should not invoke <code>paint</code> directly,
     * but should instead use the <code>repaint</code> method to
     * schedule the component for redrawing.
     * <p/>
     * This method actually delegates the work of painting to three
     * protected methods: <code>paintComponent</code>,
     * <code>paintBorder</code>,
     * and <code>paintChildren</code>.  They're called in the order
     * listed to ensure that children appear on top of component itself.
     * Generally speaking, the component and its children should not
     * paint in the insets area allocated to the border. Subclasses can
     * just override this method, as always.  A subclass that just
     * wants to specialize the UI (look and feel) delegate's
     * <code>paint</code> method should just override
     * <code>paintComponent</code>.
     *
     * @param g the <code>Graphics</code> context in which to paint
     * @see #paintComponent
     * @see #paintBorder
     * @see #paintChildren
     * @see #getComponentGraphics
     * @see #repaint
     */
    @Override
    public void paint(Graphics g) {
        if (gameShell == null){
            g.setColor(Color.red);
            g.fillRect(0,0,getWidth(),getHeight());
        } else
            gameShell.paintMinimap(g);
    }

    private EditorMain gameShell = null;
}
