package rs2;


import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.awt.image.*;
import java.nio.IntBuffer;

public class GraphicsBuffer
		implements ImageProducer, ImageObserver {

	public GraphicsBuffer(int width, int height, Component component) {
		canvasWidth = width;
		canvasHeight = height;
		componentPixels = new int[width * height];
		colorModel = new DirectColorModel(32, 0xff0000, 65280, 255);
		image = component.createImage(this);
		sendToConsumer();
		component.prepareImage(image, this);
		sendToConsumer();
		component.prepareImage(image, this);
		sendToConsumer();
		component.prepareImage(image, this);
		initDrawingArea();
	}

	public void initDrawingArea() {
		DrawingArea.setTarget(canvasWidth, canvasHeight, componentPixels);
	}

	public void drawGraphics(int y, Graphics g, int x) {
		sendToConsumer();
		g.drawImage(image, x, y, this);
	}

	public synchronized void addConsumer(ImageConsumer imageconsumer) {
		myImageConsumer = imageconsumer;
		imageconsumer.setDimensions(canvasWidth, canvasHeight);
		imageconsumer.setProperties(null);
		imageconsumer.setColorModel(colorModel);
		imageconsumer.setHints(14);
	}

	public synchronized boolean isConsumer(ImageConsumer imageconsumer) {
		return myImageConsumer == imageconsumer;
	}

	public synchronized void removeConsumer(ImageConsumer imageconsumer) {
		if (myImageConsumer == imageconsumer) {
			myImageConsumer = null;
		}
	}

	public void startProduction(ImageConsumer imageconsumer) {
		addConsumer(imageconsumer);
	}

	public void requestTopDownLeftRightResend(ImageConsumer imageconsumer) {
		System.out.println("TDLR");
	}

	private synchronized void sendToConsumer() {
		if (myImageConsumer != null) {
			myImageConsumer.setPixels(0, 0, canvasWidth, canvasHeight, colorModel, componentPixels, 0, canvasWidth);
			myImageConsumer.imageComplete(2);
		}
	}

	public boolean imageUpdate(Image image, int infoflags, int x, int y, int width, int height) {
		return true;
	}

	public final int[] componentPixels;
	public final int canvasWidth;
	public final int canvasHeight;
	private final ColorModel colorModel;
	private ImageConsumer myImageConsumer;
	private final Image image;

    public void drawGraphicsGL(int y, int x) {
        GL11.glRasterPos2i(x,503-canvasHeight-y);
        int[] _componentPixels = new int[componentPixels.length];
        IntBuffer i = BufferUtils.createIntBuffer(_componentPixels.length);
        for (int _y = 0;_y < canvasHeight;_y++){
            int screeny = canvasHeight - _y - 1;
            i.put(_componentPixels,screeny * canvasWidth, canvasWidth);
        }
        i.flip();
       // GL11.glDrawPixels(canvasWidth, canvasHeight, GL12.GL_BGRA, GL11.GL_UNSIGNED_BYTE, i);
    }
}
