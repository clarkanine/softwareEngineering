package gamePack.gameEntityPack.gameCharacterPack.gameEnemyPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameBehaviorPack.GameBehavior;

public class ConcreteGameEnemy implements GameEnemy
{

	private double Accel;
	private double maxSpeed;
	private int strength;
	private double weight;
	private int hp;
	private String name;
	private String view;
	private int difficulty;
	private ArrayList<GameBehavior> behavior;
	private ArrayList<GameArtifact> artifacts;
	
	@Override
	public double getAccel() 
	{
		return this.Accel;
	}//end getAccel

	@Override
	public void setAccel(double accel) 
	{
		if(accel < 0)
		{
			throw new IllegalArgumentException("accel can't be negative");
		}
		this.Accel = accel;
	}//end setAccel

	@Override
	public double getMaxSpeed() 
	{
		return this.maxSpeed;
	}//end getMaxSpeed

	@Override
	public void setMaxSpeed(double maxSpeed)
	{
		if(maxSpeed < 0)
		{
			throw new IllegalArgumentException("maxSpeed can't be negative");
		}
		this.maxSpeed = maxSpeed;	
	}//end setMaxSpeed
	
	@Override
	public int getStrength() 
	{
		return this.strength;
	}//end getStrength

	@Override
	public void setStrength(int strength) 
	{
		this.strength = strength;
	}//end setStrength

	@Override
	public double getWeight() 
	{
		return this.weight;
	}//end getWeight

	@Override
	public void setWeight(double weight) 
	{
		this.weight = weight;
	}//end setWeight

	@Override
	public int getHealth() 
	{
		return this.hp;
	}//end getHealth

	@Override
	public void setHealth(int health) 
	{
		this.hp = health;
	}//end setHealth

	@Override
	public ArrayList<GameBehavior> getBehaviors() 
	{
		return this.behavior;
	}//end getBehaviors

	@Override
	public void setBehaviors(ArrayList<GameBehavior> behaviors)
	{
		this.behavior = behaviors;
	}

	@Override
	public ArrayList<GameArtifact> getArtifacts() 
	{
		return this.artifacts;
	}

	@Override
	public void setArtifacts(ArrayList<GameArtifact> artifacts) 
	{
		this.artifacts = artifacts;
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
	public String getView() 
	{
		return this.view;
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
	}//end updateView

	@Override
	public void spawn() 
	{
		System.out.println(this + "has spawned");
	}//end spawn

	@Override
	public void kill() 
	{
		System.out.println(this + " has been killed");
	}//end kill

	@Override
	public void save() 
	{
		System.out.println(this + " has saved");
	}

	@Override
	public void load() 
	{
		System.out.println(this + "has loaded");
	}

	@Override
	public int getDifficulty() 
	{
		return this.difficulty;
	}
	
	public void setDifficulty(int diff)
	{
		this.difficulty = diff;
	}

	@Override
	public int getExp()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setExp(int exp)
	{
		// TODO Auto-generated method stub
		
	}



}
