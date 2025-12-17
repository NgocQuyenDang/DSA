package Stack;

import java.util.Stack;

public class FinalPricesWithDiscount {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = prices.clone();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && ans[stack.peek()] >=  prices[i]) {
                ans[stack.pop()] -=  prices[i];
            }
            stack.push(i);
        }
        return ans;
    }
}
