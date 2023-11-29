package ilkebeliz.space.utils;

import java.util.ArrayList;
import java.util.Random;

import ilkebeliz.space.Reference;
import ilkebeliz.space.elements.Alien;
import ilkebeliz.space.elements.AlienShip;
import ilkebeliz.space.elements.Barrier;
import ilkebeliz.space.elements.Barrier1;
import ilkebeliz.space.elements.Barrier2;
import ilkebeliz.space.elements.Player;
import ilkebeliz.space.elements.Shoot;
import ilkebeliz.space.gui.GameBoard;

public class GameTasks {

	private static int alienTimeDelay = 0;
	private static int playerTimeDelay = 0;
	
	public static void changeDelays() {
		alienTimeDelay++;
		playerTimeDelay++;
	}
	
	public static int getAlienDelay() {return alienTimeDelay;}
	public static int getPlayerDelay() {return playerTimeDelay;}
	public static void resetPlayerDelay() {playerTimeDelay=0;}
	
	public static void initAliens() {
		Reference.aliens = new Alien[Reference.alienColumns][Reference.alienRows];
		for(int i=0; i<Reference.alienColumns; i++) {
			for(int j=0; j<Reference.alienRows; j++) {
				Reference.aliens[i][j] = new Alien(300+i*45, 70+j*45);
			}
		}
		alienTimeDelay = 0;
	}
	public static void initAliens1() {
		Reference.aliens1 = new Alien[Reference.alienColumns1][Reference.alienRows1];
		for(int i=0; i<Reference.alienColumns1; i++) {
			for(int j=0; j<Reference.alienRows1; j++) {
				Reference.aliens1[i][j] = new Alien(200+i*45, 70+j*45);
			}
		}
		alienTimeDelay = 0;
	}
	
	public static void moveAllAliens() {
		if(alienTimeDelay==Alien.getMotionDelay()) {
			moveAllAliensSideways();
			alienTimeDelay=0;
		}
		
				if(Reference.aliens[0][0].getDir()>0) {
					Reference.aliens[Reference.alienColumns-1][Reference.alienRows-1].checkDir();		
				}
				else {
					Reference.aliens[0][0].checkDir();	
				}
	}
	
	public static void moveAllAliens1() {
			if(alienTimeDelay==Alien.getMotionDelay1()) {
				moveAllAliensSideways1();
				alienTimeDelay=0;
			}if(Reference.aliens1[0][0].getDir()>0) {
				Reference.aliens1[Reference.alienColumns1-1][Reference.alienRows1-1].checkDir();		
			}
			else {
				Reference.aliens1[0][0].checkDir();	
			}
		}
	private static void moveAllAliensSideways() {
		for(int i=0; i<Reference.alienColumns; i++) {
			for(int j=0; j<Reference.alienRows; j++) {
					Reference.aliens[i][j].moveSideways();
			}
		}
		
	}
	private static void moveAllAliensSideways1() {
		for(int i=0; i<Reference.alienColumns1; i++) {
			for(int j=0; j<Reference.alienRows1; j++) {
					Reference.aliens1[i][j].moveSideways1();
			}
		}
		
	}
	
	public static void moveShoots() {
		for(int i=0; i<Reference.shoots.size(); i++) {
			Reference.shoots.get(i).move();
			
			if(Reference.shoots.get(i).getPosY()<0 || Reference.shoots.get(i).getPosY()>Reference.windowHeight-80) {
				Reference.shoots.remove(i);
			}
		}
	}
	
