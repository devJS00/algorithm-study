import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        // 부모 관계 저장하는 해시맵 생성
        HashMap<String, String> parent = new HashMap<>(); 
        for(int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }
        
        // 각 판매원의 이익금 저장하는 해시맵 생성
        Map<String, Integer> total = new HashMap<>();
        
        for (int i = 0; i < seller.length; i++) {
            String curName = seller[i];
            int money = amount[i] * 100;
            
            while (!curName.equals("-") && money > 0) {
                int distribute = money / 10;  // 10% 계산
                int remain = money - distribute; // 남은 금액
                
                total.put(curName, total.getOrDefault(curName, 0) + remain);
                curName = parent.get(curName);
                money = distribute;              
            }
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
           
        return answer;
    }
}
