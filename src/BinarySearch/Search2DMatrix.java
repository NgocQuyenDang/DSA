package BinarySearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] arr = new int[matrix.length * matrix[0].length];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[k++] = matrix[i][j];
            }
        }
        return binarySearch(arr, arr.length, target);
    }

    public static boolean binarySearch(int[] a, int size, int key) {
        int l = 0;
        int h = size - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (a[mid] == key) {
                return true;
            } else if (a[mid] < key) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return false;
    }
}
