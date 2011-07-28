package rs2;


public class ModelHeader
{

    public ModelHeader()
    {
    }

    public byte modelData[];
    public int modelVerticeCount;
    public int modelTriangleCount;
    public int modelTextureTriangleCount;
    public int vertexModOffset;
    public int vertexXOffset;
    public int vertexYOffset;
    public int vertexZOffset;
    public int vskinBasePos;
    public int triVPointOffset;
    public int triMeshLinkOffset;
    public int triColourOffset;
    public int drawTypeBasePos;
    public int facePriorityBasePos;
    public int alphaBasepos;
    public int tskinBasepos;
    public int textureInfoBasePos;
}
