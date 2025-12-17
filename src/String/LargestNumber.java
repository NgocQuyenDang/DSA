package String;

import java.math.BigInteger;
import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));
        if (numbers[0].equals("0")) return "0";
        return String.join("", numbers);
    }
}
