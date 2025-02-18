class Solution {
    public int[] solution(String s) {
        
        int countTransform = 0; // 변환 횟수
        int zeroCount = 0; // 제거한 0의 개수
        
        while (!s.equals("1")) {
            int ones = 0;
            
            for (char c : s.toCharArray()) {
                if (c == '1') ones++;
                else zeroCount++;
            }   
            s = Integer.toBinaryString(ones); // 길이를 2진수로 변환
            countTransform++;
        }
        
        return new int[]{countTransform, zeroCount};
    }
}
