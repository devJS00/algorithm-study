import sys

sys.setrecursionlimit(10**4)

# 방향 정의
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(x, y):
    land[y][x] = 0  # 방문한 땅은 0으로 만들어줌
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if (0 <= nx < m) and (0 <= ny < n):
            if land[ny][nx] == 1:  # 방문하지 않은 땅인 경우
                dfs(nx, ny)


t = int(input())  # 테스트 케이스 개수 입력

for _ in range(t):
    answer = 0
    m, n, k = map(int, input().split())
    land = [[0] * m for _ in range(n)]

    # 배추가 심어진 땅 표시
    for _ in range(k):
        x, y = map(int, input().split())
        land[y][x] = 1

    for y in range(n):
        for x in range(m):
            if land[y][x] == 1:  # 방문하지 않은 배추가 있다면
                dfs(x, y)  # 해당 영역 탐색
                answer += 1
    print(answer)
