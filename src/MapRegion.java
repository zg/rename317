// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

final class MapRegion {

    public MapRegion(byte tsettings[][][], int hmap[][][])
    {
        setZ = 99;
        xMapSize = 104;
        yMapSize = 104;
        heightMap = hmap;
        tileSettings = tsettings;
        underLay = new byte[4][xMapSize][yMapSize];
        overLay = new byte[4][xMapSize][yMapSize];
        shapeA = new byte[4][xMapSize][yMapSize];
        shapeB = new byte[4][xMapSize][yMapSize];
        anIntArrayArrayArray135 = new int[4][xMapSize + 1][yMapSize + 1];
        aByteArrayArrayArray134 = new byte[4][xMapSize + 1][yMapSize + 1];
        colourArray = new int[xMapSize + 1][yMapSize + 1];
        hue = new int[yMapSize];
        saturation = new int[yMapSize];
        lightness = new int[yMapSize];
        huedivider = new int[yMapSize];
        colourCount = new int[yMapSize];
    }

    private static int method170(int i, int j)
    {
        int k = i + j * 57;
        k = k << 13 ^ k;
        int l = k * (k * k * 15731 + 0xc0ae5) + 0x5208dd0d & 0x7fffffff;
        return l >> 19 & 0xff;
    }

    public final void addTiles(TileSetting aclass11[], SceneGraph sceneGraph)
    {
        for(int j = 0; j < 4; j++)
        {
            for(int k = 0; k < 104; k++)
            {
                for(int i1 = 0; i1 < 104; i1++)
                    if((tileSettings[j][k][i1] & 1) == 1)
                    {
                        int k1 = j;
                        if((tileSettings[1][k][i1] & 2) == 2)
                            k1--;
                        if(k1 >= 0)
                            aclass11[k1].orClipTableSET(i1, k);
                    }

            }

        }
        anInt123 += (int)(Math.random() * 5D) - 2;
        if(anInt123 < -8)
            anInt123 = -8;
        if(anInt123 > 8)
            anInt123 = 8;
        anInt133 += (int)(Math.random() * 5D) - 2;
        if(anInt133 < -16)
            anInt133 = -16;
        if(anInt133 > 16)
            anInt133 = 16;
        for(int Z = 0; Z < 4; Z++)
        {
            byte abyte0[][] = aByteArrayArrayArray134[Z];
            byte byte0 = 96;
            char c = '\u0300';
            byte byte1 = -50;
            byte byte2 = -10;
            byte byte3 = -50;
            int sqrt = (int)Math.sqrt(byte1 * byte1 + byte2 * byte2 + byte3 * byte3);
            int sqrtA = c * sqrt >> 8;
            for(int Y = 1; Y < yMapSize - 1; Y++)
            {
                for(int X = 1; X < xMapSize - 1; X++)
                {
                    int hDX = heightMap[Z][X + 1][Y] - heightMap[Z][X - 1][Y];
                    int hDY = heightMap[Z][X][Y + 1] - heightMap[Z][X][Y - 1];
                    int square = (int)Math.sqrt(hDX * hDX + 0x10000 + hDY * hDY);
                    int k12 = (hDX << 8) / square;
                    int l13 = 0x10000 / square;
                    int j15 = (hDY << 8) / square;
                    int j16 = byte0 + (byte1 * k12 + byte2 * l13 + byte3 * j15) / sqrtA;
                    int j17 = (abyte0[X - 1][Y] >> 2) + (abyte0[X + 1][Y] >> 3) + (abyte0[X][Y - 1] >> 2) + (abyte0[X][Y + 1] >> 3) + (abyte0[X][Y] >> 1);
                    colourArray[X][Y] = j16 - j17;
                }

            }

            for(int k5 = 0; k5 < yMapSize; k5++)
            {
                hue[k5] = 0;
                saturation[k5] = 0;
                lightness[k5] = 0;
                huedivider[k5] = 0;
                colourCount[k5] = 0;
            }

            for(int X = -5; X < xMapSize + 5; X++)
            {
                for(int Y = 0; Y < yMapSize; Y++)
                {
                    int xPlus5 = X + 5;
                    if(xPlus5 >= 0 && xPlus5 < xMapSize)
                    {
                        int floID = underLay[Z][xPlus5][Y] & 0xff;
                        if(floID > 0)
                        {
                            Flo flo = Flo.cache[floID - 1];
                            hue[Y] += flo.hue2;
                            saturation[Y] += flo.saturation;
                            lightness[Y] += flo.lightness;
                            huedivider[Y] += flo.pCDivider;
                            colourCount[Y]++;
                        }
                    }
                    int yMin5 = X - 5;
                    if(yMin5 >= 0 && yMin5 < xMapSize)
                    {
                        int floID = underLay[Z][yMin5][Y] & 0xff;
                        if(floID > 0)
                        {
                            Flo flo_1 = Flo.cache[floID - 1];
                            hue[Y] -= flo_1.hue2;
                            saturation[Y] -= flo_1.saturation;
                            lightness[Y] -= flo_1.lightness;
                            huedivider[Y] -= flo_1.pCDivider;
                            colourCount[Y]--;
                        }
                    }
                }

                if(X >= 1 && X < xMapSize - 1)
                {
                    int pCAA = 0;
                    int pCBA = 0;
                    int pCCA = 0;
                    int pCDividerA = 0;
                    int colourCount = 0;
                    for(int Y = -5; Y < yMapSize + 5; Y++)
                    {
                        int yPlus5 = Y + 5;
                        if(yPlus5 >= 0 && yPlus5 < yMapSize)
                        {
                            pCAA += hue[yPlus5];
                            pCBA += saturation[yPlus5];
                            pCCA += lightness[yPlus5];
                            pCDividerA += huedivider[yPlus5];
                            colourCount += this.colourCount[yPlus5];
                        }
                        int yMin5 = Y - 5;
                        if(yMin5 >= 0 && yMin5 < yMapSize)
                        {
                            pCAA -= hue[yMin5];
                            pCBA -= saturation[yMin5];
                            pCCA -= lightness[yMin5];
                            pCDividerA -= huedivider[yMin5];
                            colourCount -= this.colourCount[yMin5];
                        }
                        if(Y >= 1 && Y < yMapSize - 1 && (!lowMem || (tileSettings[0][X][Y] & 2) != 0 || (tileSettings[Z][X][Y] & 0x10) == 0 && method182(Y, Z, X) == anInt131))
                        {
                            if(Z < setZ)
                                setZ = Z;
                            int underlayID = underLay[Z][X][Y] & 0xff;
                            int overlayID = overLay[Z][X][Y] & 0xff;
                            if(underlayID > 0 || overlayID > 0)
                            {
                                int zA = heightMap[Z][X][Y];
                                int zB = heightMap[Z][X + 1][Y];
                                int zD = heightMap[Z][X + 1][Y + 1];
                                int zC = heightMap[Z][X][Y + 1];
                                int cA = colourArray[X][Y];
                                int cB = colourArray[X + 1][Y];
                                int cD = colourArray[X + 1][Y + 1];
                                int cC = colourArray[X][Y + 1];
                                int cMix = -1;
                                int plainColour = -1;
                                if(underlayID > 0)
                                {
                                    int h = (pCAA * 256) / pCDividerA;
                                    int s = pCBA / colourCount;
                                    int l22 = pCCA / colourCount;
                                    cMix = composeColour(h, s, l22);
                                    h = h + anInt123 & 0xff;
                                    l22 += anInt133;
                                    if(l22 < 0)
                                        l22 = 0;
                                    else
                                    if(l22 > 255)
                                        l22 = 255;
                                    plainColour = composeColour(h, s, l22);
                                }
                                if(Z > 0)
                                {
                                    boolean flag = true;
                                    if(underlayID == 0 && shapeA[Z][X][Y] != 0)
                                        flag = false;
                                    if(overlayID > 0 && !Flo.cache[overlayID - 1].occlude)
                                        flag = false;
                                    if(flag && zA == zB && zA == zD && zA == zC)
                                        anIntArrayArrayArray135[Z][X][Y] |= 0x924;
                                }
                                int cRGB = 0;
                                if(cMix != -1)
                                    cRGB = ThreeDimensionalDrawingArea.colourMap[mix(plainColour, 96)];
                                if(overlayID == 0)
                                {
                                    sceneGraph.addTile(Z, X, Y, 0, 0, -1, zA, zB, zD, zC, mix(cMix, cA), mix(cMix, cB), mix(cMix, cD), mix(cMix, cC), 0, 0, 0, 0, cRGB, 0);
                                } else
                                {
                                    int shapea = shapeA[Z][X][Y] + 1;
                                    byte shapeb = shapeB[Z][X][Y];
                                    Flo overlay = Flo.cache[overlayID - 1];
                                    int texoverlay = overlay.texture;
                                    int j23;
                                    int rgbTexOverlay;
                                    if(texoverlay >= 0)
                                    {
                                        rgbTexOverlay = ThreeDimensionalDrawingArea.method369(texoverlay);
                                        j23 = -1;
                                    } else
                                    if(overlay.colour2 == 0xff00ff)
                                    {
                                        rgbTexOverlay = 0;
                                        j23 = -2;
                                        texoverlay = -1;
                                    } else
                                    {
                                        j23 = composeColour(overlay.hue, overlay.saturation, overlay.lightness);
                                        rgbTexOverlay = ThreeDimensionalDrawingArea.colourMap[method185(overlay.hslcolour, 96)];
                                    }
                                    sceneGraph.addTile(Z, X, Y, shapea, shapeb, texoverlay, zA, zB, zD, zC, mix(cMix, cA), mix(cMix, cB), mix(cMix, cD), mix(cMix, cC), method185(j23, cA), method185(j23, cB), method185(j23, cD), method185(j23, cC), cRGB, rgbTexOverlay);
                                }
                            }
                        }
                    }

                }
            }

            for(int j8 = 1; j8 < yMapSize - 1; j8++)
            {
                for(int i10 = 1; i10 < xMapSize - 1; i10++)
                    sceneGraph.method278(Z, i10, j8, method182(j8, Z, i10));

            }

        }

        sceneGraph.method305(-10, -50, -50);
        for(int j1 = 0; j1 < xMapSize; j1++)
        {
            for(int l1 = 0; l1 < yMapSize; l1++)
                if((tileSettings[1][j1][l1] & 2) == 2)
                    sceneGraph.method276(l1, j1);

        }

        int i2 = 1;
        int j2 = 2;
        int k2 = 4;
        for(int l2 = 0; l2 < 4; l2++)
        {
            if(l2 > 0)
            {
                i2 <<= 3;
                j2 <<= 3;
                k2 <<= 3;
            }
            for(int i3 = 0; i3 <= l2; i3++)
            {
                for(int k3 = 0; k3 <= yMapSize; k3++)
                {
                    for(int i4 = 0; i4 <= xMapSize; i4++)
                    {
                        if((anIntArrayArrayArray135[i3][i4][k3] & i2) != 0)
                        {
                            int k4 = k3;
                            int l5 = k3;
                            int i7 = i3;
                            int k8 = i3;
                            for(; k4 > 0 && (anIntArrayArrayArray135[i3][i4][k4 - 1] & i2) != 0; k4--);
                            for(; l5 < yMapSize && (anIntArrayArrayArray135[i3][i4][l5 + 1] & i2) != 0; l5++);
label0:
                            for(; i7 > 0; i7--)
                            {
                                for(int j10 = k4; j10 <= l5; j10++)
                                    if((anIntArrayArrayArray135[i7 - 1][i4][j10] & i2) == 0)
                                        break label0;

                            }

label1:
                            for(; k8 < l2; k8++)
                            {
                                for(int k10 = k4; k10 <= l5; k10++)
                                    if((anIntArrayArrayArray135[k8 + 1][i4][k10] & i2) == 0)
                                        break label1;

                            }

                            int l10 = ((k8 + 1) - i7) * ((l5 - k4) + 1);
                            if(l10 >= 8)
                            {
                                char c1 = '\360';
                                int k14 = heightMap[k8][i4][k4] - c1;
                                int l15 = heightMap[i7][i4][k4];
                                SceneGraph.method277(l2, i4 * 128, l15, i4 * 128, l5 * 128 + 128, k14, k4 * 128, 1);
                                for(int l16 = i7; l16 <= k8; l16++)
                                {
                                    for(int l17 = k4; l17 <= l5; l17++)
                                        anIntArrayArrayArray135[l16][i4][l17] &= ~i2;

                                }

                            }
                        }
                        if((anIntArrayArrayArray135[i3][i4][k3] & j2) != 0)
                        {
                            int l4 = i4;
                            int i6 = i4;
                            int j7 = i3;
                            int l8 = i3;
                            for(; l4 > 0 && (anIntArrayArrayArray135[i3][l4 - 1][k3] & j2) != 0; l4--);
                            for(; i6 < xMapSize && (anIntArrayArrayArray135[i3][i6 + 1][k3] & j2) != 0; i6++);
label2:
                            for(; j7 > 0; j7--)
                            {
                                for(int i11 = l4; i11 <= i6; i11++)
                                    if((anIntArrayArrayArray135[j7 - 1][i11][k3] & j2) == 0)
                                        break label2;

                            }

label3:
                            for(; l8 < l2; l8++)
                            {
                                for(int j11 = l4; j11 <= i6; j11++)
                                    if((anIntArrayArrayArray135[l8 + 1][j11][k3] & j2) == 0)
                                        break label3;

                            }

                            int k11 = ((l8 + 1) - j7) * ((i6 - l4) + 1);
                            if(k11 >= 8)
                            {
                                char c2 = '\360';
                                int l14 = heightMap[l8][l4][k3] - c2;
                                int i16 = heightMap[j7][l4][k3];
                                SceneGraph.method277(l2, l4 * 128, i16, i6 * 128 + 128, k3 * 128, l14, k3 * 128, 2);
                                for(int i17 = j7; i17 <= l8; i17++)
                                {
                                    for(int i18 = l4; i18 <= i6; i18++)
                                        anIntArrayArrayArray135[i17][i18][k3] &= ~j2;

                                }

                            }
                        }
                        if((anIntArrayArrayArray135[i3][i4][k3] & k2) != 0)
                        {
                            int i5 = i4;
                            int j6 = i4;
                            int k7 = k3;
                            int i9 = k3;
                            for(; k7 > 0 && (anIntArrayArrayArray135[i3][i4][k7 - 1] & k2) != 0; k7--);
                            for(; i9 < yMapSize && (anIntArrayArrayArray135[i3][i4][i9 + 1] & k2) != 0; i9++);
label4:
                            for(; i5 > 0; i5--)
                            {
                                for(int l11 = k7; l11 <= i9; l11++)
                                    if((anIntArrayArrayArray135[i3][i5 - 1][l11] & k2) == 0)
                                        break label4;

                            }

label5:
                            for(; j6 < xMapSize; j6++)
                            {
                                for(int i12 = k7; i12 <= i9; i12++)
                                    if((anIntArrayArrayArray135[i3][j6 + 1][i12] & k2) == 0)
                                        break label5;

                            }

                            if(((j6 - i5) + 1) * ((i9 - k7) + 1) >= 4)
                            {
                                int j12 = heightMap[i3][i5][k7];
                                SceneGraph.method277(l2, i5 * 128, j12, j6 * 128 + 128, i9 * 128 + 128, j12, k7 * 128, 4);
                                for(int k13 = i5; k13 <= j6; k13++)
                                {
                                    for(int i15 = k7; i15 <= i9; i15++)
                                        anIntArrayArrayArray135[i3][k13][i15] &= ~k2;

                                }

                            }
                        }
                    }

                }

            }

        }

    }

