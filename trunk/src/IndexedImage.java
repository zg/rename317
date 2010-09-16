// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class IndexedImage extends DrawingArea {

    public IndexedImage(JagexArchive jagexArchive, String s, int i)
    {
        Stream stream = new Stream(jagexArchive.getDataForName(s + ".dat"));
        Stream stream_1 = new Stream(jagexArchive.getDataForName("index.dat"));
        stream_1.currentOffset = stream.readUnsignedWord();
        libWidth = stream_1.readUnsignedWord();
        libHeight = stream_1.readUnsignedWord();
        int j = stream_1.readUnsignedByte();
        palette = new int[j];
        for(int k = 0; k < j - 1; k++)
            palette[k + 1] = stream_1.read3Bytes();

        for(int l = 0; l < i; l++)
        {
            stream_1.currentOffset += 2;
            stream.currentOffset += stream_1.readUnsignedWord() * stream_1.readUnsignedWord();
            stream_1.currentOffset++;
        }

        xDrawOffset = stream_1.readUnsignedByte();
        yDrawOffset = stream_1.readUnsignedByte();
        imgWidth = stream_1.readUnsignedWord();
        imgHeight = stream_1.readUnsignedWord();
        int imgType = stream_1.readUnsignedByte();
        int j1 = imgWidth * imgHeight;
        imgPixels = new byte[j1];
        if(imgType == 0)
        {
            for(int k1 = 0; k1 < j1; k1++)
                imgPixels[k1] = stream.readSignedByte();

            return;
        }
        if(imgType == 1)
        {
            for(int l1 = 0; l1 < imgWidth; l1++)
            {
                for(int i2 = 0; i2 < imgHeight; i2++)
                    imgPixels[l1 + i2 * imgWidth] = stream.readSignedByte();

            }

        }
    }

    public void resizeToHalfLibSize()
    {
        libWidth /= 2;
        libHeight /= 2;
        byte abyte0[] = new byte[libWidth * libHeight];
        int i = 0;
        for(int j = 0; j < imgHeight; j++)
        {
            for(int k = 0; k < imgWidth; k++)
                abyte0[(k + xDrawOffset >> 1) + (j + yDrawOffset >> 1) * libWidth] = imgPixels[i++];

        }

        imgPixels = abyte0;
        imgWidth = libWidth;
        imgHeight = libHeight;
        xDrawOffset = 0;
            yDrawOffset = 0;
    }

    public void resizeToLibSize()
    {
        if(imgWidth == libWidth && imgHeight == libHeight)
            return;
        byte abyte0[] = new byte[libWidth * libHeight];
        int i = 0;
        for(int j = 0; j < imgHeight; j++)
        {
            for(int k = 0; k < imgWidth; k++)
                abyte0[k + xDrawOffset + (j + yDrawOffset) * libWidth] = imgPixels[i++];

        }

        imgPixels = abyte0;
        imgWidth = libWidth;
        imgHeight = libHeight;
        xDrawOffset = 0;
        yDrawOffset = 0;
    }

    public void flipHorizontal()
    {
        byte abyte0[] = new byte[imgWidth * imgHeight];
        int j = 0;
        for(int k = 0; k < imgHeight; k++)
        {
            for(int l = imgWidth - 1; l >= 0; l--)
                abyte0[j++] = imgPixels[l + k * imgWidth];

        }

        imgPixels = abyte0;
        xDrawOffset = libWidth - imgWidth - xDrawOffset;
    }

    public void flipVertical()
    {
        byte abyte0[] = new byte[imgWidth * imgHeight];
        int i = 0;
        for(int j = imgHeight - 1; j >= 0; j--)
        {
            for(int k = 0; k < imgWidth; k++)
                abyte0[i++] = imgPixels[k + j * imgWidth];

        }

        imgPixels = abyte0;
        yDrawOffset = libHeight - imgHeight - yDrawOffset;
    }

    public void shiftColours(int i, int j, int k)
    {
        for(int i1 = 0; i1 < palette.length; i1++)
        {
            int j1 = palette[i1] >> 16 & 0xff;
            j1 += i;
            if(j1 < 0)
                j1 = 0;
            else
            if(j1 > 255)
                j1 = 255;
            int k1 = palette[i1] >> 8 & 0xff;
            k1 += j;
            if(k1 < 0)
                k1 = 0;
            else
            if(k1 > 255)
                k1 = 255;
            int l1 = palette[i1] & 0xff;
            l1 += k;
            if(l1 < 0)
                l1 = 0;
            else
            if(l1 > 255)
                l1 = 255;
            palette[i1] = (j1 << 16) + (k1 << 8) + l1;
        }
    }

    public void drawImage(int x, int y)
    {
        x += xDrawOffset;
        y += yDrawOffset;
        int l = x + y * DrawingArea.width;
        int i1 = 0;
        int j1 = imgHeight;
        int k1 = imgWidth;
        int l1 = DrawingArea.width - k1;
        int i2 = 0;
        if(y < DrawingArea.topY)
        {
            int j2 = DrawingArea.topY - y;
            j1 -= j2;
            y = DrawingArea.topY;
            i1 += j2 * k1;
            l += j2 * DrawingArea.width;
        }
        if(y + j1 > DrawingArea.viewport_h)
            j1 -= (y + j1) - DrawingArea.viewport_h;
        if(x < DrawingArea.topX)
        {
            int k2 = DrawingArea.topX - x;
            k1 -= k2;
            x = DrawingArea.topX;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if(x + k1 > DrawingArea.viewport_w)
        {
            int l2 = (x + k1) - DrawingArea.viewport_w;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if(!(k1 <= 0 || j1 <= 0))
        {
            arraycopy(j1, DrawingArea.pixels, imgPixels, l1, l, k1, i1, palette, i2);
        }
    }

    private void arraycopy(int i, int ai[], byte abyte0[], int j, int k, int l,
                           int i1, int ai1[], int j1)
    {
        int k1 = -(l >> 2);
        l = -(l & 3);
        for(int l1 = -i; l1 < 0; l1++)
        {
            for(int i2 = k1; i2 < 0; i2++)
            {
                byte byte1 = abyte0[i1++];
                if(byte1 != 0)
                    ai[k++] = ai1[byte1 & 0xff];
                else
                    k++;
                byte1 = abyte0[i1++];
                if(byte1 != 0)
                    ai[k++] = ai1[byte1 & 0xff];
                else
                    k++;
                byte1 = abyte0[i1++];
                if(byte1 != 0)
                    ai[k++] = ai1[byte1 & 0xff];
                else
                    k++;
                byte1 = abyte0[i1++];
                if(byte1 != 0)
                    ai[k++] = ai1[byte1 & 0xff];
                else
                    k++;
            }

            for(int j2 = l; j2 < 0; j2++)
            {
                byte byte2 = abyte0[i1++];
                if(byte2 != 0)
                    ai[k++] = ai1[byte2 & 0xff];
                else
                    k++;
            }

            k += j;
            i1 += j1;
        }

    }

    public byte imgPixels[];
    public final int[] palette;
    public int imgWidth;
    public int imgHeight;
    public int xDrawOffset;
    public int yDrawOffset;
    public int libWidth;
    private int libHeight;
}
