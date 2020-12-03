import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Level3Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3Game extends SWorld
{
    public static Character3 m = new Character3(65,95,"initialK.png");
    public static BrickBlock brickBlock;
    public static BrickBlock brickBlock2;
    public static BrickBlock brickBlock3;
    public static QuestionBlock qBlock1;
    public static QuestionBlock qBlock2;
    public static QuestionBlock qBlock3;
    public static GreenfootSound level4 = new GreenfootSound("level4.mp3");
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
    public static List<RedMushroom2> redMs2;
    public static List<GreenMushroom2> greenMs2;
    public static int counter=0;
    public static int counterr=0;
    public static List<Character> mario;
    public static boolean initialized = false;
    public static Tubes tubeS = new Tubes("s");
    public static Tubes tubeM = new Tubes("m");
    public static Tubes tubeL = new Tubes("l");
    public static Tubes tubeM2 = new Tubes("m");
    public static Tubes tubeL2 = new Tubes("l");
    //public static Components hole = new Components("hole.png",120,70);
    public static Thwomp th1 = new Thwomp();
    public static Thwomp th2 = new Thwomp();
    public static Thwomp th3 = new Thwomp();
    public static EndFlag endflag = new EndFlag();
    /**
     * Constructor for objects of class Level3Game.
     * 
     */
    public Level3Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1, 3750);
        GreenfootImage level3background = new GreenfootImage("level3bg.png");
        
        //Components ground = new Components("level4ground.png",3755,70);
        //addObject(ground,3750/2,490);
        //addObject(hole,1650,490);
        addMainActor(m,375,250,450,500);
        setScrollingBackground(level3background);
        brickBlock = new BrickBlock();
        brickBlock2 = new BrickBlock();
        brickBlock3 = new BrickBlock();
        addObject(brickBlock,250,300);
        addObject(brickBlock2,370,300);
        addObject(brickBlock3,1885,300);
        qBlock1 = new QuestionBlock(1);
        qBlock2 = new QuestionBlock(2);
        qBlock3 = new QuestionBlock(3);
        addObject(qBlock1,290,300);
        addObject(qBlock2,330,300);
        addObject(qBlock3,1925,300);
        addObject(coin1,310,150);
        addObject(coin2,750,(410+95/2)-64-100);
        addObject(coin3,950,(410+95/2)-90-100);
        addObject(coin4,1150,(410+95/2)-118-100);
        addObject(coin5,1350,(410+95/2)-90-100);
        addObject(coin6,1885+20,150);
        addObject(coin7,2250,(410+95/2)-90-100);
        addObject(coin8,(2800-100),(410+95/2-175));
        addObject(coin9,(3050-100),(410+95/2-175));
        addObject(coin10,(3300-100),(410+95/2-175));
        addObject(tubeL,750,(410+95/2)-64/2);
        addObject(tubeS,950,440);
        addObject(tubeM,1150,440);
        addObject(tubeM2,1350,440);
        addObject(tubeL2,2250,440);
        addObject(th1,2800,450);
        addObject(th2,3050,450);
        addObject(th3,3300,450);
        addObject(endflag,3550,410+95/2-96*3/2);
        Levels.map.stop();
        //Home.playMusic(level4);
        m.setLocation(100,410);
        initialized=true;
    }
    
    public void act()
    {
        if(initialized==false) {
            initialized=true;
        }
        Home.playMusic(level4);
        if(counter==0) {
            numCoins=0;
            counter++;
        }
        m.run(15);
        super.act();
        showText(("COINS × " + numCoins + "          ENERGY: " + round(numCoins*(11.95),1) + " kJ"),200,30);
        showText(("LIVES × " + Levels.numLives),75,60);
        if(Level3Game.initialized) {
            Character3.coins = getObjects(Coin.class);
            Character3.bricks = getObjects(BrickBlock.class);
            Character3.qBlocks = getObjects(QuestionBlock.class);
            //Character3.powerups = getObjects(PowerUps.class);
        }
        redMs2 = getObjects(RedMushroom2.class);
        greenMs2 = getObjects(GreenMushroom2.class);
        if(redMs2.size()>0 && greenMs2.size()>0) {
            PowerUps.moveRedGreenM2(redMs2.get(0),greenMs2.get(0));
            removeObject(redMs2.get(0));
            removeObject(greenMs2.get(0));
        }
        else if(redMs2.size()>0) {
            for(RedMushroom2 r : redMs2) {
                r.moveRedM(r);
                removeObject(r);
            }
        }
        else if(greenMs2.size()>0) {
            for(GreenMushroom2 g : greenMs2) {
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
