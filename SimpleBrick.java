import greenfoot.*;

/**
 * Write a description of class SimpleBrick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleBrick extends Bricks
{
    /**
     * Act - do whatever the SimpleBrick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int count=1;
    public void act() 
    {
       if(checkBall())count--;
       if(count==0)getWorld().removeObject(this);
       
    }    
}
