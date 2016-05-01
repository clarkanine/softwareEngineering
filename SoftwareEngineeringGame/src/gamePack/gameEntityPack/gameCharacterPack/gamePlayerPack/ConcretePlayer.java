package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameBehaviorPack.GameBehavior;

public class ConcretePlayer implements GamePlayer
{

	private double accel;
	private String name;
	private String view;
	private String profile;
	private String stats;
	private double maxSpeed;
	private int strength;
	private double weight;
	private int health;
	private ArrayList<GameArtifact> items;
	private ArrayList<GameBehavior> behaviors;
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
		// TODO Auto-generated method stub
		return this.behaviors;
	}

	@Override
	public void setBehaviors(ArrayList<GameBehavior> behaviors)
	{
		// TODO Auto-generated method stub
		this.behaviors = behaviors;
	}

	@Override
	public ArrayList<GameArtifact> getArtifacts()
	{
		// TODO Auto-generated method stub
		return items;
	}

	@Override
	public void setArtifacts(ArrayList<GameArtifact> artifacts)
	{
		// TODO Auto-generated method stub
		this.items = artifacts;

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

}
