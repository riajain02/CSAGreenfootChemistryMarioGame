import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Characters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    public GreenfootImage image;
    private int xCor;
    private int yCor;
    private int type=0;
    
    public Character(int x, int y, String imagePath) {
        image = new GreenfootImage(imagePath);
        image.scale(x,y);
        setImage(image);
    }
    
    public Character(GreenfootImage image) {
        setImage(image);
    }
    
    /**
     * Act - do whatever the Characters wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void run(int x) 
    {
        GreenfootImage marioFrontL = new GreenfootImage("mariorunfrontL.png");
        GreenfootImage marioBackL = new GreenfootImage("mariorunbackL.png");
        GreenfootImage marioSideL = new GreenfootImage("mariostraightL.png");
        Animation.marioFront.scale(75,100);
        Animation.marioSide.scale(75,100);
        Animation.marioBack.scale(75,100);
        marioFrontL.scale(75,100);
        marioSideL.scale(75,100);
        marioBackL.scale(75,100);
        xCor=getX();
        yCor=410;
        if(Greenfoot.isKeyDown("right")) {
            xCor+=x;
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
            Greenfoot.delay(3);
        }
        else if(Greenfoot.isKeyDown("left")) {
            xCor-=x;
            if(type==0) {
                setImage(marioFrontL);
                type=1;
            }
            else if(type==1) {
                setImage(marioSideL);
                type=2;
            }
            else if(type==2) {
                setImage(marioBackL);
                type=3;
            }
            else if(type==3) {
                setImage(marioSideL);
                type=0;
            }
            Greenfoot.delay(3);
        }
        else if(Greenfoot.isKeyDown("up")) {
            setImage(image);
            for(int i=0;i<20;i++) {
                yCor-=10;
                Greenfoot.delay(1);
                setLocation(xCor,yCor);
            }
            for(int j=0;j<20;j++) {
                yCor+=10;
                Greenfoot.delay(1);
                setLocation(xCor,yCor);
            }
            type=0;
        }
        else {
            setImage(image);
            type=0;
        }
        if(Greenfoot.isKeyDown("up")&&Greenfoot.isKeyDown("right")) {
            setImage(Animation.marioSide);
            for(int i=0;i<20;i++) {
                yCor-=10;
                xCor+=(50/20);
                setLocation(xCor,yCor);
                Greenfoot.delay(1);
            }
            for(int j=0;j<20;j++) {
                yCor+=10;
                xCor+=(50/20);
                setLocation(xCor,yCor);
                Greenfoot.delay(1);
            }
            setImage(image);
            type=0;
        }
        else if(Greenfoot.isKeyDown("up")&&Greenfoot.isKeyDown("left")) {
            setImage(marioSideL);
            for(int i=0;i<20;i++) {
                yCor-=10;
                xCor-=5;
                setLocation(xCor,yCor);
                Greenfoot.delay(1);
            }
            for(int j=0;j<20;j++) {
                yCor+=10;
                xCor-=5;
                setLocation(xCor,yCor);
                Greenfoot.delay(1);
            }
            setImage(image);
            type=0;
        }
        setLocation(xCor,yCor);
    }
    
    public void brickBlock()
    {
        if(intersects(Level4Game.plainBlock)) {
            System.out.println("working");
        }
    }
}
