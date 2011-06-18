package pgle;

import org.peterbjornx.pgl2.model.Node;
import org.peterbjornx.pgl2.tile.TileManagerNode;

import java.io.ObjectStreamClass;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/18/11
 * Time: 1:18 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class RsTileManager extends TileManagerNode {

    private List<Node> perRegion = new LinkedList<Node>();

    public RsTileManager() {
        super(4, 103, 103, 240, 128, 128);
    }

    public void clear(){
        for (Node n : perRegion)
            if (n != null && n.getParent() != null)
                n.getParent().remove(n);
        perRegion.clear();
    }

    public void add(Node child,int y,int x,int z){
        getTile(y,x,z).add(child);
        perRegion.add(child);
    }
}
