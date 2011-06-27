package editor;

import editor.gui.EditorMainWindow;
import editor.renderer.GameViewPanel;
import org.peterbjornx.pgl2.util.ServerMemoryManager;
import rs2.*;
import rs2.Graphics2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.net.InetAddress;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/24/11
 * Time: 5:26 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class EditorMain extends GameShell implements ComponentListener {
    private EditorMainWindow editorMainWindow;
    public JagexFileStore[] jagexFileStores = new JagexFileStore[5];
    private JagexArchive titleJagexArchive;
    private byte[][][] tileSettingBits;
    private int[][][] heightMap;
    private SceneGraph sceneGraph;
    private MapRegion mapRegion;
    private TileSetting[] tileSettings;
    private RSFont smallFont;
    private RSFont plainFont;
    private RSFont boldFont;
    private RgbImage minimapImage;
    private OnDemandFetcher onDemandFetcher;
    private RgbImage compass;
    private IndexedImage[] mapScenes;
    private RgbImage[] mapFunctions;
    private RgbImage mapMarker;
    private int[] compassShape1;
    private int[] compassShape2;
    private int[] minimapShape1;
    private int[] minimapShape2;
    private int fieldJ;
    private GraphicsBuffer gameScreenCanvas;
    private int mapWidth = 2;//- Settings
    private int mapHeight = 2;//- Settings
    private int heightLevel = 0;
    private int xCameraPos=mapWidth*32*128;;
    private int yCameraPos=mapHeight*32*128;
    private int xCameraCurve = (int) (Math.random() * 20D) - 10 & 0x7ff;;
    private int zCameraPos = -540;
    private int yCameraCurve = 128;
    private GraphicsBuffer minimapIP;
    private int numOfMapMarkers = 0;
    private RgbImage[] markGraphic;
    private int[] markPosX;
    private int[] markPosY;
    private boolean mapLoaded = false;
    private int resizeWidth = -1;
    private int resizeHeight = -1;
    private int currentMapX;
    private int currentMapZ;
    private Graphics minimapGraphics;
    private int lastMouseX = -1;
    private int lastMouseY = -1;
    private int[] isOnScreen;

    private JagexArchive getJagexArchive(int i) {
        byte abyte0[] = null;
        try {
            if (jagexFileStores[0] != null)
                abyte0 = jagexFileStores[0].decompress(i);
        } catch (Exception _ex) {
            JOptionPane.showMessageDialog(null, "Failed to load the cache", "RuneScape Map Editor", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        if (abyte0 != null) {
            return new JagexArchive(abyte0);
        }
        JOptionPane.showMessageDialog(null, "Failed to load the cache", "RuneScape Map Editor", JOptionPane.ERROR_MESSAGE);
        System.exit(-1);
        return null;
    }

    private void on_demand_process() {
        do {
            OnDemandData onDemandData;
            do {
                onDemandData = onDemandFetcher.getNextNode();
                if (onDemandData == null)
                    return;
                if (onDemandData.dataType == 0)
                    Model.method460(onDemandData.buffer, onDemandData.ID);
                if (onDemandData.dataType == 1 && onDemandData.buffer != null)
                    rs2.Animation.load(onDemandData.buffer);
            } while (onDemandData.dataType != 93 || !onDemandFetcher.method564(onDemandData.ID));
            MapRegion.prefetchObjects(new Packet(onDemandData.buffer), onDemandFetcher);
        } while (true);
    }

    @Override
    protected void startUp() {
        drawLoadingText(20, "Starting up");
        if (Signlink.sunjava)
            super.minDelay = 5;
        if (Signlink.cache_dat != null) {
            for (int i = 0; i < 5; i++)
                jagexFileStores[i] = new JagexFileStore(Signlink.cache_dat, Signlink.cache_idx[i], i + 1);
        }
        try {
            titleJagexArchive = getJagexArchive(1);
            smallFont = new RSFont(false, "p11_full", titleJagexArchive);
            plainFont = new RSFont(false, "p12_full", titleJagexArchive);
            boldFont = new RSFont(false, "b12_full", titleJagexArchive);
            JagexArchive configArchive = getJagexArchive(2);
            JagexArchive mediaArchive = getJagexArchive(4);
            JagexArchive textureArchive = getJagexArchive(6);
            tileSettingBits = new byte[4][64 * mapWidth][64 * mapHeight];
            heightMap = new int[4][64 * mapWidth + 1][64 * mapHeight + 1];
            sceneGraph = new SceneGraph(4, 64 * mapWidth, 64 * mapHeight, heightMap);
            for (int j = 0; j < 4; j++)
                tileSettings[j] = new TileSetting(64 * mapWidth, 64 * mapHeight);

            minimapImage = new RgbImage(512, 512);
            JagexArchive crcArchive = getJagexArchive(5);
            drawLoadingText(60, "Loading update data");
            onDemandFetcher = new OnDemandFetcher();
            onDemandFetcher.start(crcArchive, this);
            Animation.initialize(onDemandFetcher.getAnimCount());
            Model.initialize(onDemandFetcher.getVersionCount(0), onDemandFetcher);
            drawLoadingText(65, "Requesting animations");
            int k = onDemandFetcher.getVersionCount(1);
            for (int i1 = 0; i1 < k; i1++)
                onDemandFetcher.method558(1, i1);
            while (onDemandFetcher.getNodeCount() > 0) {
                int j1 = k - onDemandFetcher.getNodeCount();
                if (j1 > 0)
                    drawLoadingText(65, "Loading animations - " + (j1 * 100) / k + "%");
                on_demand_process();
                try {
                    Thread.sleep(100L);
                } catch (Exception ignored) {
                }
                if (onDemandFetcher.anInt1349 > 3) {
                    JOptionPane.showMessageDialog(null, "Failed to load animations", "RuneScape Map Editor", JOptionPane.ERROR_MESSAGE);
                    System.exit(-1);
                    return;
                }
            }
            drawLoadingText(70, "Requesting models");
            k = onDemandFetcher.getVersionCount(0);
            for (int k1 = 0; k1 < k; k1++) {
                int l1 = onDemandFetcher.getModelIndex(k1);
                if ((l1 & 1) != 0)
                    onDemandFetcher.method558(0, k1);
            }

            k = onDemandFetcher.getNodeCount();
            while (onDemandFetcher.getNodeCount() > 0) {
                int i2 = k - onDemandFetcher.getNodeCount();
                if (i2 > 0)
                    drawLoadingText(70, "Loading models - " + (i2 * 100) / k + "%");
                on_demand_process();
                try {
                    Thread.sleep(100L);
                } catch (Exception ignored) {
                }
            }
            k = onDemandFetcher.getVersionCount(0);
            for (int k2 = 0; k2 < k; k2++) {
                int l2 = onDemandFetcher.getModelIndex(k2);
                byte byte0 = 0;
                if ((l2 & 8) != 0)
                    byte0 = 10;
                else if ((l2 & 0x20) != 0)
                    byte0 = 9;
                else if ((l2 & 0x10) != 0)
                    byte0 = 8;
                else if ((l2 & 0x40) != 0)
                    byte0 = 7;
                else if ((l2 & 0x80) != 0)
                    byte0 = 6;
                else if ((l2 & 2) != 0)
                    byte0 = 5;
                else if ((l2 & 4) != 0)
                    byte0 = 4;
                if ((l2 & 1) != 0)
                    byte0 = 3;
                if (byte0 != 0)
                    onDemandFetcher.method563(byte0, 0, k2);
            }
            onDemandFetcher.method554(true);
            drawLoadingText(80, "Unpacking media");
            compass = new RgbImage(mediaArchive, "compass", 0);
            try {
                for (int k3 = 0; k3 < 100; k3++)
                    mapScenes[k3] = new IndexedImage(mediaArchive, "mapscene", k3);

            } catch (Exception ignored) {
            }
            try {
                for (int l3 = 0; l3 < 100; l3++)
                    mapFunctions[l3] = new RgbImage(mediaArchive, "mapfunction", l3);

            } catch (Exception ignored) {
            }
            mapMarker = new RgbImage(mediaArchive, "mapmarker", 1);
            drawLoadingText(83, "Unpacking textures");
            Rasterizer.unpackTextures(textureArchive);
            Rasterizer.calculatePalette(0.80000000000000004D);
            Rasterizer.resetTextures(20);
            drawLoadingText(86, "Unpacking config");
            Sequence.unpackConfig(configArchive);
            ObjectDef.unpackConfig(configArchive);
            Floor.unpackConfig(configArchive);
            ItemDef.unpackConfig(configArchive);
            NpcDef.unpackConfig(configArchive);
            IdentityKit.unpackConfig(configArchive);
            SpotAnim.unpackConfig(configArchive);
            SettingUsagePointers.unpackConfig(configArchive);
            VarBit.unpackConfig(configArchive);
            ItemDef.isMembers = true;
            drawLoadingText(100, "Preparing game engine");

			for (int x = 0; x < compassShape2.length; x++) {
				compassShape2[x] = 170;
				compassShape1[x] = -23;
			}
			for (int x = 0; x < minimapShape2.length; x++) {
				minimapShape2[x] = 170;
				minimapShape1[x] = -23;
			}

            int vpW = editorMainWindow.getGameViewPanel().getWidth();
            int vpH = editorMainWindow.getGameViewPanel().getHeight();
            minimapIP = new GraphicsBuffer(vpW, vpH, getGameComponent());
            gameScreenCanvas = new GraphicsBuffer(vpW, vpH, getGameComponent());
            Rasterizer.setBounds(vpW, vpH);
            isOnScreen = new int[64];
            for (int i8 = 0; i8 < 64; i8++) {
                int k8 = i8 * 32 + 15;
                int l8 = 600 + k8 * 3;
                int i9 = Rasterizer.SINE[k8];
                isOnScreen[i8] = l8 * i9 >> 16;
            }
            SceneGraph.setupViewport(500, 800, vpW, vpH, isOnScreen);
            editorMainWindow.getGameViewPanel().addComponentListener(this);
            editorMainWindow.getMapViewPanel().setGameShell(this);
            editorMainWindow.editorStarted();
            loadMap(3136,3136);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Failed to start up", "RuneScape Map Editor", JOptionPane.ERROR_MESSAGE);
            exception.printStackTrace();
            System.exit(-1);
        }
    }

    public void processResize() {
        startGraphicsBlock();
        gameScreenCanvas = new GraphicsBuffer(resizeWidth, resizeHeight, getGameComponent());
        Graphics2D.fillRect(0, 0, resizeWidth, resizeHeight, 0);
        Rasterizer.setBounds(resizeWidth, resizeHeight);
        SceneGraph.setupViewport(500, 800, resizeWidth, resizeHeight, isOnScreen);
        resizeWidth = -1;
        resizeHeight = -1;
        endGraphicsBlock();
        repaint();
    }

    @Override
    protected void doLogic() {
        if (onDemandFetcher != null)
            on_demand_process();
        if (mapLoaded)
            processInput();
        if (resizeWidth != -1)
            processResize();
    }

    @Override
    protected void shutdown() {
    }

    @Override
    protected void repaintGame() {
        gameScreenCanvas.drawGraphics(0, graphics, 0);
    }

    @Override
    protected void drawGame() {
        try {
            if (mapLoaded) {
                drawScene();
                drawMinimap();
            }
            gameScreenCanvas.drawGraphics(0, graphics, 0);
        } catch (Exception e){

        }

    }

    private void startEditor() {
        try {
            GameViewPanel gameViewPanel;
            editorMainWindow = new EditorMainWindow();
            editorMainWindow.show();
            gameViewPanel = editorMainWindow.getGameViewPanel();
            Signlink.startpriv(InetAddress.getLocalHost());
            initialize(gameViewPanel.getWidth(), gameViewPanel.getHeight());
            gameViewPanel.setGameShell(this);
            SceneGraph.lowMem = false;
            Rasterizer.lowMem = false;
            MapRegion.lowMem = false;
            ObjectDef.lowMem = false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to start the application!", "RuneScape Map Editor", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    public void renderscene() {
        sceneGraph.render(xCameraPos, yCameraPos, xCameraCurve, zCameraPos, fieldJ, yCameraCurve);
    }

    private void drawMapScenes(int y, int k, int x, int i1, int z) {
        int interactableObjectUID = sceneGraph.getWallObjectUID(z, x, y);
            int mhTile = mapHeight*64;
            int mwTile = mapWidth*64;
        if (interactableObjectUID != 0) {
            int l1 = sceneGraph.getIDTAGForXYZ(z, x, y, interactableObjectUID);
            int k2 = l1 >> 6 & 3;
            int i3 = l1 & 0x1f;
            int k3 = k;
            if (interactableObjectUID > 0)
                k3 = i1;
            int ai[] = minimapImage.myPixels;
            int k4 = x * 4 + ((mhTile - 1) - y) * 512 * 4;
            int i5 = interactableObjectUID >> 14 & 0x7fff;
            ObjectDef class46_2 = ObjectDef.forID(i5);
            if (class46_2.mapSceneID != -1) {
                IndexedImage indexedImage_2 = mapScenes[class46_2.mapSceneID];
                if (indexedImage_2 != null) {
                    int i6 = (class46_2.sizeX * 4 - indexedImage_2.imgWidth) / 2;
                    int j6 = (class46_2.sizeY * 4 - indexedImage_2.imgHeight) / 2;
                    indexedImage_2.drawImage(x * 4 + i6, (mhTile - y - class46_2.sizeY) * 4 + j6);
                }
            } else {
                if (i3 == 0 || i3 == 2)
                    if (k2 == 0) {
                        ai[k4] = k3;
                        ai[k4 + 512] = k3;
                        ai[k4 + 1024] = k3;
                        ai[k4 + 1536] = k3;
                    } else if (k2 == 1) {
                        ai[k4] = k3;
                        ai[k4 + 1] = k3;
                        ai[k4 + 2] = k3;
                        ai[k4 + 3] = k3;
                    } else if (k2 == 2) {
                        ai[k4 + 3] = k3;
                        ai[k4 + 3 + 512] = k3;
                        ai[k4 + 3 + 1024] = k3;
                        ai[k4 + 3 + 1536] = k3;
                    } else if (k2 == 3) {
                        ai[k4 + 1536] = k3;
                        ai[k4 + 1536 + 1] = k3;
                        ai[k4 + 1536 + 2] = k3;
                        ai[k4 + 1536 + 3] = k3;
                    }
                if (i3 == 3)
                    if (k2 == 0)
                        ai[k4] = k3;
                    else if (k2 == 1)
                        ai[k4 + 3] = k3;
                    else if (k2 == 2)
                        ai[k4 + 3 + 1536] = k3;
                    else if (k2 == 3)
                        ai[k4 + 1536] = k3;
                if (i3 == 2)
                    if (k2 == 3) {
                        ai[k4] = k3;
                        ai[k4 + 512] = k3;
                        ai[k4 + 1024] = k3;
                        ai[k4 + 1536] = k3;
                    } else if (k2 == 0) {
                        ai[k4] = k3;
                        ai[k4 + 1] = k3;
                        ai[k4 + 2] = k3;
                        ai[k4 + 3] = k3;
                    } else if (k2 == 1) {
                        ai[k4 + 3] = k3;
                        ai[k4 + 3 + 512] = k3;
                        ai[k4 + 3 + 1024] = k3;
                        ai[k4 + 3 + 1536] = k3;
                    } else if (k2 == 2) {
                        ai[k4 + 1536] = k3;
                        ai[k4 + 1536 + 1] = k3;
                        ai[k4 + 1536 + 2] = k3;
                        ai[k4 + 1536 + 3] = k3;
                    }
            }
        }
        interactableObjectUID = sceneGraph.getInteractableObjectUID(z, x, y);
        if (interactableObjectUID != 0) {
            int i2 = sceneGraph.getIDTAGForXYZ(z, x, y, interactableObjectUID);
            int l2 = i2 >> 6 & 3;
            int j3 = i2 & 0x1f;
            int l3 = interactableObjectUID >> 14 & 0x7fff;
            ObjectDef class46_1 = ObjectDef.forID(l3);
            if (class46_1.mapSceneID != -1) {
                IndexedImage indexedImage_1 = mapScenes[class46_1.mapSceneID];
                if (indexedImage_1 != null) {
                    int j5 = (class46_1.sizeX * 4 - indexedImage_1.imgWidth) / 2;
                    int k5 = (class46_1.sizeY * 4 - indexedImage_1.imgHeight) / 2;
                    indexedImage_1.drawImage(x * 4 + j5,(mhTile - y - class46_1.sizeY) * 4 + k5);
                }
            } else if (j3 == 9) {
                int l4 = 0xeeeeee;
                if (interactableObjectUID > 0)
                    l4 = 0xee0000;
                int ai1[] = minimapImage.myPixels;
                int l5 = x * 4 + ((mhTile - 1) - y) * 512 * 4;
                if (l2 == 0 || l2 == 2) {
                    ai1[l5 + 1536] = l4;
                    ai1[l5 + 1024 + 1] = l4;
                    ai1[l5 + 512 + 2] = l4;
                    ai1[l5 + 3] = l4;
                } else {
                    ai1[l5] = l4;
                    ai1[l5 + 512 + 1] = l4;
                    ai1[l5 + 1024 + 2] = l4;
                    ai1[l5 + 1536 + 3] = l4;
                }
            }
        }
        interactableObjectUID = sceneGraph.getGroundDecorationUID(z, x, y);
        if (interactableObjectUID != 0) {
            int j2 = interactableObjectUID >> 14 & 0x7fff;
            ObjectDef class46 = ObjectDef.forID(j2);
            if (class46.mapSceneID != -1) {
                IndexedImage indexedImage = mapScenes[class46.mapSceneID];
                if (indexedImage != null) {
                    int i4 = (class46.sizeX * 4 - indexedImage.imgWidth) / 2;
                    int j4 = (class46.sizeY * 4 - indexedImage.imgHeight) / 2;
                    indexedImage.drawImage(x * 4 + i4, (mhTile - y - class46.sizeY) * 4 + j4);
                }
            }
        }
    }

    public void loadMap(int x, int z) {
        x /= 64;
        z /= 64;
        currentMapX = x;
        currentMapZ = z;
        //Clean region-local caches
        Rasterizer.clearTextureCache();
        sceneGraph.initToNull();
        ObjectDef.memCache1.unlinkAll();
        ObjectDef.memCache2.unlinkAll();
        System.gc();
        for (int i = 0; i < 4; i++)
            tileSettings[i].init();
        for (int l = 0; l < 4; l++) {
            for (int k1 = 0; k1 < mapWidth*64; k1++) {
                for (int j2 = 0; j2 < mapHeight*64; j2++)
                    tileSettingBits[l][k1][j2] = 0;
            }
        }

        //TODO: Actually load the map
        mapRegion = new MapRegion(mapWidth*64,mapHeight*64,tileSettingBits,heightMap);
        for (int _x = 0;_x < mapWidth;_x++)
            for (int _z = 0;_z < mapHeight;_z++){
                int terrainIdx = onDemandFetcher.getMapIndex(0,z+_z,x+_x);
                if (terrainIdx == -1){
                    mapRegion.initMapTables(_z*64,64,64,_x*64);
                    continue;
                }
                byte[] terrainData = JavaUncompress.decompress(jagexFileStores[4].decompress(terrainIdx));
                if (terrainData == null){
                    mapRegion.initMapTables(_z*64,64,64,_x*64);
                    continue;
                }
                mapRegion.loadTerrain(terrainData,_z*64,_x*64,x*64,z*64,tileSettings);
            }
        for (int _x = 0;_x < mapWidth;_x++)
            for (int _z = 0;_z < mapHeight;_z++){
                int objectIdx = onDemandFetcher.getMapIndex(1,z+_z,x+_x);
                if (objectIdx == -1)
                    continue;
                byte[] objectData = JavaUncompress.decompress(jagexFileStores[4].decompress(objectIdx));
                if (objectData == null)
                    continue;
                mapRegion.loadObjects(_x*64,tileSettings,_z*64,sceneGraph,objectData);
            }
        mapRegion.addTiles(tileSettings,sceneGraph);
        System.gc();
        Rasterizer.resetTextures(20);
        onDemandFetcher.method566();
        mapLoaded = true;
        setHeightLevel(0);
    }

    public void setHeightLevel(int hL) {
        heightLevel = hL;
        renderMinimap(hL);
        repaint();
    }

    private void renderMinimap(int _y) {
        int ai[] = minimapImage.myPixels;
        int j = ai.length;
        for (int k = 0; k < j; k++)
            ai[k] = 0;
        int mwTile = mapWidth*64;
        int mhTile = mapHeight*64;
        for (int _z = 1; _z < mhTile - 1; _z++) {
            int i1 = ((mhTile - 1) - _z) * 512 * 4;
            for (int _x = 1; _x < mwTile - 1; _x++) {
                if ((tileSettingBits[_y][_x][_z] & 0x18) == 0)
                    sceneGraph.drawMinimapTile(_y, _x, _z, ai, i1, 512);
                if (_y < 3 && (tileSettingBits[_y + 1][_x][_z] & 8) != 0)
                    sceneGraph.drawMinimapTile(_y + 1, _x, _z, ai, i1, 512);
                i1 += 4;
            }

        }

        int j1 = ((238 + (int) (Math.random() * 20D)) - 10 << 16) + ((238 + (int) (Math.random() * 20D)) - 10 << 8) + ((238 + (int) (Math.random() * 20D)) - 10);
        int l1 = (238 + (int) (Math.random() * 20D)) - 10 << 16;
        minimapImage.initDrawingArea();
        for (int _z = 1; _z < mhTile-1; _z++) {
            for (int _x = 1; _x < mwTile-1; _x++) {
                if ((tileSettingBits[_y][_x][_z] & 0x18) == 0)
                    drawMapScenes(_z, j1, _x, l1, _y);
                if (_y < 3 && (tileSettingBits[_y + 1][_x][_z] & 8) != 0)
                    drawMapScenes(_z, j1, _x, l1, _y + 1);
            }

        }

        gameScreenCanvas.initDrawingArea();
        numOfMapMarkers = 0;
        for (int x = 0; x < 104; x++) {
            for (int y = 0; y < 104; y++) {
                int i3 = sceneGraph.getGroundDecorationUID(heightLevel, x, y);
                if (i3 != 0) {
                    i3 = i3 >> 14 & 0x7fff;
                    int j3 = ObjectDef.forID(i3).mapFunctionID;
                    if (j3 >= 0) {
                        int k3 = x;
                        int l3 = y;
                        if (j3 != 22 && j3 != 29 && j3 != 34 && j3 != 36 && j3 != 46 && j3 != 47 && j3 != 48) {
                            byte byte0 = 104;
                            byte byte1 = 104;
                            int ai1[][] = tileSettings[heightLevel].clipData;
                            for (int i4 = 0; i4 < 10; i4++) {
                                int j4 = (int) (Math.random() * 4D);
                                if (j4 == 0 && k3 > 0 && k3 > x - 3 && (ai1[k3 - 1][l3] & 0x1280108) == 0)
                                    k3--;
                                if (j4 == 1 && k3 < byte0 - 1 && k3 < x + 3 && (ai1[k3 + 1][l3] & 0x1280180) == 0)
                                    k3++;
                                if (j4 == 2 && l3 > 0 && l3 > y - 3 && (ai1[k3][l3 - 1] & 0x1280102) == 0)
                                    l3--;
                                if (j4 == 3 && l3 < byte1 - 1 && l3 < y + 3 && (ai1[k3][l3 + 1] & 0x1280120) == 0)
                                    l3++;
                            }

                        }
                        markGraphic[numOfMapMarkers] = mapFunctions[j3];
                        markPosX[numOfMapMarkers] = k3;
                        markPosY[numOfMapMarkers] = l3;
                        numOfMapMarkers++;
                    }
                }
            }

        }

    }

    private void markMinimap(RgbImage rgbImage, int i, int j) {
        int k = xCameraCurve & 0x7ff;
        int l = i * i + j * j;
        if (l > 6400)
            return;
        int i1 = Model.SINE[k];
        int j1 = Model.COSINE[k];
        i1 = (i1 * 256) / (256);
        j1 = (j1 * 256) / (256);
        int k1 = j * i1 + i * j1 >> 16;
        int l1 = j * j1 - i * i1 >> 16;
        rgbImage.drawSprite(((94 + k1) - rgbImage.w2 / 2) + 4, 83 - l1 - rgbImage.h2 / 2 - 4);
    }

    private void drawMinimap() {
        minimapIP.initDrawingArea();
        Graphics2D.resetImage();
        int i = xCameraCurve & 0x7ff;
        int j = 48 + xCameraPos / 32;
        int l2 = 464 - zCameraPos / 32;
        minimapImage.rotate(j, l2, 146, 151, i, minimapShape2, 256, minimapShape1, 5, 25);
        compass.rotate(25, 25, 33, 33, xCameraCurve, compassShape2, 256, compassShape1, 0, 0);
        for (int j5 = 0; j5 < numOfMapMarkers; j5++) {
            int mapX = (markPosX[j5] * 4 + 2) - xCameraPos / 32;
            int mapY = (markPosY[j5] * 4 + 2) - zCameraPos / 32;
            markMinimap(markGraphic[j5], mapX, mapY);
        }
        Graphics2D.fillRect(97, 78, 3, 3, 0xffffff);
        if (minimapGraphics != null && editorMainWindow.getMapViewPanel().getGraphics() != null)
            minimapIP.drawGraphics(0,editorMainWindow.getMapViewPanel().getGraphics(),0);
        gameScreenCanvas.initDrawingArea();
    }

    private void drawScene() {
        int j = heightLevel;
        int l = xCameraPos;
        int i1 = zCameraPos;
        int j1 = yCameraPos;
        int k1 = yCameraCurve;
        int l1 = xCameraCurve;
        Model.aBoolean1684 = true;
        Model.resourceCount = 0;
        Model.cursorXPos = super.mouseEventX - 4;
        Model.cursorYPos = super.mouseEventY - 4;
        gameScreenCanvas.initDrawingArea();
        Graphics2D.resetImage();
        //xxx disables graphics            if(graphicsEnabled){
        //pglWrapper.setCameraPosition(xCameraPos, yCameraPos, zCameraPos);
        //pglWrapper.setCameraRotation(-xCameraCurve, 0, yCameraCurve);
        fieldJ = j;
        //sceneGraph.render(xCameraPos, yCameraPos, xCameraCurve, zCameraPos, j, yCameraCurve);
        //if (renderNode == null) {
        //    renderNode = new PglCallClientNode();
        //    pglWrapper.scene.add(renderNode);
        // }
        renderscene();
        //pglWrapper.process();
        sceneGraph.clearInteractableObjectCache();
        draw3dScreen();
        gameScreenCanvas.drawGraphics(0, super.graphics, 0);
        xCameraPos = l;
        zCameraPos = i1;
        yCameraPos = j1;
        yCameraCurve = k1;
        xCameraCurve = l1;
        //            }
    }

    private void draw3dScreen() {
        char x = 20;
        int y = 20;
        int colour = 0xffff00;
        if (super.fps < 15)
            colour = 0xff0000;
        plainFont.drawTextHLeftVMid(colour,"Fps:" + super.fps, y, x);
        y += 15;
        Runtime runtime = Runtime.getRuntime();
        int j1 = (int) ((runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024L));
        plainFont.drawTextHLeftVMid(0xffff00,"Heap usage:" + j1 + "m",y, x);
        y += 15;
        plainFont.drawTextHLeftVMid(0xffff00,"Card usage :" + ((ServerMemoryManager.arbBufferMemory + ServerMemoryManager.textureMemory) / (1024 * 1024L)) + "m", y, x);
        y += 15;
    }

    public void paintMinimap(Graphics g) {
        minimapGraphics = g;
        minimapIP.drawGraphics(0, g, 0);
    }

    private void processInput() {
        if (mouseButtonDown == 2 && lastMouseX != -1){
            int mouseDeltaX = mouseEventX - lastMouseX;
            int mouseDeltaY = mouseEventY - lastMouseY;
            lastMouseX = mouseEventX;
            lastMouseY = mouseEventY;
            xCameraCurve += mouseDeltaX;
            yCameraCurve += mouseDeltaY;
        }
        if (mouseButtonDown == 0 && lastMouseX != -1 ){
            lastMouseX = -1;
            lastMouseY = -1;
        }
        if (mouseButtonPressed == 2 && lastMouseX == -1){
            lastMouseX = clickX;
            lastMouseY = clickY;
        }
        if (xCameraPos < 0)
        {
            xCameraPos = 0;
        }
        if (yCameraPos <=-1)
        {
            yCameraPos = 0;
        }
        if (xCameraCurve < 0)
        {
            xCameraCurve = 2047;
        }
        if (yCameraCurve < 0)
        {
            yCameraCurve = 2047;
        }
        if (xCameraCurve / 64 >= 32)
        {
            xCameraCurve = 0;
        }
        if (yCameraCurve > 2047)
        {
            yCameraCurve = 0;
        }
        if (keyStatus['w'] == 1){
            xCameraPos -= Rasterizer.SINE[xCameraCurve] >> 10;
            yCameraPos += Rasterizer.COSINE[xCameraCurve] >> 10;
            zCameraPos += Rasterizer.SINE[yCameraCurve] >> 10;
        }
        if (keyStatus['s'] == 1){
            xCameraPos += Rasterizer.SINE[xCameraCurve] >> 10;
            yCameraPos -= Rasterizer.COSINE[xCameraCurve] >> 10;
            zCameraPos -= Rasterizer.SINE[yCameraCurve] >> 10;
        }
    }

    @Override
    protected Component getGameComponent() {
        return editorMainWindow.getGameViewPanel();
    }

    public static void main(String[] args) {
        new EditorMain().startEditor();
    }

    /**
     * Invoked when the component's size changes.
     */
    public void componentResized(ComponentEvent e) {
        resizeWidth = editorMainWindow.getGameViewPanel().getWidth();
        resizeHeight = editorMainWindow.getGameViewPanel().getHeight();
    }

    /**
     * Invoked when the component's position changes.
     */
    public void componentMoved(ComponentEvent e) {
    }

    /**
     * Invoked when the component has been made visible.
     */
    public void componentShown(ComponentEvent e) {
    }

    /**
     * Invoked when the component has been made invisible.
     */
    public void componentHidden(ComponentEvent e) {
    }

    public EditorMain() {
        compassShape1 = new int[33];
        jagexFileStores = new JagexFileStore[5];
        mapFunctions = new RgbImage[100];
        minimapShape1 = new int[151];
        compassShape2 = new int[33];
        mapScenes = new IndexedImage[100];
        markPosX = new int[1000];
        markPosY = new int[1000];
        markGraphic = new RgbImage[1000];
        minimapShape2 = new int[151];
        tileSettings = new TileSetting[4];
    }

}
