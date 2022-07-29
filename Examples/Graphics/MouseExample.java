/* This class demonstrates how to use the mouse to interact with your JPanel.
   As always, the specific syntax here is restricted to Java (and, more
   particularly, the Swing library), but many of the ideas apply to mouse
   control more generally.
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

// New imports for Mouse
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseExample extends JPanel implements MouseListener
{
  Color color = Color.BLACK;

  public MouseExample()
  {
    // MouseListener instead of KeyListener
    addMouseListener(this);
    setFocusable(true);
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    g.setColor(color);
    g.fillRect(300,200,200,200);
  }
  
  /* Required methods for MouseListener. There are FIVE this time! */
  public void mousePressed(MouseEvent e)
  {
    // getButton tells us which button was clicked.
    int button = e.getButton();
    
    // BUTTON1 = left click
    if(button == MouseEvent.BUTTON1)
    {
      color = Color.RED;
    }
    else if(button == MouseEvent.BUTTON2)
    {
      color = Color.GREEN;
    }
    else if(button == MouseEvent.BUTTON3)
    {
      color = Color.BLUE;
    }
    
    System.out.println("x: " + e.getX());
    System.out.println("y: " + e.getY());
    repaint();
  }
  public void mouseReleased(MouseEvent e)
  {
  }
  public void mouseClicked(MouseEvent e)
  {
  }  
  public void mouseEntered(MouseEvent e)
  { 
  } 
  public void mouseExited(MouseEvent e)
  { 
  } 
}