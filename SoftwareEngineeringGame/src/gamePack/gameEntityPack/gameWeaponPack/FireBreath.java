package gamePack.gameEntityPack.gameWeaponPack;

import gamePack.gameEntityPack.gameCharacterBehavior.Attack;
import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.Defend;

public class FireBreath implements GameWeapon
{

	private int power = 5;
	private int durability = 20;
	private int absorbtion = 5;
	private Attack axeAttack;
	private Defend axeDefend;
	private String name = "FireBreath";
	
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
		return this.power;
	}
	
	public String getName()
	{
		return name;
	}

}
