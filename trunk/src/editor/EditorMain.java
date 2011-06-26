package editor;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import editor.gui.EditorMainWindow;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/24/11
 * Time: 5:26 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class EditorMain {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        new EditorMainWindow().show();
    }
}
