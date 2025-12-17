package Stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ExpressionContainsParentheses {
    /**
     * Tính giá trị biểu thức số học có ngoặc () và các phép toán + - * /.
     * Giả định: mỗi ký tự (số, toán tử, ngoặc) được cách nhau bởi 1 dấu cách.
     * @param expression biểu thức cần tính
     * @return giá trị biểu thức
     */
    public double evaluate(String expression){
        String[] tokens = expression.trim().split("\\s+");
        // TODO
        Stack<String> operators = new Stack<>();
        Stack<Double> values = new Stack<>();
        for (String token : tokens){
            if (isNumber(token)){
                values.push(Double.parseDouble(token));
            }
            if (token.equals("(")){
                operators.push(token);
            }
            if (token.equals("+") ||  token.equals("-") || token.equals("*") || token.equals("/")){
                while (!operators.isEmpty() && !operators.peek().equals("(")
                        && hasPrecedence(token, operators.peek())) {
                    double a = values.pop();
                    double b = values.pop();
                    double res = evaluateSubExpression(b, a, operators.pop());
                    values.push(res);
                }
                operators.push(token);
            }
            if (token.equals(")")) {
                while(!values.isEmpty() && !operators.isEmpty() && !operators.peek().equals("(")){
                    double a = values.pop();
                    double b = values.pop();
                    double res = evaluateSubExpression(b, a, operators.pop());
                    values.push(res);
                }
                operators.pop();
            }
        }
        while (!values.isEmpty() && !operators.isEmpty()){
            double a = values.pop();
            double b = values.pop();
            double res = evaluateSubExpression(b, a, operators.pop());
            values.push(res);
        }
        return values.pop();
    }

    public double evaluateSubExpression(double a , double b, String operator) {
        switch (operator) {
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a / b;
        }
        return 0;
    }

    public boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean hasPrecedence (String op1, String op2) {
        return getPrecedence(op2) >= getPrecedence(op1);
    }

    public int getPrecedence(String token) {
        switch (token) {
            case "+":
            case  "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        ExpressionContainsParentheses e = new ExpressionContainsParentheses();
        System.out.println(e.evaluate("( 6.0 * ( 2.0 + 4.0 ) )"));
    }
}
