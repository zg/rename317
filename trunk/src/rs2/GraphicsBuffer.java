package rs2;


import java.awt.*;
import java.awt.image.*;

public class GraphicsBuffer
		implements ImageProducer, ImageObserver {

	public GraphicsBuffer(int width, int height, Component component) {
		canvasWidth = width;
		canvasHeight = height;
		componentPixels = new int[width * height];
		colorModel = new DirectColorModel(32, 0xff0000, 65280, 255);
		image = component.createImage(this);
		method239();
		component.prepareImage(image, this);
		method239();
		component.prepareImage(image, this);
		method239();
		component.prepareImage(image, this);
		initDrawingArea();
	}

	public void initDrawingArea() {
		Graphics2D.init(canvasHeight, canvasWidth, componentPixels);
	}

	public void drawGraphics(int y, Graphics g, int x) {
		method239();
		g.drawImage(image, x, y, this);
	}

	public synchronized void addConsumer(ImageConsumer imageconsumer) {
		anImageConsumer319 = imageconsumer;
		imageconsumer.setDimensions(canvasWidth, canvasHeight);
		imageconsumer.setProperties(null);
		imageconsumer.setColorModel(colorModel);
		imageconsumer.setHints(14);
	}

	public synchronized boolean isConsumer(ImageConsumer imageconsumer) {
		return anImageConsumer319 == imageconsumer;
	}

	public synchronized void removeConsumer(ImageConsumer imageconsumer) {
		if (anImageConsumer319 == imageconsumer) {
			anImageConsumer319 = null;
		}
	}

	public void startProduction(ImageConsumer imageconsumer) {
		addConsumer(imageconsumer);
	}

	public void requestTopDownLeftRightResend(ImageConsumer imageconsumer) {
		System.out.println("TDLR");
	}

	private synchronized void method239() {
		if (anImageConsumer319 != null) {
			anImageConsumer319.setPixels(0, 0, canvasWidth, canvasHeight, colorModel, componentPixels, 0, canvasWidth);
			anImageConsumer319.imageComplete(2);
		}
	}

	public boolean imageUpdate(Image image, int infoflags, int x, int y, int width, int height) {
		return true;
	}

	public final int[] componentPixels;
	private final int canvasWidth;
	private final int canvasHeight;
	private final ColorModel colorModel;
	private ImageConsumer anImageConsumer319;
	private final Image image;
}
