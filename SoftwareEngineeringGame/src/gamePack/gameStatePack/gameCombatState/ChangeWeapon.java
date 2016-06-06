package gamePack.gameStatePack.gameCombatState;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public class ChangeWeapon implements CombatState {

	public ChangeWeapon() {
	}

	public ChangeWeapon(GameCharacter player, ArrayList<GameCharacter> enemies2) {
	}

	@Override
	public String getName() {
		return "change weapon";
	}

	@Override
	public void run(GameCharacter me) {
		;

	}

	@Override
	public void setCombat(CombatShenanigans theCombat) {

	}

	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes) {
		me.changeWeapon();
	}

}
