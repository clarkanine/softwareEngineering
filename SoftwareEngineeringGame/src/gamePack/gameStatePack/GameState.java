package gamePack.gameStatePack;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;

public interface GameState {
	void nextTurn();
	void executeTurn(GameCharacter character);
	void prelude();
	void interlude();
	void cutScene();
	void exitGame();
	void exitGame(GamePlayer player);
	void enterState(GameState state);
}
