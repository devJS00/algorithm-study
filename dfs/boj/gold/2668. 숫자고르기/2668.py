n = int(input())
graph = [0]  # 그래프를 저장할 리스트. 0번째 인덱스는 비워두고 1부터 N까지 사용

for i in range(n):
    graph.append(int(input()))

result = []


def dfs(node, start, route):
    route.append(node)
    if graph[node] in route and graph[node] == start:  # 만약 그래프의 다음 노드가 처음 시작 노드와 동일하다면
        result.append(graph[node])  # 사이클을 이루는 시작 노드를 결과에 추가

    elif graph[node] not in route:
        dfs(graph[node], start, route)


for i in range(1, n + 1):
    r = []  # 각 노드에 대해 새로운 경로(route)를 기록
    dfs(i, i, r)

result.sort()
print(len(result))

for r in result:
    print(r)
