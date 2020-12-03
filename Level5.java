import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level5 extends World
{
    private int counter=0;
    private int numEnters=-1;
    private boolean enter = true;
    
    /**
     * Constructor for objects of class Level5.
     * 
     */
    public Level5()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1); 
        setBackground("level5start.png");
    }
    
    public void act()
    {
         if (counter == 0){
            Greenfoot.delay(220);
            setBackground("level5p1.png");
            Greenfoot.delay(100);
         while (numEnters < 7){
            if (Greenfoot.getKey() == "enter"){
                numEnters++;
                tutorial();
            }
        }
        }
    }
    
    private LessonNotes page1 = new LessonNotes("lesson5_1.png");
    private LessonNotes page2 = new LessonNotes("lesson5_2.png");
    private LessonNotes bond = new LessonNotes("bondions.png");
    private LessonNotes separate = new LessonNotes("separateions.png");  
    
    private void tutorial(){
        if (numEnters == 1){
            addObject(separate,380,260);
            Greenfoot.delay(25);
        }
        else if (numEnters == 2){
            removeObject(separate);
            addObject(bond,380,260);
            Greenfoot.delay(25);
        }
        else if (numEnters == 3){
            removeObject(bond);
            addObject(page1,390,290);
            Greenfoot.delay(25);
        }
        else if (numEnters == 4){
            String answer = Greenfoot.ask("How much energy would be released if we have 1 mole of KCl? (numbers only, include - if needed)");
            while (!(answer.equals ("-690"))){
                answer = Greenfoot.ask("Not quite...try again. How much energy would be released if we have 1 mole of KCl? (numbers only, include - if needed)");
            }
            removeObject(page1);
            addObject(page2,380,270);
        }
        else if (numEnters == 6){
            Level5Game lvl5 = new Level5Game();
            Greenfoot.setWorld(lvl5);
        }
    }
    
}
