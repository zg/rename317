package rs2;


import rs2.media.image.RgbImage;
import rs2.util.collection.MemCache;

public class RSInterface
{

    public void swapInventoryItems(int firstSlot, int secondSlot)
    {
        int item_amount = inv[firstSlot];
        inv[firstSlot] = inv[secondSlot];
        inv[secondSlot] = item_amount;
        item_amount = inv_amount[firstSlot];
        inv_amount[firstSlot] = inv_amount[secondSlot];
        inv_amount[secondSlot] = item_amount;
    }

    public static void unpack(JagexArchive interfaceArchive, RSFont fonts[], JagexArchive mediaArchive)
    {
        image_cache = new MemCache(50000);
        Packet interface_data = new Packet(interfaceArchive.getDataForName("data"));
        int parentID = -1;
        int interface_count = interface_data.g2();
        interfaces = new RSInterface[interface_count];
        while(interface_data.pos < interface_data.data.length)
        {
            int id = interface_data.g2();
            if(id == 65535)
            {
                parentID = interface_data.g2();
                id = interface_data.g2();
            }
            RSInterface inter = interfaces[id] = new RSInterface();
            inter.id = id;
            inter.parent_id = parentID;
            inter.type = interface_data.g1();
            inter.action_type = interface_data.g1();
            inter.contentType = interface_data.g2();
            inter.width = interface_data.g2();
            inter.height = interface_data.g2();
            inter.alpha = (byte) interface_data.g1();
            inter.mouseover_triggered_inter = interface_data.g1();
            if(inter.mouseover_triggered_inter != 0)
                inter.mouseover_triggered_inter = (inter.mouseover_triggered_inter - 1 << 8) + interface_data.g1();
            else
                inter.mouseover_triggered_inter = -1;
            int condition_count = interface_data.g1();
            if(condition_count > 0)
            {
                inter.condition_test = new int[condition_count];
                inter.condition_operand = new int[condition_count];
                for(int _ctr = 0; _ctr < condition_count; _ctr++)
                {
                    inter.condition_test[_ctr] = interface_data.g1();
                    inter.condition_operand[_ctr] = interface_data.g2();
                }

            }
            int formula_count = interface_data.g1();
            if(formula_count > 0)
            {
                inter.dynamic_value_formulas = new int[formula_count][];
                for(int formulaPtr = 0; formulaPtr < formula_count; formulaPtr++)
                {
                    int formula_length = interface_data.g2();
                    inter.dynamic_value_formulas[formulaPtr] = new int[formula_length];
                    for(int byte_ptr = 0; byte_ptr < formula_length; byte_ptr++)
                        inter.dynamic_value_formulas[formulaPtr][byte_ptr] = interface_data.g2();

                }

            }
            if(inter.type == 0)
            {
                inter.scroll_height = interface_data.g2();
                inter.mouseover_only = interface_data.g1() == 1;
                int child_count = interface_data.g2();
                inter.child_id = new int[child_count];
                inter.child_x = new int[child_count];
                inter.child_y = new int[child_count];
                for(int _ctr = 0; _ctr < child_count; _ctr++)
                {
                    inter.child_id[_ctr] = interface_data.g2();
                    inter.child_x[_ctr] = interface_data.g2b();
                    inter.child_y[_ctr] = interface_data.g2b();
                }
            }
            if(inter.type == 1)
            {//no type ones in cache 317 or 377
            	interface_data.g2();
                interface_data.g1();
            }
            if(inter.type == 2)
            {
                inter.inv = new int[inter.width * inter.height];
                inter.inv_amount = new int[inter.width * inter.height];
                inter.inv_swap_enabled = interface_data.g1() == 1;
                inter.is_player_inv = interface_data.g1() == 1;
                inter.has_use_option = interface_data.g1() == 1;
                inter.inv_drag_overwrite = interface_data.g1() == 1;
                inter.inv_column_padding = interface_data.g1();
                inter.inv_row_padding = interface_data.g1();
                inter.inv_image_offset_x = new int[20];
                inter.inv_image_offset_y = new int[20];
                inter.inv_filler_image = new RgbImage[20];
                for(int image_ptr = 0; image_ptr < 20; image_ptr++)
                {
                    int hasImage = interface_data.g1();
                    if(hasImage == 1)
                    {
                        inter.inv_image_offset_x[image_ptr] = interface_data.g2b();
                        inter.inv_image_offset_y[image_ptr] = interface_data.g2b();
                        String imageName = interface_data.gstr();
                        if(mediaArchive != null && imageName.length() > 0)
                        {
                            int image_id_offset = imageName.lastIndexOf(",");
                            inter.inv_filler_image[image_ptr] =
                                    getSprite(Integer.parseInt(imageName.substring(image_id_offset + 1)),
                                            mediaArchive, imageName.substring(0, image_id_offset));
                        }
                    }
                }

                inter.actions = new String[5];
                for(int action_ptr = 0; action_ptr < 5; action_ptr++)
                {
                    inter.actions[action_ptr] = interface_data.gstr();
                    if(inter.actions[action_ptr].length() == 0)
                        inter.actions[action_ptr] = null;
                }

            }
            if(inter.type == 3)
                inter.filled = interface_data.g1() == 1;
            if(inter.type == 4 || inter.type == 1)
            {
                inter.text_centered = interface_data.g1() == 1;
                int font_id = interface_data.g1();
                if(fonts != null)
                    inter.font = fonts[font_id];
                inter.text_shadow = interface_data.g1() == 1;
            }
            if(inter.type == 4)
            {
                inter.text_default = interface_data.gstr();
                inter.text_active = interface_data.gstr();
            }
            if(inter.type == 1 || inter.type == 3 || inter.type == 4)
                inter.colour_default = interface_data.g4();
            if(inter.type == 3 || inter.type == 4)
            {
                inter.colour_active = interface_data.g4();
                inter.colour_mouseover = interface_data.g4();
                inter.colour_active_mouseover = interface_data.g4();
            }
            if(inter.type == 5)
            {
                String image_name = interface_data.gstr();
                if(mediaArchive != null && image_name.length() > 0)
                {
                    int image_id_offset = image_name.lastIndexOf(",");
                    inter.image_default = getSprite(Integer.parseInt(image_name.substring(image_id_offset + 1)), mediaArchive, image_name.substring(0, image_id_offset));
                }
                image_name = interface_data.gstr();
                if(mediaArchive != null && image_name.length() > 0)
                {
                    int image_id_offset = image_name.lastIndexOf(",");
                    inter.image_active = getSprite(Integer.parseInt(image_name.substring(image_id_offset + 1)), mediaArchive, image_name.substring(0, image_id_offset));
                }
            }
            if(inter.type == 6)
            {
                int content_id = interface_data.g1();
                if(content_id != 0)
                {
                    inter.content_default_type = 1;
                    inter.content_default_id = (content_id - 1 << 8) + interface_data.g1();
                }
                content_id = interface_data.g1();
                if(content_id != 0)
                {
                    inter.content_active_type = 1;
                    inter.content_active_id = (content_id - 1 << 8) + interface_data.g1();
                }
                content_id = interface_data.g1();
                if(content_id != 0)
                    inter.animation_default = (content_id - 1 << 8) + interface_data.g1();
                else
                    inter.animation_default = -1;
                content_id = interface_data.g1();
                if(content_id != 0)
                    inter.animation_active = (content_id - 1 << 8) + interface_data.g1();
                else
                    inter.animation_active = -1;
                inter.zoom = interface_data.g2();
                inter.rotation1 = interface_data.g2();
                inter.rotation2 = interface_data.g2();
            }
            if(inter.type == 7)
            {
                inter.inv = new int[inter.width * inter.height];
                inter.inv_amount = new int[inter.width * inter.height];
                inter.text_centered = interface_data.g1() == 1;
                int font_id = interface_data.g1();
                if(fonts != null)
                    inter.font = fonts[font_id];
                inter.text_shadow = interface_data.g1() == 1;
                inter.colour_default = interface_data.g4();
                inter.inv_column_padding = interface_data.g2b();
                inter.inv_row_padding = interface_data.g2b();
                inter.is_player_inv = interface_data.g1() == 1;
                inter.actions = new String[5];
                for(int action_id = 0; action_id < 5; action_id++)
                {
                    inter.actions[action_id] = interface_data.gstr();
                    if(inter.actions[action_id].length() == 0)
                        inter.actions[action_id] = null;
                }

            }
            if(inter.action_type == 2 || inter.type == 2)
            {
                inter.action_name = interface_data.gstr();
                inter.spell_name = interface_data.gstr();
                inter.spell_target_mask = interface_data.g2();
            }

            if(inter.type == 8)
			  inter.text_default = interface_data.gstr();

            if(inter.action_type == 1 || inter.action_type == 4 || inter.action_type == 5 || inter.action_type == 6)
            {
                inter.tooltip = interface_data.gstr();
                if(inter.tooltip.length() == 0)
                {
                    if(inter.action_type == 1)
                        inter.tooltip = "Ok";
                    if(inter.action_type == 4)
                        inter.tooltip = "Select";
                    if(inter.action_type == 5)
                        inter.tooltip = "Select";
                    if(inter.action_type == 6)
                        inter.tooltip = "Continue";
                }
            }
	}
        image_cache = null;
    }

