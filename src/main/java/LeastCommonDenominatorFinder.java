public class LeastCommonDenominatorFinder {

    private static int gcd(int a, int b) {
        while (b > 0)
        {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    public static int leastCommonDenominator(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        return a * (b / gcd(a, b));
    }
}
