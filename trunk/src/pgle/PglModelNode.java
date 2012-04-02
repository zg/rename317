package pgle;

import org.peterbjornx.pgl2.camera.Camera;
import org.peterbjornx.pgl2.model.GeometryNode;
import rs2.Model;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/18/11
 * Time: 9:08 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class PglModelNode extends GeometryNode{
    private PglModel model;

    public PglModelNode(Model model, boolean animated){
        this.model = PglModel.createPglModel(model,animated);
    }

    @Override
    protected void renderGeometry(Camera camera) {
    	try{
        model.render();
    	}catch(Exception e){e.printStackTrace();}
    }
}
