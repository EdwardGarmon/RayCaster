package gameObjects;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Wall {

	float startX;
	float endX;
	float startY;
	float endY;

	float b;
	float slope;
	float tol;
	Vector p1;
	Vector p2;
	boolean vert;

	public Wall(Vector p1, Vector p2) {
		vert = false;
		this.p1 = p1;
		this.p2 = p2;

		slope = (p2.y - p1.y) / (p2.x - p1.x);

		if (Math.abs(slope) >= 5) {
			p1 = p1.flip();
			p2 = p2.flip();
			slope = (p2.y - p1.y) / (p2.x - p1.x);
			vert = true;

		}

		startX = p1.x;
		endX = p2.x;

		if (p2.x < p1.x) {
			startX = p2.x;
			endX = p1.x;
		}

		b = (int) (p2.y - p2.x * slope);
		tol = 1;
	}

	public void render(Graphics g) {

		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

	boolean contains(float x, float y) {

		if (vert) {
			if (y >= startX && y <= endX) {
			int fy = (int) (y * slope + b);

			if ((int) Math.abs(fy - x) <= tol) {
				return true;
			}
			}
		}
		
		else

		if (x >= startX && x <= endX) {
			int fy = (int) (x * slope + b);

			if ((int) Math.abs(fy - y) <= tol) {
				return true;
			}
		}
		return false;
	}

}
