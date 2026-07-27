class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int [k];

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            if (!freq.containsKey(num)) {
                freq.put(num, 1);
            } else {
                freq.put(num, freq.get(num)+1);
            }
        }

        System.out.println(freq);

        // Extract keys
        Integer[] keySet = freq.keySet().toArray(new Integer[0]);

        // Sort numbers by frequency, highest first
        Arrays.sort(keySet, (a, b) -> freq.get(b) - freq.get(a));

        for (int i = 0; i < k; i++) {
            result[i] = keySet[i];
        }

        return result;
    }
}
