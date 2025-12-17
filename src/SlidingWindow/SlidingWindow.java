package SlidingWindow;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] array = {7, 3, 3, 3, 2, 2, 2, 2};

        int left = 0;
        int maxLength = 1;

        for (int right = 0; right < array.length; right++) {
            if (array[right] != array[left]) {
                int length = right - left;
                maxLength = Math.max(maxLength, length);
                left = right;
            }
        }
        maxLength = Math.max(maxLength, array.length - left);
        System.out.println(maxLength);
    }
}
