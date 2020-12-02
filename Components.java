import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Components here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Components extends Obstacles
{
    public Components(String imPath, int x, int y)
    {
        GreenfootImage im = new GreenfootImage(imPath);
        im.scale(x,y);
        setImage(im);
    }
    
    public Components(GreenfootImage im, int x, int y)
    {
        im.scale(x,y);
        setImage(im);
    }
    
    /**
     * Act - do whatever the Components wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
