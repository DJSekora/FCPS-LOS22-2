import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class Entity
{
  int x;
  int y;

  AnimatedSprite sprite;

  int xSpeed = 0;
  int ySpeed = 0;
  
  public Entity(int nx, int ny, BufferedImage[] spriteSheet)
  {
    x = nx;
    y = ny;
    
    sprite = new AnimatedSprite(spriteSheet);
  }
  
  public void drawTo(Graphics g)
  {
    sprite.drawTo(g,x,y);
  }
  
  // Advance the action by one game tick
  public void step()
  {
    move();
    sprite.animate();
  }
  
  // Trigger an animation sequence specified by the entered array
  // (see AnimatedSprite.java for the format of this array)
  public void startAnimationSequence(int[][] animationSequence)
  {
    sprite.startAnimationSequence(animationSequence); // pass the work along to AnimatedSprite
  }
  
  // Applies the speed to the position
  public void move()
  {
    moveX(xSpeed);
    moveY(ySpeed);
  }
  
  // Manually changes the position by the entered amount
  public void moveX(int amount)
  {
    x += amount;
  }
  
  public void moveY(int amount)
  {
    y += amount;
  }
}