    private static int method172(int i, int j)
    {
        int k = (method176(i + 45365, j + 0x16713, 4) - 128) + (method176(i + 10294, j + 37821, 2) - 128 >> 1) + (method176(i, j, 1) - 128 >> 2);
        k = (int)((double)k * 0.29999999999999999D) + 35;
        if(k < 10)
            k = 10;
        else
        if(k > 60)
            k = 60;
        return k;
    }

    public static void prefetchObjects(Stream stream, OnDemandFetcher class42_sub1)
    {
label0:
        {
            int i = -1;
            do
            {
                int j = stream.readSpaceSaver();
                if(j == 0)
                    break label0;
                i += j;
                ObjectDef class46 = ObjectDef.forID(i);
                class46.method574(class42_sub1);
                do
                {
                    int k = stream.readSpaceSaver();
                    if(k == 0)
                        break;
                    stream.readUnsignedByte();
                } while(true);
            } while(true);
        }
    }

    public final void initMapTables(int i, int j, int l, int i1)
    {
        for(int j1 = i; j1 <= i + j; j1++)
        {
            for(int k1 = i1; k1 <= i1 + l; k1++)
                if(k1 >= 0 && k1 < xMapSize && j1 >= 0 && j1 < yMapSize)
                {
                    aByteArrayArrayArray134[0][k1][j1] = 127;
                    if(k1 == i1 && k1 > 0)
                        heightMap[0][k1][j1] = heightMap[0][k1 - 1][j1];
                    if(k1 == i1 + l && k1 < xMapSize - 1)
                        heightMap[0][k1][j1] = heightMap[0][k1 + 1][j1];
                    if(j1 == i && j1 > 0)
                        heightMap[0][k1][j1] = heightMap[0][k1][j1 - 1];
                    if(j1 == i + j && j1 < yMapSize - 1)
                        heightMap[0][k1][j1] = heightMap[0][k1][j1 + 1];
                }

        }
    }

