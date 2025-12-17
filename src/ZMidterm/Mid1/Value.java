package ZMidterm.Mid1;
import java.util.*;
public class Value {
    public long getMaxValue(int[] v)
    {
        Arrays.sort(v);
        int sumAll = 0;

        for (int i : v) {
            sumAll += i;
        }

        int minWeight = Integer.MAX_VALUE;
        for (int i = 0; i < v.length;) {
            int curVal = v[i];
            int weight = 0;
            while (v[i] == curVal) {
                weight += v[i];
                i++;
            }
            minWeight = Math.min(minWeight, weight);
        }
        return sumAll - minWeight;
    }

}
