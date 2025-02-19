import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b});
        }

        int[] parents = findParents(N, edges);

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }

        br.close();
    }

    static int[] visited;
    static int[] parents;

    private static void dfs(int node, ArrayList<Integer>[] graph) {
        for (int n : graph[node]) {
            if (visited[n] == 0) {
                visited[n] = 1;
                parents[n] = node;
                dfs(n, graph);
            }
        }
    }

    private static int[] findParents(int N, List<int[]> edges) {
        visited = new int[N + 1];
        parents = new int[N + 1];

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1, graph);

        return parents;
    }
}
