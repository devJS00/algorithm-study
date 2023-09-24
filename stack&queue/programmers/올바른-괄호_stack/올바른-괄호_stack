def solution(s):
    answer = True
    stack = []
    
    # 첫 문자가 ')'이면 false return
    if s[0] == ')':
        return False
    
    for i in range(len(s)):
        # '(' 문자면 스택에 넣음
        if s[i] == '(':
            stack.append(s[i])
        # ')' 문자를 만나면 스택에서 '(' 꺼내기
        elif s[i] == ')' and len(stack) != 0:
            stack.pop()
    
    # 스택이 비어있지 않다면 false return
    if len(stack) != 0:
        answer = False

    return answer
