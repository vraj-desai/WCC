import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class Reading_With_Exceptions {

	static void process(String inputFilename) {
		
		try{
			//variables
			String outputFilename = null;
			int numbers_to_read = -1;
			
			//Process
			File input = new File(inputFilename);
			Scanner reader = new Scanner(input);
			if(reader.hasNext())
				outputFilename = reader.next();
			else
				System.out.println("Invalid File Format");
			PrintStream out = new PrintStream(new File (outputFilename));
			while(reader.hasNextInt())
				numbers_to_read = reader.nextInt();
			if(numbers_to_read < 0) {
				System.out.println("Invalid number given as the number of reading ints.");
			}
			copyNumbers(reader, out, numbers_to_read);
			printToScreen(outputFilename);
			out.close();
		}
		catch(FileNotFoundException e) {
			System.out.println( inputFilename + " does not exist in the given path.");
		}
	}
	
	static void copyNumbers(Scanner reader, PrintStream out, int num_int) {
		while(reader.hasNextInt()) {
			out.print(reader.next());
		}
		reader.close();
	}
	
	static void printToScreen(String filename){
	Scanner scan = null;
		try {
			FileInputStream fis = new FileInputStream(filename);
			scan = new Scanner(fis);
			while (scan.hasNextLine()){
				System.out.println(scan.nextLine());
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("printToScreen: can't open: " + filename);
		}
		finally
		{
			if (scan != null)
				scan.close();
		}
	}// end of printToScreen
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < args.length; i++) {
			System.out.println("Processing " + args[i] + "...");
			process(args[i]);
		}
	}

}
