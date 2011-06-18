package rs2;

import org.lwjgl.util.vector.Vector3f;
import pgle.PglCubeStub;

public class SceneGraph {

    public SceneGraph(int heightmap[][][])
    {
        int length = 104;//was parameter
        int width = 104;//was parameter
        int height = 4;//was parameter
        interactableObjectCache = new InteractableObject[5000];
        anIntArray486 = new int[10000];
        anIntArray487 = new int[10000];
        zMapSize = height;
        xMapSize = width;
        yMapSize = length;
            tileArray = new Tile[height][width][length];
            anIntArrayArrayArray445 = new int[height][width + 1][length + 1];
            this.heightmap = heightmap;
            initToNull();
    }

    public static void nullLoader()
    {
        interactableObjects = null;
        cullingClusterPointer = null;
        cullingClusters = null;
        aClass19_477 = null;
        TILE_VISIBILITY_MAPS = null;
        TILE_VISIBILITY_MAP = null;
    }

    public void initToNull()
    {
        for(int z = 0; z < zMapSize; z++)
        {
            for(int x = 0; x < xMapSize; x++)
            {
                for(int y = 0; y < yMapSize; y++)
                    tileArray[z][x][y] = null;

            }

        }
        for(int l = 0; l < anInt472; l++)
        {
            for(int j1 = 0; j1 < cullingClusterPointer[l]; j1++)
                cullingClusters[l][j1] = null;

            cullingClusterPointer[l] = 0;
        }

        for(int k1 = 0; k1 < interactableObjectCacheCurrPos; k1++)
            interactableObjectCache[k1] = null;

        interactableObjectCacheCurrPos = 0;
        for(int l1 = 0; l1 < interactableObjects.length; l1++)
            interactableObjects[l1] = null;

    }

    public void resetTilesHL(int z)
    {
        anInt442 = z;
        for(int x = 0; x < xMapSize; x++)
        {
            for(int y = 0; y < yMapSize; y++)
                if(tileArray[z][x][y] == null)
                    tileArray[z][x][y] = new Tile(z, x, y);

        }

    }

    public void applyBridgeMode(int x, int y)
    {
        Tile level0_tile = tileArray[0][x][y];
        for(int _z = 0; _z < 3; _z++)
        {
            Tile tile = tileArray[_z][x][y] = tileArray[_z + 1][x][y];
            if(tile != null)
            {
                tile.tileZ--;
                for(int ptr = 0; ptr < tile.entityCount; ptr++)
                {
                    InteractableObject worldEntity = tile.interactableObjects[ptr];
                    if((worldEntity.uid >> 29 & 3) == 2 && worldEntity.xPos == x && worldEntity.yPos == y)
                        worldEntity.zPos--;
                }

            }
        }
        if(tileArray[0][x][y] == null)
            tileArray[0][x][y] = new Tile(0, x, y);
        tileArray[0][x][y].tileBelow0 = level0_tile;
        tileArray[3][x][y] = null;
    }

    public static void createCullingCluster(int z, int lowest_x, int lowest_y, int lowest_z, int highest_x, int highest_y, int highest_z,
                                 int search_mask)
    {
        CullingCluster culling_cluster = new CullingCluster();
        culling_cluster.tileStartX = lowest_x / 128;
        culling_cluster.tileEndX = highest_x / 128;
        culling_cluster.tileStartY = lowest_y / 128;
        culling_cluster.tileEndY = highest_y / 128;
        culling_cluster.searchMask = search_mask;
        culling_cluster.worldStartX = lowest_x;
        culling_cluster.worldEndX = highest_x;
        culling_cluster.worldStartY = lowest_y;
        culling_cluster.worldEndY = highest_y;
        culling_cluster.worldStartZ = highest_z;
        culling_cluster.worldEndZ = lowest_z;
        cullingClusters[z][cullingClusterPointer[z]++] = culling_cluster;
    }

    public void setTileLogicHeight(int z, int x, int y, int l_z)
    {
        Tile tile = tileArray[z][x][y];
        if(tile != null)
        {
            tileArray[z][x][y].logicHeight = l_z;
        }
    }

    public void addTile(int zz, int x, int y, int shapeA, int shapeB, int j1, int zA,
            int zB, int zD, int zC, int colourA, int colourB, int colourD, int colourC,
            int colourAA, int colourBA, int colourDA, int colourCA, int cRGB2, int RGBA)
    {
        if(shapeA == 0)
        {
            PlainTile plainTile = new PlainTile(colourA, colourB, colourD, colourC, -1, cRGB2, false);
            for(int heightLevel = zz; heightLevel >= 0; heightLevel--)
                if(tileArray[heightLevel][x][y] == null)
                    tileArray[heightLevel][x][y] = new Tile(heightLevel, x, y);

            tileArray[zz][x][y].myPlainTile = plainTile;
            return;
        }
        if(shapeA == 1)
        {
            PlainTile plainTile_1 = new PlainTile(colourAA, colourBA, colourDA, colourCA, j1, RGBA, zA == zB && zA == zD && zA == zC);
            for(int z = zz; z >= 0; z--)
                if(tileArray[z][x][y] == null)
                    tileArray[z][x][y] = new Tile(z, x, y);

            tileArray[zz][x][y].myPlainTile = plainTile_1;
            return;
        }
        ShapedTile shapedTile = new ShapedTile(y, colourAA, colourC, zD, j1, colourDA, shapeB, colourA, cRGB2, colourD, zC, zB, zA, shapeA, colourCA, colourBA, colourB, x, RGBA);
        for(int z = zz; z >= 0; z--)
            if(tileArray[z][x][y] == null)
                tileArray[z][x][y] = new Tile(z, x, y);

        tileArray[zz][x][y].shapedTile = shapedTile;
    }

    public void addGroundDecoration(int Z, int z3d, int Y, Entity class30_sub2_sub4, byte byte0, int uid,
                          int X)
    {
        if(class30_sub2_sub4 == null)
            return;
        GroundDecoration class49 = new GroundDecoration();
        class49.aClass30_Sub2_Sub4_814 = class30_sub2_sub4;
        class49.xPos = X * 128 + 64;
        class49.yPos = Y * 128 + 64;
        class49.zPos = z3d;
        class49.uid = uid;
        class49.objConf = byte0;
        if(tileArray[Z][X][Y] == null)
            tileArray[Z][X][Y] = new Tile(Z, X, Y);
        tileArray[Z][X][Y].groundDecoration = class49;
    }

    public void addGroundItemTile(int x, int uid, Entity secondGroundItem, int k, Entity thirdGroundItem, Entity firstGroundItem,
                          int z, int y)//todo - addGroundItemTile
    {
        GroundItemTile itemTile = new GroundItemTile();
        itemTile.firstGroundItem = firstGroundItem;
        itemTile.xPos = x * 128 + 64;
        itemTile.yPos = y * 128 + 64;
        itemTile.zPos = k;
        itemTile.uid = uid;
        itemTile.secondGroundItem = secondGroundItem;
        itemTile.thirdGroundItem = thirdGroundItem;
        int j1 = 0;
        Tile class30_sub3 = tileArray[z][x][y];
        if(class30_sub3 != null)
        {
            for(int k1 = 0; k1 < class30_sub3.entityCount; k1++)
                if(class30_sub3.interactableObjects[k1].aClass30_Sub2_Sub4_521 instanceof Model)
                {
                    int l1 = ((Model)class30_sub3.interactableObjects[k1].aClass30_Sub2_Sub4_521).anInt1654;
                    if(l1 > j1)
                        j1 = l1;
                }

        }
        itemTile.anInt52 = j1;
        if(tileArray[z][x][y] == null)
            tileArray[z][x][y] = new Tile(z, x, y);
        tileArray[z][x][y].groundItemTile = itemTile;
    }

    public void addWallObject(int i, Entity class30_sub2_sub4, int uid, int y, byte byte0, int x,
                          Entity class30_sub2_sub4_1, int i1, int j1, int k1)
    {
        if(class30_sub2_sub4 == null && class30_sub2_sub4_1 == null)
            return;
        WallObject wallObject = new WallObject();
        wallObject.uid = uid;
        wallObject.aByte281 = byte0;
        wallObject.xPos = x * 128 + 64;
        wallObject.yPos = y * 128 + 64;
        wallObject.zPos = i1;
        wallObject.aClass30_Sub2_Sub4_278 = class30_sub2_sub4;
        wallObject.aClass30_Sub2_Sub4_279 = class30_sub2_sub4_1;
        wallObject.orientation = i;
        wallObject.orientation1 = j1;
        for(int z = k1; z >= 0; z--)
            if(tileArray[z][x][y] == null)
                tileArray[z][x][y] = new Tile(z, x, y);

        tileArray[k1][x][y].wallObject = wallObject;
    }

    public void addWallDecoration(int i, int tileY, int face, int tileZ, int x3dOff, int z3d,
                          Entity entity, int tileX, byte obConfig, int y3dOff, int facebits)
    {
        if(entity == null)
            return;
        WallDecoration wallDecoration = new WallDecoration();
        wallDecoration.uid = i;
        wallDecoration.objConf = obConfig;
        wallDecoration.xPos = tileX * 128 + 64 + x3dOff;
        wallDecoration.yPos = tileY * 128 + 64 + y3dOff;
        wallDecoration.zPos = z3d;
        wallDecoration.myMob = entity;
        wallDecoration.configBits = facebits;
        wallDecoration.face = face;
        for(int k2 = tileZ; k2 >= 0; k2--)
            if(tileArray[k2][tileX][tileY] == null)
                tileArray[k2][tileX][tileY] = new Tile(k2, tileX, tileY);

        tileArray[tileZ][tileX][tileY].wallDecoration = wallDecoration;
    }

    public boolean addEntityB(int i, byte byte0, int j, int k, Entity class30_sub2_sub4, int l, int i1,
                             int j1, int k1, int l1)
    {
        if(class30_sub2_sub4 == null)
        {
            return true;
        } else
        {
            int i2 = l1 * 128 + 64 * l;
            int j2 = k1 * 128 + 64 * k;
            return addEntityC(i1, l1, k1, l, k, i2, j2, j, class30_sub2_sub4, j1, false, i, byte0);
        }
    }

    public boolean addEntityA(int i, int j, int k, int l, int i1, int j1,
                             int k1, Entity class30_sub2_sub4, boolean flag)
    {
        if(class30_sub2_sub4 == null)
            return true;
        int l1 = k1 - j1;
        int i2 = i1 - j1;
        int j2 = k1 + j1;
        int k2 = i1 + j1;
        if(flag)
        {
            if(j > 640 && j < 1408)
                k2 += 128;
            if(j > 1152 && j < 1920)
                j2 += 128;
            if(j > 1664 || j < 384)
                i2 -= 128;
            if(j > 128 && j < 896)
                l1 -= 128;
        }
        l1 /= 128;
        i2 /= 128;
        j2 /= 128;
        k2 /= 128;
        return addEntityC(i, l1, i2, (j2 - l1) + 1, (k2 - i2) + 1, k1, i1, k, class30_sub2_sub4, j, true, l, (byte)0);
    }

    public boolean addEntity(int j, int k, Entity class30_sub2_sub4, int l, int i1, int j1,
                             int k1, int l1, int i2, int j2, int k2)
    {
        return class30_sub2_sub4 == null || addEntityC(j, l1, k2, (i2 - l1) + 1, (i1 - k2) + 1, j1, k, k1, class30_sub2_sub4, l, true, j2, (byte) 0);
    }

