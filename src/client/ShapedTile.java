



final class ShapedTile
{

    public ShapedTile(int i, int cAA, int cC, int zD, int i1, int cDA, int shapeB,
                   int cA, int rgb, int cD, int zC, int zB, int zA, int shapeA,
                   int cCA, int cBA, int cB, int k4, int rgba)
    {
        flat = !(zA != zB || zA != zD || zA != zC);
        this.shapeA = shapeA;
        this.shapeB = shapeB;
        colourRGB = rgb;
        colourRGBA = rgba;
        char c = '\200';
        int i5 = c / 2;
        int j5 = c / 4;
        int k5 = (c * 3) / 4;
        int ai[] = anIntArrayArray696[shapeA];
        int l5 = ai.length;
        origVertexX = new int[l5];
        origVertexY = new int[l5];
        origVertexZ = new int[l5];
        int colours[] = new int[l5];
        int ai2[] = new int[l5];
        int i6 = k4 * c;
        int j6 = i * c;
        for(int k6 = 0; k6 < l5; k6++)
        {
            int l6 = ai[k6];
            if((l6 & 1) == 0 && l6 <= 8)
                l6 = (l6 - shapeB - shapeB - 1 & 7) + 1;
            if(l6 > 8 && l6 <= 12)
                l6 = (l6 - 9 - shapeB & 3) + 9;
            if(l6 > 12 && l6 <= 16)
                l6 = (l6 - 13 - shapeB & 3) + 13;
            int i7;
            int k7;
            int i8;
            int k8;
            int j9;
            if(l6 == 1)
            {
                i7 = i6;
                k7 = j6;
                i8 = zA;
                k8 = cA;
                j9 = cAA;
            } else
            if(l6 == 2)
            {
                i7 = i6 + i5;
                k7 = j6;
                i8 = zA + zB >> 1;
                k8 = cA + cB >> 1;
                j9 = cAA + cBA >> 1;
            } else
            if(l6 == 3)
            {
                i7 = i6 + c;
                k7 = j6;
                i8 = zB;
                k8 = cB;
                j9 = cBA;
            } else
            if(l6 == 4)
            {
                i7 = i6 + c;
                k7 = j6 + i5;
                i8 = zB + zD >> 1;
                k8 = cB + cD >> 1;
                j9 = cBA + cDA >> 1;
            } else
            if(l6 == 5)
            {
                i7 = i6 + c;
                k7 = j6 + c;
                i8 = zD;
                k8 = cD;
                j9 = cDA;
            } else
            if(l6 == 6)
            {
                i7 = i6 + i5;
                k7 = j6 + c;
                i8 = zD + zC >> 1;
                k8 = cD + cC >> 1;
                j9 = cDA + cCA >> 1;
            } else
            if(l6 == 7)
            {
                i7 = i6;
                k7 = j6 + c;
                i8 = zC;
                k8 = cC;
                j9 = cCA;
            } else
            if(l6 == 8)
            {
                i7 = i6;
                k7 = j6 + i5;
                i8 = zC + zA >> 1;
                k8 = cC + cA >> 1;
                j9 = cCA + cAA >> 1;
            } else
            if(l6 == 9)
            {
                i7 = i6 + i5;
                k7 = j6 + j5;
                i8 = zA + zB >> 1;
                k8 = cA + cB >> 1;
                j9 = cAA + cBA >> 1;
            } else
            if(l6 == 10)
            {
                i7 = i6 + k5;
                k7 = j6 + i5;
                i8 = zB + zD >> 1;
                k8 = cB + cD >> 1;
                j9 = cBA + cDA >> 1;
            } else
            if(l6 == 11)
            {
                i7 = i6 + i5;
                k7 = j6 + k5;
                i8 = zD + zC >> 1;
                k8 = cD + cC >> 1;
                j9 = cDA + cCA >> 1;
            } else
            if(l6 == 12)
            {
                i7 = i6 + j5;
                k7 = j6 + i5;
                i8 = zC + zA >> 1;
                k8 = cC + cA >> 1;
                j9 = cCA + cAA >> 1;
            } else
            if(l6 == 13)
            {
                i7 = i6 + j5;
                k7 = j6 + j5;
                i8 = zA;
                k8 = cA;
                j9 = cAA;
            } else
            if(l6 == 14)
            {
                i7 = i6 + k5;
                k7 = j6 + j5;
                i8 = zB;
                k8 = cB;
                j9 = cBA;
            } else
            if(l6 == 15)
            {
                i7 = i6 + k5;
                k7 = j6 + k5;
                i8 = zD;
                k8 = cD;
                j9 = cDA;
            } else
            {
                i7 = i6 + j5;
                k7 = j6 + k5;
                i8 = zC;
                k8 = cC;
                j9 = cCA;
            }
            origVertexX[k6] = i7;
            origVertexY[k6] = i8;
            origVertexZ[k6] = k7;
            colours[k6] = k8;
            ai2[k6] = j9;
        }

        int alignDATA[] = shapeAData[shapeA];
        int vertexCount = alignDATA.length / 4;
        indexA = new int[vertexCount];
        indexB = new int[vertexCount];
        indexC = new int[vertexCount];
        verticeColourA = new int[vertexCount];
        verticeColourB = new int[vertexCount];
        verticeColourC = new int[vertexCount];
        if(i1 != -1)
            triTex = new int[vertexCount];
        int offset = 0;
        for(int vID = 0; vID < vertexCount; vID++)
        {
            int cID = alignDATA[offset];
            int idxA = alignDATA[offset + 1];
            int idxB = alignDATA[offset + 2];
            int idxC = alignDATA[offset + 3];
            offset += 4;
            if(idxA < 4)
                idxA = idxA - shapeB & 3;
            if(idxB < 4)
                idxB = idxB - shapeB & 3;
            if(idxC < 4)
                idxC = idxC - shapeB & 3;
            indexA[vID] = idxA;
            indexB[vID] = idxB;
            indexC[vID] = idxC;
            if(cID == 0)
            {
                verticeColourA[vID] = colours[idxA];
                verticeColourB[vID] = colours[idxB];
                verticeColourC[vID] = colours[idxC];
                if(triTex != null)
                    triTex[vID] = -1;
            } else
            {
                verticeColourA[vID] = ai2[idxA];
                verticeColourB[vID] = ai2[idxB];
                verticeColourC[vID] = ai2[idxC];
                if(triTex != null)
                    triTex[vID] = i1;
            }
        }

        int i9 = zA;
        int l9 = zB;
        if(zB < i9)
            i9 = zB;
        if(zB > l9)
            l9 = zB;
        if(zD < i9)
            i9 = zD;
        if(zD > l9)
            l9 = zD;
        if(zC < i9)
            i9 = zC;
        if(zC > l9)
            l9 = zC;
        i9 /= 14;
        l9 /= 14;
    }

