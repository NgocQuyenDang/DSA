package TwoPointers;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        Arrays.sort(nums);
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                count++;
                i++;
                j--;
            }
            if (nums[i] + nums[j] > k) {
                j--;
            } else {
                i++;
            }
        }
        return count;
    }
}
