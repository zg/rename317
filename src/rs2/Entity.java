package rs2;

public class Entity extends NodeSub {

    public void renderAtPoint(int i, int j, int k, int l, int i1, int j1, int k1,
            int l1, int i2)
    {
        Model model = getRotatedModel();
        if(model != null)
        {
            modelHeight = model.modelHeight;
            model.renderAtPoint(i, j, k, l, i1, j1, k1, l1, i2);
        }
    }

    Model getRotatedModel()
    {
        return null;
    }

    Entity()
    {
        modelHeight = 1000;
    }

    public VertexNormal[] vertexNormal;
    public int modelHeight;
}
