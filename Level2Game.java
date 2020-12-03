import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Level2Game here.
 * 
 * @ Chelsea Lee
 * @version 1.1
 */
public class Level2Game extends SWorld
{
    public static Character2 m = new Character2(50,75,"initialK.png");
<<<<<<< HEAD
=======
    public static BrickBlock brickBlock;
    public static BrickBlock brickBlock2;
    public static BrickBlock brickBlock3;
    public static BrickBlock brickBlock4;
    public static BrickBlock brickBlock5;
    public static BrickBlock brickBlock6;
    public static GreenfootSound level2 = new GreenfootSound("level4.mp3");
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
    //public static List<RedMushroom> redMs;
    //public static List<GreenMushroom> greenMs;
    public static int counter=0;
    public static int counterr=0;
    public static List<Character> mario;
    public static boolean initialized = false;
    public static Tubes tubeS = new Tubes("s");
    public static Tubes tubeM = new Tubes("m");
    public static Tubes tubeL = new Tubes("l");
    public static Tubes tubeM2 = new Tubes("m");
    public static Tubes tubeL2 = new Tubes("l");
    public static Components hole = new Components("hole.png",120,70);
    public static Spiny spiny1 = new Spiny();
    public static Spiny spiny2 = new Spiny();
    public static Spiny spiny3 = new Spiny();
    public static Spiny spiny4 = new Spiny();
    public static EndFlag endflag = new EndFlag();
>>>>>>> f6e45d2f51750db02e103ab30ac97b184f21c850
    /**
     * Constructor for objects of class Level2Game.
     * 
     */
    public Level2Game()
    {
        super(750, 500, 1, 3750);
        GreenfootImage level2background = new GreenfootImage("level2bg.png");
        addMainActor(m,375,250,450,500);
        setScrollingBackground(level2background);
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
        addObject(coin4,1150,(410+95/2)-118-100);
        addObject(coin5,1350,(410+95/2)-90-100);
        addObject(coin6,1885+20,150);
        addObject(coin7,2250,(410+95/2)-90-100);
        addObject(coin8,2800,(410+95/2-175));
        addObject(coin9,3050,(410+95/2-175));
        addObject(coin10,3300,(410+95/2-175));
        addObject(tubeS,750,(410+95/2)-64/2);
        addObject(tubeM,950,(410+95/2)-90/2);
        addObject(tubeL,1150,(410+95/2)-118/2);
        addObject(tubeM2,1350,(410+95/2)-90/2);
        addObject(tubeL2,2500,(410+95/2)-118/2);
        addObject(spiny1,2800,420);
        addObject(spiny2,3050,420);
        addObject(spiny3,3300,420);
        addObject(spiny4,2250,420);
        addObject(endflag,3550,410+95/2-96*3/2);
        Levels.map.stop();
        //Home.playMusic(level4);
        m.setLocation(100,410);
        initialized=true;
    }
    
    public void act()
    {
<<<<<<< HEAD
        m.run();
=======
        if(initialized==false) {
            initialized=true;
        }
        Home.playMusic(level2);
        if(counter==0) {
            numCoins=0;
            counter++;
        }
        m.run(15);
        super.act();
        showText(("COINS × " + numCoins + "          ENERGY: " + round(numCoins*(41.9),1) + " kJ"),200,30);
        showText(("LIVES × " + Levels.numLives),75,60);
        if(Level2Game.initialized) {
            Character2.coins = getObjects(Coin.class);
            Character2.bricks = getObjects(BrickBlock.class);
            Character2.qBlocks = getObjects(QuestionBlock.class);
            //Character2.powerups = getObjects(PowerUps.class);
        }
        
>>>>>>> f6e45d2f51750db02e103ab30ac97b184f21c850
    }
    
    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
    }

