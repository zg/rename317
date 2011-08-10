package pgle;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;
//import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector3f;
import org.peterbjornx.pgl2.buffer.ElementBuffer;
import org.peterbjornx.pgl2.buffer.GeometryBuffer;
import org.peterbjornx.pgl2.buffer.OpenGLBufferFactory;
import org.peterbjornx.pgl2.buffer.impl.ArbElementBuffer;
import org.peterbjornx.pgl2.texture.Texture2D;
import org.peterbjornx.pgl2.util.PglException;
import rs2.*;
import rt4.*;

import java.rmi.NotBoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/18/11
 * Time: 8:44 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class PglTerrainOverlay {
    private MapRegion mapRegion;
    private static Texture2D[] textures = new Texture2D[677];
    private GeometryBuffer geometry;
    private ElementBuffer element;
    private Vector3f[] texcoord;
    private Vector3f[] vertexes;
    private int[] triangleA;
    private int[] triangleB;
    private int[] triangleC;
    private int[] triangleHslA;
    private int[] triangleHslB;
    private int[] triangleHslC;
    private int[] triangleAlphaA;
    private int[] triangleAlphaB;
    private int[] triangleAlphaC;
    private int vertexCount = 0;
    private int triangleCount = 0;
    private int[] textureTriangles;
    private int[] textureTypes;
    private int currentTexture = -2;
    private int textureTriangleCount = 0;
    private int heightLevel = 0;
    private VertexNormal[] vertexNormals;
    //private GlEffect3 water = new GlEffect3();
    private int renderCount = 0;
    //  private ModelRendererGL modelRendererGL;

    public PglTerrainOverlay(MapRegion map, int hl) {
        heightLevel = hl;
        mapRegion = map;
        loadData();
    }

    private void loadData() {
        Class119.genetrateTextureData();
        triangleCount = 6 * 104 * 104;//Maximal triangle count
        vertexCount = 6 * 104 * 104;//Maximal triangle count
        geometry = OpenGLBufferFactory.createGeometryBuffer(triangleCount * 3, false);
        element = OpenGLBufferFactory.createElementBuffer(triangleCount, GL11.GL_TRIANGLES);
        textureTriangles = new int[triangleCount];
        textureTypes = new int[triangleCount];
        texcoord = new Vector3f[vertexCount];
        vertexes = new Vector3f[vertexCount];
        triangleA = new int[triangleCount];
        triangleB = new int[triangleCount];
        triangleC = new int[triangleCount];
        triangleHslA = new int[triangleCount];
        triangleHslB = new int[triangleCount];
        triangleHslC = new int[triangleCount];
        triangleAlphaA = new int[triangleCount];
        triangleAlphaB = new int[triangleCount];
        triangleAlphaC = new int[triangleCount];
        triangleCount = 0;
        vertexCount = 0;
        try {
            for (int x = 0; x < 103; x++)
                for (int z = 0; z < 103; z++) {
                    int shapeA = mapRegion.getTileShape()[heightLevel][x][z] + 1;
                    int shapeB = mapRegion.getShapeRotation()[heightLevel][x][z];
                    int overlay = mapRegion.getOverLay()[heightLevel][x][z] & 0xff;
                    int yA = -mapRegion.getHeightMap()[heightLevel][x][z];
                    int yB = -mapRegion.getHeightMap()[heightLevel][x + 1][z];
                    int yD = -mapRegion.getHeightMap()[heightLevel][x + 1][z + 1];
                    int yC = -mapRegion.getHeightMap()[heightLevel][x][z + 1];
                    if (overlay != 0) {
                        Floor overlayFloor = Floor.cache[overlay - 1];
                        if (overlayFloor.colour2 != 0xFF00FF)
                            generateDataForTile(x, z, yA + 1, yB + 1, yC + 1, yD + 1, overlayFloor.hdOlHslColour, overlayFloor.hdOlHslColour, overlayFloor.hdOlHslColour, overlayFloor.hdOlHslColour, overlayFloor.hdTexture, shapeA, shapeB, overlayFloor.alpha);
                    }
                }
            for (int x = 0; x < 103; x++)
                for (int z = 0; z < 103; z++) {
                    int shapeA = mapRegion.getTileShape()[heightLevel][x][z] + 1;
                    int shapeB = mapRegion.getShapeRotation()[heightLevel][x][z];
                    int overlay = mapRegion.getOverLay()[heightLevel][x][z] & 0xff;
                    int yA = -mapRegion.getHeightMap()[heightLevel][x][z];
                    int yB = -mapRegion.getHeightMap()[heightLevel][x + 1][z];
                    int yD = -mapRegion.getHeightMap()[heightLevel][x + 1][z + 1];
                    int yC = -mapRegion.getHeightMap()[heightLevel][x][z + 1];
                    if (overlay != 0) {
                        Floor overlayFloor = Floor.cache[overlay - 1];
                        if (overlayFloor.colour2 != 0xFF00FF)
                            generateDataForTile(x, z, yA + 1, yB + 1, yC + 1, yD + 1, overlayFloor.hdOlHslColour, overlayFloor.hdOlHslColour, overlayFloor.hdOlHslColour, overlayFloor.hdOlHslColour, overlayFloor.hdTexture, shapeA, shapeB, 2567);
                    }
                }
            calculateNormals508();
            for (int triPtr = 0; triPtr < triangleCount; triPtr++)
                addTriangle(triPtr);
        } catch (Exception e) {
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
                int Ux = (int) (B.getX() - A.getX()) * 256;
                int Uy = (int) (B.getY() - A.getY()) * 256;
                int Uz = (int) (B.getZ() - A.getZ()) * 256;
                int Vx = (int) (C.getX() - A.getX()) * 256;
                int Vy = (int) (C.getY() - A.getY()) * 256;
                int Vz = (int) (C.getZ() - A.getZ()) * 256;
                int Nx = Uy * Vz - Vy * Uz;
                int Ny = Uz * Vx - Vz * Ux;
                int Nz;
                for (Nz = Ux * Vy - Vx * Uy; (Nx > 8192 || Ny > 8192 || Nz > 8192 || Nx < -8192 || Ny < -8192 || Nz < -8192); Nz >>= 1) {
                    Nx >>= 1;
                    Ny >>= 1;
                }
                int i_169_ = (int) Math.sqrt((double) (Nx * Nx + Ny * Ny + Nz * Nz));
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

    private void generateDataForTile(int tileX, int tileZ, int yA, int yB, int yC, int yD, int cAA, int cBA, int cCA, int cDA, int texture, int shapeA, int shapeB, int alpha) {
        // flat = !(yA != yB || yA != yD || yA != yC);
        if (alpha == 2567 && !(texture == 1 || texture == 24))
            return;
        else if (alpha == 2567) {
            texture = 678;
            alpha = 255;
            yA++;
            yB++;
            yC++;
            yD++;
        } else if (texture == 1 || texture == 24) {
            texture = 679;
        }
        char const512 = '\200';
        int const256 = const512 / 2;
        int const128 = const512 / 4;
        int const384 = (const512 * 3) / 4;
        int shapedTileMesh[] = ShapedTile.shapedTilePointData[shapeA];
        int meshLength = shapedTileMesh.length;
        int vertexColourUnderlay[] = new int[meshLength];
        int x512 = tileX * const512;
        int z512 = tileZ * const512;
        int vertexBasePtr = vertexCount;
        boolean[] isInOverlay = new boolean[meshLength];
        for (int vertexPtr = 0; vertexPtr < meshLength; vertexPtr++) {
            int vertexType = shapedTileMesh[vertexPtr];
            if ((vertexType & 1) == 0 && vertexType <= 8)
                vertexType = (vertexType - shapeB - shapeB - 1 & 7) + 1;
            if (vertexType > 8 && vertexType <= 12)
                vertexType = (vertexType - 9 - shapeB & 3) + 9;
            if (vertexType > 12 && vertexType <= 16)
                vertexType = (vertexType - 13 - shapeB & 3) + 13;
            int vertexX;
            int vertexZ;
            int vertexY;
            // int vertexCOverlay;
            int vertexCUnderlay;
            if (vertexType == 1) {
                vertexX = x512;
                vertexZ = z512;
                vertexY = yA;
                //    vertexCOverlay = cA;
                vertexCUnderlay = cAA;
            } else if (vertexType == 2) {
                vertexX = x512 + const256;
                vertexZ = z512;
                vertexY = yA + yB >> 1;
                //    vertexCOverlay = cA + cB >> 1;
                vertexCUnderlay = cAA + cBA >> 1;
            } else if (vertexType == 3) {
                vertexX = x512 + const512;
                vertexZ = z512;
                vertexY = yB;
                //    vertexCOverlay = cB;
                vertexCUnderlay = cBA;
            } else if (vertexType == 4) {
                vertexX = x512 + const512;
                vertexZ = z512 + const256;
                vertexY = yB + yD >> 1;
                //   vertexCOverlay = cB + cD >> 1;
                vertexCUnderlay = cBA + cDA >> 1;
            } else if (vertexType == 5) {
                vertexX = x512 + const512;
                vertexZ = z512 + const512;
                vertexY = yD;
                //    vertexCOverlay = cD;
                vertexCUnderlay = cDA;
            } else if (vertexType == 6) {
                vertexX = x512 + const256;
                vertexZ = z512 + const512;
                vertexY = yD + yC >> 1;
                //    vertexCOverlay = cD + cC >> 1;
                vertexCUnderlay = cDA + cCA >> 1;
            } else if (vertexType == 7) {
                vertexX = x512;
                vertexZ = z512 + const512;
                vertexY = yC;
                //    vertexCOverlay = cC;
                vertexCUnderlay = cCA;
            } else if (vertexType == 8) {
                vertexX = x512;
                vertexZ = z512 + const256;
                vertexY = yC + yA >> 1;
                //    vertexCOverlay = cC + cA >> 1;
                vertexCUnderlay = cCA + cAA >> 1;
            } else if (vertexType == 9) {
                vertexX = x512 + const256;
                vertexZ = z512 + const128;
                vertexY = yA + yB >> 1;
                //    vertexCOverlay = cA + cB >> 1;
                vertexCUnderlay = cAA + cBA >> 1;
            } else if (vertexType == 10) {
                vertexX = x512 + const384;
                vertexZ = z512 + const256;
                vertexY = yB + yD >> 1;
                //    vertexCOverlay = cB + cD >> 1;
                vertexCUnderlay = cBA + cDA >> 1;
            } else if (vertexType == 11) {
                vertexX = x512 + const256;
                vertexZ = z512 + const384;
                vertexY = yD + yC >> 1;
                //    vertexCOverlay = cD + cC >> 1;
                vertexCUnderlay = cDA + cCA >> 1;
            } else if (vertexType == 12) {
                vertexX = x512 + const128;
                vertexZ = z512 + const256;
                vertexY = yC + yA >> 1;
                //    vertexCOverlay = cC + cA >> 1;
                vertexCUnderlay = cCA + cAA >> 1;
            } else if (vertexType == 13) {
                vertexX = x512 + const128;
                vertexZ = z512 + const128;
                vertexY = yA;
                //    vertexCOverlay = cA;
                vertexCUnderlay = cAA;
            } else if (vertexType == 14) {
                vertexX = x512 + const384;
                vertexZ = z512 + const128;
                vertexY = yB;
                //    vertexCOverlay = cB;
                vertexCUnderlay = cBA;
            } else if (vertexType == 15) {
                vertexX = x512 + const384;
                vertexZ = z512 + const384;
                vertexY = yD;
                //    vertexCOverlay = cD;
                vertexCUnderlay = cDA;
            } else {
                vertexX = x512 + const128;
                vertexZ = z512 + const384;
                vertexY = yC;
                //   vertexCOverlay = cC;
                vertexCUnderlay = cCA;
            }
            vertexes[vertexCount] = new Vector3f(vertexX, vertexY, vertexZ);
            texcoord[vertexCount++] = new Vector3f(((vertexX - tileX) / 128.0f) * ((texture == 678) ? 0.1f : 1), ((vertexZ - tileZ) / 128.0f) * ((texture == 678) ? 0.1f : 1), 0);
            // vertexColourOverlay[vertexPtr] = vertexCOverlay;
            vertexColourUnderlay[vertexPtr] = vertexCUnderlay;
        }

        int shapedTileElements[] = ShapedTile.shapedTileElementData[shapeA];
        int triangleCount2 = shapedTileElements.length / 4;
        if (currentTexture != texture) {
            textureTypes[textureTriangleCount] = texture;
            textureTriangles[textureTriangleCount++] = triangleCount;
            currentTexture = texture;
        }
        int offset = 0;
        for (int tID = 0; tID < triangleCount2; tID++) {
            int overlayOrUnderlay = shapedTileElements[offset];
            int idxA = shapedTileElements[offset + 1];
            int idxB = shapedTileElements[offset + 2];
            int idxC = shapedTileElements[offset + 3];
            offset += 4;
            if (idxA < 4)
                idxA = idxA - shapeB & 3;
            if (idxB < 4)
                idxB = idxB - shapeB & 3;
            if (idxC < 4)
                idxC = idxC - shapeB & 3;
            if (overlayOrUnderlay != 0) {
                isInOverlay[idxA] = true;
                isInOverlay[idxB] = true;
                isInOverlay[idxC] = true;
            }
        }
        offset = 0;
        for (int tID = 0; tID < triangleCount2; tID++) {
            int overlayOrUnderlay = shapedTileElements[offset];
            int idxA = shapedTileElements[offset + 1];
            int idxB = shapedTileElements[offset + 2];
            int idxC = shapedTileElements[offset + 3];
            offset += 4;
            if (idxA < 4)
                idxA = idxA - shapeB & 3;
            if (idxB < 4)
                idxB = idxB - shapeB & 3;
            if (idxC < 4)
                idxC = idxC - shapeB & 3;
            triangleA[triangleCount] = vertexBasePtr + idxA;
            triangleB[triangleCount] = vertexBasePtr + idxB;
            triangleC[triangleCount] = vertexBasePtr + idxC;
            if (overlayOrUnderlay != 0) {
                triangleAlphaA[triangleCount] = alpha;
                triangleAlphaB[triangleCount] = alpha;
                triangleAlphaC[triangleCount] = alpha;
                triangleHslA[triangleCount] = vertexColourUnderlay[idxA];
                triangleHslB[triangleCount] = vertexColourUnderlay[idxB];
                triangleHslC[triangleCount++] = vertexColourUnderlay[idxC];
            } /*else {
                triangleAlphaA[triangleCount] = 0;
                triangleAlphaB[triangleCount] = 0;
                triangleAlphaC[triangleCount] = 0;
                triangleHslA[triangleCount]   = vertexColourUnderlay[idxA];
                triangleHslB[triangleCount]   = vertexColourUnderlay[idxB];
                triangleHslC[triangleCount++] = vertexColourUnderlay[idxC];
            }  */
        }
    }

    private Color fromRgb(int rgb, int a) {
        return new Color(rgb >> 16, rgb >> 8, rgb & 0xFF, a);
    }

    private void addTriangle(int triIdx) throws PglException {
        int verAIdx = triangleA[triIdx];
        int verBIdx = triangleB[triIdx];
        int verCIdx = triangleC[triIdx];
        Color colorA = fromRgb(Rasterizer.hsl2rgb[triangleHslA[triIdx]], triangleAlphaA[triIdx]);
        Color colorB = fromRgb(Rasterizer.hsl2rgb[triangleHslB[triIdx]], triangleAlphaB[triIdx]);
        Color colorC = fromRgb(Rasterizer.hsl2rgb[triangleHslC[triIdx]], triangleAlphaC[triIdx]);
        Vector3f normalA = new Vector3f(vertexNormals[verAIdx].getX(), vertexNormals[verAIdx].getY(), vertexNormals[verAIdx].getZ());
        Vector3f normalB = new Vector3f(vertexNormals[verBIdx].getX(), vertexNormals[verBIdx].getY(), vertexNormals[verBIdx].getZ());
        Vector3f normalC = new Vector3f(vertexNormals[verCIdx].getX(), vertexNormals[verCIdx].getY(), vertexNormals[verCIdx].getZ());
        int bufAIdx = geometry.addVertex(vertexes[verAIdx], normalA, texcoord[verAIdx], colorA);
        int bufBIdx = geometry.addVertex(vertexes[verBIdx], normalB, texcoord[verBIdx], colorB);
        int bufCIdx = geometry.addVertex(vertexes[verCIdx], normalC, texcoord[verCIdx], colorC);
        List<Integer> polylist = new LinkedList<Integer>();
        polylist.add(bufAIdx);
        polylist.add(bufBIdx);
        polylist.add(bufCIdx);
        element.addPolygon(polylist);
    }

    public static Texture2D getTexture(int id) {
        return new Texture2D("./hddata/texture/" + id + ".png", false, GL11.GL_LINEAR, new int[]{255, 0, 255});
    }

    public void render() {

        textures[0].bind();
        geometry.enable();
        geometry.bind();
        element.bind();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glAlphaFunc(GL11.GL_GEQUAL, 0.0f);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        for (int tID = 0; tID < textureTriangleCount; tID++) {
            int startTriangle = textureTriangles[tID];
            int endTriangle = 0;
            int texture = textureTypes[tID];
            glPushMatrix();
            if (texture == -1)
                GL11.glDisable(GL11.GL_TEXTURE_2D);
            else {
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                glMatrixMode(GL_MODELVIEW);
                if (texture > 679)
                    texture = 0;
                if (texture == 678) {
                    OpenGLManager.bindtexture2d(Class119.textureIds2[(renderCount / 4) % 63]);
                    glTexEnvf(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_MODULATE);
                    glTexEnvf(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL11.GL_TEXTURE);
                    glTexEnvf(GL_TEXTURE_ENV, GL_OPERAND0_ALPHA, GL11.GL_SRC_ALPHA);
                    int offset = (renderCount / 7) % 50;
                    glTranslatef(0,-(offset > 25 ? (50 - offset) : offset),0);
                } else if (texture == 679) {
                    int offset = (renderCount / 7) % 50;
                    glTranslatef(0,-(offset > 25 ? (50 - offset) : offset),0);
                    GL11.glDisable(GL11.GL_TEXTURE_2D);
                } else
                    textures[texture].bind();

            }
            if (tID == textureTriangleCount - 1)
                endTriangle = triangleCount;
            else
                endTriangle = textureTriangles[tID + 1];
            if (element instanceof ArbElementBuffer) {
                GL11.glDrawElements(4, (endTriangle - startTriangle) * 3, 5125, (long) (startTriangle * 12));
            } else {
                ;
            }
            if (texture == 678) {
                glTexEnvi(8960, 34162, 8448);
            }
            glPopMatrix();
        }
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glDisable(GL11.GL_BLEND);
        renderCount++;
        renderCount = renderCount % 5000;
    }

    static {
        for (int i = 0; i < 677; i++) {
            try {
                textures[i] = getTexture(i);
                if (textures[i] == null)
                    textures[i] = textures[i - 1];
            } catch (Exception e) {
                textures[i] = textures[i - 1];
            }
        }
    }
}
