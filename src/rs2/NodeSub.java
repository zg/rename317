package rs2;


public class NodeSub extends Node {

    public final void unlinkSub()
    {
        if(previousSub == null)
        {
        } else
        {
            previousSub.nextSub = nextSub;
            nextSub.previousSub = previousSub;
            nextSub = null;
            previousSub = null;
        }
    }

    public NodeSub()
    {
    }

    public NodeSub nextSub;
    NodeSub previousSub;
}
