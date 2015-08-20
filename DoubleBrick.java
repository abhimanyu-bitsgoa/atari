import greenfoot.*;

/**
 * Write a description of class DoubleBrick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoubleBrick extends Bricks
{
    /**
     * Act - do whatever the DoubleBrick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int count=2;
    public void act() 
    {
       
       if(checkBall())count--;
       if(count==1)setImage("BrokenDoubleBlock.png");
       if(count==0)getWorld().removeObject(this);
        // Add your action code here.
    }    
}
