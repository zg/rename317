package rs2;


import rs2.util.collection.MemCache;

public class RSInterface
{

    public void swapInventoryItems(int firstSlot, int secondSlot)
    {
        int ammountofItem = inv[firstSlot];
        inv[firstSlot] = inv[secondSlot];
        inv[secondSlot] = ammountofItem;
        ammountofItem = invStackSizes[firstSlot];
        invStackSizes[firstSlot] = invStackSizes[secondSlot];
        invStackSizes[secondSlot] = ammountofItem;
    }

    public static void unpack(JagexArchive interfaceArchive, RSFont RSFonts[], JagexArchive mediaArchive)
    {
        spriteCache = new MemCache(50000);
        Packet interfaceData = new Packet(interfaceArchive.getDataForName("data"));
        int parentID = -1;
        int interfaceAmmount = interfaceData.g2();
        interfaceCache = new RSInterface[interfaceAmmount];
        while(interfaceData.pos < interfaceData.data.length)
        {
            int id = interfaceData.g2();
            if(id == 65535)
            {
                parentID = interfaceData.g2();
                id = interfaceData.g2();
            }
            RSInterface rsInterface = interfaceCache[id] = new RSInterface();
            rsInterface.id = id;
            rsInterface.parentID = parentID;
            rsInterface.type = interfaceData.g1();
            rsInterface.atActionType = interfaceData.g1();
            rsInterface.contentType = interfaceData.g2();
            rsInterface.width = interfaceData.g2();
            rsInterface.height = interfaceData.g2();
            rsInterface.alpha = (byte) interfaceData.g1();
            rsInterface.mouseOverPopupInterface = interfaceData.g1();
            if(rsInterface.mouseOverPopupInterface != 0)
                rsInterface.mouseOverPopupInterface = (rsInterface.mouseOverPopupInterface - 1 << 8) + interfaceData.g1();
            else
                rsInterface.mouseOverPopupInterface = -1;
            int conditionAmmount = interfaceData.g1();
            if(conditionAmmount > 0)
            {
                rsInterface.conditionType = new int[conditionAmmount];
                rsInterface.conditionValueToCompare = new int[conditionAmmount];
                for(int conditionPtr = 0; conditionPtr < conditionAmmount; conditionPtr++)
                {
                    rsInterface.conditionType[conditionPtr] = interfaceData.g1();
                    rsInterface.conditionValueToCompare[conditionPtr] = interfaceData.g2();
                }

            }
            int formulaAmmount = interfaceData.g1();
            if(formulaAmmount > 0)
            {
                rsInterface.dynamicValueFormulas = new int[formulaAmmount][];
                for(int formulaPtr = 0; formulaPtr < formulaAmmount; formulaPtr++)
                {
                    int subFormulaAmmount = interfaceData.g2();
                    rsInterface.dynamicValueFormulas[formulaPtr] = new int[subFormulaAmmount];
                    for(int subFormulaPtr = 0; subFormulaPtr < subFormulaAmmount; subFormulaPtr++)
                        rsInterface.dynamicValueFormulas[formulaPtr][subFormulaPtr] = interfaceData.g2();

                }

            }
            if(rsInterface.type == 0)
            {
                rsInterface.scrollMax = interfaceData.g2();
                rsInterface.hiddenUntilMouseover = interfaceData.g1() == 1;
                int childAmmount = interfaceData.g2();
                rsInterface.children = new int[childAmmount];
                rsInterface.childX = new int[childAmmount];
                rsInterface.childY = new int[childAmmount];
                for(int j3 = 0; j3 < childAmmount; j3++)
                {
                    rsInterface.children[j3] = interfaceData.g2();
                    rsInterface.childX[j3] = interfaceData.g2b();
                    rsInterface.childY[j3] = interfaceData.g2b();
                }

            }
            if(rsInterface.type == 1)
            {//no type ones in cache 317 or 377
            	interfaceData.g2();
                interfaceData.g1();
            }
            if(rsInterface.type == 2)
            {
                rsInterface.inv = new int[rsInterface.width * rsInterface.height];
                rsInterface.invStackSizes = new int[rsInterface.width * rsInterface.height];
                rsInterface.aBoolean259 = interfaceData.g1() == 1;
                rsInterface.isInventoryInterface = interfaceData.g1() == 1;
                rsInterface.usableItemInterface = interfaceData.g1() == 1;
                rsInterface.dragDeletes = interfaceData.g1() == 1;
                rsInterface.invSpritePadX = interfaceData.g1();
                rsInterface.invSpritePadY = interfaceData.g1();
                rsInterface.spritesX = new int[20];
                rsInterface.spritesY = new int[20];
                rsInterface.rgbImages = new RgbImage[20];
                for(int spritePtr = 0; spritePtr < 20; spritePtr++)
                {
                    int hasImage = interfaceData.g1();
                    if(hasImage == 1)
                    {
                        rsInterface.spritesX[spritePtr] = interfaceData.g2b();
                        rsInterface.spritesY[spritePtr] = interfaceData.g2b();
                        String imageName = interfaceData.gstr();
                        if(mediaArchive != null && imageName.length() > 0)
                        {
                            int imageID = imageName.lastIndexOf(",");
                            rsInterface.rgbImages[spritePtr] = getSprite(Integer.parseInt(imageName.substring(imageID + 1)), mediaArchive, imageName.substring(0, imageID));
                        }
                    }
                }

                rsInterface.actions = new String[5];
                for(int actionPtr = 0; actionPtr < 5; actionPtr++)
                {
                    rsInterface.actions[actionPtr] = interfaceData.gstr();
                    if(rsInterface.actions[actionPtr].length() == 0)
                        rsInterface.actions[actionPtr] = null;
                }

            }
            if(rsInterface.type == 3)
                rsInterface.filled = interfaceData.g1() == 1;
            if(rsInterface.type == 4 || rsInterface.type == 1)
            {
                rsInterface.textCentered = interfaceData.g1() == 1;
                int fontID = interfaceData.g1();
                if(RSFonts != null)
                    rsInterface.font = RSFonts[fontID];
                rsInterface.textShadow = interfaceData.g1() == 1;
            }
            if(rsInterface.type == 4)
            {
                rsInterface.textConditionFalse = interfaceData.gstr();
                rsInterface.textConditionTrue = interfaceData.gstr();
            }
            if(rsInterface.type == 1 || rsInterface.type == 3 || rsInterface.type == 4)
                rsInterface.colourConditionFalse = interfaceData.g4();
            if(rsInterface.type == 3 || rsInterface.type == 4)
            {
                rsInterface.colourConditionTrue = interfaceData.g4();
                rsInterface.colourConditionFalseMouseover = interfaceData.g4();
                rsInterface.colourConditionTrueMouseover = interfaceData.g4();
            }
            if(rsInterface.type == 5)
            {
                String imageName = interfaceData.gstr();
                if(mediaArchive != null && imageName.length() > 0)
                {
                    int imageID = imageName.lastIndexOf(",");
                    rsInterface.imageConditionFalse = getSprite(Integer.parseInt(imageName.substring(imageID + 1)), mediaArchive, imageName.substring(0, imageID));
                }
                imageName = interfaceData.gstr();
                if(mediaArchive != null && imageName.length() > 0)
                {
                    int imageID = imageName.lastIndexOf(",");
                    rsInterface.imageConditionTrue = getSprite(Integer.parseInt(imageName.substring(imageID + 1)), mediaArchive, imageName.substring(0, imageID));
                }
            }
            if(rsInterface.type == 6)
            {
                int mediaID = interfaceData.g1();
                if(mediaID != 0)
                {
                    rsInterface.mediaType = 1;
                    rsInterface.mediaID = (mediaID - 1 << 8) + interfaceData.g1();
                }
                mediaID = interfaceData.g1();
                if(mediaID != 0)
                {
                    rsInterface.enabledMediaType = 1;
                    rsInterface.enabledMediaID = (mediaID - 1 << 8) + interfaceData.g1();
                }
                mediaID = interfaceData.g1();
                if(mediaID != 0)
                    rsInterface.animationConditionFalse = (mediaID - 1 << 8) + interfaceData.g1();
                else
                    rsInterface.animationConditionFalse = -1;
                mediaID = interfaceData.g1();
                if(mediaID != 0)
                    rsInterface.animationConditionTrue = (mediaID - 1 << 8) + interfaceData.g1();
                else
                    rsInterface.animationConditionTrue = -1;
                rsInterface.zoom = interfaceData.g2();
                rsInterface.rotation1 = interfaceData.g2();
                rsInterface.rotation2 = interfaceData.g2();
            }
            if(rsInterface.type == 7)
            {
                rsInterface.inv = new int[rsInterface.width * rsInterface.height];
                rsInterface.invStackSizes = new int[rsInterface.width * rsInterface.height];
                rsInterface.textCentered = interfaceData.g1() == 1;
                int fontID = interfaceData.g1();
                if(RSFonts != null)
                    rsInterface.font = RSFonts[fontID];
                rsInterface.textShadow = interfaceData.g1() == 1;
                rsInterface.colourConditionFalse = interfaceData.g4();
                rsInterface.invSpritePadX = interfaceData.g2b();
                rsInterface.invSpritePadY = interfaceData.g2b();
                rsInterface.isInventoryInterface = interfaceData.g1() == 1;
                rsInterface.actions = new String[5];
                for(int k4 = 0; k4 < 5; k4++)
                {
                    rsInterface.actions[k4] = interfaceData.gstr();
                    if(rsInterface.actions[k4].length() == 0)
                        rsInterface.actions[k4] = null;
                }

            }
            if(rsInterface.atActionType == 2 || rsInterface.type == 2)
            {
                rsInterface.selectedActionName = interfaceData.gstr();
                rsInterface.spellName = interfaceData.gstr();
                rsInterface.spellUsableOn = interfaceData.g2();
            }

            if(rsInterface.type == 8)
			  rsInterface.textConditionFalse = interfaceData.gstr();

            if(rsInterface.atActionType == 1 || rsInterface.atActionType == 4 || rsInterface.atActionType == 5 || rsInterface.atActionType == 6)
            {
                rsInterface.tooltip = interfaceData.gstr();
                if(rsInterface.tooltip.length() == 0)
                {
                    if(rsInterface.atActionType == 1)
                        rsInterface.tooltip = "Ok";
                    if(rsInterface.atActionType == 4)
                        rsInterface.tooltip = "Select";
                    if(rsInterface.atActionType == 5)
                        rsInterface.tooltip = "Select";
                    if(rsInterface.atActionType == 6)
                        rsInterface.tooltip = "Continue";
                }
            }
	}
        spriteCache = null;
    }

