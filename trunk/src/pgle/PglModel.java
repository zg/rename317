package pgle;

import org.lwjgl.opengl.ARBBufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector3f;
import org.peterbjornx.pgl2.buffer.ElementBuffer;
import org.peterbjornx.pgl2.buffer.GeometryBuffer;
import org.peterbjornx.pgl2.buffer.OpenGLBufferFactory;
import org.peterbjornx.pgl2.buffer.impl.ARBGeometryBuffer;
import org.peterbjornx.pgl2.buffer.impl.ArbElementBuffer;
import org.peterbjornx.pgl2.texture.Texture2D;
import org.peterbjornx.pgl2.util.PglException;
import rs2.Model;
import rs2.Rasterizer;
import rt4.Class7_Sub1;
import rt4.ModelRendererGL;
import rt4.TextureSource;

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
    private int[] textureTriangles;
    private int[] textureTypes;
    private static Texture2D[] textures = new Texture2D[50];
    private int currentTexture = -2;
    private int textureTriangleCount = 0;
    private int triangleCount = 0;
    private Vector3f[] texcoordA;
    private Vector3f[] texcoordB;
    private Vector3f[] texcoordC;
    private GeometryBuffer geometry;
    private ElementBuffer element;
    private static HashMap<Model,PglModel> modelCache = new HashMap<Model, PglModel>();
  //  private ModelRendererGL modelRendererGL;

    private PglModel(Model rsModel){

        this.rsModel = rsModel;
    }

    public static PglModel createPglModel(Model rsModel,boolean animated){
        PglModel model;
        if (textures[0] == null)
            for (int i = 0;i < 50;i++)
                textures[i] = getTexture(i);
        if (!animated){
            model = modelCache.get(rsModel);
            if (model != null)
                return model;
        }
        //System.out.println(rsModel);
        model = new PglModel(rsModel);
        model.addTriangles();
   //     model.modelRendererGL =new ModelRendererGL(rsModel,64,850,true);

        if (!animated)
            modelCache.put(rsModel, model);
        return model;
    }

    private void generateTexCoords(){
    	if(rsModel.triPIndex == null || rsModel.triPIndex.length == 0)
    	{//TODO:proper fix (whats causing this)
    		//System.outs.println("O NOESSSSS");
    		return;
    	}
//    	System.out.println(rsModel.triPIndex.length);
        texcoordA = new Vector3f[rsModel.triangleCount];
        texcoordB = new Vector3f[rsModel.triangleCount];
        texcoordC = new Vector3f[rsModel.triangleCount];
        for (int tri = 0;tri < rsModel.triangleCount;tri++){
            int sourceTexture = -1;
            int i_340_;
            float tcAU = 0.0F;
            float tcAV = 0.0F;
            float tcBU = 0.0F;
            float tcBV = 0.0F;
            float tcCU = 0.0F;
            float tcCV = 0.0F;
            int triangleDrawType;
            if (rsModel.triangleDrawType == null)
                triangleDrawType = 0;
            else
                triangleDrawType = rsModel.triangleDrawType[tri];
            if ((triangleDrawType & 2) == 2)
                sourceTexture = rsModel.triangleColourOrTexture[tri];
            i_340_ = triangleDrawType >> 2;
            if (sourceTexture != -1) {
                if (i_340_ == -1) {
                    tcAU = 0.0F;
                    tcAV = 1.0F;
                    tcBU = 1.0F;
                    tcBV = 1.0F;
                    tcCU = 0.0F;
                    tcCV = 0.0F;
                } else {
                    i_340_ &= 0xff;
                        int i_351_ = rsModel.triangleA[tri];
                        int i_352_ = rsModel.triangleB[tri];
                        int i_353_ = rsModel.triangleC[tri];
                        int pI = rsModel.triPIndex[i_340_];
                        int mI = rsModel.triMIndex[i_340_];
                        int nI = rsModel.triNIndex[i_340_];
                        float Px = (float) rsModel.vertexX[pI];
                        float Py = (float) rsModel.vertexY[pI];
                        float Pz = (float) rsModel.vertexZ[pI];
                        float f_360_ = (float) rsModel.vertexX[mI] - Px;
                        float f_361_ = (float) rsModel.vertexY[mI] - Py;
                        float f_362_ = (float) rsModel.vertexZ[mI] - Pz;
                        float f_363_ = (float) rsModel.vertexX[nI] - Px;
                        float f_364_ = (float) rsModel.vertexY[nI] - Py;
                        float f_365_ = (float) rsModel.vertexZ[nI] - Pz;
                        float f_366_ = (float) rsModel.vertexX[i_351_] - Px;
                        float f_367_ = (float) rsModel.vertexY[i_351_] - Py;
                        float f_368_ = (float) rsModel.vertexZ[i_351_] - Pz;
                        float f_369_ = (float) rsModel.vertexX[i_352_] - Px;
                        float f_370_ = (float) rsModel.vertexY[i_352_] - Py;
                        float f_371_ = (float) rsModel.vertexZ[i_352_] - Pz;
                        float f_372_ = (float) rsModel.vertexX[i_353_] - Px;
                        float f_373_ = (float) rsModel.vertexY[i_353_] - Py;
                        float f_374_ = (float) rsModel.vertexZ[i_353_] - Pz;
                        float f_375_ = f_361_ * f_365_ - f_362_ * f_364_;
                        float f_376_ = f_362_ * f_363_ - f_360_ * f_365_;
                        float f_377_ = f_360_ * f_364_ - f_361_ * f_363_;
                        float f_378_ = f_364_ * f_377_ - f_365_ * f_376_;
                        float f_379_ = f_365_ * f_375_ - f_363_ * f_377_;
                        float f_380_ = f_363_ * f_376_ - f_364_ * f_375_;
                        float f_381_ = 1.0F / (f_378_ * f_360_ + f_379_ * f_361_ + f_380_ * f_362_);
                        tcAU = (f_378_ * f_366_ + f_379_ * f_367_ + f_380_ * f_368_) * f_381_;
                        tcBU = (f_378_ * f_369_ + f_379_ * f_370_ + f_380_ * f_371_) * f_381_;
                        tcCU = (f_378_ * f_372_ + f_379_ * f_373_ + f_380_ * f_374_) * f_381_;
                        f_378_ = f_361_ * f_377_ - f_362_ * f_376_;
                        f_379_ = f_362_ * f_375_ - f_360_ * f_377_;
                        f_380_ = f_360_ * f_376_ - f_361_ * f_375_;
                        f_381_ = 1.0F / (f_378_ * f_363_ + f_379_ * f_364_ + f_380_ * f_365_);
                        tcAV = (f_378_ * f_366_ + f_379_ * f_367_ + f_380_ * f_368_) * f_381_;
                        tcBV = (f_378_ * f_369_ + f_379_ * f_370_ + f_380_ * f_371_) * f_381_;
                        tcCV = (f_378_ * f_372_ + f_379_ * f_373_ + f_380_ * f_374_) * f_381_;
                }
            }
            texcoordA[tri] = new Vector3f(tcAU,tcAV,0);
            texcoordB[tri] = new Vector3f(tcBU,tcBV,0);
            texcoordC[tri] = new Vector3f(tcCU,tcCV,0);
        }
    }

    private void addTriangles(){
        geometry = OpenGLBufferFactory.createGeometryBuffer(rsModel.triangleCount*3, false);
        element = OpenGLBufferFactory.createElementBuffer(rsModel.triangleCount, GL11.GL_TRIANGLES);
        textureTriangles = new int[rsModel.triangleCount];
        textureTypes = new int[rsModel.triangleCount];
        rsModel.vns = rsModel.vertexNormals;
        rsModel.calculateNormals508();
        rsModel.lightHD(64,850,-30,-50,-30,true);
        generateTexCoords();
        try{
            for (int triPtr = 0;triPtr < rsModel.triangleCount;triPtr++)
                addTriangle(triPtr);
        } catch (Exception e){
            e.printStackTrace();
        }
        rsModel.vertexNormals = rsModel.vns;
    }

    private void addTriangle(int triPtr) throws PglException {
        int triangleDrawType;
        if (rsModel.triangleDrawType == null)
            triangleDrawType = 0;
        else
            triangleDrawType = rsModel.triangleDrawType[triPtr] & 3;
        if (triangleDrawType == 0) {
            addTriangleShaded(triPtr);
            return;
        }
        if (triangleDrawType == 1) {
            addTriangleFlat(triPtr);
            return;
        }
        if (triangleDrawType == 2) {
            addTexTriangleShaded(triPtr);
            return;
        }
        if (triangleDrawType == 3) {
            addTexTriangleFlat(triPtr);
        }
    }

    private Color fromRgb(int rgb,int a){
        return new Color(rgb >> 16,rgb >> 8,rgb & 0xFF,a);
    }

    private void addTexTriangleFlat(int triIdx) throws PglException {
        int verAIdx = rsModel.triangleA[triIdx];
        int verBIdx = rsModel.triangleB[triIdx];
        int verCIdx = rsModel.triangleC[triIdx];
        int texture = rsModel.triangleColourOrTexture[triIdx];
        int alpha = rsModel.triangleAlpha==null ? 255 : (255 - rsModel.triangleAlpha[triIdx]);
        Vector3f normalT = new Vector3f(rsModel.triangleNormals[triIdx].x / 255.0f,-(rsModel.triangleNormals[triIdx].y / 255.0f),rsModel.triangleNormals[triIdx].z / 255.0f);
        Color colorT = Class7_Sub1.useLighting ? fromRgb(0x808080,alpha) : fromRgb(Rasterizer.hsl2rgb[rsModel.triangleHslA[triIdx]],alpha);
        int bufAIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verAIdx], -rsModel.vertexY[verAIdx], rsModel.vertexZ[verAIdx])
                        , normalT, texcoordA[triIdx], colorT);
        int bufBIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verBIdx], -rsModel.vertexY[verBIdx], rsModel.vertexZ[verBIdx])
                        , normalT, texcoordB[triIdx], colorT);
        int bufCIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verCIdx], -rsModel.vertexY[verCIdx], rsModel.vertexZ[verCIdx])
                        , normalT, texcoordC[triIdx], colorT);
        List<Integer> polylist = new LinkedList<Integer>();
        polylist.add(bufAIdx);
        polylist.add(bufBIdx);
        polylist.add(bufCIdx);
        element.addPolygon(polylist);
        if(currentTexture != texture){
            textureTypes[textureTriangleCount] = texture;
            textureTriangles[textureTriangleCount++] = triangleCount++;
            currentTexture = texture;
        } else
            triangleCount++;
    }

    private void addTexTriangleShaded(int triIdx) throws PglException {
        int verAIdx = rsModel.triangleA[triIdx];
        int verBIdx = rsModel.triangleB[triIdx];
        int verCIdx = rsModel.triangleC[triIdx];
        int alpha = rsModel.triangleAlpha==null ? 255 : (255 - rsModel.triangleAlpha[triIdx]);
        Vector3f normalA = new Vector3f(rsModel.vertexNormals[verAIdx].getX(), rsModel.vertexNormals[verAIdx].getY(), rsModel.vertexNormals[verAIdx].getZ());
        Vector3f normalB = new Vector3f(rsModel.vertexNormals[verBIdx].getX(), rsModel.vertexNormals[verBIdx].getY(), rsModel.vertexNormals[verBIdx].getZ());
        Vector3f normalC = new Vector3f(rsModel.vertexNormals[verCIdx].getX(), rsModel.vertexNormals[verCIdx].getY(), rsModel.vertexNormals[verCIdx].getZ());
        Color colorT = fromRgb(0x808080,alpha);
        Color colorA = Class7_Sub1.useLighting ? colorT : fromRgb(Rasterizer.hsl2rgb[rsModel.triangleHslA[triIdx]],alpha);
        Color colorB = Class7_Sub1.useLighting ? colorT : fromRgb(Rasterizer.hsl2rgb[rsModel.triangleHslB[triIdx]],alpha);
        Color colorC = Class7_Sub1.useLighting ? colorT : fromRgb(Rasterizer.hsl2rgb[rsModel.triangleHslC[triIdx]],alpha);
        int texture = rsModel.triangleColourOrTexture[triIdx];

        int bufAIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verAIdx], -rsModel.vertexY[verAIdx], rsModel.vertexZ[verAIdx])
                        , normalA, texcoordA[triIdx], colorA);
        int bufBIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verBIdx], -rsModel.vertexY[verBIdx], rsModel.vertexZ[verBIdx])
                        , normalB, texcoordB[triIdx], colorB);
        int bufCIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verCIdx], -rsModel.vertexY[verCIdx], rsModel.vertexZ[verCIdx])
                        , normalC, texcoordC[triIdx], colorC);
        List<Integer> polylist = new LinkedList<Integer>();
        polylist.add(bufAIdx);
        polylist.add(bufBIdx);
        polylist.add(bufCIdx);
        element.addPolygon(polylist);
        if(currentTexture != texture){
            textureTypes[textureTriangleCount] = texture;
            textureTriangles[textureTriangleCount++] = triangleCount++;
            currentTexture = texture;
        } else
            triangleCount++;
    }

    private void addTriangleFlat(int triIdx) throws PglException {
        int verAIdx = rsModel.triangleA[triIdx];
        int verBIdx = rsModel.triangleB[triIdx];
        int verCIdx = rsModel.triangleC[triIdx];
        int alpha = rsModel.triangleAlpha==null ? 255 : (255 - rsModel.triangleAlpha[triIdx]);
        Vector3f normalT = new Vector3f(rsModel.triangleNormals[triIdx].x / 255.0f,-(rsModel.triangleNormals[triIdx].y / 255.0f),rsModel.triangleNormals[triIdx].z / 255.0f);
        Color colorT = Class7_Sub1.useLighting ? fromRgb(Rasterizer.hsl2rgb[rsModel.triangleColourOrTexture[triIdx]],alpha) : fromRgb(Rasterizer.hsl2rgb[rsModel.triangleHslA[triIdx]],alpha);
        int bufAIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verAIdx], -rsModel.vertexY[verAIdx], rsModel.vertexZ[verAIdx])
                        , normalT, new Vector3f(0, 0, 0), colorT);
        int bufBIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verBIdx], -rsModel.vertexY[verBIdx], rsModel.vertexZ[verBIdx])
                        , normalT, new Vector3f(0, 0, 0), colorT);
        int bufCIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verCIdx], -rsModel.vertexY[verCIdx], rsModel.vertexZ[verCIdx])
                        , normalT, new Vector3f(0, 0, 0), colorT);
        List<Integer> polylist = new LinkedList<Integer>();
        polylist.add(bufAIdx);
        polylist.add(bufBIdx);
        polylist.add(bufCIdx);
        element.addPolygon(polylist);
        if(currentTexture != -1){
            textureTypes[textureTriangleCount] = -1;
            textureTriangles[textureTriangleCount++] = triangleCount++;
            currentTexture = -1;
        } else
            triangleCount++;
    }

    private void addTriangleShaded(int triIdx) throws PglException {
        int verAIdx = rsModel.triangleA[triIdx];
        int verBIdx = rsModel.triangleB[triIdx];
        int verCIdx = rsModel.triangleC[triIdx];
        int alpha = rsModel.triangleAlpha==null ? 255 : (255 - rsModel.triangleAlpha[triIdx]);
        Vector3f normalA = new Vector3f(rsModel.vertexNormals[verAIdx].getX(), -rsModel.vertexNormals[verAIdx].getY(), rsModel.vertexNormals[verAIdx].getZ());
        Vector3f normalB = new Vector3f(rsModel.vertexNormals[verBIdx].getX(), -rsModel.vertexNormals[verBIdx].getY(), rsModel.vertexNormals[verBIdx].getZ());
        Vector3f normalC = new Vector3f(rsModel.vertexNormals[verCIdx].getX(), -rsModel.vertexNormals[verCIdx].getY(), rsModel.vertexNormals[verCIdx].getZ());
        Color colorT = fromRgb(Rasterizer.hsl2rgb[rsModel.triangleColourOrTexture[triIdx]],alpha);
        Color colorA = Class7_Sub1.useLighting ? colorT : fromRgb(Rasterizer.hsl2rgb[rsModel.triangleHslA[triIdx]],alpha);
        Color colorB = Class7_Sub1.useLighting ? colorT : fromRgb(Rasterizer.hsl2rgb[rsModel.triangleHslB[triIdx]],alpha);
        Color colorC = Class7_Sub1.useLighting ? colorT : fromRgb(Rasterizer.hsl2rgb[rsModel.triangleHslC[triIdx]],alpha);
        int bufAIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verAIdx], -rsModel.vertexY[verAIdx], rsModel.vertexZ[verAIdx])
                        , normalA, new Vector3f(0, 0, 0), colorA);
        int bufBIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verBIdx], -rsModel.vertexY[verBIdx], rsModel.vertexZ[verBIdx])
                        , normalB, new Vector3f(0, 0, 0), colorB);
        int bufCIdx = geometry.addVertex(
                        new Vector3f(rsModel.vertexX[verCIdx], -rsModel.vertexY[verCIdx], rsModel.vertexZ[verCIdx])
                        , normalC, new Vector3f(0, 0, 0), colorC);
        List<Integer> polylist = new LinkedList<Integer>();
        polylist.add(bufAIdx);
        polylist.add(bufBIdx);
        polylist.add(bufCIdx);
        element.addPolygon(polylist);
        if(currentTexture != -1){
            textureTypes[textureTriangleCount] = -1;
            textureTriangles[textureTriangleCount++] = triangleCount++;
            currentTexture = -1;
        } else
            triangleCount++;
    }

     public static Texture2D getTexture(int id) {
        return new Texture2D("./hddata/texture/" + id + ".png",false,GL11.GL_LINEAR,new int[]{255,0,255});
    }

    public void render(){
       // modelRendererGL.render();
       // if (1==1)return;
      //TODO FIX LWJGL stupid 2.8.3 buffer checks *RAGE*
        
        textures[0].bind();
        geometry.bind();
        element.bind();
        for (int tID = 0; tID < textureTriangleCount; tID++){
            int startTriangle = textureTriangles[tID];
            int endTriangle = 0;
            int texture = textureTypes[tID];
            if (texture == -1)
                GL11.glDisable(GL11.GL_TEXTURE_2D);
            else {
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                if(texture > 50)
                    texture = 0;
                textures[texture].bind();
            }
            if (tID == textureTriangleCount - 1)
                endTriangle = triangleCount;
            else
                endTriangle = textureTriangles[tID+1];
            if (element instanceof ArbElementBuffer){
                GL11.glDrawElements(4, (endTriangle - startTriangle) * 3, 5125, (long) (startTriangle * 12));
            } else {
                ;
            }
        }
    }
    static {
    }
}
