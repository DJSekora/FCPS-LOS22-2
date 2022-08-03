import java.awt.image.BufferedImage;
import java.awt.Graphics;
public class AnimatedSprite
{
  BufferedImage[] frames;
  
  int currentFrame;
  int idleFrame; // what to show if no animations are playing
  
  /* currentlyPlayingAnimation is a 2 dimensional array containing n rows and 2
     columns, where n is the number of animation steps. Example:
     4 3
     5 3
     2 5
     
     means that you show frame #4 for 3 ticks of the game loop, show frame #5
     for 3 ticks of the game loop, and show frame #2 for 5 ticks of the game
     loop.
  */
  int[][] currentlyPlayingAnimation;
  int animationStep;
  
  public AnimatedSprite(BufferedImage[] animations)
  {
    frames = animations;
    currentFrame = 0;
    idleFrame = 0;
    currentlyPlayingAnimation = null;
  }
  
  public void drawTo(Graphics g, int x, int y)
  {
    g.drawImage(frames[currentFrame], x, y, null);
  }
  
  // Executes one step of animation
  public void animate()
  {
    if(currentlyPlayingAnimation != null)
    {
      currentFrame = currentlyPlayingAnimation[animationStep][0];
      currentlyPlayingAnimation[animationStep][1]--;
      if(currentlyPlayingAnimation[animationStep][1] == 0)
      {
        animationStep++;
        if(animationStep >= currentlyPlayingAnimation.length)
        {
          currentlyPlayingAnimation = null;
          currentFrame = idleFrame;
        }
      }
    }
  }
  
  public void startAnimationSequence(int[][] animationSequence)
  {
    currentlyPlayingAnimation = animationSequence;
    animationStep = 0;
  }
}