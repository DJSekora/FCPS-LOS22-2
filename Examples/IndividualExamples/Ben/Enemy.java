public class Enemy extends Entity
{
  int attack;
  int defense;
  
  public Enemy(String enemyName, int enemyHealth, int enemyAttack, int enemyDefense)
  {
    super(enemyName, enemyHealth);
    attack = enemyAttack;
    defense = enemyDefense;
  }
  
  // getAttack and getDefense methods for consistency with player syntax
  public int getAttack()
  {
    return attack;
  }
  
  public int getDefense()
  {
    return attack;
  }
}