import greenfoot.*;
import java.util.*;

/**
 * The ball of the game. It moves and bounces off the walls and the paddle.
 * 
 * @author mik
 * @version 1.0
 */
public class Ball extends Actor
{
    private int deltaX;         // x movement speed
    private int deltaY;         // y movement speed
    private int count = 2;
    private Score score;
    private boolean stuck = true; // stuck to paddle
    
    
    Ball(Score s)
    {
        score=s;
    }
    /**
     * Act. Move if we're not stuck.
     */
    public void act() 
    {
        if (!stuck) 
        {
            move();
            makeSmoke();
            if(!selfDestroy())
            checkOut();
            
        }
    }
    
    /**
     * Move the ball. Then check what we've hit.
     */
    public void move()
    {
        setLocation (getX() + deltaX, getY() + deltaY);
        checkPaddle();
        checkWalls();
        checkBricks();
    }
    
    /**
     * Check whether we've hit one of the bricks and then Reverse direction.
     */
    private void checkBricks()
    {
        Actor brick=getOneIntersectingObject(Bricks.class);
        if(brick!=null)
        {
            Greenfoot.playSound("blip1.wav");
            score.addScore();
            deltaY = -deltaY;
        }
    }
        
    
    /**
     * Check whether we've hit one of the three walls. Reverse direction if necessary.
     */
    private void checkWalls()
    {
        int randomNo=0;
        randomNo=Greenfoot.getRandomNumber(100);
        
            
        if (getX() == 0 || getX() == getWorld().getWidth()-1) {
            /**
             * Tunneling of ball takes place
             */
            if(randomNo<50)
            {
                if(getX()==0)setLocation(getWorld().getWidth()-2, getY());
                else setLocation(2, getY());
            }
            else
            {
            deltaX = -deltaX;
            Greenfoot.playSound("blip1.wav");
           }
        }
        if (getY() == 0) {
            deltaY = -deltaY;
            Greenfoot.playSound("blip1.wav");
        }
    }
    
    /**
     * Check whether we're out (bottom of screen).
     */
    public void checkOut()
    {
        if (getY() == getWorld().getHeight()-1) {
            ((Board) getWorld()).ballIsOut();
            getWorld().removeObject(this);
            
        }
    }
    
    /**
     * Reflection of ball relative to the position of paddle
     */
    private void checkPaddle()
    {
        Actor paddle = getOneIntersectingObject(Paddle.class);
           if (paddle != null) {
            
            Greenfoot.playSound("blip1.wav");
            deltaY = -deltaY;
            int offset = getX() - paddle.getX();
            deltaX = deltaX + (offset/10);
            if (deltaX > 9) {
                deltaX = 9;
            }
            if (deltaX < -9) {
                deltaX = -9;
            }
        }            
    }
    
    /**
     * Move the ball a given distance sideways.
     */
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
    }

    /**
     * Put out a puff of smoke (only on every second call).
     */
    private void makeSmoke()
    {
        count--;
        if (count == 0) {
            getWorld().addObject ( new Smoke(), getX(), getY());
            count = 2;
        }
    }
    
    /**
     * Release the ball from the paddle.
     */
    public void release()
    {
        deltaX = Greenfoot.getRandomNumber(11) - 5;
        deltaY = -5;
        stuck = false;
    }
     /**
      * To solve ball pad bug
      */
    
     public void ballTunnel(int x,int y)
    {
        
            
            
            setLocation(x,y-35);
            
        
    }
    
    public boolean selfDestroy()
    {
        
        
        List objects=getWorld().getObjects(Bricks.class);
            if(objects.isEmpty())
            {
                getWorld().removeObject(this);
                return true;
            }
            else return false;
        
              
   }
}

