package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameArtifactPack.NullArtifact;
import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCombatState.CombatState;
import gamePack.gameEntityPack.gameWeaponPack.GameWeapon;

public class ConcretePlayer extends ConcreteCharacter
{
	public GameWeapon getWeaponChoice()
	{
		int choice;
		int i = 1;
		System.out.println("Pick your weapon:");
		
		for(GameWeapon w : this.getWeapons())
			System.out.println(i++ + ". " + w.getName());
		choice = user.nextInt();
		
		return this.getWeapons().get(choice - 1);
	}
	
	public void getCombatChoice()
	{
		int choice, i = 1;
		System.out.println(this.getName() + " combat choice:");
		
		for(CombatState combatState : this.getCombatStates())
		{
			System.out.println(i++ + ". " + combatState.getName() );
		}
		
		choice = user.nextInt();
		this.setState( this.getCombatStates().get(choice - 1) );
	}
	
	public GameArtifact chooseItem()
	{
		int i = 1;
		int choice;
		
		for(GameArtifact item : this.getItems())
			System.out.println(i++ + ". " + item.getName());
		
		choice = user.nextInt();
		
		if(choice < 1 || choice > this.getItems().size() + 1)
			return new NullArtifact();

		return this.getItems().get(choice - 1);
	}




}