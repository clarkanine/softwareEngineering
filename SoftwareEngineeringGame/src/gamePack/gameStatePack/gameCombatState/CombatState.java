package gamePack.gameStatePack.gameCombatState;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public interface CombatState {
	public void run(GameCharacter me);

	public String getName();

	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes);

	public void setCombat(CombatShenanigans theCombat);
}
