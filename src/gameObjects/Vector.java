package gameObjects;

public class Vector {

	public float x;
	public float y;
	
	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector flip() {
		return new Vector(y,x);
	}
}
