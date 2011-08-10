package rt4;
import org.lwjgl.BufferUtils;

import java.nio.Buffer;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 7/31/11
 * Time: 10:21 PM
 * To change this template use File | Ssettings | File Templates.
 */
public class AthmosphericEffects {
    public static int fogDistanceModifier = -1;
    public static float[] light1Position = new float[4];
    public static float ambientModelModifier;
    public static float[] light0Position;
    public static int anInt928;
    public static int defaultFogColour;
    public static float light2Modifier;
    public static int lightModelColour = -1;
    public static float light1Modifier;
    public static float[] fogColourComponents;
    public static int anInt934;
    public static int defaultSunColour;
    public static int fogColour;

    public static void destroy() {
        light0Position = null;
        light1Position = null;
        fogColourComponents = null;
    }

    public static FloatBuffer t(float[] t){
        FloatBuffer tt = BufferUtils.createFloatBuffer(t.length);
        tt.put(t);
        tt.flip();
        return tt;
    }

    public static void loadLightPositions() {
        glLight(16384, 4611, t(light0Position));//Light 0 position
        glLight(16385, 4611, t(light1Position));//Light 1 position
    }

    public static void setFogColour(float[] arg0) {
        if (arg0 == null)
            arg0 = fogColourComponents;
        glFog(2918, t(arg0));//Fog color
    }

    public static float getAmbientModelModifier() {
        return ambientModelModifier;
    }

    public static void setLightModel(int lightModelColour, float ambientModelModifier, float light1Modifier,
                                  float light2Modifier) {
        if (AthmosphericEffects.lightModelColour != lightModelColour || AthmosphericEffects.ambientModelModifier != ambientModelModifier || AthmosphericEffects.light1Modifier != light1Modifier
                || AthmosphericEffects.light2Modifier != light2Modifier) {
            AthmosphericEffects.lightModelColour = lightModelColour;
            AthmosphericEffects.ambientModelModifier = ambientModelModifier;
            AthmosphericEffects.light1Modifier = light1Modifier;
            AthmosphericEffects.light2Modifier = light2Modifier;
            float r = (float) (lightModelColour >> 16 & 0xff) / 255.0F;
            float g = (float) (lightModelColour >> 8 & 0xff) / 255.0F;
            float b = (float) (lightModelColour & 0xff) / 255.0F;
            float[] lightModelAmbient = { ambientModelModifier * r, ambientModelModifier * g, ambientModelModifier * b, 1.0F };
            glLightModel(2899, t(lightModelAmbient));
            float[] light1diffuse = { light1Modifier * r, light1Modifier * g, light1Modifier * b, 1.0F };
            glLight(16384, 4609, t(light1diffuse));
            float[] light2diffuse = { -light2Modifier * r, -light2Modifier * g, -light2Modifier * b, 1.0F };
            glLight(16385, 4609, t(light2diffuse));
        }
    }

    public static float getLight1Modifier() {
        return light1Modifier;
    }

    public static void setFogProperties(int fogColour, int fogDistanceModifier) {
        if (AthmosphericEffects.fogColour != fogColour || AthmosphericEffects.fogDistanceModifier != fogDistanceModifier) {
            AthmosphericEffects.fogColour = fogColour;
            AthmosphericEffects.fogDistanceModifier = fogDistanceModifier;
            int i = 50;
            int fogEnd = 3584;
            fogColourComponents[0] = (float) (fogColour >> 16 & 0xff) / 255.0F;
            fogColourComponents[1] = (float) (fogColour >> 8 & 0xff) / 255.0F;
            fogColourComponents[2] = (float) (fogColour & 0xff) / 255.0F;
            glFogi(2917, 9729);
            glFogf(2914, 0.95F);
            glHint(3156, 4353);
            int fogStart = fogEnd - 512 - fogDistanceModifier;
            if (fogStart < i)
                fogStart = i;
            glFogf(2915, (float) fogStart);
            glFogf(2916, (float) (fogEnd - 256));
            glFog(2918, t(fogColourComponents));
        }
    }

    public static int getLightModelColour() {
        return lightModelColour;
    }

    public static void setSunPosition(float x, float y, float z) {
        if (light0Position[0] != x || light0Position[1] != y
                || light0Position[2] != z) {
            light0Position[0] = x;
            light0Position[1] = y;
            light0Position[2] = z;
            light1Position[0] = -x;
            light1Position[1] = -y;
            light1Position[2] = -z;
            anInt934 = (int) (x * 256.0F / y);
            anInt928 = (int) (z * 256.0F / y);
        }
    }

    public static void setupLighting() {
        glColorMaterial(1028, 5634);
        glEnable(2903);
        float[] fs = { 0.0F, 0.0F, 0.0F, 1.0F };
        glLight(16384, 4608, t(fs));
        glEnable(16384);
        float[] fs_6_ = { 0.0F, 0.0F, 0.0F, 1.0F };
        glLight(16385, 4608, t(fs_6_));
        glEnable(16385);
        lightModelColour = -1;
        fogColour = -1;
        loadDefaults();
    }

    public static void loadDefaults() {
        setLightModel(defaultSunColour, 1.1523438F, 0.69921875F, 1.2F);
        setSunPosition(-50.0F, -60.0F, -50.0F);
        setFogProperties(defaultFogColour, 0);
    }

    static {
        light0Position = new float[4];
        light1Modifier = -1.0F;
        light2Modifier = -1.0F;
        fogColourComponents = new float[4];
        defaultSunColour = 16777215;
        defaultFogColour = 13156520;
        fogColour = -1;
    }
}

