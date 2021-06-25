package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import gfx.Assets;
import io.*;

public class Player implements KeyboardObject{
	
	private int x, y;
	private int yVelocity;
	private Rectangle bounds;
	private KeyManager manager;
	
	public Player(KeyManager manager) {
		x = 200;
		y = 100;
		bounds = new Rectangle(x, y, 35, 35);
		yVelocity = 0;
		this.manager = manager;
	}
	
	public void update() {
		y += yVelocity;
		bounds.y = y;
		yVelocity ++;
	}
	
	public void render(Graphics graphics) {
		if(yVelocity > 0) {
			//bird falling
			graphics.drawImage(Assets.birdDown, x, y, 35, 35, null);
		}else {
			//bird flying
			graphics.drawImage(Assets.birdUp, x, y, 35, 35, null);
		}
	}
	

	@Override
	public void onKeyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE && !manager.isKeyJustPressed(KeyEvent.VK_SPACE)) {
			yVelocity = -15;
		}
			
		
	}

	public Rectangle getBounds() {
		return bounds;
	}
	
	public void resetPos() {
		y = 100;
		yVelocity = 0;
	}
	
}
