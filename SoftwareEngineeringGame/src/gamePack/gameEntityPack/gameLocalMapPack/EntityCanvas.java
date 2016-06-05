package gamePack.gameEntityPack.gameLocalMapPack;

import java.awt.Canvas;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import gamePack.gameStatePack.DefaultMapState;

public class EntityCanvas {




	int id;

	Boolean isEntityMoving = false;
	Integer EntityID = 0, entityInitX = 200, entityInitY = 600, entityCurX = entityInitX, entityCurY = entityInitY, entityMoveSleepMillis = 10, entityStepPixels = 2, entityVisibleRadius = 200, entityCollisionRadius = 20;

	public EntityCanvas(int id) {
		this.id = id;
	}

	final int knightStopped = 0, knightMoving = 1, knightAttacking = 2;
	final String knightStoppedPathStr = "image/knightStopped.gif", knightAttackingPathStr = "image/knightAttacking.gif",
			knightMovingPathStr = "image/knightMoving.gif";

	final int snakeStopped = 3, snakeMoving = 4, snakeAttacking = 5;
	final String snakeStoppedPathStr = "image/snake0.png", snakeAttackingPathStr = "image/snake1.png",
			snakeMovingPathStr = "image/snake2.png";

	final int dragonStopped = 6, dragonMoving0 = 7, dragonMoving1 = 8, dragonAttacking = 9;
	final String dragonStoppedPathStr = "image/dragon0.png", dragonAttackingPathStr = "image/dragon1.png",
			dragonMovingUpFlapPathStr = "image/dragon2.png", dragonMovingDownFlapPathStr = "image/dragon3.png";

	final int goblinStopped = 10, goblinMoving = 11, goblinAttacking = 12;
	final String goblinStoppedPathStr = "image/goblin0.png", goblinAttackingPathStr = "image/goblin1.png",
			goblinMovingPathStr = "image/goblin2.png";

	final ArrayList<Integer> entityStates = new ArrayList<>(Arrays.asList(knightStopped, knightMoving, knightAttacking,
			snakeStopped, snakeMoving, snakeAttacking, dragonStopped, dragonMoving0, dragonMoving1, dragonAttacking,
			goblinStopped, goblinMoving, goblinAttacking));

	final ArrayList<String> entityImgPaths = new ArrayList<>(Arrays.asList(knightStoppedPathStr, knightMovingPathStr,
			knightAttackingPathStr, snakeStoppedPathStr, snakeAttackingPathStr, snakeMovingPathStr,
			dragonStoppedPathStr, dragonAttackingPathStr, dragonMovingUpFlapPathStr, dragonMovingDownFlapPathStr,
			goblinStoppedPathStr, goblinAttackingPathStr, goblinMovingPathStr));

	int entityAngle = 0;
	Image[] entityImgs = new Image[entityImgPaths.size()];
	AffineTransform entityAffine;

	int entityState;
	boolean entityFrozen = true;

	void initEntity() {

		int i = 0;
		for (String path : entityImgPaths) {
			if (Files.exists(Paths.get(path), LinkOption.NOFOLLOW_LINKS)) {
				entityImgs[i] = Toolkit.getDefaultToolkit().createImage(path);
			} else {
				System.out.println(path + " was not found");
				System.exit(-1);
			}
			i++;
		}

		AffineTransform newAffine = new AffineTransform();
		int tx = this.getEntityCurX() - entityImgs[entityState].getWidth(null) / 2;
		int ty = this.getEntityCurY() - entityImgs[entityState].getHeight(null) / 2;
		newAffine.translate(tx, ty);
		double radians = 2.0 * Math.PI * (1.0 - (double) entityAngle / 360);
		newAffine.rotate(radians);
		setEntityAffine(newAffine);
	}

	void entityPaint() {
		MapCanvas.offGraphics.drawImage(entityImgs[entityState], getEntityAffine(), null);
	}




