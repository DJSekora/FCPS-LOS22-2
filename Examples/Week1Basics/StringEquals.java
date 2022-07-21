/* This example demonstrates why you should not use == for Strings.

   Short answer: use the format string1.equals(string2) instead.

   Long answer: see end of this file.
 */
public class StringEquals
{
  public static void main(String[] args)
  {
    String a = "LEMON LIME";
    String b = "LEMON LIME";
    String c = "LEMON" + " LIME";
    String x = " ";
    String d = "LEMON" + x + "LIME";
    String e = a;
    
    System.out.println("a: " + (a == a));
    System.out.println("b: " + (a == b));
    System.out.println("c: " + (a == c));
    System.out.println("d: " + (a == d));
    System.out.println("e: " + (a == e));
    
    // Short answer: don't use == to compare Strings.
    // Instead, do this:
    System.out.println("d the right way: " + a.equals(d));
    
    // If we want to check for inequality, we can use the ! symbol like this:
    System.out.println("not d: " + !(a.equals(d)));
  }
}
/*
   Long explanation: For any type of data other than the 8 primitive types,
    (primitive types: byte short int long float double boolean char)
   Java doesn't store the data directly with the variable. Instead, the
   variable actually holds the LOCATION of the data.
   
   We'll see this more later, but the consequence of this is that when you
   try string1 == string2, Java is actually checking to see if string1 and
   string2 have been stored in the same location in memory. This is generally
   false unless you set one variable equal to another directly.
    (e.g. String e = a;)
   EXCEPT for when working with String literals. A String literal is when you
   type your String directly into the source code inside quotation marks "",
   as opposed to getting the String from the user or building it up from
   characters/other String variables.
   
   When you write the same String literal multiple times within your code,
   the Java compiler saves space in the compiled version of the code by only
   storing one copy of that String literal.
   So, if you set x = "hi" and y = "hi", there will only be one copy of "hi".
   That copy of "hi" will be at some memory address, and both x and y will
   contain the number corresponding to that memory address.
   
   If, instead, you set x = "hi" and read y in from the user, x and y will
   point to different locations in memory that both happen to contain the
   sequence of characters ['h', 'i'].
 */