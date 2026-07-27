class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        result = 0
        store = set(nums) # store unique numbers

        for num in nums:
            streak = 0 # count streak
            curr = num
            while curr in store: # only loops when next number is exactly 1 more
                streak += 1
                curr += 1
            result = max(result, streak)

        return result