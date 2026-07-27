class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        
        for i, a in enumerate(nums):
            if a > 0: # since its sorted, if current number more than 0 then the rest of the numbers wont sum to 0
                break
            
            if i > 0 and a == nums[i-1]: # avoids duplicate triplets
                continue

            l, r = i + 1, len(nums) - 1

            while l < r:
                threeSum = a + nums[l] + nums[r]
                if threeSum < 0:
                    l += 1
                elif threeSum > 0:
                    r -= 1
                else:
                    result.append([a, nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while nums[l] == nums[l - 1] and l < r: # Skip duplicate values for the left pointer
                        l += 1
        return result