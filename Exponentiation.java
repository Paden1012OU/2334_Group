import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
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
	
	public static void rapidTest(String startingBase, String startingPower, int minBaseZeros, int maxBaseZeros, int minPowerZeros, int maxPowerZeros, int rounding, boolean isRecursive) {
		
		for(int i = minBaseZeros; i <= maxBaseZeros ; i++) {
			String b = startingBase;
			for(int j = 0; j < i; j++) {
				b = b + "0";
			}
			BigDecimal base = new BigDecimal(b);
			
			for(int k = minPowerZeros; k <= maxPowerZeros; k++) {
				String p = startingPower;
				for(int l = 1; l <= k; l++) {
					p = p + "0";
				}
				BigInteger power = new BigInteger(p);
				
				System.out.println("Base: " + base.toString());
				System.out.println("power: " + power.toString());
				
				long s;
				long e;
				
				if(isRecursive == true) {
					s = System.currentTimeMillis();
					fastExpoRecursive(base, power, 1);
					e = System.currentTimeMillis();
				}
				else {
					s = System.currentTimeMillis();
					fastExpoIterative(base, power, 1);
					e = System.currentTimeMillis();
				}
				System.out.println("Time: " + (e - s) / 1000.0 + " seconds.");
				System.out.println("\n");
			}
		}
	}
	
	public static void manualTest() {
		
		long s;
		long e;
		
		BigDecimal result;

		Scanner scanner = new Scanner(System.in);		
		
		System.out.println("Enter the decimal place for future tests be rounded (max 67108864).");
		int rounding = scanner.nextInt();
		
		System.out.println("Use recursion(true) or iterative(false)? Only boolean inputs are accepted here.");
		boolean isRecursive = scanner.nextBoolean();	
		
		System.out.println("Proceed with the tests? (Enter \"stop\" to stop)");
		String confirm = scanner.next(); scanner.nextLine();
		
		while (!confirm.equalsIgnoreCase("stop")) {
			
			System.out.println("Enter the base.");
			String b = scanner.next(); scanner.nextLine();
				
			System.out.println("Enter the power.");
			String p = scanner.next(); scanner.nextLine();
				
			BigDecimal base = new BigDecimal(b);
			BigInteger power = new BigInteger(p);
				
				
			System.out.println("Base: " + b);
			System.out.println("power: " + p);
			System.out.println("Rounding: " + rounding);
			
			if(isRecursive == true) {
				s = System.currentTimeMillis();
				result = fastExpoRecursive(base, power, rounding);
				e = System.currentTimeMillis();
			}
			else {
				s = System.currentTimeMillis();
				result = fastExpoIterative(base, power, rounding);
				e = System.currentTimeMillis();
			}
			System.out.println("Result: " + result.toEngineeringString());
			System.out.println("Time: " + (e - s) / 1000.0 + " seconds.");
			System.out.println("\n");
			
			System.out.println("Proceed with the tests? (Enter \"stop\" to stop)");
			confirm = scanner.next(); scanner.nextLine();
		}

		scanner.close();
	}
	
	public static void avgSpeedTest(boolean isRecursive, String b, String p, int rounding, int iterations) {
		
		Long s;
		Long e;
		ArrayList<Long> speeds = new ArrayList<>();
		Long spdSum = 0L;
		
		BigDecimal base = new BigDecimal(b);
		BigInteger power = new BigInteger(p);
		
		for(int i = 0; i < iterations; i++) {
			
			s = System.currentTimeMillis();
			fastExpoIterative(base, power, rounding);
			e = System.currentTimeMillis();
			
			speeds.add(e-s);
			spdSum += e-s;
			
			
		}
		
		double avgSpd = (spdSum / 1000.0) / iterations;
		
		double std;
		double diffSqrdSum = 0.0;
		
		for(int j = 0; j < iterations; j++) {
			diffSqrdSum += Math.pow(speeds.get(j) / 1000.0 - avgSpd , 2);
		}
		
		std = Math.sqrt(diffSqrdSum / (iterations - 1));
		
		
		
		System.out.println("average speed in seconds: " + avgSpd);
		System.out.println("standard deviation in seconds: " + std);
		
		
	}
	
	public static void main(String[]args) {
		
		//rapidTest("2", "1", 0, 10, 0, 10, 0, true);
		
		//manualTest();
		
		//avgSpeedTest(false, "2", "1000000", 1, 100);
		
	}
}
