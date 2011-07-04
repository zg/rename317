package editor;

import editor.gui.EditorMainWindow;
import editor.gui.dockables.ToolSelectionBar;
import editor.renderer.GameViewPanel;
import org.peterbjornx.pgl2.util.ServerMemoryManager;
import rs2.*;
import rs2.Graphics2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.InetAddress;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/24/11
 * Time: 5:26 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class EditorMain extends GameShell implements ComponentListener, WindowListener {
    private EditorMainWindow editorMainWindow;
    public JagexFileStore[] jagexFileStores = new JagexFileStore[5];
    private OnDemandFetcher onDemandFetcher;
    private JagexArchive titleJagexArchive;
    private SceneGraph sceneGraph;
    private MapRegion mapRegion;
    private TileSetting[] tileSettings;
    private RSFont smallFont;
    private RSFont plainFont;
    private RSFont boldFont;
    private RgbImage minimapImage;
    private RgbImage compass;
    private IndexedImage[] mapScenes;
    private RgbImage[] mapFunctions;
    private RgbImage mapMarker;
    private int fieldJ;
    private GraphicsBuffer minimapIP;
    private GraphicsBuffer gameScreenCanvas;
    /* Map fields */
    private int mapWidth = 2;//- Settings
    private int mapHeight = 2;//- Settings
    private int heightLevel = 0;
    private boolean mapLoaded = false;
    private int currentMapX;
    private int currentMapZ;
    private int mapTileW = mapWidth * 64;
    private int mapTileH = mapHeight * 64;
    private byte[][][] tileSettingBits;
    private int[][][] heightMap;
    /* Camera fields */
    private int xCameraPos=mapWidth*32*128;;
    private int yCameraPos=mapHeight*32*128;
    private int xCameraCurve = (int) (Math.random() * 20D) - 10 & 0x7ff;;
    private int zCameraPos = -540;
    private int yCameraCurve = 128;
    /* Minimap fields */
    private int[] compassShape1;
    private int[] compassShape2;
    private int[] minimapShape1;
    private int[] minimapShape2;
    private int numOfMapMarkers = 0;
    private RgbImage[] markGraphic;
    private int[] markPosX;
    private int[] markPosY;
    private Graphics minimapGraphics;
    /* Mouse 360* camera fields */
    private int lastMouseX = -1;
    private int lastMouseY = -1;
    private int[] isOnScreen;
    /* Resizable window fields*/
    private int lastResizeHeight = -1;
    private int lastResizeWidth = -1;
    private int resizeWidth = -1;
    private int resizeHeight = -1;
    /* Render setting fields */
    private boolean showAllHLs = false;
    /* Basic editing fields */
    private int selectedTileY = -1;
    private int selectedTileX = -1;
    private int selectedTileZ = -1;
    /* Mod height fields */
    private int heightEditingSpeed = 10;
    /* Set height fields */
    private int setHeight;
    /* Flood fill fields */
    private int recurseOMeter = 0;
    private boolean[][][] fillTraversed;
    /* Pencil fields */
   // private boolean[][][] selectedFields;


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
            tileSettingBits = new byte[4][mapTileW][mapTileH];
            heightMap = new int[4][mapTileW + 1][mapTileH + 1];
            sceneGraph = new SceneGraph(4,mapTileW, mapTileH, heightMap);
            for (int j = 0; j < 4; j++)
                tileSettings[j] = new TileSetting(mapTileW, mapTileH);

            minimapImage = new RgbImage(786, 786);
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
				compassShape2[x] = compass.myWidth;
				compassShape1[x] = 1;
			}
			for (int x = 0; x < minimapShape2.length; x++) {
				minimapShape2[x] = 256;
				minimapShape1[x] = 1;
			}

            int vpW = editorMainWindow.getGameViewPanel().getWidth();
            int vpH = editorMainWindow.getGameViewPanel().getHeight();
            minimapIP = new GraphicsBuffer(256, 256, getGameComponent());
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
            editorMainWindow.editorStarted(this);
            loadMap(3136,3136);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Failed to start up", "RuneScape Map Editor", JOptionPane.ERROR_MESSAGE);
            exception.printStackTrace();
            System.exit(-1);
        }
    }

    public void processResize() {
        int resizeWidth = this.resizeWidth;     //to prevent resize glitch
        int resizeHeight = this.resizeHeight;
        //noinspection ConstantConditions
        if (resizeWidth != this.resizeWidth
            || resizeHeight != this.resizeHeight)
            return;
        startGraphicsBlock();
        gameScreenCanvas = new GraphicsBuffer(resizeWidth, resizeHeight, getGameComponent());
        Graphics2D.fillRect(0, 0, resizeWidth, resizeHeight, 0);
        Rasterizer.setBounds(resizeWidth, resizeHeight);
        SceneGraph.setupViewport(500, 800, resizeWidth, resizeHeight, isOnScreen);
        this.resizeWidth = -1;
        this.resizeHeight = -1;
        endGraphicsBlock();
        repaint();
    }

    @Override
    protected void doLogic() {
        if (onDemandFetcher != null)
            on_demand_process();
        if (mapLoaded){
            processCameraInput();
            sceneGraph.clearHightlights();
            if (SceneGraph.clickedTileX != -1){
                if (editorMainWindow.getToolSelectionBar().getSelectedTool()
                        == ToolSelectionBar.EditorTools.HEIGHT_EDIT)
                    sceneGraph.enableHeightHighlight();
                highlightTile(SceneGraph.clickedTileZ,SceneGraph.clickedTileX,SceneGraph.clickedTileY);
                if (mouseButtonDown == 1){
                    selectTile(SceneGraph.clickedTileZ,SceneGraph.clickedTileX,SceneGraph.clickedTileY);
                }
            }
            if (mouseButtonDown != 2){
                sceneGraph.request2DTrace(mouseEventY,mouseEventX);
            }
        }
        if (resizeWidth != -1)
            processResize();
    }

    private void selectTile(int z, int x, int y) {
        selectedTileY = z;
        selectedTileX = x;
        selectedTileZ = y;
        boolean controlDown = keyStatus[5] == 1;
        int halfW = editorMainWindow.getToolSelectionBar().getBrushSize()/2;
        if (editorMainWindow.getToolSelectionBar().getBrushSize() % 2 == 0 || halfW == 0){
            for (int _x = x;_x < editorMainWindow.getToolSelectionBar().getBrushSize()+x;_x++)
                for (int _z = y;_z < editorMainWindow.getToolSelectionBar().getBrushSize()+y;_z++)   {
                    if (z < 0 || _x < 0 || _z < 0 || z > 3 || _x >= mapTileW || _z >= mapTileH)
                        continue;
                    int dx = Math.abs(x-_x);
                    int dy = Math.abs(y-_z);
                    float d = (int) Math.sqrt(dx*dx + dy*dy);
                    modifyTile(z,_x,_z,d);
                }
        } else {
            for (int _x = x-halfW;_x <= halfW+x;_x++)
                for (int _z = y-halfW;_z <= halfW+y;_z++)   {
                    if (z < 0 || _x < 0 || _z < 0 || z > 3 || _x >= mapTileW || _z >= mapTileH)
                        continue;
                    int dx = Math.abs(x-_x);
                    int dy = Math.abs(y-_z);
                    float d = (int) Math.sqrt(dx*dx + dy*dy);
                    modifyTile(z,_x,_z,d);
                }
        }
        refreshMap();
    }

    private void highlightTile(int z, int x, int y) {
        int halfW = editorMainWindow.getToolSelectionBar().getBrushSize()/2;
        if (editorMainWindow.getToolSelectionBar().getBrushSize() % 2 == 0 || halfW == 0){
            for (int _x = x;_x < editorMainWindow.getToolSelectionBar().getBrushSize()+x;_x++)
                for (int _z = y;_z < editorMainWindow.getToolSelectionBar().getBrushSize()+y;_z++)   {
                    if (z < 0 || _x < 0 || _z < 0 || z > 3 || _x >= mapTileW || _z >= mapTileH)
                        continue;
                    int dx = Math.abs(x-_x);
                    int dy = Math.abs(y-_z);
                    sceneGraph.setHighlightedTile(_x,_z);
                }
        } else {
            for (int _x = x-halfW;_x <= halfW+x;_x++)
                for (int _z = y-halfW;_z <= halfW+y;_z++)   {
                    if (z < 0 || _x < 0 || _z < 0 || z > 3 || _x >= mapTileW || _z >= mapTileH)
                        continue;
                    int dx = Math.abs(x-_x);
                    int dy = Math.abs(y-_z);
                    sceneGraph.setHighlightedTile(_x,_z);
                }
        }
    }

    private void modifyTile(int z,int x,int y,float d){
        boolean controlDown = keyStatus[5] == 1;
        switch (editorMainWindow.getToolSelectionBar().getSelectedTool()){
            case SELECT:
                if (d == 0)
                    editorMainWindow.getSettingsBrushEditorWindow().setCurrentTileBits(tileSettingBits[z][x][y]);
                break;
            case PAINT_OVERLAY:
                if (!controlDown){
                    mapRegion.setOverlay(z,x,y,editorMainWindow.getFloorTypeSelectionWindow().getSelectedFloorId()+1);
                } else if (d == 0)
                    editorMainWindow.getFloorTypeSelectionWindow().selectFloor(mapRegion.getOverLay()[z][x][y]-1);
                break;
            case PAINT_UNDERLAY:
                if (!controlDown){
                    mapRegion.setUnderlay(z, x, y, editorMainWindow.getFloorTypeSelectionWindow().getSelectedFloorId() + 1);
                } else if (d == 0)
                    editorMainWindow.getFloorTypeSelectionWindow().selectFloor(mapRegion.getUnderLay()[z][x][y]-1);
                break;
            case HEIGHT_EDIT:
                mapRegion.automaticHeight[z][x][y] = false;
                if (!controlDown){
                    heightMap[z][x][y]-=(heightEditingSpeed/(d * 0.25f + 1f)) % 8;
                } else {
                    if (heightMap[z][x][y] < 0)
                        heightMap[z][x][y]+=(heightEditingSpeed/(d * 0.25f + 1f)) % 8;
                }
                break;
            case HEIGHT_SET:
                mapRegion.automaticHeight[z][x][y] = false;
                if (!controlDown && setHeight != -1){
                    heightMap[z][x][y]=setHeight;
                } else if (controlDown && d == 0) {
                    setHeight = heightMap[z][x][y];
                }
                break;
            case FLOODFILL_OVERLAY:
                if (d == 0)
                    doFloodFill(z,x,y,true,-1);
                break;
            case FLOODFILL_UNDERLAY:
                if (d == 0)
                    doFloodFill(z,x,y,false,-1);
                break;
            case HEIGHTFILL_OVERLAY:
                if (d == 0)
                    if (controlDown)
                        setHeight = heightMap[z][x][y];
                    else
                        doFloodFill(z, x, y, true, -1);
                break;
            case HEIGHTFILL_UNDERLAY:
                if (d == 0)
                    if (controlDown)
                        setHeight = heightMap[z][x][y];
                    else
                        doFloodFill(z, x, y, false, -1);
                break;
            case SETTINGSFILL_OVERLAY:
            case SETTINGSFILL_UNDERLAY:
                if (d == 0){
                    editorMainWindow.getSettingsBrushEditorWindow().setCurrentTileBits(tileSettingBits[z][x][y]);
                    doFloodFill(z,x,y,editorMainWindow.getToolSelectionBar().getSelectedTool() == ToolSelectionBar.EditorTools.SETTINGSFILL_OVERLAY,-1);
                }
                break;
            case APPLY_SETTINGS:
                tileSettingBits[z][x][y] = (byte) editorMainWindow.getSettingsBrushEditorWindow().getBitField();
                break;
            case ADDSHAPES_OVERLAY:
            case ADDSHAPES_UNDERLAY:
                 doFloodFill(z,x,y,editorMainWindow.getToolSelectionBar().getSelectedTool() == ToolSelectionBar.EditorTools.ADDSHAPES_OVERLAY,-1);
                break;
        }

    }

    private void doFloodFill(int y, int x, int z, boolean isOverlay,int curId) {
        if (curId == -1) {
            recurseOMeter = 0;
            fillTraversed = new boolean[4][mapTileW][mapTileH];
        }
        recurseOMeter++;
        if (y < 0 || x < 0 || z < 0 || y > 3 || x >= mapTileW || z >= mapTileH){
            recurseOMeter--;
            return;
        }
        if (isOverlay){
            int overlayId = mapRegion.getOverLay()[y][x][z] & 0xFF;
            if (curId == -1){
                curId = overlayId;
            } else if (curId != overlayId || fillTraversed[y][x][z]) {
                recurseOMeter--;
                return;
            }
        } else {
            int underlayId = mapRegion.getUnderLay()[y][x][z] & 0xFF;
            if (curId == -1){
                curId = underlayId;
            } else if (curId != underlayId || fillTraversed[y][x][z]) {
                recurseOMeter--;
                return;
            }
        }
        fillTraversed[y][x][z] = true;
        switch (editorMainWindow.getToolSelectionBar().getSelectedTool()){
            case HEIGHTFILL_OVERLAY:
                heightMap[y][x+1][z]=setHeight;
                heightMap[y][x+1][z+1]=setHeight;
                heightMap[y][x][z+1]=setHeight;
            case HEIGHTFILL_UNDERLAY:
                mapRegion.automaticHeight[y][x][z] = false;
                heightMap[y][x][z]=setHeight;
                break;
            case SETTINGSFILL_OVERLAY:
            case SETTINGSFILL_UNDERLAY:
                tileSettingBits[y][x][z] = (byte) editorMainWindow.getSettingsBrushEditorWindow().getBitField();
                break;
            case FLOODFILL_OVERLAY:
                mapRegion.setOverlay(y, x, z, editorMainWindow.getFloorTypeSelectionWindow().getSelectedFloorId() + 1);
                break;
            case FLOODFILL_UNDERLAY:
                mapRegion.setUnderlay(y,x,z,editorMainWindow.getFloorTypeSelectionWindow().getSelectedFloorId()+1);
                break;
            case ADDSHAPES_OVERLAY:
            case ADDSHAPES_UNDERLAY:
                boolean n = z == mapTileH - 1 || mapRegion.getOverLay()[y][x][z + 1] != 0;
                boolean s = z == 0 || mapRegion.getOverLay()[y][x][z - 1] != 0;
                boolean w = x == 0 || mapRegion.getOverLay()[y][x-1][z  ] != 0;
                boolean e = x == mapTileW - 1 || mapRegion.getOverLay()[y][x+1][z  ] != 0;
                mapRegion.shapeA[y][x][z] = 1;
                if (n && w && (!s) && (!e))
                    mapRegion.shapeB[y][x][z] = 1;
                else if (n && e && (!s) && (!w))
                    mapRegion.shapeB[y][x][z] = 2;
                else if (s && e && (!n) && (!w))
                    mapRegion.shapeB[y][x][z] = 3;
                else if (s && w && (!n) && (!e))
                    mapRegion.shapeB[y][x][z] = 0;
                else
                    mapRegion.shapeA[y][x][z] = 0;
                break;
        }
        if (recurseOMeter >= 500){
            recurseOMeter--;
            return;
        }
        for (int _x = x-1; _x <= x+1; _x++)
            doFloodFill(y, _x, z, isOverlay, curId);
        for (int _z = z-1; _z <= z+1; _z++)
            doFloodFill(y, x, _z, isOverlay, curId);
        recurseOMeter--;
    }



    private void refreshMap() {
        sceneGraph.clearCullingClusters();
        mapRegion.addTiles(tileSettings,sceneGraph, editorMainWindow.getEditorToolbar().getSettings());
        sceneGraph.setHeightLevel(heightLevel);
    }

    @Override
    protected void shutdown() {
    }

    @Override
    protected void repaintGame() {
        if (graphics == null)
            return;
        gameScreenCanvas.drawGraphics(0, graphics, 0);
        if (selectedTileX != -1)
            ShapedTile.drawShape(super.graphics, (byte) (mapRegion.getShapeA()[selectedTileY][selectedTileX][selectedTileZ]+1),mapRegion.getShapeB()[selectedTileY][selectedTileX][selectedTileZ]);
        }

    @Override
    protected void drawGame() {
        try {
            if (mapLoaded) {
                drawScene();
                drawMinimap();
            }gameScreenCanvas.drawGraphics(0, graphics, 0);
            if (selectedTileX != -1)
                        ShapedTile.drawShape(super.graphics, (byte) (mapRegion.getShapeA()[selectedTileY][selectedTileX][selectedTileZ]+1),mapRegion.getShapeB()[selectedTileY][selectedTileX][selectedTileZ]);

        } catch (Exception e){
            System.err.println("Exception while rendering frame!");
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
            int mhTile = mapTileH;// mapHeight*64;
        if (interactableObjectUID != 0) {
            int uid = sceneGraph.getIDTAGForXYZ(z, x, y, interactableObjectUID);
            int lineDirection = uid >> 6 & 3;
            int lineRenderType = uid & 0x1f;
            int lineColour = k;
            if (interactableObjectUID > 0)
                lineColour = i1;
            @SuppressWarnings({"MismatchedReadAndWriteOfArray"}) int minimapPixels[] = minimapImage.myPixels;
            int pixelOffset = (128 + 128 * 786) +  x * 4 + ((mhTile - 1) - y) * 786 * 4;
            int objectID = interactableObjectUID >> 14 & 0x7fff;
            ObjectDef object = ObjectDef.forID(objectID);
            if (object.mapSceneID != -1) {
                IndexedImage mapScene = mapScenes[object.mapSceneID];
                if (mapScene != null) {
                    int i6 = (object.sizeX * 4 - mapScene.imgWidth) / 2;
                    int j6 = (object.sizeY * 4 - mapScene.imgHeight) / 2;
                    mapScene.drawImage(128 + x * 4 + i6, 128 + (mhTile - y - object.sizeY) * 4 + j6);
                }
            } else {
                if (lineRenderType == 0 || lineRenderType == 2)
                    if (lineDirection == 0) {   //West
                        minimapPixels[pixelOffset] = lineColour;
                        minimapPixels[pixelOffset + 786] = lineColour;
                        minimapPixels[pixelOffset + 786*2] = lineColour;
                        minimapPixels[pixelOffset + 786*3] = lineColour;
                    } else if (lineDirection == 1) {   //North
                        minimapPixels[pixelOffset] = lineColour;
                        minimapPixels[pixelOffset + 1] = lineColour;
                        minimapPixels[pixelOffset + 2] = lineColour;
                        minimapPixels[pixelOffset + 3] = lineColour;
                    } else if (lineDirection == 2) {         //East
                        minimapPixels[pixelOffset + 3] = lineColour;
                        minimapPixels[pixelOffset + 3 + 786] = lineColour;
                        minimapPixels[pixelOffset + 3 + 786*2] = lineColour;
                        minimapPixels[pixelOffset + 3 + 786*3] = lineColour;
                    } else if (lineDirection == 3) {          //South
                        minimapPixels[pixelOffset + 786*3] = lineColour;
                        minimapPixels[pixelOffset + 786*3 + 1] = lineColour;
                        minimapPixels[pixelOffset + 786*3 + 2] = lineColour;
                        minimapPixels[pixelOffset + 786*3 + 3] = lineColour;
                    }
                if (lineRenderType == 3)
                    if (lineDirection == 0)
                        minimapPixels[pixelOffset] = lineColour;
                    else if (lineDirection == 1)
                        minimapPixels[pixelOffset + 3] = lineColour;
                    else if (lineDirection == 2)
                        minimapPixels[pixelOffset + 3 + 786*3] = lineColour;
                    else if (lineDirection == 3)
                        minimapPixels[pixelOffset + 786*3] = lineColour;
                if (lineRenderType == 2)
                    if (lineDirection == 3) {
                        minimapPixels[pixelOffset] = lineColour;
                        minimapPixels[pixelOffset + 786] = lineColour;
                        minimapPixels[pixelOffset + 786*2] = lineColour;
                        minimapPixels[pixelOffset + 786*3] = lineColour;
                    } else if (lineDirection == 0) {
                        minimapPixels[pixelOffset] = lineColour;
                        minimapPixels[pixelOffset + 1] = lineColour;
                        minimapPixels[pixelOffset + 2] = lineColour;
                        minimapPixels[pixelOffset + 3] = lineColour;
                    } else if (lineDirection == 1) {
                        minimapPixels[pixelOffset + 3] = lineColour;
                        minimapPixels[pixelOffset + 3 + 786] = lineColour;
                        minimapPixels[pixelOffset + 3 + 786*2] = lineColour;
                        minimapPixels[pixelOffset + 3 + 786*3] = lineColour;
                    } else if (lineDirection == 2) {
                        minimapPixels[pixelOffset + 786*3] = lineColour;
                        minimapPixels[pixelOffset + 786*3 + 1] = lineColour;
                        minimapPixels[pixelOffset + 786*3 + 2] = lineColour;
                        minimapPixels[pixelOffset + 786*3 + 3] = lineColour;
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
                    indexedImage_1.drawImage(128 + x * 4 + j5,128 + (mhTile - y - class46_1.sizeY) * 4 + k5);
                }
            } else if (j3 == 9) {
                int l4 = 0xeeeeee;
                if (interactableObjectUID > 0)
                    l4 = 0xee0000;
                @SuppressWarnings({"MismatchedReadAndWriteOfArray"}) int ai1[] = minimapImage.myPixels;
                int l5 = (128 + 128 * 786) + x * 4 + ((mhTile - 1) - y) * 786 * 4;
                if (l2 == 0 || l2 == 2) {
                    ai1[l5 + 786*3] = l4;
                    ai1[l5 + 786*2 + 1] = l4;
                    ai1[l5 + 786 + 2] = l4;
                    ai1[l5 + 3] = l4;
                } else {
                    ai1[l5] = l4;
                    ai1[l5 + 786 + 1] = l4;
                    ai1[l5 + 786*2 + 2] = l4;
                    ai1[l5 + 786*3 + 3] = l4;
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
                    indexedImage.drawImage(128 + x * 4 + i4,128 +  (mhTile - y - class46.sizeY) * 4 + j4);
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
            for (int k1 = 0; k1 < mapTileW; k1++) {
                for (int j2 = 0; j2 <mapTileH; j2++)
                    tileSettingBits[l][k1][j2] = 0;
            }
        }

        //TODO: Actually load the map
        mapRegion = new MapRegion(mapTileW,mapTileH,tileSettingBits,heightMap);
        for (int _x = 0;_x < mapWidth;_x++)
            for (int _z = 0;_z < mapHeight;_z++){
                int terrainIdx = onDemandFetcher.getMapIndex(0,z+_z,x+_x);
                if (terrainIdx == -1){
                    mapRegion.initMapTables(_z*64,64,64,_x*64);
                    continue;
                }
                byte[] terrainData = GZIPWrapper.decompress(jagexFileStores[4].decompress(terrainIdx));
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
                byte[] objectData = GZIPWrapper.decompress(jagexFileStores[4].decompress(objectIdx));
                if (objectData == null)
                    continue;
                mapRegion.loadObjects(_x*64,tileSettings,_z*64,sceneGraph,objectData);
            }
        mapRegion.addTiles(tileSettings,sceneGraph, 0);
        sceneGraph.setHeightLevel(0);
        System.gc();
        Rasterizer.resetTextures(20);
        onDemandFetcher.method566();
        mapLoaded = true;
        setHeightLevel(0);
    }

    public void setHeightLevel(int hL) {
        heightLevel = hL;
        sceneGraph.setHeightLevel(hL);
        renderMinimap(hL);
        repaint();
    }

    private void renderMinimap(int _y) {
        int ai[] = minimapImage.myPixels;
        int j = ai.length;
        for (int k = 0; k < j; k++)
            ai[k] = 0;
        int mwTile = mapTileW;
        int mhTile = mapTileH;
        for (int _z = 1; _z < mhTile - 1; _z++) {
            int i1 = (128 + 128 * 786) + 4 + ((mhTile - 1) - _z) * 786 * 4;
            for (int _x = 1; _x < mwTile - 1; _x++) {
                if ((tileSettingBits[_y][_x][_z] & 0x18) == 0)
                    sceneGraph.drawMinimapTile(_y, _x, _z, ai, i1, 786);
                if (_y < 3 && (tileSettingBits[_y + 1][_x][_z] & 8) != 0)
                    sceneGraph.drawMinimapTile(_y + 1, _x, _z, ai, i1, 786);
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
        for (int x = 0; x < mwTile; x++) {
            for (int y = 0; y < mhTile; y++) {
                int i3 = sceneGraph.getGroundDecorationUID(heightLevel, x, y);
                if (i3 != 0) {
                    i3 = i3 >> 14 & 0x7fff;
                    int j3 = ObjectDef.forID(i3).mapFunctionID;
                    if (j3 >= 0) {
                        int smth_X = x;
                        int smth_Y = y;
                        if (j3 != 22 && j3 != 29 && j3 != 34 && j3 != 36 && j3 != 46 && j3 != 47 && j3 != 48) {
                            byte byte0 = (byte) mwTile;
                            byte byte1 = (byte) mhTile;
                            int ai1[][] = tileSettings[heightLevel].clipData;
                            for (int i4 = 0; i4 < 10; i4++) {
                                int j4 = (int) (Math.random() * 4D);
                                if (j4 == 0 && smth_X > 0 && smth_X > x - 3 && (ai1[smth_X - 1][smth_Y] & 0x1280108) == 0)
                                    smth_X--;
                                if (j4 == 1 && smth_X < byte0 - 1 && smth_X < x + 3 && (ai1[smth_X + 1][smth_Y] & 0x1280180) == 0)
                                    smth_X++;
                                if (j4 == 2 && smth_Y > 0 && smth_Y > y - 3 && (ai1[smth_X][smth_Y - 1] & 0x1280102) == 0)
                                    smth_Y--;
                                if (j4 == 3 && smth_Y < byte1 - 1 && smth_Y < y + 3 && (ai1[smth_X][smth_Y + 1] & 0x1280120) == 0)
                                    smth_Y++;
                            }

                        }
                        markGraphic[numOfMapMarkers] = mapFunctions[j3];
                        markPosX[numOfMapMarkers] = smth_X;
                        markPosY[numOfMapMarkers] = smth_Y;
                        numOfMapMarkers++;
                    }
                }
            }

        }

    }

    private void markMinimap(RgbImage rgbImage, int x, int y) {
        int k = xCameraCurve & 0x7ff;
        int c = x * x + y * y;
        if (c > 6400)
            return;
        int sine = Model.SINE[k];
        int cosine = Model.COSINE[k];
         sine = ( sine * 256) / (256);
        cosine = (cosine * 256) / (256);
        int xthing = y * sine + x * cosine >> 16;
        int ything = y * cosine - x * sine >> 16;
        rgbImage.drawSprite((((minimapIP.canvasWidth/2 - 5) + xthing) - rgbImage.w2 / 2) + 4, (minimapIP.canvasHeight/2-3) - ything - rgbImage.h2 / 2 - 4);
    }

    private void drawMinimap() {
        minimapIP.initDrawingArea();
        Graphics2D.resetImage();
        int i = xCameraCurve & 0x7ff;
        int j = 128+xCameraPos / 32;
        int l2 = (786-128) - yCameraPos / 32;
        l2 -= 4*4;
        minimapImage.rotate(j, l2, minimapIP.canvasWidth, minimapIP.canvasHeight, xCameraCurve, 0, 0);
        compass.rotate(25, 25, 33, 33, xCameraCurve, 0, 0);
        for (int j5 = 0; j5 < numOfMapMarkers; j5++) {
            int mapX = (markPosX[j5] * 4 + 2) - xCameraPos / 32;
            int mapY = (markPosY[j5] * 4 + 2) - yCameraPos / 32;
            markMinimap(markGraphic[j5], mapX, mapY);
        }
        Graphics2D.fillRect(minimapIP.canvasWidth/2, minimapIP.canvasHeight/2, 3, 3, 0xffffff);
        if (minimapGraphics != null && editorMainWindow.getMapViewPanel().getGraphics() != null)
            minimapIP.drawGraphics(0,editorMainWindow.getMapViewPanel().getGraphics(),0);
        gameScreenCanvas.initDrawingArea();
    }

    private void drawScene() {
        int j = showAllHLs ? 3 : heightLevel;
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
        if (selectedTileX != -1)
               ShapedTile.drawShape(super.graphics,(byte) (mapRegion.getShapeA()[selectedTileY][selectedTileX][selectedTileZ]+1),mapRegion.getShapeB()[selectedTileY][selectedTileX][selectedTileZ]);
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

    private void processCameraInput() {
        if (mouseButtonDown == 2 && lastMouseX != -1){
            int mouseDeltaX = mouseEventX - lastMouseX;
            int mouseDeltaY = mouseEventY - lastMouseY;
            lastMouseX = mouseEventX;
            lastMouseY = mouseEventY;
            xCameraCurve -= mouseDeltaX;
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
            xCameraPos -= Rasterizer.SINE[xCameraCurve] >> 11;
            yCameraPos += Rasterizer.COSINE[xCameraCurve] >> 11;
            zCameraPos += Rasterizer.SINE[yCameraCurve] >> 11;
        }
        if (keyStatus['s'] == 1){
            xCameraPos += Rasterizer.SINE[xCameraCurve] >> 11;
            yCameraPos -= Rasterizer.COSINE[xCameraCurve] >> 11;
            zCameraPos -= Rasterizer.SINE[yCameraCurve] >> 11;
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
        lastResizeWidth = resizeWidth;
        lastResizeHeight = resizeHeight;
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

    @Override
    public void windowClosing(WindowEvent windowevent) {
        editorMainWindow.storeWorkspace();
    }

    @Override
    public void windowDeactivated(WindowEvent windowevent) {
        mouseButtonPressed = 0;
    }

    @Override
    public void windowOpened(WindowEvent windowevent) {
        editorMainWindow.loadWorkspace();
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

    public int getHeightLevel() {
        return heightLevel;
    }

    public void setShowAllHLs(boolean showAllHLs) {
        this.showAllHLs = showAllHLs;
    }

    public void setRenderSettings(int settings) {
        sceneGraph.initToNull();
        ObjectDef.memCache1.unlinkAll();
        ObjectDef.memCache2.unlinkAll();
        System.gc();
        for (int i = 0; i < 4; i++)
            tileSettings[i].init();
        refreshMap();
        for (int _x = 0;_x < mapWidth;_x++)
            for (int _z = 0;_z < mapHeight;_z++){
                int objectIdx = onDemandFetcher.getMapIndex(1,currentMapZ+_z,currentMapX+_x);
                if (objectIdx == -1)
                    continue;
                byte[] objectData = GZIPWrapper.decompress(jagexFileStores[4].decompress(objectIdx));
                if (objectData == null)
                    continue;
                mapRegion.loadObjects(_x*64,tileSettings,_z*64,sceneGraph,objectData);
            }
    }

    public void saveMap() {
        int x = currentMapX;
        int z = currentMapZ;
        for (int _x = 0;_x < mapWidth;_x++)
            for (int _z = 0;_z < mapHeight;_z++){
                int terrainIdx = onDemandFetcher.getMapIndex(0, z + _z, x + _x);
                Packet mapStorage = new Packet(new byte[131072]);//128KB should be enough
                mapRegion.writeMapRegion(_x * 64, _z * 64, mapStorage);
                byte[] terrainData = new byte[mapStorage.pos];
                System.arraycopy(mapStorage.data,0,terrainData,0,mapStorage.pos);
                terrainData = GZIPWrapper.compress(terrainData);
                jagexFileStores[4].put(terrainData.length,terrainData,terrainIdx);
            }
    }
}
