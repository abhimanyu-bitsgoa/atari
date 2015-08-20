import greenfoot.*;

/**
 * Write a description of class MagnetPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagnetPower extends Powerups
{
    /**
     * Act - do whatever the MagnetPower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        drop();
        absorb();
       
        
    }    
    
public void magnet(){


       Board bworld =(Board)getWorld();
       Paddle mPad=bworld.getPaddle();
        
       mPad.setImage("magnetPlayer.png");
    

}

 public void absorb(){
    
        if(this.isTouching(Paddle.class)){
            
       //change pad image by getting Paddle unstance object
       Board bworld =(Board)getWorld();
       Paddle mPad=bworld.getPaddle();
       mPad.setImage("magnetPlayer.png");
       
       getWorld().removeObject(this); // Removes the powerup from world
        }
    }

}


