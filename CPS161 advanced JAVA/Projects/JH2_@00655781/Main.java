package file_operations;
import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		for(int i = 0; i < args.length; i++) {
			FileOperations cmds = new FileOperations();
			System.out.println("\n\n============ Processing " + args[i] +" =======================\n");
			cmds.processCommandFile(args[i]);
		}
		System.out.println("Done with FileOperations");
	}
}
