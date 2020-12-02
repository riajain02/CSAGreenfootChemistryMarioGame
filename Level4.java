import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends World
{
    private int counter=0;
    private int counter2=0;
    private int numEnters=-1;
    private boolean enter = true;
    List electrons;

    /**
     * Constructor for objects of class Level4.
     * 
     */
    public Level4()
    {    
        // Create a new world with 750x500 cells with a cell size of 1x1 pixels.
        super(750, 500, 1);
        setBackground("level4start.png");
        showText(""+Levels.numLives,750/2+100,285);
        showText(""+Levels.numTotCoins + " J",175,60);
    }
    
    public void act() 
    {
        if(counter==0) {
            Greenfoot.delay(200);
            setBackground("level4-1.png");
            showText(null,750/2+100,285);
            showText(null,175,60);
            Greenfoot.delay(100);
            while(numEnters<10) {
                if(Greenfoot.getKey()=="enter") {
                    numEnters++;
                    tutorial();
                }
            }
            counter++;
            electrons = getObjects(Electron.class);
        }
        if(electrons.size() > 0)
        {
            electron.drag(electron);
            electron.isTouching();
        }
        if(Electron.electronPlaced==true) {
            counter2++;
        }
        if(counter2==1) {
            removeObject(Level4.electron);
            electrons = getObjects(Electron.class);
            addObject(text5,365,350);
            Greenfoot.delay(50);
            numEnters=0;
            while(numEnters<5) {
                if(Greenfoot.getKey()=="enter") {
                    numEnters++;
                    tutorial2();
                }
            }
            counter2++;
        }
    }
    
    private LessonNotes chalkboard = new LessonNotes("lesson4chalkboard.png");
    private LessonNotes text1 = new LessonNotes("lesson4_text1.png");
    private LessonNotes text2 = new LessonNotes("lesson4_text2.png");
    private LessonNotes text3 = new LessonNotes("lesson4_text3.png");
    public static LessonNotes chlorine = new LessonNotes("lesson4_cl_neutral.png");
    private LessonNotes potassium = new LessonNotes("lesson4_k.png");
    public static Electron electron = new Electron("lesson4_electron.png");
    private LessonNotes electrontext = new LessonNotes("lesson4_electrontext.png");
    private LessonNotes text4 = new LessonNotes("lesson4_text4.png");
    private LessonNotes text5 = new LessonNotes("lesson4_text5.png");
    private LessonNotes text6 = new LessonNotes("lesson4_text6.png");
    
    private void tutorial()
    {
        if(numEnters==1) {
            addObject(chalkboard,175,200);
            Greenfoot.delay(50);
        }
        else if(numEnters==2) {
            addObject(text1,500,200);
            Greenfoot.delay(50);
        }
        else if(numEnters==3) {
            String ans=Greenfoot.ask("How many valence electrons does chlorine have? Type in just the number.");
            while(!(ans.equals("7"))) {
                ans=Greenfoot.ask("Try again! How many valence electrons does chlorine have? Hint: look at Cl's group number.");
            }
            addObject(text2,365,350);
            Greenfoot.delay(50);
        }
        else if(numEnters==5) {
            String ans2=Greenfoot.ask("What is the charge of the ion formed by Cl? Type in just the charge of the ion as a number, including sign.");
            while(!(ans2.equals("-1"))) {
                ans2=Greenfoot.ask("Try again! What is the charge of the ion formed by Cl? Hint: an electron has a -1 charge.");
            }
            addObject(text3,365,450);
            Greenfoot.delay(50);
            removeObject(chalkboard);
        }
        if(numEnters==7) {
            removeObject(chalkboard);
            removeObject(text1);
            removeObject(text2);
            removeObject(text3);
            addObject(chlorine,100,200);
            Greenfoot.delay(50);
        }
        else if(numEnters==8) {
            addObject(potassium,250,200);
            Greenfoot.delay(50);
        }
        else if(numEnters==9) {
            addObject(electron,400,175);
            addObject(electrontext,400,275);
            Greenfoot.delay(50);
        }
        else if(numEnters==10) {
            addObject(text4,550,160);
            Greenfoot.delay(50);
        }
    }
    private void tutorial2()
    {
        if(numEnters==1) {
            addObject(text6,365,450);
            Greenfoot.delay(50);
        }
        else if(numEnters==2) {
            String ans3=Greenfoot.ask("What is the amount of energy required for this process? Include sign. Do not include units, only the number.");
            while(!(ans3.equals("-349"))) {
                ans3=Greenfoot.ask("Try again! What is the amount of energy required for this process? Include sign. Hint: We have one mole of Cl (g).");
            }
            removeObjects();
            setBackground("level4-1-page2.png");
            Greenfoot.delay(100);
        }
        else if(numEnters==4) {
           Level4Game a = new Level4Game();
           Greenfoot.setWorld(a);
           numEnters=6;
        }
    }
    
    private void removeObjects()
    {
        removeObject(chlorine);
        removeObject(potassium);
        removeObject(electron);
        removeObject(electrontext);
        removeObject(text4);
        removeObject(text5);
        removeObject(text6);
    }
}
