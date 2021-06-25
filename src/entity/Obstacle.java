package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import gfx.Assets;

public class Obstacle {

	private int x, y, width, height;
	private Rectangle bounds;
	
	public Obstacle(int x, int y, int height) {
		this.x = x;
		this.y = y;
		width = 50;
		this.height = height;
		bounds = new Rectangle(x, y, width, height);
	}
	
	public void update() {
		bounds.x = x;
	}
	
	public void render(Graphics graphics) {
		if(y == 0) {
			//draw top tube
			graphics.drawImage(Assets.tubeTop, x, height-768, width, 768, null);
		}else {
			//draw bottom tube
			graphics.drawImage(Assets.tubeBottom, x, y, width, 768, null);
		}
	}
	
	public void changeX(int deltaX) {
		x += deltaX;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
}
