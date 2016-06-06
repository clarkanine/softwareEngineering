package gamePack.gameEntityPack.gameCharacterBehavior;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public interface Attack {
	public void attack(GameCharacter me, GameCharacter you);
}
