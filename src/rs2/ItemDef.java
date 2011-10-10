package rs2;


public class ItemDef
{

    public static void clearCache()
    {
        modelCache = null;
        rgbImageCache = null;
        streamIndices = null;
        cache = null;
        itemData = null;
    }

    public boolean isDownloaded(int j)
    {
        int k = maleDialogue;
        int l = maleDialogueHat;
        if(j == 1)
        {
            k = femaleDialogue;
            l = femaleDialogueHat;
        }
        if(k == -1)
            return true;
        boolean flag = true;
        if(!Model.isCached(k))
            flag = false;
        if(l != -1 && !Model.isCached(l))
            flag = false;
        return flag;
    }

    public static void unpackConfig(JagexArchive jagexArchive)
    {
        itemData = new Packet(jagexArchive.getDataForName("obj.dat"));
        Packet itemIndexData = new Packet(jagexArchive.getDataForName("obj.idx"));
        //itemData = new Packet(FileOperations.ReadFile(Signlink.findcachedir()+"obj.dat"));
        //Packet itemIndexData = new Packet(FileOperations.ReadFile(Signlink.findcachedir()+"obj.idx"));
        
        totalItems = itemIndexData.g2();
        streamIndices = new int[totalItems];
        int offset = 2;
        for(int itemPtr = 0; itemPtr < totalItems; itemPtr++)
        {
            streamIndices[itemPtr] = offset;
            offset += itemIndexData.g2();
        }

        cache = new ItemDef[10];
        for(int k = 0; k < 10; k++)
            cache[k] = new ItemDef();

    }

    public Model getHeadModel(int gender)
    {
        int dialogueModel = maleDialogue;
        int dialogueHatModel = maleDialogueHat;
        if(gender == 1)
        {
            dialogueModel = femaleDialogue;
            dialogueHatModel = femaleDialogueHat;
        }
        if(dialogueModel == -1)
            return null;
        Model dialogueModel_ = Model.getModel(dialogueModel);
        if(dialogueHatModel != -1)
        {
            Model hatModel_ = Model.getModel(dialogueHatModel);
            Model models[] = {
                    dialogueModel_, hatModel_
            };
            dialogueModel_ = new Model(2, models);
        }
        if(originalModelColours != null)
        {
            for(int colourPtr = 0; colourPtr < originalModelColours.length; colourPtr++)
                dialogueModel_.recolour(originalModelColours[colourPtr], modifiedModelColours[colourPtr]);

        }
        return dialogueModel_;
    }

    public boolean hasItemEquipped(int gender)
    {
        int primaryModel = maleEquip1;
        int secondaryModel = maleEquip2;
        int emblem = maleEmblem;
        if(gender == 1)
        {
            primaryModel = femaleEquip1;
            secondaryModel = femaleEquip2;
            emblem = femaleEmblem;
        }
        if(primaryModel == -1)
            return true;
        boolean isEquipped = true;
        if(!Model.isCached(primaryModel))
            isEquipped = false;
        if(secondaryModel != -1 && !Model.isCached(secondaryModel))
            isEquipped = false;
        if(emblem != -1 && !Model.isCached(emblem))
            isEquipped = false;
        return isEquipped;
    }

    public Model getModelEquipedForGender(int gender)
    {
        int primaryModel = maleEquip1;
        int secondaryModel = maleEquip2;
        int emblem = maleEmblem;
        if(gender == 1)
        {
            primaryModel = femaleEquip1;
            secondaryModel = femaleEquip2;
            emblem = femaleEmblem;
        }
        if(primaryModel == -1)
            return null;
        Model primaryModel_ = Model.getModel(primaryModel);
        if(secondaryModel != -1)
            if(emblem != -1)
            {
                Model secondaryModel_ = Model.getModel(secondaryModel);
                Model emblemModel = Model.getModel(emblem);
                Model models[] = {
                        primaryModel_, secondaryModel_, emblemModel
                };
                primaryModel_ = new Model(3, models);
            } else
            {
                Model model_2 = Model.getModel(secondaryModel);
                Model models[] = {
                        primaryModel_, model_2
                };
                primaryModel_ = new Model(2, models);
            }
        if(gender == 0 && maleYOffset != 0)
            primaryModel_.translate(0, maleYOffset, 0);
        if(gender == 1 && femaleYOffset != 0)
            primaryModel_.translate(0, femaleYOffset, 0);
        if(originalModelColours != null)
        {
            for(int colourPtr = 0; colourPtr < originalModelColours.length; colourPtr++)
                primaryModel_.recolour(originalModelColours[colourPtr], modifiedModelColours[colourPtr]);

        }
        return primaryModel_;
    }

