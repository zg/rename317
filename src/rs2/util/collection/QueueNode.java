package rs2.util.collection;


public class QueueNode extends Node {

    public final void unlinkQueue()
    {
        if(queue_prev == null)
        {
        } else
        {
            queue_prev.queue_next = queue_next;
            queue_next.queue_prev = queue_prev;
            queue_next = null;
            queue_prev = null;
        }
    }

    public QueueNode()
    {
    }

    public QueueNode queue_next;
    public QueueNode queue_prev;
}
