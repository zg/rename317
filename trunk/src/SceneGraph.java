// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

final class SceneGraph {

    public SceneGraph(int heightmap[][][])
    {
        int length = 104;//was parameter
        int width = 104;//was parameter
        int height = 4;//was parameter
        aBoolean434 = true;
        obj5Cache = new Object5[5000];
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
        aClass28Array462 = null;
        culling_cluster_ptr = null;
        culling_clusters = null;
        aClass19_477 = null;
        TILE_VISIBILITY_MAPS = null;
        TILE_VISIBILITY_MAP = null;
    }

    public void initToNull()
    {
        for(int j = 0; j < zMapSize; j++)
        {
            for(int k = 0; k < xMapSize; k++)
            {
                for(int i1 = 0; i1 < yMapSize; i1++)
                    tileArray[j][k][i1] = null;

            }

        }
        for(int l = 0; l < anInt472; l++)
        {
            for(int j1 = 0; j1 < culling_cluster_ptr[l]; j1++)
                culling_clusters[l][j1] = null;

            culling_cluster_ptr[l] = 0;
        }

        for(int k1 = 0; k1 < obj5CacheCurrPos; k1++)
            obj5Cache[k1] = null;

        obj5CacheCurrPos = 0;
        for(int l1 = 0; l1 < aClass28Array462.length; l1++)
            aClass28Array462[l1] = null;

    }

    public void resetTilesHL(int i)
    {
        anInt442 = i;
        for(int k = 0; k < xMapSize; k++)
        {
            for(int l = 0; l < yMapSize; l++)
                if(tileArray[i][k][l] == null)
                    tileArray[i][k][l] = new Tile(i, k, l);

        }

    }

    public void apply_bridge_mode(int x, int y)
    {
        Tile level0_tile = tileArray[0][x][y];
        for(int _z = 0; _z < 3; _z++)
        {
            Tile tile = tileArray[_z][x][y] = tileArray[_z + 1][x][y];
            if(tile != null)
            {
                tile.tileZ--;
                for(int ptr = 0; ptr < tile.entity_count; ptr++)
                {
                    Object5 world_entity = tile.entities[ptr];
                    if((world_entity.uid >> 29 & 3) == 2 && world_entity.tile_x == x && world_entity.tile_y == y)
                        world_entity.tile_z--;
                }

            }
        }
        if(tileArray[0][x][y] == null)
            tileArray[0][x][y] = new Tile(0, x, y);
        tileArray[0][x][y].tileBelow0 = level0_tile;
        tileArray[3][x][y] = null;
    }

    public static void create_culling_cluster(int z, int lowest_x, int lowest_y, int lowest_z, int highest_x, int highest_y, int highest_z,
                                 int search_mask)
    {
        CullingCluster culling_cluster = new CullingCluster();
        culling_cluster.tile_start_x = lowest_x / 128;
        culling_cluster.tile_end_x = highest_x / 128;
        culling_cluster.tile_start_y = lowest_y / 128;
        culling_cluster.tile_end_y = highest_y / 128;
        culling_cluster.search_mask = search_mask;
        culling_cluster.world_start_x = lowest_x;
        culling_cluster.world_end_x = highest_x;
        culling_cluster.world_start_y = lowest_y;
        culling_cluster.world_end_y = highest_y;
        culling_cluster.world_start_z = highest_z;
        culling_cluster.world_end_z = lowest_z;
        culling_clusters[z][culling_cluster_ptr[z]++] = culling_cluster;
    }

    public void set_tile_logic_height(int z, int x, int y, int l_z)
    {
        Tile class30_sub3 = tileArray[z][x][y];
        if(class30_sub3 != null)
        {
            tileArray[z][x][y].logic_height = l_z;
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
            for(int j5 = zz; j5 >= 0; j5--)
                if(tileArray[j5][x][y] == null)
                    tileArray[j5][x][y] = new Tile(j5, x, y);

            tileArray[zz][x][y].myPlainTile = plainTile_1;
            return;
        }
        ShapedTile shapedTile = new ShapedTile(y, colourAA, colourC, zD, j1, colourDA, shapeB, colourA, cRGB2, colourD, zC, zB, zA, shapeA, colourCA, colourBA, colourB, x, RGBA);
        for(int k5 = zz; k5 >= 0; k5--)
            if(tileArray[k5][x][y] == null)
                tileArray[k5][x][y] = new Tile(k5, x, y);

        tileArray[zz][x][y].shapedTile = shapedTile;
    }

    public void addObj3(int Z, int z3d, int Y, Animable class30_sub2_sub4, byte byte0, int uid,
                          int X)
    {
        if(class30_sub2_sub4 == null)
            return;
        Object3 class49 = new Object3();
        class49.aClass30_Sub2_Sub4_814 = class30_sub2_sub4;
        class49.X3D = X * 128 + 64;
        class49.Y3D = Y * 128 + 64;
        class49.Z3D = z3d;
        class49.uid = uid;
        class49.objConf = byte0;
        if(tileArray[Z][X][Y] == null)
            tileArray[Z][X][Y] = new Tile(Z, X, Y);
        tileArray[Z][X][Y].obj3 = class49;
    }

    public void method281(int i, int j, Animable class30_sub2_sub4, int k, Animable class30_sub2_sub4_1, Animable class30_sub2_sub4_2,
                          int l, int i1)
    {
        GroundItemTile object4 = new GroundItemTile();
        object4.topGroundItem = class30_sub2_sub4_2;
        object4.xPos = i * 128 + 64;
        object4.yPos = i1 * 128 + 64;
        object4.zPos = k;
        object4.uid = j;
        object4.secondGroundItem = class30_sub2_sub4;
        object4.thirdGroundItem = class30_sub2_sub4_1;
        int j1 = 0;
        Tile class30_sub3 = tileArray[l][i][i1];
        if(class30_sub3 != null)
        {
            for(int k1 = 0; k1 < class30_sub3.entity_count; k1++)
                if(class30_sub3.entities[k1].aClass30_Sub2_Sub4_521 instanceof Model)
                {
                    int l1 = ((Model)class30_sub3.entities[k1].aClass30_Sub2_Sub4_521).anInt1654;
                    if(l1 > j1)
                        j1 = l1;
                }

        }
        object4.anInt52 = j1;
        if(tileArray[l][i][i1] == null)
            tileArray[l][i][i1] = new Tile(l, i, i1);
        tileArray[l][i][i1].groundItemTile = object4;
    }

