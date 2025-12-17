package Stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (String c : s.split("")) {
            if (!c.equals("]")) {
                stack.push(c);
            } else {
                String substr = "";
                while (!stack.peek().equals("[")) {
                    substr = stack.pop() + substr;
                }
                stack.pop();
                int k = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k = (stack.pop().charAt(0) - '0') * base + k;
                    base *= 10;
                }
                for (int i = 0; i < k; i++) {
                    stack.push(substr);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (String str : stack) {
            result.append(str);
        }
        return result.toString();
    }
}

