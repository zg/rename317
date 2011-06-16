package jgle_graphics;

import org.lwjgl.util.*;
import org.peterbjornx.pgl2.terrain.TerrainSource;
import org.peterbjornx.pgl2.texture.Texture2D;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/17/11
 * Time: 1:02 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class RsTerrainSource implements TerrainSource{
    private int heightLevel = 0;
    private Color[][] colourMap = new Color[104][104];
   // private MapRegion mapRegion;
    public int[][] getHeightMap() {
        return new int[0][];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Color[][] getColorMap() {
        return colourMap;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int[][] getTextureMap() {
        return new int[0][];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Texture2D getTexture(int i) {
        return null;
    }

    public int getTileSize() {
        return 128;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getSideSize() {
        return 103;
    }
}