    private void addObjectToRenderer(int i, SceneGraph sceneGraph, TileSetting tileSetting, int j, int k, int l, int i1,
                                 int j1)
    {
        if(lowMem && (tileSettings[0][l][i] & 2) == 0)
        {
            if((tileSettings[k][l][i] & 0x10) != 0)
                return;
            if(method182(i, k, l) != anInt131)
                return;
        }
        if(k < setZ)
            setZ = k;
        int zA = heightMap[k][l][i];
        int zB = heightMap[k][l + 1][i];
        int zD = heightMap[k][l + 1][i + 1];
        int zC = heightMap[k][l][i + 1];
        int zMix = zA + zB + zD + zC >> 2;
        ObjectDef class46 = ObjectDef.forID(i1);
        int idTag = l + (i << 7) + (i1 << 14) + 0x40000000;
        if(!class46.hasActions)
            idTag += 0x80000000;
        byte objConf = (byte)((j1 << 6) + j);
        if(j == 22)
        {
            if(lowMem && !class46.hasActions && !class46.aBoolean736)
                return;
            Object obj;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj = class46.method578(22, j1, zA, zB, zD, zC, -1);
            else
                obj = new ObjectOnTile(i1, j1, 22, zB, zD, zA, zC, class46.anInt781, true);
            sceneGraph.addObj3(k, zMix, i, ((Animable) (obj)), objConf, idTag, l);
            if(class46.aBoolean767 && class46.hasActions && tileSetting != null)
                tileSetting.orClipTableSET(i, l);
            return;
        }
        if(j == 10 || j == 11)
        {
            Object obj1;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj1 = class46.method578(10, j1, zA, zB, zD, zC, -1);
            else
                obj1 = new ObjectOnTile(i1, j1, 10, zB, zD, zA, zC, class46.anInt781, true);
            if(obj1 != null)
            {
                int i5 = 0;
                if(j == 11)
                    i5 += 256;
                int j4;
                int l4;
                if(j1 == 1 || j1 == 3)
                {
                    j4 = class46.anInt761;
                    l4 = class46.anInt744;
                } else
                {
                    j4 = class46.anInt744;
                    l4 = class46.anInt761;
                }
                if(sceneGraph.addEntityB(idTag, objConf, zMix, l4, ((Animable) (obj1)), j4, k, i5, i, l) && class46.aBoolean779)
                {
                    Model model;
                    if(obj1 instanceof Model)
                        model = (Model)obj1;
                    else
                        model = class46.method578(10, j1, zA, zB, zD, zC, -1);
                    if(model != null)
                    {
                        for(int j5 = 0; j5 <= j4; j5++)
                        {
                            for(int k5 = 0; k5 <= l4; k5++)
                            {
                                int l5 = model.anInt1650 / 4;
                                if(l5 > 30)
                                    l5 = 30;
                                if(l5 > aByteArrayArrayArray134[k][l + j5][i + k5])
                                    aByteArrayArrayArray134[k][l + j5][i + k5] = (byte)l5;
                            }

                        }

                    }
                }
            }
            if(class46.aBoolean767 && tileSetting != null)
                tileSetting.method212(class46.aBoolean757, class46.anInt744, class46.anInt761, l, i, j1);
            return;
        }
        if(j >= 12)
        {
            Object obj2;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj2 = class46.method578(j, j1, zA, zB, zD, zC, -1);
            else
                obj2 = new ObjectOnTile(i1, j1, j, zB, zD, zA, zC, class46.anInt781, true);
            sceneGraph.addEntityB(idTag, objConf, zMix, 1, ((Animable) (obj2)), 1, k, 0, i, l);
            if(j >= 12 && j <= 17 && j != 13 && k > 0)
                anIntArrayArrayArray135[k][l][i] |= 0x924;
            if(class46.aBoolean767 && tileSetting != null)
                tileSetting.method212(class46.aBoolean757, class46.anInt744, class46.anInt761, l, i, j1);
            return;
        }
        if(j == 0)
        {
            Object obj3;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj3 = class46.method578(0, j1, zA, zB, zD, zC, -1);
            else
                obj3 = new ObjectOnTile(i1, j1, 0, zB, zD, zA, zC, class46.anInt781, true);
            sceneGraph.addObject1(bitValues[j1], ((Animable) (obj3)), idTag, i, objConf, l, null, zMix, 0, k);
            if(j1 == 0)
            {
                if(class46.aBoolean779)
                {
                    aByteArrayArrayArray134[k][l][i] = 50;
                    aByteArrayArrayArray134[k][l][i + 1] = 50;
                }
                if(class46.aBoolean764)
                    anIntArrayArrayArray135[k][l][i] |= 0x249;
            } else
            if(j1 == 1)
            {
                if(class46.aBoolean779)
                {
                    aByteArrayArrayArray134[k][l][i + 1] = 50;
                    aByteArrayArrayArray134[k][l + 1][i + 1] = 50;
                }
                if(class46.aBoolean764)
                    anIntArrayArrayArray135[k][l][i + 1] |= 0x492;
            } else
            if(j1 == 2)
            {
                if(class46.aBoolean779)
                {
                    aByteArrayArrayArray134[k][l + 1][i] = 50;
                    aByteArrayArrayArray134[k][l + 1][i + 1] = 50;
                }
                if(class46.aBoolean764)
                    anIntArrayArrayArray135[k][l + 1][i] |= 0x249;
            } else
            if(j1 == 3)
            {
                if(class46.aBoolean779)
                {
                    aByteArrayArrayArray134[k][l][i] = 50;
                    aByteArrayArrayArray134[k][l + 1][i] = 50;
                }
                if(class46.aBoolean764)
                    anIntArrayArrayArray135[k][l][i] |= 0x492;
            }
            if(class46.aBoolean767 && tileSetting != null)
                tileSetting.method211(i, j1, l, j, class46.aBoolean757);
            if(class46.anInt775 != 16)
                sceneGraph.method290(i, class46.anInt775, l, k);
            return;
        }
        if(j == 1)
        {
            Object obj4;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj4 = class46.method578(1, j1, zA, zB, zD, zC, -1);
            else
                obj4 = new ObjectOnTile(i1, j1, 1, zB, zD, zA, zC, class46.anInt781, true);
            sceneGraph.addObject1(anIntArray140[j1], ((Animable) (obj4)), idTag, i, objConf, l, null, zMix, 0, k);
            if(class46.aBoolean779)
                if(j1 == 0)
                    aByteArrayArrayArray134[k][l][i + 1] = 50;
                else
                if(j1 == 1)
                    aByteArrayArrayArray134[k][l + 1][i + 1] = 50;
                else
                if(j1 == 2)
                    aByteArrayArrayArray134[k][l + 1][i] = 50;
                else
                if(j1 == 3)
                    aByteArrayArrayArray134[k][l][i] = 50;
            if(class46.aBoolean767 && tileSetting != null)
                tileSetting.method211(i, j1, l, j, class46.aBoolean757);
            return;
        }
        if(j == 2)
        {
            int i3 = j1 + 1 & 3;
            Object obj11;
            Object obj12;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
            {
                obj11 = class46.method578(2, 4 + j1, zA, zB, zD, zC, -1);
                obj12 = class46.method578(2, i3, zA, zB, zD, zC, -1);
            } else
            {
                obj11 = new ObjectOnTile(i1, 4 + j1, 2, zB, zD, zA, zC, class46.anInt781, true);
                obj12 = new ObjectOnTile(i1, i3, 2, zB, zD, zA, zC, class46.anInt781, true);
            }
            sceneGraph.addObject1(bitValues[j1], ((Animable) (obj11)), idTag, i, objConf, l, ((Animable) (obj12)), zMix, bitValues[i3], k);
            if(class46.aBoolean764)
                if(j1 == 0)
                {
                    anIntArrayArrayArray135[k][l][i] |= 0x249;
                    anIntArrayArrayArray135[k][l][i + 1] |= 0x492;
                } else
                if(j1 == 1)
                {
                    anIntArrayArrayArray135[k][l][i + 1] |= 0x492;
                    anIntArrayArrayArray135[k][l + 1][i] |= 0x249;
                } else
                if(j1 == 2)
                {
                    anIntArrayArrayArray135[k][l + 1][i] |= 0x249;
                    anIntArrayArrayArray135[k][l][i] |= 0x492;
                } else
                if(j1 == 3)
                {
                    anIntArrayArrayArray135[k][l][i] |= 0x492;
                    anIntArrayArrayArray135[k][l][i] |= 0x249;
                }
            if(class46.aBoolean767 && tileSetting != null)
                tileSetting.method211(i, j1, l, j, class46.aBoolean757);
            if(class46.anInt775 != 16)
                sceneGraph.method290(i, class46.anInt775, l, k);
            return;
        }
        if(j == 3)
        {
            Object obj5;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj5 = class46.method578(3, j1, zA, zB, zD, zC, -1);
            else
                obj5 = new ObjectOnTile(i1, j1, 3, zB, zD, zA, zC, class46.anInt781, true);
            sceneGraph.addObject1(anIntArray140[j1], ((Animable) (obj5)), idTag, i, objConf, l, null, zMix, 0, k);
            if(class46.aBoolean779)
                if(j1 == 0)
                    aByteArrayArrayArray134[k][l][i + 1] = 50;
                else
                if(j1 == 1)
                    aByteArrayArrayArray134[k][l + 1][i + 1] = 50;
                else
                if(j1 == 2)
                    aByteArrayArrayArray134[k][l + 1][i] = 50;
                else
                if(j1 == 3)
                    aByteArrayArrayArray134[k][l][i] = 50;
            if(class46.aBoolean767 && tileSetting != null)
                tileSetting.method211(i, j1, l, j, class46.aBoolean757);
            return;
        }
        if(j == 9)
        {
            Object obj6;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj6 = class46.method578(j, j1, zA, zB, zD, zC, -1);
            else
                obj6 = new ObjectOnTile(i1, j1, j, zB, zD, zA, zC, class46.anInt781, true);
            sceneGraph.addEntityB(idTag, objConf, zMix, 1, ((Animable) (obj6)), 1, k, 0, i, l);
            if(class46.aBoolean767 && tileSetting != null)
                tileSetting.method212(class46.aBoolean757, class46.anInt744, class46.anInt761, l, i, j1);
            return;
        }
        if(class46.aBoolean762)
            if(j1 == 1)
            {
                int j3 = zC;
                zC = zD;
                zD = zB;
                zB = zA;
                zA = j3;
            } else
            if(j1 == 2)
            {
                int k3 = zC;
                zC = zB;
                zB = k3;
                k3 = zD;
                zD = zA;
                zA = k3;
            } else
            if(j1 == 3)
            {
                int l3 = zC;
                zC = zA;
                zA = zB;
                zB = zD;
                zD = l3;
            }
        if(j == 4)
        {
            Object obj7;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj7 = class46.method578(4, 0, zA, zB, zD, zC, -1);
            else
                obj7 = new ObjectOnTile(i1, 0, 4, zB, zD, zA, zC, class46.anInt781, true);
            sceneGraph.addObject(idTag, i, j1 * 512, k, 0, zMix, ((Animable) (obj7)), l, objConf, 0, bitValues[j1]);
            return;
        }
        if(j == 5)
        {
            int i4 = 16;
            int k4 = sceneGraph.method300(k, l, i);
            if(k4 > 0)
                i4 = ObjectDef.forID(k4 >> 14 & 0x7fff).anInt775;
            Object obj13;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj13 = class46.method578(4, 0, zA, zB, zD, zC, -1);
            else
                obj13 = new ObjectOnTile(i1, 0, 4, zB, zD, zA, zC, class46.anInt781, true);
            sceneGraph.addObject(idTag, i, j1 * 512, k, faceXOffset[j1] * i4, zMix, ((Animable) (obj13)), l, objConf, faceYOffset[j1] * i4, bitValues[j1]);
            return;
        }
        if(j == 6)
        {
            Object obj8;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj8 = class46.method578(4, 0, zA, zB, zD, zC, -1);
            else
                obj8 = new ObjectOnTile(i1, 0, 4, zB, zD, zA, zC, class46.anInt781, true);
            sceneGraph.addObject(idTag, i, j1, k, 0, zMix, ((Animable) (obj8)), l, objConf, 0, 256);
            return;
        }
        if(j == 7)
        {
            Object obj9;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj9 = class46.method578(4, 0, zA, zB, zD, zC, -1);
            else
                obj9 = new ObjectOnTile(i1, 0, 4, zB, zD, zA, zC, class46.anInt781, true);
            sceneGraph.addObject(idTag, i, j1, k, 0, zMix, ((Animable) (obj9)), l, objConf, 0, 512);
            return;
        }
        if(j == 8)
        {
            Object obj10;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj10 = class46.method578(4, 0, zA, zB, zD, zC, -1);
            else
                obj10 = new ObjectOnTile(i1, 0, 4, zB, zD, zA, zC, class46.anInt781, true);
            sceneGraph.addObject(idTag, i, j1, k, 0, zMix, ((Animable) (obj10)), l, objConf, 0, 768);
        }
    }

