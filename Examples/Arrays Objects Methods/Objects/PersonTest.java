/* Demonstrates how to create objects of a class and access their data

   Make sure this is in the same folder as Person.java
 */
public class PersonTest
{
  public static void main(String[] args)
  {
    Person bob = new Person("Bob", 3);
    Person alice = new Person("Alice", 300);
    
    System.out.println(bob); // memory address of bob
    System.out.println(bob.name); // name of bob
    System.out.println(bob.age);
    
    // Every Java file you create defines a type of object!
    PersonTest what = new PersonTest();
    
    // Calling an instance method
    bob.sayHi();
  }
}