package rs2.media.image;


import rs2.*;

import java.awt.*;
import java.awt.image.PixelGrabber;

public class RgbImage extends DrawingArea {

    public RgbImage(int width, int height)
    {
        image_pixels = new int[width * height];
        image_width = library_width = width;
        image_height = library_height = height;
        x_offset = y_offset = 0;
    }

    public RgbImage(String filename)//clienthaxs own code :P
    {//realy bad way to do this but everyone is using this shody code of mine now GAHH
        javax.swing.ImageIcon icon =new javax.swing.ImageIcon (filename);
        try
        {
            Image image = Toolkit.getDefaultToolkit().createImage(FileOperations.ReadFile(filename));
            image_width = icon.getIconWidth();
            image_height = icon.getIconHeight();
            library_width = image_width;
            library_height = image_height;
            x_offset = 0;
            y_offset = 0;
            image_pixels = new int[image_width * image_height];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, image_width, image_height, image_pixels, 0, image_width);
            pixelgrabber.grabPixels();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public RgbImage(byte data[], Component component)
    {
        try
        {
            //Image image = Toolkit.getDefaultToolkit().getImage("cache/title.png");
            Image image = Toolkit.getDefaultToolkit().createImage(data);
            MediaTracker mediatracker = new MediaTracker(component);
            mediatracker.addImage(image, 0);
            mediatracker.waitForAll();
            image_width = image.getWidth(component);
            image_height = image.getHeight(component);
            library_width = image_width;
            library_height = image_height;
            x_offset = 0;
            y_offset = 0;
            image_pixels = new int[image_width * image_height];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, image_width, image_height, image_pixels, 0, image_width);
            pixelgrabber.grabPixels();
        }
        catch(Exception _ex)
        {
            System.out.println("Error converting jpg");
        }
    }

    public RgbImage(JagexArchive archive, String name, int id)
    {
        Packet image_data = new Packet(archive.getDataForName(name + ".dat"));
        Packet index_data = new Packet(archive.getDataForName("index.dat"));
        index_data.pos = image_data.g2();
        library_width  = index_data.g2();
        library_height = index_data.g2();
        int colour_count = index_data.g1();
        int palette[] = new int[colour_count];
        for(int _ctr = 0; _ctr < colour_count - 1; _ctr++)
        {
            palette[_ctr + 1] = index_data.g3();
            if(palette[_ctr + 1] == 0)
                palette[_ctr + 1] = 1;
        }

        for(int _ctr = 0; _ctr < id; _ctr++)
        {
            index_data.pos += 2;
            image_data.pos += index_data.g2() * index_data.g2();
            index_data.pos++;
        }

        x_offset = index_data.g1();
        y_offset = index_data.g1();
        image_width = index_data.g2();
        image_height = index_data.g2();
        int ordering = index_data.g1();
        int size = image_width * image_height;
        image_pixels = new int[size];
        if(ordering == 0)
        {
            for(int _ctr = 0; _ctr < size; _ctr++)
                image_pixels[_ctr] = palette[image_data.g1()];

            return;
        }
        if(ordering == 1)
        {
            for(int _x = 0; _x < image_width; _x++)
            {
                for(int _y = 0; _y < image_height; _y++)
                    image_pixels[_x + _y * image_width] = palette[image_data.g1()];

            }

        }
    }

    public void initDrawingArea()
    {
        setTarget(image_width, image_height, image_pixels);
    }

    public void add_rgb(int r, int g, int b)
    {
        for(int _ctr = 0; _ctr < image_pixels.length; _ctr++)
        {
            int input_rgb = image_pixels[_ctr];
            if(input_rgb != 0)
            {
                int endR = input_rgb >> 16 & 0xff;
                endR += r;
                if(endR < 1)
                    endR = 1;
                else
                if(endR > 255)
                    endR = 255;
                int endG = input_rgb >> 8 & 0xff;
                endG += g;
                if(endG < 1)
                    endG = 1;
                else
                if(endG > 255)
                    endG = 255;
                int endB = input_rgb & 0xff;
                endB += b;
                if(endB < 1)
                    endB = 1;
                else
                if(endB > 255)
                    endB = 255;
                image_pixels[_ctr] = (endR << 16) + (endG << 8) + endB;
            }
        }

    }

