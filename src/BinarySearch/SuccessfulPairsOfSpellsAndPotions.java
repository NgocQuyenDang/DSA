package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        List<Integer> ans = new ArrayList<>();
        for (int s : spells) {
            int leftMostIdx = potions.length;
            int l = 0, r = potions.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if ((long) s * potions[mid] >= success) {
                    r = mid -1;
                    leftMostIdx = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans.add(potions.length - leftMostIdx);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
