package Stack;

import java.util.Stack;

public class RemovingStarsFromAString {
    public String removeStars(String s) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {

            if (str[i] != '*') {
                stack.push(str[i]);
            }

            if (str[i] == '*') {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
