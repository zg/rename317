package rs2;
import java.awt.*;

@SuppressWarnings("serial")
final class RSFrame extends Frame {

	public RSFrame(RSApplet RSApplet_, int i, int j) {
		rsApplet = RSApplet_;
		setTitle("Jagex");
		setResizable(false);
		setVisible(true);
		toFront();
		setSize(i + 8, j + 28);
	}

	public Graphics getGraphics() {
		Graphics g = super.getGraphics();
		g.translate(4, 24);
		return g;
	}

	public void update(Graphics g) {
		rsApplet.update(g);
	}

	public void paint(Graphics g) {
		rsApplet.paint(g);
	}
	private final RSApplet rsApplet;
}
