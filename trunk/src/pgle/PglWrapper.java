package pgle;

import com.sun.rowset.internal.InsertRow;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.peterbjornx.pgl2.camera.Camera;
import org.peterbjornx.pgl2.input.cameracontrol.FirstPersonCamera;
import org.peterbjornx.pgl2.light.OpenGLLightManager;
import org.peterbjornx.pgl2.math.VectorMath;
import org.peterbjornx.pgl2.model.Node;
import org.peterbjornx.pgl2.terrain.Terrain;
import org.peterbjornx.pgl2.terrain.TerrainSource;
import org.peterbjornx.pgl2.util.ServerMemoryManager;
import rs2.MapRegion;
import rt4.Class7_Sub1;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/17/11
 * Time: 8:08 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class PglWrapper {

    public Node scene;
    protected Camera camera;
    private FirstPersonCamera firstPersonCamera;
    private Terrain rsTerrain;
    private boolean running = false;
    private RsTerrainSource rsTerrainSource;
    private RsTileManager rsTileManager;
    private OpenGLLightManager lightManager;
    private PglSun sun;
    private PglOverlayNode[] overlayNodes = new PglOverlayNode[4];

    public void initLighting(){
        glEnable(GL_COLOR_MATERIAL);
        glColorMaterial(GL_FRONT_AND_BACK, GL_AMBIENT_AND_DIFFUSE);
        glEnable(GL_LIGHTING);
        //lightManager = new OpenGLLightManager();
       // rsTileManager.setOpenGLLightManager(lightManager);

        sun = new PglSun();
        sun.setSunColor(new Color(0xFF, 0xFF, 0xFF, 0xff), 1.0F, 1.0F, 0.6F);
        sun.setSunPosition(new Vector3f(-30, -50, -30));
        glLightf(GL_LIGHT2, GL_CONSTANT_ATTENUATION, 1.0f);
        glLightf(GL_LIGHT2, GL_LINEAR_ATTENUATION, 0.0015625f/5f);
       glLightf(GL_LIGHT2, GL_QUADRATIC_ATTENUATION, 0);//.000625f);
    }

    /**
     * Initialize PGLEngine
     */
    public void initJgle() {
        try {
            int width = 640;
            int height = 480;
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
            scene = new Node();
            camera = new Camera();
            camera.setViewport(new Vector2f(0, 0), new Vector2f(width, height));
            camera.setNearClip(1f);
            camera.setFarClip(128 * 30.0f);
            camera.setActive(true);
            scene.add(camera);
            rsTileManager = new RsTileManager();
            scene.add(rsTileManager);
            firstPersonCamera = new FirstPersonCamera();
            glEnable(GL_DEPTH_TEST);
            if (Class7_Sub1.useLighting)
                initLighting();
            running = true;
        } catch (LWJGLException e) {

            e.printStackTrace();
            running = false;
            //System.exit(0);
        }
    }

    public void loadNewRegion(MapRegion mapRegion){
        if (rsTerrain != null)
            clearRegion();
        rsTerrainSource = new RsTerrainSource(mapRegion);
        rsTerrainSource.updateMap();
        rsTerrain = new Terrain(rsTerrainSource);
        scene.add(rsTerrain);
        for (int i = 0;i < 4;i++){
            overlayNodes[i] = new PglOverlayNode(mapRegion,i);
            scene.add(overlayNodes[i]);
        }
    }

    public void setCameraPosition(int x,int z,int y){
        camera.setPosition(new Vector3f(x,-y,z));
    }

    /**
     * The entry point for this SimpleApplication
     */
    public void process() {
        if (!running)
            return;
        if (!Display.isCloseRequested()) {
            try {
                Display.makeCurrent();
            } catch (LWJGLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            preRender();
           // lightManager.startLighting(new Camera());
            scene.render(null);
           // lightManager.stopLighting();
            try {
                Display.swapBuffers();
            } catch (LWJGLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            Display.processMessages();
            try {
                ServerMemoryManager.processQueues();
            } catch (Exception e){
                System.out.println("ServerMemoryManager exception :O");
            }
        } else {
            Display.destroy();
            System.err.println("Closing window");
            running = false;
        }

    }

    public void doLighting(){
        if (Class7_Sub1.useLighting)
            sun.activateNoManager();
    }

    public void preRender() {
        firstPersonCamera.handleInput(camera);
    }

    public RsTileManager getRsTileManager() {
        return rsTileManager;
    }

    public void clearRegion() {
        if (rsTerrain != null){
            scene.remove(rsTerrain);
            rsTerrain = null;
            rsTerrainSource = null;
            for (int i = 0;i < 4;i++)
                scene.remove(overlayNodes[i]);
        }
        System.gc();
    }

    public void doCamTransform() {
        camera.loadViewMatrix();
    }

    public void setCameraRotation(int xCameraCurve, int yCameraCurve, int i) {
        camera.setRotation(VectorMath.eulerAnglesToQuaternion(new Vector3f(xCameraCurve * 0.17578125f,yCameraCurve * 0.17578125f,i * 0.17578125f)));
    }
}
