from collections import deque

def solution(progresses, speeds):
    answer = []
    que = deque()
    # 큐에 progresses의 요소들 넣기
    for i in range(len(progresses)):
        que.append([progresses[i], speeds[i]])
    
    # 큐가 빌 때까지 반복
    while len(que) != 0:
        # 작업 진도 업데이트
        for i in range(len(que)): 
            que[i][0] += que[i][1]
            
        if que[0][0] >= 100: # 큐의 맨 앞에 있는 작업이 완료된 경우
            cnt = 0
            # 뒤에 연달아서 완료된 작업들과 함께 큐에서 빼기
            while len(que) != 0 and que[0][0] >= 100: 
                que.popleft()
                cnt += 1 # 빠져나간 작업의 수 세기
            answer.append(cnt)
            
    return answer
