package file_operations;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;





public class FileOperations {
	StringTokenizer parseCommand;
	
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
            
         
           File oldFile=null;
           String s=null; 
           if (parseCommand.hasMoreTokens())
             s= parseCommand.nextToken();
        else
            s=null;
		 oldFile = new File(s);
                 
		if(oldFile!=null){
                    
            System.out.println("renaming "+ oldFile.getAbsolutePath());
            
         
			
            boolean isFileRenamed = oldFile.renameTo(new File(parseCommand.nextToken()));
        //    System.out.println("hi"+isFileRenamed);
            if(isFileRenamed)
				System.out.println("File renamed successfully!");
			else
				System.out.println("File rename unsuccessful!");
		}
		else {
			System.out.println("The old file does not exist!");
		}
	}

	public void list(){
		// code for handling the list command
           
           String dirName=null; 
           if (parseCommand.hasMoreTokens())
             dirName= parseCommand.nextToken();
        else
            dirName=null;
		
		//dirName = parseCommand.nextToken();
		File dir = new File(dirName);
		if(dir!=null) {
			File[] dirFiles = dir.listFiles();
			for(File currFile : dirFiles){
				if(currFile.isFile()) {
					System.out.println(currFile.getName());
				}
			}
		}
		else {
			System.out.println("Directory to get file does not exist!");
		}
	}
	
	public void size(){
		// code for handling the size command
		String fileName = parseCommand.nextToken();
		File inFile = new File(fileName);
		if(inFile.exists()) {
			System.out.println(inFile.length());
		}
		else {
			System.out.println("File with a given name for a size is invalid!");
		}
	}
	
	public void lastModified(){
		// code for handling the lastModified command
		String fileName = parseCommand.nextToken();
		File inFile = new File(fileName);
		if(inFile.exists()) {
			long lastDate = inFile.lastModified();
			System.out.println(lastDate);
		}
		else {
			System.out.println("File to check the lastmodified date with given name does not exist!");
		}
	}
	
	public void mkdir(){
		//		code for handling the mkdir command
		//		Make sure you check the return code from the
		//File mkdir method to print out success/failure status
		String dirName = parseCommand.nextToken();
		File newDir = new File(dirName);
		if(!newDir.exists()) {
			boolean result = newDir.mkdirs();
			if(result == true) {
				System.out.println("new directory with " + dirName + " created successfully!");
			}
			else {
				System.out.println("Could not create new directory!");
			}
		}
		else {
			System.out.println("Directory with given name already exists!");
		}
	}
	
	public void createFile(){
		// code for handling the createFile command
           /* File f = getFile();
        if (f!= null)
        {
            try {
                PrintWriter pw = new PrintWriter(f);
                String token = getNextToken();
                while (token != null)
                {
                    pw.println(token);
                    token = getNextToken();
                }
                pw.close();
                System.out.println("created file for "+ f.getAbsolutePath());
            } catch (FileNotFoundException e) {
                System.out.println("createFile can't create: "+ f.getAbsolutePath());
            }
        }*/
		String fileName = null;
		PrintWriter print = null;
		//FileOutputStream outstream = null;
		try {
			fileName = parseCommand.nextToken();
			//outstream = new PrintWriter(fileName);
			print = new PrintWriter(fileName);
			while(parseCommand.hasMoreTokens()) {
				String writeData = parseCommand.nextToken();
				print.println(writeData);
			}
			System.out.println("New file created and data written successfully!");
			
		}
		catch(FileNotFoundException e) {
			System.out.println("You are trying to create an outputstream to nonexisting file named :" + fileName);
		}
		finally {
			if(print != null) {
				print.close();
			}
			
			}
		}
	

	public void printFile(){
		// code for handling the printFile command
		/*while(parseCommand.hasMoreTokens()) {
			String fileName = parseCommand.nextToken();
			FileInputStream readFile = null;
			Scanner scanFile = null;
			try {
				readFile = new FileInputStream(fileName);
				scanFile = new Scanner(readFile);
				while(scanFile.hasNext()) {
					System.out.println(scanFile.next());
				}
			}
			catch(FileNotFoundException e) {
				System.out.println("Tring to print non existing file named: " + fileName);
				
			}
		}*/
            File f = getFile();
        if (f != null)
        {
            try {
                Scanner scan = new Scanner(f);
                while (scan.hasNextLine())
                {
                    System.out.println(scan.nextLine());
                }
                scan.close();
                System.out.println("printed file for "+ f.getAbsolutePath());
            } catch (FileNotFoundException e) {
                System.out.println("printFile can't open: "+ f.getAbsolutePath());
            }
        }
	}

	void printUsage(){
		// process the "?" command
		System.out.print("?\ndelete filename\nrename oldFilename newFilename\nsize filename\nlastModified filename\nlist dir\nprintFile filename\ncreateFile filename\nmkdir dir\nquit");
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
				System.out.println("=========================Processing: ?=========================");
				printUsage();
				break;
			}
						
			case("createFile"):{
				System.out.println("=========================Processing: createFile=========================");
				createFile();
				break;
			}
			
			case("printFile"):{
				System.out.println("=========================Processing: printFile=========================");
				printFile();
				break;
			}
			
			case("lastModified"):{
				System.out.println("=========================Processing: lastModified=========================");
				lastModified();
				break;
			}
			
			case("size"):{
				System.out.println("=========================Processing: size=========================");
				size();
				break;
			}
			
			case("rename"):{
				System.out.println("=========================Processing: rename=========================");
				rename();
				break;
			}
			
			case("mkdir"):{
				System.out.println("=========================Processing: mkdir=========================");
				mkdir();
				break;
			}
			
			case("delete"):{
				System.out.println("=========================Processing: delete=========================");
				delete();
				break;
			}
			
			case("list"):{
				System.out.println("=========================Processing: list=========================");
				list();
				break;
			}
			
			case("quit"):{
				System.out.println("=========================Processing: quit=========================\n Done with commandFile!");
				break;
			}
			
			default:{
				System.out.println("=========================[Invalid Command! Try again!]=========================");
				break;
			}
			}
			return true;
		}
		else
			return false;
	}

	void processCommandFile(String commandFile) {
		//		Open up a scanner based on the commandFile file name. Read the commands from this file
		//		using the Scanner line by line. For each line read, call processCommandLine. Continue reading
		//		from this file as long as processCommandLine returns true and there are more lines in the file.
		//		At the end, close the Scanner.
		File cmds = null;
		Scanner scan = null;
		try {
			cmds = new File(commandFile);
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
/*public static void main(String[] args)   {
        String files[]={"cmd1.txt","cmd2.txt"};
       for(int i = 0; i < files.length; i++) {
			FileOperations cmds = new FileOperations();
			System.out.println("\n\n============ Processing " + files[i] +" =======================\n");
                    
                cmds.processCommandFile(files[i]);
           
           		}
		System.out.println("Done with FileOperations");
}*/
	
}
