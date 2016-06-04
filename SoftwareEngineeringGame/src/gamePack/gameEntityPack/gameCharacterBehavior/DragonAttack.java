package gamePack.gameEntityPack.gameCharacterBehavior;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;

public class DragonAttack implements Attack
{

	@Override
	public void attack(GameCharacter me, GameCharacter you)
	{
		MainWindow.updateTextArea(me.getName() + " blows " + me.getAttackWeapon().getName() + " and burns " + you.getName() +"\n");
		you.takeDamage(me.getStrength());
	}

}
