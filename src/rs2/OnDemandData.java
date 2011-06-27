package rs2;


public class OnDemandData extends NodeSub {

    public OnDemandData()
    {
        incomplete = true;
    }

    public int dataType;
    public byte[] buffer;
    public int ID;
    boolean incomplete;
    int loopCycle;
}
