def solution(n, lost, reserve):
    answer = 0
    # 여벌 체육복을 가지고 있지만 도난당한 학생은, 도난 명단과 여벌 명단에서 모두 제외
    for i in range(1, n+1):
        if i in lost and i in reserve:
            lost.remove(i)
            reserve.remove(i)
            
    for i in range(1, n+1):
        if i in lost:
            # 최대한 많은 학생이 체육복을 빌릴 수 있도록 하기 위해서는 앞번호 학생에게 먼저 빌리는 것이 유리
            if i-1 in reserve:
                reserve.remove(i-1)
                answer += 1
            elif i+1 in reserve:
                reserve.remove(i+1)
                answer += 1
        else:
            answer += 1
    
    return answer
