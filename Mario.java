import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends LevelPage
{
    private GreenfootImage marioFront = new GreenfootImage("initialK.png");
    public int level = 0;
    private int xcor=75;
    private int ycor=75;
    
    public Mario() {
        marioFront.scale(50,75);
        setImage(marioFront);
    }
    
    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move();
       enterLevel();
    } 
    
    public void move() {
        if(Greenfoot.isKeyDown("right")) { //0,1,4,5
            if(level==0) {
                while(xcor<275) {
                    xcor+=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=1;
            }
            else if(level==1 && LevelPage.levelsCompleted>=1) {
                while(xcor<433) {
                    xcor+=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=2;
            }
            else if(level==4 && LevelPage.levelsCompleted>=4) {
                while(xcor<550) {
                    xcor+=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=5;
            }
            else if(level==5 && LevelPage.levelsCompleted>=5) {
                while(xcor<700) {
                    xcor+=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=6;
            } 
        }
        if(Greenfoot.isKeyDown("left")) { //1,2,5,6
            if(level==1) {
                while(xcor>75) {
                    xcor-=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=0;
            }
            else if(level==2) {
                while(xcor>275) {
                    xcor-=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=1;
            }
            else if(level==5) {
                while(xcor>433) {
                    xcor-=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=4;
            }
            else if(level==6) {
                while(xcor>550) {
                    xcor-=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=5;
            }
        }
        if(Greenfoot.isKeyDown("up")) { //3,4
            if(level==3) {
                while(ycor>75) {
                    ycor-=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=2;
            }
            else if(level==4) {
                while(ycor>270) {
                    ycor-=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=3;
            }
        }
        if(Greenfoot.isKeyDown("down")) { //2,3
            if(level==2) {
                while(ycor<270 && LevelPage.levelsCompleted>=2) {
                    ycor+=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=3;
            }
            else if(level==3 && LevelPage.levelsCompleted>=3) {
                while(ycor<419) {
                    ycor+=3;
                    Greenfoot.delay(1);
                    setLocation(xcor,ycor);
                }
                level=4;
            }
        }
    }
    
    private void enterLevel() {
        if(Greenfoot.isKeyDown("enter")) {
            if(level==4) {
                Level4 lesson4 = new Level4();
                GreenfootSound levelStart = new GreenfootSound("go.wav");
                Character.counterr=0;
                Greenfoot.setWorld(lesson4);
                levelStart.play();
            }
        }
    }
}
