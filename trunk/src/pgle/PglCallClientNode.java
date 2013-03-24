package pgle;

import org.lwjgl.opengl.GL11;
import org.peterbjornx.pgl2.camera.Camera;
import org.peterbjornx.pgl2.model.GeometryNode;
import rs2.model.entity.Entity;
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
        SceneGraph.clientInstance.getPglWrapper().doLighting();
        if (Entity.effectLight != null)
            Entity.effectLight.disable();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1f);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        SceneGraph.clientInstance.renderscene();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
    }
}
