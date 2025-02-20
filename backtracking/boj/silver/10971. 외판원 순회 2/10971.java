import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시의 개수

        W = new int[N][N]; // 비용 행렬
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minCost = solveTSP(); 

        System.out.println(minCost); 

        br.close();
    }

    static int minCost = Integer.MAX_VALUE;

    private static void backtracking(int start, int cur, int cost, ArrayList<Integer> path) {
        if(path.size() == N) {
            if(W[cur][start] != 0) {  // 시작 도시로 돌아갈 수 있는 길이 있는 경우
                minCost = Math.min(minCost, cost + W[cur][start]);
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(W[cur][i] != 0 && !path.contains(i)) {  // 길이 있고, 방문하지 않은 도시인 경우
                path.add(i);
                backtracking(start, i, cost + W[cur][i], path);
                path.remove(path.size() - 1);

            }
        }
    }

    private static int solveTSP() {
        for(int i = 0; i < N; i++) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(i);  // 시작 도시 추가
            backtracking(i, i,0, path);
        }
        return minCost;
    }
}
