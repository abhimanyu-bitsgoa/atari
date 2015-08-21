import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The game paddle. It is keyboard controlled (left, right, space). It also 
 * generates a new ball when it is created itself.
 * 
 * @author mik
 * @version 1.0
 */
public class Paddle extends Actor
{
    private Ball myBall;// used before ball gets released
    private Score score;
    public Paddle mPad;
    Actor ballKill;
    
    Paddle(Score s)
    {
        score=s;
    }

    /**
     * When the paddle gets created, create a ball as well.
     */
    public void addedToWorld(World world)
    {
        newBall();
    }
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         if(getX()==(getWorld().getWidth()-1) && Greenfoot.isKeyDown ("right"))
        {
            setLocation(0,getY());
           if(myBall!=null)
            myBall.ballTunnel();
            
        }
        if(getX()==0 && Greenfoot.isKeyDown ("left"))
        {
            setLocation(getWorld().getWidth(),getY());
            if(myBall!=null)
            myBall.ballTunnel();
        }
        if (Greenfoot.isKeyDown ("left")) {
            move(-9);
        }
        if (Greenfoot.isKeyDown ("right")) {
            move(9);
        }
        if (haveBall() && Greenfoot.isKeyDown ("space")) {
            releaseBall();
        }
        
       
        
    }
    
    /**
     * moves the paddle to a given distance in x direction
     */
    
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
        if (myBall != null) {
            myBall.move (dist);
        }
    }
    
    /**
     * creates a new ball
     */
    public void newBall()
    {
        myBall = new Ball(score);
        getWorld().addObject (myBall, getX(), getY()-35);
    }
        
    public boolean haveBall()
    {
        return myBall != null;
    }
        
    public void releaseBall()
    {
        myBall.release();
        myBall = null;
    }
      
    public void magnetTouch(){
        //mPad=((Board)getWorld()).getPaddle();
        if(this.isTouching(Ball.class)){
            //((Board)getWorld()).ballIsOut();
            ballKill = getOneIntersectingObject(Ball.class);
            getWorld().removeObject(ballKill);
            newBall();        
            
        
        }
    }
}
