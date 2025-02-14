class Solution {
    int[] apeach;
    int[] bestShot;
    int maxDiff;
    
    void backtrack(int n, int idx, int[] ryan) {
        if (idx == 11 || n == 0) { // 11번째 점수까지 확인했거나 화살을 다 썼을 때
            ryan[10] += n; // 같은 점수 차이일 때 처리 위해 필요함
            int ryanScore = 0, apeachScore = 0;

            for (int i = 0; i < 11; i++) {
                if (ryan[i] > apeach[i]) ryanScore += (10 - i);
                else if (apeach[i] > 0) apeachScore += (10 - i);
            }
            
            if (ryanScore - apeachScore > maxDiff) {
                maxDiff = ryanScore - apeachScore;
                bestShot = ryan.clone();
            } else if (ryanScore - apeachScore == maxDiff) { 
                for (int i = 10; i >= 0; i--) { 
                    if (ryan[i] > bestShot[i]) { 
                        bestShot = ryan.clone();
                        break;
                    } else if (ryan[i] < bestShot[i]) {
                        break;
                    }
                }
            }
            
            ryan[10] -= n;
            return;
            
        }
        
        backtrack(n, idx + 1, ryan); // 현재 점수를 포기하고 다음 점수로 이동
        
        if (n > apeach[idx]) {
            ryan[idx] = apeach[idx] + 1; // 어피치보다 1발 더 쏘기
            backtrack(n - ryan[idx], idx + 1, ryan); 
            ryan[idx] = 0; 
        }
        
    }
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        bestShot = new int[11];
        maxDiff = 0;
        
        backtrack(n, 0, new int[11]);   
        return maxDiff > 0 ? bestShot : new int[]{-1};
    }
}  
