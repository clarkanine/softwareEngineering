package gamePack.gameStatePack.gameMapStatePack;

import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameStatePack.GameState;

public interface GameMapStateInterface extends GameState {
	public void display();
	void updateDisplay();
	void enterMap();
	void exitMap();
	public void setPlayer(GamePlayer player);
}
