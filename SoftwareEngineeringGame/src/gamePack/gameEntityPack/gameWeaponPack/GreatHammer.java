package gamePack.gameEntityPack.gameWeaponPack;

import gamePack.gameEntityPack.gameCharacterBehavior.Attack;
import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.Defend;

public class GreatHammer implements GameWeapon
{

	private int power = 35;
	private int durability = 20;
	private int absorbtion = 5;
	private Attack axeAttack;
	private Defend axeDefend;
	private String name = "GreatHammer";
	
	@Override
	public void weaponAttack(ConcreteCharacter me, ConcreteCharacter you)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void weaponDefend(ConcreteCharacter me)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPower()
	{
		// TODO Auto-generated method stub
		return 35;
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return name;
	}
	public String toString() {return this.getName();}
}
