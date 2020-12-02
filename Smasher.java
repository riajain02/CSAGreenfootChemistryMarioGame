import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Smashers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smasher extends Obstacles
{
    private GreenfootImage smasher = new GreenfootImage("smasher.png");
    
    public Smasher()
    {
        smasher.scale(15,40);
        setImage(smasher);
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
