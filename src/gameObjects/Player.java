package gameObjects;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import tutorialGame.Resources;

public class Player {

	public int x;
	public int y;
	int moveSpeed;
	float ang;
	Image texture;
	int mode;
	public Player( int mode) {
		x = 500;
		ang = 0;
		y = 350;
		moveSpeed = 5;
	
		this.mode = mode;
	}

	public void update(GameContainer gc) {

		move(gc);

	}

	public void display(Graphics g) {

		g.pushTransform();
		g.rotate(x, y, ang);
		g.drawOval(x-5, y-5, 10, 10);
		g.drawLine(x, y, x+20, y);
		g.popTransform();

	}

	private void move(GameContainer gc) {

		if(mode == 0) topDownMove(gc);
		if(mode == 1) firstPersonMove(gc);
	
		
	}
	
	
	private void firstPersonMove(GameContainer gc) {
		Input i = gc.getInput();

		i.enableKeyRepeat();

		if (i.isKeyDown(Input.KEY_W))
			x+= moveSpeed*Math.cos(getRadians());
		    y+= moveSpeed*Math.sin(getRadians());
		if (i.isKeyDown(Input.KEY_A))
			x-= moveSpeed*Math.cos(getRadians());
	        y-= moveSpeed*Math.sin(getRadians());
		if (i.isKeyDown(Input.KEY_S))
			x+= moveSpeed*Math.cos(getRadians());
	        y+= moveSpeed*Math.sin(getRadians());
		if (i.isKeyDown(Input.KEY_D))
			x+= moveSpeed*Math.cos(getRadians());
	        y+= moveSpeed*Math.sin(getRadians());

		float mouseX = i.getMouseX();
		float mouseY = i.getMouseY();


		float xD = mouseX - x;
		float yD = mouseY - y;
		
		if(mouseX>600) {
			ang++;
			
		}
		
		if(mouseX<300) {
			ang--;
		}
	}

	void topDownMove( GameContainer gc) {
		Input i = gc.getInput();

		i.enableKeyRepeat();

		if (i.isKeyDown(Input.KEY_W))
			y -= moveSpeed;
		if (i.isKeyDown(Input.KEY_A))
			x -= moveSpeed;
		if (i.isKeyDown(Input.KEY_S))
			y += moveSpeed;
		if (i.isKeyDown(Input.KEY_D))
			x += moveSpeed;

		float mouseX = i.getMouseX();
		float mouseY = i.getMouseY();


		float xD = mouseX - x;
		float yD = mouseY - y;

		ang = (float) ((float) Math.atan2(yD, xD) * (180 / Math.PI));
	}
	
	
	int getDegrees() {
		return  (int) ang;
	}
	
	float getRadians() {
		return (float) (ang*Math.PI/180);
	}
}
