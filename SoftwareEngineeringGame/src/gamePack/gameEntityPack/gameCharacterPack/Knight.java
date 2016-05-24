package gamePack.gameEntityPack.gameCharacterPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameBehaviorPack.GameBehavior;

public class Knight implements GameCharacter
{
	public Knight()
	{
		
	}
	
	public void attack()
	{
		
	}
	
	public void setDefault()
	{
		this.setAccel(10);
		this.setExp(10);
		this.setHealth(10);
		this.setMaxSpeed(10);
		this.setName("Knight");
		this.setStrength(10);
		this.setView("../../views/knight");
		this.setWeight(10);
	}

	@Override
	public String getName()
	{
		return null;
	}

	@Override
	public void setName(String name)
	{

	}

	@Override
	public String getView()
	{
		return null;
	}

	@Override
	public void setView(String view)
	{

		
	}

	@Override
	public void updateView()
	{

	}

	@Override
	public void spawn()
	{

		
	}

	@Override
	public void kill()
	{

	}

	@Override
	public void save()
	{

		
	}

	@Override
	public void load()
	{

		
	}

	@Override
	public double getAccel()
	{

		return 0;
	}

	@Override
	public void setAccel(double accel)
	{

		
	}

	@Override
	public int getExp()
	{

		return 0;
	}

	@Override
	public void setExp(int exp)
	{
		
	}

	@Override
	public double getMaxSpeed()
	{

		return 0;
	}

	@Override
	public void setMaxSpeed(double maxSpeed)
	{
		
	}

	@Override
	public int getStrength()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setStrength(int strength)
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHealth()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHealth(int health)
	{
		// TODO Auto-generated method stub
		
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
	public GameBehavior getCurrentAttack()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentAttack(GameBehavior atkBehavior)
	{
		
		
	}

	@Override
	public void attack(GameCharacter target)
	{
		// TODO Auto-generated method stub
		
	}
}
