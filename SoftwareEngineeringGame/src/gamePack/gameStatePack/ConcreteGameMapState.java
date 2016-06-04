
package gamePack.gameStatePack;

import java.io.IOException;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;

public class ConcreteGameMapState implements GameMapState {
	public static GameStateContext gameStateContext;
	

	public static GamePlayer player;
	private static Boolean mapIsVisible = new Boolean(false);

	@Override
	public synchronized void run(GameStateContext gameStateContext) {
		ConcreteGameMapState.gameStateContext = gameStateContext;
		MainWindow.gameStateContext = gameStateContext;
		MainWindow.updateTextArea(gameStateContext.getState().getClass().getSimpleName()+"\n");
		
		
		
		ConcreteGameMapState.setMapIsVisible(true);
		
		
	
		while(mapIsVisible())
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
		/*Scanner sc = new Scanner(System.in);
		if(sc.hasNextLine())
			sc.nextLine();
		sc.close();*/
		
		GameTextInputState newState = new StartMenu();
		newState.setScanner(new Scanner(System.in));
		newState.setPlayer(player);
		gameStateContext.setState(newState);
		gameStateContext.run();
	}

	public static boolean mapIsVisible() {
		synchronized(ConcreteGameMapState.mapIsVisible) {
			return ConcreteGameMapState.mapIsVisible;
		}
	}

	public static void setMapIsVisible(boolean mapIsVisible) {
		synchronized(ConcreteGameMapState.mapIsVisible) {
			ConcreteGameMapState.mapIsVisible = mapIsVisible;
		}
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

}
