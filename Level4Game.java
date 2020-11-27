import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4Game extends SWorld
{
    private Character m = new Character(65,95,"initialK.png");
    public static Obstacles plainBlock = new Obstacles("brickblock.png",40,40);
    public static GreenfootSound level4 = new GreenfootSound("level4.mp3");
    
    /**
     * Constructor for objects of class Level4Game.
     * 
     */
    public Level4Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1, 3750);
        GreenfootImage level4background = new GreenfootImage("level4bg.png");
        addMainActor(m,375,250,450,500);
        setScrollingBackground(level4background);
        Obstacles ground = new Obstacles("level4ground.png",3755,70);
        addObject(ground,3750/2,490);
        addObject(plainBlock,750/2,500/2);
        Levels.map.stop();
        Home.playMusic(level4);
    }
    
    public void act()
    {
        super.act();
        m.run(15);
        //m.brickBlock();
    }
}
