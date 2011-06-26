package editor;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import editor.gui.EditorMainWindow;
import rs2.GameShell;
import rs2.JagexFileStore;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/24/11
 * Time: 5:26 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class EditorMain extends GameShell {
    private JagexFileStore[] fileStores = new JagexFileStore[5];



    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        new EditorMainWindow().show();
    }
}
