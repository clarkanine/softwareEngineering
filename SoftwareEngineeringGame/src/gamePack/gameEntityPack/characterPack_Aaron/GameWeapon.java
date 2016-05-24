package characterPack;

public interface GameWeapon
{
	public void weaponAttack(ConcreteCharacter me, ConcreteCharacter you);
	public void weaponDefend(ConcreteCharacter me);
	public int getPower();
	public String getName();
}