	synchronized void setSnakeState(int s) {
		while (entityFrozen)
			try {
				entityState = snakeStopped;
				MainWindow.mapCanvas.repaint();
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		entityState = s;
		AffineTransform newAffine = new AffineTransform();
		int tx = this.getEntityCurX() - entityImgs[entityState].getWidth(null) / 2;
		int ty = this.getEntityCurY() - entityImgs[entityState].getHeight(null) / 2;
		newAffine.translate(tx, ty);
		double radians = 2.0 * Math.PI * (1.0 - (double) entityAngle / 360);
		newAffine.rotate(radians);
		setEntityAffine(newAffine);
		notifyAll();
	}

	synchronized void setKnightState(int s) {
		while (entityFrozen)
			try {
				entityState = knightStopped;
				MainWindow.mapCanvas.repaint();
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		entityState = s;
		AffineTransform newAffine = new AffineTransform();
		int tx = this.getEntityCurX() - entityImgs[entityState].getWidth(null) / 2;
		int ty = this.getEntityCurY() - entityImgs[entityState].getHeight(null) / 2;
		newAffine.translate(tx, ty);
		double radians = 2.0 * Math.PI * (1.0 - (double) entityAngle / 360);
		newAffine.rotate(radians);
		setEntityAffine(newAffine);
		notifyAll();
	}

	synchronized void setDragonState(int s) {
		while (entityFrozen)
			try {
				entityState = dragonStopped;
				MainWindow.mapCanvas.repaint();
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		entityState = s;
		AffineTransform newAffine = new AffineTransform();
		int tx = this.getEntityCurX() - entityImgs[entityState].getWidth(null) / 2;
		int ty = this.getEntityCurY() - entityImgs[entityState].getHeight(null) / 2;
		newAffine.translate(tx, ty);
		double radians = 2.0 * Math.PI * (1.0 - (double) entityAngle / 360);
		newAffine.rotate(radians);
		setEntityAffine(newAffine);
		notifyAll();
	}

	synchronized void setGoblinState(int s) {
		while (entityFrozen)
			try {
				entityState = goblinStopped;
				MainWindow.mapCanvas.repaint();
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		entityState = s;
		AffineTransform newAffine = new AffineTransform();
		int tx = this.getEntityCurX() - entityImgs[entityState].getWidth(null) / 2;
		int ty = this.getEntityCurY() - entityImgs[entityState].getHeight(null) / 2;
		newAffine.translate(tx, ty);
		double radians = 2.0 * Math.PI * (1.0 - (double) entityAngle / 360);
		newAffine.rotate(radians);
		setEntityAffine(newAffine);
		notifyAll();
	}

	public synchronized void freezeEntity() {
		this.entityFrozen = true;
	}

	public synchronized void thawEntity() {
		entityFrozen = false;
		notifyAll();
	}

	synchronized AffineTransform getEntityAffine() {
		return this.entityAffine;
	}

	synchronized void setEntityAffine(AffineTransform entityAffine) {
		this.entityAffine = entityAffine;
	}








	//************************






	//	static Boolean isPlayer0_Moving = false;
	//	static Integer player0_ID = 0, 
	//			player0_InitX = 200, player0_InitY = 600,
	//			player0_CurX = player0_InitX, player0_CurY = player0_InitY,
	//			player0_MoveSleepMillis = 10, player0_StepPixels = 2, 
	//			player0_VisibleRadius = 200, player0_CollisionRadius = 20;
	//
	//
	//
	//
	//	static Boolean isSnake0_Moving = false;
	//	static Integer snake0_ID = 1,
	//			snake0_InitX = 200, snake0_InitY = 200,
	//			snake0_CurX = snake0_InitX, snake0_CurY = snake0_InitY,
	//			snake0_MoveSleepMillis = 30, snake0_StepPixels = 2,
	//			snake0_VisibleRadius = 200, snake0_CollisionRadius = 10;
	//
	//
	//
	//
	//	static Boolean isDragon0_Moving = false;
	//	static Integer dragon0_ID = 2, 
	//			dragon0_InitX = 500, dragon0_InitY = 500,
	//			dragon0_CurX = dragon0_InitX, dragon0_CurY = dragon0_InitY, 
	//			dragon0_MoveSleepMillis = 30,dragon0_StepPixels = 2,
	//			dragon0_VisibleRadius = 400, dragon0_CollisionRadius = 30;
	//
	//
	//	static Boolean isGoblin0_Moving = false;
	//	static Integer goblin0_ID = 3, goblin0_InitX = 100, goblin0_InitY = 100, 
	//			goblin0_CurX = goblin0_InitX, goblin0_CurY = goblin0_InitY,
	//			goblin0_MoveSleepMillis = 30, goblin0_StepPixels = 2,
	//			goblin0_VisibleRadius = 200, goblin0_CollisionRadius = 20;





	/*	private static ArrayList<Integer> entityID = new ArrayList<>(
			Arrays.asList(player0_ID, snake0_ID, dragon0_ID, goblin0_ID));
	private static ArrayList<Integer> entityCurX = new ArrayList<>(
			Arrays.asList(player0_CurX, snake0_CurX, dragon0_CurX, goblin0_CurX));
	private static ArrayList<Integer> entityCurY = new ArrayList<>(
			Arrays.asList(player0_CurY, snake0_CurY, dragon0_CurY, goblin0_CurY));
	private static ArrayList<Boolean> entityMoving = new ArrayList<>(
			Arrays.asList(isPlayer0_Moving, isSnake0_Moving, isDragon0_Moving, isGoblin0_Moving));
	private static ArrayList<Integer> entityStepPixels = new ArrayList<>(
			Arrays.asList(player0_StepPixels, snake0_StepPixels, dragon0_StepPixels, goblin0_StepPixels));
	private static ArrayList<Integer> entityMoveSleepMillis = new ArrayList<>(Arrays.asList(player0_MoveSleepMillis,
			snake0_MoveSleepMillis, dragon0_MoveSleepMillis, goblin0_MoveSleepMillis));
	private static ArrayList<Integer> entityVisibleRadius = new ArrayList<>(
			Arrays.asList(player0_VisibleRadius, snake0_VisibleRadius, dragon0_VisibleRadius, goblin0_VisibleRadius));
	private static ArrayList<Integer> entityCollisionRadius = new ArrayList<>(Arrays.asList(player0_CollisionRadius,
			snake0_CollisionRadius, dragon0_CollisionRadius, goblin0_CollisionRadius));*/



	void moveEntity(int x, int y) {
		EntityCanvas entity = this;
		final Thread mover = new Thread(new Runnable() {
			public void run() {
				setIsEntityMoving(true);
				int x0 = getEntityCurX();
				int y0 = entity.getEntityCurY();

				double dx = MainWindow.getXClicked() - x0;
				double dy = MainWindow.getYClicked() - y0;
				double ds = Math.sqrt(dx * dx + dy * dy);
				double m = dy / dx;
				double b = MainWindow.getYClicked() - m * MainWindow.getXClicked();
				int xr = (int) Math.round(x0 + entity.entityStepPixels * (dx / ds)),
						yr = (int) Math.round(y0 + entity.entityStepPixels * (dy / ds));
				while (ds > entity.entityStepPixels && !MainWindow.isGamePaused()) {
					entity.thawEntity();
					setEntityCurX(xr);
					setEntityCurY(yr);
					x0 = entity.getEntityCurX();
					y0 = entity.getEntityCurY();
					dx = MainWindow.getXClicked() - x0;
					dy = MainWindow.getYClicked() - y0;
					ds = Math.sqrt(dx * dx + dy * dy);
					m = dy / dx;
					b = MainWindow.getYClicked() - m * MainWindow.getXClicked();
					xr = (int) Math.round((x0 + entity.entityStepPixels * (dx / ds)));
					yr = (int) Math.round((y0 + entity.entityStepPixels * (dy / ds)));
					try {
						Thread.sleep(entity.entityMoveSleepMillis);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				entity.setIsEntityMoving(false);
				entity.freezeEntity();
			}
		});
		if (!entity.getIsEntityMoving() && !MainWindow.isGamePaused())
			mover.start();
	}



	void pursueEntity(EntityCanvas srcEntity, EntityCanvas dstEntity) {
		Thread pursuer = new Thread(new Runnable() {
			public void run() {
				while (!MainWindow.isGamePaused()) {
					if (distance(srcEntity.getEntityCurX(), srcEntity.getEntityCurY(), dstEntity.getEntityCurX(),
							dstEntity.getEntityCurY()) < srcEntity.entityVisibleRadius) {
						setIsEntityMoving(true);
						double ds;
						int x0 = srcEntity.getEntityCurX();
						int y0 = srcEntity.getEntityCurY();
						double dx = dstEntity.getEntityCurX() - x0;
						double dy = dstEntity.getEntityCurY() - y0;
						ds = Math.sqrt(dx * dx + dy * dy);
						double m = dy / dx;
						double b = dstEntity.getEntityCurY() - m * dstEntity.getEntityCurX();
						int xr = (int) Math.round(x0 + srcEntity.entityStepPixels * (dx / ds)),
								yr = (int) Math.round(y0 + srcEntity.entityStepPixels * (dy / ds));
						while (ds < srcEntity.entityVisibleRadius
								&& ds > (srcEntity.entityCollisionRadius + dstEntity.entityCollisionRadius)
								&& srcEntity.getIsEntityMoving() && !MainWindow.isGamePaused()) {
							srcEntity.thawEntity();
							setEntityCurX(xr);
							setEntityCurY(yr);
							x0 = srcEntity.getEntityCurX();
							y0 = srcEntity.getEntityCurY();
							dx = dstEntity.getEntityCurX() - x0;
							dy = dstEntity.getEntityCurY() - y0;
							ds = Math.sqrt(dx * dx + dy * dy);
							m = dy / dx;
							b = dstEntity.getEntityCurY() - m * dstEntity.getEntityCurX();
							xr = (int) Math.round((x0 + srcEntity.entityStepPixels * (dx / ds)));
							yr = (int) Math.round((y0 + srcEntity.entityStepPixels * (dy / ds)));
							try {
								Thread.sleep(srcEntity.entityMoveSleepMillis);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						if (ds <= (srcEntity.entityCollisionRadius + dstEntity.entityCollisionRadius)) {
							synchronized (srcEntity.isEntityMoving) {
								if (srcEntity.isEntityMoving == true)
									MainWindow.txtrTextarea_1.append("entity" + srcEntity.id + " engaged you.\n");
								srcEntity.setIsEntityMoving(false);
							}
							setEntityCurX(dstEntity.entityInitX);
							setEntityCurY(dstEntity.entityInitY);
							MainWindow.setGamePaused(true);



							MapCanvas.mapState = MapCanvas.gameMap;

							MainWindow.btnPause.getAction().putValue("NAME", "PLAY");
							MainWindow.btnPause.getAction().putValue("SHORT_DESCRIPTION", "PLAY GAME");
							MainWindow.btnPause.setText("PLAY");
							DefaultMapState.setMapIsVisible(false);
						}
						srcEntity.setIsEntityMoving(false);
						srcEntity.freezeEntity();
					}
				}
			}
		});
		if (!getIsEntityMoving() && !MainWindow.isGamePaused())
			pursuer.start();
	}

	private Boolean getIsEntityMoving() {
		synchronized (isEntityMoving) {
			return isEntityMoving;
		}
	}

	private void setIsEntityMoving(Boolean isEntityMoving) {
		synchronized (this.isEntityMoving) {
			this.isEntityMoving =isEntityMoving;
		}
	}

	Integer getEntityCurX() {
		synchronized (entityCurX) {
			return entityCurX;
		}
	}

	void setEntityCurX(int curX) {
		synchronized (entityCurX) {
			entityCurX = curX;
		}
	}

	Integer getEntityCurY() {
		synchronized (entityCurY) {
			return entityCurY;
		}
	}

	void setEntityCurY(int curY) {
		synchronized (entityCurY) {
			entityCurY = curY;
		}
	}

	protected int distance(int enemyCurX, int enemyCurY, int playerCurX, int playerCurY) {
		return (int) Math.sqrt(Math.pow(playerCurX - enemyCurX, 2) + Math.pow(playerCurY - enemyCurY, 2));
	}


	
	
	
	//*******************************	KNIGHT





	static Thread makeKnight(EntityCanvas entity) {
		return new Thread(new Runnable() {
			public void run() {
				entity.setIsEntityMoving(false);
				entity.entityInitX = 200;
				entity.entityInitY = 600;
				entity.setEntityCurX(entity.entityInitX);
				entity.setEntityCurY(entity.entityInitY);
				entity.entityMoveSleepMillis = 10;
				entity.entityStepPixels = 2;
				entity.entityVisibleRadius = 200;
				entity.entityCollisionRadius = 20;

				while (true) {
					//if(entity!=null)
					try {
						// mapCanvas.entities.get(id).setKnightState(0);
						// mapCanvas.repaint();
						// Thread.sleep(100);

						entity.setKnightState(1);
						MainWindow.mapCanvas.repaint();
						Thread.sleep(100);

						entity.setKnightState(2);
						MainWindow.mapCanvas.repaint();
						Thread.sleep(100);
					} catch (java.lang.InterruptedException e) {
					}
				}
			}
		});
	}

	static Thread makeSnake(EntityCanvas entity) {
		return new Thread(new Runnable() {
			public void run() {
				entity.setIsEntityMoving(false);
				entity.entityInitX = 200;
				entity.entityInitY = 200;
				entity.setEntityCurX(entity.entityInitX);
				entity.setEntityCurY(entity.entityInitY);
				entity.entityMoveSleepMillis = 30;
				entity.entityStepPixels = 2;
				entity.entityVisibleRadius = 200;
				entity.entityCollisionRadius = 10;
				
				while (true) {
					try {
						// mapCanvas.entities.get(id).setSnakeState(3);
						// mapCanvas.repaint();
						// Thread.sleep(100);

						entity.setSnakeState(4);
						MainWindow.mapCanvas.repaint();
						Thread.sleep(100);

						entity.setSnakeState(5);
						MainWindow.mapCanvas.repaint();
						Thread.sleep(100);
					} catch (java.lang.InterruptedException e) {
					}
				}
			}
		});
	}

	
	static Thread makeDragon(EntityCanvas entity) {
		return new Thread(new Runnable() {
			public void run() {
				entity.setIsEntityMoving(false);
				entity.entityInitX = 500;
				entity.entityInitY = 500;
				entity.setEntityCurX(entity.entityInitX);
				entity.setEntityCurY(entity.entityInitY);
				entity.entityMoveSleepMillis = 30;
				entity.entityStepPixels = 2;
				entity.entityVisibleRadius = 400;
				entity.entityCollisionRadius = 30;
				
				while (true) {
					try {
						// mapCanvas.entities.get(id).setDragonState(6);
						// mapCanvas.repaint();
						// Thread.sleep(100);

						entity.setDragonState(7);
						MainWindow.mapCanvas.repaint();
						Thread.sleep(100);

						entity.setDragonState(8);
						MainWindow.mapCanvas.repaint();
						Thread.sleep(100);

						entity.setDragonState(9);
						MainWindow.mapCanvas.repaint();
						Thread.sleep(100);

					} catch (java.lang.InterruptedException e) {
					}
				}
			}
		});
	}

	static Thread makeGoblin(EntityCanvas entity) {
		return new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						// mapCanvas.entities.get(id).setGoblinState(10);
						// mapCanvas.repaint();
						// Thread.sleep(100);

						entity.setGoblinState(11);
						MainWindow.mapCanvas.repaint();
						Thread.sleep(100);

						entity.setGoblinState(12);
						MainWindow.mapCanvas.repaint();
						Thread.sleep(100);
					} catch (java.lang.InterruptedException e) {
					}
				}
			}
		});
	}


}
