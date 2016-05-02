package gamePack.gameEntityPack.gameCharacterPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameBehaviorPack.GameBehavior;

public interface GameCharacter extends GameEntity 
{	
	
	public double getAccel();
	void setAccel(double accel);
	
	public int getExp();
	void setExp(int exp);
	
	public double getMaxSpeed();
	void setMaxSpeed(double maxSpeed);
	
	public int getStrength();
	void setStrength(int strength);
	
	public double getWeight();
	void setWeight(double weight);
	
	public int getHealth();
	void setHealth(int health);

    public ArrayList<GameBehavior> getBehaviors();
    void setBehaviors(ArrayList<GameBehavior> behaviors);

    public ArrayList<GameArtifact> getArtifacts();
    void setArtifacts(ArrayList<GameArtifact> artifacts);
    
	
	
	
	

}
