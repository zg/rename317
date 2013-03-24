package rs2;

import rs2.util.collection.QueueNode;

public class DrawingArea extends QueueNode {


    public static void setTarget(int width, int height, int pixels[]) {
        DrawingArea.pixels = pixels;
        DrawingArea.width = width;
        DrawingArea.height = height;
        setClip(0, 0, width, height);
    }

    public static void resetClip() {
        viewport_left = 0;
        viewport_top = 0;
        viewport_right = width;
        viewport_bottom = height;
        viewportRx = viewport_right;
        viewport_center_x = viewport_right / 2;
    }

    public static void drawDiagonalLine(int x, int y, int width, int height, int colour) {
        width -= x;
        height -= y;
        if (height == 0) {
            if (width >= 0)
                drawHLine(x, y, width + 1, colour);
            else
                drawHLine(x + width, y, 1 - width, colour);
        } else if (width == 0) {
            if (height >= 0)
                drawVLine(x, y, height + 1, colour);
            else
                drawVLine(x, y + height, 1-height, colour);
        } else {
            if (width + height < 0) {
                x += width;
                width = -width;
                y += height;
                height = -height;
            }
            if (width > height) {
                y <<= 16;
                y += 32768;
                height <<= 16;
                int y_step = (int) Math.floor((double) height / (double) width + 0.5);
                width += x;
                if (x < viewport_left) {
                    y += y_step * (viewport_left - x);
                    x = viewport_left;
                }
                if (width >= viewport_right)
                    width = viewport_right - 1;
                for (/**/; x <= width; x++) {
                    int _y = y >> 16;
                    if (_y >= viewport_top && _y < viewport_bottom)
                        pixels[x + _y * DrawingArea.width] = colour;
                    y += y_step;
                }
            } else {
                x <<= 16;
                x += 32768;
                width <<= 16;
                int x_step = (int) Math.floor((double) width / (double) height + 0.5);
                height += y;
                if (y < viewport_top) {
                    x += x_step * (viewport_top - y);
                    y = viewport_top;
                }
                if (height >= viewport_bottom)
                    height = viewport_bottom - 1;
                for (/**/; y <= height; y++) {
                    int _x = x >> 16;
                    if (_x >= viewport_left && _x < viewport_right)
                        pixels[_x + y * DrawingArea.width] = colour;
                    x += x_step;
                }
            }
        }
    }

    public static void setClip(int left, int top, int right, int bottom) {
        if (left < 0) {
            left = 0;
        }
        if (top < 0) {
            top = 0;
        }
        if (right > DrawingArea.width) {
            right = DrawingArea.width;
        }
        if (bottom > DrawingArea.height) {
            bottom = DrawingArea.height;
        }
        DrawingArea.viewport_left = left;
        DrawingArea.viewport_top = top;
        viewport_right = right;
        viewport_bottom = bottom;
        viewportRx = viewport_right;
        viewport_center_x = viewport_right / 2;
        viewport_center_y = viewport_bottom / 2;
    }

    public static void clear() {
        int _cnt = width * height;
        for (int _ctr = 0; _ctr < _cnt; _ctr++) {
            pixels[_ctr] = 0;
        }
    }

