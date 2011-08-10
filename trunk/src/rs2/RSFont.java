package rs2;


import java.util.Random;

public class RSFont extends DrawingArea {

    public RSFont(boolean flag, String s, JagexArchive titleArchive)
    {
        glyphPixels = new byte[256][];
        glyphWidth = new int[256];
        glyphHeight = new int[256];
        horizontalKerning = new int[256];
        verticalKerning = new int[256];
        charEffectiveWidth = new int[256];
        random = new Random();
        isStrikethrough = false;
        Packet data = new Packet(titleArchive.getDataForName(s + ".dat"));
        Packet index = new Packet(titleArchive.getDataForName("index.dat"));
        index.pos = data.g2() + 4;
        int k = index.g1();
        if(k > 0)
            index.pos += 3 * (k - 1);
        for(int l = 0; l < 256; l++)
        {
            horizontalKerning[l] = index.g1();
            verticalKerning[l] = index.g1();
            int width = glyphWidth[l] = index.g2();
            int height = glyphHeight[l] = index.g2();
            int k1 = index.g1();
            int l1 = width * height;
            glyphPixels[l] = new byte[l1];
            if(k1 == 0)
            {
                for(int i2 = 0; i2 < l1; i2++)
                    {
                	glyphPixels[l][i2] = data.g1b();
                	}

            } else
            if(k1 == 1)
            {
                for(int j2 = 0; j2 < width; j2++)
                {
                    for(int l2 = 0; l2 < height; l2++)
                        glyphPixels[l][j2 + l2 * width] = data.g1b();

                }

            }
            if(height > charHeight && l < 128)
                charHeight = height;
            horizontalKerning[l] = 1;
            charEffectiveWidth[l] = width + 2;
            int k2 = 0;
            for(int i3 = height / 7; i3 < height; i3++)
                k2 += glyphPixels[l][i3 * width];

            if(k2 <= height / 7)
            {
                charEffectiveWidth[l]--;
                horizontalKerning[l] = 0;
            }
            k2 = 0;
            for(int j3 = height / 7; j3 < height; j3++)
                k2 += glyphPixels[l][(width - 1) + j3 * width];

            if(k2 <= height / 7)
                charEffectiveWidth[l]--;
        }

        if(flag)
        {
            charEffectiveWidth[32] = charEffectiveWidth[73];
        } else
        {
            charEffectiveWidth[32] = charEffectiveWidth[105];
        }
    }

    public void drawTextHRightVTop(String string, int x, int y, int colour)
    {
        drawTextHLeftVTop(string, x - getStringWidth(string), y, colour);
    }

    public void drawTextHMidVTop(String string, int x, int y, int colour)
    {
        drawTextHLeftVTop(string, x - getStringWidth(string) / 2, y, colour);
    }

    public void drawShadowTextHMidVTop(int colour, int x, String string, int l, boolean flag)
    {
        drawShadowTextHLeftVTop(flag, x - getFormattedStringWith(string) / 2, colour, string, l);
    }

    public int getFormattedStringWith(String string)
    {
        if(string == null)
            return 0;
        int j = 0;
        for(int k = 0; k < string.length(); k++)
            if(string.charAt(k) == '@' && k + 4 < string.length() && string.charAt(k + 4) == '@')
                k += 4;
            else
                j += charEffectiveWidth[string.charAt(k)];

        return j;
    }

    public int getStringWidth(String s)
    {
        if(s == null)
            return 0;
        int j = 0;
        for(int k = 0; k < s.length(); k++)
            j += charEffectiveWidth[s.charAt(k)];
        return j;
    }

    public void drawTextHLeftVTop(String string, int x, int y, int colour)
    {
        if(string == null)
            return;
        y -= charHeight;
        for(int i1 = 0; i1 < string.length(); i1++)
        {
            char c = string.charAt(i1);
            if(c != ' ')
                drawGlyph(glyphPixels[c], x + horizontalKerning[c], y + verticalKerning[c], glyphWidth[c], glyphHeight[c], colour);
            x += charEffectiveWidth[c];
        }
    }

