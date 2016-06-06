package gamePack.gameEntityPack.gameCharacterBehavior;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;

public class TrollAttack implements Attack {

	@Override
	public void attack(GameCharacter me, GameCharacter you) {
		MainWindow.updateTextArea(me.getName() + " wildly thrashes his " + me.getAttackWeapon().getName() + " and hits "
				+ you.getName() + "\n");
		you.takeDamage(me.getStrength());
	}

}