    private void setDefaults()
    {
        modelID = 0;
        name = null;
        description = null;
        originalModelColours = null;
        modifiedModelColours = null;
        modelZoom = 2000;
        rotationY = 0;
        rotationX = 0;
        diagionalRotation = 0;
        modelOffset1 = 0;
        modelOffset2 = 0;
        stackable = false;
        value = 1;
        membersObject = false;
        groundActions = null;
        actions = null;
        maleEquip1 = -1;
        maleEquip2 = -1;
        maleYOffset = 0;
        femaleEquip1 = -1;
        femaleEquip2 = -1;
        femaleYOffset = 0;
        maleEmblem = -1;
        femaleEmblem = -1;
        maleDialogue = -1;
        maleDialogueHat = -1;
        femaleDialogue = -1;
        femaleDialogueHat = -1;
        stackIDs = null;
        stackAmounts = null;
        certID = -1;
        certTemplateID = -1;
        modelSizeX = 128;
        modelSizeY = 128;
        modelSizeZ = 128;
        lightModifier = 0;
        shadowModifier = 0;
        team = 0;
    }

    public static ItemDef forID(int itemID)
    {
    	if(itemID >= streamIndices.length)
    		return forID(1);
        for(int j = 0; j < 10; j++)
            if(cache[j].id == itemID)
                return cache[j];

        cacheIndex = (cacheIndex + 1) % 10;
        ItemDef itemDef = cache[cacheIndex];
        itemData.pos = streamIndices[itemID];
        itemDef.id = itemID;
        itemDef.setDefaults();
        itemDef.readValues(itemData);
        if(itemDef.certTemplateID != -1)
            itemDef.toNote();
        if(!isMembers && itemDef.membersObject)
        {
            itemDef.name = "Members Object";
            itemDef.description = "Login to a members' server to use this object.".getBytes();
            itemDef.groundActions = null;
            itemDef.actions = null;
            itemDef.team = 0;
        }
        return itemDef;
    }

    private void toNote()
    {
        ItemDef itemDef = forID(certTemplateID);
        modelID = itemDef.modelID;
        modelZoom = itemDef.modelZoom;
        rotationY = itemDef.rotationY;
        rotationX = itemDef.rotationX;

        diagionalRotation = itemDef.diagionalRotation;
        modelOffset1 = itemDef.modelOffset1;
        modelOffset2 = itemDef.modelOffset2;
        originalModelColours = itemDef.originalModelColours;
        modifiedModelColours = itemDef.modifiedModelColours;
        ItemDef itemDef_1 = forID(certID);
        name = itemDef_1.name;
        membersObject = itemDef_1.membersObject;
        value = itemDef_1.value;
        String s = "a";
        char c = itemDef_1.name.charAt(0);
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            s = "an";
        description = ("Swap this note at any bank for " + s + " " + itemDef_1.name + ".").getBytes();
        stackable = true;
    }

