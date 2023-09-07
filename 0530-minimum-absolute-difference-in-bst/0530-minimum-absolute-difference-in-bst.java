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
    private TreeNode prevNode;
    private int minDiff;
    
    public int getMinimumDifference(TreeNode root) {
        // 초기값 설정
        minDiff = Integer.MAX_VALUE;
        prevNode = null;
        
        // 중위 순회를 통해 노드를 방문하면서 최소 차이 계산
        inorderTraversal(root);
        
        return minDiff;
    }
    
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        // 왼쪽 서브트리 순회
        inorderTraversal(node.left);
        
        // 현재 노드와 이전 노드 간의 차이 계산 및 업데이트
        if (prevNode != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prevNode.val));
        }
        prevNode = node;
        
        // 오른쪽 서브트리 순회
        inorderTraversal(node.right);
    }
}