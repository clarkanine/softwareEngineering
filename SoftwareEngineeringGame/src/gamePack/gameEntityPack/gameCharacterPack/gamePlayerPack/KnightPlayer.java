package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;

import gamePack.gameEntityPack.gameArtifactPack.Potion;
import gamePack.gameEntityPack.gameBehaviorPack.KnightAttackBehavior;
import gamePack.gameEntityPack.gameCharacterBehavior.Heal;
import gamePack.gameEntityPack.gameCharacterBehavior.NullAttack;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCombatState.AllTargetCombat;
import gamePack.gameEntityPack.gameCombatState.ChangeWeapon;
import gamePack.gameEntityPack.gameCombatState.SingleTargetCombat;
import gamePack.gameEntityPack.gameCombatState.UseItemState;
import gamePack.gameEntityPack.gameWeaponPack.BattleAxe;
import gamePack.gameEntityPack.gameWeaponPack.BigStick;
import gamePack.gameEntityPack.gameWeaponPack.GreatHammer;
import gamePack.gameEntityPack.gameWeaponPack.NullWeapon;
import gamePack.gameEntityPack.gameWeaponPack.WeaponOfTheGods;

public class KnightPlayer extends ConcretePlayer
{
	public KnightPlayer()
	{
		this.setDefault();
	}
	
	public void setDefault()
	{
		this.setName("Aaron");
		this.setAttack(new NullAttack());
		this.setMaxHealth(300);
		this.restore();
		this.setStrength(40);
		
		

		this.addWeapon(new BigStick());
		this.addWeapon(new GreatHammer());
		this.addWeapon(new BattleAxe() );
		this.addWeapon(new WeaponOfTheGods());
		this.setAttackWeapon(new NullWeapon() );
		
		this.addCombatState(new AllTargetCombat() );
		this.addCombatState(new SingleTargetCombat() );
		this.addCombatState(new ChangeWeapon() );
		this.addCombatState(new UseItemState() );
		
		this.addItem(new Potion(5, "Potion") );
	}
}
