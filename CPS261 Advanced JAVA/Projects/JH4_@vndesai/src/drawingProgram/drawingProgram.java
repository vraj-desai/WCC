package drawingProgram;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class drawingProgram extends JFrame implements ActionListener{

	Drawing drawing = new Drawing();
	Image offScreenImage = null;
	Dimension screenDimension = null;
	Checkbox filled, rectangle, oval, line, scribble, red, green, blue;
	
	
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
	
	boolean getFilledVal() {
		return filled.getState();
	}
	
	drawingProgram(){
		super("Drawing Program");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		//Mouse Handler
		MyMouseHandler mmh = new MyMouseHandler();
		addMouseListener(mmh);
		addMouseMotionListener(mmh);
		
		//Adding Panels
		setLayout(new BorderLayout());
		
		//Select Shape Panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.setBackground(Color.LIGHT_GRAY);
		JPanel shapePanel = new JPanel();
		shapePanel.setLayout(new FlowLayout());
		
		filled = new Checkbox("filled", true);
		CheckboxGroup shapeGroup = new CheckboxGroup();
		rectangle = new Checkbox("Rectangle", shapeGroup, true);
		oval = new Checkbox("Oval", shapeGroup, false);
		line = new Checkbox("Line", shapeGroup, false);
		scribble = new Checkbox("Scribble", shapeGroup, false);
		
		shapePanel.add(rectangle);
		shapePanel.add(oval);
		shapePanel.add(line);
		shapePanel.add(scribble);
		
		topPanel.add(filled);
		topPanel.add(shapePanel);
		
		add(topPanel, BorderLayout.NORTH);
		
		//Color Panel
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new BorderLayout());
		colorPanel.setBackground(Color.LIGHT_GRAY);
				
		CheckboxGroup Color_CheckboxGroup = new CheckboxGroup();
		red = new Checkbox("RED", Color_CheckboxGroup, true);
		green = new Checkbox("GREEN", Color_CheckboxGroup, false);
		blue = new Checkbox("BLUE", Color_CheckboxGroup, false);
				
		colorPanel.add(red, BorderLayout.NORTH);
		colorPanel.add(green, BorderLayout.CENTER);
		colorPanel.add(blue, BorderLayout.SOUTH);
				
		add(colorPanel, BorderLayout.WEST);
		
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
		g.drawImage(offScreenImage, 0, 0, this);
	}
	
	public static void main(String[] args) {
		drawingProgram dp = new drawingProgram();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		switch(str) {
		
		case "Oval":
			drawing.setdrawType(drawType.oval);
			break;
		case "Line":
			drawing.setdrawType(drawType.line);
			break;
		case "filled":
			if(this.getFilledVal())
				drawing.setFilled(true);
			else
				drawing.setFilled(false);
			break;
		case "blue":
			drawing.setColor(Color.BLUE);
			break;
		case "red":
			drawing.setColor(Color.RED);
			break;
		case "green":
			drawing.setColor(Color.GREEN);
			break;
		default:
			break;
		}
	}
}
