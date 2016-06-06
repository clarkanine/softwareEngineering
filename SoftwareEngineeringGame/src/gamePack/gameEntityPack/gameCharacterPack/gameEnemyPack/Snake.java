package gamePack.gameEntityPack.gameCharacterPack.gameEnemyPack;

import gamePack.gameEntityPack.gameCharacterBehavior.NullAttack;
import gamePack.gameEntityPack.gameWeaponPack.NullWeapon;

public class Snake extends ConcreteGameEnemy {
	public Snake() {
		super();
		this.setName("Snake");
		this.setMaxHealth(20);
		this.setHealth(20);
		this.setStrength(5);
		this.setAttackWeapon(new NullWeapon());
		this.setAttack(new NullAttack());
		this.addCombatState(new AISingleTarget());
	}
}
