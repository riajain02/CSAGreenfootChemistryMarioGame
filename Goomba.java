import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Smashers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goomba extends Obstacles
{
    private GreenfootImage goomba = new GreenfootImage("goomba.png");
    
    public Goomba()
    {
        goomba.scale(30,30);
        setImage(goomba);
    }
    
    /**
     * Act - do whatever the Smashers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
