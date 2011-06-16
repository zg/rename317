




public class NodeSub extends Node {

    public final void unlinkSub()
    {
        if(nextNodeSub == null)
        {
        } else
        {
            nextNodeSub.prevNodeSub = prevNodeSub;
            prevNodeSub.nextNodeSub = nextNodeSub;
            prevNodeSub = null;
            nextNodeSub = null;
        }
    }

    public NodeSub()
    {
    }

    public NodeSub prevNodeSub;
    NodeSub nextNodeSub;
    public static int anInt1305;
}
