
package gamePack.gameStatePack.gameMapStatePack;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameStatePack.GameState;
import gamePack.gameStatePack.GameStateContext;
import gamePack.gameStatePack.gameTextStatePack.GameTextInputState;
import gamePack.gameStatePack.gameTextStatePack.StartMenu;

public class VolcanoMapState implements GameMapStateInterface {
	GameStateContext gameStateContext;
	

	public GamePlayer player;

	@Override
	public synchronized void run(GameStateContext gameStateContext) {
		this.gameStateContext = gameStateContext;
		MainWindow.updateTextArea(GameStateContext.getState().getClass().getSimpleName()+"\n");
		this.player= (GamePlayer) MainWindow.knight0_Canvas.gameCharacter;
		MainWindow.updateTextArea(" XP="+player.getExperience()+" profileName="+player.getProfileInfo()+"\n");
		
		
		MapCanvas.mapState = MapCanvas.volcanoMap;
		
		ArrayList<EntityCanvas> entityCanvases = new ArrayList<>(Arrays.asList(
				MainWindow.dragon0_Canvas/*, 
				MainWindow.dragon1_Canvas, 
				MainWindow.dragon2_Canvas*/));
		ArrayList<Thread> entityThreads = new ArrayList<>(Arrays.asList(
				MainWindow.dragon0_Thread/*, 
				MainWindow.dragon1_Thread, 
				MainWindow.dragon2_Thread*/));
		
		EntityCanvas.makeDragons(entityCanvases, entityThreads);
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
