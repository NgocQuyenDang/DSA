package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestDirectory {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxLen = 0;
        String[] str = input.split("\n");

        for (String line : str) {
            int depth = line.lastIndexOf("\t") + 1;

            String name = line.replaceAll("\t", "");
            while (stack.size() > depth) {
                stack.pop();
            }

            int curLen = name.length();

            if (!stack.isEmpty()) {
                curLen += stack.peek() + 1;
            }
            if (!name.contains(".")) {
                stack.push(curLen);
            } else {
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
