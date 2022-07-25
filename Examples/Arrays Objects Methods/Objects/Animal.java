/* In this file, we are demonstrating two core principles of object-oriented
   programming: inheritance and polymorphism. These look like big scary words,
   but their programming meaning is pretty close to their English meaning.
   Some definitions:
   
    Superclass and Subclass: If two types of objects have the relationship
    "every A is a B", we say that A is the subclass and B is the superclass.
    For example, "every square is a rectangle", so "square" is a subclass of
    "rectangle". In general, a subclass is a more specific category than its
    superclass. The subclass relation is transitive: if A is a subclass of B,
    and B is a subclass of C, then A is a subclass of C. For example, every
    square is a rectangle and every rectangle is a quadrilateral, so every
    square is a quadrilateral (and a polygon and a 2D shape etc.).
   
    Inheritance: This means that a subclass retains all instance variables
    (fields) and instance (non-static) methods from its superclass. Methods
    can be overridden (replaced with more specific versions), but variables
    cannot.
    
    Polymorphism: This means that an object of a subclass can be used as if it
    were a member of the superclass. For example, in Java the following code is
    valid as long as Wolf is a subclass of Animal:
      Animal a = new Wolf();
    
   And some new Java keywords:
    extends: We write "public class X extends Y" to indicate that X is a
             subclass of Y. The extends keyword can only be used once per
             class, so a class can only have one superclass. This relationship
             includes both inheritance (X gets all the variables and methods of
             Y) and polymorphism (an X object can be used anywhere a Y object
             can).
             Every class extends Object or some class that extends Object.
    
    super: This keyword gets used in two different ways:
           1. In the constructor of the subclass, calling super() says "go do
              whatever the constructor for the superclass does". This must be
              done in the first line of the constructor.
           2. Calling super.methodName() will call the superclass version of
              the method instead of the subclass version (if one exists).
              
    protected: This can be used in place of "public" to describe access to a
               field or method. This means that this variable can be accessed
               by subclasses and other classes in the same package, but not
               from any external classes. Useful when private is too
               restrictive but you don't want to allow external sources to
               see or modify the value of the variable.
   
   Finally, we are also demonstrating how to write documentation for classes in
   Java. Try running the following command in the terminal:
     javadoc -private -d Docs Animal.java
 */
 
/**
* This class describes an Animal, a general class that we will be extending
* many times.
*
* @author David Sekora
* @version 1.0
*/
public class Animal
{
  /** The hunger level of the animal. */
  protected int hunger;
  // We make this protected because it is managed internally and not needed from
  // outside.

  /** Default constructor. Initializes hunger to 10. */
  public Animal()
  {
    hunger = 10;
  }
  
  /** Makes the noise of this animal. Make sure to override this in extending classes. */
  public void makeNoise()
  {
    System.out.println("");
  }
  
  /** @return The scientific name of this animal.
      Make sure to override this in extending classes.
  */
  public String scientificName()
  {
    return "";
  }
  
  /** Eating food reduces the hunger of the animal. This version allows you to
      specify the amount of hunger to be reduced.
      @param amount The amount to reduce hunger by
  */
  public void eat(int amount)
  {
    hunger = Math.max(hunger - amount, 0);
    /* The above line is equivalent to the following:
     hunger = hunger - amount;
     if(hunger < 0)
     {
       hunger = 0;
     }
    */
  }
  
  
  /* Note how we can have multiple methods with the same name, as long as they
     have different parameters (a different number of parameters always works;
     if two methods have the same name and the same number of parameters, then
     the type for at least one of the parameters must be different).
     This process is called "overloading" (this is the same meaning as
     "overloading" in English, for example the word "bow" is overloaded because
     it can be used in several different ways)
   */
  /** Eating food reduces the hunger of the animal. This version only
      decreases hunger by 1.
  */
  public void eat()
  {
    eat(1);
  }
  
  /** @return A special message depending on the hunger level of the animal.
  */
  public String hungerStatus()
  {
    if(hunger < 1){ return "completely full"; }
    else if(hunger < 3){ return "pretty full"; }
    else if(hunger < 6){ return "a little hungry"; }
    else if(hunger < 9){ return "quite hungry"; }
    return "starving";
  }
}

/* Notice how we can have multiple classes in the same file!
   This is generally bad practice, because it can make it difficult to find
   the class you're looking for, but it is sometimes useful when you know you
   will only use one class when the other is present.
   
   (To be clear: extending classes do NOT need to be in the same file! We are
    doing this here to demonstrate that it is possible.)
 */
/** Canine is a class of animal that includes wolves, dogs, foxes, and other
    animals.
  */
class Canine extends Animal
{
  /** A String representation of the sound this animal makes when it howls. */
  protected String howl;
  
  /** Default constructor. Initializes the howl sound of the animal to "Aooo".
      @see Animal
  */
  public Canine()
  {
    super(); // This calls the constructor of Animal (must be the first line)
    howl = "Aooo";
  }

  /** Overrides the makeNoise() method of Animal to print out the howl sound. */
  public void makeNoise()
  {
    System.out.println(howl);
  }
  
  /** Overrides the scientificName() method of Animal to return "canis"*/
  public String scientificName()
  {
    return "canis";
  }
  
  /** Just increases hunger for now. */
  public void run()
  {
    // We can change hunger because it has protected access, not private access
    hunger = hunger + 2;
  }
}

/** A Wolf is a type of Canine. Wolves have their own unique howl sounds! */
class Wolf extends Canine
{
  // Note how we can create a constructor that has a different format than
  // the constructors of the parent class(es). We can still call super()
  // like normal.
  /** Constructor that gives the Wolf a unique howl ending.
      @param howlEnd The unique howl ending of this particular wolf. When the
        Wolf's makeNoise() method is called, this is what will follow "Aooo".
   */
  public Wolf(String howlEnd)
  {
    super();
    howl += howlEnd;
  }
  
  // Just like methods, we can have multiple constructors as long as the
  // parameters are different!
  /** Default constructor. Gives a default howl ending of "o". */
  public Wolf()
  {
    super();
    howl += "o";
  }
  
  /** The scientific name of a wolf is "canis lupus". */
  public String scientificName()
  {
    // super.scientificName() means call the scientificName() method
    // of the Canine class.
    return super.scientificName() + " lupus";
  }
}

// Add your own Animal-extending class below this line, with its own
// makeNoise() and scientificName() methods!