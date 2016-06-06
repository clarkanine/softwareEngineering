package gamePack.gameEntityPack.gameWeaponPack;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;

public interface GameWeapon
{
	public void weaponAttack(ConcreteCharacter me, ConcreteCharacter you);
	public void weaponDefend(ConcreteCharacter me);
	public int getPower();
	public String getName();
}
