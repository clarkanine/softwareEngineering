package gamePack.gameStatePack;

import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameEntityPack.gameLocalMapPack.DefaultWindow;

public class DefaultMapState implements GameMapState {

	private GamePlayer player;
	private static Boolean mapIsVisible = new Boolean(false);

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
		//Thread cur = Thread.currentThread();
		DefaultWindow.updateTextArea(gameStateContext.getState().getClass().getSimpleName()+"\n");
		/*Thread t = new Thread(new Runnable() {
			public void run() {
				gamePack.gameEntityPack.gameLocalMapPack.DefaultWindow.main(null);
			}
		});

		t.start();*/
		/*try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


		gamePack.gameEntityPack.gameLocalMapPack.DefaultWindow.restartMap();
		DefaultMapState.setMapIsVisible(true);
		while(mapIsVisible())
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		GameTextInputState newState = new StartMenu();
		newState.setScanner(new Scanner(System.in));
		newState.setPlayer(player);
		gameStateContext.setState(newState);
		gameStateContext.run();
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

	public static boolean mapIsVisible() {
		synchronized(DefaultMapState.mapIsVisible) {
			return DefaultMapState.mapIsVisible;
		}
	}

	public static void setMapIsVisible(boolean mapIsVisible) {
		synchronized(DefaultMapState.mapIsVisible) {
			DefaultMapState.mapIsVisible = mapIsVisible;
		}
	}

}
