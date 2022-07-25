public class BasicEncrypter
{
  // Example of the control flow of an encryption procedure
  public String encrypt(String message)
  {
    StringBuilder ret = new StringBuilder();
    char c;
    
    for(int i=0; i<message.length(); i++)
    {
      c = message.charAt(i);
      
      // Do stuff to modify c in here
      
      ret.append(c);
    }
    
    return ret.toString();
  }
}

/* Why to use StringBuilder instead of String and the + operator when
   building a String character by character:
   
   Underneath, a String is secretly just an array of characters. Arrays have
   a fixed length. The length of the array for a String is the same as the
   number of characters in the String.
   
   Now consider the following two lines of code:
    String x = "Hello";
    x = x + '!';
    
   This creates an array of size 5, then creates a new array of size 6 and
   copies all 5 characters over. If we repeat this over and over for 100
   characters, we have to copy 1 + 2 + 3 + 4 + ... + 99 characters, which is
   4950 operations! In general, writing n characters would require n(n-1)/2
   operations, which is quadratic O(n^2) runtime. Writing a million characters
   should take 1 million operations, but takes around 500 billion operations
   if you use the String +.
   
   StringBuilder gives you roughly linear time.
*/