    public void method345()
    {
        int target_pixels[] = new int[library_width * library_height];
        for(int _y = 0; _y < image_height; _y++)
        {
            System.arraycopy(image_pixels, _y * image_width, target_pixels, _y + (y_offset * library_width) + x_offset, image_width);
        }

        image_pixels = target_pixels;
        image_width = library_width;
        image_height = library_height;
        x_offset = 0;
        y_offset = 0;
    }

    public void draw(int x, int y)
    {
        x += x_offset;
        y += y_offset;
        int line_offset_dest = x + y * width;
        int source_offset = 0;
        int line_count = image_height;
        int line_width = image_width;
        int dest_offset = width - line_width;
        int line_offset_src = 0;
        if(y < viewport_top)
        {
            int clip_height = viewport_top - y;
            line_count -= clip_height;
            y = viewport_top;
            source_offset += clip_height * line_width;
            line_offset_dest += clip_height * width;
        }
        if(y + line_count > viewport_bottom)
            line_count -= (y + line_count) - viewport_bottom;
        if(x < viewport_left)
        {
            int clip_width = viewport_left - x;
            line_width -= clip_width;
            x = viewport_left;
            source_offset += clip_width;
            line_offset_dest += clip_width;
            line_offset_src += clip_width;
            dest_offset += clip_width;
        }
        if(x + line_width > viewport_right)
        {
            int clip_width = (x + line_width) - viewport_right;
            line_width -= clip_width;
            line_offset_src += clip_width;
            dest_offset += clip_width;
        }
        if(line_width <= 0 || line_count <= 0)
        {
        } else
        {
            block_copy(image_pixels, source_offset, line_offset_src, pixels, line_offset_dest, dest_offset, line_width, line_count);
        }
    }

    public void draw(int x, int y, int alpha)
    {
        x += x_offset;
        y += y_offset;
        int dest_offset = x + y * width;
        int source_offset = 0;
        int line_count = image_height;
        int line_width = image_width;
        int line_offset_dest = width - line_width;
        int line_offset_src = 0;
        if(y < viewport_top)
        {
            int clip_height = viewport_top - y;
            line_count -= clip_height;
            y = viewport_top;
            source_offset += clip_height * line_width;
            dest_offset += clip_height * width;
        }
        if(y + line_count > viewport_bottom)
            line_count -= (y + line_count) - viewport_bottom;
        if(x < viewport_left)
        {
            int clip_width = viewport_left - x;
            line_width -= clip_width;
            x = viewport_left;
            source_offset += clip_width;
            dest_offset += clip_width;
            line_offset_src += clip_width;
            line_offset_dest += clip_width;
        }
        if(x + line_width > viewport_right)
        {
            int clip_width = (x + line_width) - viewport_right;
            line_width -= clip_width;
            line_offset_src += clip_width;
            line_offset_dest += clip_width;
        }
        if(!(line_width <= 0 || line_count <= 0))
        {
            block_copy_alpha(image_pixels, source_offset, line_offset_src, pixels, dest_offset, line_offset_dest, line_width, line_count, alpha);
        }
    }

    public void draw(int x, int y, IndexedImage mask)
    {
        x += x_offset;
        y += y_offset;
        int dest_ptr = x + y * width;
        int source_ptr = 0;
        int line_count = image_height;
        int line_width = image_width;
        int line_offset_dest = width - line_width;
        int line_offset_src = 0;
        if(y < viewport_top)
        {
            int clip_height = viewport_top - y;
            line_count -= clip_height;
            y = viewport_top;
            source_ptr += clip_height * line_width;
            dest_ptr += clip_height * width;
        }
        if(y + line_count > viewport_bottom)
            line_count -= (y + line_count) - viewport_bottom;
        if(x < viewport_left)
        {
            int clip_width = viewport_left - x;
            line_width -= clip_width;
            x = viewport_left;
            source_ptr += clip_width;
            dest_ptr += clip_width;
            line_offset_src += clip_width;
            line_offset_dest += clip_width;
        }
        if(x + line_width > viewport_right)
        {
            int clip_width = (x + line_width) - viewport_right;
            line_width -= clip_width;
            line_offset_src += clip_width;
            line_offset_dest += clip_width;
        }
        if(!(line_width <= 0 || line_count <= 0))
        {
            block_copy_mask(image_pixels, source_ptr, line_offset_src, pixels, dest_ptr, line_offset_dest, line_width, line_count, mask.imgPixels);
        }
    }

