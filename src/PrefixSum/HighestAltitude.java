package PrefixSum;

public class HighestAltitude {
    public int largestAltitude(int[] gain) {
        int[] ans = new int[gain.length + 1];
        ans[0] = 0;
        for (int i = 1; i <= gain.length; i++) {
            ans[i] = ans[i - 1] + gain[i - 1];
        }
        int max = ans[0];
        for (int i = 1; i <= gain.length; i++) {
            if (ans[i] > max) {
                max = ans[i];
            }
        }
        return max;
    }
}
