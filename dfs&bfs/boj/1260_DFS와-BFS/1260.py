from collections import deque

def dfs(v):
    visited_dfs[v] = True
    print(v, end = ' ')

    for i in range(1, len(graph[v])):
        if not visited_dfs[i] and graph[v][i] == 1:
            dfs(i)

def bfs(v):
    queue = deque([v])
    visited_bfs[v] = True
    while queue:
        v = queue.popleft()
        print(v, end = ' ')
        for i in range(1, len(graph[v])):
            if not visited_bfs[i] and graph[v][i] == 1:
                queue.append(i)
                visited_bfs[i] = True


# N, M, V를 공백을 기준으로 구분하여 입력 받기
n, m, v = map(int, input().split())

# 2차원 리스트의 맵 정보 입력 받기
graph = [[False]*(n+1) for _ in range(n+1)]

visited_dfs = [False] * (n+1)
visited_bfs = [False] * (n+1)

for i in range(m):
    x, y = (map(int, input().split()))
    # 연결된 정점 표시
    graph[x][y] = 1
    graph[y][x] = 1

dfs(v)
print()
bfs(v)
