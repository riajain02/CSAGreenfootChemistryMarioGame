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
    public Character marioAnimation = new Character(100,160,"initialK.png");
    public Character peachAnimation = new Character(450,300,"initialCl.png");
    public Character heart = new Character(100,100,"heart.png");
    public Character cage = new Character(200,100,"cage.png");
    public Button skip = new Button(500,300,"skip.png","skiphovered.png",4);
    public GreenfootSound animationMusic = new GreenfootSound("animation.mp3");
    private int marioXCor = 150;
    private int peachXCor = 550;
    private int peachYCor = 150;
    private int counter = 0;
    private int cageYCor = 0;

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
        addObject(skip,690,50);
        Home.startTheme.stop();
    }
    
    public void act() {
        Home.playMusic(animationMusic);
        askToSkip();
        if (counter==0) {
            if(startAnimation==true) {
                playAnimation();
            }
            counter=1;
        }
    }
    
    public void playAnimation() {
        for(int i=0;i<100;i++) {
            marioMoveLeft();
        }
        for(int j=0;j<100;j++) {
            peachMoveLeft();
        }
        addObject(heart,300,250);
        for(int k=0;k<3;k++) {
            moveHeart();
        }
        removeObject(heart);
        addObject(cage,450,200);
        cageMoveDown();
    }
    
    private void askToSkip() {
        
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
    
    public void marioMoveLeft() {
        marioAnimation.setLocation(marioXCor,370);
        marioXCor++;
        Greenfoot.delay(1);
    }
    
    public void peachMoveLeft() {
        peachXCor--;
        peachYCor++;
        peachAnimation.setLocation(peachXCor,peachYCor);
        Greenfoot.delay(1);
    }
    
    public void cageMoveDown() {
        cageYCor--;
        Greenfoot.delay(1);
        cage.setLocation(450,cageYCor);
    }
    
    public void moveHeart() {
        heart.setLocation(275,250);
        Greenfoot.delay(25);
        heart.setLocation(250,250);
        Greenfoot.delay(25);
        heart.setLocation(275,250);
        Greenfoot.delay(25);
        heart.setLocation(300,250);
        startAnimation = false;
    }
    
    public void endAnimation() {
        Levels world = new Levels();
        Greenfoot.setWorld(world);
    }
}
