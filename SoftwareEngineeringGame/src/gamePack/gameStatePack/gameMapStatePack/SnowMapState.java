
package gamePack.gameStatePack.gameMapStatePack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameStatePack.GameState;
import gamePack.gameStatePack.GameStateContext;

public class SnowMapState implements GameMapStateInterface {
	GameStateContext gameStateContext;
	

	public GamePlayer player;

	@Override
	public synchronized void run(GameStateContext gameStateContext) {
		this.gameStateContext = gameStateContext;
		MainWindow.updateTextArea(GameStateContext.getState().getClass().getSimpleName()+"\n");
		this.player= (GamePlayer) MainWindow.knight0_Canvas.gameCharacter;
		MainWindow.updateTextArea(" XP="+player.getExperience()+" profileName="+player.getProfileInfo()+"\n");
		MapCanvas.mapState = MapCanvas.snowMap;
		
		ArrayList<EntityCanvas> entityCanvases = new ArrayList<>(Arrays.asList(
				MainWindow.troll0_Canvas/*, 
				MainWindow.troll1_Canvas, 
				MainWindow.troll2_Canvas*/));
		ArrayList<Thread> entityThreads = new ArrayList<>(Arrays.asList(
				MainWindow.troll0_Thread/*, 
				MainWindow.troll1_Thread, 
				MainWindow.troll2_Thread*/));
		EntityCanvas.makeTrolls(entityCanvases, entityThreads);
		
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
		this.player = player;		
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
