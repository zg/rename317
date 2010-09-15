// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.util.Random;

public final class RSFont extends DrawingArea {

    public RSFont(boolean flag, String s, JagexArchive jagexArchive)
    {
        glyphPixels = new byte[256][];
        glyphWidth = new int[256];
        glyphHeight = new int[256];
        horizontalKerning = new int[256];
        verticalKerning = new int[256];
        rsb = new int[256];
        aRandom1498 = new Random();
        isStrikethrough = false;
        Stream data = new Stream(jagexArchive.getDataForName(s + ".dat"));
        Stream index = new Stream(jagexArchive.getDataForName("index.dat"));
        index.currentOffset = data.readUnsignedWord() + 4;
        int k = index.readUnsignedByte();
        if(k > 0)
            index.currentOffset += 3 * (k - 1);
        for(int l = 0; l < 256; l++)
        {
            horizontalKerning[l] = index.readUnsignedByte();
            verticalKerning[l] = index.readUnsignedByte();
            int i1 = glyphWidth[l] = index.readUnsignedWord();
            int j1 = glyphHeight[l] = index.readUnsignedWord();
            int k1 = index.readUnsignedByte();
            int l1 = i1 * j1;
            glyphPixels[l] = new byte[l1];
            if(k1 == 0)
            {
                for(int i2 = 0; i2 < l1; i2++)
                    glyphPixels[l][i2] = data.readSignedByte();

            } else
            if(k1 == 1)
            {
                for(int j2 = 0; j2 < i1; j2++)
                {
                    for(int l2 = 0; l2 < j1; l2++)
                        glyphPixels[l][j2 + l2 * i1] = data.readSignedByte();

                }

            }
            if(j1 > charHeight && l < 128)
                charHeight = j1;
            horizontalKerning[l] = 1;
            rsb[l] = i1 + 2;
            int k2 = 0;
            for(int i3 = j1 / 7; i3 < j1; i3++)
                k2 += glyphPixels[l][i3 * i1];

            if(k2 <= j1 / 7)
            {
                rsb[l]--;
                horizontalKerning[l] = 0;
            }
            k2 = 0;
            for(int j3 = j1 / 7; j3 < j1; j3++)
                k2 += glyphPixels[l][(i1 - 1) + j3 * i1];

            if(k2 <= j1 / 7)
                rsb[l]--;
        }

        if(flag)
        {
            rsb[32] = rsb[73];
        } else
        {
            rsb[32] = rsb[105];
        }
    }

    public void method380(String s, int i, int j, int k)
    {
        drawTextHLeftVMid(j, s, k, i - method384(s));
    }

    public void drawText(int i, String s, int k, int l)
    {
        drawTextHLeftVMid(i, s, k, l - method384(s) / 2);
    }

    public void method382(int i, int j, String s, int l, boolean flag)
    {
        method389(flag, j - getTextWidth(s) / 2, i, s, l);
    }

    public int getTextWidth(String s)
    {
        if(s == null)
            return 0;
        int j = 0;
        for(int k = 0; k < s.length(); k++)
            if(s.charAt(k) == '@' && k + 4 < s.length() && s.charAt(k + 4) == '@')
                k += 4;
            else
                j += rsb[s.charAt(k)];

        return j;
    }

    public int method384(String s)
    {
        if(s == null)
            return 0;
        int j = 0;
        for(int k = 0; k < s.length(); k++)
            j += rsb[s.charAt(k)];
        return j;
    }

    public void drawTextHLeftVMid(int i, String s, int j, int l)
    {
        if(s == null)
            return;
        j -= charHeight;
        for(int i1 = 0; i1 < s.length(); i1++)
        {
            char c = s.charAt(i1);
            if(c != ' ')
                method392(glyphPixels[c], l + horizontalKerning[c], j + verticalKerning[c], glyphWidth[c], glyphHeight[c], i);
            l += rsb[c];
        }
    }

    public void method386(int i, String s, int j, int k, int l)
    {
        if(s == null)
            return;
        j -= method384(s) / 2;
        l -= charHeight;
        for(int i1 = 0; i1 < s.length(); i1++)
        {
            char c = s.charAt(i1);
            if(c != ' ')
                method392(glyphPixels[c], j + horizontalKerning[c], l + verticalKerning[c] + (int)(Math.sin((double)i1 / 2D + (double)k / 5D) * 5D), glyphWidth[c], glyphHeight[c], i);
            j += rsb[c];
        }

    }

