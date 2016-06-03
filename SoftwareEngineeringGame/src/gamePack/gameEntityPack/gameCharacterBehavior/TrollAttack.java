package gamePack.gameEntityPack.gameCharacterBehavior;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public class TrollAttack implements Attack
{

	@Override
	public void attack(GameCharacter me, GameCharacter you)
	{
		System.out.println(me.getName() + " wildly thrashes his " + me.getAttackWeapon().getName() + " and hits " + you.getName() );
		you.takeDamage(me.getStrength());
	}

}
