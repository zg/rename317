package rs2;
public final class SpotAnim {

	public static void unpackConfig(JagexArchive jagexArchive) {
		// Packet stream = new Packet(jagexArchive.getDataForName("spotanim.dat"));
		Packet stream = new Packet(FileOperations.ReadFile("./cache/extras/spotanim.dat"));
		int length = stream.g2();
		if (cache == null)
			cache = new SpotAnim[length];
		for (int j = 0; j < length; j++) {
			if (cache[j] == null)
				cache[j] = new SpotAnim();
			cache[j].id = j;
			cache[j].readValues(stream);
		}
	}

	/*
	 * private void readValues(Packet stream)
	 * {
	 * do
	 * {
	 * int i = stream.g1();
	 * if(i == 0)
	 * return;
	 * if(i == 1)
	 * modelID = stream.g2();
	 * else
	 * if(i == 2)
	 * {
	 * animationID = stream.g2();
	 * if(Animation.anims != null)
	 * aAnimation_407 = Animation.anims[animationID];
	 * } else
	 * if(i == 4)
	 * resizeXY = stream.g2();
	 * else
	 * if(i == 5)
	 * resizeZ = stream.g2();
	 * else
	 * if(i == 6)
	 * rotation = stream.g2();
	 * else
	 * if(i == 7)
	 * modelBrightness = stream.g1();
	 * else
	 * if(i == 8)
	 * modelShadow = stream.g1();
	 * else
	 * if(i >= 40 && i < 50)
	 * originalModelColours[i - 40] = stream.g2();
	 * else
	 * if(i >= 50 && i < 60)
	 * modifiedModelColours[i - 50] = stream.g2();
	 * else
	 * System.out.println("Error unrecognised spotanim config code: " + i);
	 * } while(true);
	 * }
	 */
	private void readValues(Packet stream) {// new format type
		do {
			modelID = stream.g2();
			animationID = stream.g2();
			if (Animation.anims != null && animationID != 65535 && animationID != -1)
				aAnimation_407 = Animation.anims[animationID];
			resizeXY = stream.g1();
			resizeZ = stream.g1();
			int j = stream.g1();
			if (j != 0) {
				for (int k = 0; k < j; k++)
					originalModelColours[k] = stream.g2();
				for (int k = 0; k < j; k++)
					modifiedModelColours[k] = stream.g2();
			}
			break;
		} while (true);
	}

	public Model getModel() {
		Model model = (Model) aMRUNodes_415.get(id);
		if (model != null)
			return model;
		model = Model.getModel(modelID);
		if (model == null)
			return null;
		for (int i = 0; i < 6; i++)
			if (originalModelColours[0] != 0)
				model.recolour(originalModelColours[i], modifiedModelColours[i]);
		aMRUNodes_415.put(model, id);
		return model;
	}

	private SpotAnim() {
		animationID = -1;
		originalModelColours = new int[6];
		modifiedModelColours = new int[6];
		resizeXY = 128;
		resizeZ = 128;
	}
	public static SpotAnim cache[];
	private int id;
	private int modelID;
	private int animationID;
	public Animation aAnimation_407;
	private final int[] originalModelColours;
	private final int[] modifiedModelColours;
	public int resizeXY;
	public int resizeZ;
	public int rotation;
	public int modelBrightness;
	public int modelShadow;
	public static MRUNodes aMRUNodes_415 = new MRUNodes(30);
}
