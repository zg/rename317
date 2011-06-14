// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class IdentityKit {

    public static void unpackConfig(JagexArchive jagexArchive)
    {
        Packet stream = new Packet(jagexArchive.getDataForName("idk.dat"));
        length = stream.g2();
        if(cache == null)
            cache = new IdentityKit[length];
        for(int j = 0; j < length; j++)
        {
            if(cache[j] == null)
                cache[j] = new IdentityKit();
            cache[j].readValues(stream);
        }
    }

    private void readValues(Packet stream)
    {
        do
        {
            int opcode = stream.g1();
            if(opcode == 0)
                return;
            if(opcode == 1)
                body_part_id = stream.g1();
            else
            if(opcode == 2)
            {
                int model_count = stream.g1();
                body_model_ids = new int[model_count];
                for(int ptr = 0; ptr < model_count; ptr++)
                    body_model_ids[ptr] = stream.g2();

            } else
            if(opcode == 3)
                not_selectable = true;
            else
            if(opcode >= 40 && opcode < 50)
                recolour_original[opcode - 40] = stream.g2();
            else
            if(opcode >= 50 && opcode < 60)
                recolour_target[opcode - 50] = stream.g2();
            else
            if(opcode >= 60 && opcode < 70)
                head_model_ids[opcode - 60] = stream.g2();
            else
                System.out.println("Error unrecognised config code: " + opcode);
        } while(true);
    }

    public boolean isBodyDownloaded()
    {
        if(body_model_ids == null)
            return true;
        boolean is_downloaded = true;
        for(int ptr = 0; ptr < body_model_ids.length; ptr++)
            if(!Model.isDownloaded(body_model_ids[ptr]))
                is_downloaded = false;

        return is_downloaded;
    }

    public Model getBodyModel()
    {
        if(body_model_ids == null)
            return null;
        Model sub_models[] = new Model[body_model_ids.length];
        for(int model_ptr = 0; model_ptr < body_model_ids.length; model_ptr++)
            sub_models[model_ptr] = Model.getModel(body_model_ids[model_ptr]);

        Model model;
        if(sub_models.length == 1)
            model = sub_models[0];
        else
            model = new Model(sub_models.length, sub_models);
        for(int colour_ptr = 0; colour_ptr < 6; colour_ptr++)
        {
            if(recolour_original[colour_ptr] == 0)
                break;
            model.recolour(recolour_original[colour_ptr], recolour_target[colour_ptr]);
        }

        return model;
    }

    public boolean isHeadDownloaded()
    {
        boolean is_downloaded = true;
        for(int ptr = 0; ptr < 5; ptr++)
            if(head_model_ids[ptr] != -1 && !Model.isDownloaded(head_model_ids[ptr]))
                is_downloaded = false;

        return is_downloaded;
    }

    public Model getHeadModel()
    {
        Model sub_models[] = new Model[5];
        int model_ptr = 0;
        for(int id_ptr = 0; id_ptr < 5; id_ptr++)
            if(head_model_ids[id_ptr] != -1)
                sub_models[model_ptr++] = Model.getModel(head_model_ids[id_ptr]);

        Model model = new Model(model_ptr, sub_models);
        for(int colour_ptr = 0; colour_ptr < 6; colour_ptr++)
        {
            if(recolour_original[colour_ptr] == 0)
                break;
            model.recolour(recolour_original[colour_ptr], recolour_target[colour_ptr]);
        }

        return model;
    }

    private IdentityKit()
    {
        body_part_id = -1;
        recolour_original = new int[6];
        recolour_target = new int[6];
        not_selectable = false;
    }

    public static int length;
    public static IdentityKit cache[];
    public int body_part_id;
    private int[] body_model_ids;
    private final int[] recolour_original;
    private final int[] recolour_target;
    private final int[] head_model_ids = {
        -1, -1, -1, -1, -1
    };
    public boolean not_selectable;
}
