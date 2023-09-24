def solution(arr):
    answer = [arr[0]] # 스택에 arr의 첫 번째 숫자를 넣음
    for i in range(len(arr)):
        if arr[i] == answer[-1]: # 스택에 마지막으로 들어간 숫자와 같으면
            continue # 넣지 않음
        else: answer.append(arr[i])
    return answer
