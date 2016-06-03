package gamePack.gameEntityPack.gameCharacterPack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameArtifactPack.NullArtifact;
import gamePack.gameEntityPack.gameCharacterBehavior.Attack;
import gamePack.gameEntityPack.gameCombatState.CombatState;
import gamePack.gameEntityPack.gameWeaponPack.GameWeapon;
import gamePack.gameEntityPack.gameWeaponPack.NullWeapon;

public abstract class ConcreteCharacter implements GameCharacter, Dead, GameEntity
{
	public static final Scanner user = new Scanner(System.in);
	public static final Random random = new Random();
	private CombatState currentState;
	private GameArtifact currentItem;
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
	private ArrayList<GameWeapon> myWeapons;
	private ArrayList<State> myStates;
	private ArrayList<GameArtifact> items;
	private ArrayList<GameCharacter> targets;
	//private EntityCanvas blah;
	
	public ConcreteCharacter()
	{
		items = new ArrayList<>();
		myCombatStates = new ArrayList<>();
		myWeapons = new ArrayList<>();
		targets = new ArrayList<>();
		this.setAttackWeapon(new NullWeapon() );
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
	
	@Override
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
	public void attack(GameCharacter you)
	{
		//System.out.println("attacking " + you.getName() );
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
	
	public int compareSpeed(GameCharacter other)
	{
		if(this.getSpeed() < other.getSpeed() )
			return -1;
		
		return 1;
	}

	
	public int getMaxHealth()
	{
		return this.maxHealth;
	}

	
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
	
	public abstract GameWeapon getWeaponChoice();
	
	public void addCombatState(CombatState combatState)
	{
		myCombatStates.add(combatState);
	}
	
	
	public void setCurrentCombatBehavior()
	{
		//currentState = getCombatChoice();
	}
	
	
	public void setState(CombatState newState)
	{
		currentState = newState;
	}
	
	public CombatState getCurrentState()
	{
		return currentState;
	}
	
	public ArrayList<CombatState> getCombatStates()
	{
		return this.myCombatStates;
	}
	
	public void runState()
	{
		if(this.isDead() )
			return;
		currentState.run(this);
	}
	
	public void addItem(GameArtifact item)
	{
		if(items == null)
			items = new ArrayList<>();
		else
		{
			items.add(item);
		}
	}
	
	public void useItem(GameArtifact item)
	{
		if(item != null)
		{
			System.out.println("using " + item.getName() );
			item.use(this);
		}
	}
	
	public GameArtifact chooseItem()
	{
		int i = 1;
		int choice;
		
		
		if(items.size() < 1)
		{
			System.out.println("No items");
			return null;
		}
		
		for(GameArtifact item : items)
			System.out.println(i++ + ". " + item.getName());
		
		choice = user.nextInt();
		
		if(choice < 1 || choice > items.size() + 1)
			return null;

		return items.get(choice - 1);
	}

	@Override
	public String getView()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setView(String view)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateView()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void spawn()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kill()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load()
	{
		// TODO Auto-generated method stub
		
	}
	
	public void enemyCombat(ConcreteCharacter target)
	{
		this.attack(target);
		
	}
	
	public void restore()
	{
		this.setHealth(maxHealth);
		for(GameArtifact artifact : items)
			artifact.restore();
	}
	
	public ArrayList<GameArtifact> getItems()
	{
		return items;
	}
	
	public int compareTo(GameCharacter other)
	{
		if(this.getSpeed() > other.getSpeed() )
			return 1;
		return -1;
	}
	
	public ArrayList<GameCharacter> getTargets()
	{
		return targets;
	}
	
	public void setTargets(ArrayList<GameCharacter> targets)
	{
		this.targets.clear();
		this.targets = targets;
	}
	
	public void chooseTarget(ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes)
	{
		this.currentState.setTargets(this, friends, foes);
	}
	
	public GameArtifact getCurrentItem()
	{
		return currentItem;
	}
	
	public void setCurrentItem(GameArtifact item)
	{
		currentItem = item;
	}
	
	@Override
	public void clearTargets()
	{
		this.getTargets().clear();
	}
}
