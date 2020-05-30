//package bricks.copy;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Rectangle;
//import java.awt.event.ActionEvent;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.image.*;
//import java.io.File;
//
//import javax.swing.JFrame;
//import javax.swing.Timer;
//
//
//public class Driver implements KeyListener {
//	
//	int screen_width = 800;
//	int screen_height = 800;
//	
//	Brick[][] mybricks = new Brick[10][10];
//	
//	String src = new File("").getAbsolutePath() + "/src/"; // path to image
//	
//	public void paint(Graphics g) {
//
////		super.paintComponent(g);
//		g.setColor(Color.white);
//		g.fillRect(0,0,screen_width, screen_height);
//		
//		for(int r = 0; r < mybricks.length; r++) {
//			for(int c = 0; c < mybricks[0].length; c++) {
//				mybricks[r][c].paint(g);
//			}
//		}
//		
//	}
//	
//	public void update() {
//		
//	}
//	
//	public void actionPerformed(ActionEvent arg0) {
//		update();
//		//repaint();
//	}
//	
//	public static void main(String[] arg) {
//	}
//	
//	public Driver() {
//		JFrame f = new JFrame();
//		f.setTitle("Brick Breaker");
//		f.setSize(screen_width, screen_height);
//		f.setResizable(false);
//		f.addKeyListener(this);
//		
//		for(int r = 0; r < mybricks.length; r++) {
//			for(int c = 0; c < mybricks[0].length; c++) {
//				mybricks[r][c] = new Brick("brick.jpg", 30, 60, 75+ (35*c), 100+(65*r));
//			}
//		}
//		
//		f.add(f, this);
//
////		t = new Timer(17, this);
////		t.start();
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
//	}
//	
//	public void reset() {
//		
//	}
//	
//	public void keyPressed(KeyEvent e) {
//		
//	}
//
//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//}

package bricks.copy;

	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.event.MouseMotionListener;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.Timer;

	import java.awt.image.*;

	public class Driver extends JPanel implements ActionListener, KeyListener,
			MouseListener, MouseMotionListener {
		
		int screen_width = 800;
		int screen_height = 800;
		
		Brick[][] mybricks = new Brick[10][12];
		Ball ball = new Ball(300, 500, 15, 15);
		Slider slider = new Slider(20, 100, 300, 600);
		public void paint(Graphics g) {

//			super.paintComponent(g);
			
			//paint bricks
			g.setColor(Color.pink);
			for(int r = 0; r < mybricks.length; r++) {
				for(int c = 0; c < mybricks[0].length; c++) {
					if(mybricks[r][c].isBroken() == false) {
					g.fillRect(mybricks[r][c].getX(), mybricks[r][c].getY(), 
							mybricks[r][c].getW(), mybricks[r][c].getH());
					}
				}
			}
			
			//paint ball
			g.setColor(Color.blue);
			g.fillOval(ball.getH(), ball.getW(), ball.getX(), ball.getY());
			
			//paint slider
			g.setColor(Color.black);
			g.fillRect(slider.getX(), slider.getY(), slider.getWidth(), slider.getHeight());
			
		}
	
		public void update() {
//			ball.setH(ball.getH() + ball.getVx());
//			ball.setW(ball.getW() + ball.getVy());
			ball.move();
			repaint();
			
			//right 
			if(ball.getH() == 800-ball.getY()) {
				ball.setVx(ball.getVx() * -1);
			}
			//top
			if(ball.getW() == 0) {
				ball.setVy(ball.getVy() * -1);
			}
			//left
			if(ball.getH() == 0) {
				ball.setVx(ball.getVx() * -1);
			}
			//bottom
			if(ball.getW() == 780-ball.getY()) {
				ball.setVy(ball.getVy() * -1);
			}
			//slider
			if(ball.getW() >= slider.getY() - ball.getY() &&
					ball.getH() > slider.getX() &&
					ball.getH() < slider.getX() + slider.getWidth()) {
				ball.setVy(ball.getVy() * -1);
			}
			
//			for(int r = 0; r < mybricks.length; r++) {
//				for(int c = 0 ; c < mybricks[0].length; c++) {
//					if(ball.collided(mybricks[r][c])) {
//						mybricks[r][c].setBroken(true);
//						mybricks[r][c].setX(-500);
//						ball.setVx(ball.getVx() * -1);
//						ball.setVy(ball.getVy() * -1);
//						repaint();
//					}
//				}
			
			for(int r = 0 ; r < mybricks.length; r++) {
				for(int c = 0 ; c < mybricks[0].length; c++) {
					//bottom of brick
					if(ball.getW() <= mybricks[r][c].getY() + mybricks[r][c].getH() &&
							ball.getH() > mybricks[r][c].getX() && 
							ball.getH() < mybricks[r][c].getX()+mybricks[r][c].getW()) {
						ball.setVy(ball.getVy() * -1);
						mybricks[r][c].setBroken(true);
						mybricks[r][c].setX(-500);
						repaint();
					
//					} else if (ball.getH() <= mybricks[r][c].getX()+mybricks[r][c].getW() &&
//							ball.getW() > mybricks[r][c].getY() &&
//							ball.getW() < mybricks[r][c].getY() + mybricks[r][c].getH()) {
//						ball.setVx(ball.getVx() * -1);
//						mybricks[r][c].setBroken(true);
//						mybricks[r][c].setX(-500);
//						repaint();
//						
//					} else if (ball.getH() + ball.getY() >= mybricks[r][c].getX() &&
//							ball.getW() > mybricks[r][c].getY() &&
//							ball.getW() < mybricks[r][c].getY() + mybricks[r][c].getH()) {
//						ball.setVx(ball.getVx() * -1);
//						mybricks[r][c].setBroken(true);
//						mybricks[r][c].setX(-500);
//						repaint();
//					}else if (ball.getW() + ball.getX() == mybricks[r][c].getY() && 
//							ball.getH() > mybricks[r][c].getX() && 
//							ball.getH() < mybricks[r][c].getX()+mybricks[r][c].getW()){
//						ball.setVy(ball.getVy() * -1);
//						mybricks[r][c].setBroken(true);
//						mybricks[r][c].setX(-500);
//						repaint();
//					
//					}
						
					}
				}
			}
		}
			
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			update();
			repaint();
		}

		public static void main(String[] arg) {
			Driver d = new Driver();
		}

		public Driver() {

			JFrame f = new JFrame();
			f.setTitle("Brickbreaker");
			f.setSize(screen_width, screen_height);
			f.setResizable(false);
			f.addKeyListener(this);
			
			//instantiate bricks
			for(int r = 0; r < mybricks.length; r++) {
				for(int c = 0; c < mybricks[0].length; c++) {
					mybricks[r][c] = new Brick(30, 60, 15 + (65*c), 50+ (35*r));
				}
			}
		
			

			f.add(this);
			t = new Timer(16, this);
			t.start();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
		}

		Timer t;
		

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == 37) {
				slider.setX(slider.getX() - slider.getVx());
			}
			
			if(e.getKeyCode() == 39) {
				slider.setX(slider.getX() + slider.getVx());
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			//System.out.println(e.getKeyCode());

		}

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

		public void reset() {
			
		}
		
		boolean on = false;
		@Override
		public void mousePressed(MouseEvent e) {
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			
			
		}

	}