    public void addObject1(int i, Animable class30_sub2_sub4, int j, int k, byte byte0, int l,
                          Animable class30_sub2_sub4_1, int i1, int j1, int k1)
    {
        if(class30_sub2_sub4 == null && class30_sub2_sub4_1 == null)
            return;
        Object1 object1 = new Object1();
        object1.uid = j;
        object1.aByte281 = byte0;
        object1.anInt274 = l * 128 + 64;
        object1.anInt275 = k * 128 + 64;
        object1.anInt273 = i1;
        object1.aClass30_Sub2_Sub4_278 = class30_sub2_sub4;
        object1.aClass30_Sub2_Sub4_279 = class30_sub2_sub4_1;
        object1.orientation = i;
        object1.orientation1 = j1;
        for(int l1 = k1; l1 >= 0; l1--)
            if(tileArray[l1][l][k] == null)
                tileArray[l1][l][k] = new Tile(l1, l, k);

        tileArray[k1][l][k].obj1 = object1;
    }

    public void addObject(int i, int tileY, int face, int tileZ, int x3dOff, int z3d,
                          Animable animable, int tileX, byte obConfig, int y3dOff, int facebits)
    {
        if(animable == null)
            return;
        Object2 object2 = new Object2();
        object2.uid = i;
        object2.objConf = obConfig;
        object2.X3D = tileX * 128 + 64 + x3dOff;
        object2.Y3D = tileY * 128 + 64 + y3dOff;
        object2.Z3D = z3d;
        object2.myMob = animable;
        object2.configBits = facebits;
        object2.face = face;
        for(int k2 = tileZ; k2 >= 0; k2--)
            if(tileArray[k2][tileX][tileY] == null)
                tileArray[k2][tileX][tileY] = new Tile(k2, tileX, tileY);

        tileArray[tileZ][tileX][tileY].obj2 = object2;
    }

    public boolean addEntityB(int i, byte byte0, int j, int k, Animable class30_sub2_sub4, int l, int i1,
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
                             int k1, Animable class30_sub2_sub4, boolean flag)
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

    public boolean addEntity(int j, int k, Animable class30_sub2_sub4, int l, int i1, int j1,
                             int k1, int l1, int i2, int j2, int k2)
    {
        return class30_sub2_sub4 == null || addEntityC(j, l1, k2, (i2 - l1) + 1, (i1 - k2) + 1, j1, k, k1, class30_sub2_sub4, l, true, j2, (byte) 0);
    }

    private boolean addEntityC(int i, int j, int k, int l, int i1, int j1, int k1,
            int l1, Animable class30_sub2_sub4, int i2, boolean flag, int j2, byte byte0)
    {
        for(int k2 = j; k2 < j + l; k2++)
        {
            for(int l2 = k; l2 < k + i1; l2++)
            {
                if(k2 < 0 || l2 < 0 || k2 >= xMapSize || l2 >= yMapSize)
                    return false;
                Tile class30_sub3 = tileArray[i][k2][l2];
                if(class30_sub3 != null && class30_sub3.entity_count >= 5)
                    return false;
            }

        }

        Object5 class28 = new Object5();
        class28.uid = j2;
        class28.aByte530 = byte0;
        class28.tile_z = i;
        class28.anInt519 = j1;
        class28.anInt520 = k1;
        class28.anInt518 = l1;
        class28.aClass30_Sub2_Sub4_521 = class30_sub2_sub4;
        class28.anInt522 = i2;
        class28.tile_x = j;
        class28.tile_y = k;
        class28.anInt524 = (j + l) - 1;
        class28.anInt526 = (k + i1) - 1;
        for(int i3 = j; i3 < j + l; i3++)
        {
            for(int j3 = k; j3 < k + i1; j3++)
            {
                int k3 = 0;
                if(i3 > j)
                    k3++;
                if(i3 < (j + l) - 1)
                    k3 += 4;
                if(j3 > k)
                    k3 += 8;
                if(j3 < (k + i1) - 1)
                    k3 += 2;
                for(int l3 = i; l3 >= 0; l3--)
                    if(tileArray[l3][i3][j3] == null)
                        tileArray[l3][i3][j3] = new Tile(l3, i3, j3);

                Tile class30_sub3_1 = tileArray[i][i3][j3];
                class30_sub3_1.entities[class30_sub3_1.entity_count] = class28;
                class30_sub3_1.anIntArray1319[class30_sub3_1.entity_count] = k3;
                class30_sub3_1.anInt1320 |= k3;
                class30_sub3_1.entity_count++;
            }

        }

        if(flag)
            obj5Cache[obj5CacheCurrPos++] = class28;
        return true;
    }

    public void clearObj5Cache()
    {
        for(int i = 0; i < obj5CacheCurrPos; i++)
        {
            Object5 object5 = obj5Cache[i];
            method289(object5);
            obj5Cache[i] = null;
        }

        obj5CacheCurrPos = 0;
    }

    private void method289(Object5 class28)
    {
        for(int j = class28.tile_x; j <= class28.anInt524; j++)
        {
            for(int k = class28.tile_y; k <= class28.anInt526; k++)
            {
                Tile class30_sub3 = tileArray[class28.tile_z][j][k];
                if(class30_sub3 != null)
                {
                    for(int l = 0; l < class30_sub3.entity_count; l++)
                    {
                        if(class30_sub3.entities[l] != class28)
                            continue;
                        class30_sub3.entity_count--;
                        for(int i1 = l; i1 < class30_sub3.entity_count; i1++)
                        {
                            class30_sub3.entities[i1] = class30_sub3.entities[i1 + 1];
                            class30_sub3.anIntArray1319[i1] = class30_sub3.anIntArray1319[i1 + 1];
                        }

                        class30_sub3.entities[class30_sub3.entity_count] = null;
                        break;
                    }

                    class30_sub3.anInt1320 = 0;
                    for(int j1 = 0; j1 < class30_sub3.entity_count; j1++)
                        class30_sub3.anInt1320 |= class30_sub3.anIntArray1319[j1];

                }
            }

        }

    }

    public void method290(int i, int k, int l, int i1)
    {
        Tile class30_sub3 = tileArray[i1][l][i];
        if(class30_sub3 == null)
            return;
        Object2 class26 = class30_sub3.obj2;
        if(class26 != null)
        {
            int j1 = l * 128 + 64;
            int k1 = i * 128 + 64;
            class26.X3D = j1 + ((class26.X3D - j1) * k) / 16;
            class26.Y3D = k1 + ((class26.Y3D - k1) * k) / 16;
        }
    }

    public void method291(int i, int j, int k, byte byte0)
    {
        Tile class30_sub3 = tileArray[j][i][k];
        if(byte0 != -119)
            aBoolean434 = !aBoolean434;
        if(class30_sub3 != null)
        {
            class30_sub3.obj1 = null;
        }
    }

    public void method292(int j, int k, int l)
    {
        Tile class30_sub3 = tileArray[k][l][j];
        if(class30_sub3 != null)
        {
            class30_sub3.obj2 = null;
        }
    }

