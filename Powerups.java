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
    long powerStart;
    long powerCurrent;
    int timeToken=0;
    Board bworld ;
    Paddle mPad;   
    String imageName;
    
    public void act() 
    {
        // Add your action code here.
        drop();
        absorb(imageName);
        
    }  
    
    
    public void drop(){
        this.setLocation(getX(),getY()+3);
    
    }
    
    public void absorb(String imageName){
    if(this.isTouching(Paddle.class)){
            //||getY()==getWorld().getHeight()-1
       //change pad image by getting Paddle instance object
       bworld =(Board)getWorld();
       mPad=bworld.getPaddle();
       mPad.setImage(imageName);
      // getWorld().removeObject(this);
       powerStart=System.currentTimeMillis();
       timeToken=1;
       powerRemove();
       
       
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
       getWorld().removeObject(this);
    }
   
   }
   
   public void powerRemove(){
       
        
        
       GreenfootImage im=new GreenfootImage(1,1);
       this.setImage(im);
    
    }
    
    public void powerDelete(){
        getWorld().removeObject(this);
    }
    
   
}
