package MovingString;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.util.Random;

import javax.swing.JFrame;

public class MovingString extends JFrame implements Runnable {

	static private int fontSize = 90;
	static boolean fontsizeIncrease = true;
	static double x_vel,y_vel;
	static Point CurrPoint;
	int StringWidth, StringHeight, StringAscent;
	Insets ScreenInsets = null;
	Image OffScreenImage = null;
	Dimension ScreenDimen = null;
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
		ScreenInsets = getInsets();
		x_vel = (-10 + (int)(20*Math.random()));
		y_vel = -10 + (int)(20*Math.random());
		
		//Thread
		Thread t = new Thread(this);
		setResizable(false);
		t.start(); 
	}
	
	public void update() {
		//Update fontsize and positioning
		CurrPoint.x += x_vel;
		CurrPoint.y += y_vel;
		
		
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
		
		if(CurrPoint.x + StringWidth > ScreenDimen.width-ScreenInsets.right) {
			x_vel *= -1;
			CurrPoint.x = ScreenInsets.right - StringWidth;	
			if(fontsizeIncrease == true) {
				fontsizeIncrease = false;
			}
			else
				fontsizeIncrease = true;
		}
		
		if(CurrPoint.x < ScreenInsets.left) {
			x_vel *= -1;
			CurrPoint.x = ScreenInsets.left;
			if(fontsizeIncrease == true) {
				fontsizeIncrease = false;
			}
			else
				fontsizeIncrease = true;
		}
		
		if(CurrPoint.y - StringAscent < ScreenInsets.top) {
			y_vel *= -1;
			CurrPoint.y = ScreenInsets.top;
			if(fontsizeIncrease == true) {
				fontsizeIncrease = false;
			}
			else
				fontsizeIncrease = true;
		}
		
		if(CurrPoint.y + (StringHeight - StringAscent) > ScreenInsets.bottom) {
			y_vel *= -1;
			CurrPoint.y = ScreenInsets.bottom;
			if(fontsizeIncrease == true) {
				fontsizeIncrease = false;
			}
			else
				fontsizeIncrease = true;
		}
	}
	boolean temp = true; 
	public void paint(Graphics screen) {
		
		Dimension dimen = this.getSize();
		
		if(OffScreenImage != null || !dimen.equals(ScreenDimen)) {
			ScreenDimen = dimen;
			OffScreenImage = createImage(dimen.width, dimen.height);
		}
		Graphics g = OffScreenImage.getGraphics();
		//Setting Up the Font
		String text = "Vraj";
		/*g.setColor(Color.WHITE);
		g.fillRect(ScreenInsets.left, ScreenInsets.top, ScreenDimen.width - ScreenInsets.right, ScreenDimen.height - ScreenInsets.bottom);
		*/g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		g.setColor(color_generator());
		StringHeight = g.getFontMetrics().getHeight();
		StringAscent = g.getFontMetrics().getAscent();
		StringWidth = g.getFontMetrics().stringWidth(text);
		
		//Update StartPoint for First Time
		if(temp) {
			CurrPoint = new Point((ScreenDimen.width-StringWidth)/2, (ScreenDimen.height/2)-StringAscent);
			temp = false;
		}
		
		g.drawString(text, CurrPoint.x, CurrPoint.y);
		screen.drawImage(OffScreenImage, 0, 0, this);
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