    public static RgbImage getSprite(int itemID, int stackSize, int k)
    {
        if(k == 0)
        {
            RgbImage rgbImage = (RgbImage) rgbImageCache.get(itemID);
            if(rgbImage != null && rgbImage.h2 != stackSize && rgbImage.h2 != -1)
            {
                rgbImage.unlink();
                rgbImage = null;
            }
            if(rgbImage != null)
                return rgbImage;
        }
        ItemDef definition = forID(itemID);
        if(definition.stackIDs == null)
            stackSize = -1;
        if(stackSize > 1)
        {
            int itemId = -1;
            for(int stackPtr = 0; stackPtr < 10; stackPtr++)
                if(stackSize >= definition.stackAmounts[stackPtr] && definition.stackAmounts[stackPtr] != 0)
                    itemId = definition.stackIDs[stackPtr];

            if(itemId != -1)
                definition = forID(itemId);
        }
        Model model = definition.getModelForAmmount(1);
        if(model == null)
            return null;
        RgbImage rgbImage = null;
        if(definition.certTemplateID != -1)
        {
            rgbImage = getSprite(definition.certID, 10, -1);
            if(rgbImage == null)
                return null;
        }
        RgbImage sprite2 = new RgbImage(32, 32);
        int centerX = Rasterizer.centerX;
        int centerY = Rasterizer.centerY;
        int lineOffsets[] = Rasterizer.lineOffsets;
        int pixels[] = DrawingArea.pixels;
        int width = DrawingArea.width;
        int height = DrawingArea.height;
        int topX = DrawingArea.topX;
        int width_ = DrawingArea.viewport_w;
        int topY = DrawingArea.topY;
        int height_ = DrawingArea.viewport_h;
        Rasterizer.notTextured = false;
        DrawingArea.setTarget(32, 32, sprite2.myPixels);
        DrawingArea.fillRect(0, 0, 32, 32, 0);
        Rasterizer.setDefaultBounds();
        int k3 = definition.modelZoom;
        if(k == -1)
            k3 = (int)((double)k3 * 1.5D);
        if(k > 0)
            k3 = (int)((double)k3 * 1.04D);
        int l3 = Rasterizer.SINE[definition.rotationY] * k3 >> 16;
        int i4 = Rasterizer.COSINE[definition.rotationY] * k3 >> 16;
        model.rendersingle(definition.rotationX, definition.diagionalRotation, definition.rotationY, definition.modelOffset1, l3 + model.modelHeight / 2 + definition.modelOffset2, i4 + definition.modelOffset2);
        for(int i5 = 31; i5 >= 0; i5--)
        {
            for(int j4 = 31; j4 >= 0; j4--)
                if(sprite2.myPixels[i5 + j4 * 32] == 0)
                    if(i5 > 0 && sprite2.myPixels[(i5 - 1) + j4 * 32] > 1)
                        sprite2.myPixels[i5 + j4 * 32] = 1;
                    else
                    if(j4 > 0 && sprite2.myPixels[i5 + (j4 - 1) * 32] > 1)
                        sprite2.myPixels[i5 + j4 * 32] = 1;
                    else
                    if(i5 < 31 && sprite2.myPixels[i5 + 1 + j4 * 32] > 1)
                        sprite2.myPixels[i5 + j4 * 32] = 1;
                    else
                    if(j4 < 31 && sprite2.myPixels[i5 + (j4 + 1) * 32] > 1)
                        sprite2.myPixels[i5 + j4 * 32] = 1;

        }

        if(k > 0)
        {
            for(int j5 = 31; j5 >= 0; j5--)
            {
                for(int k4 = 31; k4 >= 0; k4--)
                    if(sprite2.myPixels[j5 + k4 * 32] == 0)
                        if(j5 > 0 && sprite2.myPixels[(j5 - 1) + k4 * 32] == 1)
                            sprite2.myPixels[j5 + k4 * 32] = k;
                        else
                        if(k4 > 0 && sprite2.myPixels[j5 + (k4 - 1) * 32] == 1)
                            sprite2.myPixels[j5 + k4 * 32] = k;
                        else
                        if(j5 < 31 && sprite2.myPixels[j5 + 1 + k4 * 32] == 1)
                            sprite2.myPixels[j5 + k4 * 32] = k;
                        else
                        if(k4 < 31 && sprite2.myPixels[j5 + (k4 + 1) * 32] == 1)
                            sprite2.myPixels[j5 + k4 * 32] = k;

            }

        } else
        if(k == 0)
        {
            for(int k5 = 31; k5 >= 0; k5--)
            {
                for(int l4 = 31; l4 >= 0; l4--)
                    if(sprite2.myPixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0 && sprite2.myPixels[(k5 - 1) + (l4 - 1) * 32] > 0)
                        sprite2.myPixels[k5 + l4 * 32] = 0x302020;

            }

        }
        if(definition.certTemplateID != -1)
        {
            int l5 = rgbImage.w2;
            int j6 = rgbImage.h2;
            rgbImage.w2 = 32;
            rgbImage.h2 = 32;
            rgbImage.drawSprite(0, 0);
            rgbImage.w2 = l5;
            rgbImage.h2 = j6;
        }
        if(k == 0)
            rgbImageCache.put(sprite2, itemID);
        DrawingArea.setTarget(height, width, pixels);
        DrawingArea.setBounds(height_, topX, width_, topY);
        Rasterizer.centerX = centerX;
        Rasterizer.centerY = centerY;
        Rasterizer.lineOffsets = lineOffsets;
        Rasterizer.notTextured = true;
        if(definition.stackable)
            sprite2.w2 = 33;
        else
            sprite2.w2 = 32;
        sprite2.h2 = stackSize;
        return sprite2;
    }

