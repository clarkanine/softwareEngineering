package gamePack.gameEntityPack.gameLocalMapPack;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

//Class that defines what happens (i.e: the color changes) when a panel is clicked
public class BoxListener extends MouseAdapter
{
	//static int [][] clicks = new int[100][42];
	private static Integer playerClickX;
	private static Integer playerClickY;
	//public static Integer playerCurX = 0, playerCurY = 0;
	//public static Integer enemyCurX = 0, enemyCurY = 0;
	private static boolean clicked = false;
	private static boolean inPursuit = false;
	private static JPanel clickedBox; 

	public synchronized static int getPlayerClickX() {
			return BoxListener.playerClickX;
	}


	public synchronized static void setPlayerClickX(int playerClickX) {
			BoxListener.playerClickX = playerClickX;
	}



	public synchronized static int getPlayerClickY() {
			return BoxListener.playerClickY;
	}


	public synchronized static void setPlayerClickY(int playerClickY) {
			BoxListener.playerClickY = playerClickY;
	}


	private synchronized static boolean isClicked() {
		return clicked;
	}


	private synchronized static void setClicked(boolean clicked) {
		BoxListener.clicked = clicked;
	}


	private synchronized static boolean isInPursuit() {
		return inPursuit;
	}


	private synchronized static void setInPursuit(boolean inPursuit) {
		BoxListener.inPursuit = inPursuit;
	}


	private synchronized static JPanel getClickedBox() {
		return clickedBox;
	}


	private synchronized static void setClickedBox(JPanel clickedBox) {
		BoxListener.clickedBox = clickedBox;
	}


	public void mousePressed(MouseEvent me)
	{
		setClickedBox((JPanel)me.getSource());
		setClicked(true);
		/*
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 */


		//int id = Integer.parseInt(clickedBox.getName());
		//playerClickX = id%100;
		//playerClickY = id/100;
		setPlayerClickX(getClickedBox().getX());
		setPlayerClickY(getClickedBox().getY());
		movePlayer();
		//clickedBox.getParent().getParent().getComponent(0).setLocation(playerClickX, playerClickY);



	}


	public void movePlayer() {
		new Thread(new Runnable() {
			public void run() {
				JTextArea textArea_player = (JTextArea) getClickedBox().getParent().getParent().getComponent(0);
				//playerCurX = textArea_player.getX();
				//playerCurY = textArea_player.getY();
				double dx = getClickedBox().getX()-textArea_player.getX(), dy = getClickedBox().getY()-textArea_player.getY();
				int ds = (int)Math.ceil(Math.sqrt(dx*dx+dy*dy));

				while(ds > 0 && isClicked()) {
					dx = getClickedBox().getX()-textArea_player.getX();
					dy = getClickedBox().getY()-textArea_player.getY();
					ds = (int)Math.ceil(Math.sqrt(dx*dx+dy*dy));
					textArea_player.setLocation((int) (textArea_player.getX() + dx/10), (int) (textArea_player.getY() + dy/10));
					ArrayList<JPanel> nearbyBoxs = getNearbyBoxes(textArea_player.getX(), textArea_player.getY(), 100);
					for(JPanel box: nearbyBoxs) {
						if(box.isOpaque())
							box.setOpaque(false);
					}

					ArrayList<JTextArea> nearbyEnemies = getNearbyEnemies(textArea_player.getX(), textArea_player.getY(), 150);
					for(JTextArea textArea_enemy: nearbyEnemies) {
						setInPursuit(true);
						pursuePlayer(textArea_enemy, 200);
					}
					getClickedBox().getParent().getParent().repaint();
					getClickedBox().getParent().getParent().getParent().repaint();
					textArea_player.repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}


				setClicked(false);
				getClickedBox().getParent().getParent().repaint();
				getClickedBox().getParent().getParent().getParent().repaint();
				textArea_player.repaint();
			}
		}).start();
	}

