import java.util.*;

class Solution {
    int maxCount;
    boolean[] visited;
    int[][] Dungeons;
    
    private void backtrack(int k, int count) {
        for (int i = 0; i < Dungeons.length; i++) {
            if (!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;
                backtrack(k - Dungeons[i][1], count + 1);
                maxCount = Math.max(maxCount, count + 1);
                visited[i] = false;
            }
        }       
    }
    
    public int solution(int k, int[][] dungeons) {      
        maxCount = 0;
        visited = new boolean[dungeons.length];
        Dungeons = dungeons;
        backtrack(k, 0);
        
        return maxCount;
    }
}
