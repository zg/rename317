package rs2.config;


import rs2.*;
import rs2.media.image.RgbImage;
import rs2.util.collection.MemCache;

public class ItemDef
{

    public static void clearCache()
    {
        model_cache = null;
        image_cache = null;
        item_offsets = null;
        cache = null;
        item_data = null;
    }

    public static void unpackConfig(JagexArchive jagexArchive)
    {
        item_data = new Packet(jagexArchive.getDataForName("obj.dat"));
        Packet item_index = new Packet(jagexArchive.getDataForName("obj.idx"));
        item_count = item_index.g2();
        item_offsets = new int[item_count];
        int offset = 2;
        for(int _ctr = 0; _ctr < item_count; _ctr++)
        {
            item_offsets[_ctr] = offset;
            offset += item_index.g2();
        }
        cache = new ItemDef[10];
        for(int _ctr = 0; _ctr < 10; _ctr++)
            cache[_ctr] = new ItemDef();

    }

    public Model getChatEquipModel(int gender)
    {
        int dialogueModel    = equipped_model_male_dialogue_1;
        int dialogueHatModel = equipped_model_male_dialogue_2;
        if(gender == 1)
        {
            dialogueModel    = equipped_model_female_dialogue_1;
            dialogueHatModel = equipped_model_female_dialogue_2;
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

    public boolean isEquippedModelCached(int gender)
    {
        int primaryModel = equipped_model_male_1;
        int secondaryModel = equipped_model_male_2;
        int emblem = equipped_model_male_3;
        if(gender == 1)
        {
            primaryModel = equipped_model_female_1;
            secondaryModel = equipped_model_female_2;
            emblem = equipped_model_female_3;
        }
        if(primaryModel == -1)
            return true;
        boolean cached = true;
        if(!Model.isCached(primaryModel))
            cached = false;
        if(secondaryModel != -1 && !Model.isCached(secondaryModel))
            cached = false;
        if(emblem != -1 && !Model.isCached(emblem))
            cached = false;
        return cached;
    }

    public boolean isDialogueModelCached(int gender)
    {
        int model_1 = equipped_model_male_dialogue_1;
        int model_2 = equipped_model_male_dialogue_2;
        if(gender == 1)
        {
            model_1 = equipped_model_female_dialogue_1;
            model_2 = equipped_model_female_dialogue_2;
        }
        if(model_1 == -1)
            return true;
        boolean cached = true;
        if(!Model.isCached(model_1))
            cached = false;
        if(model_2 != -1 && !Model.isCached(model_2))
            cached = false;
        return cached;
    }

    public Model getEquippedModel(int gender)
    {
        int primaryModel = equipped_model_male_1;
        int secondaryModel = equipped_model_male_2;
        int emblem = equipped_model_male_3;
        if(gender == 1)
        {
            primaryModel = equipped_model_female_1;
            secondaryModel = equipped_model_female_2;
            emblem = equipped_model_female_3;
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
        if(gender == 0 && equipped_model_male_translation_y != 0)
            primaryModel_.translate(0, equipped_model_male_translation_y, 0);
        if(gender == 1 && equipped_model_female_translation_y != 0)
            primaryModel_.translate(0, equipped_model_female_translation_y, 0);
        if(model_recolour_original != null)
        {
            for(int colourPtr = 0; colourPtr < model_recolour_original.length; colourPtr++)
                primaryModel_.recolour(model_recolour_original[colourPtr], model_recolour_target[colourPtr]);

        }
        return primaryModel_;
    }

    private void setDefaults()
    {
        inventory_model = 0;
        name = null;
        description = null;
        model_recolour_original = null;
        model_recolour_target = null;
        rotation_length = 2000;
        rotation_x_world = 0;
        rotation_y = 0;
        rotation_z = 0;
        translate_x = 0;
        translate_yz = 0;
        stackable = false;
        value = 1;
        is_members_only = false;
        actions_dropped = null;
        actions = null;
        equipped_model_male_1 = -1;
        equipped_model_male_2 = -1;
        equipped_model_male_translation_y = 0;
        equipped_model_female_1 = -1;
        equipped_model_female_2 = -1;
        equipped_model_female_translation_y = 0;
        equipped_model_male_3 = -1;
        equipped_model_female_3 = -1;
        equipped_model_male_dialogue_1 = -1;
        equipped_model_male_dialogue_2 = -1;
        equipped_model_female_dialogue_1 = -1;
        equipped_model_female_dialogue_2 = -1;
        stack_variant_id = null;
        stack_variant_size = null;
        unnoted_item_id = -1;
        noted_item_id = -1;
        model_scale_x = 128;
        model_scale_y = 128;
        model_scale_z = 128;
        light_intensity = 0;
        light_mag = 0;
        team = 0;
    }

    public static ItemDef forID(int itemID)
    {
    	if(itemID >= item_offsets.length)
    		return forID(1);
        for(int _cnt = 0; _cnt < 10; _cnt++)
            if(cache[_cnt].id == itemID)
                return cache[_cnt];

        cacheIndex = (cacheIndex + 1) % 10;
        ItemDef itemDef = cache[cacheIndex];
        item_data.pos = item_offsets[itemID];
        itemDef.id = itemID;
        itemDef.setDefaults();
        itemDef.readValues(item_data);
        if(itemDef.noted_item_id != -1)
            itemDef.toNote();
        if(!enable_members_items && itemDef.is_members_only)
        {
            itemDef.name = "Members Object";
            itemDef.description = "Login to a members' server to use this object.".getBytes();
            itemDef.actions_dropped = null;
            itemDef.actions = null;
            itemDef.team = 0;
        }
        return itemDef;
    }

    private void toNote()
    {
        ItemDef itemDef = forID(noted_item_id);
        inventory_model = itemDef.inventory_model;
        rotation_length = itemDef.rotation_length;
        rotation_x_world = itemDef.rotation_x_world;
        rotation_y = itemDef.rotation_y;

        rotation_z = itemDef.rotation_z;
        translate_x = itemDef.translate_x;
        translate_yz = itemDef.translate_yz;
        model_recolour_original = itemDef.model_recolour_original;
        model_recolour_target = itemDef.model_recolour_target;
        ItemDef itemDef_1 = forID(unnoted_item_id);
        name = itemDef_1.name;
        is_members_only = itemDef_1.is_members_only;
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
            RgbImage rgbImage = (RgbImage) image_cache.get(item_id);
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
        int k3 = definition.rotation_length;
        if(outline_colour == -1)
            k3 = (int)((double)k3 * 1.5D);
        if(outline_colour > 0)
            k3 = (int)((double)k3 * 1.04D);
        int sine = Rasterizer.SINE[definition.rotation_x_world] * k3 >> 16;
        int cosine = Rasterizer.COSINE[definition.rotation_x_world] * k3 >> 16;
        model.rendersingle(0, definition.rotation_y, definition.rotation_z, definition.translate_x, sine + model.modelHeight / 2 + definition.translate_yz, cosine + definition.translate_yz, definition.rotation_x_world);
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
            image_cache.put(sprite2, item_id);
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
        model = Model.getModel(inventory_model);
        if(model == null)
            return null;
        if(model_scale_x != 128 || model_scale_y != 128 || model_scale_z != 128)
            model.scale(model_scale_x, model_scale_y, model_scale_z);
        if(model_recolour_original != null)
        {
            for(int colour_ptr = 0; colour_ptr < model_recolour_original.length; colour_ptr++)
                model.recolour(model_recolour_original[colour_ptr], model_recolour_target[colour_ptr]);

        }
        model.light(64 + light_intensity, 768 + light_mag, -50, -10, -50, true);
        model.fits_on_single_square = true;
        model_cache.put(model, id);
        return model;
    }

    public Model getUnshadedModel(int stack_size)
    {
        if(stack_variant_id != null && stack_size > 1)
        {
            int stack_item_id = -1;
            for(int _cnt = 0; _cnt < 10; _cnt++)
                if(stack_size >= stack_variant_size[_cnt] && stack_variant_size[_cnt] != 0)
                    stack_item_id = stack_variant_id[_cnt];

            if(stack_item_id != -1)
                return forID(stack_item_id).getUnshadedModel(1);
        }
        Model model = Model.getModel(inventory_model);
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
            int opcode = stream.g1();
            if(opcode == 0)
                return;
            if(opcode == 1)
                inventory_model = stream.g2();
            else
            if(opcode == 2)
                name = stream.gstr();
            else
            if(opcode == 3)
                description = stream.gstrbyte();
            else
            if(opcode == 4)
                rotation_length = stream.g2();
            else
            if(opcode == 5)
                rotation_x_world = stream.g2();
            else
            if(opcode == 6)
                rotation_y = stream.g2();
            else
            if(opcode == 7)
            {
                translate_x = stream.g2();
                if(translate_x > 32767)
                    translate_x -= 0x10000;
            } else
            if(opcode == 8)
            {
                translate_yz = stream.g2();
                if(translate_yz > 32767)
                    translate_yz -= 0x10000;
            } else
            if(opcode == 10)
                stream.g2();
            else
            if(opcode == 11)
                stackable = true;
            else
            if(opcode == 12)
                value = stream.g4();
            else
            if(opcode == 16)
                is_members_only = true;
            else
            if(opcode == 23)
            {
                equipped_model_male_1 = stream.g2();
                equipped_model_male_translation_y = stream.g1b();
            } else
            if(opcode == 24)
                equipped_model_male_2 = stream.g2();
            else
            if(opcode == 25)
            {
                equipped_model_female_1 = stream.g2();
                equipped_model_female_translation_y = stream.g1b();
            } else
            if(opcode == 26)
                equipped_model_female_2 = stream.g2();
            else
            if(opcode >= 30 && opcode < 35)
            {
                if(actions_dropped == null)
                    actions_dropped = new String[5];
                actions_dropped[opcode - 30] = stream.gstr();
                if(actions_dropped[opcode - 30].equalsIgnoreCase("hidden"))
                    actions_dropped[opcode - 30] = null;
            } else
            if(opcode >= 35 && opcode < 40)
            {
                if(actions == null)
                    actions = new String[5];
                actions[opcode - 35] = stream.gstr();
            } else
            if(opcode == 40)
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
            if(opcode == 78)
                equipped_model_male_3 = stream.g2();
            else
            if(opcode == 79)
                equipped_model_female_3 = stream.g2();
            else
            if(opcode == 90)
                equipped_model_male_dialogue_1 = stream.g2();
            else
            if(opcode == 91)
                equipped_model_female_dialogue_1 = stream.g2();
            else
            if(opcode == 92)
                equipped_model_male_dialogue_2 = stream.g2();
            else
            if(opcode == 93)
                equipped_model_female_dialogue_2 = stream.g2();
            else
            if(opcode == 95)
                rotation_z = stream.g2();
            else
            if(opcode == 97)
                unnoted_item_id = stream.g2();
            else
            if(opcode == 98)
                noted_item_id = stream.g2();
            else
            if(opcode >= 100 && opcode < 110)
            {
                if(stack_variant_id == null)
                {
                    stack_variant_id = new int[10];
                    stack_variant_size = new int[10];
                }
                stack_variant_id[opcode - 100] = stream.g2();
                stack_variant_size[opcode - 100] = stream.g2();
            } else
            if(opcode == 110)
                model_scale_x = stream.g2();
            else
            if(opcode == 111)
                model_scale_y = stream.g2();
            else
            if(opcode == 112)
                model_scale_z = stream.g2();
            else
            if(opcode == 113)
                light_intensity = stream.g1b();
            else
            if(opcode == 114)
                light_mag = stream.g1b() * 5;
            else if(opcode == 115)
                team = stream.g1();
			else if (opcode == 116)
				lendID = stream.g2();
			else if (opcode == 117)
				lentItemID = stream.g2();
        } while(true);
    }

    private ItemDef()
    {
        id = -1;
    }

    public static boolean enable_members_items = true;

    public static MemCache image_cache = new MemCache(100);
    public static MemCache model_cache = new MemCache(50);

    private static Packet item_data;
    private static int[] item_offsets;
    public static int item_count;

    private static ItemDef[] cache;
    private static int cacheIndex;

    public int id;

    public String name;
    public byte description[];

    public int value;
    public int team;
    public boolean stackable;
    public boolean is_members_only;

    public String actions[];
    public String actions_dropped[];

    private int noted_item_id;
    private int unnoted_item_id;

    private int[] model_recolour_original;
    private int[] model_recolour_target;

    private int equipped_model_male_1;
    private int equipped_model_male_2;
    private int equipped_model_male_3;
    private byte equipped_model_male_translation_y;

    private int equipped_model_female_1;
    private int equipped_model_female_2;
    private int equipped_model_female_3;
    private byte equipped_model_female_translation_y;

    private int equipped_model_male_dialogue_1;
    private int equipped_model_male_dialogue_2;
    private int equipped_model_female_dialogue_1;
    private int equipped_model_female_dialogue_2;

    private int inventory_model;

    private int light_intensity;
    private int light_mag;

    public int rotation_length;
    public int rotation_x_world;

    public int rotation_y;
    public int rotation_z;

    private int model_scale_x;
    private int model_scale_z;
    private int model_scale_y;
    private int translate_x;
    private int translate_yz;

    private int[] stack_variant_id;
    private int[] stack_variant_size;

	public int lendID;
	public int lentItemID;
}
