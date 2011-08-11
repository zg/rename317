package rs2;


import rt4.TriangleNormal;

public class Model extends Entity {

    public VertexNormal[] vns;
    public int[] triangleNormalX;
    public int[] triangleNormalY;
    public int[] triangleNormalZ;
    public short[] triangleTexture;
    public TriangleNormal[] triangleNormals;
    public long hash;
    public static void clearCache() {
        modelHeaderCache = null;
        aBooleanArray1663 = null;
        aBooleanArray1664 = null;
        vertexSX = null;
        vertexSY = null;
        depthBuffer = null;
        vertexMvX = null;
        vertexMvY = null;
        vertexMvZ = null;
        depthListIndices = null;
        faceLists = null;
        anIntArray1673 = null;
        anIntArrayArray1674 = null;
        anIntArray1675 = null;
        anIntArray1676 = null;
        anIntArray1677 = null;
        SINE = null;
        COSINE = null;
        HSL2RGB = null;
        modelIntArray4 = null;
    }

    public static void initialize(int i, OnDemandFetcherParent onDemandFetcherParent) {
        modelHeaderCache = new ModelHeader[i + 70000];//wtf PETER!!!
        abstractODFetcher = onDemandFetcherParent;
    }


    public Model(int modelId, int j) {
        byte[] is = modelHeaderCache[modelId].modelData;
        if (is[is.length - 1] == -1 && is[is.length - 2] == -1)
            readNewModel(is, modelId);
        else
            readOldModel(modelId);
    }

    private void readOldModel(int i) {
        //int j = -870;
        //anInt1614 = 9;
        //aBoolean1615 = false;
        //anInt1616 = 360;
        //anInt1617 = 1;
        //aBoolean1618 = true;
        oneSquareModel = false;
        //anInt1620++;
        hash = i;
        ModelHeader class21 = modelHeaderCache[i];
        vertexCount = class21.modelVerticeCount;
        triangleCount = class21.modelTriangleCount;
        textureTriangleCount = class21.modelTextureTriangleCount;
        vertexX = new int[vertexCount];//vertexX
        vertexY = new int[vertexCount];//vy
        vertexZ = new int[vertexCount];//vz
        triangleA = new int[triangleCount];//trianglea
        triangleB = new int[triangleCount];//b
        triangleC = new int[triangleCount];//c
        triPIndex = new int[textureTriangleCount];//tri_a_buffer
        triMIndex = new int[textureTriangleCount];//b
        triNIndex = new int[textureTriangleCount];//c
        if (class21.vskinBasePos >= 0)
            vertexVSkin = new int[vertexCount];//vertex_vskin
        if (class21.drawTypeBasePos >= 0)
            triangleDrawType = new int[triangleCount];//triangle_draw_type
        if (class21.facePriorityBasePos >= 0)
            facePriority = new int[triangleCount];//face_priority
        else
            anInt1641 = -class21.facePriorityBasePos - 1;
        if (class21.alphaBasepos >= 0)//alpha_basepos
            triangleAlpha = new int[triangleCount];//triangleAlpha
        if (class21.tskinBasepos >= 0)//tskin_basepos
            triangleTSkin = new int[triangleCount];//triangle_tskin
        triangleColour = new int[triangleCount];//triangleColour
        
        Packet class30_sub2_sub2 = new Packet(class21.modelData);
        class30_sub2_sub2.pos = class21.vertexModOffset;
        
        Packet class30_sub2_sub2_1 = new Packet(class21.modelData);
        class30_sub2_sub2_1.pos = class21.vertexXOffset;
        
        Packet class30_sub2_sub2_2 = new Packet(class21.modelData);
        class30_sub2_sub2_2.pos = class21.vertexYOffset;
        
        Packet class30_sub2_sub2_3 = new Packet(class21.modelData);
        class30_sub2_sub2_3.pos = class21.vertexZOffset;
        
        Packet class30_sub2_sub2_4 = new Packet(class21.modelData);
        class30_sub2_sub2_4.pos = class21.vskinBasePos;
        
        int k = 0;
        int l = 0;
        int i1 = 0;
        for (int j1 = 0; j1 < vertexCount; j1++) {
            int k1 = class30_sub2_sub2.g1();
            int i2 = 0;
            if ((k1 & 1) != 0)
                i2 = class30_sub2_sub2_1.gsmart();
            int k2 = 0;
            if ((k1 & 2) != 0)
                k2 = class30_sub2_sub2_2.gsmart();
            int i3 = 0;
            if ((k1 & 4) != 0)
                i3 = class30_sub2_sub2_3.gsmart();
            vertexX[j1] = k + i2;
            vertexY[j1] = l + k2;
            vertexZ[j1] = i1 + i3;
            k = vertexX[j1];
            l = vertexY[j1];
            i1 = vertexZ[j1];
            if (vertexVSkin != null)
                vertexVSkin[j1] = class30_sub2_sub2_4.g1();
        }

        class30_sub2_sub2.pos = class21.triColourOffset;
        class30_sub2_sub2_1.pos = class21.drawTypeBasePos;
        class30_sub2_sub2_2.pos = class21.facePriorityBasePos;
        class30_sub2_sub2_3.pos = class21.alphaBasepos;
        class30_sub2_sub2_4.pos = class21.tskinBasepos;
        for (int l1 = 0; l1 < triangleCount; l1++) {
            triangleColour[l1] = class30_sub2_sub2.g2();
            if (triangleDrawType != null)
            {
                triangleDrawType[l1] = class30_sub2_sub2_1.g1();
            }
            if (facePriority != null)
                facePriority[l1] = class30_sub2_sub2_2.g1();
            if (triangleAlpha != null) {
                triangleAlpha[l1] = class30_sub2_sub2_3.g1();
            }
            if (triangleTSkin != null)
                triangleTSkin[l1] = class30_sub2_sub2_4.g1();
        }

        class30_sub2_sub2.pos = class21.triVPointOffset;
        class30_sub2_sub2_1.pos = class21.triMeshLinkOffset;
        int j2 = 0;
        int l2 = 0;
        int j3 = 0;
        int k3 = 0;
        for (int l3 = 0; l3 < triangleCount; l3++) {
            int i4 = class30_sub2_sub2_1.g1();
            if (i4 == 1) {
                j2 = class30_sub2_sub2.gsmart() + k3;
                k3 = j2;
                l2 = class30_sub2_sub2.gsmart() + k3;
                k3 = l2;
                j3 = class30_sub2_sub2.gsmart() + k3;
                k3 = j3;
                triangleA[l3] = j2;
                triangleB[l3] = l2;
                triangleC[l3] = j3;
            }
            if (i4 == 2) {
                //j2 = j2;
                l2 = j3;
                j3 = class30_sub2_sub2.gsmart() + k3;
                k3 = j3;
                triangleA[l3] = j2;
                triangleB[l3] = l2;
                triangleC[l3] = j3;
            }
            if (i4 == 3) {
                j2 = j3;
                //l2 = l2;
                j3 = class30_sub2_sub2.gsmart() + k3;
                k3 = j3;
                triangleA[l3] = j2;
                triangleB[l3] = l2;
                triangleC[l3] = j3;
            }
            if (i4 == 4) {
                int k4 = j2;
                j2 = l2;
                l2 = k4;
                j3 = class30_sub2_sub2.gsmart() + k3;
                k3 = j3;
                triangleA[l3] = j2;
                triangleB[l3] = l2;
                triangleC[l3] = j3;
            }
        }

        class30_sub2_sub2.pos = class21.textureInfoBasePos;
        for (int j4 = 0; j4 < textureTriangleCount; j4++) {
            triPIndex[j4] = class30_sub2_sub2.g2();
            triMIndex[j4] = class30_sub2_sub2.g2();
            triNIndex[j4] = class30_sub2_sub2.g2();
        }
    }

