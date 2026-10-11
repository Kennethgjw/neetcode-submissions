class Solution {
    public int orangesRotting(int[][] grid) {
        // Stores positions of rotten oranges
        Queue<int[]> queue = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] directions = {
            {-1, 0}, // up
            {1, 0}, // down
            {0, -1}, // left
            {0, 1}, // right
        };

        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean rottedSomething = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newRow >= rows ||
                        newCol < 0 || newCol >= cols) {
                        continue;
                    }

                    if (grid[newRow][newCol] != 1) {
                        continue;
                    }

                    grid[newRow][newCol] = 2;
                    fresh--;

                    queue.offer(new int[] {newRow, newCol});
                    rottedSomething = true;
                }
            }

            if (rottedSomething) {
                minutes++;
            }
        }

        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}
