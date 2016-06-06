package gamePack.gameStatePack;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;
import gamePack.gameStatePack.gameTextStatePack.SQLiteJDBC;

public class EndGame implements FinalStateInterface {

	private GamePlayer player;

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
	public synchronized void run(GameStateContext gameStateContext) {
		MainWindow.updateTextArea(GameStateContext.getState().getClass().getSimpleName() + "\n"
				+ "\nThank you for playing the game\nPROGRAM TERMINATING\n");
		if (player!=null) {
			GamePlayer oldPlayer = SQLiteJDBC.selectProfile(player.getProfileInfo());
			int oldXP = oldPlayer.getExperience(), newXP = player.getExperience();
			if (newXP > oldXP)
				SQLiteJDBC.updateProfile(player.getProfileInfo(), "EXPERIENCE",
						Integer.toString(player.getExperience()));
			SQLiteJDBC.selectProfile(player.getProfileInfo());
			MainWindow.updateTextArea(
					"oldXP=" + oldXP + " newXP=" + newXP + " profileName" + player.getProfileInfo() + "\n");
		}
		try {
			wait(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(0);
	}

	@Override
	public void gameSave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameShutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlayer(GamePlayer gamePlayer) {
		this.player = gamePlayer;

	}
	
	@Override 
	public GamePlayer getPlayer()
	{
		return this.player;
	}

	@Override
	public void addEnemy(GameCharacter enemy) {
		// TODO Auto-generated method stub
		
	}

}
