import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Animation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animation extends World
{
    public static boolean startAnimation = false;
    public static GreenfootImage marioFront = new GreenfootImage("mariorunfront.png");
    public static GreenfootImage marioBack = new GreenfootImage("mariorunback.png");
    public static GreenfootImage marioSide = new GreenfootImage("mariostraight.png");
    public Character marioAnimation = new Character(marioSide);
    public Character peachAnimation = new Character(450,300,"initialCl.png");
    public Character heart = new Character(100,100,"heart.png");
    public Character cage = new Character(200,300,"cage.png");
    public Character babyBowser = new Character(150,150,"babybowser.png");
    public static GreenfootSound animationMusic = new GreenfootSound("animation.mp3");
    public static GreenfootSound bowser = new GreenfootSound("bowserbackground.wav");
    public static Levels world = new Levels();
    private int marioXCor = 150;
    private int peachXCor = 550;
    private int peachYCor = 150;
    private int counter = 0;
    private int cageYCor = 0;
    private int type = 0;
    
    /**
     * Constructor for objects of class Animation.
     * 
     */
    public Animation()
    {    
        // Create a new world with 750x500 cells with a cell size of 1x1 pixels.
        super(750, 500, 1); 
        setBackground("animationbackground.jpg");
        addObject(marioAnimation,marioXCor,370);
        addObject(peachAnimation,550,150);
        Home.startTheme.stop();
        Levels.map.stop();
        marioFront.scale(150,175);
        marioBack.scale(150,175);
        marioSide.scale(150,200);
    }
    
    public void act() {
        if (counter==0) {
            animationMusic.play();
            askToSkip();
            if(startAnimation==true) {
                playAnimation();
            }
            else {
                endAnimation();
            }
            counter=1;
        }
    }
    
    public void playAnimation() {
        for(int i=0;i<10;i++) {
            marioMoveRight(5);
        }
        marioAnimation.setImage("initialK.png");
        for(int j=0;j<100;j++) {
            peachMoveRight();
        }
        addObject(heart,300,250);
        for(int k=0;k<3;k++) {
            moveHeart();
        }
        removeObject(heart);
        addObject(babyBowser,500,50);
        addObject(cage,400,0);
        for(int m=0;m<100;m++) {
            cageMoveDown();
        }
        GreenfootSound ungh = new GreenfootSound("ungh.wav");
        GreenfootSound boo = new GreenfootSound("boolaugh.wav");
        ungh.play();
        for (int n=0;n<40;n++) {
            steal();
        }
        removeObject(peachAnimation);
        removeObject(cage);
        removeObject(babyBowser);
        boo.play();
        ungh.play();
        for(int o=0;o<20;o++) {
            marioMoveRight(10);
        }
        endAnimation();
    }
    
    private void askToSkip() {
        String ans = Greenfoot.ask("Play animation? (y/n)");
        if(!(ans.equals("y") || ans.equals("yes"))) {
            startAnimation=false;
        }
    }
    
    private void hover(Button button) {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            button.setImage(button.image);
            List objects = getObjectsAt(mouse.getX(), mouse.getY(), Button.class);
            for (Object object : objects)
            {
                if(object==button) {
                    button.setImage(button.imageHovered); 
                }
            }
        }
    }
    
    private void click(Button button) {
        if(Greenfoot.mouseClicked(button)) {
            endAnimation();
        }
    }
    
    private void marioMoveRight(int x) {
        for(int i=0;i<2;i++) {
            marioXCor+=x;
            if(type==0) {
                marioAnimation.setImage(marioFront);
                type=1;
            }
            else if(type==1) {
                marioAnimation.setImage(marioSide);
                type=2;
            }
            else if(type==2) {
                marioAnimation.setImage(marioBack);
                type=3;
            }
            else if(type==3) {
                marioAnimation.setImage(marioSide);
                type=0;
            }
            marioAnimation.setLocation(marioXCor,350);
            Greenfoot.delay(3);
        }
    }
    
    private void peachMoveRight() {
        peachXCor--;
        peachYCor++;
        peachAnimation.setLocation(peachXCor,peachYCor);
        Greenfoot.delay(1);
    }
    
    private void cageMoveDown() {
        cageYCor+=2;
        Greenfoot.delay(1);
        cage.setLocation(400,cageYCor);
        animationMusic.stop();
        Home.playMusic(bowser);
    }
    
    private void moveHeart() {
        heart.setLocation(275,250);
        Greenfoot.delay(25);
        heart.setLocation(250,250);
        Greenfoot.delay(25);
        heart.setLocation(275,250);
        Greenfoot.delay(25);
        heart.setLocation(300,250);
        startAnimation = false;
    }
    
    private void steal() {
        peachYCor-=5;
        cageYCor-=5;
        peachAnimation.setLocation(peachXCor,peachYCor);
        cage.setLocation(400,cageYCor);
        Greenfoot.delay(1);
    }
    
    private void endAnimation() {
        Greenfoot.setWorld(world);
    }
}
