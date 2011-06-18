package pgle;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector3f;
import org.peterbjornx.pgl2.gl.GLQM;
import org.peterbjornx.pgl2.light.OpenGLLight;
import org.peterbjornx.pgl2.light.OpenGLLightManager;
import org.peterbjornx.pgl2.light.VirtualLight;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/18/11
 * Time: 5:15 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class PglSun {
    private OpenGLLight sunGLLight0;
    private OpenGLLight sunGLLight1;
    private PglSunLight directionalLight1;
    private PglSunLight directionalLight0;
    private Color sunColor;
    private float light0Intensity;
    private float light1Intensity;
    private Vector3f position;

    public PglSun(){
        sunGLLight0 = new OpenGLLight();
        sunGLLight1 = new OpenGLLight();
        sunGLLight0.setDirectional(true);
        sunGLLight1.setDirectional(true);
        directionalLight0 = new PglSunLight(sunGLLight0);
        directionalLight1 = new PglSunLight(sunGLLight1);
    }

    public void setSunColor(Color color, float light0Intensity,float light1Intensity,float ambientIntensity){
        if ((color != sunColor) || this.light0Intensity != light0Intensity || this.light1Intensity != light1Intensity){
            sunColor = color;
            this.light0Intensity = light0Intensity;
            this.light1Intensity = light1Intensity;
            float r = color.getRed();
            float g = color.getGreen();
            float b = color.getBlue();
            Color light0Colour = new Color((int)(r * light0Intensity*256f),(int)(g * light0Intensity*256f),(int)(b * light0Intensity*256f));
            Color light1Colour = new Color((int)(r * light1Intensity*256f),(int)(g * light1Intensity*256f),(int)(b * light1Intensity*256f));
            Color ambientColour = new Color((int)(r * ambientIntensity*256f),(int)(g * ambientIntensity*256f),(int)(b * ambientIntensity*256f));
            sunGLLight0.setDiffuse(light0Colour);
            sunGLLight0.setSpecular(light0Colour);
            sunGLLight0.setAmbient(light0Colour);
            sunGLLight1.setDiffuse(light1Colour);
            sunGLLight1.setSpecular(light1Colour);
            sunGLLight1.setAmbient(light1Colour);
            glLightModel(GL11.GL_LIGHT_MODEL_AMBIENT, GLQM.getColour4fBuffer(ambientColour));
        }
    }

    public void setSunPosition(Vector3f position){
        if (this.position != position){
            sunGLLight0.setPosition(position);
            sunGLLight1.setPosition((Vector3f)position.negate());
            this.position = position;
        }
    }

    public void activate(OpenGLLightManager manager){
        directionalLight0 = new PglSunLight(sunGLLight0);
        directionalLight1 = new PglSunLight(sunGLLight1);
        manager.activateVirtualLight(directionalLight0);
        manager.activateVirtualLight(directionalLight1);
    }


    public void deactivate(OpenGLLightManager manager){
        manager.deactivateVirtualLight(directionalLight0);
        manager.deactivateVirtualLight(directionalLight1);
    }

    private class PglSunLight implements VirtualLight {
        private OpenGLLight openGLLight;

        public PglSunLight(OpenGLLight openGLLight) {
            this.openGLLight = openGLLight;
        }

        public OpenGLLight getOpenGLLight() {
            return openGLLight;
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

}
