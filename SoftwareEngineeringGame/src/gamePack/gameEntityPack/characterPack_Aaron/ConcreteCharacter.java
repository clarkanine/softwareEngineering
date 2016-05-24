package characterPack;

import java.util.ArrayList;
import java.util.Scanner;

public class ConcreteCharacter implements GameCharacter, Health, Dead
{
	public static final Scanner user = new Scanner(System.in);
	private CombatState currentState;
	private String name;
	private GameWeapon myAttackWeapon, myDefendWeapon;
	private Attack myAttack;
	private Defend myDefend;
	private ArrayList<CombatState> myCombatStates;
	private int health;
	private int maxHealth;
	private int strength;
	private int defense = 10;
	private int speed;
	private boolean isDead;
	private boolean isDefending = false;
	private ArrayList<GameWeapon> myWeapons = new ArrayList<>();
	private ArrayList<State> myStates;
	
	public ConcreteCharacter()
	{
		myCombatStates = new ArrayList<>();
	}
	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
		
	}


	@Override
	public void setHealth(int health)
	{
		if(health <= 0)
		{
			this.health = 0;
			this.setDead(true);
			return;
		}

		this.health = health;
		if(this.health > this.getMaxHealth())
			this.health = this.getMaxHealth();
	}
	
	public void takeDamage(int damage)
	{
		int damageTaken = damage;
		
		if( this.isDefending() )
		{
			damageTaken -= defense;
			if(damageTaken < 0)
				damageTaken = 0;
		}
		
		this.setHealth(this.getHealth() - damageTaken);
		
		if(this.isDead())
			System.out.println(this.getName() + " has fallen");
	}

	@Override
	public int getHealth()
	{
		return this.health;
	}

	@Override
	public void attack(ConcreteCharacter you)
	{
		if(this.isDead())
			return;
		myAttack.attack(this, you);
	}

	@Override
	public void defend()
	{
		this.isDefending = true;
		System.out.println(this.getName() + " is defending!");
		myDefendWeapon.weaponDefend(this);
	}
	
	public int getStrength()
	{
		int totalStrength = this.strength;
		
		if(this.getAttackWeapon() != null)
			totalStrength += this.getAttackWeapon().getPower();
		return totalStrength;
	}
	
	public void setStrength(int strength)
	{
		this.strength = strength;
	}
	
	public int getDefense()
	{
		return this.defense;
	}
	
	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	@Override
	public void setDead(boolean dead)
	{
		this.isDead = dead;
		
	}

	@Override
	public boolean isDead()
	{
		return this.isDead;
	}

	@Override
	public void checkDead()
	{
		if(this.getHealth() <= 0)
			this.setDead(true);
	}
	
	
	public void setAttackWeapon(GameWeapon w)
	{
		this.myAttackWeapon = w;
	}
	
	public void setDefendWeapon(GameWeapon w)
	{
		this.myDefendWeapon = w;
	}
	public GameWeapon getAttackWeapon()
	{
		return myAttackWeapon;
	}
	
	public void setDefending(boolean defending)
	{
		this.isDefending = defending;
	}
	
	public boolean isDefending()
	{
		return this.isDefending;
	}
	
	public void setAttack(Attack attack)
	{
		this.myAttack = attack;
	}
	
	public void setDefend(Defend defend)
	{
		this.myDefend = defend;
	}
	
	public Attack getAttack()
	{
		return myAttack;
	}
	
	public Defend getDefend()
	{
		return myDefend;
	}
	
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}
	
	public int compareSpeed(ConcreteCharacter other)
	{
		if(this.getSpeed() < other.getSpeed() )
			return -1;
		
		return 1;
	}

	@Override
	public int getMaxHealth()
	{
		return this.maxHealth;
	}

	@Override
	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
		
	}
	
	public ArrayList<GameWeapon> getWeapons()
	{
		return myWeapons;
	}
	
	public void addWeapon(GameWeapon w)
	{
		myWeapons.add(w);
	}
	
	public void changeWeapon()
	{
		GameWeapon newWeapon = getWeaponChoice();
		this.setAttackWeapon(newWeapon);
		
	}
	
	private GameWeapon getWeaponChoice()
	{
		int choice;
		int i = 1;
		System.out.println("Pick your weapon:");
		
		for(GameWeapon w : myWeapons)
			System.out.println(i++ + ". " + w.getName());
		choice = user.nextInt();
		
		return myWeapons.get(choice - 1);
	}
	
	public void addCombatState(CombatState combatState)
	{
		myCombatStates.add(combatState);
	}
	
	private CombatState getCombatChoice(ArrayList<ConcreteCharacter> enemies)
	{
		int choice, i = 1;
		
		for(CombatState combatState : myCombatStates)
		{
			System.out.println(i++ + ". " + combatState.getName());
		}
		
		choice = user.nextInt();
		return myCombatStates.get(choice - 1);
	}
	
	public void setCurrentCombatBehavior(ArrayList<ConcreteCharacter> enemies)
	{
		
		currentState = getCombatChoice(enemies);
	}
	
	public void executeCombatBehavior(ArrayList<ConcreteCharacter> enemies)
	{
		//currentState.initCombatState(this, enemies);
		//currentState.execute();
	}
	
	public void setState(CombatState newState)
	{
		currentState = newState;
	}
	
	public ArrayList<CombatState> getCombatStates()
	{
		return this.myCombatStates;
	}
	
	public void runState()
	{
		currentState.run();
	}
	
}
