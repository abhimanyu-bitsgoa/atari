import greenfoot.*;

/**
 * Write a description of class GunPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GunPower extends Powerups
{
    /**
     * Act - do whatever the GunPower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
        // Add your action code here.
        drop();
        absorb("GunPower.png");
    }    
    
    /*
    public void absorb(){
    
        if(this.isTouching(Paddle.class)){
            
       //change pad image by getting Paddle instance object
       bworld =(Board)getWorld();
       mPad=bworld.getPaddle();
       mPad.setImage("GunPower.png");
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
        
    
    }*/
    
}
