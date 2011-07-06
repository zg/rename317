package rs2;


import java.awt.*;
import java.awt.image.PixelGrabber;

public class RgbImage extends Graphics2D {

    public RgbImage(int i, int j)
    {
        myPixels = new int[i * j];
        myWidth = w2 = i;
        myHeight = h2 = j;
        xDrawOffset = yDrawOffset = 0;
    }

    public RgbImage(String filename)//clienthaxs own code :P
    {

        javax.swing.ImageIcon icon =new javax.swing.ImageIcon (filename);
        icon.getIconHeight();
        icon.getIconWidth();
        //System.out.println(icon.getIconHeight()+" "+icon.getIconWidth());
        try
        {
            Image image = Toolkit.getDefaultToolkit().createImage(FileOperations.ReadFile(filename));
            myWidth = icon.getIconWidth();
            myHeight = icon.getIconHeight();
            w2 = myWidth;
            h2 = myHeight;
            xDrawOffset = 0;
            yDrawOffset = 0;
            myPixels = new int[myWidth * myHeight];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, myWidth, myHeight, myPixels, 0, myWidth);
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
            Image image = Toolkit.getDefaultToolkit().getImage("cache/title.png");
            //Image image = Toolkit.getDefaultToolkit().createImage(abyte0);
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
        Packet stream = new Packet(jagexArchive.getDataForName(s + ".dat"));
        Packet stream_1 = new Packet(jagexArchive.getDataForName("index.dat"));
        stream_1.pos = stream.g2();
        w2 = stream_1.g2();
        h2 = stream_1.g2();
        int j = stream_1.g1();
        int ai[] = new int[j];
        for(int k = 0; k < j - 1; k++)
        {
            ai[k + 1] = stream_1.g3();
            if(ai[k + 1] == 0)
                ai[k + 1] = 1;
        }

        for(int l = 0; l < i; l++)
        {
            stream_1.pos += 2;
            stream.pos += stream_1.g2() * stream_1.g2();
            stream_1.pos++;
        }

        xDrawOffset = stream_1.g1();
        yDrawOffset = stream_1.g1();
        myWidth = stream_1.g2();
        myHeight = stream_1.g2();
        int i1 = stream_1.g1();
        int j1 = myWidth * myHeight;
        myPixels = new int[j1];
        if(i1 == 0)
        {
            for(int k1 = 0; k1 < j1; k1++)
                myPixels[k1] = ai[stream.g1()];

            return;
        }
        if(i1 == 1)
        {
            for(int l1 = 0; l1 < myWidth; l1++)
            {
                for(int i2 = 0; i2 < myHeight; i2++)
                    myPixels[l1 + i2 * myWidth] = ai[stream.g1()];

            }

        }
    }

    public void initDrawingArea()
    {
        setTarget(myHeight, myWidth, myPixels);
    }

