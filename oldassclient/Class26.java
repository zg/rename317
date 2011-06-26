import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public final class Class26 implements ImageProducer, ImageObserver
{
    private int anInt357 = 604;
    private boolean aBoolean358 = true;
    public int[] anIntArray359;
    public int anInt360;
    public int anInt361;
    ColorModel aColorModel362;
    ImageConsumer anImageConsumer363;
    public Image anImage364;
    
    public Class26(int arg0, int arg1, int arg2, Component arg3) {
	anInt360 = arg2;
	anInt361 = arg0;
	anIntArray359 = new int[arg2 * arg0];
	((Class26) this).aColorModel362
	    = new DirectColorModel(32, 16711680, 65280, 255);
	anImage364 = arg3.createImage(this);
	method192();
	arg1 = 31 / arg1;
	arg3.prepareImage(anImage364, this);
	method192();
	arg3.prepareImage(anImage364, this);
	method192();
	arg3.prepareImage(anImage364, this);
	method190(0);
    }
    
    public void method190(int arg0) {
	Class33_Sub2_Sub2.method284(aBoolean358, anInt360, anIntArray359,
				    anInt361);
	if (arg0 != 0) {
	}
    }
    
    public void method191(Graphics arg0, int arg1, int arg2) {
	method192();
	arg0.drawImage(anImage364, arg1, arg2, this);
    }
    
    public synchronized void addConsumer(ImageConsumer arg0) {
	((Class26) this).anImageConsumer363 = arg0;
	arg0.setDimensions(anInt360, anInt361);
	arg0.setProperties(null);
	arg0.setColorModel(((Class26) this).aColorModel362);
	arg0.setHints(14);
    }
    
    public synchronized boolean isConsumer(ImageConsumer arg0) {
	if (((Class26) this).anImageConsumer363 == arg0)
	    return true;
	return false;
    }
    
    public synchronized void removeConsumer(ImageConsumer arg0) {
	if (((Class26) this).anImageConsumer363 == arg0)
	    ((Class26) this).anImageConsumer363 = null;
    }
    
    public void startProduction(ImageConsumer arg0) {
	addConsumer(arg0);
    }
    
    public void requestTopDownLeftRightResend(ImageConsumer arg0) {
	System.out.println("TDLR");
    }
    
    public synchronized void method192() {
	if (((Class26) this).anImageConsumer363 != null) {
	    ((Class26) this).anImageConsumer363.setPixels(0, 0, anInt360,
							  anInt361,
							  (((Class26) this)
							   .aColorModel362),
							  anIntArray359, 0,
							  anInt360);
	    ((Class26) this).anImageConsumer363.imageComplete(2);
	}
    }
    
    public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			       int arg4, int arg5) {
	return true;
    }
}
