package rs2;


import java.awt.*;

public class ShapedTile
{

    public ShapedTile(int tileX, int tileZ, int yA, int yB, int yC, int yD, int cAA, int cBA, int cCA, int cDA, int rgba, int cA, int cB, int cC, int cD, int rgb, int texture, int shape, int rotation)
    {
        flat = !(yA != yB || yA != yD || yA != yC);
        this.shape = shape;
        this.rotation = rotation;
        colourRGB = rgb;
        colourRGBA = rgba;
        char const512 = '\200';
        int const256 = const512 / 2;
        int const128 = const512 / 4;
        int const384 = (const512 * 3) / 4;
        int shapedTileMesh[] = shapedTilePointData[shape];
        int meshLength = shapedTileMesh.length;
        origVertexX = new int[meshLength];
        origVertexY = new int[meshLength];
        origVertexZ = new int[meshLength];
        int vertexColourOverlay[] = new int[meshLength];
        int vertexColourUnderlay[] = new int[meshLength];
        int x512 = tileX * const512;
        int z512 = tileZ * const512;
        for(int vertexPtr = 0; vertexPtr < meshLength; vertexPtr++)
        {
            int vertexType = shapedTileMesh[vertexPtr];
            if((vertexType & 1) == 0 && vertexType <= 8)
                vertexType = (vertexType - rotation - rotation - 1 & 7) + 1;
            if(vertexType > 8 && vertexType <= 12)
                vertexType = (vertexType - 9 - rotation & 3) + 9;
            if(vertexType > 12 && vertexType <= 16)
                vertexType = (vertexType - 13 - rotation & 3) + 13;
            int vertexX;
            int vertexZ;
            int vertexY;
            int vertexCOverlay;
            int vertexCUnderlay;
            if(vertexType == 1)
            {
                vertexX = x512;
                vertexZ = z512;
                vertexY = yA;
                vertexCOverlay = cA;
                vertexCUnderlay = cAA;
            } else
            if(vertexType == 2)
            {
                vertexX = x512 + const256;
                vertexZ = z512;
                vertexY = yA + yB >> 1;
                vertexCOverlay = cA + cB >> 1;
                vertexCUnderlay = cAA + cBA >> 1;
            } else
            if(vertexType == 3)
            {
                vertexX = x512 + const512;
                vertexZ = z512;
                vertexY = yB;
                vertexCOverlay = cB;
                vertexCUnderlay = cBA;
            } else
            if(vertexType == 4)
            {
                vertexX = x512 + const512;
                vertexZ = z512 + const256;
                vertexY = yB + yD >> 1;
                vertexCOverlay = cB + cD >> 1;
                vertexCUnderlay = cBA + cDA >> 1;
            } else
            if(vertexType == 5)
            {
                vertexX = x512 + const512;
                vertexZ = z512 + const512;
                vertexY = yD;
                vertexCOverlay = cD;
                vertexCUnderlay = cDA;
            } else
            if(vertexType == 6)
            {
                vertexX = x512 + const256;
                vertexZ = z512 + const512;
                vertexY = yD + yC >> 1;
                vertexCOverlay = cD + cC >> 1;
                vertexCUnderlay = cDA + cCA >> 1;
            } else
            if(vertexType == 7)
            {
                vertexX = x512;
                vertexZ = z512 + const512;
                vertexY = yC;
                vertexCOverlay = cC;
                vertexCUnderlay = cCA;
            } else
            if(vertexType == 8)
            {
                vertexX = x512;
                vertexZ = z512 + const256;
                vertexY = yC + yA >> 1;
                vertexCOverlay = cC + cA >> 1;
                vertexCUnderlay = cCA + cAA >> 1;
            } else
            if(vertexType == 9)
            {
                vertexX = x512 + const256;
                vertexZ = z512 + const128;
                vertexY = yA + yB >> 1;
                vertexCOverlay = cA + cB >> 1;
                vertexCUnderlay = cAA + cBA >> 1;
            } else
            if(vertexType == 10)
            {
                vertexX = x512 + const384;
                vertexZ = z512 + const256;
                vertexY = yB + yD >> 1;
                vertexCOverlay = cB + cD >> 1;
                vertexCUnderlay = cBA + cDA >> 1;
            } else
            if(vertexType == 11)
            {
                vertexX = x512 + const256;
                vertexZ = z512 + const384;
                vertexY = yD + yC >> 1;
                vertexCOverlay = cD + cC >> 1;
                vertexCUnderlay = cDA + cCA >> 1;
            } else
            if(vertexType == 12)
            {
                vertexX = x512 + const128;
                vertexZ = z512 + const256;
                vertexY = yC + yA >> 1;
                vertexCOverlay = cC + cA >> 1;
                vertexCUnderlay = cCA + cAA >> 1;
            } else
            if(vertexType == 13)
            {
                vertexX = x512 + const128;
                vertexZ = z512 + const128;
                vertexY = yA;
                vertexCOverlay = cA;
                vertexCUnderlay = cAA;
            } else
            if(vertexType == 14)
            {
                vertexX = x512 + const384;
                vertexZ = z512 + const128;
                vertexY = yB;
                vertexCOverlay = cB;
                vertexCUnderlay = cBA;
            } else
            if(vertexType == 15)
            {
                vertexX = x512 + const384;
                vertexZ = z512 + const384;
                vertexY = yD;
                vertexCOverlay = cD;
                vertexCUnderlay = cDA;
            } else
            {
                vertexX = x512 + const128;
                vertexZ = z512 + const384;
                vertexY = yC;
                vertexCOverlay = cC;
                vertexCUnderlay = cCA;
            }
            origVertexX[vertexPtr] = vertexX;
            origVertexY[vertexPtr] = vertexY;
            origVertexZ[vertexPtr] = vertexZ;
            vertexColourOverlay[vertexPtr] = vertexCOverlay;
            vertexColourUnderlay[vertexPtr] = vertexCUnderlay;
        }

        int shapedTileElements[] = shapedTileElementData[shape];
        int vertexCount = shapedTileElements.length / 4;
        triangleA = new int[vertexCount];
        triangleB = new int[vertexCount];
        triangleC = new int[vertexCount];
        triangleHslA = new int[vertexCount];
        triangleHslB = new int[vertexCount];
        triangleHslC = new int[vertexCount];
        if(texture != -1)
            triangleTexture = new int[vertexCount];
        int offset = 0;
        for(int vID = 0; vID < vertexCount; vID++)
        {
            int overlayOrUnderlay = shapedTileElements[offset];
            int idxA = shapedTileElements[offset + 1];
            int idxB = shapedTileElements[offset + 2];
            int idxC = shapedTileElements[offset + 3];
            offset += 4;
            if(idxA < 4)
                idxA = idxA - rotation & 3;
            if(idxB < 4)
                idxB = idxB - rotation & 3;
            if(idxC < 4)
                idxC = idxC - rotation & 3;
            triangleA[vID] = idxA;
            triangleB[vID] = idxB;
            triangleC[vID] = idxC;
            if(overlayOrUnderlay == 0)
            {
                triangleHslA[vID] = vertexColourOverlay[idxA];
                triangleHslB[vID] = vertexColourOverlay[idxB];
                triangleHslC[vID] = vertexColourOverlay[idxC];
                if(triangleTexture != null)
                    triangleTexture[vID] = -1;
            } else
            {
                triangleHslA[vID] = vertexColourUnderlay[idxA];
                triangleHslB[vID] = vertexColourUnderlay[idxB];
                triangleHslC[vID] = vertexColourUnderlay[idxC];
                if(triangleTexture != null)
                    triangleTexture[vID] = texture;
            }
        }

        int i9 = yA;
        int l9 = yB;
        if(yB < i9)
            i9 = yB;
        if(yB > l9)
            l9 = yB;
        if(yD < i9)
            i9 = yD;
        if(yD > l9)
            l9 = yD;
        if(yC < i9)
            i9 = yC;
        if(yC > l9)
            l9 = yC;
        i9 /= 14;
        l9 /= 14;
    }

