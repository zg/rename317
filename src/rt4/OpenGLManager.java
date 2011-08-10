package rt4;

import java.nio.ByteOrder;

import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.opengl.GL13.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/20/11
 * Time: 12:09 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class OpenGLManager {
    public static boolean has_vbo = true;//GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
    public static boolean byte_order_bigendian = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN; //Set this to true for some exotic architectures
    public static boolean aBoolean2051 = has_vbo;
    public static boolean has_texture_3d = false;
    private static int bound_texture_2d = -1;

    public static void bindtexture2d(int arg0) {
        //if (arg0 != bound_texture_2d) {
            if (arg0 != -1) {
                if (bound_texture_2d == -1)
                    glEnable(3553);
                glBindTexture(3553, arg0);
            } else
                glDisable(3553);
            bound_texture_2d = arg0;
       // }
    }
    
    public static void loadGLDefaults() {
        if (!has_texture_3d)
            return;
        glDisable(GL_TEXTURE_2D);
        glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_COMBINE);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_MODULATE);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_MODULATE);
        glEnable(GL_LIGHTING);
        glEnable(GL_FOG);
        glEnable(GL_DEPTH_TEST);
        glActiveTexture(GL_TEXTURE1);
        glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_COMBINE);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_MODULATE);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_MODULATE);
        glActiveTexture(GL_TEXTURE0);
        glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        glShadeModel(GL_SMOOTH);
        glClearDepth(1.0);
        glDepthFunc(GL_LEQUAL);
        glMatrixMode(GL_TEXTURE);
        glLoadIdentity();
        glPolygonMode(GL_FRONT, GL_FILL);
        //glEnable(2884);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_ALPHA_TEST);
        glAlphaFunc(GL_GREATER, 0.0F);
        glEnableClientState(GL_VERTEX_ARRAY);
        glEnableClientState(GL_NORMAL_ARRAY);
        glEnableClientState(32886);
        glEnableClientState(32888);
        glMatrixMode(5888);
        glLoadIdentity();
    }
}