    public void readNewModel(byte abyte0[], int modelID) {
    	
    	int anInt2259 = 0;
    	int anInt2265 = 0;
    	byte[] aByteArray2269 = null;
    	byte[] aByteArray2253 = null;
    	byte[] aByteArray2255 = null;
    	int[] anIntArray2238 = null;
    	int[] anIntArray2228 = null;
    	int[] anIntArray2241 = null;
    	short[] aShortArray2237 = null;
    	int[] anIntArray2272 = null;
    	int[] anIntArray2261 = null;
    	int[] anIntArray2225 = null;
    	byte[] aByteArray2263 = null;
    	
    	
        hash = modelID;
        System.out.println("reading new model " + modelID);
        
        Packet rsbuffer = new Packet(abyte0);
        Packet rsbuffer1 = new Packet(abyte0);
        Packet rsbuffer2 = new Packet(abyte0);
        Packet rsbuffer3 = new Packet(abyte0);
        Packet rsbuffer4 = new Packet(abyte0);
        Packet rsbuffer5 = new Packet(abyte0);
        Packet rsbuffer6 = new Packet(abyte0);
        rsbuffer.pos = -23 + abyte0.length;
        int vertexCount = rsbuffer.g2();
        int triangleCount = rsbuffer.g2();
        int modelTextureTriangleCount = rsbuffer.g1();
        
        ModelHeader ModelDef_1 = modelHeaderCache[modelID] = new ModelHeader();
        ModelDef_1.modelData = abyte0;
        ModelDef_1.modelVerticeCount = vertexCount;
        ModelDef_1.modelTriangleCount = triangleCount;
        ModelDef_1.modelTextureTriangleCount = modelTextureTriangleCount;
        
        int i = rsbuffer.g1();
        boolean flag = (1 & i) == 1;
        boolean flag1 = (2 & i) == 2;
        boolean flag2 = (4 & i) == 4;
        boolean flag3 = (i & 8) == 8;
        if(flag3)
        {
            rsbuffer.pos -= 7;
            anInt2265 = rsbuffer.g1();
            rsbuffer.pos += 6;
        }
        int j = rsbuffer.g1();
        int k = rsbuffer.g1();
        int l = rsbuffer.g1();
        int i1 = rsbuffer.g1();
        int j1 = rsbuffer.g1();
        int k1 = rsbuffer.g2();
        int l1 = rsbuffer.g2();
        int i2 = rsbuffer.g2();
        int j2 = rsbuffer.g2();
        int k2 = rsbuffer.g2();
        int l2 = 0;
        int i3 = 0;
        int j3 = 0;
        if(~modelTextureTriangleCount < -1)
        {
            rsbuffer.pos = 0;
            aByteArray2269 = new byte[modelTextureTriangleCount];
            for(int k3 = 0; ~modelTextureTriangleCount < ~k3; k3++)
            {
                byte byte1 = aByteArray2269[k3] = rsbuffer.g1b();
                if(byte1 >= 1 && byte1 <= 3)
                    i3++;
                if(byte1 == 2)
                    j3++;
                if(~byte1 == -1)
                    l2++;
            }

        }
        int l3 = modelTextureTriangleCount;
        int vertexModOffset = l3;
        l3 += vertexCount;
        int j4 = l3;
        if(flag)
            l3 += triangleCount;
        int triMeshLinkOffset = l3;
        l3 += triangleCount;
        int facePriorityBasePos = l3;
        if(j == 255)
            l3 += triangleCount;
        int tskinBasepos = l3;
        if(l == 1)
            l3 += triangleCount;
        int vskinBasePos = l3;
        if(j1 == 1)
            l3 += vertexCount;
        int alphaBasepos = l3;
        if(k == 1)
            l3 += triangleCount;
        int triVPointOffset = l3;
        l3 += j2;
        int i6 = l3;
        if(i1 == 1)
            l3 += 2 * triangleCount;
        int j6 = l3;
        l3 += k2;
        int k6 = l3;
        l3 += triangleCount * 2;
        int vertexXOffset = l3;
        l3 += k1;
        int vertexYOffset = l3;
        l3 += l1;
        int vertexZOffset = l3;
        l3 += i2;
        int textureInfoBasePos = l3;
        l3 += 6 * l2;
        int l7 = l3;
        l3 += 6 * i3;
        byte byte2 = 6;
        if(anInt2265 == 14)
            byte2 = 7;
        else
        if(anInt2265 >= 15)
            byte2 = 9;
        int i8 = l3;
        l3 += byte2 * i3;
        int j8 = l3;
        l3 += i3;
        int k8 = l3;
        l3 += i3;
        int l8 = l3;
        l3 += i3 - -(j3 * 2);
        
        if(k == 1)
            triangleAlpha = new int[triangleCount];
        vertexX = new int[vertexCount];
        rsbuffer.pos = vertexModOffset;
        if(i1 == 1)
            aShortArray2237 = new short[triangleCount];
        vertexZ = new int[vertexCount];
        if(l == 1)
            triangleTSkin = new int[triangleCount];
        int i9 = l3;
        if(flag)
            triangleDrawType = new int[triangleCount];
        triangleB = new int[triangleCount];
        triangleColour = new int[triangleCount];
        if(j1 == 1)
            vertexVSkin = new int[vertexCount];
        if(i1 == 1 && modelTextureTriangleCount > 0)
            aByteArray2263 = new byte[triangleCount];
        vertexY = new int[vertexCount];
        triangleC = new int[triangleCount];
        triangleA = new int[triangleCount];
        if(modelTextureTriangleCount > 0)
        {
            triPIndex = new int[modelTextureTriangleCount];
            triMIndex = new int[modelTextureTriangleCount];
            triNIndex = new int[modelTextureTriangleCount];
            if(j3 > 0)
            {
                anIntArray2241 = new int[j3];
                anIntArray2228 = new int[j3];
            }
            if(~i3 < -1)
            {
                aByteArray2255 = new byte[i3];
                anIntArray2272 = new int[i3];
                anIntArray2261 = new int[i3];
                anIntArray2225 = new int[i3];
                anIntArray2238 = new int[i3];
                aByteArray2253 = new byte[i3];
            }
        }
        if(j == 255)
            facePriority = new int[triangleCount];
        rsbuffer1.pos = vertexXOffset;
        rsbuffer2.pos = vertexYOffset;
        rsbuffer3.pos = vertexZOffset;
        rsbuffer4.pos = vskinBasePos;
        int j9 = 0;
        int k9 = 0;
        int l9 = 0;
        for(int i10 = 0; ~vertexCount < ~i10; i10++)
        {
            int j10 = rsbuffer.g1();
            int l10 = 0;
            if((j10 & 1) != 0)
                l10 = rsbuffer1.gsmart();
            int j11 = 0;
            if((j10 & 2) != 0)
                j11 = rsbuffer2.gsmart();
            int l11 = 0;
            if((j10 & 4) != 0)
                l11 = rsbuffer3.gsmart();
            vertexX[i10] = l10 + j9;
            vertexY[i10] = j11 + k9;
            vertexZ[i10] = l9 - -l11;
            j9 = vertexX[i10];
            k9 = vertexY[i10];
            l9 = vertexZ[i10];
            if(j1 == 1)
                vertexVSkin[i10] = rsbuffer4.g1();
        }

        rsbuffer.pos = k6;
        rsbuffer1.pos = j4;
        rsbuffer2.pos = facePriorityBasePos;
        rsbuffer3.pos = alphaBasepos;
        rsbuffer4.pos = tskinBasepos;
        rsbuffer5.pos = i6;
        rsbuffer6.pos = j6;
        for(int k10 = 0; triangleCount > k10; k10++)
        {
            triangleColour[k10] = (short)rsbuffer.g2();
            if(flag)
                triangleDrawType[k10] = rsbuffer1.g1b();
            if(j == 255)
                facePriority[k10] = rsbuffer2.g1b();
            if(k == 1)
                triangleAlpha[k10] = rsbuffer3.g1b();
            if(l == 1)
                triangleTSkin[k10] = rsbuffer4.g1();
            if(i1 == 1)
                aShortArray2237[k10] = (short)(-1 + rsbuffer5.g2());
            if(aByteArray2263 != null)
                if(aShortArray2237[k10] != -1)
                    aByteArray2263[k10] = (byte)(-1 + rsbuffer6.g1());
                else
                    aByteArray2263[k10] = -1;
        }

        rsbuffer.pos = triVPointOffset;
        anInt2259 = -1;
        rsbuffer1.pos = triMeshLinkOffset;
        int i11 = 0;
        int k11 = 0;
        int i12 = 0;
        int j12 = 0;
        for(int k12 = 0; ~triangleCount < ~k12; k12++)
        {
            int l12 = rsbuffer1.g1();
            if(l12 == 1)
            {
                i11 = (short)(j12 + rsbuffer.gsmart());
                j12 = i11;
                k11 = (short)(j12 + rsbuffer.gsmart());
                j12 = k11;
                i12 = (short)(j12 + rsbuffer.gsmart());
                triangleA[k12] = (short) i11;
                j12 = i12;
                triangleB[k12] = (short) k11;
                triangleC[k12] = (short) i12;
                if(i11 > anInt2259)
                    anInt2259 = i11;
                if(k11 > anInt2259)
                    anInt2259 = k11;
                if(i12 > anInt2259)
                    anInt2259 = i12;
            }
            if(l12 == 2)
            {
                k11 = i12;
                i12 = (short)(j12 + rsbuffer.gsmart());
                j12 = i12;
                triangleA[k12] = (short) i11;
                triangleB[k12] = (short) k11;
                triangleC[k12] = (short) i12;
                if(i12 > anInt2259)
                    anInt2259 = i12;
            }
            if(l12 == 3)
            {
                i11 = i12;
                i12 = (short)(rsbuffer.gsmart() + j12);
                j12 = i12;
                triangleA[k12] = (short) i11;
                triangleB[k12] = (short) k11;
                triangleC[k12] = (short) i12;
                if(~anInt2259 > ~i12)
                    anInt2259 = i12;
            }
            if(l12 == 4)
            {
                int j13 = i11;
                i11 = k11;
                i12 = (short)(rsbuffer.gsmart() + j12);
                k11 = j13;
                j12 = i12;
                triangleA[k12] = (short) i11;
                triangleB[k12] = (short) k11;
                triangleC[k12] = (short) i12;
                if(~anInt2259 > ~i12)
                    anInt2259 = i12;
            }
        }

        anInt2259++;
        rsbuffer.pos = textureInfoBasePos;
        rsbuffer1.pos = l7;
        rsbuffer2.pos = i8;
        rsbuffer3.pos = j8;
        rsbuffer4.pos = k8;
        rsbuffer5.pos = l8;
        for(int i13 = 0; i13 < modelTextureTriangleCount; i13++)
        {
            int k13 = 0xff & aByteArray2269[i13];
            if(~k13 == -1)
            {
                triPIndex[i13] = (short)rsbuffer.g2();
                triMIndex[i13] = (short)rsbuffer.g2();
                triNIndex[i13] = (short)rsbuffer.g2();
            }
            if(k13 == 1)
            {
                triPIndex[i13] = (short)rsbuffer1.g2();
                triMIndex[i13] = (short)rsbuffer1.g2();
                triNIndex[i13] = (short)rsbuffer1.g2();
                if(anInt2265 >= 15)
                {
                    anIntArray2261[i13] = rsbuffer2.g3();
                    anIntArray2272[i13] = rsbuffer2.g3();
                    anIntArray2225[i13] = rsbuffer2.g3();
                } else
                {
                    anIntArray2261[i13] = rsbuffer2.g2();
                    if(anInt2265 < 14)
                        anIntArray2272[i13] = rsbuffer2.g2();
                    else
                        anIntArray2272[i13] = rsbuffer2.g3();
                    anIntArray2225[i13] = rsbuffer2.g2();
                }
                aByteArray2253[i13] = rsbuffer3.g1b();
                aByteArray2255[i13] = rsbuffer4.g1b();
                anIntArray2238[i13] = rsbuffer5.g1b();
            }
            if(k13 == 2)
            {
                triPIndex[i13] = (short)rsbuffer1.g2();
                triMIndex[i13] = (short)rsbuffer1.g2();
                triNIndex[i13] = (short)rsbuffer1.g2();
                if(anInt2265 >= 15)
                {
                    anIntArray2261[i13] = rsbuffer2.g3();
                    anIntArray2272[i13] = rsbuffer2.g3();
                    anIntArray2225[i13] = rsbuffer2.g3();
                } else
                {
                    anIntArray2261[i13] = rsbuffer2.g2();
                    if(anInt2265 < 14)
                        anIntArray2272[i13] = rsbuffer2.g2();
                    else
                        anIntArray2272[i13] = rsbuffer2.g3();
                    anIntArray2225[i13] = rsbuffer2.g2();
                }
                aByteArray2253[i13] = rsbuffer3.g1b();
                aByteArray2255[i13] = rsbuffer4.g1b();
                anIntArray2238[i13] = rsbuffer5.g1b();
                anIntArray2228[i13] = rsbuffer5.g1b();
                anIntArray2241[i13] = rsbuffer5.g1b();
            }
            if(k13 == 3)
            {
                triPIndex[i13] = (short)rsbuffer1.g2();
                triMIndex[i13] = (short)rsbuffer1.g2();
                triNIndex[i13] = (short)rsbuffer1.g2();
                if(anInt2265 >= 15)
                {
                    anIntArray2261[i13] = rsbuffer2.g3();
                    anIntArray2272[i13] = rsbuffer2.g3();
                    anIntArray2225[i13] = rsbuffer2.g3();
                } else
                {
                    anIntArray2261[i13] = rsbuffer2.g2();
                    if(anInt2265 < 14)
                        anIntArray2272[i13] = rsbuffer2.g2();
                    else
                        anIntArray2272[i13] = rsbuffer2.g3();
                    anIntArray2225[i13] = rsbuffer2.g2();
                }
                aByteArray2253[i13] = rsbuffer3.g1b();
                aByteArray2255[i13] = rsbuffer4.g1b();
                anIntArray2238[i13] = rsbuffer5.g1b();
            }
        }

        rsbuffer.pos = i9;
        if(flag1)//particles?
        {
            int l13 = rsbuffer.g1();
            if(~l13 < -1)
            {
                //aClass351Array2242 = new Class351[l13];
                for(int j14 = 0; ~j14 > ~l13; j14++)
                {
                    int i15 = rsbuffer.g2();
                    int l15 = rsbuffer.g2();
                    byte byte3;
                    if(j != 255)
                        byte3 = (byte)j;
                    else
                        byte3 = (byte)facePriority[l15];
                    //aClass351Array2242[j14] = new Class351(i15, triangleA[l15], triangleB[l15], triangleC[l15], byte3);
                }

            }
            int k14 = rsbuffer.g1();
            if(k14 > 0)
            {
                //aClass255Array2226 = new Class255[k14];
                for(int j15 = 0; ~j15 > ~k14; j15++)
                {
                    int i16 = rsbuffer.g2();
                    int k16 = rsbuffer.g2();
                    //aClass255Array2226[j15] = new Class255(i16, k16);
                }

            }
        }
        if(flag2)
        {
            int i14 = rsbuffer.g1();
            if(i14 > 0)
            {
                //aClass108Array2276 = new Class108[i14];
                for(int l14 = 0; ~i14 < ~l14; l14++)
                {
                    int k15 = rsbuffer.g2();
                    int j16 = rsbuffer.g2();
                    int l16 = rsbuffer.g1();
                    byte byte4 = rsbuffer.g1b();
                    //aClass108Array2276[l14] = new Class108(k15, j16, l16, byte4);
                }

            }
        }
    
    }

    public static void readHeader(byte abyte0[], int j) {//readheader? - shouldnt realy be being used
        if (abyte0 == null) {
            ModelHeader modelHeader = modelHeaderCache[j] = new ModelHeader();
            modelHeader.modelVerticeCount = 0;
            modelHeader.modelTriangleCount = 0;
            modelHeader.modelTextureTriangleCount = 0;
            return;
        }
        Packet stream = new Packet(abyte0);
        stream.pos = abyte0.length - 18;
        ModelHeader modelHeader_1 = modelHeaderCache[j] = new ModelHeader();
        modelHeader_1.modelData = abyte0;
        modelHeader_1.modelVerticeCount = stream.g2();
        modelHeader_1.modelTriangleCount = stream.g2();
        modelHeader_1.modelTextureTriangleCount = stream.g1();
        int isTextured = stream.g1();
        int l = stream.g1();
        int isTransparent = stream.g1();
        int hasChangedColours = stream.g1();
        int hasAnimations = stream.g1();
        int xSize = stream.g2();
        int ySize = stream.g2();
        int zSize = stream.g2();
        int tDataLength = stream.g2();
        int l2 = 0;
        modelHeader_1.vertexModOffset = l2;
        l2 += modelHeader_1.modelVerticeCount;
        modelHeader_1.triMeshLinkOffset = l2;
        l2 += modelHeader_1.modelTriangleCount;
        modelHeader_1.facePriorityBasePos = l2;
        if (l == 255)
            l2 += modelHeader_1.modelTriangleCount;
        else
            modelHeader_1.facePriorityBasePos = -l - 1;
        modelHeader_1.tskinBasepos = l2;
        if (hasChangedColours == 1)
            l2 += modelHeader_1.modelTriangleCount;
        else
            modelHeader_1.tskinBasepos = -1;
        modelHeader_1.drawTypeBasePos = l2;
        if (isTextured == 1)
            l2 += modelHeader_1.modelTriangleCount;
        else
            modelHeader_1.drawTypeBasePos = -1;
        modelHeader_1.vskinBasePos = l2;
        if (hasAnimations == 1)
            l2 += modelHeader_1.modelVerticeCount;
        else
            modelHeader_1.vskinBasePos = -1;
        modelHeader_1.alphaBasepos = l2;
        if (isTransparent == 1)
            l2 += modelHeader_1.modelTriangleCount;
        else
            modelHeader_1.alphaBasepos = -1;
        modelHeader_1.triVPointOffset = l2;
        l2 += tDataLength;
        modelHeader_1.triColourOffset = l2;
        l2 += modelHeader_1.modelTriangleCount * 2;
        modelHeader_1.textureInfoBasePos = l2;
        l2 += modelHeader_1.modelTextureTriangleCount * 6;
        modelHeader_1.vertexXOffset = l2;
        l2 += xSize;
        modelHeader_1.vertexYOffset = l2;
        l2 += ySize;
        modelHeader_1.vertexZOffset = l2;
        l2 += zSize;
    }

    public static void clearHeader(int id)//clearHeader?
    {
        modelHeaderCache[id] = null;
    }

    public static Model getModel(int j) {
        if (modelHeaderCache == null)
            return null;
        ModelHeader modelHeader = modelHeaderCache[j];
        if (modelHeader == null) {
            if (((OnDemandFetcher)abstractODFetcher).clientInstance == null){
                readHeader(((OnDemandFetcher)abstractODFetcher).getDataFromCache(j,0), j);
                return new Model(j, 0);//edited for new engine
            } else {
                abstractODFetcher.requestData(j);
                return null;
            }
        } else {
            return new Model(j, 0);//edited for new engine
        }
    }

