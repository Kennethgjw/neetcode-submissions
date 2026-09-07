class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0;
        int r = heights.length - 1;
        int currArea = 0;

        while (l < r) {
            currArea = Math.min(heights[l], heights[r]) * (r - l);

            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }

            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }
}
