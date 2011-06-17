package rs2.extras;

public class packSkins
{


	public packSkins()
	{
	/*
	Format
	2byte - fileID
	4byte - fileSize
	ByteArray of fileSize -- gziped
	repeat
	*/
	//Pack the frames as the svn hates lots of files
	//2722 total skins

	int numSkins = 2722;
	int spaceNeeded = 0;
	numSkins++;

	System.out.println("Calucating space needed....");

	byte[][] datacache = new byte[numSkins][];

	for(int i = 0; i < numSkins; i++)
	{
		byte[] frameData;
		frameData = CompressingFile.getCompressedData("./skinlist/"+i+".dat");
		datacache[i] = frameData;
		spaceNeeded += frameData.length + 6;
	}
	spaceNeeded +=2;
	System.out.println("Space needed = "+spaceNeeded);

	Packet stream = new Packet(new byte[spaceNeeded]);
	stream.p2(numSkins);
	for(int i = 0; i < numSkins; i++)
	{
		byte[] frameData = datacache[i];

		stream.p2(i);
		stream.p4(frameData.length);
		stream.writeBytes(frameData);
	}
	FileOperations.WriteFile("./Skins.dat", stream.data, stream.pos);
	System.out.println("packed file size = "+stream.pos);

}

public static void main(String[] args)
{
new packSkins();
}

}