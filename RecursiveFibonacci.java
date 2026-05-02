import java.math.BigInteger;
import java.util.Scanner;
public class RecursiveFibonacci {

	public static BigInteger[] comp;
	
	public static BigInteger fibonacci(int n) {
		
		if (n == 0)
			return BigInteger.ZERO;
		if(n ==1)
			return BigInteger.ONE;
		if(comp[n] != null) {
			return comp[n];
		} else {
		
			
		BigInteger result = fibonacci(n-1).add(fibonacci(n-2));
		comp[n] = result;
		return result;
		}
}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		
		comp = new BigInteger[num+1];
		
		System.out.println("Calculate Fibonacci Number: " + num);
		
		long timeStart = System.nanoTime();
		for (int i = 0; i <= num; i += 1000) {
            fibonacci(i);
		}
		BigInteger result = fibonacci(num);
		long timeStop = System.nanoTime();
		double nanoSec = (timeStop - timeStart);
		double milliSec = nanoSec / 1000000;
		
		if (num >= 10000) {
			java.math.BigDecimal bd = new java.math.BigDecimal(result);
			String shortened = String.format("%.3E", bd);
			System.out.println("Result: " + shortened);
		} else {
			System.out.println("Final Result: " + result.toString());
		}
		System.out.println("System Time----------------|");
		System.out.println("Nano Seconds: " + nanoSec);
		System.out.println("Milliseconds: " + String.format("%.3f", milliSec));
		
		sc.close();
	}
}	