	public void pursuePlayer(JTextArea textArea_enemy, int radius) {
		new Thread(new Runnable() {
			public void run() {
				JTextArea textArea_player = (JTextArea) getClickedBox().getParent().getParent().getComponent(0);
				//JTextArea textArea_enemy = (JTextArea) clickedBox.getParent().getParent().getComponent(1);
				//				playerCurX = textArea_player.getX();
				//				playerCurY = textArea_player.getY();
				//				enemyCurX = textArea_enemy.getX();
				//				enemyCurY = textArea_enemy.getY();
				double dx = textArea_player.getX()-textArea_enemy.getX(), dy = textArea_player.getY()-textArea_enemy.getY();
				int ds = (int)Math.ceil(Math.sqrt(dx*dx+dy*dy));

				while(ds > 0 && ds < radius && isInPursuit()) {

					dx = textArea_player.getX()-textArea_enemy.getX();
					dy = textArea_player.getY()-textArea_enemy.getY();
					ds = (int)Math.ceil(Math.sqrt(dx*dx+dy*dy));
					textArea_enemy.setLocation((int) (textArea_enemy.getX() + dx/30), (int) (textArea_enemy.getY() + dy/30));
					textArea_player.repaint();
					textArea_enemy.repaint();
					if(ds < 50 && isInPursuit()) {
						MainWindow.updateTextArea(textArea_enemy.getName()+ " got you!\n");
						System.exit(-1);
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				setInPursuit(false);
				textArea_player.repaint();
				textArea_enemy.repaint();
			}
		}).start();
	}

	ArrayList<JPanel> getNearbyBoxes(int refX, int refY, int radius) {
		ArrayList<JPanel> nearbyBoxs = new ArrayList<>();
		for(Component c: getClickedBox().getParent().getComponents()) {
			double dx = c.getX()-refX, dy = c.getY()-refY;
			double ds = Math.ceil(Math.sqrt(dx*dx+dy*dy));
			if(ds < radius) {
				nearbyBoxs.add((JPanel) c);
			}
		}
		return nearbyBoxs;
	}

	private ArrayList<JTextArea> getNearbyEnemies(int refX, int refY, int radius) {
		ArrayList<JTextArea> nearbyEnemies = new ArrayList<>();
		for(Component c: getClickedBox().getParent().getParent().getComponents()) {
			double dx = c.getX()-refX, dy = c.getY()-refY;
			double ds = Math.ceil(Math.sqrt(dx*dx+dy*dy));
			if(ds < radius && c.getName()!=null && c.getName().contains("enemy")) {
				nearbyEnemies.add((JTextArea) c);
			}
		}
		return nearbyEnemies;
	}

	/*
	public void mouseEntered(MouseEvent me)
	{
		JPanel clickedBox =(JPanel)me.getSource();
		ArrayList<JPanel> nearbyBoxs = getNearbyBoxes(clickedBox, 100);
		for(JPanel box: nearbyBoxs) {
			if(box.isOpaque())
				box.setOpaque(false);
		}
		clickedBox.getParent().getParent().repaint();
	}

	public void mouseExited(MouseEvent me)
	{
		JPanel clickedBox =(JPanel)me.getSource();
		ArrayList<JPanel> nearbyBoxs = getNearbyBoxes(clickedBox, 50);
		for(JPanel box: nearbyBoxs) {
			if(! box.isOpaque())
				box.setOpaque(true);
		}
		clickedBox.getParent().getParent().repaint();
	}
	 */
}





/*
package clickableGrid;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

//Class that defines what happens (i.e: the color changes) when a panel is clicked
public class BoxListener extends MouseAdapter
{
	//static int [][] clicks = new int[100][42];
	public static int playerClickX, playerClickY;
	public static int playerCurX = 0, playerCurY = 0;
	public static int enemyCurX = 0, enemyCurY = 0;
	private static boolean clicked = false;
	private static boolean inPursuit = false;
	private static JPanel clickedBox; 

	public void mousePressed(MouseEvent me)
	{
		clickedBox =(JPanel)me.getSource();
		clicked = true;



		//int id = Integer.parseInt(clickedBox.getName());
		//playerClickX = id%100;
		//playerClickY = id/100;
		playerClickX = clickedBox.getX();
		playerClickY = clickedBox.getY();
		movePlayer();
		//clickedBox.getParent().getParent().getComponent(0).setLocation(playerClickX, playerClickY);



	}


	public void movePlayer() {
		new Thread(new Runnable() {
			public void run() {
				JTextArea textArea_player = (JTextArea) clickedBox.getParent().getParent().getComponent(0);
				//playerCurX = textArea_player.getX();
				//playerCurY = textArea_player.getY();
				double dx = clickedBox.getX()-textArea_player.getX(), dy = clickedBox.getY()-textArea_player.getY();
				int ds = (int)Math.ceil(Math.sqrt(dx*dx+dy*dy));

				while(ds > 0 && clicked) {
					dx = clickedBox.getX()-textArea_player.getX();
					dy = clickedBox.getY()-textArea_player.getY();
					ds = (int)Math.ceil(Math.sqrt(dx*dx+dy*dy));
					textArea_player.setLocation((int) (textArea_player.getX() + dx/10), (int) (textArea_player.getY() + dy/10));
					ArrayList<JPanel> nearbyBoxs = getNearbyBoxes(textArea_player.getX(), textArea_player.getY(), 100);
					for(JPanel box: nearbyBoxs) {
						if(box.isOpaque())
							box.setOpaque(false);
					}
					
					ArrayList<JTextArea> nearbyEnemies = getNearbyEnemies(textArea_player.getX(), textArea_player.getY(), 100);
					for(JTextArea textArea_enemy: nearbyEnemies) {
							inPursuit = true;
							pursuePlayer(textArea_enemy, 200);
					}
					clickedBox.getParent().getParent().repaint();
					clickedBox.getParent().getParent().getParent().repaint();
					textArea_player.repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
				clicked = false;
				clickedBox.getParent().getParent().repaint();
				clickedBox.getParent().getParent().getParent().repaint();
				textArea_player.repaint();
			}
		}).start();
	}
	
	public synchronized void pursuePlayer(JTextArea textArea_enemy, int radius) {
		new Thread(new Runnable() {
			public void run() {
				JTextArea textArea_player = (JTextArea) clickedBox.getParent().getParent().getComponent(0);
				//JTextArea textArea_enemy = (JTextArea) clickedBox.getParent().getParent().getComponent(1);
//				playerCurX = textArea_player.getX();
//				playerCurY = textArea_player.getY();
//				enemyCurX = textArea_enemy.getX();
//				enemyCurY = textArea_enemy.getY();
				double dx = textArea_player.getX()-textArea_enemy.getX(), dy = textArea_player.getY()-textArea_enemy.getY();
				int ds = (int)Math.ceil(Math.sqrt(dx*dx+dy*dy));

				while(ds > 0 && ds < radius && inPursuit) {
					
					dx = textArea_player.getX()-textArea_enemy.getX();
					dy = textArea_player.getY()-textArea_enemy.getY();
					ds = (int)Math.ceil(Math.sqrt(dx*dx+dy*dy));
					textArea_enemy.setLocation((int) (textArea_enemy.getX() + dx/20), (int) (textArea_enemy.getY() + dy/20));
					textArea_player.repaint();
					textArea_enemy.repaint();
					if(ds < 50 && inPursuit) {
						System.out.println(textArea_enemy.getName()+ " got you!");
						System.exit(-1);
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				inPursuit = false;
				textArea_player.repaint();
				textArea_enemy.repaint();
			}
		}).start();
	}

	private ArrayList<JPanel> getNearbyBoxes(int refX, int refY, int radius) {
		ArrayList<JPanel> nearbyBoxs = new ArrayList<>();
		for(Component c: clickedBox.getParent().getComponents()) {
			double dx = c.getX()-refX, dy = c.getY()-refY;
			double ds = Math.ceil(Math.sqrt(dx*dx+dy*dy));
			if(ds < radius) {
				nearbyBoxs.add((JPanel) c);
			}
		}
		return nearbyBoxs;
	}
	
	private ArrayList<JTextArea> getNearbyEnemies(int refX, int refY, int radius) {
		ArrayList<JTextArea> nearbyEnemies = new ArrayList<>();
		for(Component c: clickedBox.getParent().getParent().getComponents()) {
			double dx = c.getX()-refX, dy = c.getY()-refY;
			double ds = Math.ceil(Math.sqrt(dx*dx+dy*dy));
			if(ds < radius && c.getName()!=null && c.getName().contains("enemy")) {
				nearbyEnemies.add((JTextArea) c);
			}
		}
		return nearbyEnemies;
	}
	

}

*/