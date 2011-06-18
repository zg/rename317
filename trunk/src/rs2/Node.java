package rs2;


public class Node {

    public final void unlink()
    {
        if(previous == null)
        {
        } else
        {
            previous.next = next;
            next.previous = previous;
            next = null;
            previous = null;
        }
    }

    public Node()
    {
    }

    public long hash;
    public Node next;
    public Node previous;
}
