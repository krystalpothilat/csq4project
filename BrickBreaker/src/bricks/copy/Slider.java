package bricks.copy;

public class Slider {
	private int height;
	private int width;
	private int vx;
	private int x;
	private int y;
	
	public Slider() {
		height = 20;
		width = 60;
	}
	
	public Slider(int paramh, int paramw, int paramx, int paramy) {
		this.height = paramh;
		this.width = paramw;
		this.x = paramx;
		this.y = paramy;
		vx = 10
				;
	}
	public void setVx(int vx) {
		this.vx = vx;
	}
	
	public int getVx() {
		return vx;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
