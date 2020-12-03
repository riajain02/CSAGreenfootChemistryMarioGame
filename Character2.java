    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.List;
    
    /**
     * Write a description of class Characters here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Character2 extends Character
    {
        public GreenfootImage image;
        public int xCor;
        public int yCor;
        public int xVal;
        public int yVal;
        private int type=0;
        private GreenfootSound coin = new GreenfootSound("coin.mp3");
        private GreenfootImage brickHit = new GreenfootImage("brickblockhit.png");
        private GreenfootSound bump = new GreenfootSound("blockbump.wav");
        private GreenfootSound powerup = new GreenfootSound("powerup.mp3");
        private GreenfootSound oneup = new GreenfootSound("1-up.mp3");
        private GreenfootSound powerupappears = new GreenfootSound("power-up-appears.mp3");
        private GreenfootSound jump = new GreenfootSound("jump.wav");
        private GreenfootSound spiny = new GreenfootSound("smash.wav");
        private GreenfootSound lifelost = new GreenfootSound("life-lost.mp3");
        private GreenfootSound levelcompleted = new GreenfootSound("levelcomplete.wav");
        private boolean touching=false;
        private static int counter=0;
        public static List<Coin> coins;
        public static List<BrickBlock> bricks;
        public static List<QuestionBlock> qBlocks;
        public static List<PowerUps> powerups;
        private int minYCor = 410;
        private boolean blocks=false;
        private boolean blocks2=false;
        public static RedMushroom redM1;
        public static GreenMushroom greenM1;
        private int powerUpCounter=0;
        private GreenfootImage marioFrontL = new GreenfootImage("mariorunfrontL.png");
        private GreenfootImage marioBackL = new GreenfootImage("mariorunbackL.png");
        private GreenfootImage marioSideL = new GreenfootImage("mariostraightL.png");
        private static boolean xLim=false;
        public static boolean alive=true;
        public static int counterr=0;
        private int y;
        private boolean spinyCounter=true;
        
        public Character2(int x, int y, String imagePath) {
            image = new GreenfootImage(imagePath);
            image.scale(x,y);
            setImage(image);
        }
        
        public Character2(GreenfootImage image) {
            setImage(image);
        }
        
        /**
         * Act - do whatever the Characters wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act()
        {
            if(counterr==0) {
                xVal=getX(); 
                yVal=getY(); 
                counterr++; 
                counter=0; 
                Level2Game.numCoins=0;
                spinyCounter=true;
                coins=getWorld().getObjects(Coin.class);
                for(Coin c : coins) {
                    c.coinRemoved=false;
                }
                alive=true;
            }
        }
        
        public void run(int x) 
        {
            Animation.marioFront.scale(75,100);
            Animation.marioSide.scale(75,100);
            Animation.marioBack.scale(75,100);
            marioFrontL.scale(75,100);
            marioSideL.scale(75,100);
            marioBackL.scale(75,100);
            xCor=getX();
            yCor=getY();
            if(Greenfoot.isKeyDown("right")) {
                if((!intersects(Level2Game.tubeS)||xVal>770)&&(!intersects(Level2Game.tubeM)||xVal>970)&&(!intersects(Level2Game.tubeL)||xVal>1170)&&(!intersects(Level2Game.tubeM2)||xVal>1370)&&(!intersects(Level2Game.tubeL2)||xVal>2570)) {
                    int i=xCor;
                    xCor+=x;
                    if(i!=xCor && xCor!=764) {
                        xVal+=x;
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
                else {setImage(image);}
            }
            else if(Greenfoot.isKeyDown("left")) {
                if((!intersects(Level2Game.tubeS)||xVal<730)&&(!intersects(Level2Game.tubeM)||xVal<930)&&(!intersects(Level2Game.tubeL)||xVal<1130)&&(!intersects(Level2Game.tubeM2)||xVal<1330)&&(!intersects(Level2Game.tubeM2)||xVal>1370)&&(!intersects(Level2Game.tubeL2)||xVal>2570)) {
                    int i=xCor;
                    xCor-=x;
                    if(i!=xCor && xCor>=764) {
                        xVal-=x;
                    }
                    xVal-=x;
                    if(type==0) {
                        setImage(marioFrontL);
                        type=1;
                    }
                    else if(type==1) {
                        setImage(marioSideL);
                        type=2;
                    }
                    else if(type==2) {
                        setImage(marioBackL);
                        type=3;
                    }
                    else if(type==3) {
                        setImage(marioSideL);
                        type=0;
                    }
                    checkTouching();
                    setLocation(xCor,yCor);
                    Greenfoot.delay(3);
                }
                else {setImage(image);}
            }
            else if(Greenfoot.isKeyDown("up")) {
                setImage(image);
                jump.play();
                setBottomYCor();
                if(blocks && ((getY()-(95/2))>300)) {
                    for(int i=0;i<4;i++) {
                        yCor-=11;
                        yVal-=11;
                        checkTouching();
                        Greenfoot.delay(1);
                        setLocation(xCor,yCor);
                    }
                    for(int i=0;i<4;i++) {
                        yCor+=11;
                        yVal-=11;
                        checkTouching();
                        Greenfoot.delay(1);
                        setLocation(xCor,yCor);
                    }
                }
                else {
                    for(int i=0;i<20;i++) {
                        yCor-=10;
                        yVal-=10;
                        checkTouching();
                        Greenfoot.delay(1);
                        setLocation(xCor,yCor);
                    }
                }
                setBottomYCor();
                while((getY()+(95/2))<minYCor) {
                    setBottomYCor();
                    yCor+=10;
                    yVal-=10;
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
                jump.play();
                setBottomYCor();
                if(blocks) {
                    for(int i=0;i<4;i++) {
                        yCor-=11;
                        yVal-=11;
                        xCor+=4;
                        xVal+=4;
                        setLocation(xCor,yCor);
                        checkTouching();
                        Greenfoot.delay(1);
                    }
                    setBottomYCor();
                    while(getY()<minYCor) {
                        setBottomYCor();
                        yCor+=10;
                        xCor+=4;
                        xVal+=4;
                        yVal+=10;
                        checkTouching();
                        Greenfoot.delay(1);
                        setLocation(xCor,yCor);
                    }
                }
                else {
                    for(int i=0;i<20;i++) {
                        yCor-=10;
                        yVal-=10;
                        xCor+=4;
                        xVal+=4;
                        setLocation(xCor,yCor);
                        checkTouching();
                        Greenfoot.delay(1);
                    }
                    setBottomYCor();
                    if(getWorld().getObjects(Character2.class).size()>0) {
                        while((getY()+(95/2)<minYCor)) {
                            setBottomYCor();
                            yCor+=10;
                            yVal+=10;
                            xCor+=4;
                            xVal+=4;
                            checkTouching();
                            Greenfoot.delay(1);
                            setLocation(xCor,yCor);
                        }
                    }
                }
                setImage(image);
                type=0;
            }
            else if(Greenfoot.isKeyDown("up")&&Greenfoot.isKeyDown("left")) {
                setImage(marioSideL);
                jump.play();
                setBottomYCor();
                if(blocks) {
                    for(int i=0;i<4;i++) {
                        yCor-=11;
                        yVal-=11;
                        xCor-=4;
                        xVal-=4;
                        setLocation(xCor,yCor);
                        checkTouching();
                        Greenfoot.delay(1);
                    }
                    setBottomYCor();
                    while(getY()<minYCor) {
                        setBottomYCor();
                        yCor+=10;
                        yVal+=10;
                        xCor-=4;
                        xVal-=4;
                        checkTouching();
                        Greenfoot.delay(1);
                        setLocation(xCor,yCor);
                    }
                }
                else {
                    for(int i=0;i<20;i++) {
                        yCor-=10;
                        yVal-=10;
                        xCor-=4;
                        xVal-=4;
                        setLocation(xCor,yCor);
                        checkTouching();
                        Greenfoot.delay(1);
                    }
                    setBottomYCor();
                    while((getY()+(95/2))<minYCor) {
                        setBottomYCor();
                        yCor+=10;
                        yVal+=10;
                        xCor-=4;
                        xVal-=4;
                        checkTouching();
                        Greenfoot.delay(1);
                        setLocation(xCor,yCor);
                    }
                }
            setImage(image);
            type=0;
        }
        setBottomYCor();
        if(getWorld().getObjects(Character2.class)!=null) {
            if(getWorld().getObjects(Character2.class).size()>0) {
                if(alive) {
                    while(getY()+95/2<minYCor) {
                        setBottomYCor();
                        yCor+=10;
                        yVal+=10;
                        xCor+=4;
                        xVal+=4;
                        checkTouching();
                        Greenfoot.delay(1);
                        setLocation(xCor,yCor);
                    }
                }
            }
        }
    }
    
    /*public void touchingBrick(BrickBlock b)
    {
        if(intersects(b) && (getY()-95/2)<=320 && (getY()-95/2)>=300) {
            if(b.blockHit==false) {
               brickHit.scale(40,40);
               b.setImage(brickHit);
               bump.play();
            }
            b.blockHit=true;
        }
    }
    */
    
    public void touchingCoin(Coin c)
    {
        if(counter==0) {
            c.coinRemoved=false;
            counter++;
        }
        if(intersects(c)) {
            if(c.coinRemoved==false) {
                getWorld().removeObject(c);
                c.coinRemoved=true;
                touching=true;
                coin.play();
                Level2Game.numCoins++;
            }
        }
    }
    
   
    
    public void checkTouching()
    {
        if(Level2Game.initialized) {
            if(coins!=null) {
                for(Coin c : coins) {
                    touchingCoin(c);
                }
            }
            /*if(bricks!=null) {
                for(BrickBlock b : bricks) {
                    touchingBrick(b);
                }
            }
            /*if(qBlocks!=null) {
                for(QuestionBlock q : qBlocks) {
                    touchingQBlock(q,q.powerUpType);
                }
            }
            if(powerups!=null) {
                for(PowerUps p : powerups) {
                    powerUps(p);
                }
            }
            */
            //fall(Level2Game.m);
            //smash();
            if(alive && getWorld().getObjects(Spiny.class).size()>0) {
                if (((xVal > (2250-20) && xVal <= 2250) || (xVal > (2800-20) && xVal <=2800)||(xVal > (3050-20) && xVal <=3050)||(xVal > (3300-20) && xVal <=3300)) && getY()<400) { {
                    die(Level2Game.m);
                }
            }
            levelCompleted();
            gameOver();
            
        }
    }
}
    
    public void setBottomYCor()
    {
        if(xVal>230 && xVal<390 || xVal>1865 && xVal<1945) {
            blocks=true;
            if(yVal>320) {
                minYCor=410;
            }
            else {
                minYCor=280;
            }
        }
        else {
            blocks=false;
            minYCor=410+(95/2);
        }
        if(xVal>730&&xVal<770) {
            minYCor=423-95/2;
        }
        if(xVal>930&&xVal<970 || xVal>1330&&xVal<1370) {
            minYCor=397-95/2;
        }
        if(xVal>1130&&xVal<1170) {
            minYCor=369-95/2;
        }
    }
    
    /*public void fall(Character2 m) {
        if(intersects(Level4Game.hole)&& xVal>1600 && xVal<1660) {
            setImage(image);
            while(getY()<500) {
                yCor+=15;
                setLocation(xCor,yCor);
                Greenfoot.delay(3);
            }
            die(m);
        }
    }
    */
    
    /*public void spiny()
    {
        if(xVal>2700&&xVal<2900 && spinyCounter) {
            y=Level2Game.spiny1.getY();
            spiny.play();
            while(y<430) {
                y+=16;
                run(15);
                Level2Game.spiny1.setLocation(Level2Game.spiny1.getX(),y);
                if(intersects(Level2Game.spiny1)) {
                    die(Level2Game.m);
                }
                Greenfoot.delay(1);
            }
            spinyCounter=false;
        }
        else if(xVal>2950&&xVal<3150) {
            y=Level2Game.spiny2.getY();
            spiny.play();
            while(y<430) {
                y+=16;
                run(15);
                Level2Game.spiny2.setLocation(Level2Game.spiny2.getX(),y);
                if(intersects(Level2Game.spiny2)) {
                    die(Level2Game.m);
                }
                Greenfoot.delay(1);
            }
            spinyCounter=false;
        }
        else if(xVal>3200&&xVal<3400) {
            y=Level2Game.spiny3.getY();
            spiny.play();
            while(y<430) {
                y+=16;
                run(15);
                Level2Game.spiny3.setLocation(Level2Game.spiny3.getX(),y);
                if(intersects(Level2Game.spiny3)) {
                    die(Level2Game.m);
                }
                Greenfoot.delay(1);
            }
            spinyCounter=false;
        }
    }
    */
    
    public void levelCompleted()
    {
        if(getWorld().getObjects(EndFlag.class)!=null) {
            if(getWorld().getObjects(EndFlag.class).size()>0) {
                if(intersects(Level2Game.endflag)) {
                    if(Level2Game.numCoins>=10) {
                        Level2Game.level2.stop();
                        levelcompleted.play();
                        setImage(image);
                        Greenfoot.delay(100);
                        int x=getX();
                        int type2=0;
                        System.out.println();
                        while(xVal<3750) {
                            x+=15;
                            if(type==0) {
                                setImage(Animation.marioFront);
                                type2=1;
                            }
                            else if(type==1) {
                                setImage(Animation.marioSide);
                                type2=2;
                            }
                            else if(type==2) {
                                setImage(Animation.marioBack);
                                type2=3;
                            }
                            else if(type==3) {
                                setImage(Animation.marioSide);
                                type2=0;
                            }
                            setLocation(x,410);
                            Greenfoot.delay(3);
                        }
                        getWorld().removeObject(Level2Game.m);
                        Levels a = new Levels();
                        Greenfoot.setWorld(a);
                        if(LevelPage.levelsCompleted<4) {
                            LevelPage.levelsCompleted=4;
                        }
                        Levels.numTotCoins+=10;
                    }
                    else {
                        Level2Game.level2.stop();
                        NotEnoughCoins n=new NotEnoughCoins();
                        Greenfoot.setWorld(n);
                        Greenfoot.delay(500);
                        Levels a = new Levels();
                        Greenfoot.setWorld(a);
                    }
                }
            }
        }
    }
    
    public void die(Character2 m) {
        if(alive) {
            getWorld().removeObject(m);
            Level2Game.level2.stop();
            lifelost.play();
            LifeLostScreen l = new LifeLostScreen();
            Greenfoot.setWorld(l);
            Greenfoot.delay(200);
            Home.playMusic(Levels.map);
            Levels a = new Levels();
            Greenfoot.setWorld(a);
            Levels.numLives--;
            if(Levels.numLives<=0) {
                gameOver();
            }
            else {
                alive=false;
            }
        }
    }
    
    public void gameOver() {
        if(Levels.numLives<=0 && alive) {
            GameOver g = new GameOver();
            Greenfoot.setWorld(g);
            alive=false;
        }
    }
}
