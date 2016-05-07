package gamePack.gameStatePack;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameEntityPack.gameLocalMapPack.DefaultWindow;

public class EndGame implements GameFinalState {

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
	public void run(GameStateContext gameStateContext) {
		DefaultWindow.updateTextArea(gameStateContext.getState().getClass().getSimpleName() + "\n"
		+ "\nThank you for playing the game\n\n");
		System.exit(0);
	}

	@Override
	public void gameSave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameShutdown() {
		// TODO Auto-generated method stub

	}

}
