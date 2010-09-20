// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class RSInterface
{

    public void swapInventoryItems(int i, int j)
    {
        int k = inv[i];
        inv[i] = inv[j];
        inv[j] = k;
        k = invStackSizes[i];
        invStackSizes[i] = invStackSizes[j];
        invStackSizes[j] = k;
    }

    public static void unpack(JagexArchive jagexArchive, RSFont RSFonts[], JagexArchive jagexArchive_1)
    {
        aMRUNodes_238 = new MRUNodes(50000);
        Packet stream = new Packet(jagexArchive.getDataForName("data"));
        int i = -1;
        int j = stream.g2();
        interfaceCache = new RSInterface[j];
        while(stream.pos < stream.data.length)
        {
            int k = stream.g2();
            if(k == 65535)
            {
                i = stream.g2();
                k = stream.g2();
            }
            RSInterface rsInterface = interfaceCache[k] = new RSInterface();
            rsInterface.id = k;
            rsInterface.parentID = i;
            rsInterface.type = stream.g1();
            rsInterface.atActionType = stream.g1();
            rsInterface.content_type = stream.g2();
            rsInterface.width = stream.g2();
            rsInterface.height = stream.g2();
            rsInterface.aByte254 = (byte) stream.g1();
            rsInterface.anInt230 = stream.g1();
            if(rsInterface.anInt230 != 0)
                rsInterface.anInt230 = (rsInterface.anInt230 - 1 << 8) + stream.g1();
            else
                rsInterface.anInt230 = -1;
            int i1 = stream.g1();
            if(i1 > 0)
            {
                rsInterface.condition_type = new int[i1];
                rsInterface.condition_value_to_compare = new int[i1];
                for(int j1 = 0; j1 < i1; j1++)
                {
                    rsInterface.condition_type[j1] = stream.g1();
                    rsInterface.condition_value_to_compare[j1] = stream.g2();
                }

            }
            int k1 = stream.g1();
            if(k1 > 0)
            {
                rsInterface.dynamic_value_formulas = new int[k1][];
                for(int l1 = 0; l1 < k1; l1++)
                {
                    int i3 = stream.g2();
                    rsInterface.dynamic_value_formulas[l1] = new int[i3];
                    for(int l4 = 0; l4 < i3; l4++)
                        rsInterface.dynamic_value_formulas[l1][l4] = stream.g2();

                }

            }
            if(rsInterface.type == 0)
            {
                rsInterface.scrollMax = stream.g2();
                rsInterface.hidden_until_mouseover = stream.g1() == 1;
                int i2 = stream.g2();
                rsInterface.children = new int[i2];
                rsInterface.childX = new int[i2];
                rsInterface.childY = new int[i2];
                for(int j3 = 0; j3 < i2; j3++)
                {
                    rsInterface.children[j3] = stream.g2();
                    rsInterface.childX[j3] = stream.g2b();
                    rsInterface.childY[j3] = stream.g2b();
                }

            }
            if(rsInterface.type == 1)
            {
                stream.g2();
                stream.g1();
            }
            if(rsInterface.type == 2)
            {
                rsInterface.inv = new int[rsInterface.width * rsInterface.height];
                rsInterface.invStackSizes = new int[rsInterface.width * rsInterface.height];
                rsInterface.aBoolean259 = stream.g1() == 1;
                rsInterface.isInventoryInterface = stream.g1() == 1;
                rsInterface.usableItemInterface = stream.g1() == 1;
                rsInterface.aBoolean235 = stream.g1() == 1;
                rsInterface.invSpritePadX = stream.g1();
                rsInterface.invSpritePadY = stream.g1();
                rsInterface.spritesX = new int[20];
                rsInterface.spritesY = new int[20];
                rsInterface.rgbImages = new RgbImage[20];
                for(int j2 = 0; j2 < 20; j2++)
                {
                    int k3 = stream.g1();
                    if(k3 == 1)
                    {
                        rsInterface.spritesX[j2] = stream.g2b();
                        rsInterface.spritesY[j2] = stream.g2b();
                        String s1 = stream.gstr();
                        if(jagexArchive_1 != null && s1.length() > 0)
                        {
                            int i5 = s1.lastIndexOf(",");
                            rsInterface.rgbImages[j2] = method207(Integer.parseInt(s1.substring(i5 + 1)), jagexArchive_1, s1.substring(0, i5));
                        }
                    }
                }

                rsInterface.actions = new String[5];
                for(int l3 = 0; l3 < 5; l3++)
                {
                    rsInterface.actions[l3] = stream.gstr();
                    if(rsInterface.actions[l3].length() == 0)
                        rsInterface.actions[l3] = null;
                }

            }
            if(rsInterface.type == 3)
                rsInterface.filled = stream.g1() == 1;
            if(rsInterface.type == 4 || rsInterface.type == 1)
            {
                rsInterface.text_centered = stream.g1() == 1;
                int k2 = stream.g1();
                if(RSFonts != null)
                    rsInterface.font = RSFonts[k2];
                rsInterface.text_shadow = stream.g1() == 1;
            }
            if(rsInterface.type == 4)
            {
                rsInterface.text_conditionfalse = stream.gstr();
                rsInterface.text_conditiontrue = stream.gstr();
            }
            if(rsInterface.type == 1 || rsInterface.type == 3 || rsInterface.type == 4)
                rsInterface.colour_conditionfalse = stream.g4();
            if(rsInterface.type == 3 || rsInterface.type == 4)
            {
                rsInterface.colour_conditiontrue = stream.g4();
                rsInterface.colour_conditionfalse_mouseover = stream.g4();
                rsInterface.colour_conditiontrue_mouseover = stream.g4();
            }
            if(rsInterface.type == 5)
            {
                String s = stream.gstr();
                if(jagexArchive_1 != null && s.length() > 0)
                {
                    int i4 = s.lastIndexOf(",");
                    rsInterface.image_conditionfalse = method207(Integer.parseInt(s.substring(i4 + 1)), jagexArchive_1, s.substring(0, i4));
                }
                s = stream.gstr();
                if(jagexArchive_1 != null && s.length() > 0)
                {
                    int j4 = s.lastIndexOf(",");
                    rsInterface.image_conditiontrue = method207(Integer.parseInt(s.substring(j4 + 1)), jagexArchive_1, s.substring(0, j4));
                }
            }
            if(rsInterface.type == 6)
            {
                int l = stream.g1();
                if(l != 0)
                {
                    rsInterface.anInt233 = 1;
                    rsInterface.mediaID = (l - 1 << 8) + stream.g1();
                }
                l = stream.g1();
                if(l != 0)
                {
                    rsInterface.anInt255 = 1;
                    rsInterface.anInt256 = (l - 1 << 8) + stream.g1();
                }
                l = stream.g1();
                if(l != 0)
                    rsInterface.animation_conditionfalse = (l - 1 << 8) + stream.g1();
                else
                    rsInterface.animation_conditionfalse = -1;
                l = stream.g1();
                if(l != 0)
                    rsInterface.animation_conditiontrue = (l - 1 << 8) + stream.g1();
                else
                    rsInterface.animation_conditiontrue = -1;
                rsInterface.anInt269 = stream.g2();
                rsInterface.anInt270 = stream.g2();
                rsInterface.anInt271 = stream.g2();
            }
            if(rsInterface.type == 7)
            {
                rsInterface.inv = new int[rsInterface.width * rsInterface.height];
                rsInterface.invStackSizes = new int[rsInterface.width * rsInterface.height];
                rsInterface.text_centered = stream.g1() == 1;
                int l2 = stream.g1();
                if(RSFonts != null)
                    rsInterface.font = RSFonts[l2];
                rsInterface.text_shadow = stream.g1() == 1;
                rsInterface.colour_conditionfalse = stream.g4();
                rsInterface.invSpritePadX = stream.g2b();
                rsInterface.invSpritePadY = stream.g2b();
                rsInterface.isInventoryInterface = stream.g1() == 1;
                rsInterface.actions = new String[5];
                for(int k4 = 0; k4 < 5; k4++)
                {
                    rsInterface.actions[k4] = stream.gstr();
                    if(rsInterface.actions[k4].length() == 0)
                        rsInterface.actions[k4] = null;
                }

            }
            if(rsInterface.atActionType == 2 || rsInterface.type == 2)
            {
                rsInterface.selectedActionName = stream.gstr();
                rsInterface.spellName = stream.gstr();
                rsInterface.spellUsableOn = stream.g2();
            }

            if(rsInterface.type == 8)
			  rsInterface.text_conditionfalse = stream.gstr();

            if(rsInterface.atActionType == 1 || rsInterface.atActionType == 4 || rsInterface.atActionType == 5 || rsInterface.atActionType == 6)
            {
                rsInterface.tooltip = stream.gstr();
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
        
//aryan	Bot.notifyInterface(rsInterface);
	}
        aMRUNodes_238 = null;
    }

    private Model get_model(int type, int j)
    {
        Model model = (Model) model_cache.get((type << 16) + j);
        if(model != null)
            return model;
        if(type == 1)
            model = Model.getModel(j);
        if(type == 2)
            model = EntityDef.forID(j).get_head_model();
        if(type == 3)
            model = client.session_player.get_head_model();
        if(type == 4)
            model = ItemDef.forID(j).get_inventory_model(50);
        if(type == 5)
            model = null;
        if(model != null)
            model_cache.put(model, (type << 16) + j);
        return model;
    }

    private static RgbImage method207(int i, JagexArchive jagexArchive, String s)
    {
        long l = (TextClass.method585(s) << 8) + (long)i;
        RgbImage rgbImage = (RgbImage) aMRUNodes_238.get(l);
        if(rgbImage != null)
            return rgbImage;
        try
        {
            rgbImage = new RgbImage(jagexArchive, s, i);
            aMRUNodes_238.put(rgbImage, l);
        }
        catch(Exception _ex)
        {
            return null;
        }
        return rgbImage;
    }

    public static void set_custom_model(boolean flag, Model model)
    {
        int i = 0;//was parameter
        int j = 5;//was parameter
        if(flag)
            return;
        model_cache.unlinkAll();
        if(model != null && j != 4)
            model_cache.put(model, (j << 16) + i);
    }

    public Model method209(int j, int k, boolean flag)
    {
        Model model;
        if(flag)
            model = get_model(anInt255, anInt256);
        else
            model = get_model(anInt233, mediaID);
        if(model == null)
            return null;
        if(k == -1 && j == -1 && model.triangleColours == null)
            return model;
        Model model_1 = new Model(true, AnimationFrame.method532(k) & AnimationFrame.method532(j), false, model);
        if(k != -1 || j != -1)
            model_1.calcSkinning();
        if(k != -1)
            model_1.applyTransform(k);
        if(j != -1)
            model_1.applyTransform(j);
        model_1.preprocess(64, 768, -50, -10, -50, true);
            return model_1;
    }

    public RSInterface()
    {
    }

    public RgbImage image_conditionfalse;
    public int anInt208;
    public RgbImage rgbImages[];
    public static RSInterface interfaceCache[];
    public int condition_value_to_compare[];
    public int content_type;
    public int spritesX[];
    public int colour_conditionfalse_mouseover;
    public int atActionType;
    public String spellName;
    public int colour_conditiontrue;
    public int width;
    public String tooltip;
    public String selectedActionName;
    public boolean text_centered;
    public int scrollPosition;
    public String actions[];
    public int dynamic_value_formulas[][];
    public boolean filled;
    public String text_conditiontrue;
    public int anInt230;
    public int invSpritePadX;
    public int colour_conditionfalse;
    public int anInt233;
    public int mediaID;
    public boolean aBoolean235;
    public int parentID;
    public int spellUsableOn;
    private static MRUNodes aMRUNodes_238;
    public int colour_conditiontrue_mouseover;
    public int children[];
    public int childX[];
    public boolean usableItemInterface;
    public RSFont font;
    public int invSpritePadY;
    public int condition_type[];
    public int anim_frame;
    public int spritesY[];
    public String text_conditionfalse;
    public boolean isInventoryInterface;
    public int id;
    public int invStackSizes[];
    public int inv[];
    public byte aByte254;
    private int anInt255;
    private int anInt256;
    public int animation_conditionfalse;
    public int animation_conditiontrue;
    public boolean aBoolean259;
    public RgbImage image_conditiontrue;
    public int scrollMax;
    public int type;
    public int x_offset;
    private static final MRUNodes model_cache = new MRUNodes(30);
    public int y_offset;
    public boolean hidden_until_mouseover;
    public int height;
    public boolean text_shadow;
    public int anInt269;
    public int anInt270;
    public int anInt271;
    public int childY[];

}
