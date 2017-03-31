package edu4java.minipaddle1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel {
	
	/*int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	
	private void moveBall(){
		if(x + xa < 0)
			xa = 1;
		if(x + xa > getWidth() - 30)
			xa = -1;
		if(y + ya < 0)
			ya = 1;
		if(y + ya > getHeight() - 30)
			ya = -1;
		
		x = x + xa;
		y = y + ya;
	}*/
	
	//instantiate our ball & paddle objs
	Ball ball = new Ball(this);
	Paddle paddle = new Paddle(this);
	
	//constructor
	public Game(){
		addKeyListener(new KeyListener(){
			
			public void keyTyped(KeyEvent e){
				
			}
			
			public void keyReleased(KeyEvent e){
				paddle.keyReleased(e);
			}
			public void keyPressed(KeyEvent e){
				paddle.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	private void move(){
		ball.move();
		paddle.move();
	}
			
	@Override
	public void paint(Graphics g){
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				         RenderingHints.VALUE_ANTIALIAS_ON);
		
		ball.paint(g2d);
		paddle.paint(g2d);
		
		/*g2d.fillOval(x, y, 30, 30);
		g2d.setColor(Color.BLUE);
		g2d.fillOval(50, 100, 30, 30);
		//g2d.drawOval(50, 100, 30, 30);
		
		//g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));*/
	}
	
	//for collision detection
	public void gameOver(){
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		
		JFrame frame = new JFrame();
		Game g = new Game();
		
		
		
		frame.add(g);
		frame.setTitle("Paddle Game");
		frame.setSize(300, 400);
		frame.setContentPane(g);//for background
		frame.getContentPane().setBackground(Color.ORANGE);//for background
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		while(true){
			g.move();
			g.repaint();
			Thread.sleep(10);
			
		}

	}

}
