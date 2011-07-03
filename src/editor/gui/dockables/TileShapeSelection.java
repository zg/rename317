package editor.gui.dockables;

import rs2.Floor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/24/11
 * Time: 6:39 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class TileShapeSelection extends JPanel implements Scrollable{
    private JButton[] shapeButtons;
    private Floor selectedFloor = null;
    private int selectedFloorId = -2;
    private java.util.List<ActionListener> listenerList2 = new LinkedList<ActionListener>();

    public TileShapeSelection(){
        setLayout(new FlowLayout());
        loadFloors();
    }

    public void loadFloors() {
        if (Floor.cache == null)
            return;
        shapeButtons = new JButton[Floor.cache.length+1];
        addFloorJButton(-1);
        for (int i = 0;i < Floor.cache.length;i++)
            addFloorJButton(i);
    }

    private void addFloorJButton(final int id){
        if (id > Floor.cache.length)
            return;
        JButton floorButton = new JButton("");
        if(id != -1)
            floorButton.setBackground(new Color(Floor.cache[id].colour2));
        floorButton.setAction(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (selectedFloorId != -2)
                    shapeButtons[selectedFloorId+1].setText("");
                if(id > -1)
                    selectedFloor = Floor.cache[id];
                selectedFloorId = id;
                shapeButtons[id+1].setText("O");
                for (ActionListener l : listenerList2)
                    l.actionPerformed(null);
            }
        });
        shapeButtons[id+1] = floorButton;
        add(floorButton);
        floorButton.setMaximumSize(new Dimension(15, 15));
        floorButton.setMinimumSize(new Dimension(15, 15));
        floorButton.setSize(15, 15);
        floorButton.setPreferredSize(new Dimension(15,15));

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
        if (selectedFloorId == -2)
            return -1;
        return selectedFloorId;
    }

    public void refresh() {
        for (int i = -1;i < shapeButtons.length-1;i++)
            remove(shapeButtons[i+1]);
        shapeButtons = new JButton[Floor.cache.length+1];
        addFloorJButton(-1);
        for (int i = 0;i < Floor.cache.length;i++)
            addFloorJButton(i);
        this.doLayout();
        repaint();
    }

    public void selectFloor(int id) {
        if (selectedFloorId != -2)
            shapeButtons[selectedFloorId+1].setText("");
        if (selectedFloorId >= 0)
            selectedFloor = Floor.cache[id];
        selectedFloorId = id;
        shapeButtons[id+1].setText("O");
        for (ActionListener l : listenerList2)
             l.actionPerformed(null);
    }

    /**
     * Returns the preferred size of the viewport for a view component.
     * For example, the preferred size of a <code>JList</code> component
     * is the size required to accommodate all of the cells in its list.
     * However, the value of <code>preferredScrollableViewportSize</code>
     * is the size required for <code>JList.getVisibleRowCount</code> rows.
     * A component without any properties that would affect the viewport
     * size should just return <code>getPreferredSize</code> here.
     *
     * @return the preferredSize of a <code>JViewport</code> whose view
     *         is this <code>Scrollable</code>
     * @see javax.swing.JViewport#getPreferredSize
     */
    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    /**
     * Components that display logical rows or columns should compute
     * the scroll increment that will completely expose one new row
     * or column, depending on the value of orientation.  Ideally,
     * components should handle a partially exposed row or column by
     * returning the distance required to completely expose the item.
     * <p/>
     * Scrolling containers, like JScrollPane, will use this method
     * each time the user requests a unit scroll.
     *
     * @param visibleRect The view area visible within the viewport
     * @param orientation Either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL.
     * @param direction   Less than zero to scroll up/left, greater than zero for down/right.
     * @return The "unit" increment for scrolling in the specified direction.
     *         This value should always be positive.
     * @see javax.swing.JScrollBar#setUnitIncrement
     */
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Components that display logical rows or columns should compute
     * the scroll increment that will completely expose one block
     * of rows or columns, depending on the value of orientation.
     * <p/>
     * Scrolling containers, like JScrollPane, will use this method
     * each time the user requests a block scroll.
     *
     * @param visibleRect The view area visible within the viewport
     * @param orientation Either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL.
     * @param direction   Less than zero to scroll up/left, greater than zero for down/right.
     * @return The "block" increment for scrolling in the specified direction.
     *         This value should always be positive.
     * @see javax.swing.JScrollBar#setBlockIncrement
     */
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 10;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Return true if a viewport should always force the width of this
     * <code>Scrollable</code> to match the width of the viewport.
     * For example a normal
     * text view that supported line wrapping would return true here, since it
     * would be undesirable for wrapped lines to disappear beyond the right
     * edge of the viewport.  Note that returning true for a Scrollable
     * whose ancestor is a JScrollPane effectively disables horizontal
     * scrolling.
     * <p/>
     * Scrolling containers, like JViewport, will use this method each
     * time they are validated.
     *
     * @return True if a viewport should force the Scrollables width to match its own.
     */
    public boolean getScrollableTracksViewportWidth() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Return true if a viewport should always force the height of this
     * Scrollable to match the height of the viewport.  For example a
     * columnar text view that flowed text in left to right columns
     * could effectively disable vertical scrolling by returning
     * true here.
     * <p/>
     * Scrolling containers, like JViewport, will use this method each
     * time they are validated.
     *
     * @return True if a viewport should force the Scrollables height to match its own.
     */
    public boolean getScrollableTracksViewportHeight() {
        return false;  //To chfange body of implemented methods use File | Settings | File Templates.
    }
}
