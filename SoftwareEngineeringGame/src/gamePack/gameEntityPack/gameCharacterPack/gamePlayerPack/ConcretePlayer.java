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
	private double strength;
	private double weight;
	private int health;
	private ArrayList<GameArtifact> items;
	private ArrayList<GameBehavior> behaviors;
	@Override
	public double getAccel()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAccel(double accel)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public double getMaxSpeed()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMaxSpeed(double maxSpeed)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public double getStrength()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setStrength(double strength)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public double getWeight()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWeight(double weight)
	{
		this.weight = weight;

	}

	@Override
	public double getHealth()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHealth(double health)
	{
		this.health = health;

	}

	@Override
	public ArrayList<GameBehavior> getBehaviors()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBehaviors(ArrayList<GameBehavior> behaviors)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<GameArtifact> getArtifacts()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setArtifacts(ArrayList<GameArtifact> artifacts)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name)
	{
		// TODO Auto-generated method stub

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

	@Override
	public String getProfileInfo()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProfileInfo(String info)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String getStats()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStats(String stats)
	{
		// TODO Auto-generated method stub

	}

}
