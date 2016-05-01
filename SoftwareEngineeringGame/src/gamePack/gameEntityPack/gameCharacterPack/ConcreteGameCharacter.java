package gamePack.gameEntityPack.gameCharacterPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameBehaviorPack.GameBehavior;

public class ConcreteGameCharacter implements GameCharacter
{
	private double accel;
	private String name;
	private String view;
	private double maxSpeed;
	private int strength;
	private double weight;
	private int health;
	private ArrayList<GameArtifact> items;
	private ArrayList<GameBehavior> behaviors;
	
	
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
		System.out.println("View has been updated");	
	}

	@Override
	public void spawn()
	{
		System.out.println(this + " has spawned");
		
	}

	@Override
	public void kill()
	{
		System.out.println(this + " has been killed");
		
	}

	@Override
	public void save()
	{
		System.out.println(this + " has saved");
		
	}

	@Override
	public void load()
	{
		System.out.println(this + " has loaded");
		
	}

	@Override
	public double getAccel()
	{
		// TODO Auto-generated method stub
		return accel;
	}

	@Override
	public void setAccel(double accel)
	{
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
		return behaviors;
	}

	@Override
	public void setBehaviors(ArrayList<GameBehavior> behaviors)
	{
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
		this.items = artifacts;
		
	}

}
