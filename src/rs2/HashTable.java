package rs2;


public class HashTable {

    public HashTable()
    {
        int i = 1024;//was parameter
        size = i;
        cache = new Node[i];
        for(int k = 0; k < i; k++)
        {
            Node node = cache[k] = new Node();
            node.next = node;
            node.previous = node;
        }

    }

    public Node findNodeByID(long l)
    {
        Node node = cache[(int)(l & (long)(size - 1))];
        for(Node node_1 = node.next; node_1 != node; node_1 = node_1.next)
            if(node_1.hash == l)
                return node_1;

        return null;
    }

    public void removeFromCache(Node node, long l)
    {
        try
        {
            if(node.previous != null)
                node.unlink();
            Node node_1 = cache[(int)(l & (long)(size - 1))];
                node.previous = node_1.previous;
                node.next = node_1;
                node.previous.next = node;
                node.next.previous = node;
                node.hash = l;
                return;
        }
        catch(RuntimeException runtimeexception)
        {
            Signlink.reporterror("91499, " + node + ", " + l + ", " + (byte) 7 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    private final int size;
    private final Node[] cache;
}
