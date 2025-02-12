import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
         
        Queue<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));
        
        for(int i = 0; i < goal.length; i++) {
            if(!queue1.isEmpty() && queue1.peek().equals(goal[i])) {
                queue1.poll();
            }
            else if(!queue2.isEmpty() && queue2.peek().equals(goal[i])) {
                queue2.poll();
            }
            else {
                return "No";
            }
            
        }
        
        return "Yes";
    }
}
