import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4Game extends SWorld
{
    private Actor m = new Character(50,75,"initialK.png");

    /**
     * Constructor for objects of class Level4Game.
     * 
     */
    public Level4Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
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
