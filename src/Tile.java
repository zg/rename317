// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 


public final class Tile extends Node {

    public Tile(int i, int j, int k)
    {
        entities = new InteractableObject[5];
        anIntArray1319 = new int[5];
        anInt1310 = tileZ = i;
        anInt1308 = j;
        anInt1309 = k;
    }

    int tileZ;
    final int anInt1308;
    final int anInt1309;
    final int anInt1310;
    public PlainTile myPlainTile;
    public ShapedTile shapedTile;
    public WallObject obj1;
    public WallDecoration obj2;
    public GroundDecoration obj3;
    public GroundItemTile groundItemTile;
    int entity_count;
    public final InteractableObject[] entities;
    final int[] anIntArray1319;
    int anInt1320;
    int logic_height;
    boolean aBoolean1322;
    boolean aBoolean1323;
    boolean aBoolean1324;
    int anInt1325;
    int anInt1326;
    int anInt1327;
    int anInt1328;
    public Tile tileBelow0;
}
