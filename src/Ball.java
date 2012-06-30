
//This class controls each ball

public class Ball {

	int radius;
	int x;
	int y;
	int color;
	
	int dx;
	int dy;
	
	public Ball()
	{
		/* Create ball with default values */
		  
		   //Variable radius
		radius = (int)(Math.random()* 100);
		
			//Center of the panel
		x = 400;  
		y = 300;
		
			//Default Color
		color=0;
		
		dx=2;
		dy=2;
		
	}
	
	public int getx()
	{
		
		System.out.println("X:"+ x);
		return x;
	}
	
	public int gety()
	{
		System.out.println("Y:" + y);
		return y;
	}
	
	public int getradius()
	{
		System.out.println("Radius: "+ radius);
		return radius;
	}
	
	public void bounce()
	{
		CheckCollision();
		x +=dx;
		y +=dy;
	}
	
	
	
	public void CheckCollision()
	{
	
	//Check for collision, if detected change directions
	
	if ( x<radius)
	{
		dx= Math.abs(dx);
	}
	if ( x> 800 - radius)
	{
		dx= -Math.abs(dx);
	}
	if (y<radius)
	{
		dy = Math.abs(dy);
	}
	if (y> 600-radius)
	{
		dy= -Math.abs(dy);
	}
	}
	
	public void setRadius(int r)
	{
		radius=r;
	}
	
	public void setColor(int c)
	{
		color=c;
	}
	
	public int getColor()
	{
		return color;
	}
	}
