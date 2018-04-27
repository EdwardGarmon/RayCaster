package gameObjects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import tutorialGame.Resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.Map;
import java.util.Map.Entry;

public class WorldMap {

	ArrayList<Wall> environ;

	public WorldMap() {
		environ = new ArrayList();

	}

	public void addWall(Vector p1, Vector p2) {

		Wall w = new Wall(p1, p2);

		environ.add(w);
	}

	public void display(Graphics g) {
		for(int i = 0; i< environ.size(); i++) {
			environ.get(i).render(g);
		}
	}

	boolean contains(Vector v) {
		for(int i = 0; i < environ.size(); i++ ) {
			if(environ.get(i).contains(v.x, v.y)) {
				return true;
			}
		}
		return false;

	}
}