    private Model getModel(int type, int id)
    {
        Model model = (Model) modelCache.get((type << 16) + id);
        if(model != null)
            return model;
        if(type == 1)
            model = Model.getModel(id);
        if(type == 2)
            model = NpcDef.forID(id).getHeadModel();
        if(type == 3)
            model = Client.sessionPlayer.getHeadModel();
        if(type == 4)
            model = ItemDef.forID(id).getInventoryModel(50);
        if(type == 5)
            model = null;
        if(model != null)
            modelCache.put(model, (type << 16) + id);
        return model;
    }

    private static RgbImage getSprite(int i, JagexArchive jagexArchive, String s)
    {
        long l = (TextClass.encodeSpriteName(s) << 8) + (long)i;
        RgbImage rgbImage = (RgbImage) spriteCache.get(l);
        if(rgbImage != null)
            return rgbImage;
        try
        {
            rgbImage = new RgbImage(jagexArchive, s, i);
            spriteCache.put(rgbImage, l);
        }
        catch(Exception _ex)
        {
            return null;
        }
        return rgbImage;
    }

    public static void setCustomModel(Model model)
    {
        int id = 0;//was parameter
        int type = 5;//was parameter
        modelCache.clear();
        if(model != null && type != 4)
            modelCache.put(model, (type << 16) + id);
    }

