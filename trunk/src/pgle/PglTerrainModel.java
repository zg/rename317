package pgle;

//import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import org.lwjgl.util.vector.Vector3f;
import rs2.*;
import rt4.Class119;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/18/11
 * Time: 8:44 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class PglTerrainModel {
    private MapRegion mapRegion;
    private Vector3f[] vgertexes;
    private HashMap<Long,Integer>  reverse2 = new HashMap<Long, Integer>();
    private int[] triangleA;
    private int[] triangleB;
    private int[] triangleC;
    private int vertexCount = 0;
    private int triangleCount = 0;
    private int heightLevel = 0;
    private VertexNormal[] vertexNormals;
    private int renderCount = 0;
    private Vector3f[] vertexes;
    //  private ModelRendererGL modelRendererGL;

    public PglTerrainModel(MapRegion map, int hl){
        heightLevel = hl;
        mapRegion = map;
        loadData();
    }

    private void loadData(){
        Class119.genetrateTextureData();
        triangleCount = 6*104*104;//Maximal triangle count
        vertexCount = 6*104*104;//Maximal triangle count
        vertexes = new Vector3f[vertexCount];
        triangleA = new int[triangleCount];
        triangleB = new int[triangleCount];
        triangleC = new int[triangleCount];
        triangleCount = 0;
        vertexCount = 0;
        try{
            for (int x = 0;x < 103;x++)
                for (int z = 0;z < 103;z++){
                    int yA = -mapRegion.get_tile_height()[heightLevel][x][z];
                    int yB = -mapRegion.get_tile_height()[heightLevel][x + 1][z];
                    int yD = -mapRegion.get_tile_height()[heightLevel][x + 1][z + 1];
                    int yC = -mapRegion.get_tile_height()[heightLevel][x][z + 1];
                    generateDataForTile(x,z,yA+1,yB+1,yC+1,yD+1);

                }
            calculateNormals508();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void calculateNormals508() {
        vertexNormals = null;
        if (vertexNormals == null) {
            vertexNormals = new VertexNormal[vertexCount];
            for (int i = 0; i < vertexCount; i++)
            vertexNormals[i] = new VertexNormal();
            for (int i = 0; i < triangleCount; i++) {
            int triA = triangleA[i];
            int triB = triangleB[i];
            int triC = triangleC[i];
            Vector3f A = vertexes[triA];
            Vector3f B = vertexes[triB];
            Vector3f C = vertexes[triC];
            int Ux = (int)(B.getX() - A.getX())*256;
            int Uy = (int)(B.getY() - A.getY())*256;
            int Uz = (int)(B.getZ() - A.getZ())*256;
            int Vx = (int)(C.getX() - A.getX())*256;
            int Vy = (int)(C.getY() - A.getY())*256;
            int Vz = (int)(C.getZ() - A.getZ())*256;
            int Nx = Uy * Vz - Vy * Uz;
            int Ny = Uz * Vx - Vz * Ux;
            int Nz;
            for (Nz = Ux * Vy - Vx * Uy;
                 (Nx > 8192 || Ny > 8192 || Nz > 8192
                  || Nx < -8192 || Ny < -8192 || Nz < -8192);
                 Nz >>= 1) {
                Nx >>= 1;
                Ny >>= 1;
            }
            int i_169_ = (int) Math.sqrt((double) (Nx * Nx
                                   + Ny * Ny
                                   + Nz * Nz));
            if (i_169_ <= 0)
                i_169_ = 1;
            Nx = Nx * 256 / i_169_;
            Ny = Ny * 256 / i_169_;
            Nz = Nz * 256 / i_169_;
                VertexNormal vertexNormal = vertexNormals[triA];
                vertexNormal.x += Nx;
                vertexNormal.y += Ny;
                vertexNormal.z += Nz;
                vertexNormal.magnitude++;
                vertexNormal = vertexNormals[triB];
                vertexNormal.x += Nx;
                vertexNormal.y += Ny;
                vertexNormal.z += Nz;
                vertexNormal.magnitude++;
                vertexNormal = vertexNormals[triC];
                vertexNormal.x += Nx;
                vertexNormal.y += Ny;
                vertexNormal.z += Nz;
                vertexNormal.magnitude++;
            }
        }
    }

    public int addVertex(int x,int y,int z){
        Vector3f v = new Vector3f(x,y,z);
        long k = (x/128) + (z/128) * 1000;
        if (reverse2.containsKey(k))
            return reverse2.get(k);
        reverse2.put(k,vertexCount);
        vertexes[vertexCount++] = v;
        return vertexCount - 1;
    }

    private void generateDataForTile(int tileX, int tileZ, int yA, int yB, int yC, int yD) {
        if (Math.abs(yA - yD) < Math.abs(yB - yC)){
            triangleA[triangleCount] = addVertex(tileX * 128,yA,tileZ * 128);
            triangleA[triangleCount] = addVertex(tileX * 128,yC,(tileZ+1) * 128);
            triangleA[triangleCount++] = addVertex((tileX+1) * 128,yB,tileZ * 128);
            triangleA[triangleCount] = addVertex(tileX * 128,yC,(tileZ+1) * 128);
            triangleA[triangleCount] = addVertex((tileX+1) * 128,yD,(tileZ+1) * 128);
            triangleA[triangleCount++] = addVertex((tileX+1) * 128,yB,tileZ * 128);
        } else {
            triangleA[triangleCount] = addVertex(tileX * 128,yA,tileZ * 128);
            triangleA[triangleCount] = addVertex(tileX * 128,yC,(tileZ+1) * 128);
            triangleA[triangleCount++] = addVertex((tileX+1) * 128,yD,(tileZ+1) * 128);
            triangleA[triangleCount] = addVertex(tileX * 128,yA,tileZ * 128);
            triangleA[triangleCount] = addVertex((tileX+1) * 128,yD,(tileZ+1) * 128);
            triangleA[triangleCount++] = addVertex((tileX+1) * 128,yB,tileZ * 128);
        }
    }

    public Vector3f[][] getNormals(){
        Vector3f[][] v = new Vector3f[103][103];

        for (int x = 0;x < 103;x++)
            for (int z = 0;z < 103;z++){
                VertexNormal vv = vertexNormals[reverse2.get(x+z*1000L)];
                v[x][z] = new Vector3f(vv.getX(),vv.getY(),vv.getZ());
            }
        return v;
    }
}
