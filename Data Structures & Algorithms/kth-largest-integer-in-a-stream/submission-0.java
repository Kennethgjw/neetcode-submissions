class KthLargest {
    private int k;
    private PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();

        for (int num: nums) {
            add(num);
        }    
    }
    
    public int add(int val) {
        heap.offer(val);

        if (heap.size() > k) {
            heap.poll();
        }

        System.out.println(heap.peek());
        return heap.peek();
    }
}
