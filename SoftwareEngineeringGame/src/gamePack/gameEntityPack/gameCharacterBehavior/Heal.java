package gamePack.gameEntityPack.gameCharacterBehavior;

import java.util.ArrayList;
import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameStatePack.gameCombatState.CombatShenanigans;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;
import gamePack.gameStatePack.gameTextStatePack.TextInputState;

public class Heal implements Special {
	private CombatShenanigans theCombat;
	private int healPoints = 100;

	public Heal(GameCharacter actor, ArrayList<GameCharacter> enemies2) {
	}

	public void useSpecial(ConcreteCharacter me, ConcreteCharacter you) {
		me.setHealth(me.getHealth() + healPoints);

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "heal power";
	}

	@Override
	public void run(GameCharacter me) {
		for (GameCharacter c : me.getTargets())
			c.setHealth(c.getHealth() + healPoints);
		;

		theCombat.printStatus();

	}

	@Override
	public void setCombat(CombatShenanigans theCombat) {
		this.theCombat = theCombat;

	}

	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes) {
		int i = 1;
		int choice;

		ArrayList<GameCharacter> everyone = new ArrayList<>();
		ArrayList<GameCharacter> target = new ArrayList<>();

		everyone.addAll(friends);
		everyone.addAll(foes);

		for (GameCharacter c : everyone) {
			MainWindow.updateTextArea(i + ". " + c.getName() + "\n");
		}

		choice = TextInputState.readInt();

		// Scanner in = new Scanner(System.in);
		// choice = in.nextInt();
		// in.close();

		// choice = ConcreteCharacter.user.nextInt();
		target.add(everyone.get(choice - 1));
	}

}
