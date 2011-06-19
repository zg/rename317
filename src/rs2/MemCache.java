package rs2;


public class MemCache {

    public MemCache(int i)
    {
        emptyNodeSub = new NodeSub();
        queue = new Queue();
        initialCount = i;
        spaceLeft = i;
        hashTable = new HashTable();
    }

    public NodeSub get(long l)
    {
        NodeSub nodeSub = (NodeSub) hashTable.findNodeByID(l);
        if(nodeSub != null)
        {
            queue.insertBack(nodeSub);
        }
        return nodeSub;
    }

    public void put(NodeSub nodeSub, long l)
    {
        try
        {
            if(spaceLeft == 0)
            {
                NodeSub nodeSub_1 = queue.popFront();
                nodeSub_1.unlink();
                nodeSub_1.unlinkSub();
                if(nodeSub_1 == emptyNodeSub)
                {
                    NodeSub nodeSub_2 = queue.popFront();
                    nodeSub_2.unlink();
                    nodeSub_2.unlinkSub();
                }
            } else
            {
                spaceLeft--;
            }
            hashTable.removeFromCache(nodeSub, l);
            queue.insertBack(nodeSub);
            return;
        }
        catch(RuntimeException runtimeexception)
        {
            Signlink.reporterror("47547, " + nodeSub + ", " + l + ", " + (byte) 2 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void unlinkAll()
    {
        do
        {
            NodeSub nodeSub = queue.popFront();
            if(nodeSub != null)
            {
                nodeSub.unlink();
                nodeSub.unlinkSub();
            } else
            {
                spaceLeft = initialCount;
                return;
            }
        } while(true);
    }

    private final NodeSub emptyNodeSub;
    private final int initialCount;
    private int spaceLeft;
    private final HashTable hashTable;
    private final Queue queue;
}
