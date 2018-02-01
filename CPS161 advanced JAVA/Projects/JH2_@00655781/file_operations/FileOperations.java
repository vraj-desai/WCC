package file_operations;
import java.io.*;
import java.util.*;

public class FileOperations {
	StringTokenizer parseCommand;
	File currFile;
	
	public void delete(){
		//		code for handling the delete command
		//		Make sure you check the return code from the
		//		File delete method to print out success/failure status
		File deleteFile = null;
		String fileName = getNextToken();
		if(fileName == null)
			System.out.println("[No input given for Filename!]");
		else {
			deleteFile = new File(fileName);
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
			else {
				System.out.println("[ " + fileName + " does not exist!]");
			}
		}
	}
	
	public void rename(){
		//		code for handling the rename command
		//		Make sure you check the return code from the
		//		File rename method to print out success/failure status
	}

	public void list(){
		// code for handling the list command
	}
	
	public void size(){
		// code for handling the size command
	}
	
	public void lastModified(){
		// code for handling the lastModified command
	}
	
	public void mkdir(String line){
		//		code for handling the mkdir command
		//		Make sure you check the return code from the
		//File mkdir method to print out success/failure status
		String dirName = parseCommand.nextToken();
		File dir = new File(dirName);
	}
	
	public void createFile(String line){
		// code for handling the createFile command
		String fileName = null;
		try {
			fileName = parseCommand.nextToken();
			File newFile = new File(fileName);
			FileOutputStream outstream = new FileOutputStream(fileName);
			PrintStream print = new PrintStream(outstream);
			while(parseCommand.hasMoreTokens()) {
				String writeData = parseCommand.nextToken();
				print.println(writeData);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("You are trying to create an outputstream to nonexisting file named :" + fileName);
		}
	}

	public void printFile(String line){
		// code for handling the printFile command
		String fileName = parseCommand.nextToken();
		FileInputStream readFile = null;
		Scanner scanFile = null;
		String outFileName = null;
		if(parseCommand.hasMoreTokens()) {
			outFileName = parseCommand.nextToken();
		}
		else {
			System.out.println("No output file name given!");
			return;
		}
		File newFile = new File(outFileName);
		FileOutputStream outStream = null;
		PrintStream print = null;
				
		try {
			readFile = new FileInputStream(fileName);
			scanFile = new Scanner(readFile);
			outStream = new FileOutputStream(outFileName);
			print = new PrintStream(outStream);
			while(scanFile.hasNext()) {
				print.println(scanFile.next());
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Tring to print non existing file named: " + fileName);
			
		}
	}

	void printUsage(){
		// process the "?" command
	}

	//		useful private routine for getting next string on the command line
	private String getNextToken(){
		if (parseCommand.hasMoreTokens()) 
			return parseCommand.nextToken();
		else
			return null;
	}

	//useful private routine for getting a File class from the next string on the command line
	private File getFile(){
		File f = null;
		String fileName = getNextToken();
		if (fileName == null)
			System.out.println("Missing a File name");
		else
			f = new File(fileName);
		return f;
	}
	
	private void printhelpcmd() {
		System.out.print("?\ndelete filename\nrename oldFilename newFilename\nsize filename\nlastModified filename\nlist dir\nprintFile filename\ncreateFile filename\nmkdir dir\nquit");
	}
	
	public boolean processCommandLine(String line){
		//		if line is not null, then setup the parseCommand StringTokenizer. Pull off the first string
		//		using getNextToken() and treat it as the "command" to be processed.
		//		It would be good to print out the command you are processing to make your output more readable.
		//		If you are using at least java 1.7, you can use a switch statement on command.
		//		Otherwise, resort to if-then-else logic. Call the appropriate routine to process the requested command:
		//		i.e. delete, rename, mkdir list, etc.
		//		return false if command is quit or the line is null, otherwise return true.
		if(line != null) {
			String cmd = getNextToken();
			switch(cmd) {
			case("?"):{
				System.out.println("Processing: ?");
				break;
			}
						
			case("createFile"):{
				System.out.println("Processing: createFile");
				break;
			}
			
			case("printFile"):{
				System.out.println("Processing: printFile");
				break;
			}
			
			case("lastModified"):{
				System.out.println("Processing: lastModified");
				break;
			}
			
			case("size"):{
				System.out.println("Processing: size");
				break;
			}
			
			case("rename"):{
				System.out.println("Processing: rename");
				break;
			}
			
			case("mkdir"):{
				System.out.println("Processing: mkdir");
				mkdir(line);
				break;
			}
			
			case("delete"):{
				System.out.println("Processing: delete");
				break;
			}
			
			case("list"):{
				System.out.println("Processing: list");
				break;
			}
			
			case("quit"):{
				System.out.println("Processing: quit");
				break;
			}
			
			default:{
				System.out.println("[Invalid Command! Try again!]");
				break;
			}
			}
			return true;
		}
		else
			return false;
	}

	void processCommandFile(String commandFile) throws FileNotFoundException{
		//		Open up a scanner based on the commandFile file name. Read the commands from this file
		//		using the Scanner line by line. For each line read, call processCommandLine. Continue reading
		//		from this file as long as processCommandLine returns true and there are more lines in the file.
		//		At the end, close the Scanner.
		FileInputStream cmds = null;
		Scanner scan = null;
		try {
			cmds = new FileInputStream(commandFile);
			scan = new Scanner(cmds);
			String lineIn = null;
			while(scan.hasNextLine()) {
				lineIn = scan.nextLine();
				parseCommand = new StringTokenizer(lineIn);
				processCommandLine(lineIn);
				parseCommand = null;
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Could not find file named: " + commandFile);
		}
		if(cmds != null) {
			//cmds.close();
		}
		if(scan != null) {
			scan.close();
		}
	}

	/*public static void main(String[] args){
		FileOperations fo= new FileOperations(); 
		for (int i=0; i < args.length; i++) {
			System.out.println("\n\n============ Processing " + args[i] +" =======================\n");
			fo.processCommandFile(args[i]);
		}
		System.out.println("Done with FileOperations");
	}*/
}
