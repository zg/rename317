package rs2;

/*
 * 
 * Thanks to kshishkov on #libav-devel for the help with this 
 * 
 */
public class Filter
{

    private float decrementFactor(int i, int j, float f)
    {
        float ratio = (float)lowpassSamples[i][0][j] + f * (float)(lowpassSamples[i][1][j] - lowpassSamples[i][0][j]);
            ratio *= 0.001525879F;/* convert fixed- to floating-point: ratio * 100 / 65536 */
            return 1.0F - (float)Math.pow(10D, -ratio / 20F);/* convert from ratio in dB to a reduction factor */
            /* to calculate gain in dB we use L = 10 log A1^2/A0^2 = 20 log A1/A0
            since ratio is a loss in dB we use L = -ratio
            thus the amplitude ratio A1/A0 = 10^(L/20) = 10^(-ratio/20)
            so to calculate the decrement
            A0 - A1 = A0 * (A0 - A1)/A0 = A0 * (1 - A1/A0)
            so this provides the factor to calculate the decrement */
    }

    private float normalize(float octaves)
    {
    	/* the frequency for the C note is 32.7032 Hz
        octave is the number of octaves above note C our note is */
        float fNote = 32.7032F * (float)Math.pow(2D, octaves);/* convert from octaves to frequency based on C */
        /* f_s = 22050 Hz is our sampling frequency
        f_norm = f / f_s normalizes the frequency
        2 * pi * f_norm converts it to radians */
        return (fNote * 3.141593F) / 11025F;
        /* (f * pi) / (f_s / 2)
        = 2 * f * pi / f_s
        = 2 * pi * f / f_s
        = 2 * pi * f_norm
        this calculates the frequency denoted in octaves from C and normalizes it in radians
      */
        }

    private float method543(float f, int i, int j)
    {
        float f1 = (float)anIntArrayArrayArray666[j][0][i] + f * (float)(anIntArrayArrayArray666[j][1][i] - anIntArrayArrayArray666[j][0][i]);
        f1 *= 0.0001220703F;/* convert fixed- to floating-point: f1 / 8192 */
        return normalize(f1);
    }

    public int method544(int i, float smoothing)
    {
        if(i == 0)
        {
            float f1 = (float)anIntArray668[0] + (float)(anIntArray668[1] - anIntArray668[0]) * smoothing;
            f1 *= 0.003051758F;// some kind of transformer?
            attenuation = (float)Math.pow(0.10000000000000001D, f1 / 20F);
            attenuation16Bit = (int)(attenuation * 65536F);
        }
        if(anIntArray665[i] == 0)
            return 0;
        float f2 = decrementFactor(i, 0, smoothing);
        aFloatArrayArray669[i][0] = -2F * f2 * (float)Math.cos(method543(smoothing, 0, i));
        aFloatArrayArray669[i][1] = f2 * f2;
        for(int k = 1; k < anIntArray665[i]; k++)
        {
            float f3 = decrementFactor(i, k, smoothing);
            float f4 = -2F * f3 * (float)Math.cos(method543(smoothing, k, i));
            float f5 = f3 * f3;
            aFloatArrayArray669[i][k * 2 + 1] = aFloatArrayArray669[i][k * 2 - 1] * f5;
            aFloatArrayArray669[i][k * 2] = aFloatArrayArray669[i][k * 2 - 1] * f4 + aFloatArrayArray669[i][k * 2 - 2] * f5;
            for(int j1 = k * 2 - 1; j1 >= 2; j1--)
                aFloatArrayArray669[i][j1] += aFloatArrayArray669[i][j1 - 1] * f4 + aFloatArrayArray669[i][j1 - 2] * f5;

            aFloatArrayArray669[i][1] += aFloatArrayArray669[i][0] * f4 + f5;
            aFloatArrayArray669[i][0] += f4;
        }

        if(i == 0)
        {
            for(int l = 0; l < anIntArray665[0] * 2; l++)
                aFloatArrayArray669[0][l] *= attenuation;

        }
        for(int i1 = 0; i1 < anIntArray665[i] * 2; i1++)
            anIntArrayArray670[i][i1] = (int)(aFloatArrayArray669[i][i1] * 65536F);

        return anIntArray665[i] * 2;
    }

    public void method545(Packet stream, Envelope amplitudeEnvelope)
    {
        int i = stream.g1();
        anIntArray665[0] = i >> 4;
        anIntArray665[1] = i & 0xf;
        if(i != 0)
        {
            anIntArray668[0] = stream.g2();
            anIntArray668[1] = stream.g2();
            int j = stream.g1();
            for(int k = 0; k < 2; k++)
            {
                for(int l = 0; l < anIntArray665[k]; l++)
                {
                    anIntArrayArrayArray666[k][0][l] = stream.g2();
                    lowpassSamples[k][0][l] = stream.g2();
                }

            }

            for(int i1 = 0; i1 < 2; i1++)
            {
                for(int j1 = 0; j1 < anIntArray665[i1]; j1++)
                    if((j & 1 << i1 * 4 << j1) != 0)
                    {
                        anIntArrayArrayArray666[i1][1][j1] = stream.g2();
                        lowpassSamples[i1][1][j1] = stream.g2();
                    } else
                    {
                        anIntArrayArrayArray666[i1][1][j1] = anIntArrayArrayArray666[i1][0][j1];
                        lowpassSamples[i1][1][j1] = lowpassSamples[i1][0][j1];
                    }

            }

            if(j != 0 || anIntArray668[1] != anIntArray668[0])
                amplitudeEnvelope.decodeSegments(stream);
        } else
        {
            anIntArray668[0] = anIntArray668[1] = 0;
        }

    }

    public Filter()
    {
        anIntArray665 = new int[2];
        anIntArrayArrayArray666 = new int[2][2][4];
        lowpassSamples = new int[2][2][4];
        anIntArray668 = new int[2];
    }

    final int[] anIntArray665;
    private final int[][][] anIntArrayArrayArray666;
    private final int[][][] lowpassSamples;
    private final int[] anIntArray668;
    private static final float[][] aFloatArrayArray669 = new float[2][8];
    static final int[][] anIntArrayArray670 = new int[2][8];
    private static float attenuation;
    static int attenuation16Bit;

}
