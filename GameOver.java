import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private GreenfootSound gameover = new GreenfootSound("gameover.mp3");
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Level4Game.level4.stop();
        setBackground("gameoverscreen.png");
        Levels.map.stop();
        gameover.play();
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("s")) {
            reset();
        }
    }
    
    public void reset() {
        Levels.numLives=5;
        Levels.numTotCoins=0;
        LevelPage.levelsCompleted=0;
        Levels a = new Levels();
        Greenfoot.setWorld(a);
    }
}
