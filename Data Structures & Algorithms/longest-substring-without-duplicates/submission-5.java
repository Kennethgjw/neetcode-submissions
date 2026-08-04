class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();

        int l = 0;
        int r = 0;
        int longest = 0;

        while (r < s.length()) {
            char current = s.charAt(r);

            if (!seen.contains(current)) {
                seen.add(current); // add the current into the hash set
                r++; // move window to the right
            } else { // duplicate
                seen.remove(s.charAt(l)); // r does not move when duplicate found
                l++;
            }
            int currentLength = r - l;
            longest = Math.max(longest, currentLength); // is it the longest?
        }

        return longest;
    }
}