    private static int method176(int i, int j, int k)
    {
        int l = i / k;
        int i1 = i & k - 1;
        int j1 = j / k;
        int k1 = j & k - 1;
        int l1 = method186(l, j1);
        int i2 = method186(l + 1, j1);
        int j2 = method186(l, j1 + 1);
        int k2 = method186(l + 1, j1 + 1);
        int l2 = method184(l1, i2, i1, k);
        int i3 = method184(j2, k2, i1, k);
        return method184(l2, i3, k1, k);
    }

    private int composeColour(int i, int j, int k)
    {
        if(k > 179)
            j /= 2;
        if(k > 192)
            j /= 2;
        if(k > 217)
            j /= 2;
        if(k > 243)
            j /= 2;
        return (i / 4 << 10) + (j / 32 << 7) + k / 2;
    }

    public static boolean method178(int i, int j)
    {
        ObjectDef class46 = ObjectDef.forID(i);
        if(j == 11)
            j = 10;
        if(j >= 5 && j <= 8)
            j = 4;
        return class46.method577(j);
    }

    public final void method179(int i, int j, TileSetting aclass11[], int l, int i1, byte abyte0[],
                                int j1, int k1, int l1)
    {
        for(int i2 = 0; i2 < 8; i2++)
        {
            for(int j2 = 0; j2 < 8; j2++)
                if(l + i2 > 0 && l + i2 < 103 && l1 + j2 > 0 && l1 + j2 < 103)
                    aclass11[k1].clipData[l + i2][l1 + j2] &= 0xfeffffff;

        }
        Stream stream = new Stream(abyte0);
        for(int l2 = 0; l2 < 4; l2++)
        {
            for(int i3 = 0; i3 < 64; i3++)
            {
                for(int j3 = 0; j3 < 64; j3++)
                    if(l2 == i && i3 >= i1 && i3 < i1 + 8 && j3 >= j1 && j3 < j1 + 8)
                        readTile(l1 + Class4.method156(j3 & 7, j, i3 & 7), 0, stream, l + Class4.method155(j, j3 & 7, i3 & 7), k1, j, 0);
                    else
                        readTile(-1, 0, stream, -1, 0, 0, 0);

            }

        }

    }

