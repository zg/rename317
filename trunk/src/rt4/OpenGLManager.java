package rt4;

import org.lwjgl.opengl.GLContext;

import java.nio.ByteOrder;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/20/11
 * Time: 12:09 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class OpenGLManager {
    public static boolean has_vbo = false;//GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
    public static boolean byte_order_bigendian = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN; //Set this to true for some exotic architectures
    public static boolean aBoolean2051 = has_vbo;
}
