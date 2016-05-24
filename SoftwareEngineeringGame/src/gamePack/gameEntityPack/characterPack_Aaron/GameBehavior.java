package characterPack;

import java.util.ArrayList;

public interface GameBehavior
{
	public String getName();
	public void initCombatState(ConcreteCharacter me, ArrayList<ConcreteCharacter> enemies);
	public void execute();
}
