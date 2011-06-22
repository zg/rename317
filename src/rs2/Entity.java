package rs2;

import org.peterbjornx.pgl2.model.GeometryNode;
import pgle.PglModel;
import pgle.PglModelNode;

import java.awt.color.ICC_ColorSpace;
import java.util.HashMap;

public class Entity extends NodeSub {


    public void renderAtPoint(int i, int j, int k, int l, int i1, int j1, int k1,
            int l1, int i2)
    {
        Model model = this instanceof Model ? (Model) this : getRotatedModel();
        if(model != null)
        {
            PglModelNode pgleNode = modelPool.get(model);
            if (pgleNode == null){
                mismatchCounter++;
                if (mismatchCounter == 5000 && modelPool.size() >= 10000){
                    mismatchCounter = 0;
                    modelPool.clear();
                }
                pgleNode = new PglModelNode(model,true);
                modelPool.put(model,pgleNode);
            }
            if (pgleNode != null)
                renderAtPoint(pgleNode,i,j1,k1,l1);
            modelHeight = model.modelHeight;
            model.renderAtPoint2(i, j, k, l, i1, j1, k1, l1, i2);
        }
    }

    private void renderAtPoint(GeometryNode root,int xRotLocal,int x,int y,int z){
        x+=SceneGraph.xCameraPosition;
        y+=SceneGraph.zCameraPosition;
        z+=SceneGraph.yCameraPosition;
        root.renderAtPoint(-(xRotLocal * 0.17578125f),0,0,0,x,-y,z);
    }

    Model getRotatedModel()
    {
        return null;
    }

    Entity()
    {
        modelHeight = 1000;
    }
    private int mismatchCounter = 0;
    private static HashMap<Model,PglModelNode> modelPool = new HashMap<Model, PglModelNode>();
    public VertexNormal[] vertexNormals;
    public int modelHeight;
}
