package rs2.extras;

public class packFrames
{


public packFrames()
{
/*
Format
2byte - fileID
4byte - fileSize
ByteArray of fileSize -- gziped
repeat
*/
//Pack the frames as the svn hates lots of files
//2722 total frames + 0(1)

int numFrames = 2722;
int spaceNeeded = 0;
numFrames++;

System.out.println("Calucating space needed....");

byte[][] datacache = new byte[numFrames][];

for(int i = 0; i < numFrames; i++)
{
byte[] frameData; //= FileOperations.ReadFile("./frames/"+i+".dat");
frameData = CompressingFile.getCompressedData("./frames/"+i+".dat");
datacache[i] = frameData;
spaceNeeded += frameData.length + 6;
}
spaceNeeded +=2;
System.out.println("Space needed = "+spaceNeeded);

//old method. 43594115

Packet stream = new Packet(new byte[spaceNeeded]);
stream.p2(numFrames);
for(int i = 0; i < numFrames; i++)
{
//byte[] frameData = FileOperations.ReadFile("./frames/"+i+".dat");
byte[] frameData = datacache[i];

stream.p2(i);
stream.p4(frameData.length);
stream.writeBytes(frameData);
}
FileOperations.WriteFile("./Frames.dat", stream.data, stream.pos);
System.out.println("packed file size = "+stream.pos);

}

public static void main(String[] args)
{
new packFrames();
}

}