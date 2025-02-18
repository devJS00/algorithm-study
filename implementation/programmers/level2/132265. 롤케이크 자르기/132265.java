import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        
        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }
        
        Set<Integer> leftSet = new HashSet<>();
        
        for(int t : topping) {
            
            leftSet.add(t); // 철수가 가질 토핑 종류 추가
            rightMap.put(t, rightMap.get(t) - 1);
            
            if (rightMap.get(t) == 0) {
                rightMap.remove(t);
            }
            
            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
            
        }
        
        return answer;
    }
}
