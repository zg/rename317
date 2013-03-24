package rs2.util.collection;


import rs2.Signlink;

public class HashTable {

    public HashTable(int size)
    {
        this.size = size;
        cache = new Node[size];
        for(int _ctr = 0; _ctr < size; _ctr++)
        {
            Node hash_head = cache[_ctr] = new Node();
            hash_head.next = hash_head;
            hash_head.prev = hash_head;
        }

    }

    public Node get(long hash)
    {
        Node hash_match = cache[(int)(hash & (long)(size - 1))];
        for(Node entry = hash_match.next; entry != hash_match; entry = entry.next)
            if(entry.hash == hash)
                return entry;

        return null;
    }

    public void put(Node entry, long hash)
    {
        try
        {
            if(entry.prev != null)
                entry.unlink();
            Node hash_match = cache[(int)(hash & (long)(size - 1))];
            entry.prev = hash_match.prev;
            entry.next = hash_match;
            entry.prev.next = entry;
            entry.next.prev = entry;
            entry.hash = hash;
            return;
        }
        catch(RuntimeException runtimeexception)
        {
            Signlink.reporterror("HashTable.put, " + entry + ", " + hash + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    private final int size;
    private final Node[] cache;
}
