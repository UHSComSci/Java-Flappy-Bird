package ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import gamelogic.Game;
import gfx.Assets;
import io.KeyboardObject;

public class Popup implements KeyboardObject{
	
	private boolean active;
	private Game game;
	
	public Popup(Game game) {
		this.game = game;
		active = false;
	}
	
	public void render(Graphics graphics) {
		if(active) {
			graphics.drawImage(Assets.popup, 256, 192, 512, 384, null);
		}
	}

	@Override
	public void onKeyPressed(KeyEvent e) {
		if(active) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				game.restart();
				active = false;
			}
		}
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

}
