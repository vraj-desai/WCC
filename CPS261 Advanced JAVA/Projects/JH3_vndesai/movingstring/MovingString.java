package movingstring;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class MovingString extends JFrame implements Runnable {

	private int fontSize = 35;
	private String text = "Hello";
	Font font = null;
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
		font = g.getFont();
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		g.setColor(color_generator());
		Dimension d = getSize();
		frameWidth = d.width;
		frameHeight = d.height;
		FontMetrics fm = getFontMetrics(font);
		int fontHeight = fm.getHeight();
		int maxAscent = fm.getAscent();
		int fontWidth = fm.stringWidth(text);
		leftX = (d.width/2)-(fontWidth/2);
		rightX = (d.width/2)-(fontWidth/2)+fontWidth;
		upY =  d.height/2 - maxAscent;
		downY = d.height/2 - maxAscent +fontHeight;
		g.drawString(text, (d.width/2)-(fontWidth/2) , (d.height/2)+maxAscent);
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(100);
				if(leftX <= 0 || rightX >= 800 || upY <= 0 || downY >= 600) {
					fontSize = 35;
					repaint();
				}
				else {
					fontSize++;
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
