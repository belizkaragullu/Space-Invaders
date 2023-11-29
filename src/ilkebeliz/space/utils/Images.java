package ilkebeliz.space.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	public static final BufferedImage logo = readImage("try4");
	public static final BufferedImage player = readImage("spaceship1");
	public static final BufferedImage alien0 = readImage("pinkAlien1");
	public static final BufferedImage alien1 = readImage("orangeAlien");
	public static final BufferedImage alien2 = readImage("greenAlien");
	public static final BufferedImage topAlien = readImage("AlienTop");
	public static final BufferedImage explosion = readImage("explosion");

	
	private static BufferedImage readImage(String fileName) {
		System.out.println("[ResourceManager]: Loading "+fileName+".png");
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("src/ilkebeliz/resources/"+fileName+".png"));
		} catch (IOException e) {
			System.out.println("[ResourceManager]: Exception when loading src/ilkebeliz/resources/"+fileName+".png");
		}
		
		return img;
	}
		

}