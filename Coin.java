import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Obstacles
{
    private GreenfootImage coinIm = new GreenfootImage("coin.png");
    public boolean coinRemoved=false;

    public Coin() {
        coinIm.scale(50,50);
        setImage(coinIm);
    }
    
    public Coin(int x, int y) {
        coinIm.scale(x,y);
        setImage(coinIm);
    }
    
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // add code here
    }
}
