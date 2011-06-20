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
import org.peterbjornx.pgl2.model.Node;
import org.peterbjornx.pgl2.terrain.Terrain;
import org.peterbjornx.pgl2.terrain.TerrainSource;
import org.peterbjornx.pgl2.util.ServerMemoryManager;
import rs2.MapRegion;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/17/11
 * Time: 8:08 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class PglWrapper {

    protected Node scene;
    protected Camera camera;
    private FirstPersonCamera firstPersonCamera;
    private Terrain rsTerrain;
    private boolean running = false;
    private RsTerrainSource rsTerrainSource;
    private RsTileManager rsTileManager;
    private OpenGLLightManager lightManager;
    private PglSun sun;

    public void initLighting(){
        glEnable(GL_COLOR_MATERIAL);
        glColorMaterial(GL_FRONT_AND_BACK, GL_AMBIENT_AND_DIFFUSE);
        glEnable(GL_LIGHTING);
        lightManager = new OpenGLLightManager();
        rsTileManager.setOpenGLLightManager(lightManager);
        sun = new PglSun();
        sun.setSunColor(new Color(0xFF,0xFF,0xFF,0xff),0.69921875F,1.0F,0.4F);
        sun.setSunPosition(new Vector3f(-30, -50, -30));
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
        //    initLighting();
            running = true;
        } catch (LWJGLException e) {

            e.printStackTrace();
            running = false;
            //System.exit(0);
        }
    }

    public void loadNewRegion(MapRegion mapRegion){
        if (rsTerrain == null){
            rsTerrainSource = new RsTerrainSource(mapRegion);
            rsTerrainSource.updateMap();
            rsTerrain = new Terrain(rsTerrainSource);
            scene.add(rsTerrain);
        } else {
            rsTerrainSource.updateMap();
            rsTerrain.update();

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
            ServerMemoryManager.processQueues();
        } else {
            Display.destroy();
            System.err.println("Closing window");
            running = false;
        }
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
        }
        rsTileManager.clear();
        System.gc();
    }
}
