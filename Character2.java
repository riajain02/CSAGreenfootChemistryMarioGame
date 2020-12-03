import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Character6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character2 extends Character
{
    private GreenfootImage image;
    private int xCor;
    private int yCor;
    private int xVal;
    private int type;
    public static int counterr=0;
    private boolean q1asked=false;
    private boolean q2asked=false;
    private boolean q3asked=false;
    private boolean q4asked=false;
    private boolean q5asked=false;
    
    public Character2(int x, int y, String imagePath) {
        image = new GreenfootImage(imagePath);
        image.scale(x,y);
        setImage(image);
        type=0;
    }
        
    /**
     * Act - do whatever the Character6 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(counterr==0) {
            xVal=getX();
            Level6Final.initiated=true;
            counterr++;
        }
    }    
    
    public void run()
    {
            Animation.marioFront.scale(75,100);
            Animation.marioSide.scale(75,100);
            Animation.marioBack.scale(75,100);
            Character4.marioFrontL.scale(75,100);
            Character4.marioSideL.scale(75,100);
            Character4.marioBackL.scale(75,100);
            xCor=getX();
            yCor=getY();
            if(Greenfoot.isKeyDown("right")) {
                int i=xCor;
                xCor+=15;
                if(i!=xCor && xCor!=764) {
                    xVal+=15;
                }
                 if(type==0) {
                    setImage(Animation.marioFront);
                    type=1;
                }
                else if(type==1) {
                    setImage(Animation.marioSide);
                    type=2;
                }
                else if(type==2) {
                    setImage(Animation.marioBack);
                    type=3;
                }
                else if(type==3) {
                    setImage(Animation.marioSide);
                    type=0;
                }
                checkTouching();
                setLocation(xCor,yCor);
                Greenfoot.delay(3);
            }
            else if(Greenfoot.isKeyDown("left")) {
                int i=xCor;
                xCor-=15;
                if(i!=xCor && xCor>=764) {
                    xVal-=15;
                }
                xVal-=15;
                if(type==0) {
                    setImage(Character4.marioFrontL);
                    type=1;
                }
                else if(type==1) {
                    setImage(Character4.marioSideL);
                    type=2;
                }
                else if(type==2) {
                    setImage(Character4.marioBackL);
                    type=3;
                }
                else if(type==3) {
                    setImage(Character4.marioSideL);
                    type=0;
                }
                checkTouching();
                setLocation(xCor,yCor);
                Greenfoot.delay(3);
            }
            else if(Greenfoot.isKeyDown("up")) {
                setImage(image);
                Character4.jump.play();
                checkTouching();
                for(int i=0;i<20;i++) {
                    yCor-=10;
                    checkTouching();
                    Greenfoot.delay(1);
                    setLocation(xCor,yCor);
                }
                while(getY()<250) {
                    yCor+=10;
                    checkTouching();
                    Greenfoot.delay(1);
                    setLocation(xCor,yCor);
                }
                type=0;
                setLocation(xCor,yCor);
            }
            else {
                setImage(image);
                setLocation(xCor,yCor);
                type=0;
            }
            if(Greenfoot.isKeyDown("up")&&Greenfoot.isKeyDown("right")) {
                setImage(Animation.marioSide);
                Character4.jump.play();
                for(int i=0;i<20;i++) {
                    yCor-=10;
                    xCor+=9;
                    xVal+=9;
                    setLocation(xCor,yCor);
                    checkTouching();
                    Greenfoot.delay(1);
                }
                if(getWorld().getObjects(Character6.class).size()>0) {
                    while(getY()<250) {
                        yCor+=10;
                        xCor+=9;
                        xVal+=9;
                        checkTouching();
                        Greenfoot.delay(1);
                        setLocation(xCor,yCor);
                    }
                }
                setImage(image);
                type=0;
            }
            else if(Greenfoot.isKeyDown("up")&&Greenfoot.isKeyDown("left")) {
                setImage(Character4.marioSideL);
                Character4.jump.play();
                for(int i=0;i<20;i++) {
                    yCor-=10;
                    xCor-=9;
                    xVal-=9;
                    setLocation(xCor,yCor);
                    checkTouching();
                    Greenfoot.delay(1);
                }
                while(getY()<250) {
                    yCor+=10;
                    xCor-=9;
                    xVal-=9;
                    checkTouching();
                    Greenfoot.delay(1);
                    setLocation(xCor,yCor);
                }
            setImage(image);
            type=0;
            checkTouching();
        }
        if(getWorld().getObjects(Character6.class)!=null) {
            if(getWorld().getObjects(Character6.class).size()>0) {
                while(getY()<250) {
                    yCor+=10;
                    xCor+=4;
                    xVal+=4;
                    checkTouching();
                    Greenfoot.delay(1);
                    setLocation(xCor,yCor);
                }
            }
        }
    }
    
    public void checkTouching()
    {
        if(Level6Final.initiated) {
            super.act();
            gameOver();
        }
    }
    
    public void levelCompleted()
    {
        Level6Final.level6sound.stop();
        GreenfootSound worldclear = new GreenfootSound("worldclear.mp3");
        worldclear.play();
        Greenfoot.delay(300);
        getWorld().removeObject(Level6Final.m);
        GameWon g = new GameWon();
        Greenfoot.setWorld(g);
        LevelPage.levelsCompleted=6;       
    }
    
    public void gameOver() {
        if(Levels.numLives<=0) {
            GameOver g = new GameOver();
            Greenfoot.setWorld(g);
        }
    }
}