    public void method293(int i, int k, int l)
    {
        Tile class30_sub3 = tileArray[i][k][l];
        if(class30_sub3 == null)
            return;
        for(int j1 = 0; j1 < class30_sub3.entity_count; j1++)
        {
            Object5 class28 = class30_sub3.entities[j1];
            if((class28.uid >> 29 & 3) == 2 && class28.tile_x == k && class28.tile_y == l)
            {
                method289(class28);
                return;
            }
        }

    }

    public void method294(int i, int j, int k)
    {
        Tile class30_sub3 = tileArray[i][k][j];
        if(class30_sub3 == null)
            return;
        class30_sub3.obj3 = null;
    }

    public void method295(int i, int j, int k)
    {
        Tile class30_sub3 = tileArray[i][j][k];
        if(class30_sub3 != null)
        {
            class30_sub3.groundItemTile = null;
        }
    }

    public Object1 method296(int i, int j, int k)
    {
        Tile class30_sub3 = tileArray[i][j][k];
        if(class30_sub3 == null)
            return null;
        else
            return class30_sub3.obj1;
    }

    public Object2 method297(int i, int k, int l)
    {
        Tile class30_sub3 = tileArray[l][i][k];
        if(class30_sub3 == null)
            return null;
        else
            return class30_sub3.obj2;
    }

    public Object5 method298(int i, int j, int k)
    {
        Tile class30_sub3 = tileArray[k][i][j];
        if(class30_sub3 == null)
            return null;
        for(int l = 0; l < class30_sub3.entity_count; l++)
        {
            Object5 class28 = class30_sub3.entities[l];
            if((class28.uid >> 29 & 3) == 2 && class28.tile_x == i && class28.tile_y == j)
                return class28;
        }
        return null;
    }

    public Object3 method299(int i, int j, int k)
    {
        Tile class30_sub3 = tileArray[k][j][i];
        if(class30_sub3 == null || class30_sub3.obj3 == null)
            return null;
        else
            return class30_sub3.obj3;
    }

    public int method300(int i, int j, int k)
    {
        Tile class30_sub3 = tileArray[i][j][k];
        if(class30_sub3 == null || class30_sub3.obj1 == null)
            return 0;
        else
            return class30_sub3.obj1.uid;
    }

    public int method301(int i, int j, int l)
    {
        Tile class30_sub3 = tileArray[i][j][l];
        if(class30_sub3 == null || class30_sub3.obj2 == null)
            return 0;
        else
            return class30_sub3.obj2.uid;
    }

    public int method302(int i, int j, int k)
    {
        Tile class30_sub3 = tileArray[i][j][k];
        if(class30_sub3 == null)
            return 0;
        for(int l = 0; l < class30_sub3.entity_count; l++)
        {
            Object5 class28 = class30_sub3.entities[l];
            if((class28.uid >> 29 & 3) == 2 && class28.tile_x == j && class28.tile_y == k)
                return class28.uid;
        }

        return 0;
    }

    public int method303(int i, int j, int k)
    {
        Tile class30_sub3 = tileArray[i][j][k];
        if(class30_sub3 == null || class30_sub3.obj3 == null)
            return 0;
        else
            return class30_sub3.obj3.uid;
    }

    public int getIDTAGForXYZ(int i, int j, int k, int l)
    {
        Tile class30_sub3 = tileArray[i][j][k];
        if(class30_sub3 == null)
            return -1;
        if(class30_sub3.obj1 != null && class30_sub3.obj1.uid == l)
            return class30_sub3.obj1.aByte281 & 0xff;
        if(class30_sub3.obj2 != null && class30_sub3.obj2.uid == l)
            return class30_sub3.obj2.objConf & 0xff;
        if(class30_sub3.obj3 != null && class30_sub3.obj3.uid == l)
            return class30_sub3.obj3.objConf & 0xff;
        for(int i1 = 0; i1 < class30_sub3.entity_count; i1++)
            if(class30_sub3.entities[i1].uid == l)
                return class30_sub3.entities[i1].aByte530 & 0xff;

        return -1;
    }

    public void shade_models(int l_x, int l_y, int l_z, int mag_multiplier, int lightness)
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
                        Object1 class10 = tile.obj1;
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
                        for(int k2 = 0; k2 < tile.entity_count; k2++)
                        {
                            Object5 class28 = tile.entities[k2];
                            if(class28 != null && class28.aClass30_Sub2_Sub4_521 != null && class28.aClass30_Sub2_Sub4_521.vertexNormal != null)
                            {
                                method307(_z, (class28.anInt524 - class28.tile_x) + 1, (class28.anInt526 - class28.tile_y) + 1, _x, _y, (Model)class28.aClass30_Sub2_Sub4_521);
                                ((Model)class28.aClass30_Sub2_Sub4_521).doShading(lightness, l_magnitude, l_x, l_y, l_z);
                            }
                        }

                        Object3 class49 = tile.obj3;
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

    private void method306(int i, int j, Model model, int k)
    {
        if(i < xMapSize)
        {
            Tile class30_sub3 = tileArray[j][i + 1][k];
            if(class30_sub3 != null && class30_sub3.obj3 != null && class30_sub3.obj3.aClass30_Sub2_Sub4_814.vertexNormal != null)
                method308(model, (Model)class30_sub3.obj3.aClass30_Sub2_Sub4_814, 128, 0, 0, true);
        }
        if(k < xMapSize)
        {
            Tile class30_sub3_1 = tileArray[j][i][k + 1];
            if(class30_sub3_1 != null && class30_sub3_1.obj3 != null && class30_sub3_1.obj3.aClass30_Sub2_Sub4_814.vertexNormal != null)
                method308(model, (Model)class30_sub3_1.obj3.aClass30_Sub2_Sub4_814, 0, 0, 128, true);
        }
        if(i < xMapSize && k < yMapSize)
        {
            Tile class30_sub3_2 = tileArray[j][i + 1][k + 1];
            if(class30_sub3_2 != null && class30_sub3_2.obj3 != null && class30_sub3_2.obj3.aClass30_Sub2_Sub4_814.vertexNormal != null)
                method308(model, (Model)class30_sub3_2.obj3.aClass30_Sub2_Sub4_814, 128, 0, 128, true);
        }
        if(i < xMapSize && k > 0)
        {
            Tile class30_sub3_3 = tileArray[j][i + 1][k - 1];
            if(class30_sub3_3 != null && class30_sub3_3.obj3 != null && class30_sub3_3.obj3.aClass30_Sub2_Sub4_814.vertexNormal != null)
                method308(model, (Model)class30_sub3_3.obj3.aClass30_Sub2_Sub4_814, 128, 0, -128, true);
        }
    }

