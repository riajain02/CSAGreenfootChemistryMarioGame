import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenMushroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenMushroom2 extends PowerUps
{
    public int typeG=0;
    public int counter=1;
    
    public GreenMushroom2()
    {
        GreenfootImage im = new GreenfootImage("greenmushroom.png");
        im.scale(30,30);
        setImage(im);
        typeG=counter;
        counter++;
    }
    
    /**
     * Act - do whatever the GreenMushroom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public void moveGreenM(PowerUps a) {
        if(a.i==0) {
            if(typeG==1) {
                int x=getX();
                int y=getY();
                for(int i=0;i<27;i++) {
                    x+=3;
                    setLocation(x,y);
                    Level3Game.m.run(15);
                    Level3Game.m.powerUps(a);
                    Greenfoot.delay(1);
                }
                y=(410+95/2)-15;
                a.setLocation(x,y);
                while(x>0) {
                    x-=3;
                    a.setLocation(x,y);
                    Level3Game.m.run(15);
                    Level3Game.m.powerUps(a);
                    Greenfoot.delay(1);
                }
                a.i++;
            }
        }
    }
}
