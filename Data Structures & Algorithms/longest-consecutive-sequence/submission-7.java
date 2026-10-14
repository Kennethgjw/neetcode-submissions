class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        if (nums.length == 0) {
            return 0;
        }

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int length = 1;

                while (set.contains(num + 1)) {
                    length++;
                    num++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
