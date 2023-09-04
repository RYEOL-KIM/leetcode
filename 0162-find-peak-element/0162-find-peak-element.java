class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // 현재 요소가 다음 요소보다 크면 왼쪽 부분을 탐색
                right = mid;
            } else {
                // 다음 요소가 현재 요소보다 크면 오른쪽 부분을 탐색
                left = mid + 1;
            }
        }

        // left와 right가 같은 위치에서 루프가 종료되면 피크 요소의 인덱스가 됩니다.
        return left;
    }
}