    private boolean addEntityC(int z, int x, int y, int l, int i1, int j1, int k1,
            int l1, Entity class30_sub2_sub4, int i2, boolean flag, int j2, byte byte0)
    {
        for(int _x = x; _x < x + l; _x++)
        {
            for(int _y = y; _y < y + i1; _y++)
            {
                if(_x < 0 || _y < 0 || _x >= xMapSize || _y >= yMapSize)
                    return false;
                Tile class30_sub3 = tileArray[z][_x][_y];
                if(class30_sub3 != null && class30_sub3.entityCount >= 5)
                    return false;
            }

        }

        InteractableObject class28 = new InteractableObject();
        class28.uid = j2;
        class28.aByte530 = byte0;
        class28.zPos = z;
        class28.worldX = j1;
        class28.worldY = k1;
        class28.worldZ = l1;
        class28.aClass30_Sub2_Sub4_521 = class30_sub2_sub4;
        class28.anInt522 = i2;
        class28.xPos = x;
        class28.yPos = y;
        class28.anInt524 = (x + l) - 1;
        class28.anInt526 = (y + i1) - 1;
        org.peterbjornx.pgl2.model.Node node = new PglCubeStub(); //for now
        //System.out.println("addentity");
        if (flag)
            clientInstance.getPglWrapper().getRsTileManager().addPerFrame(node,z,x,y);
        else
            clientInstance.getPglWrapper().getRsTileManager().addPerRegion(node,z,x,y);
        node.setPosition(new Vector3f(j1-128*x,(-l1)-240*z,k1-128*y));
        for(int i3 = x; i3 < x + l; i3++)
        {
            for(int j3 = y; j3 < y + i1; j3++)
            {
                int k3 = 0;
                if(i3 > x)
                    k3++;
                if(i3 < (x + l) - 1)
                    k3 += 4;
                if(j3 > y)
                    k3 += 8;
                if(j3 < (y + i1) - 1)
                    k3 += 2;
                for(int l3 = z; l3 >= 0; l3--)
                    if(tileArray[l3][i3][j3] == null)
                        tileArray[l3][i3][j3] = new Tile(l3, i3, j3);

                Tile class30_sub3_1 = tileArray[z][i3][j3];
                class30_sub3_1.interactableObjects[class30_sub3_1.entityCount] = class28;
                class30_sub3_1.anIntArray1319[class30_sub3_1.entityCount] = k3;
                class30_sub3_1.anInt1320 |= k3;
                class30_sub3_1.entityCount++;
            }

        }

        if(flag)
            interactableObjectCache[interactableObjectCacheCurrPos++] = class28;
        return true;
    }

    public void clearInteractableObjectCache()
    {
        clientInstance.getPglWrapper().getRsTileManager().removePerFrame();
        for(int i = 0; i < interactableObjectCacheCurrPos; i++)
        {
            InteractableObject object5 = interactableObjectCache[i];
            method289(object5);
            interactableObjectCache[i] = null;
        }

        interactableObjectCacheCurrPos = 0;
    }

    private void method289(InteractableObject interactableObject)
    {
        for(int x = interactableObject.xPos; x <= interactableObject.anInt524; x++)
        {
            for(int y = interactableObject.yPos; y <= interactableObject.anInt526; y++)
            {
                Tile tile = tileArray[interactableObject.zPos][x][y];
                if(tile != null)
                {
                    for(int l = 0; l < tile.entityCount; l++)
                    {
                        if(tile.interactableObjects[l] != interactableObject)
                            continue;
                        tile.entityCount--;
                        for(int i1 = l; i1 < tile.entityCount; i1++)
                        {
                            tile.interactableObjects[i1] = tile.interactableObjects[i1 + 1];
                            tile.anIntArray1319[i1] = tile.anIntArray1319[i1 + 1];
                        }

                        tile.interactableObjects[tile.entityCount] = null;
                        break;
                    }

                    tile.anInt1320 = 0;
                    for(int j1 = 0; j1 < tile.entityCount; j1++)
                        tile.anInt1320 |= tile.anIntArray1319[j1];

                }
            }

        }

    }