    public void method387(int i, String s, int j, int k, int l)
    {
        if(s == null)
            return;
        i -= method384(s) / 2;
        k -= charHeight;
        for(int i1 = 0; i1 < s.length(); i1++)
        {
            char c = s.charAt(i1);
            if(c != ' ')
                method392(glyphPixels[c], i + horizontalKerning[c] + (int)(Math.sin((double)i1 / 5D + (double)j / 5D) * 5D), k + verticalKerning[c] + (int)(Math.sin((double)i1 / 3D + (double)j / 5D) * 5D), glyphWidth[c], glyphHeight[c], l);
            i += rsb[c];
        }

    }

    public void method388(int i, String s, int j, int k, int l, int i1)
    {
        if(s == null)
            return;
        double d = 7D - (double)i / 8D;
        if(d < 0.0D)
            d = 0.0D;
        l -= method384(s) / 2;
        k -= charHeight;
        for(int k1 = 0; k1 < s.length(); k1++)
        {
            char c = s.charAt(k1);
            if(c != ' ')
                method392(glyphPixels[c], l + horizontalKerning[c], k + verticalKerning[c] + (int)(Math.sin((double)k1 / 1.5D + (double)j) * d), glyphWidth[c], glyphHeight[c], i1);
            l += rsb[c];
        }

    }

    public void method389(boolean flag1, int i, int j, String s, int k)
    {
        isStrikethrough = false;
        int l = i;
        if(s == null)
            return;
        k -= charHeight;
        for(int i1 = 0; i1 < s.length(); i1++)
            if(s.charAt(i1) == '@' && i1 + 4 < s.length() && s.charAt(i1 + 4) == '@')
            {
                int j1 = getColorByName(s.substring(i1 + 1, i1 + 4));
                if(j1 != -1)
                    j = j1;
                i1 += 4;
            } else
            {
                char c = s.charAt(i1);
                if(c != ' ')
                {
                    if(flag1)
                        method392(glyphPixels[c], i + horizontalKerning[c] + 1, k + verticalKerning[c] + 1, glyphWidth[c], glyphHeight[c], 0);
                    method392(glyphPixels[c], i + horizontalKerning[c], k + verticalKerning[c], glyphWidth[c], glyphHeight[c], j);
                }
                i += rsb[c];
            }
        if(isStrikethrough)
            DrawingArea.drawHLine(k + (int)((double) charHeight * 0.69999999999999996D), 0x800000, i - l, l);
    }

    public void method390(int i, int j, String s, int k, int ypos)
    {
        if(s == null)
            return;
        aRandom1498.setSeed(k);
        int j1 = 192 + (aRandom1498.nextInt() & 0x1f);
        ypos -= charHeight;
        for(int cpos = 0; cpos < s.length(); cpos++)
            if(s.charAt(cpos) == '@' && cpos + 4 < s.length() && s.charAt(cpos + 4) == '@')
            {
                int l1 = getColorByName(s.substring(cpos + 1, cpos + 4));
                if(l1 != -1)
                    j = l1;
                cpos += 4;
            } else
            {
                char c = s.charAt(cpos);
                if(c != ' ')
                {
                        method394(192, i + horizontalKerning[c] + 1, glyphPixels[c], glyphWidth[c], ypos + verticalKerning[c] + 1, glyphHeight[c], 0);
                    method394(j1, i + horizontalKerning[c], glyphPixels[c], glyphWidth[c], ypos + verticalKerning[c], glyphHeight[c], j);
                }
                i += rsb[c];
                if((aRandom1498.nextInt() & 3) == 0)
                    i++;
            }

    }

    private int getColorByName(String s)
    {
        if(s.equals("red"))
            return 0xff0000;
        if(s.equals("gre"))
            return 65280;
        if(s.equals("blu"))
            return 255;
        if(s.equals("yel"))
            return 0xffff00;
        if(s.equals("cya"))
            return 65535;
        if(s.equals("mag"))
            return 0xff00ff;
        if(s.equals("whi"))
            return 0xffffff;
        if(s.equals("bla"))
            return 0;
        if(s.equals("lre"))
            return 0xff9040;
        if(s.equals("dre"))
            return 0x800000;
        if(s.equals("dbl"))
            return 128;
        if(s.equals("or1"))
            return 0xffb000;
        if(s.equals("or2"))
            return 0xff7000;
        if(s.equals("or3"))
            return 0xff3000;
        if(s.equals("gr1"))
            return 0xc0ff00;
        if(s.equals("gr2"))
            return 0x80ff00;
        if(s.equals("gr3"))
            return 0x40ff00;
        if(s.equals("str"))
            isStrikethrough = true;
        if(s.equals("end"))
            isStrikethrough = false;
        return -1;
    }

