class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // nums = [-1,0,1,2,-1,-4]
        Arrays.sort(nums);
        // nums = [-4,-1,-1,0,1,2]
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 3 positive numbers cannot add up to 0
            if (nums[i] > 0) break; // will not = 0 from here onwards so end it here

            // skip duplicates of the first number
            // will just duplicate results
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    // counter duplicate issue
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}