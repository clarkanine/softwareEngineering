
import gamePack.gameEntityPack.gameLocalMapPack.DefaultWindow;
import gamePack.gameStatePack.GameStateContext;


public class DemoClient {
	public static void main(String[] args) {       

				GameStateContext gameStateContext = new GameStateContext();
				DefaultWindow.updateTextArea("DemoClient\n");
				gameStateContext.run();

	}
}