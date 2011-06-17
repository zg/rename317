package rs2;

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
