import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;

public class SoundExample
{
  static final double PI2 = 2*Math.PI;
  
  public static void main(String[] args)
  {
    try
    {
      AudioFormat af = new AudioFormat( (float)44100, 8, 1, true, false );
      SourceDataLine sdl = AudioSystem.getSourceDataLine( af );
      sdl.open();
      sdl.start();
      playNote(sdl, 440*Math.pow(2, 12.0/12), 100, 500);
      playNote(sdl, 440*Math.pow(2, 7.0/12), 100, 500);
      playNote(sdl, 440*Math.pow(2, 4.0/12), 100, 500);
      playNote(sdl, 440*Math.pow(2, 0.0/12), 100, 500);
      sdl.drain();
      sdl.stop();
    }
    catch(Exception e){e.printStackTrace();}
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
}