/* This file contains examples of the basic variable types for storing integers
   in Java. These types are:
    byte:  8 bits, range 0 to 255
    short: 16 bits, range -32768 to +32767
    int:   32 bits, range ~-2billion to ~+2billion, standard in Java
    long:  64 bits, range in the -8 to +8 quintillions
    
   We won't need to use byte or short very much. The default in Java for
   integers is the int type, since most numbers we use on a daily basis are
   in between negative and positive 2 billion.
 */
public class VariableExample
{
  public static void main(String[] args)
  {
    byte x = 5;
    short y = 6;
    int z = -783;
    
    // Note that we need the 'l' at the end (a lowercase L, not 1 or I or |).
    // This says that the number should be treated as a 64 bit long instead
    // of the default int. Without the 'l', Java will complain that the number
    // is too big.
    long o = 5000000000l;
    
    // the following line will throw an error, because we are trying to put
    // the contents of a 32-bit slot into a 16-bit slot:
    //short s = z;
    
    // Instead, we can write this:
    short t = (short)z;
    // This process is called 'casting'. It reassures the compiler that we
    // really do want to shove the 32-bit information into the 16-bit slot.
    // This will cut off the highest 16 bits.
    
    // Feel free to change the following line to print out different variables
    // or mathematical operations.
    System.out.println(x);
  }
}