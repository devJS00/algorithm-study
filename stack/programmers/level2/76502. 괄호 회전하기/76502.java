import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        int n = s.length();
        
        String rotated = s; 
        
        for (int i = 0; i < n; i++) {
            if (isValid(rotated)) {
                count++; 
            }
            rotated = rotated.substring(1) + rotated.charAt(0); // 왼쪽 회전
        }
        
        return count;
    }
    
    // 올바른 괄호 문자열인지 확인하는 함수 (스택 사용)
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false; // 닫는 괄호가 먼저 나오는 경우
                
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == ']' && top != '[') || 
                    (c == '}' && top != '{')) {
                    return false; // 올바른 짝이 아님
                }
            }
        }
        
        return stack.isEmpty(); // 마지막에 스택이 비어 있어야 올바른 괄호 문자열
    }
}
