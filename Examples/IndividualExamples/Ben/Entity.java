/* Entity is the parent class for Player and Enemy (you could also use this
   as a parent class for an NPC class, if you want).
   You can't make any objects of type Entity - that's what the abstract keyword
   is for. Instead, we just put all the stuff that Player and Enemy objects
   share here, so we don't have duplicate code running around.
 */
public abstract class Entity
{
  String name;

  int maxHealth;
  int currentHealth;
  
  public Entity(String entityName, int entityHealth)
  {
    name = entityName;
    maxHealth = entityHealth;
    currentHealth = maxHealth;
  }
  
  // Override getAttack and getDefense in subclasses depending on how that
  // type of entity should operate.
  public int getAttack()
  {
    return 0;
  }
  
  public int getDefense()
  {
    return 0;
  }
  
  
  // Combat sequence: one party launches an attack, the other party receives
  // the attack, and then damage calculation is done.
  // Current formula is (attacker.attack - defender.defense)
  public int launchAttack(Entity other)
  {
    int attackPower = getAttack();
    return other.receiveAttack(attackPower);
  }
  
  public int receiveAttack(int attackPower)
  {
    int damage = attackPower - getDefense();
    if(damage > 0)
    {
      takeDamage(damage);
    }
    return damage;
  }
  
  public void takeDamage(int amount)
  {
    currentHealth -= amount;
  }
  
  // Example of a method that can be used when a potion is drunk etc..
  public void recoverHealth(int amount)
  {
    currentHealth += amount;
    if(currentHealth > maxHealth)
    {
      currentHealth = maxHealth;
    }
  }
  
  // Utility method to determine whether the entity is currently alive
  public boolean isAlive()
  {
    return currentHealth > 0;
  }
}