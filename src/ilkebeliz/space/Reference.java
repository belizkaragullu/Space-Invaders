package ilkebeliz.space;

import java.util.ArrayList;

import ilkebeliz.space.elements.Alien;
import ilkebeliz.space.elements.AlienShip;
import ilkebeliz.space.elements.Barrier;
import ilkebeliz.space.elements.Barrier1;
import ilkebeliz.space.elements.Barrier2;
import ilkebeliz.space.elements.Player;
import ilkebeliz.space.elements.Shoot;
import ilkebeliz.space.utils.AlienMap;

public class Reference {
	public static final int windowWidth = 900;
	public static final int windowHeight = 600;
	
	public static Player player;
	public static Alien aliens[][];
	public static Alien aliens1[][];


	public static AlienMap map;
	public static AlienMap map1;
	public static ArrayList<Shoot> shoots;


	public static Barrier barriers[];
	public static Barrier1 barriers1[];
	public static Barrier2 barriers2[];

	
	public static final int alienRows = 5;
	public static final int alienColumns = 5;
	public static final int alienRows1 = 6;
	public static final int alienColumns1 = 7;
	public static AlienShip topAlienShip;
	


}
