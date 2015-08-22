import greenfoot.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Actor hitBrick;
    Board bworld;
    
    public void act() 
    {
        // Add your action code here.
        /*GreenfootImage img=new GreenfootImage("bullet.png");
        img.scale(48,48);
        setImage(img);*/
        bulletRise();
        
        bulletHit();
        
    }   

    /*public void bulletAdd(){
        Board bworld ;
        Paddle mPad;   
        bworld =(Board)getWorld();
        mPad=bworld.getPaddle();
        bullet=new Bullet();
        ((Board) getWorld()).addObject(bullet,mPad.getX(),mPad.getY());
    }*/

    public void bulletRise(){
       
        
        this.setLocation(getX(),getY()-20);
        if(isAtEdge()){
        this.setImage("null.png");
        
    }
        
    }
    
    public void bulletHit(){
        
        if((this.isTouching(Bricks.class))){
        hitBrick = getOneIntersectingObject(Bricks.class);
        getWorld().removeObject(hitBrick);
        //this.setImage("null.png");
        bworld=(Board)getWorld();
        bworld.getBulletHit().addScore();
        getWorld().removeObject(this);
        
    }
    }
    
    
    
    
}
