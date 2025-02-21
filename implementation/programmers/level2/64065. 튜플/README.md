import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        ArrayList<Integer> result = new ArrayList<>();
        
        s = s.substring(2, s.length() - 2);  // "{{ }}" 제거
        String[] sArr = s.split("},\\{");   // "},{" 기준으로 분리
        
        Arrays.sort(sArr, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        
         for (String str : sArr) {
            for (String sNum : str.split(",")) {
                int iNum = Integer.parseInt(sNum);
                if(!result.contains(iNum)) {
                     result.add(iNum);
                }   
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}
