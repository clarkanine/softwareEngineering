package gamePack.gameStatePack;

import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;

public interface GameMapState extends GameState {
	public void display();
	void updateDisplay();
	void enterMap();
	void exitMap();
	public void setPlayer(GamePlayer player);
}
