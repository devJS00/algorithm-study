import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(String cloth : clothesMap.keySet()) {
            int temp = clothesMap.get(cloth);
            answer = answer * (temp + 1);
        }
        
        return answer - 1;
    }
}
