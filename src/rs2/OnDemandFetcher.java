package rs2;


import java.io.*;
import java.net.Socket;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;

public class OnDemandFetcher extends OnDemandFetcherParent
        implements Runnable
{

    private boolean crcMatches(int i, int j, byte abyte0[])
    {
        if(abyte0 == null || abyte0.length < 2)
            return false;
        int k = abyte0.length - 2;
        int footer = ((abyte0[k] & 0xff) << 8) + (abyte0[k + 1] & 0xff);
        crc32.reset();
        crc32.update(abyte0, 0, k);
        int i1 = (int) crc32.getValue();
        return footer == i && i1 == j;
    }

    private void readData()
    {
        try
        {
            int j = inputStream.available();
            if(expectedSize == 0 && j >= 6)
            {
                waiting = true;
                for(int k = 0; k < 6; k += inputStream.read(ioBuffer, k, 6 - k));
                int dataType = ioBuffer[0] & 0xff;
                int dataIndex = ((ioBuffer[1] & 0xff) << 8) + (ioBuffer[2] & 0xff);
                int fileLength = ((ioBuffer[3] & 0xff) << 8) + (ioBuffer[4] & 0xff);
                int chunkID = ioBuffer[5] & 0xff;
                current = null;
                for(OnDemandData onDemandData = (OnDemandData) requested.getFront(); onDemandData != null; onDemandData = (OnDemandData) requested.getNext())
                {
                    if(onDemandData.dataType == dataType && onDemandData.ID == dataIndex)
                        current = onDemandData;
                    if(current != null)
                        onDemandData.loopCycle = 0;
                }

                if(current != null)
                {
                    loopCycle = 0;
                    if(fileLength == 0)
                    {
                        Signlink.reporterror("Rej: " + dataType + "," + dataIndex);
                        current.buffer = null;
                        if(current.incomplete)
                            synchronized(zippedNodes)
                            {
                                zippedNodes.insertBack(current);
                            }
                        else
                            current.unlink();
                        current = null;
                    } else
                    {
                        if(current.buffer == null && chunkID == 0)
                            current.buffer = new byte[fileLength];
                        if(current.buffer == null && chunkID != 0)
                            throw new IOException("missing start of file");
                    }
                }
                completedSize = chunkID * 500;
                expectedSize = 500;
                if(expectedSize > fileLength - chunkID * 500)
                    expectedSize = fileLength - chunkID * 500;
            }
            if(expectedSize > 0 && j >= expectedSize)
            {
                waiting = true;
                byte abyte0[] = ioBuffer;
                int i1 = 0;
                if(current != null)
                {
                    abyte0 = current.buffer;
                    i1 = completedSize;
                }
                for(int k1 = 0; k1 < expectedSize; k1 += inputStream.read(abyte0, k1 + i1, expectedSize - k1));
                if(expectedSize + completedSize >= abyte0.length && current != null)
                {
                    if(clientInstance.jagexFileStores[0] != null)
                        clientInstance.jagexFileStores[current.dataType + 1].put(abyte0.length, abyte0, current.ID);
                    if(!current.incomplete && current.dataType == 3)
                    {
                        current.incomplete = true;
                        current.dataType = 93;
                    }
                    if(current.incomplete)
                        synchronized(zippedNodes)
                        {
                            zippedNodes.insertBack(current);
                        }
                    else
                        current.unlink();
                }
                expectedSize = 0;
            }
        }
        catch(IOException ioexception)
        {
            try
            {
                socket.close();
            }
            catch(Exception _ex) { }
            socket = null;
            inputStream = null;
            outputStream = null;
            expectedSize = 0;
        }
    }

    public void start(JagexArchive jagexArchive, Client client1)
    {
        String as[] = {
            "model_version", "anim_version", "midi_version", "map_version"
        };
        for(int i = 0; i < 4; i++)
        {
            byte abyte0[] = jagexArchive.getDataForName(as[i]);
            int j = abyte0.length / 2;
            Packet stream = new Packet(abyte0);
            versions[i] = new int[j];
            fileStatus[i] = new byte[j];
            for(int l = 0; l < j; l++)
                versions[i][l] = stream.g2();

        }

        String as1[] = {
            "model_crc", "anim_crc", "midi_crc", "map_crc"
        };
        for(int k = 0; k < 4; k++)
        {
            byte abyte1[] = jagexArchive.getDataForName(as1[k]);
            int i1 = abyte1.length / 4;
            Packet stream_1 = new Packet(abyte1);
            crcs[k] = new int[i1];
            for(int l1 = 0; l1 < i1; l1++)
                crcs[k][l1] = stream_1.g4();

        }

        byte abyte2[] = jagexArchive.getDataForName("model_index");
        int j1 = versions[0].length;
        modelIndices = new byte[j1];
        for(int k1 = 0; k1 < j1; k1++)
            if(k1 < abyte2.length)
                modelIndices[k1] = abyte2[k1];
            else
                modelIndices[k1] = 0;

        abyte2 = jagexArchive.getDataForName("map_index");
        Packet stream2 = new Packet(abyte2);
        j1 = abyte2.length / 7;
        mapIndices1 = new int[j1];
        mapIndices2 = new int[j1];
        mapIndices3 = new int[j1];
        mapIndices4 = new int[j1];
        for(int i2 = 0; i2 < j1; i2++)
        {
            mapIndices1[i2] = stream2.g2();
            mapIndices2[i2] = stream2.g2();
            mapIndices3[i2] = stream2.g2();
            mapIndices4[i2] = stream2.g1();
        }

        abyte2 = jagexArchive.getDataForName("anim_index");
        stream2 = new Packet(abyte2);
        j1 = abyte2.length / 2;
        anIntArray1360 = new int[j1];
        for(int j2 = 0; j2 < j1; j2++)
            anIntArray1360[j2] = stream2.g2();

        abyte2 = jagexArchive.getDataForName("midi_index");
        stream2 = new Packet(abyte2);
        j1 = abyte2.length;
        anIntArray1348 = new int[j1];
        for(int k2 = 0; k2 < j1; k2++)
            anIntArray1348[k2] = stream2.g1();

        clientInstance = client1;
        running = true;
        clientInstance.startRunnable(this, 2);
    }

    public int getNodeCount()
    {
        synchronized(queue)
        {
            return queue.getSize();
        }
    }

    public void disable()
    {
        running = false;
    }

    public void method554(boolean flag)
    {
        int j = mapIndices1.length;
        for(int k = 0; k < j; k++)
            if(flag || mapIndices4[k] != 0)
            {
                method563((byte)2, 3, mapIndices3[k]);
                method563((byte)2, 3, mapIndices2[k]);
            }

    }

    public int getVersionCount(int j)
    {
        return versions[j].length;
    }

    private void closeRequest(OnDemandData onDemandData)
    {System.out.println("close request");
        try
        {
            if(socket == null)
            {
                long l = System.currentTimeMillis();
                if(l - openSocketTime < 4000L)
                    return;
                openSocketTime = l;
                socket = clientInstance.openSocket(43594 + Client.portOff);
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                outputStream.write(15);
                for(int j = 0; j < 8; j++)
                    inputStream.read();

                loopCycle = 0;
            }
            ioBuffer[0] = (byte)onDemandData.dataType;
            ioBuffer[1] = (byte)(onDemandData.ID >> 8);
            ioBuffer[2] = (byte)onDemandData.ID;
            if(onDemandData.incomplete)
                ioBuffer[3] = 2;
            else
            if(!clientInstance.loggedIn)
                ioBuffer[3] = 1;
            else
                ioBuffer[3] = 0;
            outputStream.write(ioBuffer, 0, 4);
            writeLoopCycle = 0;
            anInt1349 = -10000;
            return;
        }
        catch(IOException ioexception) { }
        try
        {
            socket.close();
        }
        catch(Exception _ex) { }
        socket = null;
        inputStream = null;
        outputStream = null;
        expectedSize = 0;
        anInt1349++;
    }

    public int getAnimCount()
    {
        return anIntArray1360.length;
    }

    public void method558(int i, int j)
    {
        if(i < 0 || i > versions.length || j < 0 || j > versions[i].length)
            return;
        if(versions[i][j] == 0)
            return;
        synchronized(queue)
        {
            for(OnDemandData onDemandData = (OnDemandData) queue.getFront(); onDemandData != null; onDemandData = (OnDemandData) queue.getNext())
                if(onDemandData.dataType == i && onDemandData.ID == j)
                    return;

            OnDemandData onDemandData_1 = new OnDemandData();
            onDemandData_1.dataType = i;
            onDemandData_1.ID = j;
            onDemandData_1.incomplete = true;
            synchronized(aClass19_1370)
            {
                aClass19_1370.insertBack(onDemandData_1);
            }
            queue.insertBack(onDemandData_1);
        }
    }

    public int getModelIndex(int i)
    {
        return modelIndices[i] & 0xff;
    }

    public void run()
    {
        try
        {
            while(running)
            {
                onDemandCycle++;
                int i = 20;
                if(anInt1332 == 0 && clientInstance.jagexFileStores[0] != null)
                    i = 50;
                try
                {
                    Thread.sleep(i);
                }
                catch(Exception _ex) { }
                waiting = true;
                for(int j = 0; j < 100; j++)
                {
                    if(!waiting)
                        break;
                    waiting = false;
                    checkReceived();
                    handleFailed();
                    if(uncompletedCount == 0 && j >= 5)
                        break;
                    method568();
                    if(inputStream != null)
                        readData();
                }

                boolean flag = false;
                for(OnDemandData onDemandData = (OnDemandData) requested.getFront(); onDemandData != null; onDemandData = (OnDemandData) requested.getNext())
                    if(onDemandData.incomplete)
                    {
                        flag = true;
                        onDemandData.loopCycle++;
                        if(onDemandData.loopCycle > 50)//50)
                        {
                            onDemandData.loopCycle = 0;
                            closeRequest(onDemandData);
                        }
                    }

                if(!flag)
                {
                    for(OnDemandData onDemandData_1 = (OnDemandData) requested.getFront(); onDemandData_1 != null; onDemandData_1 = (OnDemandData) requested.getNext())
                    {
                        flag = true;
                        onDemandData_1.loopCycle++;
                        if(onDemandData_1.loopCycle > 50)
                        {
                            onDemandData_1.loopCycle = 0;
                            closeRequest(onDemandData_1);
                        }
                    }

                }
                if(flag)
                {
                    loopCycle++;
                    if(loopCycle > 750)
                    {
                        try
                        {
                            socket.close();
                        }
                        catch(Exception _ex) { }
                        socket = null;
                        inputStream = null;
                        outputStream = null;
                        expectedSize = 0;
                    }
                } else
                {
                    loopCycle = 0;
                    statusString = "";
                }
                if(clientInstance.loggedIn && socket != null && outputStream != null && (anInt1332 > 0 || clientInstance.jagexFileStores[0] == null))
                {
                    writeLoopCycle++;
                    if(writeLoopCycle > 500)
                    {
                        writeLoopCycle = 0;
                        ioBuffer[0] = 0;
                        ioBuffer[1] = 0;
                        ioBuffer[2] = 0;
                        ioBuffer[3] = 10;
                        try
                        {
                            outputStream.write(ioBuffer, 0, 4);
                        }
                        catch(IOException _ex)
                        {
                            loopCycle = 5000;
                        }
                    }
                }
            }
        }
        catch(Exception exception)
        {
            Signlink.reporterror("od_ex " + exception.getMessage());
        }
    }

    public void method560(int i, int j)
    {
        if(clientInstance.jagexFileStores[0] == null)
            return;
        if(versions[j][i] == 0)
            return;
        if(fileStatus[j][i] == 0)
            return;
        if(anInt1332 == 0)
            return;
        OnDemandData onDemandData = new OnDemandData();
        onDemandData.dataType = j;
        onDemandData.ID = i;
        onDemandData.incomplete = false;
        synchronized(aClass19_1344)
        {
            aClass19_1344.insertBack(onDemandData);
        }
    }

    public OnDemandData getNextNode()
    {
        OnDemandData onDemandData;
        synchronized(zippedNodes)
        {
            onDemandData = (OnDemandData) zippedNodes.popFront();
        }
        if(onDemandData == null)
            return null;
        synchronized(queue)
        {
            onDemandData.unlinkSub();
        }
        if(onDemandData.buffer == null)
            return onDemandData;
        int i = 0;
        try
        {
            GZIPInputStream gzipinputstream = new GZIPInputStream(new ByteArrayInputStream(onDemandData.buffer));
            do
            {
                if(i == gzipInputBuffer.length)
                    throw new RuntimeException("buffer overflow!");
                int k = gzipinputstream.read(gzipInputBuffer, i, gzipInputBuffer.length - i);
                if(k == -1)
                    break;
                i += k;
            } while(true);
        }
        catch(IOException _ex)
        {
            throw new RuntimeException("error unzipping");
        }
        onDemandData.buffer = new byte[i];
        System.arraycopy(gzipInputBuffer, 0, onDemandData.buffer, 0, i);

        return onDemandData;
    }

    public int method562(int i, int k, int l)
    {
        int i1 = (l << 8) + k;
        for(int j1 = 0; j1 < mapIndices1.length; j1++)
            if(mapIndices1[j1] == i1)
                if(i == 0)
                    return mapIndices2[j1];
                else
                    return mapIndices3[j1];
        return -1;
    }

    public void method548(int i)
    {
        method558(0, i);
    }

    public void method563(byte byte0, int i, int j)
    {
        if(clientInstance.jagexFileStores[0] == null)
            return;
        if(versions[i][j] == 0)
            return;
        byte abyte0[] = clientInstance.jagexFileStores[i + 1].decompress(j);
        if(crcMatches(versions[i][j], crcs[i][j], abyte0))
            return;
        fileStatus[i][j] = byte0;
        if(byte0 > anInt1332)
            anInt1332 = byte0;
        totalFiles++;
    }

    public boolean method564(int i)
    {
        for(int k = 0; k < mapIndices1.length; k++)
            if(mapIndices3[k] == i)
                return true;
        return false;
    }

    private void handleFailed()
    {
        uncompletedCount = 0;
        completedCount = 0;
        for(OnDemandData onDemandData = (OnDemandData) requested.getFront(); onDemandData != null; onDemandData = (OnDemandData) requested.getNext())
            if(onDemandData.incomplete)
                uncompletedCount++;
            else
                completedCount++;

        while(uncompletedCount < 10)
        {
            OnDemandData onDemandData_1 = (OnDemandData)aClass19_1368.popFront();
            if(onDemandData_1 == null)
                break;
            if(fileStatus[onDemandData_1.dataType][onDemandData_1.ID] != 0)
                filesLoaded++;
            fileStatus[onDemandData_1.dataType][onDemandData_1.ID] = 0;
            requested.insertBack(onDemandData_1);
            uncompletedCount++;
            closeRequest(onDemandData_1);
            waiting = true;
        }
    }

    public void method566()
    {
        synchronized(aClass19_1344)
        {
            aClass19_1344.clear();
        }
    }

    private void checkReceived()
    {
        OnDemandData onDemandData;
        synchronized(aClass19_1370)
        {
            onDemandData = (OnDemandData)aClass19_1370.popFront();
        }
        while(onDemandData != null)
        {
            waiting = true;
            byte abyte0[] = null;
            if(clientInstance.jagexFileStores[0] != null)
                abyte0 = clientInstance.jagexFileStores[onDemandData.dataType + 1].decompress(onDemandData.ID);
            if(!crcMatches(versions[onDemandData.dataType][onDemandData.ID], crcs[onDemandData.dataType][onDemandData.ID], abyte0))
                abyte0 = null;
            synchronized(aClass19_1370)
            {
                if(abyte0 == null)
                {
                    aClass19_1368.insertBack(onDemandData);
                } else
                {
                    onDemandData.buffer = abyte0;
                    synchronized(zippedNodes)
                    {
                        zippedNodes.insertBack(onDemandData);
                    }
                }
                onDemandData = (OnDemandData)aClass19_1370.popFront();
            }
        }
    }

    private void method568()//used in client startup
    {
        while(uncompletedCount == 0 && completedCount < 10)
        {
            if(anInt1332 == 0)
                break;
            OnDemandData onDemandData;
            synchronized(aClass19_1344)
            {
                onDemandData = (OnDemandData)aClass19_1344.popFront();
            }
            while(onDemandData != null)
            {
                if(fileStatus[onDemandData.dataType][onDemandData.ID] != 0)
                {
                    fileStatus[onDemandData.dataType][onDemandData.ID] = 0;
                    requested.insertBack(onDemandData);
                    closeRequest(onDemandData);
                    waiting = true;
                    if(filesLoaded < totalFiles)
                        filesLoaded++;
                    statusString = "Loading extra files - " + (filesLoaded * 100) / totalFiles + "%";
                    completedCount++;
                    if(completedCount == 10)
                        return;
                }
                synchronized(aClass19_1344)
                {
                    onDemandData = (OnDemandData)aClass19_1344.popFront();
                }
            }
            for(int j = 0; j < 4; j++)
            {
                byte abyte0[] = fileStatus[j];
                int k = abyte0.length;
                for(int l = 0; l < k; l++)
                    if(abyte0[l] == anInt1332)
                    {
                        abyte0[l] = 0;
                        OnDemandData onDemandData_1 = new OnDemandData();
                        onDemandData_1.dataType = j;
                        onDemandData_1.ID = l;
                        onDemandData_1.incomplete = false;
                        requested.insertBack(onDemandData_1);
                        closeRequest(onDemandData_1);
                        waiting = true;
                        if(filesLoaded < totalFiles)
                            filesLoaded++;
                        statusString = "Loading extra files - " + (filesLoaded * 100) / totalFiles + "%";
                        completedCount++;
                        if(completedCount == 10)
                            return;
                    }

            }

            anInt1332--;
        }
    }

    public boolean method569(int i)
    {
        return anIntArray1348[i] == 1;
    }

    public OnDemandFetcher()
    {
        requested = new Deque();
        statusString = "";
        crc32 = new CRC32();
        ioBuffer = new byte[500];
        fileStatus = new byte[4][];
        aClass19_1344 = new Deque();
        running = true;
        waiting = false;
        zippedNodes = new Deque();
        gzipInputBuffer = new byte[65000];
        queue = new Queue();
        versions = new int[4][];
        crcs = new int[4][];
        aClass19_1368 = new Deque();
        aClass19_1370 = new Deque();
    }

    private int totalFiles;
    private final Deque requested;
    private int anInt1332;
    public String statusString;
    private int writeLoopCycle;
    private long openSocketTime;
    private int[] mapIndices3;
    private final CRC32 crc32;
    private final byte[] ioBuffer;
    public int onDemandCycle;
    private final byte[][] fileStatus;
    private Client clientInstance;
    private final Deque aClass19_1344;
    private int completedSize;
    private int expectedSize;
    private int[] anIntArray1348;
    public int anInt1349;
    private int[] mapIndices2;
    private int filesLoaded;
    private boolean running;
    private OutputStream outputStream;
    private int[] mapIndices4;
    private boolean waiting;
    private final Deque zippedNodes;
    private final byte[] gzipInputBuffer;
    private int[] anIntArray1360;
    private final Queue queue;
    private InputStream inputStream;
    private Socket socket;
    private final int[][] versions;
    private final int[][] crcs;
    private int uncompletedCount;
    private int completedCount;
    private final Deque aClass19_1368;
    private OnDemandData current;
    private final Deque aClass19_1370;
    private int[] mapIndices1;
    private byte[] modelIndices;
    private int loopCycle;
}
