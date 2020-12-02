import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3Game extends SWorld
{
    private Actor m = new Character(50,75,"initialK.png");
    /**
     * Constructor for objects of class Level2Game.
     * 
     */
    public Level3Game()
    {
        super(750, 500, 1, 2250);
        GreenfootImage level4background = new GreenfootImage("backgroundtest.png");
        setScrollingBackground(level4background);
        addMainActor(m,375,250,450,500);
    }
    
    public void act()
    {
        //m.run();
    }
}

