import greenfoot.*;
import java.awt.*;



public class Score extends Actor
{
    
    private GreenfootImage img;
    
    private int score;
    
    
   public Score()
   {
       score=0;
 
       update();
    }
    
    public void addScore()
    {
        score++;
        update();
    }
    
    public void update()
    {
       setImage("asteroid.png");
       img=new GreenfootImage(""+score,40,Color.WHITE,null,Color.BLUE);
       getImage().drawImage(img, 40, 50);
        
       
    }
    
    public int getScore()
    {
        return score;
    }
    
}
