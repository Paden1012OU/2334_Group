import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;
import java.math.BigDecimal;

public class Exponentiation2 {
	
	public static BigDecimal fastExpoIterative(BigDecimal base, BigInteger power, int rounding) throws ArithmeticException{

		BigDecimal zeroDecimal = new BigDecimal("0");
		BigInteger zeroInt = new BigInteger("0");
		BigDecimal one = new BigDecimal("1");
		BigInteger two = new BigInteger("2");
		
		
		if(base.doubleValue() == 0 && power.intValue() <= 0) {
			throw new ArithmeticException();
		}
		else if(base.doubleValue() == 0) {
			return zeroDecimal;
		}
		else if(power.intValue() == 0) {
			return one;
		}
		else if(power.intValue() < 0) {
			base = one.divide(base, rounding, RoundingMode.HALF_UP);
			power = power.abs();
		}
		
		BigDecimal result = one;
		BigDecimal coefficient = base;
		
		while (power.doubleValue() > 0) {
			if (power.mod(two).equals(zeroInt) == false) {
				result = result.multiply(coefficient);
				
			}
			coefficient = coefficient.multiply(coefficient);
			power = power.divide(two);
		}
		
		return result;
	}
	
	public static BigDecimal fastExpoRecursive(BigDecimal base, BigInteger power, int rounding) throws ArithmeticException{
		BigDecimal zeroDecimal = new BigDecimal("0");
		BigInteger zeroInt = new BigInteger("0");
		BigDecimal oneDecimal= new BigDecimal("1");
		BigInteger oneInt = new BigInteger("1");
		BigInteger negativeOne = new BigInteger("-1");
		BigInteger two = new BigInteger("2");
		
		if(base.equals(zeroDecimal) && power.intValue() <=0) {
			throw new ArithmeticException();
		}
		else if (power.equals(zeroInt)) {
			return oneDecimal;
		}
		else if (power.equals(oneInt)) {
			return base;
		}
		else if(power.equals(negativeOne)) {
			return oneDecimal.divide(base, rounding, RoundingMode.HALF_UP);
		}
		else if (power.mod(two).equals(zeroInt)) {
			return fastExpoRecursive(base, power.divide(two), rounding).multiply(fastExpoRecursive(base, power.divide(two), rounding));
		}
		else {
			return base.multiply(fastExpoRecursive(base, (power.subtract(oneInt)).divide(two), rounding)).multiply(fastExpoRecursive(base, (power.subtract(oneInt)).divide(two), rounding));
		}		
	}
	
	
	public static void main(String[]args) {
		/*
		Scanner scanner = new Scanner(System.in);		
		
		System.out.println("Enter the base.");
		String b = scanner.next(); scanner.nextLine();
		
		System.out.println("Enter the power.");
		String p = scanner.next(); scanner.nextLine();
		
		System.out.println("Enter the decimal place to be rounded (max 67108864).");
		int rounding = scanner.nextInt();
		
		scanner.close();
		
		BigDecimal base = new BigDecimal(b);
		BigInteger power = new BigInteger(p);
		
		
		System.out.println("Base: " + b);
		System.out.println("power: " + p);
		System.out.println("Rounding: " + rounding);
		
		//System.out.println("Result: " + fastExpoIterative(base, power, rounding).toString());
		*/
		
		
		
		for(int i = 1; i <= 30 ; i++) {
			String b = "1";
			for(int j = 0; j < i; j++) {
				b = b + "0";
			}
			BigDecimal base = new BigDecimal(b);
			
			for(int k = 0; k <= 30; k++) {
				String p = "1";
				for(int l = 1; l <= k; l++) {
					p = p + "0";
				}
				BigInteger power = new BigInteger(p);
				
				System.out.println("Base: " + base.toString());
				System.out.println("power: " + power.toString());
				
				long s = System.currentTimeMillis();
				//System.out.println("Result: " + fastExpoRecursive(base, power, 1).toString());
				fastExpoRecursive(base, power, 1);
				long e = System.currentTimeMillis();
				
				System.out.println("Time: " + (e - s) / 1000.0 + " seconds.");
				System.out.println("\n");
			}
		}
	}
}
