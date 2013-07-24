package rs2;

// Decompiler options: packimports(3)

import rs2.model.object.ObjectInstance;import rs2.model.entity.Entity;

public class MapRegion {

    private int[][][] tile_layer0_colour;
    public boolean[][][] tile_auto_height;
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

    public MapRegion(int width, int height, byte tile_flags[][][], int tile_height[][][])
    {
        setZ = 99;
        size_x = width;
        size_z = height;
        this.tile_height = tile_height;
        this.tile_flags = tile_flags;
        tile_layer0_type = new byte[4][size_x][size_z];
        tile_layer1_type = new byte[4][size_x][size_z];
        tile_layer1_shape = new byte[4][size_x][size_z];
        tile_layer1_orientation = new byte[4][size_x][size_z];
        tile_culling_bitmap = new int[4][size_x + 1][size_z + 1];
        object_shadow_data = new byte[4][size_x + 1][size_z + 1];
        tile_lightness = new int[size_x + 1][size_z + 1];
        tile_layer0_colour = new int[4][size_x][size_z];
        tile_auto_height = new boolean[4][size_x][size_z];//Used only by the editor utility
        hue_buffer = new int[size_z];
        saturation_buffer = new int[size_z];
        lightness_buffer = new int[size_z];
        huedivider = new int[size_z];
        buffer_size = new int[size_z];
    }


