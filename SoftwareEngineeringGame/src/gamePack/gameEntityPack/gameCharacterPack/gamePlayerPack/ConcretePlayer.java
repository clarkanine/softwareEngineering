package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;

import java.util.ArrayList;

<<<<<<< HEAD
=======
import gamePack.gameEntityPack.GameEntity;
>>>>>>> 68a0ca0680ed1fec3e33bc5d234c4e351df78b6a
import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameBehaviorPack.GameBehavior;

public class ConcretePlayer implements GamePlayer
{
<<<<<<< HEAD

	
=======
>>>>>>> 68a0ca0680ed1fec3e33bc5d234c4e351df78b6a
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
<<<<<<< HEAD
	private ArrayList<GameArtifact> items;
	private ArrayList<GameBehavior> behaviors;
=======
	//private AttackBehavior currentAttack;
	
	private ArrayList<GameEntity> entities;
	//private ArrayList<GameArtifact> items;
	//private ArrayList<GameBehavior> behaviors;
>>>>>>> 68a0ca0680ed1fec3e33bc5d234c4e351df78b6a
	
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
		// TODO Auto-generated method stub
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
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return this.behaviors;
	}

	@Override
	public void setBehaviors(ArrayList<GameBehavior> behaviors)
	{
		// TODO Auto-generated method stub
		this.behaviors = behaviors;
=======
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
>>>>>>> 68a0ca0680ed1fec3e33bc5d234c4e351df78b6a
	}

	@Override
	public ArrayList<GameArtifact> getArtifacts()
	{
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return items;
=======
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
>>>>>>> 68a0ca0680ed1fec3e33bc5d234c4e351df78b6a
	}

	@Override
	public void setArtifacts(ArrayList<GameArtifact> artifacts)
	{
<<<<<<< HEAD
		// TODO Auto-generated method stub
		this.items = artifacts;
=======
		//this.items = artifacts;
>>>>>>> 68a0ca0680ed1fec3e33bc5d234c4e351df78b6a

	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name)
	{
		// TODO Auto-generated method stub
		this.name = name;

	}

	@Override
	public String getView()
	{
		// TODO Auto-generated method stub
		return view;
	}

	@Override
	public void setView(String view)
	{
		// TODO Auto-generated method stub
		this.view = view;

	}

	@Override
	public void updateView()
	{
		// TODO Auto-generated method stub
		System.out.println("updated view");

	}

	@Override
	public void spawn()
	{
		// TODO Auto-generated method stub
		System.out.println("spawned");

	}

	@Override
	public void kill()
	{
		// TODO Auto-generated method stub
		System.out.println("killed");
	}

	@Override
	public void save()
	{
		// TODO Auto-generated method stub
		System.out.println("Saved");

	}

	@Override
	public void load()
	{
		// TODO Auto-generated method stub
		System.out.println("Loaded");

	}

	@Override
	public String getProfileInfo()
	{
		// TODO Auto-generated method stub
		return profile;
	}

	@Override
	public void setProfileInfo(String info)
	{
		// TODO Auto-generated method stub
		profile = info;

	}

	@Override
	public String getStats()
	{
		// TODO Auto-generated method stub
		return stats;
	}

	@Override
	public void setStats(String stats)
	{
		// TODO Auto-generated method stub
		this.stats = stats;

	}

	@Override
	public int getExp()
	{
		// TODO Auto-generated method stub
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

<<<<<<< HEAD
=======
	public void attack()
	{
		//currentAttack.executeBehavior();
	}
>>>>>>> 68a0ca0680ed1fec3e33bc5d234c4e351df78b6a
}
