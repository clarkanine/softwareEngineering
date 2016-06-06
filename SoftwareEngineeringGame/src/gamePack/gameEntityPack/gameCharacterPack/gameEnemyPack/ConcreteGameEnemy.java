package gamePack.gameEntityPack.gameCharacterPack.gameEnemyPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameWeaponPack.GameWeapon;
import gamePack.gameStatePack.gameCombatState.CombatState;

public class ConcreteGameEnemy extends ConcreteCharacter {

	@Override
	public GameWeapon getWeaponChoice() {
		int numWeapons;
		ArrayList<GameWeapon> weapons = this.getWeapons();

		numWeapons = weapons.size();

		return weapons.get(ConcreteCharacter.random.nextInt(numWeapons));
	}

	@Override
	public void getCombatChoice() {
		int numStates;
		ArrayList<CombatState> theStates = this.getCombatStates();

		numStates = theStates.size();

		this.setState(theStates.get(Math.abs(ConcreteCharacter.random.nextInt(numStates))));
		// System.out.println("Chosen state is " +
		// this.getCurrentState().getName() );
	}

}