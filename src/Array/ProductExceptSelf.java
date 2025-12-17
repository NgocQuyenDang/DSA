package Array;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans =  new int[nums.length];
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int productL = 1;
        int productR = 1;

        for (int i = 0; i < nums.length; i++) {
            leftProduct[i] = productL;
            productL *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            rightProduct[i] = productR;
            productR *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = leftProduct[i] * rightProduct[i];
        }
        return ans;
    }
}
