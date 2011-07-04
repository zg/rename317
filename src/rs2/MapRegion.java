package rs2;

// Decompiler options: packimports(3)

import java.io.File;

public class MapRegion {

    private int[][][] underlayRgb;
    public boolean[][][] automaticHeight;
    private boolean isMapEditor = false;
    /**
     * Constant naming scheme:
     * *FC - False colour
     * *RES - Resolution (as in: to look something up)
     */
    public static final int NO_BLENDING_BIT   = 1;
    public static final int NO_OVERLAY_BIT    = 2;
    public static final int NO_COLOUR_RES_BIT = 4;
    public static final int RENDER_HIDDEN_BIT = 16;
    public static final int TILE_SETTINGS_FC = NO_BLENDING_BIT | NO_COLOUR_RES_BIT | NO_OVERLAY_BIT | 8;

    public MapRegion(int width, int height, byte tileSettings[][][], int heightMap[][][])
    {
        setZ = 99;
        xMapSize = width;
        yMapSize = height;
        this.heightMap = heightMap;
        this.tileSettings = tileSettings;
        underLay = new byte[4][xMapSize][yMapSize];
        overLay = new byte[4][xMapSize][yMapSize];
        tileShape = new byte[4][xMapSize][yMapSize];
        tileRotation = new byte[4][xMapSize][yMapSize];
        tile_culling_bitmap = new int[4][xMapSize + 1][yMapSize + 1];
        object_shadow_data = new byte[4][xMapSize + 1][yMapSize + 1];
        tileLightness = new int[xMapSize + 1][yMapSize + 1];
        underlayRgb = new int[4][xMapSize][yMapSize];
        automaticHeight = new boolean[4][xMapSize][yMapSize];//Used only by the editor utility
        hue = new int[yMapSize];
        saturation = new int[yMapSize];
        lightness = new int[yMapSize];
        huedivider = new int[yMapSize];
        colourCount = new int[yMapSize];
    }

    private static int method170(int i, int j)
    {
        int k = i + j * 57;
        k = k << 13 ^ k;
        int l = k * (k * k * 15731 + 0xc0ae5) + 0x5208dd0d & 0x7fffffff;
        return l >> 19 & 0xff;
    }

