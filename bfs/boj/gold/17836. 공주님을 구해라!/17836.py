from collections import deque

n, m, t = map(int, input().split())

graph = []

for _ in range(n):
    graph.append(list(map(int, input().split())))

visited = [[-1] * m for _ in range(n)]  # 방문 여부를 확인하는 리스트. 도달하는 데 걸리는 시간도 함께 저장

direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = 0
    use_gram = 10001
    while q:
        x, y = q.popleft()
        # 상, 하, 좌, 우 네 방향으로 이동 시도
        for dx, dy in direction:
            nx, ny = x + dx, y + dy
            # 다음 좌표가 그래프 범위를 벗어나면 무시
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            if visited[nx][ny] == -1 and graph[nx][ny] == 2:  # 다음 좌표에 검이 있는 경우(그래프 값이 2)라면
                use_gram = (visited[x][y] + 1) + (n - 1 - nx) + (m - 1 - ny)  # 현재까지의 시간 + 검에서 목적지까지의 거리

            if visited[nx][ny] == -1 and (graph[nx][ny] == 0 or graph[nx][ny] == 2):  # 다음 좌표가 이동할 수 있는 칸(0 또는 2)인 경우
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx, ny))

            if (nx, ny) == (n - 1, m - 1):
                return min(use_gram, visited[x][y] + 1)  # 검을 사용한 시간과 검을 사용하지 않은 시간 중 최솟값을 반환

    return use_gram  # 그람을 써야만 공주님에게 도달할 수 있는 경우가 있어 use_gram을 반환해야 함


result = bfs(0, 0)

if result <= t:
    print(result)
else:
    print('Fail')
