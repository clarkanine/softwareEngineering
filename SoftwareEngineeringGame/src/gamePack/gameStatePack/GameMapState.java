package gamePack.gameStatePack;

public interface GameMapState extends GameState {
	public void display();
	void updateDisplay();
	void enterMap();
	void exitMap();
}
