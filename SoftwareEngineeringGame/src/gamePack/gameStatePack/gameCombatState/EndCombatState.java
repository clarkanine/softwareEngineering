package gamePack.gameStatePack.gameCombatState;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;

public class EndCombatState implements CombatState {
	private GameCharacter player;

	public EndCombatState(GameCharacter actor) {
		this.player = actor;
	}

	@Override
	public void run(GameCharacter me) {
		player.restore();
		MainWindow.updateTextArea("Battle has ended\n");

	}

	@Override
	public String getName() {
		return "End combat state";
	}

	@Override
	public void setCombat(CombatShenanigans theCombat) {

	}

	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes) {

	}
}
