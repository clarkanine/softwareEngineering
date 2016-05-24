package characterPack;

public interface Special extends CombatState
{
	public void useSpecial(ConcreteCharacter me, ConcreteCharacter you);
	public String getName();
}
