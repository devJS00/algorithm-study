import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE; // 최소 차이를 저장할 변수

        for (int i = 0; i < wires.length; i++) {

            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int j = 0; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // 하나의 간선을 제외하고 그래프 생성
                graph[wires[j][0]].add(wires[j][1]);
                graph[wires[j][1]].add(wires[j][0]);
            }

            boolean[] visited = new boolean[n + 1];
            int size1 = bfs(graph, visited, wires[i][0]); // 한쪽 네트워크 크기
            int size2 = n - size1; // 다른 네트워크 크기

            minDiff = Math.min(minDiff, Math.abs(size1 - size2));
        }

        return minDiff;
    }

    private int bfs(ArrayList<Integer>[] graph, boolean[] visited, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    count++;
                }
            }
        }

        return count;
    }
}
