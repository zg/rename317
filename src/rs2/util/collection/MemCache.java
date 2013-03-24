package rs2.util.collection;
import rs2.Signlink;

public class MemCache {

    public MemCache(int size)
    {
        queue_head = new QueueNode();
        usage_list = new Queue();
        max_size = size;
        free_slots = size;
        hash_table = new HashTable(1024);
    }

    public QueueNode get(long hash)
    {
        QueueNode node = (QueueNode) hash_table.get(hash);
        if(node != null)
        {
            usage_list.insertBack(node);
        }
        return node;
    }

    public void put(QueueNode entry, long hash)
    {
        try
        {
            if(free_slots == 0)
            {
                QueueNode dropEntry = usage_list.popFront();
                dropEntry.unlink();
                dropEntry.unlinkQueue();
                if(dropEntry == queue_head)
                {
                    dropEntry = usage_list.popFront();
                    dropEntry.unlink();
                    dropEntry.unlinkQueue();
                }
            } else
            {
                free_slots--;
            }
            hash_table.put(entry, hash);
            usage_list.insertBack(entry);
            return;
        }
        catch(RuntimeException runtimeexception)
        {
            Signlink.reporterror("MemCache.put, " + entry + ", " + hash + ", " + runtimeexception.toString());
        }
        throw new RuntimeException("Error Reported");
    }

    public void clear()
    {
        do
        {
            QueueNode entry = usage_list.popFront();
            if(entry != null)
            {
                entry.unlink();
                entry.unlinkQueue();
            } else {
                free_slots = max_size;
                return;
            }
        } while(true);
    }

    private final QueueNode queue_head;
    private final int max_size;
    private int free_slots;
    private final HashTable hash_table;
    private final Queue usage_list;
}
