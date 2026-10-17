class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int l = 0;
        int r = 0;
        int longest = 0;

        while (r < s.length()) {
            char curr = s.charAt(r);

            // check if we seen the char before
            if (!seen.contains(curr)) {
                seen.add(curr);
                r++;
            } else {
                seen.remove(s.charAt(l));
                l++;
            }
            
            int currentLength = r - l;
            longest = Math.max(currentLength, longest);
        }

        return longest;
    }
}
