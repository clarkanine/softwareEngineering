package characterPack;

public class NullAttack implements Attack
{

	@Override
	public void attack(ConcreteCharacter me, ConcreteCharacter you)
	{
		if(you.isDead())
		{
			System.out.println(you.getName() + " is dead. You give him a disrespectful kick in the head");
			return;
		}
		System.out.println(me.getName() + " is hitting " + you.getName() + " with his " + me.getAttackWeapon().getName());
		you.takeDamage( me.getStrength() );
		
	}
	
}
