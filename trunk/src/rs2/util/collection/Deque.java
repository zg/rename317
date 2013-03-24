package rs2.util.collection;


public class Deque {

    public Deque()
    {
        head = new Node();
        head.next = head;
        head.prev = head;
    }

    public void insertBack(Node entry)
    {
        if(entry.prev != null)
            entry.unlink();
        entry.prev = head.prev;
        entry.next = head;
        entry.prev.next = entry;
        entry.next.prev = entry;
    }

    public void insertFront(Node entry)
    {
        if(entry.prev != null)
            entry.unlink();
        entry.prev = head;
        entry.next = head.next;
        entry.prev.next = entry;
        entry.next.prev = entry;
    }

    public Node popFront()
    {
        Node entry = head.next;
        if(entry == head)
        {
            return null;
        } else
        {
            entry.unlink();
            return entry;
        }
    }

    public Node getFront()
    {
        Node entry = head.next;
        if(entry == head)
        {
            current = null;
            return null;
        } else
        {
            current = entry.next;
            return entry;
        }
    }

    public Node getBack()
    {
        Node entry = head.prev;
        if(entry == head)
        {
            current = null;
            return null;
        } else
        {
            current = entry.prev;
            return entry;
        }
    }

    public Node getNext()
    {
        Node entry = current;
        if(entry == head)
        {
            current = null;
            return null;
        } else
        {
            current = entry.next;
            return entry;
        }
    }

    public Node getPrevious()
    {
        Node entry = current;
        if(entry == head)
        {
            current = null;
            return null;
        }
        current = entry.prev;
            return entry;
    }

    public void clear()
    {
        if(head.next == head)
            return;
        do
        {
            Node entry = head.next;
            if(entry == head)
                return;
            entry.unlink();
        } while(true);
    }

    private final Node head;
    private Node current;
}