    public void shiftColours(int r, int g, int b)
    {
        for(int i1 = 0; i1 < myPixels.length; i1++)
        {
            int j1 = myPixels[i1];
            if(j1 != 0)
            {
                int endR = j1 >> 16 & 0xff;
                endR += r;
                if(endR < 1)
                    endR = 1;
                else
                if(endR > 255)
                    endR = 255;
                int endG = j1 >> 8 & 0xff;
                endG += g;
                if(endG < 1)
                    endG = 1;
                else
                if(endG > 255)
                    endG = 255;
                int endB = j1 & 0xff;
                endB += b;
                if(endB < 1)
                    endB = 1;
                else
                if(endB > 255)
                    endB = 255;
                myPixels[i1] = (endR << 16) + (endG << 8) + endB;
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
        int l = i + j * width;
        int i1 = 0;
        int j1 = myHeight;
        int k1 = myWidth;
        int l1 = width - k1;
        int i2 = 0;
        if(j < topY)
        {
            int j2 = topY - j;
            j1 -= j2;
            j = topY;
            i1 += j2 * k1;
            l += j2 * width;
        }
        if(j + j1 > viewport_h)
            j1 -= (j + j1) - viewport_h;
        if(i < topX)
        {
            int k2 = topX - i;
            k1 -= k2;
            i = topX;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if(i + k1 > viewport_w)
        {
            int l2 = (i + k1) - viewport_w;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if(k1 <= 0 || j1 <= 0)
        {
        } else
        {
            method347(l, k1, j1, i2, i1, l1, myPixels, pixels);
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
        int i1 = i + j * width;
        int j1 = 0;
        int k1 = myHeight;
        int l1 = myWidth;
        int i2 = width - l1;
        int j2 = 0;
        if(j < topY)
        {
            int k2 = topY - j;
            k1 -= k2;
            j = topY;
            j1 += k2 * l1;
            i1 += k2 * width;
        }
        if(j + k1 > viewport_h)
            k1 -= (j + k1) - viewport_h;
        if(i < topX)
        {
            int l2 = topX - i;
            l1 -= l2;
            i = topX;
            j1 += l2;
            i1 += l2;
            j2 += l2;
            i2 += l2;
        }
        if(i + l1 > viewport_w)
        {
            int i3 = (i + l1) - viewport_w;
            l1 -= i3;
            j2 += i3;
            i2 += i3;
        }
        if(!(l1 <= 0 || k1 <= 0))
        {
            method351(j1, l1, pixels, myPixels, j2, k1, i2, k, i1);
        }
    }

    public void drawSprite(int i, int k)
    {
        i += xDrawOffset;
        k += yDrawOffset;
        int l = i + k * width;
        int i1 = 0;
        int j1 = myHeight;
        int k1 = myWidth;
        int l1 = width - k1;
        int i2 = 0;
        if(k < topY)
        {
            int j2 = topY - k;
            j1 -= j2;
            k = topY;
            i1 += j2 * k1;
            l += j2 * width;
        }
        if(k + j1 > viewport_h)
            j1 -= (k + j1) - viewport_h;
        if(i < topX)
        {
            int k2 = topX - i;
            k1 -= k2;
            i = topX;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if(i + k1 > viewport_w)
        {
            int l2 = (i + k1) - viewport_w;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if(!(k1 <= 0 || j1 <= 0))
        {
            method349(pixels, myPixels, i1, l, k1, j1, l1, i2);
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
            int baseOffset = some_x + some_y * Graphics2D.width;
            for(some_y = 0; some_y < height; some_y++)
            {
                int targetLineOffset = ai1[some_y];
                int targetOffset = baseOffset + targetLineOffset;
                int __x = xSomething + __pxoffset * targetLineOffset;
                int __y = k3 - __pyoffset * targetLineOffset;
                for(some_x = -widthmap[some_y]; some_x < 0; some_x++)
                {
                    pixels[targetOffset++] = myPixels[(__x >> 16) + (__y >> 16) * myWidth];
                    __x += __pxoffset;
                    __y -= __pyoffset;
                }

                xSomething += __pyoffset;
                k3 += __pxoffset;
                baseOffset += Graphics2D.width;
            }

        }
        catch(Exception _ex)
        {
        }
    }
    public void rotate(int center_x, int center_y, int width, int height, int angle, int y, int x)
    {
        //all of the following were parameters
        int hingesize = 256;
        //all of the previous were parameters
        try
        {
            int i2 = -width / 2;
            int j2 = -height / 2;
            int __pyoffset = (int)(Math.sin((double)angle / 326.11000000000001D) * 65536D);
            int __pxoffset = (int)(Math.cos((double)angle / 326.11000000000001D) * 65536D);
            __pyoffset = __pyoffset * hingesize >> 8;
            __pxoffset = __pxoffset * hingesize >> 8;
            int i3 = (center_x << 16) + (j2 * __pyoffset + i2 * __pxoffset);
            int j3 = (center_y << 16) + (j2 * __pxoffset - i2 * __pyoffset);
            int off = x + y * Graphics2D.width;
            for(y = 0; y < height; y++)
            {
                int l3 = off;
                int __x = i3;
                int __y = j3;
                for(x = -width; x < 0; x++)
                {
                    int k4 = myPixels[(__x >> 16) + (__y >> 16) * myWidth];
                    if(k4 != 0)
                        pixels[l3++] = k4;
                    else
                        l3++;
                    __x += __pxoffset;
                    __y -= __pyoffset;
                }

                i3 += __pyoffset;
                j3 += __pxoffset;
                off += Graphics2D.width;
            }

        }
        catch(Exception _ex)
        {
        }
    }
    public void rotate(int y,
                          double d, int x)
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
            int off = x + y * Graphics2D.width;
            for(y = 0; y < height; y++)
            {
                int l3 = off;
                int __x = i3;
                int __y = j3;
                for(x = -width; x < 0; x++)
                {
                    int k4 = myPixels[(__x >> 16) + (__y >> 16) * myWidth];
                    if(k4 != 0)
                        pixels[l3++] = k4;
                    else
                        l3++;
                    __x += __pxoffset;
                    __y -= __pyoffset;
                }

                i3 += __pyoffset;
                j3 += __pxoffset;
                off += Graphics2D.width;
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
        int k = j + i * width;
        int l = 0;
        int i1 = myHeight;
        int j1 = myWidth;
        int k1 = width - j1;
        int l1 = 0;
        if(i < topY)
        {
            int i2 = topY - i;
            i1 -= i2;
            i = topY;
            l += i2 * j1;
            k += i2 * width;
        }
        if(i + i1 > viewport_h)
            i1 -= (i + i1) - viewport_h;
        if(j < topX)
        {
            int j2 = topX - j;
            j1 -= j2;
            j = topX;
            l += j2;
            k += j2;
            l1 += j2;
            k1 += j2;
        }
        if(j + j1 > viewport_w)
        {
            int k2 = (j + j1) - viewport_w;
            j1 -= k2;
            l1 += k2;
            k1 += k2;
        }
        if(!(j1 <= 0 || i1 <= 0))
        {
            method355(myPixels, j1, indexedImage.imgPixels, i1, pixels, 0, k1, k, l1, l);
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

    	public void drawSpriteWithDimens(int xPos, int yPos, int vertSize) {
		xPos += xDrawOffset;
		yPos += yDrawOffset;
		int l = xPos + yPos * width;
		int i1 = 0;
		int horizSize = myWidth;
		int l1 = width - horizSize;
		int i2 = 0;
		if (yPos < topY) {
			int j2 = topY - yPos;
			vertSize -= j2;
			yPos = topY;
			i1 += j2 * horizSize;
			l += j2 * width;
		}
		if (yPos + vertSize > viewport_h)
			vertSize -= (yPos + vertSize) - viewport_h;
		if (xPos < topX) {
			int k2 = topX - xPos;
			horizSize -= k2;
			xPos = topX;
			i1 += k2;
			l += k2;
			i2 += k2;
			l1 += k2;
		}
		if (xPos + horizSize > viewport_h) {
			int l2 = (xPos + horizSize) - viewport_h;
			horizSize -= l2;
			i2 += l2;
			l1 += l2;
		}
		if (!(horizSize <= 0 || vertSize <= 0)) {
			method349(pixels, myPixels, i1, l, horizSize, vertSize,
					l1, i2);
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
