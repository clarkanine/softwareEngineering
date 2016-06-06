package gamePack.gameEntityPack.gameCharacterBehavior;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;

public interface GameBehavior {
	public String getName();

	public void initCombatState(ConcreteCharacter me, ArrayList<ConcreteCharacter> enemies);

	public void execute();
}
