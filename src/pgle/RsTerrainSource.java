package pgle;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector3f;
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
    private PglTerrainModel model;

    public RsTerrainSource(MapRegion mapRegion) {
        this.mapRegion = mapRegion;
    }

    public void updateMap(){
        byte[][] underlays = mapRegion.get_tile_layer0_type()[heightLevel];
        int[][] underlaysRgb = mapRegion.get_tile_layer0_colour()[heightLevel];
        int[][] heightmap = mapRegion.get_tile_height()[heightLevel];
        for (int x = 0;x < 104;x++)
            for (int z = 0;z < 104;z++){
                if (underlays[x][z] == 0)
                    underlays[x][z] = 1;
                Floor underlay = Floor.cache[(underlays[x][z] & 0xFF) - 1];
                int underlayRgb = underlaysRgb[x][z];
                colourMap[x][z] = new Color(underlayRgb >> 16,underlayRgb >> 8,underlayRgb & 0xFF);
                textureMap[x][z] = underlay.hdUlTexture;
                heightMap[x][z] = (((!(mapRegion.get_tile_layer1_type()[heightLevel][x][z] == 6 && mapRegion.get_tile_layer1_shape()[heightLevel][x][z] != 1)) || heightmap[x][z] != 0) ? -heightmap[x][z] : -200)-9;

            }
        model = new PglTerrainModel(mapRegion,0);
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

    @Override
    public Vector3f[][] getNormalMap() {
        return model.getNormals();
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