    public final void readMapzor(byte abyte0[], int i, int j, int k, int l, TileSetting aclass11[])
    {
        for(int i1 = 0; i1 < 4; i1++)
        {
            for(int j1 = 0; j1 < 64; j1++)
            {
                for(int k1 = 0; k1 < 64; k1++)
                    if(j + j1 > 0 && j + j1 < 103 && i + k1 > 0 && i + k1 < 103)
                        aclass11[i1].clipData[j + j1][i + k1] &= 0xfeffffff;

            }

        }

        Stream stream = new Stream(abyte0);
        for(int l1 = 0; l1 < 4; l1++)
        {
            for(int i2 = 0; i2 < 64; i2++)
            {
                for(int j2 = 0; j2 < 64; j2++)
                    readTile(j2 + i, l, stream, i2 + j, l1, 0, k);

            }

        }
    }

    private void readTile(int i, int j, Stream stream, int k, int l, int i1,
                                 int k1)
    {
        if(k >= 0 && k < 104 && i >= 0 && i < 104)
        {
            tileSettings[l][k][i] = 0;
            do
            {
                int l1 = stream.readUnsignedByte();
                if(l1 == 0)
                    if(l == 0)
                    {
                        heightMap[0][k][i] = -method172(0xe3b7b + k + k1, 0x87cce + i + j) * 8;
                        return;
                    } else
                    {
                        heightMap[l][k][i] = heightMap[l - 1][k][i] - 240;
                        return;
                    }
                if(l1 == 1)
                {
                    int j2 = stream.readUnsignedByte();
                    if(j2 == 1)
                        j2 = 0;
                    if(l == 0)
                    {
                        heightMap[0][k][i] = -j2 * 8;
                        return;
                    } else
                    {
                        heightMap[l][k][i] = heightMap[l - 1][k][i] - j2 * 8;
                        return;
                    }
                }
                if(l1 <= 49)
                {
                    overLay[l][k][i] = stream.readSignedByte();
                    shapeA[l][k][i] = (byte)((l1 - 2) / 4);
                    shapeB[l][k][i] = (byte)((l1 - 2) + i1 & 3);
                } else
                if(l1 <= 81)
                    tileSettings[l][k][i] = (byte)(l1 - 49);
                else
                    underLay[l][k][i] = (byte)(l1 - 81);
            } while(true);
        }
        do
        {
            int i2 = stream.readUnsignedByte();
            if(i2 == 0)
                break;
            if(i2 == 1)
            {
                stream.readUnsignedByte();
                return;
            }
            if(i2 <= 49)
                stream.readUnsignedByte();
        } while(true);
    }

