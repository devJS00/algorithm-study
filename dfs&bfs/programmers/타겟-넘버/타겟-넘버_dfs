def solution(numbers, target):
    answer = 0
    stack = [[numbers[0],0], [-numbers[0],0]] # 첫 번째 정수를 더하면서 시작하는 경우, 빼면서 시작하는 경우와 인덱스
    while stack:
        result, idx = stack.pop()
        idx += 1
        if idx != len(numbers): # 아직 모든 숫자를 쓰지 않은 상태
            stack.append([result+numbers[idx], idx]) 
            stack.append([result-numbers[idx], idx])
        else: # 마지막 숫자까지 사용한 상태
            if result == target: # 계산 결과와 타겟 넘버가 같으면
                answer += 1 # answer 1 증가
    return answer
