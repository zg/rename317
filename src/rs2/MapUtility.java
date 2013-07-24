package rs2;

//Class4
public class MapUtility
{//Thanks Xaves

    public static int rotate_terrain_block_x(int x, int z, int orientation)
    {
        orientation &= 3;
        if(orientation == 0)
            return x;
        if(orientation == 1)
            return z;
        if(orientation == 2)
            return 7 - x;
        else
            return 7 - z;
    }

    public static int rotate_terrain_block_z(int x, int z, int orientation)
    {
        orientation &= 3;
        if(orientation == 0)
            return z;
        if(orientation == 1)
            return 7 - x;
        if(orientation == 2)
            return 7 - z;
        else
            return x;
    }

    public static int rotate_object_block_x(int x, int z, int width, int height, int orientation)
    {
        orientation &= 3;
        if(orientation == 0)
            return x;
        if(orientation == 1)
            return z;
        if(orientation == 2)
            return 7 - x - (width - 1);
        else
            return 7 - z - (height - 1);
    }

    public static int rotate_object_block_z(int x, int z, int width, int height, int orientation)
    {
        orientation &= 3;
        if(orientation == 0)
            return z;
        if(orientation == 1)
            return 7 - x - (width - 1);
        if(orientation == 2)
            return 7 - z - (height - 1);
        else
            return x;
    }

}
