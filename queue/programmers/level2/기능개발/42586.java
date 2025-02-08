import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int daysLeft = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.add(daysLeft);
        }
        
        while(!queue.isEmpty()) {
            int deployDay = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && queue.peek() <= deployDay) {
                queue.poll();
                count++;
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
