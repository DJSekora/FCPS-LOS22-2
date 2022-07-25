/* This class shows some examples of the details of how the extends keyword
   affects how objects can be used and what behavior they will exhibit.
   
   Make sure this is in the same folder as Animal.java!
 */
public class AnimalTest
{
  public static void main(String[] args)
  {
    /* One of the following 4 lines will not compile.
       See if you can figure out which one!
       This works because of polymorphism
     */
    Animal a = new Animal();
    Animal b = new Wolf();
    //Wolf c = new Animal();
    Wolf d = new Wolf("oOoOO");

    Canine can = new Canine();
    
    // Remove one of these to match the above.
    a.makeNoise();
    b.makeNoise();
    //c.makeNoise();
    d.makeNoise();
    can.makeNoise();
    
    // Wolves have hungerStatus() and eat() methods because of inheritance
    System.out.println(d.hungerStatus());
    d.eat();
    d.eat();
    d.eat();
    System.out.println(d.hungerStatus());
    
    
    // We can't call a.run() because a is not a Wolf.
    //a.run();
    
    // We can call b.run, but we have to use casting to reassure Java that b
    // is actually a Wolf object and not some other type of Animal.
    //b.run(); // Does not compile
    ((Wolf)b).run();   // Also compiles
    ((Canine)b).run(); // Also compiles
    
    // d.run() has no issues, because d is a Wolf variable and run is a method
    // that the Wolf class inherits from the Canine class.
    d.run();
    
    // This still prints "canis lupus" - casting doesn't actually change which
    // version of the method is called, it just reassures the compiler that
    // the object actually has the appropriate type.
    System.out.println(((Canine)b).scientificName());
  }
}