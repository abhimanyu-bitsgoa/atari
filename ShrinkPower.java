import greenfoot.*;

/**
 * Write a description of class ShrinkPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShrinkPower extends Powerups
{
    /**
     * Act - do whatever the ShrinkPower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    long powerStart;
    long powerCurrent;
    int timeToken=0;
    Board bworld ;
    Paddle mPad;
    public void act() 
    {
        // Add your action code here.
        drop();
        absorb();
    }    
    
    
    
    public void absorb(){
    if(this.isTouching(Paddle.class)){
            
       //change pad image by getting Paddle instance object
       bworld =(Board)getWorld();
       mPad=bworld.getPaddle();
       mPad.setImage("SmallPlayer.png");
       getWorld().removeObject(this);
       powerStart=System.currentTimeMillis();
       timeToken=1;
       
       // Removes the powerup from world
        }
        
       if(timeToken==1){
         powerCurrent=System.currentTimeMillis();
         //mPad.setImage("ball.png");
       }
         
        if((((powerCurrent-powerStart)/1000)>=3)){
        //bworld=(Board)getWorld();
        //mPad=bworld.getPaddle();
        mPad.setImage("Player.png");
        timeToken=0;
        powerCurrent=0;
    }
        
    
    }
}
