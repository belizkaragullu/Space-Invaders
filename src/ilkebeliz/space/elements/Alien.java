package ilkebeliz.space.elements;

import java.awt.Rectangle;

import ilkebeliz.space.utils.Images;

public class Alien extends ScreenElement {
	
	private static int xDir = 20;
	private static int motionDelay = 25;
	private static int motionDelay1 = 30;
			
			;

	private int deathDelay = 5;
	
	public Alien(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
		this.died=false;
	}
	
	
	public void moveSideways() {
		posX+=xDir;
	}
	public void moveSideways1() {
		posX+=xDir;
	}
	
	

	public boolean checkDir() {
		if(posX<20) {
			xDir=10; return true;
		}
		else if(posX>810) {
			xDir=-10; return true;
		}
		
		return false;
	}
	
	public int getDir() {return xDir;}
	
		public static int getMotionDelay() {return motionDelay;}
	public static int getMotionDelay1() {return motionDelay1;}
	
	public static void decreaseMotionDelay() {
		if(motionDelay>0) motionDelay--;
	}

	public static void decreaseMotionDelay1() {
		if(motionDelay1>0) motionDelay1--;
	}
	

	public void decreaseDeathDelay() {deathDelay--;}
	

	public int getDeathDelay() {return deathDelay;}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(posX, posY, Images.alien1.getWidth(), Images.alien1.getHeight());
	}
}