    public final void addTiles(TileSetting tileSettings[], SceneGraph sceneGraph, int render_mode)
    {
        for(int tile_y = 0; tile_y < 4; tile_y++)
        {
            for(int tile_x = 0; tile_x < size_x; tile_x++)
            {
                for(int tile_z = 0; tile_z < size_z; tile_z++)
                    if((tile_flags[tile_y][tile_x][tile_z] & 1) == 1)
                    {
                        int k1 = tile_y;
                        if((tile_flags[1][tile_x][tile_z] & 2) == 2)
                            k1--;
                        if(k1 >= 0)
                            tileSettings[k1].orClipTableSET(tile_z, tile_x);
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
            for(int tile_y = 1; tile_y < size_z - 1; tile_y++)
            {
                for(int tile_x = 1; tile_x < size_x - 1; tile_x++)
                {	//This renders the object shadows
                    int hDX = tile_height[z][tile_x + 1][tile_y] - tile_height[z][tile_x - 1][tile_y];
                    int hDY = tile_height[z][tile_x][tile_y + 1] - tile_height[z][tile_x][tile_y - 1];
                    int normal_m = (int)Math.sqrt(hDX * hDX + 0x10000 + hDY * hDY);
                    int normal_x = (hDX << 8) / normal_m;
                    int normal_y = 0x10000 / normal_m;
                    int normal_z = (hDY << 8) / normal_m;
                    int diffuse_lightness = light_off + (l_x * normal_x + l_y * normal_y + l_z * normal_z) / sqrtA;
                    int object_shadow = (something_with_objects[tile_x - 1][tile_y] >> 2) + (something_with_objects[tile_x + 1][tile_y] >> 3) + (something_with_objects[tile_x][tile_y - 1] >> 2) + (something_with_objects[tile_x][tile_y + 1] >> 3) + (something_with_objects[tile_x][tile_y] >> 1);
                    tile_lightness[tile_x][tile_y] = diffuse_lightness - object_shadow;
                }

            }
            if ((render_mode & NO_BLENDING_BIT) == 0)
                for(int tile_z = 0; tile_z < size_z; tile_z++)
                {
                    hue_buffer[tile_z] = 0;
                    saturation_buffer[tile_z] = 0;
                    lightness_buffer[tile_z] = 0;
                    huedivider[tile_z] = 0;
                    buffer_size[tile_z] = 0;
                }

            for(int tile_x = -5; tile_x < size_x + 5; tile_x++)
            {
                if ((render_mode & NO_BLENDING_BIT) == 0)
                    for(int tile_z = 0; tile_z < size_z; tile_z++)
                    {
                        int tile_r_x = tile_x + 5;
                        if(tile_r_x >= 0 && tile_r_x < size_x)
                        {
                            int tile_type = tile_layer0_type[z][tile_r_x][tile_z] & 0xff;
                            if(tile_type > 0)
                            {
                                Floor floor = Floor.cache[tile_type - 1];
                                hue_buffer[tile_z] += floor.hue2;
                                saturation_buffer[tile_z] += floor.saturation;
                                lightness_buffer[tile_z] += floor.lightness;
                                huedivider[tile_z] += floor.hue_weight;
                                buffer_size[tile_z]++;
                            }
                        }
                        int tile_l_x = tile_x - 5;
                        if(tile_l_x >= 0 && tile_l_x < size_x)
                        {
                            int tile_type = tile_layer0_type[z][tile_l_x][tile_z] & 0xff;
                            if(tile_type > 0)
                            {
                                Floor floor = Floor.cache[tile_type - 1];
                                hue_buffer[tile_z] -= floor.hue2;
                                saturation_buffer[tile_z] -= floor.saturation;
                                lightness_buffer[tile_z] -= floor.lightness;
                                huedivider[tile_z] -= floor.hue_weight;
                                buffer_size[tile_z]--;
                            }
                        }
                    }

                if(tile_x >= 1 && tile_x < size_x - 1)
                {
                    int tile_hue = 0;
                    int tile_sat = 0;
                    int tile_light = 0;
                    int tile_hue_shift = 0;
                    int buffer_size = 0;
                    for(int tile_z = -5; tile_z < size_z + 5; tile_z++)
                    {
                        if ((render_mode & NO_BLENDING_BIT) == 0){
                            int tile_b_z = tile_z + 5;
                            if(tile_b_z >= 0 && tile_b_z < size_z)
                            {
                                tile_hue += hue_buffer[tile_b_z];
                                tile_sat += saturation_buffer[tile_b_z];
                                tile_light += lightness_buffer[tile_b_z];
                                tile_hue_shift += huedivider[tile_b_z];
                                buffer_size += this.buffer_size[tile_b_z];
                            }
                            int tile_u_z = tile_z - 5;
                            if(tile_u_z >= 0 && tile_u_z < size_z)
                            {
                                tile_hue -= hue_buffer[tile_u_z];
                                tile_sat -= saturation_buffer[tile_u_z];
                                tile_light -= lightness_buffer[tile_u_z];
                                tile_hue_shift -= huedivider[tile_u_z];
                                buffer_size -= this.buffer_size[tile_u_z];
                            }
                        }
                        if(tile_z >= 1 && tile_z < size_z - 1
                                && (!low_detail || (tile_flags[0][tile_x][tile_z] & 2) != 0 || (tile_flags[z][tile_x][tile_z] & 0x10) == 0 && get_logic_height(z, tile_x, tile_z) == anInt131))
                        {
                            if(z < setZ)
                                setZ = z;
                            int tile_layer0_type = this.tile_layer0_type[z][tile_x][tile_z] & 0xff;
                            int tile_layer1_type = this.tile_layer1_type[z][tile_x][tile_z] & 0xff;
                            if(tile_layer0_type > 0 || tile_layer1_type > 0 || (render_mode & RENDER_HIDDEN_BIT) != 0)
                            {
                                int y_a = tile_height[z][tile_x][tile_z];
                                int y_b = tile_height[z][tile_x + 1][tile_z];
                                int y_d = tile_height[z][tile_x + 1][tile_z + 1];
                                int y_c = tile_height[z][tile_x][tile_z + 1];
                                int lightness_a = tile_lightness[tile_x][tile_z];
                                int lightness_b = tile_lightness[tile_x + 1][tile_z];
                                int lightness_d = tile_lightness[tile_x + 1][tile_z + 1];
                                int lightness_c = tile_lightness[tile_x][tile_z + 1];
                                int underlay_hsl_real = -1;
                                int underlay_hsl = -1;
                                if(tile_layer0_type > 0 || (render_mode & RENDER_HIDDEN_BIT) != 0)
                                {
                                    int h = -1;
                                    int s = 0;
                                    int l = 0;
                                    if (tile_layer0_type == 0 && (render_mode & RENDER_HIDDEN_BIT) != 0){
                                        h = 120;
                                        s = 128;
                                        l = 128;
                                    } else if ((render_mode & NO_BLENDING_BIT) == 0){     //Not hidden
                                        h = (tile_hue * 256) / tile_hue_shift;
                                        s = tile_sat / buffer_size;
                                        l = tile_light / buffer_size;
                                        underlay_hsl_real = pack_hsl(h, s, l);
                                        h = h + hue_offset & 0xff;
                                        l += lightness_offset;
                                        if(l < 0)
                                            l = 0;
                                        else
                                        if(l > 255)
                                            l = 255;
                                    } else if ((render_mode & 8) != 0) {      // Not blending
                                        boolean clipped = (tile_flags[z][tile_x][tile_z] & 1) == 1;
                                        boolean bridge = (tile_flags[z][tile_x][tile_z] & 2) == 2;
                                        boolean removeroofs = (tile_flags[z][tile_x][tile_z] & 3) == 3;
                                        underlay_hsl = rgb_to_hsl((clipped ? 0xFF0000 : 0) |
                                                (bridge ? 0x00FF00 : 0) |
                                                (removeroofs ? 0x0000FF : 0));
                                    } else if ((render_mode & NO_COLOUR_RES_BIT) == 0){  //Not falsecolour
                                        Floor underlayF = Floor.cache[tile_layer0_type - 1];
                                        underlay_hsl = underlayF.hslColour;
                                    } else {
                                        h = tile_layer0_type;
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
                                    if(tile_layer0_type == 0 && tile_layer1_shape[z][tile_x][tile_z] != 0)
                                        underlay_hidden = false;
                                    if(tile_layer1_type > 0 && !Floor.cache[tile_layer1_type - 1].occlude)
                                        underlay_hidden = false;
                                    if(((render_mode & RENDER_HIDDEN_BIT) != 0  || ((tile_flags[z][tile_x][tile_z] & 0x10) == 0 && (tile_layer0_type != 0 || tile_layer1_type != 0))) && underlay_hidden && y_a == y_b && y_a == y_d && y_a == y_c)
                                        tile_culling_bitmap[z][tile_x][tile_z] |= 04444;
                                }
                                int underlay_rgb = 0;
                                if(underlay_hsl_real != -1)
                                    underlay_rgb = Rasterizer.hsl2rgb[mix_lightness(underlay_hsl, 96)];
                                tile_layer0_colour[z][tile_x][tile_z] = underlay_rgb;
                                if(tile_layer1_type == 0 || (render_mode & NO_OVERLAY_BIT) != 0)
                                {
                                    sceneGraph.addTile(z, tile_x, tile_z, 0, 0, -1, y_a, y_b, y_d, y_c, mix_lightness(underlay_hsl_real, lightness_a), mix_lightness(underlay_hsl_real, lightness_b), mix_lightness(underlay_hsl_real, lightness_d), mix_lightness(underlay_hsl_real, lightness_c), 0, 0, 0, 0, underlay_rgb, 0, false);
                                } else {
                                    int shape = tile_layer1_shape[z][tile_x][tile_z] + 1;
                                    byte rotation = tile_layer1_orientation[z][tile_x][tile_z];
                                    Floor overlay = Floor.cache[tile_layer1_type - 1];
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
                                        overlay_hsl = overlay.hslColour;//pack_hsl(overlay.hue, overlay.saturation, overlay.lightness_buffer);
                                        overlay_rgb = Rasterizer.hsl2rgb[mix_lightness_signed(overlay.hslColour, 96)];
                                    }
                                    sceneGraph.addTile(z, tile_x, tile_z, shape, rotation, overlay_texture, y_a, y_b, y_d, y_c, mix_lightness(underlay_hsl_real, lightness_a), mix_lightness(underlay_hsl_real, lightness_b), mix_lightness(underlay_hsl_real, lightness_d), mix_lightness(underlay_hsl_real, lightness_c), mix_lightness_signed(overlay_hsl, lightness_a), mix_lightness_signed(overlay_hsl, lightness_b), mix_lightness_signed(overlay_hsl, lightness_d), mix_lightness_signed(overlay_hsl, lightness_c), underlay_rgb, overlay_rgb, false);
                                }
                            }
                        }
                    }

                }
            }

            for(int _y = 1; _y < size_z - 1; _y++)
            {
                for(int _x = 1; _x < size_x - 1; _x++)
                    sceneGraph.setTileLogicHeight(z, _x, _y, get_logic_height(z, _x, _y));

            }

        }

        sceneGraph.shadeModels(-50, -10, -50, 768, 64);
        for(int _x = 0; _x < size_x; _x++)
        {
            for(int _y = 0; _y < size_z; _y++)
                if((tile_flags[1][_x][_y] & 2) == 2)
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
                for(int __y = 0; __y <= size_z; __y++)
                {
                    for(int __x = 0; __x <= size_x; __x++)
                    {
                        if((tile_culling_bitmap[__z][__x][__y] & x_flag) != 0)
                        {
                            int lowest_y_flagged = __y;
                            int highest_y_flagged = __y;
                            int lowest_z_flagged = __z;
                            int highest_z_flagged = __z;
                            for(; lowest_y_flagged > 0 && (tile_culling_bitmap[__z][__x][lowest_y_flagged - 1] & x_flag) != 0; lowest_y_flagged--);
                            for(; highest_y_flagged < size_z && (tile_culling_bitmap[__z][__x][highest_y_flagged + 1] & x_flag) != 0; highest_y_flagged++);
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
                                int h_a = tile_height[highest_z_flagged][__x][lowest_y_flagged] - c1;
                                int h_b = tile_height[lowest_z_flagged][__x][lowest_y_flagged];
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
                            for(; highest_x_flagged < size_x && (tile_culling_bitmap[__z][highest_x_flagged + 1][__y] & y_flag) != 0; highest_x_flagged++);
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
                                int h_a = tile_height[highest_z_flagged][lowest_x_flagged][__y] - c2;
                                int h_b = tile_height[lowest_z_flagged][lowest_x_flagged][__y];
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
                            for(; i9 < size_z && (tile_culling_bitmap[__z][__x][i9 + 1] & z_flag) != 0; i9++);
label4:
                            for(; i5 > 0; i5--)
                            {
                                for(int l11 = k7; l11 <= i9; l11++)
                                    if((tile_culling_bitmap[__z][i5 - 1][l11] & z_flag) == 0)
                                        break label4;

                            }

label5:
                            for(; j6 < size_x; j6++)
                            {
                                for(int i12 = k7; i12 <= i9; i12++)
                                    if((tile_culling_bitmap[__z][j6 + 1][i12] & z_flag) == 0)
                                        break label5;

                            }

                            if(((j6 - i5) + 1) * ((i9 - k7) + 1) >= 4)
                            {
                                int j12 = tile_height[__z][i5][k7];
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

    private int mix_lightness_signed(int hsl, int lightness)
    {
        if(hsl == -2)
            return 12345678;
        if(hsl == -1)
        {
            if(lightness < 0)
                lightness = 0;
            else if(lightness > 127)
                lightness = 127;
            lightness = 127 - lightness;
            return lightness;
        }
        lightness = (lightness * (hsl & 0x7f)) / 128;
        if(lightness < 2)
            lightness = 2;
        else
        if(lightness > 126)
            lightness = 126;
        return (hsl & 0xff80) + lightness;
    }

    private static int mix_lightness(int hsl, int lightness)
    {
        if(hsl == -1)
            return 12345678;
        lightness = (lightness * (hsl & 0x7f)) / 128;
        if(lightness < 2)
            lightness = 2;
        else
        if(lightness > 126)
            lightness = 126;
        return (hsl & 0xff80) + lightness;
    }

    /**
     * Convert an 24 bit RGB colour word to an 18 bit HSL word
     * @param rgb The RGB colour word to convert
     * @return The converted HSL colour word
     */

    public int rgb_to_hsl(int rgb) {
        double r = (double) (rgb >> 16 & 0xff) / 256D;
        double g = (double) (rgb >> 8 & 0xff) / 256D;
        double b = (double) (rgb & 0xff) / 256D;
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
        //Noise was injected in the colour here for anti-cheat purposes.
        //This was removed because it wasn't needed
        return pack_hsl(_hue, _saturation, _lightness);
    }

    /**
     * Packs separate hue, saturation and lightness_buffer into a 18bit HSL word
     * @param hue The hue value to pack
     * @param saturation The saturation value to pack
     * @param lightness The lightness_buffer to pack
     * @return The packed HSL word
     */
    private int pack_hsl(int hue, int saturation, int lightness)
    {
        if(lightness > 179)
            saturation /= 2;
        if(lightness > 192)
            saturation /= 2;
        if(lightness > 217)
            saturation /= 2;
        if(lightness > 243)
            saturation /= 2;
        return (hue / 4 << 10) + (saturation / 32 << 7) + lightness / 2;
    }

    /**
     * 2D Pseudorandom noise generator 
     * @param x The horizontal coordinate to get the noise for
     * @param y The vertical coordinate to get the noise for
     * @return The value of the noise at [<b>x</b>;<b>y</b>]
     */
    private static int random_noise(int x, int y)
    {
        int n = x + y * 57;
        n = n << 13 ^ n;
        int l = n * (n * n * 15731 + 789221) + 1376312589 & 0x7fffffff;
        return l >> 19 & 0xff;
    }

    private static int random_noise_weighed_sum(int x, int y)
    {
        int v_dist2 =   random_noise(x - 1, y - 1) +
                random_noise(x + 1, y - 1) +
                random_noise(x - 1, y + 1) +
                random_noise(x + 1, y + 1);
        int v_dist1 =   random_noise(x - 1, y) +
                random_noise(x + 1, y) +
                random_noise(x, y - 1) +
                random_noise(x, y + 1);
        int v_local =   random_noise(x, y);
        return v_dist2 / 16 + v_dist1 / 8 + v_local / 4;
    }

    /**
     * Implements cosine interpolation
     * @param a First value
     * @param b Second value
     * @param mu "Position" between values
     * @param mu_scale Divider for <b>mu</b>
     * @return Interpolated value
     */
    private static int interpolate(int a, int b, int mu, int mu_scale)
    {
        int f = 0x10000 - Rasterizer.COSINE[(mu * 1024) / mu_scale] >> 1;
        return (a * (0x10000 - f) >> 16) + (b * f >> 16);
    }

    /**
     * Perlin noise generator
     * @param x The horizontal coordinate to get the noise for
     * @param y The vertical coordinate to get the noise for
     * @param scale The scale of the coordinate set
     * @return The value of the noise at [<b>x</b>;<b>y</b>]
     */
    private static int perlin_noise(int x, int y, int scale)
    {
        int scaled_x = x / scale;
        int mu_x = x & scale - 1;
        int scaled_y = y / scale;
        int mu_y = y & scale - 1;
        int s = random_noise_weighed_sum(scaled_x, scaled_y);
        int t = random_noise_weighed_sum(scaled_x + 1, scaled_y);
        int u = random_noise_weighed_sum(scaled_x, scaled_y + 1);
        int v = random_noise_weighed_sum(scaled_x + 1, scaled_y + 1);
        int i_v1 = interpolate(s, t, mu_x, scale);
        int i_v2 = interpolate(u, v, mu_x, scale);
        return interpolate(i_v1, i_v2, mu_y, scale);
    }

    private static int perlin_noise_3pass(int x, int y)
    {
        int noise = (perlin_noise(x + 45365, y + 91923, 4) - 128) +
                    (perlin_noise(x + 10294, y + 37821, 2) - 128 >> 1) +
                    (perlin_noise(x, y, 1) - 128 >> 2);
        noise = (int)((double)noise * 0.29999999999999999D) + 35;
        if(noise < 10)
            noise = 10;
        else if(noise > 60)
            noise = 60;
        return noise;
    }


    public final void clear_region(int block_z, int block_h, int block_w, int block_x)
    {
        for(int tile_z = block_z; tile_z <= block_z + block_h; tile_z++)
        {
            for(int tile_x = block_x; tile_x <= block_x + block_w; tile_x++)
                if(tile_x >= 0 && tile_x < size_x && tile_z >= 0 && tile_z < size_z)
                {
                    object_shadow_data[0][tile_x][tile_z] = 127;
                    if(tile_x == block_x && tile_x > 0)
                        tile_height[0][tile_x][tile_z] = tile_height[0][tile_x - 1][tile_z];
                    if(tile_x == block_x + block_w && tile_x < size_x - 1)
                        tile_height[0][tile_x][tile_z] = tile_height[0][tile_x + 1][tile_z];
                    if(tile_z == block_z && tile_z > 0)
                        tile_height[0][tile_x][tile_z] = tile_height[0][tile_x][tile_z - 1];
                    if(tile_z == block_z + block_h && tile_z < size_z - 1)
                        tile_height[0][tile_x][tile_z] = tile_height[0][tile_x][tile_z + 1];
                }

        }
    }
    
    private void add_object(int object_id, int object_type, int object_orientation, int tile_y, int tile_x, int tile_z, TileSetting tileSetting, SceneGraph sceneGraph)
    {
        if(low_detail && (tile_flags[0][tile_x][tile_z] & 2) == 0)
        {
            if((tile_flags[tile_y][tile_x][tile_z] & 0x10) != 0)
                return;
            if(get_logic_height(tile_y, tile_x, tile_z) != anInt131)
                return;
        }
        if(tile_y < setZ)
            setZ = tile_y;
        int a_y = tile_height[tile_y][tile_x][tile_z];
        int b_y = tile_height[tile_y][tile_x + 1][tile_z];
        int d_y = tile_height[tile_y][tile_x + 1][tile_z + 1];
        int c_y = tile_height[tile_y][tile_x][tile_z + 1];
        int avg_z = a_y + b_y + d_y + c_y >> 2;
        ObjectDef object_def = ObjectDef.forID(object_id);
        int idTag = tile_x + (tile_z << 7) + (object_id << 14) + 0x40000000;
        if(!object_def.hasActions)
            idTag += 0x80000000;
        byte object_info = (byte)((object_orientation << 6) + object_type);
        if(object_type == 22)
        {
            if(low_detail && !object_def.hasActions && !object_def.aBoolean736)
                return;
            Object obj;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj = object_def.generate_model(22, object_orientation, a_y, b_y, d_y, c_y, -1);
            else
                obj = new ObjectInstance(object_id, object_orientation, 22, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            sceneGraph.addGroundDecoration(tile_y, avg_z, tile_z, ((Entity) (obj)), object_info, idTag, tile_x, false);
            if(object_def.isUnwalkable && object_def.hasActions && tileSetting != null)
                tileSetting.orClipTableSET(tile_z, tile_x);
            return;
        }
        if(object_type == 10 || object_type == 11)
        {
            Object obj1;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj1 = object_def.generate_model(10, object_orientation, a_y, b_y, d_y, c_y, -1);
            else
                obj1 = new ObjectInstance(object_id, object_orientation, 10, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            if(obj1 != null)
            {
                int i5 = 0;
                if(object_type == 11)
                    i5 += 256;
                int j4;
                int l4;
                if(object_orientation == 1 || object_orientation == 3)
                {
                    j4 = object_def.height;
                    l4 = object_def.width;
                } else
                {
                    j4 = object_def.width;
                    l4 = object_def.height;
                }
                if(sceneGraph.addEntityB(idTag, object_info, avg_z, l4, ((Entity) (obj1)), j4, tile_y, i5, tile_z, tile_x) && object_def.aBoolean779)
                {
                    Model model;
                    if(obj1 instanceof Model)
                        model = (Model)obj1;
                    else
                        model = object_def.generate_model(10, object_orientation, a_y, b_y, d_y, c_y, -1);
                    if(model != null)
                    {
                        for(int j5 = 0; j5 <= j4; j5++)
                        {
                            for(int k5 = 0; k5 <= l4; k5++)
                            {
                                int l5 = model.diagonal2DAboveorigin / 4;
                                if(l5 > 30)
                                    l5 = 30;
                                if(l5 > object_shadow_data[tile_y][tile_x + j5][tile_z + k5])
                                    object_shadow_data[tile_y][tile_x + j5][tile_z + k5] = (byte)l5;
                            }

                        }

                    }
                }
            }
            if(object_def.isUnwalkable && tileSetting != null)
                tileSetting.method212(object_def.aBoolean757, object_def.width, object_def.height, tile_x, tile_z, object_orientation);
            return;
        }
        if(object_type >= 12)
        {
            Object obj2;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj2 = object_def.generate_model(object_type, object_orientation, a_y, b_y, d_y, c_y, -1);
            else
                obj2 = new ObjectInstance(object_id, object_orientation, object_type, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            sceneGraph.addEntityB(idTag, object_info, avg_z, 1, ((Entity) (obj2)), 1, tile_y, 0, tile_z, tile_x);
            if(object_type >= 12 && object_type <= 17 && object_type != 13 && tile_y > 0)
                tile_culling_bitmap[tile_y][tile_x][tile_z] |= 0x924;
            if(object_def.isUnwalkable && tileSetting != null)
                tileSetting.method212(object_def.aBoolean757, object_def.width, object_def.height, tile_x, tile_z, object_orientation);
            return;
        }
        if(object_type == 0)
        {
            Object obj3;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj3 = object_def.generate_model(0, object_orientation, a_y, b_y, d_y, c_y, -1);
            else
                obj3 = new ObjectInstance(object_id, object_orientation, 0, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            sceneGraph.addWallObject(powers_of_two[object_orientation], ((Entity) (obj3)), idTag, tile_z, object_info, tile_x, null, avg_z, 0, tile_y,object_orientation);
            if(object_orientation == 0)
            {
                if(object_def.aBoolean779)
                {
                    object_shadow_data[tile_y][tile_x][tile_z] = 50;
                    object_shadow_data[tile_y][tile_x][tile_z + 1] = 50;
                }
                if(object_def.aBoolean764)
                    tile_culling_bitmap[tile_y][tile_x][tile_z] |= 0x249;
            } else
            if(object_orientation == 1)
            {
                if(object_def.aBoolean779)
                {
                    object_shadow_data[tile_y][tile_x][tile_z + 1] = 50;
                    object_shadow_data[tile_y][tile_x + 1][tile_z + 1] = 50;
                }
                if(object_def.aBoolean764)
                    tile_culling_bitmap[tile_y][tile_x][tile_z + 1] |= 0x492;
            } else
            if(object_orientation == 2)
            {
                if(object_def.aBoolean779)
                {
                    object_shadow_data[tile_y][tile_x + 1][tile_z] = 50;
                    object_shadow_data[tile_y][tile_x + 1][tile_z + 1] = 50;
                }
                if(object_def.aBoolean764)
                    tile_culling_bitmap[tile_y][tile_x + 1][tile_z] |= 0x249;
            } else
            if(object_orientation == 3)
            {
                if(object_def.aBoolean779)
                {
                    object_shadow_data[tile_y][tile_x][tile_z] = 50;
                    object_shadow_data[tile_y][tile_x + 1][tile_z] = 50;
                }
                if(object_def.aBoolean764)
                    tile_culling_bitmap[tile_y][tile_x][tile_z] |= 0x492;
            }
            if(object_def.isUnwalkable && tileSetting != null)
                tileSetting.method211(tile_z, object_orientation, tile_x, object_type, object_def.aBoolean757);
            if(object_def.anInt775 != 16)
                sceneGraph.method290(tile_z, object_def.anInt775, tile_x, tile_y);
            return;
        }
        if(object_type == 1)
        {
            Object obj4;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj4 = object_def.generate_model(1, object_orientation, a_y, b_y, d_y, c_y, -1);
            else
                obj4 = new ObjectInstance(object_id, object_orientation, 1, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            sceneGraph.addWallObject(highNybbleBitValues[object_orientation], ((Entity) (obj4)), idTag, tile_z, object_info, tile_x, null, avg_z, 0, tile_y,object_orientation);
            if(object_def.aBoolean779)
                if(object_orientation == 0)
                    object_shadow_data[tile_y][tile_x][tile_z + 1] = 50;
                else
                if(object_orientation == 1)
                    object_shadow_data[tile_y][tile_x + 1][tile_z + 1] = 50;
                else
                if(object_orientation == 2)
                    object_shadow_data[tile_y][tile_x + 1][tile_z] = 50;
                else
                if(object_orientation == 3)
                    object_shadow_data[tile_y][tile_x][tile_z] = 50;
            if(object_def.isUnwalkable && tileSetting != null)
                tileSetting.method211(tile_z, object_orientation, tile_x, object_type, object_def.aBoolean757);
            return;
        }
        if(object_type == 2)
        {
            int i3 = object_orientation + 1 & 3;
            Object obj11;
            Object obj12;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
            {
                obj11 = object_def.generate_model(2, 4 + object_orientation, a_y, b_y, d_y, c_y, -1);
                obj12 = object_def.generate_model(2, i3, a_y, b_y, d_y, c_y, -1);
            } else
            {
                obj11 = new ObjectInstance(object_id, 4 + object_orientation, 2, a_y, b_y, c_y, d_y, object_def.animation_id, true);
                obj12 = new ObjectInstance(object_id, i3, 2, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            }
            sceneGraph.addWallObject(powers_of_two[object_orientation], ((Entity) (obj11)), idTag, tile_z, object_info, tile_x, ((Entity) (obj12)), avg_z, powers_of_two[i3], tile_y,object_orientation);
            if(object_def.aBoolean764)
                if(object_orientation == 0)
                {
                    tile_culling_bitmap[tile_y][tile_x][tile_z] |= 0x249;
                    tile_culling_bitmap[tile_y][tile_x][tile_z + 1] |= 0x492;
                } else
                if(object_orientation == 1)
                {
                    tile_culling_bitmap[tile_y][tile_x][tile_z + 1] |= 0x492;
                    tile_culling_bitmap[tile_y][tile_x + 1][tile_z] |= 0x249;
                } else
                if(object_orientation == 2)
                {
                    tile_culling_bitmap[tile_y][tile_x + 1][tile_z] |= 0x249;
                    tile_culling_bitmap[tile_y][tile_x][tile_z] |= 0x492;
                } else
                if(object_orientation == 3)
                {
                    tile_culling_bitmap[tile_y][tile_x][tile_z] |= 0x492;
                    tile_culling_bitmap[tile_y][tile_x][tile_z] |= 0x249;
                }
            if(object_def.isUnwalkable && tileSetting != null)
                tileSetting.method211(tile_z, object_orientation, tile_x, object_type, object_def.aBoolean757);
            if(object_def.anInt775 != 16)
                sceneGraph.method290(tile_z, object_def.anInt775, tile_x, tile_y);
            return;
        }
        if(object_type == 3)
        {
            Object obj5;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj5 = object_def.generate_model(3, object_orientation, a_y, b_y, d_y, c_y, -1);
            else
                obj5 = new ObjectInstance(object_id, object_orientation, 3, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            sceneGraph.addWallObject(highNybbleBitValues[object_orientation], ((Entity) (obj5)), idTag, tile_z, object_info, tile_x, null, avg_z, 0, tile_y,object_orientation);
            if(object_def.aBoolean779)
                if(object_orientation == 0)
                    object_shadow_data[tile_y][tile_x][tile_z + 1] = 50;
                else
                if(object_orientation == 1)
                    object_shadow_data[tile_y][tile_x + 1][tile_z + 1] = 50;
                else
                if(object_orientation == 2)
                    object_shadow_data[tile_y][tile_x + 1][tile_z] = 50;
                else
                if(object_orientation == 3)
                    object_shadow_data[tile_y][tile_x][tile_z] = 50;
            if(object_def.isUnwalkable && tileSetting != null)
                tileSetting.method211(tile_z, object_orientation, tile_x, object_type, object_def.aBoolean757);
            return;
        }
        if(object_type == 9)
        {
            Object obj6;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj6 = object_def.generate_model(object_type, object_orientation, a_y, b_y, d_y, c_y, -1);
            else
                obj6 = new ObjectInstance(object_id, object_orientation, object_type, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            sceneGraph.addEntityB(idTag, object_info, avg_z, 1, ((Entity) (obj6)), 1, tile_y, 0, tile_z, tile_x);
            if(object_def.isUnwalkable && tileSetting != null)
                tileSetting.method212(object_def.aBoolean757, object_def.width, object_def.height, tile_x, tile_z, object_orientation);
            return;
        }
        if(object_def.adjustToTerrain)
            if(object_orientation == 1)
            {
                int j3 = c_y;
                c_y = d_y;
                d_y = b_y;
                b_y = a_y;
                a_y = j3;
            } else
            if(object_orientation == 2)
            {
                int k3 = c_y;
                c_y = b_y;
                b_y = k3;
                k3 = d_y;
                d_y = a_y;
                a_y = k3;
            } else
            if(object_orientation == 3)
            {
                int l3 = c_y;
                c_y = a_y;
                a_y = b_y;
                b_y = d_y;
                d_y = l3;
            }
        if(object_type == 4)
        {
            Object obj7;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj7 = object_def.generate_model(4, 0, a_y, b_y, d_y, c_y, -1);
            else
                obj7 = new ObjectInstance(object_id, 0, 4, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            sceneGraph.addWallDecoration(idTag, tile_z, object_orientation * 512, tile_y, 0, avg_z, ((Entity) (obj7)), tile_x, object_info, 0, powers_of_two[object_orientation]);
            return;
        }
        if(object_type == 5)
        {
            int i4 = 16;
            int k4 = sceneGraph.getWallObjectUID(tile_y, tile_x, tile_z);
            if(k4 > 0)
                i4 = ObjectDef.forID(k4 >> 14 & 0x7fff).anInt775;
            Object obj13;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj13 = object_def.generate_model(4, 0, a_y, b_y, d_y, c_y, -1);
            else
                obj13 = new ObjectInstance(object_id, 0, 4, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            sceneGraph.addWallDecoration(idTag, tile_z, object_orientation * 512, tile_y, faceXOffset[object_orientation] * i4, avg_z, ((Entity) (obj13)), tile_x, object_info, faceYOffset[object_orientation] * i4, powers_of_two[object_orientation]);
            return;
        }
        if(object_type == 6)
        {
            Object obj8;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj8 = object_def.generate_model(4, 0, a_y, b_y, d_y, c_y, -1);
            else
                obj8 = new ObjectInstance(object_id, 0, 4, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            sceneGraph.addWallDecoration(idTag, tile_z, object_orientation, tile_y, 0, avg_z, ((Entity) (obj8)), tile_x, object_info, 0, 256);
            return;
        }
        if(object_type == 7)
        {
            Object obj9;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj9 = object_def.generate_model(4, 0, a_y, b_y, d_y, c_y, -1);
            else
                obj9 = new ObjectInstance(object_id, 0, 4, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            sceneGraph.addWallDecoration(idTag, tile_z, object_orientation, tile_y, 0, avg_z, ((Entity) (obj9)), tile_x, object_info, 0, 512);
            return;
        }
        if(object_type == 8)
        {
            Object obj10;
            if(object_def.animation_id == -1 && object_def.alternative_ids == null)
                obj10 = object_def.generate_model(4, 0, a_y, b_y, d_y, c_y, -1);
            else
                obj10 = new ObjectInstance(object_id, 0, 4, a_y, b_y, c_y, d_y, object_def.animation_id, true);
            sceneGraph.addWallDecoration(idTag, tile_z, object_orientation, tile_y, 0, avg_z, ((Entity) (obj10)), tile_x, object_info, 0, 768);
        }
    }

    public static boolean is_object_type_cached(int object_id, int object_type)
    {
        ObjectDef object_def = ObjectDef.forID(object_id);
        if(object_type == 11)
            object_type = 10;
        if(object_type >= 5 && object_type <= 8)
            object_type = 4;
        return object_def.is_type_cached(object_type);
    }

    public final void load_terrain_subblock(byte block_data[], int block_y, int block_x, int block_z, int subblock_y, int subblock_x, int subblock_z, int orientation, TileSetting tileSettings[])
    {
        for(int tile_x = 0; tile_x < 8; tile_x++)
        {
            for(int tile_z = 0; tile_z < 8; tile_z++)
                if(block_x + tile_x > 0 && block_x + tile_x < size_x - 1 && block_z + tile_z > 0 && block_z + tile_z < size_z - 1)
                    tileSettings[block_y].clipData[block_x + tile_x][block_z + tile_z] &= 0xfeffffff;

        }
        Packet stream = new Packet(block_data);
        for(int tile_y = 0; tile_y < 4; tile_y++)
        {
            for(int tile_x = 0; tile_x < 64; tile_x++)
            {
                for(int tile_z = 0; tile_z < 64; tile_z++)
                    if(tile_y == subblock_y && tile_x >= subblock_x && tile_x < subblock_x + 8 && tile_z >= subblock_z && tile_z < subblock_z + 8)
                        load_terrain_tile(block_y,
                                block_x + MapUtility.rotate_terrain_block_x(tile_x & 7, tile_z & 7, orientation),
                                block_z + MapUtility.rotate_terrain_block_z(tile_x & 7, tile_z & 7, orientation),
                                0,
                                0,
                                orientation,
                                stream);
                    else
                        load_terrain_tile(0, -1, -1, 0, 0, 0, stream);

            }

        }

    }

    public final void load_terrain_block(byte block_data[], int block_z, int block_x, int region_x, int region_z, TileSetting tileSetting[])
    {
        for(int tile_y = 0; tile_y < 4; tile_y++)
        {
            for(int tile_x = 0; tile_x < 64; tile_x++)
            {
                for(int tile_z = 0; tile_z < 64; tile_z++)
                    if(block_x + tile_x > 0 && block_x + tile_x < size_x - 1 && block_z + tile_z > 0 && block_z + tile_z < size_z - 1)
                        tileSetting[tile_y].clipData[block_x + tile_x][block_z + tile_z] &= 0xfeffffff;

            }

        }

        Packet stream = new Packet(block_data);
        for(int tile_y = 0; tile_y < 4; tile_y++)
        {
            for(int tile_x = 0; tile_x < 64; tile_x++)
            {
                for(int tile_z = 0; tile_z < 64; tile_z++)
                    load_terrain_tile(tile_y, tile_x + block_x, tile_z + block_z, region_x, region_z, 0, stream);

            }

        }
    }

    private void load_terrain_tile(int tile_y, int tile_x, int tile_z, int region_x, int region_z, int tile_orientation, Packet stream)
    {
        if(tile_x >= 0 && tile_x < size_x && tile_z >= 0 && tile_z < size_z)
        {
            tile_flags[tile_y][tile_x][tile_z] = 0;
            do
            {
                int value = stream.g1();
                if(value == 0){
                    tile_auto_height[tile_y][tile_x][tile_z] = true;
                    if(tile_y == 0)
                    {
                        tile_height[0][tile_x][tile_z] = -perlin_noise_3pass(932731 + tile_x + region_x, 556238 + tile_z + region_z) * 8;
                        return;
                    } else
                    {
                        tile_height[tile_y][tile_x][tile_z] = tile_height[tile_y - 1][tile_x][tile_z] - 240;
                        return;
                    }
                }
                if(value == 1)
                {
                    tile_auto_height[tile_y][tile_x][tile_z] = false;
                    int height = stream.g1();
                    if(height == 1)
                        height = 0;
                    if(tile_y == 0)
                    {
                        tile_height[0][tile_x][tile_z] = -height * 8;
                        return;
                    } else
                    {
                        tile_height[tile_y][tile_x][tile_z] = tile_height[tile_y - 1][tile_x][tile_z] - height * 8;
                        return;
                    }
                }
                if(value <= 49)
                {
                    tile_layer1_type[tile_y][tile_x][tile_z] = stream.g1b();
                    tile_layer1_shape[tile_y][tile_x][tile_z] = (byte)((value - 2) / 4);
                    tile_layer1_orientation[tile_y][tile_x][tile_z] = (byte) (((value - 2) + tile_orientation) & 3);
                } else
                if(value <= 81)
                    tile_flags[tile_y][tile_x][tile_z] = (byte)(value - 49);
                else
                    tile_layer0_type[tile_y][tile_x][tile_z] = (byte)(value - 81);     //255-81 = Only 174 possible underlays
            } while(true);
        }
        do
        {
            if (isMapEditor)
                System.err.println("Warning: tiles are being discarded, are you sure mapSize is a multiple of 64?");
            int value = stream.g1();
            if(value == 0)
                break;
            if(value == 1)
            {
                stream.g1();
                return;
            }
            if(value <= 49)
                stream.g1();
        } while(true);
    }

    public void save_terrain_block(int block_x, int block_y, Packet packet) {
        if (block_x < 0 ||  block_y < 0 || (block_x + 64) > size_x || (block_y + 64) > size_z)
            throw new RuntimeException("Trying to write tiles not in memory!");
        for(int tile_y = 0; tile_y < 4; tile_y++)
        {
            for(int tile_x = 0; tile_x < 64; tile_x++)
            {
                for(int tile_z = 0; tile_z < 64; tile_z++)
                    save_terrain_tile(tile_y, tile_x + block_x, tile_z + block_y, packet);

            }

        }
    }

    private void save_terrain_tile(int y, int x, int z, Packet packet) {
        if(tile_layer1_type[y][x][z] != 0){
            packet.p1((tile_layer1_shape[y][x][z] * 4) + (tile_layer1_orientation[y][x][z] & 3) + 2);
            packet.p1(tile_layer1_type[y][x][z]);
        }
        if(tile_flags[y][x][z] != 0)
            packet.p1(tile_flags[y][x][z] + 49);
        if(tile_layer0_type[y][x][z] != 0)
            packet.p1(tile_layer0_type[y][x][z] + 81);
        if(!tile_auto_height[y][x][z]){
            packet.p1(1);
            if (y == 0)
                packet.p1((-tile_height[y][x][z]) / 8);
            else
                packet.p1((tile_height[y-1][x][z]- tile_height[y][x][z]) / 8);
        } else
            packet.p1(0);
    }

    private int get_logic_height(int tile_z, int tile_x, int tile_y)
    {
        if((tile_flags[tile_z][tile_x][tile_y] & 8) != 0)
            return 0;
        if(tile_z > 0 && (tile_flags[1][tile_x][tile_y] & 2) != 0)
            return tile_z - 1;
        else
            return tile_z;
    }


    public static void method188(SceneGraph sceneGraph, int i, int y, int k, int l, TileSetting tileSetting, int ai[][][], int x,
                                 int objectID, int z)
    {
        int l1 = ai[l][x][y];
        int i2 = ai[l][x + 1][y];
        int j2 = ai[l][x + 1][y + 1];
        int k2 = ai[l][x][y + 1];
        int l2 = l1 + i2 + j2 + k2 >> 2;
        ObjectDef objectDef = ObjectDef.forID(objectID);
        int i3 = x + (y << 7) + (objectID << 14) + 0x40000000;
        if(!objectDef.hasActions)
            i3 += 0x80000000;
        byte byte1 = (byte)((i << 6) + k);
        if(k == 22)
        {
            Object obj;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj = objectDef.generate_model(22, i, l1, i2, j2, k2, -1);
            else
                obj = new ObjectInstance(objectID, i, 22, l1, i2, k2, j2, objectDef.animation_id, true);
            sceneGraph.addGroundDecoration(z, l2, y, ((Entity) (obj)), byte1, i3, x, false);
            if(objectDef.isUnwalkable && objectDef.hasActions)
                tileSetting.orClipTableSET(y, x);
            return;
        }
        if(k == 10 || k == 11)
        {
            Object obj1;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj1 = objectDef.generate_model(10, i, l1, i2, j2, k2, -1);
            else
                obj1 = new ObjectInstance(objectID, i, 10, l1, i2, k2, j2, objectDef.animation_id, true);
            if(obj1 != null)
            {
                int j5 = 0;
                if(k == 11)
                    j5 += 256;
                int k4;
                int i5;
                if(i == 1 || i == 3)
                {
                    k4 = objectDef.height;
                    i5 = objectDef.width;
                } else
                {
                    k4 = objectDef.width;
                    i5 = objectDef.height;
                }
                sceneGraph.addEntityB(i3, byte1, l2, i5, ((Entity) (obj1)), k4, z, j5, y, x);
            }
            if(objectDef.isUnwalkable)
                tileSetting.method212(objectDef.aBoolean757, objectDef.width, objectDef.height, x, y, i);
            return;
        }
        if(k >= 12)
        {
            Object obj2;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj2 = objectDef.generate_model(k, i, l1, i2, j2, k2, -1);
            else
                obj2 = new ObjectInstance(objectID, i, k, l1, i2, k2, j2, objectDef.animation_id, true);
            sceneGraph.addEntityB(i3, byte1, l2, 1, ((Entity) (obj2)), 1, z, 0, y, x);
            if(objectDef.isUnwalkable)
                tileSetting.method212(objectDef.aBoolean757, objectDef.width, objectDef.height, x, y, i);
            return;
        }
        if(k == 0)
        {
            Object obj3;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj3 = objectDef.generate_model(0, i, l1, i2, j2, k2, -1);
            else
                obj3 = new ObjectInstance(objectID, i, 0, l1, i2, k2, j2, objectDef.animation_id, true);
            sceneGraph.addWallObject(powers_of_two[i], ((Entity) (obj3)), i3, y, byte1, x, null, l2, 0, z,i);
            if(objectDef.isUnwalkable)
                tileSetting.method211(y, i, x, k, objectDef.aBoolean757);
            return;
        }
        if(k == 1)
        {
            Object obj4;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj4 = objectDef.generate_model(1, i, l1, i2, j2, k2, -1);
            else
                obj4 = new ObjectInstance(objectID, i, 1, l1, i2, k2, j2, objectDef.animation_id, true);
            sceneGraph.addWallObject(highNybbleBitValues[i], ((Entity) (obj4)), i3, y, byte1, x, null, l2, 0, z,i);
            if(objectDef.isUnwalkable)
                tileSetting.method211(y, i, x, k, objectDef.aBoolean757);
            return;
        }
        if(k == 2)
        {
            int j3 = i + 1 & 3;
            Object obj11;
            Object obj12;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
            {
                obj11 = objectDef.generate_model(2, 4 + i, l1, i2, j2, k2, -1);
                obj12 = objectDef.generate_model(2, j3, l1, i2, j2, k2, -1);
            } else
            {
                obj11 = new ObjectInstance(objectID, 4 + i, 2, l1, i2, k2, j2, objectDef.animation_id, true);
                obj12 = new ObjectInstance(objectID, j3, 2, l1, i2, k2, j2, objectDef.animation_id, true);
            }
            sceneGraph.addWallObject(powers_of_two[i], ((Entity) (obj11)), i3, y, byte1, x, ((Entity) (obj12)), l2, powers_of_two[j3], z,i);
            if(objectDef.isUnwalkable)
                tileSetting.method211(y, i, x, k, objectDef.aBoolean757);
            return;
        }
        if(k == 3)
        {
            Object obj5;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj5 = objectDef.generate_model(3, i, l1, i2, j2, k2, -1);
            else
                obj5 = new ObjectInstance(objectID, i, 3, l1, i2, k2, j2, objectDef.animation_id, true);
            sceneGraph.addWallObject(highNybbleBitValues[i], ((Entity) (obj5)), i3, y, byte1, x, null, l2, 0, z,i);
            if(objectDef.isUnwalkable)
                tileSetting.method211(y, i, x, k, objectDef.aBoolean757);
            return;
        }
        if(k == 9)
        {
            Object obj6;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj6 = objectDef.generate_model(k, i, l1, i2, j2, k2, -1);
            else
                obj6 = new ObjectInstance(objectID, i, k, l1, i2, k2, j2, objectDef.animation_id, true);
            sceneGraph.addEntityB(i3, byte1, l2, 1, ((Entity) (obj6)), 1, z, 0, y, x);
            if(objectDef.isUnwalkable)
                tileSetting.method212(objectDef.aBoolean757, objectDef.width, objectDef.height, x, y, i);
            return;
        }
        if(objectDef.adjustToTerrain)
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
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj7 = objectDef.generate_model(4, 0, l1, i2, j2, k2, -1);
            else
                obj7 = new ObjectInstance(objectID, 0, 4, l1, i2, k2, j2, objectDef.animation_id, true);
            sceneGraph.addWallDecoration(i3, y, i * 512, z, 0, l2, ((Entity) (obj7)), x, byte1, 0, powers_of_two[i]);
            return;
        }
        if(k == 5)
        {
            int j4 = 16;
            int l4 = sceneGraph.getWallObjectUID(z, x, y);
            if(l4 > 0)
                j4 = ObjectDef.forID(l4 >> 14 & 0x7fff).anInt775;
            Object obj13;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj13 = objectDef.generate_model(4, 0, l1, i2, j2, k2, -1);
            else
                obj13 = new ObjectInstance(objectID, 0, 4, l1, i2, k2, j2, objectDef.animation_id, true);
            sceneGraph.addWallDecoration(i3, y, i * 512, z, faceXOffset[i] * j4, l2, ((Entity) (obj13)), x, byte1, faceYOffset[i] * j4, powers_of_two[i]);
            return;
        }
        if(k == 6)
        {
            Object obj8;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj8 = objectDef.generate_model(4, 0, l1, i2, j2, k2, -1);
            else
                obj8 = new ObjectInstance(objectID, 0, 4, l1, i2, k2, j2, objectDef.animation_id, true);
            sceneGraph.addWallDecoration(i3, y, i, z, 0, l2, ((Entity) (obj8)), x, byte1, 0, 256);
            return;
        }
        if(k == 7)
        {
            Object obj9;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj9 = objectDef.generate_model(4, 0, l1, i2, j2, k2, -1);
            else
                obj9 = new ObjectInstance(objectID, 0, 4, l1, i2, k2, j2, objectDef.animation_id, true);
            sceneGraph.addWallDecoration(i3, y, i, z, 0, l2, ((Entity) (obj9)), x, byte1, 0, 512);
            return;
        }
        if(k == 8)
        {
            Object obj10;
            if(objectDef.animation_id == -1 && objectDef.alternative_ids == null)
                obj10 = objectDef.generate_model(4, 0, l1, i2, j2, k2, -1);
            else
                obj10 = new ObjectInstance(objectID, 0, 4, l1, i2, k2, j2, objectDef.animation_id, true);
            sceneGraph.addWallDecoration(i3, y, i, z, 0, l2, ((Entity) (obj10)), x, byte1, 0, 768);
        }
    }


    public static void request_object_models(Packet block_data, OnDemandFetcher data_source)
    {
        label0:
        {
            int object_id = -1;
            do
            {
                int delta_id = block_data.gsmarts();
                if(delta_id == 0)
                    break label0;
                object_id += delta_id;
                ObjectDef object_def = ObjectDef.forID(object_id);
                object_def.request_models(data_source);
                do
                {
                    int delta_pos = block_data.gsmarts();
                    if(delta_pos == 0)
                        break;
                    block_data.g1();
                } while(true);
            } while(true);
        }
    }

    public static boolean is_object_block_cached(int block_x, int block_z, byte[] block_data) //xxx bad method, decompiled with JODE
    {
        boolean fully_cached = true;
        Packet stream = new Packet(block_data);
        int object_id = -1;
        for (; ; ) {
            int delta_id = stream.gsmarts();
            if (delta_id == 0)
                break;
            object_id += delta_id;
            int pos = 0;
            boolean found_instance = false;
            for (; ; ) {
                if (found_instance) {
                    int i_256_ = stream.gsmarts();
                    if (i_256_ == 0)
                        break;
                    stream.g1();
                } else {
                    int delta_pos = stream.gsmarts();
                    if (delta_pos == 0)
                        break;
                    pos += delta_pos - 1;
                    int tile_z = pos & 0x3f;
                    int tile_x = pos >> 6 & 0x3f;
                    int object_type = stream.g1() >> 2;
                    int object_x = tile_x + block_x;
                    int object_z = tile_z + block_z;
                    if (object_x > 0 && object_z > 0 && object_x < 103 && object_z < 103)  //TODO:Make not static or modify mapSize to static
                    {
                        ObjectDef object_def = ObjectDef.forID(object_id);
                        if (object_type != 22 || !low_detail || object_def.hasActions || object_def.aBoolean736) {
                            fully_cached &= object_def.is_cached();
                            found_instance = true;
                        }
                    }
                }
            }
        }
        return fully_cached;
    }

    public final void load_object_block(int block_x, int block_z, byte block_data[], TileSetting tileSettings[], SceneGraph sceneGraph)
    {
label0:
        {
            Packet stream = new Packet(block_data);
            int object_id = -1;
            do
            {
                int delta_id = stream.gsmarts();
                if(delta_id == 0)
                    break label0;
                object_id += delta_id;
                int pos = 0;
                do
                {
                    int delta_pos = stream.gsmarts();
                    if(delta_pos == 0)
                        break;
                    pos += delta_pos - 1;
                    int tile_z = pos & 0x3f;
                    int tile_x = pos >> 6 & 0x3f;
                    int tile_y = pos >> 12;
                    int object_info = stream.g1();
                    int object_type = object_info >> 2;
                    int object_orientation = object_info & 3;
                    int object_x = tile_x + block_x;
                    int object_z = tile_z + block_z;
                    if(object_x > 0 && object_z > 0 && object_x < size_x - 1&& object_z < size_z - 1)
                    {
                        int logic_y = tile_y;
                        if((tile_flags[1][object_x][object_z] & 2) == 2)
                            logic_y--;
                        TileSetting tileSetting = null;
                        if(logic_y >= 0)
                            tileSetting = tileSettings[logic_y];
                        add_object(object_id, object_type, object_orientation, tile_y, object_x, object_z, tileSetting, sceneGraph);
                    }
                } while(true);
            } while(true);
        }
    }

    public final void load_object_subblock(byte block_data[], int block_y, int block_x, int block_z, int subblock_y, int subblock_x, int subblock_z, int orientation, TileSetting tileSettings[], SceneGraph sceneGraph)
    {
        label0:
        {
            Packet stream = new Packet(block_data);
            int object_id = -1;
            do
            {
                int delta_id = stream.gsmarts();
                if(delta_id == 0)
                    break label0;
                object_id += delta_id;
                int pos = 0;
                do
                {
                    int delta_pos = stream.gsmarts();
                    if(delta_pos == 0)
                        break;
                    pos += delta_pos - 1;
                    int tile_z = pos & 0x3f;
                    int tile_x = pos >> 6 & 0x3f;
                    int tile_y = pos >> 12;
                    int object_info = stream.g1();
                    int object_type = object_info >> 2;
                    int object_orientation = object_info & 3;
                    if(tile_y == subblock_y && tile_x >= subblock_x && tile_x < subblock_x + 8 && tile_z >= subblock_z && tile_z < subblock_z + 8)
                    {
                        ObjectDef object_def = ObjectDef.forID(object_id);
                        int object_x = block_x + MapUtility.rotate_object_block_x(tile_x & 7, tile_z & 7, object_def.width, object_def.height, orientation);
                        int object_z = block_z + MapUtility.rotate_object_block_z(tile_x & 7, tile_z & 7, object_def.width, object_def.height, orientation);
                        if(object_x > 0 && object_z > 0 && object_x < size_x - 1 && object_z < size_z - 1)
                        {
                            int logic_y = tile_y;
                            if((tile_flags[1][object_x][object_z] & 2) == 2)
                                logic_y--;
                            TileSetting tileSetting = null;
                            if(logic_y >= 0)
                                tileSetting = tileSettings[logic_y];
                            add_object(object_id, object_type, object_orientation + orientation & 3, block_y, object_x, object_z, tileSetting, sceneGraph);
                        }
                    }
                } while(true);
            } while(true);
        }
    }

    public int get_height(int y, int x, int z){
        if (z == 0)
            return (-tile_height[y][x][z]) / 8;
        else
            return (tile_height[y][x][z-1]- tile_height[y][x][z]) / 8;
    }

    public void set_height(int y, int x, int z, int height){
        tile_auto_height[y][x][z] = false;
        if(height == 1)
            height = 0;
        if(y == 0)
        {
            tile_height[0][x][z] = -height * 8;
            return;
        } else
        {
            tile_height[y][x][z] = tile_height[y - 1][x][z] - height * 8;
            return;
        }
    }

    public int[][][] get_tile_height() {
        return tile_height;
    }

    public byte[][][] get_tile_layer1_type() {
        return tile_layer1_type;
    }

    public byte[][][] get_tile_layer1_shape() {
        return tile_layer1_shape;
    }

    public byte[][][] get_tile_layer1_orientation() {
        return tile_layer1_orientation;
    }

    public byte[][][] get_tile_layer0_type() {
        return tile_layer0_type;
    }

    public int[][][] get_tile_layer0_colour() {
        return tile_layer0_colour;
    }

    public byte[][][] get_tile_flags() {
        return tile_flags;
    }

    private static int hue_offset = (int)(Math.random() * 17D) - 8;
    private final int[] hue_buffer;
    private final int[] saturation_buffer;
    private final int[] lightness_buffer;
    private final int[] huedivider;
    private final int[] buffer_size;
    private final int[][][] tile_height;
    private final byte[][][] tile_layer1_type;
    static int anInt131;
    private static int lightness_offset = (int)(Math.random() * 33D) - 16;
    private final byte[][][] object_shadow_data;
    private final int[][][] tile_culling_bitmap;
    public final byte[][][] tile_layer1_shape;
    private static final int faceXOffset[] = {
        1, 0, -1, 0
    };
    //private static final int anInt138 = 323;//never used
    private final int[][] tile_lightness;
    private static final int highNybbleBitValues[] = {
        16, 32, 64, 128
    };
    private final byte[][][] tile_layer0_type;
    private static final int faceYOffset[] = {
        0, -1, 0, 1
    };
    static int setZ = 99;
    private final int size_x;
    private final int size_z;
    public final byte[][][] tile_layer1_orientation;
    private final byte[][][] tile_flags;
    public static boolean low_detail = true;
    private static final int powers_of_two[] = {
        1, 2, 4, 8
    };

    public void setOverlay(int z, int x, int y, int overlay) {
        tile_layer1_type[z][x][y] = (byte) overlay;
    }

    public void setUnderlay(int z, int x, int y, int underlay) {
        tile_layer0_type[z][x][y] = (byte) underlay;
    }
}
