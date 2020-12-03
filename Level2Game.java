import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Level2Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2Game extends SWorld
{
    public static Character2 m = new Character2(50,75,"initialK.png");
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
    //public static Spiny spiny1 = new Spiny();
    //public static Spiny spiny2 = new Spiny();
    //public static Spiny spiny3 = new Spiny();
    //public static Spiny spiny4 = new Spiny();
    public static EndFlag endflag = new EndFlag();
    /**
     * Constructor for objects of class Level2Game.
     * 
     */
    public Level2Game()
    {
        super(750, 500, 1, 2250);
        GreenfootImage level4background = new GreenfootImage("backgroundtest.png");
        addMainActor(m,375,250,450,500);
        setScrollingBackground(level4background);
    }
    
    public void act()
    {
        m.run(15);
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
        showText(("COINS × " + numCoins + "          ENERGY: " + (Math.round(numCoins*(41.9))) + " kJ"),200,30);
        showText(("LIVES × " + Levels.numLives),75,60);
        if(Level2Game.initialized) {
            Character2.coins = getObjects(Coin.class);
            Character2.bricks = getObjects(BrickBlock.class);
            Character2.qBlocks = getObjects(QuestionBlock.class);
            //Character2.powerups = getObjects(PowerUps.class);
        }
    }
}
