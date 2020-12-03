import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedMushroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedMushroom2 extends PowerUps
{
    public int typeR;
    public int counter=1;
    
    public RedMushroom2()
    {
        GreenfootImage im = new GreenfootImage("redmushroom.png");
        im.scale(30,30);
        setImage(im);
        typeR=counter;
        counter++;
    }
    
    /**
     * Act - do whatever the RedMushroom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public void moveRedM(PowerUps a) {
        if(a.i==0) {
            if(typeR==1) {
                int x=getX();
                int y=getY();
                for(int i=0;i<40;i++) {
                    x+=3;
                    setLocation(x,y);
                    Level3Game.m.run(15);
                    Level3Game.m.powerUps(a);
                    if(Level3Game.greenMs2.size()>0) {
                        for(GreenMushroom2 g : Level3Game.greenMs2) {
                            g.moveGreenM(g);
                            getWorld().removeObject(g);
                        }
                    }
                    Greenfoot.delay(1);
                }
                y=(410+95/2)-15;
                a.setLocation(x,y);
                while(x>0) {
                    x-=3;
                    a.setLocation(x,y);
                    Level3Game.m.run(15);
                    Level3Game.m.powerUps(a);
                    if(Level3Game.greenMs2.size()>0) {
                        for(GreenMushroom2 g : Level3Game.greenMs2) {
                            g.moveGreenM(g);
                            getWorld().removeObject(g);
                        }
                    }
                    Greenfoot.delay(1);
                }
                a.i++;
            }
            else if(typeR==2) {
                int x=getX();
                int y=getY();
                for(int i=0;i<2;i++) {
                    x+=3;
                    setLocation(x,y);
                    Level3Game.m.run(15);
                    Level3Game.m.powerUps(a);
                    Greenfoot.delay(1);
                }
                y=(410+95/2)-15;
                a.setLocation(x,y);
                while(x>1685) {
                    x-=3;
                    a.setLocation(x,y);
                    Level3Game.m.run(15);
                    Level3Game.m.powerUps(a);
                    Greenfoot.delay(1);
                }
                while(y<500) {
                    y-=3;
                    a.setLocation(x,y);
                    Level3Game.m.run(15);
                    Level3Game.m.powerUps(a);
                    Greenfoot.delay(1);
                }
                getWorld().removeObject(a);
                a.i++;
            }
        }
    }
}
