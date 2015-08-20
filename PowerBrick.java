import greenfoot.*;

/**
 * Write a description of class PowerBrick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerBrick extends Bricks
{
    /**
     * Act - do whatever the PowerBrick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // Add your action code here.
        if(checkBall()==true){
        
        int powerType;
        powerType=Greenfoot.getRandomNumber(3);
        
        
        if(true){
         MagnetPower magnetPow=new MagnetPower();
        ((Board) getWorld()).addObject(magnetPow,getX(),getY());
        
        getWorld().removeObject(this);
        
        //magnetPow.magnet();
        
            
            
        }
        
    }
    }    


}