    public static void fillRect(int x, int y, int width, int height, int colour, int alpha) {
        if (x < viewport_left) {
            width -= viewport_left - x;
            x = viewport_left;
        }
        if (y < viewport_top) {
            height -= viewport_top - y;
            y = viewport_top;
        }
        if (x + width > viewport_right) {
            width = viewport_right - x;
        }
        if (y + height > viewport_bottom) {
            height = viewport_bottom - y;
        }
        int dest_intensity = 256 - alpha;
        int src_red = (colour >> 16 & 0xff) * alpha;
        int src_green = (colour >> 8 & 0xff) * alpha;
        int src_blue = (colour & 0xff) * alpha;
        int line_offset = DrawingArea.width - width;
        int ptr = x + y * DrawingArea.width;
        for (int y_off = 0; y_off < height; y_off++) {
            for (int x_off = -width; x_off < 0; x_off++) {
                int dest_red = (pixels[ptr] >> 16 & 0xff) * dest_intensity;
                int dest_green = (pixels[ptr] >> 8 & 0xff) * dest_intensity;
                int dest_blue = (pixels[ptr] & 0xff) * dest_intensity;
                int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);
                pixels[ptr++] = result_rgb;
            }

            ptr += line_offset;
        }
    }

    public static void fillRect(int x, int y, int width, int height, int colour) {
        if (x < viewport_left) {
            width -= viewport_left - x;
            x = viewport_left;
        }
        if (y < viewport_top) {
            height -= viewport_top - y;
            y = viewport_top;
        }
        if (x + width > viewport_right) {
            width = viewport_right - x;
        }
        if (y + height > viewport_bottom) {
            height = viewport_bottom - y;
        }
        int line_offset = DrawingArea.width - width;
        int ptr = x + y * DrawingArea.width;
        for (int y_off = -height; y_off < 0; y_off++) {
            for (int x_off = -width; x_off < 0; x_off++) {
                pixels[ptr++] = colour;
            }

            ptr += line_offset;
        }

    }

    public static void drawRect(int x, int y, int width, int height, int colour) {
        drawHLine(x, y, width, colour);
        drawHLine(x, (y + height) - 1, width, colour);
        drawVLine(x, y, height, colour);
        drawVLine((x + width) - 1, y, height, colour);
    }

    public static void drawRect(int x, int y, int width, int height, int colour, int alpha) {
        drawHLine(x, y, width, colour, alpha);
        drawHLine(x, (y + height) - 1, width, colour, alpha);
        if (height >= 3) {
            drawVLine(x, y + 1, height - 2, colour, alpha);
            drawVLine((x + width) - 1, y + 1, height - 2, colour, alpha);
        }
    }

    public static void drawHLine(int x, int y, int width, int colour) {
        if (y < viewport_top || y >= viewport_bottom) {
            return;
        }
        if (x < viewport_left) {
            width -= viewport_left - x;
            x = viewport_left;
        }
        if (x + width > viewport_right) {
            width = viewport_right - x;
        }
        int ptr = x + y * DrawingArea.width;
        for (int x_off = 0; x_off < width; x_off++) {
            pixels[ptr + x_off] = colour;
        }

    }

    public static void drawHLine(int x, int y, int width, int colour, int alpha) {
        if (y < viewport_top || y >= viewport_bottom) {
            return;
        }
        if (x < viewport_left) {
            width -= viewport_left - x;
            x = viewport_left;
        }
        if (x + width > viewport_right) {
            width = viewport_right - x;
        }
        int dest_intensity = 256 - alpha;
        int src_red = (colour >> 16 & 0xff) * alpha;
        int src_green = (colour >> 8 & 0xff) * alpha;
        int src_blue = (colour & 0xff) * alpha;
        int ptr = x + y * DrawingArea.width;
        for (int off_y = 0; off_y < width; off_y++) {
            int dest_red = (pixels[ptr] >> 16 & 0xff) * dest_intensity;
            int dest_green = (pixels[ptr] >> 8 & 0xff) * dest_intensity;
            int dest_blue = (pixels[ptr] & 0xff) * dest_intensity;
            int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);
            pixels[ptr++] = result_rgb;
        }

    }

    public static void drawVLine(int x, int y, int height, int colour) {
        if (x < viewport_left || x >= viewport_right) {
            return;
        }
        if (y < viewport_top) {
            height -= viewport_top - y;
            y = viewport_top;
        }
        if (y + height > viewport_bottom) {
            height = viewport_bottom - y;
        }
        int ptr = x + y * width;
        for (int y_off = 0; y_off < height; y_off++) {
            pixels[ptr + y_off * width] = colour;
        }

    }

    public static void drawVLine(int x, int y, int height, int colour, int alpha) {
        if (x < viewport_left || x >= viewport_right) {
            return;
        }
        if (y < viewport_top) {
            height -= viewport_top - y;
            y = viewport_top;
        }
        if (y + height > viewport_bottom) {
            height = viewport_bottom - y;
        }
        int dest_intensity = 256 - alpha;
        int src_red = (colour >> 16 & 0xff) * alpha;
        int src_green = (colour >> 8 & 0xff) * alpha;
        int src_blue = (colour & 0xff) * alpha;
        int ptr = x + y * width;
        for (int y_off = 0; y_off < height; y_off++) {
            int dest_red = (pixels[ptr] >> 16 & 0xff) * dest_intensity;
            int dest_green = (pixels[ptr] >> 8 & 0xff) * dest_intensity;
            int dest_blue = (pixels[ptr] & 0xff) * dest_intensity;
            int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);
            pixels[ptr] = result_rgb;
            ptr += width;
        }

    }

    public static void fillCircleAlpha(int x, int y, int radius, int colour, int alpha)//draw circle? - used for highlighting the map symbols ;D
    {
        int dest_intensity = 256 - alpha;
        int src_red = (colour >> 16 & 0xff) * alpha;
        int src_green = (colour >> 8 & 0xff) * alpha;
        int src_blue = (colour & 0xff) * alpha;
        int start_y = y - radius;
        if (start_y < 0)
            start_y = 0;
        int end_y = y + radius;
        if (end_y >= height)
            end_y = height - 1;
        for (int _y = start_y; _y <= end_y; _y++) {
            int y_from_center = _y - y;
            int x_from_center = (int) Math.sqrt(radius * radius - y_from_center * y_from_center);
            int start_x = x - x_from_center;
            int end_x = x + x_from_center;
            if (start_x < 0)
                start_x = 0;
            if (end_x >= width)
                end_x = width - 1;
            int pixel_offset = start_x + _y * width;
            for (int _x = start_x; _x <= end_x; _x++) {
                int dest_red   = (pixels[pixel_offset] >> 16 & 0xff) * dest_intensity;
                int dest_green = (pixels[pixel_offset] >> 8 & 0xff) * dest_intensity;
                int dest_blue  = (pixels[pixel_offset] & 0xff) * dest_intensity;
                int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);
                pixels[pixel_offset++] = result_rgb;
            }

        }

    }

    public static void fillCircle(int posX, int y, int radius, int colour) {
        int start_y = y - radius;
        if (start_y < 0)
            start_y = 0;
        int end_y = y + radius;
        if (end_y >= height)
            end_y = height - 1;
        for (int _y = start_y; _y <= end_y; _y++) {
            int y_from_center = _y - y;
            int x_from_center = (int) Math.sqrt(radius * radius - y_from_center * y_from_center);
            int start_x = posX - x_from_center;
            if (start_x < 0)
                start_x = 0;
            int end_x = posX + x_from_center;
            if (end_x >= width)
                end_x = width - 1;
            int pixel_offset = start_x + _y * width;
            for (int _x = start_x; _x <= end_x; _x++) {

                pixels[pixel_offset++] = colour;
            }

        }

    }


    public DrawingArea() {
    }

    public static int pixels[];
    public static int width;
    public static int height;
    public static int viewport_top;
    public static int viewport_bottom;
    public static int viewport_left;
    public static int viewport_right;
    public static int viewportRx;
    public static int viewport_center_x;
    public static int viewport_center_y;

}
