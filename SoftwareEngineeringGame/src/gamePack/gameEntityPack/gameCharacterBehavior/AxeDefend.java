package gamePack.gameEntityPack.gameCharacterBehavior;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.Defend;
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;

public class AxeDefend implements Defend
{

	@Override
	public void defend(ConcreteCharacter me)
	{
		if(!me.isDead())
			MainWindow.updateTextArea(me.getName() + " is defending with axe\n");
		
		me.setDefending(true);
		
	}

}
