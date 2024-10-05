n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)


def dfs(node):
    visited[node] = True
    for g in graph[node]:
        if not visited[g]:
            dfs(g)


answer = 0
for i in range(1, n + 1):
    # 해당 노드를 방문하지 않았으면 DFS 실행
    if not visited[i]: 
        answer += 1
        dfs(i)

print(answer)
