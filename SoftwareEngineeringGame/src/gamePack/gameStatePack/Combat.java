package gamePack.gameStatePack;

import java.util.ArrayList;
import java.util.Scanner;

import gamePack.gameEntityPack.gameArtifactPack.Potion;
import gamePack.gameEntityPack.gameCharacterBehavior.Heal;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gameEnemyPack.Snake;
import gamePack.gameEntityPack.gameCharacterPack.gameEnemyPack.TrollEnemy;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.KnightPlayer;
import gamePack.gameEntityPack.gameCombatState.AllTargetCombat;
import gamePack.gameEntityPack.gameCombatState.BattleWonState;
import gamePack.gameEntityPack.gameCombatState.ChangeWeapon;
import gamePack.gameEntityPack.gameCombatState.CombatState;
import gamePack.gameEntityPack.gameCombatState.InitialCombatState;
import gamePack.gameEntityPack.gameCombatState.SingleTargetCombat;
import gamePack.gameEntityPack.gameCombatState.UseItemState;
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;
import gamePack.gameEntityPack.gameWeaponPack.BattleAxe;
import gamePack.gameEntityPack.gameWeaponPack.BigStick;
import gamePack.gameEntityPack.gameWeaponPack.GreatHammer;
import gamePack.gameEntityPack.gameWeaponPack.WeaponOfTheGods;

public class Combat
{
	public static void main(String[] args)
	{
		int numAliveEnemies;
		GameCharacter current;
		ArrayList<GameCharacter> enemies, players, everyone;
		//Scanner user = new Scanner(System.in);
		String again = "y";
		CombatShenanigans theCombat;

		
		while( again.compareTo("y") == 0 )
		{
			players = new ArrayList<>();
			players.add(new KnightPlayer() );
			players.add(new KnightPlayer() );
			players.add(new KnightPlayer() );
			players.get(0).setSpeed(1001);
			
			enemies = new ArrayList<>();
			
			enemies.add( new TrollEnemy() );
			enemies.add( new TrollEnemy() );
			enemies.add( new Snake() );
			
			enemies.get(0).setSpeed(1000);
			
			numAliveEnemies = enemies.size();
		

			//player.addCombatState(new SingleTargetCombat(player, enemies));
			//player.addCombatState(new AllTargetCombat(player, enemies));
			//player.addCombatState(new ChangeWeapon(player, enemies));
			//player.addCombatState(new Heal(player, enemies));
			//player.addCombatState(new UseItemState(player, enemies) );
			

			
			theCombat = new CombatShenanigans(players, enemies);
			
			
			theCombat.run();
			MainWindow.updateTextArea("===============================\n");
			
			MainWindow.updateTextArea("Play again? (y/n): \n");
			again = ConcreteGameTextInputState.readLine();
			//again = user.next();
		}
			
		//user.close();
	}
	
}
