class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        if (nums.length == 0) return 0;

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) { // this means this is the cfm the start of sequence
                int length = 1;

                while (set.contains(num + 1)) {
                    length++;
                    num++;
                }

                longest = Math.max(length, longest);
            }
        }

        return longest;
    }
}
