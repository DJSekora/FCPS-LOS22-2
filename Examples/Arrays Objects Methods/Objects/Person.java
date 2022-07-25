/* This class describes a Person object. A Person consists of a name and an
   age.
   
   Java is an "object-oriented" language. Objects are the central focus of
   the language.
   
   'Person' here is a very basic type of object, it just stores data
   and cannot perform any functions (this is in contrast to the object types
   we have seen such as Scanner and Random, which have methods like nextLine
   and nextInt we can call).
 */
public class Person
{
  // These variables are called 'fields' or 'instance variables'
  // These are the properties of the object
  // public means we can access the variable from anywhere
  // private means we can only access it from this file
  public String name;
  public int age;
  
  // Constructor
  // Describes how to initialize a Person object
  // n and a are the 'parameters' (sometimes called 'arguments')
  public Person(String n, int a)
  {
    name = n;
    age = a;
  }
  
  /* Instance (non-static) method example
     To call this method, we need a variable of type Person
     Example:
        bob.sayHi();
      instead of 
        sayHi();
        
     In exchange, we are able to access all of the instance variables (fields)
     of that object. For example, here we get to use 'name' and 'age'.
   */
  public void sayHi()
  {
    System.out.println("Hi, I'm " + name + " and I'm " + age + " years old!");
  }
}