    private Model getModel(int type, int id)
    {
        Model model = (Model) model_cache.get((type << 16) + id);
        if(model != null)
            return model;
        if(type == 1)
            model = Model.getModel(id);
        if(type == 2)
            model = NpcDef.forID(id).getHeadModel();
        if(type == 3)
            model = Client.session_player.getHeadModel();
        if(type == 4)
            model = ItemDef.forID(id).getUnshadedModel(50);
        if(type == 5)
            model = null;
        if(model != null)
            model_cache.put(model, (type << 16) + id);
        return model;
    }

    private static RgbImage getSprite(int i, JagexArchive jagexArchive, String name)
    {
        long l = (TextClass.encodeSpriteName(name) << 8) + (long)i;
        RgbImage rgbImage = (RgbImage) image_cache.get(l);
        if(rgbImage != null)
            return rgbImage;
        try
        {
            rgbImage = new RgbImage(jagexArchive, name, i);
            image_cache.put(rgbImage, l);
        }
        catch(Exception _ex)
        {
            return null;
        }
        return rgbImage;
    }

    public static void setModel(Model model, int type, int id)
    {
        model_cache.clear();
        if(model != null && type != 4)
            model_cache.put(model, (type << 16) + id);
    }

    public Model getAnimatedModel(int frame1ID, int frame2ID, boolean active)
    {
        Model originalModel;
        if(active)
            originalModel = getModel(content_active_type, content_active_id);
        else
            originalModel = getModel(content_default_type, content_default_id);
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

    public RgbImage image_default;
    public int duration;
    public RgbImage inv_filler_image[];
    public static RSInterface interfaces[];
    public int condition_operand[];
    public int contentType;
    public int inv_image_offset_x[];
    public int colour_mouseover;
    public int action_type;
    public String spell_name;
    public int colour_active;
    public int width;
    public String tooltip;
    public String action_name;
    public boolean text_centered;
    public int scroll_y;
    public String actions[];
    public int dynamic_value_formulas[][];
    public boolean filled;
    public String text_active;
    public int mouseover_triggered_inter;
    public int inv_column_padding;
    public int colour_default;
    public int content_default_type;
    public int content_default_id;
    public boolean inv_drag_overwrite;
    public int parent_id;
    public int spell_target_mask;
    private static MemCache image_cache;
    public int colour_active_mouseover;
    public int child_id[];
    public int child_x[];
    public boolean has_use_option;
    public RSFont font;
    public int inv_row_padding;
    public int condition_test[];
    public int animFrame;
    public int inv_image_offset_y[];
    public String text_default;
    public boolean is_player_inv;
    public int id;
    public int inv_amount[];
    public int inv[];
    public byte alpha;
    private int content_active_type;
    private int content_active_id;
    public int animation_default;
    public int animation_active;
    public boolean inv_swap_enabled;
    public RgbImage image_active;
    public int scroll_height;
    public int type;
    public int offset_x;
    private static final MemCache model_cache = new MemCache(30);
    public int offset_y;
    public boolean mouseover_only;
    public int height;
    public boolean text_shadow;
    public int zoom;
    public int rotation1;
    public int rotation2;
    public int child_y[];

}
