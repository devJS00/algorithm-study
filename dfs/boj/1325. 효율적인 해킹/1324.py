def dfs(i):
    cnt = 0
    visited = [False] * (n + 1)
    stack.append(i)
    visited[i] = True

    while stack:
        val = stack.pop()
        result[i] += 1
        for j in graph[val]:
            if not visited[j]:
                stack.append(j)
                visited[j] = True

# N, M을 공백을 기준으로 구분하여 입력 받기
n, m = map(int, input().split())

# 인접 리스트 방식으로 그래프 표현
graph = [[] for _ in range(n+1)]
for i in range(m):
    x, y = (map(int, input().split()))
    graph[y].append(x)

result = [0] * (n+1)
stack = []

for i in range(1, n+1):
    dfs(i)

max_result = max(result)

for i in range(1, n+1):
    if result[i] == max_result: # 결과가 최댓값과 같으면 출력
        print(i, end=" ")
