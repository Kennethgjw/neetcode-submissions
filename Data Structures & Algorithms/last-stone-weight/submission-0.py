class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        while len(stones) > 1:
            stones.sort(reverse=True)
            first, second = stones.pop(0), stones.pop(0)
            
            if first != second:
                stones.append(first - second)
        
        if stones:
            return stones[0]
        else:
            return 0
            