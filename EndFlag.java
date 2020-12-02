import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndFlag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndFlag extends Obstacles
{
    private GreenfootImage im = new GreenfootImage("endflag.png");
    
    public EndFlag()
    {
        im.scale(30*3,96*3);
        setImage(im);
    }
    
    /**
     * Act - do whatever the EndFlag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
