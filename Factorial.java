import java.math.BigInteger;

public class FactorialIterative {

    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}

import java.math.BigInteger;

public class FactorialRecursive {

    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }
}

import java.math.BigInteger;

public class FactorialDriver {

    public static void main(String[] args) {
    	// Current input test sizes
    	// Currently 5000 but can be changed
        int[] testSizes = {100000};
        int runs = 10;

        for (int n : testSizes) {
            long recursiveTotal = 0;
            long iterativeTotal = 0;
            
            // Keep track of whether recursion fails
            boolean recursiveFailed = false;

            // Run the recursive version multiple times.
            for (int i = 0; i < runs; i++) {
                try {
                    long startRecursive = System.nanoTime();
                    BigInteger recursiveResult = FactorialRecursive.factorial(n);
                    long endRecursive = System.nanoTime();
                    recursiveTotal += (endRecursive - startRecursive);
                } catch (StackOverflowError e) {
                    recursiveFailed = true;
                    break;
                }
            }
            // Run interative version multiple times
            for (int i = 0; i < runs; i++) {
                long startIterative = System.nanoTime();
                BigInteger iterativeResult = FactorialIterative.factorial(n);
                long endIterative = System.nanoTime();
                iterativeTotal += (endIterative - startIterative);
            }
            // print the current input size we just tested
            System.out.println("n = " + n);
            
            
            // Print either the recursive average time or the error message.
            if (recursiveFailed) {
                System.out.println("Recursive: StackOverflowError");
            } else {
                System.out.println("Recursive avg time: " + (recursiveTotal / runs) + " ns");
            }

            System.out.println("Iterative avg time: " + (iterativeTotal / runs) + " ns");
            System.out.println();
        }
    }
}