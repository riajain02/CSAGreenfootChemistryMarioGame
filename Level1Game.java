import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Level1Game here.
 * 
 * @author Ria Jain, Tinh-Phong Nguyen
 * @version 1.0
 */
public class Level1Game extends SWorld
{
    public static Character1 mar = new Character1(65,95,"initialK.png");
    public static BrickBlock brickBlock;
    public static BrickBlock brickBlock2;
    public static BrickBlock brickBlock3;
    public static BrickBlock brickBlock4;
    public static BrickBlock brickBlock5;
    public static BrickBlock brickBlock6;
    public static QuestionBlock qBlock1;
    public static QuestionBlock qBlock2;
    public static QuestionBlock qBlock3;
    public static GreenfootSound level1 = new GreenfootSound("level4.mp3");
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
    public static Tubes tubeL = new Tubes("l");
    public static Tubes tubeM2 = new Tubes("m");
    public static Tubes tubeL2 = new Tubes("l");
    public static Components hole = new Components("hole.png",120,70);
    public static Goomba goomba1 = new Goomba();
    public static Goomba goomba2 = new Goomba();
    public static EndFlag endflag = new EndFlag();
    
    /**
     * Constructor for objects of class Level1Game.
     * 
     */
    public Level1Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1, 3750);
        GreenfootImage level1background = new GreenfootImage("level4bg.png");
        Components ground = new Components("level4ground.png",3755,70);
        addObject(ground,3750/2,490);
        addObject(hole,1650,490);
        addMainActor(mar,375,250,450,500);
        setScrollingBackground(level1background);
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
        addObject(goomba1,2800,(410+95/2)-64/2);
        addObject(goomba2,3300,(410+95/2)-64/2);
        addObject(endflag,3550,410+95/2-96*3/2);
        Levels.map.stop();
        mar.setLocation(100,410);
        initialized=true;
    }
    
    public void act()
    {
        if(initialized==false) {
            initialized=true;
        }
        Home.playMusic(level1);
        if(counter==0) {
            numCoins=0;
            counter++;
        }
        mar.run(15);
        super.act();
        showText(("COINS × " + numCoins + "          ENERGY: " + round(numCoins*(9.0),1) + " kJ"),200,30);
        showText(("LIVES × " + Levels.numLives),75,60);
        if(Level1Game.initialized) {
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
