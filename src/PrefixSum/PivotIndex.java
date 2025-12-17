package PrefixSum;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int i = 0;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int j = 1; j <= n; j++) {
            prefixSum[j] = prefixSum[j - 1] + nums[j - 1];
        }

        while (i < n) {
            int sumLeft = 0;
            int sumRight = 0;
            int l = 0;
            sumLeft = prefixSum[i] - prefixSum[l];
            sumRight = prefixSum[prefixSum.length - 1] - prefixSum[i + 1];
            if (sumLeft == sumRight) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 6, 5, 6};
        int[] prefixSum = new int[arr.length + 1];
        prefixSum[0] = 0;
        for (int j = 1; j <= arr.length; j++) {
            prefixSum[j] = prefixSum[j - 1] + arr[j - 1];
        }
        for (int i = 0; i < prefixSum.length; i++) {
            System.out.print(prefixSum[i] + " ");
        }
    }
}
