import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class path here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Path extends LevelPage
{
    /**
     * Act - do whatever the path wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Path(String path) {
        setImage(path);
    }
    
    public Path(String path, int x, int y) {
        GreenfootImage image = new GreenfootImage(path);
        image.scale(x,y);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
