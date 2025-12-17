package PriorityQueue;

import java.util.*;

public class FrequencySorter {
    /**
     * Sắp xếp các ký tự chuỗi theo thứ tự tăng dần dựa trên tần suất xuất hiện.
     * Nếu hai ký tự có cùng tần suất thì sắp xếp theo thứ tự a-z.
     * @param s chuỗi ban đầu
     * @return chuỗi được sắp xếp
     */
    public static String frequencySort(String s) {
        // TODO
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) ->
                                                                        a.getValue().compareTo(b.getValue()) == 0
                                                                        ? a.getKey() -  b.getKey() : a.getValue() - b.getValue());
        Map<Character, Integer> map = new HashMap<>();

        for (int  i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        queue.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for(int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
