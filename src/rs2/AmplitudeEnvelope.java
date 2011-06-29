package rs2;

public class AmplitudeEnvelope
{

    public void method325(Packet stream)
    {
        	form = stream.g1();
            anInt538 = stream.g4();
            anInt539 = stream.g4();
            readValues(stream);
    }

    public void readValues(Packet stream)
    {
        length = stream.g1();
        duration = new int[length];
        amplitudes = new int[length];
        for(int i = 0; i < length; i++)
        {
            duration[i] = stream.g2();
            amplitudes[i] = stream.g2();
        }

    }

    void resetValues()
    {
        updateTick = 0;
        pointer = 0;
        step = 0;
        amplitude = 0;
        tick = 0;
    }

    int currentAmplitude(int sampleCount)//linear interpolation method
    {
        if(tick >= updateTick)
        {
            amplitude = amplitudes[pointer++] << 15;
            if(pointer >= length)
                pointer = length - 1;
            updateTick = (int)(((double)duration[pointer] / 65536D) * (double)sampleCount);
            if(updateTick > tick)
                step = ((amplitudes[pointer] << 15) - amplitude) / (updateTick - tick);
        }
        amplitude += step;
        tick++;
        return amplitude - step >> 15;
    }

    public AmplitudeEnvelope()
    {
    }

    private int length;
    private int[] duration;
    private int[] amplitudes;
    int anInt538;//no idea
    int anInt539;//no idea
    int form;
    private int updateTick;
    private int pointer;
    private int step;
    private int amplitude;
    private int tick;
    public static int anInt546;
}
