import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QuestionBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuestionBlock extends Obstacles
{
    public boolean qBlockHit=false;
    public int powerUpType;

    public QuestionBlock(int s)
    {
        GreenfootImage im = new GreenfootImage("questionblock.png");
        im.scale(40,40);
        setImage(im);
        powerUpType=s; // 1 = red mushroom, 2 = green mushroom
    }
    
    /**
     * Act - do whatever the QuestionBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
