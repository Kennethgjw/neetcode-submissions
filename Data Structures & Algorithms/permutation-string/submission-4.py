class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1_count = Counter(s1)
        window_count = Counter(s2[:len(s1)])

        if s1_count == window_count: # Check window before sliding
            return True

        l = 0 # Left pointer

        for r in range(len(s1), len(s2)): # starts with r = len(s1) and loop until len(s2)
            window_count[s2[r]] += 1
            window_count[s2[l]] -= 1

            if window_count[s2[l]] == 0:  # Remove key if value becomes 0
                del window_count[s2[l]]
            l += 1

            if s1_count == window_count:
                return True
        return False