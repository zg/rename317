package rs2;

import org.peterbjornx.pgl2.model.Node;
import rs2.model.entity.Entity;

public class WallObject
{

    public org.peterbjornx.pgl2.model.Node pgleNode1;
    public Node pgleNode2;

    public WallObject()
    {
    }

    int zPos;
    int xPos;
    int yPos;
    int orientation;
    int orientation1;
    public Entity node1;
    public Entity node2;
    public int uid;
    byte objConf;
}
