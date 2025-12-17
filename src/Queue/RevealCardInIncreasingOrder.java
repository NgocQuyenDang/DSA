package Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class RevealCardInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            q.add(i);
        }

        for (int i = 0; i < deck.length; i++) {
            int idx = q.pollFirst();
            res[idx] = deck[i];
            if (!q.isEmpty()) {
                q.add(q.pollFirst());
            }

        }
        return res;
    }
}
