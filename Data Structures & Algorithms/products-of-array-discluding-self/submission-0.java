class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int [] result = new int[length];

        // interate through array
        for (int i=0; i < length; i++) {
            int prod = 1;
            for (int j=0; j < length; j++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }
            result[i] = prod;
        }

        return result;
    }
}  
