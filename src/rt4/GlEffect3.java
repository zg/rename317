package rt4;

import org.lwjgl.BufferUtils;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL14.*;
import static org.lwjgl.opengl.GL15.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 8/1/11
 * Time: 11:42 AM
 * To change this template use File | Ssettings | File Templates.
 */
public class GlEffect3 {
    public static int translateX = 6336;
    public static int translateY = -1192;
    public static int translateZ = 6720;
    public static int rotateY = 1812;
    public static int rotateX = 128;
    public int gradientAlpha = -1;
    public static boolean texture1or2 = false;
    public int listPointer;
    public float[] texGenParameters = new float[4];

    public static void setTextureMatrix(int arg0, int z, byte arg2, int arg3, int arg4, int arg5) {
        try {
            rotateY = arg5;
            translateX = arg3;
            translateZ = z;
            rotateX = arg0;
            translateY = arg4;
        } catch (RuntimeException runtimeexception) {

            throw ErrorHandling.method554(runtimeexception, ("se.GA(" + arg0 + ',' + z + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + arg5 + ')'));
        }
    }

    public static FloatBuffer t(float[] t){
        FloatBuffer tt = BufferUtils.createFloatBuffer(t.length);
        tt.put(t);
        tt.flip();
        return tt;
    }

    public void setup(int parameter) {
        glActiveTexture(33985);
        if (texture1or2 || parameter >= 0) {
            glPushMatrix();
            glLoadIdentity();
            glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
            glRotatef((float) rotateX * 360.0F / 2048.0F, 1.0F, 0.0F, 0.0F);
            glRotatef(((float) rotateY * 360.0F / 2048.0F), 0.0F, 1.0F, 0.0F);
            glTranslatef((float) -translateX, (float) -translateY, (float) -translateZ);
            System.err.println("RX:"+rotateX+" RY:"+rotateY+" TX:"+translateX+" TY:"+translateY+" TZ"+translateZ);
            if (texture1or2) {
                texGenParameters[0] = 0.0010F;
                texGenParameters[1] = 9.0E-4F;
                texGenParameters[2] = 0.0F;
                texGenParameters[3] = 0.0F;
                glTexGen(8192, 9474, t(texGenParameters));
                texGenParameters[0] = 0.0F;
                texGenParameters[1] = 9.0E-4F;
                texGenParameters[2] = 0.0010F;
                texGenParameters[3] = 0.0F;
                glTexGen(8193, 9474, t(texGenParameters));
                texGenParameters[0] = 0.0F;
                texGenParameters[1] = 0.0F;
                texGenParameters[2] = 0.0F;
                texGenParameters[3] = (float) 107 * 0.01F;
                glTexGen(8194, 9474, t(texGenParameters));
                glActiveTexture(33986);
            }
            glTexEnv(8960, 8705, t(LightingShit.method1590(false)));
            if (parameter >= 0) {
                texGenParameters[0] = 0.0F;
                texGenParameters[1] = 1.0F / 128;
                texGenParameters[2] = 0.0F;
                texGenParameters[3] = 1.0F * (float) parameter / (float) 128;
                glTexGen(8192, 9474, t(texGenParameters));
                glEnable(3168);
            } else
                glDisable(3168);
            glPopMatrix();
        } else
            glDisable(3168);
        glActiveTexture(33984);
    }

    public void disable() {
        glCallList(listPointer + 1);
    }

    public static void enableTexCoordArray() {
        glClientActiveTexture(getActiveTexture());
        glEnableClientState(32888);
        glClientActiveTexture(33984);
    }

    public static void disableTexCoordArray() {
        glClientActiveTexture(getActiveTexture());
        glDisableClientState(32888);
        glClientActiveTexture(33984);
    }

    public void enable() {
        glCallList(listPointer);
    }
    public int getTextureParameters() {
        return 0;
    }

    public static int getActiveTexture() {
        return texture1or2 ? 33986 : 33985;
    }

    public void createLists() {
        listPointer = glGenLists(2);
        glNewList(listPointer, 4864);
            glActiveTexture(33985);
            if (texture1or2) {
                glBindTexture(32879, Class119.texture3DPointer2);
                glTexEnvi(8960, 34161, 260);
                glTexEnvi(8960, 34192, 768);
                glTexEnvi(8960, 34162, 7681);
                glTexEnvi(8960, 34184, 34168);
                glTexGeni(8192, 9472, 9216);    //s
                glTexGeni(8194, 9472, 9216);    //r
                glTexGeni(8193, 9472, 9216);    //t
                glTexGeni(8195, 9472, 9217);    //q
                glTexGen(8195, 9473, t(new float[]{0.0F, 0.0F, 0.0F, 1.0F}));
                glEnable(3168);
                glEnable(3169);
                glEnable(3170);
                glEnable(3171);
                glEnable(32879);
                glActiveTexture(33986);
                glTexEnvi(8960, 8704, 34160);
            }
            glBindTexture(3552, gradientAlpha);
            glTexEnvi(8960, 34161, 34165);
            glTexEnvi(8960, 34176, 34166);
            glTexEnvi(8960, 34178, 5890);
            glTexEnvi(8960, 34162, 7681);
            glTexEnvi(8960, 34184, 34168);
            glTexGeni(8192, 9472, 9216);
            glEnable(3552);
            glEnable(3168);
            glActiveTexture(33984);
        glEndList();
        glNewList(listPointer + 1, 4864);
            glActiveTexture(33985);
            if (texture1or2) {
                glTexEnvi(8960, 34161, 8448);
                glTexEnvi(8960, 34192, 768);
                glTexEnvi(8960, 34162, 8448);
                glTexEnvi(8960, 34184, 5890);
                glDisable(3168);
                glDisable(3169);
                glDisable(3170);
                glDisable(3171);
                glDisable(32879);
                glActiveTexture(33986);
                glTexEnvi(8960, 8704, 8448);
            }
            glTexEnv(8960, 8705, t(new float[]{0.0F, 1.0F, 0.0F, 1.0F}));
            glTexEnvi(8960, 34161, 8448);
            glTexEnvi(8960, 34176, 5890);
            glTexEnvi(8960, 34178, 34166);
            glTexEnvi(8960, 34162, 8448);
            glTexEnvi(8960, 34184, 5890);
            glDisable(3552);
            glDisable(3168);
            glActiveTexture(33984);
        glEndList();
    }

    public GlEffect3() {
        Class119.genetrateTextureData();
        listPointer = -1;
      //  if (org.lwjgl.opengl.GLContext.getCapabilities().GL_ >= 2) {
            int[] is = new int[1];
            byte[] is_0_ = new byte[8];
            int i = 0;
            while (i < 8)
                is_0_[i] = (byte) (96 + ++i * 159 / 8);
            is[0] = glGenTextures();
            glBindTexture(3552, is[0]);
            glTexImage1D(3552, 0, 6406, 8, 0, 6406, 5121, ByteBuffer.wrap(is_0_));
            glTexParameteri(3552, 10241, 9729);
            glTexParameteri(3552, 10240, 9729);
            glTexParameteri(3552, 10242, 33071);
            gradientAlpha = is[0];
            texture1or2 = false;///*OpenGLManager.max_texture_units > 2 && */OpenGLManager.has_texture_3d;
            createLists();
       // }
    }
}
