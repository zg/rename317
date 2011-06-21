package pgle;

import org.peterbjornx.pgl2.camera.Camera;
import org.peterbjornx.pgl2.model.GeometryNode;
import rs2.SceneGraph;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/21/11
 * Time: 9:51 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class PglCallClientNode extends GeometryNode{

    @Override
    protected void renderGeometry(Camera camera) {
        SceneGraph.clientInstance.renderscene();
    }
}
