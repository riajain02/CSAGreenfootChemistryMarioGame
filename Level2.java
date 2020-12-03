import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Level2 here.
 * 
 * @Chelsea Lee
 * version 1.1
 */
public class Level2 extends World
{
    private int counter=0;
    private int numEnters=-1;
    private boolean enter = true;
    
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1); 
        setBackground("level2start.png");
    }
    
    public void act()
    {
        if (counter == 0){
            Greenfoot.delay(220);
            setBackground("level2p1.png");
            Greenfoot.delay(100);
            
        while (numEnters < 10){
            if (Greenfoot.getKey() == "enter"){
                numEnters++;
                tutorial();
            }
        }
        }
    }
    
    private LessonNotes chalkboard = new LessonNotes("lesson2chalkboard.png");
    private LessonNotes page1 = new LessonNotes("lesson2_1.png");
    private LessonNotes page2 = new LessonNotes("lesson2_2.png");
    private LessonNotes page3 = new LessonNotes("lesson2_3.png");
    private LessonNotes page4 = new LessonNotes("lesson2_4.png");
    
    
    private void tutorial()
    {
        if (numEnters == 1){
            addObject(chalkboard,190,200);
            Greenfoot.delay(25);
        }
        else if (numEnters == 2){
            addObject(page1,525, 200);
            Greenfoot.delay(25);
        }
        else if (numEnters == 3){
            String answer = Greenfoot.ask("How many valence electrons does Potassium have? (numbers only)");
            while (!(answer.equals ("1"))){
                answer = Greenfoot.ask("Not quite...try again. How many valence electrons does Potassium have? (numbers only)");
            }
            addObject(page2,325,370);
            Greenfoot.delay(25);
        }
        else if (numEnters == 5){
            String answer2 = Greenfoot.ask("What would the charge of the K ion be? (include +/-)"); 
            while (!(answer2.equals("+1"))){
                answer2 = Greenfoot.ask("Not quite...try again. What would the charge of the K ion be? (include +/-)");
            }
            removeObject(chalkboard);
            removeObject(page1);
            removeObject(page2);
            //page2.setLocation(325,200);
            addObject(page3,350,300);
            Greenfoot.delay(25);
        }
        else if (numEnters == 7){
            String answer3 = Greenfoot.ask("How much energy would we need for ionization to occur? (numbers only, include - if needed)");
            while (!(answer3.equals("419"))){
                answer3 = Greenfoot.ask("Not quite...try again. How much energy would we need for ionization to occur? (numbers only, include - if needed)");
            }
            removeObject(page3);
            addObject(page4, 360, 300);
            Greenfoot.delay(25);
        }
        else if (numEnters == 9){
            Level2Game lvl2 = new Level2Game();
            Greenfoot.setWorld(lvl2);
        }
    }
}
