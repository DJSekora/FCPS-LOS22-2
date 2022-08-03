import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class KeySoundExample extends JPanel implements KeyListener
{
  static final double PI2 = 2*Math.PI;
  static final double INTERVAL = Math.pow(2, 1.0/12);
  
  double prevFreq = 440;
  double freq = 440;
  double inc = freq*PI2/44100;
  
  boolean[] pressed;
  double[] frequencies;
  boolean go = true;
  
  SourceDataLine sdl;
  
  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    frame.setSize(800,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    KeySoundExample panel = new KeySoundExample();
    frame.add(panel);
    frame.setVisible(true);
    
    panel.mainLoop();
  }
  
  public KeySoundExample()
  {
    addKeyListener(this);
    setFocusable(true);
    
    pressed = new boolean[13];
    
    frequencies = new double[13];
    frequencies[10] = 440;
    for(int i=10; i > 1; i--)
    {
      frequencies[i-1] = frequencies[i]/INTERVAL;
    }
    for(int i=11; i < frequencies.length; i++)
    {
      frequencies[i] = frequencies[i-1]*INTERVAL;
    }
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
  }
  
  public void mainLoop()
  {
        try
        {
          double angle = 0;
          double volume = 100;
          byte[] buf = new byte[ 1 ];
          double sample;
        
          AudioFormat af = new AudioFormat( (float)44100, 8, 1, true, false );
          sdl = AudioSystem.getSourceDataLine( af );
          sdl.open();
          sdl.start();
          while(go)
          {
            for(int i=0; i<100; i++)
            {
              sample = getSinSample(angle);
              buf[0] = (byte)(sample * volume);
              sdl.write( buf, 0, 1 );
              angle += inc;
              angle = angle % PI2;
            }
          }
          sdl.drain();
          sdl.stop();
        }
        catch(Exception e){e.printStackTrace();}
  }

  public void keyPressed(KeyEvent e)
  {
    int code = e.getKeyCode();
    if(code == KeyEvent.VK_ESCAPE) go = false;
    else
    {
      int index = keyCodeToIndex(code);
      setFrequency(frequencies[index]);
      pressed[index] = true;
    
      if(freq != prevFreq)
      {
        sdl.flush();
        prevFreq = freq;
      }
    }
    
  }
  
  public void keyReleased(KeyEvent e)
  {
    int code = e.getKeyCode();
    pressed[keyCodeToIndex(code)] = false;
  }
  
  public void keyTyped(KeyEvent e){}
  
  public int keyCodeToIndex(int code)
  {
    if(code == KeyEvent.VK_Q){return 1;}
    if(code == KeyEvent.VK_W){return 3;}
    if(code == KeyEvent.VK_E){return 5;}
    if(code == KeyEvent.VK_R){return 6;}
    if(code == KeyEvent.VK_T){return 8;}
    if(code == KeyEvent.VK_Y){return 10;}
    if(code == KeyEvent.VK_U){return 12;}
    return 0;
  }

  public static void playNote(SourceDataLine sdl, double freq, double volume, double duration)
  {
    byte[] buf = new byte[ 1 ];
    double angle = 0;
    double inc = freq*PI2/44100; // 44100 samples per second
    
    try
    { 
      double cap = duration * (float)44100 / 1000;
      
      for(int i=0; i<cap; i++)
      {
        buf[0] = (byte)(getSinSample(angle) * volume);
        sdl.write( buf, 0, 1 );
        angle += inc;
        angle = angle % PI2;
      }
    }
    catch(Exception e){e.printStackTrace();}
  }
  
  public static double getSinSample(double angle)
  {
    return Math.sin(angle);
  }
  
  public void setFrequency(double f)
  {
    freq = f;
    inc = freq*PI2/44100;
  }
}