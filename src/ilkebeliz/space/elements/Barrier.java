package ilkebeliz.space.elements;

import java.awt.Rectangle;

public class Barrier extends ScreenElement {

	private int damageCount;

	

	public Barrier(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
		damageCount =2;
	
	}

	public int getDamage() {return damageCount;}
	

	public void damage() {damageCount--;}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(posX, posY, 30,30);
	}
	
	
}