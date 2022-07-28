/* Basic example of how to do animation.

   Make sure to call panel.mainLoop() in your main method!
 */
import javax.swing.JPanel;
import java.awt.Graphics;

public class AnimationExample extends JPanel
{
  private int x;
  private int speed;

  public AnimationExample()
  {
    x = 50;
    speed = 20;
  }
  
  /* Update the image and redraw the screen */
  public void mainLoop()
  {
    // Not great style to say while(true), but we'll talk about alternatives
    // later. For now, this is our main way to have a persistent program.
    while(true)
    {
      try
      {
        Thread.sleep(40);
      }catch(Exception e){e.printStackTrace();}
      
      x+=speed;
      repaint(); // built-in to JPanel
    }
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    // Make sure something in your paintComponent method is linked to a variable!
    g.fillRect(x, 50, 50, 50);
  }
}