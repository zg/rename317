// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;
import java.awt.image.PixelGrabber;

public final class RgbImage extends DrawingArea {

    public RgbImage(int i, int j)
    {
        myPixels = new int[i * j];
        myWidth = w2 = i;
        myHeight = h2 = j;
        xDrawOffset = yDrawOffset = 0;
    }

    public RgbImage(byte abyte0[], Component component)
    {
        try
        {
//            Image image = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir()+"mopar.jpg");
            Image image = Toolkit.getDefaultToolkit().createImage(abyte0);
            MediaTracker mediatracker = new MediaTracker(component);
            mediatracker.addImage(image, 0);
            mediatracker.waitForAll();
            myWidth = image.getWidth(component);
            myHeight = image.getHeight(component);
            w2 = myWidth;
            h2 = myHeight;
            xDrawOffset = 0;
            yDrawOffset = 0;
            myPixels = new int[myWidth * myHeight];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, myWidth, myHeight, myPixels, 0, myWidth);
            pixelgrabber.grabPixels();
        }
        catch(Exception _ex)
        {
            System.out.println("Error converting jpg");
        }
    }

    public RgbImage(JagexArchive jagexArchive, String s, int i)
    {
        Stream stream = new Stream(jagexArchive.getDataForName(s + ".dat"));
        Stream stream_1 = new Stream(jagexArchive.getDataForName("index.dat"));
        stream_1.currentOffset = stream.readUnsignedWord();
        w2 = stream_1.readUnsignedWord();
        h2 = stream_1.readUnsignedWord();
        int j = stream_1.readUnsignedByte();
        int ai[] = new int[j];
        for(int k = 0; k < j - 1; k++)
        {
            ai[k + 1] = stream_1.read3Bytes();
            if(ai[k + 1] == 0)
                ai[k + 1] = 1;
        }

        for(int l = 0; l < i; l++)
        {
            stream_1.currentOffset += 2;
            stream.currentOffset += stream_1.readUnsignedWord() * stream_1.readUnsignedWord();
            stream_1.currentOffset++;
        }

        xDrawOffset = stream_1.readUnsignedByte();
        yDrawOffset = stream_1.readUnsignedByte();
        myWidth = stream_1.readUnsignedWord();
        myHeight = stream_1.readUnsignedWord();
        int i1 = stream_1.readUnsignedByte();
        int j1 = myWidth * myHeight;
        myPixels = new int[j1];
        if(i1 == 0)
        {
            for(int k1 = 0; k1 < j1; k1++)
                myPixels[k1] = ai[stream.readUnsignedByte()];

            return;
        }
        if(i1 == 1)
        {
            for(int l1 = 0; l1 < myWidth; l1++)
            {
                for(int i2 = 0; i2 < myHeight; i2++)
                    myPixels[l1 + i2 * myWidth] = ai[stream.readUnsignedByte()];

            }

        }
    }

    public void initDrawingArea()
    {
        DrawingArea.initDrawingArea(myHeight, myWidth, myPixels);
    }

    public void method344(int i, int j, int k)
    {
        for(int i1 = 0; i1 < myPixels.length; i1++)
        {
            int j1 = myPixels[i1];
            if(j1 != 0)
            {
                int k1 = j1 >> 16 & 0xff;
                k1 += i;
                if(k1 < 1)
                    k1 = 1;
                else
                if(k1 > 255)
                    k1 = 255;
                int l1 = j1 >> 8 & 0xff;
                l1 += j;
                if(l1 < 1)
                    l1 = 1;
                else
                if(l1 > 255)
                    l1 = 255;
                int i2 = j1 & 0xff;
                i2 += k;
                if(i2 < 1)
                    i2 = 1;
                else
                if(i2 > 255)
                    i2 = 255;
                myPixels[i1] = (k1 << 16) + (l1 << 8) + i2;
            }
        }

    }

    public void method345()
    {
        int ai[] = new int[w2 * h2];
        for(int j = 0; j < myHeight; j++)
        {
            System.arraycopy(myPixels, j * myWidth, ai, j + yDrawOffset * w2 + xDrawOffset, myWidth);
        }

        myPixels = ai;
        myWidth = w2;
        myHeight = h2;
        xDrawOffset = 0;
        yDrawOffset = 0;
    }

    public void method346(int i, int j)
    {
        i += xDrawOffset;
        j += yDrawOffset;
        int l = i + j * DrawingArea.width;
        int i1 = 0;
        int j1 = myHeight;
        int k1 = myWidth;
        int l1 = DrawingArea.width - k1;
        int i2 = 0;
        if(j < DrawingArea.topY)
        {
            int j2 = DrawingArea.topY - j;
            j1 -= j2;
            j = DrawingArea.topY;
            i1 += j2 * k1;
            l += j2 * DrawingArea.width;
        }
        if(j + j1 > DrawingArea.bottomY)
            j1 -= (j + j1) - DrawingArea.bottomY;
        if(i < DrawingArea.topX)
        {
            int k2 = DrawingArea.topX - i;
            k1 -= k2;
            i = DrawingArea.topX;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if(i + k1 > DrawingArea.bottomX)
        {
            int l2 = (i + k1) - DrawingArea.bottomX;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if(k1 <= 0 || j1 <= 0)
        {
        } else
        {
            method347(l, k1, j1, i2, i1, l1, myPixels, DrawingArea.pixels);
        }
    }

    private void method347(int i, int j, int k, int l, int i1, int k1,
                           int ai[], int ai1[])
    {
        int l1 = -(j >> 2);
        j = -(j & 3);
        for(int i2 = -k; i2 < 0; i2++)
        {
            for(int j2 = l1; j2 < 0; j2++)
            {
                ai1[i++] = ai[i1++];
                ai1[i++] = ai[i1++];
                ai1[i++] = ai[i1++];
                ai1[i++] = ai[i1++];
            }

            for(int k2 = j; k2 < 0; k2++)
                ai1[i++] = ai[i1++];

            i += k1;
            i1 += l;
        }
    }

    public void drawSprite1(int i, int j)
    {
        int k = 128;//was parameter
        i += xDrawOffset;
        j += yDrawOffset;
        int i1 = i + j * DrawingArea.width;
        int j1 = 0;
        int k1 = myHeight;
        int l1 = myWidth;
        int i2 = DrawingArea.width - l1;
        int j2 = 0;
        if(j < DrawingArea.topY)
        {
            int k2 = DrawingArea.topY - j;
            k1 -= k2;
            j = DrawingArea.topY;
            j1 += k2 * l1;
            i1 += k2 * DrawingArea.width;
        }
        if(j + k1 > DrawingArea.bottomY)
            k1 -= (j + k1) - DrawingArea.bottomY;
        if(i < DrawingArea.topX)
        {
            int l2 = DrawingArea.topX - i;
            l1 -= l2;
            i = DrawingArea.topX;
            j1 += l2;
            i1 += l2;
            j2 += l2;
            i2 += l2;
        }
        if(i + l1 > DrawingArea.bottomX)
        {
            int i3 = (i + l1) - DrawingArea.bottomX;
            l1 -= i3;
            j2 += i3;
            i2 += i3;
        }
        if(!(l1 <= 0 || k1 <= 0))
        {
            method351(j1, l1, DrawingArea.pixels, myPixels, j2, k1, i2, k, i1);
        }
    }

    public void drawSprite(int i, int k)
    {
        i += xDrawOffset;
        k += yDrawOffset;
        int l = i + k * DrawingArea.width;
        int i1 = 0;
        int j1 = myHeight;
        int k1 = myWidth;
        int l1 = DrawingArea.width - k1;
        int i2 = 0;
        if(k < DrawingArea.topY)
        {
            int j2 = DrawingArea.topY - k;
            j1 -= j2;
            k = DrawingArea.topY;
            i1 += j2 * k1;
            l += j2 * DrawingArea.width;
        }
        if(k + j1 > DrawingArea.bottomY)
            j1 -= (k + j1) - DrawingArea.bottomY;
        if(i < DrawingArea.topX)
        {
            int k2 = DrawingArea.topX - i;
            k1 -= k2;
            i = DrawingArea.topX;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if(i + k1 > DrawingArea.bottomX)
        {
            int l2 = (i + k1) - DrawingArea.bottomX;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if(!(k1 <= 0 || j1 <= 0))
        {
            method349(DrawingArea.pixels, myPixels, i1, l, k1, j1, l1, i2);
        }
    }

    private void method349(int ai[], int ai1[], int j, int k, int l, int i1,
                           int j1, int k1)
    {
        int i;//was parameter
        int l1 = -(l >> 2);
        l = -(l & 3);
        for(int i2 = -i1; i2 < 0; i2++)
        {
            for(int j2 = l1; j2 < 0; j2++)
            {
                i = ai1[j++];
                if(i != 0)
                    ai[k++] = i;
                else
                    k++;
                i = ai1[j++];
                if(i != 0)
                    ai[k++] = i;
                else
                    k++;
                i = ai1[j++];
                if(i != 0)
                    ai[k++] = i;
                else
                    k++;
                i = ai1[j++];
                if(i != 0)
                    ai[k++] = i;
                else
                    k++;
            }

            for(int k2 = l; k2 < 0; k2++)
            {
                i = ai1[j++];
                if(i != 0)
                    ai[k++] = i;
                else
                    k++;
            }

            k += j1;
            j += k1;
        }

    }

    private void method351(int i, int j, int ai[], int ai1[], int l, int i1,
                           int j1, int k1, int l1)
    {
        int k;//was parameter
        int j2 = 256 - k1;
        for(int k2 = -i1; k2 < 0; k2++)
        {
            for(int l2 = -j; l2 < 0; l2++)
            {
                k = ai1[i++];
                if(k != 0)
                {
                    int i3 = ai[l1];
                    ai[l1++] = ((k & 0xff00ff) * k1 + (i3 & 0xff00ff) * j2 & 0xff00ff00) + ((k & 0xff00) * k1 + (i3 & 0xff00) * j2 & 0xff0000) >> 8;
                } else
                {
                    l1++;
                }
            }

            l1 += j1;
            i += l;
        }
    }

    public void rotate(int height, int angle, int widthmap[], int hingesize, int ai1[], int center_y,
                          int j1, int k1, int width, int center_x)
    {
        try
        {
            int j2 = -width / 2;
            int k2 = -height / 2;
            int __pyoffset = (int)(Math.sin((double)angle / 326.11000000000001D) * 65536D);
            int __pxoffset = (int)(Math.cos((double)angle / 326.11000000000001D) * 65536D);
            __pyoffset = __pyoffset * hingesize >> 8;
            __pxoffset = __pxoffset * hingesize >> 8;
            int j3 = (center_x << 16) + (k2 * __pyoffset + j2 * __pxoffset);
            int k3 = (center_y << 16) + (k2 * __pxoffset - j2 * __pyoffset);
            int l3 = k1 + j1 * DrawingArea.width;
            for(j1 = 0; j1 < height; j1++)
            {
                int i4 = ai1[j1];
                int j4 = l3 + i4;
                int __x = j3 + __pxoffset * i4;
                int __y = k3 - __pyoffset * i4;
                for(k1 = -widthmap[j1]; k1 < 0; k1++)
                {
                    DrawingArea.pixels[j4++] = myPixels[(__x >> 16) + (__y >> 16) * myWidth];
                    __x += __pxoffset;
                    __y -= __pyoffset;
                }

                j3 += __pyoffset;
                k3 += __pxoffset;
                l3 += DrawingArea.width;
            }

        }
        catch(Exception _ex)
        {
        }
    }

    public void method353(int i,
                          double d, int l1)
    {
        //all of the following were parameters
        int j = 15;
        int k = 20;
        int l = 15;
        int j1 = 256;
        int k1 = 20;
        //all of the previous were parameters
        try
        {
            int i2 = -k / 2;
            int j2 = -k1 / 2;
            int k2 = (int)(Math.sin(d) * 65536D);
            int l2 = (int)(Math.cos(d) * 65536D);
            k2 = k2 * j1 >> 8;
            l2 = l2 * j1 >> 8;
            int i3 = (l << 16) + (j2 * k2 + i2 * l2);
            int j3 = (j << 16) + (j2 * l2 - i2 * k2);
            int k3 = l1 + i * DrawingArea.width;
            for(i = 0; i < k1; i++)
            {
                int l3 = k3;
                int i4 = i3;
                int j4 = j3;
                for(l1 = -k; l1 < 0; l1++)
                {
                    int k4 = myPixels[(i4 >> 16) + (j4 >> 16) * myWidth];
                    if(k4 != 0)
                        DrawingArea.pixels[l3++] = k4;
                    else
                        l3++;
                    i4 += l2;
                    j4 -= k2;
                }

                i3 += k2;
                j3 += l2;
                k3 += DrawingArea.width;
            }

        }
        catch(Exception _ex)
        {
        }
    }

    public void method354(IndexedImage indexedImage, int i, int j)
    {
        j += xDrawOffset;
        i += yDrawOffset;
        int k = j + i * DrawingArea.width;
        int l = 0;
        int i1 = myHeight;
        int j1 = myWidth;
        int k1 = DrawingArea.width - j1;
        int l1 = 0;
        if(i < DrawingArea.topY)
        {
            int i2 = DrawingArea.topY - i;
            i1 -= i2;
            i = DrawingArea.topY;
            l += i2 * j1;
            k += i2 * DrawingArea.width;
        }
        if(i + i1 > DrawingArea.bottomY)
            i1 -= (i + i1) - DrawingArea.bottomY;
        if(j < DrawingArea.topX)
        {
            int j2 = DrawingArea.topX - j;
            j1 -= j2;
            j = DrawingArea.topX;
            l += j2;
            k += j2;
            l1 += j2;
            k1 += j2;
        }
        if(j + j1 > DrawingArea.bottomX)
        {
            int k2 = (j + j1) - DrawingArea.bottomX;
            j1 -= k2;
            l1 += k2;
            k1 += k2;
        }
        if(!(j1 <= 0 || i1 <= 0))
        {
            method355(myPixels, j1, indexedImage.aByteArray1450, i1, DrawingArea.pixels, 0, k1, k, l1, l);
        }
    }

    private void method355(int ai[], int i, byte abyte0[], int j, int ai1[], int k,
                           int l, int i1, int j1, int k1)
    {
        int l1 = -(i >> 2);
        i = -(i & 3);
        for(int j2 = -j; j2 < 0; j2++)
        {
            for(int k2 = l1; k2 < 0; k2++)
            {
                k = ai[k1++];
                if(k != 0 && abyte0[i1] == 0)
                    ai1[i1++] = k;
                else
                    i1++;
                k = ai[k1++];
                if(k != 0 && abyte0[i1] == 0)
                    ai1[i1++] = k;
                else
                    i1++;
                k = ai[k1++];
                if(k != 0 && abyte0[i1] == 0)
                    ai1[i1++] = k;
                else
                    i1++;
                k = ai[k1++];
                if(k != 0 && abyte0[i1] == 0)
                    ai1[i1++] = k;
                else
                    i1++;
            }

            for(int l2 = i; l2 < 0; l2++)
            {
                k = ai[k1++];
                if(k != 0 && abyte0[i1] == 0)
                    ai1[i1++] = k;
                else
                    i1++;
            }

            i1 += l;
            k1 += j1;
        }

    }

    public int myPixels[];
    public int myWidth;
    public int myHeight;
    private int xDrawOffset;
    private int yDrawOffset;
    public int w2;
    public int h2;
}
