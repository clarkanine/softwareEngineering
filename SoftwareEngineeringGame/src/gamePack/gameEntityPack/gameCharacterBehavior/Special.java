package gamePack.gameEntityPack.gameCharacterBehavior;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameStatePack.gameCombatState.CombatState;

public interface Special extends CombatState
{
	public void useSpecial(ConcreteCharacter me, ConcreteCharacter you);
	public String getName();
}
