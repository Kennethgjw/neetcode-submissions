class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # Initialize res to store the maximum length of the substring we find
        res = 0
        
        # Create a set of distinct characters in the string
        charSet = set(s)

        # Iterate over each distinct character in the string
        for c in charSet:
            # Initialize count to track how many times character c appears in the window
            count = 0
            # Initialize l (left pointer of the sliding window)
            l = 0
            
            # Iterate over each character in the string using the right pointer r
            for r in range(len(s)):
                # If the character at the current position is the same as c, increase count
                if s[r] == c:
                    count += 1

                # If the number of characters we need to replace exceeds k, shrink the window from the left
                while (r - l + 1) - count > k:
                    # If the character at the left pointer is the same as c, reduce count
                    if s[l] == c:
                        count -= 1
                    # Move the left pointer to the right to shrink the window
                    l += 1
                    
                # Update the result with the maximum length of the window we've encountered
                res = max(res, r - l + 1)

        # Return the maximum length of the valid substring found
        return res
