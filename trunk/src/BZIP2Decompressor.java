//Thanks sadistic :3

final class BZIP2Decompressor
{


    public static int decompressBuffer(byte outputBuf[], int decompressedSize, byte inputBuf[], int compressedSize, int offset)
    {
        synchronized(Bzip2Decompressor)
        {
            Bzip2Decompressor.inputBuffer = inputBuf;
            Bzip2Decompressor.fileStartOffsets = offset;
            Bzip2Decompressor.outputBuffer = outputBuf;
            Bzip2Decompressor.anInt569 = 0;
            Bzip2Decompressor.compressedSize = compressedSize;
            Bzip2Decompressor.decompressedSize = decompressedSize;
            Bzip2Decompressor.bitPos = 0;
            Bzip2Decompressor.current2Bytes = 0;
            Bzip2Decompressor.junk1 = 0;
            Bzip2Decompressor.junk2 = 0;
            Bzip2Decompressor.anInt571 = 0;
            Bzip2Decompressor.anInt572 = 0;
            Bzip2Decompressor.junk3 = 0;
            getNextBlock(Bzip2Decompressor);
            decompressedSize -= Bzip2Decompressor.decompressedSize;
            return decompressedSize;
        }
    }

    @SuppressWarnings("static-access")
	private static void getNextFileHeader(BZ2Entry archive)
    {
        byte byte4 = archive.aByte573;
        int i = archive.anInt574;
        int j = archive.anInt584;
        int k = archive.anInt582;
        int buf[] = archive.anIntArray587;
        int l = archive.anInt581;
        byte outBuf[] = archive.outputBuffer;
        int i1 = archive.anInt569;
        int decompressedSize = archive.decompressedSize;
        int k1 = decompressedSize;
        int l1 = archive.anInt601 + 1;
label0:
        do
        {
            if(i > 0)
            {
                do
                {
                    if(decompressedSize == 0)
                        break label0;
                    if(i == 1)
                        break;
                    outBuf[i1] = byte4;
                    i--;
                    i1++;
                    decompressedSize--;
                } while(true);
                if(decompressedSize == 0)
                {
                    i = 1;
                    break;
                }
                outBuf[i1] = byte4;
                i1++;
                decompressedSize--;
            }
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                if(j == l1)
                {
                    i = 0;
                    break label0;
                }
                byte4 = (byte)k;
                l = buf[l];
                byte byte0 = (byte)(l & 0xff);
                l >>= 8;
                j++;
                if(byte0 != k)
                {
                    k = byte0;
                    if(decompressedSize == 0)
                    {
                        i = 1;
                    } else
                    {
                        outBuf[i1] = byte4;
                        i1++;
                        decompressedSize--;
                        flag = true;
                        continue;
                    }
                    break label0;
                }
                if(j != l1)
                    continue;
                if(decompressedSize == 0)
                {
                    i = 1;
                    break label0;
                }
                outBuf[i1] = byte4;
                i1++;
                decompressedSize--;
                flag = true;
            }
            i = 2;
            l = buf[l];
            byte byte1 = (byte)(l & 0xff);
            l >>= 8;
            if(++j != l1)
                if(byte1 != k)
                {
                    k = byte1;
                } else
                {
                    i = 3;
                    l = buf[l];
                    byte byte2 = (byte)(l & 0xff);
                    l >>= 8;
                    if(++j != l1)
                        if(byte2 != k)
                        {
                            k = byte2;
                        } else
                        {
                            l = buf[l];
                            byte byte3 = (byte)(l & 0xff);
                            l >>= 8;
                            j++;
                            i = (byte3 & 0xff) + 4;
                            l = buf[l];
                            k = (byte)(l & 0xff);
                            l >>= 8;
                            j++;
                        }
                }
        } while(true);
        int i2 = archive.anInt571;
        archive.anInt571 += k1 - decompressedSize;
        if(archive.anInt571 < i2)
            archive.anInt572++;
        archive.aByte573 = byte4;
        archive.anInt574 = i;
        archive.anInt584 = j;
        archive.anInt582 = k;
        archive.anIntArray587 = buf;
        archive.anInt581 = l;
        archive.outputBuffer = outBuf;
        archive.anInt569 = i1;
        archive.decompressedSize = decompressedSize;
    }

    @SuppressWarnings("static-access")
	private static void getNextBlock(BZ2Entry BZ2Entry)
    {
        int tMinLen = 0;
        int tLimit[] = null;
        int tBase[] = null;
        int tPerm[] = null;
        BZ2Entry.blockSize = 1;
        if(BZ2Entry.anIntArray587 == null)
            BZ2Entry.anIntArray587 = new int[BZ2Entry.blockSize * 0x186a0];
        boolean reading = true;
        while(reading) 
        {
            byte currentBlock = getByte(BZ2Entry);
            if(currentBlock == 23)
                return;
            /* Magic Numbers */
            currentBlock = getByte(BZ2Entry);// 0x41
            currentBlock = getByte(BZ2Entry);// 0x59
            currentBlock = getByte(BZ2Entry);// 0x26
            currentBlock = getByte(BZ2Entry);// 0x53
            currentBlock = getByte(BZ2Entry);// 0x59
            BZ2Entry.junk3++;
            /* CRC Checksums */
            currentBlock = getByte(BZ2Entry);
            currentBlock = getByte(BZ2Entry);
            currentBlock = getByte(BZ2Entry);
            currentBlock = getByte(BZ2Entry);
            /* Randomized block, 1 = randomized */
            currentBlock = getBit(BZ2Entry);
            BZ2Entry.randomized = currentBlock != 0;
            if(BZ2Entry.randomized)
                System.out.println("PANIC! RANDOMISED BLOCK!");
            BZ2Entry.origPointer = 0;
            currentBlock = getByte(BZ2Entry);
            BZ2Entry.origPointer = BZ2Entry.origPointer << 8 | currentBlock & 0xff;
            currentBlock = getByte(BZ2Entry);
            BZ2Entry.origPointer = BZ2Entry.origPointer << 8 | currentBlock & 0xff;
            currentBlock = getByte(BZ2Entry);
            BZ2Entry.origPointer = BZ2Entry.origPointer << 8 | currentBlock & 0xff;
            for(int j = 0; j < 16; j++)
            {
                byte byte1 = getBit(BZ2Entry);
                BZ2Entry.inUse16[j] = byte1 == 1;
            }

            for(int k = 0; k < 256; k++)
                BZ2Entry.inUse[k] = false;

            for(int idx = 0; idx < 16; idx++)
                if(BZ2Entry.inUse16[idx])
                {
                    for(int idx2 = 0; idx2 < 16; idx2++)
                    {
                        byte byte2 = getBit(BZ2Entry);
                        if(byte2 == 1)
                            BZ2Entry.inUse[idx * 16 + idx2] = true;
                    }

                }

            makeMaps(BZ2Entry);
            int alphaSize = BZ2Entry.inUseOff + 2;
            int tableCount = getBits(3, BZ2Entry);
            int selectorCount = getBits(15, BZ2Entry);
            for(int selectorIdx = 0; selectorIdx < selectorCount; selectorIdx++)
            {
                int selectorValue = 0;
                do
                {
                    byte byte3 = getBit(BZ2Entry);
                    if(byte3 == 0)
                        break;
                    selectorValue++;
                } while(true);
                BZ2Entry.selectorMtf[selectorIdx] = (byte)selectorValue;
            }

            byte pos[] = new byte[6];
            for(byte tableIndex = 0; tableIndex < tableCount; tableIndex++)
                pos[tableIndex] = tableIndex;

            for(int selectorIdx = 0; selectorIdx < selectorCount; selectorIdx++)
            {
                byte selectorMtf = BZ2Entry.selectorMtf[selectorIdx];
                byte curSelectorMtf = pos[selectorMtf];
                for(; selectorMtf > 0; selectorMtf--)
                    pos[selectorMtf] = pos[selectorMtf - 1];

                pos[0] = curSelectorMtf;
                BZ2Entry.selector[selectorIdx] = curSelectorMtf;
            }

            for(int tableIdx = 0; tableIdx < tableCount; tableIdx++)
            {
                int curr = getBits(5, BZ2Entry);
                for(int alphaIdx = 0; alphaIdx < alphaSize; alphaIdx++)
                {
                    do
                    {
                        byte flag = getBit(BZ2Entry);
                        if(flag == 0)
                            break;
                        flag = getBit(BZ2Entry);
                        if(flag == 0)
                            curr++;
                        else
                            curr--;
                    } while(true);
                    BZ2Entry.len[tableIdx][alphaIdx] = (byte)curr;
                }

            }

            for(int tableIdx = 0; tableIdx < tableCount; tableIdx++)
            {
                byte minLen = 32;
                int maxLen = 0;
                for(int alphaIdx = 0; alphaIdx < alphaSize; alphaIdx++)
                {
                    if(BZ2Entry.len[tableIdx][alphaIdx] > maxLen)
                        maxLen = BZ2Entry.len[tableIdx][alphaIdx];
                    if(BZ2Entry.len[tableIdx][alphaIdx] < minLen)
                        minLen = BZ2Entry.len[tableIdx][alphaIdx];
                }

                createDecodeTables(BZ2Entry.limit[tableIdx], BZ2Entry.base[tableIdx], BZ2Entry.perm[tableIdx], BZ2Entry.len[tableIdx], minLen, maxLen, alphaSize);
                BZ2Entry.minLens[tableIdx] = minLen;
            }

            int endOfBlock = BZ2Entry.inUseOff + 1;
            //int l5 = 0x186a0 * BZ2Entry.anInt578;//never used
            int groupNo = -1;
            int groupPos = 0;
            for(int idx = 0; idx <= 255; idx++)
                BZ2Entry.unzftab[idx] = 0;

            int j9 = 4095;
            for(int tmpIdx = 15; tmpIdx >= 0; tmpIdx--)
            {
                for(int yyIdx = 15; yyIdx >= 0; yyIdx--)
                {
                    BZ2Entry.yy[j9] = (byte)(tmpIdx * 16 + yyIdx);
                    j9--;
                }

                BZ2Entry.tmp[tmpIdx] = j9 + 1;
            }

            int last = 0;
            if(groupPos == 0)
            {
                groupNo++;
                groupPos = 50;
                byte byte12 = BZ2Entry.selector[groupNo];
                tMinLen = BZ2Entry.minLens[byte12];
                tLimit = BZ2Entry.limit[byte12];
                tPerm = BZ2Entry.perm[byte12];
                tBase = BZ2Entry.base[byte12];
            }
            groupPos--;
            int zt = tMinLen;
            int zvec;
            byte bit;
            for(zvec = getBits(zt, BZ2Entry); zvec > tLimit[zt]; zvec = zvec << 1 | bit)
            {
                zt++;
                bit = getBit(BZ2Entry);
            }

            for(int nextSym = tPerm[zvec - tBase[zt]]; nextSym != endOfBlock;)
                if(nextSym == 0 || nextSym == 1)
                {
                    int j6 = -1;
                    int k6 = 1;
                    do
                    {
                        if(nextSym == 0)
                            j6 += k6;
                        else
                        if(nextSym == 1)
                            j6 += 2 * k6;
                        k6 *= 2;
                        if(groupPos == 0)
                        {
                            groupNo++;
                            groupPos = 50;
                            byte tSelector = BZ2Entry.selector[groupNo];
                            tMinLen = BZ2Entry.minLens[tSelector];
                            tLimit = BZ2Entry.limit[tSelector];
                            tPerm = BZ2Entry.perm[tSelector];
                            tBase = BZ2Entry.base[tSelector];
                        }
                        groupPos--;
                        int zt_ = tMinLen;
                        int zvec_;
                        byte byte10;
                        for(zvec_ = getBits(zt_, BZ2Entry); zvec_ > tLimit[zt_]; zvec_ = zvec_ << 1 | byte10)
                        {
                            zt_++;
                            byte10 = getBit(BZ2Entry);
                        }

                        nextSym = tPerm[zvec_ - tBase[zt_]];
                    } while(nextSym == 0 || nextSym == 1);
                    j6++;
                    byte byte5 = BZ2Entry.seqToUnseq[BZ2Entry.yy[BZ2Entry.tmp[0]] & 0xff];
                    BZ2Entry.unzftab[byte5 & 0xff] += j6;
                    for(; j6 > 0; j6--)
                    {
                        BZ2Entry.anIntArray587[last] = byte5 & 0xff;
                        last++;
                    }

                } else
                {
                    int j11 = nextSym - 1;
                    byte byte6;
                    if(j11 < 16)
                    {
                        int j10 = BZ2Entry.tmp[0];
                        byte6 = BZ2Entry.yy[j10 + j11];
                        for(; j11 > 3; j11 -= 4)
                        {
                            int k11 = j10 + j11;
                            BZ2Entry.yy[k11] = BZ2Entry.yy[k11 - 1];
                            BZ2Entry.yy[k11 - 1] = BZ2Entry.yy[k11 - 2];
                            BZ2Entry.yy[k11 - 2] = BZ2Entry.yy[k11 - 3];
                            BZ2Entry.yy[k11 - 3] = BZ2Entry.yy[k11 - 4];
                        }

                        for(; j11 > 0; j11--)
                            BZ2Entry.yy[j10 + j11] = BZ2Entry.yy[(j10 + j11) - 1];

                        BZ2Entry.yy[j10] = byte6;
                    } else
                    {
                        int l10 = j11 / 16;
                        int i11 = j11 % 16;
                        int k10 = BZ2Entry.tmp[l10] + i11;
                        byte6 = BZ2Entry.yy[k10];
                        for(; k10 > BZ2Entry.tmp[l10]; k10--)
                            BZ2Entry.yy[k10] = BZ2Entry.yy[k10 - 1];

                        BZ2Entry.tmp[l10]++;
                        for(; l10 > 0; l10--)
                        {
                            BZ2Entry.tmp[l10]--;
                            BZ2Entry.yy[BZ2Entry.tmp[l10]] = BZ2Entry.yy[(BZ2Entry.tmp[l10 - 1] + 16) - 1];
                        }

                        BZ2Entry.tmp[0]--;
                        BZ2Entry.yy[BZ2Entry.tmp[0]] = byte6;
                        if(BZ2Entry.tmp[0] == 0)
                        {
                            int i10 = 4095;
                            for(int k9 = 15; k9 >= 0; k9--)
                            {
                                for(int l9 = 15; l9 >= 0; l9--)
                                {
                                    BZ2Entry.yy[i10] = BZ2Entry.yy[BZ2Entry.tmp[k9] + l9];
                                    i10--;
                                }

                                BZ2Entry.tmp[k9] = i10 + 1;
                            }

                        }
                    }
                    BZ2Entry.unzftab[BZ2Entry.seqToUnseq[byte6 & 0xff] & 0xff]++;
                    BZ2Entry.anIntArray587[last] = BZ2Entry.seqToUnseq[byte6 & 0xff] & 0xff;
                    last++;
                    if(groupPos == 0)
                    {
                        groupNo++;
                        groupPos = 50;
                        byte byte14 = BZ2Entry.selector[groupNo];
                        tMinLen = BZ2Entry.minLens[byte14];
                        tLimit = BZ2Entry.limit[byte14];
                        tPerm = BZ2Entry.perm[byte14];
                        tBase = BZ2Entry.base[byte14];
                    }
                    groupPos--;
                    int k7 = tMinLen;
                    int j8;
                    byte byte11;
                    for(j8 = getBits(k7, BZ2Entry); j8 > tLimit[k7]; j8 = j8 << 1 | byte11)
                    {
                        k7++;
                        byte11 = getBit(BZ2Entry);
                    }

                    nextSym = tPerm[j8 - tBase[k7]];
                }

            BZ2Entry.anInt574 = 0;
            BZ2Entry.aByte573 = 0;
            BZ2Entry.cftab[0] = 0;
            for(int j2 = 1; j2 <= 256; j2++)
                BZ2Entry.cftab[j2] = BZ2Entry.unzftab[j2 - 1];

            for(int k2 = 1; k2 <= 256; k2++)
                BZ2Entry.cftab[k2] += BZ2Entry.cftab[k2 - 1];

            for(int l2 = 0; l2 < last; l2++)
            {
                byte byte7 = (byte)(BZ2Entry.anIntArray587[l2] & 0xff);
                BZ2Entry.anIntArray587[BZ2Entry.cftab[byte7 & 0xff]] |= l2 << 8;
                BZ2Entry.cftab[byte7 & 0xff]++;
            }

            BZ2Entry.anInt581 = BZ2Entry.anIntArray587[BZ2Entry.origPointer] >> 8;
            BZ2Entry.anInt584 = 0;
            BZ2Entry.anInt581 = BZ2Entry.anIntArray587[BZ2Entry.anInt581];
            BZ2Entry.anInt582 = (byte)(BZ2Entry.anInt581 & 0xff);
            BZ2Entry.anInt581 >>= 8;
            BZ2Entry.anInt584++;
            BZ2Entry.anInt601 = last;
            getNextFileHeader(BZ2Entry);
            reading = BZ2Entry.anInt584 == BZ2Entry.anInt601 + 1 && BZ2Entry.anInt574 == 0;
        }
    }

    private static byte getByte(BZ2Entry BZ2Entry)
    {
        return (byte) getBits(8, BZ2Entry);
    }

    private static byte getBit(BZ2Entry BZ2Entry)
    {
        return (byte) getBits(1, BZ2Entry);
    }

    private static int getBits(int i, BZ2Entry BZ2Entry)
    {
        int j;
        do
        {
            if(BZ2Entry.bitPos >= i)
            {
                int k = BZ2Entry.current2Bytes >> BZ2Entry.bitPos - i & (1 << i) - 1;
                BZ2Entry.bitPos -= i;
                j = k;
                break;
            }
            BZ2Entry.current2Bytes = BZ2Entry.current2Bytes << 8 | BZ2Entry.inputBuffer[BZ2Entry.fileStartOffsets] & 0xff;
            BZ2Entry.bitPos += 8;
            BZ2Entry.fileStartOffsets++;
            BZ2Entry.compressedSize--;
            BZ2Entry.junk1++;
            if(BZ2Entry.junk1 == 0)
                BZ2Entry.junk2++;
        } while(true);
        return j;
    }

    private static void makeMaps(BZ2Entry BZ2Entry)
    {
        BZ2Entry.inUseOff = 0;
        for(int i = 0; i < 256; i++)
            if(BZ2Entry.inUse[i])
            {
                BZ2Entry.seqToUnseq[BZ2Entry.inUseOff] = (byte)i;
                BZ2Entry.inUseOff++;
            }

    }

    private static void createDecodeTables(int limit[], int base[], int perm[], byte len[], int i, int maxLen, int alphaSize)
    {
        int l = 0;
        for(int i1 = i; i1 <= maxLen; i1++)
        {
            for(int l2 = 0; l2 < alphaSize; l2++)
                if(len[l2] == i1)
                {
                    perm[l] = l2;
                    l++;
                }

        }

        for(int j1 = 0; j1 < 23; j1++)
            base[j1] = 0;

        for(int k1 = 0; k1 < alphaSize; k1++)
            base[len[k1] + 1]++;

        for(int l1 = 1; l1 < 23; l1++)
            base[l1] += base[l1 - 1];

        for(int i2 = 0; i2 < 23; i2++)
            limit[i2] = 0;

        int vec = 0;
        for(int j2 = i; j2 <= maxLen; j2++)
        {
            vec += base[j2 + 1] - base[j2];
            limit[j2] = vec - 1;
            vec <<= 1;
        }

        for(int k2 = i + 1; k2 <= maxLen; k2++)
            base[k2] = (limit[k2 - 1] + 1 << 1) - base[k2];

    }

    private static final BZ2Entry Bzip2Decompressor = new BZ2Entry();

}
