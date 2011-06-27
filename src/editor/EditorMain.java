package editor;

import editor.gui.EditorMainWindow;
import editor.renderer.GameViewPanel;
import org.peterbjornx.pgl2.util.ServerMemoryManager;
import pgle.PglCallClientNode;
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
    private int heightLevel = 0;
    private int xCameraPos;
    private int yCameraPos;
    private int xCameraCurve;
    private int zCameraPos;
    private int yCameraCurve;
    private GraphicsBuffer minimapIP;
    private int numOfMapMarkers = 0;
    private RgbImage[] markGraphic;
    private int[] markPosX;
    private int[] markPosY;
    private boolean mapLoaded = false;

    private JagexArchive getJagexArchive(int i) {
        byte abyte0[] = null;
        try {
            if (jagexFileStores[0] != null)
                abyte0 = jagexFileStores[0].decompress(i);
        } catch (Exception _ex) {
            JOptionPane.showMessageDialog(null,"Failed to load the cache","RuneScape Map Editor",JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        if (abyte0 != null) {
            return new JagexArchive(abyte0);
        }
        JOptionPane.showMessageDialog(null,"Failed to load the cache","RuneScape Map Editor",JOptionPane.ERROR_MESSAGE);
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
        drawLoadingText(20,"Starting up");
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
            tileSettingBits = new byte[4][104][104];
            heightMap = new int[4][105][105];
            sceneGraph = new SceneGraph(4, 104, 104, heightMap);
            for (int j = 0; j < 4; j++)
                tileSettings[j] = new TileSetting();

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
                    JOptionPane.showMessageDialog(null,"Failed to load animations","RuneScape Map Editor",JOptionPane.ERROR_MESSAGE);
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
            for (int j6 = 0; j6 < 33; j6++) {
                int k6 = 999;
                int i7 = 0;
                for (int k7 = 0; k7 < 34; k7++) {
                    if (k6 == 999)
                        k6 = k7;
                }

                compassShape1[j6] = k6;
                compassShape2[j6] = i7 - k6;
            }

            for (int l6 = 5; l6 < 156; l6++) {
                int j7 = 999;
                int l7 = 0;
                for (int j8 = 25; j8 < 172; j8++) {
                    if (j7 == 999)
                        j7 = j8;
                }

                minimapShape1[l6 - 5] = j7 - 25;
                minimapShape2[l6 - 5] = l7 - j7;
            }
            int vpW = editorMainWindow.getGameViewPanel().getWidth();
            int vpH = editorMainWindow.getGameViewPanel().getHeight();
            minimapIP = new GraphicsBuffer(vpW,vpH,getGameComponent());
            gameScreenCanvas = new GraphicsBuffer(vpW,vpH,getGameComponent());
            Rasterizer.setBounds(vpW, vpH);
            int ai[] = new int[9];
            for (int i8 = 0; i8 < 9; i8++) {
                int k8 = 128 + i8 * 32 + 15;
                int l8 = 600 + k8 * 3;
                int i9 = Rasterizer.SINE[k8];
                ai[i8] = l8 * i9 >> 16;
            }
            SceneGraph.setupViewport(500, 800, vpW, vpH, ai);
            editorMainWindow.getGameViewPanel().addComponentListener(this);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null,"Failed to start up","RuneScape Map Editor",JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    public void resize3D(){
            int vpW = editorMainWindow.getGameViewPanel().getWidth();
            int vpH = editorMainWindow.getGameViewPanel().getHeight();
            gameScreenCanvas = new GraphicsBuffer(vpW,vpH,getGameComponent());
            int ai[] = new int[9];
            for (int i8 = 0; i8 < 9; i8++) {
                int k8 = 128 + i8 * 32 + 15;
                int l8 = 600 + k8 * 3;
                int i9 = Rasterizer.SINE[k8];
                ai[i8] = l8 * i9 >> 16;
            }
            Rasterizer.setBounds(vpW, vpH);
            SceneGraph.setupViewport(500, 800, vpW, vpH, ai);

    }

    @Override
    protected void doLogic() {
        if (onDemandFetcher != null)
            on_demand_process();
    }

    @Override
    protected void shutdown() {
    }

    @Override
    protected void repaintGame() {
    }

    @Override
    protected void drawGame() {
        if (mapLoaded){
            drawScene();
            drawMinimap();
        }

    }

    private void startEditor(){
        try {
            GameViewPanel gameViewPanel;
            editorMainWindow = new EditorMainWindow();
            editorMainWindow.show();
            gameViewPanel = editorMainWindow.getGameViewPanel();
            Signlink.startpriv(InetAddress.getLocalHost());
            initialize(gameViewPanel.getWidth(),gameViewPanel.getHeight());
            gameViewPanel.setGameShell(this);
            SceneGraph.lowMem = false;
            Rasterizer.lowMem = false;
            MapRegion.lowMem = false;
            ObjectDef.lowMem = false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to start the application!","RuneScape Map Editor",JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    public void renderscene() {
        sceneGraph.render(xCameraPos, yCameraPos, xCameraCurve, zCameraPos, fieldJ, yCameraCurve);
    }

    private void drawMapScenes(int y, int k, int x, int i1, int z) {
        int interactableObjectUID = sceneGraph.getWallObjectUID(z, x, y);
        if (interactableObjectUID != 0) {
            int l1 = sceneGraph.getIDTAGForXYZ(z, x, y, interactableObjectUID);
            int k2 = l1 >> 6 & 3;
            int i3 = l1 & 0x1f;
            int k3 = k;
            if (interactableObjectUID > 0)
                k3 = i1;
            int ai[] = minimapImage.myPixels;
            int k4 = 24624 + x * 4 + (103 - y) * 512 * 4;
            int i5 = interactableObjectUID >> 14 & 0x7fff;
            ObjectDef class46_2 = ObjectDef.forID(i5);
            if (class46_2.mapSceneID != -1) {
                IndexedImage indexedImage_2 = mapScenes[class46_2.mapSceneID];
                if (indexedImage_2 != null) {
                    int i6 = (class46_2.sizeX * 4 - indexedImage_2.imgWidth) / 2;
                    int j6 = (class46_2.sizeY * 4 - indexedImage_2.imgHeight) / 2;
                    indexedImage_2.drawImage(48 + x * 4 + i6, 48 + (104 - y - class46_2.sizeY) * 4 + j6);
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
                    indexedImage_1.drawImage(48 + x * 4 + j5, 48 + (104 - y - class46_1.sizeY) * 4 + k5);
                }
            } else if (j3 == 9) {
                int l4 = 0xeeeeee;
                if (interactableObjectUID > 0)
                    l4 = 0xee0000;
                int ai1[] = minimapImage.myPixels;
                int l5 = 24624 + x * 4 + (103 - y) * 512 * 4;
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
                    indexedImage.drawImage(48 + x * 4 + i4, 48 + (104 - y - class46.sizeY) * 4 + j4);
                }
            }
        }
    }

    public void loadMap(int x,int z){
        //TODO: Actually load the map
        mapLoaded = true;
        setHeightLevel(0);
    }

    public void setHeightLevel(int hL){
        heightLevel = hL;
        rendedMapScene(hL);
    }

    private void rendedMapScene(int i) {
        int ai[] = minimapImage.myPixels;
        int j = ai.length;
        for (int k = 0; k < j; k++)
            ai[k] = 0;

        for (int l = 1; l < 103; l++) {
            int i1 = 24628 + (103 - l) * 512 * 4;
            for (int k1 = 1; k1 < 103; k1++) {
                if ((tileSettingBits[i][k1][l] & 0x18) == 0)
                    sceneGraph.drawMinimapTile(i, k1, l, ai, i1, 512);
                if (i < 3 && (tileSettingBits[i + 1][k1][l] & 8) != 0)
                    sceneGraph.drawMinimapTile(i + 1, k1, l, ai, i1, 512);
                i1 += 4;
            }

        }

        int j1 = ((238 + (int) (Math.random() * 20D)) - 10 << 16) + ((238 + (int) (Math.random() * 20D)) - 10 << 8) + ((238 + (int) (Math.random() * 20D)) - 10);
        int l1 = (238 + (int) (Math.random() * 20D)) - 10 << 16;
        minimapImage.initDrawingArea();
        for (int i2 = 1; i2 < 103; i2++) {
            for (int j2 = 1; j2 < 103; j2++) {
                if ((tileSettingBits[i][j2][i2] & 0x18) == 0)
                    drawMapScenes(i2, j1, j2, l1, i);
                if (i < 3 && (tileSettingBits[i + 1][j2][i2] & 8) != 0)
                    drawMapScenes(i2, j1, j2, l1, i + 1);
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
        int i = xCameraCurve & 0x7ff;
        int j = 48 + xCameraPos / 32;
        int l2 = 464 - zCameraPos / 32;
        minimapImage.rotate(151, i, minimapShape2, 256, minimapShape1, l2, 5, 25, 146, j);
        compass.rotate(33, xCameraCurve, compassShape2, 256, compassShape1, 25, 0, 0, 33, 25);
        for (int j5 = 0; j5 < numOfMapMarkers; j5++) {
            int mapX = (markPosX[j5] * 4 + 2) - xCameraPos / 32;
            int mapY = (markPosY[j5] * 4 + 2) - zCameraPos / 32;
            markMinimap(markGraphic[j5], mapX, mapY);
        }
        Graphics2D.fillRect(97, 78, 3, 3, 0xffffff);
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
        gameScreenCanvas.initDrawingArea();
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
            plainFont.method380("Fps:" + super.fps, x, colour, y);
            y += 15;
            Runtime runtime = Runtime.getRuntime();
            int j1 = (int) ((runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024L));
            colour = 0xffff00;
            plainFont.method380("Heap usage:" + j1 + "m", x, 0xffff00, y);
            y += 15;
            plainFont.method380("Card usage :" + ((ServerMemoryManager.arbBufferMemory + ServerMemoryManager.textureMemory) / (1024 * 1024L)) + "m", x, colour, y);
            y += 15;
    }

    public void drawMinimap(Graphics g){
        minimapIP.drawGraphics(0,g,0);
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
        resize3D();
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
