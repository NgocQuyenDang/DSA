package Stack;

import java.util.Stack;

public class MinimumStringLengthAfterRemoveABCD {
    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'A' && c == 'B' ||
                !stack.isEmpty() && stack.peek() == 'C' && c == 'D') {

                    stack.pop();

            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(minLength("ABFCACDB"));
    }
}
