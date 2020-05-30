package bricks.copy;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;



public class Brick {
	private int x;
	private int y;
	private int h;
	private int w;
	private boolean broken;
	private Image img;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
	public Brick() {
		h = 20;
		w = 55;
		broken = false;
	}
	
	public Brick(int paramH, int paramW, int paramX, int paramY) {
		this.h = paramH;
		this.w = paramW;
		this.x = paramX;
		this.y = paramY;
		broken = false;
	}
	
		
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
	}
	
	
	
	public boolean isBroken() {
		return broken;
	}

	public void setBroken(boolean broken) {
		this.broken = broken;
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

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}
	
	
	
}

