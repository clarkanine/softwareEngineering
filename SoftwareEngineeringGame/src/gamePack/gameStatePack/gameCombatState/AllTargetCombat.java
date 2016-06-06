package gamePack.gameStatePack.gameCombatState;

import java.util.ArrayList;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public class AllTargetCombat implements CombatState {

	Scanner user;
	public AllTargetCombat() {
	}

	public AllTargetCombat(GameCharacter player, ArrayList<GameCharacter> enemies) {

	}

	@Override
	public void run(GameCharacter me) {
		for (GameCharacter c : me.getTargets())
			me.attack(c);

		// actor.setState( new EnemyCombat(actor, characters));
		// theCombat.printStatus();

	}

	public String getName() {
		return "All target ";
	}

	@Override
	public void setCombat(CombatShenanigans theCombat) {

	}

	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes) {
		me.setTargets(foes);

	}

}