    public void drawTextHRMidVTopWaving(String string, int x, int y, int colour, int wavePart)
    {
    	if(string == null)
            return;
        x -= getStringWidth(string) / 2;
        y -= charHeight;
        for(int i1 = 0; i1 < string.length(); i1++)
        {
            char c = string.charAt(i1);
            if(c != ' ')
                drawGlyph(glyphPixels[c], x + horizontalKerning[c], y + verticalKerning[c] + (int) (Math.sin((double) i1 / 2D + (double) wavePart / 5D) * 5D), glyphWidth[c], glyphHeight[c], colour);
            x += charEffectiveWidth[c];
        }

    }

    public void drawTextHRMidVTopWaving2(int i, String s, int j, int k, int l)
    {
        if(s == null)
            return;
        i -= getStringWidth(s) / 2;
        k -= charHeight;
        for(int i1 = 0; i1 < s.length(); i1++)
        {
            char c = s.charAt(i1);
            if(c != ' ')
                drawGlyph(glyphPixels[c], i + horizontalKerning[c] + (int) (Math.sin((double) i1 / 5D + (double) j / 5D) * 5D), k + verticalKerning[c] + (int) (Math.sin((double) i1 / 3D + (double) j / 5D) * 5D), glyphWidth[c], glyphHeight[c], l);
            i += charEffectiveWidth[c];
        }

    }

    public void drawTextHRMidVTopShaking(int wavePart, String string, int wavePart2, int y, int x, int colour)
    {
        if(string == null)
            return;
        double d = 7D - (double)wavePart / 8D;
        if(d < 0.0D)
            d = 0.0D;
        x -= getStringWidth(string) / 2;
        y -= charHeight;
        for(int k1 = 0; k1 < string.length(); k1++)
        {
            char c = string.charAt(k1);
            if(c != ' ')
                drawGlyph(glyphPixels[c], x + horizontalKerning[c], y + verticalKerning[c] + (int) (Math.sin((double) k1 / 1.5D + (double) wavePart2) * d), glyphWidth[c], glyphHeight[c], colour);
            x += charEffectiveWidth[c];
        }

    }

