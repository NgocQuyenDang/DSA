package Stack;

import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            if  (set.contains(arr[i])) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > arr[i] && map.get(stack.peek()) > i) {
                set.remove(stack.pop());
            }
            if (!set.contains(arr[i])) {
                stack.push(arr[i]);
                set.add(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
