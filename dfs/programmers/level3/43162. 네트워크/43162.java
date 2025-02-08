class Solution {
    private boolean[] visited;
    private int[][] computer;
    
    private void dfs(int node) {
        visited[node] = true;  
         for (int i = 0; i < computer.length; i++) {
            if (computer[node][i] == 1 && !visited[i]) { // 연결된 컴퓨터가 있고, 아직 방문하지 않았다면
                dfs(i);
            }
        }
        
    }
    
    public int solution(int n, int[][] computers) {
        computer = computers;
        visited = new boolean[n];
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {  // 방문하지 않은 컴퓨터라면 DFS 수행
                dfs(i);
                count++; 
            }
        }
        
        return count;
    }
}
