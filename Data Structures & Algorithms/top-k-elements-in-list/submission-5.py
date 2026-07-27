class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        res = []
        arr = []

        for num in nums:
            count[num] = 1 + count.get(num, 0)
        
        for num, cnt in count.items():
            arr.append([cnt, num])
        arr.sort()

        while len(res) < k:
            res.append(arr.pop()[1])
        
        return res
        # for num in nums:
        #     count[num] = 1 + count.get(num, 0)
        
        # for num, cnt in count.items():
        #     arr.append([cnt, num])
        # arr.sort()
        
        # while len(res) < k:
        #     res.append(arr.pop()[1])
        # return res 

        # Input: nums = [1,2,2,3,3,3], k = 2
        # Output: [2,3]
        
