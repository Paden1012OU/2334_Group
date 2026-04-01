public class Factorial {

    public static long factorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n == 0 || n == 1) {
            return 1L;
        }
        return n * factorialRecursive(n - 1);
    }

    public static long factorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // use for quick testing (optional)
    public static void main(String[] args) {
        int n = 50;
        System.out.println("Recursive: " + factorialRecursive(n));
        System.out.println("Iterative: " + factorialIterative(n));
    }
}