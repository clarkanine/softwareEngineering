package gamePack.gameStatePack;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;
import gamePack.gameStatePack.gameTextStatePack.ProfileInputState;

public class StartGame implements InitialStateInterface {

	GameStateContext gameStateContext;

	@Override
	public void run(GameStateContext gameStateContext) {
		this.gameStateContext = gameStateContext;
		MainWindow.updateTextArea(GameStateContext.getState().getClass().getSimpleName() + "\n");
		this.gameStateContext = gameStateContext;
		GameState gameState = new ProfileInputState();
		GameStateContext.setState(gameState);
		this.gameStateContext.run();
	}

	@Override
	public void gameRun() {

	}

	@Override
	public void nextTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeTurn(GameCharacter character) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prelude() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interlude() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cutScene() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitGame(GamePlayer player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterState(GameState state) {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameBuild() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlayer(GamePlayer gamePlayer) {

	}

	@Override
	public void addEnemy(GameCharacter enemy) {
		// TODO Auto-generated method stub

	}

	@Override
	public GamePlayer getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

}
