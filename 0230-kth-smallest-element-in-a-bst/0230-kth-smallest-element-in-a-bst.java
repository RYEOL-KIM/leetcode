/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // 중위 순회를 위한 스택
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                // 현재 노드를 스택에 추가하고 왼쪽 자식 노드로 이동
                stack.push(current);
                current = current.left;
            }
            
            // 스택에서 노드를 꺼내고 카운트 감소
            current = stack.pop();
            k--;
            
            // k가 0이면 k번째 작은 값을 찾은 것이므로 반환
            if (k == 0) {
                return current.val;
            }
            
            // 오른쪽 자식 노드로 이동
            current = current.right;
        }
        
        return -1; // 문제에서 보장된 조건을 만족하지 않으면 -1을 반환하거나 예외를 던질 수 있습니다       
    }
}