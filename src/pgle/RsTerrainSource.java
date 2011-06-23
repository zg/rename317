package pgle;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.peterbjornx.pgl2.terrain.TerrainSource;
import org.peterbjornx.pgl2.texture.Texture2D;
import rs2.Floor;
import rs2.MapRegion;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/17/11
 * Time: 6:23 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class RsTerrainSource implements TerrainSource {
    private MapRegion mapRegion;
    private int[][] textureMap = new int[104][104];
    private Color[][] colourMap = new Color[104][104];
    private int[][] heightMap = new int[104][104];
    private int heightLevel = 0;

    public RsTerrainSource(MapRegion mapRegion) {
        this.mapRegion = mapRegion;
    }

    public void updateMap(){
        byte[][] underlays = mapRegion.getUnderLay()[heightLevel];
        int[][] underlaysRgb = mapRegion.getUnderlayRgb()[heightLevel];
        int[][] heightmap = mapRegion.getHeightMap()[heightLevel];
        for (int x = 0;x < 104;x++)
            for (int z = 0;z < 104;z++){
                if (underlays[x][z] == 0)
                    underlays[x][z] = 1;
                Floor underlay = Floor.cache[underlays[x][z] - 1];
                int underlayRgb = underlaysRgb[x][z];
                colourMap[x][z] = new Color(underlayRgb >> 16,underlayRgb >> 8,underlayRgb & 0xFF);
                textureMap[x][z] = underlay.hdUlTexture;
                heightMap[x][z] = -heightmap[x][z];
            }
    }

    public int[][] getHeightMap() {
        return heightMap;
    }

    public Color[][] getColorMap() {
        return colourMap;
    }

    public int[][] getTextureMap() {
        return textureMap;
    }

    public Texture2D getTexture(int id) {
        Texture2D t = new Texture2D("./hddata/texture/" + id + ".png",false, GL11.GL_LINEAR,new int[]{255,0,255});
        return t;
    }

    public int getTileSize() {
        return 128;
    }

    public int getSideSize() {
        return 103;
    }
}
