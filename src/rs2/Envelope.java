package rs2;

public class Envelope
{

    public void decode(Packet stream)
    {
        	form = stream.g1();
            anInt538 = stream.g4();
            anInt539 = stream.g4();
            decodeSegments(stream);
    }

    public void decodeSegments(Packet stream)
    {
        segmentCount = stream.g1();
        segmentDuration = new int[segmentCount];
        segmentPeak = new int[segmentCount];
        for(int i = 0; i < segmentCount; i++)
        {
            segmentDuration[i] = stream.g2();
            segmentPeak[i] = stream.g2();
        }

    }

    void resetValues()
    {
        checkpoint = 0;
        segmentPtr = 0;
        step = 0;
        amplitude = 0;
        tick = 0;
    }

    int evaluate(int rate)//linear interpolation method
    {
        if(tick >= checkpoint)
        {
            amplitude = segmentPeak[segmentPtr++] << 15;
            if(segmentPtr >= segmentCount)
                segmentPtr = segmentCount - 1;
            checkpoint = (int)(((double)segmentDuration[segmentPtr] / 65536D) * (double)rate);
            if(checkpoint > tick)
                step = ((segmentPeak[segmentPtr] << 15) - amplitude) / (checkpoint - tick);
        }
        amplitude += step;
        tick++;
        return amplitude - step >> 15;
    }

    public Envelope()
    {
    }

    private int segmentCount;
    private int[] segmentDuration;
    private int[] segmentPeak;
    int anInt538;//no idea
    int anInt539;//no idea
    int form;
    private int checkpoint;
    private int segmentPtr;
    private int step;
    private int amplitude;
    private int tick;
    //public static int anInt546;
}
