import greenfoot.*; 

/**
 * The game board. The board had a paddle that can move.
 * 
 * @author mik
 * @version 1.0
 */
public class Board extends World
{
    private Paddle paddle;

    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board()
    {    
        super(960, 620, 1);
        GreenfootImage img=new GreenfootImage("Space.png");
        img.scale(getWidth(),getHeight());
        setBackground(img);

        setPaintOrder ( Ball.class, Smoke.class );
        Score s=new Score();

        paddle = new Paddle(s);
        addObject ( paddle, getWidth() / 2, getHeight() - 40);

        addObject(s,58,56);

        createBlocks();

        prepare();
    }

    private void createBlocks()
    {
        int deltaX= 67 ,deltaY= 52 ,x,y= 121,randomNo;
        while(y<getHeight()/2)
        {
            x=163;
            while(x<getWidth()-163)
            {
                randomNo=Greenfoot.getRandomNumber(100);
                if(randomNo<20)
                    addObject(new DoubleBrick(),x, y);
                else
                    addObject(new SimpleBrick(),x, y);
                x+=deltaX;
            }
            y+=deltaY;
        }

    }

    public void ballIsOut()
    {
        paddle.newBall();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        PowerBrick powerbrick = new PowerBrick();
        addObject(powerbrick, 506, 433);
        PowerBrick powerbrick2 = new PowerBrick();
        addObject(powerbrick2, 412, 434);
        PowerBrick powerbrick3 = new PowerBrick();
        addObject(powerbrick3, 304, 432);
        PowerBrick powerbrick4 = new PowerBrick();
        addObject(powerbrick4, 256, 412);
        PowerBrick powerbrick5 = new PowerBrick();
        addObject(powerbrick5, 614, 431);
        PowerBrick powerbrick6 = new PowerBrick();
        addObject(powerbrick6, 696, 416);
        removeObject(powerbrick6);
        removeObject(powerbrick5);
        removeObject(powerbrick);
        removeObject(powerbrick2);
        removeObject(powerbrick3);
        removeObject(powerbrick4);
        PowerBrick powerbrick7 = new PowerBrick();
        addObject(powerbrick7, 524, 359);
        PowerBrick powerbrick8 = new PowerBrick();
        addObject(powerbrick8, 429, 361);
        PowerBrick powerbrick9 = new PowerBrick();
        addObject(powerbrick9, 316, 367);
        PowerBrick powerbrick10 = new PowerBrick();
        addObject(powerbrick10, 679, 363);
        PowerBrick powerbrick11 = new PowerBrick();
        addObject(powerbrick11, 212, 376);
        PowerBrick powerbrick12 = new PowerBrick();
        addObject(powerbrick12, 614, 370);
    }
    
    public Paddle getPaddle(){
        return paddle;
    }
}
