package TwoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int length = right - left;
            int width = Math.min(height[left], height[right]);
            int area = length * width;
            maxWater = Math.max(maxWater, area);

            if (height[left] < height[right]) {
                left++;
            } else right--;
        }
        return maxWater;
    }
}
