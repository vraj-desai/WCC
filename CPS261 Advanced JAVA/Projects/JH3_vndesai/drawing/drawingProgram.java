package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.JFrame;

public class drawingProgram extends JFrame{

	Drawing drawing = new Drawing();
	
	class MyMouseHandler extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			drawing.mousePressed(e.getPoint());
			repaint();
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
		
		MyMouseHandler mmh = new MyMouseHandler();
		addMouseListener(mmh);
		addMouseMotionListener(mmh);
		
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		Dimension dimen = getSize();
		Insets insets = getInsets();
		int top = insets.top;
		int left = insets.left;
		g.setColor(Color.WHITE);
		g.fillRect(0,0,dimen.width,dimen.height);
		drawing.draw(g);
		String str = drawing.toString();
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
			System.out.println("Exiting Program");
			dp.dispose() ;
			keyboard.close();
		}
	}

}
