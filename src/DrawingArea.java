// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class DrawingArea extends NodeSub {

    public static void initDrawingArea(int i, int j, int ai[])
    {
        pixels = ai;
        width = j;
        height = i;
        setDrawingArea(i, 0, j, 0);
    }

    public static void defaultDrawingAreaSize()
    {
            topX = 0;
            topY = 0;
            viewport_w = width;
            viewport_h = height;
            viewport_r_x = viewport_w - 1;
            viewport_c_x = viewport_w / 2;
    }

    public static void setDrawingArea(int i, int j, int k, int l)
    {
        if(j < 0)
            j = 0;
        if(l < 0)
            l = 0;
        if(k > width)
            k = width;
        if(i > height)
            i = height;
        topX = j;
        topY = l;
        viewport_w = k;
        viewport_h = i;
        viewport_r_x = viewport_w - 1;
        viewport_c_x = viewport_w / 2;
        viewport_c_y = viewport_h / 2;
    }

    public static void reset_image()
    {
        int i = width * height;
        for(int j = 0; j < i; j++)
            pixels[j] = 0;

    }

    public static void fillRect(int x, int y, int w, int h, int colour, int alpha)
    {
        if(x < topX)
        {
            w -= topX - x;
            x = topX;
        }
        if(y < topY)
        {
            h -= topY - y;
            y = topY;
        }
        if(x + w > viewport_w)
            w = viewport_w - x;
        if(y + h > viewport_h)
            h = viewport_h - y;
        int dest_intensity = 256 - alpha;
        int src_red = (colour >> 16 & 0xff) * alpha;
        int src_green = (colour >> 8 & 0xff) * alpha;
        int src_blue = (colour & 0xff) * alpha;
        int line_offset = width - w;
        int ptr = x + y * width;
        for(int _y = 0; _y < h; _y++)
        {
            for(int _x = -w; _x < 0; _x++)
            {
                int dest_red = (pixels[ptr] >> 16 & 0xff) * dest_intensity;
                int dest_green = (pixels[ptr] >> 8 & 0xff) * dest_intensity;
                int dest_blue = (pixels[ptr] & 0xff) * dest_intensity;
                int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);
                pixels[ptr++] = result_rgb;
            }

            ptr += line_offset;
        }
    }

    public static void fillRect(int x, int y, int w, int h, int colour)
    {
        if(x < topX)
        {
            w -= topX - x;
            x = topX;
        }
        if(y < topY)
        {
            h -= topY - y;
            y = topY;
        }
        if(x + w > viewport_w)
            w = viewport_w - x;
        if(y + h > viewport_h)
            h = viewport_h - y;
        int line_offset = width - w;
        int ptr = x + y * width;
        for(int _y = -h; _y < 0; _y++)
        {
            for(int _x = -w; _x < 0; _x++)
                pixels[ptr++] = colour;

            ptr += line_offset;
        }

    }

    public static void drawRect(int x, int y, int w, int h, int colour)
    {
        drawHLine(x, y, w, colour);
        drawHLine(x, (y + h) - 1, w, colour);
        drawVLine(x, y, h, colour);
        drawVLine((x + w) - 1, y, h, colour);
    }

    public static void drawRect(int x, int y, int w, int h, int colour, int alpha)
    {
        drawHLine(x, y, w, colour, alpha);
        drawHLine(x, (y + h) - 1, w, colour, alpha);
        if(h >= 3)
        {
            drawVLine(x, y + 1, h - 2, colour, alpha);
            drawVLine((x + w) - 1, y + 1, h - 2, colour, alpha);
        }
    }

    public static void drawHLine(int x, int y, int w, int colour)
    {
        if(y < topY || y >= viewport_h)
            return;
        if(x < topX)
        {
            w -= topX - x;
            x = topX;
        }
        if(x + w > viewport_w)
            w = viewport_w - x;
        int ptr = x + y * width;
        for(int _x = 0; _x < w; _x++)
            pixels[ptr + _x] = colour;

    }

    public static void drawHLine(int x, int y, int w, int colour, int alpha)
    {
        if(y < topY || y >= viewport_h)
            return;
        if(x < topX)
        {
            w -= topX - x;
            x = topX;
        }
        if(x + w > viewport_w)
            w = viewport_w - x;
        int dest_intensity = 256 - alpha;
        int src_red = (colour >> 16 & 0xff) * alpha;
        int src_green = (colour >> 8 & 0xff) * alpha;
        int src_blue = (colour & 0xff) * alpha;
        int ptr = x + y * width;
        for(int _x = 0; _x < w; _x++)
        {
            int dest_red = (pixels[ptr] >> 16 & 0xff) * dest_intensity;
            int dest_green = (pixels[ptr] >> 8 & 0xff) * dest_intensity;
            int dest_blue = (pixels[ptr] & 0xff) * dest_intensity;
            int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);
            pixels[ptr++] = result_rgb;
        }

    }

    public static void drawVLine(int x, int y, int h, int colour)
    {
        if(x < topX || x >= viewport_w)
            return;
        if(y < topY)
        {
            h -= topY - y;
            y = topY;
        }
        if(y + h > viewport_h)
            h = viewport_h - y;
        int ptr = x + y * width;
        for(int _y = 0; _y < h; _y++)
            pixels[ptr + _y * width] = colour;

    }

    public static void drawVLine(int x, int y, int h, int colour, int alpha)
    {
        if(x < topX || x >= viewport_w)
            return;
        if(y < topY)
        {
            h -= topY - y;
            y = topY;
        }
        if(y + h > viewport_h)
            h = viewport_h - y;
        int dest_intensity = 256 - alpha;
        int src_red = (colour >> 16 & 0xff) * alpha;
        int src_green = (colour >> 8 & 0xff) * alpha;
        int src_blue = (colour & 0xff) * alpha;
        int ptr = x + y * width;
        for(int _y = 0; _y < h; _y++)
        {
            int dest_red = (pixels[ptr] >> 16 & 0xff) * dest_intensity;
            int dest_green = (pixels[ptr] >> 8 & 0xff) * dest_intensity;
            int dest_blue = (pixels[ptr] & 0xff) * dest_intensity;
            int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);
            pixels[ptr] = result_rgb;
            ptr += width;
        }

    }

    DrawingArea()
    {
    }

    public static int pixels[];
    public static int width;
    public static int height;
    public static int topY;
    public static int viewport_h;
    public static int topX;
    public static int viewport_w;
    public static int viewport_r_x;
    public static int viewport_c_x;
    public static int viewport_c_y;

}
