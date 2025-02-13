import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        
        // 원하는 제품 목록을 해시맵에 저장
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 슬라이딩 윈도우 탐색
        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> discount10d = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
            }   
            
            // 할인하는 상품의 개수가 원하는 수량과 일치하는지 확인 
            if (wantMap.equals(discount10d)) {
                answer++;
            }
        
        }
        
        return answer;
    }
}
