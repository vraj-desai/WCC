package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.JFrame;

public class drawingProgram extends JFrame{

	Drawing drawing = new Drawing();
	Image offScreenImage = null;
	Dimension screenDimension = null;
	
	class MyMouseHandler extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			drawing.mousePressed(e.getPoint());
		}
		
		public void mouseReleased(MouseEvent e) {
			drawing.mouseReleased(e.getPoint());
			repaint();
		}
		
		public void mouseDragged(MouseEvent e) {
			drawing.mouseDragged(e.getPoint());
			repaint();
		}
	}
	
	
	drawingProgram(){
		super("Drawing Program");
		setSize(800, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		MyMouseHandler mmh = new MyMouseHandler();
		addMouseListener(mmh);
		addMouseMotionListener(mmh);
		
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		Dimension dimen = getSize();
		
		if(offScreenImage != null || !dimen.equals(screenDimension)) {
			screenDimension = dimen;
			offScreenImage = createImage(dimen.width, dimen.height);
		}
		Graphics screen = offScreenImage.getGraphics();
		Insets insets = getInsets();
		int top = insets.top;
		int left = insets.left;
		
		screen.setColor(Color.WHITE);
		screen.fillRect(0,0,dimen.width,dimen.height);
		drawing.draw(screen);
		//Printing Info at the Top
		String str = drawing.toString();
		screen.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		int FontHeight = screen.getFontMetrics().getHeight();
		int FontAscent = screen.getFontMetrics().getAscent();
		screen.setColor(Color.YELLOW);
		screen.fillRect(0+left, 0+top, 800, FontHeight);
		screen.setColor(Color.BLACK);
		screen.drawString(str, 0+left, 0+top+FontAscent);
		g.drawImage(offScreenImage, 0, 0, this);
	}
	
	public static void main(String[] args) {

		drawingProgram dp = new drawingProgram();
		Scanner keyboard = new Scanner(System.in);
		boolean continueFlag = true;
		while(continueFlag) {
			System.out.println("Cmds: o,l,q,f,?,d,b,m,g");
			String str = keyboard.next().toLowerCase();
			if(str.length() == 0) continue;
			
			switch(str.charAt(0)) {
			case 'o':
				dp.drawing.setdrawType(drawType.oval);
				break;
			case 'l':
				dp.drawing.setdrawType(drawType.line);
				break;
			case 'q':
				continueFlag = false;
				break;
			case 'f':
				dp.drawing.setFilled(true);
				break;
			case 'd':
				dp.drawing.setFilled(false);
				break;
			case 'b':
				dp.drawing.setColor(Color.blue);
				break;
			case 'm':
				dp.drawing.setColor(Color.magenta);
				break;
			case 'g':
				dp.drawing.setColor(Color.GREEN);
				break;
			default:
				System.out.println("o - drawType = oval");
				System.out.println("l - drawType = line");
				System.out.println("q - quit");
				System.out.println("f - filled Objects");
				System.out.println("d - unfilled objects");
				System.out.println("b - blue color objects");
				System.out.println("m - magenta color objects");
				System.out.println("g - green color objects");
				break;
			}
		}
		System.out.println("Exiting Program");
		dp.dispose() ;
		keyboard.close();
	}

}
