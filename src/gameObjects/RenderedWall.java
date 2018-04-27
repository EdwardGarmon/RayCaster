package gameObjects;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class RenderedWall {

	float realDis;
	float width;
	float height;
	float color;
	float dis;
	public RenderedWall(double realDis,  double width, double height, float dis) {
		this.realDis = (float) realDis;
		this.width = (float) width;
		this.height = (float) height;
		this.dis = dis;
	}
	
	public void display(Graphics g) {
		
		g.setColor(Color.cyan.darker(dis/300));
		
		g.fillRect(500 - realDis - width/2, 350-height/2, width, height);
		g.setColor(Color.white);
	}
	
}
