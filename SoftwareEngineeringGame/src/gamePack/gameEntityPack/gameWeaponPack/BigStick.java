package gamePack.gameEntityPack.gameWeaponPack;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;

public class BigStick implements GameWeapon {

	private int power = 5;
	private String name = "BigStick";

	@Override
	public void weaponAttack(ConcreteCharacter me, ConcreteCharacter you) {
		// TODO Auto-generated method stub

	}

	@Override
	public void weaponDefend(ConcreteCharacter me) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return this.power;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return this.getName();
	}
}
