import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Character6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character6 extends Character
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
    
    public Character6(int x, int y, String imagePath) {
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
            setBottomYCor();
        }
        quiz();
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
            //if(xVal<0) {
            setBottomYCor();
            super.act();
            //levelCompleted();
            gameOver();
        }
    }
    
    private int y2=250;
    public void setBottomYCor()
    {
        if(xVal>739&&xVal<1009&&getY()>=250 || xVal>1579&&xVal<1834&&getY()>=250 || xVal>2119&&xVal<2374&&getY()>=250 || xVal>2524&&xVal<2779&&getY()>=250 ||xVal>2959&&xVal<3187&&getY()>=250) {
            Level6Final.level6sound.stop();
            Character4.lifelost.play();
            setImage(image);
            for(int i=0;i<5;i++) {
                y2+=10;
                setLocation(xVal,y2);
                Greenfoot.delay(1);
            }
            LifeLostScreen l = new LifeLostScreen();
            Greenfoot.setWorld(l);
            Greenfoot.delay(200);
            Home.playMusic(Levels.map);
            Levels a = new Levels();
            Greenfoot.setWorld(a);
            Levels.numLives--;
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
    
    public void quiz() {
         if(xVal>1019&&!q1asked) {
            String ans1=Greenfoot.ask("True or False: A solid substance cannot go directly from solid to gas. It must pass the liquid state. (Type 'T' or 'F')");
            while(!ans1.equals("F")) {
                ans1=Greenfoot.ask("Try again! True or False: A solid substance cannot go directly from solid to gas. It must pass the liquid state. (Type 'T' or 'F')");
            }
            String ans2=Greenfoot.ask("Correct! A solid can go from solid to gas, as we saw with potassium. This process is called...");
            while(!(ans2.equals("Sublimation")||ans2.equals("sublimation"))) {
                ans2=Greenfoot.ask("Try again! A solid can go from solid to gas, as we saw with potassium. This process is called...");
            }
            String ans3=Greenfoot.ask("Correct! Is the process of sublimation endothermic (energy is applied) or exothermic (energy is released)? Type 'A' for endothermic or 'B' for exothermic.");
            while(!ans3.equals("A")) {
                ans3=Greenfoot.ask("Try again! Is the process of sublimation endothermic (energy is applied) or exothermic (energy is released)? Type 'A' for endothermic or 'B' for exothermic.");
            }
            System.out.println("Correct! To recap, sublimation is the process in which a solid substance turns into a gaseous one. This is necessary because ions must be gaseous to chemically react. Sublimation is an endothermic process because we need to apply energy to turn a solid into a gas.");
            q1asked=true;
        }
        if(xVal>1844&&!q2asked) {
            String ans1=Greenfoot.ask("True or False: In order to form a salt (ionic compound), potassium must lose an electron. (Type 'T' or 'F')");
            while(!ans1.equals("T")) {
                ans1=Greenfoot.ask("Try again! True or False: In order to form a salt (ionic compound), potassium must lose an electron. (Type 'T' or 'F')");
            }
            String ans2=Greenfoot.ask("Correct! If potassium has 1 valence electron, will it gain or lose electrons? Type 'g' for gain and 'l' for lose.");
            while(!(ans2.equals("l")||ans2.equals("L"))) {
                ans2=Greenfoot.ask("Try again! If potassium has 1 valence electron, will it gain or lose electrons? Type 'g' for gain and 'l' for lose.");
            }
            String ans3=Greenfoot.ask("Correct! Is the process of ionization (for potassium) endothermic (energy is applied) or exothermic (energy is released)? Type 'A' for endothermic or 'B' for exothermic.");
            while(!ans3.equals("A")) {
                ans3=Greenfoot.ask("Try again! Is the process of ionization (for potassium) endothermic (energy is applied) or exothermic (energy is released)? Type 'A' for endothermic or 'B' for exothermic.");
            }
            System.out.println("Correct! To recap, ionization energy is the energy associated with the gaining or loss of an electron. Potassium forms the 1+ cation, which it means it loses one electron. To break off that electron, energy is applied, thus making the process endothermic.");
            q2asked=true;
        }
        if(xVal>2384&&!q3asked) {
            String ans1=Greenfoot.ask("True or False: Chlorine in its natural state forms the Cl- ion. (Type 'T' or 'F')");
            while(!ans1.equals("F")) {
                ans1=Greenfoot.ask("Try again! True or False: Chlorine in its natural state forms the Cl- ion. Remember, chlorine is diatomic! (Type 'T' or 'F')");
            }
            String ans2=Greenfoot.ask("Correct! Chlorine is diatomic, so it must separate into its nascent form, Cl. The energy associated with breaking the bonds between the two Cl atoms in Cl2 is called...");
            while(!(ans2.equals("bond energy")||ans2.equals("Bond Energy")||ans2.equals("Bond energy"))) {
                ans2=Greenfoot.ask("Try again! The energy associated with breaking the bonds between the two Cl atoms in Cl2 is called...");
            }
            String ans3=Greenfoot.ask("Correct! Is the process of breaking bonds endothermic (energy is applied) or exothermic (energy is released)? Type 'A' for endothermic or 'B' for exothermic.");
            while(!ans3.equals("A")) {
                ans3=Greenfoot.ask("Try again! Is the process of separating chlorine endothermic (energy is applied) or exothermic (energy is released)? Type 'A' for endothermic or 'B' for exothermic.");
            }
            System.out.println("Correct! To recap, chlorine is naturally a diatomic gas (Cl2 (g)). However, to bond with K+, we only a Cl- ion which requires chlorine to separate into its nascent form. Because a bond is being broken, energy must be applied, making it an endothermic process.");
            q3asked=true;
        }
        if(xVal>2789&&!q4asked) {
            String ans1=Greenfoot.ask("True or False: In order to form a salt (ionic compound), chlorine must gain an electron to form an anion. (Type 'T' or 'F')");
            while(!ans1.equals("T")) {
                ans1=Greenfoot.ask("Try again! True or False: In order to form a salt (ionic compound), chlorine must gain an electron to form an anion. (Type 'T' or 'F')");
            }
            String ans2=Greenfoot.ask("Correct! If chlorine has 7 valence electron, will it gain or lose electrons? Type 'g' for gain and 'l' for lose.");
            while(!(ans2.equals("g")||ans2.equals("G"))) {
                ans2=Greenfoot.ask("Try again! If chlorine has 7 valence electron, will it gain or lose electrons? Remember, we are trying to get to 8 valence electrons. Think about which process will be easier. Type 'g' for gain and 'l' for lose.");
            }
            String ans3=Greenfoot.ask("Correct! Is the process of ionization (for chlorine) endothermic (energy is applied) or exothermic (energy is released)? Type 'A' for endothermic or 'B' for exothermic.");
            while(!ans3.equals("B")) {
                ans3=Greenfoot.ask("Try again! Is the process of ionization (for chlroine) endothermic (energy is applied) or exothermic (energy is released)? Type 'A' for endothermic or 'B' for exothermic.");
            }
            System.out.println("Correct! To recap, ionization energy is the energy associated with the gaining or loss of an electron. Chlorine forms the 1- cation, which it means it gains one electron. With the addition of that electron, energy is released, making the process exothermic.");
            q4asked=true;
        }
        if(xVal>3197&&!q5asked) {
            String ans1=Greenfoot.ask("True or False: There is a change in energy when potassium and chlorine ions form ionic bonds. (Type 'T' or 'F')");
            while(!ans1.equals("T")) {
                ans1=Greenfoot.ask("Try again! True or False: There is a change in energy when potassium and chlorine ions form ionic bonds. (Type 'T' or 'F')");
            }
            String ans2=Greenfoot.ask("Correct! When these ions bond, they form a lattice structure. This energy associated with process is called...");
            while(!(ans2.equals("lattice energy")||ans2.equals("Lattice energy")||ans2.equals("Lattice Energy"))) {
                ans2=Greenfoot.ask("Try again! When these ions bond, they form a lattice structure. This energy associated with process is called...");
            }
            String ans3=Greenfoot.ask("Correct! Is this process endothermic (energy is applied) or exothermic (energy is released)? Type 'A' for endothermic or 'B' for exothermic.");
            while(!ans3.equals("B")) {
                ans3=Greenfoot.ask("Try again! Is this endothermic (energy is applied) or exothermic (energy is released)? Type 'A' for endothermic or 'B' for exothermic.");
            }
            System.out.println("Correct! Now, the reaction can occur! Run to the end of the world to continue.");
            q5asked=true;
        }
        if(xVal>3300&&q5asked) {
            levelCompleted();
        }
    }
}
