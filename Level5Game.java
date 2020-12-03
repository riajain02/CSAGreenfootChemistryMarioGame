import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
<<<<<<< HEAD

/**
 * Write a description of class Level2Game here.
=======
import java.util.List;

/**
 * Write a description of class Level5Game here.
>>>>>>> e246bafc33a4a9fc596d202eaef79925b17deeeb
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level5Game extends SWorld
{
<<<<<<< HEAD
    private Actor m = new Character(50,75,"initialK.png");
    /**
     * Constructor for objects of class Level2Game.
     * 
     */
    public Level5Game()
    {
        super(750, 500, 1, 2250);
        GreenfootImage level4background = new GreenfootImage("backgroundtest.png");
        setScrollingBackground(level4background);
        addMainActor(m,375,250,450,500);
=======
    public static Character5 mari = new Character5(65,95,"initialK.png");
    public static BrickBlock brickBlock;
    public static BrickBlock brickBlock2;
    public static BrickBlock brickBlock3;
    public static BrickBlock brickBlock4;
    public static BrickBlock brickBlock5;
    public static BrickBlock brickBlock6;
    public static GreenfootSound level5 = new GreenfootSound("level4.mp3");
    public static int lowestHeight=500;
    public static int numCoins=0;
    public static Coin coin1 = new Coin();
    public static Coin coin2 = new Coin();
    public static Coin coin3 = new Coin();
    public static Coin coin4 = new Coin();
    public static Coin coin5 = new Coin(); 
    public static Coin coin6 = new Coin();
    public static Coin coin7 = new Coin();
    public static Coin coin8 = new Coin();
    public static Coin coin9 = new Coin();
    public static Coin coin10 = new Coin();
    public static List<RedMushroom> redMs;
    public static List<GreenMushroom> greenMs;
    public static int counter=0;
    public static int counterr=0;
    public static List<Character> mario;
    public static boolean initialized = false;
    public static Tubes tubeS = new Tubes("s");
    public static Tubes tubeM = new Tubes("m");
    public static Goomba goomba1 = new Goomba();
    public static Tubes tubeM2 = new Tubes("m");
    public static Goomba goomba2 = new Goomba();
    public static Components hole = new Components("hole.png",120,70);
    public static Smasher smasher1 = new Smasher();
    public static Smasher smasher2 = new Smasher();
    public static Smasher smasher3 = new Smasher();
    public static EndFlag endflag = new EndFlag();
    
    /**
     * Constructor for objects of class Level5Game.
     * 
     */
    public Level5Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1, 3750);
        GreenfootImage level4background = new GreenfootImage("cityskyline.png");
        Components ground = new Components("level4ground.png",3755,70);
        addObject(ground,3750/2,490);
        addObject(hole,1650,490);
        addMainActor(mari,375,250,450,500);
        setScrollingBackground(level4background);
        brickBlock = new BrickBlock();
        brickBlock2 = new BrickBlock();
        brickBlock3 = new BrickBlock();
        brickBlock4 = new BrickBlock();
        brickBlock5 = new BrickBlock();
        brickBlock6 = new BrickBlock();
        addObject(brickBlock,250,300);
        addObject(brickBlock2,370,300);
        addObject(brickBlock3,1885,300);
        addObject(brickBlock4,290,300);
        addObject(brickBlock5,330,300);
        addObject(brickBlock6,1925,300);
        addObject(coin1,310,150);
        addObject(coin2,750,(410+95/2)-64-100);
        addObject(coin3,950,(410+95/2)-90-100);
        addObject(coin4,1150,(410+95/2)-118-60);
        addObject(coin5,1350,(410+95/2)-90-100);
        addObject(coin6,1885+20,150);
        addObject(coin7,2250,(410+95/2)-90-60);
        addObject(coin8,2800,(410+95/2-175));
        addObject(coin9,3050,(410+95/2-175));
        addObject(coin10,3300,(410+95/2-175));
        addObject(tubeS,750,(410+95/2)-64/2);
        addObject(tubeM,950,(410+95/2)-90/2);
        addObject(goomba1,1150,(410+95/2)-64/2);
        addObject(tubeM2,1350,(410+95/2)-90/2);
        addObject(goomba2,2500,(410+95/2)-64/2);
        addObject(smasher1,2800,25);
        addObject(smasher2,3050,25);
        addObject(smasher3,3300,25);
        addObject(endflag,3550,410+95/2-96*3/2);
        Levels.map.stop();
        //Home.playMusic(level4);
        mari.setLocation(100,410);
        initialized=true;
>>>>>>> e246bafc33a4a9fc596d202eaef79925b17deeeb
    }
    
    public void act()
    {
<<<<<<< HEAD
        //m.run();
    }
}

=======
        if(initialized==false) {
            initialized=true;
        }
        Home.playMusic(level5);
        if(counter==0) {
            numCoins=0;
            counter++;
        }
        mari.run(15);
        super.act();
        showText(("COINS × " + numCoins + "          ENERGY: " + round(numCoins*(-69),1) + " kJ"),200,30);
        showText(("LIVES × " + Levels.numLives),75,60);
        if(Level5Game.initialized) {
            Character4.coins = getObjects(Coin.class);
            Character4.bricks = getObjects(BrickBlock.class);
            Character4.qBlocks = getObjects(QuestionBlock.class);
            Character4.powerups = getObjects(PowerUps.class);
        }
        redMs = getObjects(RedMushroom.class);
        greenMs = getObjects(GreenMushroom.class);
        if(redMs.size()>0 && greenMs.size()>0) {
            PowerUps.moveRedGreenM(redMs.get(0),greenMs.get(0));
            removeObject(redMs.get(0));
            removeObject(greenMs.get(0));
        }
        else if(redMs.size()>0) {
            for(RedMushroom r : redMs) {
                r.moveRedM(r);
                removeObject(r);
            }
        }
        else if(greenMs.size()>0) {
            for(GreenMushroom g : greenMs) {
                g.moveGreenM(g);
                removeObject(g);
            }
        }
    }
    
    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
>>>>>>> e246bafc33a4a9fc596d202eaef79925b17deeeb
