package PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        long totalCost = 0;

        int l = 0;
        int r = costs.length - 1;

        for (int i = 0; i < candidates && l <= r; i++) {
            heap.add(new int[]{costs[l], l});
            l++;
        }

        for (int j = 0; j < candidates && l <= r; j++) {
            heap.add(new int[]{costs[r], r});
            r--;
        }

        for (int i = 0; i < k; i++) {
            int[] selectedWorker = heap.poll();
            totalCost += selectedWorker[0];
            int index = selectedWorker[1];

            if (l <= r) {
                if (index < l) {
                    heap.add(new int[]{costs[l], l});
                    l++;
                } else {
                    heap.add(new int[]{costs[r], r});
                    r--;
                }
            }
        }
        return totalCost;
    }
}
