import greenfoot.*; 
import java.util.*;
import java.awt.Color;

/**
 * The game board. The board had a paddle that can move.
 * 
 * @author mik
 * @version 1.0
 */
public class Board extends World
{
    private Paddle paddle;
    private Score s;
    private int numberOfLives=3;
    private List objects;
    private GreenfootImage gameOver,scoreBoard;

    /**
     * Constructor for objects of class Board.
     * 
     */
    private Lives lives[]=new Lives[3];
    public Board()
    {   
       
        
        super(960, 620, 1);
       
        GreenfootImage img=new GreenfootImage("Space.png");
        img.scale(getWidth(),getHeight());
        setBackground(img);

        setPaintOrder ( Ball.class, Smoke.class );
        s=new Score();
        addObject(s,58,56);

        paddle = new Paddle(s);
        addObject ( paddle, getWidth() / 2, getHeight() - 40);

        
        
        createLives();

        createBlocks();
    
        
    }

    
    
        private void createLives()
        {
            int x=863,y=35,deltaX=30;
        
          for(int i=0;i<lives.length;i++)
          {
            lives[i]=new Lives();
            addObject(lives[i],x,y);
            x+=deltaX;
          }
       }
       
       
       
       /**
        * Creates the blocks 
        */
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
                    addObject(new PowerBrick(),x, y);
                else
                if(randomNo<50)
                    addObject(new DoubleBrick(),x, y);
                    else
                    addObject(new SimpleBrick(),x, y);
                x+=deltaX;
            }
            y+=deltaY;
        }

    }
    
    /**
     * Triggers necessary events when ball is missed by the bar
     */

    public void ballIsOut()
    {
        
        if(numberOfLives>0)removeObject(lives[3-numberOfLives]);
        numberOfLives--;
        Greenfoot.playSound("lost_life.mp3");
        if(checkLife())
        {
            objects=getObjects(Bricks.class);
            removeObjects(objects);
            gameOver();
        }
        
        paddle.newBall();
    }

   

    
    public Paddle getPaddle(){
        return paddle;
    }
    
    
    
    private boolean checkLife()
    {
        if(numberOfLives==0)return true;
        else return false;
    }
    
    
    /**
     * Displays score when the game is over
     */
    private void gameOver()
    {
         scoreBoard=new GreenfootImage("Final Score : "+s.getScore(),40,Color.WHITE,null,Color.BLUE);
        gameOver=new GreenfootImage("GAME OVER",60,Color.WHITE,null,Color.BLUE);

        
        getBackground().drawImage(gameOver,297,173);
        getBackground().drawImage(scoreBoard,317,173+100);
        
    }
    
    
        
}
