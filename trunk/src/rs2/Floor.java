package rs2;

public class Floor {

    public static void unpackConfig(JagexArchive jagexArchive) {
        Packet stream = new Packet(jagexArchive.getDataForName("flo.dat"));
        int cacheSize = stream.g2();
        if (cache == null)
            cache = new Floor[cacheSize];
        for (int j = 0; j < cacheSize; j++) {
            if (cache[j] == null)
                cache[j] = new Floor();
            cache[j].readValues(stream);
        }
        if (Config.LOAD_HD_FLO)  {
            for (int id = 0; id < cacheSize; id++) {
                try {
                    cache[id].readValuesHD(new Packet(FileOperations.ReadFile("./hddata/flo/" + id + ".dat")));
                } catch (Exception e) {
                    System.err.println("[FloorData] Error: Could not load new engine values for floor type " + id);
                }
            }
            for (int id = 0; id < cacheSize; id++) {
                try {
                    cache[id].readValuesHD2(new Packet(FileOperations.ReadFile("./hddata/underlayflo/" + id + ".dat")));
                } catch (Exception e) {
                    System.err.println("[FloorData] Error: Could not load new engine values for underlay floor type " + id);
                }
            }
        }
    }

    public void readValuesHD2(Packet arg0) {
        while (true) {
            int opcode = arg0.g1();
            if (opcode == 0)
                return;
            else if (opcode == 1) {
                hdUlColour = arg0.g3();  //r3
                int i2 = hslColour;
                rgb2hls(hdUlColour);
                hdHslColour = hslColour;
                hslColour = i2;
            } else if (opcode == 2) {
                hdUlTexture = arg0.g2();    //2
                if ((hdUlTexture ^ 0xffffffff) == -65536)
                    hdUlTexture = -1;
            } else if (opcode == 3) {
                textureC = arg0.g2();   //2
            } else if (opcode == 4) {
                ;//occlude = false;
            } else {
                System.err.println("[FloorData] Error unrecognised new engine config code: " + opcode);
            }
        }
    }

    private void readValuesHD(Packet stream) {
        do {
            int opcode = stream.g1();
            if (opcode == 0)
                return;
            else if (opcode == 1) {
                int j = hue;
                int k = saturation;
                int l = lightness;
                int i1 = hue2;
                hdColour = stream.g3();
                int i2 = hslColour;
                rgb2hls(hdColour);
                hdOlHslColour = hslColour;
                hslColour = i2;
                hue = j;
                saturation = k;
                lightness = l;
                hue2 = i1;
                pCDivider = i1;
                //rgb2hls(colour2);
            } else if (opcode == 2) {
                texture = stream.g1();
            } else if (opcode == 3) //Replaced by texture_word in HD
            {
                hdTexture = stream.g2();
                if (hdTexture == 65535)
                    hdTexture = -1;
            } else if (opcode == 5)
                occlude = false;
            else if (opcode == 6)
                ;//name = stream.readString();
            else if (opcode == 7) {
                stream.g3();
            } else if (opcode == 8 || opcode == 10) {
                //Nothing
            } else if (opcode == 12)
                ;//val12 = false;
            else if (opcode == 9) {
                stream.g2();
            } else if (opcode == 11) {
                stream.g1();
            } else if (opcode == 14)
                stream.g1();
            else if (opcode == 13) {
                stream.g3();
            } else {
                System.err.println("[FloorData] Error unrecognised new engine config code: " + opcode);
            }
        } while (true);
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
                name = stream.gstr();//name
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

    private Floor() {
        texture = -1;
        occlude = true;
    }

    public static Floor cache[];
    public int colour2;
    public int texture;
    public int textureC;
    public int hdTexture;
    public int hdUlTexture;
    public boolean occlude;
    public int hue;
    public int saturation;
    public int lightness;
    public int hue2;
    public int pCDivider;
    public int hslColour;
    public int hdColour = 0xff00ff;
    public int hdUlColour = 0xff00ff;
    public int hdHslColour = 0;
    public int hdOlHslColour = 0;
    public String name;
}
