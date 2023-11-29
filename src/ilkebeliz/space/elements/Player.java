package ilkebeliz.space.elements;

import java.awt.Rectangle;

import ilkebeliz.space.Reference;
import ilkebeliz.space.utils.Images;

public class Player extends ScreenElement {

	public static double getSpeed=0;
	public static double angle=0;
	public final int shotDelay = 10;	
	private int lives;
	

	
	public Player() {
		posX = Reference.windowWidth/2;
		posY = Reference.windowHeight-120;
		lives = 3;
		died = false;
		}

		

	public void moveX(int xDir) {
		posX+=xDir;

	}
	public void calculateAngle(int x, int y) {
		double slope;
	if((posX-450)==0) {
		slope=0;
		}
	else {
		slope =(double)(480-posY)/(posX-450);}
	angle=Math.atan(slope);
	}
	
	public void moveY(int yDir) {
		posY+=yDir;
	}


	public int getLives() {return lives;}
	
	
	public void takeLife() {lives--;}
	
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(posX, posY, Images.player.getWidth(), Images.player.getHeight());
	}
}