package editor.gui.dockables;

import rs2.MapRegion;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 1/28/11
 * Time: 9:47 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class EditorToolbar {
    private JButton heightLevelUpButton;
    private JButton heightLevelDownButton;
    private JToggleButton showAllHeightLevelButtons;
    private int ourHeightlevel = 0;
    private List<ChangeListener> listenerList = new LinkedList<ChangeListener>();
    private JPanel mainPane;
    private JToggleButton disableBlendingButton;
    private JToggleButton noOverlayBtn;
    private JToggleButton floorIdVisBtn;
    private JToggleButton settingsButton;
    private JToggleButton renderHiddenBtn;
    private JSpinner targetHLSpinner;
    private JSlider setHeight;
    private int settings = 0;

    public EditorToolbar() {
        heightLevelDownButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            public void actionPerformed(ActionEvent e) {
                if (ourHeightlevel == 3) {
                    heightLevelUpButton.setEnabled(true);
                }
                ourHeightlevel--;
                targetHLSpinner.setValue(ourHeightlevel);
                if (ourHeightlevel < 0) {
                    ourHeightlevel = 0;
                    heightLevelDownButton.setEnabled(false);
                }
                for (ChangeListener l : listenerList)
                    l.stateChanged(null);
            }
        });
        heightLevelUpButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            public void actionPerformed(ActionEvent e) {
                if (ourHeightlevel == 0) {
                    heightLevelDownButton.setEnabled(true);
                }
                ourHeightlevel++;
                targetHLSpinner.setValue(ourHeightlevel);
                if (ourHeightlevel > 3) {
                    ourHeightlevel = 3;
                    heightLevelUpButton.setEnabled(false);
                }
                for (ChangeListener l : listenerList)
                    l.stateChanged(null);
            }
        });
        showAllHeightLevelButtons.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                for (ChangeListener l : listenerList)
                    l.stateChanged(null);
            }
        });
        ChangeListener settingsListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                settings = 0;
                if (disableBlendingButton.isSelected())
                    settings |= MapRegion.NO_BLENDING_BIT;
                if (floorIdVisBtn.isSelected())
                    settings |= MapRegion.NO_COLOUR_RES_BIT;
                if (noOverlayBtn.isSelected())
                    settings |= MapRegion.NO_OVERLAY_BIT;
                if (renderHiddenBtn.isSelected())
                    settings |= MapRegion.RENDER_HIDDEN_BIT;
                if (settingsButton.isSelected())
                    settings = MapRegion.TILE_SETTINGS_FC;
                for (ChangeListener l : listenerList)
                    l.stateChanged(new ChangeEvent(this));
            }
        };
        disableBlendingButton.addChangeListener(settingsListener);
        floorIdVisBtn.addChangeListener(settingsListener);
        noOverlayBtn.addChangeListener(settingsListener);
        renderHiddenBtn.addChangeListener(settingsListener);
        settingsButton.addChangeListener(settingsListener);
        setHeight.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            public void stateChanged(ChangeEvent e) {
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

    public int getHeightlevel() {
        return ourHeightlevel;
    }

    public void setHeightLevel(int hl) {
        ourHeightlevel = hl;
        targetHLSpinner.setValue(hl);
    }

    public boolean getShowAllHLs() {
        return showAllHeightLevelButtons.isSelected();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public Component getMainPane() {
        return mainPane;
    }

    public int getSettings() {
        return settings;
    }

    public int getTargetHeight() {
        return setHeight.getValue();
    }

    public void setTargetHeight(int height) {
        setHeight.setValue(height);
    }

    public int getTargetHL() {
        return (Integer) targetHLSpinner.getValue();
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
        mainPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 13, new Insets(0, 0, 0, 0), -1, -1));
        heightLevelUpButton = new JButton();
        heightLevelUpButton.setText("HL+");
        mainPane.add(heightLevelUpButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        heightLevelDownButton = new JButton();
        heightLevelDownButton.setText("HL-");
        mainPane.add(heightLevelDownButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        mainPane.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 12, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        disableBlendingButton = new JToggleButton();
        disableBlendingButton.setText("Disable Blending");
        mainPane.add(disableBlendingButton, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        noOverlayBtn = new JToggleButton();
        noOverlayBtn.setText("No Overlays");
        mainPane.add(noOverlayBtn, new com.intellij.uiDesigner.core.GridConstraints(0, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        floorIdVisBtn = new JToggleButton();
        floorIdVisBtn.setText("FC:FloID");
        mainPane.add(floorIdVisBtn, new com.intellij.uiDesigner.core.GridConstraints(0, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        settingsButton = new JToggleButton();
        settingsButton.setText("FC:Settings");
        mainPane.add(settingsButton, new com.intellij.uiDesigner.core.GridConstraints(0, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        renderHiddenBtn = new JToggleButton();
        renderHiddenBtn.setText("Show Hidden");
        mainPane.add(renderHiddenBtn, new com.intellij.uiDesigner.core.GridConstraints(0, 9, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        targetHLSpinner = new JSpinner();
        mainPane.add(targetHLSpinner, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(32, 18), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Target HL:");
        mainPane.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showAllHeightLevelButtons = new JToggleButton();
        showAllHeightLevelButtons.setText("AllHLs");
        mainPane.add(showAllHeightLevelButtons, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        setHeight = new JSlider();
        setHeight.setMajorTickSpacing(10);
        setHeight.setMaximum(255);
        setHeight.setMinimum(0);
        setHeight.setMinorTickSpacing(5);
        setHeight.setPaintLabels(false);
        setHeight.setPaintTicks(true);
        setHeight.setValue(0);
        setHeight.setValueIsAdjusting(false);
        mainPane.add(setHeight, new com.intellij.uiDesigner.core.GridConstraints(0, 11, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Set height:");
        mainPane.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 10, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPane;
    }
}
