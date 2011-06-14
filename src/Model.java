// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class Model extends Animable {

    public static void nullLoader()
    {
        modelHeaderCache = null;
        aBooleanArray1663 = null;
        aBooleanArray1664 = null;
        anIntArray1665 = null;
        anIntArray1666 = null;
        cameraDepth = null;
        anIntArray1668 = null;
        vertexBY = null;
        anIntArray1670 = null;
        depthListIndices = null;
        faceLists = null;
        anIntArray1673 = null;
        anIntArrayArray1674 = null;
        anIntArray1675 = null;
        anIntArray1676 = null;
        anIntArray1677 = null;
        SINE = null;
        COSINE = null;
        modelIntArray3 = null;
        modelIntArray4 = null;
    }

    public static void method459(int i, OnDemandFetcherParent onDemandFetcherParent)
    {
        modelHeaderCache = new ModelHeader[i+30000];//wtf PETER!!!
        aOnDemandFetcherParent_1662 = onDemandFetcherParent;
    }


        public Model(int modelId,int j)
    {
	 byte[] is = modelHeaderCache[modelId].modelData;
        if(is[is.length - 1] == -1 && is[is.length - 2] == -1)
                readNewModel(is, modelId);
        else
                readOldModel(modelId);
    }

        private void readOldModel(int i)
    {
		//int j = -870;
        //anInt1614 = 9;
        //aBoolean1615 = false;
        //anInt1616 = 360;
        //anInt1617 = 1;
        //aBoolean1618 = true;
        aBoolean1659 = false;
        //anInt1620++;
        ModelHeader class21 = modelHeaderCache[i];
        verticeCount = class21.modelVerticeCount;
        triangleCount = class21.modelTriangleCount;
        texturedTriangeAmmount = class21.modelTextureTriangleCount;
        vertexX = new int[verticeCount];//vertexX
        vertexY = new int[verticeCount];//vy
        vertexZ = new int[verticeCount];//vz
        triangleA = new int[triangleCount];//trianglea
        triangleB = new int[triangleCount];//b
        triangleC = new int[triangleCount];//c
        triPIndex = new int[texturedTriangeAmmount];//tri_a_buffer
        triMIndex = new int[texturedTriangeAmmount];//b
        triNIndex = new int[texturedTriangeAmmount];//c
        if(class21.anInt376 >= 0)
            vertexVSkin = new int[verticeCount];//vertex_vskin
        if(class21.anInt380 >= 0)
            triangleDrawType = new int[triangleCount];//triangle_draw_type
        if(class21.anInt381 >= 0)
            facePriority = new int[triangleCount];//face_priority
        else
            anInt1641 = -class21.anInt381 - 1;
        if(class21.alphaBasepos >= 0)//alpha_basepos
            triangleAlpha = new int[triangleCount];//triangleAlpha
        if(class21.tskinBasepos >= 0)//tskin_basepos
            triangleTSkin = new int[triangleCount];//triangle_tskin
        triangleColours = new int[triangleCount];//triangleColours
        Packet class30_sub2_sub2 = new Packet(class21.modelData);
        class30_sub2_sub2.pos = class21.vertexModOffset;
        Packet class30_sub2_sub2_1 = new Packet(class21.modelData);
        class30_sub2_sub2_1.pos = class21.vertexXOffset;
        Packet class30_sub2_sub2_2 = new Packet(class21.modelData);
        class30_sub2_sub2_2.pos = class21.vertexYOffset;
        Packet class30_sub2_sub2_3 = new Packet(class21.modelData);
        class30_sub2_sub2_3.pos = class21.vertexZOffset;
        Packet class30_sub2_sub2_4 = new Packet(class21.modelData);
        class30_sub2_sub2_4.pos = class21.anInt376;
        int k = 0;
        int l = 0;
        int i1 = 0;
        for(int j1 = 0; j1 < verticeCount; j1++)
        {
            int k1 = class30_sub2_sub2.g1();
            int i2 = 0;
            if((k1 & 1) != 0)
                i2 = class30_sub2_sub2_1.gsmart();
            int k2 = 0;
            if((k1 & 2) != 0)
                k2 = class30_sub2_sub2_2.gsmart();
            int i3 = 0;
            if((k1 & 4) != 0)
                i3 = class30_sub2_sub2_3.gsmart();
            vertexX[j1] = k + i2;
            vertexY[j1] = l + k2;
            vertexZ[j1] = i1 + i3;
            k = vertexX[j1];
            l = vertexY[j1];
            i1 = vertexZ[j1];
            if(vertexVSkin != null)
                vertexVSkin[j1] = class30_sub2_sub2_4.g1();
        }

        class30_sub2_sub2.pos = class21.triColourOffset;
        class30_sub2_sub2_1.pos = class21.anInt380;
        class30_sub2_sub2_2.pos = class21.anInt381;
        class30_sub2_sub2_3.pos = class21.alphaBasepos;
        class30_sub2_sub2_4.pos = class21.tskinBasepos;
        for(int l1 = 0; l1 < triangleCount; l1++)
        {
            triangleColours[l1] = class30_sub2_sub2.g2();
            if(triangleDrawType != null)
                triangleDrawType[l1] = class30_sub2_sub2_1.g1();
            if(facePriority != null)
                facePriority[l1] = class30_sub2_sub2_2.g1();
            if(triangleAlpha != null){
                triangleAlpha[l1] = class30_sub2_sub2_3.g1();
		}
            if(triangleTSkin != null)
                triangleTSkin[l1] = class30_sub2_sub2_4.g1();
        }

        class30_sub2_sub2.pos = class21.triVPointOffset;
        class30_sub2_sub2_1.pos = class21.triMeshLinkOffset;
        int j2 = 0;
        int l2 = 0;
        int j3 = 0;
        int k3 = 0;
        for(int l3 = 0; l3 < triangleCount; l3++)
        {
            int i4 = class30_sub2_sub2_1.g1();
            if(i4 == 1)
            {
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
            if(i4 == 2)
            {
                j2 = j2;
                l2 = j3;
                j3 = class30_sub2_sub2.gsmart() + k3;
                k3 = j3;
                triangleA[l3] = j2;
                triangleB[l3] = l2;
                triangleC[l3] = j3;
            }
            if(i4 == 3)
            {
                j2 = j3;
                l2 = l2;
                j3 = class30_sub2_sub2.gsmart() + k3;
                k3 = j3;
                triangleA[l3] = j2;
                triangleB[l3] = l2;
                triangleC[l3] = j3;
            }
            if(i4 == 4)
            {
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

        class30_sub2_sub2.pos = class21.anInt384;
        for(int j4 = 0; j4 < texturedTriangeAmmount; j4++)
        {
            triPIndex[j4] = class30_sub2_sub2.g2();
            triMIndex[j4] = class30_sub2_sub2.g2();
            triNIndex[j4] = class30_sub2_sub2.g2();
        }
	}
        public void readNewModel(byte abyte0[], int modelID) {
	System.out.println("reading new model "+modelID);
        Packet nc1 = new Packet(abyte0);
        Packet nc2 = new Packet(abyte0);
        Packet nc3 = new Packet(abyte0);
        Packet nc4 = new Packet(abyte0);
        Packet nc5 = new Packet(abyte0);
        Packet nc6 = new Packet(abyte0);
        Packet nc7 = new Packet(abyte0);
		nc1.pos = abyte0.length - 23;
		int numVertices = nc1.g2();
		int numTriangles = nc1.g2();
		int numTexTriangles = nc1.g1();
		ModelHeader ModelDef_1 = modelHeaderCache[modelID] = new ModelHeader();
		ModelDef_1.modelData = abyte0;
		ModelDef_1.modelVerticeCount = numVertices;
		ModelDef_1.modelTriangleCount = numTriangles;
		ModelDef_1.modelTextureTriangleCount = numTexTriangles;
		int l1 = nc1.g1();
		boolean bool = (0x1 & l1 ^ 0xffffffff) == -2;
		boolean bool_78_ = (l1 & 0x2 ^ 0xffffffff) == -3;
		int i2 = nc1.g1();
		int j2 = nc1.g1();
		int k2 = nc1.g1();
		int l2 = nc1.g1();
		int i3 = nc1.g1();
		int j3 = nc1.g2();
		int k3 = nc1.g2();
		int l3 = nc1.g2();
		int i4 = nc1.g2();
		int j4 = nc1.g2();
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int v = 0;
		int hb = 0;
		int P = 0;
		byte G = 0;
		byte[] x = null;
		byte[] O = null;
		byte[] J = null;
		byte[] F = null;
		byte[] cb = null;
		byte[] gb = null;
		byte[] lb = null;
		int[] ab = null;
		int[] kb = null;
		int[] y = null;
		int[] N = null;
		short[] D = null;
		int[] triangleColours2 = new int[numTriangles];
		if(numTexTriangles > 0) {
			O = new byte[numTexTriangles];
			nc1.pos = 0;
			for(int j5 = 0; j5 < numTexTriangles; j5++)
			{
			byte byte0 = O[j5] = nc1.g1b();
			if(byte0 == 0)
				k4++;
			if(byte0 >= 1 && byte0 <= 3)
				l4++;
			if(byte0 == 2)
				i5++;
			}
		}
		int k5 = numTexTriangles;
		int l5 = k5;
		k5 += numVertices;
		int i6 = k5;
		if(l1 == 1)
			k5 += numTriangles;
		int j6 = k5;
		k5 += numTriangles;
		int k6 = k5;
		if(i2 == 255)
			k5 += numTriangles;
		int l6 = k5;
		if(k2 == 1)
			k5 += numTriangles;
		int i7 = k5;
		if(i3 == 1)
			k5 += numVertices;
		int j7 = k5;
		if(j2 == 1)
			k5 += numTriangles;
		int k7 = k5;
		k5 += i4;
		int l7 = k5;
		if(l2 == 1)
			k5 += numTriangles * 2;
		int i8 = k5;
		k5 += j4;
		int j8 = k5;
		k5 += numTriangles * 2;
		int k8 = k5;
		k5 += j3;
		int l8 = k5;
		k5 += k3;
		int i9 = k5;
		k5 += l3;
		int j9 = k5;
		k5 += k4 * 6;
		int k9 = k5;
		k5 += l4 * 6;
		int l9 = k5;
		k5 += l4 * 6;
		int i10 = k5;
		k5 += l4;
		int j10 = k5;
		k5 += l4;
		int k10 = k5;
		k5 += l4 + i5 * 2;
		v = numVertices;
		hb = numTriangles;
		P = numTexTriangles;
		int[] vertexX2 = new int[numVertices];
		int[] vertexY2 = new int[numVertices];
		int[] vertexZ2 = new int[numVertices];
		int[] facePoint1 = new int[numTriangles];
		int[] facePoint2 = new int[numTriangles];
		int[] facePoint3 = new int[numTriangles];
			vertexVSkin = new int[numVertices];
			triangleDrawType = new int[numTriangles];
			facePriority = new int[numTriangles];
			triangleAlpha = new int[numTriangles];
			triangleTSkin = new int[numTriangles];




		if(i3 == 1)
			vertexVSkin = new int[numVertices];
		if(bool)
			triangleDrawType = new int[numTriangles];
		if(i2 == 255)
			facePriority = new int[numTriangles];
		else
			G = (byte)i2;
		if(j2 == 1)
			triangleAlpha = new int[numTriangles];
		if(k2 == 1)
			triangleTSkin = new int[numTriangles];
		if(l2 == 1)
			D = new short[numTriangles];
		if(l2 == 1 && numTexTriangles > 0)
			x = new byte[numTriangles];
		triangleColours2 = new int[numTriangles];
		int i_115_ = k5;
		int[] texTrianglesPoint1 = null;
		int[] texTrianglesPoint2 = null;
		int[] texTrianglesPoint3 = null;
		if(numTexTriangles > 0) {
			texTrianglesPoint1 = new int[numTexTriangles];
			texTrianglesPoint2 = new int[numTexTriangles];
			texTrianglesPoint3 = new int[numTexTriangles];
			if(l4 > 0) {
				kb = new int[l4];
				N = new int[l4];
				y = new int[l4];
				gb = new byte[l4];
				lb = new byte[l4];
				F = new byte[l4];
			}
			if(i5 > 0) {
				cb = new byte[i5];
				J = new byte[i5];
			}
		}
		nc1.pos = l5;
		nc2.pos = k8;
		nc3.pos = l8;
		nc4.pos = i9;
		nc5.pos = i7;
		int l10 = 0;
		int i11 = 0;
		int j11 = 0;
		for(int k11 = 0; k11 < numVertices; k11++) {
			int l11 = nc1.g1();
			int j12 = 0;
			if((l11 & 1) != 0)
				j12 = nc2.gsmart();
			int l12 = 0;
			if((l11 & 2) != 0)
				l12 = nc3.gsmart();
			int j13 = 0;
			if((l11 & 4) != 0)
				j13 = nc4.gsmart();
			vertexX2[k11] = l10 + j12;
			vertexY2[k11] = i11 + l12;
			vertexZ2[k11] = j11 + j13;
			l10 = vertexX2[k11];
			i11 = vertexY2[k11];
			j11 = vertexZ2[k11];
			if(vertexVSkin != null)
			vertexVSkin[k11] = nc5.g1();
		}
		nc1.pos = j8;
		nc2.pos = i6;
		nc3.pos = k6;
		nc4.pos = j7;
		nc5.pos = l6;
		nc6.pos = l7;
		nc7.pos = i8;
		for(int i12 = 0; i12 < numTriangles; i12++) {


			triangleColours2[i12] = nc1.g2();
			if(l1 == 1){
				triangleDrawType[i12] = nc2.g1b();
				if(triangleDrawType[i12] == 2)triangleColours2[i12] = 65535;
				triangleDrawType[i12] = 0;
			}
			if(i2 == 255){
			facePriority[i12] = nc3.g1b();
			}
			if(j2 == 1){
			triangleAlpha[i12] = nc4.g1b();
			if(triangleAlpha[i12] < 0)
			triangleAlpha[i12] = (256+triangleAlpha[i12]);
			}
			if(k2 == 1)
			triangleTSkin[i12] = nc5.g1();
			if(l2 == 1)
			D[i12] = (short)(nc6.g2() - 1);

			if(x != null)
			if(D[i12] != -1)
				x[i12] = (byte)(nc7.g1() -1);
			else
				x[i12] = -1;
		}
		nc1.pos = k7;
		nc2.pos = j6;
		int k12 = 0;
		int i13 = 0;
		int k13 = 0;
		int l13 = 0;
		for(int i14 = 0; i14 < numTriangles; i14++) {
			int j14 = nc2.g1();
			if(j14 == 1) {
				k12 = nc1.gsmart() + l13;
				l13 = k12;
				i13 = nc1.gsmart() + l13;
				l13 = i13;
				k13 = nc1.gsmart() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if(j14 == 2) {
				i13 = k13;
				k13 = nc1.gsmart() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if(j14 == 3) {
				k12 = k13;
				k13 = nc1.gsmart() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if(j14 == 4) {
				int l14 = k12;
				k12 = i13;
				i13 = l14;
				k13 = nc1.gsmart() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
		}
		nc1.pos = j9;
		nc2.pos = k9;
		nc3.pos = l9;
		nc4.pos = i10;
		nc5.pos = j10;
		nc6.pos = k10;
		for(int k14 = 0; k14 < numTexTriangles; k14++) {
			int i15 = O[k14] & 0xff;
			if(i15 == 0) {
				texTrianglesPoint1[k14] = nc1.g2();
				texTrianglesPoint2[k14] = nc1.g2();
				texTrianglesPoint3[k14] = nc1.g2();
			}
			if(i15 == 1) {
				texTrianglesPoint1[k14] = nc2.g2();
				texTrianglesPoint2[k14] = nc2.g2();
				texTrianglesPoint3[k14] = nc2.g2();
				kb[k14] = nc3.g2();
				N[k14] = nc3.g2();
				y[k14] = nc3.g2();
				gb[k14] = nc4.g1b();
				lb[k14] = nc5.g1b();
				F[k14] = nc6.g1b();
			}
			if(i15 == 2) {
				texTrianglesPoint1[k14] = nc2.g2();
				texTrianglesPoint2[k14] = nc2.g2();
				texTrianglesPoint3[k14] = nc2.g2();
				kb[k14] = nc3.g2();
				N[k14] = nc3.g2();
				y[k14] = nc3.g2();
				gb[k14] = nc4.g1b();
				lb[k14] = nc5.g1b();
				F[k14] = nc6.g1b();
				cb[k14] = nc6.g1b();
				J[k14] = nc6.g1b();
			}
			if(i15 == 3) {
				texTrianglesPoint1[k14] = nc2.g2();
				texTrianglesPoint2[k14] = nc2.g2();
				texTrianglesPoint3[k14] = nc2.g2();
				kb[k14] = nc3.g2();
				N[k14] = nc3.g2();
				y[k14] = nc3.g2();
				gb[k14] = nc4.g1b();
				lb[k14] = nc5.g1b();
				F[k14] = nc6.g1b();
			}
		}

	if (i2 != 255) {
		for(int i12 = 0; i12 < numTriangles; i12++)
			facePriority[i12] = i2;

	}
		triangleColours = triangleColours2;
		verticeCount = numVertices;
		triangleCount = numTriangles;
		vertexX = vertexX2;
		vertexY = vertexY2;
		vertexZ = vertexZ2;
		triangleA= facePoint1;
		triangleB= facePoint2;
		triangleC= facePoint3;
}

    public static void method460(byte abyte0[], int j)
    {
        if(abyte0 == null)
        {
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
        int k = stream.g1();
        int l = stream.g1();
        int i1 = stream.g1();
        int j1 = stream.g1();
        int k1 = stream.g1();
        int l1 = stream.g2();
        int i2 = stream.g2();
        int j2 = stream.g2();
        int k2 = stream.g2();
        int l2 = 0;
        modelHeader_1.vertexModOffset = l2;
        l2 += modelHeader_1.modelVerticeCount;
        modelHeader_1.triMeshLinkOffset = l2;
        l2 += modelHeader_1.modelTriangleCount;
        modelHeader_1.anInt381 = l2;
        if(l == 255)
            l2 += modelHeader_1.modelTriangleCount;
        else
            modelHeader_1.anInt381 = -l - 1;
        modelHeader_1.tskinBasepos = l2;
        if(j1 == 1)
            l2 += modelHeader_1.modelTriangleCount;
        else
            modelHeader_1.tskinBasepos = -1;
        modelHeader_1.anInt380 = l2;
        if(k == 1)
            l2 += modelHeader_1.modelTriangleCount;
        else
            modelHeader_1.anInt380 = -1;
        modelHeader_1.anInt376 = l2;
        if(k1 == 1)
            l2 += modelHeader_1.modelVerticeCount;
        else
            modelHeader_1.anInt376 = -1;
        modelHeader_1.alphaBasepos = l2;
        if(i1 == 1)
            l2 += modelHeader_1.modelTriangleCount;
        else
            modelHeader_1.alphaBasepos = -1;
        modelHeader_1.triVPointOffset = l2;
        l2 += k2;
        modelHeader_1.triColourOffset = l2;
        l2 += modelHeader_1.modelTriangleCount * 2;
        modelHeader_1.anInt384 = l2;
        l2 += modelHeader_1.modelTextureTriangleCount * 6;
        modelHeader_1.vertexXOffset = l2;
        l2 += l1;
        modelHeader_1.vertexYOffset = l2;
        l2 += i2;
        modelHeader_1.vertexZOffset = l2;
        l2 += j2;
    }

    public static void method461(int j)//clearHeader?
    {
        modelHeaderCache[j] = null;
    }

    public static Model getModel(int j)
    {
        if(modelHeaderCache == null)
            return null;
        ModelHeader modelHeader = modelHeaderCache[j];
        if(modelHeader == null)
        {
            aOnDemandFetcherParent_1662.method548(j);
            return null;
        } else
        {
            return new Model(j,0);//edited for new engine
        }
    }

    public static boolean isDownloaded(int i)
    {
        if(modelHeaderCache == null)
            return false;
        ModelHeader modelHeader = modelHeaderCache[i];
        if(modelHeader == null)
        {
            aOnDemandFetcherParent_1662.method548(i);
            return false;
        } else
        {
            return true;
        }
    }

    private Model()
    {
        aBoolean1659 = false;
    }

    private Model(int i)
    {
        aBoolean1659 = false;
        ModelHeader modelHeader = modelHeaderCache[i];
        verticeCount = modelHeader.modelVerticeCount;
        triangleCount = modelHeader.modelTriangleCount;
        texturedTriangeAmmount = modelHeader.modelTextureTriangleCount;
        vertexX = new int[verticeCount];
        vertexY = new int[verticeCount];
        vertexZ = new int[verticeCount];
        triangleA = new int[triangleCount];
        triangleB = new int[triangleCount];
        triangleC = new int[triangleCount];
        triPIndex = new int[texturedTriangeAmmount];
        triMIndex = new int[texturedTriangeAmmount];
        triNIndex = new int[texturedTriangeAmmount];
        if(modelHeader.anInt376 >= 0)
            vertexVSkin = new int[verticeCount];
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
        triangleColours = new int[triangleCount];
        Packet stream = new Packet(modelHeader.modelData);
        stream.pos = modelHeader.vertexModOffset;
        Packet vXStream = new Packet(modelHeader.modelData);
        vXStream.pos = modelHeader.vertexXOffset;
        Packet vYStream = new Packet(modelHeader.modelData);
        vYStream.pos = modelHeader.vertexYOffset;
        Packet vZStream = new Packet(modelHeader.modelData);
        vZStream.pos = modelHeader.vertexZOffset;
        Packet stream_4 = new Packet(modelHeader.modelData);
        stream_4.pos = modelHeader.anInt376;
        int oldVX = 0;
        int oldVY = 0;
        int oldVZ = 0;
        for(int vID = 0; vID < verticeCount; vID++)
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
            vertexX[vID] = oldVX + vertexx;
            vertexY[vID] = oldVY + vertexy;
            vertexZ[vID] = oldVZ + vertexz;
            oldVX = vertexX[vID];
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
            triangleColours[l1] = stream.g2();
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
                triA = triA;
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
                triB = triB;
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
        for(int j4 = 0; j4 < texturedTriangeAmmount; j4++)
        {
            triPIndex[j4] = stream.g2();
            triMIndex[j4] = stream.g2();
            triNIndex[j4] = stream.g2();
        }

    }

    public Model(int i, Model aclass30_sub2_sub4_sub6s[])
    {
        aBoolean1659 = false;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        verticeCount = 0;
        triangleCount = 0;
        texturedTriangeAmmount = 0;
        anInt1641 = -1;
        for(int k = 0; k < i; k++)
        {
            Model model = aclass30_sub2_sub4_sub6s[k];
            if(model != null)
            {
                verticeCount += model.verticeCount;
                triangleCount += model.triangleCount;
                texturedTriangeAmmount += model.texturedTriangeAmmount;
                flag |= model.triangleDrawType != null;
                if(model.facePriority != null)
                {
                    flag1 = true;
                } else
                {
                    if(anInt1641 == -1)
                        anInt1641 = model.anInt1641;
                    if(anInt1641 != model.anInt1641)
                        flag1 = true;
                }
                flag2 |= model.triangleAlpha != null;
                flag3 |= model.triangleTSkin != null;
            }
        }

        vertexX = new int[verticeCount];
        vertexY = new int[verticeCount];
        vertexZ = new int[verticeCount];
        vertexVSkin = new int[verticeCount];
        triangleA = new int[triangleCount];
        triangleB = new int[triangleCount];
        triangleC = new int[triangleCount];
        triPIndex = new int[texturedTriangeAmmount];
        triMIndex = new int[texturedTriangeAmmount];
        triNIndex = new int[texturedTriangeAmmount];
        if(flag)
            triangleDrawType = new int[triangleCount];
        if(flag1)
            facePriority = new int[triangleCount];
        if(flag2)
            triangleAlpha = new int[triangleCount];
        if(flag3)
            triangleTSkin = new int[triangleCount];
        triangleColours = new int[triangleCount];
        verticeCount = 0;
        triangleCount = 0;
        texturedTriangeAmmount = 0;
        int l = 0;
        for(int i1 = 0; i1 < i; i1++)
        {
            Model model_1 = aclass30_sub2_sub4_sub6s[i1];
            if(model_1 != null)
            {
                for(int j1 = 0; j1 < model_1.triangleCount; j1++)
                {
                    if(flag)
                        if(model_1.triangleDrawType == null)
                        {
                            triangleDrawType[triangleCount] = 0;
                        } else
                        {
                            int k1 = model_1.triangleDrawType[j1];
                            if((k1 & 2) == 2)
                                k1 += l << 2;
                            triangleDrawType[triangleCount] = k1;
                        }
                    if(flag1)
                        if(model_1.facePriority == null)
                            facePriority[triangleCount] = model_1.anInt1641;
                        else
                            facePriority[triangleCount] = model_1.facePriority[j1];
                    if(flag2)
                        if(model_1.triangleAlpha == null)
                            triangleAlpha[triangleCount] = 0;
                        else
                            triangleAlpha[triangleCount] = model_1.triangleAlpha[j1];
                    if(flag3 && model_1.triangleTSkin != null)
                        triangleTSkin[triangleCount] = model_1.triangleTSkin[j1];
                    triangleColours[triangleCount] = model_1.triangleColours[j1];
                    triangleA[triangleCount] = method465(model_1, model_1.triangleA[j1]);
                    triangleB[triangleCount] = method465(model_1, model_1.triangleB[j1]);
                    triangleC[triangleCount] = method465(model_1, model_1.triangleC[j1]);
                    triangleCount++;
                }

                for(int l1 = 0; l1 < model_1.texturedTriangeAmmount; l1++)
                {
                    triPIndex[texturedTriangeAmmount] = method465(model_1, model_1.triPIndex[l1]);
                    triMIndex[texturedTriangeAmmount] = method465(model_1, model_1.triMIndex[l1]);
                    triNIndex[texturedTriangeAmmount] = method465(model_1, model_1.triNIndex[l1]);
                    texturedTriangeAmmount++;
                }

                l += model_1.texturedTriangeAmmount;
            }
        }

    }

    public Model(Model aclass30_sub2_sub4_sub6s[])
    {
        int i = 2;//was parameter
        aBoolean1659 = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        verticeCount = 0;
        triangleCount = 0;
        texturedTriangeAmmount = 0;
        anInt1641 = -1;
        for(int k = 0; k < i; k++)
        {
            Model model = aclass30_sub2_sub4_sub6s[k];
            if(model != null)
            {
                verticeCount += model.verticeCount;
                triangleCount += model.triangleCount;
                texturedTriangeAmmount += model.texturedTriangeAmmount;
                flag1 |= model.triangleDrawType != null;
                if(model.facePriority != null)
                {
                    flag2 = true;
                } else
                {
                    if(anInt1641 == -1)
                        anInt1641 = model.anInt1641;
                    if(anInt1641 != model.anInt1641)
                        flag2 = true;
                }
                flag3 |= model.triangleAlpha != null;
                flag4 |= model.triangleColours != null;
            }
        }

        vertexX = new int[verticeCount];
        vertexY = new int[verticeCount];
        vertexZ = new int[verticeCount];
        triangleA = new int[triangleCount];
        triangleB = new int[triangleCount];
        triangleC = new int[triangleCount];
        triangleHslA = new int[triangleCount];
        triangleHslB = new int[triangleCount];
        triangleHslC = new int[triangleCount];
        triPIndex = new int[texturedTriangeAmmount];
        triMIndex = new int[texturedTriangeAmmount];
        triNIndex = new int[texturedTriangeAmmount];
        if(flag1)
            triangleDrawType = new int[triangleCount];
        if(flag2)
            facePriority = new int[triangleCount];
        if(flag3)
            triangleAlpha = new int[triangleCount];
        if(flag4)
            triangleColours = new int[triangleCount];
        verticeCount = 0;
        triangleCount = 0;
        texturedTriangeAmmount = 0;
        int i1 = 0;
        for(int j1 = 0; j1 < i; j1++)
        {
            Model model_1 = aclass30_sub2_sub4_sub6s[j1];
            if(model_1 != null)
            {
                int k1 = verticeCount;
                for(int l1 = 0; l1 < model_1.verticeCount; l1++)
                {
                    vertexX[verticeCount] = model_1.vertexX[l1];
                    vertexY[verticeCount] = model_1.vertexY[l1];
                    vertexZ[verticeCount] = model_1.vertexZ[l1];
                    verticeCount++;
                }

                for(int i2 = 0; i2 < model_1.triangleCount; i2++)
                {
                    triangleA[triangleCount] = model_1.triangleA[i2] + k1;
                    triangleB[triangleCount] = model_1.triangleB[i2] + k1;
                    triangleC[triangleCount] = model_1.triangleC[i2] + k1;
                    triangleHslA[triangleCount] = model_1.triangleHslA[i2];
                    triangleHslB[triangleCount] = model_1.triangleHslB[i2];
                    triangleHslC[triangleCount] = model_1.triangleHslC[i2];
                    if(flag1)
                        if(model_1.triangleDrawType == null)
                        {
                            triangleDrawType[triangleCount] = 0;
                        } else
                        {
                            int j2 = model_1.triangleDrawType[i2];
                            if((j2 & 2) == 2)
                                j2 += i1 << 2;
                            triangleDrawType[triangleCount] = j2;
                        }
                    if(flag2)
                        if(model_1.facePriority == null)
                            facePriority[triangleCount] = model_1.anInt1641;
                        else
                            facePriority[triangleCount] = model_1.facePriority[i2];
                    if(flag3)
                        if(model_1.triangleAlpha == null)
                            triangleAlpha[triangleCount] = 0;
                        else
                            triangleAlpha[triangleCount] = model_1.triangleAlpha[i2];
                    if(flag4 && model_1.triangleColours != null)
                        triangleColours[triangleCount] = model_1.triangleColours[i2];
                    triangleCount++;
                }

                for(int k2 = 0; k2 < model_1.texturedTriangeAmmount; k2++)
                {
                    triPIndex[texturedTriangeAmmount] = model_1.triPIndex[k2] + k1;
                    triMIndex[texturedTriangeAmmount] = model_1.triMIndex[k2] + k1;
                    triNIndex[texturedTriangeAmmount] = model_1.triNIndex[k2] + k1;
                    texturedTriangeAmmount++;
                }

                i1 += model_1.texturedTriangeAmmount;
            }
        }

        calculateDiagonals();
    }

    public Model(boolean flag, boolean flag1, boolean flag2, Model model)
    {
        aBoolean1659 = false;
        verticeCount = model.verticeCount;
        triangleCount = model.triangleCount;
        texturedTriangeAmmount = model.texturedTriangeAmmount;
        if(flag2)
        {
            vertexX = model.vertexX;
            vertexY = model.vertexY;
            vertexZ = model.vertexZ;
        } else
        {
            vertexX = new int[verticeCount];
            vertexY = new int[verticeCount];
            vertexZ = new int[verticeCount];
            for(int j = 0; j < verticeCount; j++)
            {
                vertexX[j] = model.vertexX[j];
                vertexY[j] = model.vertexY[j];
                vertexZ[j] = model.vertexZ[j];
            }

        }
        if(flag)
        {
            triangleColours = model.triangleColours;
        } else
        {
            triangleColours = new int[triangleCount];
            System.arraycopy(model.triangleColours, 0, triangleColours, 0, triangleCount);

        }
        if(flag1)
        {
            triangleAlpha = model.triangleAlpha;
        } else
        {
            triangleAlpha = new int[triangleCount];
            if(model.triangleAlpha == null)
            {
                for(int l = 0; l < triangleCount; l++)
                    triangleAlpha[l] = 0;

            } else
            {
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

    public Model(boolean flag, boolean flag1, Model model)
    {
        aBoolean1659 = false;
        verticeCount = model.verticeCount;
        triangleCount = model.triangleCount;
        texturedTriangeAmmount = model.texturedTriangeAmmount;
        if(flag)
        {
            vertexY = new int[verticeCount];
            System.arraycopy(model.vertexY, 0, vertexY, 0, verticeCount);

        } else
        {
            vertexY = model.vertexY;
        }
        if(flag1)
        {
            triangleHslA = new int[triangleCount];
            triangleHslB = new int[triangleCount];
            triangleHslC = new int[triangleCount];
            for(int k = 0; k < triangleCount; k++)
            {
                triangleHslA[k] = model.triangleHslA[k];
                triangleHslB[k] = model.triangleHslB[k];
                triangleHslC[k] = model.triangleHslC[k];
            }

            triangleDrawType = new int[triangleCount];
            if(model.triangleDrawType == null)
            {
                for(int l = 0; l < triangleCount; l++)
                    triangleDrawType[l] = 0;

            } else
            {
                System.arraycopy(model.triangleDrawType, 0, triangleDrawType, 0, triangleCount);

            }
            super.vertexNormal = new VertexNormal[verticeCount];
            for(int j1 = 0; j1 < verticeCount; j1++)
            {
                VertexNormal vertexNormal = super.vertexNormal[j1] = new VertexNormal();
                VertexNormal vertexNormal_1 = model.vertexNormal[j1];
                vertexNormal.x = vertexNormal_1.x;
                vertexNormal.y = vertexNormal_1.y;
                vertexNormal.z = vertexNormal_1.z;
                vertexNormal.magnitude = vertexNormal_1.magnitude;
            }

            vertexNormalOffset = model.vertexNormalOffset;
        } else
        {
            triangleHslA = model.triangleHslA;
            triangleHslB = model.triangleHslB;
            triangleHslC = model.triangleHslC;
            triangleDrawType = model.triangleDrawType;
        }
        vertexX = model.vertexX;
        vertexZ = model.vertexZ;
        triangleColours = model.triangleColours;
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

    public void method464(Model model, boolean flag)
    {
        verticeCount = model.verticeCount;
        triangleCount = model.triangleCount;
        texturedTriangeAmmount = model.texturedTriangeAmmount;
        if(anIntArray1622.length < verticeCount)
        {
            anIntArray1622 = new int[verticeCount + 100];
            anIntArray1623 = new int[verticeCount + 100];
            anIntArray1624 = new int[verticeCount + 100];
        }
        vertexX = anIntArray1622;
        vertexY = anIntArray1623;
        vertexZ = anIntArray1624;
        for(int k = 0; k < verticeCount; k++)
        {
            vertexX[k] = model.vertexX[k];
            vertexY[k] = model.vertexY[k];
            vertexZ[k] = model.vertexZ[k];
        }

        if(flag)
        {
            triangleAlpha = model.triangleAlpha;
        } else
        {
            if(anIntArray1625.length < triangleCount)
                anIntArray1625 = new int[triangleCount + 100];
            triangleAlpha = anIntArray1625;
            if(model.triangleAlpha == null)
            {
                for(int l = 0; l < triangleCount; l++)
                    triangleAlpha[l] = 0;

            } else
            {
                System.arraycopy(model.triangleAlpha, 0, triangleAlpha, 0, triangleCount);

            }
        }
        triangleDrawType = model.triangleDrawType;
        triangleColours = model.triangleColours;
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

    private int method465(Model model, int i)
    {
        int j = -1;
        int k = model.vertexX[i];
        int l = model.vertexY[i];
        int i1 = model.vertexZ[i];
        for(int j1 = 0; j1 < verticeCount; j1++)
        {
            if(k != vertexX[j1] || l != vertexY[j1] || i1 != vertexZ[j1])
                continue;
            j = j1;
            break;
        }

        if(j == -1)
        {
            vertexX[verticeCount] = k;
            vertexY[verticeCount] = l;
            vertexZ[verticeCount] = i1;
            if(model.vertexVSkin != null)
                vertexVSkin[verticeCount] = model.vertexVSkin[i];
            j = verticeCount++;
        }
        return j;
    }

    public void calculateDiagonals()
    {
        super.modelHeight = 0;
        diagonal2DAboveorigin = 0;
        maxY = 0;
        for(int verticePointer = 0; verticePointer < verticeCount; verticePointer++)
        {
            int v_x = vertexX[verticePointer];
            int v_y = vertexY[verticePointer];
            int v_z = vertexZ[verticePointer];
            if(-v_y > super.modelHeight)
                super.modelHeight = -v_y;
            if(v_y > maxY)
                maxY = v_y;
            int bounds_diagonal = v_x * v_x + v_z * v_z;
            if(bounds_diagonal > diagonal2DAboveorigin)
                diagonal2DAboveorigin = bounds_diagonal;
        }
        diagonal2DAboveorigin = (int)(Math.sqrt(diagonal2DAboveorigin) + 0.98999999999999999D);
        diagonal3DAboveorigin = (int)(Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + super.modelHeight * super.modelHeight) + 0.98999999999999999D);
        diagonal3D = diagonal3DAboveorigin + (int)(Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + maxY * maxY) + 0.98999999999999999D);
    }

    public void method467()
    {
        super.modelHeight = 0;
        maxY = 0;
        for(int i = 0; i < verticeCount; i++)
        {
            int j = vertexY[i];
            if(-j > super.modelHeight)
                super.modelHeight = -j;
            if(j > maxY)
                maxY = j;
        }

        diagonal3DAboveorigin = (int)(Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + super.modelHeight * super.modelHeight) + 0.98999999999999999D);
        diagonal3D = diagonal3DAboveorigin + (int)(Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + maxY * maxY) + 0.98999999999999999D);
    }

    private void calculateDiagonalsAndStats()
    {
        super.modelHeight = 0;
        diagonal2DAboveorigin = 0;
        maxY = 0;
        minX = 0xf423f;//todo - change to int - 999999
        maxX = 0xfff0bdc1;//4293967297
        maxZ = 0xfffe7961;//4294867297
        minZ = 0x1869f;//99999
        for(int j = 0; j < verticeCount; j++)
        {
            int v_x = vertexX[j];
            int v_y = vertexY[j];
            int v_z = vertexZ[j];
            if(v_x < minX)
                minX = v_x;
            if(v_x > maxX)
                maxX = v_x;
            if(v_z < minZ)
                minZ = v_z;
            if(v_z > maxZ)
                maxZ = v_z;
            if(-v_y > super.modelHeight)
                super.modelHeight = -v_y;
            if(v_y > maxY)
                maxY = v_y;
            int _diagonal_2D_aboveorigin = v_x * v_x + v_z * v_z;
            if(_diagonal_2D_aboveorigin > diagonal2DAboveorigin)
                diagonal2DAboveorigin = _diagonal_2D_aboveorigin;
        }

        diagonal2DAboveorigin = (int)Math.sqrt(diagonal2DAboveorigin);
        diagonal3DAboveorigin = (int)Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + super.modelHeight * super.modelHeight);
            diagonal3D = diagonal3DAboveorigin + (int)Math.sqrt(diagonal2DAboveorigin * diagonal2DAboveorigin + maxY * maxY);
    }

    public void calcSkinning()
    {
        if(vertexVSkin != null)
        {
            int ai[] = new int[256];
            int j = 0;
            for(int l = 0; l < verticeCount; l++)
            {
                int j1 = vertexVSkin[l];
                ai[j1]++;
                if(j1 > j)
                    j = j1;
            }

            vertexSkin = new int[j + 1][];
            for(int k1 = 0; k1 <= j; k1++)
            {
                vertexSkin[k1] = new int[ai[k1]];
                ai[k1] = 0;
            }

            for(int j2 = 0; j2 < verticeCount; j2++)
            {
                int l2 = vertexVSkin[j2];
                vertexSkin[l2][ai[l2]++] = j2;
            }

            vertexVSkin = null;
        }
        if(triangleTSkin != null)
        {
            int ai1[] = new int[256];
            int k = 0;
            for(int i1 = 0; i1 < triangleCount; i1++)
            {
                int l1 = triangleTSkin[i1];
                ai1[l1]++;
                if(l1 > k)
                    k = l1;
            }

            triangleSkin = new int[k + 1][];
            for(int i2 = 0; i2 <= k; i2++)
            {
                triangleSkin[i2] = new int[ai1[i2]];
                ai1[i2] = 0;
            }

            for(int k2 = 0; k2 < triangleCount; k2++)
            {
                int i3 = triangleTSkin[k2];
                triangleSkin[i3][ai1[i3]++] = k2;
            }

            triangleTSkin = null;
        }
    }

    public void applyTransform(int frameID)
    {
        if(vertexSkin == null)
            return;
        if(frameID == -1)
            return;
        AnimationFrame animationFrame = AnimationFrame.forID(frameID);
        if(animationFrame == null)
            return;
        ModelTransform modelTransform = animationFrame.myModelTransform;
        vertexXModifier = 0;
        vertexYModifier = 0;
        vertexZModifier = 0;
        for(int k = 0; k < animationFrame.anInt638; k++)
        {
            int opcodeID = animationFrame.opcodeLinkTable[k];
            transformStep(modelTransform.opcodes[opcodeID], modelTransform.skinList[opcodeID], animationFrame.modifier1[k], animationFrame.modifier2[k], animationFrame.modifier3[k]);
        }

    }

    public void mixAnimationFrames(int framesFrom2[], int frameId2, int frameId1)
    {
        if(frameId1 == -1)
            return;
        if(framesFrom2 == null || frameId2 == -1)
        {
            applyTransform(frameId1);
            return;
        }
        AnimationFrame animationFrame = AnimationFrame.forID(frameId1);
        if(animationFrame == null)
            return;
        AnimationFrame animationFrame_1 = AnimationFrame.forID(frameId2);
        if(animationFrame_1 == null)
        {
            applyTransform(frameId1);
            return;
        }
        ModelTransform modelTransform = animationFrame.myModelTransform;
        vertexXModifier = 0;
        vertexYModifier = 0;
        vertexZModifier = 0;
        int l = 0;
        int stepIDD = framesFrom2[l++];
        for(int j1 = 0; j1 < animationFrame.anInt638; j1++)
        {
            int k1;
            for(k1 = animationFrame.opcodeLinkTable[j1]; k1 > stepIDD; stepIDD = framesFrom2[l++]);
            if(k1 != stepIDD || modelTransform.opcodes[k1] == 0)
                transformStep(modelTransform.opcodes[k1], modelTransform.skinList[k1], animationFrame.modifier1[j1], animationFrame.modifier2[j1], animationFrame.modifier3[j1]);
        }

        vertexXModifier = 0;
        vertexYModifier = 0;
        vertexZModifier = 0;
        l = 0;
        stepIDD = framesFrom2[l++];
        for(int l1 = 0; l1 < animationFrame_1.anInt638; l1++)
        {
            int stepID;
            for(stepID = animationFrame_1.opcodeLinkTable[l1]; stepID > stepIDD; stepIDD = framesFrom2[l++]);
            if(stepID == stepIDD || modelTransform.opcodes[stepID] == 0)
                transformStep(modelTransform.opcodes[stepID], modelTransform.skinList[stepID], animationFrame_1.modifier1[l1], animationFrame_1.modifier2[l1], animationFrame_1.modifier3[l1]);
        }

    }

    private void transformStep(int opcode, int skinList[], int vXOff, int vYOff, int vZOff)
    {
        int skinlistCount = skinList.length;
        if(opcode == 0)
        {
            int vModDiv = 0;
            vertexXModifier = 0;
            vertexYModifier = 0;
            vertexZModifier = 0;
            for(int k2 = 0; k2 < skinlistCount; k2++)
            {
                int vskinID = skinList[k2];
                if(vskinID < vertexSkin.length)
                {
                    int ai5[] = vertexSkin[vskinID];
                    for(int idxVM = 0; idxVM < ai5.length; idxVM++)
                    {
                        int j6 = ai5[idxVM];
                        vertexXModifier += vertexX[j6];
                        vertexYModifier += vertexY[j6];
                        vertexZModifier += vertexZ[j6];
                        vModDiv++;
                    }

                }
            }

            if(vModDiv > 0)
            {
                vertexXModifier = vertexXModifier / vModDiv + vXOff;
                vertexYModifier = vertexYModifier / vModDiv + vYOff;
                vertexZModifier = vertexZModifier / vModDiv + vZOff;
                return;
            } else
            {
                vertexXModifier = vXOff;
                vertexYModifier = vYOff;
                vertexZModifier = vZOff;
                return;
            }
        }
        if(opcode == 1)  //Translate
        {
            for(int k1 = 0; k1 < skinlistCount; k1++)
            {
                int l2 = skinList[k1];
                if(l2 < vertexSkin.length)
                {
                    int ai1[] = vertexSkin[l2];
                    for(int i4 = 0; i4 < ai1.length; i4++)
                    {
                        int j5 = ai1[i4];
                        vertexX[j5] += vXOff;
                        vertexY[j5] += vYOff;
                        vertexZ[j5] += vZOff;
                    }

                }
            }

            return;
        }
        if(opcode == 2)//Rotate
        {
            for(int l1 = 0; l1 < skinlistCount; l1++)
            {
                int i3 = skinList[l1];
                if(i3 < vertexSkin.length)
                {
                    int ai2[] = vertexSkin[i3];
                    for(int j4 = 0; j4 < ai2.length; j4++)
                    {
                        int k5 = ai2[j4];
                        vertexX[k5] -= vertexXModifier;
                        vertexY[k5] -= vertexYModifier;
                        vertexZ[k5] -= vertexZModifier;
                        int k6 = (vXOff & 0xff) * 8;
                        int l6 = (vYOff & 0xff) * 8;
                        int i7 = (vZOff & 0xff) * 8;
                        if(i7 != 0)
                        {
                            int j7 = SINE[i7];
                            int i8 = COSINE[i7];
                            int l8 = vertexY[k5] * j7 + vertexX[k5] * i8 >> 16;
                            vertexY[k5] = vertexY[k5] * i8 - vertexX[k5] * j7 >> 16;
                            vertexX[k5] = l8;
                        }
                        if(k6 != 0)
                        {
                            int k7 = SINE[k6];
                            int j8 = COSINE[k6];
                            int i9 = vertexY[k5] * j8 - vertexZ[k5] * k7 >> 16;
                            vertexZ[k5] = vertexY[k5] * k7 + vertexZ[k5] * j8 >> 16;
                            vertexY[k5] = i9;
                        }
                        if(l6 != 0)
                        {
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
        if(opcode == 3)//scale
        {
            for(int skinListIDX = 0; skinListIDX < skinlistCount; skinListIDX++)
            {
                int skinID = skinList[skinListIDX];
                if(skinID < vertexSkin.length)
                {
                    int vSkin[] = vertexSkin[skinID];
                    for(int skinPos = 0; skinPos < vSkin.length; skinPos++)
                    {
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
        if(opcode == 5 && triangleSkin != null && triangleAlpha != null)//SetAlpha
        {
            for(int mapID = 0; mapID < skinlistCount; mapID++)
            {
                int skinID = skinList[mapID];
                if(skinID < triangleSkin.length)
                {
                    int tskin[] = triangleSkin[skinID];
                    for(int l4 = 0; l4 < tskin.length; l4++)
                    {
                        int i6 = tskin[l4];
                        triangleAlpha[i6] += vXOff * 8;
                        if(triangleAlpha[i6] < 0)
                            triangleAlpha[i6] = 0;
                        if(triangleAlpha[i6] > 255)
                            triangleAlpha[i6] = 255;
                    }

                }
            }

        }
    }

    public void method473()
    {
        for(int j = 0; j < verticeCount; j++)
        {
            int k = vertexX[j];
            vertexX[j] = vertexZ[j];
            vertexZ[j] = -k;
        }

    }

    public void method474(int i)
    {
        int k = SINE[i];
        int l = COSINE[i];
        for(int i1 = 0; i1 < verticeCount; i1++)
        {
            int j1 = vertexY[i1] * l - vertexZ[i1] * k >> 16;
            vertexZ[i1] = vertexY[i1] * k + vertexZ[i1] * l >> 16;
            vertexY[i1] = j1;
        }
    }

    public void translate(int i, int j, int l)
    {
        for(int i1 = 0; i1 < verticeCount; i1++)
        {
            vertexX[i1] += i;
            vertexY[i1] += j;
            vertexZ[i1] += l;
        }

    }

    public void recolour(int i, int j)
    {
        for(int k = 0; k < triangleCount; k++)
            if(triangleColours[k] == i)
                triangleColours[k] = j;

    }

    public void method477()
    {
        for(int j = 0; j < verticeCount; j++)
            vertexZ[j] = -vertexZ[j];

        for(int k = 0; k < triangleCount; k++)
        {
            int l = triangleA[k];
            triangleA[k] = triangleC[k];
            triangleC[k] = l;
        }
    }

    public void scaleT(int i, int j, int l)
    {
        for(int i1 = 0; i1 < verticeCount; i1++)
        {
            vertexX[i1] = (vertexX[i1] * i) / 128;
            vertexY[i1] = (vertexY[i1] * l) / 128;
            vertexZ[i1] = (vertexZ[i1] * j) / 128;
        }

    }

    public void preprocess(int lightMod, int magMultiplyer, int l_x, int l_y, int l_z, boolean flatShading)
    {
        int _mag_pre = (int)Math.sqrt(l_x * l_x + l_y * l_y + l_z * l_z);
        int mag = magMultiplyer * _mag_pre >> 8;
        if(triangleHslA == null)
        {
            triangleHslA = new int[triangleCount];
            triangleHslB = new int[triangleCount];
            triangleHslC = new int[triangleCount];
        }
        if(super.vertexNormal == null)
        {
            super.vertexNormal = new VertexNormal[verticeCount];
            for(int l1 = 0; l1 < verticeCount; l1++)
                super.vertexNormal[l1] = new VertexNormal();

        }
        for(int triID = 0; triID < triangleCount; triID++)
        {//todo - rename this to camelcode in future (peter plz do this, looks fucking complicated >:)
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
            for(normalZ = d_a_b_x * d_c_a_y - d_c_a_x * d_a_b_y; normalX > 8192 || normalY > 8192 || normalZ > 8192 || normalX < -8192 || normalY < -8192 || normalZ < -8192; normalZ >>= 1)
            {
                normalX >>= 1;
                normalY >>= 1;
            }

            int normal_length = (int)Math.sqrt(normalX * normalX + normalY * normalY + normalZ * normalZ);
            if(normal_length <= 0)
                normal_length = 1;
            normalX = (normalX * 256) / normal_length;//Normalization
            normalY = (normalY * 256) / normal_length;
            normalZ = (normalZ * 256) / normal_length;
            if(triangleDrawType == null || (triangleDrawType[triID] & 1) == 0)
            {
                VertexNormal vertexNormal_2 = super.vertexNormal[t_a];
                vertexNormal_2.x += normalX;
                vertexNormal_2.y += normalY;
                vertexNormal_2.z += normalZ;
                vertexNormal_2.magnitude++;
                vertexNormal_2 = super.vertexNormal[t_b];
                vertexNormal_2.x += normalX;
                vertexNormal_2.y += normalY;
                vertexNormal_2.z += normalZ;
                vertexNormal_2.magnitude++;
                vertexNormal_2 = super.vertexNormal[t_c];
                vertexNormal_2.x += normalX;
                vertexNormal_2.y += normalY;
                vertexNormal_2.z += normalZ;
                vertexNormal_2.magnitude++;
            } else
            {
                int lightness = lightMod + (l_x * normalX + l_y * normalY + l_z * normalZ) / (mag + mag / 2);
                triangleHslA[triID] = mixLightness(triangleColours[triID], lightness, triangleDrawType[triID]);
            }
        }
//todo - this can be condensed
        
        if(flatShading)
        {
            doShading(lightMod, mag, l_x, l_y, l_z);
        } else
        {
            vertexNormalOffset = new VertexNormal[verticeCount];
            for(int vertexPointer = 0; vertexPointer < verticeCount; vertexPointer++)
            {
                VertexNormal vertexNormal = super.vertexNormal[vertexPointer];
                VertexNormal vertexNormal_1 = vertexNormalOffset[vertexPointer] = new VertexNormal();
                vertexNormal_1.x = vertexNormal.x;
                vertexNormal_1.y = vertexNormal.y;
                vertexNormal_1.z = vertexNormal.z;
                vertexNormal_1.magnitude = vertexNormal.magnitude;
            }

        }
        if(flatShading)
        {
            calculateDiagonals();
        } else
        {
            calculateDiagonalsAndStats();
        }
    }

    public void doShading(int intensity, int falloff, int l_x, int l_y, int l_z)
    {
        for(int triID = 0; triID < triangleCount; triID++)
        {
            int triA = triangleA[triID];
            int triB = triangleB[triID];
            int triC = triangleC[triID];
            if(triangleDrawType == null)
            {
                int t_hsl = triangleColours[triID];
                VertexNormal vertexNormal = super.vertexNormal[triA];
                int l = intensity + (l_x * vertexNormal.x + l_y * vertexNormal.y + l_z * vertexNormal.z) / (falloff * vertexNormal.magnitude);
                triangleHslA[triID] = mixLightness(t_hsl, l, 0);
                vertexNormal = super.vertexNormal[triB];
                l = intensity + (l_x * vertexNormal.x + l_y * vertexNormal.y + l_z * vertexNormal.z) / (falloff * vertexNormal.magnitude);
                triangleHslB[triID] = mixLightness(t_hsl, l, 0);
                vertexNormal = super.vertexNormal[triC];
                l = intensity + (l_x * vertexNormal.x + l_y * vertexNormal.y + l_z * vertexNormal.z) / (falloff * vertexNormal.magnitude);
                triangleHslC[triID] = mixLightness(t_hsl, l, 0);
            } else if((triangleDrawType[triID] & 1) == 0){
            	//Bit 1 of triangle_draw_type ON means mix_lightness returns just lightness
            	//instead of mixed hsl
                int t_hsl = triangleColours[triID];
                int t_flags = triangleDrawType[triID];
                VertexNormal vertexNormal_1 = super.vertexNormal[triA];
                int l = intensity + (l_x * vertexNormal_1.x + l_y * vertexNormal_1.y + l_z * vertexNormal_1.z) / (falloff * vertexNormal_1.magnitude);
                triangleHslA[triID] = mixLightness(t_hsl, l, t_flags);
                vertexNormal_1 = super.vertexNormal[triB];
                l = intensity + (l_x * vertexNormal_1.x + l_y * vertexNormal_1.y + l_z * vertexNormal_1.z) / (falloff * vertexNormal_1.magnitude);
                triangleHslB[triID] = mixLightness(t_hsl, l, t_flags);
                vertexNormal_1 = super.vertexNormal[triC];
                l = intensity + (l_x * vertexNormal_1.x + l_y * vertexNormal_1.y + l_z * vertexNormal_1.z) / (falloff * vertexNormal_1.magnitude);
                triangleHslC[triID] = mixLightness(t_hsl, l, t_flags);
            }
        }

        super.vertexNormal = null;
        vertexNormalOffset = null;
        vertexVSkin = null;
        triangleTSkin = null;
        if(triangleDrawType != null)
        {
            for(int l1 = 0; l1 < triangleCount; l1++)
                if((triangleDrawType[l1] & 2) == 2)
                    return;

        }
        triangleColours = null;
    }

    private static int mixLightness(int hsl, int l, int flags)
    {
        if((flags & 2) == 2)
        {
            if(l < 0)
                l = 0;
            else
            if(l > 127)
                l = 127;
            l = 127 - l;
            return l;
        }
        l = l * (hsl & 0x7f) >> 7;
        if(l < 2)
            l = 2;
        else
        if(l > 126)
            l = 126;
        return (hsl & 0xff80) + l;
    }

    public void rendersingle(int j, int k, int l, int i1, int j1, int k1)
    {//todo figure if i has any significence to its value.
        int i = 0; //was a parameter
        int l1 = ThreeDimensionalDrawingArea.xMidPos;
        int i2 = ThreeDimensionalDrawingArea.yMidPos;
        int j2 = SINE[i];//[i]
        int k2 = COSINE[i];//[i]
        int l2 = SINE[j];
        int i3 = COSINE[j];
        int j3 = SINE[k];
        int k3 = COSINE[k];
        int l3 = SINE[l];
        int i4 = COSINE[l];
        int j4 = j1 * l3 + k1 * i4 >> 16;
        for(int k4 = 0; k4 < verticeCount; k4++)
        {
            int l4 = vertexX[k4];
            int i5 = vertexY[k4];
            int j5 = vertexZ[k4];
            if(k != 0)
            {
                int k5 = i5 * j3 + l4 * k3 >> 16;
                i5 = i5 * k3 - l4 * j3 >> 16;
                l4 = k5;
            }
            if(i != 0)
            {
                int l5 = i5 * k2 - j5 * j2 >> 16;
                j5 = i5 * j2 + j5 * k2 >> 16;
                i5 = l5;
            }
            if(j != 0)
            {
                int i6 = j5 * l2 + l4 * i3 >> 16;
                j5 = j5 * i3 - l4 * l2 >> 16;
                l4 = i6;
            }
            l4 += i1;
            i5 += j1;
            j5 += k1;
            int j6 = i5 * i4 - j5 * l3 >> 16;
            j5 = i5 * l3 + j5 * i4 >> 16;
            i5 = j6;
            cameraDepth[k4] = j5 - j4;
            anIntArray1665[k4] = l1 + (l4 << 9) / j5;
            anIntArray1666[k4] = i2 + (i5 << 9) / j5;
            if(texturedTriangeAmmount > 0)
            {
                anIntArray1668[k4] = l4;
                vertexBY[k4] = i5;
                anIntArray1670[k4] = j5;
            }
        }

        try
        {
            method483(false, false, 0);
        }
        catch(Exception _ex)
        {
        }
    }

    public void renderAtPoint(int i, int j, int k, int l, int i1, int j1, int k1,
            int l1, int i2)
    {
        int j2 = l1 * i1 - j1 * l >> 16;
        int k2 = k1 * j + j2 * k >> 16;
        int l2 = diagonal2DAboveorigin * k >> 16;
        int i3 = k2 + l2;
        if(i3 <= 50 || k2 >= 3500)
            return;
        int j3 = l1 * l + j1 * i1 >> 16;
        int k3 = j3 - diagonal2DAboveorigin << 9;
        if(k3 / i3 >= DrawingArea.viewportCx)
            return;
        int l3 = j3 + diagonal2DAboveorigin << 9;
        if(l3 / i3 <= -DrawingArea.viewportCx)
            return;
        int i4 = k1 * k - j2 * j >> 16;
        int j4 = diagonal2DAboveorigin * j >> 16;
        int k4 = i4 + j4 << 9;
        if(k4 / i3 <= -DrawingArea.viewportCy)
            return;
        int l4 = j4 + (super.modelHeight * k >> 16);
        int i5 = i4 - l4 << 9;
        if(i5 / i3 >= DrawingArea.viewportCy)
            return;
        int j5 = l2 + (super.modelHeight * j >> 16);
        boolean flag = false;
        if(k2 - j5 <= 50)
            flag = true;
        boolean flag1 = false;
        if(i2 > 0 && aBoolean1684)
        {
            int k5 = k2 - l2;
            if(k5 <= 50)
                k5 = 50;
            if(j3 > 0)
            {
                k3 /= i3;
                l3 /= k5;
            } else
            {
                l3 /= i3;
                k3 /= k5;
            }
            if(i4 > 0)
            {
                i5 /= i3;
                k4 /= k5;
            } else
            {
                k4 /= i3;
                i5 /= k5;
            }
            int i6 = anInt1685 - ThreeDimensionalDrawingArea.xMidPos;
            int k6 = anInt1686 - ThreeDimensionalDrawingArea.yMidPos;
            if(i6 > k3 && i6 < l3 && k6 > i5 && k6 < k4)
                if(aBoolean1659)
                    resourceIDTAG[resourceCount++] = i2;
                else
                    flag1 = true;
        }
        int l5 = ThreeDimensionalDrawingArea.xMidPos;
        int j6 = ThreeDimensionalDrawingArea.yMidPos;
        int l6 = 0;
        int i7 = 0;
        if(i != 0)
        {
            l6 = SINE[i];
            i7 = COSINE[i];
        }
        for(int j7 = 0; j7 < verticeCount; j7++)
        {
            int k7 = vertexX[j7];
            int l7 = vertexY[j7];
            int i8 = vertexZ[j7];
            if(i != 0)
            {
                int j8 = i8 * l6 + k7 * i7 >> 16;
                i8 = i8 * i7 - k7 * l6 >> 16;
                k7 = j8;
            }
            k7 += j1;
            l7 += k1;
            i8 += l1;
            int k8 = i8 * l + k7 * i1 >> 16;
            i8 = i8 * i1 - k7 * l >> 16;
            k7 = k8;
            k8 = l7 * k - i8 * j >> 16;
            i8 = l7 * j + i8 * k >> 16;
            l7 = k8;
            cameraDepth[j7] = i8 - k2;
            if(i8 >= 50)
            {
                anIntArray1665[j7] = l5 + (k7 << 9) / i8;
                anIntArray1666[j7] = j6 + (l7 << 9) / i8;
            } else
            {
                anIntArray1665[j7] = -5000;
                flag = true;
            }
            if(flag || texturedTriangeAmmount > 0)
            {
                anIntArray1668[j7] = k7;
                vertexBY[j7] = l7;
                anIntArray1670[j7] = i8;
            }
        }

        try
        {
            method483(flag, flag1, i2);
        }
        catch(Exception _ex)
        {
        }
    }

    private void method483(boolean flag, boolean flag1, int i)
    {
        for(int j = 0; j < diagonal3D; j++)
            depthListIndices[j] = 0;

        for(int k = 0; k < triangleCount; k++)
            if(triangleDrawType == null || triangleDrawType[k] != -1)
            {
                int l = triangleA[k];
                int k1 = triangleB[k];
                int j2 = triangleC[k];
                int i3 = anIntArray1665[l];
                int l3 = anIntArray1665[k1];
                int k4 = anIntArray1665[j2];
                if(flag && (i3 == -5000 || l3 == -5000 || k4 == -5000))
                {
                    aBooleanArray1664[k] = true;
                    int j5 = (cameraDepth[l] + cameraDepth[k1] + cameraDepth[j2]) / 3 + diagonal3DAboveorigin;
                    faceLists[j5][depthListIndices[j5]++] = k;
                } else
                {
                    if(flag1 && method486(anInt1685, anInt1686, anIntArray1666[l], anIntArray1666[k1], anIntArray1666[j2], i3, l3, k4))
                    {
                        resourceIDTAG[resourceCount++] = i;
                        flag1 = false;
                    }
                    if((i3 - l3) * (anIntArray1666[j2] - anIntArray1666[k1]) - (anIntArray1666[l] - anIntArray1666[k1]) * (k4 - l3) > 0)
                    {
                        aBooleanArray1664[k] = false;
                        aBooleanArray1663[k] = i3 < 0 || l3 < 0 || k4 < 0 || i3 > DrawingArea.viewportRx || l3 > DrawingArea.viewportRx || k4 > DrawingArea.viewportRx;
                        int k5 = (cameraDepth[l] + cameraDepth[k1] + cameraDepth[j2]) / 3 + diagonal3DAboveorigin;
                        faceLists[k5][depthListIndices[k5]++] = k;
                    }
                }
            }

        if(facePriority == null)
        {
            for(int i1 = diagonal3D - 1; i1 >= 0; i1--)
            {
                int l1 = depthListIndices[i1];
                if(l1 > 0)
                {
                    int ai[] = faceLists[i1];
                    for(int j3 = 0; j3 < l1; j3++)
                        rasterize(ai[j3]);

                }
            }

            return;
        }
        for(int j1 = 0; j1 < 12; j1++)
        {
            anIntArray1673[j1] = 0;
            anIntArray1677[j1] = 0;
        }

        for(int i2 = diagonal3D - 1; i2 >= 0; i2--)
        {
            int k2 = depthListIndices[i2];
            if(k2 > 0)
            {
                int ai1[] = faceLists[i2];
                for(int i4 = 0; i4 < k2; i4++)
                {
                    int l4 = ai1[i4];
                    int l5 = facePriority[l4];
                    int j6 = anIntArray1673[l5]++;
                    anIntArrayArray1674[l5][j6] = l4;
                    if(l5 < 10)
                        anIntArray1677[l5] += i2;
                    else
                    if(l5 == 10)
                        anIntArray1675[j6] = i2;
                    else
                        anIntArray1676[j6] = i2;
                }

            }
        }

        int l2 = 0;
        if(anIntArray1673[1] > 0 || anIntArray1673[2] > 0)
            l2 = (anIntArray1677[1] + anIntArray1677[2]) / (anIntArray1673[1] + anIntArray1673[2]);
        int k3 = 0;
        if(anIntArray1673[3] > 0 || anIntArray1673[4] > 0)
            k3 = (anIntArray1677[3] + anIntArray1677[4]) / (anIntArray1673[3] + anIntArray1673[4]);
        int j4 = 0;
        if(anIntArray1673[6] > 0 || anIntArray1673[8] > 0)
            j4 = (anIntArray1677[6] + anIntArray1677[8]) / (anIntArray1673[6] + anIntArray1673[8]);
        int i6 = 0;
        int k6 = anIntArray1673[10];
        int ai2[] = anIntArrayArray1674[10];
        int ai3[] = anIntArray1675;
        if(i6 == k6)
        {
            i6 = 0;
            k6 = anIntArray1673[11];
            ai2 = anIntArrayArray1674[11];
            ai3 = anIntArray1676;
        }
        int i5;
        if(i6 < k6)
            i5 = ai3[i6];
        else
            i5 = -1000;
        for(int l6 = 0; l6 < 10; l6++)
        {
            while(l6 == 0 && i5 > l2) 
            {
                rasterize(ai2[i6++]);
                if(i6 == k6 && ai2 != anIntArrayArray1674[11])
                {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if(i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            while(l6 == 3 && i5 > k3) 
            {
                rasterize(ai2[i6++]);
                if(i6 == k6 && ai2 != anIntArrayArray1674[11])
                {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if(i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            while(l6 == 5 && i5 > j4) 
            {
                rasterize(ai2[i6++]);
                if(i6 == k6 && ai2 != anIntArrayArray1674[11])
                {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if(i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            int i7 = anIntArray1673[l6];
            int ai4[] = anIntArrayArray1674[l6];
            for(int j7 = 0; j7 < i7; j7++)
                rasterize(ai4[j7]);

        }

        while(i5 != -1000) 
        {
            rasterize(ai2[i6++]);
            if(i6 == k6 && ai2 != anIntArrayArray1674[11])
            {
                i6 = 0;
                ai2 = anIntArrayArray1674[11];
                k6 = anIntArray1673[11];
                ai3 = anIntArray1676;
            }
            if(i6 < k6)
                i5 = ai3[i6];
            else
                i5 = -1000;
        }
    }

    private void rasterize(int i)
    {
        if(aBooleanArray1664[i])
        {
            method485(i);
            return;
        }
        int j = triangleA[i];
        int k = triangleB[i];
        int l = triangleC[i];
        ThreeDimensionalDrawingArea.aBoolean1462 = aBooleanArray1663[i];
        if(triangleAlpha == null)
            ThreeDimensionalDrawingArea.alpha = 0;
        else
            ThreeDimensionalDrawingArea.alpha = triangleAlpha[i];
        int i1;
        if(triangleDrawType == null)
            i1 = 0;
        else
            i1 = triangleDrawType[i] & 3;
        if(i1 == 0)
        {
            ThreeDimensionalDrawingArea.drawColouredTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], triangleHslA[i], triangleHslB[i], triangleHslC[i]);
            return;
        }
        if(i1 == 1)
        {
            ThreeDimensionalDrawingArea.method376(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], modelIntArray3[triangleHslA[i]]);
            return;
        }
        if(i1 == 2)
        {
            int j1 = triangleDrawType[i] >> 2;
            int l1 = triPIndex[j1];
            int j2 = triMIndex[j1];
            int l2 = triNIndex[j1];
            ThreeDimensionalDrawingArea.drawTexturedTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], triangleHslA[i], triangleHslB[i], triangleHslC[i], anIntArray1668[l1], anIntArray1668[j2], anIntArray1668[l2], vertexBY[l1], vertexBY[j2], vertexBY[l2], anIntArray1670[l1], anIntArray1670[j2], anIntArray1670[l2], triangleColours[i]);
            return;
        }
        if(i1 == 3)
        {
            int k1 = triangleDrawType[i] >> 2;
            int i2 = triPIndex[k1];
            int k2 = triMIndex[k1];
            int i3 = triNIndex[k1];
            ThreeDimensionalDrawingArea.drawTexturedTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], triangleHslA[i], triangleHslA[i], triangleHslA[i], anIntArray1668[i2], anIntArray1668[k2], anIntArray1668[i3], vertexBY[i2], vertexBY[k2], vertexBY[i3], anIntArray1670[i2], anIntArray1670[k2], anIntArray1670[i3], triangleColours[i]);
        }
    }

    private void method485(int i)
    {
        int j = ThreeDimensionalDrawingArea.xMidPos;
        int k = ThreeDimensionalDrawingArea.yMidPos;
        int l = 0;
        int i1 = triangleA[i];
        int j1 = triangleB[i];
        int k1 = triangleC[i];
        int l1 = anIntArray1670[i1];
        int i2 = anIntArray1670[j1];
        int j2 = anIntArray1670[k1];
        if(l1 >= 50)
        {
            anIntArray1678[l] = anIntArray1665[i1];
            anIntArray1679[l] = anIntArray1666[i1];
            anIntArray1680[l++] = triangleHslA[i];
        } else
        {
            int k2 = anIntArray1668[i1];
            int k3 = vertexBY[i1];
            int k4 = triangleHslA[i];
            if(j2 >= 50)
            {
                int k5 = (50 - l1) * modelIntArray4[j2 - l1];
                anIntArray1678[l] = j + (k2 + ((anIntArray1668[k1] - k2) * k5 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (k3 + ((vertexBY[k1] - k3) * k5 >> 16) << 9) / 50;
                anIntArray1680[l++] = k4 + ((triangleHslC[i] - k4) * k5 >> 16);
            }
            if(i2 >= 50)
            {
                int l5 = (50 - l1) * modelIntArray4[i2 - l1];
                anIntArray1678[l] = j + (k2 + ((anIntArray1668[j1] - k2) * l5 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (k3 + ((vertexBY[j1] - k3) * l5 >> 16) << 9) / 50;
                anIntArray1680[l++] = k4 + ((triangleHslB[i] - k4) * l5 >> 16);
            }
        }
        if(i2 >= 50)
        {
            anIntArray1678[l] = anIntArray1665[j1];
            anIntArray1679[l] = anIntArray1666[j1];
            anIntArray1680[l++] = triangleHslB[i];
        } else
        {
            int l2 = anIntArray1668[j1];
            int l3 = vertexBY[j1];
            int l4 = triangleHslB[i];
            if(l1 >= 50)
            {
                int i6 = (50 - i2) * modelIntArray4[l1 - i2];
                anIntArray1678[l] = j + (l2 + ((anIntArray1668[i1] - l2) * i6 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (l3 + ((vertexBY[i1] - l3) * i6 >> 16) << 9) / 50;
                anIntArray1680[l++] = l4 + ((triangleHslA[i] - l4) * i6 >> 16);
            }
            if(j2 >= 50)
            {
                int j6 = (50 - i2) * modelIntArray4[j2 - i2];
                anIntArray1678[l] = j + (l2 + ((anIntArray1668[k1] - l2) * j6 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (l3 + ((vertexBY[k1] - l3) * j6 >> 16) << 9) / 50;
                anIntArray1680[l++] = l4 + ((triangleHslC[i] - l4) * j6 >> 16);
            }
        }
        if(j2 >= 50)
        {
            anIntArray1678[l] = anIntArray1665[k1];
            anIntArray1679[l] = anIntArray1666[k1];
            anIntArray1680[l++] = triangleHslC[i];
        } else
        {
            int i3 = anIntArray1668[k1];
            int i4 = vertexBY[k1];
            int i5 = triangleHslC[i];
            if(i2 >= 50)
            {
                int k6 = (50 - j2) * modelIntArray4[i2 - j2];
                anIntArray1678[l] = j + (i3 + ((anIntArray1668[j1] - i3) * k6 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (i4 + ((vertexBY[j1] - i4) * k6 >> 16) << 9) / 50;
                anIntArray1680[l++] = i5 + ((triangleHslB[i] - i5) * k6 >> 16);
            }
            if(l1 >= 50)
            {
                int l6 = (50 - j2) * modelIntArray4[l1 - j2];
                anIntArray1678[l] = j + (i3 + ((anIntArray1668[i1] - i3) * l6 >> 16) << 9) / 50;
                anIntArray1679[l] = k + (i4 + ((vertexBY[i1] - i4) * l6 >> 16) << 9) / 50;
                anIntArray1680[l++] = i5 + ((triangleHslA[i] - i5) * l6 >> 16);
            }
        }
        int j3 = anIntArray1678[0];
        int j4 = anIntArray1678[1];
        int j5 = anIntArray1678[2];
        int i7 = anIntArray1679[0];
        int j7 = anIntArray1679[1];
        int k7 = anIntArray1679[2];
        if((j3 - j4) * (k7 - j7) - (i7 - j7) * (j5 - j4) > 0)
        {
            ThreeDimensionalDrawingArea.aBoolean1462 = false;
            if(l == 3)
            {
                if(j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.viewportRx || j4 > DrawingArea.viewportRx || j5 > DrawingArea.viewportRx)
                    ThreeDimensionalDrawingArea.aBoolean1462 = true;
                int l7;
                if(triangleDrawType == null)
                    l7 = 0;
                else
                    l7 = triangleDrawType[i] & 3;
                if(l7 == 0)
                    ThreeDimensionalDrawingArea.drawColouredTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2]);
                else
                if(l7 == 1)
                    ThreeDimensionalDrawingArea.method376(i7, j7, k7, j3, j4, j5, modelIntArray3[triangleHslA[i]]);
                else
                if(l7 == 2)
                {
                    int j8 = triangleDrawType[i] >> 2;
                    int k9 = triPIndex[j8];
                    int k10 = triMIndex[j8];
                    int k11 = triNIndex[j8];
                    ThreeDimensionalDrawingArea.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], anIntArray1668[k9], anIntArray1668[k10], anIntArray1668[k11], vertexBY[k9], vertexBY[k10], vertexBY[k11], anIntArray1670[k9], anIntArray1670[k10], anIntArray1670[k11], triangleColours[i]);
                } else
                if(l7 == 3)
                {
                    int k8 = triangleDrawType[i] >> 2;
                    int l9 = triPIndex[k8];
                    int l10 = triMIndex[k8];
                    int l11 = triNIndex[k8];
                    ThreeDimensionalDrawingArea.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, triangleHslA[i], triangleHslA[i], triangleHslA[i], anIntArray1668[l9], anIntArray1668[l10], anIntArray1668[l11], vertexBY[l9], vertexBY[l10], vertexBY[l11], anIntArray1670[l9], anIntArray1670[l10], anIntArray1670[l11], triangleColours[i]);
                }
            }
            if(l == 4)
            {
                if(j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.viewportRx || j4 > DrawingArea.viewportRx || j5 > DrawingArea.viewportRx || anIntArray1678[3] < 0 || anIntArray1678[3] > DrawingArea.viewportRx)
                    ThreeDimensionalDrawingArea.aBoolean1462 = true;
                int i8;
                if(triangleDrawType == null)
                    i8 = 0;
                else
                    i8 = triangleDrawType[i] & 3;
                if(i8 == 0)
                {
                    ThreeDimensionalDrawingArea.drawColouredTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2]);
                    ThreeDimensionalDrawingArea.drawColouredTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], anIntArray1680[0], anIntArray1680[2], anIntArray1680[3]);
                    return;
                }
                if(i8 == 1)
                {
                    int l8 = modelIntArray3[triangleHslA[i]];
                    ThreeDimensionalDrawingArea.method376(i7, j7, k7, j3, j4, j5, l8);
                    ThreeDimensionalDrawingArea.method376(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], l8);
                    return;
                }
                if(i8 == 2)
                {
                    int i9 = triangleDrawType[i] >> 2;
                    int i10 = triPIndex[i9];
                    int i11 = triMIndex[i9];
                    int i12 = triNIndex[i9];
                    ThreeDimensionalDrawingArea.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], anIntArray1668[i10], anIntArray1668[i11], anIntArray1668[i12], vertexBY[i10], vertexBY[i11], vertexBY[i12], anIntArray1670[i10], anIntArray1670[i11], anIntArray1670[i12], triangleColours[i]);
                    ThreeDimensionalDrawingArea.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], anIntArray1680[0], anIntArray1680[2], anIntArray1680[3], anIntArray1668[i10], anIntArray1668[i11], anIntArray1668[i12], vertexBY[i10], vertexBY[i11], vertexBY[i12], anIntArray1670[i10], anIntArray1670[i11], anIntArray1670[i12], triangleColours[i]);
                    return;
                }
                if(i8 == 3)
                {
                    int j9 = triangleDrawType[i] >> 2;
                    int j10 = triPIndex[j9];
                    int j11 = triMIndex[j9];
                    int j12 = triNIndex[j9];
                    ThreeDimensionalDrawingArea.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, triangleHslA[i], triangleHslA[i], triangleHslA[i], anIntArray1668[j10], anIntArray1668[j11], anIntArray1668[j12], vertexBY[j10], vertexBY[j11], vertexBY[j12], anIntArray1670[j10], anIntArray1670[j11], anIntArray1670[j12], triangleColours[i]);
                    ThreeDimensionalDrawingArea.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], triangleHslA[i], triangleHslA[i], triangleHslA[i], anIntArray1668[j10], anIntArray1668[j11], anIntArray1668[j12], vertexBY[j10], vertexBY[j11], vertexBY[j12], anIntArray1670[j10], anIntArray1670[j11], anIntArray1670[j12], triangleColours[i]);
                }
            }
        }
    }

    private boolean method486(int i, int j, int k, int l, int i1, int j1, int k1,
            int l1)
    {
        if(j < k && j < l && j < i1)
            return false;
        if(j > k && j > l && j > i1)
            return false;
        return !(i < j1 && i < k1 && i < l1) && (i <= j1 || i <= k1 || i <= l1);
    }

    public static final Model aModel_1621 = new Model();
    private static int[] anIntArray1622 = new int[2000];
    private static int[] anIntArray1623 = new int[2000];
    private static int[] anIntArray1624 = new int[2000];
    private static int[] anIntArray1625 = new int[2000];
    public int verticeCount;
    public int vertexX[];
    public int vertexY[];
    public int vertexZ[];
    public int triangleCount;
    public int triangleA[];
    public int triangleB[];
    public int triangleC[];
    private int[] triangleHslA;
    private int[] triangleHslB;
    private int[] triangleHslC;
    public int triangleDrawType[];
    private int[] facePriority;
    private int[] triangleAlpha;
    public int triangleColours[];
  
    private int anInt1641;
    private int texturedTriangeAmmount;
    private int[] triPIndex;
    private int[] triMIndex;
    private int[] triNIndex;
    public int minX;
    public int maxX;
    public int maxZ;
    public int minZ;
    public int diagonal2DAboveorigin;
    public int maxY;
    private int diagonal3D;
    private int diagonal3DAboveorigin;
    public int anInt1654;
    private int[] vertexVSkin;
    private int[] triangleTSkin;
    public int vertexSkin[][];
    public int triangleSkin[][];
    public boolean aBoolean1659;
    VertexNormal vertexNormalOffset[];
    private static ModelHeader[] modelHeaderCache;
    private static OnDemandFetcherParent aOnDemandFetcherParent_1662;
    private static boolean[] aBooleanArray1663 = new boolean[4096];
    private static boolean[] aBooleanArray1664 = new boolean[4096];
    private static int[] anIntArray1665 = new int[4096];
    private static int[] anIntArray1666 = new int[4096];
    private static int[] cameraDepth = new int[4096];
    private static int[] anIntArray1668 = new int[4096];
    private static int[] vertexBY = new int[4096];
    private static int[] anIntArray1670 = new int[4096];
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
    public static int anInt1685;
    public static int anInt1686;
    public static int resourceCount;
    public static final int[] resourceIDTAG = new int[1000];
    public static int SINE[];
    public static int COSINE[];
    private static int[] modelIntArray3;
    private static int[] modelIntArray4;

    static 
    {
        SINE = ThreeDimensionalDrawingArea.SINE;
        COSINE = ThreeDimensionalDrawingArea.COSINE;
        modelIntArray3 = ThreeDimensionalDrawingArea.HSL2RGB;
        modelIntArray4 = ThreeDimensionalDrawingArea.anIntArray1469;
    }
}
