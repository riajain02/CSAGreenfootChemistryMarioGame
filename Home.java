import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends World
{
    public static Button play = new Button(100,50,"play.jpg","playhovered.jpg",1);
    public static Button info = new Button (30,30,"ibutton.jpg","ibuttonHovered.jpg",2);
    public static Button howToPlay = new Button (650,450,"instructions.jpg",3);
    private int click = 0;
    private int hover = 0;
    private boolean hovering;
    public static GreenfootSound startTheme = new GreenfootSound("starttheme.wav");
    public GreenfootSound buttonHover = new GreenfootSound("buttonhover.wav");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Home()
    {    
        // Create a new world with 750x500 cells with a cell size of 1x1 pixels.
        super(750, 500, 1); 
        setBackground("home.jpg");
        addObject(play,750/2,300);
        addObject(info, 725, 25);
        startTheme.setVolume(75);
    }
    
    public void act() {
        playMusic(startTheme);
        hover(play);
        hover(info);
        click(info);
        click(play);
    }
    
    public static void playMusic(GreenfootSound sound) {
        if(!sound.isPlaying()) {
            sound.play();
        }
    }
    
    private void hover(Button button) {
        if (Greenfoot.mouseMoved(null)) {
            if (hovering != Greenfoot.mouseMoved(button)) {
                hovering = ! hovering;
                if (hovering) {
                    playMusic(buttonHover);
                }
            }        
        }
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            List objects = getObjectsAt(mouse.getX(), mouse.getY(), Button.class);
            button.setImage(button.image);
            for (Object object : objects) {
                if(object==button) {
                    button.setImage(button.imageHovered);
                }
            }
        }
    }
    
    private void click(Button button) {
        if(Greenfoot.mouseClicked(button)) {
            if(button.buttonType==1) {
                Animation world = new Animation();
                Greenfoot.setWorld(world);
                Animation.startAnimation = true;
            }
            if(button.buttonType==2) {
                if(click==0) {
                    addObject(howToPlay,750/2,500/2);
                    click=1;
                }
                else if(click==1) {
                    removeObject(howToPlay);
                    click=0;
                }
            }
        }
    }
}
