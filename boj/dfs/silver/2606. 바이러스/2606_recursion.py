import sys
sys.setrecursionlimit(10**4)

comp_n = int(input())  # 컴퓨터의 수
pair_n = int(input())  # 컴퓨터 쌍의 수

graph = [[] for _ in range(comp_n + 1)]
visited = [0] * (comp_n + 1)  # 방문 정보 표현할 리스트
answer = 0

for i in range(pair_n):
    c1, c2 = map(int, input().split())
    graph[c1].append(c2)  # graph의 c1번째 리스트에 c2를 넣는 것으로 c1와 c2가 연결되어 있다는 것 표현
    graph[c2].append(c1)  # 같은 방식으로 c2의 입장에서도 c1과 연결되어 있다는 것 표현


def dfs(i):
    global answer
    visited[i] = 1
    for g in graph[i]:
        if visited[g] == 0:  # 방문하지 않은 노드인 경우
            dfs(g)  # dfs 함수 호출
            answer += 1


dfs(1)
print(answer)