    public Model getModelForAmmount(int i)
    {
        if(stackIDs != null && i > 1)
        {
            int j = -1;
            for(int k = 0; k < 10; k++)
                if(i >= stackAmounts[k] && stackAmounts[k] != 0)
                    j = stackIDs[k];

            if(j != -1)
                return forID(j).getModelForAmmount(1);
        }
        Model model = (Model) modelCache.get(id);
        if(model != null)
            return model;
        model = Model.getModel(modelID);
        if(model == null)
            return null;
        if(modelSizeX != 128 || modelSizeY != 128 || modelSizeZ != 128)
            model.scaleT(modelSizeX, modelSizeZ, modelSizeY);
        if(originalModelColours != null)
        {
            for(int colourPtr = 0; colourPtr < originalModelColours.length; colourPtr++)
                model.recolour(originalModelColours[colourPtr], modifiedModelColours[colourPtr]);

        }
        model.light(64 + lightModifier, 768 + shadowModifier, -50, -10, -50, true);
        model.oneSquareModel = true;
        modelCache.put(model, id);
        return model;
    }

    public Model getInventoryModel(int i)
    {
        if(stackIDs != null && i > 1)
        {
            int j = -1;
            for(int k = 0; k < 10; k++)
                if(i >= stackAmounts[k] && stackAmounts[k] != 0)
                    j = stackIDs[k];

            if(j != -1)
                return forID(j).getInventoryModel(1);
        }
        Model model = Model.getModel(modelID);
        if(model == null)
            return null;
        if(originalModelColours != null)
        {
            for(int colourPtr = 0; colourPtr < originalModelColours.length; colourPtr++)
                model.recolour(originalModelColours[colourPtr], modifiedModelColours[colourPtr]);

        }
        return model;
    }

