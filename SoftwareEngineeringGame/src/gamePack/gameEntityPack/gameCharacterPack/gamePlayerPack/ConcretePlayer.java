package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;

import java.util.ArrayList;
import java.util.Scanner;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameArtifactPack.NullArtifact;
import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCombatState.CombatState;
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;
import gamePack.gameEntityPack.gameWeaponPack.GameWeapon;
import gamePack.gameStatePack.ConcreteGameTextInputState;

public class ConcretePlayer extends ConcreteCharacter implements GamePlayer
{
	public GameWeapon getWeaponChoice()
	{
		int choice;
		int i = 1;
		MainWindow.updateTextArea("Pick your weapon:"+ "\n");
		
		for(GameWeapon w : this.getWeapons())
			MainWindow.updateTextArea(i++ + ". " + w.getName()+ "\n");
		
		choice = ConcreteGameTextInputState.readInt();
		
		/*Scanner in = new Scanner(System.in);
		choice = in.nextInt();
		in.close();*/
		
		//choice = user.nextInt();
		
		return this.getWeapons().get(choice - 1);
	}
	
	public void getCombatChoice()
	{
		int choice, i = 1;
		MainWindow.updateTextArea(this.getName() + " combat choice:"+ "\n");
		
		for(CombatState combatState : this.getCombatStates())
		{
			MainWindow.updateTextArea(i++ + ". " + combatState.getName() + "\n");
		}
		
		choice = ConcreteGameTextInputState.readInt();
		
		/*Scanner in = new Scanner(System.in);
		choice = in.nextInt();
		in.close();*/
		
		//choice = user.nextInt();
		this.setState( this.getCombatStates().get(choice - 1) );
	}
	
	public GameArtifact chooseItem()
	{
		int i = 1;
		int choice;
		
		for(GameArtifact item : this.getItems())
			MainWindow.updateTextArea(i++ + ". " + item.getName()+ "\n");
		
		choice = ConcreteGameTextInputState.readInt();
		
		/*Scanner in = new Scanner(System.in);
		choice = in.nextInt();
		in.close();*/
		
		//choice = user.nextInt();
		
		if(choice < 1 || choice > this.getItems().size() + 1)
			return new NullArtifact();

		return this.getItems().get(choice - 1);
	}

	@Override
	public int compareTo(GameEntity o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getProfileInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProfileInfo(String info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getStats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStats(String stats) {
		// TODO Auto-generated method stub
		
	}




}