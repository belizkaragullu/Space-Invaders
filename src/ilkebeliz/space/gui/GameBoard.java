package ilkebeliz.space.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


import javax.swing.JPanel;
import javax.swing.Timer;

import ilkebeliz.space.Reference;
import ilkebeliz.space.elements.Barrier;
import ilkebeliz.space.elements.Barrier2;
import ilkebeliz.space.elements.Player;
import ilkebeliz.space.elements.Shoot;
import ilkebeliz.space.utils.AlienMap;
import ilkebeliz.space.utils.GameState;
import ilkebeliz.space.utils.GameTasks;
import ilkebeliz.space.utils.Images;

public class GameBoard extends JPanel implements ActionListener, KeyListener {

	private GameState state;
	private static Timer timer;
	private int timerDelay =0;
	
	private int playerDeathDelay = 10;
	
	private static int score = 0;
	private static int aliensKilled = 0;
	
	public GameBoard() {
		
		addKeyListener(this);
		this.setFocusable(true);

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
		
		Reference.map = new AlienMap();
		Reference.map1 = new AlienMap();

		state = GameState.MAIN_MENU;
	
		timer = new Timer(timerDelay, this);
		timer.start();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		repaint(); revalidate();
		
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, Reference.windowWidth, Reference.windowHeight);
		
		if(state == GameState.LEVEL1) {
			graphicLevel1(g);
		}
		 else if (state== GameState.LEVEL2 ) {
		    	graphicLevel2(g);
		    }
		    else if (state== GameState.LEVEL3 ) {
		    	graphicLevel3(g);
		    }
		else if(state == GameState.MAIN_MENU) {
			graphicMainMenu(g);
		}
		else if(state == GameState.GAME_OVER) {
			graphicGameOver(g);
		}
		else if(state==GameState.FINISH1) {
			graphicFinish1(g);
		}	
		else if(state==GameState.FINISH2) {
			graphicFinish2(g);
		}
		else if(state==GameState.FINISH3) {
			graphicFinish3(g);
		}
	   
			
		}

	public static void addScore(int value) {score+=value;}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(state == GameState.LEVEL1) {
			if(!Reference.player.isDead()) {
				switch(arg0.getKeyCode()) {
				
				case KeyEvent.VK_LEFT:
					if(Reference.player.getPosX()>10) Reference.player.moveX(-5);
					Player.getSpeed-=5;
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
					break;
					
				case KeyEvent.VK_RIGHT:
					if(Reference.player.getPosX()<810) Reference.player.moveX(5);
					Player.getSpeed+=5;
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
					 break;
					
				case KeyEvent.VK_UP:
					if(Reference.player.getPosY()>370)
				    Reference.player.moveY(-5);
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
				
					break;
					
				case KeyEvent.VK_DOWN:
					if(Reference.player.getPosY()<480)
					Reference.player.moveY(5);
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
					break;
				
				case KeyEvent.VK_SPACE:
					if(GameTasks.getPlayerDelay() > Reference.player.shotDelay) {
						Reference.shoots.add(new Shoot(Reference.player.getPosX()+35, Reference.player.getPosY()-10, -10));
						GameTasks.resetPlayerDelay();
					}
					break;
				}
			}
		}
		if(state == GameState.LEVEL2) {
			if(!Reference.player.isDead()) {
				switch(arg0.getKeyCode()) {
				
				case KeyEvent.VK_LEFT:
					if(Reference.player.getPosX()>10) Reference.player.moveX(-5);
					Player.getSpeed-=5;
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
					break;
					
				case KeyEvent.VK_RIGHT:
					if(Reference.player.getPosX()<810) Reference.player.moveX(5);
					Player.getSpeed+=5;
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
					 break;
					
				case KeyEvent.VK_UP:
					if(Reference.player.getPosY()>370)
				    Reference.player.moveY(-5);
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
				
					break;
					
				case KeyEvent.VK_DOWN:
					if(Reference.player.getPosY()<480)
					Reference.player.moveY(5);
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
					break;
				
				case KeyEvent.VK_SPACE:
					if(GameTasks.getPlayerDelay() > Reference.player.shotDelay) {
						Reference.shoots.add(new Shoot(Reference.player.getPosX()+35, Reference.player.getPosY()-10, -10));
						GameTasks.resetPlayerDelay();
					}
					break;
				}
			}
		}
		else if(state == GameState.LEVEL3) {
			if(!Reference.player.isDead()) {
				switch(arg0.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(Reference.player.getPosX()>10) Reference.player.moveX(-5);
					Player.getSpeed-=5;
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
					break;
					
				case KeyEvent.VK_RIGHT:
					if(Reference.player.getPosX()<810) Reference.player.moveX(5);
					Player.getSpeed+=5;
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
					 break;
					
				case KeyEvent.VK_UP:
					if(Reference.player.getPosY()>370)
				    Reference.player.moveY(-5);
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
				
					break;
					
				case KeyEvent.VK_DOWN:
					if(Reference.player.getPosY()<480)
					Reference.player.moveY(5);
					 Reference.player.calculateAngle(Reference.player.getPosX(),Reference.player.getPosY());
					break;
				
				case KeyEvent.VK_SPACE:
					if(GameTasks.getPlayerDelay() > Reference.player.shotDelay) {
						Reference.shoots.add(new Shoot(Reference.player.getPosX()+35, Reference.player.getPosY()-10, -10));
						GameTasks.resetPlayerDelay();
					}
					break;
				}
			}
		}
		else if(state == GameState.MAIN_MENU) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				state = GameState.LEVEL1;
				
		}}
		else if(state == GameState.GAME_OVER) {
			state = GameState.MAIN_MENU;
			score = 0;
			GameTasks.restart();
		}
		else if(state==GameState.FINISH1) {
			if (arg0.getKeyCode() == KeyEvent.VK_L) {
			state = GameState.LEVEL2;
			aliensKilled=0;
			//score=0;
			GameTasks.restart();}
		}
		else if(state==GameState.FINISH2) {
			if (arg0.getKeyCode() == KeyEvent.VK_L) {
			state = GameState.LEVEL3;
			aliensKilled=0;
			//score=0;
			GameTasks.restart();}
		}
		else if(state==GameState.FINISH3) {
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			state = GameState.MAIN_MENU;
			aliensKilled=0;
			score=0;
			GameTasks.restart();}
		}
	}
