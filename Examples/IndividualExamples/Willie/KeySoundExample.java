/* Imports for audio */
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;

/* Imports for window */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

/* Imports for keyboard input */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class KeySoundExample extends JPanel implements KeyListener
{
  // PI*2 is a very useful 
  static final double PI2 = 2*Math.PI;
  
  // Interval between consecutive notes in the chromatic scale. Multiply a
  // frequency by this value to go up one half-step.
  static final double INTERVAL = Math.pow(2, 1.0/12);
  
  // Currently playing frequency. For now, only one tone allowed at a time.
  double prevFreq = 440;
  double freq = 440;
  
  // How much to increase the angle by each time to maintain the desired frequency.
  // (
  double inc = freq*PI2/44100;
  
  // array keeping track of which keys are pressed, may be useful if you want to implement pressing multiple keys at once
  // (but for now this is maintained but not used)
  boolean[] pressed; 
  
  // Array holding the frequencies for each key press
  double[] frequencies;
  boolean go = true;
  
  SourceDataLine sdl;
  
  // Standard main method stolen from MainForGraphics
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
    // These two must be here for keyboard input
    addKeyListener(this);
    setFocusable(true);
    
    pressed = new boolean[13];
    
    
    // Populate the frequencies for one full octave
    // (slot 0 is reserved for "silence")
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
  
  // We always play a sound
  public void mainLoop()
  {
    try
    {
      // sin operates on angles
      double angle = 0;
      
      // volume can range from 0 to 100
      double volume = 100;
      
      // this passes in information into the SourceDataLine
      byte[] buf = new byte[ 1 ];
      double sample;
    
      // define audio format as 44100 samples per second, 8 bits per sample (1 byte), 1 channel
      AudioFormat af = new AudioFormat( (float)44100, 8, 1, true, false );
      sdl = AudioSystem.getSourceDataLine( af );
      sdl.open(af, 2205); // 2205 is the buffer size in samples. This means 1/20 of a second latency
      sdl.start();
      while(go)
      {
        for(int i=0; i<1; i++)
        {
          sample = getSinSample(angle);
          buf[0] = (byte)(sample * volume);
          sdl.write( buf, 0, 1 ); // putting data into the sourcedataline is what makes the sound
          angle += inc;
          angle = angle % PI2;
        }
      }
      // end stream
      sdl.drain();
      sdl.stop();
      sdl.close();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
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
        //sdl.flush();
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