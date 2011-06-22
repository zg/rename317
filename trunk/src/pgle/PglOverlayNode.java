package pgle;

import org.peterbjornx.pgl2.camera.Camera;
import org.peterbjornx.pgl2.model.GeometryNode;
import rs2.MapRegion;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/22/11
 * Time: 11:44 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class PglOverlayNode extends GeometryNode{
    private PglTerrainOverlay overlay;

    public PglOverlayNode(MapRegion map,int hl){
        overlay = new PglTerrainOverlay(map,hl);
    }

    @Override
    protected void renderGeometry(Camera camera) {
        overlay.render();
    }
}
