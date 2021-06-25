package ui;

import java.awt.Graphics;
import java.util.LinkedList;

public class UIManager {

	private LinkedList<Background> bgRoll;
	
	public UIManager() {
		bgRoll = new LinkedList<>();
		for(int x = 0; x < 1024+432; x += 431) {
			addBg(x);
		}
	}
	
	public void update() {
		for(int i = 0; i < bgRoll.size(); i++) {
			bgRoll.get(i).update();
		}
		Background b = bgRoll.getFirst();
		if(b.getX() < -450) {
			bgRoll.removeFirst();
		}
		b = bgRoll.getLast();
		if(b.getX() < 1024) {
			addBg(b.getX()+431);
		}
	}
	
	public void render(Graphics graphics) {
		for(int i = 0; i < bgRoll.size(); i++) {
			bgRoll.get(i).render(graphics);
		}
	}
	
	private void addBg(int x) {
		bgRoll.add(new Background(x));
	}
	
}
