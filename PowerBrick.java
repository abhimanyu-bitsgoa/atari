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
        powerType=Greenfoot.getRandomNumber(4);
        
        
        if(true){
        Powerups magnetPower=new Powerups();
        ((Board) getWorld()).addObject(magnetPower,getX(),getY());
        
        getWorld().removeObject(this);
            
            
        }
        
    }
    }    
}