    public final void addTiles(TileSetting aclass11[], SceneGraph sceneGraph, int renderMode)
    {
        for(int j = 0; j < 4; j++)
        {
            for(int k = 0; k < xMapSize; k++)
            {
                for(int i1 = 0; i1 < yMapSize; i1++)
                    if((tileSettings[j][k][i1] & 1) == 1)
                    {
                        int k1 = j;
                        if((tileSettings[1][k][i1] & 2) == 2)
                            k1--;
                        if(k1 >= 0)
                            aclass11[k1].orClipTableSET(i1, k);
                    }

            }

        }
        hue_offset += (int)(Math.random() * 5D) - 2;
        if(hue_offset < -8)
            hue_offset = -8;
        if(hue_offset > 8)
            hue_offset = 8;
        lightness_offset += (int)(Math.random() * 5D) - 2;
        if(lightness_offset < -16)
            lightness_offset = -16;
        if(lightness_offset > 16)
            lightness_offset = 16;
        for(int z = 0; z < 4; z++)
        {
            byte something_with_objects[][] = object_shadow_data[z];
            byte light_off = 96;
            char falloff = '\u0300';
            byte l_x = -50;
            byte l_y = -10;
            byte l_z = -50;
            int l_mag = (int)Math.sqrt(l_x * l_x + l_y * l_y + l_z * l_z);
            int sqrtA = falloff * l_mag >> 8;
            for(int Y = 1; Y < yMapSize - 1; Y++)
            {
                for(int X = 1; X < xMapSize - 1; X++)
                {	//This renders the object shadows
                    int hDX = heightMap[z][X + 1][Y] - heightMap[z][X - 1][Y];
                    int hDY = heightMap[z][X][Y + 1] - heightMap[z][X][Y - 1];
                    int square = (int)Math.sqrt(hDX * hDX + 0x10000 + hDY * hDY);
                    int normal_x = (hDX << 8) / square;
                    int normal_y = 0x10000 / square;
                    int normal_z = (hDY << 8) / square;
                    int j16 = light_off + (l_x * normal_x + l_y * normal_y + l_z * normal_z) / sqrtA;
                    int j17 = (something_with_objects[X - 1][Y] >> 2) + (something_with_objects[X + 1][Y] >> 3) + (something_with_objects[X][Y - 1] >> 2) + (something_with_objects[X][Y + 1] >> 3) + (something_with_objects[X][Y] >> 1);
                    tileLightness[X][Y] = j16 - j17;
                }

            }
            if ((renderMode & NO_BLENDING_BIT) == 0)
                for(int _y = 0; _y < yMapSize; _y++)
                {
                    hue[_y] = 0;
                    saturation[_y] = 0;
                    lightness[_y] = 0;
                    huedivider[_y] = 0;
                    colourCount[_y] = 0;
                }

            for(int X = -5; X < xMapSize + 5; X++)
            {
                if ((renderMode & NO_BLENDING_BIT) == 0)
                    for(int Y = 0; Y < yMapSize; Y++)
                    {
                        int xPlus5 = X + 5;
                        if(xPlus5 >= 0 && xPlus5 < xMapSize)
                        {
                            int floID = underLay[z][xPlus5][Y] & 0xff;
                            if(floID > 0)
                            {
                                Floor floor = Floor.cache[floID - 1];
                                hue[Y] += floor.hue2;
                                saturation[Y] += floor.saturation;
                                lightness[Y] += floor.lightness;
                                huedivider[Y] += floor.pCDivider;
                                colourCount[Y]++;
                            }
                        }
                        int yMin5 = X - 5;
                        if(yMin5 >= 0 && yMin5 < xMapSize)
                        {
                            int floID = underLay[z][yMin5][Y] & 0xff;
                            if(floID > 0)
                            {
                                Floor floor_1 = Floor.cache[floID - 1];
                                hue[Y] -= floor_1.hue2;
                                saturation[Y] -= floor_1.saturation;
                                lightness[Y] -= floor_1.lightness;
                                huedivider[Y] -= floor_1.pCDivider;
                                colourCount[Y]--;
                            }
                        }
                    }

                if(X >= 1 && X < xMapSize - 1)
                {
                    int tile_hue = 0;
                    int tile_sat = 0;
                    int tile_light = 0;
                    int tile_hue_shift = 0;
                    int colourCount = 0;
                    for(int Y = -5; Y < yMapSize + 5; Y++)
                    {
                        if ((renderMode & NO_BLENDING_BIT) == 0){
                            int yPlus5 = Y + 5;
                            if(yPlus5 >= 0 && yPlus5 < yMapSize)
                            {
                                tile_hue += hue[yPlus5];
                                tile_sat += saturation[yPlus5];
                                tile_light += lightness[yPlus5];
                                tile_hue_shift += huedivider[yPlus5];
                                colourCount += this.colourCount[yPlus5];
                            }
                            int yMin5 = Y - 5;
                            if(yMin5 >= 0 && yMin5 < yMapSize)
                            {
                                tile_hue -= hue[yMin5];
                                tile_sat -= saturation[yMin5];
                                tile_light -= lightness[yMin5];
                                tile_hue_shift -= huedivider[yMin5];
                                colourCount -= this.colourCount[yMin5];
                            }
                        }
                        if(Y >= 1 && Y < yMapSize - 1 && (!lowMem || (tileSettings[0][X][Y] & 2) != 0 || (tileSettings[z][X][Y] & 0x10) == 0 && get_logic_height(z, X, Y) == anInt131))
                        {
                            if(z < setZ)
                                setZ = z;
                            int underlayID = underLay[z][X][Y] & 0xff;
                            int overlay_id = overLay[z][X][Y] & 0xff;
                            if(underlayID > 0 || overlay_id > 0 || (renderMode & RENDER_HIDDEN_BIT) != 0)
                            {
                                int zA = heightMap[z][X][Y];
                                int zB = heightMap[z][X + 1][Y];
                                int zD = heightMap[z][X + 1][Y + 1];
                                int zC = heightMap[z][X][Y + 1];
                                int shadow_a = tileLightness[X][Y];
                                int shadow_b = tileLightness[X + 1][Y];
                                int shadow_d = tileLightness[X + 1][Y + 1];
                                int shadow_c = tileLightness[X][Y + 1];
                                int underlay_hsl_real = -1;
                                int underlay_hsl = -1;
                                if(underlayID > 0 || (renderMode & RENDER_HIDDEN_BIT) != 0)
                                {
                                    int h = -1;
                                    int s = 0;
                                    int l = 0;
                                    if (underlayID == 0 && (renderMode & RENDER_HIDDEN_BIT) != 0){
                                        h = 120;
                                        s = 128;
                                        l = 128;
                                    } else if ((renderMode & NO_BLENDING_BIT) == 0){     //Not hidden
                                        h = (tile_hue * 256) / tile_hue_shift;
                                        s = tile_sat / colourCount;
                                        l = tile_light / colourCount;
                                        underlay_hsl_real = pack_hsl(h, s, l);
                                        h = h + hue_offset & 0xff;
                                        l += lightness_offset;
                                        if(l < 0)
                                            l = 0;
                                        else
                                        if(l > 255)
                                            l = 255;
                                    } else if ((renderMode & 8) != 0) {      // Not blending
                                        boolean clipped = (tileSettings[z][X][Y] & 1) == 1;
                                        boolean bridge = (tileSettings[z][X][Y] & 2) == 2;
                                        boolean removeroofs = (tileSettings[z][X][Y] & 3) == 3;
                                        underlay_hsl = rgb2hls((clipped     ? 0xFF0000 : 0) |
                                                               (bridge      ? 0x00FF00 : 0) |
                                                               (removeroofs ? 0x0000FF : 0));
                                    } else if ((renderMode & NO_COLOUR_RES_BIT) == 0){  //Not falsecolour
                                        Floor underlayF = Floor.cache[underlayID - 1];
                                        underlay_hsl = underlayF.hslColour;
                                    } else {
                                        h = underlayID;
                                        s = 128;
                                        l = 128;
                                    }
                                    if (h != -1 && underlay_hsl == -1)
                                        underlay_hsl = pack_hsl(h, s, l);
                                    if (underlay_hsl_real == -1)
                                        underlay_hsl_real = underlay_hsl;
                                }
                                if(z > 0)
                                {
                                    boolean underlay_hidden = true;
                                    if(underlayID == 0 && tileShape[z][X][Y] != 0)
                                        underlay_hidden = false;
                                    if(overlay_id > 0 && !Floor.cache[overlay_id - 1].occlude)
                                        underlay_hidden = false;
                                    if(((renderMode & RENDER_HIDDEN_BIT) != 0  || ((tileSettings[z][X][Y] & 0x10) == 0 && (underlayID != 0 || overlay_id != 0))) && underlay_hidden && zA == zB && zA == zD && zA == zC)
                                        tile_culling_bitmap[z][X][Y] |= 0x924;
                                }
                                int underlay_rgb = 0;
                                if(underlay_hsl_real != -1)
                                    underlay_rgb = Rasterizer.hsl2rgb[mix_lightness(underlay_hsl, 96)];
                                underlayRgb[z][X][Y] = underlay_rgb;
                                if(overlay_id == 0 || (renderMode & NO_OVERLAY_BIT) != 0)
                                {
                                    sceneGraph.addTile(z, X, Y, 0, 0, -1, zA, zB, zD, zC, mix_lightness(underlay_hsl_real, shadow_a), mix_lightness(underlay_hsl_real, shadow_b), mix_lightness(underlay_hsl_real, shadow_d), mix_lightness(underlay_hsl_real, shadow_c), 0, 0, 0, 0, underlay_rgb, 0);
                                } else {
                                    int shape = tileShape[z][X][Y] + 1;
                                    byte rotation = tileRotation[z][X][Y];
                                    Floor overlay = Floor.cache[overlay_id - 1];
                                    int overlay_texture = overlay.texture;
                                    int overlay_hsl;
                                    int overlay_rgb;
                                    if(overlay_texture >= 0)
                                    {
                                        overlay_rgb = Rasterizer.getAverageTextureColour(overlay_texture);
                                        overlay_hsl = -1;//Grayscale
                                    } else if(overlay.colour2 == 0xff00ff) {
                                        overlay_rgb = 0;
                                        overlay_hsl = -2;//Transparent
                                        overlay_texture = -1;
                                    } else {
                                        overlay_hsl = overlay.hslColour;//pack_hsl(overlay.hue, overlay.saturation, overlay.lightness);
                                        overlay_rgb = Rasterizer.hsl2rgb[mix_lightness_gt(overlay.hslColour, 96)];
                                    }
                                    sceneGraph.addTile(z, X, Y, shape, rotation, overlay_texture, zA, zB, zD, zC, mix_lightness(underlay_hsl_real, shadow_a), mix_lightness(underlay_hsl_real, shadow_b), mix_lightness(underlay_hsl_real, shadow_d), mix_lightness(underlay_hsl_real, shadow_c), mix_lightness_gt(overlay_hsl, shadow_a), mix_lightness_gt(overlay_hsl, shadow_b), mix_lightness_gt(overlay_hsl, shadow_d), mix_lightness_gt(overlay_hsl, shadow_c), underlay_rgb, overlay_rgb);
                                }
                            }
                        }
                    }

                }
            }

            for(int _y = 1; _y < yMapSize - 1; _y++)
            {
                for(int _x = 1; _x < xMapSize - 1; _x++)
                    sceneGraph.setTileLogicHeight(z, _x, _y, get_logic_height(z, _x, _y));

            }

        }

        sceneGraph.shadeModels(-50, -10, -50, 768, 64);
        for(int _x = 0; _x < xMapSize; _x++)
        {
            for(int _y = 0; _y < yMapSize; _y++)
                if((tileSettings[1][_x][_y] & 2) == 2)
                    sceneGraph.applyBridgeMode(_x, _y);

        }

        int x_flag = 1;
        int y_flag = 2;
        int z_flag = 4;
        for(int _z = 0; _z < 4; _z++)
        {
            if(_z > 0)
            {
                x_flag <<= 3;
                y_flag <<= 3;
                z_flag <<= 3;
            }
            for(int __z = 0; __z <= _z; __z++)
            {
                for(int __y = 0; __y <= yMapSize; __y++)
                {
                    for(int __x = 0; __x <= xMapSize; __x++)
                    {
                        if((tile_culling_bitmap[__z][__x][__y] & x_flag) != 0)
                        {
                            int lowest_y_flagged = __y;
                            int highest_y_flagged = __y;
                            int lowest_z_flagged = __z;
                            int highest_z_flagged = __z;
                            for(; lowest_y_flagged > 0 && (tile_culling_bitmap[__z][__x][lowest_y_flagged - 1] & x_flag) != 0; lowest_y_flagged--);
                            for(; highest_y_flagged < yMapSize && (tile_culling_bitmap[__z][__x][highest_y_flagged + 1] & x_flag) != 0; highest_y_flagged++);
for_lowest_z_flagged:
                            for(; lowest_z_flagged > 0; lowest_z_flagged--)
                            {
                                for(int ___y = lowest_y_flagged; ___y <= highest_y_flagged; ___y++)
                                    if((tile_culling_bitmap[lowest_z_flagged - 1][__x][___y] & x_flag) == 0)
                                        break for_lowest_z_flagged;

                            }

for_highest_z_flagged:
                            for(; highest_z_flagged < _z; highest_z_flagged++)
                            {
                                for(int ___y = lowest_y_flagged; ___y <= highest_y_flagged; ___y++)
                                    if((tile_culling_bitmap[highest_z_flagged + 1][__x][___y] & x_flag) == 0)
                                        break for_highest_z_flagged;

                            }

                            int flag_count_for___x = ((highest_z_flagged + 1) - lowest_z_flagged) * ((highest_y_flagged - lowest_y_flagged) + 1);
                            if(flag_count_for___x >= 8)
                            {
                                char c1 = '\360';
                                int h_a = heightMap[highest_z_flagged][__x][lowest_y_flagged] - c1;
                                int h_b = heightMap[lowest_z_flagged][__x][lowest_y_flagged];
                                SceneGraph.createCullingCluster(_z, __x * 128, lowest_y_flagged * 128, h_b, __x * 128, highest_y_flagged * 128 + 128, h_a, 1);
                                for(int ___z = lowest_z_flagged; ___z <= highest_z_flagged; ___z++)
                                {
                                    for(int ___y = lowest_y_flagged; ___y <= highest_y_flagged; ___y++)
                                        tile_culling_bitmap[___z][__x][___y] &= ~x_flag;

                                }

                            }
                        }
                        if((tile_culling_bitmap[__z][__x][__y] & y_flag) != 0)
                        {
                            int lowest_x_flagged = __x;
                            int highest_x_flagged = __x;
                            int lowest_z_flagged = __z;
                            int highest_z_flagged = __z;
                            for(; lowest_x_flagged > 0 && (tile_culling_bitmap[__z][lowest_x_flagged - 1][__y] & y_flag) != 0; lowest_x_flagged--);
                            for(; highest_x_flagged < xMapSize && (tile_culling_bitmap[__z][highest_x_flagged + 1][__y] & y_flag) != 0; highest_x_flagged++);
for_lowest_z_flagged:
                            for(; lowest_z_flagged > 0; lowest_z_flagged--)
                            {
                                for(int ___x = lowest_x_flagged; ___x <= highest_x_flagged; ___x++)
                                    if((tile_culling_bitmap[lowest_z_flagged - 1][___x][__y] & y_flag) == 0)
                                        break for_lowest_z_flagged;

                            }

for_highest_z_flagged:
                            for(; highest_z_flagged < _z; highest_z_flagged++)
                            {
                                for(int ___x = lowest_x_flagged; ___x <= highest_x_flagged; ___x++)
                                    if((tile_culling_bitmap[highest_z_flagged + 1][___x][__y] & y_flag) == 0)
                                        break for_highest_z_flagged;

                            }

                            int flag_count = ((highest_z_flagged + 1) - lowest_z_flagged) * ((highest_x_flagged - lowest_x_flagged) + 1);
                            if(flag_count >= 8)
                            {
                                char c2 = '\360';
                                int h_a = heightMap[highest_z_flagged][lowest_x_flagged][__y] - c2;
                                int h_b = heightMap[lowest_z_flagged][lowest_x_flagged][__y];
                                SceneGraph.createCullingCluster(_z, lowest_x_flagged * 128, __y * 128, h_b, highest_x_flagged * 128 + 128, __y * 128, h_a, 2);
                                for(int ___z = lowest_z_flagged; ___z <= highest_z_flagged; ___z++)
                                {
                                    for(int ___x = lowest_x_flagged; ___x <= highest_x_flagged; ___x++)
                                        tile_culling_bitmap[___z][___x][__y] &= ~y_flag;

                                }

                            }
                        }
                        if((tile_culling_bitmap[__z][__x][__y] & z_flag) != 0)
                        {
                            int i5 = __x;
                            int j6 = __x;
                            int k7 = __y;
                            int i9 = __y;
                            for(; k7 > 0 && (tile_culling_bitmap[__z][__x][k7 - 1] & z_flag) != 0; k7--);
                            for(; i9 < yMapSize && (tile_culling_bitmap[__z][__x][i9 + 1] & z_flag) != 0; i9++);
label4:
                            for(; i5 > 0; i5--)
                            {
                                for(int l11 = k7; l11 <= i9; l11++)
                                    if((tile_culling_bitmap[__z][i5 - 1][l11] & z_flag) == 0)
                                        break label4;

                            }

label5:
                            for(; j6 < xMapSize; j6++)
                            {
                                for(int i12 = k7; i12 <= i9; i12++)
                                    if((tile_culling_bitmap[__z][j6 + 1][i12] & z_flag) == 0)
                                        break label5;

                            }

                            if(((j6 - i5) + 1) * ((i9 - k7) + 1) >= 4)
                            {
                                int j12 = heightMap[__z][i5][k7];
                                SceneGraph.createCullingCluster(_z, i5 * 128, k7 * 128, j12, j6 * 128 + 128, i9 * 128 + 128, j12, 4);
                                for(int k13 = i5; k13 <= j6; k13++)
                                {
                                    for(int i15 = k7; i15 <= i9; i15++)
                                        tile_culling_bitmap[__z][k13][i15] &= ~z_flag;

                                }

                            }
                        }
                    }

                }

            }

        }

    }

