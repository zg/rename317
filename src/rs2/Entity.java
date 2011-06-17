package rs2;


//mobile -super_
public class Entity extends Animable {

    public final void setPos(int x, int y, boolean flag)//push
    {
        if(animation != -1 && Animation.anims[animation].priority == 1)
            animation = -1;
        if(!flag)
        {
            int dx = x - pathX[0];
            int dy = y - pathY[0];
            if(dx >= -8 && dx <= 8 && dy >= -8 && dy <= 8)
            {
                if(pathLength < 9)
                    pathLength++;
                for(int i1 = pathLength; i1 > 0; i1--)
                {
                    pathX[i1] = pathX[i1 - 1];
                    pathY[i1] = pathY[i1 - 1];
                    pathRun[i1] = pathRun[i1 - 1];
                }

                pathX[0] = x;
                pathY[0] = y;
                pathRun[0] = false;
                return;
            }
        }
        pathLength = 0;
        anInt1542 = 0;
        anInt1503 = 0;
        pathX[0] = x;
        pathY[0] = y;
        this.boundExtentX = pathX[0] * 128 + boundDim * 64;
        this.boundExtentY = pathY[0] * 128 + boundDim * 64;
    }

    public final void method446()
    {
        pathLength = 0;
        anInt1542 = 0;
    }

    public final void updateHitData(int j, int k, int l)
    {
        for(int i1 = 0; i1 < 4; i1++)
            if(hitsLoopCycle[i1] <= l)
            {
                hitArray[i1] = k;
                hitMarkTypes[i1] = j;
                hitsLoopCycle[i1] = l + 70;
                return;
            }
    }

    public final void move(boolean run, int dir)
    {
        int x = pathX[0];
        int y = pathY[0];
        if(dir == 0)
        {
            x--;
            y++;
        }
        if(dir == 1)
            y++;
        if(dir == 2)
        {
            x++;
            y++;
        }
        if(dir == 3)
            x--;
        if(dir == 4)
            x++;
        if(dir == 5)
        {
            x--;
            y--;
        }
        if(dir == 6)
            y--;
        if(dir == 7)
        {
            x++;
            y--;
        }
        if(animation != -1 && Animation.anims[animation].priority == 1)
            animation = -1;
        if(pathLength < 9)
            pathLength++;
        for(int l = pathLength; l > 0; l--)
        {
            pathX[l] = pathX[l - 1];
            pathY[l] = pathY[l - 1];
            pathRun[l] = pathRun[l - 1];
        }
            pathX[0] = x;
            pathY[0] = y;
            pathRun[0] = run;
    }

    public int entScreenX;
	public int entScreenY;
	public final int index = -1;
	public boolean isVisible()
    {
        return false;
    }

    Entity()
    {
        pathX = new int[10];
        pathY = new int[10];
        interactingEntity = -1;
        anInt1504 = 32;
        anInt1505 = -1;
        height = 200;
        anInt1511 = -1;
        anInt1512 = -1;
        hitArray = new int[4];
        hitMarkTypes = new int[4];
        hitsLoopCycle = new int[4];
        anInt1517 = -1;
        anInt1520 = -1;
        animation = -1;
        loopCycleStatus = -1000;
        textCycle = 100;
        boundDim = 1;
        aBoolean1541 = false;
        pathRun = new boolean[10];
        anInt1554 = -1;
        anInt1555 = -1;
        anInt1556 = -1;
        anInt1557 = -1;
    }

    public final int[] pathX;
    public final int[] pathY;
    public int interactingEntity;
    int anInt1503;
    int anInt1504;
    int anInt1505;
    public String textSpoken;
    public int height;
    public int turnDirection;
    int anInt1511;//idle?
    int anInt1512;//idleTurn?
    int anInt1513;//
    final int[] hitArray;
    final int[] hitMarkTypes;
    final int[] hitsLoopCycle;
    int anInt1517;
    int anInt1518;
    int anInt1519;
    int anInt1520;
    int anInt1521;
    int anInt1522;
    int anInt1523;
    int anInt1524;
    int pathLength;
    public int animation;
    int anInt1527;
    int anInt1528;
    int anInt1529;
    int anInt1530;
    int anInt1531;
    public int loopCycleStatus;
    public int currentHealth;
    public int maxHealth;
    int textCycle;
    int time;
    int anInt1538;
    int anInt1539;
    int boundDim;
    boolean aBoolean1541;
    int anInt1542;
    int anInt1543;
    int anInt1544;
    int anInt1545;
    int anInt1546;
    int anInt1547;
    int anInt1548;
    int anInt1549;
    public int boundExtentX;
    public int boundExtentY;
    int anInt1552;
    final boolean[] pathRun;
    int anInt1554;//walk?
    int anInt1555;//turn180?
    int anInt1556;//turn90clockwise?
    int anInt1557;//turn90counterclockwise?
}