    public static boolean isCached(int i) {
        if (modelHeaderCache == null)
            return false;
        ModelHeader modelHeader = modelHeaderCache[i];
        if (modelHeader == null) {
            abstractODFetcher.requestData(i);
            return false;
        } else {
            return true;
        }
    }

    private Model() {
        oneSquareModel = false;
    }

    /*private rs2.Model(int i)//never used O_o
    {
        aBoolean1659 = false;
        rs2.ModelHeader modelHeader = modelHeaderCache[i];
        vertexCount = modelHeader.modelVerticeCount;
        triangleCount = modelHeader.modelTriangleCount;
        textureTriangleCount = modelHeader.modelTextureTriangleCount;
        viewSpaceX = new int[vertexCount];
        vertexY = new int[vertexCount];
        vertexZ = new int[vertexCount];
        triangleA = new int[triangleCount];
        triangleB = new int[triangleCount];
        triangleC = new int[triangleCount];
        triPIndex = new int[textureTriangleCount];
        triMIndex = new int[textureTriangleCount];
        triNIndex = new int[textureTriangleCount];
        if(modelHeader.anInt376 >= 0)
            vertexVSkin = new int[vertexCount];
        if(modelHeader.anInt380 >= 0)
            triangleDrawType = new int[triangleCount];
        if(modelHeader.anInt381 >= 0)
            facePriority = new int[triangleCount];
        else
            anInt1641 = -modelHeader.anInt381 - 1;
        if(modelHeader.alphaBasepos >= 0)
            triangleAlpha = new int[triangleCount];
        if(modelHeader.tskinBasepos >= 0)
            triangleTSkin = new int[triangleCount];
        triangleColour = new int[triangleCount];
        rs2.Packet stream = new rs2.Packet(modelHeader.modelData);
        stream.pos = modelHeader.vertexModOffset;
        rs2.Packet vXStream = new rs2.Packet(modelHeader.modelData);
        vXStream.pos = modelHeader.vertexXOffset;
        rs2.Packet vYStream = new rs2.Packet(modelHeader.modelData);
        vYStream.pos = modelHeader.vertexYOffset;
        rs2.Packet vZStream = new rs2.Packet(modelHeader.modelData);
        vZStream.pos = modelHeader.vertexZOffset;
        rs2.Packet stream_4 = new rs2.Packet(modelHeader.modelData);
        stream_4.pos = modelHeader.anInt376;
        int oldVX = 0;
        int oldVY = 0;
        int oldVZ = 0;
        for(int vID = 0; vID < vertexCount; vID++)
        {
            int readValModifier = stream.g1();
            int vertexx = 0;
            if((readValModifier & 1) != 0)
                vertexx = vXStream.gsmart();
            int vertexy = 0;
            if((readValModifier & 2) != 0)
                vertexy = vYStream.gsmart();
            int vertexz = 0;
            if((readValModifier & 4) != 0)
                vertexz = vZStream.gsmart();
            viewSpaceX[vID] = oldVX + vertexx;
            vertexY[vID] = oldVY + vertexy;
            vertexZ[vID] = oldVZ + vertexz;
            oldVX = viewSpaceX[vID];
            oldVY = vertexY[vID];
            oldVZ = vertexZ[vID];
            if(vertexVSkin != null)
                vertexVSkin[vID] = stream_4.g1();
        }

        stream.pos = modelHeader.triColourOffset;
        vXStream.pos = modelHeader.anInt380;
        vYStream.pos = modelHeader.anInt381;
        vZStream.pos = modelHeader.alphaBasepos;
        stream_4.pos = modelHeader.tskinBasepos;
        for(int l1 = 0; l1 < triangleCount; l1++)
        {
            triangleColour[l1] = stream.g2();
            if(triangleDrawType != null)
                triangleDrawType[l1] = vXStream.g1();
            if(facePriority != null)
                facePriority[l1] = vYStream.g1();
            if(triangleAlpha != null)
                triangleAlpha[l1] = vZStream.g1();
            if(triangleTSkin != null)
                triangleTSkin[l1] = stream_4.g1();
        }

        stream.pos = modelHeader.triVPointOffset;
        vXStream.pos = modelHeader.triMeshLinkOffset;
        int triA = 0;
        int triB = 0;
        int triC = 0;
        int oldTriX = 0;
        for(int l3 = 0; l3 < triangleCount; l3++)
        {
            int i4 = vXStream.g1();
            if(i4 == 1)
            {
                triA = stream.gsmart() + oldTriX;
                oldTriX = triA;
                triB = stream.gsmart() + oldTriX;
                oldTriX = triB;
                triC = stream.gsmart() + oldTriX;
                oldTriX = triC;
                triangleA[l3] = triA;
                triangleB[l3] = triB;
                triangleC[l3] = triC;
            }
            if(i4 == 2)
            {
                //triA = triA;
                triB = triC;
                triC = stream.gsmart() + oldTriX;
                oldTriX = triC;
                triangleA[l3] = triA;
                triangleB[l3] = triB;
                triangleC[l3] = triC;
            }
            if(i4 == 3)
            {
                triA = triC;
                //triB = triB;
                triC = stream.gsmart() + oldTriX;
                oldTriX = triC;
                triangleA[l3] = triA;
                triangleB[l3] = triB;
                triangleC[l3] = triC;
            }
            if(i4 == 4)
            {
                int k4 = triA;
                triA = triB;
                triB = k4;
                triC = stream.gsmart() + oldTriX;
                oldTriX = triC;
                triangleA[l3] = triA;
                triangleB[l3] = triB;
                triangleC[l3] = triC;
            }
        }

        stream.pos = modelHeader.anInt384;
        for(int j4 = 0; j4 < textureTriangleCount; j4++)
        {
            triPIndex[j4] = stream.g2();
            triMIndex[j4] = stream.g2();
            triNIndex[j4] = stream.g2();
        }

    }*/

    public Model(int i, Model aclass30_sub2_sub4_sub6s[]) {
        oneSquareModel = false;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        vertexCount = 0;
        triangleCount = 0;
        textureTriangleCount = 0;
        anInt1641 = -1;
        for (int k = 0; k < i; k++) {
            Model model = aclass30_sub2_sub4_sub6s[k];
            if (model != null) {
                vertexCount += model.vertexCount;
                triangleCount += model.triangleCount;
                textureTriangleCount += model.textureTriangleCount;
                flag |= model.triangleDrawType != null;
                if (model.facePriority != null) {
                    flag1 = true;
                } else {
                    if (anInt1641 == -1)
                        anInt1641 = model.anInt1641;
                    if (anInt1641 != model.anInt1641)
                        flag1 = true;
                }
                flag2 |= model.triangleAlpha != null;
                flag3 |= model.triangleTSkin != null;
                hash += model.hash * Math.pow(10,k*3);
            }
        }

        vertexX = new int[vertexCount];
        vertexY = new int[vertexCount];
        vertexZ = new int[vertexCount];
        vertexVSkin = new int[vertexCount];
        triangleA = new int[triangleCount];
        triangleB = new int[triangleCount];
        triangleC = new int[triangleCount];
        triPIndex = new int[textureTriangleCount];
        triMIndex = new int[textureTriangleCount];
        triNIndex = new int[textureTriangleCount];
        if (flag)
            triangleDrawType = new int[triangleCount];
        if (flag1)
            facePriority = new int[triangleCount];
        if (flag2)
            triangleAlpha = new int[triangleCount];
        if (flag3)
            triangleTSkin = new int[triangleCount];
        triangleColour = new int[triangleCount];
        vertexCount = 0;
        triangleCount = 0;
        textureTriangleCount = 0;
        int l = 0;
        for (int i1 = 0; i1 < i; i1++) {
            Model model_1 = aclass30_sub2_sub4_sub6s[i1];
            if (model_1 != null) {
                for (int j1 = 0; j1 < model_1.triangleCount; j1++) {
                    if (flag)
                        if (model_1.triangleDrawType == null) {
                            triangleDrawType[triangleCount] = 0;
                        } else {
                            int k1 = model_1.triangleDrawType[j1];
                            if ((k1 & 2) == 2)
                                k1 += l << 2;
                            triangleDrawType[triangleCount] = k1;
                        }
                    if (flag1)
                        if (model_1.facePriority == null)
                            facePriority[triangleCount] = model_1.anInt1641;
                        else
                            facePriority[triangleCount] = model_1.facePriority[j1];
                    if (flag2)
                        if (model_1.triangleAlpha == null)
                            triangleAlpha[triangleCount] = 0;
                        else
                            triangleAlpha[triangleCount] = model_1.triangleAlpha[j1];
                    if (flag3 && model_1.triangleTSkin != null)
                        triangleTSkin[triangleCount] = model_1.triangleTSkin[j1];
                    triangleColour[triangleCount] = model_1.triangleColour[j1];
                    triangleA[triangleCount] = method465(model_1, model_1.triangleA[j1]);
                    triangleB[triangleCount] = method465(model_1, model_1.triangleB[j1]);
                    triangleC[triangleCount] = method465(model_1, model_1.triangleC[j1]);
                    triangleCount++;
                }

                for (int l1 = 0; l1 < model_1.textureTriangleCount; l1++) {
                    triPIndex[textureTriangleCount] = method465(model_1, model_1.triPIndex[l1]);
                    triMIndex[textureTriangleCount] = method465(model_1, model_1.triMIndex[l1]);
                    triNIndex[textureTriangleCount] = method465(model_1, model_1.triNIndex[l1]);
                    textureTriangleCount++;
                }

                l += model_1.textureTriangleCount;
            }
        }

    }

    public Model(Model aclass30_sub2_sub4_sub6s[]) {
        int i = 2;//was parameter
        oneSquareModel = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        vertexCount = 0;
        triangleCount = 0;
        textureTriangleCount = 0;
        anInt1641 = -1;
        for (int k = 0; k < i; k++) {
            Model model = aclass30_sub2_sub4_sub6s[k];
            if (model != null) {
                vertexCount += model.vertexCount;
                triangleCount += model.triangleCount;
                textureTriangleCount += model.textureTriangleCount;
                flag1 |= model.triangleDrawType != null;
                if (model.facePriority != null) {
                    flag2 = true;
                } else {
                    if (anInt1641 == -1)
                        anInt1641 = model.anInt1641;
                    if (anInt1641 != model.anInt1641)
                        flag2 = true;
                }
                flag3 |= model.triangleAlpha != null;
                flag4 |= model.triangleColour != null;
                hash += model.hash * Math.pow(10,k*3);
            }
        }

        vertexX = new int[vertexCount];
        vertexY = new int[vertexCount];
        vertexZ = new int[vertexCount];
        triangleA = new int[triangleCount];
        triangleB = new int[triangleCount];
        triangleC = new int[triangleCount];
        triangleHslA = new int[triangleCount];
        triangleHslB = new int[triangleCount];
        triangleHslC = new int[triangleCount];
        triPIndex = new int[textureTriangleCount];
        triMIndex = new int[textureTriangleCount];
        triNIndex = new int[textureTriangleCount];
        if (flag1)
            triangleDrawType = new int[triangleCount];
        if (flag2)
            facePriority = new int[triangleCount];
        if (flag3)
            triangleAlpha = new int[triangleCount];
        if (flag4)
            triangleColour = new int[triangleCount];
        vertexCount = 0;
        triangleCount = 0;
        textureTriangleCount = 0;
        int i1 = 0;
        for (int j1 = 0; j1 < i; j1++) {
            Model model_1 = aclass30_sub2_sub4_sub6s[j1];
            if (model_1 != null) {
                int k1 = vertexCount;
                for (int l1 = 0; l1 < model_1.vertexCount; l1++) {
                    vertexX[vertexCount] = model_1.vertexX[l1];
                    vertexY[vertexCount] = model_1.vertexY[l1];
                    vertexZ[vertexCount] = model_1.vertexZ[l1];
                    vertexCount++;
                }

                for (int i2 = 0; i2 < model_1.triangleCount; i2++) {
                    triangleA[triangleCount] = model_1.triangleA[i2] + k1;
                    triangleB[triangleCount] = model_1.triangleB[i2] + k1;
                    triangleC[triangleCount] = model_1.triangleC[i2] + k1;
                    triangleHslA[triangleCount] = model_1.triangleHslA[i2];
                    triangleHslB[triangleCount] = model_1.triangleHslB[i2];
                    triangleHslC[triangleCount] = model_1.triangleHslC[i2];
                    if (flag1)
                        if (model_1.triangleDrawType == null) {
                            triangleDrawType[triangleCount] = 0;
                        } else {
                            int j2 = model_1.triangleDrawType[i2];
                            if ((j2 & 2) == 2)
                                j2 += i1 << 2;
                            triangleDrawType[triangleCount] = j2;
                        }
                    if (flag2)
                        if (model_1.facePriority == null)
                            facePriority[triangleCount] = model_1.anInt1641;
                        else
                            facePriority[triangleCount] = model_1.facePriority[i2];
                    if (flag3)
                        if (model_1.triangleAlpha == null)
                            triangleAlpha[triangleCount] = 0;
                        else
                            triangleAlpha[triangleCount] = model_1.triangleAlpha[i2];
                    if (flag4 && model_1.triangleColour != null)
                        triangleColour[triangleCount] = model_1.triangleColour[i2];
                    triangleCount++;
                }

                for (int k2 = 0; k2 < model_1.textureTriangleCount; k2++) {
                    triPIndex[textureTriangleCount] = model_1.triPIndex[k2] + k1;
                    triMIndex[textureTriangleCount] = model_1.triMIndex[k2] + k1;
                    triNIndex[textureTriangleCount] = model_1.triNIndex[k2] + k1;
                    textureTriangleCount++;
                }

                i1 += model_1.textureTriangleCount;
            }
        }

        calculateDiagonals();
    }

