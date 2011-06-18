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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
            int rgb = Rasterizer.HSL2RGB[rsModel.triangleColours[triIdx]];
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
        if (triangleColours == null)
            updateColours();
        rsModel.calculateNormals();
        try {
            for (int triIdx = 0; triIdx < rsModel.triangleCount; triIdx++) {
                int verAIdx = rsModel.triangleA[triIdx];
                int verBIdx = rsModel.triangleB[triIdx];
                int verCIdx = rsModel.triangleC[triIdx];

                int bufAIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verAIdx], -rsModel.vertexY[verAIdx], rsModel.vertexZ[verAIdx])
                        , new Vector3f(rsModel.vertex[verAIdx].getX(), rsModel.vertex[verAIdx].getY(), rsModel.vertex[verAIdx].getZ())
                        , new Vector3f(0, 0, 0), triangleColours[triIdx]);
                int bufBIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verBIdx], -rsModel.vertexY[verBIdx], rsModel.vertexZ[verBIdx])
                        , new Vector3f(rsModel.vertex[verBIdx].getX(), rsModel.vertex[verBIdx].getY(), rsModel.vertex[verBIdx].getZ()),
                        new Vector3f(0, 0, 0), triangleColours[triIdx]);
                int bufCIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verCIdx], -rsModel.vertexY[verCIdx], rsModel.vertexZ[verCIdx])
                        , new Vector3f(rsModel.vertex[verCIdx].getX(), rsModel.vertex[verCIdx].getY(), rsModel.vertex[verCIdx].getZ()),
                        new Vector3f(0, 0, 0), triangleColours[triIdx]);
                List<Integer> polylist = new LinkedList<Integer>();
                polylist.add(bufAIdx);
                polylist.add(bufBIdx);
                polylist.add(bufCIdx);
                element.addPolygon(polylist);
            }
            rsModel.vertex = rsModel.vns;
        } catch (PglException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void render(){
        geometry.bind();
        element.bind();
        element.draw();
    }
}
