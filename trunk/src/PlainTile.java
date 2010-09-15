// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

//eah...
final class PlainTile
{

    public PlainTile(int cA, int cB, int cD, int cC, int tex, int cRGB2, boolean flag)
    {
        flat = true;
        colourA = cA;
        colourB = cB;
        colourD = cD;
        colourC = cC;
        texture = tex;
        colourRGB = cRGB2;
        flat = flag;
    }

    final int colourA;
    final int colourB;
    final int colourD;
    final int colourC;
    final int texture;
    boolean flat;
    final int colourRGB;
}
