import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]> trustRelationships = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            trustRelationships.add(new int[]{A, B});
        }

        List<Integer> result = findMostHackableComputers(N, trustRelationships);

        for (int computer : result) {
            System.out.print(computer + " ");
        }

        br.close();
    }

    static int maxCount;

    private static int dfs(int node, ArrayList<Integer>[] graph, boolean[] visited, ArrayList<Integer> hackable) {
        visited[node] = true;
        int count = 1;

        for(int n : graph[node]) {
            if(!visited[n]) {
                count += dfs(n, graph, visited, hackable);
            }
        }
        return count;
    }

    private static List<Integer> findMostHackableComputers(int N, List<int[]> trustRelationships) {
        // 컴퓨터 간의 신뢰 관계를 그래프로 표현
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] trustRelationship : trustRelationships) {
            graph[trustRelationship[1]].add(trustRelationship[0]);
        }

        maxCount = 0;
        ArrayList<Integer> result = new ArrayList<>();

        ArrayList<Integer>[] hackables = new ArrayList[N + 1]; // 각 컴퓨터가 해킹할 수 있는 컴퓨터들을 저장하기 위한 리스트
        for(int i = 0; i < N + 1; i++) {
            hackables[i] = new ArrayList<>();
        }

        for(int i = 1; i < N + 1; i++) {
            boolean[] visited = new boolean[N + 1];
            ArrayList<Integer> hackable = new ArrayList<>();
            int count = dfs(i, graph, visited, hackable);

            if(count > maxCount) {
                maxCount = count;
                result.clear();
                result.add(i);
            } else if(count == maxCount) {
                result.add(i);
            }
        }

        return result;
    }
}
