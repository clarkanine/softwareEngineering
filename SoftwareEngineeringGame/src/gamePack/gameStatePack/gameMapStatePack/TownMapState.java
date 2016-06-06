
package gamePack.gameStatePack.gameMapStatePack;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameStatePack.GameState;
import gamePack.gameStatePack.GameStateContext;

public class TownMapState implements GameMapStateInterface {
	GameStateContext gameStateContext;


	public static GamePlayer player;

	@Override
	public synchronized void run(GameStateContext gameStateContext) {
		this.gameStateContext = gameStateContext;
		MainWindow.updateTextArea(GameStateContext.getState().getClass().getSimpleName()+"\n");

		MapCanvas.mapState = MapCanvas.townMap;

		ArrayList<EntityCanvas> entityCanvases = new ArrayList<>(Arrays.asList(
				MainWindow.snake0_Canvas/*, 
				MainWindow.snake1_Canvas, 
				MainWindow.snake2_Canvas*/));
		ArrayList<Thread> entityThreads = new ArrayList<>(Arrays.asList(
				MainWindow.snake0_Thread/*, 
				MainWindow.snake1_Thread, 
				MainWindow.snake2_Thread*/));
		
		
		EntityCanvas.makeSnakes(entityCanvases, entityThreads);


		MainWindow.knight0_Canvas.setEntityCurX(MainWindow.mapCanvas.getWidth()/2);
		MainWindow.knight0_Canvas.setEntityCurY(MainWindow.mapCanvas.getHeight()/2);

		MainWindow.setGamePaused(true);
		MainWindow.window.pauseAction.putValue("NAME", "PLAY");
		MainWindow.window.pauseAction.putValue("SHORT_DESCRIPTION", "PLAY GAME");
		MainWindow.btnPause.setText("PLAY");

		MainWindow.setMapIsVisible(true);



		while(MainWindow.mapIsVisible())
			try {
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		try {
			System.in.close();//if text was entered during map state this will clear the input stream 
		} catch (IOException e) {
			e.printStackTrace();
		}
		GameState newState = new GameMapState();
		GameStateContext.setState(newState);
		this.gameStateContext.run();
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
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDisplay() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterMap() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitMap() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlayer(GamePlayer player) {
		TownMapState.player = player;		
	}





	@Override
	public void addEnemy(GameCharacter enemy) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public GamePlayer getPlayer() {
		return this.player;
	}

}