    private int method182(int i, int j, int k)
    {
        if((tileSettings[j][k][i] & 8) != 0)
            return 0;
        if(j > 0 && (tileSettings[1][k][i] & 2) != 0)
            return j - 1;
        else
            return j;
    }

    public final void method183(TileSetting aclass11[], SceneGraph sceneGraph, int i, int j, int k, int l,
                                byte abyte0[], int i1, int j1, int k1)
    {
label0:
        {
            Stream stream = new Stream(abyte0);
            int l1 = -1;
            do
            {
                int i2 = stream.readSpaceSaver();
                if(i2 == 0)
                    break label0;
                l1 += i2;
                int j2 = 0;
                do
                {
                    int k2 = stream.readSpaceSaver();
                    if(k2 == 0)
                        break;
                    j2 += k2 - 1;
                    int l2 = j2 & 0x3f;
                    int i3 = j2 >> 6 & 0x3f;
                    int j3 = j2 >> 12;
                    int k3 = stream.readUnsignedByte();
                    int l3 = k3 >> 2;
                    int i4 = k3 & 3;
                    if(j3 == i && i3 >= i1 && i3 < i1 + 8 && l2 >= k && l2 < k + 8)
                    {
                        ObjectDef class46 = ObjectDef.forID(l1);
                        int j4 = j + Class4.method157(j1, class46.anInt761, i3 & 7, l2 & 7, class46.anInt744);
                        int k4 = k1 + Class4.method158(l2 & 7, class46.anInt761, j1, class46.anInt744, i3 & 7);
                        if(j4 > 0 && k4 > 0 && j4 < 103 && k4 < 103)
                        {
                            int l4 = j3;
                            if((tileSettings[1][j4][k4] & 2) == 2)
                                l4--;
                            TileSetting tileSetting = null;
                            if(l4 >= 0)
                                tileSetting = aclass11[l4];
                            addObjectToRenderer(k4, sceneGraph, tileSetting, l3, l, j4, l1, i4 + j1 & 3);
                        }
                    }
                } while(true);
            } while(true);
        }
    }

    private static int method184(int i, int j, int k, int l)
    {
        int i1 = 0x10000 - ThreeDimensionalDrawingArea.COSINE[(k * 1024) / l] >> 1;
        return (i * (0x10000 - i1) >> 16) + (j * i1 >> 16);
    }

    private int method185(int i, int j)
    {
        if(i == -2)
            return 0xbc614e;
        if(i == -1)
        {
            if(j < 0)
                j = 0;
            else
            if(j > 127)
                j = 127;
            j = 127 - j;
            return j;
        }
        j = (j * (i & 0x7f)) / 128;
        if(j < 2)
            j = 2;
        else
        if(j > 126)
            j = 126;
        return (i & 0xff80) + j;
    }

