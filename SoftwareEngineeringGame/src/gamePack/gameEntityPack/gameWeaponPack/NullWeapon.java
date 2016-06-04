package gamePack.gameEntityPack.gameWeaponPack;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;

public class NullWeapon implements GameWeapon
{

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
		return 0;
	}
	
	public String getName()
	{
		return "bare hands";
	}
	public String toString() {return this.getName();}
}
