package editor.gui.dockables;

import rs2.Floor;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/24/11
 * Time: 6:39 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class FloorTypeSelection extends JPanel {
    private JButton[] floorButtons;
    private Floor selectedFloor = null;
    private int selectedFloorId = -1;
    private java.util.List<ActionListener> listenerList2 = new LinkedList<ActionListener>();

    public FloorTypeSelection(){
        setLayout(new FlowLayout());
        loadFloors();
    }

    public void loadFloors() {
        if (Floor.cache == null)
            return;
        floorButtons = new JButton[Floor.cache.length];
        for (int i = 0;i < Floor.cache.length;i++)
            addFloorJButton(i);
    }

    private void addFloorJButton(final int id){
        if (id > Floor.cache.length)
            return;
        JButton floorButton = new JButton("");
        floorButton.setBackground(new Color(Floor.cache[id].colour2));
        floorButton.setAction(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (selectedFloorId != -1)
                    floorButtons[selectedFloorId].setText("");
                selectedFloor = Floor.cache[id];
                selectedFloorId = id;
                floorButtons[id].setText("O");
                for (ActionListener l : listenerList2)
                    l.actionPerformed(null);
            }
        });
        floorButtons[id] = floorButton;
        add(floorButton);
        floorButton.setMaximumSize(new Dimension(17, 17));
        floorButton.setMinimumSize(new Dimension(17, 17));
        floorButton.setSize(17, 17);
        floorButton.setPreferredSize(new Dimension(17,17));

    }

    public boolean addActionListener(ActionListener actionListener) {
        return listenerList2.add(actionListener);
    }

    public boolean removeActionListener(ActionListener o) {
        return listenerList2.remove(o);
    }

    public Floor getSelectedFloor() {
        return selectedFloor;
    }

    public int getSelectedFloorId() {
        return selectedFloorId;
    }

    public void refresh() {
        for (int i = 0;i < floorButtons.length;i++)
            remove(floorButtons[i]);
        floorButtons = new JButton[Floor.cache.length];
        for (int i = 0;i < Floor.cache.length;i++)
            addFloorJButton(i);
        this.doLayout();
        repaint();
    }
}
