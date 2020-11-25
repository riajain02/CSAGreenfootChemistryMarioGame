import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Electron here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Electron extends Actor
{
    private boolean isGrabbed;
    public static boolean electronPlaced = false;
    private int x;
    private int y;

    /**
     * Act - do whatever the Electron wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Electron(String image)
    {
        setImage(image);
    }
    
    public void act() 
    {
        drag(Level4.electron);
    }  
    
    public void drag(Electron object) 
    {
        if(Greenfoot.mousePressed(object) && !isGrabbed) {
            isGrabbed=true;
            World world = getWorld();
            MouseInfo mouse = Greenfoot.getMouseInfo();
            world.removeObject(object);
            world.addObject(object,mouse.getX(),mouse.getY());
            return;
        }
        if((Greenfoot.mouseDragged(object)) && isGrabbed) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(),mouse.getY());
            return;
        }
        if(Greenfoot.mouseDragEnded(object) && isGrabbed) {
            isGrabbed=false;
            return;
        }
    }
    
    public void isTouching()
    {
        if(Level4.electron!=null)
        {
            int x = Level4.electron.getX();
            int y = Level4.electron.getY();
            if((x>135 && x<145) && (y>140 && y<175))
            {
                Level4.chlorine.setImage("lesson4_cl_ion.png");
                electronPlaced=true;
            }
        }
    }
}
