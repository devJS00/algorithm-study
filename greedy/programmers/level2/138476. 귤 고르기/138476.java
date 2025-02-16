import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int t : tangerine) {
            countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        }
        
        ArrayList<Integer> counts = new ArrayList<>(countMap.values());
        Collections.sort(counts, Collections.reverseOrder());
        
        int sum = 0, kind = 0;
        for (int count : counts) {
            sum += count;
            kind++; 
            if (sum >= k) break; 
        }

        return kind; 
    }
}