    private static int method186(int i, int j)
    {
        int k = method170(i - 1, j - 1) + method170(i + 1, j - 1) + method170(i - 1, j + 1) + method170(i + 1, j + 1);
        int l = method170(i - 1, j) + method170(i + 1, j) + method170(i, j - 1) + method170(i, j + 1);
        int i1 = method170(i, j);
        return k / 16 + l / 8 + i1 / 4;
    }

    private static int mix(int i, int j)
    {
        if(i == -1)
            return 0xbc614e;
        j = (j * (i & 0x7f)) / 128;
        if(j < 2)
            j = 2;
        else
        if(j > 126)
            j = 126;
        return (i & 0xff80) + j;
    }

    public static void method188(SceneGraph sceneGraph, int i, int j, int k, int l, TileSetting tileSetting, int ai[][][], int i1,
                                 int j1, int k1)
    {
        int l1 = ai[l][i1][j];
        int i2 = ai[l][i1 + 1][j];
        int j2 = ai[l][i1 + 1][j + 1];
        int k2 = ai[l][i1][j + 1];
        int l2 = l1 + i2 + j2 + k2 >> 2;
        ObjectDef class46 = ObjectDef.forID(j1);
        int i3 = i1 + (j << 7) + (j1 << 14) + 0x40000000;
        if(!class46.hasActions)
            i3 += 0x80000000;
        byte byte1 = (byte)((i << 6) + k);
        if(k == 22)
        {
            Object obj;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj = class46.method578(22, i, l1, i2, j2, k2, -1);
            else
                obj = new ObjectOnTile(j1, i, 22, i2, j2, l1, k2, class46.anInt781, true);
            sceneGraph.addObj3(k1, l2, j, ((Animable) (obj)), byte1, i3, i1);
            if(class46.aBoolean767 && class46.hasActions)
                tileSetting.orClipTableSET(j, i1);
            return;
        }
        if(k == 10 || k == 11)
        {
            Object obj1;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj1 = class46.method578(10, i, l1, i2, j2, k2, -1);
            else
                obj1 = new ObjectOnTile(j1, i, 10, i2, j2, l1, k2, class46.anInt781, true);
            if(obj1 != null)
            {
                int j5 = 0;
                if(k == 11)
                    j5 += 256;
                int k4;
                int i5;
                if(i == 1 || i == 3)
                {
                    k4 = class46.anInt761;
                    i5 = class46.anInt744;
                } else
                {
                    k4 = class46.anInt744;
                    i5 = class46.anInt761;
                }
                sceneGraph.addEntityB(i3, byte1, l2, i5, ((Animable) (obj1)), k4, k1, j5, j, i1);
            }
            if(class46.aBoolean767)
                tileSetting.method212(class46.aBoolean757, class46.anInt744, class46.anInt761, i1, j, i);
            return;
        }
        if(k >= 12)
        {
            Object obj2;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj2 = class46.method578(k, i, l1, i2, j2, k2, -1);
            else
                obj2 = new ObjectOnTile(j1, i, k, i2, j2, l1, k2, class46.anInt781, true);
            sceneGraph.addEntityB(i3, byte1, l2, 1, ((Animable) (obj2)), 1, k1, 0, j, i1);
            if(class46.aBoolean767)
                tileSetting.method212(class46.aBoolean757, class46.anInt744, class46.anInt761, i1, j, i);
            return;
        }
        if(k == 0)
        {
            Object obj3;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj3 = class46.method578(0, i, l1, i2, j2, k2, -1);
            else
                obj3 = new ObjectOnTile(j1, i, 0, i2, j2, l1, k2, class46.anInt781, true);
            sceneGraph.addObject1(bitValues[i], ((Animable) (obj3)), i3, j, byte1, i1, null, l2, 0, k1);
            if(class46.aBoolean767)
                tileSetting.method211(j, i, i1, k, class46.aBoolean757);
            return;
        }
        if(k == 1)
        {
            Object obj4;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj4 = class46.method578(1, i, l1, i2, j2, k2, -1);
            else
                obj4 = new ObjectOnTile(j1, i, 1, i2, j2, l1, k2, class46.anInt781, true);
            sceneGraph.addObject1(anIntArray140[i], ((Animable) (obj4)), i3, j, byte1, i1, null, l2, 0, k1);
            if(class46.aBoolean767)
                tileSetting.method211(j, i, i1, k, class46.aBoolean757);
            return;
        }
        if(k == 2)
        {
            int j3 = i + 1 & 3;
            Object obj11;
            Object obj12;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
            {
                obj11 = class46.method578(2, 4 + i, l1, i2, j2, k2, -1);
                obj12 = class46.method578(2, j3, l1, i2, j2, k2, -1);
            } else
            {
                obj11 = new ObjectOnTile(j1, 4 + i, 2, i2, j2, l1, k2, class46.anInt781, true);
                obj12 = new ObjectOnTile(j1, j3, 2, i2, j2, l1, k2, class46.anInt781, true);
            }
            sceneGraph.addObject1(bitValues[i], ((Animable) (obj11)), i3, j, byte1, i1, ((Animable) (obj12)), l2, bitValues[j3], k1);
            if(class46.aBoolean767)
                tileSetting.method211(j, i, i1, k, class46.aBoolean757);
            return;
        }
        if(k == 3)
        {
            Object obj5;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj5 = class46.method578(3, i, l1, i2, j2, k2, -1);
            else
                obj5 = new ObjectOnTile(j1, i, 3, i2, j2, l1, k2, class46.anInt781, true);
            sceneGraph.addObject1(anIntArray140[i], ((Animable) (obj5)), i3, j, byte1, i1, null, l2, 0, k1);
            if(class46.aBoolean767)
                tileSetting.method211(j, i, i1, k, class46.aBoolean757);
            return;
        }
        if(k == 9)
        {
            Object obj6;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj6 = class46.method578(k, i, l1, i2, j2, k2, -1);
            else
                obj6 = new ObjectOnTile(j1, i, k, i2, j2, l1, k2, class46.anInt781, true);
            sceneGraph.addEntityB(i3, byte1, l2, 1, ((Animable) (obj6)), 1, k1, 0, j, i1);
            if(class46.aBoolean767)
                tileSetting.method212(class46.aBoolean757, class46.anInt744, class46.anInt761, i1, j, i);
            return;
        }
        if(class46.aBoolean762)
            if(i == 1)
            {
                int k3 = k2;
                k2 = j2;
                j2 = i2;
                i2 = l1;
                l1 = k3;
            } else
            if(i == 2)
            {
                int l3 = k2;
                k2 = i2;
                i2 = l3;
                l3 = j2;
                j2 = l1;
                l1 = l3;
            } else
            if(i == 3)
            {
                int i4 = k2;
                k2 = l1;
                l1 = i2;
                i2 = j2;
                j2 = i4;
            }
        if(k == 4)
        {
            Object obj7;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj7 = class46.method578(4, 0, l1, i2, j2, k2, -1);
            else
                obj7 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.anInt781, true);
            sceneGraph.addObject(i3, j, i * 512, k1, 0, l2, ((Animable) (obj7)), i1, byte1, 0, bitValues[i]);
            return;
        }
        if(k == 5)
        {
            int j4 = 16;
            int l4 = sceneGraph.method300(k1, i1, j);
            if(l4 > 0)
                j4 = ObjectDef.forID(l4 >> 14 & 0x7fff).anInt775;
            Object obj13;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj13 = class46.method578(4, 0, l1, i2, j2, k2, -1);
            else
                obj13 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.anInt781, true);
            sceneGraph.addObject(i3, j, i * 512, k1, faceXOffset[i] * j4, l2, ((Animable) (obj13)), i1, byte1, faceYOffset[i] * j4, bitValues[i]);
            return;
        }
        if(k == 6)
        {
            Object obj8;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj8 = class46.method578(4, 0, l1, i2, j2, k2, -1);
            else
                obj8 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.anInt781, true);
            sceneGraph.addObject(i3, j, i, k1, 0, l2, ((Animable) (obj8)), i1, byte1, 0, 256);
            return;
        }
        if(k == 7)
        {
            Object obj9;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj9 = class46.method578(4, 0, l1, i2, j2, k2, -1);
            else
                obj9 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.anInt781, true);
            sceneGraph.addObject(i3, j, i, k1, 0, l2, ((Animable) (obj9)), i1, byte1, 0, 512);
            return;
        }
        if(k == 8)
        {
            Object obj10;
            if(class46.anInt781 == -1 && class46.childrenIDs == null)
                obj10 = class46.method578(4, 0, l1, i2, j2, k2, -1);
            else
                obj10 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.anInt781, true);
            sceneGraph.addObject(i3, j, i, k1, 0, l2, ((Animable) (obj10)), i1, byte1, 0, 768);
        }
    }

  public static boolean method189(int i, byte[] is, int i_250_
  ) //xxx bad method, decompiled with JODE
  {
    boolean bool = true;
    Stream stream = new Stream(is);
    int i_252_ = -1;
    for (;;)
      {
	int i_253_ = stream.readSpaceSaver();
	if (i_253_ == 0)
	  break;
	i_252_ += i_253_;
	int i_254_ = 0;
	boolean bool_255_ = false;
	for (;;)
	  {
	    if (bool_255_)
	      {
		int i_256_ = stream.readSpaceSaver();
		if (i_256_ == 0)
		  break;
		stream.readUnsignedByte();
	      }
	    else
	      {
		int i_257_ = stream.readSpaceSaver();
		if (i_257_ == 0)
		  break;
		i_254_ += i_257_ - 1;
		int i_258_ = i_254_ & 0x3f;
		int i_259_ = i_254_ >> 6 & 0x3f;
		int i_260_ = stream.readUnsignedByte() >> 2;
		int i_261_ = i_259_ + i;
		int i_262_ = i_258_ + i_250_;
		if (i_261_ > 0 && i_262_ > 0 && i_261_ < 103 && i_262_ < 103)
		  {
		    ObjectDef class46 = ObjectDef.forID (i_252_);
		    if (i_260_ != 22 || !lowMem || class46.hasActions
                    || class46.aBoolean736)
		      {
			bool &= class46.method579 ();
			bool_255_ = true;
		      }
		  }
	      }
	  }
      }
    return bool;
  }

    public final void method190(int xOff, TileSetting aclass11[], int yOff, SceneGraph sceneGraph, byte abyte0[])
    {
label0:
        {
            Stream stream = new Stream(abyte0);
            int objID = -1;
            do
            {
                int readOID = stream.readSpaceSaver();
                if(readOID == 0)
                    break label0;
                objID += readOID;
                int coordSetting = 0;
                do
                {
                    int coordSS = stream.readSpaceSaver();
                    if(coordSS == 0)
                        break;
                    coordSetting += coordSS - 1;
                    int rY = coordSetting & 0x3f;
                    int rX = coordSetting >> 6 & 0x3f;
                    int Z = coordSetting >> 12;
                    int objByte = stream.readUnsignedByte();
                    int objType = objByte >> 2;
                    int face = objByte & 3;
                    int X = rX + xOff;
                    int Y = rY + yOff;
                    if(X > 0 && Y > 0 && X < 103 && Y < 103)
                    {
                        int l3 = Z;
                        if((tileSettings[1][X][Y] & 2) == 2)
                            l3--;
                        TileSetting tileSetting = null;
                        if(l3 >= 0)
                            tileSetting = aclass11[l3];
                        addObjectToRenderer(Y, sceneGraph, tileSetting, objType, Z, X, objID, face);
                    }
                } while(true);
            } while(true);
        }
    }

    private static int anInt123 = (int)(Math.random() * 17D) - 8;
    private final int[] hue;
    private final int[] saturation;
    private final int[] lightness;
    private final int[] huedivider;
    private final int[] colourCount;
    private final int[][][] heightMap;
    private final byte[][][] overLay;
    static int anInt131;
    private static int anInt133 = (int)(Math.random() * 33D) - 16;
    private final byte[][][] aByteArrayArrayArray134;
    private final int[][][] anIntArrayArrayArray135;
    private final byte[][][] shapeA;
    private static final int faceXOffset[] = {
        1, 0, -1, 0
    };
    private static final int anInt138 = 323;
    private final int[][] colourArray;
    private static final int anIntArray140[] = {
        16, 32, 64, 128
    };
    private final byte[][][] underLay;
    private static final int faceYOffset[] = {
        0, -1, 0, 1
    };
    static int setZ = 99;
    private final int xMapSize;
    private final int yMapSize;
    private final byte[][][] shapeB;
    private final byte[][][] tileSettings;
    static boolean lowMem = true;
    private static final int bitValues[] = {
        1, 2, 4, 8
    };

}
