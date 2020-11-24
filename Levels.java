import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{
    private GreenfootSound map = new GreenfootSound("map.mp3");
    public static ArrayList<Level> levels = new ArrayList<>();
    
    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Levels()
    {    
        // Create a new world with 750x500 cells with a cell size of 1x1 pixels.
        super(750, 500, 1);
        Animation.animationMusic.stop();
        setBackground("levelspage.png");
        addPaths();
        addLevels();
        Mario mario = new Mario();
        addObject(mario,75,75);
    }
    
    public void addPaths() 
    {
        Path path1 = new Path("path1.png");
        Path path2 = new Path("path2.png");
        Path path3 = new Path("path3.png",47,345);
        Path path4 = new Path("path2.png");
        addObject(path1,75,75);
        addObject(path2,290,75);
        addObject(path3,433,270);
        addObject(path4,590,419);
    }
    
    public void addLevels()
    {
        Level level1 = new Level(1);
        Level level2 = new Level(2);
        Level level3 = new Level(3);
        Level level4 = new Level(4);
        Level level5 = new Level(5);
        Level level6 = new Level(6);
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        levels.add(level5);
        levels.add(level6);
        addObject(level1,275,75);
        addObject(level2,433,75);
        addObject(level3,433,270);
        addObject(level4,433,419);
        addObject(level5,550,419);
        addObject(level6,700,419);
    }
    
    public void act() 
    {
        Home.playMusic(map);
    }
}
