package gamePack.gameStatePack;

public class GameStateContext {
	private static GameState gameState;
	private static GameStateContext gameStateContext;
	@SuppressWarnings("unused")
	private static int difficulty;

	private GameStateContext() {
		gameState = new StartGame();
		GameStateContext.gameStateContext = this;
	}

	public static void setState(final GameState newState) {
		if (GameStateContext.getGameStateContext() == null)
			GameStateContext.gameStateContext = new GameStateContext();
		GameStateContext.gameState = newState;
	}

	public static GameState getState() {
		if (GameStateContext.gameState == null) {
			GameStateContext.gameStateContext = new GameStateContext();
		}
		return GameStateContext.gameState;
	}

	public void run() {
		gameState.run(this);
	}

	public static GameStateContext getGameStateContext() {
		if (GameStateContext.gameStateContext == null) {
			GameStateContext.gameStateContext = new GameStateContext();
		}
		return GameStateContext.gameStateContext;
	}

	public static void setDifficulty(int difficultyInt) {
		GameStateContext.difficulty = difficultyInt;

	}
}