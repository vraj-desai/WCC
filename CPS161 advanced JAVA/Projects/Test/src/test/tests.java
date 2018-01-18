package test;
import java.util.Scanner;
public class tests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int int1 = reader.nextInt();
		int int2 = reader.nextInt();
		
		try {
			int result = int1/int2;
			System.out.println(result);
			reader.close();
		}
		catch(ArithmeticException e){
			System.out.println("Can you really devide any number by zero?");
		}
	}

}
