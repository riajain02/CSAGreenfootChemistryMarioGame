import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWon extends World
{
    private GreenfootSound ending = new GreenfootSound("ending.mp3");
    private GreenfootImage marioIm = new GreenfootImage("finalK.png");
    private GreenfootImage peachIm = new GreenfootImage("finalCl.png");
    private GreenfootImage endanimationbg = new GreenfootImage("endinganimationscreen.png");
    private GreenfootImage endingscreen = new GreenfootImage("endingscreen.png");
    private AnimationCharacter mario = new AnimationCharacter(marioIm);
    private AnimationCharacter peach = new AnimationCharacter(peachIm);
    private int counter=0;
    
    /**
     * Constructor for objects of class GameWon.
     * 
     */
    public GameWon()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1);
        setBackground(endanimationbg);
        Level6Final.level6sound.stop();
        ending.play();
        addObject(mario,750/3,250+100);
        addObject(peach,750/3*2,250-100);
    }
    
    public void act()
    {
        if(counter==0) {
            reaction();
            removeObject(mario);
            removeObject(peach);
            if(getObjects(AnimationCharacter.class)!=null) {
                if(getObjects(AnimationCharacter.class).size()>0) {
                    reaction();
                }
            }
            setBackground(endingscreen);
            counter++;
        }
        Home.playMusic(ending);
        if(Greenfoot.isKeyDown("enter")) {
            Home h = new Home();
            Greenfoot.setWorld(h);
            ending.stop();
            LevelPage.levelsCompleted=0;
        }
    }
    
    public void reaction()
    {
        int mx=mario.getX();
        int my=mario.getY();
        int px=peach.getX();
        int py=peach.getY();
        for(int i=0;i<2;i++) {
            for(int j=0;j<4;j++) {
                my-=5;
                px-=5;
                mario.setLocation(mx,my);
                peach.setLocation(px,py);
                Greenfoot.delay(10);
            }
            for(int k=0;k<8;k++) {
                my+=5;
                px+=5;
                mario.setLocation(mx,my);
                peach.setLocation(px,py);
                Greenfoot.delay(10);
            }
            for(int l=0;l<4;l++) {
                my-=5;
                px-=5;
                mario.setLocation(mx,my);
                peach.setLocation(px,py);
                Greenfoot.delay(10);
            }
        }
        for(int i=0;i<5;i++) {
            mx+=25;
            px-=25;
            my-=20;
            py+=20;
            mario.setLocation(mx,my);
            peach.setLocation(px,py);
            Greenfoot.delay(10);
        }
    }
}
