package gamePack.gameEntityPack.gameCharacterBehavior;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.Defend;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;

public class AxeDefend implements Defend {

	@Override
	public void defend(ConcreteCharacter me) {
		if (!me.isDead())
			MainWindow.updateTextArea(me.getName() + " is defending with axe\n");

		me.setDefending(true);

	}

}
