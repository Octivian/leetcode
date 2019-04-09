package interview;

public class GreatCommonDivisor {
    static int solution(int a, int b) {
        return gcd(Math.min(a, b), Math.max(a, b) % Math.min(a, b));
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
