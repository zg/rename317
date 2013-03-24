package rs2.model.entity;

import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector3f;
import org.peterbjornx.pgl2.light.OpenGLLight;
import org.peterbjornx.pgl2.model.GeometryNode;
import pgle.PglModelNode;
import rs2.*;
import rs2.util.collection.QueueNode;

import java.util.HashMap;

public class Entity extends QueueNode {


    public void renderAtPoint(int i, int j, int k, int l, int i1, int x, int y,
            int z, int i2)
    {
        Model model = this instanceof Model ? (Model) this : getRotatedModel();
        if(model != null)
        {
            if (SceneGraph.USE_HD){
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
                    renderAtPoint(pgleNode,i,x,y,z);
                if (pgleNode != null && this instanceof Projectile){
                    setEffectLight(Rasterizer.hsl2rgb[model.triangleColourOrTexture[0]]);
                    effectLight.enable();
                    effectLight.loadValues();
                }
            }
            modelHeight = model.modelHeight;
            model.renderAtPoint2(i, j, k, l, i1, x, y, z, i2);
        }
    }

    private void renderAtPoint(GeometryNode root,int xRotLocal,int x,int y,int z){
        x+=SceneGraph.xCameraPosition;
        y+=SceneGraph.zCameraPosition;
        z+=SceneGraph.yCameraPosition;

        root.renderAtPoint(-(xRotLocal * 0.17578125f),0,0,0,x,-y,z);
    }

    public Model getRotatedModel()
    {
        return null;
    }

    public Entity()
    {
        modelHeight = 1000;
    }

    public static void cleanPglPool(){
        modelPool.clear();
    }

    public static void setEffectLight(int rgb){
            float r = (float)((rgb >> 16) & 0xff);
            float g = (float)((rgb >> 8)  & 0xff);
            float b = (float)( rgb        & 0xff);
            Color light0Colour = new Color((int)r,(int)g,(int)b);
            effectLight.setDiffuse(light0Colour);
            effectLight.setSpecular(light0Colour);
            effectLight.setAmbient(light0Colour);
    }

    public static OpenGLLight effectLight = new OpenGLLight();
    private int mismatchCounter = 0;
    private static HashMap<Model,PglModelNode> modelPool = new HashMap<Model, PglModelNode>();
    public VertexNormal[] vertexNormals;
    public int modelHeight;

    static {
        effectLight.setId(2);
        effectLight.setDirectional(false);
        effectLight.setPosition(new Vector3f(0,0,0));
    }
}
