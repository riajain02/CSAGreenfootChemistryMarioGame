import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level6Final here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level6Final extends SWorld
{
    public static Character6 m = new Character6(65,95,"initialK.png");
    public static GreenfootImage level6bg = new GreenfootImage("level6bg.png");
    public static GreenfootSound level6sound = new GreenfootSound("level6.mp3");
    public static int numCoins=0;
    public static boolean initiated=false;
    public static EndFlag endflag = new EndFlag();
    private int counter=0;
    /**
     * Constructor for objects of class Level6Final.
     * 
     */
    public Level6Final()
    {
        super(750, 500, 1, 3750);
        Levels.map.stop();
        addMainActor(m,375,300-95/2,450,500);
        level6bg.scale(750,500);
        setScrollingBackground(level6bg);
        m.setLocation(375,250);
        showText(null,750/2+10,325);
        initiated=true;
    }
    
    public void act()
    {
        Home.playMusic(level6sound);
        super.act();
        m.run();
    }
}
