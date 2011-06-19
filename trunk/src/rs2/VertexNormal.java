package rs2;

public class VertexNormal
{

    public VertexNormal()
    {
    }

    public int x;
    public int y;
    public int z;
    public int magnitude;

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
