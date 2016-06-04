package gamePack.gameEntityPack.gameArtifactPack;

import java.util.Random;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;

public class DefensePotion implements GameArtifact
{
	private int numUses;
	private String name;
	
	public DefensePotion(int n, String name)
	{
		this.numUses = n;
		this.name = name;
	}//end StrengthPotion
	
	@Override
	public void use(ConcreteCharacter c)
	{
		if(this.numUses > 0)
		{
			Random r = new Random();
			int high = 10;
			int low = 1;
			
			//return r.nextInt(high - low) + low;
		}//end if
		
		else
		{
			MainWindow.updateTextArea("Potion is empty!\n");
			//return 0;
		}//end else
	}//end use

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
	public void restore()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(GameEntity o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
