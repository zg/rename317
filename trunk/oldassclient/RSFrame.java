import java.awt.Frame;
import java.awt.Graphics;

public final class RSFrame extends Frame
{
    RSApplet anApplet_Sub1_30;
    
    public RSFrame(int arg0, RSApplet arg1, int arg2, int arg3) {
	((RSFrame) this).anApplet_Sub1_30 = arg1;
	this.setTitle("Jagex");
	this.setResizable(false);
	if (arg2 != 22967)
	    throw new NullPointerException();
	this.show();
	this.toFront();
	this.resize(arg0 + 8, arg3 + 28);
    }
    
    public Graphics getGraphics() {
	Graphics graphics = super.getGraphics();
	graphics.translate(4, 24);
	return graphics;
    }
    
    public final void update(Graphics arg0) {
	((RSFrame) this).anApplet_Sub1_30.update(arg0);
    }
    
    public final void paint(Graphics arg0) {
	((RSFrame) this).anApplet_Sub1_30.paint(arg0);
    }
}
