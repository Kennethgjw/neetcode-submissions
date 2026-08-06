class Solution {
    public int binarySearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        int middle = l + (r - l) / 2;

        if (nums[middle] == target) {
            return middle;
        }

        if (nums[middle] > target) {
            return binarySearch(nums, l, middle - 1, target);
        }
        return binarySearch(nums, middle + 1, nums.length - 1, target);
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
}
