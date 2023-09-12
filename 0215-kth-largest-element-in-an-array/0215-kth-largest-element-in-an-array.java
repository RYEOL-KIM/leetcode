class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 최소 힙을 생성하고 배열의 요소를 삽입
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            
            // 힙의 크기가 k보다 크면 가장 작은 요소를 제거
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
}