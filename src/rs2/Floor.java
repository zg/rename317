package rs2;

import java.awt.*;

public class Floor {

    private static final boolean WRITE_HD = false;

    public static void unpackConfig(JagexArchive jagexArchive) {
        Packet stream = new Packet(jagexArchive.getDataForName("flo.dat"));
        int cacheSize = stream.g2();
        if (cache == null)
            cache = new Floor[cacheSize];
        for (int j = 0; j < cacheSize; j++) {
            if (cache[j] == null)
                cache[j] = new Floor();
            cache[j].id = j;
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
                rgb2hls(hdUlColour, true);
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
            if (opcode == 0){
                    if (name != null && name.equals("water")) {
                        alpha = 170;
                        int j = hue;
                        int k = saturation;
                        int l = lightness;
                        int i1 = hue2;
                        hdColour = new Color(17, 27, 134).getRGB();
                        int i2 = hslColour;
                        rgb2hls(hdColour, true);
                        hdOlHslColour = hslColour;
                        hslColour = i2;
                        hue = j;
                        saturation = k;
                        lightness = l;
                        hue2 = i1;
                        pCDivider = i1;
                    }
                return;
            } else if (opcode == 1) {
                int j = hue;
                int k = saturation;
                int l = lightness;
                int i1 = hue2;
                hdColour = stream.g3();
                int i2 = hslColour;
                rgb2hls(hdColour, true);
                hdOlHslColour = hslColour;
                hslColour = i2;
                hue = j;
                saturation = k;
                lightness = l;
                hue2 = i1;
                pCDivider = i1;
                //rgb2hls(colour2);
            } else if (opcode == 2) {
                hdTexture = stream.g1();
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

            switch (i) {
                case 1:
                    colour2 = stream.g3();
                    rgb2hls(colour2, true);
                    break;
                case 2:
                    texture = stream.g1();
                    break;
                case 3:
                    break;
                case 5:
                    occlude = false;
                    break;
                case 6:
                    name = stream.gstr();//name
                    break;
                case 7:
                    int j = hue;
                    int k = saturation;
                    int l = lightness;
                    int i1 = hue2;
                    int j1 = stream.g3();
                    minimapColour = j1;
                    rgb2hls(j1, true);
                    hue = j;
                    saturation = k;
                    lightness = l;
                    hue2 = i1;
                    pCDivider = i1;
                    break;
                case 8:
                    j = hue;
                    k = saturation;
                    l = lightness;
                    i1 = hue2;
                    hdColour = stream.g3();
                    int i2 = hslColour;
                    rgb2hls(hdColour, true);
                    hdOlHslColour = hslColour;
                    hslColour = i2;
                    hue = j;
                    saturation = k;
                    lightness = l;
                    hue2 = i1;
                    pCDivider = i1;
                    break;
                case 9:
                    hdTexture = stream.g1() & 0xFF;
                    break;
                case 10:
                    hdTexture = stream.g2() & 0xFFFF;
                    if (hdTexture == 65535)
                        hdTexture = -1;
                case 11:
                    hdUlColour = stream.g3();  //r3
                    i2 = hslColour;
                    rgb2hls(hdUlColour, true);
                    hdHslColour = hslColour;
                    hslColour = i2;
                    break;
                case 12:
                    hdUlTexture = stream.g2();
                    if (hdUlTexture == 65535)
                        hdUlTexture = -1;
                    break;
                case 13:
                    alpha = stream.g1() & 0xFF;
                    break;
                case 0:
                    if (name != null && name.equals("water")) {
                        System.out.println(id);
                        alpha = 170;
                        j = hue;
                        k = saturation;
                        l = lightness;
                        i1 = hue2;
                        hdColour = new Color(8, 76, 168).getRGB();
                        i2 = hslColour;
                        rgb2hls(hdColour, true);
                        hdOlHslColour = hslColour;
                        hslColour = i2;
                        hue = j;
                        saturation = k;
                        lightness = l;
                        hue2 = i1;
                        pCDivider = i1;
                    }
                    return;
                default:
                    System.out.println("Error unrecognised config code: " + i);
                    break;
            }
        } while (true);
    }

    public void save(){

    }

    public void writeValues(Packet stream) {
        if (texture != -1){
            stream.p1(2);
            stream.p1(texture);
        }
        if (colour2 != 0){
            stream.p1(1);
            stream.p3(colour2);
        }
        if (!occlude)
            stream.p1(5);
        if (name != null) {
            stream.p1(6);
            stream.pjstr(name);
        }
        if (minimapColour != 0){
            stream.p1(7);
            stream.p3(minimapColour);
        }
        if (WRITE_HD){
            if (hdColour != 0){
                stream.p1(8);
                stream.p3(hdColour);
            }
            if (hdTexture != -1 && hdTexture < 255 ){
                stream.p1(9);
                stream.p1(hdTexture);
            } else if (hdTexture != -1){
                stream.p1(10);
                stream.p2(hdTexture);
            }
            if (hdUlColour != 0){
                stream.p1(11);
                stream.p3(hdUlColour);
            }
            if (hdUlTexture != -1){
                stream.p1(12);
                stream.p3(hdUlTexture);
            }
            if (alpha != 255){
                stream.p1(13);
                stream.p3(alpha);
            }
        }
    }

    public void rgb2hls(int i, boolean b2) {
        double r = (double) (i >> 16 & 0xff) / 256D;
        double g = (double) (i >> 8 & 0xff) / 256D;
        double b = (double) (i & 0xff) / 256D;
        int j = hue;
        int k = saturation;
        int l = lightness;
        int i1 = hue2;
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
        if (!b2){
            this.hue = j;
            this.saturation = k;
            this.lightness = l;
            this.hue2 = i1;
            this.pCDivider = i1;
        }
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
    public int hdTexture = -1;
    public int hdUlTexture = -1;
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
    public int minimapColour;
    public int id;

    /**Custom Fields Start Here**/
    public int alpha = 255;

    public Floor cloneFLO() {
        Floor flo2 = new Floor();
        flo2.colour2 = colour2;
        flo2.texture = texture;
        flo2.occlude = occlude;
        flo2.hdTexture = hdTexture;
        flo2.hdColour = hdColour;
        flo2.textureC  =textureC;
        flo2.hdUlColour = hdUlColour;
        flo2.hdUlTexture = hdUlTexture;
        flo2.minimapColour = minimapColour;
        flo2.name = name;
        flo2.id = id;
        return  flo2;
    }

    public void replace(Floor flo2){
        colour2 = flo2.colour2;
        texture = flo2.texture;
        occlude = flo2.occlude;
        hdTexture = flo2.hdTexture;
        hdColour = flo2.hdColour;
        textureC = flo2.textureC;
        hdUlColour = flo2.hdUlColour;
        hdUlTexture = flo2.hdUlTexture;
        minimapColour = flo2.minimapColour;
        name = flo2.name;

    }

    public static int addNew(Floor floor){
        Floor floors[] = new Floor[cache.length + 1];
        System.arraycopy(cache,0,floors,0,cache.length);
        floors[cache.length] = new Floor();
        floors[cache.length].replace(floor);
        floors[cache.length].id = cache.length;
        cache = floors;
        return cache.length - 1;
    }

}
