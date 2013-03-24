package rs2.util.collection;

public class Queue {

    public Queue()
    {
        head = new QueueNode();
        head.queue_next = head;
        head.queue_prev = head;
    }

    public void insertBack(QueueNode queueNode)
    {
        if(queueNode.queue_prev != null)
            queueNode.unlinkQueue();
        queueNode.queue_prev = head.queue_prev;
        queueNode.queue_next = head;
        queueNode.queue_prev.queue_next = queueNode;
        queueNode.queue_next.queue_prev = queueNode;
    }

    public QueueNode popFront()
    {
        QueueNode entry = head.queue_next;
        if(entry == head)
        {
            return null;
        } else
        {
            entry.unlinkQueue();
            return entry;
        }
    }

    public QueueNode getFront()
    {
        QueueNode entry = head.queue_next;
        if(entry == head)
        {
            current = null;
            return null;
        } else
        {
            current = entry.queue_next;
            return entry;
        }
    }

    public QueueNode getNext()
    {
        QueueNode entry = current;
        if(entry == head)
        {
            current = null;
            return null;
        } else
        {
            current = entry.queue_next;
            return entry;
        }
    }

    public int getSize()
    {
        int i = 0;
        for(QueueNode queueNode = head.queue_next; queueNode != head; queueNode = queueNode.queue_next)
            i++;

        return i;
    }

    private final QueueNode head;
    private QueueNode current;
}
