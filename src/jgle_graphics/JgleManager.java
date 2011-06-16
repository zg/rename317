package jgle_graphics;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.vector.Vector2f;
import org.peterbjornx.pgl2.camera.Camera;
import org.peterbjornx.pgl2.model.Node;
import org.peterbjornx.pgl2.util.ServerMemoryManager;

import static org.lwjgl.opengl.GL11.*;
/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/17/11
 * Time: 12:38 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class JgleManager {

    protected Node scene;
    protected Camera camera;
    private boolean running = false;

    /**
     * Initialize PGLEngine
     */
    public void initJgle() {
        try {
            int width = 640;
            int height =  480;
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
            scene = new Node();
            camera = new Camera();
            camera.setViewport(new Vector2f(0, 0), new Vector2f(width, height));
            camera.setNearClip(1f);
            camera.setFarClip(128*30.0f);
            camera.setActive(true);
            scene.add(camera);
            glEnable(GL_DEPTH_TEST);
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * The entry point for this SimpleApplication
     */
    protected void process(){
        if (!running)
            return;
        if (!Display.isCloseRequested()) {
            preRender();
            scene.render(null);
            Display.update();
            ServerMemoryManager.processQueues();
        } else {
            Display.destroy();
            running = false;
        }
    }

    private void preRender() {
        //To change body of created methods use File | Settings | File Templates.
    }

}
