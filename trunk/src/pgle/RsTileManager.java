package pgle;

import org.peterbjornx.pgl2.model.Node;
import org.peterbjornx.pgl2.tile.TileManagerNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/18/11
 * Time: 1:18 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */                                            //TODO: Allow for 2 classes of objects on tiles,per frame and per map
public class RsTileManager extends TileManagerNode {
    private List<Node> perFrame = new LinkedList<Node>();
    private List<Node> perRegion = new LinkedList<Node>();

    public RsTileManager() {
        super(4, 103, 103, 240, 128, 128);
    }

    public void addPerFrame(Node child,int y,int x,int z){
        getTile(y,x,z).add(child);
        perFrame.add(child);
    }

    public void addPerRegion(Node child,int y,int x,int z){
        getTile(y,x,z).add(child);
        perRegion.add(child);
    }

    public void removePerRegion(){
        for(Node n : perRegion)
            n.getParent().remove(n);
        perRegion.clear();
    }

    public void removePerFrame(){
        for(Node n : perFrame)
            n.getParent().remove(n);
        perFrame.clear();
    }
}
