package rs2;


public class OnDemandData extends NodeSub {

    public OnDemandData()
    {
        incomplete = true;
    }

    int dataType;
    byte buffer[];
    int ID;
    boolean incomplete;
    int loopCycle;
}
