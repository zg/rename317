package editor.gui.dockables.flooreditor;

import editor.gui.controls.ColourEditor;
import rs2.Floor;
//import sun.plugin.dom.core.Text;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/24/11
 * Time: 7:19 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class FloorEditorWindow {
    private JPanel mainPane;
    private JComboBox previewModeBox;
    private JButton saveButton;
    private JButton saveAsNewButton;
    private JButton resetButton;
    private JSpinner gameTexture;
    private ColourEditor gameColour;
    private JCheckBox blendingCheckbox;
    private JTextField gameName;
    private FloorPreviewPanel previewBox;
    private Floor currentFloor;
    private Floor loadedFloor;
    private List<ChangeListener> listenerList = new LinkedList<ChangeListener>();
    private boolean isDirty = false;
    private boolean isLoading = false;

    public FloorEditorWindow() {
        previewModeBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            public void actionPerformed(ActionEvent e) {
                previewBox.setMode(FloorPreviewPanel.FloorPreviewMode.values()[previewModeBox.getSelectedIndex()]);
                loadFloor();
            }
        });
        final ChangeListener cl = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (currentFloor == null || isLoading)
                    return;
                isDirty = true;
                currentFloor.occlude = blendingCheckbox.isSelected();
                switch (previewBox.getMode()) {
                    case RT3_GAME:
                        currentFloor.colour2 = gameColour.getColour();
                        currentFloor.rgb2hls(currentFloor.colour2, true);
                        currentFloor.texture = (Integer) gameTexture.getValue();
                        currentFloor.name = gameName.getText();
                        break;
                    case RT3_MAP:
                        currentFloor.minimapColour = gameColour.getColour();
                        currentFloor.rgb2hls(currentFloor.minimapColour, false);
                        break;
                    case RT4P_OVERLAY:
                        currentFloor.hdColour = gameColour.getColour();
                        int hslColour = currentFloor.hslColour;
                        currentFloor.rgb2hls(currentFloor.hdColour, false);
                        currentFloor.hdOlHslColour = hslColour;
                        currentFloor.hslColour = hslColour;
                        currentFloor.hdTexture = (Integer) gameTexture.getValue();
                        //currentFloor.name = gameName.getText();
                        break;
                    case RT4P_UNDERLAY:
                        currentFloor.hdUlColour = gameColour.getColour();
                        hslColour = currentFloor.hslColour;
                        currentFloor.rgb2hls(currentFloor.hdUlColour, false);
                        currentFloor.hdHslColour = hslColour;
                        currentFloor.hslColour = hslColour;
                        currentFloor.hdUlTexture = (Integer) gameTexture.getValue();
                        //currentFloor.name = gameName.getText();
                        break;
                }
                previewBox.repaint();
            }
        };
        gameColour.addChangeListener(cl);
        gameTexture.addChangeListener(cl);
        blendingCheckbox.addChangeListener(cl);

        gameName.addFocusListener(new FocusListener() {
            String text = "";

            public void focusGained(FocusEvent e) {
                text = gameName.getText();
            }

            public void focusLost(FocusEvent e) {
                if (!gameName.getText().equals(text))
                    cl.stateChanged(null);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((!isDirty) || JOptionPane.showConfirmDialog(mainPane, "Are you sure you want to revert all changes to this floor?", "RuneScape Map Editor",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION)
                    currentFloor = loadedFloor.cloneFLO();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isDirty = false;
                loadedFloor.replace(currentFloor);
                Floor.cache[loadedFloor.id] = loadedFloor;
                for (ChangeListener l : listenerList)
                    l.stateChanged(null);
            }
        });
        saveAsNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isDirty = false;
                int i = Floor.addNew(currentFloor);
                currentFloor.id = i;
                loadedFloor = Floor.cache[i];
                for (ChangeListener l : listenerList)
                    l.stateChanged(null);
            }
        });
    }

    public boolean addChangeListener(ChangeListener changeListener) {
        return listenerList.add(changeListener);
    }

    public boolean removeChangeListener(ChangeListener o) {
        return listenerList.remove(o);
    }

    public JPanel getMainPane() {
        return mainPane;
    }

    private void loadFloor() {
        if (currentFloor == null)
            return;
        isLoading = true;
        blendingCheckbox.setSelected(currentFloor.occlude);
        switch (previewBox.getMode()) {
            case RT3_GAME:
                gameColour.setColour(currentFloor.colour2);
                gameTexture.setValue(currentFloor.texture);
                gameName.setText(currentFloor.name);
                break;
            case RT3_MAP:
                gameColour.setColour(currentFloor.minimapColour);
                gameTexture.setValue(currentFloor.texture);
                gameName.setText(currentFloor.name);
                break;
            case RT4P_OVERLAY:
                gameColour.setColour(currentFloor.hdColour);
                gameTexture.setValue(currentFloor.hdTexture);
                //gameName.setText(currentFloor.name);
                break;
            case RT4P_UNDERLAY:
                gameColour.setColour(currentFloor.hdUlColour);
                gameTexture.setValue(currentFloor.hdUlTexture);
                //gameName.setText(currentFloor.name);
                break;
        }
        isLoading = false;
        previewBox.repaint();
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor.cloneFLO();
        this.loadedFloor = currentFloor;
        previewBox.setMyFloor(this.currentFloor);
        previewBox.repaint();
        loadFloor();
    }

    public boolean isDirty() {
        return isDirty;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPane = new JPanel();
        mainPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        previewBox = new FloorPreviewPanel();
        mainPane.add(previewBox, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(128, 128), new Dimension(128, 128), null, 0, false));
        final JToolBar toolBar1 = new JToolBar();
        mainPane.add(toolBar1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 20), null, 0, false));
        saveButton = new JButton();
        saveButton.setText("Save");
        toolBar1.add(saveButton);
        saveAsNewButton = new JButton();
        saveAsNewButton.setText("Save As New");
        toolBar1.add(saveAsNewButton);
        resetButton = new JButton();
        resetButton.setText("Reset");
        toolBar1.add(resetButton);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPane.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        gameTexture = new JSpinner();
        panel1.add(gameTexture, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Texture:");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gameColour = new ColourEditor();
        panel1.add(gameColour, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        blendingCheckbox = new JCheckBox();
        blendingCheckbox.setSelected(false);
        blendingCheckbox.setText("Blend colour");
        panel1.add(blendingCheckbox, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gameName = new JTextField();
        panel1.add(gameName, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Name:");
        panel1.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Edit mode:");
        panel1.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        previewModeBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Game (SD)");
        defaultComboBoxModel1.addElement("Game (LD)");
        defaultComboBoxModel1.addElement("Minimap");
        defaultComboBoxModel1.addElement("Game Overlay (HD)");
        defaultComboBoxModel1.addElement("Game Underlay (HD)");
        previewModeBox.setModel(defaultComboBoxModel1);
        panel1.add(previewModeBox, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        mainPane.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPane;
    }
}
