package ilkebeliz.space.elements;

import java.awt.Rectangle;

import ilkebeliz.space.utils.Images;

public class AlienShip extends ScreenElement {

	public AlienShip() {
		this.posX = 900;
		this.posY = 50;
	}
	

	public void move() {
		this.posX-=2;
	}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(posX, posY, Images.topAlien.getWidth(), Images.topAlien.getHeight());
	}

}