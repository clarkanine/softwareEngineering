
package gamePack.gameStatePack.gameMapStatePack;

import java.io.IOException;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameStatePack.GameState;
import gamePack.gameStatePack.GameStateContext;

public class GameMapState implements GameMapStateInterface {
	GameStateContext gameStateContext;
	

	private GamePlayer player;
	@Override
	public synchronized void run(GameStateContext gameStateContext) {
		this.gameStateContext = gameStateContext;
		MainWindow.updateTextArea(GameStateContext.getState().getClass().getSimpleName()+"\n");
		MainWindow.updateTextArea(" XP="+player.getExperience()+" profileName="+player.getProfileInfo()+"\n");
		MainWindow.knight0_Canvas.gameCharacter = player;
		
		MapCanvas.mapState = MapCanvas.gameMap;
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
		/*
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextLine())
			sc.nextLine();
		sc.close();
		*/
	/*	GameTextInputState newState = new StartMenu();
		newState.setScanner(new Scanner(System.in));
		newState.setPlayer(player);
		gameStateContext.setState(newState);*/
		
		GameStateContext.getState().setPlayer(player);
		gameStateContext.run();
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
		// TODO Auto-generated method stub
		return this.player;
	}

}
