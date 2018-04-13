package spellChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SpellChecker {
	
	private static HashSet<String> words = new HashSet<String>();
	public static Scanner keyboard = new Scanner(System.in);
	public static void updateDictionary(String fileName) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				StringTokenizer stringToken = new StringTokenizer(line, " \t.,;:-%'\"");
				words.add(stringToken.nextToken());
			}
		}
		catch(FileNotFoundException e) {
			System.err.println(fileName + " not Found!");
			System.exit(2);
		}
		finally {
			if(scan != null) {
				scan.close();
			}
		}
	}
	
	public static TreeSet<String> spellCheck(String fileName){
		TreeSet<String> misspelledWords = new TreeSet<String>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				StringTokenizer stringToken = new StringTokenizer(line, " \t.,;:-%'\"");
				while(stringToken.hasMoreTokens()) {
					String token = stringToken.nextToken().toLowerCase();
					String searchToken = token;
					if(token.charAt((token.length())-1) == 's' && token.length() > 1) {
						token = token.substring(0, (token.length())-1);
					}
					int firstChar = (int)(token.charAt(0));
					if(((firstChar >= 97) && (firstChar  <= 127)) && (!(words.contains(token) || misspelledWords.contains(token)))) {
						System.out.println(searchToken + " not in dictionary. Add to dictionary? (y/n)");
						keyboard = new Scanner(System.in);
						boolean exitFlag = true;
						while(exitFlag) {
							String char_in = keyboard.next();
							if(char_in.length() != 1) {
								System.out.println("Please choose valid option. Try Again!");
							}
							switch(char_in) {
							case "y":
								words.add(token);
								exitFlag = false;
								break;
							case "n":
								misspelledWords.add(token);
								exitFlag = false;
								break;
							default:
								System.out.println("Please choose valid option. Try Again!");
								break;
							}
						}
					}
				}
			}
		}
		catch(FileNotFoundException e) {
			System.err.println(fileName + " not Found!");
			System.exit(2);
		}
		finally {
			if(scan != null) {
				scan.close();
			}
		}
		return misspelledWords;
	}
	public static void main(String[] args) {
		
		if(args.length < 1) {
			System.err.println("No File Name specified to Initialize the Dictionary");
			System.exit(1);
		}
		
		System.out.println("========Updating the dictionary from " + args[0] + "========");
		updateDictionary(args[0]);
		System.out.println("Dictionary updated successfully!");
		
		for(int i = 1; i < args.length; i++) {
			System.out.println("\n========Spell checking " + args[i] + "========");
			TreeSet<String> misspelledWords = spellCheck(args[i]);
			Iterator<String> itr = misspelledWords.iterator();
			System.out.println("********misspelled words********");
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}
		if(keyboard != null) {
			keyboard.close();
		}
	}
	
}