    public int rgb2hls(int i) {
        double r = (double) (i >> 16 & 0xff) / 256D;
        double g = (double) (i >> 8 & 0xff) / 256D;
        double b = (double) (i & 0xff) / 256D;
        double cmin = r;
        if (g < cmin)
            cmin = g;
        if (b < cmin)
            cmin = b;
        double cmax = r;
        if (g > cmax)
            cmax = g;
        if (b > cmax)
            cmax = b;
        double hue = 0.0D;
        double saturation = 0.0D;
        double lightness = (cmin + cmax) / 2D;
        if (cmin != cmax) {
            if (lightness < 0.5D)
                saturation = (cmax - cmin) / (cmax + cmin);
            if (lightness >= 0.5D)
                saturation = (cmax - cmin) / (2D - cmax - cmin);
            if (r == cmax)
                hue = (g - b) / (cmax - cmin);
            else if (g == cmax)
                hue = 2D + (b - r) / (cmax - cmin);
            else if (b == cmax)
                hue = 4D + (r - g) / (cmax - cmin);
        }
        hue /= 6D;
        int _hue = (int) (hue * 256D);
        int _saturation = (int) (saturation * 256D);
        int _lightness = (int) (lightness * 256D);
        if (_saturation < 0)
            _saturation = 0;
        else if (_saturation > 255)
            _saturation = 255;
        if (_lightness < 0)
            _lightness = 0;
        else if (_lightness > 255)
            _lightness = 255;
        int huerand = _hue;
        if (huerand < 0)
            huerand = 0;
        else if (huerand > 255)
            huerand = 255;
        int satrand = _saturation;
        if (satrand < 0)
            satrand = 0;
        else if (satrand > 255)
            satrand = 255;
        int lightrand = _lightness;
        if (lightrand < 0)
            lightrand = 0;
        else if (lightrand > 255)
            lightrand = 255;
        return pack_hsl(huerand, satrand, lightrand);
    }