    final int[] origVertexX;
    final int[] origVertexY;
    final int[] origVertexZ;
    final int[] triangleHslA;
    final int[] triangleHslB;
    final int[] triangleHslC;
    final int[] triangleA;
    final int[] triangleB;
    final int[] triangleC;
    int triangleTexture[];
    final boolean flat;
    final int shape;
    final int rotation;
    final int colourRGB;
    final int colourRGBA;
    static final int[] screenX = new int[6];
    static final int[] screenY = new int[6];
    static final int[] viewSpaceX = new int[6];
    static final int[] viewSpaceY = new int[6];
    static final int[] viewSpaceZ = new int[6];
    static final int[] anIntArray693 = {
        1, 0
    };
    static final int[] anIntArray694 = {
        2, 1
    };
    static final int[] anIntArray695 = {
        3, 3
    };
    public static final int[][] shapedTilePointData = {
        {
            1, 3, 5, 7
        }, {
            1, 3, 5, 7
        }, {
            1, 3, 5, 7
        }, {
            1, 3, 5, 7, 6
        }, {
            1, 3, 5, 7, 6
        }, {
            1, 3, 5, 7, 6
        }, {
            1, 3, 5, 7, 6
        }, {
            1, 3, 5, 7, 2, 6
        }, {
            1, 3, 5, 7, 2, 8
        }, {
            1, 3, 5, 7, 2, 8
        }, {
            1, 3, 5, 7, 11, 12
        }, {
            1, 3, 5, 7, 11, 12
        }, {
            1, 3, 5, 7, 13, 14
        }
    };
    public static final int[][] shapedTileElementData = {
        {
            0, 1, 2, 3,
            0, 0, 1, 3
        }, {
            1, 1, 2, 3,
            1, 0, 1, 3
        }, {
            0, 1, 2, 3,
            1, 0, 1, 3
        }, {
            0, 0, 1, 2,
            0, 0, 2, 4,
            1, 0, 4, 3
        }, {
            0, 0, 1, 4,
            0, 0, 4, 3,
            1, 1, 2, 4
        }, {
            0, 0, 4, 3,
            1, 0, 1, 2,
            1, 0, 2, 4
        }, {
            0, 1, 2, 4,
            1, 0, 1, 4,
            1, 0, 4, 3
        }, {
            0, 4, 1, 2,
            0, 4, 2, 5,
            1, 0, 4, 5,
            1, 0, 5, 3
        }, {
            0, 4, 1, 2,
            0, 4, 2, 3,
            0, 4, 3, 5,
            1, 0, 4, 5
        }, {
            0, 0, 4, 5,
            1, 4, 1, 2,
            1, 4, 2, 3,
            1, 4, 3, 5
        }, {
            0, 0, 1, 5,
            0, 1, 4, 5,
            0, 1, 2, 4,
            1, 0, 5, 3,
            1, 5, 4, 3,
            1, 4, 2, 3
        }, {
            1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 
            2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 
            0, 4, 2, 3
        }, {
            1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 
            4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 
            0, 1, 2, 5
        }
    };