    public Model getAnimatedModel(int frame1ID, int frame2ID, boolean flag)
    {
        Model originalModel;
        if(flag)
            originalModel = getModel(enabledMediaType, enabledMediaID);
        else
            originalModel = getModel(mediaType, mediaID);
        if(originalModel == null)
            return null;
        if(frame2ID == -1 && frame1ID == -1 && originalModel.triangleColourOrTexture == null)
            return originalModel;
        Model animatedModel = new Model(true, Animation.isNullFrame(frame2ID) & Animation.isNullFrame(frame1ID), false, originalModel);
        if(frame2ID != -1 || frame1ID != -1)
            animatedModel.createBones();
        if(frame2ID != -1)
            animatedModel.applyTransform(frame2ID);
        if(frame1ID != -1)
            animatedModel.applyTransform(frame1ID);
        animatedModel.light(64, 768, -50, -10, -50, true);
            return animatedModel;
    }

    public RSInterface()
    {
    }

    public RgbImage imageConditionFalse;
    public int duration;
    public RgbImage rgbImages[];
    public static RSInterface interfaceCache[];
    public int conditionValueToCompare[];
    public int contentType;
    public int spritesX[];
    public int colourConditionFalseMouseover;
    public int atActionType;
    public String spellName;
    public int colourConditionTrue;
    public int width;
    public String tooltip;
    public String selectedActionName;
    public boolean textCentered;
    public int scrollPosition;
    public String actions[];
    public int dynamicValueFormulas[][];
    public boolean filled;
    public String textConditionTrue;
    public int mouseOverPopupInterface;
    public int invSpritePadX;
    public int colourConditionFalse;
    public int mediaType;
    public int mediaID;
    public boolean dragDeletes;
    public int parentID;
    public int spellUsableOn;
    private static MemCache spriteCache;
    public int colourConditionTrueMouseover;
    public int children[];
    public int childX[];
    public boolean usableItemInterface;
    public RSFont font;
    public int invSpritePadY;
    public int conditionType[];
    public int animFrame;
    public int spritesY[];
    public String textConditionFalse;
    public boolean isInventoryInterface;
    public int id;
    public int invStackSizes[];
    public int inv[];
    public byte alpha;
    private int enabledMediaType;
    private int enabledMediaID;
    public int animationConditionFalse;
    public int animationConditionTrue;
    public boolean aBoolean259;
    public RgbImage imageConditionTrue;
    public int scrollMax;
    public int type;
    public int xOffset;
    private static final MemCache modelCache = new MemCache(30);
    public int yOffset;
    public boolean hiddenUntilMouseover;
    public int height;
    public boolean textShadow;
    public int zoom;
    public int rotation1;
    public int rotation2;
    public int childY[];

}