    public void draw_trans(int x, int y)
    {
        x += x_offset;
        y += y_offset;
        int dest_offset = x + y * width;
        int source_offset = 0;
        int line_count = image_height;
        int line_width = image_width;
        int line_offset_dest = width - line_width;
        int line_offset_source = 0;
        if(y < viewport_top)
        {
            int clip_height = viewport_top - y;
            line_count -= clip_height;
            y = viewport_top;
            source_offset += clip_height * line_width;
            dest_offset += clip_height * width;
        }
        if(y + line_count > viewport_bottom)
            line_count -= (y + line_count) - viewport_bottom;
        if(x < viewport_left)
        {
            int clip_width = viewport_left - x;
            line_width -= clip_width;
            x = viewport_left;
            source_offset += clip_width;
            dest_offset += clip_width;
            line_offset_source += clip_width;
            line_offset_dest += clip_width;
        }
        if(x + line_width > viewport_right)
        {
            int clip_width = (x + line_width) - viewport_right;
            line_width -= clip_width;
            line_offset_source += clip_width;
            line_offset_dest += clip_width;
        }
        if(!(line_width <= 0 || line_count <= 0))
        {
            block_copy_trans(image_pixels, source_offset, line_offset_source, pixels, dest_offset, line_offset_dest, line_width, line_count);
        }
    }

    public void draw_height(int x, int y, int line_count) {
        x += x_offset;
        y += y_offset;
        int dest_offset = x + y * width;
        int source_offset = 0;
        int line_width = image_width;
        int line_offset_dest = width - line_width;
        int line_offset_source = 0;
        if (y < viewport_top) {
            int clip_height = viewport_top - y;
            line_count -= clip_height;
            y = viewport_top;
            source_offset += clip_height * line_width;
            dest_offset += clip_height * width;
        }
        if (y + line_count > viewport_bottom)
            line_count -= (y + line_count) - viewport_bottom;
        if (x < viewport_left) {
            int clip_width = viewport_left - x;
            line_width -= clip_width;
            x = viewport_left;
            source_offset += clip_width;
            dest_offset += clip_width;
            line_offset_source += clip_width;
            line_offset_dest += clip_width;
        }
        if (x + line_width > viewport_bottom) {
            int clip_width = (x + line_width) - viewport_bottom;
            line_width -= clip_width;
            line_offset_source += clip_width;
            line_offset_dest += clip_width;
        }
        if (!(line_width <= 0 || line_count <= 0)) {
            block_copy_trans(image_pixels, source_offset, line_offset_source, pixels, dest_offset, line_offset_dest, line_width, line_count
            );
        }
    }

    private void block_copy(int source[], int source_ptr, int source_block_length, int dest[], int dest_ptr, int dest_block_length, int copy_length, int count)
    {
        int num_blocks = copy_length >> 2; //Divide by four
        copy_length = copy_length & 3;
        for(int _ctr1 = 0; _ctr1 < count; _ctr1++)
        {
            for(int _ctr = 0; _ctr < num_blocks; _ctr++)
            {
                dest[dest_ptr++] = source[source_ptr++];
                dest[dest_ptr++] = source[source_ptr++];
                dest[dest_ptr++] = source[source_ptr++];
                dest[dest_ptr++] = source[source_ptr++];
            }

            for(int _ctr = 0; _ctr < copy_length; _ctr++)
                dest[dest_ptr++] = source[source_ptr++];

            dest_ptr   += dest_block_length;
            source_ptr += source_block_length;
        }
    }

