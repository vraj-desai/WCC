import java.util.*;
import java.io.*;

public class indent{

	public static ArrayList<String> content = new ArrayList<String>();
	
    public static int lineColNum(String line){
    	for(int i = 0; i < line.length(); i++){
    		if(line.charAt(i) != ' '){
    			return i;
            }
        }
    	return -1;
    }

    public static boolean indentationChecker(String fileName) throws IOException{
        Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(fileName + " not found!");
		}
        Deque<Integer> indents = new ArrayDeque<Integer>();
        while(scan.hasNextLine()){
        	String line =  scan.nextLine();
        	content.add(line);
        	int colIdx = lineColNum(line);
            if(colIdx != -1) {
            	if(indents.peekFirst() == null) {
            		indents.addFirst(colIdx);
            	}
            	else if(colIdx >= indents.peekFirst()) {
            		indents.addFirst(colIdx);
            	}
            	else {
            		int indentPeek = indents.peekFirst();
            			while(colIdx != indentPeek) {
        					indents.removeFirst();
            				if(!indents.isEmpty()) {
                				indentPeek = indents.peekFirst();
            				}
            				else
            					return false;
            			}
            		}
            	}
            }
        return true;
    }

    public static void main(String args[]) throws IOException{
        for(int i = 0; i < args.length; i++){
        	System.out.println("\n\n********Processing file: " + args[i] + "********");
            boolean indentation = indentationChecker(args[i]);
            if(indentation){
            	System.out.println("=>" + args[i] +" is indented Properly.");
            }
            else {
            	System.out.println("=>" + args[i] +" is not indented Properly.");
            }
            for(int j = 0; j < content.size(); j++) {
            	System.out.println(content.get(j));
            }
            content.clear();
        }
    }
}