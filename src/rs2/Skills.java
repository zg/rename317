package rs2;


final class SKILLS
{

    public static final int COUNT = 25;
    public static final String[] skillNames = {
        "attack", "defence", "strength", "hitpoints", "ranged", "prayer", "magic", "cooking", "woodcutting", "fletching", 
        "fishing", "firemaking", "crafting", "smithing", "mining", "herblore", "agility", "thieving", "slayer", "farming", 
        "runecraft", "-unused-", "-unused-", "-unused-", "-unused-"
    };
    public static final boolean[] ENABLED = {
        true, true, true, true, true, true, true, true, true, true, 
        true, true, true, true, true, true, true, true, true, false, 
        true, false, false, false, false
    };

}
