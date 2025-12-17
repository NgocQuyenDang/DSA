package Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set1.remove(i);
            }
        }
        for (int i : nums1) {
            if (set2.contains(i)) {
                set2.remove(i);
            }
        }
        answer.add(new ArrayList<>(set1));
        answer.add(new ArrayList<>(set2));
        return answer;
    }
}
