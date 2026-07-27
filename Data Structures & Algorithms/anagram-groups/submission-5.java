class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String word: strs) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);

            String key = new String(letters);

            // Check if key exists in map
            // If does not exist, create a new Array List
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }

            // If exists, find the key and add it to that array
            result.get(key).add(word);
        }

        return new ArrayList<>(result.values());
    }
}
