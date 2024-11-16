from collections import deque

n, m = map(int, input().split())

graph = []

for _ in range(n):
    graph.append(list(map(int, input().split())))

visited = [[False] * m for _ in range(m)]
result = [[0] * m for _ in range(m)]

direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    while q:
        x, y = q.popleft()
        # 상, 하, 좌, 우 네 방향으로 이동 시도
        for dx, dy in direction:
            nx, ny = x + dx, y + dy
            # 다음 좌표가 그래프 범위를 벗어나면 무시
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            if visited[nx][ny] == False and graph[nx][ny] == 1:  # 새로운 좌표가 방문하지 않았고, 값이 1일 경우
                visited[nx][ny] = True
                result[nx][ny] = result[x][y] + 1  # 이전 위치에서 거리 1 증가
                q.append((nx, ny))


for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            bfs(i, j)

for i in range(n):
    for j in range(m):
        if visited[i][j] == 0 and graph[i][j] == 1:
            result[i][j] = -1
    print(*result[i])
