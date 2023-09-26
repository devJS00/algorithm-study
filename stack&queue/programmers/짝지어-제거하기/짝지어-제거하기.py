def solution(s):
    answer = -1
    stack = []
    for i in s:
        if stack != [] and stack[-1] == i: # 이번 문자가 스택 맨 위에 있는 문자와 같은 경우
            stack.pop() # 이번 문자를 스택에 넣지 않고 맨 위에 있는 문자를 스택에서 꺼냄 -> 짝지어 제거
        else: stack.append(i) # 다른 경우 문자를 스택에 넣음
        
    if stack == []: # 실행이 끝난 후 스택이 비어있으면
        answer = 1 # 성공
    else: answer = 0 # 아니면 실패
    
    return answer
