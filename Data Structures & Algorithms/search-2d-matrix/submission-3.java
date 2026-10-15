class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];

            int largestNumInRow = row[row.length - 1];

            if (largestNumInRow >= target) {
                return binarySearch(row, target);
            }
        }

        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) {
                return true;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }
}
