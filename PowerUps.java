import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUps extends Actor
{
    public boolean powerUpUsed=false;
    public int i=0;
    
    /**
     * Act - do whatever the PowerUps wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public static void moveRedGreenM(RedMushroom a, GreenMushroom b) {
        if(a.i==0 && b.i==0) {
            if(a.typeR==1 && b.typeG==1) {
                int rx=a.getX();
                int ry=a.getY();
                int gx=b.getX();
                int gy=b.getY();
                while(rx<420 || gx<420) {
                    if(rx<420) {rx+=3; a.setLocation(rx,ry);}
                    else {rx-=3; ry=(410+95/2)-15; a.setLocation(rx,ry);}
                    if(gx<420) {gx+=3; b.setLocation(rx,ry);}
                    else {gx-=3; gx=(410+95/2)-15; b.setLocation(gx,gy);}
                    a.setLocation(rx,ry);
                    b.setLocation(rx,ry);
                    Level4Game.m.run(15);
                    Level4Game.m.powerUps(a);
                    Level4Game.m.powerUps(b);
                    Greenfoot.delay(1);
                }
                while(rx>0 || gx>0) {
                    rx-=3;
                    ry=(410+95/2)-15;
                    gx-=3;
                    gy=(410+95/2)-15;
                    a.setLocation(rx,ry);
                    b.setLocation(gx,gy);
                    Level4Game.m.run(15);
                    Level4Game.m.powerUps(a);
                    Level4Game.m.powerUps(b);
                    Greenfoot.delay(1);
                }
                a.i++;
            }
        }
        else if(a.i==0) {
            a.moveRedM(a);
        }
        else if(b.i==0) {
            b.moveGreenM(b);
        }
    }
    
    public static void moveRedGreenM2(RedMushroom2 a, GreenMushroom2 b) {
        if(a.i==0 && b.i==0) {
            if(a.typeR==1 && b.typeG==1) {
                int rx=a.getX();
                int ry=a.getY();
                int gx=b.getX();
                int gy=b.getY();
                while(rx<420 || gx<420) {
                    if(rx<420) {rx+=3; a.setLocation(rx,ry);}
                    else {rx-=3; ry=(410+95/2)-15; a.setLocation(rx,ry);}
                    if(gx<420) {gx+=3; b.setLocation(rx,ry);}
                    else {gx-=3; gx=(410+95/2)-15; b.setLocation(gx,gy);}
                    a.setLocation(rx,ry);
                    b.setLocation(rx,ry);
                    Level3Game.m.run(15);
                    Level3Game.m.powerUps(a);
                    Level3Game.m.powerUps(b);
                    Greenfoot.delay(1);
                }
                while(rx>0 || gx>0) {
                    rx-=3;
                    ry=(410+95/2)-15;
                    gx-=3;
                    gy=(410+95/2)-15;
                    a.setLocation(rx,ry);
                    b.setLocation(gx,gy);
                    Level3Game.m.run(15);
                    Level3Game.m.powerUps(a);
                    Level3Game.m.powerUps(b);
                    Greenfoot.delay(1);
                }
                a.i++;
            }
        }
        else if(a.i==0) {
            a.moveRedM(a);
        }
        else if(b.i==0) {
            b.moveGreenM(b);
        }
}
}
