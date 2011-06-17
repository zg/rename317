package rs2;


public final class OnDemandData extends NodeSub {

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
