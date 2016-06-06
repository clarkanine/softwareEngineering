package gamePack.gameEntityPack.gameWeaponPack;

import gamePack.gameEntityPack.gameCharacterBehavior.Attack;
import gamePack.gameEntityPack.gameCharacterBehavior.AxeAttack;
import gamePack.gameEntityPack.gameCharacterBehavior.AxeDefend;
import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.Defend;

public class BattleAxe implements GameWeapon {
	private int power = 10;
	private Attack axeAttack;
	private Defend axeDefend;
	private String name = "BattleAxe";

	public BattleAxe() {
		axeAttack = new AxeAttack();
		axeDefend = new AxeDefend();
	}

	public int getPower() {
		return power;
	}

	@Override
	public void weaponAttack(ConcreteCharacter me, ConcreteCharacter you) {
		axeAttack.attack(me, you);
	}

	@Override
	public void weaponDefend(ConcreteCharacter me) {
		axeDefend.defend(me);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String toString() {
		return this.getName();
	}

}
