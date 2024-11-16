def solution(number, k):
    stack = []
    
    for num in number:
        # 스택이 비어 있지 않고, k가 남아 있고, 현재 숫자가 스택의 마지막 숫자보다 크면 숫자를 제거
        while stack and k > 0 and stack[-1] < num:
            stack.pop()
            k -= 1  # 제거할 수 있는 숫자 수 감소
        
        stack.append(num)  # 스택에 현재 숫자를 추가
    
    # 만약 제거할 숫자가 남아있다면 스택의 끝에서 제거
    if k > 0:
        stack = stack[:-k]
        
    answer = ''.join(stack)
    
    return answer
