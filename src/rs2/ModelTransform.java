package rs2;


public class ModelTransform
{

    public ModelTransform(Packet stream)
    {

        int length = stream.g1();
        opcodes = new int[length];
        skinList = new int[length][];
        for(int stepId = 0; stepId < length; stepId++)
            opcodes[stepId] = stream.g1();

        for(int stepId = 0; stepId < length; stepId++)
        {
            int stepSkinIdLength = stream.g1();
            skinList[stepId] = new int[stepSkinIdLength];
            for(int skinIDX = 0; skinIDX < stepSkinIdLength; skinIDX++)
                skinList[stepId][skinIDX] = stream.g1();

        }


    }

    public final int[] opcodes;
    public final int[][] skinList;
}
