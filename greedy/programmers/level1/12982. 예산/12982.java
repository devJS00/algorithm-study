import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        int idx = 0;
        for(int amount : d) { 
            if(budget < amount) {
                break;
            }
            answer++;  
            budget -= amount;
        }
        
        return budget >= 0 ? answer : answer - 1;
    }
}
