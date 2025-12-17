package Stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BaseBallGame {
    public int calPoints(String[] operations) {
        int finalScore = 0;
        Stack<Integer> score = new Stack<>();
        for (String ops : operations) {
             if (ops.charAt(0) == '+') {
                int temp1 = score.pop();
                int temp2 = score.peek();
                score.push(temp1);
                score.push(temp1 + temp2);
            } else if (ops.charAt(0) == 'C') {
                score.pop();
            } else if  (ops.charAt(0) == 'D') {
                score.push(score.peek() * 2);
            } else {
                 score.push(Integer.parseInt(ops));
             }
        }
        while (!score.isEmpty()) {
            finalScore += score.pop();
        }
        return finalScore;
    }
}
