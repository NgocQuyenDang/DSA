package MidTerm;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BooleanExpressionCalculator {

    /**
     * Tính giá trị logic (true/false) của biểu thức boolean đầu vào.
     *
     * @param expression chuỗi biểu thức logic cần tính toán.
     *             Các phần tử phải được phân tách bằng khoảng trắng và có ngoặc đầy đủ.
     *             Ví dụ: "( ! ( ( true && false ) || true ) )".
     *
     * @return kết quả boolean sau khi tính toán biểu thức.
     */
    public boolean computeBooleanExpression(String expression) {
        String[] tokens = expression.trim().split("\\s+");
        // TODO
        Set<String> set = Set.of("&&", "||", "!");

        Stack<String> values = new Stack<>();
        Stack<String> ops = new Stack<>();

        for (String token : tokens) {
            if (token.equals("(")) {
                continue;
            }

            if (set.contains(token)) {
                ops.push(token);
            }

            if (token.equals("true") || token.equals("false")) {
                values.push(token);
            }

            if (token.equals(")")) {
                String operator = ops.pop();

                if (operator.equals("!")) {
                    values.push(String.valueOf(!Boolean.parseBoolean(values.pop())));
                } else {
                    String s1 = values.pop();
                    String s2 = values.pop();
                    String res = evaluate(s1, s1, operator);
                    values.push(res);
                }
            }
        }
        return Boolean.parseBoolean(values.pop());
    }

    public String evaluate(String s1, String s2, String operator) {
        if (operator.equals("&&")) {
            if (s1.equals("false") || s2.equals("false")) {
                return "false";
            } else {
                return "true";
            }
        } else if (operator.equals("||")) {
            if (s1.equals("true") || s2.equals("true")) {
                return "true";
            } else {
                return "false";
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BooleanExpressionCalculator bc = new BooleanExpressionCalculator();
        System.out.println(bc.computeBooleanExpression("( ! ( ( true && false ) || true ) )"));
        System.out.println(bc.computeBooleanExpression( "( ! ( ( true && false ) || false ) )"));
    }
}