    private void method392(byte abyte0[], int i, int j, int k, int l, int i1)
    {
        int j1 = i + j * DrawingArea.width;
        int k1 = DrawingArea.width - k;
        int l1 = 0;
        int i2 = 0;
        if(j < DrawingArea.topY)
        {
            int j2 = DrawingArea.topY - j;
            l -= j2;
            j = DrawingArea.topY;
            i2 += j2 * k;
            j1 += j2 * DrawingArea.width;
        }
        if(j + l >= DrawingArea.bottomY)
            l -= ((j + l) - DrawingArea.bottomY) + 1;
        if(i < DrawingArea.topX)
        {
            int k2 = DrawingArea.topX - i;
            k -= k2;
            i = DrawingArea.topX;
            i2 += k2;
            j1 += k2;
            l1 += k2;
            k1 += k2;
        }
        if(i + k >= DrawingArea.bottomX)
        {
            int l2 = ((i + k) - DrawingArea.bottomX) + 1;
            k -= l2;
            l1 += l2;
            k1 += l2;
        }
        if(!(k <= 0 || l <= 0))
        {
            method393(DrawingArea.pixels, abyte0, i1, i2, j1, k, l, k1, l1);
        }
    }

    private void method393(int ai[], byte abyte0[], int i, int j, int k, int l, int i1,
            int j1, int k1)
    {
        int l1 = -(l >> 2);
        l = -(l & 3);
        for(int i2 = -i1; i2 < 0; i2++)
        {
            for(int j2 = l1; j2 < 0; j2++)
            {
                if(abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
                if(abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
                if(abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
                if(abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
            }

            for(int k2 = l; k2 < 0; k2++)
                if(abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;

            k += j1;
            j += k1;
        }

    }

    private void method394(int i, int j, byte abyte0[], int k, int l, int i1,
                           int j1)
    {
        int k1 = j + l * DrawingArea.width;
        int l1 = DrawingArea.width - k;
        int i2 = 0;
        int j2 = 0;
        if(l < DrawingArea.topY)
        {
            int k2 = DrawingArea.topY - l;
            i1 -= k2;
            l = DrawingArea.topY;
            j2 += k2 * k;
            k1 += k2 * DrawingArea.width;
        }
        if(l + i1 >= DrawingArea.bottomY)
            i1 -= ((l + i1) - DrawingArea.bottomY) + 1;
        if(j < DrawingArea.topX)
        {
            int l2 = DrawingArea.topX - j;
            k -= l2;
            j = DrawingArea.topX;
            j2 += l2;
            k1 += l2;
            i2 += l2;
            l1 += l2;
        }
        if(j + k >= DrawingArea.bottomX)
        {
            int i3 = ((j + k) - DrawingArea.bottomX) + 1;
            k -= i3;
            i2 += i3;
            l1 += i3;
        }
        if(k <= 0 || i1 <= 0)
            return;
        method395(abyte0, i1, k1, DrawingArea.pixels, j2, k, i2, l1, j1, i);
    }

    private void method395(byte abyte0[], int i, int j, int ai[], int l, int i1,
                           int j1, int k1, int l1, int i2)
    {
        l1 = ((l1 & 0xff00ff) * i2 & 0xff00ff00) + ((l1 & 0xff00) * i2 & 0xff0000) >> 8;
        i2 = 256 - i2;
        for(int j2 = -i; j2 < 0; j2++)
        {
            for(int k2 = -i1; k2 < 0; k2++)
                if(abyte0[l++] != 0)
                {
                    int l2 = ai[j];
                    ai[j++] = (((l2 & 0xff00ff) * i2 & 0xff00ff00) + ((l2 & 0xff00) * i2 & 0xff0000) >> 8) + l1;
                } else
                {
                    j++;
                }

            j += k1;
            l += j1;
        }

    }

    private final byte[][] glyphPixels;
    private final int[] glyphWidth;
    private final int[] glyphHeight;
    private final int[] horizontalKerning;
    private final int[] verticalKerning;
    private final int[] rsb;
    public int charHeight;
    private final Random aRandom1498;
    private boolean isStrikethrough;
}
