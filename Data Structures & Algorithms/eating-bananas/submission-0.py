class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l = 1 # at least 1 per hour
        r = max(piles) # highest value in list per hour
        res = r # highest eating rate first but we see if we trying to find the minimum

        while l <= r:
            k = (l+r) // 2 # we find somewhere in the middle first
            hours = 0
            
            for p in piles:
                hours += math.ceil(float(p)/k) # bananas / eating rate
            if hours <= h: # hours took less than hours given
                res = k 
                r = k - 1 # decrease eating rate to try to find a lower num since finding minimum
            else: # hours took more
                l = k + 1 # increase the eating rate
        return res