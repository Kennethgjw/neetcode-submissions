class Solution:
    def findMin(self, nums: List[int]) -> int:
        res = nums[0]
        l, r = 0, len(nums) - 1

        while l <= r:
            
            if nums[l] < nums[r]:  # If the array is already sorted, return nums[l]
                return min(res, nums[l])

            m = (l + r) // 2
            res = min(res, nums[m])

            if nums[m] >= nums[l]:
                l = m + 1
            else:
                r = m - 1
        
        return res

            
