package TwoPointers;

import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 6, 7};
        int[] b = {2, 5, 8, 9};
        int[] c = new int[a.length + b.length];
        int n = a.length;
        int m = b.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
                k++;
            } else {
                c[k] = b[j];
                j++;
            }
        }

        while (i < n) {
            c[k++] = a[i];
            i++;
        }

        while (j < m) {
            c[k++] = b[j];
            j++;
        }
        System.out.println(Arrays.toString(c));
    }
}