    private void method307(int i, int j, int k, int l, int i1, Model model)
    {
        boolean flag = true;
        int j1 = l;
        int k1 = l + j;
        int l1 = i1 - 1;
        int i2 = i1 + k;
        for(int j2 = i; j2 <= i + 1; j2++)
            if(j2 != zMapSize)
            {
                for(int k2 = j1; k2 <= k1; k2++)
                    if(k2 >= 0 && k2 < xMapSize)
                    {
                        for(int l2 = l1; l2 <= i2; l2++)
                            if(l2 >= 0 && l2 < yMapSize && (!flag || k2 >= k1 || l2 >= i2 || l2 < i1 && k2 != l))
                            {
                                Tile class30_sub3 = tileArray[j2][k2][l2];
                                if(class30_sub3 != null)
                                {
                                    int i3 = (heightmap[j2][k2][l2] + heightmap[j2][k2 + 1][l2] + heightmap[j2][k2][l2 + 1] + heightmap[j2][k2 + 1][l2 + 1]) / 4 - (heightmap[i][l][i1] + heightmap[i][l + 1][i1] + heightmap[i][l][i1 + 1] + heightmap[i][l + 1][i1 + 1]) / 4;
                                    Object1 class10 = class30_sub3.obj1;
                                    if(class10 != null && class10.aClass30_Sub2_Sub4_278 != null && class10.aClass30_Sub2_Sub4_278.vertexNormal != null)
                                        method308(model, (Model)class10.aClass30_Sub2_Sub4_278, (k2 - l) * 128 + (1 - j) * 64, i3, (l2 - i1) * 128 + (1 - k) * 64, flag);
                                    if(class10 != null && class10.aClass30_Sub2_Sub4_279 != null && class10.aClass30_Sub2_Sub4_279.vertexNormal != null)
                                        method308(model, (Model)class10.aClass30_Sub2_Sub4_279, (k2 - l) * 128 + (1 - j) * 64, i3, (l2 - i1) * 128 + (1 - k) * 64, flag);
                                    for(int j3 = 0; j3 < class30_sub3.entity_count; j3++)
                                    {
                                        Object5 class28 = class30_sub3.entities[j3];
                                        if(class28 != null && class28.aClass30_Sub2_Sub4_521 != null && class28.aClass30_Sub2_Sub4_521.vertexNormal != null)
                                        {
                                            int k3 = (class28.anInt524 - class28.tile_x) + 1;
                                            int l3 = (class28.anInt526 - class28.tile_y) + 1;
                                            method308(model, (Model)class28.aClass30_Sub2_Sub4_521, (class28.tile_x - l) * 128 + (k3 - j) * 64, i3, (class28.tile_y - i1) * 128 + (l3 - k) * 64, flag);
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
        for(int y_angle = 128; y_angle <= 384; y_angle += 32)
        {
            for(int x_angle = 0; x_angle < 2048; x_angle += 64)
            {
                yCurveSine = Model.SINE[y_angle];
                yCurveCosine = Model.COSINE[y_angle];
                xCurveSine = Model.SINE[x_angle];
                xCurveCosine = Model.COSINE[x_angle];
                int y_angle_ptr = (y_angle - 128) / 32;
                int x_angle_ptr = x_angle / 64;
                for(int x = -26; x <= 26; x++)
                {
                    for(int y = -26; y <= 26; y++)
                    {
                        int world_x = x * 128;
                        int world_y = y * 128;
                        boolean is_visible = false;
                        for(int world_z = -min_z; world_z <= max_z; world_z += 128)
                        {
                            if(!is_on_screen(ai[y_angle_ptr] + world_z, world_y, world_x))
                                continue;
                            is_visible = true;
                            break;
                        }

                        aflag[y_angle_ptr][x_angle_ptr][x + 25 + 1][y + 25 + 1] = is_visible;
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

    private static boolean is_on_screen(int z, int y, int x)
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
        this.plane = plane;
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
        for(int k1 = anInt442; k1 < zMapSize; k1++)
        {
            Tile aclass30_sub3[][] = tileArray[k1];
            for(int i2 = anInt449; i2 < anInt450; i2++)
            {
                for(int k2 = anInt451; k2 < anInt452; k2++)
                {
                    Tile class30_sub3 = aclass30_sub3[i2][k2];
                    if(class30_sub3 != null)
                        if(class30_sub3.logic_height > plane || !TILE_VISIBILITY_MAP[(i2 - xCameraPositionTile) + 25][(k2 - yCameraPositionTile) + 25] && heightmap[k1][i2][k2] - zCampos < 2000)
                        {
                            class30_sub3.aBoolean1322 = false;
                            class30_sub3.aBoolean1323 = false;
                            class30_sub3.anInt1325 = 0;
                        } else
                        {
                            class30_sub3.aBoolean1322 = true;
                            class30_sub3.aBoolean1323 = true;
                            class30_sub3.aBoolean1324 = class30_sub3.entity_count > 0;
                            anInt446++;
                        }
                }

            }

        }

        for(int l1 = anInt442; l1 < zMapSize; l1++)
        {
            Tile aclass30_sub3_1[][] = tileArray[l1];
            for(int l2 = -25; l2 <= 0; l2++)
            {
                int i3 = xCameraPositionTile + l2;
                int k3 = xCameraPositionTile - l2;
                if(i3 >= anInt449 || k3 < anInt450)
                {
                    for(int i4 = -25; i4 <= 0; i4++)
                    {
                        int k4 = yCameraPositionTile + i4;
                        int i5 = yCameraPositionTile - i4;
                        if(i3 >= anInt449)
                        {
                            if(k4 >= anInt451)
                            {
                                Tile class30_sub3_1 = aclass30_sub3_1[i3][k4];
                                if(class30_sub3_1 != null && class30_sub3_1.aBoolean1322)
                                    renderTileF(class30_sub3_1, true);
                            }
                            if(i5 < anInt452)
                            {
                                Tile class30_sub3_2 = aclass30_sub3_1[i3][i5];
                                if(class30_sub3_2 != null && class30_sub3_2.aBoolean1322)
                                    renderTileF(class30_sub3_2, true);
                            }
                        }
                        if(k3 < anInt450)
                        {
                            if(k4 >= anInt451)
                            {
                                Tile class30_sub3_3 = aclass30_sub3_1[k3][k4];
                                if(class30_sub3_3 != null && class30_sub3_3.aBoolean1322)
                                    renderTileF(class30_sub3_3, true);
                            }
                            if(i5 < anInt452)
                            {
                                Tile class30_sub3_4 = aclass30_sub3_1[k3][i5];
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
                    Tile class30_sub3_7 = TILE.tileBelow0;
                    if(class30_sub3_7.myPlainTile != null)
                    {
                        if(!method320(0, X, Y))
                            renderTile(class30_sub3_7.myPlainTile, 0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, X, Y);
                    } else
                    if(class30_sub3_7.shapedTile != null && !method320(0, X, Y))
                        drawShapedTile(X, yCurveSine, xCurveSine, class30_sub3_7.shapedTile, yCurveCosine, Y, xCurveCosine);
                    Object1 class10 = class30_sub3_7.obj1;
                    if(class10 != null)
                        class10.aClass30_Sub2_Sub4_278.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class10.anInt274 - xCameraPosition, class10.anInt273 - zCameraPosition, class10.anInt275 - yCameraPosition, class10.uid);
                    for(int i2 = 0; i2 < class30_sub3_7.entity_count; i2++)
                    {
                        Object5 class28 = class30_sub3_7.entities[i2];
                        if(class28 != null)
                            class28.aClass30_Sub2_Sub4_521.renderAtPoint(class28.anInt522, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class28.anInt519 - xCameraPosition, class28.anInt518 - zCameraPosition, class28.anInt520 - yCameraPosition, class28.uid);
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
                Object1 class10_3 = TILE.obj1;
                Object2 class26_1 = TILE.obj2;
                if(class10_3 != null || class26_1 != null)
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
                if(class10_3 != null)
                {
                    if((class10_3.orientation & anIntArray479[j1]) != 0)
                    {
                        if(class10_3.orientation == 16)
                        {
                            TILE.anInt1325 = 3;
                            TILE.anInt1326 = anIntArray481[j1];
                            TILE.anInt1327 = 3 - TILE.anInt1326;
                        } else
                        if(class10_3.orientation == 32)
                        {
                            TILE.anInt1325 = 6;
                            TILE.anInt1326 = anIntArray482[j1];
                            TILE.anInt1327 = 6 - TILE.anInt1326;
                        } else
                        if(class10_3.orientation == 64)
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
                    if((class10_3.orientation & j2) != 0 && !method321(l, X, Y, class10_3.orientation))
                        class10_3.aClass30_Sub2_Sub4_278.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class10_3.anInt274 - xCameraPosition, class10_3.anInt273 - zCameraPosition, class10_3.anInt275 - yCameraPosition, class10_3.uid);
                    if((class10_3.orientation1 & j2) != 0 && !method321(l, X, Y, class10_3.orientation1))
                        class10_3.aClass30_Sub2_Sub4_279.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class10_3.anInt274 - xCameraPosition, class10_3.anInt273 - zCameraPosition, class10_3.anInt275 - yCameraPosition, class10_3.uid);
                }
                if(class26_1 != null && !method322(l, X, Y, class26_1.myMob.modelHeight))
                    if((class26_1.configBits & j2) != 0)
                        class26_1.myMob.renderAtPoint(class26_1.face, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class26_1.X3D - xCameraPosition, class26_1.Z3D - zCameraPosition, class26_1.Y3D - yCameraPosition, class26_1.uid);
                    else
                    if((class26_1.configBits & 0x300) != 0)
                    {
                        int j4 = class26_1.X3D - xCameraPosition;
                        int l5 = class26_1.Z3D - zCameraPosition;
                        int k6 = class26_1.Y3D - yCameraPosition;
                        int i8 = class26_1.face;
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
                        if((class26_1.configBits & 0x100) != 0 && k10 < k9)
                        {
                            int i11 = j4 + faceXOffset2[i8];
                            int k11 = k6 + faceYOffset2[i8];
                            class26_1.myMob.renderAtPoint(i8 * 512 + 256, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, i11, l5, k11, class26_1.uid);
                        }
                        if((class26_1.configBits & 0x200) != 0 && k10 > k9)
                        {
                            int j11 = j4 + faceXOffset3[i8];
                            int l11 = k6 + faceYOffset3[i8];
                            class26_1.myMob.renderAtPoint(i8 * 512 + 1280 & 0x7ff, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, j11, l5, l11, class26_1.uid);
                        }
                    }
                if(flag1)
                {
                    Object3 class49 = TILE.obj3;
                    if(class49 != null)
                        class49.aClass30_Sub2_Sub4_814.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class49.X3D - xCameraPosition, class49.Z3D - zCameraPosition, class49.Y3D - yCameraPosition, class49.uid);
                    GroundItemTile object4_1 = TILE.groundItemTile;
                    if(object4_1 != null && object4_1.anInt52 == 0)
                    {
                        if(object4_1.secondGroundItem != null)
                            object4_1.secondGroundItem.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, object4_1.xPos - xCameraPosition, object4_1.zPos - zCameraPosition, object4_1.yPos - yCameraPosition, object4_1.uid);
                        if(object4_1.thirdGroundItem != null)
                            object4_1.thirdGroundItem.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, object4_1.xPos - xCameraPosition, object4_1.zPos - zCameraPosition, object4_1.yPos - yCameraPosition, object4_1.uid);
                        if(object4_1.topGroundItem != null)
                            object4_1.topGroundItem.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, object4_1.xPos - xCameraPosition, object4_1.zPos - zCameraPosition, object4_1.yPos - yCameraPosition, object4_1.uid);
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
                for(int k1 = 0; k1 < TILE.entity_count; k1++)
                {
                    if(TILE.entities[k1].anInt528 == anInt448 || (TILE.anIntArray1319[k1] & TILE.anInt1325) != TILE.anInt1326)
                        continue;
                    flag2 = false;
                    break;
                }

                if(flag2)
                {
                    Object1 class10_1 = TILE.obj1;
                    if(!method321(l, X, Y, class10_1.orientation))
                        class10_1.aClass30_Sub2_Sub4_278.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class10_1.anInt274 - xCameraPosition, class10_1.anInt273 - zCameraPosition, class10_1.anInt275 - yCameraPosition, class10_1.uid);
                    TILE.anInt1325 = 0;
                }
            }
            if(TILE.aBoolean1324)
                try
                {
                    int i1 = TILE.entity_count;
                    TILE.aBoolean1324 = false;
                    int l1 = 0;
label0:
                    for(int k2 = 0; k2 < i1; k2++)
                    {
                        Object5 class28_1 = TILE.entities[k2];
                        if(class28_1.anInt528 == anInt448)
                            continue;
                        for(int k3 = class28_1.tile_x; k3 <= class28_1.anInt524; k3++)
                        {
                            for(int l4 = class28_1.tile_y; l4 <= class28_1.anInt526; l4++)
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
                                    if(k3 > class28_1.tile_x)
                                        l6++;
                                    if(k3 < class28_1.anInt524)
                                        l6 += 4;
                                    if(l4 > class28_1.tile_y)
                                        l6 += 8;
                                    if(l4 < class28_1.anInt526)
                                        l6 += 2;
                                    if((l6 & class30_sub3_21.anInt1325) != TILE.anInt1327)
                                        continue;
                                    TILE.aBoolean1324 = true;
                                }
                                continue label0;
                            }

                        }

                        aClass28Array462[l1++] = class28_1;
                        int i5 = xCameraPositionTile - class28_1.tile_x;
                        int i6 = class28_1.anInt524 - xCameraPositionTile;
                        if(i6 > i5)
                            i5 = i6;
                        int i7 = yCameraPositionTile - class28_1.tile_y;
                        int j8 = class28_1.anInt526 - yCameraPositionTile;
                        if(j8 > i7)
                            class28_1.anInt527 = i5 + j8;
                        else
                            class28_1.anInt527 = i5 + i7;
                    }

                    while(l1 > 0) 
                    {
                        int i3 = -50;
                        int l3 = -1;
                        for(int j5 = 0; j5 < l1; j5++)
                        {
                            Object5 class28_2 = aClass28Array462[j5];
                            if(class28_2.anInt528 != anInt448)
                                if(class28_2.anInt527 > i3)
                                {
                                    i3 = class28_2.anInt527;
                                    l3 = j5;
                                } else
                                if(class28_2.anInt527 == i3)
                                {
                                    int j7 = class28_2.anInt519 - xCameraPosition;
                                    int k8 = class28_2.anInt520 - yCameraPosition;
                                    int l9 = aClass28Array462[l3].anInt519 - xCameraPosition;
                                    int l10 = aClass28Array462[l3].anInt520 - yCameraPosition;
                                    if(j7 * j7 + k8 * k8 > l9 * l9 + l10 * l10)
                                        l3 = j5;
                                }
                        }

                        if(l3 == -1)
                            break;
                        Object5 class28_3 = aClass28Array462[l3];
                        class28_3.anInt528 = anInt448;
                        if(!method323(l, class28_3.tile_x, class28_3.anInt524, class28_3.tile_y, class28_3.anInt526, class28_3.aClass30_Sub2_Sub4_521.modelHeight))
                            class28_3.aClass30_Sub2_Sub4_521.renderAtPoint(class28_3.anInt522, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class28_3.anInt519 - xCameraPosition, class28_3.anInt518 - zCameraPosition, class28_3.anInt520 - yCameraPosition, class28_3.uid);
                        for(int k7 = class28_3.tile_x; k7 <= class28_3.anInt524; k7++)
                        {
                            for(int l8 = class28_3.tile_y; l8 <= class28_3.anInt526; l8++)
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
                if(object4.topGroundItem != null)
                    object4.topGroundItem.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, object4.xPos - xCameraPosition, object4.zPos - zCameraPosition - object4.anInt52, object4.yPos - yCameraPosition, object4.uid);
            }
            if(TILE.anInt1328 != 0)
            {
                Object2 class26 = TILE.obj2;
                if(class26 != null && !method322(l, X, Y, class26.myMob.modelHeight))
                    if((class26.configBits & TILE.anInt1328) != 0)
                        class26.myMob.renderAtPoint(class26.face, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class26.X3D - xCameraPosition, class26.Z3D - zCameraPosition, class26.Y3D - yCameraPosition, class26.uid);
                    else
                    if((class26.configBits & 0x300) != 0)
                    {
                        int l2 = class26.X3D - xCameraPosition;
                        int j3 = class26.Z3D - zCameraPosition;
                        int i4 = class26.Y3D - yCameraPosition;
                        int k5 = class26.face;
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
                        if((class26.configBits & 0x100) != 0 && l7 >= j6)
                        {
                            int i9 = l2 + faceXOffset2[k5];
                            int i10 = i4 + faceYOffset2[k5];
                            class26.myMob.renderAtPoint(k5 * 512 + 256, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, i9, j3, i10, class26.uid);
                        }
                        if((class26.configBits & 0x200) != 0 && l7 <= j6)
                        {
                            int j9 = l2 + faceXOffset3[k5];
                            int j10 = i4 + faceYOffset3[k5];
                            class26.myMob.renderAtPoint(k5 * 512 + 1280 & 0x7ff, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, j9, j3, j10, class26.uid);
                        }
                    }
                Object1 class10_2 = TILE.obj1;
                if(class10_2 != null)
                {
                    if((class10_2.orientation1 & TILE.anInt1328) != 0 && !method321(l, X, Y, class10_2.orientation1))
                        class10_2.aClass30_Sub2_Sub4_279.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class10_2.anInt274 - xCameraPosition, class10_2.anInt273 - zCameraPosition, class10_2.anInt275 - yCameraPosition, class10_2.uid);
                    if((class10_2.orientation & TILE.anInt1328) != 0 && !method321(l, X, Y, class10_2.orientation))
                        class10_2.aClass30_Sub2_Sub4_278.renderAtPoint(0, yCurveSine, yCurveCosine, xCurveSine, xCurveCosine, class10_2.anInt274 - xCameraPosition, class10_2.anInt273 - zCameraPosition, class10_2.anInt275 - yCameraPosition, class10_2.uid);
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
        int screenXA = ThreeDimensionalDrawingArea.xMidPos + (xA << 9) / yA;
        int screenYA = ThreeDimensionalDrawingArea.yMidPos + (zA << 9) / yA;
        int screenXB = ThreeDimensionalDrawingArea.xMidPos + (xB << 9) / yB;
        int screenYB = ThreeDimensionalDrawingArea.yMidPos + (zB << 9) / yB;
        int screenXD = ThreeDimensionalDrawingArea.xMidPos + (xD << 9) / yD;
        int screenYD = ThreeDimensionalDrawingArea.yMidPos + (zD << 9) / yD;
        int screenXC = ThreeDimensionalDrawingArea.xMidPos + (xC << 9) / yC;
        int screenYC = ThreeDimensionalDrawingArea.yMidPos + (zC << 9) / yC;
        ThreeDimensionalDrawingArea.alpha = 0;
        if((screenXD - screenXC) * (screenYB - screenYC) - (screenYD - screenYC) * (screenXB - screenXC) > 0)
        {
            ThreeDimensionalDrawingArea.aBoolean1462 = screenXD < 0 || screenXC < 0 || screenXB < 0 || screenXD > DrawingArea.viewportRx || screenXC > DrawingArea.viewportRx || screenXB > DrawingArea.viewportRx;
            if(isClicked && isTriangleClicked(clickX, clickY, screenYD, screenYC, screenYB, screenXD, screenXC, screenXB))
            {
                clickedTileX = tX;
                clickedTileY = tY;
            }
            if(plainTile.texture == -1)
            {
                if(plainTile.colourD != 0xbc614e)
                    ThreeDimensionalDrawingArea.drawColouredTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB);
            } else
            if(!lowMem)
            {
                if(plainTile.flat)
                    ThreeDimensionalDrawingArea.drawTexturedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB, xA, xB, xC, zA, zB, zC, yA, yB, yC, plainTile.texture);
                else
                    ThreeDimensionalDrawingArea.drawTexturedTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, plainTile.colourD, plainTile.colourC, plainTile.colourB, xD, xC, xB, zD, zC, zB, yD, yC, yB, plainTile.texture);
            } else
            {
                int i7 = textureRGBColour[plainTile.texture];
                ThreeDimensionalDrawingArea.drawColouredTriangle(screenYD, screenYC, screenYB, screenXD, screenXC, screenXB, mixColour(i7, plainTile.colourD), mixColour(i7, plainTile.colourC), mixColour(i7, plainTile.colourB));
            }
        }
        if((screenXA - screenXB) * (screenYC - screenYB) - (screenYA - screenYB) * (screenXC - screenXB) > 0)
        {
            ThreeDimensionalDrawingArea.aBoolean1462 = screenXA < 0 || screenXB < 0 || screenXC < 0 || screenXA > DrawingArea.viewportRx || screenXB > DrawingArea.viewportRx || screenXC > DrawingArea.viewportRx;
            if(isClicked && isTriangleClicked(clickX, clickY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC))
            {
                clickedTileX = tX;
                clickedTileY = tY;
            }
            if(plainTile.texture == -1)
            {
                if(plainTile.colourA != 0xbc614e)
                {
                    ThreeDimensionalDrawingArea.drawColouredTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, plainTile.colourA, plainTile.colourB, plainTile.colourC);
                }
            } else
            {
                if(!lowMem)
                {
                    ThreeDimensionalDrawingArea.drawTexturedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, plainTile.colourA, plainTile.colourB, plainTile.colourC, xA, xB, xC, zA, zB, zC, yA, yB, yC, plainTile.texture);
                    return;
                }
                int j7 = textureRGBColour[plainTile.texture];
                ThreeDimensionalDrawingArea.drawColouredTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, mixColour(j7, plainTile.colourA), mixColour(j7, plainTile.colourB), mixColour(j7, plainTile.colourC));
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
            ShapedTile.screenX[vID] = ThreeDimensionalDrawingArea.xMidPos + (i2 << 9) / i3;
            ShapedTile.screenY[vID] = ThreeDimensionalDrawingArea.yMidPos + (k2 << 9) / i3;
        }

        ThreeDimensionalDrawingArea.alpha = 0;
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
                ThreeDimensionalDrawingArea.aBoolean1462 = sXA < 0 || sXB < 0 || sXC < 0 || sXA > DrawingArea.viewportRx || sXB > DrawingArea.viewportRx || sXC > DrawingArea.viewportRx;
                if(isClicked && isTriangleClicked(clickX, clickY, sYA, sYB, sYC, sXA, sXB, sXC))
                {
                    clickedTileX = i;
                    clickedTileY = i1;
                }
                if(shapedTile.triTex == null || shapedTile.triTex[j2] == -1)
                {
                    if(shapedTile.verticeColourA[j2] != 0xbc614e)
                        ThreeDimensionalDrawingArea.drawColouredTriangle(sYA, sYB, sYC, sXA, sXB, sXC, shapedTile.verticeColourA[j2], shapedTile.verticeColourB[j2], shapedTile.verticeColourC[j2]);
                } else
                if(!lowMem)
                {
                    if(shapedTile.flat)
                        ThreeDimensionalDrawingArea.drawTexturedTriangle(sYA, sYB, sYC, sXA, sXB, sXC, shapedTile.verticeColourA[j2], shapedTile.verticeColourB[j2], shapedTile.verticeColourC[j2], ShapedTile.veritceX[0], ShapedTile.veritceX[1], ShapedTile.veritceX[3], ShapedTile.veritceZ[0], ShapedTile.veritceZ[1], ShapedTile.veritceZ[3], ShapedTile.veritceY[0], ShapedTile.veritceY[1], ShapedTile.veritceY[3], shapedTile.triTex[j2]);
                    else
                        ThreeDimensionalDrawingArea.drawTexturedTriangle(sYA, sYB, sYC, sXA, sXB, sXC, shapedTile.verticeColourA[j2], shapedTile.verticeColourB[j2], shapedTile.verticeColourC[j2], ShapedTile.veritceX[indexA], ShapedTile.veritceX[indexB], ShapedTile.veritceX[indexC], ShapedTile.veritceZ[indexA], ShapedTile.veritceZ[indexB], ShapedTile.veritceZ[indexC], ShapedTile.veritceY[indexA], ShapedTile.veritceY[indexB], ShapedTile.veritceY[indexC], shapedTile.triTex[j2]);
                } else
                {
                    int k5 = textureRGBColour[shapedTile.triTex[j2]];
                    ThreeDimensionalDrawingArea.drawColouredTriangle(sYA, sYB, sYC, sXA, sXB, sXC, mixColour(k5, shapedTile.verticeColourA[j2]), mixColour(k5, shapedTile.verticeColourB[j2]), mixColour(k5, shapedTile.verticeColourC[j2]));
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
        int cluster_count = culling_cluster_ptr[plane];
        CullingCluster clusters[] = culling_clusters[plane];
        processed_culling_clusters_ptr = 0;
        for(int ptr = 0; ptr < cluster_count; ptr++)
        {
            CullingCluster cluster = clusters[ptr];
            if(cluster.search_mask == 1)
            {
                int x_dist_from_camera_start = (cluster.tile_start_x - xCameraPositionTile) + 25;
                if(x_dist_from_camera_start < 0 || x_dist_from_camera_start > 50)
                    continue;
                int y_dist_from_camera_start = (cluster.tile_start_y - yCameraPositionTile) + 25;
                if(y_dist_from_camera_start < 0)
                    y_dist_from_camera_start = 0;
                int y_dist_from_camera_end = (cluster.tile_end_y - yCameraPositionTile) + 25;
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
                int x_dist_from_camera_start_real = xCameraPosition - cluster.world_start_x;
                if(x_dist_from_camera_start_real > 32)
                {
                    cluster.tile_distance_enum = 1;
                } else
                {
                    if(x_dist_from_camera_start_real >= -32)
                        continue;
                    cluster.tile_distance_enum = 2;
                    x_dist_from_camera_start_real = -x_dist_from_camera_start_real;
                }
                cluster.world_distance_from_camera_start_y = (cluster.world_start_y - yCameraPosition << 8) / x_dist_from_camera_start_real;
                cluster.world_distance_from_camera_end_y = (cluster.world_end_y - yCameraPosition << 8) / x_dist_from_camera_start_real;
                cluster.world_distance_from_camera_start_z = (cluster.world_start_z - zCameraPosition << 8) / x_dist_from_camera_start_real;
                cluster.world_distance_from_camera_end_z = (cluster.world_end_z - zCameraPosition << 8) / x_dist_from_camera_start_real;
                processed_culling_clusters[processed_culling_clusters_ptr++] = cluster;
                continue;
            }
            if(cluster.search_mask == 2)
            {
                int y_dist_from_camera_start = (cluster.tile_start_y - yCameraPositionTile) + 25;
                if(y_dist_from_camera_start < 0 || y_dist_from_camera_start > 50)
                    continue;
                int x_dist_from_camera_start = (cluster.tile_start_x - xCameraPositionTile) + 25;
                if(x_dist_from_camera_start < 0)
                    x_dist_from_camera_start = 0;
                int x_dist_from_camera_end = (cluster.tile_end_x - xCameraPositionTile) + 25;
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
                int y_dist_from_camera_start_real = yCameraPosition - cluster.world_start_y;
                if(y_dist_from_camera_start_real > 32)
                {
                    cluster.tile_distance_enum = 3;
                } else
                {
                    if(y_dist_from_camera_start_real >= -32)
                        continue;
                    cluster.tile_distance_enum = 4;
                    y_dist_from_camera_start_real = -y_dist_from_camera_start_real;
                }
                cluster.world_distance_from_camera_start_x = (cluster.world_start_x - xCameraPosition << 8) / y_dist_from_camera_start_real;
                cluster.world_distance_from_camera_end_x = (cluster.world_end_x - xCameraPosition << 8) / y_dist_from_camera_start_real;
                cluster.world_distance_from_camera_start_z = (cluster.world_start_z - zCameraPosition << 8) / y_dist_from_camera_start_real;
                cluster.world_distance_from_camera_end_z = (cluster.world_end_z - zCameraPosition << 8) / y_dist_from_camera_start_real;
                processed_culling_clusters[processed_culling_clusters_ptr++] = cluster;
            } else
            if(cluster.search_mask == 4)
            {
                int z_dist_from_camera_start_real = cluster.world_start_z - zCameraPosition;
                if(z_dist_from_camera_start_real > 128)
                {
                    int y_dist_from_camera_start = (cluster.tile_start_y - yCameraPositionTile) + 25;
                    if(y_dist_from_camera_start < 0)
                        y_dist_from_camera_start = 0;
                    int y_dist_from_camera_end = (cluster.tile_end_y - yCameraPositionTile) + 25;
                    if(y_dist_from_camera_end > 50)
                        y_dist_from_camera_end = 50;
                    if(y_dist_from_camera_start <= y_dist_from_camera_end)
                    {
                        int x_dist_from_camera_start = (cluster.tile_start_x - xCameraPositionTile) + 25;
                        if(x_dist_from_camera_start < 0)
                            x_dist_from_camera_start = 0;
                        int x_dist_from_camera_end = (cluster.tile_end_x - xCameraPositionTile) + 25;
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
                            cluster.tile_distance_enum = 5;
                            cluster.world_distance_from_camera_start_x = (cluster.world_start_x - xCameraPosition << 8) / z_dist_from_camera_start_real;
                            cluster.world_distance_from_camera_end_x = (cluster.world_end_x - xCameraPosition << 8) / z_dist_from_camera_start_real;
                            cluster.world_distance_from_camera_start_y = (cluster.world_start_y - yCameraPosition << 8) / z_dist_from_camera_start_real;
                            cluster.world_distance_from_camera_end_y = (cluster.world_end_y - yCameraPosition << 8) / z_dist_from_camera_start_real;
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
            if(class47.tile_distance_enum == 1)
            {
                int i1 = class47.world_start_x - i;
                if(i1 > 0)
                {
                    int j2 = class47.world_start_y + (class47.world_distance_from_camera_start_y * i1 >> 8);
                    int k3 = class47.world_end_y + (class47.world_distance_from_camera_end_y * i1 >> 8);
                    int l4 = class47.world_start_z + (class47.world_distance_from_camera_start_z * i1 >> 8);
                    int i6 = class47.world_end_z + (class47.world_distance_from_camera_end_z * i1 >> 8);
                    if(k >= j2 && k <= k3 && j >= l4 && j <= i6)
                        return true;
                }
            } else
            if(class47.tile_distance_enum == 2)
            {
                int j1 = i - class47.world_start_x;
                if(j1 > 0)
                {
                    int k2 = class47.world_start_y + (class47.world_distance_from_camera_start_y * j1 >> 8);
                    int l3 = class47.world_end_y + (class47.world_distance_from_camera_end_y * j1 >> 8);
                    int i5 = class47.world_start_z + (class47.world_distance_from_camera_start_z * j1 >> 8);
                    int j6 = class47.world_end_z + (class47.world_distance_from_camera_end_z * j1 >> 8);
                    if(k >= k2 && k <= l3 && j >= i5 && j <= j6)
                        return true;
                }
            } else
            if(class47.tile_distance_enum == 3)
            {
                int k1 = class47.world_start_y - k;
                if(k1 > 0)
                {
                    int l2 = class47.world_start_x + (class47.world_distance_from_camera_start_x * k1 >> 8);
                    int i4 = class47.world_end_x + (class47.world_distance_from_camera_end_x * k1 >> 8);
                    int j5 = class47.world_start_z + (class47.world_distance_from_camera_start_z * k1 >> 8);
                    int k6 = class47.world_end_z + (class47.world_distance_from_camera_end_z * k1 >> 8);
                    if(i >= l2 && i <= i4 && j >= j5 && j <= k6)
                        return true;
                }
            } else
            if(class47.tile_distance_enum == 4)
            {
                int l1 = k - class47.world_start_y;
                if(l1 > 0)
                {
                    int i3 = class47.world_start_x + (class47.world_distance_from_camera_start_x * l1 >> 8);
                    int j4 = class47.world_end_x + (class47.world_distance_from_camera_end_x * l1 >> 8);
                    int k5 = class47.world_start_z + (class47.world_distance_from_camera_start_z * l1 >> 8);
                    int l6 = class47.world_end_z + (class47.world_distance_from_camera_end_z * l1 >> 8);
                    if(i >= i3 && i <= j4 && j >= k5 && j <= l6)
                        return true;
                }
            } else
            if(class47.tile_distance_enum == 5)
            {
                int i2 = j - class47.world_start_z;
                if(i2 > 0)
                {
                    int j3 = class47.world_start_x + (class47.world_distance_from_camera_start_x * i2 >> 8);
                    int k4 = class47.world_end_x + (class47.world_distance_from_camera_end_x * i2 >> 8);
                    int l5 = class47.world_start_y + (class47.world_distance_from_camera_start_y * i2 >> 8);
                    int i7 = class47.world_end_y + (class47.world_distance_from_camera_end_y * i2 >> 8);
                    if(i >= j3 && i <= k4 && k >= l5 && k <= i7)
                        return true;
                }
            }
        }

        return false;
    }

    private boolean aBoolean434;
    public static boolean lowMem = true;
    private final int zMapSize;
    private final int xMapSize;
    private final int yMapSize;
    private final int[][][] heightmap;
    private final Tile[][][] tileArray;
    private int anInt442;
    private int obj5CacheCurrPos;
    private final Object5[] obj5Cache;
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
    private static Object5[] aClass28Array462 = new Object5[100];
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
    private static int[] culling_cluster_ptr;
    private static CullingCluster[][] culling_clusters;
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

    static 
    {
        anInt472 = 4;
        culling_cluster_ptr = new int[anInt472];
        culling_clusters = new CullingCluster[anInt472][500];
    }
}
