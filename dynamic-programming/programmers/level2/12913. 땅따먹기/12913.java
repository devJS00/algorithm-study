import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for(int i = 1 ; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                int max = 0;
                for(int k = 0; k < 4; k++) { // 이전 줄에서 가장 큰 값 찾기
                    if(k != j) {
                        max = Math.max(max, land[i - 1][k]);
                    }
                }
                land[i][j] += max;
            }
        }
        
        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }
}
