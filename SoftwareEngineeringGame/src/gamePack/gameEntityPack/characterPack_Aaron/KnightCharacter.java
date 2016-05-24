package characterPack;

public class KnightCharacter extends ConcreteCharacter
{
	public KnightCharacter(String name)
	{
		this.setMaxHealth(300);
		this.setHealth(100);
		this.setStrength(20);
		this.setName(name);
		this.setAttackWeapon(new NullWeapon() );
		this.setDefendWeapon( this.getAttackWeapon() );
		this.setAttack(new NullAttack() );
		//this.setSpecial( new Heal() );
		//this.addCombatState( new SingleTargetCombat() );
		//this.addCombatState( new AllTargetCombat() );
		//this.addCombatState( new Heal() );
		//this.addCombatState( new ChangeWeapon() );
	}
}
