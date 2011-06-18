package rs2;


public class Deque {

    public Deque()
    {
        head = new Node();
        head.next = head;
        head.previous = head;
    }

    public void insertBack(Node node)
    {
        if(node.previous != null)
            node.unlink();
        node.previous = head.previous;
        node.next = head;
        node.previous.next = node;
        node.next.previous = node;
    }

    public void insertFront(Node node)
    {
        if(node.previous != null)
            node.unlink();
        node.previous = head;
        node.next = head.next;
        node.previous.next = node;
        node.next.previous = node;
    }

    public Node popFront()
    {
        Node node = head.next;
        if(node == head)
        {
            return null;
        } else
        {
            node.unlink();
            return node;
        }
    }

    public Node getFront()
    {
        Node node = head.next;
        if(node == head)
        {
            current = null;
            return null;
        } else
        {
            current = node.next;
            return node;
        }
    }

    public Node getBack()
    {
        Node node = head.previous;
        if(node == head)
        {
            current = null;
            return null;
        } else
        {
            current = node.previous;
            return node;
        }
    }

    public Node getNext()
    {
        Node node = current;
        if(node == head)
        {
            current = null;
            return null;
        } else
        {
            current = node.next;
            return node;
        }
    }

    public Node getPrevious()
    {
        Node node = current;
        if(node == head)
        {
            current = null;
            return null;
        }
        current = node.previous;
            return node;
    }

    public void clear()
    {
        if(head.next == head)
            return;
        do
        {
            Node node = head.next;
            if(node == head)
                return;
            node.unlink();
        } while(true);
    }

    private final Node head;
    private Node current;
}
