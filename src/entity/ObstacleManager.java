package entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import gamelogic.Game;

public class ObstacleManager {
	
	private LinkedList<Obstacle> obstacles;
	private int frameCount;
	private Player player;
	private Game game;
	
	public ObstacleManager(Game game, Player player) {
		obstacles = new LinkedList<>();
		frameCount = 0;
		this.game = game;
		this.player = player;
		generateObstacle();
	}
	
	public void update() {
		frameCount ++;
		for(int i = 0; i < obstacles.size(); i++) {
			Obstacle o = obstacles.get(i);
			o.changeX(-8);
			o.update();
			if(o.getBounds().getMaxX() < 0) {
				obstacles.remove(i);
				i --;
			}
			if(o.getBounds().intersects(player.getBounds())) {
				game.die();
			}
		}
		if(frameCount > 60) {
			generateObstacle();
			frameCount = 0;
		}
	}
	
	public void render(Graphics graphics) {
		for(int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).render(graphics);
		}
	}
	
	private void generateObstacle() {
		int startY = (int)(Math.random()*468+150);
		Obstacle o1 = new Obstacle(1024, 0, startY);
		Obstacle o2 = new Obstacle(1024, startY+150, 768-startY-150);
		obstacles.add(o1);
		obstacles.add(o2);
	}

}
