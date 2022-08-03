/* Basic example of how to do animation.

   Make sure to call panel.mainLoop() in your main method!
 */
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class AnimatedSpriteExample extends JPanel
{
  public static final int FPS = 25;
  public static final int MSPF = 1000/FPS;

  Entity entity;

  public AnimatedSpriteExample()
  {
    BufferedImage[] images = new BufferedImage[4];
    for(int i=0; i<images.length; i++)
    {
      // for now, we just generate images, feel free to load from files instead
      images[i] = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
      for(int x = 0; x < 100; x++)
      {
        for(int y = 0; y < 100; y++)
        {
          images[i].setRGB(x, y, 0xff000000 + (0x00ff0000 >> i*8));
        }
      }
    }
  
    entity = new Entity(100, 50, images);
  }
  
  /* Update the image and redraw the screen */
  public void mainLoop()
  {
    long nextTick = System.currentTimeMillis();
    long curTime;
    
    triggerSequenceA();
 
    while(true)
    {
      // change game state
      entity.step();
      
      // wait some time
      curTime = System.currentTimeMillis();
      if(nextTick > curTime)
      {
        try
        {
          Thread.sleep(nextTick - curTime);
        }
        catch(Exception e){e.printStackTrace();}
      }
      
      nextTick += MSPF;
      
      // redraw screen
      repaint();
    }
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    entity.drawTo(g);
  }
  
  public void triggerSequenceA()
  {
    entity.startAnimationSequence(new int[][]{
        {0,10},
        {1,10},
        {2,10},
        {3,10},
        {2,5},
        {1,5},
        {0,5},
      }
    );
  }
}