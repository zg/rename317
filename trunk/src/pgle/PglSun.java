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
    public static  int[] light0Position = new int[3];
    public PglSun(){
        sunGLLight0 = new OpenGLLight();
        sunGLLight1 = new OpenGLLight();
        sunGLLight0.setDirectional(true);
        sunGLLight1.setDirectional(true);
        sunGLLight0.setId(0);
        sunGLLight1.setId(1);
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
            Color lololol =new Color(0,0,0,255);
            Color light0Colour = new Color((int)(r * light0Intensity),(int)(g * light0Intensity),(int)(b * light0Intensity));
            Color light1Colour = new Color((int)(r * light1Intensity),(int)(g * light1Intensity),(int)(b * light1Intensity));
            Color ambientColour = new Color((int)(r * ambientIntensity),(int)(g * ambientIntensity),(int)(b * ambientIntensity));
            sunGLLight0.setDiffuse(light0Colour);
            sunGLLight0.setSpecular(light0Colour);
            sunGLLight0.setAmbient(lololol);
            sunGLLight1.setDiffuse(light1Colour);
            sunGLLight1.setSpecular(light1Colour);
            sunGLLight1.setAmbient(lololol);
            glLightModel(GL11.GL_LIGHT_MODEL_AMBIENT, GLQM.getColour4fBuffer(ambientColour));
        }
    }

    public void setSunPosition(Vector3f position){
        if (this.position != position){
            sunGLLight0.setPosition(position);
            sunGLLight1.setPosition((Vector3f)position.negate());
            this.position = position;
            light0Position[0] = (int) position.getX();
            light0Position[1] = (int) position.getY();
            light0Position[2] = (int) position.getZ();
        }
    }

    public void activate(OpenGLLightManager manager){
        directionalLight0 = new PglSunLight(sunGLLight0);
        directionalLight1 = new PglSunLight(sunGLLight1);
        manager.activateVirtualLight(directionalLight0);
        manager.activateVirtualLight(directionalLight1);

    }

    public void activateNoManager(){
        sunGLLight0.enable();
        sunGLLight1.enable();
        sunGLLight0.loadValues();
        sunGLLight1.loadValues();
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
