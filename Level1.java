import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Lesson for level 1 - sublimation of K(s).
 * 
 * @author Ria Jain, Tinh-Phong Nguyen
 * @version 1.0
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
        showText(""+Levels.numLives,750/2+10,315);
        showText(""+Levels.numTotCoins + " J",175,60);
    }
    public void act() 
    {
        if(counter==0) {
            Greenfoot.delay(200);
            showText(null,750/2+10,315);
            showText(null,175,60);
            setBackground("level1-1.png");
            Greenfoot.delay(100);
            while(numEnters<10) {
                if(Greenfoot.getKey()=="enter") {
                    numEnters++;
                    tutorial();
                }
            }
            counter++;
        }
    }
    
    private LessonNotes chalkboard;
    private GreenfootImage chalkboardIm = new GreenfootImage("lesson1chalkboard.png");
    private LessonNotes text1 = new LessonNotes("level1_text1.png");
    private LessonNotes text2 = new LessonNotes("level1_text2.png");
    private LessonNotes text3 = new LessonNotes("level1_text3.png");
    private LessonNotes text4 = new LessonNotes("level1_text4.png");
    private LessonNotes text5 = new LessonNotes("level1_text5.png");
    private void tutorial()
    {
        if(numEnters==1) {
            chalkboardIm.scale(250,188);
            chalkboard = new LessonNotes(chalkboardIm);
            addObject(chalkboard,175,200);
            Greenfoot.delay(50);
        }
        else if(numEnters==2) {
            addObject(text1,550,200);
            Greenfoot.delay(50);
        }
        else if(numEnters==3) {
            String ans=Greenfoot.ask("What states of matter are involved in sublimation? Answer in the format: word, word");
            while(!(ans.equals("solid, gas"))&&!(ans.equals("solid,gas"))&&!(ans.equals("gas, solid"))&&!(ans.equals("gas,solid"))) {
                ans=Greenfoot.ask("Try again! What states of matter are involved in sublimation? Hint: read the chalkboard.");
            }
            addObject(text2,750/2,350);
            Greenfoot.delay(50);
        }
        else if(numEnters==5) {
            addObject(text3,750/2,450);
            Greenfoot.delay(50);
        }
        else if(numEnters==6) {
            removeObject(chalkboard);
            removeObject(text1);
            removeObject(text2);
            removeObject(text3);
            addObject(text4,750/2,200);
            Greenfoot.delay(50);
        }
        else if(numEnters==7) {
            addObject(text5,750/2,300);
            Greenfoot.delay(50);
        }
        else if(numEnters==8)
        { 
            String ans=Greenfoot.ask("If we have one mole of K(s), and the enthalpy of sublimation for potassium is 90, how many kJ of energy is needed?");
            while(!(ans.equals("90"))) {
                ans=Greenfoot.ask("Try again! If we have one mole of K(s), and the enthalpy of sublimation for potassium is 90, how many kJ of energy is needed?");
            }
            removeObject(text4);
            removeObject(text5);
            setBackground("level1-1-page2.png");
        }
        else if (numEnters==9){
            Level1Game lvl1 = new Level1Game();
            Greenfoot.setWorld(lvl1);
        }
    }
    
}

