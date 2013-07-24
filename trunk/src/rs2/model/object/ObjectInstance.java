package rs2.model.object;


import rs2.*;
import rs2.model.entity.Entity;

public class ObjectInstance extends Entity {
                     //ObjectAnimation
    public Model getRotatedModel()
    {
        int anim = -1;
        if(sequence != null)
        {
            int k = Client.currentTime - next_frame_time;
            if(k > 100 && sequence.frameStep > 0)
                k = 100;
            while(k > sequence.getFrameLength(frame))
            {
                k -= sequence.getFrameLength(frame);
                frame++;
                if(frame < sequence.frameCount)
                    continue;
                frame -= sequence.frameStep;
                if(frame >= 0 && frame < sequence.frameCount)
                    continue;
                sequence = null;
                break;
            }
            next_frame_time = Client.currentTime - k;
            if(sequence != null)
                anim = sequence.frame2IDS[frame];
        }
        ObjectDef object_def;
        if(alternative_object_ids != null)
            object_def = get_active_definition();
        else
            object_def = ObjectDef.forID(object_id);
        if(object_def == null)
        {
            return null;
        } else
        {
            return object_def.generate_model(type, orientation, a_y, b_y, d_y, c_y, anim);
        }
    }

    private ObjectDef get_active_definition()
    {
        int alternative_ptr = -1;
        if(config_id_bitfield != -1)
        {
            VarBit variable_bit = VarBit.cache[config_id_bitfield];
            int var_ptr = variable_bit.variable;
            int lsb = variable_bit.leastSignificantBit;
            int msb = variable_bit.mostSignificantBit;
            int mask = StaticLogic.BITFIELD_MASK[msb - lsb];
            if (clientInstance == null)
                alternative_ptr = 0;
            else
                alternative_ptr = clientInstance.session_variables[var_ptr] >> lsb & mask;
        } else
        if(variable_id != -1)
            if (clientInstance == null)
                alternative_ptr = 0;
            else
                alternative_ptr = clientInstance.session_variables[variable_id];
        if(alternative_ptr < 0 || alternative_ptr >= alternative_object_ids.length || alternative_object_ids[alternative_ptr] == -1)
            return null;
        else
            return ObjectDef.forID(alternative_object_ids[alternative_ptr]);
    }

    public ObjectInstance(int object_id, int orientation, int type, int a_y, int b_y, int c_y, int d_y,
                          int sequence_id, boolean randomize)
    {
        this.object_id = object_id;
        this.type = type;
        this.orientation = orientation;
        this.a_y = a_y;
        this.b_y = b_y;
        this.d_y = d_y;
        this.c_y = c_y;
        if(sequence_id != -1)
        {
            sequence = Sequence.anims[sequence_id];
            frame = 0;
            next_frame_time = Client.currentTime;
            if(randomize && sequence.frameStep != -1)
            {
                frame = (int)(Math.random() * (double) sequence.frameCount);
                next_frame_time -= (int)(Math.random() * (double) sequence.getFrameLength(frame));
            }
        }
        ObjectDef object_def = ObjectDef.forID(this.object_id);
        config_id_bitfield = object_def.variable_id_bitfield;
        variable_id = object_def.variable_id;
        alternative_object_ids = object_def.alternative_ids;
    }

    private int frame;
    private final int[] alternative_object_ids;
    private final int config_id_bitfield;
    private final int variable_id;
    private final int a_y;
    private final int b_y;
    private final int d_y;
    private final int c_y;
    private Sequence sequence;
    private int next_frame_time;
    public static Client clientInstance;
    private final int object_id;
    private final int type;
    private final int orientation;
}
