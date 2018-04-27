package states;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import gameObjects.Vector;
import gameObjects.WorldMap;

public class WallAdder {

	WorldMap map;

	Boolean firstClick;

	Vector p1;
	Vector p2;

	public WallAdder(WorldMap map) {
		this.map = map;
		firstClick = false;
	}

	public void addWall(GameContainer gc) {
		Input i = gc.getInput();
		if (i.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			if (firstClick) {
				
				p2 = new Vector(i.getMouseX(),i.getMouseY());
				map.addWall(p1,p2);
				firstClick = false;
			} else {
				p1 = new Vector(i.getMouseX(),i.getMouseY());
				firstClick = true;
			}
		}

	}
}
