package rt4;

import org.lwjgl.opengl.GL11;
import org.peterbjornx.pgl2.texture.Texture2D;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/20/11
 * Time: 12:13 AM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class TextureSource {

    private static Texture2D[] textures = new Texture2D[50];

    public static Texture2D getTexture(int id) {
        return new Texture2D("./hddata/texture/" + id + ".png");
    }
    public static void bindtexture(int texture) {
            if (texture == -1)
                GL11.glDisable(GL11.GL_TEXTURE_2D);
            else {
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                textures[texture].bind();
            }

    }
    static {
        for (int i = 0;i < 50;i++)
            textures[i] = getTexture(i);
    }
}
