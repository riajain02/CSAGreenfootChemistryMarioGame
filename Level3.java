import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @Chelsea Lee
 * @1.1
 */
public class Level3 extends World
{
    private int counter=0;
    private int numEnters=-1;
    private boolean enter = true;
    
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1); 
        setBackground("level3start.png");
        showText(""+Levels.numLives,750/2+10,330);
        showText(""+Levels.numTotCoins + " J",175,60);
    }
    
    public void act()
    {
        if (counter == 0){
            Greenfoot.delay(220);
            showText(null,750/2+10,330);
            showText(null,175,60);
            setBackground("level3p1.png");
            Greenfoot.delay(100);
<<<<<<< HEAD
            while (numEnters < 5){
                if (Greenfoot.getKey() == "enter"){
                    numEnters++;
                    tutorial();
                }
=======
        while (numEnters < 10){
            if (Greenfoot.getKey() == "enter"){
                numEnters++;
                tutorial();
>>>>>>> f6e45d2f51750db02e103ab30ac97b184f21c850
            }
        }
    }
    
    private LessonNotes page1 = new LessonNotes("lesson3_1.png");
    private LessonNotes page2 = new LessonNotes("lesson3_2.png");
    
    private void tutorial()
    {
        if (numEnters  == 1){
            addObject(page1,380,260);
            Greenfoot.delay(25);
        }
        else if (numEnters == 2){
            String answer = Greenfoot.ask("How much energy would be needed if we need 1/2 a mole of Cl2? (numbers only, include - if needed)");
            while (!(answer.equals ("119.5"))){
                answer = Greenfoot.ask("Not quite...try again. How much energy would be needed if we need 1/2 a mole of Cl? (numbers only, include - if needed)");
            }
            removeObject(page1);
            addObject(page2,380,270);
            Greenfoot.delay(25);
        }
        else if (numEnters == 4){
            Level3Game lvl3 = new Level3Game();
            Greenfoot.setWorld(lvl3);
            numEnters = 10;
        }
    }
}
