class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
            return result;
        }
        
        // 최소 힙을 사용하여 쌍의 합이 작은 순서대로 추적
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        // 처음 k개의 쌍을 최소 힙에 초기화
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while (k > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int num1 = pair[0];
            int num2 = pair[1];
            int index2 = pair[2];
            
            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(num1);
            currentPair.add(num2);
            result.add(currentPair);
            
            // nums2 배열의 다음 요소로 이동
            if (index2 < nums2.length - 1) {
                minHeap.offer(new int[]{num1, nums2[index2 + 1], index2 + 1});
            }
            
            k--;
        }
        
        return result;
    }
}