    public void drawShadowTextHLeftVTop(boolean flag1, int i, int textColour, String s, int k)
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
                    textColour = j1;
                i1 += 4;
            } else
            {
                char c = s.charAt(i1);
                if(c != ' ')
                {
                    if(flag1)
                        drawGlyph(glyphPixels[c], i + horizontalKerning[c] + 1, k + verticalKerning[c] + 1, glyphWidth[c], glyphHeight[c], 0);
                    drawGlyph(glyphPixels[c], i + horizontalKerning[c], k + verticalKerning[c], glyphWidth[c], glyphHeight[c], textColour);
                }
                i += charEffectiveWidth[c];
            }
        if(isStrikethrough)
            drawHLine(l, k + (int)((double) charHeight * 0.69999999999999996D), i - l, 0x800000);
    }

    public void drawShadowedTextRight(int i, int colour, String s, int seed, int ypos)//draw shadowd text to the right
    {
        if(s == null)
            return;
        random.setSeed(seed);
        int j1 = 192 + (random.nextInt() & 0x1f);
        ypos -= charHeight;
        for(int cpos = 0; cpos < s.length(); cpos++)
            if(s.charAt(cpos) == '@' && cpos + 4 < s.length() && s.charAt(cpos + 4) == '@')
            {
                int l1 = getColorByName(s.substring(cpos + 1, cpos + 4));
                if(l1 != -1)
                    colour = l1;
                cpos += 4;
            } else
            {
                char c = s.charAt(cpos);
                if(c != ' ')
                {
                        drawShadowedChar(192, i + horizontalKerning[c] + 1, glyphPixels[c], glyphWidth[c], ypos + verticalKerning[c] + 1, glyphHeight[c], 0);
                    drawShadowedChar(j1, i + horizontalKerning[c], glyphPixels[c], glyphWidth[c], ypos + verticalKerning[c], glyphHeight[c], colour);
                }
                i += charEffectiveWidth[c];
                if((random.nextInt() & 3) == 0)
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

    private void drawGlyph(byte abyte0[], int i, int j, int k, int l, int colour)
    {
        int j1 = i + j * width;
        int k1 = width - k;
        int l1 = 0;
        int i2 = 0;
        if(j < topY)
        {
            int j2 = topY - j;
            l -= j2;
            j = topY;
            i2 += j2 * k;
            j1 += j2 * width;
        }
        if(j + l >= viewport_h)
            l -= ((j + l) - viewport_h) + 1;
        if(i < topX)
        {
            int k2 = topX - i;
            k -= k2;
            i = topX;
            i2 += k2;
            j1 += k2;
            l1 += k2;
            k1 += k2;
        }
        if(i + k >= viewport_w)
        {
            int l2 = ((i + k) - viewport_w) + 1;
            k -= l2;
            l1 += l2;
            k1 += l2;
        }
        if(!(k <= 0 || l <= 0))
        {
            colourPixels(pixels, abyte0, colour, i2, j1, k, l, k1, l1);
        }
    }

    private void colourPixels(int pixels[], byte originalPixels[], int colour, int j, int k, int l, int i1,
            int j1, int k1)
    {
        int l1 = -(l >> 2);
        l = -(l & 3);
        for(int i2 = -i1; i2 < 0; i2++)
        {
            for(int j2 = l1; j2 < 0; j2++)
            {
                if(originalPixels[j++] != 0)
                    pixels[k++] = colour;
                else
                    k++;
                if(originalPixels[j++] != 0)
                    pixels[k++] = colour;
                else
                    k++;
                if(originalPixels[j++] != 0)
                    pixels[k++] = colour;
                else
                    k++;
                if(originalPixels[j++] != 0)
                    pixels[k++] = colour;
                else
                    k++;
            }

            for(int k2 = l; k2 < 0; k2++)
                if(originalPixels[j++] != 0)
                    pixels[k++] = colour;
                else
                    k++;

            k += j1;
            j += k1;
        }

    }

    private void drawShadowedChar(int i, int j, byte abyte0[], int k, int l, int i1,
                           int j1)
    {
        int k1 = j + l * width;
        int l1 = width - k;
        int i2 = 0;
        int j2 = 0;
        if(l < topY)
        {
            int k2 = topY - l;
            i1 -= k2;
            l = topY;
            j2 += k2 * k;
            k1 += k2 * width;
        }
        if(l + i1 >= viewport_h)
            i1 -= ((l + i1) - viewport_h) + 1;
        if(j < topX)
        {
            int l2 = topX - j;
            k -= l2;
            j = topX;
            j2 += l2;
            k1 += l2;
            i2 += l2;
            l1 += l2;
        }
        if(j + k >= viewport_w)
        {
            int i3 = ((j + k) - viewport_w) + 1;
            k -= i3;
            i2 += i3;
            l1 += i3;
        }
        if(k <= 0 || i1 <= 0)
            return;
        recolourAlpha(abyte0, i1, k1, pixels, j2, k, i2, l1, j1, i);
    }

    private void recolourAlpha(byte abyte0[], int i, int j, int ai[], int l, int i1,
                           int j1, int k1, int colour, int alpha)
    {
        colour = ((colour & 0xff00ff) * alpha & 0xff00ff00) + ((colour & 0xff00) * alpha & 0xff0000) >> 8;
        alpha = 256 - alpha;
        for(int j2 = -i; j2 < 0; j2++)
        {
            for(int k2 = -i1; k2 < 0; k2++)
                if(abyte0[l++] != 0)
                {
                    int l2 = ai[j];
                    ai[j++] = (((l2 & 0xff00ff) * alpha & 0xff00ff00) + ((l2 & 0xff00) * alpha & 0xff0000) >> 8) + colour;
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
    private final int[] charEffectiveWidth;
    public int charHeight;
    private final Random random;
    private boolean isStrikethrough;
}
