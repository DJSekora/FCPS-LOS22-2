/* Description: This program demonstrates how nextInt can be used to get an
   integer from the user, and explains a bit about how reading information
   from the user works.
   
   Your computer sees user input as if it is reading a text file. It has a
   cursor, and it advances the cursor in different ways depending on which
   command is executed.
   
   The .nextLine() command reads the rest of the current line from the cursor,
   then advances the cursor to the beginning of the next line.
   
   The .next() command reads characters from the cursor until it reaches
   whitespace (space, tab, newline, etc.), then stops without moving the cursor
   to the next line. Importantly, if you call .next() and then call .nextLine(),
   the .nextLine() will be starting in the middle or end of the line (right
   where .next() left off), and will not know to continue reading.
   
   The .next() and .nextInt() commands share this behavior. The only difference
   is that the .nextInt() command performs additional processing on the input
   to try and interpret it as an integer instead of a String (if it fails, then
   it will throw an error).
   
   The easy fix to force it to go to the beginning of the line you want is to
   make an additional call to .nextLine() that you do not need to store.
 */

import java.util.Scanner;

public class NextIntExample
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    String first = input.nextLine();
    int second = input.nextInt();
    
    // If you comment this out, then you will only be able to input 3 lines
    input.nextLine();
    
    // Without the previous command, 'third' will be empty
    String third = input.nextLine();
    String fourth = input.nextLine();
    
    System.out.println(first);
    System.out.println(second);
    System.out.println(third);
    System.out.println(fourth);
  }
}