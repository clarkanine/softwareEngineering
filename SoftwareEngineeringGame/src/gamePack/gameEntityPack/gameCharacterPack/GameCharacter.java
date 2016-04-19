package gamePack.gameEntityPack.gameCharacterPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameBehaviorPack.GameBehavior;

public interface GameCharacter extends GameEntity {
	
	public double getAccel();
	void setAccel(double accel);
	
	public double getMaxSpeed();
	void setMaxSpeed(double maxSpeed);
	
	public double getStrength();
	void setStrength(double strength);
	
	public double getWeight();
	void setWeight();
	
	public double getHealth();
	void setHealth(double health);

    public ArrayList<GameBehavior> getBehaviors();
    void setBehaviors(ArrayList<GameBehavior> behaviors);

    public ArrayList<GameArtifact> getArtifacts();
    void setArtifacts(ArrayList<GameArtifact> artifacts);
	
	
	
	

}
