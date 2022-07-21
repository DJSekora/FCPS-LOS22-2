public class IfExample
{
    public static void main(String[] args)
    {
        // Define variables at the start so we can easily see and modify them.
        // Try changing the values of x and name to see how the output changes
        int x = 5;
        // Strings are variables to store text
        String name = "David";
        
        /* This is an if statement. The thing inside the parentheses () is
           called the "condition", and it needs to be a boolean expression
           (true/false value). This file contains several examples of boolean
           expressions, but there are many many more.
         */
        if(x < 8)
        {
            // If the condition is true, then all of the code inside of the
            // curly brackets {} will be executed.
            System.out.println("Less than 8!");
        }
        
        // Rule of thumb: when you open a new set of curly brackets,
        // you should NOT use a semicolon!
        if(x == 5)
        {
            System.out.println("Equals 5!");
        }
        if(x <= 5) // if x is equal to 5, both will run
        {
            System.out.println("Less than or equal to 5!");
        }
        
        // When checking equality for Strings, we use a different syntax:
        if(name.equals("David"))
        {
            System.out.println("Access granted!");
            System.out.println("You're the best!");
            
            // We can put any code we want inside of an if statement -
            // including more if statements
            if(x == 5)
            {
                System.out.println("David AND equals 5 wow!");
            }
        }
    }
}