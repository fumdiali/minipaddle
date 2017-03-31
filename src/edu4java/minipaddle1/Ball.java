package edu4java.minipaddle1;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {

	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;
	
	public Ball(Game game){
		this.game = game;
	}
	
	void move(){
		if(x + xa < 0)
			xa = 1;
		if(x + xa > game.getWidth() - DIAMETER)
			xa = -1;
		if(y + ya < 0)
			ya = 1;
		if(y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		if(collision()){
			ya = -1;
			y = game.paddle.getTopY()- DIAMETER;
		}
		
		x = x + xa;
		y = y + ya;
	}
	
	private boolean collision(){
		return game.paddle.getBounds().intersects(getBounds());
	}
	
	public void paint(Graphics2D g){
		g.fillOval(x, y, 30, 30);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,DIAMETER,DIAMETER);
	}
}