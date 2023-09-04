/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
            // head가 노드이거나 연결 리스트 노드가 아닌 경우 head 반환, 연결리스트 노드만 처리
        if (head == null || head.next == null) {
            return head;
        }

        // slow는 이전 노드, fast는 다음 노드
        ListNode slow = head;
        ListNode fast = head.next;

        // slow 포인터는 한 칸씩 이동, fast 포인터는 두 칸씩 이동
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 중간 인덱스 저장
        ListNode mid = slow.next;
        // 노드 연결리스트 끊기
        slow.next = null;

        // 더 작은 연결 리스트로 계속해서 쪼개기
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // 더미 노드 생성
        ListNode tmp = new ListNode(0);
        ListNode ref = tmp;

        // 왼쪽과 오른쪽 연결 리스트가 존재한다면
        while (left != null && right != null) {
            // 왼쪽 노드 값이 더 작다면
            if (left.val < right.val) {
                // 왼쪽 노드를 더미 노드 다음 노드에 연결
                tmp.next = left;
                // left 연결리스트는 다음 노드로 이동
                left = left.next;
            } else {
                // 오른쪽 노드를 더미 노드 다음 노드에 연결
                tmp.next = right;
                // right 연결리스트 다음 노드로 이동
                right = right.next;
            }
            // 더미 노드 오른쪽 이동
            tmp = tmp.next;
        }

        // 마지막으로 남은 노드는 가장 큰 노드이므로 가장 마지막에 더미 노드와 연결
        tmp.next = (left != null) ? left : right;

        // 더미 노드 다음 노드 (헤드 노드 반환)
        return ref.next;        
    }
}