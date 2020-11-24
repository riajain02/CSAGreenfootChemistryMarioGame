import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends LevelPage
{
    private GreenfootImage levelIncomplete = new GreenfootImage("level.png");
    private GreenfootImage levelComplete = new GreenfootImage("levelcompleted.png");
    public int level;
    
    /**
     * Act - do whatever the Level wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Level(int x) {
        level=x;
        levelIncomplete.scale(50,30);
        levelComplete.scale(50,30);
        setImage(levelIncomplete);
    }
    
    public void act() 
    {
        setColor();
    }
    
    public void setColor()
    {
        for(Level x : Levels.levels) {
            if(x.level <= LevelPage.levelsCompleted) {
                x.setImage(levelComplete);
            }
        }
    }
}
