
public class Exponentiation {

	public static double iterative(double base, int power) {
		
		if (power == 0) {
			return 1;
		}
		
		if (power < 0) {
			base = 1 / base;
			power = Math.abs(power);
		}
		
		double result = 1;
		double coefficient = base;
		
		for(; power > 0; power /= 2) {
			if (power % 2 != 0) {
				result *= coefficient;
			}
				coefficient *= coefficient;
			
		}
		
		return result;
	}
	
	public static double recursive(double base, int power) {
		
		if (power == 0) {
			return 1;
		}
		else if (power == 1) {
			return base;
		}
		else if(power == -1) {
			return 1 / base;
		}
		else if (power % 2 == 0) {
			return recursive(base, power / 2) * recursive(base, power / 2);
		}
		else {
			return base * recursive(base, (power - 1) / 2) * recursive(base, (power - 1) / 2);
		}
	}
	
	public static void main(String[]args) {
		double base = -2;
		int power = -12;
		System.out.println("Base: " + base);
		System.out.println("power: " + power);
		System.out.println("iterative: " + iterative(base, power));
		System.out.println("recursive: " + recursive(base, power));
	}
	
	
	
}
