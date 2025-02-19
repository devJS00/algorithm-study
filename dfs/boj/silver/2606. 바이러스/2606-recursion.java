import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<int[]> connections = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connections.add(new int[]{a, b});
        }

        int infectedCount = getInfectedComputerCount(n, connections);

        System.out.println(infectedCount);

        br.close();
    }

    private static int[] visited;
    static int count;

    private static void dfs(int n, ArrayList<Integer>[] graph) {
        visited[n] = 1;
        count++;
        for(int node : graph[n]) {
            if(visited[node] == 0) {
                dfs(node, graph);
            }
        }
    }

    private static int getInfectedComputerCount(int n, List<int[]> connections) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]); // 양방향 그래프이므로 반대 방향도 추가
        }

        visited = new int[n + 1];
        count = 0;
        dfs(1, graph);
        return count - 1;
    }
}
