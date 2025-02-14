import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 방향 정의(상, 하, 좌, 우)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cr = pos[0];
            int cc = pos[1];
            
            if (cr == n - 1 && cc == m - 1) {
                return maps[cr][cc];  // 최단 거리 반환
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1) {
                    queue.add(new int[]{nr, nc});
                    maps[nr][nc] = maps[cr][cc] + 1;
                }
            }
        }
        
        
        return -1;
    }
    
}
