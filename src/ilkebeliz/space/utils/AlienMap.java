package ilkebeliz.space.utils;

import java.awt.Graphics2D;

import ilkebeliz.space.Reference;

public class AlienMap {

	private int map[][];
	private int map1[][];

	public AlienMap() {
		map = new int[][] {{2,1,1,0,0},{2,1,1,0,0},{2,1,1,0,0},{2,1,1,0,0},{2,1,1,0,0}};
		map1 = new int[][] {{2,1,1,0,0,1},{2,1,1,0,0,1},{2,1,1,0,0,1},{2,1,1,0,0,1},{2,1,1,0,0,1},{2,1,1,0,0,1},{2,1,1,0,0,1}};
	}

	public void draw(Graphics2D g2d) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				
				if(!Reference.aliens[i][j].isDead()) {
					switch(map[i][j]) {
					
					case 0:
							g2d.drawImage(Images.alien0, Reference.aliens[i][j].getPosX(), Reference.aliens[i][j].getPosY(), Images.alien0.getWidth(), Images.alien0.getHeight(), null);
							break;
					case 1:
							g2d.drawImage(Images.alien1, Reference.aliens[i][j].getPosX(), Reference.aliens[i][j].getPosY(), Images.alien1.getWidth(), Images.alien1.getHeight(), null);
						break;
					case 2:
					     	g2d.drawImage(Images.alien2, Reference.aliens[i][j].getPosX(), Reference.aliens[i][j].getPosY(), Images.alien2.getWidth(), Images.alien2.getHeight(), null);
					    	break;
					}
				}
				else {
					if(Reference.aliens[i][j].getDeathDelay() > 0) {
						g2d.drawImage(Images.explosion, Reference.aliens[i][j].getPosX(), Reference.aliens[i][j].getPosY(), Images.explosion.getWidth()*3, Images.explosion.getHeight()*3, null);
						Reference.aliens[i][j].decreaseDeathDelay();
					}
				}
			}
		}
	}
	public void draw1(Graphics2D g2d) {
		for(int i=0; i<map1.length; i++) {
			for(int j=0; j<map1[i].length; j++) {
				
				if(!Reference.aliens1[i][j].isDead()) {
					switch(map1[i][j]) {
					
					case 0:
							g2d.drawImage(Images.alien0, Reference.aliens1[i][j].getPosX(), Reference.aliens1[i][j].getPosY(), Images.alien0.getWidth(), Images.alien0.getHeight(), null);
							break;
					case 1:
							g2d.drawImage(Images.alien1, Reference.aliens1[i][j].getPosX(), Reference.aliens1[i][j].getPosY(), Images.alien1.getWidth(), Images.alien1.getHeight(), null);
						break;
					case 2:
					     	g2d.drawImage(Images.alien2, Reference.aliens1[i][j].getPosX(), Reference.aliens1[i][j].getPosY(), Images.alien2.getWidth(), Images.alien2.getHeight(), null);
					    	break;
					}
				}
				else {
					if(Reference.aliens1[i][j].getDeathDelay() > 0) {
						g2d.drawImage(Images.explosion, Reference.aliens1[i][j].getPosX(), Reference.aliens1[i][j].getPosY(), Images.explosion.getWidth()*3, Images.explosion.getHeight()*3, null);
						Reference.aliens1[i][j].decreaseDeathDelay();
					}
				}
			}
		}
	}
	
	public int getAlienType(int x, int y) {return map[x][y];}
	public int getAlienType1(int x, int y) {return map1[x][y];}

}