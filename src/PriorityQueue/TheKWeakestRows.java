package PriorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class TheKWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        int[] res = new int[k];

        for (int i = 0; i < mat.length; i++) {
            int soldiers = countOneElement(mat[i]);
            heap.add(new int[]{i, soldiers});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[0];
        }
        return res;
    }

    public int countOneElement(int[] row) {
        int l = 0, r = row.length - 1;
        int firstZeroIndex = row.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (row[mid] == 0) {
                firstZeroIndex = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return firstZeroIndex;
    }
}
