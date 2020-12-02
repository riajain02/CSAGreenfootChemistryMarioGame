import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrickBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrickBlock extends Obstacles
{
    public boolean blockHit=false;

    /**
     * Act - do whatever the CrickBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BrickBlock()
    {
        GreenfootImage im = new GreenfootImage("brickblock.png");
        im.scale(40,40);
        setImage(im);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
