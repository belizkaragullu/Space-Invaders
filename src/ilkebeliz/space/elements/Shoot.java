package ilkebeliz.space.elements;

import java.awt.Rectangle;

public class Shoot extends ScreenElement {
private int yDir;
	


	public Shoot(int posX, int posY, int yDir) {
		this.posX=posX;
		this.posY=posY;
		this.yDir=yDir;
	}

	public void move() {
		this.posY+=yDir;
	}
	

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(posX, posY, 2, 10);
	}

}