//	static String timeString;
//	int k=0;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	//	Timer timerScreen = new Timer(1000,new ActionListener() {
			
		//	@Override
			//public void actionPerformed(ActionEvent arg0) {
				//// TODO Auto-generated method stub
				//timeString=String.valueOf(k/60);
				//k++;
	//		}
				
	//		});
	//	timerScreen.start();
		if(state == GameState.LEVEL1) {
			if(!Reference.player.isDead()) {
				GameTasks.changeDelays();			
				GameTasks.alienShoot();
				GameTasks.moveShoots();
				
				if(GameTasks.checkCollisionAlienShoot()) {
					aliensKilled++;
				}
				
				GameTasks.checkCollisionShieldShoot2();
				
				if(GameTasks.checkCollisionPlayerShoot()) {
					System.out.println("[GameBoard]: Detected player death");
					Reference.player.setDead(true);
				}
			
				
			}
			if(Reference.player.isDead()) {
				playerDeathDelay--;
				
				if(playerDeathDelay == 0) {
					playerDeathDelay =100;

					if(Reference.player.getLives()>0)
						Reference.player.setDead(false);
					else
						state = GameState.GAME_OVER;
					
					System.out.println("[GameBoard]: Death animation ended");
				}
			}
			
		
			if(aliensKilled == Reference.alienColumns*Reference.alienRows) {
				playerDeathDelay=100;
				state = GameState.FINISH1;
			}
		}
		if(state == GameState.LEVEL2) {
			if(!Reference.player.isDead()) {
				
				GameTasks.changeDelays();
				GameTasks.moveAllAliens();
				GameTasks.alienShoot();
				GameTasks.moveShoots();

				if(GameTasks.checkCollisionAlienShoot()) {
					aliensKilled++;
				}
				
				GameTasks.checkCollisionShieldShoot();
				
				if(GameTasks.checkCollisionPlayerShoot()) {
					System.out.println("[GameBoard]: Detected player death");
					Reference.player.setDead(true);
				}
			
				
			}

			if(Reference.player.isDead()) {
				playerDeathDelay--;
				
				if(playerDeathDelay == 0) {
					playerDeathDelay =100;

					if(Reference.player.getLives()>0)
						Reference.player.setDead(false);
					else
						state = GameState.GAME_OVER;
					
					System.out.println("[GameBoard]: Death animation ended");
				}
			}
			

			if(aliensKilled == Reference.alienColumns*Reference.alienRows) {
				playerDeathDelay=100;
				state = GameState.FINISH2;
		
			}
		}
		if(state == GameState.LEVEL3) {

			
			if(!Reference.player.isDead()) {
				GameTasks.changeDelays();
				GameTasks.moveAllAliens1();
				GameTasks.alienShoot1();

				GameTasks.moveShoots();

				if(GameTasks.checkCollisionAlienShoot1()) {
					aliensKilled++;
				}
				
				GameTasks.topShipFlight();
				
				GameTasks.checkCollisionTopShipShoot();

				GameTasks.checkCollisionShieldShoot1();
				

				if(GameTasks.checkCollisionPlayerShoot()) {
					System.out.println("[GameBoard]: Detected player death");
					Reference.player.setDead(true);
				}
			
			}
			if(Reference.player.isDead()) {
				playerDeathDelay--;
				
				if(playerDeathDelay == 0) {
					playerDeathDelay = 100;
					if(Reference.player.getLives()>0)
						Reference.player.setDead(false);
					else
						state = GameState.GAME_OVER;
					
					
				}
			}

			if(aliensKilled == Reference.alienColumns1*Reference.alienRows1) {
				playerDeathDelay=100; 
				state = GameState.FINISH3;
				aliensKilled=0;		
			}
		}
		repaint(); 
		revalidate();
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		Player.getSpeed= 0;
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {}

	
	
	private static void graphicLevel1(Graphics g) {

		if(!Reference.player.isDead()) {
			g.drawImage(Images.player, Reference.player.getPosX(), Reference.player.getPosY(), Images.player.getWidth(), Images.player.getHeight(), null);

	
		g.setFont(new Font("Algerian", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Score: ", 650, 29);
		g.drawString(""+score, 720, 29);
		g.drawString("Lives: ", 40, 29);
		g.drawString("Speed",650 , 559);
		g.drawString(""+Player.getSpeed, 720, 559);
		g.drawString("Angle ", 40, 559);
     	g.drawString(""+Player.angle, 140, 559);
     	g.drawString("Time: ",360, 559);
    // 	g.drawString(""+timeString,420, 559);
		

     
		for(int i=0; i<Reference.player.getLives(); i++) {
			g.drawImage(Images.player, i*40+110,17, 50,34, null);
		}
		

		g.setColor(Color.pink);
		g.fillRect(4, 530, 880, 4);
		g.setColor(Color.pink);
		g.fillRect(4, 50, 880, 4);
		

		g.setColor(Color.red);
		for(int i=0; i<Reference.shoots.size(); i++) {
			g.fillRect(Reference.shoots.get(i).getPosX(), Reference.shoots.get(i).getPosY(), 3, 10);
		}
		

		g.setColor(Color.blue);
		for(int i=0; i<Reference.barriers2.length; i++) {
				switch(Reference.barriers2[i].getDamage()) {
				case 1:
					g.drawRect(Reference.barriers2[i].getPosX(), Reference.barriers2[i].getPosY(),20,20); break;
				case 2:
					g.fillRect(Reference.barriers2[i].getPosX(), Reference.barriers2[i].getPosY(),20, 20); break;
			}
		}
			

		Reference.map.draw((Graphics2D) g);

	}
	}
	
	private static void graphicLevel2(Graphics g) {

		if(!Reference.player.isDead()) {
			g.drawImage(Images.player, Reference.player.getPosX(), Reference.player.getPosY(), Images.player.getWidth(), Images.player.getHeight(), null);
		}
			

		g.setFont(new Font("Algerian", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Score: ", 650, 29);
		g.drawString(""+score, 720, 29);
		g.drawString("Lives: ", 40, 29);
		g.drawString("Speed",650 , 559);
		g.drawString(""+Player.getSpeed, 720, 559);
		g.drawString("Angle ", 40, 559);
     	g.drawString(""+Player.angle, 140, 559);
     	g.drawString("Time: ",360, 559);

		for(int i=0; i<Reference.player.getLives(); i++) {
			g.drawImage(Images.player, i*40+110,17, 50,34, null);
		}
		

		g.setColor(Color.pink);
		g.fillRect(4, 530, 880, 4);
		g.setColor(Color.pink);
		g.fillRect(4, 50, 880, 4);
		
		g.setColor(Color.red);
		for(int i=0; i<Reference.shoots.size(); i++) {
			g.fillRect(Reference.shoots.get(i).getPosX(), Reference.shoots.get(i).getPosY(), 3, 10);
		}

		g.setColor(Color.pink);
		for(int i=0; i<Reference.barriers.length; i++) {
				switch(Reference.barriers[i].getDamage()) {
				case 1:
					g.drawRect(Reference.barriers[i].getPosX(), Reference.barriers[i].getPosY(),20,20); break;
				case 2:
					g.fillRect(Reference.barriers[i].getPosX(), Reference.barriers[i].getPosY(),20, 20); break;
			}
		}
			
		Reference.map.draw((Graphics2D) g);

	}
	private static void graphicLevel3(Graphics g) {
		if(!Reference.player.isDead()) {
			g.drawImage(Images.player, Reference.player.getPosX(), Reference.player.getPosY(), Images.player.getWidth(), Images.player.getHeight(), null);
		}
			
		g.setFont(new Font("Algerian", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Score: ", 650, 29);
		g.drawString(""+score, 720, 29);
		g.drawString("Lives: ", 40, 29);
		g.drawString("Speed",650 , 559);
		g.drawString(""+Player.getSpeed, 720, 559);
		g.drawString("Angle ", 40, 559);
     	g.drawString(""+Player.angle, 140, 559);
     	g.drawString("Time: ",360, 559);

     	
		g.drawImage(Images.player, 40+110,17,50,34,null);
		
		

		g.setColor(Color.yellow);
		g.fillRect(4, 530, 880, 4);
		g.setColor(Color.yellow);
		g.fillRect(4, 50, 880, 4);
		
		
		g.setColor(Color.red);
		for(int i=0; i<Reference.shoots.size(); i++) {
			g.fillRect(Reference.shoots.get(i).getPosX(), Reference.shoots.get(i).getPosY(), 3, 10);
		}

		g.setColor(Color.yellow);
		for(int i=0; i<Reference.barriers1.length; i++) {
				switch(Reference.barriers1[i].getDamage()) {
				case 1:
					g.drawRect(Reference.barriers1[i].getPosX(), Reference.barriers1[i].getPosY(),30,30); break;
				case 2:
					g.drawRoundRect(Reference.barriers1[i].getPosX(), Reference.barriers1[i].getPosY(),30,30,25,25);break;
				case 3:
					g.fillRect(Reference.barriers1[i].getPosX(), Reference.barriers1[i].getPosY(),30, 30); break;
			}
		}

				Reference.map1.draw1((Graphics2D) g);	

				if(Reference.topAlienShip != null)
				g.drawImage(Images.topAlien, Reference.topAlienShip.getPosX(), Reference.topAlienShip.getPosY(), Images.topAlien.getWidth(), Images.topAlien.getHeight(), null);
			
				for(int i=0; i<Reference.player.getLives(); i++) {
					g.drawImage(Images.player, i*40+110,17, 50,34, null);
				}
	}
	
	private static void graphicMainMenu(Graphics g) {

		g.setColor(Color.white);
		g.drawImage(Images.logo, 260, 85, Images.logo.getWidth()*2, Images.logo.getHeight(), null);
		g.drawImage(Images.alien0, 380, 300, Images.alien0.getWidth(), Images.alien0.getHeight(), null);
		g.drawImage(Images.alien1, 380, 340, Images.alien1.getWidth(), Images.alien1.getHeight(), null);
		g.drawImage(Images.alien2, 380, 380, Images.alien2.getWidth(), Images.alien2.getHeight(), null);
		g.drawImage(Images.topAlien, 370, 410, Images.topAlien.getWidth(), 40, null);

	
		g.setFont(new Font("Algerian", Font.BOLD, 20));
		g.drawString("= 10 PTS", 430, 320);
		g.drawString("= 20 PTS", 430, 360);
		g.drawString("= 30 PTS", 430, 400);
		g.drawString("= 50 PTS", 430, 440);
	
		g.drawString("PRESS ENTER TO START",320,550 );
	
	}
	
	private static void graphicGameOver(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Algerian", Font.BOLD, 50));
		g.drawString("GAME OVER", 300, 285);
		
		g.setColor(Color.red);
		g.setFont(new Font("Algerian", Font.BOLD, 20));
		g.drawString("YOUR SCORE: "+score, 370, 150);
		g.drawString("PRESS ENTER TO RETURN MAÝN MENU",270, 450);
	}
	private static void graphicFinish1(Graphics g) {
		g.setColor(Color.blue);
		g.setFont(new Font("Algerian", Font.BOLD, 30));
		g.drawString("YOU HAVE PASSED LEVEL 1",250,285);
		
		g.setColor(Color.white);
		g.setFont(new Font("Algerian", Font.BOLD, 18));
		g.drawString("YOUR SCORE "+score, 380, 150);
		g.drawString("PRESS L TO LEVEL UP", 370, 450);
	}
	private static void graphicFinish2(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Algerian", Font.BOLD, 30));
		g.drawString("YOU HAVE PASSED LEVEL 2",250, 285);
		
		g.setColor(Color.white);
		g.setFont(new Font("Algerian", Font.BOLD, 18));
		g.drawString("YOUR SCORE "+score, 380, 150);
		g.drawString("PRESS L TO LEVEL UP", 370, 450);
	}
	private static void graphicFinish3(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Algerian", Font.BOLD, 30));
		g.drawString("CONGRATULATÝONS,YOU SKIPPED ALL THE LEVELS!",50, 285);
		
		g.setColor(Color.white);
		g.setFont(new Font("Algerian", Font.BOLD, 18));
		g.drawString("YOUR SCORE "+score, 380, 150);
		g.drawString("PRESS ENTER TO RETURN MAÝN MENU", 310, 450);
	}
	
	
	
}