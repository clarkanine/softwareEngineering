package gamePack.gameEntityPack.gameCharacterPack.gameEnemyPack;

import gamePack.gameEntityPack.gameCharacterBehavior.*;
import gamePack.gameEntityPack.gameWeaponPack.*;

public class Dragon extends ConcreteGameEnemy {

	public Dragon() {
		super();
		this.setName("Dragon");
		this.setMaxHealth(50);
		this.setHealth(50);
		this.setStrength(5);
		this.setAttackWeapon(new FireBreath());
		this.setAttack(new DragonAttack());
		this.addCombatState(new AISingleTarget());

	}

}// end class
