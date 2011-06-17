package rs2;

public final class Animation {

    public static void unpackConfig(JagexArchive jagexArchive)
    {
//        rs2.Packet stream = new rs2.Packet(jagexArchive.getDataForName("seq.dat"));
Packet stream = new Packet(FileOperations.ReadFile("./extras/seq.dat"));
        int length = stream.g2();
System.out.println("Reading new animations... "+length+" new animations");
        if(anims == null)
            anims = new Animation[length];
        for(int j = 0; j < length; j++)
        {
            if(anims[j] == null)
                anims[j] = new Animation();
            anims[j].readValues(stream);
        }
    }

    public int getFrameLength(int i)
    {
        int j = frameLengths[i];
        if(j == 0)
        {
            AnimationFrame animationFrame = AnimationFrame.forID(frame2IDS[i]);
            if(animationFrame != null)
                j = frameLengths[i] = animationFrame.displayLength;
        }
        if(j == 0)
            j = 1;
        return j;
    }

    private void readValues(Packet stream)
    {
        	do {
			anInt360 = stream.g2();
			if(anInt360 == 65535)
			   anInt360 = -1;
			anInt361 = stream.g2();
			if(anInt361 == 65535)
			   anInt361 = -1;
			anInt359 = stream.g1();
			anInt362 = stream.g1();
			anInt363 = stream.g1();
			priority = stream.g1();
		  	frameCount = stream.g2();
			frame2IDS = new int[frameCount];
			frame1IDS = new int[frameCount];
			frameLengths = new int[frameCount];
			for(int i=0; i < frameCount; i++)
			  frame2IDS[i] = stream.g4();
			for(int i=0; i < frameCount; i++)
			  frame1IDS[i] = -1;
			for(int i=0; i < frameCount; i++)
			  frameLengths[i] = stream.g1();
			break;
		} while(true);
    }


/*
    private void readValues(rs2.Packet stream)
    {
        do
        {
            int i = stream.g1();
            if(i == 0)
                break;
            if(i == 1)
            {
                frameCount = stream.g1();
                frame2IDS = new int[frameCount];
                frame1IDS = new int[frameCount];
                frameLengths = new int[frameCount];
                for(int j = 0; j < frameCount; j++)
                {
                    frame2IDS[j] = stream.g2();
                    frame1IDS[j] = stream.g2();
                    if(frame1IDS[j] == 65535)
                        frame1IDS[j] = -1;
                    frameLengths[j] = stream.g2();
                }

            } else
            if(i == 2)
                frameStep = stream.g2();
            else
            if(i == 3)
            {
                int k = stream.g1();
                animationFlowControl = new int[k + 1];
                for(int l = 0; l < k; l++)
                    animationFlowControl[l] = stream.g1();

                animationFlowControl[k] = 0x98967f;
            } else
            if(i == 4)
                aBoolean358 = true;
            else
            if(i == 5)
                anInt359 = stream.g1();
            else
            if(i == 6)
                anInt360 = stream.g2();
            else
            if(i == 7)
                anInt361 = stream.g2();
            else
            if(i == 8)
                anInt362 = stream.g1();
            else
            if(i == 9)
                anInt363 = stream.g1();
            else
            if(i == 10)
                priority = stream.g1();
            else
            if(i == 11)
                anInt365 = stream.g1();
            else
            if(i == 12)
                stream.g4();
            else
                System.out.println("Error unrecognised seq config code: " + i);
        } while(true);
        if(frameCount == 0)
        {
            frameCount = 1;
            frame2IDS = new int[1];
            frame2IDS[0] = -1;
            frame1IDS = new int[1];
            frame1IDS[0] = -1;
            frameLengths = new int[1];
            frameLengths[0] = -1;
        }
        if(anInt363 == -1)
            if(animationFlowControl != null)
                anInt363 = 2;
            else
                anInt363 = 0;
        if(priority == -1)
        {
            if(animationFlowControl != null)
            {
                priority = 2;
                return;
            }
            priority = 0;
        }
    }
*/

    private Animation()
    {
        frameStep = -1;
        aBoolean358 = false;
        anInt359 = 5;
        anInt360 = -1;
        anInt361 = -1;
        anInt362 = 99;
        anInt363 = -1;
        priority = -1;
        anInt365 = 2;
    }

    public static Animation anims[];
    public int frameCount;
    public int frame2IDS[];
    public int frame1IDS[];
    private int[] frameLengths;
    public int frameStep;
    public int animationFlowControl[];
    public boolean aBoolean358;
    public int anInt359;
    public int anInt360;
    public int anInt361;
    public int anInt362;
    public int anInt363;
    public int priority;
    public int anInt365;
    public static int anInt367;
}
