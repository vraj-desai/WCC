package BarGraph;

import java.awt.*;
import java.io.*;
import java.util.*;

public class graphing {
	
	private static int arg;

	static public class GBar{
		String name;
		int value;
		GBar(String nameIn, int valIn){
			name = nameIn;
			value = valIn;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		for(int i = 0; i < args.length; i++) {
			//stream and scanner
			FileInputStream inFile = new FileInputStream(args[i]);
			Scanner fileContent = new Scanner(inFile);

			//this arraylist will hold data from current file in form of GBars
			ArrayList<GBar> graphData = new ArrayList<GBar>();
			String graphTitle = fileContent.nextLine();
			
			//Reading data from file and adding that to the arrayList
			while(fileContent.hasNextLine()) {
				String data = fileContent.nextLine();
				String[] splitData = data.split(";");
				GBar currData = new GBar(splitData[0], Integer.parseInt(splitData[1]));
				graphData.add(currData);
			}
			
		}
		arg = args.length;
	}
}
