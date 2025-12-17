package PriorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToActivateServers {
    /**
     * Tính toán chi phí tối thiểu để kích hoạt đúng k máy chủ.
     *
     * @param performance mảng hiệu năng của từng máy chủ
     * @param baseCost mảng chi phí cơ bản tương ứng
     * @param k số lượng máy chủ cần thuê
     * @return chi phí nhỏ nhất có thể để kích hoạt k máy chủ
     */
    public static double minCostToActivate(int[] performance, int[] baseCost, int k) {
        // TODO
        int n = performance.length;

        double[][] servers = new double[n][2];
        for (int i = 0; i < n; i++) {
            servers[i][0] = (double) baseCost[i] / performance[i];
            servers[i][1] = performance[i];
        }

        Arrays.sort(servers, (a, b) -> Double.compare(a[0], b[0]));
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int sumOfPerf = 0;
        double res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int perf = (int) servers[i][1];
            sumOfPerf += perf;
            heap.add(perf);
            if (heap.size() > k) {
                sumOfPerf -= heap.poll();
            }
            if (heap.size() == k) {
                double cost = servers[i][0] * sumOfPerf;
                res = Math.min(res, cost);
            }
        }
        return res;
    }
}
