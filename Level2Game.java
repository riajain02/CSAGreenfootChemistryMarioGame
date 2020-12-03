import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2Game extends SWorld
{
    public static Character4 m = new Character4(50,75,"initialK.png");
    /**
     * Constructor for objects of class Level2Game.
     * 
     */
    public Level2Game()
    {
        super(750, 500, 1, 2250);
        GreenfootImage level4background = new GreenfootImage("backgroundtest.png");
        addMainActor(m,375,250,450,500);
        setScrollingBackground(level4background);
    }
    
    public void act()
    {
        m.run(15);
    }
}
