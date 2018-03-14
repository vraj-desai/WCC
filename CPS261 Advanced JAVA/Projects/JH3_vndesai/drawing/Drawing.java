package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

enum drawType{oval, line};

class drawingProperties{
	drawType drawType;
	boolean filled;
	Color color;
	drawingProperties(drawType drawType_in, Color color_in, boolean filled_in){
		this.color = color_in;
		this.filled = filled_in;
		this.drawType = drawType_in;
	}
	
	public String toString(){
		return drawType + "color = " + color + " filled = " + filled;
	}
}

public class Drawing {

	drawingProperties drawingProperties = new drawingProperties(drawType.line, Color.cyan, false);
	ArrayList<Shape> shapeArr = new ArrayList<Shape>();
	Shape currShape = null;
	
	public String toString() {
		return drawingProperties.toString();
	}
	
	public void draw(Graphics g) {
		for(int i = 1; i < shapeArr.size(); i++) {
			Shape s = shapeArr.get(i);
			s.draw(g);
		}
		if(currShape != null) {
			currShape.draw(g);
		}
		
	}
	
	public void setColor(Color color_in) {
		drawingProperties.color = color_in;
	}
	
	public void setFilled(boolean filled_in) {
		drawingProperties.filled = filled_in;
	}
	
	public void setdrawType(drawType drawType_in) {
		drawingProperties.drawType = drawType_in;
	}
	
	public void mousePressed(Point p) {
		switch(drawingProperties.drawType) {
		case oval:
			currShape = new oval(drawingProperties.color, drawingProperties.filled);
			break;
		case line:
			currShape = new line(drawingProperties.color);
			break;
		}
		currShape.firstPoint(p);
	}
	
	public void mouseReleased(Point p) {
		currShape.followingPoint(p);
		shapeArr.add(currShape);
		currShape = null;
	}
	
	public void mouseDragged(Point p) {
		switch(drawingProperties.drawType){
		case oval:
		case line:
			currShape.followingPoint(p);
			break;
		}
	}
}

abstract class Shape{
	Color color;
	Shape(Color color_in){
		color = color_in;
	}
	
	abstract void firstPoint(Point p);
	abstract void draw(Graphics g);
	abstract void followingPoint(Point p);
}

class oval extends Shape{

	boolean filled = false;
	Point startPoint,lastPoint;
	
	oval(Color color_in, boolean filled_in) {
		super(color_in);
		lastPoint = startPoint;
		this.filled = filled_in;
	}

	@Override
	void firstPoint(Point p) {
		startPoint = p;
		lastPoint = p;
	}

	@Override
	void draw(Graphics g) {
		g.setColor(color);
		int x = Math.min(startPoint.x, lastPoint.x);
		int y = Math.min(startPoint.y, lastPoint.y);
		int width = Math.max(startPoint.x, lastPoint.x);
		int height = Math.max(startPoint.y, lastPoint.y);
		if(filled)
			g.drawOval(x, y, width, height);
		else
			g.fillOval(x, y, width, height);
	}

	@Override
	void followingPoint(Point p) {
		lastPoint = p;
	}
}

class line extends Shape{
	
	Point startPoint, endPoint;
	
	line(Color color_in) {
		super(color_in);
		endPoint = startPoint;
	}

	@Override
	void firstPoint(Point p) {
		startPoint  = p;
	}

	@Override
	void draw(Graphics g) {
		int start_x = Math.min(startPoint.x, endPoint.x);
		int start_y = Math.min(startPoint.y, endPoint.y);
		int end_x = Math.max(startPoint.x, endPoint.x);
		int end_y = Math.max(startPoint.y, endPoint.y);
		g.drawLine(start_x, start_y, end_x, end_y);
	}

	@Override
	void followingPoint(Point p) {
		endPoint = p;
	}
	
}