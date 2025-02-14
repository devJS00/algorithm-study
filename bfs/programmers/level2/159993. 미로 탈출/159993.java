import java.util.*;

class Solution {
    static int[] dc = {-1, 1, 0, 0}; 
    static int[] dr = {0, 0, -1, 1};
    
    static String[] map;
    static int n, m;
    
    private int bfs(int startC, int startR, int targetC, int targetR) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        int dist = 0;

        queue.add(new int[]{startC, startR, dist});
        visited[startC][startR] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cc = cur[0];
            int cr = cur[1];
            int curDist = cur[2];
            
            if(cc == targetC && cr == targetR) {
                return curDist;
            }
            
            for(int i = 0; i < 4; i++) {
                int nc = cc + dc[i];
                int nr = cr + dr[i];
                
                if (nc >= 0 && nc < n && nr >= 0 && nr < m && !visited[nc][nr] && map[nc].charAt(nr) != 'X') {
                    queue.add(new int[]{nc, nr, curDist + 1});
                    visited[nc][nr] = true;
                }
               
            }
        }
        
        return -1;
    }
    
    
    public int solution(String[] maps) {
        int answer = 0;
        map = maps;
        n = maps.length;
        m = maps[0].length();
        
        // 시작점(S), 레버(L), 출구(E) 위치 찾기
        int startC = 0, startR = 0, leverC = 0, leverR = 0, exitC = 0, exitR = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    startC = i; startR = j;
                } else if (c == 'L') {
                    leverC = i; leverR = j;
                } else if (c == 'E') {
                    exitC = i; exitR = j;
                }
            }
        }
        
        int toLever = bfs(startC, startR, leverC, leverR);
        int toExit = bfs(leverC, leverR, exitC, exitR);
        
        if(toLever == -1 || toExit == -1) {
            return -1;
        }
        else {
            return toLever + toExit;
        }
    }
}
