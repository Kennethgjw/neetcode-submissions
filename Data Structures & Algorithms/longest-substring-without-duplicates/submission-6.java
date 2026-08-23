class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();

        int l = 0;
        int r = 0;
        int longest = 0;

        while (r < s.length()) {
            char current = s.charAt(r);

            // check if we seen before
            if (!seen.contains(current)) {
                // if not seen, we add it to HashSet
                // r++
                seen.add(current);
                r++;
            } else { // matches
                seen.remove(s.charAt(l));
                l++;
            }
            int currentLength = r - l;
            longest = Math.max(currentLength, longest);
        }

        return longest;
    }
}
