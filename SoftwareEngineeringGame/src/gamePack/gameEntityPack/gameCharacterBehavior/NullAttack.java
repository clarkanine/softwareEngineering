package gamePack.gameEntityPack.gameCharacterBehavior;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;

public class NullAttack implements Attack {

	@Override
	public void attack(GameCharacter me, GameCharacter you) {
		if (you.isDead()) {
			MainWindow.updateTextArea(you.getName() + " is dead. You give him a disrespectful kick in the head\n");
			return;
		}
		MainWindow.updateTextArea(
				me.getName() + " is hitting " + you.getName() + " with his " + me.getAttackWeapon().getName() + "\n");
		you.takeDamage(me.getStrength());

	}

}