    public static void drawShape(Graphics graphics, byte shapeA, byte shapeB) {
        char tileW = '\200';
        int halfW = tileW / 2;
        int quarterW = tileW / 4;
        int tqW = (tileW * 3) / 4;
        int shapedTileMesh[] = shapedTilePointData[shapeA];
        int meshLength = shapedTileMesh.length;
        int[] vx = new int[meshLength];
        int[] vy = new int[meshLength];
        int x = 0;
        int y = 0;
        for(int vertexPtr = 0; vertexPtr < meshLength; vertexPtr++)
        {
            int vertexType = shapedTileMesh[vertexPtr];
            if((vertexType & 1) == 0 && vertexType <= 8)
                vertexType = (vertexType - shapeB - shapeB - 1 & 7) + 1;
            if(vertexType > 8 && vertexType <= 12)
                vertexType = (vertexType - 9 - shapeB & 3) + 9;
            if(vertexType > 12 && vertexType <= 16)
                vertexType = (vertexType - 13 - shapeB & 3) + 13;
            int vertexX;
            int vertexY;
            if(vertexType == 1)
            {
                vertexX = x;
                vertexY = y;
            } else
            if(vertexType == 2)
            {
                vertexX = x + halfW;
                vertexY = y;
            } else
            if(vertexType == 3)
            {
                vertexX = x + tileW;
                vertexY = y;
            } else
            if(vertexType == 4)
            {
                vertexX = x + tileW;
                vertexY = y + halfW;
            } else
            if(vertexType == 5)
            {
                vertexX = x + tileW;
                vertexY = y + tileW;
            } else
            if(vertexType == 6)
            {
                vertexX = x + halfW;
                vertexY = y + tileW;
            } else
            if(vertexType == 7)
            {
                vertexX = x;
                vertexY = y + tileW;
            } else
            if(vertexType == 8)
            {
                vertexX = x;
                vertexY = y + halfW;
            } else
            if(vertexType == 9)
            {
                vertexX = x + halfW;
                vertexY = y + quarterW;
            } else
            if(vertexType == 10)
            {
                vertexX = x + tqW;
                vertexY = y + halfW;
            } else
            if(vertexType == 11)
            {
                vertexX = x + halfW;
                vertexY = y + tqW;
            } else
            if(vertexType == 12)
            {
                vertexX = x + quarterW;
                vertexY = y + halfW;
            } else
            if(vertexType == 13)
            {
                vertexX = x + quarterW;
                vertexY = y + quarterW;
            } else
            if(vertexType == 14)
            {
                vertexX = x + tqW;
                vertexY = y + quarterW;
            } else
            if(vertexType == 15)
            {
                vertexX = x + tqW;
                vertexY = y + tqW;
            } else
            {
                vertexX = x + quarterW;
                vertexY = y + tqW;
            }
            vx[vertexPtr] = vertexX;
            vy[vertexPtr] = vertexY;
        }
        int shapedTileElements[] = shapedTileElementData[shapeA];
        int vertexCount = shapedTileElements.length / 4;
        int offset = 0;
        for(int vID = 0; vID < vertexCount; vID++)
        {
            int overlayOrUnderlay = shapedTileElements[offset];
            int idxA = shapedTileElements[offset + 1];
            int idxB = shapedTileElements[offset + 2];
            int idxC = shapedTileElements[offset + 3];
            offset += 4;
            if(idxA < 4)
                idxA = idxA - shapeB & 3;
            if(idxB < 4)
                idxB = idxB - shapeB & 3;
            if(idxC < 4)
                idxC = idxC - shapeB & 3;
            graphics.setColor(overlayOrUnderlay != 0 ? Color.white : Color.black);
            graphics.fillPolygon(new int[]{vx[idxA],vx[idxB],vx[idxC]},new int[]{vy[idxA],vy[idxB],vy[idxC]},3);
        }
    }
}
