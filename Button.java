import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    public int buttonType;
    public GreenfootImage image;
    public GreenfootImage imageHovered;
    public World h = getWorld();
    
    public Button(int x, int y, String imagePath, int type) {
        image = new GreenfootImage(imagePath);
        image.scale(x,y);
        setImage(image);
        buttonType=type;
    }
    
    public Button(int x, int y, String imagePath, String imagePathHovered, int type) {
        image = new GreenfootImage(imagePath);
        imageHovered = new GreenfootImage(imagePathHovered);
        image.scale(x,y);
        imageHovered.scale(x,y);
        setImage(image);
        buttonType=type;
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
}