    private void block_copy_alpha(int source[], int source_ptr, int source_block_length, int dest[], int dest_ptr, int dest_block_length, int copy_length, int count,
                                  int alpha)
    {
        int source_value;//was parameter
        int dest_alpha = 256 - alpha;
        for(int _ctr1 = 0; _ctr1 < count; _ctr1++)
        {
            for(int _ctr = 0; _ctr < copy_length; _ctr++)
            {
                source_value = source[source_ptr++];
                if(source_value != 0)
                {
                    int dest_value = dest[dest_ptr];
                    dest[dest_ptr++] = ((source_value & 0xff00ff) * alpha + (dest_value & 0xff00ff) * dest_alpha & 0xff00ff00) + ((source_value & 0xff00) * alpha + (dest_value & 0xff00) * dest_alpha & 0xff0000) >> 8;
                } else
                {
                    dest_ptr++;
                }
            }

            dest_ptr += dest_block_length;
            source_ptr += source_block_length;
        }
    }

    private void block_copy_trans(int source[], int source_ptr, int source_block_length, int dest[], int dest_ptr, int dest_block_length, int copy_length, int count)
    {
        int value;//was parameter
        int num_blocks = copy_length >> 2;
        copy_length = copy_length & 3;
        for(int i2 = 0; i2 < count; i2++)
        {
            for(int _ctr = 0; _ctr < num_blocks; _ctr++)
            {
                value = source[source_ptr++];
                if(value != 0)
                    dest[dest_ptr++] = value;
                else
                    dest_ptr++;
                value = source[source_ptr++];
                if(value != 0)
                    dest[dest_ptr++] = value;
                else
                    dest_ptr++;
                value = source[source_ptr++];
                if(value != 0)
                    dest[dest_ptr++] = value;
                else
                    dest_ptr++;
                value = source[source_ptr++];
                if(value != 0)
                    dest[dest_ptr++] = value;
                else
                    dest_ptr++;
            }

            for(int _ctr = 0; _ctr < copy_length; _ctr++)
            {
                value = source[source_ptr++];
                if(value != 0)
                    dest[dest_ptr++] = value;
                else
                    dest_ptr++;
            }

            dest_ptr += dest_block_length;
            source_ptr += source_block_length;
        }

    }

    private void block_copy_mask(int src[], int source_ptr, int source_block_length, int dest[], int dest_ptr, int dest_block_length, int copy_length, int count, byte mask[])
    {
        int num_blocks = copy_length >> 2;
        copy_length = copy_length & 3;
        for(int block_ctr = 0; block_ctr < count; block_ctr++)
        {
            int value;
            for(int _ctr = 0; _ctr < num_blocks; _ctr++)
            {
                value = src[source_ptr++];
                if(value != 0 && mask[dest_ptr] == 0)
                    dest[dest_ptr++] = value;
                else
                    dest_ptr++;
                value = src[source_ptr++];
                if(value != 0 && mask[dest_ptr] == 0)
                    dest[dest_ptr++] = value;
                else
                    dest_ptr++;
                value = src[source_ptr++];
                if(value != 0 && mask[dest_ptr] == 0)
                    dest[dest_ptr++] = value;
                else
                    dest_ptr++;
                value = src[source_ptr++];
                if(value != 0 && mask[dest_ptr] == 0)
                    dest[dest_ptr++] = value;
                else
                    dest_ptr++;
            }

            for(int _ctr = copy_length; _ctr < 0; _ctr++)
            {
                value = src[source_ptr++];
                if(value != 0 && mask[dest_ptr] == 0)
                    dest[dest_ptr++] = value;
                else
                    dest_ptr++;
            }

            dest_ptr += dest_block_length;
            source_ptr += source_block_length;
        }

    }


