import greenfoot.*;

/**
 * Write a description of class Bricks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bricks extends Actor
{
    
    /**
     * checking whether ball is touching the brick
     */
    
    public boolean checkBall()
    {
        if(getOneIntersectingObject(Ball.class)!=null)return true;
        else return false;
    }
    
}
