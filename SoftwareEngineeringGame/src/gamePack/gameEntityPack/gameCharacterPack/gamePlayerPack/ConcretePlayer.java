package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameBehaviorPack.GameBehavior;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public class ConcretePlayer implements GamePlayer
{
	private double accel;
	private String profileName;
	private String name;
	private String view;
	private String profile;
	private String stats;
	private double maxSpeed;
	private int strength;
	private int exp;
	private double weight;
	private int health;
	private GameBehavior currentAttack;
	
	private ArrayList<GameEntity> entities;
	//private ArrayList<GameArtifact> items;
	//private ArrayList<GameBehavior> behaviors;
	
	@Override
	public double getAccel()
	{
		// TODO Auto-generated method stub
		return accel;
	}

	@Override
	public void setAccel(double accel)
	{
		// TODO Auto-generated method stub
		this.accel = accel;

	}

	@Override
	public double getMaxSpeed()
	{
		// TODO Auto-generated method stub
		return maxSpeed;
	}

	@Override
	public void setMaxSpeed(double maxSpeed)
	{
		// TODO Auto-generated method stub
		this.maxSpeed = maxSpeed;

	}

	@Override
	public int getStrength()
	{
		// TODO Auto-generated method stub
		return strength;
	}

	@Override
	public void setStrength(int strength)
	{
		// TODO Auto-generated method stub
		this.strength = strength;
	}

	@Override
	public double getWeight()
	{
		return weight;
	}

	@Override
	public void setWeight(double weight)
	{
		this.weight = weight;

	}

	@Override
	public int getHealth()
	{
		// TODO Auto-generated method stub
		return health;
	}

	@Override
	public void setHealth(int health)
	{
		this.health = health;

	}

	@Override
	public ArrayList<GameBehavior> getBehaviors()
	{
		ArrayList<GameBehavior> behavs = new ArrayList<>();
		GameBehavior curr;
		
		
		for( GameEntity entity : entities)
		{
			if( entity instanceof GameBehavior )
			{
				curr = (GameBehavior) entity;
				behavs.add(curr);
			}
		}
			
		return behavs;
	}

	
	@Override
	public void setBehaviors(ArrayList<GameBehavior> behaviors)
	{
		//this.behaviors = behaviors;
	}
	
	public void addBehavior(GameBehavior behavior)
	{
		entities.add(behavior);
	}

	@Override
	public ArrayList<GameArtifact> getArtifacts()
	{
		ArrayList<GameArtifact> artifacts = new ArrayList<>();
		GameArtifact curr;
		
		
		for( GameEntity entity : entities)
		{
			if( entity instanceof GameArtifact )
			{
				curr = (GameArtifact) entity;
				artifacts.add(curr);
			}
		}
			
		return artifacts;
	}
	
	public void addArtifact(GameArtifact artifact)
	{
		entities.add(artifact);
	}

	@Override
	public void setArtifacts(ArrayList<GameArtifact> artifacts)
	{
		//this.items = artifacts;

	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;

	}

	@Override
	public String getView()
	{
		return view;
	}

	@Override
	public void setView(String view)
	{
		this.view = view;

	}

	@Override
	public void updateView()
	{
		System.out.println("updated view");

	}

	@Override
	public void spawn()
	{
		System.out.println("spawned");

	}

	@Override
	public void kill()
	{
		System.out.println("killed");
	}

	@Override
	public void save()
	{
		System.out.println("Saved");

	}

	@Override
	public void load()
	{
		System.out.println("Loaded");

	}

	@Override
	public String getProfileInfo()
	{
		return profile;
	}

	@Override
	public void setProfileInfo(String info)
	{
		profile = info;

	}

	@Override
	public String getStats()
	{
		return stats;
	}

	@Override
	public void setStats(String stats)
	{
		this.stats = stats;
	}

	@Override
	public int getExp()
	{
		return exp;
	}

	@Override
	public void setExp(int exp)
	{
		this.exp = exp;
		
	}
	
	public String getProfileName()
	{
		return profileName;
	}
	
	public void setProfileName(String profName)
	{
		this.profileName = profName;
	}

	public void attack(GameCharacter target)
	{
		
	}

	@Override
	public GameBehavior getCurrentAttack()
	{
		return this.currentAttack;
	}

	@Override
	public void setCurrentAttack(GameBehavior atkBehavior)
	{
		this.currentAttack = atkBehavior;
		
	}

}
