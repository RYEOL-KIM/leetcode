/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> cloneMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // 이미 복사한 노드인 경우, 복사본을 반환
        if (cloneMap.containsKey(node)) {
            return cloneMap.get(node);
        }

        // 새로운 노드 생성
        Node clonedNode = new Node(node.val, new ArrayList<>());
        cloneMap.put(node, clonedNode);

        // 이웃 노드들을 복사하고 연결
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }

        return clonedNode;
    }
}