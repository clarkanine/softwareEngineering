package gamePack.gameStatePack;



public interface GameTextInputState extends GameState {
	String readWord();
	String readLine();
	int readInt();
	char readChar();
	void openMenu();
	void closeMenu();
	//etc

}
