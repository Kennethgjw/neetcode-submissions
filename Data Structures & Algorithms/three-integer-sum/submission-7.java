class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // nums = [-1,0,1,2,-1,-4]
        Arrays.sort(nums);
        // nums = [-4,-1,-1,0,1,2]
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i<nums.length; i++) {
            // 3 positive numbers cannot add up to 0
            if (nums[i] > 0) break; // will not = 0 from here onwards so end it here

            // skip duplicates of the first number
            // will just duplicate results
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int l = i + 1;
            int r = nums.length - 1;
    
            // nums = [-4,-1,-1,0,1,2]

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else { // equals to 0
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    // same logic, if new nums[l] is duplicate
                    // will lead to duplicate result again
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}