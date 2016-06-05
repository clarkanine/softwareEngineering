
package gamePack.gameStatePack.gameMapStatePack;

import java.awt.Image;
import java.io.IOException;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameStatePack.GameState;
import gamePack.gameStatePack.GameStateContext;
import gamePack.gameStatePack.gameTextStatePack.GameTextInputState;
import gamePack.gameStatePack.gameTextStatePack.StartMenu;

public class SnowMapState implements GameMapStateInterface {
	GameStateContext gameStateContext;
	

	public static GamePlayer player;

	@Override
	public synchronized void run(GameStateContext gameStateContext) {
		this.gameStateContext = gameStateContext;
		MainWindow.updateTextArea(this.gameStateContext.getState().getClass().getSimpleName()+"\n");
		
		MapCanvas.mapState = MapCanvas.snowMap;
		

		if (MainWindow.troll0_Canvas == null) {
			MainWindow.troll0_Canvas = new EntityCanvas(MainWindow.getNewEntityID());
			MainWindow.mapCanvas.entities.add(MainWindow.troll0_Canvas);
			MainWindow.troll0_Canvas.initEntity();
			for (Image entityImage : MainWindow.troll0_Canvas.entityImgs)
				MainWindow.mapCanvas.mt.addImage(entityImage, MainWindow.mapCanvas.mtCount++);
			MainWindow.snake0Thread = EntityCanvas.makeTroll(MainWindow.troll0_Canvas);
			MainWindow.entityThreads.add(MainWindow.snake0Thread);
			//entityThreads.get(snake0_ID).start();
			MainWindow.snake0Thread.start();
		}
		MainWindow.troll0_Canvas.setEntityCurX((int) (Math.random()*MainWindow.mapCanvas.getWidth()));
		MainWindow.troll0_Canvas.setEntityCurY((int) (Math.random()*MainWindow.mapCanvas.getHeight()));
		
		
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

		GameState newState = new ConcreteGameMapState();
		this.gameStateContext.setState(newState);
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

}