    private static int generateMapHeight(int i, int j)
    {
        int k = (method176(i + 45365, j + 0x16713, 4) - 128) + (method176(i + 10294, j + 37821, 2) - 128 >> 1) + (method176(i, j, 1) - 128 >> 2);
        k = (int)((double)k * 0.29999999999999999D) + 35;
        if(k < 10)
            k = 10;
        else
        if(k > 60)
            k = 60;
        return k;
    }

    public static void prefetchObjects(Packet stream, OnDemandFetcher class42_sub1)
    {
label0:
        {
            int i = -1;
            do
            {
                int j = stream.gsmarts();
                if(j == 0)
                    break label0;
                i += j;
                ObjectDef class46 = ObjectDef.forID(i);
                class46.method574(class42_sub1);
                do
                {
                    int k = stream.gsmarts();
                    if(k == 0)
                        break;
                    stream.g1();
                } while(true);
            } while(true);
        }
    }

    public final void initMapTables(int i, int j, int l, int i1)
    {
        for(int j1 = i; j1 <= i + j; j1++)
        {
            for(int k1 = i1; k1 <= i1 + l; k1++)
                if(k1 >= 0 && k1 < xMapSize && j1 >= 0 && j1 < yMapSize)
                {
                    object_shadow_data[0][k1][j1] = 127;
                    if(k1 == i1 && k1 > 0)
                        heightMap[0][k1][j1] = heightMap[0][k1 - 1][j1];
                    if(k1 == i1 + l && k1 < xMapSize - 1)
                        heightMap[0][k1][j1] = heightMap[0][k1 + 1][j1];
                    if(j1 == i && j1 > 0)
                        heightMap[0][k1][j1] = heightMap[0][k1][j1 - 1];
                    if(j1 == i + j && j1 < yMapSize - 1)
                        heightMap[0][k1][j1] = heightMap[0][k1][j1 + 1];
                }

        }
    }

