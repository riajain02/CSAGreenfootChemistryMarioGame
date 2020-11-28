import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    private int counter=0;
    private int numEnters=-1;
    private boolean enter = true;

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1); 
        setBackground("level1start.png");
    }
    public void act() 
    {
        if(counter==0) {
            Greenfoot.delay(200);
            setBackground("level1-1.png");
            Greenfoot.delay(100);
            while(numEnters<6) {
                if(Greenfoot.getKey()=="enter") {
                    numEnters++;
                    tutorial();
                }
            }
            counter++;
        }
    }
    
    private LessonNotes chalkboard = new LessonNotes("lesson1chalkboard.png");
    private LessonNotes text1 = new LessonNotes("level1_text1.png");
    private LessonNotes text2 = new LessonNotes("level1_text2.png");
    private LessonNotes text3 = new LessonNotes("level1_text3.png");
    
    private void tutorial()
    {
        if(numEnters==1) {
            addObject(chalkboard,175,230);
            Greenfoot.delay(50);
        }
        else if(numEnters==2) {
            addObject(text1,550,220);
            Greenfoot.delay(50);
        }
        else if(numEnters==3) {
            String ans=Greenfoot.ask("What states of matter are involved in sublimation? Answer in the format: word, word");
            while(!(ans.equals("gas, solid"))) {
                ans=Greenfoot.ask("Try again! What states of matter are involved in sublimation? Hint: Read the chalkboard.");
            }
            addObject(text2,175,420);
            Greenfoot.delay(50);
        }
        else if(numEnters==5) {
            addObject(text3,550,400);
            Greenfoot.delay(100);
            removeObject(chalkboard);
            removeObject(text1);
            removeObject(text2);
            removeObject(text3);
            
            setBackground("level1-1-page2.png");
        }
        else if (numEnters==6) {
            startLevel();
        }
    }
    
    private void startLevel()
    {
    
    }
}
