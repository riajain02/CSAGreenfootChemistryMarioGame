import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacles extends Actor
{
    /**
     * Act - do whatever the Obstacles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Obstacles(String imPath, int x, int y)
    {
        GreenfootImage im = new GreenfootImage(imPath);
        im.scale(x,y);
        setImage(im);
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
