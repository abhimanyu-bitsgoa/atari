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
        powerType=Greenfoot.getRandomNumber(5);
        if(powerType==1){
         MagnetPower magnetPow=new MagnetPower();
        ((Board) getWorld()).addObject(magnetPow,getX(),getY());
        getWorld().removeObject(this);
        }
        
        else if(powerType==2){
         GrowPower growPow=new GrowPower();
        ((Board) getWorld()).addObject(growPow,getX(),getY());
        getWorld().removeObject(this);
        }
        
        else if(powerType==3){
         ShrinkPower shrinkPow=new ShrinkPower();
        ((Board) getWorld()).addObject(shrinkPow,getX(),getY());
        getWorld().removeObject(this);
        }
        
        else {
         GunPower gunPow=new GunPower();
        ((Board) getWorld()).addObject(gunPow,getX(),getY());
        getWorld().removeObject(this);
        }
        
        
    }
    }    


}
