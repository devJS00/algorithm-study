import sys
from collections import deque

input = sys.stdin.readline
n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]
answer = [[0] * m for _ in range(n)]
direction = [(-1,0),(1,0),(0,-1),(0,1)]

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y] = 1
    while q:
        x,y = q.popleft()
        for dx,dy in direction:
            nx,ny = x+dx,y+dy
            if 0<=nx<n and 0<=ny<m and visited[nx][ny] == 0:
                if graph[nx][ny] == 1:
                    visited[nx][ny] = 1
                    answer[nx][ny] = answer[x][y] + 1
                    q.append((nx,ny))
                else :
                    answer[nx][ny] = 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            bfs(i,j)


for i in range(n):
    for j in range(m):
        if visited[i][j] == 0 and graph[i][j] == 1:
            answer[i][j] = -1
    print(*answer[i])
