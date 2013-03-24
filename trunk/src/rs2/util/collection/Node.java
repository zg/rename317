package rs2.util.collection;

public class Node {

    public final void unlink()
    {
        if(prev == null)
        {
        } else
        {
            prev.next = next;
            next.prev = prev;
            next = null;
            prev = null;
        }
    }

    public Node()
    {
    }

    public long hash;
    public Node next;
    public Node prev;
}