    public void method290(int y, int k, int x, int z)
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null)
            return;
        WallDecoration wallDecoration = tile.wallDecoration;
        if(wallDecoration != null)
        {
            int j1 = x * 128 + 64;
            int k1 = y * 128 + 64;
            wallDecoration.xPos = j1 + ((wallDecoration.xPos - j1) * k) / 16;
            wallDecoration.yPos = k1 + ((wallDecoration.yPos - k1) * k) / 16;
        }
    }

    public void removeWallObject(int x, int z, int y)
    {
        Tile class30_sub3 = tileArray[z][x][y];
        if(class30_sub3 != null)
        {
            class30_sub3.wallObject = null;
        }
    }

    public void removeWallDecoration(int y, int z, int x)
    {
        Tile tile = tileArray[z][x][y];
        if(tile != null)
        {
            tile.wallDecoration = null;
        }
    }

    public void method293(int z, int x, int y)
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null)
            return;
        for(int j1 = 0; j1 < tile.entityCount; j1++)
        {
            InteractableObject interactableObject = tile.interactableObjects[j1];
            if((interactableObject.uid >> 29 & 3) == 2 && interactableObject.xPos == x && interactableObject.yPos == y)
            {
                method289(interactableObject);
                return;
            }
        }

    }

    public void removeGroundDecoration(int z, int y, int x)//todo - removeGroundDecoration?
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null)
            return;
        tile.groundDecoration = null;
    }

    public void removeGroundItemTile(int z, int x, int y)//todo - removeGroundItemTile
    {
        Tile tile = tileArray[z][x][y];
        if(tile != null)
        {
            tile.groundItemTile = null;
        }
    }

    public WallObject getWallObject(int z, int x, int y)//todo - getWallObject
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null)
            return null;
        else
            return tile.wallObject;
    }

    public WallDecoration getWallDecoration(int x, int y, int z)//todo - getWallDecoration
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null)
            return null;
        else
            return tile.wallDecoration;
    }

    public InteractableObject getInteractableObject(int x, int y, int z)//todo - getInteractableObject
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null)
            return null;
        for(int l = 0; l < tile.entityCount; l++)
        {
            InteractableObject interactableObject = tile.interactableObjects[l];
            if((interactableObject.uid >> 29 & 3) == 2 && interactableObject.xPos == x && interactableObject.yPos == y)
                return interactableObject;
        }
        return null;
    }

    public GroundDecoration getGroundDecoration(int y, int x, int z)//todo - getGroundDecoration
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null || tile.groundDecoration == null)
            return null;
        else
            return tile.groundDecoration;
    }

    public int getWallObjectUID(int z, int x, int y)//todo - getWallObjectUID
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null || tile.wallObject == null)
            return 0;
        else
            return tile.wallObject.uid;
    }

    public int getWallDecorationUID(int z, int x, int y)//todo - getWallDecorationUID
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null || tile.wallDecoration == null)
            return 0;
        else
            return tile.wallDecoration.uid;
    }

    public int getInteractableObjectUID(int z, int x, int y)//todo - getInteractableObjectUID
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null)
            return 0;
        for(int l = 0; l < tile.entityCount; l++)
        {
            InteractableObject interactableObject = tile.interactableObjects[l];
            if((interactableObject.uid >> 29 & 3) == 2 && interactableObject.xPos == x && interactableObject.yPos == y)
                return interactableObject.uid;
        }

        return 0;
    }

    public int getGroundDecorationUID(int z, int x, int y)//TODO getGroundDecorationUID
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null || tile.groundDecoration == null)
            return 0;
        else
            return tile.groundDecoration.uid;
    }

    public int getIDTAGForXYZ(int z, int x, int y, int interactableObjectUID)
    {
        Tile class30_sub3 = tileArray[z][x][y];
        if(class30_sub3 == null)
            return -1;
        if(class30_sub3.wallObject != null && class30_sub3.wallObject.uid == interactableObjectUID)
            return class30_sub3.wallObject.aByte281 & 0xff;
        if(class30_sub3.wallDecoration != null && class30_sub3.wallDecoration.uid == interactableObjectUID)
            return class30_sub3.wallDecoration.objConf & 0xff;
        if(class30_sub3.groundDecoration != null && class30_sub3.groundDecoration.uid == interactableObjectUID)
            return class30_sub3.groundDecoration.objConf & 0xff;
        for(int i1 = 0; i1 < class30_sub3.entityCount; i1++)
            if(class30_sub3.interactableObjects[i1].uid == interactableObjectUID)
                return class30_sub3.interactableObjects[i1].aByte530 & 0xff;

        return -1;
    }

    public void shadeModels(int l_x, int l_y, int l_z, int mag_multiplier, int lightness)
    {
        int dist_from_origin = (int)Math.sqrt(l_x * l_x + l_y * l_y + l_z * l_z);
        int l_magnitude = mag_multiplier * dist_from_origin >> 8;//Devide by 256 then times 768 wtf
        for(int _z = 0; _z < zMapSize; _z++)
        {
            for(int _x = 0; _x < xMapSize; _x++)
            {
                for(int _y = 0; _y < yMapSize; _y++)
                {
                    Tile tile = tileArray[_z][_x][_y];
                    if(tile != null)
                    {
                        WallObject class10 = tile.wallObject;
                        if(class10 != null && class10.aClass30_Sub2_Sub4_278 != null && class10.aClass30_Sub2_Sub4_278.vertexNormal != null)
                        {
                            method307(_z, 1, 1, _x, _y, (Model)class10.aClass30_Sub2_Sub4_278);
                            if(class10.aClass30_Sub2_Sub4_279 != null && class10.aClass30_Sub2_Sub4_279.vertexNormal != null)
                            {
                                method307(_z, 1, 1, _x, _y, (Model)class10.aClass30_Sub2_Sub4_279);
                                method308((Model)class10.aClass30_Sub2_Sub4_278, (Model)class10.aClass30_Sub2_Sub4_279, 0, 0, 0, false);
                                ((Model)class10.aClass30_Sub2_Sub4_279).doShading(lightness, l_magnitude, l_x, l_y, l_z);
                            }
                            ((Model)class10.aClass30_Sub2_Sub4_278).doShading(lightness, l_magnitude, l_x, l_y, l_z);
                        }
                        for(int k2 = 0; k2 < tile.entityCount; k2++)
                        {
                            InteractableObject class28 = tile.interactableObjects[k2];
                            if(class28 != null && class28.aClass30_Sub2_Sub4_521 != null && class28.aClass30_Sub2_Sub4_521.vertexNormal != null)
                            {
                                method307(_z, (class28.anInt524 - class28.xPos) + 1, (class28.anInt526 - class28.yPos) + 1, _x, _y, (Model)class28.aClass30_Sub2_Sub4_521);
                                ((Model)class28.aClass30_Sub2_Sub4_521).doShading(lightness, l_magnitude, l_x, l_y, l_z);
                            }
                        }

                        GroundDecoration class49 = tile.groundDecoration;
                        if(class49 != null && class49.aClass30_Sub2_Sub4_814.vertexNormal != null)
                        {
                            method306(_x, _z, (Model)class49.aClass30_Sub2_Sub4_814, _y);
                            ((Model)class49.aClass30_Sub2_Sub4_814).doShading(lightness, l_magnitude, l_x, l_y, l_z);
                        }
                    }
                }

            }

        }

    }

    private void method306(int x, int z, Model model, int y)
    {
        if(x < xMapSize)
        {
            Tile tile = tileArray[z][x + 1][y];
            if(tile != null && tile.groundDecoration != null && tile.groundDecoration.aClass30_Sub2_Sub4_814.vertexNormal != null)
                method308(model, (Model)tile.groundDecoration.aClass30_Sub2_Sub4_814, 128, 0, 0, true);
        }
        if(y < xMapSize)
        {
            Tile tile = tileArray[z][x][y + 1];
            if(tile != null && tile.groundDecoration != null && tile.groundDecoration.aClass30_Sub2_Sub4_814.vertexNormal != null)
                method308(model, (Model)tile.groundDecoration.aClass30_Sub2_Sub4_814, 0, 0, 128, true);
        }
        if(x < xMapSize && y < yMapSize)
        {
            Tile tile = tileArray[z][x + 1][y + 1];
            if(tile != null && tile.groundDecoration != null && tile.groundDecoration.aClass30_Sub2_Sub4_814.vertexNormal != null)
                method308(model, (Model)tile.groundDecoration.aClass30_Sub2_Sub4_814, 128, 0, 128, true);
        }
        if(x < xMapSize && y > 0)
        {
            Tile tile = tileArray[z][x + 1][y - 1];
            if(tile != null && tile.groundDecoration != null && tile.groundDecoration.aClass30_Sub2_Sub4_814.vertexNormal != null)
                method308(model, (Model)tile.groundDecoration.aClass30_Sub2_Sub4_814, 128, 0, -128, true);
        }
    }

    private void method307(int i, int j, int k, int l, int i1, Model model)
    {
        boolean flag = true;
        int j1 = l;
        int k1 = l + j;
        int l1 = i1 - 1;
        int i2 = i1 + k;
        for(int z = i; z <= i + 1; z++)
            if(z != zMapSize)
            {
                for(int x = j1; x <= k1; x++)
                    if(x >= 0 && x < xMapSize)
                    {
                        for(int y = l1; y <= i2; y++)
                            if(y >= 0 && y < yMapSize && (!flag || x >= k1 || y >= i2 || y < i1 && x != l))
                            {
                                Tile class30_sub3 = tileArray[z][x][y];
                                if(class30_sub3 != null)
                                {
                                    int i3 = (heightmap[z][x][y] + heightmap[z][x + 1][y] + heightmap[z][x][y + 1] + heightmap[z][x + 1][y + 1]) / 4 - (heightmap[i][l][i1] + heightmap[i][l + 1][i1] + heightmap[i][l][i1 + 1] + heightmap[i][l + 1][i1 + 1]) / 4;
                                    WallObject class10 = class30_sub3.wallObject;
                                    if(class10 != null && class10.aClass30_Sub2_Sub4_278 != null && class10.aClass30_Sub2_Sub4_278.vertexNormal != null)
                                        method308(model, (Model)class10.aClass30_Sub2_Sub4_278, (x - l) * 128 + (1 - j) * 64, i3, (y - i1) * 128 + (1 - k) * 64, flag);
                                    if(class10 != null && class10.aClass30_Sub2_Sub4_279 != null && class10.aClass30_Sub2_Sub4_279.vertexNormal != null)
                                        method308(model, (Model)class10.aClass30_Sub2_Sub4_279, (x - l) * 128 + (1 - j) * 64, i3, (y - i1) * 128 + (1 - k) * 64, flag);
                                    for(int j3 = 0; j3 < class30_sub3.entityCount; j3++)
                                    {
                                        InteractableObject class28 = class30_sub3.interactableObjects[j3];
                                        if(class28 != null && class28.aClass30_Sub2_Sub4_521 != null && class28.aClass30_Sub2_Sub4_521.vertexNormal != null)
                                        {
                                            int k3 = (class28.anInt524 - class28.xPos) + 1;
                                            int l3 = (class28.anInt526 - class28.yPos) + 1;
                                            method308(model, (Model)class28.aClass30_Sub2_Sub4_521, (class28.xPos - l) * 128 + (k3 - j) * 64, i3, (class28.yPos - i1) * 128 + (l3 - k) * 64, flag);
                                        }
                                    }

                                }
                            }

                    }

                j1--;
                flag = false;
            }

    }

    private void method308(Model model, Model model_1, int t_x, int t_Y, int k, boolean flag)
    {
        anInt488++;
        int l = 0;
        int ai[] = model_1.vertexX;
        int i1 = model_1.verticeCount;
        for(int j1 = 0; j1 < model.verticeCount; j1++)
        {
            VertexNormal vertexNormal = model.vertexNormal[j1];
            VertexNormal vertexNormal_1 = model.vertexNormalOffset[j1];
            if(vertexNormal_1.magnitude != 0)
            {
                int i2 = model.vertexY[j1] - t_Y;
                if(i2 <= model_1.maxY)
                {
                    int j2 = model.vertexX[j1] - t_x;
                    if(j2 >= model_1.minX && j2 <= model_1.maxX)
                    {
                        int k2 = model.vertexZ[j1] - k;
                        if(k2 >= model_1.minZ && k2 <= model_1.maxZ)
                        {
                            for(int l2 = 0; l2 < i1; l2++)
                            {
                                VertexNormal normal = model_1.vertexNormal[l2];
                                VertexNormal normal_offset = model_1.vertexNormalOffset[l2];
                                if(j2 == ai[l2] && k2 == model_1.vertexZ[l2] && i2 == model_1.vertexY[l2] && normal_offset.magnitude != 0)
                                {
                                    vertexNormal.x += normal_offset.x;
                                    vertexNormal.y += normal_offset.y;
                                    vertexNormal.z += normal_offset.z;
                                    vertexNormal.magnitude += normal_offset.magnitude;
                                    normal.x += vertexNormal_1.x;
                                    normal.y += vertexNormal_1.y;
                                    normal.z += vertexNormal_1.z;
                                    normal.magnitude += vertexNormal_1.magnitude;
                                    l++;
                                    anIntArray486[j1] = anInt488;
                                    anIntArray487[l2] = anInt488;
                                }
                            }

                        }
                    }
                }
            }
        }

        if(l < 3 || !flag)
            return;
        for(int k1 = 0; k1 < model.triangleCount; k1++)
            if(anIntArray486[model.triangleA[k1]] == anInt488 && anIntArray486[model.triangleB[k1]] == anInt488 && anIntArray486[model.triangleC[k1]] == anInt488)
                model.triangleDrawType[k1] = -1;

        for(int l1 = 0; l1 < model_1.triangleCount; l1++)
            if(anIntArray487[model_1.triangleA[l1]] == anInt488 && anIntArray487[model_1.triangleB[l1]] == anInt488 && anIntArray487[model_1.triangleC[l1]] == anInt488)
                model_1.triangleDrawType[l1] = -1;

    }

    public void drawMinimapTile(int pixels[], int drawOffset, int heightLevel, int x, int y)
    {
        int j = 512;//was parameter
        Tile class30_sub3 = tileArray[heightLevel][x][y];
        if(class30_sub3 == null)
            return;
        PlainTile plainTile = class30_sub3.myPlainTile;
        if(plainTile != null)
        {
            int j1 = plainTile.colourRGB;
            if(j1 == 0)
                return;
            for(int k1 = 0; k1 < 4; k1++)
            {
                pixels[drawOffset] = j1;
                pixels[drawOffset + 1] = j1;
                pixels[drawOffset + 2] = j1;
                pixels[drawOffset + 3] = j1;
                drawOffset += j;
            }

            return;
        }
        ShapedTile shapedTile = class30_sub3.shapedTile;
        if(shapedTile == null)
            return;
        int l1 = shapedTile.shapeA;
        int i2 = shapedTile.shapeB;
        int j2 = shapedTile.colourRGB;
        int k2 = shapedTile.colourRGBA;
        int ai1[] = anIntArrayArray489[l1];
        int ai2[] = anIntArrayArray490[i2];
        int l2 = 0;
        if(j2 != 0)
        {
            for(int i3 = 0; i3 < 4; i3++)
            {
                pixels[drawOffset] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                pixels[drawOffset + 1] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                pixels[drawOffset + 2] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                pixels[drawOffset + 3] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                drawOffset += j;
            }

            return;
        }
        for(int j3 = 0; j3 < 4; j3++)
        {
            if(ai1[ai2[l2++]] != 0)
                pixels[drawOffset] = k2;
            if(ai1[ai2[l2++]] != 0)
                pixels[drawOffset + 1] = k2;
            if(ai1[ai2[l2++]] != 0)
                pixels[drawOffset + 2] = k2;
            if(ai1[ai2[l2++]] != 0)
                pixels[drawOffset + 3] = k2;
            drawOffset += j;
        }

    }

    public static void initialize(int min_z, int max_z, int daW, int daH, int ai[])
    {
        left = 0;
        top = 0;
        right = daW;
        bottom = daH;
        midX = daW / 2;
        midY = daH / 2;
        boolean aflag[][][][] = new boolean[9][32][53][53];
        for(int yAngle = 128; yAngle <= 384; yAngle += 32)
        {
            for(int xAngle = 0; xAngle < 2048; xAngle += 64)
            {
                yCurveSine = Model.SINE[yAngle];
                yCurveCosine = Model.COSINE[yAngle];
                xCurveSine = Model.SINE[xAngle];
                xCurveCosine = Model.COSINE[xAngle];
                int yAnglePointer = (yAngle - 128) / 32;
                int xAnglePointer = xAngle / 64;
                for(int x = -26; x <= 26; x++)
                {
                    for(int y = -26; y <= 26; y++)
                    {
                        int worldX = x * 128;
                        int worldY = y * 128;
                        boolean isVisible = false;
                        for(int worldZ = -min_z; worldZ <= max_z; worldZ += 128)
                        {
                            if(!isOnScreen(ai[yAnglePointer] + worldZ, worldY, worldX))
                                continue;
                            isVisible = true;
                            break;
                        }

                        aflag[yAnglePointer][xAnglePointer][x + 25 + 1][y + 25 + 1] = isVisible;
                    }

                }

            }

        }

        for(int k1 = 0; k1 < 8; k1++)
        {
            for(int i2 = 0; i2 < 32; i2++)
            {
                for(int k2 = -25; k2 < 25; k2++)
                {
                    for(int i3 = -25; i3 < 25; i3++)
                    {
                        boolean flag1 = false;
label0:
                        for(int l3 = -1; l3 <= 1; l3++)
                        {
                            for(int j4 = -1; j4 <= 1; j4++)
                            {
                                if(aflag[k1][i2][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1])
                                    flag1 = true;
                                else
                                if(aflag[k1][(i2 + 1) % 31][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1])
                                    flag1 = true;
                                else
                                if(aflag[k1 + 1][i2][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1])
                                {
                                    flag1 = true;
                                } else
                                {
                                    if(!aflag[k1 + 1][(i2 + 1) % 31][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1])
                                        continue;
                                    flag1 = true;
                                }
                                break label0;
                            }

                        }

                        TILE_VISIBILITY_MAPS[k1][i2][k2 + 25][i3 + 25] = flag1;
                    }

                }

            }

        }

    }

    private static boolean isOnScreen(int z, int y, int x)
    {
        int l = y * xCurveSine + x * xCurveCosine >> 16;
        int i1 = y * xCurveCosine - x * xCurveSine >> 16;
        int j1 = z * yCurveSine + i1 * yCurveCosine >> 16;
        int k1 = z * yCurveCosine - i1 * yCurveSine >> 16;
        if(j1 < 50 || j1 > 3500)
            return false;
        int l1 = midX + (l << 9) / j1;
        int i2 = midY + (k1 << 9) / j1;
        return l1 >= left && l1 <= right && i2 >= top && i2 <= bottom;
    }

    public void setClick(int i, int j)
    {
        isClicked = true;
        clickX = j;
        clickY = i;
        clickedTileX = -1;
        clickedTileY = -1;
    }

    public void render(int xCampos, int yCampos, int xCurve, int zCampos, int plane, int yCurve)
    {
        if(xCampos < 0)
            xCampos = 0;
        else
        if(xCampos >= xMapSize * 128)
            xCampos = xMapSize * 128 - 1;
        if(yCampos < 0)
            yCampos = 0;
        else
        if(yCampos >= yMapSize * 128)
            yCampos = yMapSize * 128 - 1;
        anInt448++;
        yCurveSine = Model.SINE[yCurve];
        yCurveCosine = Model.COSINE[yCurve];
        xCurveSine = Model.SINE[xCurve];
        xCurveCosine = Model.COSINE[xCurve];
        TILE_VISIBILITY_MAP = TILE_VISIBILITY_MAPS[(yCurve - 128) / 32][xCurve / 64];
        xCameraPosition = xCampos;
        zCameraPosition = zCampos;
        yCameraPosition = yCampos;
        xCameraPositionTile = xCampos / 128;
        yCameraPositionTile = yCampos / 128;
        SceneGraph.plane = plane;
        anInt449 = xCameraPositionTile - 25;
        if(anInt449 < 0)
            anInt449 = 0;
        anInt451 = yCameraPositionTile - 25;
        if(anInt451 < 0)
            anInt451 = 0;
        anInt450 = xCameraPositionTile + 25;
        if(anInt450 > xMapSize)
            anInt450 = xMapSize;
        anInt452 = yCameraPositionTile + 25;
        if(anInt452 > yMapSize)
            anInt452 = yMapSize;
        process_culling();
        anInt446 = 0;
        for(int z = anInt442; z < zMapSize; z++)
        {
            Tile floorTiles[][] = tileArray[z];
            for(int x = anInt449; x < anInt450; x++)
            {
                for(int y = anInt451; y < anInt452; y++)
                {
                    Tile singleTile = floorTiles[x][y];
                    if(singleTile != null)
                        if(singleTile.logicHeight > plane || !TILE_VISIBILITY_MAP[(x - xCameraPositionTile) + 25][(y - yCameraPositionTile) + 25] && heightmap[z][x][y] - zCampos < 2000)
                        {
                            singleTile.aBoolean1322 = false;
                            singleTile.aBoolean1323 = false;
                            singleTile.anInt1325 = 0;
                        } else
                        {
                            singleTile.aBoolean1322 = true;
                            singleTile.aBoolean1323 = true;
                            singleTile.aBoolean1324 = singleTile.entityCount > 0;
                            anInt446++;
                        }
                }

            }

        }

        for(int z = anInt442; z < zMapSize; z++)
        {
            Tile floorTiles[][] = tileArray[z];
            for(int l2 = -25; l2 <= 0; l2++)
            {
                int x = xCameraPositionTile + l2;
                int x2 = xCameraPositionTile - l2;
                if(x >= anInt449 || x2 < anInt450)
                {
                    for(int i4 = -25; i4 <= 0; i4++)
                    {
                        int y = yCameraPositionTile + i4;
                        int y2 = yCameraPositionTile - i4;
                        if(x >= anInt449)
                        {
                            if(y >= anInt451)
                            {
                                Tile class30_sub3_1 = floorTiles[x][y];
                                if(class30_sub3_1 != null && class30_sub3_1.aBoolean1322)
                                    renderTileF(class30_sub3_1, true);
                            }
                            if(y2 < anInt452)
                            {
                                Tile class30_sub3_2 = floorTiles[x][y2];
                                if(class30_sub3_2 != null && class30_sub3_2.aBoolean1322)
                                    renderTileF(class30_sub3_2, true);
                            }
                        }
                        if(x2 < anInt450)
                        {
                            if(y >= anInt451)
                            {
                                Tile class30_sub3_3 = floorTiles[x2][y];
                                if(class30_sub3_3 != null && class30_sub3_3.aBoolean1322)
                                    renderTileF(class30_sub3_3, true);
                            }
                            if(y2 < anInt452)
                            {
                                Tile class30_sub3_4 = floorTiles[x2][y2];
                                if(class30_sub3_4 != null && class30_sub3_4.aBoolean1322)
                                    renderTileF(class30_sub3_4, true);
                            }
                        }
                        if(anInt446 == 0)
                        {
                            isClicked = false;
                            return;
                        }
                    }

                }
            }

        }

        for(int j2 = anInt442; j2 < zMapSize; j2++)
        {
            Tile aclass30_sub3_2[][] = tileArray[j2];
            for(int j3 = -25; j3 <= 0; j3++)
            {
                int l3 = xCameraPositionTile + j3;
                int j4 = xCameraPositionTile - j3;
                if(l3 >= anInt449 || j4 < anInt450)
                {
                    for(int l4 = -25; l4 <= 0; l4++)
                    {
                        int j5 = yCameraPositionTile + l4;
                        int k5 = yCameraPositionTile - l4;
                        if(l3 >= anInt449)
                        {
                            if(j5 >= anInt451)
                            {
                                Tile class30_sub3_5 = aclass30_sub3_2[l3][j5];
                                if(class30_sub3_5 != null && class30_sub3_5.aBoolean1322)
                                    renderTileF(class30_sub3_5, false);
                            }
                            if(k5 < anInt452)
                            {
                                Tile class30_sub3_6 = aclass30_sub3_2[l3][k5];
                                if(class30_sub3_6 != null && class30_sub3_6.aBoolean1322)
                                    renderTileF(class30_sub3_6, false);
                            }
                        }
                        if(j4 < anInt450)
                        {
                            if(j5 >= anInt451)
                            {
                                Tile class30_sub3_7 = aclass30_sub3_2[j4][j5];
                                if(class30_sub3_7 != null && class30_sub3_7.aBoolean1322)
                                    renderTileF(class30_sub3_7, false);
                            }
                            if(k5 < anInt452)
                            {
                                Tile class30_sub3_8 = aclass30_sub3_2[j4][k5];
                                if(class30_sub3_8 != null && class30_sub3_8.aBoolean1322)
                                    renderTileF(class30_sub3_8, false);
                            }
                        }
                        if(anInt446 == 0)
                        {
                            isClicked = false;
                            return;
                        }
                    }

                }
            }

        }

        isClicked = false;
    }

    private void renderTileF(Tile class30_sub3, boolean flag)
    {
        aClass19_477.insertHead(class30_sub3);
        do
        {
            Tile TILE;
            do
            {
                TILE = (Tile)aClass19_477.popHead();
                if(TILE == null)
                    return;
            } while(!TILE.aBoolean1323);
            int X = TILE.anInt1308;
            int Y = TILE.anInt1309;
            int k = TILE.tileZ;
            int l = TILE.anInt1310;
            Tile aclass30_sub3[][] = tileArray[k];
            if(TILE.aBoolean1322)
            {
                if(flag)
                {
                    if(k > 0)
                    {
                        Tile class30_sub3_2 = tileArray[k - 1][X][Y];
                        if(class30_sub3_2 != null && class30_sub3_2.aBoolean1323)
                            continue;
                    }
                    if(X <= xCameraPositionTile && X > anInt449)
                    {
                        Tile class30_sub3_3 = aclass30_sub3[X - 1][Y];
                        if(class30_sub3_3 != null && class30_sub3_3.aBoolean1323 && (class30_sub3_3.aBoolean1322 || (TILE.anInt1320 & 1) == 0))
                            continue;
                    }
                    if(X >= xCameraPositionTile && X < anInt450 - 1)
                    {
                        Tile class30_sub3_4 = aclass30_sub3[X + 1][Y];
                        if(class30_sub3_4 != null && class30_sub3_4.aBoolean1323 && (class30_sub3_4.aBoolean1322 || (TILE.anInt1320 & 4) == 0))
                            continue;
                    }
                    if(Y <= yCameraPositionTile && Y > anInt451)
                    {
                        Tile class30_sub3_5 = aclass30_sub3[X][Y - 1];
                        if(class30_sub3_5 != null && class30_sub3_5.aBoolean1323 && (class30_sub3_5.aBoolean1322 || (TILE.anInt1320 & 8) == 0))
                            continue;
                    }
                    if(Y >= yCameraPositionTile && Y < anInt452 - 1)
                    {
                        Tile class30_sub3_6 = aclass30_sub3[X][Y + 1];
                        if(class30_sub3_6 != null && class30_sub3_6.aBoolean1323 && (class30_sub3_6.aBoolean1322 || (TILE.anInt1320 & 2) == 0))
                            continue;
                    }
                } else
                {
                    flag = true;
                }
                TILE.aBoolean1322 = false;
                if(TILE.tileBelow0 != null)
                {
                    Tile tile = TILE.tileBelow0;
                    if(tile.myPlainTile != null)
                    {
                        if(!method320(0, X, Y))
                            renderTile(tile.myPlainTile, 0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, X, Y);
                    } else
                    if(tile.shapedTile != null && !method320(0, X, Y))
                        drawShapedTile(X, yCurveSine, xCurveSine, tile.shapedTile, yCurveCosine, Y, xCurveCosine);
                    WallObject class10 = tile.wallObject;
                    if(class10 != null)
                        class10.aClass30_Sub2_Sub4_278.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class10.xPos - xCameraPosition, class10.zPos - zCameraPosition, class10.yPos - yCameraPosition, class10.uid);
                    for(int i2 = 0; i2 < tile.entityCount; i2++)
                    {
                        InteractableObject class28 = tile.interactableObjects[i2];
                        if(class28 != null)
                            class28.aClass30_Sub2_Sub4_521.renderAtPoint(class28.anInt522, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class28.worldX - xCameraPosition, class28.worldZ - zCameraPosition, class28.worldY - yCameraPosition, class28.uid);
                    }

                }
                boolean flag1 = false;
                if(TILE.myPlainTile != null)
                {
                    if(!method320(l, X, Y))
                    {
                        flag1 = true;
                        renderTile(TILE.myPlainTile, l, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, X, Y);
                    }
                } else
                if(TILE.shapedTile != null && !method320(l, X, Y))
                {
                    flag1 = true;
                    drawShapedTile(X, yCurveSine, xCurveSine, TILE.shapedTile, yCurveCosine, Y, xCurveCosine);
                }
                int j1 = 0;
                int j2 = 0;
                WallObject wallObject = TILE.wallObject;
                WallDecoration wallDecoration = TILE.wallDecoration;
                if(wallObject != null || wallDecoration != null)
                {
                    if(xCameraPositionTile == X)
                        j1++;
                    else
                    if(xCameraPositionTile < X)
                        j1 += 2;
                    if(yCameraPositionTile == Y)
                        j1 += 3;
                    else
                    if(yCameraPositionTile > Y)
                        j1 += 6;
                    j2 = anIntArray478[j1];
                    TILE.anInt1328 = anIntArray480[j1];
                }
                if(wallObject != null)
                {
                    if((wallObject.orientation & anIntArray479[j1]) != 0)
                    {
                        if(wallObject.orientation == 16)
                        {
                            TILE.anInt1325 = 3;
                            TILE.anInt1326 = anIntArray481[j1];
                            TILE.anInt1327 = 3 - TILE.anInt1326;
                        } else
                        if(wallObject.orientation == 32)
                        {
                            TILE.anInt1325 = 6;
                            TILE.anInt1326 = anIntArray482[j1];
                            TILE.anInt1327 = 6 - TILE.anInt1326;
                        } else
                        if(wallObject.orientation == 64)
                        {
                            TILE.anInt1325 = 12;
                            TILE.anInt1326 = anIntArray483[j1];
                            TILE.anInt1327 = 12 - TILE.anInt1326;
                        } else
                        {
                            TILE.anInt1325 = 9;
                            TILE.anInt1326 = anIntArray484[j1];
                            TILE.anInt1327 = 9 - TILE.anInt1326;
                        }
                    } else
                    {
                        TILE.anInt1325 = 0;
                    }
                    if((wallObject.orientation & j2) != 0 && !method321(l, X, Y, wallObject.orientation))
                        wallObject.aClass30_Sub2_Sub4_278.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, wallObject.xPos - xCameraPosition, wallObject.zPos - zCameraPosition, wallObject.yPos - yCameraPosition, wallObject.uid);
                    if((wallObject.orientation1 & j2) != 0 && !method321(l, X, Y, wallObject.orientation1))
                        wallObject.aClass30_Sub2_Sub4_279.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, wallObject.xPos - xCameraPosition, wallObject.zPos - zCameraPosition, wallObject.yPos - yCameraPosition, wallObject.uid);
                }
                if(wallDecoration != null && !method322(l, X, Y, wallDecoration.myMob.modelHeight))
                    if((wallDecoration.configBits & j2) != 0)
                        wallDecoration.myMob.renderAtPoint(wallDecoration.face, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, wallDecoration.xPos - xCameraPosition, wallDecoration.zPos - zCameraPosition, wallDecoration.yPos - yCameraPosition, wallDecoration.uid);
                    else
                    if((wallDecoration.configBits & 0x300) != 0)
                    {
                        int j4 = wallDecoration.xPos - xCameraPosition;
                        int l5 = wallDecoration.zPos - zCameraPosition;
                        int k6 = wallDecoration.yPos - yCameraPosition;
                        int i8 = wallDecoration.face;
                        int k9;
                        if(i8 == 1 || i8 == 2)
                            k9 = -j4;
                        else
                            k9 = j4;
                        int k10;
                        if(i8 == 2 || i8 == 3)
                            k10 = -k6;
                        else
                            k10 = k6;
                        if((wallDecoration.configBits & 0x100) != 0 && k10 < k9)
                        {
                            int i11 = j4 + faceXOffset2[i8];
                            int k11 = k6 + faceYOffset2[i8];
                            wallDecoration.myMob.renderAtPoint(i8 * 512 + 256, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, i11, l5, k11, wallDecoration.uid);
                        }
                        if((wallDecoration.configBits & 0x200) != 0 && k10 > k9)
                        {
                            int j11 = j4 + faceXOffset3[i8];
                            int l11 = k6 + faceYOffset3[i8];
                            wallDecoration.myMob.renderAtPoint(i8 * 512 + 1280 & 0x7ff, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, j11, l5, l11, wallDecoration.uid);
                        }
                    }
                if(flag1)
                {
                    GroundDecoration groundDecoration = TILE.groundDecoration;
                    if(groundDecoration != null)
                        groundDecoration.aClass30_Sub2_Sub4_814.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, groundDecoration.xPos - xCameraPosition, groundDecoration.zPos - zCameraPosition, groundDecoration.yPos - yCameraPosition, groundDecoration.uid);
                    GroundItemTile object4_1 = TILE.groundItemTile;
                    if(object4_1 != null && object4_1.anInt52 == 0)
                    {
                        if(object4_1.secondGroundItem != null)
                            object4_1.secondGroundItem.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, object4_1.xPos - xCameraPosition, object4_1.zPos - zCameraPosition, object4_1.yPos - yCameraPosition, object4_1.uid);
                        if(object4_1.thirdGroundItem != null)
                            object4_1.thirdGroundItem.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, object4_1.xPos - xCameraPosition, object4_1.zPos - zCameraPosition, object4_1.yPos - yCameraPosition, object4_1.uid);
                        if(object4_1.firstGroundItem != null)
                            object4_1.firstGroundItem.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, object4_1.xPos - xCameraPosition, object4_1.zPos - zCameraPosition, object4_1.yPos - yCameraPosition, object4_1.uid);
                    }
                }
                int k4 = TILE.anInt1320;
                if(k4 != 0)
                {
                    if(X < xCameraPositionTile && (k4 & 4) != 0)
                    {
                        Tile class30_sub3_17 = aclass30_sub3[X + 1][Y];
                        if(class30_sub3_17 != null && class30_sub3_17.aBoolean1323)
                            aClass19_477.insertHead(class30_sub3_17);
                    }
                    if(Y < yCameraPositionTile && (k4 & 2) != 0)
                    {
                        Tile class30_sub3_18 = aclass30_sub3[X][Y + 1];
                        if(class30_sub3_18 != null && class30_sub3_18.aBoolean1323)
                            aClass19_477.insertHead(class30_sub3_18);
                    }
                    if(X > xCameraPositionTile && (k4 & 1) != 0)
                    {
                        Tile class30_sub3_19 = aclass30_sub3[X - 1][Y];
                        if(class30_sub3_19 != null && class30_sub3_19.aBoolean1323)
                            aClass19_477.insertHead(class30_sub3_19);
                    }
                    if(Y > yCameraPositionTile && (k4 & 8) != 0)
                    {
                        Tile class30_sub3_20 = aclass30_sub3[X][Y - 1];
                        if(class30_sub3_20 != null && class30_sub3_20.aBoolean1323)
                            aClass19_477.insertHead(class30_sub3_20);
                    }
                }
            }
            if(TILE.anInt1325 != 0)
            {
                boolean flag2 = true;
                for(int k1 = 0; k1 < TILE.entityCount; k1++)
                {
                    if(TILE.interactableObjects[k1].anInt528 == anInt448 || (TILE.anIntArray1319[k1] & TILE.anInt1325) != TILE.anInt1326)
                        continue;
                    flag2 = false;
                    break;
                }

                if(flag2)
                {
                    WallObject class10_1 = TILE.wallObject;
                    if(!method321(l, X, Y, class10_1.orientation))
                        class10_1.aClass30_Sub2_Sub4_278.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class10_1.xPos - xCameraPosition, class10_1.zPos - zCameraPosition, class10_1.yPos - yCameraPosition, class10_1.uid);
                    TILE.anInt1325 = 0;
                }
            }
            if(TILE.aBoolean1324)
                try
                {
                    int i1 = TILE.entityCount;
                    TILE.aBoolean1324 = false;
                    int l1 = 0;
label0:
                    for(int k2 = 0; k2 < i1; k2++)
                    {
                        InteractableObject interactableObject = TILE.interactableObjects[k2];
                        if(interactableObject.anInt528 == anInt448)
                            continue;
                        for(int k3 = interactableObject.xPos; k3 <= interactableObject.anInt524; k3++)
                        {
                            for(int l4 = interactableObject.yPos; l4 <= interactableObject.anInt526; l4++)
                            {
                                Tile class30_sub3_21 = aclass30_sub3[k3][l4];
                                if(class30_sub3_21.aBoolean1322)
                                {
                                    TILE.aBoolean1324 = true;
                                } else
                                {
                                    if(class30_sub3_21.anInt1325 == 0)
                                        continue;
                                    int l6 = 0;
                                    if(k3 > interactableObject.xPos)
                                        l6++;
                                    if(k3 < interactableObject.anInt524)
                                        l6 += 4;
                                    if(l4 > interactableObject.yPos)
                                        l6 += 8;
                                    if(l4 < interactableObject.anInt526)
                                        l6 += 2;
                                    if((l6 & class30_sub3_21.anInt1325) != TILE.anInt1327)
                                        continue;
                                    TILE.aBoolean1324 = true;
                                }
                                continue label0;
                            }

                        }

                        interactableObjects[l1++] = interactableObject;
                        int i5 = xCameraPositionTile - interactableObject.xPos;
                        int i6 = interactableObject.anInt524 - xCameraPositionTile;
                        if(i6 > i5)
                            i5 = i6;
                        int i7 = yCameraPositionTile - interactableObject.yPos;
                        int j8 = interactableObject.anInt526 - yCameraPositionTile;
                        if(j8 > i7)
                            interactableObject.anInt527 = i5 + j8;
                        else
                            interactableObject.anInt527 = i5 + i7;
                    }

                    while(l1 > 0) 
                    {
                        int i3 = -50;
                        int l3 = -1;
                        for(int j5 = 0; j5 < l1; j5++)
                        {
                            InteractableObject interactableObject = interactableObjects[j5];
                            if(interactableObject.anInt528 != anInt448)
                                if(interactableObject.anInt527 > i3)
                                {
                                    i3 = interactableObject.anInt527;
                                    l3 = j5;
                                } else
                                if(interactableObject.anInt527 == i3)
                                {
                                    int j7 = interactableObject.worldX - xCameraPosition;
                                    int k8 = interactableObject.worldY - yCameraPosition;
                                    int l9 = interactableObjects[l3].worldX - xCameraPosition;
                                    int l10 = interactableObjects[l3].worldY - yCameraPosition;
                                    if(j7 * j7 + k8 * k8 > l9 * l9 + l10 * l10)
                                        l3 = j5;
                                }
                        }

                        if(l3 == -1)
                            break;
                        InteractableObject class28_3 = interactableObjects[l3];
                        class28_3.anInt528 = anInt448;
                        if(!method323(l, class28_3.xPos, class28_3.anInt524, class28_3.yPos, class28_3.anInt526, class28_3.aClass30_Sub2_Sub4_521.modelHeight))
                            class28_3.aClass30_Sub2_Sub4_521.renderAtPoint(class28_3.anInt522, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class28_3.worldX - xCameraPosition, class28_3.worldZ - zCameraPosition, class28_3.worldY - yCameraPosition, class28_3.uid);
                        for(int k7 = class28_3.xPos; k7 <= class28_3.anInt524; k7++)
                        {
                            for(int l8 = class28_3.yPos; l8 <= class28_3.anInt526; l8++)
                            {
                                Tile class30_sub3_22 = aclass30_sub3[k7][l8];
                                if(class30_sub3_22.anInt1325 != 0)
                                    aClass19_477.insertHead(class30_sub3_22);
                                else
                                if((k7 != X || l8 != Y) && class30_sub3_22.aBoolean1323)
                                    aClass19_477.insertHead(class30_sub3_22);
                            }

                        }

                    }
                    if(TILE.aBoolean1324)
                        continue;
                }
                catch(Exception _ex)
                {
                    TILE.aBoolean1324 = false;
                }
            if(!TILE.aBoolean1323 || TILE.anInt1325 != 0)
                continue;
            if(X <= xCameraPositionTile && X > anInt449)
            {
                Tile class30_sub3_8 = aclass30_sub3[X - 1][Y];
                if(class30_sub3_8 != null && class30_sub3_8.aBoolean1323)
                    continue;
            }
            if(X >= xCameraPositionTile && X < anInt450 - 1)
            {
                Tile class30_sub3_9 = aclass30_sub3[X + 1][Y];
                if(class30_sub3_9 != null && class30_sub3_9.aBoolean1323)
                    continue;
            }
            if(Y <= yCameraPositionTile && Y > anInt451)
            {
                Tile class30_sub3_10 = aclass30_sub3[X][Y - 1];
                if(class30_sub3_10 != null && class30_sub3_10.aBoolean1323)
                    continue;
            }
            if(Y >= yCameraPositionTile && Y < anInt452 - 1)
            {
                Tile class30_sub3_11 = aclass30_sub3[X][Y + 1];
                if(class30_sub3_11 != null && class30_sub3_11.aBoolean1323)
                    continue;
            }
            TILE.aBoolean1323 = false;
            anInt446--;
            GroundItemTile object4 = TILE.groundItemTile;
            if(object4 != null && object4.anInt52 != 0)
            {
                if(object4.secondGroundItem != null)
                    object4.secondGroundItem.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, object4.xPos - xCameraPosition, object4.zPos - zCameraPosition - object4.anInt52, object4.yPos - yCameraPosition, object4.uid);
                if(object4.thirdGroundItem != null)
                    object4.thirdGroundItem.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, object4.xPos - xCameraPosition, object4.zPos - zCameraPosition - object4.anInt52, object4.yPos - yCameraPosition, object4.uid);
                if(object4.firstGroundItem != null)
                    object4.firstGroundItem.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, object4.xPos - xCameraPosition, object4.zPos - zCameraPosition - object4.anInt52, object4.yPos - yCameraPosition, object4.uid);
            }
            if(TILE.anInt1328 != 0)
            {
                WallDecoration wallDecoration = TILE.wallDecoration;
                if(wallDecoration != null && !method322(l, X, Y, wallDecoration.myMob.modelHeight))
                    if((wallDecoration.configBits & TILE.anInt1328) != 0)
                        wallDecoration.myMob.renderAtPoint(wallDecoration.face, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, wallDecoration.xPos - xCameraPosition, wallDecoration.zPos - zCameraPosition, wallDecoration.yPos - yCameraPosition, wallDecoration.uid);
                    else
                    if((wallDecoration.configBits & 0x300) != 0)
                    {
                        int l2 = wallDecoration.xPos - xCameraPosition;
                        int j3 = wallDecoration.zPos - zCameraPosition;
                        int i4 = wallDecoration.yPos - yCameraPosition;
                        int k5 = wallDecoration.face;
                        int j6;
                        if(k5 == 1 || k5 == 2)
                            j6 = -l2;
                        else
                            j6 = l2;
                        int l7;
                        if(k5 == 2 || k5 == 3)
                            l7 = -i4;
                        else
                            l7 = i4;
                        if((wallDecoration.configBits & 0x100) != 0 && l7 >= j6)
                        {
                            int i9 = l2 + faceXOffset2[k5];
                            int i10 = i4 + faceYOffset2[k5];
                            wallDecoration.myMob.renderAtPoint(k5 * 512 + 256, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, i9, j3, i10, wallDecoration.uid);
                        }
                        if((wallDecoration.configBits & 0x200) != 0 && l7 <= j6)
                        {
                            int j9 = l2 + faceXOffset3[k5];
                            int j10 = i4 + faceYOffset3[k5];
                            wallDecoration.myMob.renderAtPoint(k5 * 512 + 1280 & 0x7ff, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, j9, j3, j10, wallDecoration.uid);
                        }
                    }
                WallObject class10_2 = TILE.wallObject;
                if(class10_2 != null)
                {
                    if((class10_2.orientation1 & TILE.anInt1328) != 0 && !method321(l, X, Y, class10_2.orientation1))
                        class10_2.aClass30_Sub2_Sub4_279.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class10_2.xPos - xCameraPosition, class10_2.zPos - zCameraPosition, class10_2.yPos - yCameraPosition, class10_2.uid);
                    if((class10_2.orientation & TILE.anInt1328) != 0 && !method321(l, X, Y, class10_2.orientation))
                        class10_2.aClass30_Sub2_Sub4_278.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class10_2.xPos - xCameraPosition, class10_2.zPos - zCameraPosition, class10_2.yPos - yCameraPosition, class10_2.uid);
                }
            }
            if(k < zMapSize - 1)
            {
                Tile class30_sub3_12 = tileArray[k + 1][X][Y];
                if(class30_sub3_12 != null && class30_sub3_12.aBoolean1323)
                    aClass19_477.insertHead(class30_sub3_12);
            }
            if(X < xCameraPositionTile)
            {
                Tile class30_sub3_13 = aclass30_sub3[X + 1][Y];
                if(class30_sub3_13 != null && class30_sub3_13.aBoolean1323)
                    aClass19_477.insertHead(class30_sub3_13);
            }
            if(Y < yCameraPositionTile)
            {
                Tile class30_sub3_14 = aclass30_sub3[X][Y + 1];
                if(class30_sub3_14 != null && class30_sub3_14.aBoolean1323)
                    aClass19_477.insertHead(class30_sub3_14);
            }
            if(X > xCameraPositionTile)
            {
                Tile class30_sub3_15 = aclass30_sub3[X - 1][Y];
                if(class30_sub3_15 != null && class30_sub3_15.aBoolean1323)
                    aClass19_477.insertHead(class30_sub3_15);
            }
            if(Y > yCameraPositionTile)
            {
                Tile class30_sub3_16 = aclass30_sub3[X][Y - 1];
                if(class30_sub3_16 != null && class30_sub3_16.aBoolean1323)
                    aClass19_477.insertHead(class30_sub3_16);
            }
        } while(true);
    }

    private void renderTile(PlainTile plainTile, int tZ, int j, int k, int l, int i1, int tX,
            int tY)
    {
        int xC;
        int xA = xC = (tX << 7) - xCameraPosition;
        int yB;
        int yA = yB = (tY << 7) - yCameraPosition;
        int xD;
        int xB = xD = xA + 128;
        int yC;
        int yD = yC = yA + 128;
        int zA = heightmap[tZ][tX][tY] - zCameraPosition;
        int zB = heightmap[tZ][tX + 1][tY] - zCameraPosition;
        int zD = heightmap[tZ][tX + 1][tY + 1] - zCameraPosition;
        int zC = heightmap[tZ][tX][tY + 1] - zCameraPosition;
        int l4 = yA * l + xA * i1 >> 16;
        yA = yA * i1 - xA * l >> 16;
        xA = l4;
                /**
         * The Square
         * A--------B
         * |        |
         * |        |
         * |        |
         * C--------D
         *
         * JagSquare
         * A--------B
         * |        |
         * |        |
         * |        |
         * D--------C
         */
        l4 = zA * k - yA * j >> 16;
        yA = zA * j + yA * k >> 16;
        zA = l4;
        if(yA < 50)
            return;
        l4 = yB * l + xB * i1 >> 16;
        yB = yB * i1 - xB * l >> 16;
        xB = l4;
        l4 = zB * k - yB * j >> 16;
        yB = zB * j + yB * k >> 16;
        zB = l4;
        if(yB < 50)
            return;
        l4 = yD * l + xD * i1 >> 16;
        yD = yD * i1 - xD * l >> 16;
        xD = l4;
        l4 = zD * k - yD * j >> 16;
        yD = zD * j + yD * k >> 16;
        zD = l4;
        if(yD < 50)
            return;
        l4 = yC * l + xC * i1 >> 16;
        yC = yC * i1 - xC * l >> 16;
        xC = l4;
        l4 = zC * k - yC * j >> 16;
        yC = zC * j + yC * k >> 16;
        zC = l4;
        if(yC < 50)
            return;
        int screenXA = Rasterizer.centerX + (xA << 9) / yA;
        int screenYA = Rasterizer.centerY + (zA << 9) / yA;
        int screenXB = Rasterizer.centerX + (xB << 9) / yB;
        int screenYB = Rasterizer.centerY + (zB << 9) / yB;
        int screenXD = Rasterizer.centerX + (xD << 9) / yD;
        int screenYD = Rasterizer.centerY + (zD << 9) / yD;
        int screenXC = Rasterizer.centerX + (xC << 9) / yC;
        int screenYC = Rasterizer.centerY + (zC << 9) / yC;
        Rasterizer.alpha = 0;
        if((screenXD - screenXC) * (screenYB - screenYC) - (screenYD - screenYC) * (screenXB - screenXC) > 0)
        {
            Rasterizer.aBoolean1462 = screenXD < 0 || screenXC < 0 || screenXB < 0 || screenXD > DrawingArea.viewportRx || screenXC > DrawingArea.viewportRx || screenXB > DrawingArea.viewportRx;
            if(isClicked && isTriangleClicked(clickX, clickY, screenYD, screenYC, screenYB, screenXD, screenXC, screenXB))
            {
                clickedTileX = tX;
                clickedTileY = tY;
            }
            if(plainTile.texture == -1)
            {
                if(plainTile.colourD != 0xbc614e)
                    Rasterizer.drawTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB);
            } else
            if(!lowMem)
            {
                if(plainTile.flat)
                    Rasterizer.drawTexturedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB, xA, xB, xC, zA, zB, zC, yA, yB, yC, plainTile.texture);
                else
                    Rasterizer.drawTexturedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB, xD, xC, xB, zD, zC, zB, yD, yC, yB, plainTile.texture);
            } else
            {
                int i7 = textureRGBColour[plainTile.texture];
                Rasterizer.drawTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, mixColour(i7, plainTile.colourD), mixColour(i7, plainTile.colourC), mixColour(i7, plainTile.colourB));
            }
        }
        if((screenXA - screenXB) * (screenYC - screenYB) - (screenYA - screenYB) * (screenXC - screenXB) > 0)
        {
            Rasterizer.aBoolean1462 = screenXA < 0 || screenXB < 0 || screenXC < 0 || screenXA > DrawingArea.viewportRx || screenXB > DrawingArea.viewportRx || screenXC > DrawingArea.viewportRx;
            if(isClicked && isTriangleClicked(clickX, clickY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC))
            {
                clickedTileX = tX;
                clickedTileY = tY;
            }
            if(plainTile.texture == -1)
            {
                if(plainTile.colourA != 0xbc614e)
                {
                    Rasterizer.drawTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, plainTile.colourA, plainTile.colourB, plainTile.colourC);
                }
            } else
            {
                if(!lowMem)
                {
                    Rasterizer.drawTexturedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, plainTile.colourA, plainTile.colourB, plainTile.colourC, xA, xB, xC, zA, zB, zC, yA, yB, yC, plainTile.texture);
                    return;
                }
                int j7 = textureRGBColour[plainTile.texture];
                Rasterizer.drawTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, mixColour(j7, plainTile.colourA), mixColour(j7, plainTile.colourB), mixColour(j7, plainTile.colourC));
            }
        }
    }

    private void drawShapedTile(int i, int j, int k, ShapedTile shapedTile, int l, int i1,
                           int j1)
    {
        int k1 = shapedTile.origVertexX.length;
        for(int vID = 0; vID < k1; vID++)
        {
            int i2 = shapedTile.origVertexX[vID] - xCameraPosition;
            int k2 = shapedTile.origVertexY[vID] - zCameraPosition;
            int i3 = shapedTile.origVertexZ[vID] - yCameraPosition;
            int k3 = i3 * k + i2 * j1 >> 16;
            i3 = i3 * j1 - i2 * k >> 16;
            i2 = k3;
            k3 = k2 * l - i3 * j >> 16;
            i3 = k2 * j + i3 * l >> 16;
            k2 = k3;
            if(i3 < 50)
                return;
            if(shapedTile.triTex != null)
            {
                ShapedTile.veritceX[vID] = i2;
                ShapedTile.veritceZ[vID] = k2;
                ShapedTile.veritceY[vID] = i3;
            }
            ShapedTile.screenX[vID] = Rasterizer.centerX + (i2 << 9) / i3;
            ShapedTile.screenY[vID] = Rasterizer.centerY + (k2 << 9) / i3;
        }

        Rasterizer.alpha = 0;
        k1 = shapedTile.indexA.length;
        for(int j2 = 0; j2 < k1; j2++)
        {
            int indexA = shapedTile.indexA[j2];
            int indexB = shapedTile.indexB[j2];
            int indexC = shapedTile.indexC[j2];
            int sXA = ShapedTile.screenX[indexA];
            int sXB = ShapedTile.screenX[indexB];
            int sXC = ShapedTile.screenX[indexC];
            int sYA = ShapedTile.screenY[indexA];
            int sYB = ShapedTile.screenY[indexB];
            int sYC = ShapedTile.screenY[indexC];
            if((sXA - sXB) * (sYC - sYB) - (sYA - sYB) * (sXC - sXB) > 0)
            {
                Rasterizer.aBoolean1462 = sXA < 0 || sXB < 0 || sXC < 0 || sXA > DrawingArea.viewportRx || sXB > DrawingArea.viewportRx || sXC > DrawingArea.viewportRx;
                if(isClicked && isTriangleClicked(clickX, clickY, sYA, sYB, sYC, sXA, sXB, sXC))
                {
                    clickedTileX = i;
                    clickedTileY = i1;
                }
                if(shapedTile.triTex == null || shapedTile.triTex[j2] == -1)
                {
                    if(shapedTile.verticeColourA[j2] != 0xbc614e)
                        Rasterizer.drawTriangle(sYA, sYB, sYC, sXA, sXB, sXC, shapedTile.verticeColourA[j2], shapedTile.verticeColourB[j2], shapedTile.verticeColourC[j2]);
                } else
                if(!lowMem)
                {
                    if(shapedTile.flat)
                        Rasterizer.drawTexturedTriangle(sYA, sYB, sYC, sXA, sXB, sXC, shapedTile.verticeColourA[j2], shapedTile.verticeColourB[j2], shapedTile.verticeColourC[j2], ShapedTile.veritceX[0], ShapedTile.veritceX[1], ShapedTile.veritceX[3], ShapedTile.veritceZ[0], ShapedTile.veritceZ[1], ShapedTile.veritceZ[3], ShapedTile.veritceY[0], ShapedTile.veritceY[1], ShapedTile.veritceY[3], shapedTile.triTex[j2]);
                    else
                        Rasterizer.drawTexturedTriangle(sYA, sYB, sYC, sXA, sXB, sXC, shapedTile.verticeColourA[j2], shapedTile.verticeColourB[j2], shapedTile.verticeColourC[j2], ShapedTile.veritceX[indexA], ShapedTile.veritceX[indexB], ShapedTile.veritceX[indexC], ShapedTile.veritceZ[indexA], ShapedTile.veritceZ[indexB], ShapedTile.veritceZ[indexC], ShapedTile.veritceY[indexA], ShapedTile.veritceY[indexB], ShapedTile.veritceY[indexC], shapedTile.triTex[j2]);
                } else
                {
                    int k5 = textureRGBColour[shapedTile.triTex[j2]];
                    Rasterizer.drawTriangle(sYA, sYB, sYC, sXA, sXB, sXC, mixColour(k5, shapedTile.verticeColourA[j2]), mixColour(k5, shapedTile.verticeColourB[j2]), mixColour(k5, shapedTile.verticeColourC[j2]));
                }
            }
        }

    }

    private int mixColour(int j, int k)
    {
        k = 127 - k;
        k = (k * (j & 0x7f)) / 160;
        if(k < 2)
            k = 2;
        else
        if(k > 126)
            k = 126;
        return (j & 0xff80) + k;
    }

    private boolean isTriangleClicked(int i, int j, int k, int l, int i1, int j1, int k1,
            int l1)
    {
        if(j < k && j < l && j < i1)
            return false;
        if(j > k && j > l && j > i1)
            return false;
        if(i < j1 && i < k1 && i < l1)
            return false;
        if(i > j1 && i > k1 && i > l1)
            return false;
        int i2 = (j - k) * (k1 - j1) - (i - j1) * (l - k);
        int j2 = (j - i1) * (j1 - l1) - (i - l1) * (k - i1);
        int k2 = (j - l) * (l1 - k1) - (i - k1) * (i1 - l);
        return i2 * k2 > 0 && k2 * j2 > 0;
    }

    private void process_culling()
    {
        int cluster_count = cullingClusterPointer[plane];
        CullingCluster clusters[] = cullingClusters[plane];
        processed_culling_clusters_ptr = 0;
        for(int ptr = 0; ptr < cluster_count; ptr++)
        {
            CullingCluster cluster = clusters[ptr];
            if(cluster.searchMask == 1)
            {
                int x_dist_from_camera_start = (cluster.tileStartX - xCameraPositionTile) + 25;
                if(x_dist_from_camera_start < 0 || x_dist_from_camera_start > 50)
                    continue;
                int y_dist_from_camera_start = (cluster.tileStartY - yCameraPositionTile) + 25;
                if(y_dist_from_camera_start < 0)
                    y_dist_from_camera_start = 0;
                int y_dist_from_camera_end = (cluster.tileEndY - yCameraPositionTile) + 25;
                if(y_dist_from_camera_end > 50)
                    y_dist_from_camera_end = 50;
                boolean is_visible = false;
                while(y_dist_from_camera_start <= y_dist_from_camera_end) 
                    if(TILE_VISIBILITY_MAP[x_dist_from_camera_start][y_dist_from_camera_start++])
                    {
                        is_visible = true;
                        break;
                    }
                if(!is_visible)
                    continue;
                int x_dist_from_camera_start_real = xCameraPosition - cluster.worldStartX;
                if(x_dist_from_camera_start_real > 32)
                {
                    cluster.tileDistanceEnum = 1;
                } else
                {
                    if(x_dist_from_camera_start_real >= -32)
                        continue;
                    cluster.tileDistanceEnum = 2;
                    x_dist_from_camera_start_real = -x_dist_from_camera_start_real;
                }
                cluster.worldDistanceFromCameraStartY = (cluster.worldStartY - yCameraPosition << 8) / x_dist_from_camera_start_real;
                cluster.worldDistanceFromCameraEndY = (cluster.worldEndY - yCameraPosition << 8) / x_dist_from_camera_start_real;
                cluster.worldDistanceFromCameraStartZ = (cluster.worldStartZ - zCameraPosition << 8) / x_dist_from_camera_start_real;
                cluster.worldDistanceFromCameraEndZ = (cluster.worldEndZ - zCameraPosition << 8) / x_dist_from_camera_start_real;
                processed_culling_clusters[processed_culling_clusters_ptr++] = cluster;
                continue;
            }
            if(cluster.searchMask == 2)
            {
                int y_dist_from_camera_start = (cluster.tileStartY - yCameraPositionTile) + 25;
                if(y_dist_from_camera_start < 0 || y_dist_from_camera_start > 50)
                    continue;
                int x_dist_from_camera_start = (cluster.tileStartX - xCameraPositionTile) + 25;
                if(x_dist_from_camera_start < 0)
                    x_dist_from_camera_start = 0;
                int x_dist_from_camera_end = (cluster.tileEndX - xCameraPositionTile) + 25;
                if(x_dist_from_camera_end > 50)
                    x_dist_from_camera_end = 50;
                boolean is_visible = false;
                while(x_dist_from_camera_start <= x_dist_from_camera_end) 
                    if(TILE_VISIBILITY_MAP[x_dist_from_camera_start++][y_dist_from_camera_start])
                    {
                        is_visible = true;
                        break;
                    }
                if(!is_visible)
                    continue;
                int y_dist_from_camera_start_real = yCameraPosition - cluster.worldStartY;
                if(y_dist_from_camera_start_real > 32)
                {
                    cluster.tileDistanceEnum = 3;
                } else
                {
                    if(y_dist_from_camera_start_real >= -32)
                        continue;
                    cluster.tileDistanceEnum = 4;
                    y_dist_from_camera_start_real = -y_dist_from_camera_start_real;
                }
                cluster.worldDistanceFromCameraStartX = (cluster.worldStartX - xCameraPosition << 8) / y_dist_from_camera_start_real;
                cluster.worldDistanceFromCameraEndX = (cluster.worldEndX - xCameraPosition << 8) / y_dist_from_camera_start_real;
                cluster.worldDistanceFromCameraStartZ = (cluster.worldStartZ - zCameraPosition << 8) / y_dist_from_camera_start_real;
                cluster.worldDistanceFromCameraEndZ = (cluster.worldEndZ - zCameraPosition << 8) / y_dist_from_camera_start_real;
                processed_culling_clusters[processed_culling_clusters_ptr++] = cluster;
            } else
            if(cluster.searchMask == 4)
            {
                int z_dist_from_camera_start_real = cluster.worldStartZ - zCameraPosition;
                if(z_dist_from_camera_start_real > 128)
                {
                    int y_dist_from_camera_start = (cluster.tileStartY - yCameraPositionTile) + 25;
                    if(y_dist_from_camera_start < 0)
                        y_dist_from_camera_start = 0;
                    int y_dist_from_camera_end = (cluster.tileEndY - yCameraPositionTile) + 25;
                    if(y_dist_from_camera_end > 50)
                        y_dist_from_camera_end = 50;
                    if(y_dist_from_camera_start <= y_dist_from_camera_end)
                    {
                        int x_dist_from_camera_start = (cluster.tileStartX - xCameraPositionTile) + 25;
                        if(x_dist_from_camera_start < 0)
                            x_dist_from_camera_start = 0;
                        int x_dist_from_camera_end = (cluster.tileEndX - xCameraPositionTile) + 25;
                        if(x_dist_from_camera_end > 50)
                            x_dist_from_camera_end = 50;
                        boolean is_visible = false;
for_outer:
                        for(int __x = x_dist_from_camera_start; __x <= x_dist_from_camera_end; __x++)
                        {
                            for(int __y = y_dist_from_camera_start; __y <= y_dist_from_camera_end; __y++)
                            {
                                if(!TILE_VISIBILITY_MAP[__x][__y])
                                    continue;
                                is_visible = true;
                                break for_outer;
                            }

                        }

                        if(is_visible)
                        {
                            cluster.tileDistanceEnum = 5;
                            cluster.worldDistanceFromCameraStartX = (cluster.worldStartX - xCameraPosition << 8) / z_dist_from_camera_start_real;
                            cluster.worldDistanceFromCameraEndX = (cluster.worldEndX - xCameraPosition << 8) / z_dist_from_camera_start_real;
                            cluster.worldDistanceFromCameraStartY = (cluster.worldStartY - yCameraPosition << 8) / z_dist_from_camera_start_real;
                            cluster.worldDistanceFromCameraEndY = (cluster.worldEndY - yCameraPosition << 8) / z_dist_from_camera_start_real;
                            processed_culling_clusters[processed_culling_clusters_ptr++] = cluster;
                        }
                    }
                }
            }
        }

    }

    private boolean method320(int i, int j, int k)
    {
        int l = anIntArrayArrayArray445[i][j][k];
        if(l == -anInt448)
            return false;
        if(l == anInt448)
            return true;
        int i1 = j << 7;
        int j1 = k << 7;
        if(method324(i1 + 1, heightmap[i][j][k], j1 + 1) && method324((i1 + 128) - 1, heightmap[i][j + 1][k], j1 + 1) && method324((i1 + 128) - 1, heightmap[i][j + 1][k + 1], (j1 + 128) - 1) && method324(i1 + 1, heightmap[i][j][k + 1], (j1 + 128) - 1))
        {
            anIntArrayArrayArray445[i][j][k] = anInt448;
            return true;
        } else
        {
            anIntArrayArrayArray445[i][j][k] = -anInt448;
            return false;
        }
    }

    private boolean method321(int i, int j, int k, int l)
    {
        if(!method320(i, j, k))
            return false;
        int i1 = j << 7;
        int j1 = k << 7;
        int k1 = heightmap[i][j][k] - 1;
        int l1 = k1 - 120;
        int i2 = k1 - 230;
        int j2 = k1 - 238;
        if(l < 16)
        {
            if(l == 1)
            {
                if(i1 > xCameraPosition)
                {
                    if(!method324(i1, k1, j1))
                        return false;
                    if(!method324(i1, k1, j1 + 128))
                        return false;
                }
                if(i > 0)
                {
                    if(!method324(i1, l1, j1))
                        return false;
                    if(!method324(i1, l1, j1 + 128))
                        return false;
                }
                return method324(i1, i2, j1) && method324(i1, i2, j1 + 128);
            }
            if(l == 2)
            {
                if(j1 < yCameraPosition)
                {
                    if(!method324(i1, k1, j1 + 128))
                        return false;
                    if(!method324(i1 + 128, k1, j1 + 128))
                        return false;
                }
                if(i > 0)
                {
                    if(!method324(i1, l1, j1 + 128))
                        return false;
                    if(!method324(i1 + 128, l1, j1 + 128))
                        return false;
                }
                return method324(i1, i2, j1 + 128) && method324(i1 + 128, i2, j1 + 128);
            }
            if(l == 4)
            {
                if(i1 < xCameraPosition)
                {
                    if(!method324(i1 + 128, k1, j1))
                        return false;
                    if(!method324(i1 + 128, k1, j1 + 128))
                        return false;
                }
                if(i > 0)
                {
                    if(!method324(i1 + 128, l1, j1))
                        return false;
                    if(!method324(i1 + 128, l1, j1 + 128))
                        return false;
                }
                return method324(i1 + 128, i2, j1) && method324(i1 + 128, i2, j1 + 128);
            }
            if(l == 8)
            {
                if(j1 > yCameraPosition)
                {
                    if(!method324(i1, k1, j1))
                        return false;
                    if(!method324(i1 + 128, k1, j1))
                        return false;
                }
                if(i > 0)
                {
                    if(!method324(i1, l1, j1))
                        return false;
                    if(!method324(i1 + 128, l1, j1))
                        return false;
                }
                return method324(i1, i2, j1) && method324(i1 + 128, i2, j1);
            }
        }
        if(!method324(i1 + 64, j2, j1 + 64))
            return false;
        if(l == 16)
            return method324(i1, i2, j1 + 128);
        if(l == 32)
            return method324(i1 + 128, i2, j1 + 128);
        if(l == 64)
            return method324(i1 + 128, i2, j1);
        if(l == 128)
        {
            return method324(i1, i2, j1);
        } else
        {
            System.out.println("Warning unsupported wall type");
            return true;
        }
    }

    private boolean method322(int i, int j, int k, int l)
    {
        if(!method320(i, j, k))
            return false;
        int i1 = j << 7;
        int j1 = k << 7;
        return method324(i1 + 1, heightmap[i][j][k] - l, j1 + 1) && method324((i1 + 128) - 1, heightmap[i][j + 1][k] - l, j1 + 1) && method324((i1 + 128) - 1, heightmap[i][j + 1][k + 1] - l, (j1 + 128) - 1) && method324(i1 + 1, heightmap[i][j][k + 1] - l, (j1 + 128) - 1);
    }

    private boolean method323(int i, int j, int k, int l, int i1, int j1)
    {
        if(j == k && l == i1)
        {
            if(!method320(i, j, l))
                return false;
            int k1 = j << 7;
            int i2 = l << 7;
            return method324(k1 + 1, heightmap[i][j][l] - j1, i2 + 1) && method324((k1 + 128) - 1, heightmap[i][j + 1][l] - j1, i2 + 1) && method324((k1 + 128) - 1, heightmap[i][j + 1][l + 1] - j1, (i2 + 128) - 1) && method324(k1 + 1, heightmap[i][j][l + 1] - j1, (i2 + 128) - 1);
        }
        for(int l1 = j; l1 <= k; l1++)
        {
            for(int j2 = l; j2 <= i1; j2++)
                if(anIntArrayArrayArray445[i][l1][j2] == -anInt448)
                    return false;

        }

        int k2 = (j << 7) + 1;
        int l2 = (l << 7) + 2;
        int i3 = heightmap[i][j][l] - j1;
        if(!method324(k2, i3, l2))
            return false;
        int j3 = (k << 7) - 1;
        if(!method324(j3, i3, l2))
            return false;
        int k3 = (i1 << 7) - 1;
        return method324(k2, i3, k3) && method324(j3, i3, k3);
    }

    private boolean method324(int i, int j, int k)
    {
        for(int l = 0; l < processed_culling_clusters_ptr; l++)
        {
            CullingCluster class47 = processed_culling_clusters[l];
            if(class47.tileDistanceEnum == 1)
            {
                int i1 = class47.worldStartX - i;
                if(i1 > 0)
                {
                    int j2 = class47.worldStartY + (class47.worldDistanceFromCameraStartY * i1 >> 8);
                    int k3 = class47.worldEndY + (class47.worldDistanceFromCameraEndY * i1 >> 8);
                    int l4 = class47.worldStartZ + (class47.worldDistanceFromCameraStartZ * i1 >> 8);
                    int i6 = class47.worldEndZ + (class47.worldDistanceFromCameraEndZ * i1 >> 8);
                    if(k >= j2 && k <= k3 && j >= l4 && j <= i6)
                        return true;
                }
            } else
            if(class47.tileDistanceEnum == 2)
            {
                int j1 = i - class47.worldStartX;
                if(j1 > 0)
                {
                    int k2 = class47.worldStartY + (class47.worldDistanceFromCameraStartY * j1 >> 8);
                    int l3 = class47.worldEndY + (class47.worldDistanceFromCameraEndY * j1 >> 8);
                    int i5 = class47.worldStartZ + (class47.worldDistanceFromCameraStartZ * j1 >> 8);
                    int j6 = class47.worldEndZ + (class47.worldDistanceFromCameraEndZ * j1 >> 8);
                    if(k >= k2 && k <= l3 && j >= i5 && j <= j6)
                        return true;
                }
            } else
            if(class47.tileDistanceEnum == 3)
            {
                int k1 = class47.worldStartY - k;
                if(k1 > 0)
                {
                    int l2 = class47.worldStartX + (class47.worldDistanceFromCameraStartX * k1 >> 8);
                    int i4 = class47.worldEndX + (class47.worldDistanceFromCameraEndX * k1 >> 8);
                    int j5 = class47.worldStartZ + (class47.worldDistanceFromCameraStartZ * k1 >> 8);
                    int k6 = class47.worldEndZ + (class47.worldDistanceFromCameraEndZ * k1 >> 8);
                    if(i >= l2 && i <= i4 && j >= j5 && j <= k6)
                        return true;
                }
            } else
            if(class47.tileDistanceEnum == 4)
            {
                int l1 = k - class47.worldStartY;
                if(l1 > 0)
                {
                    int i3 = class47.worldStartX + (class47.worldDistanceFromCameraStartX * l1 >> 8);
                    int j4 = class47.worldEndX + (class47.worldDistanceFromCameraEndX * l1 >> 8);
                    int k5 = class47.worldStartZ + (class47.worldDistanceFromCameraStartZ * l1 >> 8);
                    int l6 = class47.worldEndZ + (class47.worldDistanceFromCameraEndZ * l1 >> 8);
                    if(i >= i3 && i <= j4 && j >= k5 && j <= l6)
                        return true;
                }
            } else
            if(class47.tileDistanceEnum == 5)
            {
                int i2 = j - class47.worldStartZ;
                if(i2 > 0)
                {
                    int j3 = class47.worldStartX + (class47.worldDistanceFromCameraStartX * i2 >> 8);
                    int k4 = class47.worldEndX + (class47.worldDistanceFromCameraEndX * i2 >> 8);
                    int l5 = class47.worldStartY + (class47.worldDistanceFromCameraStartY * i2 >> 8);
                    int i7 = class47.worldEndY + (class47.worldDistanceFromCameraEndY * i2 >> 8);
                    if(i >= j3 && i <= k4 && k >= l5 && k <= i7)
                        return true;
                }
            }
        }

        return false;
    }


    public static boolean lowMem = true;
    private final int zMapSize;
    private final int xMapSize;
    private final int yMapSize;
    private final int[][][] heightmap;
    private final Tile[][][] tileArray;
    private int anInt442;
    private int interactableObjectCacheCurrPos;
    private final InteractableObject[] interactableObjectCache;
    private final int[][][] anIntArrayArrayArray445;
    private static int anInt446;
    private static int plane;
    private static int anInt448;
    private static int anInt449;
    private static int anInt450;
    private static int anInt451;
    private static int anInt452;
    private static int xCameraPositionTile;
    private static int yCameraPositionTile;
    private static int xCameraPosition;
    private static int zCameraPosition;
    private static int yCameraPosition;
    private static int yCurveSine;
    private static int yCurveCosine;
    private static int xCurveSine;
    private static int xCurveCosine;
    private static InteractableObject[] interactableObjects = new InteractableObject[100];
    private static final int[] faceXOffset2 = {
        53, -53, -53, 53
    };
    private static final int[] faceYOffset2 = {
        -53, -53, 53, 53
    };
    private static final int[] faceXOffset3 = {
        -45, 45, 45, -45
    };
    private static final int[] faceYOffset3 = {
        45, 45, -45, -45
    };
    private static boolean isClicked;
    private static int clickX;
    private static int clickY;
    public static int clickedTileX = -1;
    public static int clickedTileY = -1;
    private static final int anInt472;
    private static int[] cullingClusterPointer;
    private static CullingCluster[][] cullingClusters;
    private static int processed_culling_clusters_ptr;
    private static final CullingCluster[] processed_culling_clusters = new CullingCluster[500];
    private static NodeList aClass19_477 = new NodeList();
    private static final int[] anIntArray478 = {
        19, 55, 38, 155, 255, 110, 137, 205, 76
    };
    private static final int[] anIntArray479 = {
        160, 192, 80, 96, 0, 144, 80, 48, 160
    };
    private static final int[] anIntArray480 = {
        76, 8, 137, 4, 0, 1, 38, 2, 19
    };
    private static final int[] anIntArray481 = {
        0, 0, 2, 0, 0, 2, 1, 1, 0
    };
    private static final int[] anIntArray482 = {
        2, 0, 0, 2, 0, 0, 0, 4, 4
    };
    private static final int[] anIntArray483 = {
        0, 4, 4, 8, 0, 0, 8, 0, 0
    };
    private static final int[] anIntArray484 = {
        1, 1, 0, 0, 0, 8, 0, 0, 8
    };
    private static final int[] textureRGBColour = {
        41, 39248, 41, 4643, 41, 41, 41, 41, 41, 41, 
        41, 41, 41, 41, 41, 43086, 41, 41, 41, 41, 
        41, 41, 41, 8602, 41, 28992, 41, 41, 41, 41, 
        41, 5056, 41, 41, 41, 7079, 41, 41, 41, 41, 
        41, 41, 41, 41, 41, 41, 3131, 41, 41, 41
    };
    private final int[] anIntArray486;
    private final int[] anIntArray487;
    private int anInt488;
    private final int[][] anIntArrayArray489 = {
        new int[16], {
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
            1, 1, 1, 1, 1, 1
        }, {
            1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 
            1, 0, 1, 1, 1, 1
        }, {
            1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 
            0, 0, 1, 0, 0, 0
        }, {
            0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 
            0, 1, 0, 0, 0, 1
        }, {
            0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 
            1, 1, 1, 1, 1, 1
        }, {
            1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 
            1, 1, 1, 1, 1, 1
        }, {
            1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 
            0, 0, 1, 1, 0, 0
        }, {
            0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 
            0, 0, 1, 1, 0, 0
        }, {
            1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 
            1, 1, 0, 0, 1, 1
        }, 
        {
            1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 
            0, 0, 1, 0, 0, 0
        }, {
            0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 
            1, 1, 0, 1, 1, 1
        }, {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 
            1, 0, 1, 1, 1, 1
        }
    };
    private final int[][] anIntArrayArray490 = {
        {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
            10, 11, 12, 13, 14, 15
        }, {
            12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 
            6, 2, 15, 11, 7, 3
        }, {
            15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 
            5, 4, 3, 2, 1, 0
        }, {
            3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 
            9, 13, 0, 4, 8, 12
        }
    };
    private static boolean[][][][] TILE_VISIBILITY_MAPS = new boolean[8][32][51][51];
    private static boolean[][] TILE_VISIBILITY_MAP;
    private static int midX;
    private static int midY;
    private static int left;
    private static int top;
    private static int right;
    private static int bottom;

    public static client clientInstance;
    static 
    {
        anInt472 = 4;
        cullingClusterPointer = new int[anInt472];
        cullingClusters = new CullingCluster[anInt472][500];
    }
}
