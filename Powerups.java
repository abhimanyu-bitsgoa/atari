import greenfoot.*;

/**
 * Write a description of class Powerups here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerups extends Actor
{
    /**
     * Act - do whatever the Powerups wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
        // Add your action code here.
        drop();
        
    }  
    
    
    public void drop(){
        this.setLocation(getX(),getY()+3);
    
    }
    
   
    /*
    public boolean transform(){
        if(this.isTouching(Paddle.class)){
            
        getWorld().removeObject(this);
         return true;}
        
        else {
            getWorld().removeObject(this);
            return false;
        }
            
    }*/
}
