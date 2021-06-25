package ui;

import java.awt.Graphics;

import gfx.Assets;

public class Background {
	
	private int x, y, width, height;
	
	public Background(int x) {
		this.x = x;
		y = 0;
		width = 432;
		height = 768;
	}
	
	public void update() {
		x -= 8;
	}
	
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.background, x, y, width, height, null);
	}
	
	public int getX() {
		return x;
	}
}
