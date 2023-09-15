public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[target + 1];

        queue.offer(1); // 시작 위치
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == target) {
                    return moves;
                }

                for (int next = curr + 1; next <= Math.min(curr + 6, target); next++) {
                    int[] coordinates = getCoordinates(next, n);
                    int row = coordinates[0];
                    int col = coordinates[1];

                    int destination = board[row][col] == -1 ? next : board[row][col];

                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            moves++;
        }

        return -1; // 목적지에 도달할 수 없는 경우
    }

    // 번호로부터 좌표 (행과 열)를 얻는 함수
    private int[] getCoordinates(int num, int n) {
        int row = (num - 1) / n;
        int col = (num - 1) % n;
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        row = n - 1 - row;
        return new int[]{row, col};
    }
}