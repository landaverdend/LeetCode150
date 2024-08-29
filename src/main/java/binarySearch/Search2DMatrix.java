package binarySearch;

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix[0].length - 1; // useful...

        // Immediately just check to make sure target is in bounds.
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][n]) return false;


        // it's a double binary search...
        int l = 0, r = matrix.length - 1;
        while (l <= r) {
            int m = ((r - l) / 2) + l;

            int val = matrix[m][n];
            if (val == target) return true; // just a quick check to save us an extra BS

            if (val < target) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }

        return normalBS(matrix[l], target);
    }

    public static boolean normalBS(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = (r-l) / 2 + l;

            if (arr[m] == target) {
                return true;
            }

            if (arr[m] < target) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }

        return false;
    }

    public static void main(String[] args ) {

        // 1,3,5,7 [10,11,16,20] [23,30,34,60
        int[][] in = new int[][] {
            {1,3,5,7}, {10,11,16,20},
        };
        int target = 12;

        System.out.printf("Result: %s", searchMatrix(in, target) ? "T" : "F");
    }
}