    final int[] origVertexX;
    final int[] origVertexY;
    final int[] origVertexZ;
    final int[] verticeColourA;
    final int[] verticeColourB;
    final int[] verticeColourC;
    final int[] indexA;
    final int[] indexB;
    final int[] indexC;
    int triTex[];
    final boolean flat;
    final int shapeA;
    final int shapeB;
    final int colourRGB;
    final int colourRGBA;
    static final int[] screenX = new int[6];
    static final int[] screenY = new int[6];
    static final int[] veritceX = new int[6];
    static final int[] veritceZ = new int[6];
    static final int[] veritceY = new int[6];
    static final int[] anIntArray693 = {
        1, 0
    };
    static final int[] anIntArray694 = {
        2, 1
    };
    static final int[] anIntArray695 = {
        3, 3
    };
    private static final int[][] anIntArrayArray696 = {
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
    private static final int[][] shapeAData = {
        {
            0, 1, 2, 3, 0, 0, 1, 3
        }, {
            1, 1, 2, 3, 1, 0, 1, 3
        }, {
            0, 1, 2, 3, 1, 0, 1, 3
        }, {
            0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 
            4, 3
        }, {
            0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 
            2, 4
        }, {
            0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 
            2, 4
        }, {
            0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 
            4, 3
        }, {
            0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 
            4, 5, 1, 0, 5, 3
        }, {
            0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 
            3, 5, 1, 0, 4, 5
        }, {
            0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 
            2, 3, 1, 4, 3, 5
        }, {
            0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 
            2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 
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

}