    private void addObjectToRenderer(int i, SceneGraph sceneGraph, TileSetting tileSetting, int j, int k, int l, int i1,
                                 int j1)
    {
        if(lowMem && (tileSettings[0][l][i] & 2) == 0)
        {
            if((tileSettings[k][l][i] & 0x10) != 0)
                return;
            if(get_logic_height(k, l, i) != anInt131)
                return;
        }
        if(k < setZ)
            setZ = k;
        int zA = heightMap[k][l][i];
        int zB = heightMap[k][l + 1][i];
        int zD = heightMap[k][l + 1][i + 1];
        int zC = heightMap[k][l][i + 1];
        int zMix = zA + zB + zD + zC >> 2;
        ObjectDef class46 = ObjectDef.forID(i1);
        int idTag = l + (i << 7) + (i1 << 14) + 0x40000000;
        if(!class46.hasActions)
            idTag += 0x80000000;
        byte objConf = (byte)((j1 << 6) + j);
        if(j == 22)
        {
            if(lowMem && !class46.hasActions && !class46.aBoolean736)
                return;
            Object obj;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj = class46.method578(22, j1, zA, zB, zD, zC, -1);
            else
                obj = new ObjectOnTile(i1, j1, 22, zB, zD, zA, zC, class46.animationID, true);
            sceneGraph.addGroundDecoration(k, zMix, i, ((Entity) (obj)), objConf, idTag, l);
            if(class46.isUnwalkable && class46.hasActions && tileSetting != null)
                tileSetting.orClipTableSET(i, l);
            return;
        }
        if(j == 10 || j == 11)
        {
            Object obj1;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj1 = class46.method578(10, j1, zA, zB, zD, zC, -1);
            else
                obj1 = new ObjectOnTile(i1, j1, 10, zB, zD, zA, zC, class46.animationID, true);
            if(obj1 != null)
            {
                int i5 = 0;
                if(j == 11)
                    i5 += 256;
                int j4;
                int l4;
                if(j1 == 1 || j1 == 3)
                {
                    j4 = class46.sizeY;
                    l4 = class46.sizeX;
                } else
                {
                    j4 = class46.sizeX;
                    l4 = class46.sizeY;
                }
                if(sceneGraph.addEntityB(idTag, objConf, zMix, l4, ((Entity) (obj1)), j4, k, i5, i, l) && class46.aBoolean779)
                {
                    Model model;
                    if(obj1 instanceof Model)
                        model = (Model)obj1;
                    else
                        model = class46.method578(10, j1, zA, zB, zD, zC, -1);
                    if(model != null)
                    {
                        for(int j5 = 0; j5 <= j4; j5++)
                        {
                            for(int k5 = 0; k5 <= l4; k5++)
                            {
                                int l5 = model.diagonal2DAboveorigin / 4;
                                if(l5 > 30)
                                    l5 = 30;
                                if(l5 > object_shadow_data[k][l + j5][i + k5])
                                    object_shadow_data[k][l + j5][i + k5] = (byte)l5;
                            }

                        }

                    }
                }
            }
            if(class46.isUnwalkable && tileSetting != null)
                tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, l, i, j1);
            return;
        }
        if(j >= 12)
        {
            Object obj2;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj2 = class46.method578(j, j1, zA, zB, zD, zC, -1);
            else
                obj2 = new ObjectOnTile(i1, j1, j, zB, zD, zA, zC, class46.animationID, true);
            sceneGraph.addEntityB(idTag, objConf, zMix, 1, ((Entity) (obj2)), 1, k, 0, i, l);
            if(j >= 12 && j <= 17 && j != 13 && k > 0)
                tile_culling_bitmap[k][l][i] |= 0x924;
            if(class46.isUnwalkable && tileSetting != null)
                tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, l, i, j1);
            return;
        }
        if(j == 0)
        {
            Object obj3;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj3 = class46.method578(0, j1, zA, zB, zD, zC, -1);
            else
                obj3 = new ObjectOnTile(i1, j1, 0, zB, zD, zA, zC, class46.animationID, true);
            sceneGraph.addWallObject(bitValues[j1], ((Entity) (obj3)), idTag, i, objConf, l, null, zMix, 0, k,j1);
            if(j1 == 0)
            {
                if(class46.aBoolean779)
                {
                    object_shadow_data[k][l][i] = 50;
                    object_shadow_data[k][l][i + 1] = 50;
                }
                if(class46.aBoolean764)
                    tile_culling_bitmap[k][l][i] |= 0x249;
            } else
            if(j1 == 1)
            {
                if(class46.aBoolean779)
                {
                    object_shadow_data[k][l][i + 1] = 50;
                    object_shadow_data[k][l + 1][i + 1] = 50;
                }
                if(class46.aBoolean764)
                    tile_culling_bitmap[k][l][i + 1] |= 0x492;
            } else
            if(j1 == 2)
            {
                if(class46.aBoolean779)
                {
                    object_shadow_data[k][l + 1][i] = 50;
                    object_shadow_data[k][l + 1][i + 1] = 50;
                }
                if(class46.aBoolean764)
                    tile_culling_bitmap[k][l + 1][i] |= 0x249;
            } else
            if(j1 == 3)
            {
                if(class46.aBoolean779)
                {
                    object_shadow_data[k][l][i] = 50;
                    object_shadow_data[k][l + 1][i] = 50;
                }
                if(class46.aBoolean764)
                    tile_culling_bitmap[k][l][i] |= 0x492;
            }
            if(class46.isUnwalkable && tileSetting != null)
                tileSetting.method211(i, j1, l, j, class46.aBoolean757);
            if(class46.anInt775 != 16)
                sceneGraph.method290(i, class46.anInt775, l, k);
            return;
        }
        if(j == 1)
        {
            Object obj4;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj4 = class46.method578(1, j1, zA, zB, zD, zC, -1);
            else
                obj4 = new ObjectOnTile(i1, j1, 1, zB, zD, zA, zC, class46.animationID, true);
            sceneGraph.addWallObject(highNybbleBitValues[j1], ((Entity) (obj4)), idTag, i, objConf, l, null, zMix, 0, k,j1);
            if(class46.aBoolean779)
                if(j1 == 0)
                    object_shadow_data[k][l][i + 1] = 50;
                else
                if(j1 == 1)
                    object_shadow_data[k][l + 1][i + 1] = 50;
                else
                if(j1 == 2)
                    object_shadow_data[k][l + 1][i] = 50;
                else
                if(j1 == 3)
                    object_shadow_data[k][l][i] = 50;
            if(class46.isUnwalkable && tileSetting != null)
                tileSetting.method211(i, j1, l, j, class46.aBoolean757);
            return;
        }
        if(j == 2)
        {
            int i3 = j1 + 1 & 3;
            Object obj11;
            Object obj12;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
            {
                obj11 = class46.method578(2, 4 + j1, zA, zB, zD, zC, -1);
                obj12 = class46.method578(2, i3, zA, zB, zD, zC, -1);
            } else
            {
                obj11 = new ObjectOnTile(i1, 4 + j1, 2, zB, zD, zA, zC, class46.animationID, true);
                obj12 = new ObjectOnTile(i1, i3, 2, zB, zD, zA, zC, class46.animationID, true);
            }
            sceneGraph.addWallObject(bitValues[j1], ((Entity) (obj11)), idTag, i, objConf, l, ((Entity) (obj12)), zMix, bitValues[i3], k,j1);
            if(class46.aBoolean764)
                if(j1 == 0)
                {
                    tile_culling_bitmap[k][l][i] |= 0x249;
                    tile_culling_bitmap[k][l][i + 1] |= 0x492;
                } else
                if(j1 == 1)
                {
                    tile_culling_bitmap[k][l][i + 1] |= 0x492;
                    tile_culling_bitmap[k][l + 1][i] |= 0x249;
                } else
                if(j1 == 2)
                {
                    tile_culling_bitmap[k][l + 1][i] |= 0x249;
                    tile_culling_bitmap[k][l][i] |= 0x492;
                } else
                if(j1 == 3)
                {
                    tile_culling_bitmap[k][l][i] |= 0x492;
                    tile_culling_bitmap[k][l][i] |= 0x249;
                }
            if(class46.isUnwalkable && tileSetting != null)
                tileSetting.method211(i, j1, l, j, class46.aBoolean757);
            if(class46.anInt775 != 16)
                sceneGraph.method290(i, class46.anInt775, l, k);
            return;
        }
        if(j == 3)
        {
            Object obj5;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj5 = class46.method578(3, j1, zA, zB, zD, zC, -1);
            else
                obj5 = new ObjectOnTile(i1, j1, 3, zB, zD, zA, zC, class46.animationID, true);
            sceneGraph.addWallObject(highNybbleBitValues[j1], ((Entity) (obj5)), idTag, i, objConf, l, null, zMix, 0, k,j1);
            if(class46.aBoolean779)
                if(j1 == 0)
                    object_shadow_data[k][l][i + 1] = 50;
                else
                if(j1 == 1)
                    object_shadow_data[k][l + 1][i + 1] = 50;
                else
                if(j1 == 2)
                    object_shadow_data[k][l + 1][i] = 50;
                else
                if(j1 == 3)
                    object_shadow_data[k][l][i] = 50;
            if(class46.isUnwalkable && tileSetting != null)
                tileSetting.method211(i, j1, l, j, class46.aBoolean757);
            return;
        }
        if(j == 9)
        {
            Object obj6;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj6 = class46.method578(j, j1, zA, zB, zD, zC, -1);
            else
                obj6 = new ObjectOnTile(i1, j1, j, zB, zD, zA, zC, class46.animationID, true);
            sceneGraph.addEntityB(idTag, objConf, zMix, 1, ((Entity) (obj6)), 1, k, 0, i, l);
            if(class46.isUnwalkable && tileSetting != null)
                tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, l, i, j1);
            return;
        }
        if(class46.isSolid)
            if(j1 == 1)
            {
                int j3 = zC;
                zC = zD;
                zD = zB;
                zB = zA;
                zA = j3;
            } else
            if(j1 == 2)
            {
                int k3 = zC;
                zC = zB;
                zB = k3;
                k3 = zD;
                zD = zA;
                zA = k3;
            } else
            if(j1 == 3)
            {
                int l3 = zC;
                zC = zA;
                zA = zB;
                zB = zD;
                zD = l3;
            }
        if(j == 4)
        {
            Object obj7;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj7 = class46.method578(4, 0, zA, zB, zD, zC, -1);
            else
                obj7 = new ObjectOnTile(i1, 0, 4, zB, zD, zA, zC, class46.animationID, true);
            sceneGraph.addWallDecoration(idTag, i, j1 * 512, k, 0, zMix, ((Entity) (obj7)), l, objConf, 0, bitValues[j1]);
            return;
        }
        if(j == 5)
        {
            int i4 = 16;
            int k4 = sceneGraph.getWallObjectUID(k, l, i);
            if(k4 > 0)
                i4 = ObjectDef.forID(k4 >> 14 & 0x7fff).anInt775;
            Object obj13;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj13 = class46.method578(4, 0, zA, zB, zD, zC, -1);
            else
                obj13 = new ObjectOnTile(i1, 0, 4, zB, zD, zA, zC, class46.animationID, true);
            sceneGraph.addWallDecoration(idTag, i, j1 * 512, k, faceXOffset[j1] * i4, zMix, ((Entity) (obj13)), l, objConf, faceYOffset[j1] * i4, bitValues[j1]);
            return;
        }
        if(j == 6)
        {
            Object obj8;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj8 = class46.method578(4, 0, zA, zB, zD, zC, -1);
            else
                obj8 = new ObjectOnTile(i1, 0, 4, zB, zD, zA, zC, class46.animationID, true);
            sceneGraph.addWallDecoration(idTag, i, j1, k, 0, zMix, ((Entity) (obj8)), l, objConf, 0, 256);
            return;
        }
        if(j == 7)
        {
            Object obj9;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj9 = class46.method578(4, 0, zA, zB, zD, zC, -1);
            else
                obj9 = new ObjectOnTile(i1, 0, 4, zB, zD, zA, zC, class46.animationID, true);
            sceneGraph.addWallDecoration(idTag, i, j1, k, 0, zMix, ((Entity) (obj9)), l, objConf, 0, 512);
            return;
        }
        if(j == 8)
        {
            Object obj10;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj10 = class46.method578(4, 0, zA, zB, zD, zC, -1);
            else
                obj10 = new ObjectOnTile(i1, 0, 4, zB, zD, zA, zC, class46.animationID, true);
            sceneGraph.addWallDecoration(idTag, i, j1, k, 0, zMix, ((Entity) (obj10)), l, objConf, 0, 768);
        }
    }

    private static int method176(int i, int j, int k)
    {
        int l = i / k;
        int i1 = i & k - 1;
        int j1 = j / k;
        int k1 = j & k - 1;
        int l1 = method186(l, j1);
        int i2 = method186(l + 1, j1);
        int j2 = method186(l, j1 + 1);
        int k2 = method186(l + 1, j1 + 1);
        int l2 = method184(l1, i2, i1, k);
        int i3 = method184(j2, k2, i1, k);
        return method184(l2, i3, k1, k);
    }

    private int pack_hsl(int h, int s, int l)
    {
        if(l > 179)
            s /= 2;
        if(l > 192)
            s /= 2;
        if(l > 217)
            s /= 2;
        if(l > 243)
            s /= 2;
        return (h / 4 << 10) + (s / 32 << 7) + l / 2;
    }

    public static boolean method178(int i, int j)
    {
        ObjectDef class46 = ObjectDef.forID(i);
        if(j == 11)
            j = 10;
        if(j >= 5 && j <= 8)
            j = 4;
        return class46.method577(j);
    }

    public final void loadMapChunk(int i, int j, TileSetting aclass11[], int l, int i1, byte abyte0[], int j1, int k1, int l1)
    {
        for(int i2 = 0; i2 < 8; i2++)
        {
            for(int j2 = 0; j2 < 8; j2++)
                if(l + i2 > 0 && l + i2 < xMapSize - 1 && l1 + j2 > 0 && l1 + j2 < yMapSize - 1)
                    aclass11[k1].clipData[l + i2][l1 + j2] &= 0xfeffffff;

        }
        Packet stream = new Packet(abyte0);
        for(int l2 = 0; l2 < 4; l2++)
        {
            for(int i3 = 0; i3 < 64; i3++)
            {
                for(int j3 = 0; j3 < 64; j3++)
                    if(l2 == i && i3 >= i1 && i3 < i1 + 8 && j3 >= j1 && j3 < j1 + 8)
                        readTile(k1, l + MapUtility.getRotatedMapChunkX(j, j3 & 7, i3 & 7), l1 + MapUtility.getRotatedMapChunkY(j3 & 7, j, i3 & 7), 0, 0, j, stream);
                    else
                        readTile(0, -1, -1, 0, 0, 0, stream);

            }

        }

    }

    public final void loadTerrain(byte abyte0[], int zOffset, int xOffset, int k, int l, TileSetting tileSetting[])
    {
        for(int _y = 0; _y < 4; _y++)
        {
            for(int _x = 0; _x < 64; _x++)
            {
                for(int _z = 0; _z < 64; _z++)
                    if(xOffset + _x > 0 && xOffset + _x < xMapSize - 1 && zOffset + _z > 0 && zOffset + _z < yMapSize - 1)
                        tileSetting[_y].clipData[xOffset + _x][zOffset + _z] &= 0xfeffffff;

            }

        }

        Packet stream = new Packet(abyte0);
        for(int l1 = 0; l1 < 4; l1++)
        {
            for(int i2 = 0; i2 < 64; i2++)
            {
                for(int j2 = 0; j2 < 64; j2++)
                    readTile(l1, i2 + xOffset, j2 + zOffset, k, l, 0, stream);

            }

        }
    }

    private void readTile(int y, int x, int z, int xOffset, int zOffset, int shapeBOffset, Packet stream)
    {
        if(x >= 0 && x < xMapSize && z >= 0 && z < yMapSize)
        {
            tileSettings[y][x][z] = 0;
            do
            {
                int value = stream.g1();
                if(value == 0){
                    automaticHeight[y][x][z] = true;
                    if(y == 0)
                    {
                        heightMap[0][x][z] = -generateMapHeight(0xe3b7b + x + xOffset, 0x87cce + z + zOffset) * 8;
                        return;
                    } else
                    {
                        heightMap[y][x][z] = heightMap[y - 1][x][z] - 240;
                        return;
                    }
                }
                if(value == 1)
                {
                    automaticHeight[y][x][z] = false;
                    int height = stream.g1();
                    if(height == 1)
                        height = 0;
                    if(y == 0)
                    {
                        heightMap[0][x][z] = -height * 8;
                        return;
                    } else
                    {
                        heightMap[y][x][z] = heightMap[y - 1][x][z] - height * 8;
                        return;
                    }
                }
                if(value <= 49)
                {
                    overLay[y][x][z] = stream.g1b();
                    tileShape[y][x][z] = (byte)((value - 2) / 4);
                    tileRotation[y][x][z] = (byte) (((value - 2) + shapeBOffset) & 3);
                } else
                if(value <= 81)
                    tileSettings[y][x][z] = (byte)(value - 49);
                else
                    underLay[y][x][z] = (byte)(value - 81);     //255-81 = Only 174 possible underlays
            } while(true);
        }
        do
        {
            if (isMapEditor)
                System.err.println("Warning: tiles are being discarded, are you sure mapSize is a multiple of 64?");
            int i2 = stream.g1();
            if(i2 == 0)
                break;
            if(i2 == 1)
            {
                stream.g1();
                return;
            }
            if(i2 <= 49)
                stream.g1();
        } while(true);
    }

    public void writeMapRegion(int xOffset, int zOffset, Packet packet) {
        if (xOffset < 0 ||  zOffset < 0 || (xOffset + 64) > xMapSize || (zOffset + 64) > yMapSize)
            throw new RuntimeException("Trying to write tiles not in memory!");
        for(int y = 0; y < 4; y++)
        {
            for(int x = 0; x < 64; x++)
            {
                for(int z = 0; z < 64; z++)
                    writeTile(y, x + xOffset, z + zOffset, packet);

            }

        }
    }

    private void writeTile(int y,int x,int z, Packet packet) {
        if(overLay[y][x][z] != 0){
            packet.p1((tileShape[y][x][z] * 4) + (tileRotation[y][x][z] & 3) + 2);
            packet.p1(overLay[y][x][z]);
        }
        if(tileSettings[y][x][z] != 0)
            packet.p1(tileSettings[y][x][z] + 49);
        if(underLay[y][x][z] != 0)
            packet.p1(underLay[y][x][z] + 81);
        if(!automaticHeight[y][x][z]){
            packet.p1(1);
            if (y == 0)
                packet.p1((-heightMap[y][x][z]) / 8);
            else
                packet.p1((heightMap[y-1][x][z]-heightMap[y][x][z]) / 8);
        } else
            packet.p1(0);
    }

    private int get_logic_height(int z, int x, int y)
    {
        if((tileSettings[z][x][y] & 8) != 0)
            return 0;
        if(z > 0 && (tileSettings[1][x][y] & 2) != 0)
            return z - 1;
        else
            return z;
    }

    public final void method183(TileSetting aclass11[], SceneGraph sceneGraph, int i, int j, int k, int l,
                                byte abyte0[], int i1, int j1, int k1)
    {
label0:
        {
            Packet stream = new Packet(abyte0);
            int l1 = -1;
            do
            {
                int i2 = stream.gsmarts();
                if(i2 == 0)
                    break label0;
                l1 += i2;
                int j2 = 0;
                do
                {
                    int k2 = stream.gsmarts();
                    if(k2 == 0)
                        break;
                    j2 += k2 - 1;
                    int l2 = j2 & 0x3f;
                    int i3 = j2 >> 6 & 0x3f;
                    int j3 = j2 >> 12;
                    int k3 = stream.g1();
                    int l3 = k3 >> 2;
                    int i4 = k3 & 3;
                    if(j3 == i && i3 >= i1 && i3 < i1 + 8 && l2 >= k && l2 < k + 8)
                    {
                        ObjectDef class46 = ObjectDef.forID(l1);
                        int j4 = j + MapUtility.getRotatedLandscapeChunkX(j1, class46.sizeY, i3 & 7, l2 & 7, class46.sizeX);
                        int k4 = k1 + MapUtility.getRotatedLandscapeChunkY(l2 & 7, class46.sizeY, j1, class46.sizeX, i3 & 7);
                        if(j4 > 0 && k4 > 0 && j4 < xMapSize - 1 && k4 < yMapSize - 1)
                        {
                            int l4 = j3;
                            if((tileSettings[1][j4][k4] & 2) == 2)
                                l4--;
                            TileSetting tileSetting = null;
                            if(l4 >= 0)
                                tileSetting = aclass11[l4];
                            addObjectToRenderer(k4, sceneGraph, tileSetting, l3, l, j4, l1, i4 + j1 & 3);
                        }
                    }
                } while(true);
            } while(true);
        }
    }

    private static int method184(int i, int j, int k, int l)
    {
        int i1 = 0x10000 - Rasterizer.COSINE[(k * 1024) / l] >> 1;
        return (i * (0x10000 - i1) >> 16) + (j * i1 >> 16);
    }

    private int mix_lightness_gt(int hsl, int l)
    {
        if(hsl == -2)
            return 0xbc614e;
        if(hsl == -1)
        {
            if(l < 0)
                l = 0;
            else if(l > 127)
                l = 127;
            l = 127 - l;
            return l;
        }
        l = (l * (hsl & 0x7f)) / 128;
        if(l < 2)
            l = 2;
        else
        if(l > 126)
            l = 126;
        return (hsl & 0xff80) + l;
    }

    private static int method186(int i, int j)
    {
        int k = method170(i - 1, j - 1) + method170(i + 1, j - 1) + method170(i - 1, j + 1) + method170(i + 1, j + 1);
        int l = method170(i - 1, j) + method170(i + 1, j) + method170(i, j - 1) + method170(i, j + 1);
        int i1 = method170(i, j);
        return k / 16 + l / 8 + i1 / 4;
    }

    private static int mix_lightness(int hsl, int l)
    {
        if(hsl == -1)
            return 0xbc614e;
        l = (l * (hsl & 0x7f)) / 128;
        if(l < 2)
            l = 2;
        else
        if(l > 126)
            l = 126;
        return (hsl & 0xff80) + l;
    }

    public static void method188(SceneGraph sceneGraph, int i, int j, int k, int l, TileSetting tileSetting, int ai[][][], int i1,
                                 int j1, int k1)
    {
        int l1 = ai[l][i1][j];
        int i2 = ai[l][i1 + 1][j];
        int j2 = ai[l][i1 + 1][j + 1];
        int k2 = ai[l][i1][j + 1];
        int l2 = l1 + i2 + j2 + k2 >> 2;
        ObjectDef class46 = ObjectDef.forID(j1);
        int i3 = i1 + (j << 7) + (j1 << 14) + 0x40000000;
        if(!class46.hasActions)
            i3 += 0x80000000;
        byte byte1 = (byte)((i << 6) + k);
        if(k == 22)
        {
            Object obj;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj = class46.method578(22, i, l1, i2, j2, k2, -1);
            else
                obj = new ObjectOnTile(j1, i, 22, i2, j2, l1, k2, class46.animationID, true);
            sceneGraph.addGroundDecoration(k1, l2, j, ((Entity) (obj)), byte1, i3, i1);
            if(class46.isUnwalkable && class46.hasActions)
                tileSetting.orClipTableSET(j, i1);
            return;
        }
        if(k == 10 || k == 11)
        {
            Object obj1;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj1 = class46.method578(10, i, l1, i2, j2, k2, -1);
            else
                obj1 = new ObjectOnTile(j1, i, 10, i2, j2, l1, k2, class46.animationID, true);
            if(obj1 != null)
            {
                int j5 = 0;
                if(k == 11)
                    j5 += 256;
                int k4;
                int i5;
                if(i == 1 || i == 3)
                {
                    k4 = class46.sizeY;
                    i5 = class46.sizeX;
                } else
                {
                    k4 = class46.sizeX;
                    i5 = class46.sizeY;
                }
                sceneGraph.addEntityB(i3, byte1, l2, i5, ((Entity) (obj1)), k4, k1, j5, j, i1);
            }
            if(class46.isUnwalkable)
                tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, i1, j, i);
            return;
        }
        if(k >= 12)
        {
            Object obj2;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj2 = class46.method578(k, i, l1, i2, j2, k2, -1);
            else
                obj2 = new ObjectOnTile(j1, i, k, i2, j2, l1, k2, class46.animationID, true);
            sceneGraph.addEntityB(i3, byte1, l2, 1, ((Entity) (obj2)), 1, k1, 0, j, i1);
            if(class46.isUnwalkable)
                tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, i1, j, i);
            return;
        }
        if(k == 0)
        {
            Object obj3;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj3 = class46.method578(0, i, l1, i2, j2, k2, -1);
            else
                obj3 = new ObjectOnTile(j1, i, 0, i2, j2, l1, k2, class46.animationID, true);
            sceneGraph.addWallObject(bitValues[i], ((Entity) (obj3)), i3, j, byte1, i1, null, l2, 0, k1,i);
            if(class46.isUnwalkable)
                tileSetting.method211(j, i, i1, k, class46.aBoolean757);
            return;
        }
        if(k == 1)
        {
            Object obj4;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj4 = class46.method578(1, i, l1, i2, j2, k2, -1);
            else
                obj4 = new ObjectOnTile(j1, i, 1, i2, j2, l1, k2, class46.animationID, true);
            sceneGraph.addWallObject(highNybbleBitValues[i], ((Entity) (obj4)), i3, j, byte1, i1, null, l2, 0, k1,i);
            if(class46.isUnwalkable)
                tileSetting.method211(j, i, i1, k, class46.aBoolean757);
            return;
        }
        if(k == 2)
        {
            int j3 = i + 1 & 3;
            Object obj11;
            Object obj12;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
            {
                obj11 = class46.method578(2, 4 + i, l1, i2, j2, k2, -1);
                obj12 = class46.method578(2, j3, l1, i2, j2, k2, -1);
            } else
            {
                obj11 = new ObjectOnTile(j1, 4 + i, 2, i2, j2, l1, k2, class46.animationID, true);
                obj12 = new ObjectOnTile(j1, j3, 2, i2, j2, l1, k2, class46.animationID, true);
            }
            sceneGraph.addWallObject(bitValues[i], ((Entity) (obj11)), i3, j, byte1, i1, ((Entity) (obj12)), l2, bitValues[j3], k1,i);
            if(class46.isUnwalkable)
                tileSetting.method211(j, i, i1, k, class46.aBoolean757);
            return;
        }
        if(k == 3)
        {
            Object obj5;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj5 = class46.method578(3, i, l1, i2, j2, k2, -1);
            else
                obj5 = new ObjectOnTile(j1, i, 3, i2, j2, l1, k2, class46.animationID, true);
            sceneGraph.addWallObject(highNybbleBitValues[i], ((Entity) (obj5)), i3, j, byte1, i1, null, l2, 0, k1,i);
            if(class46.isUnwalkable)
                tileSetting.method211(j, i, i1, k, class46.aBoolean757);
            return;
        }
        if(k == 9)
        {
            Object obj6;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj6 = class46.method578(k, i, l1, i2, j2, k2, -1);
            else
                obj6 = new ObjectOnTile(j1, i, k, i2, j2, l1, k2, class46.animationID, true);
            sceneGraph.addEntityB(i3, byte1, l2, 1, ((Entity) (obj6)), 1, k1, 0, j, i1);
            if(class46.isUnwalkable)
                tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, i1, j, i);
            return;
        }
        if(class46.isSolid)
            if(i == 1)
            {
                int k3 = k2;
                k2 = j2;
                j2 = i2;
                i2 = l1;
                l1 = k3;
            } else
            if(i == 2)
            {
                int l3 = k2;
                k2 = i2;
                i2 = l3;
                l3 = j2;
                j2 = l1;
                l1 = l3;
            } else
            if(i == 3)
            {
                int i4 = k2;
                k2 = l1;
                l1 = i2;
                i2 = j2;
                j2 = i4;
            }
        if(k == 4)
        {
            Object obj7;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj7 = class46.method578(4, 0, l1, i2, j2, k2, -1);
            else
                obj7 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.animationID, true);
            sceneGraph.addWallDecoration(i3, j, i * 512, k1, 0, l2, ((Entity) (obj7)), i1, byte1, 0, bitValues[i]);
            return;
        }
        if(k == 5)
        {
            int j4 = 16;
            int l4 = sceneGraph.getWallObjectUID(k1, i1, j);
            if(l4 > 0)
                j4 = ObjectDef.forID(l4 >> 14 & 0x7fff).anInt775;
            Object obj13;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj13 = class46.method578(4, 0, l1, i2, j2, k2, -1);
            else
                obj13 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.animationID, true);
            sceneGraph.addWallDecoration(i3, j, i * 512, k1, faceXOffset[i] * j4, l2, ((Entity) (obj13)), i1, byte1, faceYOffset[i] * j4, bitValues[i]);
            return;
        }
        if(k == 6)
        {
            Object obj8;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj8 = class46.method578(4, 0, l1, i2, j2, k2, -1);
            else
                obj8 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.animationID, true);
            sceneGraph.addWallDecoration(i3, j, i, k1, 0, l2, ((Entity) (obj8)), i1, byte1, 0, 256);
            return;
        }
        if(k == 7)
        {
            Object obj9;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj9 = class46.method578(4, 0, l1, i2, j2, k2, -1);
            else
                obj9 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.animationID, true);
            sceneGraph.addWallDecoration(i3, j, i, k1, 0, l2, ((Entity) (obj9)), i1, byte1, 0, 512);
            return;
        }
        if(k == 8)
        {
            Object obj10;
            if(class46.animationID == -1 && class46.configObjectIDs == null)
                obj10 = class46.method578(4, 0, l1, i2, j2, k2, -1);
            else
                obj10 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.animationID, true);
            sceneGraph.addWallDecoration(i3, j, i, k1, 0, l2, ((Entity) (obj10)), i1, byte1, 0, 768);
        }
    }

  public static boolean method189(int i, byte[] is, int i_250_
  ) //xxx bad method, decompiled with JODE
  {
    boolean bool = true;
    Packet stream = new Packet(is);
    int i_252_ = -1;
    for (;;)
      {
	int i_253_ = stream.gsmarts();
	if (i_253_ == 0)
	  break;
	i_252_ += i_253_;
	int i_254_ = 0;
	boolean bool_255_ = false;
	for (;;)
	  {
	    if (bool_255_)
	      {
		int i_256_ = stream.gsmarts();
		if (i_256_ == 0)
		  break;
		stream.g1();
	      }
	    else
	      {
		int i_257_ = stream.gsmarts();
		if (i_257_ == 0)
		  break;
		i_254_ += i_257_ - 1;
		int i_258_ = i_254_ & 0x3f;
		int i_259_ = i_254_ >> 6 & 0x3f;
		int i_260_ = stream.g1() >> 2;
		int i_261_ = i_259_ + i;
		int i_262_ = i_258_ + i_250_;
		if (i_261_ > 0 && i_262_ > 0 && i_261_ < 103 && i_262_ < 103)  //TODO:Make not static or modify mapSize to static
		  {
		    ObjectDef class46 = ObjectDef.forID (i_252_);
		    if (i_260_ != 22 || !lowMem || class46.hasActions
                    || class46.aBoolean736)
		      {
			bool &= class46.method579 ();
			bool_255_ = true;
		      }
		  }
	      }
	  }
      }
    return bool;
  }

    public final void loadObjects(int xOff, TileSetting aclass11[], int yOff, SceneGraph sceneGraph, byte abyte0[])
    {
label0:
        {
            Packet stream = new Packet(abyte0);
            int objID = -1;
            do
            {
                int readOID = stream.gsmarts();
                if(readOID == 0)
                    break label0;
                objID += readOID;
                int coordSetting = 0;
                do
                {
                    int coordSS = stream.gsmarts();
                    if(coordSS == 0)
                        break;
                    coordSetting += coordSS - 1;
                    int rY = coordSetting & 0x3f;
                    int rX = coordSetting >> 6 & 0x3f;
                    int Z = coordSetting >> 12;
                    int objByte = stream.g1();
                    int objType = objByte >> 2;
                    int face = objByte & 3;
                    int X = rX + xOff;
                    int Y = rY + yOff;
                    if(X > 0 && Y > 0 && X < xMapSize - 1&& Y < yMapSize - 1)
                    {
                        int l3 = Z;
                        if((tileSettings[1][X][Y] & 2) == 2)
                            l3--;
                        TileSetting tileSetting = null;
                        if(l3 >= 0)
                            tileSetting = aclass11[l3];
                        addObjectToRenderer(Y, sceneGraph, tileSetting, objType, Z, X, objID, face);
                    }
                } while(true);
            } while(true);
        }
    }

    public int getHeight(int y, int x, int z){
        if (z == 0)
            return (-heightMap[y][x][z]) / 8;
        else
            return (heightMap[y][x][z-1]-heightMap[y][x][z]) / 8;
    }

    public void setHeight(int y,int x, int z, int height){
        automaticHeight[y][x][z] = false;
        if(height == 1)
            height = 0;
        if(y == 0)
        {
            heightMap[0][x][z] = -height * 8;
            return;
        } else
        {
            heightMap[y][x][z] = heightMap[y - 1][x][z] - height * 8;
            return;
        }
    }

    public int[][][] getHeightMap() {
        return heightMap;
    }

    public byte[][][] getOverLay() {
        return overLay;
    }

    public byte[][][] getShapeA() {
        return tileShape;
    }

    public byte[][][] getShapeB() {
        return tileRotation;
    }

    public byte[][][] getUnderLay() {
        return underLay;
    }

    public int[][][] getUnderlayRgb() {
        return underlayRgb;
    }

    public byte[][][] getTileSettings() {
        return tileSettings;
    }

    private static int hue_offset = (int)(Math.random() * 17D) - 8;
    private final int[] hue;
    private final int[] saturation;
    private final int[] lightness;
    private final int[] huedivider;
    private final int[] colourCount;
    private final int[][][] heightMap;
    private final byte[][][] overLay;
    static int anInt131;
    private static int lightness_offset = (int)(Math.random() * 33D) - 16;
    private final byte[][][] object_shadow_data;
    private final int[][][] tile_culling_bitmap;
    public final byte[][][] tileShape;
    private static final int faceXOffset[] = {
        1, 0, -1, 0
    };
    //private static final int anInt138 = 323;//never used
    private final int[][] tileLightness;
    private static final int highNybbleBitValues[] = {
        16, 32, 64, 128
    };
    private final byte[][][] underLay;
    private static final int faceYOffset[] = {
        0, -1, 0, 1
    };
    static int setZ = 99;
    private final int xMapSize;
    private final int yMapSize;
    public final byte[][][] tileRotation;
    private final byte[][][] tileSettings;
    public static boolean lowMem = true;
    private static final int bitValues[] = {
        1, 2, 4, 8
    };

    public void setOverlay(int z, int x, int y, int overlay) {
        overLay[z][x][y] = (byte) overlay;
    }

    public void setUnderlay(int z, int x, int y, int underlay) {
        underLay[z][x][y] = (byte) underlay;
    }
}
