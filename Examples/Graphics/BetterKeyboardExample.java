/* This class contains some small improvements over the KeyboardExample class.

   We do a pretty good job of correcting some of the flaws, but there's still
   room for more improvement. See EvenBetterKeyboardExample.java for the next
   upgrade!
   
   MAKE SURE TO CALL panel.mainLoop() AT THE END OF THE MAIN METHOD FROM
   GraphicsMainExample.java.
   
   The main addition from KeyboardExample: We have combined the mainLoop idea
   from the AnimationExample with the keyboard movement. Instead of changing
   the position directly when a key is pressed, we just change the speed. The
   position changes inside a loop - every 20 milliseconds, the loop checks the
   xSpeed and ySpeed of the square and moves it accordingly.
   Advantages:  
     + Creates smoother movement,
     + removes dependency on how fast your operating system spams key presses,
       and also
     + allows us to reliably move diagonally
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class BetterKeyboardExample extends JPanel implements KeyListener
{
  int sx = 200;
  int sy = 200;
  int sw = 50;
  int sh = 50;
  
  // The speed will now change depending on input and be applied in a main loop
  int xSpeed = 0;
  int ySpeed = 0;
  
  // How many pixels to move per frame max
  int maxSpeed = 5;

  public BetterKeyboardExample()
  {
    addKeyListener(this);
    setFocusable(true);
  }
  
  public void paintComponent(Graphics g)
  {
    //super.paintComponent(g);
    g.fillRect(sx, sy, sw, sh);
  }
  
  /* Combine the timer idea and the keyboard input idea. This way, we move at
     a consistent rate. Make sure to call this method with panel.mainLoop()
     at the end of the main method in GraphicsMainExample.java!
     
     Notice how this has the same 3 parts as the animation loop:
      1. Change some variable(s) representing information about what to draw
         as needed,
      2. Wait a fixed amount of time to keep a consistent frame rate,
      3. Redraw the screen,
   */
  public void mainLoop()
  {
    while(true)
    {
      sx+=xSpeed;
      sy+=ySpeed;
      
      try
      {
        Thread.sleep(20);
      }
      catch(Exception e){e.printStackTrace();}
      
      repaint();
    }
  }
  
  /* Required methods for KeyListener */
  public void keyPressed(KeyEvent e)
  {
    int code = e.getKeyCode();
    
    // We have moved the code that changes the position of the square to the
    // mainLoop method. So, all we have to do here is set xSpeed and ySpeed.
    if(code == KeyEvent.VK_RIGHT)
    {
      xSpeed = maxSpeed;
    }
    else if(code == KeyEvent.VK_LEFT)
    {
      xSpeed = -maxSpeed;
    }
    else if(code == KeyEvent.VK_UP)
    {
      ySpeed = -maxSpeed;
    }
    else if(code == KeyEvent.VK_DOWN)
    {
      ySpeed = -maxSpeed;
    }
  }
  
  // Make sure to set the speed back to 0 when we release the key
  public void keyReleased(KeyEvent e)
  {
    int code = e.getKeyCode();
    
    // Notice how we can combine the cases here
    if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_LEFT)
    {
      xSpeed = 0;
    }
    else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN)
    {
      ySpeed = 0;
    }
  }
  public void keyTyped(KeyEvent e)
  {
  }
}