package BinarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int result = r;

        while (l <= r) {
            int mid =  l + (r - l) / 2;
            long hours = 0;
            for (int p : piles) {
                hours += (p + mid - 1L) / mid;
            }
            if (hours <= h) {
                result = Math.min(result, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        KokoEatingBananas test = new KokoEatingBananas();
        System.out.println(test.minEatingSpeed(piles, h));
    }
}
