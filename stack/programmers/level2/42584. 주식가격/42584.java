import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] sec = new int[prices.length];
        
        stack.push(0);
        
        for(int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int temp = stack.pop();
                sec[temp] = i - temp;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int temp = stack.pop();
            sec[temp] = prices.length - temp - 1;        
        }
               
        return sec;
    }
}
