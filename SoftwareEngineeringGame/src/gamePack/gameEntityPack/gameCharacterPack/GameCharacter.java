package gamePack.gameEntityPack.gameCharacterPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameCharacterBehavior.Attack;
import gamePack.gameEntityPack.gameCombatState.CombatState;
import gamePack.gameEntityPack.gameWeaponPack.GameWeapon;

public interface GameCharacter extends Comparable<GameCharacter>
{
	public String getName();
	public void setName(String name);
	public void attack(GameCharacter enemy);
	public void defend();
	public void takeDamage(int damage);
	public int getStrength();
	public void setStrength(int strength);
	public int getDefense();
	public void setDefense(int defense);
	public void setAttackWeapon(GameWeapon weapon);
	public GameWeapon getAttackWeapon();
	public void setAttack(Attack theAttack);
	public Attack getAttack();
	public void setSpeed(int speed);
	public int getSpeed();
	public ArrayList<GameWeapon> getWeapons();
	public void addWeapon(GameWeapon weapon);
	public void addCombatState(CombatState combatState);
	public int getHealth();
	public void setHealth(int health);
	public boolean isDead();
	public void addItem(GameArtifact item);
	public void changeWeapon();
	public int getMaxHealth();
	public ArrayList<CombatState> getCombatStates();
	public GameArtifact chooseItem();
	public void useItem(GameArtifact theItem);
	public void setState(CombatState theState);
	public void restore();
	public void runState();
	public void getCombatChoice();
	public void chooseTarget(ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes);
	public void setTargets(ArrayList<GameCharacter> targets);
	public ArrayList<GameCharacter> getTargets();
	public void setCurrentItem(GameArtifact item);
	public GameArtifact getCurrentItem();
	public CombatState getCurrentState();
	public void clearTargets();
	
}
