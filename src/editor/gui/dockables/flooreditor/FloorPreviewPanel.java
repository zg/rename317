package editor.gui.dockables.flooreditor;

import rs2.*;

import javax.swing.*;
import javax.swing.text.ZoneView;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.BreakIterator;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/24/11
 * Time: 7:21 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class FloorPreviewPanel extends JPanel{
    private GraphicsBuffer graphicsBuffer;
    private Floor myFloor = null;
    private FloorPreviewMode mode = FloorPreviewMode.RT3_GAME;

    public FloorPreviewPanel(){
        graphicsBuffer = new GraphicsBuffer(128,128,this);
        setMaximumSize(new Dimension(128,128));
        setPreferredSize(new Dimension(128,128));
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
    public void paint(Graphics g) {    //TODO: Add texture colour blending
        GameShell.startGraphicsBlock();
        graphicsBuffer.initDrawingArea();
        Graphics2D.resetImage();
        if (myFloor != null)
            switch (mode){
                case RT3_GAME:
                    if (myFloor.texture != -1)
                        Rasterizer.textureImages[myFloor.texture].drawImage(0,0);
                    else
                        Graphics2D.fillRect(0,0,128,128,myFloor.colour2);
                    break;
                case RT3_GAME_LD:
                    if (myFloor.texture != -1)
                        Graphics2D.fillRect(0,0,128,128,Rasterizer.getAverageTextureColour(myFloor.texture));
                    else
                        Graphics2D.fillRect(0, 0, 128, 128, myFloor.colour2);
                    break;
                case RT3_MAP:
                    if (myFloor.texture != -1)
                        Graphics2D.fillRect(0,0,128,128,Rasterizer.getAverageTextureColour(myFloor.texture));
                    else
                        Graphics2D.fillRect(0, 0, 128, 128, myFloor.minimapColour);
                    break;
                case RT4P_OVERLAY:
                    if (myFloor.hdTexture != -1)
                        Rasterizer.textureImagesHD[myFloor.hdTexture].drawSprite(0,0);
                    else
                        Graphics2D.fillRect(0,0,128,128,myFloor.hdColour);
                    break;
                case RT4P_UNDERLAY:
                    if (myFloor.hdUlTexture != -1)
                        Rasterizer.textureImagesHD[myFloor.hdUlTexture].drawSprite(0,0);
                    else
                        Graphics2D.fillRect(0,0,128,128,myFloor.hdUlColour);
                    break;
            }
        else
            Graphics2D.fillRect(0, 0, 128, 128, 0xFF0000);
        GameShell.endGraphicsBlock();
        graphicsBuffer.drawGraphics(0,g,0);
    }

    public void setMyFloor(Floor myFloor) {
        this.myFloor = myFloor;
    }

    public void setMode(FloorPreviewMode mode) {
        this.mode = mode;
    }

    public FloorPreviewMode getMode() {
        return mode;
    }

    public Floor getMyFloor() {
        return myFloor;
    }

    /**
     * Created by IntelliJ IDEA.
     * User: Peter
     * Date: 6/24/11
     * Time: 7:24 PM
     * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
     */
    public static enum FloorPreviewMode {
        RT3_GAME,
        RT3_GAME_LD,
        RT3_MAP,
        RT4P_OVERLAY,
        RT4P_UNDERLAY
    }
}
