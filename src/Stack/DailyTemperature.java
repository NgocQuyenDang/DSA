package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                int cur = stack.pop();
                ans[cur] = i - cur;
            }
            stack.push(i);
        }
        return ans;
    }
}
