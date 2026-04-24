import java.util.Scanner;
import java.math.*;

public class IterativeFibonacci {

	public static BigInteger fibonacci(int num) {
		
		BigInteger firstNum = BigInteger.ZERO;
		BigInteger secondNum = BigInteger.ONE;
		
		for(int i = 1; i <= num; i++) {

			BigInteger nextNum = firstNum.add(secondNum);
	        firstNum = secondNum;
	        secondNum = nextNum;
		}
		// System.out.println("Result: " + firstNum);
		
		return firstNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number to find its fibonacci value: ");
		int num = sc.nextInt();
		long timeStart = System.nanoTime();
		System.out.println("Result: " + fibonacci(num));
		
		long timeStop = System.nanoTime();
		long nanoDuration = timeStop - timeStart;
		double millisecDuration = (timeStop - timeStart) / 1000000.0;
		
		System.out.println("System Runtime in Nanoseconds: " + nanoDuration);
		System.out.println("System Runtime in Milliseconds: " + String.format("%.3f", millisecDuration));
		sc.close();
	}	
}
// 10 		-> 1.9385 ms
// 5000 	-> 4.8551 ms
// 