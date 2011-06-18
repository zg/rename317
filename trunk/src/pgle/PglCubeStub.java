package pgle;

import org.peterbjornx.pgl2.camera.Camera;
import org.peterbjornx.pgl2.model.GeometryNode;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/18/11
 * Time: 1:46 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class PglCubeStub extends GeometryNode {
    @Override
    protected void renderGeometry(Camera camera) {
        glPushMatrix();
        glScalef(64,64,64);
        glBegin(GL_QUADS);
            glColor3f(0.0f, 1.0f, 0.0f);            // Set The Color To Green
            glVertex3f(1.0f, 1.0f, -1.0f);            // Top Right Of The Quad (Top)
            glVertex3f(-1.0f, 1.0f, -1.0f);            // Top Left Of The Quad (Top)
            glVertex3f(-1.0f, 1.0f, 1.0f);            // Bottom Left Of The Quad (Top)
            glVertex3f(1.0f, 1.0f, 1.0f);            // Bottom Right Of The Quad (Top)               1

            glColor3f(1.0f, 0.5f, 0.0f);            // Set The Color To Orange               2
            glVertex3f(1.0f, -1.0f, 1.0f);            // Top Right Of The Quad (Bottom)
            glVertex3f(-1.0f, -1.0f, 1.0f);            // Top Left Of The Quad (Bottom)
            glVertex3f(-1.0f, -1.0f, -1.0f);            // Bottom Left Of The Quad (Bottom)
            glVertex3f(1.0f, -1.0f, -1.0f);            // Bottom Right Of The Quad (Bottom)

            glColor3f(1.0f, 0.0f, 0.0f);            // Set The Color To Red
            glVertex3f(1.0f, 1.0f, 1.0f);            // Top Right Of The Quad (Front)         3
            glVertex3f(-1.0f, 1.0f, 1.0f);            // Top Left Of The Quad (Front)
            glVertex3f(-1.0f, -1.0f, 1.0f);            // Bottom Left Of The Quad (Front)
            glVertex3f(1.0f, -1.0f, 1.0f);            // Bottom Right Of The Quad (Front)

            glColor3f(1.0f, 1.0f, 0.0f);            // Set The Color To Yellow
            glVertex3f(1.0f, -1.0f, -1.0f);            // Bottom Left Of The Quad (Back)
            glVertex3f(-1.0f, -1.0f, -1.0f);            // Bottom Right Of The Quad (Back)     4
            glVertex3f(-1.0f, 1.0f, -1.0f);            // Top Right Of The Quad (Back)
            glVertex3f(1.0f, 1.0f, -1.0f);            // Top Left Of The Quad (Back)

            glColor3f(0.0f, 0.0f, 1.0f);            // Set The Color To Blue
            glVertex3f(-1.0f, 1.0f, 1.0f);            // Top Right Of The Quad (Left)
            glVertex3f(-1.0f, 1.0f, -1.0f);            // Top Left Of The Quad (Left)          5
            glVertex3f(-1.0f, -1.0f, -1.0f);            // Bottom Left Of The Quad (Left)
            glVertex3f(-1.0f, -1.0f, 1.0f);            // Bottom Right Of The Quad (Left)

            glColor3f(1.0f, 0.0f, 1.0f);            // Set The Color To Violet
            glVertex3f(1.0f, 1.0f, -1.0f);            // Top Right Of The Quad (Right)
            glVertex3f(1.0f, 1.0f, 1.0f);            // Top Left Of The Quad (Right)            6
            glVertex3f(1.0f, -1.0f, 1.0f);            // Bottom Left Of The Quad (Right)
            glVertex3f(1.0f, -1.0f, -1.0f);            // Bottom Right Of The Quad (Right)
        glEnd();
        glPopMatrix();
    }
}
