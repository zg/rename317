package rs2;


public class Tile extends Node {

    public boolean highlighted = false;

    public Tile(int z, int x, int y)
    {
        interactableObjects = new InteractableObject[5];
        anIntArray1319 = new int[5];
        anInt1310 = tileZ = z;//need to merge 1310 and tileZ
        anInt1308 = x;
        anInt1309 = y;
    }

    int tileZ;
    final int anInt1308;
    final int anInt1309;
    final int anInt1310;
    public PlainTile myPlainTile;
    public ShapedTile shapedTile;
    public WallObject wallObject;
    public WallDecoration wallDecoration;
    public GroundDecoration groundDecoration;
    public GroundItemTile groundItemTile;
    int entityCount;
    public final InteractableObject[] interactableObjects;
    final int[] anIntArray1319;
    int anInt1320;
    int logicHeight;
    boolean aBoolean1322;
    boolean aBoolean1323;
    boolean aBoolean1324;
    int anInt1325;
    int anInt1326;
    int anInt1327;
    int anInt1328;
    public Tile tileBelow0;
}
