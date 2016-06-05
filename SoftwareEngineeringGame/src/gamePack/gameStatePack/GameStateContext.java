package gamePack.gameStatePack;

import java.util.Scanner;

public class GameStateContext {
    private static GameState gameState;
    private static GameStateContext gameStateContext;
    private GameStateContext() {
        gameState = new StartGame();
        GameStateContext.gameStateContext = this;
    }

    /**
     * Setter method for the state.
     * Normally only called by classes implementing the State interface.
     * @param newState the new state of this context
     */
    public static void setState(final GameState newState) {
    	if(GameStateContext.getGameStateContext()==null)
    		GameStateContext.gameStateContext = new GameStateContext();
        GameStateContext.gameState = newState;
    }

    public GameState getState() {
    	if(GameStateContext.gameState==null) {
    		GameStateContext.gameStateContext = new GameStateContext();
    	}
        return GameStateContext.gameState;
    }
    
    public void run() {
        gameState.run(this);
    }

	public static GameStateContext getGameStateContext() {
		if(GameStateContext.gameStateContext==null) {
    		GameStateContext.gameStateContext = new GameStateContext();
    	}
        return GameStateContext.gameStateContext;
	}
}