import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<Integer>();
    boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        dfs("", numbers);    
        answer = set.size();
        
        return answer;
    }
    
    private void dfs(String s, String numbers) {
        if(s.length() != 0 && isPrime(Integer.parseInt(s))) {
            set.add(Integer.parseInt(s));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i] == false) {
                visited[i] = true;
                dfs(s + numbers.charAt(i), numbers);
                visited[i] = false;
            }   
        }
    }
    
     private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
}
