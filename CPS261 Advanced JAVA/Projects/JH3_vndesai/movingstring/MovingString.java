package MovingString;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class MovingString extends JFrame implements Runnable {

	private int fontSize = 35;
	boolean fontsizeIncrease = true;
	double x_vel = Math.random();
	double y_vel = Math.random();
	int leftX, rightX,upY,downY,frameWidth,frameHeight;
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
		
		Thread t = new Thread(this);
		t.start(); 
	}
	
	public void paint(Graphics g) {
		String text = "Hello";
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		g.setColor(color_generator());
		Dimension d = getSize();
		frameWidth = d.width;
		frameHeight = d.height;
		FontMetrics fm = getFontMetrics(g.getFont());
		int fontHeight = fm.getHeight();
		int maxAscent = fm.getAscent();		int fontWidth = fm.stringWidth(text);
		leftX = (d.width/2)-(fontWidth/2);
		rightX = (d.width/2)+(fontWidth/2);
		upY =  d.height/2 - maxAscent;
		downY = d.height/2 - maxAscent +fontHeight;
		g.drawString(text, (int)(leftX+x_vel) , (int)((d.height/2)+maxAscent));
		System.out.println(fontWidth);
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(100);
				if(fontSize == 20) {
					fontsizeIncrease = true;
				}
				if(leftX <= 0 || rightX >= 800 || upY <= 0 || downY >= 600) {
					x_vel *= -1;
					y_vel *= -1;
					if(fontsizeIncrease == true) {
						fontsizeIncrease = false;
					}
					repaint();
				}
				else {
					if(fontsizeIncrease) {
						fontSize++;
					}
					else {
						x_vel++;
						y_vel++;
						fontSize--;
					}
					repaint();
				}
			}
			catch(InterruptedException e) {}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingString mv= new MovingString();
	}
}
