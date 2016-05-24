package characterPack;

public interface GameCharacter
{
	public String getName();
	public void setName(String name);
	public void attack(ConcreteCharacter you);
	public void defend();
	
}
