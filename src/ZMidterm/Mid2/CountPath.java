package ZMidterm.Mid2;

public class CountPath {
    public static int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private static int combination(int n, int k) {
        if (k < 0 || k > n) return 0;
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public int countPath(int M, int N, int t)
    {
        return combination(M + t - 2, M -1) + combination(M + N - t - 2, M - 1);
    }
}
