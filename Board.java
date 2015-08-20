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
}
