package rt4;

import org.lwjgl.BufferUtils;
import org.peterbjornx.pgl2.util.ServerMemoryManager;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL14.*;
import static org.lwjgl.opengl.GL15.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 8/1/11
 * Time: 11:53 AM
 * To change this template use File | Ssettings | File Templates.
 */
public class Class119 {
    public static int texturePointer2;
    public static int[] idBuffer = null;
    public static ByteBuffer textureData2;
    public static int texture3DPointer2 = -1;
    public static int[] textureIds2;
    public static boolean use3DTexture;

    public static void finalizeCard() {
        if (texture3DPointer2 != -1) {
            glDeleteTextures(texture3DPointer2);
            texture3DPointer2 = -1;
            ServerMemoryManager.textureMemory -= textureData2.limit() * 2;
        }
        if (textureIds2 != null) {
            glDeleteTextures(t(textureIds2));
            textureIds2 = null;
            ServerMemoryManager.textureMemory -= textureData2.limit() * 2;
        }
    }

    public static FloatBuffer t(float[] t){
        FloatBuffer tt = BufferUtils.createFloatBuffer(t.length);
        tt.put(t);
        tt.flip();
        return tt;
    }

    public static IntBuffer t(int[] t){
        IntBuffer tt = BufferUtils.createIntBuffer(t.length);
        tt.put(t);
        tt.flip();
        return tt;
    }

    public static void loadTexData2() {
        if (use3DTexture) {
            int[] is = new int[1];
            is[0] = glGenTextures();
            glBindTexture(32879, is[0]);
            textureData2.position(0);
            glTexImage3D(32879, 0, 6410, 128, 128, 32, 0, 6410, 5121, textureData2);
            glTexParameteri(32879, 10241, 9729);
            glTexParameteri(32879, 10240, 9729);
            texture3DPointer2 = is[0];
            ServerMemoryManager.textureMemory += textureData2.limit() * 2;
        } else {
            textureIds2 = new int[64];
            for (int i = 0;i < 64; i++)
                textureIds2[i] = glGenTextures();
            for (int i = 0; i < 64; i++) {
                OpenGLManager.bindtexture2d(textureIds2[i]);
                textureData2.position(i * 64 * 64 * 2);
                glTexImage2D(3553, 0,GL_LUMINANCE_ALPHA, 64, 64, 0, GL_LUMINANCE_ALPHA, 5121, textureData2);
                glTexParameteri(3553, 10241, 9729);
                glTexParameteri(3553, 10240, 9729);
            }
            ServerMemoryManager.textureMemory += textureData2.limit() * 2;
        }
    }

    public static void genetrateTextureData() {
        use3DTexture = OpenGLManager.has_texture_3d;
        if (textureData2 == null) {
            Class26_Sub2_Sub1 class26_sub2_sub1 = new Class26_Sub2_Sub1();
            byte[] is;
            if (use3DTexture)
                is = class26_sub2_sub1.method1033(128, 128, 32);
            else
                is = class26_sub2_sub1.method1033(64, 64, 64);
            textureData2 = ByteBuffer.allocateDirect(is.length);
            textureData2.position(0);
            textureData2.put(is);
            textureData2.flip();
        }
        loadTexData2();
    }

    public static void destroy() {
        textureIds2 = null;
        idBuffer = null;
        textureData2 = null;
    }

    static {
        texturePointer2 = -1;
        textureIds2 = null;
    }
}
