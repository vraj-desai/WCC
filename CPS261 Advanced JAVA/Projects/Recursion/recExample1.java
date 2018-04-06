import java.io.*;

public class recExample1{

	public void getAnswer(int n){
		if(n < 0){
			return 0;
		}
		else if(n == 0){
			return 1;
		}
		else{
			retrun getAnswer(n-1)+getAnswer(n-2)+getAnswer(n-3)
		}
	}

	public void main(string[] args){
		recExample1 rec = new recExample1();
		int n = keyboard.nextInt();
		System.out.println("Answer is " + rec.getAnswer(n));
	}
}
