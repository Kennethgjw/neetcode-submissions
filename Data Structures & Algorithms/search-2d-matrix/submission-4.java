class Solution {
public boolean searchMatrix(int[][] matrix, int target) {

    // Number of rows and columns in the matrix
    int rows = matrix.length;
    int cols = matrix[0].length;

    // Pretend the entire 2D matrix is one long sorted array.
    //
    // Example:
    // [ [1, 2, 4, 8],
    //   [10,11,12,13],
    //   [14,20,30,40] ]
    //
    // Treat it like:
    // [1,2,4,8,10,11,12,13,14,20,30,40]

    int l = 0;

    // Total number of elements = rows * cols
    // Last valid index is therefore rows * cols - 1
    int r = rows * cols - 1;

    while (l <= r) {

        // Find the middle index of our imaginary 1D array
        int m = l + (r - l) / 2;

        // Convert the imaginary 1D index back into:
        // row index + column index
        //
        // Example if cols = 4 and m = 6:
        //
        // row = 6 / 4 = 1
        // col = 6 % 4 = 2
        //
        // So index 6 corresponds to matrix[1][2]

        int row = m / cols;
        int col = m % cols;

        // Get the actual value from the matrix
        int value = matrix[row][col];

        if (value == target) {
            return true;

        } else if (value < target) {

            // Target must be somewhere to the RIGHT
            l = m + 1;

        } else {

            // Target must be somewhere to the LEFT
            r = m - 1;
        }
    }

    // If binary search finishes without finding target
    return false;
}
}