	public static void alienShoot() {
		Random rand = new Random();
		int col = rand.nextInt(Reference.alienColumns*5);
		int row = rand.nextInt(Reference.alienRows*5);
		
		if(col>=Reference.alienColumns || row>=Reference.alienRows) return;
		if(Reference.aliens[col][row].isDead()) return;
		
		if(row == 4) {
			Reference.shoots.add(new Shoot(Reference.aliens[col][row].getPosX()+15, Reference.aliens[col][row].getPosY()+25, 4));
			return;
		}
		
		if(Reference.aliens[col][row+1].isDead()) {
			Reference.shoots.add(new Shoot(Reference.aliens[col][row].getPosX()+15, Reference.aliens[col][row].getPosY()+25, 4));
		}
	}
	public static void alienShoot1() {
		Random rand = new Random();
		int col = rand.nextInt(Reference.alienColumns1*3);
		int row = rand.nextInt(Reference.alienRows1*3);
		
		if(col>=Reference.alienColumns1 || row>=Reference.alienRows1) return;
		if(Reference.aliens1[col][row].isDead()) return;
		
		if(row == 5) {
			Reference.shoots.add(new Shoot(Reference.aliens1[col][row].getPosX()+15, Reference.aliens1[col][row].getPosY()+25, 4));
			return;
		}
		
		if(Reference.aliens1[col][row+1].isDead()) {
			Reference.shoots.add(new Shoot(Reference.aliens1[col][row].getPosX()+15, Reference.aliens1[col][row].getPosY()+25, 4));
		}
	}
	
