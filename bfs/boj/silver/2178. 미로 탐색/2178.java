import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int result = findShortestPath(n, m, maze);

        System.out.println(result);

        br.close();
    }

    static int[] dc = {1, -1, 0, 0};
    static int[] dr = {0, 0, 1, -1};

    private static int bfs(int n, int m, int[][] maze) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int cr = point[0];
            int cc = point[1];

            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if(maze[nr][nc] == 1) {
                    maze[nr][nc] = maze[cr][cc] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return maze[n - 1][m - 1];
    }

    private static int findShortestPath(int n, int m, int[][] maze) {
        int result = bfs(n, m, maze);
        return result;
    }
}
