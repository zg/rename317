package rs2;
public final class Flo {

	public static void unpackConfig(JagexArchive jagexArchive) {
		Packet stream = new Packet(jagexArchive.getDataForName("flo.dat"));
		int cacheSize = stream.g2();
		if (cache == null)
			cache = new Flo[cacheSize];
		for (int j = 0; j < cacheSize; j++) {
			if (cache[j] == null)
				cache[j] = new Flo();
			cache[j].readValues(stream);
		}
	}

	private void readValues(Packet stream) {
		do {
			int i = stream.g1();
			if (i == 0)
				return;
			else if (i == 1) {
				colour2 = stream.g3();
				rgb2hls(colour2);
			} else if (i == 2)
				texture = stream.g1();
			else if (i == 3) {
			} else if (i == 5)
				occlude = false;
			else if (i == 6)
				stream.gstr();// name
			else if (i == 7) {
				int j = hue;
				int k = saturation;
				int l = lightness;
				int i1 = hue2;
				int j1 = stream.g3();
				rgb2hls(j1);
				hue = j;
				saturation = k;
				lightness = l;
				hue2 = i1;
				pCDivider = i1;
			} else {
				System.out.println("Error unrecognised config code: " + i);
			}
		} while (true);
	}

	private void rgb2hls(int i) {
		double r = (double) (i >> 16 & 0xff) / 256D;
		double g = (double) (i >> 8 & 0xff) / 256D;
		double b = (double) (i & 0xff) / 256D;
		double cmin = r;
		if (g < cmin)
			cmin = g;
		if (b < cmin)
			cmin = b;
		double cmax = r;
		if (g > cmax)
			cmax = g;
		if (b > cmax)
			cmax = b;
		double hue = 0.0D;
		double saturation = 0.0D;
		double lightness = (cmin + cmax) / 2D;
		if (cmin != cmax) {
			if (lightness < 0.5D)
				saturation = (cmax - cmin) / (cmax + cmin);
			if (lightness >= 0.5D)
				saturation = (cmax - cmin) / (2D - cmax - cmin);
			if (r == cmax)
				hue = (g - b) / (cmax - cmin);
			else if (g == cmax)
				hue = 2D + (b - r) / (cmax - cmin);
			else if (b == cmax)
				hue = 4D + (r - g) / (cmax - cmin);
		}
		hue /= 6D;
		this.hue = (int) (hue * 256D);
		this.saturation = (int) (saturation * 256D);
		this.lightness = (int) (lightness * 256D);
		if (this.saturation < 0)
			this.saturation = 0;
		else if (this.saturation > 255)
			this.saturation = 255;
		if (this.lightness < 0)
			this.lightness = 0;
		else if (this.lightness > 255)
			this.lightness = 255;
		if (lightness > 0.5D)
			pCDivider = (int) ((1.0D - lightness) * saturation * 512D);
		else
			pCDivider = (int) (lightness * saturation * 512D);
		if (pCDivider < 1)
			pCDivider = 1;
		hue2 = (int) (hue * (double) pCDivider);
		int huerand = (this.hue + (int) (Math.random() * 16D)) - 8;
		if (huerand < 0)
			huerand = 0;
		else if (huerand > 255)
			huerand = 255;
		int satrand = (this.saturation + (int) (Math.random() * 48D)) - 24;
		if (satrand < 0)
			satrand = 0;
		else if (satrand > 255)
			satrand = 255;
		int lightrand = (this.lightness + (int) (Math.random() * 48D)) - 24;
		if (lightrand < 0)
			lightrand = 0;
		else if (lightrand > 255)
			lightrand = 255;
		hslColour = packHSL(huerand, satrand, lightrand);
	}

	private int packHSL(int hue, int saturation, int lightness) {
		if (lightness > 179)
			saturation /= 2;
		if (lightness > 192)
			saturation /= 2;
		if (lightness > 217)
			saturation /= 2;
		if (lightness > 243)
			saturation /= 2;
		return (hue / 4 << 10) + (saturation / 32 << 7) + lightness / 2;
	}

	private Flo() {
		texture = -1;
		occlude = true;
	}
	public static Flo cache[];
	public int colour2;
	public int texture;
	public boolean occlude;
	public int hue;
	public int saturation;
	public int lightness;
	public int hue2;
	public int pCDivider;
	public int hslColour;
}
