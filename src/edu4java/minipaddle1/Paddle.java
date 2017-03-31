package edu4java.minipaddle1;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {

	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xa = 0;
	private Game game;
	
	public Paddle(Game game){
		this.game = game;
	}
	
	public void move(){
		if(x + xa > 0 && x + xa < game.getWidth()-60)
			x = x + xa;
	}
	
	public void paint(Graphics2D g){
		g.fillRect(x,Y,WIDTH,HEIGHT);
	}
	
	public void keyReleased(KeyEvent e){
		xa = 0;
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()== KeyEvent.VK_LEFT)
			xa = -1;
		if(e.getKeyCode()== KeyEvent.VK_RIGHT)
			xa = 1;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,Y,WIDTH,HEIGHT);
	}
	
	public int getTopY(){
		return Y;
	}
}
