from collections import deque
    
def solution(maps):
    answer = 0
    
    # 이동 방향 정의(상하좌우)
    dx = [-1, 1, 0 , 0] 
    dy = [0, 0, -1, 1] 
    
    # bfs 함수 구현
    def bfs(x, y):
        queue = deque()
        queue.append((x, y)) # 시작 위치 큐에 넣음
        
        while queue: # 큐가 빌 때 까지
            x, y = queue.popleft() # 큐에서 위치 꺼냄
            # 현재 위치에서 상하좌우로의 위치 확인
            for i in range(4):  
                nx = x + dx[i]
                ny = y + dy[i]
                   
                # 공간을 벗어난 경우 무시    
                if nx < 0 or nx >= len(maps) or ny < 0 or ny >= len(maps[0]): 
                    continue       
                # 벽이면 무시
                if maps[nx][ny] == 0:
                    continue
            
                if maps[nx][ny] == 1: # 갈 수 있는 칸인 경우
                    maps[nx][ny] = maps[x][y] + 1 # 노드에 현재까지의 거리 기록
                    queue.append((nx, ny)) # 새로운 위치 큐에 추가
                    
        return maps[len(maps)-1][len(maps[0])-1] # 맨 오른쪽 아래 칸에 최단 거리 저장되어 있음
    
    answer = bfs(0, 0) # bfs 함수 실행 
    if answer == 1:
        answer = -1
    
    return answer
