package ilkebeliz.space.elements;

import java.awt.Rectangle;

public class Barrier1 extends ScreenElement {

	private int damageCount;


	public Barrier1(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
		damageCount =3;
	
	}
	

	public int getDamage() {return damageCount;}
	

	public void damage() {damageCount--;}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(posX, posY, 30,30);
	}
	
	
}