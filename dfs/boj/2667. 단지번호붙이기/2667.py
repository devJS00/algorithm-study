n = int(input())

# 2차원 리스트의 맵 정보 입력 받기
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

visited = [[0] * n for _ in range(n)]

count = 0  # 현재 단지 내 집의 수를 카운팅할 변수
complex = []  # 각 단지별 집의 수를 저장할 리스트


def dfs(x, y):
    global count
    # 주어진 범위를 벗어나는 경우에는 즉시 종료
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False

    if graph[x][y] == 1 and visited[x][y] == 0:  # 현재 위치가 집(1)이면서 아직 방문하지 않은 곳인 경우
        visited[x][y] = 1
        count += 1
        # 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)
        return True

    return False


for i in range(n):
    for j in range(n):
        if dfs(i, j):
            complex.append(count)
            count = 0  # 다음 단지를 위한 카운팅 변수 초기화

print(len(complex))
complex.sort()
for c in complex:
    print(c)