    private void readValues(Packet stream)
    {
        do
        {
            int opCode = stream.g1();
            if(opCode == 0)
                return;
            if(opCode == 1)
                modelID = stream.g2();
            else
            if(opCode == 2)
                name = stream.gstr();
            else
            if(opCode == 3)
                description = stream.gstrbyte();
            else
            if(opCode == 4)
                modelZoom = stream.g2();
            else
            if(opCode == 5)
                rotationY = stream.g2();
            else
            if(opCode == 6)
                rotationX = stream.g2();
            else
            if(opCode == 7)
            {
                modelOffset1 = stream.g2();
                if(modelOffset1 > 32767)
                    modelOffset1 -= 0x10000;
            } else
            if(opCode == 8)
            {
                modelOffset2 = stream.g2();
                if(modelOffset2 > 32767)
                    modelOffset2 -= 0x10000;
            } else
            if(opCode == 10)
                stream.g2();
            else
            if(opCode == 11)
                stackable = true;
            else
            if(opCode == 12)
                value = stream.g4();
            else
            if(opCode == 16)
                membersObject = true;
            else
            if(opCode == 23)
            {
                maleEquip1 = stream.g2();
                maleYOffset = stream.g1b();
            } else
            if(opCode == 24)
                maleEquip2 = stream.g2();
            else
            if(opCode == 25)
            {
                femaleEquip1 = stream.g2();
                femaleYOffset = stream.g1b();
            } else
            if(opCode == 26)
                femaleEquip2 = stream.g2();
            else
            if(opCode >= 30 && opCode < 35)
            {
                if(groundActions == null)
                    groundActions = new String[5];
                groundActions[opCode - 30] = stream.gstr();
                if(groundActions[opCode - 30].equalsIgnoreCase("hidden"))
                    groundActions[opCode - 30] = null;
            } else
            if(opCode >= 35 && opCode < 40)
            {
                if(actions == null)
                    actions = new String[5];
                actions[opCode - 35] = stream.gstr();
            } else
            if(opCode == 40)
            {
                int colours = stream.g1();
                originalModelColours = new int[colours];
                modifiedModelColours = new int[colours];
                for(int colourPtr = 0; colourPtr < colours; colourPtr++)
                {
                    originalModelColours[colourPtr] = stream.g2();
                    modifiedModelColours[colourPtr] = stream.g2();
                }

            } else
            if(opCode == 78)
                maleEmblem = stream.g2();
            else
            if(opCode == 79)
                femaleEmblem = stream.g2();
            else
            if(opCode == 90)
                maleDialogue = stream.g2();
            else
            if(opCode == 91)
                femaleDialogue = stream.g2();
            else
            if(opCode == 92)
                maleDialogueHat = stream.g2();
            else
            if(opCode == 93)
                femaleDialogueHat = stream.g2();
            else
            if(opCode == 95)
                diagionalRotation = stream.g2();
            else
            if(opCode == 97)
                certID = stream.g2();
            else
            if(opCode == 98)
                certTemplateID = stream.g2();
            else
            if(opCode >= 100 && opCode < 110)
            {
                if(stackIDs == null)
                {
                    stackIDs = new int[10];
                    stackAmounts = new int[10];
                }
                stackIDs[opCode - 100] = stream.g2();
                stackAmounts[opCode - 100] = stream.g2();
            } else
            if(opCode == 110)
                modelSizeX = stream.g2();
            else
            if(opCode == 111)
                modelSizeY = stream.g2();
            else
            if(opCode == 112)
                modelSizeZ = stream.g2();
            else
            if(opCode == 113)
                lightModifier = stream.g1b();
            else
            if(opCode == 114)
                shadowModifier = stream.g1b() * 5;//shadowing?
            else
            if(opCode == 115)
                team = stream.g1();
			else if (opCode == 116)
				lendID = stream.g2();
			else if (opCode == 117)
				lentItemID = stream.g2();
        } while(true);
    }

    private ItemDef()
    {
        id = -1;
    }

    private byte femaleYOffset;
    public int value;
    private int[] originalModelColours;
    public int id;
    public static MemCache rgbImageCache = new MemCache(100);
    public static MemCache modelCache = new MemCache(50);
    private int[] modifiedModelColours;
    public boolean membersObject;
    private int femaleEmblem;
    private int certTemplateID;
    private int femaleEquip2;
    private int maleEquip1;
    private int maleDialogueHat;
    private int modelSizeX;
    public String groundActions[];
    private int modelOffset1;
    public String name;
    private static ItemDef[] cache;
    private int femaleDialogueHat;
    private int modelID;
    private int maleDialogue;
    public boolean stackable;
    public byte description[];
    private int certID;
    private static int cacheIndex;
    public int modelZoom;
    public static boolean isMembers = true;
    private static Packet itemData;
    private int shadowModifier;
    private int maleEmblem;
    private int maleEquip2;
    public String actions[];
    public int rotationY;
    private int modelSizeZ;
    private int modelSizeY;
    private int[] stackIDs;
    private int modelOffset2;
    private static int[] streamIndices;
    private int lightModifier;
    private int femaleDialogue;
    public int rotationX;
    private int femaleEquip1;
    private int[] stackAmounts;
    public int team;
    public static int totalItems;
    private int diagionalRotation;
    private byte maleYOffset;
	public int lendID;
	public int lentItemID;
}
