import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Bouncing_Balls extends JFrame {
	
	
	JButton start= new JButton("Start");
	BallPanel ballpanel=new BallPanel();
	String[] colors= {"blue", "gray", "green", "magenta", "red"};
	JPanel ballcontrol= new JPanel();

	
	
	public static void main(String[] args) {
		
		//Display the frame for the bouncing balls
		
		Bouncing_Balls frame=new Bouncing_Balls();
		frame.setSize(800,600);
		frame.setTitle("Bouncing Balls");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	
	public Bouncing_Balls()
	{
		//Create a "panel" on top of the "frame"
		setLayout(new BorderLayout());	
		ballpanel.setBackground(Color.BLACK); // black background so it is easier to see the ball
		add(ballpanel, BorderLayout.CENTER);
		
		// A button on the bottom in order to start the animation
		add(start, BorderLayout.SOUTH);
		start.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ballpanel.start();
					}
				});
		
		
		//3 drop down list to control ball speed, color, and radius
		
		
		ballcontrol.setLayout(new FlowLayout());
		
		final JComboBox fillcolor= new JComboBox(colors);
		fillcolor.setSelectedIndex(ballpanel.ball.getColor());
		
		ballcontrol.add(new JLabel("Ball Color"));
		ballcontrol.add(fillcolor);
		fillcolor.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				ballpanel.ball.setColor(fillcolor.getSelectedIndex());
			}
		});
		
		
		
		final JScrollBar setspeed = new JScrollBar(JScrollBar.HORIZONTAL);
		setspeed.setValue(ballpanel.getSpeed());
		setspeed.setMaximum(50);
		setspeed.setMinimum(0);
		
		setspeed.addAdjustmentListener(new AdjustmentListener() {
				
			public void adjustmentValueChanged(AdjustmentEvent e) {
				
				ballpanel.setSpeed(setspeed.getValue());
			}

		});
		
		ballcontrol.add(new JLabel("Speed:"));
		ballcontrol.add(setspeed);
		
		
		final JScrollBar setradius = new JScrollBar(JScrollBar.HORIZONTAL);
		setradius.setMaximum(500);
		setradius.setMinimum(1);
		setradius.setValue(ballpanel.ball.getradius()); // Default radius
		
		setradius.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				
				ballpanel.ball.setRadius(setradius.getValue());
			}
		});
		
		ballcontrol.add(new JLabel("Radius: "));
		ballcontrol.add(setradius);
		
		add(ballcontrol, BorderLayout.NORTH);
	}
}
		
		
		
	
