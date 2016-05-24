
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;
import gamePack.gameStatePack.GameStateContext;


public class DemoClient {
	public static void main(String[] args) {       

				GameStateContext gameStateContext = new GameStateContext();
				MainWindow.updateTextArea("DemoClient\n");
				gameStateContext.run();

	}
}