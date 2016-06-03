package gamePack.gameEntityPack.gameArtifactPack;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;

public interface GameArtifact extends GameEntity 
{
	public void use(ConcreteCharacter character);
	public void restore();
}
