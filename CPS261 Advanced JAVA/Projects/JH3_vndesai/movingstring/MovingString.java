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

	static boolean temp = true; 
	static private int fontSize = 90;
	static boolean fontsizeIncrease = true;
	static double x_vel,y_vel;
	static Point CurrPoint;
	static int StringWidth, StringHeight, StringAscent;
	static Insets ScreenInsets = null;
	static Image OffScreenImage = null;
	static Dimension ScreenDimen = null;
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
		setResizable(false);
		
		//update points of the frame
		ScreenInsets = getInsets();
		x_vel = (int)(-10 + (int)(20*Math.random()));
		y_vel = (int)(-10 + (int)(20*Math.random()));
		
		//Thread
		Thread t = new Thread(this);
		t.start(); 
	}
	
	public void update() {
		//Update fontsize and positioning
		CurrPoint.x += x_vel;
		CurrPoint.y += y_vel;
		
		
		if(this.fontsizeIncrease) {
			this.fontSize++;
		}
		else {
			this.fontSize--;
		}
		if(this.fontSize < 90) {
			this.fontsizeIncrease = true;
			this.fontSize = 90;
		}
		
		if(this.CurrPoint.x + this.StringWidth > this.ScreenDimen.width-this.ScreenInsets.right) {
			this.x_vel *= -1;
			this.CurrPoint.x = this.ScreenInsets.right - this.StringWidth;	
			if(this.fontsizeIncrease == true) {
				this.fontsizeIncrease = false;
			}
			else
				this.fontsizeIncrease = true;
		}
		
		if(this.CurrPoint.x < this.ScreenInsets.left) {
			this.x_vel *= -1;
			this.CurrPoint.x = this.ScreenInsets.left;
			if(this.fontsizeIncrease == true) {
				this.fontsizeIncrease = false;
			}
			else
				this.fontsizeIncrease = true;
		}
		
		if(CurrPoint.y - StringAscent < ScreenInsets.top) {
			this.y_vel *= -1;
			this.CurrPoint.y = this.ScreenInsets.top;
			if(this.fontsizeIncrease == true) {
				this.fontsizeIncrease = false;
			}
			else
				this.fontsizeIncrease = true;
		}
		
		if(this.CurrPoint.y + (this.StringHeight - this.StringAscent) > this.ScreenInsets.bottom) {
			this.y_vel *= -1;
			this.CurrPoint.y = this.ScreenInsets.bottom;
			if(this.fontsizeIncrease == true) {
				this.fontsizeIncrease = false;
			}
			else
				this.fontsizeIncrease = true;
		}
	}
	public void paint(Graphics screen) {
		
		Dimension dimen = this.getSize();
		
		if(this.OffScreenImage != null || !dimen.equals(ScreenDimen)) {
			this.ScreenDimen = dimen;
			this.OffScreenImage = createImage(dimen.width, dimen.height);
		}
		Graphics g = OffScreenImage.getGraphics();
		//Setting Up the Font
		String text = "Vraj";
		/*g.setColor(Color.WHITE);
		g.fillRect(ScreenInsets.left, ScreenInsets.top, ScreenDimen.width - ScreenInsets.right, ScreenDimen.height - ScreenInsets.bottom);
		*/g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		g.setColor(color_generator());
		this.StringHeight = g.getFontMetrics().getHeight();
		this.StringAscent = g.getFontMetrics().getAscent();
		this.StringWidth = g.getFontMetrics().stringWidth(text);
		
		//Update StartPoint for First Time
		if(this.temp) {
			this.CurrPoint = new Point((this.ScreenDimen.width-this.StringWidth)/2, (this.ScreenDimen.height/2)-this.StringAscent);
			this.temp = false;
		}
		
		g.drawString(text, CurrPoint.x, CurrPoint.y);
		screen.drawImage(OffScreenImage, 0, 0, this);
	}
	

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
				this.repaint();
				this.update();
			}
			catch(InterruptedException e) {}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingString mv= new MovingString();
	}
}
