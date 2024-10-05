import sys
sys.setrecursionlimit(10**4)

# 이동할 방향 정의
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

def dfs(x, y):
    stack = [(x, y)] # 시작 노드 스택에 넣어줌
    visited[x][y] = 1 # 시작 노드 방문 표시

    # 스택이 빌 때까지 반복
    while stack:
        cx, cy = stack.pop()
        for i in range(8):
            # 현재 위치에서 8가지 방향으로의 위치 확인
            nx = dx[i] + cx
            ny = dy[i] + cy
            if 0 <= nx < h and 0 <= ny < w: # 지도를 벗어나면 무시
                if graph[nx][ny] == 1 and visited[nx][ny] == 0: # 땅이고 아직 방문하지 않은 노드인 경우
                    stack.append((nx, ny))
                    visited[nx][ny] = 1 # 방문 표시


while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0: # 입력의 마지막 줄
        break
    answer = 0
    graph = []
    visited = [[0] * w for _ in range(h)] # 방문 정보 표현

    for i in range(h):
        graph.append(list(map(int, input().split()))) # 지도 정보 입력

    for i in range(h):
        for j in range(w):
            if graph[i][j] == 1 and visited[i][j] == 0:
                dfs(i, j)
                answer += 1

    print(answer)
