package rs2;


public class Queue {

    public Queue()
    {
        head = new NodeSub();
        head.nextSub = head;
        head.previousSub = head;
    }

    public void insertBack(NodeSub nodeSub)
    {
        if(nodeSub.previousSub != null)
            nodeSub.unlinkSub();
        nodeSub.previousSub = head.previousSub;
        nodeSub.nextSub = head;
        nodeSub.previousSub.nextSub = nodeSub;
        nodeSub.nextSub.previousSub = nodeSub;
    }

    public NodeSub popFront()
    {
        NodeSub nodeSub = head.nextSub;
        if(nodeSub == head)
        {
            return null;
        } else
        {
            nodeSub.unlinkSub();
            return nodeSub;
        }
    }

    public NodeSub getFront()
    {
        NodeSub nodeSub = head.nextSub;
        if(nodeSub == head)
        {
            current = null;
            return null;
        } else
        {
            current = nodeSub.nextSub;
            return nodeSub;
        }
    }

    public NodeSub getNext()
    {
        NodeSub nodeSub = current;
        if(nodeSub == head)
        {
            current = null;
            return null;
        } else
        {
            current = nodeSub.nextSub;
            return nodeSub;
        }
    }

    public int getSize()
    {
        int i = 0;
        for(NodeSub nodeSub = head.nextSub; nodeSub != head; nodeSub = nodeSub.nextSub)
            i++;

        return i;
    }

    private final NodeSub head;
    private NodeSub current;
}
