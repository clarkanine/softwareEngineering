package gamePack.gameStatePack;

import java.util.Scanner;

public class GameStateContext {
    private GameState myState;
    public GameStateContext() {
        this.setState(new StartGame());
    }

    /**
     * Setter method for the state.
     * Normally only called by classes implementing the State interface.
     * @param newState the new state of this context
     */
    void setState(final GameState newState) {
        myState = newState;
    }

    public GameState getState() {
        return myState;
    }
    
    public void run() {
        myState.run(this);
    }
}