    public void rotate(int center_x, int center_y, int width, int height, int angle, int widthmap[], int hingesize, int ai1[], int some_y, int some_x)
    {
        try
        {
            int negCenterX = -width / 2;
            int negCenterY = -height / 2;
            int __pyoffset = (int)(Math.sin((double)angle / 326.11000000000001D) * 65536D);
            int __pxoffset = (int)(Math.cos((double)angle / 326.11000000000001D) * 65536D);
            __pyoffset = __pyoffset * hingesize >> 8;
            __pxoffset = __pxoffset * hingesize >> 8;
            int xSomething = (center_x << 16) + (negCenterY * __pyoffset + negCenterX * __pxoffset);
            int k3 = (center_y << 16) + (negCenterY * __pxoffset - negCenterX * __pyoffset);
            int baseOffset = some_x + some_y * DrawingArea.width;
            for(some_y = 0; some_y < height; some_y++)
            {
                int targetLineOffset = ai1[some_y];
                int targetOffset = baseOffset + targetLineOffset;
                int __x = xSomething + __pxoffset * targetLineOffset;
                int __y = k3 - __pyoffset * targetLineOffset;
                for(some_x = -widthmap[some_y]; some_x < 0; some_x++)
                {
                    pixels[targetOffset++] = image_pixels[(__x >> 16) + (__y >> 16) * image_width];
                    __x += __pxoffset;
                    __y -= __pyoffset;
                }

                xSomething += __pyoffset;
                k3 += __pxoffset;
                baseOffset += DrawingArea.width;
            }

        }
        catch(Exception _ex)
        {
        }
    }
    public void rotate(int center_x, int center_y, int width, int height, int angle, int y, int x, int hypotenuse)
    {
        //all of the following were parameters
        //all of the previous were parameters
        try
        {
            int i2 = -width / 2;
            int j2 = -height / 2;
            int sine = (int)(Math.sin((double)angle / 326.11000000000001D) * 65536D);
            int cosine = (int)(Math.cos((double)angle / 326.11000000000001D) * 65536D);
            sine = sine * hypotenuse >> 8;
            cosine = cosine * hypotenuse >> 8;
            int sine_2 = (center_x << 16) + (j2 * sine   + i2 * cosine);
            int cosine_2 = (center_y << 16) + (j2 * cosine - i2 * sine);
            int off = x + y * DrawingArea.width;
            for(y = 0; y < height; y++)
            {
                int dest_offset = off;
                int __x = sine_2;
                int __y = cosine_2;
                for(x = -width; x < 0; x++)
                {
                    int value = image_pixels[(__x >> 16) + (__y >> 16) * image_width];
                    if(value != 0)
                        pixels[dest_offset++] = value;
                    else
                        dest_offset++;
                    __x += cosine;
                    __y -= sine;
                }

                sine_2 += sine;
                cosine_2 += cosine;
                off += DrawingArea.width;
            }

        }
        catch(Exception _ex)
        {
        }
    }
    public void rotate(int y, double d, int x)
    {
        //all of the following were parameters
        int center_y = 15;
        int width = 20;
        int center_x = 15;
        int hingesize = 256;
        int height = 20;
        //all of the previous were parameters
        try
        {
            int i2 = -width / 2;
            int j2 = -height / 2;
            int __pyoffset = (int)(Math.sin(d) * 65536D);
            int __pxoffset = (int)(Math.cos(d) * 65536D);
            __pyoffset = __pyoffset * hingesize >> 8;
            __pxoffset = __pxoffset * hingesize >> 8;
            int i3 = (center_x << 16) + (j2 * __pyoffset + i2 * __pxoffset);
            int j3 = (center_y << 16) + (j2 * __pxoffset - i2 * __pyoffset);
            int off = x + y * DrawingArea.width;
            for(y = 0; y < height; y++)
            {
                int l3 = off;
                int __x = i3;
                int __y = j3;
                for(x = -width; x < 0; x++)
                {
                    int k4 = image_pixels[(__x >> 16) + (__y >> 16) * image_width];
                    if(k4 != 0)
                        pixels[l3++] = k4;
                    else
                        l3++;
                    __x += __pxoffset;
                    __y -= __pyoffset;
                }

                i3 += __pyoffset;
                j3 += __pxoffset;
                off += DrawingArea.width;
            }

        }
        catch(Exception _ex)
        {
        }
    }

    public int image_pixels[];
    public int image_width;
    public int image_height;
    private int x_offset;
    private int y_offset;
    public int library_width;
    public int library_height;
}
