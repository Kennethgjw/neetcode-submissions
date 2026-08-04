class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int l = 0;
        int longest = 0;
        int highestFrequency = 0;

        // move right pointer across string
        for (int r = 0; r < s.length(); r++) {
            char current = s.charAt(r);

            // add current char to frequency map
            count.put(current, count.getOrDefault(current, 0) + 1);

            highestFrequency = Math.max(highestFrequency, count.get(current));

            int windowLength = r - l + 1; 
            int replacementNeeded = windowLength - highestFrequency;

            // Shrink window if we need more than k replacements
            while (replacementNeeded > k) {
                char leftChar = s.charAt(l);

                // remove one occurence of the character that is leaving the window
                count.put(leftChar, count.get(leftChar) - 1);
                l++; // move left pointer forward

                windowLength = r - l + 1; // recalculate smaller windoow size
                replacementNeeded = windowLength - highestFrequency; // check how many replacements needed now
            }

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
