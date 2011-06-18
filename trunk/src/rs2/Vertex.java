package rs2;

public class Vertex
{

    public Vertex()
    {
    }

    public int x;
    int y;
    int z;
    int magnitude;

    public float getX() {
        if (magnitude == 0)
            return x / 256.0f;
        return (x / magnitude) / 256.0f;
    }

    public float getY() {
        if (magnitude == 0)
            return z / 256.0f;
        return (x / magnitude) / 256.0f;
    }

    public float getZ() {
        if (magnitude == 0)
            return y / 256.0f;
        return (x / magnitude) / 256.0f;
    }
}
