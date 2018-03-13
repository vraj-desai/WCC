package MovingString;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.util.Random;

import javax.swing.JFrame;

public class MovingString extends JFrame implements Runnable {

	static private int fontSize = 90;
	static boolean fontsizeIncrease = true;
	static double x_vel,y_vel;
	static Point UpperRight, UpperLeft, LowerLeft, LowerRight, StartingPoint;
	int StringWidth, StringHeight, StringAscent;
	private Color color_generator() {
		Random r = new Random();
		Color color = new Color(r.nextFloat(),r.nextFloat(), r.nextFloat());
		return color;
	}
	
	public MovingString() {
		
		super("Moving String");
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//update points of the frame
		Insets insets = getInsets();
		Dimension d = getSize();
		UpperRight = new Point(d.width - insets.right,insets.top);
		UpperLeft = new Point(insets.left,insets.top);
		LowerLeft = new Point(insets.left, d.height - insets.bottom);
		LowerRight = new Point(d.width-insets.right, d.height-insets.bottom);
		x_vel = (-10 + (int)(20*Math.random()));
		y_vel = -10 + (int)(20*Math.random());
		
		//Thread
		Thread t = new Thread(this);
		setResizable(false);
		t.start(); 
	}
	
	public void update() {
		//Update fontsize and positioning
		StartingPoint.x += x_vel;
		StartingPoint.y += y_vel;
		
		if(fontsizeIncrease) {
			fontSize++;
		}
		else {
			fontSize--;
		}
		if(fontSize < 90) {
			fontsizeIncrease = true;
			fontSize = 90;
		}
		
		if(StartingPoint.x + StringWidth > UpperRight.x) {
			x_vel *= -1;
			StartingPoint.x = UpperRight.x - StringWidth;
			if(fontsizeIncrease == true) {
				fontsizeIncrease = false;
			}
			else
				fontsizeIncrease = true;
		}
		
		if(StartingPoint.x < UpperLeft.x) {
			x_vel *= -1;
			StartingPoint.x = UpperLeft.x;
			if(fontsizeIncrease == true) {
				fontsizeIncrease = false;
			}
			else
				fontsizeIncrease = true;
		}
		
		if(StartingPoint.y - StringAscent < UpperLeft.y) {
			y_vel *= -1;
			StartingPoint.y = UpperLeft.y;
			if(fontsizeIncrease == true) {
				fontsizeIncrease = false;
			}
			else
				fontsizeIncrease = true;
		}
		
		if(StartingPoint.y + (StringHeight-StringAscent) > LowerLeft.y) {
			y_vel *= -1;
			StartingPoint.y = LowerLeft.y;
			if(fontsizeIncrease == true) {
				fontsizeIncrease = false;
			}
			else
				fontsizeIncrease = true;
		}
	}
	
	public void paint(Graphics g) {
		
		//Setting Up the Font
		String text = "Vraj";
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		g.setColor(color_generator());
		StringHeight = g.getFontMetrics().getHeight();
		StringAscent = g.getFontMetrics().getAscent();
		StringWidth = g.getFontMetrics().stringWidth(text);
		
		//Update StartPoint for First Time
		StartingPoint = new Point((UpperRight.x-StringWidth)/2, LowerLeft.y/2);
		g.drawString(text, StartingPoint.x, StartingPoint.y);
		update();
	}
	

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
				repaint();
			}
			catch(InterruptedException e) {}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingString mv= new MovingString();
	}
}
