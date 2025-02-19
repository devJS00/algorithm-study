import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] distance = calculateDistances(n, m, map);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(distance[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    static int dc[] = {1, -1, 0, 0};
    static int dr[] = {0, 0, 1, -1};
    static int[][] distance;

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        int count = 1;
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            x = point[0];
            y = point[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dc[i];
                int ny = y + dr[i];
                if(nx >= 0 && ny >= 0 && nx < distance.length && ny < distance[0].length && distance[nx][ny] == -1) {
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static int[][] calculateDistances(int n, int m, int[][] map) {
        distance = new int[n][m];
        int destX = 0;
        int destY = 0;

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                distance[i][j] = -1;
                if(map[i][j] == 0) { // 벽인 경우
                    distance[i][j] = 0;
                }
                if(map[i][j] == 2) { // 도착지점인 경우
                    distance[i][j] = 0;
                    destX = i;
                    destY = j;
                }
            }
        }

        bfs(destX, destY);

        return distance;
    }
}