	public static boolean checkCollisionAlienShoot() {
		for(int i=0; i<Reference.alienColumns; i++) {
			for(int j=0; j<Reference.alienRows; j++) {
				for(int k=0; k<Reference.shoots.size(); k++) {
					
					if(Reference.shoots.get(k).getBoundingBox().intersects(Reference.aliens[i][j].getBoundingBox()) && !Reference.aliens[i][j].isDead()) {
						
						Reference.aliens[i][j].setDead(true);
						Reference.shoots.remove(k);
						
						switch(Reference.map.getAlienType(i, j)) {
						case 0:
							GameBoard.addScore(10); break;
						case 1:
							GameBoard.addScore(20); break;
						case 2:
							GameBoard.addScore(30); break;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean checkCollisionAlienShoot1() {
		for(int i=0; i<Reference.alienColumns1; i++) {
			for(int j=0; j<Reference.alienRows1; j++) {
				for(int k=0; k<Reference.shoots.size(); k++) {
					
					if(Reference.shoots.get(k).getBoundingBox().intersects(Reference.aliens1[i][j].getBoundingBox()) && !Reference.aliens1[i][j].isDead()) {
						
						Reference.aliens1[i][j].setDead(true);
						Reference.shoots.remove(k);
						
						switch(Reference.map1.getAlienType1(i, j)) {
						case 0:
							GameBoard.addScore(10); break;
						case 1:
							GameBoard.addScore(20); break;
						case 2:
							GameBoard.addScore(30); break;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean checkCollisionPlayerShoot() {
		for(int i=0; i<Reference.shoots.size(); i++) {
			if(Reference.shoots.get(i).getBoundingBox().intersects(Reference.player.getBoundingBox())) {
				Reference.shoots.remove(i);
				Reference.player.takeLife();
				return true;
			}
		}
		return false;
	}
	public static boolean checkCollisionPlayerShoot1() {
		for(int i=0; i<Reference.shoots.size(); i++) {
			if(Reference.shoots.get(i).getBoundingBox().intersects(Reference.player.getBoundingBox())) {
				Reference.shoots.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static void checkCollisionShieldShoot() {
		for(int i=0; i<Reference.barriers.length; i++) {
			for(int j=0; j<Reference.shoots.size(); j++) {
				if(Reference.shoots.get(j).getBoundingBox().intersects(Reference.barriers[i].getBoundingBox()) && Reference.barriers[i].getDamage()>0) {
					Reference.barriers[i].damage();
					Reference.shoots.remove(j);
				}
			}
		}
	}
	public static void checkCollisionShieldShoot1() {
		for(int i=0; i<Reference.barriers1.length; i++) {
			for(int j=0; j<Reference.shoots.size(); j++) {
				if(Reference.shoots.get(j).getBoundingBox().intersects(Reference.barriers1[i].getBoundingBox()) && Reference.barriers1[i].getDamage()>0) {
					Reference.barriers1[i].damage();
					Reference.shoots.remove(j);
				}
			}
		}
	}
	public static void checkCollisionShieldShoot2() {
		for(int i=0; i<Reference.barriers2.length; i++) {
			for(int j=0; j<Reference.shoots.size(); j++) {
				if(Reference.shoots.get(j).getBoundingBox().intersects(Reference.barriers2[i].getBoundingBox()) && Reference.barriers2[i].getDamage()>0) {
					Reference.barriers2[i].damage();
					Reference.shoots.remove(j);
				}
			}
		}
	}
	
	public static void restart() {
		Reference.player = new Player();
				
		GameTasks.initAliens();
		GameTasks.initAliens1();

		Reference.shoots = new ArrayList<Shoot>();
		
Reference.barriers = new Barrier[] {
				
				new Barrier(70, 400 ),
				new Barrier(90, 400),
				new Barrier(110, 400),
				new Barrier(130, 400),
				new Barrier(150, 400 ),
				new Barrier(170, 400),
				new Barrier(190, 400),
				
				new Barrier(270, 400),
				new Barrier(290, 400),
				new Barrier(310, 400),
				new Barrier(330, 400),
				new Barrier(350, 400),
			    new Barrier(370, 400),
			    new Barrier(390, 400),
			    
				
				new Barrier(470, 400),
				new Barrier(490, 400),
				new Barrier(510, 400),
				new Barrier(530, 400),
				new Barrier(550, 400),
				new Barrier(570, 400),
				new Barrier(590, 400),
				
				
				new Barrier(670, 400),
				new Barrier(690, 400),
				new Barrier(710, 400),
				new Barrier(730, 400),
				new Barrier(750, 400),
				new Barrier(770, 400),
			    new Barrier(790, 400),
		
			
		};
Reference.barriers1 = new Barrier1[] {
				
				new Barrier1(70, 400 ),
				new Barrier1(100, 400),
				new Barrier1(130, 400),
				new Barrier1(160, 400),
				
				new Barrier1(620, 400),
				new Barrier1(650, 400),
				new Barrier1(680, 400),
				new Barrier1(710, 400),
				
				new Barrier1(260, 400),
				new Barrier1(290, 400),
				new Barrier1(320, 400),
				new Barrier1(350, 400),
				
				new Barrier1(440, 400),
				new Barrier1(470, 400),
				new Barrier1(500, 400),
				new Barrier1(530, 400),
			
		};

Reference.barriers2 = new Barrier2[] {
		
		new Barrier2(260, 300),
		new Barrier2(280, 300),
		new Barrier2(300, 300),
		new Barrier2(320, 300),
		new Barrier2(340, 300),
		new Barrier2(360, 300),
		new Barrier2(380, 300),
		new Barrier2(400, 300),
		new Barrier2(420, 300),
		new Barrier2(440, 300),
		new Barrier2(460, 300),
		new Barrier2(480, 300),
		new Barrier2(500, 300),
		new Barrier2(520, 300)
	
};
	}
	public static void topShipFlight() {
		Random rand = new Random();
		int r = rand.nextInt(500);
		
		if(Reference.topAlienShip == null && r == 0) {
			Reference.topAlienShip = new AlienShip();
	
		}
			
		if(Reference.topAlienShip != null) {
			Reference.topAlienShip.move();
			if(Reference.topAlienShip.getPosX() < 0)
				Reference.topAlienShip = null;
		}
	}
	
	public static void checkCollisionTopShipShoot() {
		for(int i=0; i<Reference.shoots.size(); i++) {
			if(Reference.topAlienShip !=null) {
				if(Reference.shoots.get(i).getBoundingBox().intersects(Reference.topAlienShip.getBoundingBox())) {
					Reference.topAlienShip = null;
					GameBoard.addScore(50);
				}
			}
		}
	}
}