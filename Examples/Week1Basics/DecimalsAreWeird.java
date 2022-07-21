/* This program contains an example of floating point error.
   The conclusion is NOT that floating point numbers are useless, or that we
   can never use them. Instead, the lesson is that floating point numbers can
   only be trusted to provide approximations up to a certain standard of
   precision.
 */
public class DecimalsAreWeird
{
  public static void main(String[] args)
  {
    double y = 2.0/3;
    double z = 1.0/9;
    
    /* Run the code as-is, then remove the comment from the following line.
       Without the line, it prints 2.0 as expected.
       With the line, it prints 6.999... instead of 7.
       This is because of floating point error! Floating point numbers aren't
       reliable if exact calculations with fractions are needed - the answer
       will often be slightly off in one direction or the other.
     */
    // y = (y + z)*9;
    System.out.println(y*3);
  }
}