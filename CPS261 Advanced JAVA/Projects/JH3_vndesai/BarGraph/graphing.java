package BarGraph;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

class GBar{
	String name;
	int value;
	GBar(String nameIn, int valIn){
		name = nameIn;
		value = valIn;
	}
}

public class graphing extends JFrame {

	ArrayList<GBar> graphData = new ArrayList<GBar>();
	graphing(String GraphTitleIn ,ArrayList<GBar> GraphDataIn){
		super(GraphTitleIn);
		
		graphData = GraphDataIn;
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	//returns max width of the names in GraphDataIn
	int getMaxTextWidth(ArrayList<GBar> GraphDataIn, FontMetrics fm){
		int MaxWidth = 0;
		for(int i = 0; i < GraphDataIn.size(); i++) {
			int width = fm.stringWidth(GraphDataIn.get(i).name);
			if(width > MaxWidth) {
				MaxWidth = width;
			}
		}
		return MaxWidth;
	}
	
	//returns max bar value of the names in GraphDataIn
	int getMaxBarValue(ArrayList<GBar> GraphDataIn) {
		int MaxVal = 0;
		for(int i = 0; i < GraphDataIn.size(); i++) {
			int val = GraphDataIn.get(i).value;
			if(val > MaxVal) {
				MaxVal = val;
			}
		}
		return MaxVal;
	}
	
	public void paint(Graphics2D g) {
		super.paint(g);
		Dimension d = getSize();
		Insets insets = getInsets();
		int top = insets.top;
		int left = insets.left;
		int right = insets.right;
		int bottom = insets.bottom;
		int graphBorder = 10;
		
		//set color to red
		Color color = Color.RED;
		g.setColor(color);
		
		//Draw red rectangle with 10 pixel width
		Stroke oldStroke = g.getStroke();
		g.setStroke(new BasicStroke(graphBorder));
		g.drawRect(top, left, right, bottom);
		g.setStroke(oldStroke);
		
		//set color to black
		color = Color.BLACK;
		g.setColor(color);
		
		//Font settings
		Font font = g.getFont();
		FontMetrics fm = getFontMetrics(font);
		int fontHeight = fm.getHeight();
		int maxAscent = fm.getAscent();
		
		//String and bar positioning
		int strMaxWidth = left + graphBorder + getMaxTextWidth(graphData, fm);
		int x_bar_start = strMaxWidth + 1;
		
		int barMaxVal = getMaxBarValue(graphData);
		double scale = (d.width - x_bar_start - right - graphBorder) / (double)barMaxVal;
		
		int y_start = top + graphBorder;
		int barHeight = fontHeight;
		
		for(int i = 0; i < graphData.size(); i++) {
			String text = graphData.get(i).name;
			int textWidth = fm.stringWidth(text);
			int val = graphData.get(i).value;
			int scaledVal = (int)(val*scale);
			//draw string
			g.drawString(text, strMaxWidth - textWidth, y_start + maxAscent);
			
			//set color to green
			color = Color.GREEN;
			g.setColor(color);
			
			//draw green Rectangle
			g.fillRect(x_bar_start, y_start, scaledVal, barHeight);
			
			//set color to black
			color = Color.BLACK;
			g.setColor(color);
			
			//update y_start
			y_start += fontHeight + 10;
		}
		//Draw line seperating the names and bars
		g.drawLine(strMaxWidth, top + graphBorder, strMaxWidth, d.height - graphBorder);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		for(int i = 0; i < args.length; i++) {
			Scanner fileContent = new Scanner(new File(args[i]));

			//this arraylist will hold data from current file in form of GBars
			ArrayList<GBar> currGraphData = new ArrayList<GBar>();
			
			//Title of the Graph
			String graphTitle = fileContent.nextLine();
			
			//Reading data from file and adding that to the arrayList
			while(fileContent.hasNextLine()) {
				String data = fileContent.nextLine();
				String[] splitData = data.split(";");
				String currVal = splitData[1].substring(1);
				GBar currData = new GBar(splitData[0], Integer.parseInt(currVal));
				currGraphData.add(currData);
			}
			if(fileContent != null) {
				fileContent.close();
			}
			graphing graph = new graphing(graphTitle, currGraphData);
		}
	}
}
