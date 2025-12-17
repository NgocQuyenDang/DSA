package Stack;

import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                stack.push(c);
            } else if (map.containsKey(c)) {
                if (stack.isEmpty()) return false;
                if (stack.peek() != map.get(c)) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[)"));
    }
}
