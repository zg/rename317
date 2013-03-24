package rs2;


import rs2.media.image.RgbImage;
import rs2.util.collection.MemCache;

public class ItemDef
{

    public static void clearCache()
    {
        model_cache = null;
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
        if(model_recolour_original != null)
        {
            for(int colourPtr = 0; colourPtr < model_recolour_original.length; colourPtr++)
                dialogueModel_.recolour(model_recolour_original[colourPtr], model_recolour_target[colourPtr]);

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
        if(model_recolour_original != null)
        {
            for(int colourPtr = 0; colourPtr < model_recolour_original.length; colourPtr++)
                primaryModel_.recolour(model_recolour_original[colourPtr], model_recolour_target[colourPtr]);

        }
        return primaryModel_;
    }

    private void setDefaults()
    {
        model_id = 0;
        name = null;
        description = null;
        model_recolour_original = null;
        model_recolour_target = null;
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
        stack_variant_id = null;
        stack_variant_size = null;
        unnoted_item_id = -1;
        noted_item_id = -1;
        model_scale_x = 128;
        model_scale_y = 128;
        model_scale_z = 128;
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
        if(itemDef.noted_item_id != -1)
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
        ItemDef itemDef = forID(noted_item_id);
        model_id = itemDef.model_id;
        modelZoom = itemDef.modelZoom;
        rotationY = itemDef.rotationY;
        rotationX = itemDef.rotationX;

        diagionalRotation = itemDef.diagionalRotation;
        modelOffset1 = itemDef.modelOffset1;
        modelOffset2 = itemDef.modelOffset2;
        model_recolour_original = itemDef.model_recolour_original;
        model_recolour_target = itemDef.model_recolour_target;
        ItemDef itemDef_1 = forID(unnoted_item_id);
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

    public static RgbImage getSprite(int item_id, int stackSize, int outline_colour)
    {
        if(outline_colour == 0)
        {
            RgbImage rgbImage = (RgbImage) rgbImageCache.get(item_id);
            if(rgbImage != null && rgbImage.library_height != stackSize && rgbImage.library_height != -1)
            {
                rgbImage.unlink();
                rgbImage = null;
            }
            if(rgbImage != null)
                return rgbImage;
        }
        ItemDef definition = forID(item_id);
        if(definition.stack_variant_id == null)
            stackSize = -1;
        if(stackSize > 1)
        {
            int stack_item_id = -1;
            for(int stackPtr = 0; stackPtr < 10; stackPtr++)
                if(stackSize >= definition.stack_variant_size[stackPtr] && definition.stack_variant_size[stackPtr] != 0)
                    stack_item_id = definition.stack_variant_id[stackPtr];

            if(stack_item_id != -1)
                definition = forID(stack_item_id);
        }
        Model model = definition.getModel(1);
        if(model == null)
            return null;
        RgbImage cert_image = null;
        if(definition.noted_item_id != -1)
        {
            cert_image = getSprite(definition.unnoted_item_id, 10, -1);
            if(cert_image == null)
                return null;
        }
        RgbImage sprite2 = new RgbImage(32, 32);
        int centerX = Rasterizer.center_x;
        int centerY = Rasterizer.center_y;
        int lineOffsets[] = Rasterizer.lineOffsets;
        int pixels[] = DrawingArea.pixels;
        int width = DrawingArea.width;
        int height = DrawingArea.height;
        int vp_left = DrawingArea.viewport_left;
        int vp_right = DrawingArea.viewport_right;
        int vp_top = DrawingArea.viewport_top;
        int vp_bottom = DrawingArea.viewport_bottom;
        Rasterizer.notTextured = false;
        DrawingArea.setTarget(32, 32, sprite2.image_pixels);
        DrawingArea.fillRect(0, 0, 32, 32, 0);
        Rasterizer.setDefaultBounds();
        int k3 = definition.modelZoom;
        if(outline_colour == -1)
            k3 = (int)((double)k3 * 1.5D);
        if(outline_colour > 0)
            k3 = (int)((double)k3 * 1.04D);
        int l3 = Rasterizer.SINE[definition.rotationY] * k3 >> 16;
        int i4 = Rasterizer.COSINE[definition.rotationY] * k3 >> 16;
        model.rendersingle(definition.rotationX, definition.diagionalRotation, definition.rotationY, definition.modelOffset1, l3 + model.modelHeight / 2 + definition.modelOffset2, i4 + definition.modelOffset2);
        for(int _x = 31; _x >= 0; _x--)
        {
            for(int _y = 31; _y >= 0; _y--)
                if(sprite2.image_pixels[_x + _y * 32] == 0)
                    if(_x > 0 && sprite2.image_pixels[(_x - 1) + _y * 32] > 1)
                        sprite2.image_pixels[_x + _y * 32] = 1;
                    else if(_y > 0 && sprite2.image_pixels[_x + (_y - 1) * 32] > 1)
                        sprite2.image_pixels[_x + _y * 32] = 1;
                    else if(_x < 31 && sprite2.image_pixels[_x + 1 + _y * 32] > 1)
                        sprite2.image_pixels[_x + _y * 32] = 1;
                    else if(_y < 31 && sprite2.image_pixels[_x + (_y + 1) * 32] > 1)
                        sprite2.image_pixels[_x + _y * 32] = 1;

        }

        if(outline_colour > 0)
        {
            for(int _x = 31; _x >= 0; _x--)
            {
                for(int _y = 31; _y >= 0; _y--)
                    if(sprite2.image_pixels[_x + _y * 32] == 0)
                        if(_x > 0 && sprite2.image_pixels[(_x - 1) + _y * 32] == 1)
                            sprite2.image_pixels[_x + _y * 32] = outline_colour;
                        else
                        if(_y > 0 && sprite2.image_pixels[_x + (_y - 1) * 32] == 1)
                            sprite2.image_pixels[_x + _y * 32] = outline_colour;
                        else
                        if(_x < 31 && sprite2.image_pixels[_x + 1 + _y * 32] == 1)
                            sprite2.image_pixels[_x + _y * 32] = outline_colour;
                        else
                        if(_y < 31 && sprite2.image_pixels[_x + (_y + 1) * 32] == 1)
                            sprite2.image_pixels[_x + _y * 32] = outline_colour;

            }

        } else if(outline_colour == 0)
        {
            for(int _x = 31; _x >= 0; _x--)
            {
                for(int _y = 31; _y >= 0; _y--)
                    if(sprite2.image_pixels[_x + _y * 32] == 0 && _x > 0 && _y > 0 && sprite2.image_pixels[(_x - 1) + (_y - 1) * 32] > 0)
                        sprite2.image_pixels[_x + _y * 32] = 0x302020;

            }

        }
        if(definition.noted_item_id != -1)
        {
            int old_w = cert_image.library_width;
            int old_h = cert_image.library_height;
            cert_image.library_width = 32;
            cert_image.library_height = 32;
            cert_image.draw_trans(0, 0);
            cert_image.library_width = old_w;
            cert_image.library_height = old_h;
        }
        if(outline_colour == 0)
            rgbImageCache.put(sprite2, item_id);
        DrawingArea.setTarget(width, height, pixels);
        DrawingArea.setClip(vp_left, vp_top, vp_right, vp_bottom);
        Rasterizer.center_x = centerX;
        Rasterizer.center_y = centerY;
        Rasterizer.lineOffsets = lineOffsets;
        Rasterizer.notTextured = true;
        if(definition.stackable)
            sprite2.library_width = 33;
        else
            sprite2.library_width = 32;
        sprite2.library_height = stackSize;
        return sprite2;
    }

    public Model getModel(int stack_size)
    {
        if(stack_variant_id != null && stack_size > 1)
        {
            int stack_item_id = -1;
            for(int k = 0; k < 10; k++)
                if(stack_size >= stack_variant_size[k] && stack_variant_size[k] != 0)
                    stack_item_id = stack_variant_id[k];

            if(stack_item_id != -1)
                return forID(stack_item_id).getModel(1);
        }
        Model model = (Model) model_cache.get(id);
        if(model != null)
            return model;
        model = Model.getModel(model_id);
        if(model == null)
            return null;
        if(model_scale_x != 128 || model_scale_y != 128 || model_scale_z != 128)
            model.scale(model_scale_x, model_scale_y, model_scale_z);
        if(model_recolour_original != null)
        {
            for(int colour_ptr = 0; colour_ptr < model_recolour_original.length; colour_ptr++)
                model.recolour(model_recolour_original[colour_ptr], model_recolour_target[colour_ptr]);

        }
        model.light(64 + lightModifier, 768 + shadowModifier, -50, -10, -50, true);
        model.oneSquareModel = true;
        model_cache.put(model, id);
        return model;
    }

    public Model getInventoryModel(int i)
    {
        if(stack_variant_id != null && i > 1)
        {
            int j = -1;
            for(int k = 0; k < 10; k++)
                if(i >= stack_variant_size[k] && stack_variant_size[k] != 0)
                    j = stack_variant_id[k];

            if(j != -1)
                return forID(j).getInventoryModel(1);
        }
        Model model = Model.getModel(model_id);
        if(model == null)
            return null;
        if(model_recolour_original != null)
        {
            for(int colourPtr = 0; colourPtr < model_recolour_original.length; colourPtr++)
                model.recolour(model_recolour_original[colourPtr], model_recolour_target[colourPtr]);

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
                model_id = stream.g2();
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
                model_recolour_original = new int[colours];
                model_recolour_target = new int[colours];
                for(int colourPtr = 0; colourPtr < colours; colourPtr++)
                {
                    model_recolour_original[colourPtr] = stream.g2();
                    model_recolour_target[colourPtr] = stream.g2();
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
                unnoted_item_id = stream.g2();
            else
            if(opCode == 98)
                noted_item_id = stream.g2();
            else
            if(opCode >= 100 && opCode < 110)
            {
                if(stack_variant_id == null)
                {
                    stack_variant_id = new int[10];
                    stack_variant_size = new int[10];
                }
                stack_variant_id[opCode - 100] = stream.g2();
                stack_variant_size[opCode - 100] = stream.g2();
            } else
            if(opCode == 110)
                model_scale_x = stream.g2();
            else
            if(opCode == 111)
                model_scale_y = stream.g2();
            else
            if(opCode == 112)
                model_scale_z = stream.g2();
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
    private int[] model_recolour_original;
    public int id;
    public static MemCache rgbImageCache = new MemCache(100);
    public static MemCache model_cache = new MemCache(50);
    private int[] model_recolour_target;
    public boolean membersObject;
    private int femaleEmblem;
    private int noted_item_id;
    private int femaleEquip2;
    private int maleEquip1;
    private int maleDialogueHat;
    private int model_scale_x;
    public String groundActions[];
    private int modelOffset1;
    public String name;
    private static ItemDef[] cache;
    private int femaleDialogueHat;
    private int model_id;
    private int maleDialogue;
    public boolean stackable;
    public byte description[];
    private int unnoted_item_id;
    private static int cacheIndex;
    public int modelZoom;
    public static boolean isMembers = true;
    private static Packet itemData;
    private int shadowModifier;
    private int maleEmblem;
    private int maleEquip2;
    public String actions[];
    public int rotationY;
    private int model_scale_z;
    private int model_scale_y;
    private int[] stack_variant_id;
    private int modelOffset2;
    private static int[] streamIndices;
    private int lightModifier;
    private int femaleDialogue;
    public int rotationX;
    private int femaleEquip1;
    private int[] stack_variant_size;
    public int team;
    public static int totalItems;
    private int diagionalRotation;
    private byte maleYOffset;
	public int lendID;
	public int lentItemID;
}
