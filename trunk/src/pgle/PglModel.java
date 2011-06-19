package pgle;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector3f;
import org.peterbjornx.pgl2.buffer.ElementBuffer;
import org.peterbjornx.pgl2.buffer.GeometryBuffer;
import org.peterbjornx.pgl2.buffer.OpenGLBufferFactory;
import org.peterbjornx.pgl2.util.PglException;
import rs2.Model;
import rs2.Rasterizer;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/18/11
 * Time: 8:44 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class PglModel {
    private Model rsModel;
    private Color[] triangleColours;
    private GeometryBuffer geometry;
    private ElementBuffer element;
    private GeometryBuffer geometryN;
    private ElementBuffer elementN;
    private static HashMap<Model,PglModel> modelCache = new HashMap<Model, PglModel>();

    private PglModel(Model rsModel){
        this.rsModel = rsModel;
    }

    public static PglModel createPglModel(Model rsModel,boolean animated){
        PglModel model;
        if (!animated){
            model = modelCache.get(rsModel);
            if (model != null)
                return model;
        }
        model = new PglModel(rsModel);
        model.createBuffers();
        if (!animated)
            modelCache.put(rsModel,model);
        return model;
    }

    public void updateColours() {
        triangleColours = new Color[rsModel.triangleCount];
        for (int triIdx = 0; triIdx < rsModel.triangleCount; triIdx++) {
            int rgb = Rasterizer.hsl2rgb[rsModel.triangleColour[triIdx]];
            triangleColours[triIdx] = new Color(rgb >> 16, rgb >> 8, rgb & 0xFF);
        }
    }

    public void createBuffers() {     //TODO: Generate normals
        if (geometry != null) {
            geometry = null;
            element = null;
        }
        geometry = OpenGLBufferFactory.createGeometryBuffer(rsModel.triangleCount*3, false);
        element = OpenGLBufferFactory.createElementBuffer(rsModel.triangleCount, GL11.GL_TRIANGLES);
//        geometryN = OpenGLBufferFactory.createGeometryBuffer(rsModel.triangleCount*6, false);
//        elementN = OpenGLBufferFactory.createElementBuffer(rsModel.triangleCount*3, GL11.GL_LINES);
        if (triangleColours == null)
            updateColours();
        rsModel.calculateNormals();
        try {
            for (int triIdx = 0; triIdx < rsModel.triangleCount; triIdx++) {
                int verAIdx = rsModel.triangleA[triIdx];
                int verBIdx = rsModel.triangleB[triIdx];
                int verCIdx = rsModel.triangleC[triIdx];
                Vector3f normalA = new Vector3f(rsModel.vertexNormals[verAIdx].getX(), rsModel.vertexNormals[verAIdx].getY(), rsModel.vertexNormals[verAIdx].getZ());
                Vector3f normalB = new Vector3f(rsModel.vertexNormals[verBIdx].getX(), rsModel.vertexNormals[verBIdx].getY(), rsModel.vertexNormals[verBIdx].getZ());
                Vector3f normalC = new Vector3f(rsModel.vertexNormals[verCIdx].getX(), rsModel.vertexNormals[verCIdx].getY(), rsModel.vertexNormals[verCIdx].getZ());
                Vector3f normalT = new Vector3f(rsModel.triangleNormalX[triIdx] / 256.0f,(rsModel.triangleNormalY[triIdx] / 256.0f),rsModel.triangleNormalZ[triIdx] / 256.0f);
                Color nC = new Color(255,0,255);
                int bufAIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verAIdx], -rsModel.vertexY[verAIdx], rsModel.vertexZ[verAIdx])
                        , normalT
                        , new Vector3f(0, 0, 0), triangleColours[triIdx]);
                int bufBIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verBIdx], -rsModel.vertexY[verBIdx], rsModel.vertexZ[verBIdx])
                        , normalT,
                        new Vector3f(0, 0, 0), triangleColours[triIdx]);
                int bufCIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verCIdx], -rsModel.vertexY[verCIdx], rsModel.vertexZ[verCIdx])
                        , normalT,
                        new Vector3f(0, 0, 0), triangleColours[triIdx]);
/**
                int nAIdx = geometryN.addVertex(
                        new Vector3f(rsModel.vertexX[verAIdx], -rsModel.vertexY[verAIdx], rsModel.vertexZ[verAIdx])
                        , normalT
                        , new Vector3f(0, 0, 0), nC);
                int nAIdx1 = geometryN.addVertex(
                        Vector3f.add(new Vector3f(rsModel.vertexX[verAIdx], -rsModel.vertexY[verAIdx], rsModel.vertexZ[verAIdx]),normalT,null)
                        , normalT
                        , new Vector3f(0, 0, 0), nC);
                int nBIdx = geometryN.addVertex(
                        new Vector3f(rsModel.vertexX[verBIdx], -rsModel.vertexY[verBIdx], rsModel.vertexZ[verBIdx])
                        , normalT
                        , new Vector3f(0, 0, 0), nC);
                int nBIdx1 = geometryN.addVertex(
                        Vector3f.add(new Vector3f(rsModel.vertexX[verBIdx], -rsModel.vertexY[verBIdx], rsModel.vertexZ[verBIdx]),normalT,null)
                        , normalA
                        , new Vector3f(0, 0, 0), nC);
                int nCIdx = geometryN.addVertex(
                        new Vector3f(rsModel.vertexX[verBIdx], -rsModel.vertexY[verBIdx], rsModel.vertexZ[verBIdx])
                        , normalB
                        , new Vector3f(0, 0, 0), nC);
                int nCIdx1 = geometryN.addVertex(
                        Vector3f.add(new Vector3f(rsModel.vertexX[verCIdx], -rsModel.vertexY[verCIdx], rsModel.vertexZ[verCIdx]),normalT,null)
                        , normalC
                        , new Vector3f(0, 0, 0), nC);     **/
                List<Integer> polylist = new LinkedList<Integer>();
                polylist.add(bufAIdx);
                polylist.add(bufBIdx);
                polylist.add(bufCIdx);
                element.addPolygon(polylist);
                /*polylist.clear();
                polylist.add(nAIdx);
                polylist.add(nAIdx1);
                elementN.addPolygon(polylist);
                polylist.clear();
                polylist.add(nBIdx);
                polylist.add(nBIdx1);
                elementN.addPolygon(polylist);
                polylist.clear();
                polylist.add(nCIdx);
                polylist.add(nCIdx1);
                elementN.addPolygon(polylist);   */
            }
            rsModel.vertexNormals = rsModel.vns;
        } catch (PglException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void render(){
        GL11.glDisableClientState(GL11.GL_NORMAL_ARRAY);
        GL11.glEnable(GL11.GL_AUTO_NORMAL);
        geometry.bind();
        element.bind();
        element.draw();
       // geometryN.bind();
       // elementN.bind();
       // elementN.draw();
    }
}
