import java.awt.Color;
import java.awt.Graphics;
public class DoubleSquare
{
  double x;
  double y;
  double size;
  Color color;
  
  // The speed will now change depending on input and be applied in a main loop
  double xSpeed = 0;
  double ySpeed = 0;
  
  /* Our maxSpeed makes a comeback, this time as a limiter on how large the
     speed can get in each direction. We put it in the Square class instead
     of the JPanel-extending class because we have most of the movement logic
     in here.
     (If we wanted to be even more realistic, we could limit the TOTAL speed
      instead of the speed in each direction, but that would require some
      trigonometry and more code so we'll leave that for now.)
   */
  double maxSpeed = 10;
  
  double friction = 0.98; // Multiplier for speed at each tick so we don't get infinite movement
  
  public DoubleSquare(double nx, double ny, double nsize, Color ncolor)
  {
    x = nx;
    y = ny;
    size = nsize;
    color = ncolor;
  }
  
  public void drawTo(Graphics g)
  {
    g.setColor(color);
    g.fillRect((int)x, (int)y, (int)size, (int)size);
  }
  
  // Applies the speed to the position
  public void move()
  {
    moveX(xSpeed);
    moveY(ySpeed);
    
    applyFriction();
  }
  
  // Manually changes the position by the entered amount
  public void moveX(double amount)
  {
    x += amount;
  }
  
  public void moveY(double amount)
  {
    y += amount;
  }
  
  // Acceleration modifies the speed
  public void applyAccelerationX(double amount)
  {
    xSpeed += amount;
    
    // Make sure we don't go past our max
    if(xSpeed > maxSpeed)
    {
      xSpeed = maxSpeed;
    }
    if(xSpeed < -maxSpeed)
    {
      xSpeed = -maxSpeed;
    }
  }
  
  public void applyAccelerationY(double amount)
  {
    ySpeed += amount;
    
    if(ySpeed > maxSpeed)
    {
      ySpeed = maxSpeed;
    }
    if(ySpeed < -maxSpeed)
    {
      ySpeed = -maxSpeed;
    }
  }
  
  public void applyFriction()
  {
    xSpeed *= friction;
    ySpeed *= friction;
  }
}