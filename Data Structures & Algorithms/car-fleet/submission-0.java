class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Store each car as: [position, speed]
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // sort cars by position descending
        // closest car first
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();

        for (int[] car : cars) {
            int pos = car[0];
            int spd = car[1];

            // time to take position
            double time = (double) (target - pos) / spd;
            
            // if car cannot catch up to car infront
            // forms a new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
