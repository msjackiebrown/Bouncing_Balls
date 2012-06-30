import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.*;

//Holds the parameters for drawing the balls

public class BallPanel extends JPanel  {
	
	Ball ball= new Ball();
	int speed = 10; // How fast is the ball going?
	
	private Timer timer = new Timer(speed, new TimerListener());
	
	
	private class TimerListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		switch(ball.color)
		{
		case 0:
			g.setColor(Color.BLUE);
			break;
		case 1:
			g.setColor(Color.GRAY);
			break;
		case 2:
			g.setColor(Color.GREEN);
			break;
		case 3:
			g.setColor(Color.MAGENTA);
			break;
		case 4:
			g.setColor(Color.RED);
			break;
		}
		
		ball.bounce(); // Move ball (Bounce)
		
		g.fillOval(ball.getx()-ball.getradius(), ball.gety()-ball.getradius(), ball.getradius()*2, ball.getradius()*2);
		
	}
	
	public void stop()
	{
		timer.stop();
	}
	
	public void start() {
		
		timer.start();
	}
			
	public void setSpeed(int s)
	{
		speed=s;
		timer.setDelay(speed);
	}
	
	public int getSpeed()
	{
		return speed;
	}
	}
	
	

