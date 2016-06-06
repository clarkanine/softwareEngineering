package gamePack.gameStatePack.gameCombatState;

import java.util.ArrayList;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;
import gamePack.gameStatePack.gameTextStatePack.TextInputState;

public class InitialCombatState implements CombatState {

	private GameCharacter actor;
	public InitialCombatState() {
	}

	public InitialCombatState(GameCharacter thePlayer, ArrayList<GameCharacter> theEnemies) {
		this.actor = thePlayer;
		run(actor);
	}

	@Override
	public void run(GameCharacter me) {

		int choice, i = 1;

		for (CombatState combatState : actor.getCombatStates()) {
			// behavior.initCombatState(this, enemies);
			MainWindow.updateTextArea(i++ + ". " + combatState.getName() + "\n");
		}

		choice = TextInputState.readInt();

		/*
		 * Scanner in = new Scanner(System.in); choice = in.nextInt();
		 * in.close();
		 */

		// choice = ConcreteCharacter.user.nextInt();
		// MainWindow.updateTextArea("Chosen state is " +
		// actor.getCombatStates().get(choice-1).getName());
		actor.setState(actor.getCombatStates().get(choice - 1));
		actor.runState();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Beginning combat";
	}

	@Override
	public void setCombat(CombatShenanigans theCombat) {

	}

	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes) {
		// TODO Auto-generated method stub

	}

}
