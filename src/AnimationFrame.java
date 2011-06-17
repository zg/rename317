
public final class AnimationFrame
{

	public static byte[] getData(int i1, int i2) {
		if(frameData == null)
		loadFrames();
		
		if(skinData == null)
		loadSkins();

		if (i1 == 0)
		{
			//return FileOperations.ReadFile("./extras/frames/" + i2 + ".dat");
			return frameData[i2];
		}
		else
		{
			//return FileOperations.ReadFile("./extras/skinlist/" + i2 + ".dat");
			return skinData[i2];
		}
	}
	public static void loadSkins()
	{
		System.out.println("Preloading Skins...");
		Packet stream = new Packet(FileOperations.ReadFile("./extras/Skins.dat"));

/*
Format
2byte numData
loop
2byte - fileID - could be removed realy
4byte - fileSize
ByteArray of fileSize -- gziped
repeat
*/

		int numSkins = stream.g2();
		skinData = new byte[numSkins][];

		for(int i = 0; i < numSkins; i++)
		{
			int fileID = stream.g2();
			int compressedSize = stream.g4();
			byte[] compressedData = stream.getData(new byte[compressedSize]);
			byte[] decompressedData = JavaUncompress.decompress(compressedData);
			skinData[fileID] = decompressedData;
		}
		System.out.println("preloaded "+numSkins+" skins");
	}

	public static void loadFrames()
	{
		System.out.println("Preloading Frames...");
		Packet stream = new Packet(FileOperations.ReadFile("./extras/Frames.dat"));

/*
Format
2byte - fileID - could be removed realy
4byte - fileSize
ByteArray of fileSize -- gziped
repeat
*/

		int numFrames = stream.g2();
		frameData = new byte[numFrames][];

		for(int i = 0; i < numFrames; i++)
		{
			int fileID = stream.g2();
			int compressedSize = stream.g4();
			byte[] compressedData = stream.getData(new byte[compressedSize]);
			byte[] decompressedData = JavaUncompress.decompress(compressedData);
			frameData[fileID] = decompressedData;
		}
		System.out.println("preloaded "+numFrames+" frames");

	}

    public static void method528(int i)
    {
//        aAnimationFrameArray635 = new AnimationFrame[i + 1];
//        aBooleanArray643 = new boolean[i + 1];
//        for(int j = 0; j < i + 1; j++)
//            aBooleanArray643[j] = true;
	aAnimationFrameArray635 = new AnimationFrame[3000][0];
    }

   public static void load(int file){
    try {
	    Packet stream = new Packet(getData(0, file));
        Packet stream1 = new Packet(getData(1, file));
		ModelTransform class18 = new ModelTransform(stream1);
        int k1 = stream.g2();
		aAnimationFrameArray635[file] = new AnimationFrame[k1];
	    int ai[] = new int[500];
        int ai1[] = new int[500];
        int ai2[] = new int[500];
        int ai3[] = new int[500];
        for(int l1 = 0; l1 < k1; l1++)
        {
            int i2 = stream.g2();
            AnimationFrame class36 = aAnimationFrameArray635[file][i2] = new AnimationFrame();
            class36.myModelTransform = class18;
            int j2 = stream.g1();
            int l2 = 0;
			int k2 = -1;
            for(int i3 = 0; i3 < j2; i3++)
            {
                int j3 = stream.g1();
	
                if(j3 > 0)
                {
                    if(class18.opcodes[i3] != 0)
                    {
                        for(int l3 = i3 - 1; l3 > k2; l3--)
                        {
                            if(class18.opcodes[l3] != 0)
                                continue;
                            ai[l2] = l3;
                            ai1[l2] = 0;
                            ai2[l2] = 0;
                            ai3[l2] = 0;
                            l2++;
                            break;
                        }

                    }
                    ai[l2] = i3;
                    short c = 0;
                    if(class18.opcodes[i3] == 3)
                        c = (short)128;

                    if((j3 & 1) != 0)
                        ai1[l2] = (short)stream.readShort2();
                    else
                        ai1[l2] = c;
                    if((j3 & 2) != 0)
                        ai2[l2] = stream.readShort2();
                    else
                        ai2[l2] = c;
                    if((j3 & 4) != 0)
                        ai3[l2] = stream.readShort2();
                    else
                        ai3[l2] = c;
                    k2 = i3;
                    l2++;
            	}
	}

            class36.anInt638 = l2;
            class36.opcodeLinkTable = new int[l2];
            class36.modifier1 = new int[l2];
            class36.modifier2 = new int[l2];
            class36.modifier3 = new int[l2];
            for(int k3 = 0; k3 < l2; k3++)
            {
                class36.opcodeLinkTable[k3] = ai[k3];
                class36.modifier1[k3] = ai1[k3];
                class36.modifier2[k3] = ai2[k3];
                class36.modifier3[k3] = ai3[k3];
            }

        }
      }catch(Exception exception) { }
    }

    public static void nullLoader()
    {
        aAnimationFrameArray635 = null;
    }

    public static AnimationFrame forID(int j)
    {
		if(aAnimationFrameArray635 == null)
		return null;
		String hex = Integer.toHexString(j);
		int file = Integer.parseInt(hex.substring(0,(hex.length()-4)), 16);
		int frame = Integer.parseInt(hex.substring((hex.length()-4)), 16);
		if(aAnimationFrameArray635[file].length == 0)
			load(file);
		return aAnimationFrameArray635[file][frame];

    }

    public static boolean method532(int i)
    {
        return i == -1;
    }

    private AnimationFrame()
    {

    }
	public static byte[][] frameData = null;
	public static byte[][] skinData = null;
    private static AnimationFrame[][] aAnimationFrameArray635;
    public int displayLength;
    public ModelTransform myModelTransform;
    public int anInt638;
    public int opcodeLinkTable[];
    public int modifier1[];
    public int modifier2[];
    public int modifier3[];
    //private static boolean[] aBooleanArray643;//never used

}