    public Model(boolean flag, boolean animationNull, boolean flag2, Model model) {
        oneSquareModel = false;
        vertexCount = model.vertexCount;
        triangleCount = model.triangleCount;
        this.hash = model.hash*2+1;
        textureTriangleCount = model.textureTriangleCount;
        if (flag2) {
            vertexX = model.vertexX;
            vertexY = model.vertexY;
            vertexZ = model.vertexZ;
        } else {
            vertexX = new int[vertexCount];
            vertexY = new int[vertexCount];
            vertexZ = new int[vertexCount];
            for (int j = 0; j < vertexCount; j++) {
                vertexX[j] = model.vertexX[j];
                vertexY[j] = model.vertexY[j];
                vertexZ[j] = model.vertexZ[j];
            }

        }
        if (flag) {
            triangleColour = model.triangleColour;
        } else {
            triangleColour = new int[triangleCount];
            System.arraycopy(model.triangleColour, 0, triangleColour, 0, triangleCount);

        }
        if (animationNull) {
            triangleAlpha = model.triangleAlpha;
        } else {
            triangleAlpha = new int[triangleCount];
            if (model.triangleAlpha == null) {
                for (int l = 0; l < triangleCount; l++)
                    triangleAlpha[l] = 0;

            } else {
                System.arraycopy(model.triangleAlpha, 0, triangleAlpha, 0, triangleCount);

            }
        }
        vertexVSkin = model.vertexVSkin;
        triangleTSkin = model.triangleTSkin;
        triangleDrawType = model.triangleDrawType;
        triangleA = model.triangleA;
        triangleB = model.triangleB;
        triangleC = model.triangleC;
        facePriority = model.facePriority;
        anInt1641 = model.anInt1641;
        triPIndex = model.triPIndex;
        triMIndex = model.triMIndex;
        triNIndex = model.triNIndex;
    }

    public Model(boolean isSolid, boolean nonFlatShading, Model model) {
        this.hash = model.hash*3+1;
        oneSquareModel = false;
        vertexCount = model.vertexCount;
        triangleCount = model.triangleCount;
        textureTriangleCount = model.textureTriangleCount;
        if (isSolid) {
            vertexY = new int[vertexCount];
            System.arraycopy(model.vertexY, 0, vertexY, 0, vertexCount);

        } else {
            vertexY = model.vertexY;
        }
        if (nonFlatShading) {
            triangleHslA = new int[triangleCount];
            triangleHslB = new int[triangleCount];
            triangleHslC = new int[triangleCount];
            for (int k = 0; k < triangleCount; k++) {
                triangleHslA[k] = model.triangleHslA[k];
                triangleHslB[k] = model.triangleHslB[k];
                triangleHslC[k] = model.triangleHslC[k];
            }

            triangleDrawType = new int[triangleCount];
            if (model.triangleDrawType == null) {
                for (int l = 0; l < triangleCount; l++)
                    triangleDrawType[l] = 0;

            } else {
                System.arraycopy(model.triangleDrawType, 0, triangleDrawType, 0, triangleCount);

            }
            super.vertexNormals = new VertexNormal[vertexCount];
            for (int j1 = 0; j1 < vertexCount; j1++) {
                VertexNormal vertexNormal = super.vertexNormals[j1] = new VertexNormal();
                VertexNormal vertexNormal_1 = model.vertexNormals[j1];
                vertexNormal.x = vertexNormal_1.x;
                vertexNormal.y = vertexNormal_1.y;
                vertexNormal.z = vertexNormal_1.z;
                vertexNormal.magnitude = vertexNormal_1.magnitude;
            }

            vertexNormalOffset = model.vertexNormalOffset;
        } else {
            triangleHslA = model.triangleHslA;
            triangleHslB = model.triangleHslB;
            triangleHslC = model.triangleHslC;
            triangleDrawType = model.triangleDrawType;
        }
        vertexX = model.vertexX;
        vertexZ = model.vertexZ;
        triangleColour = model.triangleColour;
        triangleAlpha = model.triangleAlpha;
        facePriority = model.facePriority;
        anInt1641 = model.anInt1641;
        triangleA = model.triangleA;
        triangleB = model.triangleB;
        triangleC = model.triangleC;
        triPIndex = model.triPIndex;
        triMIndex = model.triMIndex;
        triNIndex = model.triNIndex;
        super.modelHeight = model.modelHeight;
        maxY = model.maxY;
        diagonal2DAboveorigin = model.diagonal2DAboveorigin;
        diagonal3DAboveorigin = model.diagonal3DAboveorigin;
        diagonal3D = model.diagonal3D;
        minX = model.minX;
        maxZ = model.maxZ;
        minZ = model.minZ;
        maxX = model.maxX;
    }

    public void method464(Model model, boolean flag) {
        this.hash = model.hash*4+1;
        vertexCount = model.vertexCount;
        triangleCount = model.triangleCount;
        textureTriangleCount = model.textureTriangleCount;
        if (anIntArray1622.length < vertexCount) {
            anIntArray1622 = new int[vertexCount + 100];
            anIntArray1623 = new int[vertexCount + 100];
            anIntArray1624 = new int[vertexCount + 100];
        }
        vertexX = anIntArray1622;
        vertexY = anIntArray1623;
        vertexZ = anIntArray1624;
        for (int k = 0; k < vertexCount; k++) {
            vertexX[k] = model.vertexX[k];
            vertexY[k] = model.vertexY[k];
            vertexZ[k] = model.vertexZ[k];
        }

        if (flag) {
            triangleAlpha = model.triangleAlpha;
        } else {
            if (anIntArray1625.length < triangleCount)
                anIntArray1625 = new int[triangleCount + 100];
            triangleAlpha = anIntArray1625;
            if (model.triangleAlpha == null) {
                for (int l = 0; l < triangleCount; l++)
                    triangleAlpha[l] = 0;

            } else {
                System.arraycopy(model.triangleAlpha, 0, triangleAlpha, 0, triangleCount);

            }
        }
        triangleDrawType = model.triangleDrawType;
        triangleColour = model.triangleColour;
        facePriority = model.facePriority;
        anInt1641 = model.anInt1641;
        triangleSkin = model.triangleSkin;
        vertexSkin = model.vertexSkin;
        triangleA = model.triangleA;
        triangleB = model.triangleB;
        triangleC = model.triangleC;
        triangleHslA = model.triangleHslA;
        triangleHslB = model.triangleHslB;
        triangleHslC = model.triangleHslC;
        triPIndex = model.triPIndex;
        triMIndex = model.triMIndex;
        triNIndex = model.triNIndex;
    }

    private int method465(Model model, int i) {
        int j = -1;
        int k = model.vertexX[i];
        int l = model.vertexY[i];
        int i1 = model.vertexZ[i];
        for (int j1 = 0; j1 < vertexCount; j1++) {
            if (k != vertexX[j1] || l != vertexY[j1] || i1 != vertexZ[j1])
                continue;
            j = j1;
            break;
        }

        if (j == -1) {
            vertexX[vertexCount] = k;
            vertexY[vertexCount] = l;
            vertexZ[vertexCount] = i1;
            if (model.vertexVSkin != null)
                vertexVSkin[vertexCount] = model.vertexVSkin[i];
            j = vertexCount++;
        }
        return j;
    }

