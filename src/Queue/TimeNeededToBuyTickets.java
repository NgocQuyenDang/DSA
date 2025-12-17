package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for  (int i = 0; i < tickets.length; i++) {
            queue.add(i);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int person = queue.poll();
            tickets[person]--;
            time++;
            if (person == k && tickets[person] == 0) {
                return time;
            }
            if (tickets[person] > 0) {
                queue.add(person);
            }
        }
        return time;
    }
}
