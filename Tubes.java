import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tubes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tubes extends Obstacles
{
    private GreenfootImage tubeS = new GreenfootImage("tubesmall.png");
    private GreenfootImage tubeM = new GreenfootImage("tubemedium.png");
    private GreenfootImage tubeL = new GreenfootImage("tubelarge.png");
    
    public Tubes(String s) {
        if(s.equals("s")) {
            tubeS.scale(60,64);
            setImage(tubeS);
        }
        if(s.equals("m")) {
            tubeM.scale(60,90);
            setImage(tubeM);
        }
        if(s.equals("l")) {
            tubeL.scale(60,118);
            setImage(tubeL);
        }
    }
    
    /**
     * Act - do whatever the Tubes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