    public void calculateDiagonals() {
        super.modelHeight = 0;
        diagonal2DAboveorigin = 0;
        maxY = 0;
        for (int verticePointer = 0; verticePointer < vertexCount; verticePointer++) {
            int v_x = vertexX[verticePointer];
            int v_y = vertexY[verticePointer];
            int v_z = vertexZ[verticePointer];
            if (-v_y > super.modelHeight)
                super.modelHeight = -v_y;
            if (v_y > maxY)
                maxY = v_y;
            int bounds_diagonal = v_x * v_x + v_z * v_z;
            if (bounds_diagonal > diagonal2DAboveorigin)
                diagonal2DAboveorigin = bounds_diagonal;
        }
        diagonal2DAboveorigin = (int) (Math.sqrt(diagonal2DAboveorigin) + 0.98999999999999999D);
        diagonal3DAboveorigin = (int) (Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + super.modelHeight * super.modelHeight) + 0.98999999999999999D);
        diagonal3D = diagonal3DAboveorigin + (int) (Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + maxY * maxY) + 0.98999999999999999D);
    }

    public void method467() {
        super.modelHeight = 0;
        maxY = 0;
        for (int i = 0; i < vertexCount; i++) {
            int j = vertexY[i];
            if (-j > super.modelHeight)
                super.modelHeight = -j;
            if (j > maxY)
                maxY = j;
        }

        diagonal3DAboveorigin = (int) (Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + super.modelHeight * super.modelHeight) + 0.98999999999999999D);
        diagonal3D = diagonal3DAboveorigin + (int) (Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + maxY * maxY) + 0.98999999999999999D);
    }

    private void calculateDiagonalsAndStats() {
        super.modelHeight = 0;
        diagonal2DAboveorigin = 0;
        maxY = 0;
        minX = 0xf423f;//todo - change to int - 999999
        maxX = 0xfff0bdc1;//4293967297
        maxZ = 0xfffe7961;//4294867297
        minZ = 0x1869f;//99999
        for (int j = 0; j < vertexCount; j++) {
            int v_x = vertexX[j];
            int v_y = vertexY[j];
            int v_z = vertexZ[j];
            if (v_x < minX)
                minX = v_x;
            if (v_x > maxX)
                maxX = v_x;
            if (v_z < minZ)
                minZ = v_z;
            if (v_z > maxZ)
                maxZ = v_z;
            if (-v_y > super.modelHeight)
                super.modelHeight = -v_y;
            if (v_y > maxY)
                maxY = v_y;
            int _diagonal_2D_aboveorigin = v_x * v_x + v_z * v_z;
            if (_diagonal_2D_aboveorigin > diagonal2DAboveorigin)
                diagonal2DAboveorigin = _diagonal_2D_aboveorigin;
        }

        diagonal2DAboveorigin = (int) Math.sqrt(diagonal2DAboveorigin);
        diagonal3DAboveorigin = (int) Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + super.modelHeight * super.modelHeight);
        diagonal3D = diagonal3DAboveorigin + (int) Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + maxY * maxY);
    }

    public void createBones() {//groups bones etc
        if (vertexVSkin != null) {//bones
            int ai[] = new int[256];
            int j = 0;
            for (int l = 0; l < vertexCount; l++) {
                int j1 = vertexVSkin[l];
                ai[j1]++;
                if (j1 > j)
                    j = j1;
            }

            vertexSkin = new int[j + 1][];
            for (int k1 = 0; k1 <= j; k1++) {
                vertexSkin[k1] = new int[ai[k1]];
                ai[k1] = 0;
            }

            for (int j2 = 0; j2 < vertexCount; j2++) {
                int l2 = vertexVSkin[j2];
                vertexSkin[l2][ai[l2]++] = j2;
            }

            vertexVSkin = null;
        }
        if (triangleTSkin != null) {
            int ai1[] = new int[256];
            int k = 0;
            for (int i1 = 0; i1 < triangleCount; i1++) {
                int l1 = triangleTSkin[i1];
                ai1[l1]++;
                if (l1 > k)
                    k = l1;
            }

            triangleSkin = new int[k + 1][];
            for (int i2 = 0; i2 <= k; i2++) {
                triangleSkin[i2] = new int[ai1[i2]];
                ai1[i2] = 0;
            }

            for (int k2 = 0; k2 < triangleCount; k2++) {
                int i3 = triangleTSkin[k2];
                triangleSkin[i3][ai1[i3]++] = k2;
            }

            triangleTSkin = null;
        }
    }

    public void applyTransform(int frameID) {
        if (vertexSkin == null)
            return;
        if (frameID == -1)
            return;
        hash+=frameID*1000000;
        Animation animation = Animation.forID(frameID);
        if (animation == null)
            return;
        ModelTransform modelTransform = animation.myModelTransform;
        vertexXModifier = 0;
        vertexYModifier = 0;
        vertexZModifier = 0;
        for (int k = 0; k < animation.stepCount; k++) {
            int opcodeID = animation.opcodeLinkTable[k];
            transformStep(modelTransform.opcodes[opcodeID], modelTransform.skinList[opcodeID], animation.modifier1[k], animation.modifier2[k], animation.modifier3[k]);
        }

    }

    public void mixAnimationFrames(int framesFrom2[], int frameId2, int frameId1) {
        if (frameId1 == -1)
            return;
        if (framesFrom2 == null || frameId2 == -1) {
            applyTransform(frameId1);
            return;
        }
        Animation animation = Animation.forID(frameId1);
        if (animation == null)
            return;
        Animation animation_1 = Animation.forID(frameId2);
        if (animation_1 == null) {
            applyTransform(frameId1);
            return;
        }
        hash+=frameId2*100000000;
        hash+=frameId1*1000000;
        ModelTransform modelTransform = animation.myModelTransform;
        vertexXModifier = 0;
        vertexYModifier = 0;
        vertexZModifier = 0;
        int l = 0;
        int stepIDD = framesFrom2[l++];
        for (int j1 = 0; j1 < animation.stepCount; j1++) {
            int k1;
            for (k1 = animation.opcodeLinkTable[j1]; k1 > stepIDD; stepIDD = framesFrom2[l++]) ;
            if (k1 != stepIDD || modelTransform.opcodes[k1] == 0)
                transformStep(modelTransform.opcodes[k1], modelTransform.skinList[k1], animation.modifier1[j1], animation.modifier2[j1], animation.modifier3[j1]);
        }

        vertexXModifier = 0;
        vertexYModifier = 0;
        vertexZModifier = 0;
        l = 0;
        stepIDD = framesFrom2[l++];
        for (int l1 = 0; l1 < animation_1.stepCount; l1++) {
            int stepID;
            for (stepID = animation_1.opcodeLinkTable[l1]; stepID > stepIDD; stepIDD = framesFrom2[l++]) ;
            if (stepID == stepIDD || modelTransform.opcodes[stepID] == 0)
                transformStep(modelTransform.opcodes[stepID], modelTransform.skinList[stepID], animation_1.modifier1[l1], animation_1.modifier2[l1], animation_1.modifier3[l1]);
        }

    }

    private void transformStep(int opcode, int skinList[], int vXOff, int vYOff, int vZOff) {
        int skinlistCount = skinList.length;
        if (opcode == 0) {
            int vModDiv = 0;
            vertexXModifier = 0;
            vertexYModifier = 0;
            vertexZModifier = 0;
            for (int k2 = 0; k2 < skinlistCount; k2++) {
                int vskinID = skinList[k2];
                if (vskinID < vertexSkin.length) {
                    int ai5[] = vertexSkin[vskinID];
                    for (int idxVM = 0; idxVM < ai5.length; idxVM++) {
                        int j6 = ai5[idxVM];
                        vertexXModifier += vertexX[j6];
                        vertexYModifier += vertexY[j6];
                        vertexZModifier += vertexZ[j6];
                        vModDiv++;
                    }

                }
            }

            if (vModDiv > 0) {
                vertexXModifier = vertexXModifier / vModDiv + vXOff;
                vertexYModifier = vertexYModifier / vModDiv + vYOff;
                vertexZModifier = vertexZModifier / vModDiv + vZOff;
                return;
            } else {
                vertexXModifier = vXOff;
                vertexYModifier = vYOff;
                vertexZModifier = vZOff;
                return;
            }
        }
        if (opcode == 1)  //Translate
        {
            for (int k1 = 0; k1 < skinlistCount; k1++) {
                int l2 = skinList[k1];
                if (l2 < vertexSkin.length) {
                    int ai1[] = vertexSkin[l2];
                    for (int i4 = 0; i4 < ai1.length; i4++) {
                        int j5 = ai1[i4];
                        vertexX[j5] += vXOff;
                        vertexY[j5] += vYOff;
                        vertexZ[j5] += vZOff;
                    }

                }
            }

            return;
        }
        if (opcode == 2)//Rotate
        {
            for (int l1 = 0; l1 < skinlistCount; l1++) {
                int i3 = skinList[l1];
                if (i3 < vertexSkin.length) {
                    int ai2[] = vertexSkin[i3];
                    for (int j4 = 0; j4 < ai2.length; j4++) {
                        int k5 = ai2[j4];
                        vertexX[k5] -= vertexXModifier;
                        vertexY[k5] -= vertexYModifier;
                        vertexZ[k5] -= vertexZModifier;
                        int k6 = (vXOff & 0xff) * 8;
                        int l6 = (vYOff & 0xff) * 8;
                        int i7 = (vZOff & 0xff) * 8;
                        if (i7 != 0) {
                            int j7 = SINE[i7];
                            int i8 = COSINE[i7];
                            int l8 = vertexY[k5] * j7 + vertexX[k5] * i8 >> 16;
                            vertexY[k5] = vertexY[k5] * i8 - vertexX[k5] * j7 >> 16;
                            vertexX[k5] = l8;
                        }
                        if (k6 != 0) {
                            int k7 = SINE[k6];
                            int j8 = COSINE[k6];
                            int i9 = vertexY[k5] * j8 - vertexZ[k5] * k7 >> 16;
                            vertexZ[k5] = vertexY[k5] * k7 + vertexZ[k5] * j8 >> 16;
                            vertexY[k5] = i9;
                        }
                        if (l6 != 0) {
                            int l7 = SINE[l6];
                            int k8 = COSINE[l6];
                            int j9 = vertexZ[k5] * l7 + vertexX[k5] * k8 >> 16;
                            vertexZ[k5] = vertexZ[k5] * k8 - vertexX[k5] * l7 >> 16;
                            vertexX[k5] = j9;
                        }
                        vertexX[k5] += vertexXModifier;
                        vertexY[k5] += vertexYModifier;
                        vertexZ[k5] += vertexZModifier;
                    }

                }
            }

            return;
        }
        if (opcode == 3)//scale
        {
            for (int skinListIDX = 0; skinListIDX < skinlistCount; skinListIDX++) {
                int skinID = skinList[skinListIDX];
                if (skinID < vertexSkin.length) {
                    int vSkin[] = vertexSkin[skinID];
                    for (int skinPos = 0; skinPos < vSkin.length; skinPos++) {
                        int vidX = vSkin[skinPos];
                        vertexX[vidX] -= vertexXModifier;
                        vertexY[vidX] -= vertexYModifier;
                        vertexZ[vidX] -= vertexZModifier;
                        vertexX[vidX] = (vertexX[vidX] * vXOff) / 128;
                        vertexY[vidX] = (vertexY[vidX] * vYOff) / 128;
                        vertexZ[vidX] = (vertexZ[vidX] * vZOff) / 128;
                        vertexX[vidX] += vertexXModifier;
                        vertexY[vidX] += vertexYModifier;
                        vertexZ[vidX] += vertexZModifier;
                    }

                }
            }

            return;
        }
        if (opcode == 5 && triangleSkin != null && triangleAlpha != null)//SetAlpha
        {
            for (int mapID = 0; mapID < skinlistCount; mapID++) {
                int skinID = skinList[mapID];
                if (skinID < triangleSkin.length) {
                    int tskin[] = triangleSkin[skinID];
                    for (int l4 = 0; l4 < tskin.length; l4++) {
                        int i6 = tskin[l4];
                        triangleAlpha[i6] += vXOff * 8;
                        if (triangleAlpha[i6] < 0)
                            triangleAlpha[i6] = 0;
                        if (triangleAlpha[i6] > 255)
                            triangleAlpha[i6] = 255;
                    }

                }
            }

        }
    }

    public void rotateBy90() {//rotate by 90
        hash += 9000000000L;
        for (int j = 0; j < vertexCount; j++) {
            int k = vertexX[j];
            vertexX[j] = vertexZ[j];
            vertexZ[j] = -k;
        }

    }

    public void method474(int i) {//duno
        hash += i*100000000L;

        int k = SINE[i];
        int l = COSINE[i];
        for (int i1 = 0; i1 < vertexCount; i1++) {
            int j1 = vertexY[i1] * l - vertexZ[i1] * k >> 16;
            vertexZ[i1] = vertexY[i1] * k + vertexZ[i1] * l >> 16;
            vertexY[i1] = j1;
        }
    }

    public void translate(int x, int y, int z) {
        hash += (x*y*z)*362345L;
        for (int i1 = 0; i1 < vertexCount; i1++) {
            vertexX[i1] += x;
            vertexY[i1] += y;
            vertexZ[i1] += z;
        }

    }

    public void recolour(int i, int j) {
        hash += (i*100000000L)+(j*10000000000L);
        for (int k = 0; k < triangleCount; k++)
            if (triangleColour[k] == i)
                triangleColour[k] = j;

    }
    
    public boolean fliped = false;

    public void mirrorModel() {//mirrors the model, used on lumbys castle doors, alkarid gates etcetc
    	if(fliped)
    	{
    		System.out.println("fuuu");
    		return;
    	}
    	fliped = true;
        for (int vertex = 0; vertex < vertexCount; vertex++)
            vertexZ[vertex] = -vertexZ[vertex];

        for (int triangle = 0; triangle < triangleCount; triangle++) {
            int l = triangleA[triangle];
            triangleA[triangle] = triangleC[triangle];
            triangleC[triangle] = l;
        }
    }

    public void scaleT(int scaleX, int scaleZ, int scaleY) {
        hash *= scaleX*scaleZ*scaleY;
        for (int i1 = 0; i1 < vertexCount; i1++) {
            vertexX[i1] = (vertexX[i1] * scaleX) / 128;
            vertexY[i1] = (vertexY[i1] * scaleY) / 128;
            vertexZ[i1] = (vertexZ[i1] * scaleZ) / 128;
        }

    }

     public void calculateNormals() {
         vns = super.vertexNormals;
         triangleNormalX = new int[triangleCount];
         triangleNormalY = new int[triangleCount];
         triangleNormalZ = new int[triangleCount];
         if (super.vertexNormals == null) {
            super.vertexNormals = new VertexNormal[vertexCount];
            for (int l1 = 0; l1 < vertexCount; l1++)
                super.vertexNormals[l1] = new VertexNormal();

        }
        for (int triID = 0; triID < triangleCount; triID++) {//todo - rename this to camelcode in future (peter plz do this, looks fucking complicated >:)
            int t_a = triangleA[triID];
            int t_b = triangleB[triID];
            int t_c = triangleC[triID];
            int u_x = vertexX[t_b] - vertexX[t_a];
            int u_y = (-vertexY[t_b]) - (-vertexY[t_a]);
            int u_z = vertexZ[t_b] - vertexZ[t_a];
            int d_c_a_x = vertexX[t_c] - vertexX[t_a];
            int d_c_a_y = (-vertexY[t_c]) - (-vertexY[t_a]);
            int d_c_a_z = vertexZ[t_c] - vertexZ[t_a];
            int normalX = u_y * d_c_a_z - d_c_a_y * u_z;
            int normalY = u_z * d_c_a_x - d_c_a_z * u_x;
            int normalZ;
            for (normalZ = u_x * d_c_a_y - d_c_a_x * u_y; normalX > 8192 || normalY > 8192 || normalZ > 8192 || normalX < -8192 || normalY < -8192 || normalZ < -8192; normalZ >>= 1) {
                normalX >>= 1;
                normalY >>= 1;
            }

            int normal_length = (int) Math.sqrt(normalX * normalX + normalY * normalY + normalZ * normalZ);
            if (normal_length <= 0)
                normal_length = 1;
            normalX = (normalX * 256) / normal_length;//Normalization
            normalY = (normalY * 256) / normal_length;
            normalZ = (normalZ * 256) / normal_length;
            if (triangleDrawType == null || (triangleDrawType[triID] & 1) == 0) {
                VertexNormal vertexNormal_2 = super.vertexNormals[t_a];
                vertexNormal_2.x += normalX;
                vertexNormal_2.y += normalY;
                vertexNormal_2.z += normalZ;
                vertexNormal_2.magnitude++;
                vertexNormal_2 = super.vertexNormals[t_b];
                vertexNormal_2.x += normalX;
                vertexNormal_2.y += normalY;
                vertexNormal_2.z += normalZ;
                vertexNormal_2.magnitude++;
                vertexNormal_2 = super.vertexNormals[t_c];
                vertexNormal_2.x += normalX;
                vertexNormal_2.y += normalY;
                vertexNormal_2.z += normalZ;
                vertexNormal_2.magnitude++;
            }
            triangleNormalX[triID] = normalX;
            triangleNormalY[triID] = normalY;
            triangleNormalZ[triID] = normalZ;
        }
    }

     public void calculateNormals508() {
         vertexNormals = null;
        if (vertexNormals == null) {
            vertexNormals = new VertexNormal[vertexCount];
            for (int i = 0; i < vertexCount; i++)
            vertexNormals[i] = new VertexNormal();
            for (int i = 0; i < triangleCount; i++) {
            int i_157_ = triangleA[i];
            int i_158_ = triangleB[i];
            int i_159_ = triangleC[i];
            int i_160_ = vertexX[i_158_] - vertexX[i_157_];
            int i_161_ = vertexY[i_158_] - vertexY[i_157_];
            int i_162_ = vertexZ[i_158_] - vertexZ[i_157_];
            int i_163_ = vertexX[i_159_] - vertexX[i_157_];
            int i_164_ = vertexY[i_159_] - vertexY[i_157_];
            int i_165_ = vertexZ[i_159_] - vertexZ[i_157_];
            int i_166_ = i_161_ * i_165_ - i_164_ * i_162_;
            int i_167_ = i_162_ * i_163_ - i_165_ * i_160_;
            int i_168_;
            for (i_168_ = i_160_ * i_164_ - i_163_ * i_161_;
                 (i_166_ > 8192 || i_167_ > 8192 || i_168_ > 8192
                  || i_166_ < -8192 || i_167_ < -8192 || i_168_ < -8192);
                 i_168_ >>= 1) {
                i_166_ >>= 1;
                i_167_ >>= 1;
            }
            int i_169_ = (int) Math.sqrt((double) (i_166_ * i_166_
                                   + i_167_ * i_167_
                                   + i_168_ * i_168_));
            if (i_169_ <= 0)
                i_169_ = 1;
            i_166_ = i_166_ * 256 / i_169_;
            i_167_ = i_167_ * 256 / i_169_;
            i_168_ = i_168_ * 256 / i_169_;
            int i_170_;
            if (triangleDrawType == null)
                i_170_ = (byte) 0;
            else
                i_170_ = triangleDrawType[i] & 1;
            if (i_170_ == 0) {
                VertexNormal vertexNormal = vertexNormals[i_157_];
                vertexNormal.x += i_166_;
                vertexNormal.y += i_167_;
                vertexNormal.z += i_168_;
                vertexNormal.magnitude++;
                vertexNormal = vertexNormals[i_158_];
                vertexNormal.x += i_166_;
                vertexNormal.y += i_167_;
                vertexNormal.z += i_168_;
                vertexNormal.magnitude++;
                vertexNormal = vertexNormals[i_159_];
                vertexNormal.x += i_166_;
                vertexNormal.y += i_167_;
                vertexNormal.z += i_168_;
                vertexNormal.magnitude++;
            } else if (i_170_ == 1) {
                if (triangleNormals == null || triangleNormals.length != triangleCount)
                triangleNormals = new TriangleNormal[triangleCount];
                TriangleNormal triangleNormal = triangleNormals[i] = new TriangleNormal();
                triangleNormal.x = i_166_;
                triangleNormal.y = i_167_;
                triangleNormal.z = i_168_;
            }
            }
        }
    }

    public void light(int lightMod, int magMultiplyer, int l_x, int l_y, int l_z, boolean flatShading) {
        int _mag_pre = (int) Math.sqrt(l_x * l_x + l_y * l_y + l_z * l_z);
        int mag = magMultiplyer * _mag_pre >> 8;
        if (triangleHslA == null) {
            triangleHslA = new int[triangleCount];
            triangleHslB = new int[triangleCount];
            triangleHslC = new int[triangleCount];
        }
        if (super.vertexNormals == null) {
            super.vertexNormals = new VertexNormal[vertexCount];
            for (int l1 = 0; l1 < vertexCount; l1++)
                super.vertexNormals[l1] = new VertexNormal();

        }
        for (int triID = 0; triID < triangleCount; triID++) {//todo - rename this to camelcode in future (peter plz do this, looks fucking complicated >:)
            int t_a = triangleA[triID];
            int t_b = triangleB[triID];
            int t_c = triangleC[triID];
            int d_a_b_x = vertexX[t_b] - vertexX[t_a];
            int d_a_b_y = vertexY[t_b] - vertexY[t_a];
            int d_a_b_z = vertexZ[t_b] - vertexZ[t_a];
            int d_c_a_x = vertexX[t_c] - vertexX[t_a];
            int d_c_a_y = vertexY[t_c] - vertexY[t_a];
            int d_c_a_z = vertexZ[t_c] - vertexZ[t_a];
            int normalX = d_a_b_y * d_c_a_z - d_c_a_y * d_a_b_z;
            int normalY = d_a_b_z * d_c_a_x - d_c_a_z * d_a_b_x;
            int normalZ;
            for (normalZ = d_a_b_x * d_c_a_y - d_c_a_x * d_a_b_y; normalX > 8192 || normalY > 8192 || normalZ > 8192 || normalX < -8192 || normalY < -8192 || normalZ < -8192; normalZ >>= 1) {
                normalX >>= 1;
                normalY >>= 1;
            }

            int normal_length = (int) Math.sqrt(normalX * normalX + normalY * normalY + normalZ * normalZ);
            if (normal_length <= 0)
                normal_length = 1;
            normalX = (normalX * 256) / normal_length;//Normalization
            normalY = (normalY * 256) / normal_length;
            normalZ = (normalZ * 256) / normal_length;
            if (triangleDrawType == null || (triangleDrawType[triID] & 1) == 0) {
                VertexNormal vertexNormal_2 = super.vertexNormals[t_a];
                vertexNormal_2.x += normalX;
                vertexNormal_2.y += normalY;
                vertexNormal_2.z += normalZ;
                vertexNormal_2.magnitude++;
                vertexNormal_2 = super.vertexNormals[t_b];
                vertexNormal_2.x += normalX;
                vertexNormal_2.y += normalY;
                vertexNormal_2.z += normalZ;
                vertexNormal_2.magnitude++;
                vertexNormal_2 = super.vertexNormals[t_c];
                vertexNormal_2.x += normalX;
                vertexNormal_2.y += normalY;
                vertexNormal_2.z += normalZ;
                vertexNormal_2.magnitude++;
            } else {
                int lightness = lightMod + (l_x * normalX + l_y * normalY + l_z * normalZ) / (mag + mag / 2);
                triangleHslA[triID] = mixLightness(triangleColour[triID], lightness, triangleDrawType[triID]);
            }
        }
//todo - this can be condensed - DONE

        if (flatShading) {
            doShading(lightMod, mag, l_x, l_y, l_z);
            calculateDiagonals();
        } else {
            vertexNormalOffset = new VertexNormal[vertexCount];
            for (int vertexPointer = 0; vertexPointer < vertexCount; vertexPointer++) {
                VertexNormal vertexNormal = super.vertexNormals[vertexPointer];
                VertexNormal vertexNormal_1 = vertexNormalOffset[vertexPointer] = new VertexNormal();
                vertexNormal_1.x = vertexNormal.x;
                vertexNormal_1.y = vertexNormal.y;
                vertexNormal_1.z = vertexNormal.z;
                vertexNormal_1.magnitude = vertexNormal.magnitude;
            }
            calculateDiagonalsAndStats();
        }
    }

    public void lightHD(int lightMod, int magMultiplyer, int l_x, int l_y, int l_z, boolean flatShading) {
            int _mag_pre = (int) Math.sqrt(l_x * l_x + l_y * l_y + l_z * l_z);
            int mag = magMultiplyer * _mag_pre >> 8;
            if (triangleHslA == null) {
                triangleHslA = new int[triangleCount];
                triangleHslB = new int[triangleCount];
                triangleHslC = new int[triangleCount];
            }
            for (int triID = 0; triID < triangleCount; triID++) {//todo - rename this to camelcode in future (peter plz do this, looks fucking complicated >:)
                if (triangleDrawType == null || (triangleDrawType[triID] & 1) == 0) {
                } else {
                    int lightness = lightMod + (l_x * triangleNormals[triID].x +
                                                l_y * triangleNormals[triID].y +
                                                l_z * triangleNormals[triID].z) / (mag + mag / 2);
                    triangleHslA[triID] = mixLightness(triangleColour[triID], lightness, triangleDrawType[triID]);
                }
            }
    //todo - this can be condensed - DONE

            if (flatShading) {
                doShadingHD(lightMod, mag, l_x, l_y, l_z);
                calculateDiagonals();
            }  else {
                vertexNormalOffset = new VertexNormal[vertexCount];
                for (int vertexPointer = 0; vertexPointer < vertexCount; vertexPointer++) {
                    VertexNormal vertexNormal = super.vertexNormals[vertexPointer];
                    VertexNormal vertexNormal_1 = vertexNormalOffset[vertexPointer] = new VertexNormal();
                    vertexNormal_1.x = vertexNormal.x;
                    vertexNormal_1.y = vertexNormal.y;
                    vertexNormal_1.z = vertexNormal.z;
                    vertexNormal_1.magnitude = vertexNormal.magnitude;
                }
                calculateDiagonalsAndStats();
            }
        }

    public void doShadingHD(int intensity, int falloff, int l_x, int l_y, int l_z) {
        for (int triID = 0; triID < triangleCount; triID++) {
            int triA = triangleA[triID];
            int triB = triangleB[triID];
            int triC = triangleC[triID];
            if (triangleDrawType == null) {
                int t_hsl = triangleColour[triID];
                VertexNormal vertexNormal = super.vertexNormals[triA];
                int l = intensity + (l_x * vertexNormal.x + l_y * vertexNormal.y + l_z * vertexNormal.z) / (falloff * vertexNormal.magnitude);
                triangleHslA[triID] = mixLightness(t_hsl, l, 0);
                vertexNormal = super.vertexNormals[triB];
                l = intensity + (l_x * vertexNormal.x + l_y * vertexNormal.y + l_z * vertexNormal.z) / (falloff * vertexNormal.magnitude);
                triangleHslB[triID] = mixLightness(t_hsl, l, 0);
                vertexNormal = super.vertexNormals[triC];
                l = intensity + (l_x * vertexNormal.x + l_y * vertexNormal.y + l_z * vertexNormal.z) / (falloff * vertexNormal.magnitude);
                triangleHslC[triID] = mixLightness(t_hsl, l, 0);
            } else if ((triangleDrawType[triID] & 1) == 0) {
                //Bit 1 of triangle_draw_type ON means mix_lightness returns just lightness
                //instead of mixed hsl
                int t_hsl = triangleColour[triID];
                int t_flags = triangleDrawType[triID];
                VertexNormal vertexNormal_1 = super.vertexNormals[triA];
                int l = intensity + (l_x * vertexNormal_1.x + l_y * vertexNormal_1.y + l_z * vertexNormal_1.z) / (falloff * vertexNormal_1.magnitude);
                triangleHslA[triID] = mixLightness(t_hsl, l, t_flags);
                vertexNormal_1 = super.vertexNormals[triB];
                l = intensity + (l_x * vertexNormal_1.x + l_y * vertexNormal_1.y + l_z * vertexNormal_1.z) / (falloff * vertexNormal_1.magnitude);
                triangleHslB[triID] = mixLightness(t_hsl, l, t_flags);
                vertexNormal_1 = super.vertexNormals[triC];
                l = intensity + (l_x * vertexNormal_1.x + l_y * vertexNormal_1.y + l_z * vertexNormal_1.z) / (falloff * vertexNormal_1.magnitude);
                triangleHslC[triID] = mixLightness(t_hsl, l, t_flags);
            }
        }
        if (triangleDrawType != null) {
            for (int l1 = 0; l1 < triangleCount; l1++)
                if ((triangleDrawType[l1] & 2) == 2)
                    return;

        }
    }

    public void doShading(int intensity, int falloff, int l_x, int l_y, int l_z) {
        for (int triID = 0; triID < triangleCount; triID++) {
            int triA = triangleA[triID];
            int triB = triangleB[triID];
            int triC = triangleC[triID];
            if (triangleDrawType == null) {
                int t_hsl = triangleColour[triID];
                VertexNormal vertexNormal = super.vertexNormals[triA];
                int l = intensity + (l_x * vertexNormal.x + l_y * vertexNormal.y + l_z * vertexNormal.z) / (falloff * vertexNormal.magnitude);
                triangleHslA[triID] = mixLightness(t_hsl, l, 0);
                vertexNormal = super.vertexNormals[triB];
                l = intensity + (l_x * vertexNormal.x + l_y * vertexNormal.y + l_z * vertexNormal.z) / (falloff * vertexNormal.magnitude);
                triangleHslB[triID] = mixLightness(t_hsl, l, 0);
                vertexNormal = super.vertexNormals[triC];
                l = intensity + (l_x * vertexNormal.x + l_y * vertexNormal.y + l_z * vertexNormal.z) / (falloff * vertexNormal.magnitude);
                triangleHslC[triID] = mixLightness(t_hsl, l, 0);
            } else if ((triangleDrawType[triID] & 1) == 0) {
                //Bit 1 of triangle_draw_type ON means mix_lightness returns just lightness
                //instead of mixed hsl
                int t_hsl = triangleColour[triID];
                int t_flags = triangleDrawType[triID];
                VertexNormal vertexNormal_1 = super.vertexNormals[triA];
                int l = intensity + (l_x * vertexNormal_1.x + l_y * vertexNormal_1.y + l_z * vertexNormal_1.z) / (falloff * vertexNormal_1.magnitude);
                triangleHslA[triID] = mixLightness(t_hsl, l, t_flags);
                vertexNormal_1 = super.vertexNormals[triB];
                l = intensity + (l_x * vertexNormal_1.x + l_y * vertexNormal_1.y + l_z * vertexNormal_1.z) / (falloff * vertexNormal_1.magnitude);
                triangleHslB[triID] = mixLightness(t_hsl, l, t_flags);
                vertexNormal_1 = super.vertexNormals[triC];
                l = intensity + (l_x * vertexNormal_1.x + l_y * vertexNormal_1.y + l_z * vertexNormal_1.z) / (falloff * vertexNormal_1.magnitude);
                triangleHslC[triID] = mixLightness(t_hsl, l, t_flags);
            }
        }

        super.vertexNormals = null;
        vertexNormalOffset = null;
        vertexVSkin = null;
        triangleTSkin = null;
        if (triangleDrawType != null) {
            for (int l1 = 0; l1 < triangleCount; l1++)
                if ((triangleDrawType[l1] & 2) == 2)
                    return;

        }
        //triangleColour = null;
    }

    private static int mixLightness(int hsl, int l, int flags) {
        if ((flags & 2) == 2) {
            if (l < 0)
                l = 0;
            else if (l > 127)
                l = 127;
            l = 127 - l;
            return l;
        }
        l = l * (hsl & 0x7f) >> 7;
        if (l < 2)
            l = 2;
        else if (l > 126)
            l = 126;
        return (hsl & 0xff80) + l;
    }

    public void rendersingle(int j, int diagionalRotation, int l, int i1, int sine, int cosine) {//todo figure if i has any significence to its value.
        int i = 0; //was a parameters
        int l1 = Rasterizer.centerX;
        int i2 = Rasterizer.centerY;
        int j2 = SINE[i];//[i]
        int k2 = COSINE[i];//[i]
        int l2 = SINE[j];
        int i3 = COSINE[j];
        int j3 = SINE[diagionalRotation];
        int k3 = COSINE[diagionalRotation];
        int l3 = SINE[l];
        int i4 = COSINE[l];
        int j4 = sine * l3 + cosine * i4 >> 16;
        for (int k4 = 0; k4 < vertexCount; k4++) {
            int l4 = vertexX[k4];
            int i5 = vertexY[k4];
            int j5 = vertexZ[k4];
            if (diagionalRotation != 0) {
                int k5 = i5 * j3 + l4 * k3 >> 16;
                i5 = i5 * k3 - l4 * j3 >> 16;
                l4 = k5;
            }
            if (i != 0) {
                int l5 = i5 * k2 - j5 * j2 >> 16;
                j5 = i5 * j2 + j5 * k2 >> 16;
                i5 = l5;
            }
            if (j != 0) {
                int i6 = j5 * l2 + l4 * i3 >> 16;
                j5 = j5 * i3 - l4 * l2 >> 16;
                l4 = i6;
            }
            l4 += i1;
            i5 += sine;
            j5 += cosine;
            int j6 = i5 * i4 - j5 * l3 >> 16;
            j5 = i5 * l3 + j5 * i4 >> 16;
            i5 = j6;
            depthBuffer[k4] = j5 - j4;
            vertexSX[k4] = l1 + (l4 << 9) / j5;
            vertexSY[k4] = i2 + (i5 << 9) / j5;
            if (textureTriangleCount > 0) {
                vertexMvX[k4] = l4;
                vertexMvY[k4] = i5;
                vertexMvZ[k4] = j5;
            }
        }

        try {
            method483(false, false, 0);
        } catch (Exception _ex) {
        }
    }

    public void renderAtPoint2(int i, int yCameraSine, int yCameraCosine, int xCurveSine, int xCurveCosine, int x, int y,
                              int z, int i2) {
        int j2 = z * xCurveCosine - x * xCurveSine >> 16;
        int k2 = y * yCameraSine + j2 * yCameraCosine >> 16;
        int l2 = diagonal2DAboveorigin * yCameraCosine >> 16;
        int i3 = k2 + l2;
        if (i3 <= 50 || k2 >= 3500)
            return;
        int j3 = z * xCurveSine + x * xCurveCosine >> 16;
        int k3 = j3 - diagonal2DAboveorigin << 9;
        if (k3 / i3 >= DrawingArea.viewportCx)
            return;
        int l3 = j3 + diagonal2DAboveorigin << 9;
        if (l3 / i3 <= -DrawingArea.viewportCx)
            return;
        int i4 = y * yCameraCosine - j2 * yCameraSine >> 16;
        int j4 = diagonal2DAboveorigin * yCameraSine >> 16;
        int k4 = i4 + j4 << 9;
        if (k4 / i3 <= -DrawingArea.viewportCy)
            return;
        int l4 = j4 + (super.modelHeight * yCameraCosine >> 16);
        int i5 = i4 - l4 << 9;
        if (i5 / i3 >= DrawingArea.viewportCy)
            return;
        int j5 = l2 + (super.modelHeight * yCameraSine >> 16);
        boolean flag = false;
        if (k2 - j5 <= 50)
            flag = true;
        boolean flag1 = false;
        if (i2 > 0 && aBoolean1684) {
            int k5 = k2 - l2;
            if (k5 <= 50)
                k5 = 50;
            if (j3 > 0) {
                k3 /= i3;
                l3 /= k5;
            } else {
                l3 /= i3;
                k3 /= k5;
            }
            if (i4 > 0) {
                i5 /= i3;
                k4 /= k5;
            } else {
                k4 /= i3;
                i5 /= k5;
            }
            int i6 = cursorXPos - Rasterizer.centerX;
            int k6 = cursorYPos - Rasterizer.centerY;
            if (i6 > k3 && i6 < l3 && k6 > i5 && k6 < k4)
                if (oneSquareModel)
                    resourceIDTAG[resourceCount++] = i2;
                else
                    flag1 = true;
        }
        int l5 = Rasterizer.centerX;
        int j6 = Rasterizer.centerY;
        int l6 = 0;
        int i7 = 0;
        if (i != 0) {
            l6 = SINE[i];
            i7 = COSINE[i];
        }
        for (int vetexIdx = 0; vetexIdx < vertexCount; vetexIdx++) {
            int vX = vertexX[vetexIdx];
            int vY = vertexY[vetexIdx];
            int vZ = vertexZ[vetexIdx];
            if (i != 0) {
                int j8 = vZ * l6 + vX * i7 >> 16;
                vZ = vZ * i7 - vX * l6 >> 16;
                vX = j8;
            }
            vX += x;
            vY += y;
            vZ += z;
            int k8 = vZ * xCurveSine + vX * xCurveCosine >> 16;
            vZ = vZ * xCurveCosine - vX * xCurveSine >> 16;
            vX = k8;
            k8 = vY * yCameraCosine - vZ * yCameraSine >> 16;
            vZ = vY * yCameraSine + vZ * yCameraCosine >> 16;
            vY = k8;
            depthBuffer[vetexIdx] = vZ - k2;
            if (vZ >= 50) {
                vertexSX[vetexIdx] = l5 + (vX << 9) / vZ;
                vertexSY[vetexIdx] = j6 + (vY << 9) / vZ;
            } else {
                vertexSX[vetexIdx] = -5000;
                flag = true;
            }
            if (flag || textureTriangleCount > 0) {
                vertexMvX[vetexIdx] = vX;
                vertexMvY[vetexIdx] = vY;
                vertexMvZ[vetexIdx] = vZ;
            }
        }

        try {
            method483(flag, flag1, i2);
        } catch (Exception _ex) {
        }
    }

    private void method483(boolean flag, boolean flag1, int i) {
        for (int j = 0; j < diagonal3D; j++)
            depthListIndices[j] = 0;

        for (int k = 0; k < triangleCount; k++)
            if (triangleDrawType == null || triangleDrawType[k] != -1) {
                int l = triangleA[k];
                int k1 = triangleB[k];
                int j2 = triangleC[k];
                int i3 = vertexSX[l];
                int l3 = vertexSX[k1];
                int k4 = vertexSX[j2];
                if (flag && (i3 == -5000 || l3 == -5000 || k4 == -5000)) {
                    aBooleanArray1664[k] = true;
                    int j5 = (depthBuffer[l] + depthBuffer[k1] + depthBuffer[j2]) / 3 + diagonal3DAboveorigin;
                    faceLists[j5][depthListIndices[j5]++] = k;
                } else {
                    if (flag1 && method486(cursorXPos, cursorYPos, vertexSY[l], vertexSY[k1], vertexSY[j2], i3, l3, k4)) {
                        resourceIDTAG[resourceCount++] = i;
                        flag1 = false;
                    }
                    if ((i3 - l3) * (vertexSY[j2] - vertexSY[k1]) - (vertexSY[l] - vertexSY[k1]) * (k4 - l3) > 0) {
                        aBooleanArray1664[k] = false;
                        aBooleanArray1663[k] = i3 < 0 || l3 < 0 || k4 < 0 || i3 > DrawingArea.viewportRx || l3 > DrawingArea.viewportRx || k4 > DrawingArea.viewportRx;
                        int k5 = (depthBuffer[l] + depthBuffer[k1] + depthBuffer[j2]) / 3 + diagonal3DAboveorigin;
                        faceLists[k5][depthListIndices[k5]++] = k;
                    }
                }
            }

        if (facePriority == null) {
            for (int i1 = diagonal3D - 1; i1 >= 0; i1--) {
                int l1 = depthListIndices[i1];
                if (l1 > 0) {
                    int ai[] = faceLists[i1];
                    for (int j3 = 0; j3 < l1; j3++)
                        rasterize(ai[j3]);

                }
            }

            return;
        }
        for (int j1 = 0; j1 < 12; j1++) {
            anIntArray1673[j1] = 0;
            anIntArray1677[j1] = 0;
        }

        for (int i2 = diagonal3D - 1; i2 >= 0; i2--) {
            int k2 = depthListIndices[i2];
            if (k2 > 0) {
                int ai1[] = faceLists[i2];
                for (int i4 = 0; i4 < k2; i4++) {
                    int l4 = ai1[i4];
                    int l5 = facePriority[l4];
                    int j6 = anIntArray1673[l5]++;
                    anIntArrayArray1674[l5][j6] = l4;
                    if (l5 < 10)
                        anIntArray1677[l5] += i2;
                    else if (l5 == 10)
                        anIntArray1675[j6] = i2;
                    else
                        anIntArray1676[j6] = i2;
                }

            }
        }

        int l2 = 0;
        if (anIntArray1673[1] > 0 || anIntArray1673[2] > 0)
            l2 = (anIntArray1677[1] + anIntArray1677[2]) / (anIntArray1673[1] + anIntArray1673[2]);
        int k3 = 0;
        if (anIntArray1673[3] > 0 || anIntArray1673[4] > 0)
            k3 = (anIntArray1677[3] + anIntArray1677[4]) / (anIntArray1673[3] + anIntArray1673[4]);
        int j4 = 0;
        if (anIntArray1673[6] > 0 || anIntArray1673[8] > 0)
            j4 = (anIntArray1677[6] + anIntArray1677[8]) / (anIntArray1673[6] + anIntArray1673[8]);
        int i6 = 0;
        int k6 = anIntArray1673[10];
        int ai2[] = anIntArrayArray1674[10];
        int ai3[] = anIntArray1675;
        if (i6 == k6) {
            i6 = 0;
            k6 = anIntArray1673[11];
            ai2 = anIntArrayArray1674[11];
            ai3 = anIntArray1676;
        }
        int i5;
        if (i6 < k6)
            i5 = ai3[i6];
        else
            i5 = -1000;
        for (int l6 = 0; l6 < 10; l6++) {
            while (l6 == 0 && i5 > l2) {
                rasterize(ai2[i6++]);
                if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            while (l6 == 3 && i5 > k3) {
                rasterize(ai2[i6++]);
                if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            while (l6 == 5 && i5 > j4) {
                rasterize(ai2[i6++]);
                if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            int i7 = anIntArray1673[l6];
            int ai4[] = anIntArrayArray1674[l6];
            for (int j7 = 0; j7 < i7; j7++)
                rasterize(ai4[j7]);

        }

        while (i5 != -1000) {
            rasterize(ai2[i6++]);
            if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                i6 = 0;
                ai2 = anIntArrayArray1674[11];
                k6 = anIntArray1673[11];
                ai3 = anIntArray1676;
            }
            if (i6 < k6)
                i5 = ai3[i6];
            else
                i5 = -1000;
        }
    }

    private void rasterize(int triPtr) {
        if (aBooleanArray1664[triPtr]) {
            method485(triPtr);
            return;
        }
        int tA = triangleA[triPtr];
        int tB = triangleB[triPtr];
        int tC = triangleC[triPtr];
        Rasterizer.restrict_edges = aBooleanArray1663[triPtr];
        if (triangleAlpha == null)
            Rasterizer.alpha = 0;
        else
            Rasterizer.alpha = triangleAlpha[triPtr];
        int triangleDrawType;
        if (this.triangleDrawType == null)
            triangleDrawType = 0;
        else
            triangleDrawType = this.triangleDrawType[triPtr] & 3;
        if (triangleDrawType == 0) {
            Rasterizer.drawShadedTriangle(vertexSY[tA], vertexSY[tB], vertexSY[tC], vertexSX[tA], vertexSX[tB], vertexSX[tC], triangleHslA[triPtr], triangleHslB[triPtr], triangleHslC[triPtr]);
            return;
        }
        if (triangleDrawType == 1) {
            Rasterizer.drawFlatTriangle(vertexSY[tA], vertexSY[tB], vertexSY[tC], vertexSX[tA], vertexSX[tB], vertexSX[tC], HSL2RGB[triangleHslA[triPtr]]);
            return;
        }
        if (triangleDrawType == 2) {
            int textriPtr = this.triangleDrawType[triPtr] >> 2;
            int tP = triPIndex[textriPtr];
            int tM = triMIndex[textriPtr];
            int tN = triNIndex[textriPtr];
            Rasterizer.drawTexturedTriangle(vertexSY[tA], vertexSY[tB], vertexSY[tC], vertexSX[tA], vertexSX[tB], vertexSX[tC], triangleHslA[triPtr], triangleHslB[triPtr], triangleHslC[triPtr], vertexMvX[tP], vertexMvX[tM], vertexMvX[tN], vertexMvY[tP], vertexMvY[tM], vertexMvY[tN], vertexMvZ[tP], vertexMvZ[tM], vertexMvZ[tN], triangleColour[triPtr]);
            return;
        }
        if (triangleDrawType == 3) {
            int k1 = this.triangleDrawType[triPtr] >> 2;
            int i2 = triPIndex[k1];
            int k2 = triMIndex[k1];
            int i3 = triNIndex[k1];
            Rasterizer.drawTexturedTriangle(vertexSY[tA], vertexSY[tB], vertexSY[tC], vertexSX[tA], vertexSX[tB], vertexSX[tC], triangleHslA[triPtr], triangleHslA[triPtr], triangleHslA[triPtr], vertexMvX[i2], vertexMvX[k2], vertexMvX[i3], vertexMvY[i2], vertexMvY[k2], vertexMvY[i3], vertexMvZ[i2], vertexMvZ[k2], vertexMvZ[i3], triangleColour[triPtr]);
        }
    }

    private void method485(int i) {
        int j = Rasterizer.centerX;
        int k = Rasterizer.centerY;
        int l = 0;
        int i1 = triangleA[i];
        int j1 = triangleB[i];
        int k1 = triangleC[i];
        int l1 = vertexMvZ[i1];
        int i2 = vertexMvZ[j1];
        int j2 = vertexMvZ[k1];
        if (l1 >= 50) {
            anIntArray1678[l] = vertexSX[i1];
            anIntArray1679[l] = vertexSY[i1];
            anIntArray1680[l++] = triangleHslA[i];
        } else {
            int k2 = vertexMvX[i1];
            int k3 = vertexMvY[i1];
            int k4 = triangleHslA[i];
            if (j2 >= 50) {
                int k5 = (50 - l1) * modelIntArray4[j2 - l1];
                anIntArray1678[l] = j + (k2 + ((vertexMvX[k1] - k2) * k5 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (k3 + ((vertexMvY[k1] - k3) * k5 >> 16) << 9) / 50;
                anIntArray1680[l++] = k4 + ((triangleHslC[i] - k4) * k5 >> 16);
            }
            if (i2 >= 50) {
                int l5 = (50 - l1) * modelIntArray4[i2 - l1];
                anIntArray1678[l] = j + (k2 + ((vertexMvX[j1] - k2) * l5 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (k3 + ((vertexMvY[j1] - k3) * l5 >> 16) << 9) / 50;
                anIntArray1680[l++] = k4 + ((triangleHslB[i] - k4) * l5 >> 16);
            }
        }
        if (i2 >= 50) {
            anIntArray1678[l] = vertexSX[j1];
            anIntArray1679[l] = vertexSY[j1];
            anIntArray1680[l++] = triangleHslB[i];
        } else {
            int l2 = vertexMvX[j1];
            int l3 = vertexMvY[j1];
            int l4 = triangleHslB[i];
            if (l1 >= 50) {
                int i6 = (50 - i2) * modelIntArray4[l1 - i2];
                anIntArray1678[l] = j + (l2 + ((vertexMvX[i1] - l2) * i6 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (l3 + ((vertexMvY[i1] - l3) * i6 >> 16) << 9) / 50;
                anIntArray1680[l++] = l4 + ((triangleHslA[i] - l4) * i6 >> 16);
            }
            if (j2 >= 50) {
                int j6 = (50 - i2) * modelIntArray4[j2 - i2];
                anIntArray1678[l] = j + (l2 + ((vertexMvX[k1] - l2) * j6 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (l3 + ((vertexMvY[k1] - l3) * j6 >> 16) << 9) / 50;
                anIntArray1680[l++] = l4 + ((triangleHslC[i] - l4) * j6 >> 16);
            }
        }
        if (j2 >= 50) {
            anIntArray1678[l] = vertexSX[k1];
            anIntArray1679[l] = vertexSY[k1];
            anIntArray1680[l++] = triangleHslC[i];
        } else {
            int i3 = vertexMvX[k1];
            int i4 = vertexMvY[k1];
            int i5 = triangleHslC[i];
            if (i2 >= 50) {
                int k6 = (50 - j2) * modelIntArray4[i2 - j2];
                anIntArray1678[l] = j + (i3 + ((vertexMvX[j1] - i3) * k6 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (i4 + ((vertexMvY[j1] - i4) * k6 >> 16) << 9) / 50;
                anIntArray1680[l++] = i5 + ((triangleHslB[i] - i5) * k6 >> 16);
            }
            if (l1 >= 50) {
                int l6 = (50 - j2) * modelIntArray4[l1 - j2];
                anIntArray1678[l] = j + (i3 + ((vertexMvX[i1] - i3) * l6 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (i4 + ((vertexMvY[i1] - i4) * l6 >> 16) << 9) / 50;
                anIntArray1680[l++] = i5 + ((triangleHslA[i] - i5) * l6 >> 16);
            }
        }
        int j3 = anIntArray1678[0];
        int j4 = anIntArray1678[1];
        int j5 = anIntArray1678[2];
        int i7 = anIntArray1679[0];
        int j7 = anIntArray1679[1];
        int k7 = anIntArray1679[2];
        if ((j3 - j4) * (k7 - j7) - (i7 - j7) * (j5 - j4) > 0) {
            Rasterizer.restrict_edges = false;
            if (l == 3) {
                if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.viewportRx || j4 > DrawingArea.viewportRx || j5 > DrawingArea.viewportRx)
                    Rasterizer.restrict_edges = true;
                int l7;
                if (triangleDrawType == null)
                    l7 = 0;
                else
                    l7 = triangleDrawType[i] & 3;
                if (l7 == 0)
                    Rasterizer.drawShadedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2]);
                else if (l7 == 1)
                    Rasterizer.drawFlatTriangle(i7, j7, k7, j3, j4, j5, HSL2RGB[triangleHslA[i]]);
                else if (l7 == 2) {
                    int j8 = triangleDrawType[i] >> 2;
                    int k9 = triPIndex[j8];
                    int k10 = triMIndex[j8];
                    int k11 = triNIndex[j8];
                    Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], vertexMvX[k9], vertexMvX[k10], vertexMvX[k11], vertexMvY[k9], vertexMvY[k10], vertexMvY[k11], vertexMvZ[k9], vertexMvZ[k10], vertexMvZ[k11], triangleColour[i]);
                } else if (l7 == 3) {
                    int k8 = triangleDrawType[i] >> 2;
                    int l9 = triPIndex[k8];
                    int l10 = triMIndex[k8];
                    int l11 = triNIndex[k8];
                    Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, triangleHslA[i], triangleHslA[i], triangleHslA[i], vertexMvX[l9], vertexMvX[l10], vertexMvX[l11], vertexMvY[l9], vertexMvY[l10], vertexMvY[l11], vertexMvZ[l9], vertexMvZ[l10], vertexMvZ[l11], triangleColour[i]);
                }
            }
            if (l == 4) {
                if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.viewportRx || j4 > DrawingArea.viewportRx || j5 > DrawingArea.viewportRx || anIntArray1678[3] < 0 || anIntArray1678[3] > DrawingArea.viewportRx)
                    Rasterizer.restrict_edges = true;
                int i8;
                if (triangleDrawType == null)
                    i8 = 0;
                else
                    i8 = triangleDrawType[i] & 3;
                if (i8 == 0) {
                    Rasterizer.drawShadedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2]);
                    Rasterizer.drawShadedTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], anIntArray1680[0], anIntArray1680[2], anIntArray1680[3]);
                    return;
                }
                if (i8 == 1) {
                    int l8 = HSL2RGB[triangleHslA[i]];
                    Rasterizer.drawFlatTriangle(i7, j7, k7, j3, j4, j5, l8);
                    Rasterizer.drawFlatTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], l8);
                    return;
                }
                if (i8 == 2) {
                    int i9 = triangleDrawType[i] >> 2;
                    int i10 = triPIndex[i9];
                    int i11 = triMIndex[i9];
                    int i12 = triNIndex[i9];
                    Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], vertexMvX[i10], vertexMvX[i11], vertexMvX[i12], vertexMvY[i10], vertexMvY[i11], vertexMvY[i12], vertexMvZ[i10], vertexMvZ[i11], vertexMvZ[i12], triangleColour[i]);
                    Rasterizer.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], anIntArray1680[0], anIntArray1680[2], anIntArray1680[3], vertexMvX[i10], vertexMvX[i11], vertexMvX[i12], vertexMvY[i10], vertexMvY[i11], vertexMvY[i12], vertexMvZ[i10], vertexMvZ[i11], vertexMvZ[i12], triangleColour[i]);
                    return;
                }
                if (i8 == 3) {
                    int j9 = triangleDrawType[i] >> 2;
                    int j10 = triPIndex[j9];
                    int j11 = triMIndex[j9];
                    int j12 = triNIndex[j9];
                    Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, triangleHslA[i], triangleHslA[i], triangleHslA[i], vertexMvX[j10], vertexMvX[j11], vertexMvX[j12], vertexMvY[j10], vertexMvY[j11], vertexMvY[j12], vertexMvZ[j10], vertexMvZ[j11], vertexMvZ[j12], triangleColour[i]);
                    Rasterizer.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], triangleHslA[i], triangleHslA[i], triangleHslA[i], vertexMvX[j10], vertexMvX[j11], vertexMvX[j12], vertexMvY[j10], vertexMvY[j11], vertexMvY[j12], vertexMvZ[j10], vertexMvZ[j11], vertexMvZ[j12], triangleColour[i]);
                }
            }
        }
    }

    private boolean method486(int i, int j, int k, int l, int i1, int j1, int k1,
                              int l1) {
        if (j < k && j < l && j < i1)
            return false;
        if (j > k && j > l && j > i1)
            return false;
        return !(i < j1 && i < k1 && i < l1) && (i <= j1 || i <= k1 || i <= l1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Model model = (Model) o;

        if (oneSquareModel != model.oneSquareModel)
            return false;
        if (anInt1641 != model.anInt1641)
            return false;
        if (anInt1654 != model.anInt1654)
            return false;
        if (diagonal3D != model.diagonal3D)
            return false;
        if (diagonal3DAboveorigin != model.diagonal3DAboveorigin)
            return false;
        if (hash != model.hash)
            return false;
        if (maxX != model.maxX)
            return false;
        if (maxY != model.maxY)
            return false;
        if (maxZ != model.maxZ)
            return false;
        if (minX != model.minX)
            return false;
        if (minZ != model.minZ)
            return false;
        if (textureTriangleCount != model.textureTriangleCount)
            return false;
        if (triangleCount != model.triangleCount)
            return false;
        if (vertexCount != model.vertexCount)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (hash ^ (hash >>> 32));
        result = 31 * result + vertexCount;
        result = 31 * result + triangleCount;
        result = 31 * result + anInt1641;
        result = 31 * result + textureTriangleCount;
        result = 31 * result + minX;
        result = 31 * result + maxX;
        result = 31 * result + maxZ;
        result = 31 * result + minZ;
        result = 31 * result + maxY;
        result = 31 * result + diagonal3D;
        result = 31 * result + diagonal3DAboveorigin;
        result = 31 * result + anInt1654;
        result = 31 * result + (oneSquareModel ? 1 : 0);
        return result;
    }

    public static final Model aModel_1621 = new Model();
    private static int[] anIntArray1622 = new int[2000];
    private static int[] anIntArray1623 = new int[2000];
    private static int[] anIntArray1624 = new int[2000];
    private static int[] anIntArray1625 = new int[2000];
    public int vertexCount;
    public int vertexX[];
    public int vertexY[];
    public int vertexZ[];
    public int triangleCount;
    public int triangleA[];
    public int triangleB[];
    public int triangleC[];
    public int[] triangleHslA;
    public int[] triangleHslB;
    public int[] triangleHslC;
    public int triangleDrawType[];
    public int[] facePriority;
    public int[] triangleAlpha;
    public int triangleColour[];

    private int anInt1641;
    public int textureTriangleCount;
    public int[] triPIndex;
    public int[] triMIndex;
    public int[] triNIndex;
    public int minX;
    public int maxX;
    public int maxZ;
    public int minZ;
    public int diagonal2DAboveorigin;
    public int maxY;
    private int diagonal3D;
    private int diagonal3DAboveorigin;
    public int anInt1654;
    public int[] vertexVSkin;
    public int[] triangleTSkin;
    public int vertexSkin[][];
    public int triangleSkin[][];
    public boolean oneSquareModel;
    VertexNormal vertexNormalOffset[];
    private static ModelHeader[] modelHeaderCache;
    private static OnDemandFetcherParent abstractODFetcher;
    private static boolean[] aBooleanArray1663 = new boolean[4096];
    public static boolean[] aBooleanArray1664 = new boolean[4096];
    private static int[] vertexSX = new int[4096];
    private static int[] vertexSY = new int[4096];
    private static int[] depthBuffer = new int[4096];
    private static int[] vertexMvX = new int[4096];
    private static int[] vertexMvY = new int[4096];
    private static int[] vertexMvZ = new int[4096];
    private static int[] depthListIndices = new int[1500];
    private static int[][] faceLists = new int[1500][512];
    private static int[] anIntArray1673 = new int[12];
    private static int[][] anIntArrayArray1674 = new int[12][2000];
    private static int[] anIntArray1675 = new int[2000];
    private static int[] anIntArray1676 = new int[2000];
    private static int[] anIntArray1677 = new int[12];
    private static final int[] anIntArray1678 = new int[10];
    private static final int[] anIntArray1679 = new int[10];
    private static final int[] anIntArray1680 = new int[10];
    private static int vertexXModifier;
    private static int vertexYModifier;
    private static int vertexZModifier;
    public static boolean aBoolean1684;
    public static int cursorXPos;//1685
    public static int cursorYPos;//1686
    public static int resourceCount;
    public static final int[] resourceIDTAG = new int[1000];
    public static int SINE[];
    public static int COSINE[];
    private static int[] HSL2RGB;
    private static int[] modelIntArray4;

    static {
        SINE = Rasterizer.SINE;
        COSINE = Rasterizer.COSINE;
        HSL2RGB = Rasterizer.hsl2rgb;
        modelIntArray4 = Rasterizer.anIntArray1469;
    }
}
