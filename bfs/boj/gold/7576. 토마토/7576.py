from collections import deque

m, n = map(int, input().split())

graph = []

for _ in range(n):
    graph.append(list(map(int, input().split())))

direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]

min_days = 1  # 이미 모든 토마토가 익어있는 경우를 위해 1로 초기화


def bfs():
    global min_days
    q = deque()
    # 익은 토마토가 있는 좌표를 큐에 추가. 시작점이 여러 개 있는 경우 이렇게 처리
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                q.append([i, j])
    while q:
        x, y = q.popleft()
        # 상, 하, 좌, 우 네 방향으로 이동 시도
        for dx, dy in direction:
            nx, ny = x + dx, y + dy
            # 다음 좌표가 그래프 범위를 벗어나면 무시
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                if graph[nx][ny] > min_days:
                    min_days = graph[nx][ny]
                q.append((nx, ny))


bfs()

# BFS가 끝난 후에도 익지 않은 토마토가 남아 있으면 -1을 출력하고 프로그램 종료
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            print(-1)
            exit(0)

print(min_days - 1)  # 모든 토마토가 익었다면, min_days에서 초기 값(1)을 빼서 최소 날짜을 출력
