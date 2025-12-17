package Stack;

import java.util.Stack;

public class Postfix {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int token1 =  operands.pop();
                int token2 = operands.pop();
                operands.push(evaluate(token2, token1, token));
            } else operands.push(Integer.parseInt(token));
        }
        return operands.pop();
    }

    public static int evaluate(int x, int y, String operator) {
        switch (operator) {
            case "*": return x * y;
            case "/": return x / y;
            case "%": return x % y;
            case "+": return x + y;
            case "-": return x - y;
        }
        return 0;
    }
}
