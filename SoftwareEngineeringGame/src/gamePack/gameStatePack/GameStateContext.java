package gamePack.gameStatePack;

import java.util.Scanner;

class GameStateContext {
    private GameState myState;
    GameStateContext() {
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

    public void run() {
        myState.run(this);
    }
}