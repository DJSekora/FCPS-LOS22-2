/* Quick example showing off random number generation */

// We need a new import!
import java.util.Random;

public class RandomExample
{
  public static void main(String[] args)
  {
    // Initialize the random number generator
    Random rng = new Random();
    
    // This gets a random integer (from the full range of ~-2bil to +2bil)
    int number = rng.nextInt();
    
    // We can also specify a maximum (this gives us numbers 0 through 9):
    int number2 = rng.nextInt(10);
    
    // If we want a different range, we can figure out how big the range is
    // and then apply a shift (this will give numbers from 42 through 46):
    int number3 = rng.nextInt(5) + 42;
    
    // You can add a seed to make it do the same thing every time
    Random rng2 = new Random(234);
    int sameEveryTime = rng2.nextInt();
    System.out.println("This one changes: " + number);
    System.out.println("This one is the same: " + sameEveryTime);
    
    // Sometimes, we want to be able to recover the seed used to replicate
    // the behavior. So, we could use one random number to seed another, like
    // this:
    int seed = rng.nextInt(1000);
    Random rng3 = new Random(seed);
    
    System.out.println("Seed: " + seed);
    System.out.println("Number: " + rng3.nextInt());
  }
}