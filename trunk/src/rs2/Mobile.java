package rs2;


import rs2.model.entity.Entity;

//mobile -super_
public class Mobile extends Entity {

    public final void setPos(int x, int y, boolean flag)//push
    {
        if(animation != -1 && Sequence.anims[animation].priority == 1)
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

    public final void method446()//resetPath?
    {
        pathLength = 0;
        anInt1542 = 0;
    }

    public final void updateHitData(int hitType, int hitDamage, int currentTime)
    {
        for(int hitPtr = 0; hitPtr < 4; hitPtr++)
            if(hitsLoopCycle[hitPtr] <= currentTime)
            {
                hitDamages[hitPtr] = hitDamage;
                hitMarkTypes[hitPtr] = hitType;
                hitsLoopCycle[hitPtr] = currentTime + 70;
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
        if(animation != -1 && Sequence.anims[animation].priority == 1)
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

    Mobile()
    {
        pathX = new int[10];
        pathY = new int[10];
        interactingEntity = -1;
        degreesToTurn = 32;
        runAnimIndex = -1;
        height = 200;
        standAnimIndex = -1;
        standTurnAnimIndex = -1;
        hitDamages = new int[4];
        hitMarkTypes = new int[4];
        hitsLoopCycle = new int[4];
        anInt1517 = -1;
        gfxId = -1;
        animation = -1;
        loopCycleStatus = -1000;
        textCycle = 100;
        boundDim = 1;
        aBoolean1541 = false;
        pathRun = new boolean[10];
        walkAnimIndex = -1;
        turn180AnimIndex = -1;
        turn90CWAnimIndex = -1;
        turn90CCWAnimIndex = -1;
    }

    public final int[] pathX;
    public final int[] pathY;
    public int interactingEntity;
    int anInt1503;
    int degreesToTurn;
    int runAnimIndex;
    public String textSpoken;
    public int height;
    public int turnDirection;
    int standAnimIndex;//idle?
    int standTurnAnimIndex;//idleTurn?
    int fancyTextColourType;//
    final int[] hitDamages;
    final int[] hitMarkTypes;
    final int[] hitsLoopCycle;
    int anInt1517;
    int anInt1518;
    int anInt1519;
    int gfxId;
    int currentAnim;
    int anInt1522;
    int gfxDelay;
    int graphicHeight;
    int pathLength;
    public int animation;
    int anInt1527;
    int anInt1528;
    int animationDelay;
    int anInt1530;
    int fancyTextDrawType;
    public int loopCycleStatus;
    public int currentHealth;
    public int maxHealth;
    int textCycle;
    int time;
    int faceX;
    int faceY;
    int boundDim;
    boolean aBoolean1541;
    int anInt1542;
    int anInt1543;
    int anInt1544;
    int anInt1545;
    int anInt1546;
    int anInt1547;
    int anInt1548;
    int turnInfo;//int for how many degrees to turn
    public int boundExtentX;
    public int boundExtentY;
    int currentRotation;
    final boolean[] pathRun;
    int walkAnimIndex;//walk?
    int turn180AnimIndex;//turn180?
    int turn90CWAnimIndex;//turn90clockwise?
    int turn90CCWAnimIndex;//turn90counterclockwise?
}
