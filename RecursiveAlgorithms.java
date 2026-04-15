import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
public class RecursiveAlgorithms {

	public static HashMap<Integer, BigInteger> calc = new HashMap<>();
	
	public static BigInteger fibonacci(int n) {
		
		if (n == 0)
			return BigInteger.ZERO;
		if(n ==1)
			return BigInteger.ONE;
		if(calc.containsKey(n)) {
			return calc.get(n);
		} else {
		
		BigInteger result = fibonacci(n-1).add(fibonacci(n-2));
		calc.put(n, result);
		return result;
		}
}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		System.out.println("Calculate Fibonacci Number: " + num);
		long timeStart = System.nanoTime();
		System.out.println(fibonacci(num));
		long timeStop = System.nanoTime();
		
		double nanoSec = (timeStop - timeStart);
		double milliSec = nanoSec / 1000000;
		
		System.out.println("System Time–––––––––––––|");
		System.out.println("Nano Seconds: " + nanoSec);
		System.out.println("Milliseconds: " + String.format("%.2f", milliSec));
		sc.close();
		
		
		
	}

}
