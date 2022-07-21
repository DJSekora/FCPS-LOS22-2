/* This file contains more examples of if statements.

   It also includes examples of how to use 'else' and 'else if'.

 */
public class MoreIfExamples
{
  public static void main(String[] args)
  {
    int x = 5;
    int y = 7;
    
    // Single ampersand & means BITWISE AND
    int z = 3 & 2; // = 2
    
    // Single vertical bar means BITWISE OR
    int w = 3 | 2; // = 3
    
    // Double ampersand && means boolean AND
    // This lets us create more complex conditions!
    if(x < 5 && y > 4)
    {
      System.out.println("AND!");
    }
    
    // Double vertical bar || means boolean OR
    if(x < 5 || y > 4)
    {
      System.out.println("OR!");
    }
    
    // != means "not equals
    if(x != 5)
    {
      System.out.println("Not 5");
    }
    // an else statement says what to do if the condition was false
    else 
    {
      System.out.println("Is 5");
      
      // We can put any code we want in here, including more if and else statements
      if(y > 6)
      {
        System.out.println("y also > 6");
      }
      else
      {
        System.out.println("y also <= 6");
      }
    }
    
    // If we want to easily branch our code into 3 or more distinct cases,
    // we can use else if statements
    if(x < 5)
    {
      System.out.println("Less");
    }
    else if(x > 5)
    {
      System.out.println("Greater");
    }
    // If you put an else in, that ends the chain
    // If you don't put an else here, then that says
    //  "if all the conditions were false, do nothing"
    else
    {
      System.out.println("Equal");
    }
    
    
    // Sometimes we prefer to not define our variables until closer to where we
    // want to use them:
    String name = "David";
    
    // Here is an example of a long chain of ifs and else ifs.
    // If one of the names we are checking for is stored in 'name', then we
    // print a special message.
    if(name.equals("John"))
    {
      System.out.println("Mow your lawn, John.");
    }
    else if(name.equals("Bill"))
    {
      System.out.println("What's your will, Bill?");
    }
    else if(name.equals("Joe"))
    {
      System.out.println("How's it go, Joe?");
    }
    else if(name.equals("Mike"))
    {
      System.out.println("Where's your bike, Mike?");
    }
    else if(name.equals("David"))
    {
      System.out.println("Oh great and powerful David, please bestow your wisdom upon us!");
    }
    
    // The ! operator also can negate whatever boolean expression it is in
    // front of. We can use parentheses () to make the ! operator apply to
    // a more complex expression.
    if(!(x < 5 || name.equals("Robert")))
    {
      System.out.println("Not less than 5 or Robert!");
    }
  }
}